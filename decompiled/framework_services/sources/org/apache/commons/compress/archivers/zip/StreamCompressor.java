package org.apache.commons.compress.archivers.zip;

import java.io.Closeable;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.apache.commons.compress.parallel.ScatterGatherBackingStore;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StreamCompressor implements Closeable {
    private static final int BUFFER_SIZE = 4096;
    private static final int DEFLATER_BLOCK_SIZE = 8192;
    private final CRC32 crc;
    private final Deflater def;
    private final byte[] outputBuffer;
    private final byte[] readerBuf;
    private long sourcePayloadLength;
    private long totalWrittenToOutputStream;
    private long writtenToOutputStreamForLastEntry;

    private static final class DataOutputCompressor extends StreamCompressor {
        private final DataOutput raf;

        public DataOutputCompressor(Deflater deflater, DataOutput raf) {
            super(deflater);
            this.raf = raf;
        }

        @Override // org.apache.commons.compress.archivers.zip.StreamCompressor
        protected final void writeOut(byte[] data, int offset, int length) throws IOException {
            this.raf.write(data, offset, length);
        }
    }

    private static final class OutputStreamCompressor extends StreamCompressor {
        private final OutputStream os;

        public OutputStreamCompressor(Deflater deflater, OutputStream os) {
            super(deflater);
            this.os = os;
        }

        @Override // org.apache.commons.compress.archivers.zip.StreamCompressor
        protected final void writeOut(byte[] data, int offset, int length) throws IOException {
            this.os.write(data, offset, length);
        }
    }

    private static final class ScatterGatherBackingStoreCompressor extends StreamCompressor {
        private final ScatterGatherBackingStore bs;

        public ScatterGatherBackingStoreCompressor(Deflater deflater, ScatterGatherBackingStore bs) {
            super(deflater);
            this.bs = bs;
        }

        @Override // org.apache.commons.compress.archivers.zip.StreamCompressor
        protected final void writeOut(byte[] data, int offset, int length) throws IOException {
            this.bs.writeOut(data, offset, length);
        }
    }

    private static final class SeekableByteChannelCompressor extends StreamCompressor {
        private final SeekableByteChannel channel;

        public SeekableByteChannelCompressor(Deflater deflater, SeekableByteChannel channel) {
            super(deflater);
            this.channel = channel;
        }

        @Override // org.apache.commons.compress.archivers.zip.StreamCompressor
        protected final void writeOut(byte[] data, int offset, int length) throws IOException {
            this.channel.write(ByteBuffer.wrap(data, offset, length));
        }
    }

    protected abstract void writeOut(byte[] r1, int r2, int r3) throws IOException;

    StreamCompressor(Deflater deflater) {
        this.crc = new CRC32();
        this.writtenToOutputStreamForLastEntry = 0;
        this.sourcePayloadLength = 0;
        this.totalWrittenToOutputStream = 0;
        this.outputBuffer = new byte[4096];
        this.readerBuf = new byte[4096];
        this.def = deflater;
    }

    static StreamCompressor create(OutputStream os, Deflater deflater) {
        return new OutputStreamCompressor(deflater, os);
    }

    static StreamCompressor create(OutputStream os) {
        return create(os, new Deflater(-1, true));
    }

    static StreamCompressor create(DataOutput os, Deflater deflater) {
        return new DataOutputCompressor(deflater, os);
    }

    static StreamCompressor create(SeekableByteChannel os, Deflater deflater) {
        return new SeekableByteChannelCompressor(deflater, os);
    }

    public static StreamCompressor create(int compressionLevel, ScatterGatherBackingStore bs) {
        Deflater deflater = new Deflater(compressionLevel, true);
        return new ScatterGatherBackingStoreCompressor(deflater, bs);
    }

    public static StreamCompressor create(ScatterGatherBackingStore bs) {
        return create(-1, bs);
    }

    public long getCrc32() {
        return this.crc.getValue();
    }

    public long getBytesRead() {
        return this.sourcePayloadLength;
    }

    public long getBytesWrittenForLastEntry() {
        return this.writtenToOutputStreamForLastEntry;
    }

    public long getTotalBytesWritten() {
        return this.totalWrittenToOutputStream;
    }

    public void deflate(InputStream source, int method) throws IOException {
        reset();
    L3:
        int length = source.read(this.readerBuf, 0, this.readerBuf.length);
        if (length < 0) goto L7;
        write(this.readerBuf, 0, length, method);
        goto L3
    L7:
        if (method != 8) goto L11;
        flushDeflater();
        return;
    }

    long write(byte[] b, int offset, int length, int method) throws IOException {
        long current = this.writtenToOutputStreamForLastEntry;
        this.crc.update(b, offset, length);
        if (method != 8) goto L5;
        writeDeflated(b, offset, length);
    L6:
        this.sourcePayloadLength += (long) length;
        return this.writtenToOutputStreamForLastEntry - current;
    L5:
        writeCounted(b, offset, length);
        goto L6
    }

    void reset() {
        this.crc.reset();
        this.def.reset();
        this.sourcePayloadLength = 0;
        this.writtenToOutputStreamForLastEntry = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.def.end();
    }

    void flushDeflater() throws IOException {
        this.def.finish();
    L4:
        if (this.def.finished() == true) goto L6;
        deflate();
        goto L4
    }

    private void writeDeflated(byte[] b, int offset, int length) throws IOException {
        if (length > 0) goto L4;
        return;
    L4:
        if (this.def.finished() == false) goto L6;
        return;
    L6:
        if (length > 8192) goto L8;
        this.def.setInput(b, offset, length);
        deflateUntilInputIsNeeded();
        return;
    L8:
        int fullblocks = length / 8192;
        int i = 0;
    L9:
        if (i >= fullblocks) goto L11;
        this.def.setInput(b, (i * 8192) + offset, 8192);
        deflateUntilInputIsNeeded();
        i = i + 1;
        goto L9
    L11:
        int done = fullblocks * 8192;
        if (done >= length) goto L19;
        this.def.setInput(b, offset + done, length - done);
        deflateUntilInputIsNeeded();
        return;
    }

    private void deflateUntilInputIsNeeded() throws IOException {
    L3:
        if (this.def.needsInput() == true) goto L5;
        deflate();
        goto L3
    }

    void deflate() throws IOException {
        int len = this.def.deflate(this.outputBuffer, 0, this.outputBuffer.length);
        if (len <= 0) goto L6;
        writeCounted(this.outputBuffer, 0, len);
        return;
    }

    public void writeCounted(byte[] data) throws IOException {
        writeCounted(data, 0, data.length);
    }

    public void writeCounted(byte[] data, int offset, int length) throws IOException {
        writeOut(data, offset, length);
        this.writtenToOutputStreamForLastEntry += (long) length;
        this.totalWrittenToOutputStream += (long) length;
    }
}
