package org.apache.commons.compress.compressors.gzip;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes3.dex */
public class GzipCompressorOutputStream extends CompressorOutputStream {
    private static final int FCOMMENT = 16;
    private static final int FNAME = 8;
    private boolean closed;
    private final CRC32 crc;
    private final byte[] deflateBuffer;
    private final Deflater deflater;
    private final OutputStream out;

    public GzipCompressorOutputStream(OutputStream out) throws IOException {
        this(out, new GzipParameters());
    }

    public GzipCompressorOutputStream(OutputStream out, GzipParameters parameters) throws IOException {
        this.deflateBuffer = new byte[512];
        this.crc = new CRC32();
        this.out = out;
        this.deflater = new Deflater(parameters.getCompressionLevel(), true);
        writeHeader(parameters);
    }

    private void writeHeader(GzipParameters parameters) throws IOException {
        String filename = parameters.getFilename();
        String comment = parameters.getComment();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putShort(-29921);
        int r3 = 8;
        buffer.put((byte) 8);
        if (filename != null) goto L6;
        r3 = 0;
    L6:
        if (comment == null) goto L8;
        int r5 = 16;
    L9:
        buffer.put((byte) (r3 | r5));
        buffer.putInt((int) (parameters.getModificationTime() / 1000));
        int compressionLevel = parameters.getCompressionLevel();
        if (compressionLevel != 9) goto L13;
        buffer.put((byte) 2);
    L16:
        buffer.put((byte) parameters.getOperatingSystem());
        this.out.write(buffer.array());
        if (filename == null) goto L19;
        this.out.write(filename.getBytes(CharsetNames.ISO_8859_1));
        this.out.write(0);
    L19:
        if (comment == null) goto L22;
        this.out.write(comment.getBytes(CharsetNames.ISO_8859_1));
        this.out.write(0);
        return;
    L22:
        return;
    L13:
        if (compressionLevel != 1) goto L15;
        buffer.put((byte) 4);
        goto L16
    L15:
        buffer.put((byte) 0);
        goto L16
    L8:
        r5 = 0;
        goto L9
    }

    private void writeTrailer() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putInt((int) this.crc.getValue());
        buffer.putInt(this.deflater.getTotalIn());
        this.out.write(buffer.array());
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        write(new byte[]{(byte) (b & 255)}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] buffer) throws IOException {
        write(buffer, 0, buffer.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] buffer, int offset, int length) throws IOException {
        if (this.deflater.finished() == true) goto L12;
        if (length <= 0) goto L14;
        this.deflater.setInput(buffer, offset, length);
    L7:
        if (this.deflater.needsInput() == true) goto L9;
        deflate();
        goto L7
    L9:
        this.crc.update(buffer, offset, length);
        return;
    L14:
        return;
    L12:
        throw new IOException("Cannot write more data, the end of the compressed data stream has been reached");
    }

    private void deflate() throws IOException {
        int length = this.deflater.deflate(this.deflateBuffer, 0, this.deflateBuffer.length);
        if (length <= 0) goto L6;
        this.out.write(this.deflateBuffer, 0, length);
        return;
    }

    public void finish() throws IOException {
        if (this.deflater.finished() == true) goto L11;
        this.deflater.finish();
    L6:
        if (this.deflater.finished() == true) goto L8;
        deflate();
        goto L6
    L8:
        writeTrailer();
        return;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L11;
        return;
    L11:
        finish();     // Catch: Throwable -> L7
        this.deflater.end();
        this.out.close();
        this.closed = true;
        return;
    L7:
        th = move-exception;
        this.deflater.end();
        this.out.close();
        this.closed = true;
        throw th;
    }
}
