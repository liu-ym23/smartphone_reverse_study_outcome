package org.tukaani.xz;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.EncoderUtil;

/* JADX INFO: loaded from: classes3.dex */
class BlockOutputStream extends FinishableOutputStream {
    private final Check check;
    private final long compressedSizeLimit;
    private FinishableOutputStream filterChain;
    private final int headerSize;
    private final OutputStream out;
    private final CountingOutputStream outCounted;
    private final byte[] tempBuf;
    private long uncompressedSize;

    public BlockOutputStream(OutputStream out, FilterEncoder[] filters, Check check, ArrayCache arrayCache) throws IOException {
        this.uncompressedSize = 0;
        this.tempBuf = new byte[1];
        this.out = out;
        this.check = check;
        this.outCounted = new CountingOutputStream(out);
        this.filterChain = this.outCounted;
        int i = filters.length - 1;
    L3:
        if (i < 0) goto L5;
        this.filterChain = filters[i].getOutputStream(this.filterChain, arrayCache);
        i = i - 1;
        goto L3
    L5:
        ByteArrayOutputStream bufStream = new ByteArrayOutputStream();
        bufStream.write(0);
        bufStream.write(filters.length - 1);
        int i2 = 0;
    L7:
        if (i2 >= filters.length) goto L9;
        EncoderUtil.encodeVLI(bufStream, filters[i2].getFilterID());
        byte[] filterProps = filters[i2].getFilterProps();
        EncoderUtil.encodeVLI(bufStream, filterProps.length);
        bufStream.write(filterProps);
        i2 = i2 + 1;
    L9:
        int i3 = bufStream.size();
        if ((i3 & 3) == 0) goto L12;
        bufStream.write(0);
        goto L9
    L12:
        byte[] buf = bufStream.toByteArray();
        this.headerSize = buf.length + 4;
        if (this.headerSize > 1024) goto L17;
        buf[0] = (byte) (buf.length / 4);
        out.write(buf);
        EncoderUtil.writeCRC32(out, buf);
        this.compressedSizeLimit = (9223372036854775804L - ((long) this.headerSize)) - ((long) check.getSize());
        return;
    L17:
        throw new UnsupportedOptionsException();
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.tempBuf[0] = (byte) b;
        write(this.tempBuf, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] buf, int off, int len) throws IOException {
        this.filterChain.write(buf, off, len);
        this.check.update(buf, off, len);
        this.uncompressedSize += (long) len;
        validate();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.filterChain.flush();
        validate();
    }

    @Override // org.tukaani.xz.FinishableOutputStream
    public void finish() throws IOException {
        this.filterChain.finish();
        validate();
        long i = this.outCounted.getSize();
    L4:
        if ((3 & i) == 0) goto L6;
        this.out.write(0);
        i = i + 1;
        goto L4
    L6:
        this.out.write(this.check.finish());
    }

    private void validate() throws IOException {
        long compressedSize = this.outCounted.getSize();
        if (compressedSize < 0) goto L10;
        if (compressedSize > this.compressedSizeLimit) goto L10;
        if (this.uncompressedSize < 0) goto L10;
        return;
    L10:
        throw new XZIOException("XZ Stream has grown too big");
    }

    public long getUnpaddedSize() {
        return (((long) this.headerSize) + this.outCounted.getSize()) + ((long) this.check.getSize());
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }
}
