package org.tukaani.xz;

import com.android.server.usb.descriptors.UsbDescriptor;
import java.io.IOException;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lzma.LZMAEncoder;
import org.tukaani.xz.rangecoder.RangeEncoderToBuffer;

/* JADX INFO: loaded from: classes3.dex */
class LZMA2OutputStream extends FinishableOutputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int COMPRESSED_SIZE_MAX = 65536;
    private final ArrayCache arrayCache;
    private final byte[] chunkHeader;
    private boolean dictResetNeeded;
    private IOException exception;
    private boolean finished;
    private LZEncoder lz;
    private LZMAEncoder lzma;
    private FinishableOutputStream out;
    private int pendingSize;
    private final int props;
    private boolean propsNeeded;
    private RangeEncoderToBuffer rc;
    private boolean stateResetNeeded;
    private final byte[] tempBuf;

    static {
    }

    private static int getExtraSizeBefore(int dictSize) {
        if (65536 > dictSize) goto L7;
        return 0;
    L7:
        return 65536 - dictSize;
    }

    static int getMemoryUsage(LZMA2Options options) {
        int dictSize = options.getDictSize();
        int extraSizeBefore = getExtraSizeBefore(dictSize);
        return LZMAEncoder.getMemoryUsage(options.getMode(), dictSize, extraSizeBefore, options.getMatchFinder()) + 70;
    }

    LZMA2OutputStream(FinishableOutputStream out, LZMA2Options options, ArrayCache arrayCache) {
        this.dictResetNeeded = true;
        this.stateResetNeeded = true;
        this.propsNeeded = true;
        this.pendingSize = 0;
        this.finished = false;
        this.exception = null;
        this.chunkHeader = new byte[6];
        this.tempBuf = new byte[1];
        if (out == null) goto L12;
        this.arrayCache = arrayCache;
        this.out = out;
        this.rc = new RangeEncoderToBuffer(65536, arrayCache);
        int dictSize = options.getDictSize();
        int extraSizeBefore = getExtraSizeBefore(dictSize);
        this.lzma = LZMAEncoder.getInstance(this.rc, options.getLc(), options.getLp(), options.getPb(), options.getMode(), dictSize, extraSizeBefore, options.getNiceLen(), options.getMatchFinder(), options.getDepthLimit(), this.arrayCache);
        this.lz = this.lzma.getLZEncoder();
        byte[] presetDict = options.getPresetDict();
        if (presetDict != null) goto L7;
    L9:
        this.props = (((options.getPb() * 5) + options.getLp()) * 9) + options.getLc();
        return;
    L7:
        if (presetDict.length <= 0) goto L9;
        this.lz.setPresetDict(dictSize, presetDict);
        this.dictResetNeeded = false;
        goto L9
    L12:
        throw new NullPointerException();
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.tempBuf[0] = (byte) b;
        write(this.tempBuf, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] buf, int off, int len) throws IOException {
        if (off < 0) goto L29;
        if (len < 0) goto L29;
        if ((off + len) < 0) goto L29;
        if ((off + len) > buf.length) goto L29;
        if (this.exception != null) goto L27;
        if (this.finished == true) goto L25;
    L12:
        if (len <= 0) goto L23;
        int used = this.lz.fillWindow(buf, off, len);     // Catch: IOException -> L17
        off = off + used;     // Catch: IOException -> L17
        len = len - used;     // Catch: IOException -> L17
        this.pendingSize += used;     // Catch: IOException -> L17
        if (this.lzma.encodeForLZMA2() == false) goto L12;
        writeChunk();     // Catch: IOException -> L17
    L17:
        e = move-exception;
        this.exception = e;
        throw e;
    L23:
        return;
    L25:
        throw new XZIOException("Stream finished or closed");
    L27:
        throw this.exception;
    L29:
        throw new IndexOutOfBoundsException();
    }

    private void writeChunk() throws IOException {
        int compressedSize = this.rc.finish();
        int uncompressedSize = this.lzma.getUncompressedSize();
        if ((compressedSize + 2) >= uncompressedSize) goto L5;
        writeLZMA(uncompressedSize, compressedSize);
    L6:
        this.pendingSize -= uncompressedSize;
        this.lzma.resetUncompressedSize();
        this.rc.reset();
        return;
    L5:
        this.lzma.reset();
        uncompressedSize = this.lzma.getUncompressedSize();
        writeUncompressed(uncompressedSize);
        goto L6
    }

    private void writeLZMA(int uncompressedSize, int compressedSize) throws IOException {
        if (this.propsNeeded == false) goto L9;
        if (this.dictResetNeeded == false) goto L7;
        int control = UsbDescriptor.CLASSID_WIRELESS;
    L12:
        this.chunkHeader[0] = (byte) (control | ((uncompressedSize - 1) >>> 16));
        this.chunkHeader[1] = (byte) ((uncompressedSize - 1) >>> 8);
        this.chunkHeader[2] = (byte) (uncompressedSize - 1);
        this.chunkHeader[3] = (byte) ((compressedSize - 1) >>> 8);
        this.chunkHeader[4] = (byte) (compressedSize - 1);
        if (this.propsNeeded == false) goto L15;
        this.chunkHeader[5] = (byte) this.props;
        this.out.write(this.chunkHeader, 0, 6);
    L16:
        this.rc.write(this.out);
        this.propsNeeded = false;
        this.stateResetNeeded = false;
        this.dictResetNeeded = false;
        return;
    L15:
        this.out.write(this.chunkHeader, 0, 5);
        goto L16
    L7:
        control = 192;
        goto L12
    L9:
        if (this.stateResetNeeded == false) goto L11;
        control = 160;
        goto L12
    L11:
        control = 128;
        goto L12
    }

    private void writeUncompressed(int uncompressedSize) throws IOException {
    L3:
        if (uncompressedSize <= 0) goto L9;
        int chunkSize = Math.min(uncompressedSize, 65536);
        byte[] r2 = this.chunkHeader;
        if (this.dictResetNeeded == false) goto L7;
        int r3 = 1;
    L8:
        r2[0] = (byte) r3;
        this.chunkHeader[1] = (byte) ((chunkSize - 1) >>> 8);
        this.chunkHeader[2] = (byte) (chunkSize - 1);
        this.out.write(this.chunkHeader, 0, 3);
        this.lz.copyUncompressed(this.out, uncompressedSize, chunkSize);
        uncompressedSize = uncompressedSize - chunkSize;
        this.dictResetNeeded = false;
        goto L3
    L7:
        r3 = 2;
        goto L8
    L9:
        this.stateResetNeeded = true;
    }

    private void writeEndMarker() throws IOException {
        if (this.exception != null) goto L16;
        this.lz.setFinishing();
    L17:
    L8:
        e = move-exception;
        this.exception = e;
        throw e;
    L6:
        if (this.pendingSize <= 0) goto L10;
        this.lzma.encodeForLZMA2();     // Catch: IOException -> L8
        writeChunk();     // Catch: IOException -> L8
        goto L17
    L10:
        this.out.write(0);     // Catch: IOException -> L8
        this.finished = true;
        this.lzma.putArraysToCache(this.arrayCache);
        this.lzma = null;
        this.lz = null;
        this.rc.putArraysToCache(this.arrayCache);
        this.rc = null;
        return;
    L16:
        throw this.exception;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.exception != null) goto L19;
        if (this.finished == true) goto L17;
        this.lz.setFlushing();     // Catch: IOException -> L10
    L8:
        if (this.pendingSize <= 0) goto L12;
        this.lzma.encodeForLZMA2();     // Catch: IOException -> L10
        writeChunk();     // Catch: IOException -> L10
        goto L8
    L12:
        this.out.flush();     // Catch: IOException -> L10
        return;
    L10:
        e = move-exception;
        this.exception = e;
        throw e;
    L17:
        throw new XZIOException("Stream finished or closed");
    L19:
        throw this.exception;
    }

    @Override // org.tukaani.xz.FinishableOutputStream
    public void finish() throws IOException {
        if (this.finished == true) goto L10;
        writeEndMarker();
        this.out.finish();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        this.exception = e;
        throw e;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.out == null) goto L18;
        if (this.finished == false) goto L24;
    L22:
        this.out.close();     // Catch: IOException -> L12
    L16:
        this.out = null;
    L12:
        e = move-exception;
        if (this.exception != null) goto L16;
        this.exception = e;
        goto L16
    L24:
        writeEndMarker();     // Catch: IOException -> L8
    L18:
        if (this.exception != null) goto L21;
        return;
    L21:
        throw this.exception;
    }
}
