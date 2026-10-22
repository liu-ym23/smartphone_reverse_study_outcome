package org.tukaani.xz;

import a8.b;
import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lzma.LZMAEncoder;
import org.tukaani.xz.rangecoder.RangeEncoderToStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class LZMAOutputStream extends FinishableOutputStream {
    private final ArrayCache arrayCache;
    private long currentUncompressedSize;
    private IOException exception;
    private final long expectedUncompressedSize;
    private boolean finished;
    private LZEncoder lz;
    private LZMAEncoder lzma;
    private OutputStream out;
    private final int props;
    private final RangeEncoderToStream rc;
    private final byte[] tempBuf;
    private final boolean useEndMarker;

    private LZMAOutputStream(OutputStream outputStream, LZMA2Options lZMA2Options, boolean z, boolean z2, long j4, ArrayCache arrayCache) throws IOException {
        this.currentUncompressedSize = 0L;
        this.finished = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        outputStream.getClass();
        if (j4 < -1) {
            throw new IllegalArgumentException("Invalid expected input size (less than -1)");
        }
        this.useEndMarker = z2;
        this.expectedUncompressedSize = j4;
        this.arrayCache = arrayCache;
        this.out = outputStream;
        RangeEncoderToStream rangeEncoderToStream = new RangeEncoderToStream(outputStream);
        this.rc = rangeEncoderToStream;
        int dictSize = lZMA2Options.getDictSize();
        LZMAEncoder lZMAEncoder = LZMAEncoder.getInstance(rangeEncoderToStream, lZMA2Options.getLc(), lZMA2Options.getLp(), lZMA2Options.getPb(), lZMA2Options.getMode(), dictSize, 0, lZMA2Options.getNiceLen(), lZMA2Options.getMatchFinder(), lZMA2Options.getDepthLimit(), arrayCache);
        this.lzma = lZMAEncoder;
        this.lz = lZMAEncoder.getLZEncoder();
        byte[] presetDict = lZMA2Options.getPresetDict();
        if (presetDict != null && presetDict.length > 0) {
            if (z) {
                throw new UnsupportedOptionsException("Preset dictionary cannot be used in .lzma files (try a raw LZMA stream instead)");
            }
            this.lz.setPresetDict(dictSize, presetDict);
        }
        int lc = lZMA2Options.getLc() + ((lZMA2Options.getLp() + (lZMA2Options.getPb() * 5)) * 9);
        this.props = lc;
        if (z) {
            outputStream.write(lc);
            for (int i8 = 0; i8 < 4; i8++) {
                outputStream.write(dictSize & 255);
                dictSize >>>= 8;
            }
            for (int i9 = 0; i9 < 8; i9++) {
                outputStream.write(((int) (j4 >>> (i9 * 8))) & 255);
            }
        }
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

    @Override // org.tukaani.xz.FinishableOutputStream
    public void finish() throws IOException {
        if (this.finished) {
            return;
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        try {
            long j4 = this.expectedUncompressedSize;
            if (j4 != -1 && j4 != this.currentUncompressedSize) {
                throw new XZIOException("Expected uncompressed size (" + this.expectedUncompressedSize + ") doesn't equal the number of bytes written to the stream (" + this.currentUncompressedSize + ")");
            }
            this.lz.setFinishing();
            this.lzma.encodeForLZMA1();
            if (this.useEndMarker) {
                this.lzma.encodeLZMA1EndMarker();
            }
            this.rc.finish();
            this.finished = true;
            this.lzma.putArraysToCache(this.arrayCache);
            this.lzma = null;
            this.lz = null;
        } catch (IOException e9) {
            this.exception = e9;
            throw e9;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws XZIOException {
        throw new XZIOException("LZMAOutputStream does not support flushing");
    }

    public int getProps() {
        return this.props;
    }

    public long getUncompressedSize() {
        return this.currentUncompressedSize;
    }

    @Override // java.io.OutputStream
    public void write(int i8) throws IOException {
        byte[] bArr = this.tempBuf;
        bArr[0] = (byte) i8;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) throws IOException {
        int i10;
        if (i8 >= 0 && i9 >= 0 && (i10 = i8 + i9) >= 0 && i10 <= bArr.length) {
            IOException iOException = this.exception;
            if (iOException == null) {
                if (!this.finished) {
                    long j4 = this.expectedUncompressedSize;
                    if (j4 != -1 && j4 - this.currentUncompressedSize < i9) {
                        throw new XZIOException(b.r(new StringBuilder("Expected uncompressed input size ("), this.expectedUncompressedSize, " bytes) was exceeded"));
                    }
                    this.currentUncompressedSize += i9;
                    while (i9 > 0) {
                        try {
                            int iFillWindow = this.lz.fillWindow(bArr, i8, i9);
                            i8 += iFillWindow;
                            i9 -= iFillWindow;
                            this.lzma.encodeForLZMA1();
                        } catch (IOException e9) {
                            this.exception = e9;
                            throw e9;
                        }
                    }
                    return;
                }
                throw new XZIOException("Stream finished or closed");
            }
            throw iOException;
        }
        throw new IndexOutOfBoundsException();
    }

    public LZMAOutputStream(OutputStream outputStream, LZMA2Options lZMA2Options, long j4) {
        this(outputStream, lZMA2Options, j4, ArrayCache.getDefaultCache());
    }

    public LZMAOutputStream(OutputStream outputStream, LZMA2Options lZMA2Options, long j4, ArrayCache arrayCache) {
        this(outputStream, lZMA2Options, true, j4 == -1, j4, arrayCache);
    }

    public LZMAOutputStream(OutputStream outputStream, LZMA2Options lZMA2Options, boolean z) {
        this(outputStream, lZMA2Options, z, ArrayCache.getDefaultCache());
    }

    public LZMAOutputStream(OutputStream outputStream, LZMA2Options lZMA2Options, boolean z, ArrayCache arrayCache) {
        this(outputStream, lZMA2Options, false, z, -1L, arrayCache);
    }
}
