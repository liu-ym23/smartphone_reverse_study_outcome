package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class LZMA2Options extends FilterOptions {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DICT_SIZE_DEFAULT = 8388608;
    public static final int DICT_SIZE_MAX = 805306368;
    public static final int DICT_SIZE_MIN = 4096;
    public static final int LC_DEFAULT = 3;
    public static final int LC_LP_MAX = 4;
    public static final int LP_DEFAULT = 0;
    public static final int MF_BT4 = 20;
    public static final int MF_HC4 = 4;
    public static final int MODE_FAST = 1;
    public static final int MODE_NORMAL = 2;
    public static final int MODE_UNCOMPRESSED = 0;
    public static final int NICE_LEN_MAX = 273;
    public static final int NICE_LEN_MIN = 8;
    public static final int PB_DEFAULT = 2;
    public static final int PB_MAX = 4;
    public static final int PRESET_DEFAULT = 6;
    public static final int PRESET_MAX = 9;
    public static final int PRESET_MIN = 0;
    private static final int[] presetToDepthLimit = null;
    private static final int[] presetToDictSize = null;
    private int depthLimit;
    private int dictSize;
    private int lc;
    private int lp;
    private int mf;
    private int mode;
    private int niceLen;
    private int pb;
    private byte[] presetDict;

    static {
        presetToDictSize = new int[]{262144, 1048576, 2097152, 4194304, 4194304, 8388608, 8388608, 16777216, 33554432, 67108864};
        presetToDepthLimit = new int[]{4, 8, 24, 48};
    }

    public LZMA2Options() {
        this.presetDict = null;
        setPreset(6);     // Catch: UnsupportedOptionsException -> L5
        return;
    L7:
        throw new RuntimeException();
    }

    public LZMA2Options(int preset) throws UnsupportedOptionsException {
        this.presetDict = null;
        setPreset(preset);
    }

    public LZMA2Options(int dictSize, int lc, int lp, int pb, int mode, int niceLen, int mf, int depthLimit) throws UnsupportedOptionsException {
        this.presetDict = null;
        setDictSize(dictSize);
        setLcLp(lc, lp);
        setPb(pb);
        setMode(mode);
        setNiceLen(niceLen);
        setMatchFinder(mf);
        setDepthLimit(depthLimit);
    }

    public void setPreset(int preset) throws UnsupportedOptionsException {
        if (preset < 0) goto L22;
        if (preset > 9) goto L22;
        this.lc = 3;
        this.lp = 0;
        this.pb = 2;
        this.dictSize = presetToDictSize[preset];
        if (preset > 3) goto L12;
        this.mode = 1;
        this.mf = 4;
        if (preset > 1) goto L10;
        int r0 = 128;
    L11:
        this.niceLen = r0;
        this.depthLimit = presetToDepthLimit[preset];
        return;
    L10:
        r0 = NICE_LEN_MAX;
        goto L11
    L12:
        this.mode = 2;
        this.mf = 20;
        if (preset != 4) goto L16;
        int r1 = 16;
    L19:
        this.niceLen = r1;
        this.depthLimit = 0;
        return;
    L16:
        if (preset != 5) goto L18;
        r1 = 32;
        goto L19
    L18:
        r1 = 64;
    L22:
        throw new UnsupportedOptionsException("Unsupported preset: " + preset);
    }

    public void setDictSize(int dictSize) throws UnsupportedOptionsException {
        if (dictSize < 4096) goto L11;
        if (dictSize > 805306368) goto L9;
        this.dictSize = dictSize;
        return;
    L9:
        throw new UnsupportedOptionsException("LZMA2 dictionary size must not exceed 768 MiB: " + dictSize + " B");
    L11:
        throw new UnsupportedOptionsException("LZMA2 dictionary size must be at least 4 KiB: " + dictSize + " B");
    }

    public int getDictSize() {
        return this.dictSize;
    }

    public void setPresetDict(byte[] presetDict) {
        this.presetDict = presetDict;
    }

    public byte[] getPresetDict() {
        return this.presetDict;
    }

    public void setLcLp(int lc, int lp) throws UnsupportedOptionsException {
        if (lc < 0) goto L12;
        if (lp < 0) goto L12;
        if (lc > 4) goto L12;
        if (lp > 4) goto L12;
        if ((lc + lp) > 4) goto L12;
        this.lc = lc;
        this.lp = lp;
        return;
    L12:
        throw new UnsupportedOptionsException("lc + lp must not exceed 4: " + lc + " + " + lp);
    }

    public void setLc(int lc) throws UnsupportedOptionsException {
        setLcLp(lc, this.lp);
    }

    public void setLp(int lp) throws UnsupportedOptionsException {
        setLcLp(this.lc, lp);
    }

    public int getLc() {
        return this.lc;
    }

    public int getLp() {
        return this.lp;
    }

    public void setPb(int pb) throws UnsupportedOptionsException {
        if (pb < 0) goto L8;
        if (pb > 4) goto L8;
        this.pb = pb;
        return;
    L8:
        throw new UnsupportedOptionsException("pb must not exceed 4: " + pb);
    }

    public int getPb() {
        return this.pb;
    }

    public void setMode(int mode) throws UnsupportedOptionsException {
        if (mode < 0) goto L8;
        if (mode > 2) goto L8;
        this.mode = mode;
        return;
    L8:
        throw new UnsupportedOptionsException("Unsupported compression mode: " + mode);
    }

    public int getMode() {
        return this.mode;
    }

    public void setNiceLen(int niceLen) throws UnsupportedOptionsException {
        if (niceLen < 8) goto L11;
        if (niceLen > 273) goto L9;
        this.niceLen = niceLen;
        return;
    L9:
        throw new UnsupportedOptionsException("Maximum nice length of matches is 273: " + niceLen);
    L11:
        throw new UnsupportedOptionsException("Minimum nice length of matches is 8 bytes: " + niceLen);
    }

    public int getNiceLen() {
        return this.niceLen;
    }

    public void setMatchFinder(int mf) throws UnsupportedOptionsException {
        if (mf != 4) goto L5;
    L9:
        this.mf = mf;
        return;
    L5:
        if (mf == 20) goto L9;
        throw new UnsupportedOptionsException("Unsupported match finder: " + mf);
    }

    public int getMatchFinder() {
        return this.mf;
    }

    public void setDepthLimit(int depthLimit) throws UnsupportedOptionsException {
        if (depthLimit < 0) goto L6;
        this.depthLimit = depthLimit;
        return;
    L6:
        throw new UnsupportedOptionsException("Depth limit cannot be negative: " + depthLimit);
    }

    public int getDepthLimit() {
        return this.depthLimit;
    }

    @Override // org.tukaani.xz.FilterOptions
    public int getEncoderMemoryUsage() {
        if (this.mode != 0) goto L6;
        return UncompressedLZMA2OutputStream.getMemoryUsage();
    L6:
        return LZMA2OutputStream.getMemoryUsage(this);
    }

    @Override // org.tukaani.xz.FilterOptions
    public FinishableOutputStream getOutputStream(FinishableOutputStream out, ArrayCache arrayCache) {
        if (this.mode != 0) goto L7;
        return new UncompressedLZMA2OutputStream(out, arrayCache);
    L7:
        return new LZMA2OutputStream(out, this, arrayCache);
    }

    @Override // org.tukaani.xz.FilterOptions
    public int getDecoderMemoryUsage() {
        int d = this.dictSize - 1;
        int d2 = d | (d >>> 2);
        int d3 = d2 | (d2 >>> 3);
        int d4 = d3 | (d3 >>> 4);
        int d5 = d4 | (d4 >>> 8);
        return LZMA2InputStream.getMemoryUsage((d5 | (d5 >>> 16)) + 1);
    }

    @Override // org.tukaani.xz.FilterOptions
    public InputStream getInputStream(InputStream in, ArrayCache arrayCache) throws IOException {
        return new LZMA2InputStream(in, this.dictSize, this.presetDict, arrayCache);
    }

    @Override // org.tukaani.xz.FilterOptions
    FilterEncoder getFilterEncoder() {
        return new LZMA2Encoder(this);
    }

    public Object clone() {
        return super.clone();
    L6:
        throw new RuntimeException();
    }
}
