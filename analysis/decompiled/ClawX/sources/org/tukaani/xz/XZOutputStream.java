package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.EncoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.IndexEncoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
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

    public XZOutputStream(OutputStream outputStream, FilterOptions filterOptions) {
        this(outputStream, filterOptions, 4);
    }

    private void encodeStreamFlags(byte[] bArr, int i8) {
        bArr[i8] = 0;
        bArr[i8 + 1] = (byte) this.streamFlags.checkType;
    }

    private void encodeStreamFooter() throws IOException {
        byte[] bArr = new byte[6];
        long indexSize = (this.index.getIndexSize() / 4) - 1;
        for (int i8 = 0; i8 < 4; i8++) {
            bArr[i8] = (byte) (indexSize >>> (i8 * 8));
        }
        encodeStreamFlags(bArr, 4);
        EncoderUtil.writeCRC32(this.out, bArr);
        this.out.write(bArr);
        this.out.write(XZ.FOOTER_MAGIC);
    }

    private void encodeStreamHeader() throws IOException {
        this.out.write(XZ.HEADER_MAGIC);
        byte[] bArr = new byte[2];
        encodeStreamFlags(bArr, 0);
        this.out.write(bArr);
        EncoderUtil.writeCRC32(this.out, bArr);
    }

    private void setFiltersForNextBlock(FilterOptions[] filterOptionsArr) throws UnsupportedOptionsException {
        if (filterOptionsArr.length < 1 || filterOptionsArr.length > 4) {
            throw new UnsupportedOptionsException("XZ filter chain must be 1-4 filters");
        }
        this.filtersSupportFlushing = true;
        FilterEncoder[] filterEncoderArr = new FilterEncoder[filterOptionsArr.length];
        for (int i8 = 0; i8 < filterOptionsArr.length; i8++) {
            FilterEncoder filterEncoder = filterOptionsArr[i8].getFilterEncoder();
            filterEncoderArr[i8] = filterEncoder;
            this.filtersSupportFlushing = filterEncoder.supportsFlushing() & this.filtersSupportFlushing;
        }
        RawCoder.validate(filterEncoderArr);
        this.filters = filterEncoderArr;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.out != null) {
            try {
                finish();
            } catch (IOException unused) {
            }
            try {
                this.out.close();
            } catch (IOException e9) {
                if (this.exception == null) {
                    this.exception = e9;
                }
            }
            this.out = null;
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
    }

    public void endBlock() throws IOException {
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        }
        BlockOutputStream blockOutputStream = this.blockEncoder;
        if (blockOutputStream != null) {
            try {
                blockOutputStream.finish();
                this.index.add(this.blockEncoder.getUnpaddedSize(), this.blockEncoder.getUncompressedSize());
                this.blockEncoder = null;
            } catch (IOException e9) {
                this.exception = e9;
                throw e9;
            }
        }
    }

    @Override // org.tukaani.xz.FinishableOutputStream
    public void finish() throws IOException {
        if (this.finished) {
            return;
        }
        endBlock();
        try {
            this.index.encode(this.out);
            encodeStreamFooter();
            this.finished = true;
        } catch (IOException e9) {
            this.exception = e9;
            throw e9;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        }
        try {
            BlockOutputStream blockOutputStream = this.blockEncoder;
            if (blockOutputStream == null) {
                this.out.flush();
            } else if (this.filtersSupportFlushing) {
                blockOutputStream.flush();
            } else {
                endBlock();
                this.out.flush();
            }
        } catch (IOException e9) {
            this.exception = e9;
            throw e9;
        }
    }

    public void updateFilters(FilterOptions filterOptions) throws UnsupportedOptionsException {
        updateFilters(new FilterOptions[]{filterOptions});
    }

    @Override // java.io.OutputStream
    public void write(int i8) throws IOException {
        byte[] bArr = this.tempBuf;
        bArr[0] = (byte) i8;
        write(bArr, 0, 1);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions filterOptions, ArrayCache arrayCache) {
        this(outputStream, filterOptions, 4, arrayCache);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions filterOptions, int i8) {
        this(outputStream, new FilterOptions[]{filterOptions}, i8);
    }

    public void updateFilters(FilterOptions[] filterOptionsArr) throws UnsupportedOptionsException {
        if (this.blockEncoder == null) {
            setFiltersForNextBlock(filterOptionsArr);
            return;
        }
        throw new UnsupportedOptionsException("Changing filter options in the middle of a XZ Block not implemented");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) throws IOException {
        int i10;
        if (i8 >= 0 && i9 >= 0 && (i10 = i8 + i9) >= 0 && i10 <= bArr.length) {
            IOException iOException = this.exception;
            if (iOException == null) {
                if (!this.finished) {
                    try {
                        if (this.blockEncoder == null) {
                            this.blockEncoder = new BlockOutputStream(this.out, this.filters, this.check, this.arrayCache);
                        }
                        this.blockEncoder.write(bArr, i8, i9);
                        return;
                    } catch (IOException e9) {
                        this.exception = e9;
                        throw e9;
                    }
                }
                throw new XZIOException("Stream finished or closed");
            }
            throw iOException;
        }
        throw new IndexOutOfBoundsException();
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions filterOptions, int i8, ArrayCache arrayCache) {
        this(outputStream, new FilterOptions[]{filterOptions}, i8, arrayCache);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions[] filterOptionsArr) {
        this(outputStream, filterOptionsArr, 4);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions[] filterOptionsArr, ArrayCache arrayCache) {
        this(outputStream, filterOptionsArr, 4, arrayCache);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions[] filterOptionsArr, int i8) {
        this(outputStream, filterOptionsArr, i8, ArrayCache.getDefaultCache());
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions[] filterOptionsArr, int i8, ArrayCache arrayCache) throws IOException {
        StreamFlags streamFlags = new StreamFlags();
        this.streamFlags = streamFlags;
        this.index = new IndexEncoder();
        this.blockEncoder = null;
        this.exception = null;
        this.finished = false;
        this.tempBuf = new byte[1];
        this.arrayCache = arrayCache;
        this.out = outputStream;
        setFiltersForNextBlock(filterOptionsArr);
        streamFlags.checkType = i8;
        this.check = Check.getInstance(i8);
        encodeStreamHeader();
    }
}
