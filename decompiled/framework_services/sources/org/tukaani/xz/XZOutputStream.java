package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.EncoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.IndexEncoder;

/* JADX INFO: loaded from: classes3.dex */
public class XZOutputStream extends FinishableOutputStream {
    private final ArrayCache arrayCache;
    private BlockOutputStream blockEncoder;
    private final Check check;
    private IOException exception;
    private FilterEncoder[] filters;
    private boolean filtersSupportFlushing;
    private boolean finished;
    private final IndexEncoder index;
    private OutputStream out;
    private final StreamFlags streamFlags;
    private final byte[] tempBuf;

    public XZOutputStream(OutputStream out, FilterOptions filterOptions) throws IOException {
        this(out, filterOptions, 4);
    }

    public XZOutputStream(OutputStream out, FilterOptions filterOptions, ArrayCache arrayCache) throws IOException {
        this(out, filterOptions, 4, arrayCache);
    }

    public XZOutputStream(OutputStream out, FilterOptions filterOptions, int checkType) throws IOException {
        this(out, new FilterOptions[]{filterOptions}, checkType);
    }

    public XZOutputStream(OutputStream out, FilterOptions filterOptions, int checkType, ArrayCache arrayCache) throws IOException {
        this(out, new FilterOptions[]{filterOptions}, checkType, arrayCache);
    }

    public XZOutputStream(OutputStream out, FilterOptions[] filterOptions) throws IOException {
        this(out, filterOptions, 4);
    }

    public XZOutputStream(OutputStream out, FilterOptions[] filterOptions, ArrayCache arrayCache) throws IOException {
        this(out, filterOptions, 4, arrayCache);
    }

    public XZOutputStream(OutputStream out, FilterOptions[] filterOptions, int checkType) throws IOException {
        this(out, filterOptions, checkType, ArrayCache.getDefaultCache());
    }

    public XZOutputStream(OutputStream out, FilterOptions[] filterOptions, int checkType, ArrayCache arrayCache) throws IOException {
        this.streamFlags = new StreamFlags();
        this.index = new IndexEncoder();
        this.blockEncoder = null;
        this.exception = null;
        this.finished = false;
        this.tempBuf = new byte[1];
        this.arrayCache = arrayCache;
        this.out = out;
        updateFilters(filterOptions);
        this.streamFlags.checkType = checkType;
        this.check = Check.getInstance(checkType);
        encodeStreamHeader();
    }

    public void updateFilters(FilterOptions filterOptions) throws XZIOException {
        FilterOptions[] opts = {filterOptions};
        updateFilters(opts);
    }

    public void updateFilters(FilterOptions[] filterOptions) throws XZIOException {
        if (this.blockEncoder != null) goto L17;
        if (filterOptions.length < 1) goto L15;
        if (filterOptions.length > 4) goto L15;
        this.filtersSupportFlushing = true;
        FilterEncoder[] newFilters = new FilterEncoder[filterOptions.length];
        int i = 0;
    L10:
        if (i >= filterOptions.length) goto L12;
        newFilters[i] = filterOptions[i].getFilterEncoder();
        this.filtersSupportFlushing &= newFilters[i].supportsFlushing();
        i = i + 1;
        goto L10
    L12:
        RawCoder.validate(newFilters);
        this.filters = newFilters;
        return;
    L15:
        throw new UnsupportedOptionsException("XZ filter chain must be 1-4 filters");
    L17:
        throw new UnsupportedOptionsException("Changing filter options in the middle of a XZ Block not implemented");
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.tempBuf[0] = (byte) b;
        write(this.tempBuf, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] buf, int off, int len) throws IOException {
        if (off < 0) goto L26;
        if (len < 0) goto L26;
        if ((off + len) < 0) goto L26;
        if ((off + len) > buf.length) goto L26;
        if (this.exception != null) goto L24;
        if (this.finished == true) goto L22;
    L15:
        e = move-exception;
        this.exception = e;
        throw e;
    L13:
        if (this.blockEncoder != null) goto L17;
        this.blockEncoder = new BlockOutputStream(this.out, this.filters, this.check, this.arrayCache);     // Catch: IOException -> L15
    L17:
        this.blockEncoder.write(buf, off, len);     // Catch: IOException -> L15
        return;
    L22:
        throw new XZIOException("Stream finished or closed");
    L24:
        throw this.exception;
    L26:
        throw new IndexOutOfBoundsException();
    }

    public void endBlock() throws IOException {
        if (this.exception != null) goto L17;
        if (this.finished == true) goto L15;
        if (this.blockEncoder != null) goto L18;
        return;
    L18:
        this.blockEncoder.finish();     // Catch: IOException -> L10
        this.index.add(this.blockEncoder.getUnpaddedSize(), this.blockEncoder.getUncompressedSize());     // Catch: IOException -> L10
        this.blockEncoder = null;     // Catch: IOException -> L10
        return;
    L10:
        e = move-exception;
        this.exception = e;
        throw e;
    L15:
        throw new XZIOException("Stream finished or closed");
    L17:
        throw this.exception;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.exception != null) goto L22;
        if (this.finished == true) goto L20;
    L11:
        e = move-exception;
        this.exception = e;
        throw e;
    L7:
        if (this.blockEncoder != null) goto L9;
        this.out.flush();     // Catch: IOException -> L11
        return;
    L9:
        if (this.filtersSupportFlushing == false) goto L13;
        this.blockEncoder.flush();     // Catch: IOException -> L11
        return;
    L13:
        endBlock();     // Catch: IOException -> L11
        this.out.flush();     // Catch: IOException -> L11
        return;
    L20:
        throw new XZIOException("Stream finished or closed");
    L22:
        throw this.exception;
    }

    @Override // org.tukaani.xz.FinishableOutputStream
    public void finish() throws IOException {
        if (this.finished == true) goto L10;
        endBlock();
        this.index.encode(this.out);     // Catch: IOException -> L7
        encodeStreamFooter();     // Catch: IOException -> L7
        this.finished = true;
        return;
    L7:
        e = move-exception;
        this.exception = e;
        throw e;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.out == null) goto L16;
        finish();     // Catch: IOException -> L6
    L22:
        this.out.close();     // Catch: IOException -> L10
    L14:
        this.out = null;
    L10:
        e = move-exception;
        if (this.exception != null) goto L14;
        this.exception = e;
    L16:
        if (this.exception != null) goto L19;
        return;
    L19:
        throw this.exception;
    }

    private void encodeStreamFlags(byte[] buf, int off) {
        buf[off] = 0;
        buf[off + 1] = (byte) this.streamFlags.checkType;
    }

    private void encodeStreamHeader() throws IOException {
        this.out.write(XZ.HEADER_MAGIC);
        byte[] buf = new byte[2];
        encodeStreamFlags(buf, 0);
        this.out.write(buf);
        EncoderUtil.writeCRC32(this.out, buf);
    }

    private void encodeStreamFooter() throws IOException {
        byte[] buf = new byte[6];
        long backwardSize = (this.index.getIndexSize() / 4) - 1;
        int i = 0;
    L4:
        if (i >= 4) goto L6;
        buf[i] = (byte) (backwardSize >>> (i * 8));
        i = i + 1;
        goto L4
    L6:
        encodeStreamFlags(buf, 4);
        EncoderUtil.writeCRC32(this.out, buf);
        this.out.write(buf);
        this.out.write(XZ.FOOTER_MAGIC);
    }
}
