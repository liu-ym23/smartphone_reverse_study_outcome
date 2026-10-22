package org.tukaani.xz;

import a8.b;
import java.io.InputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class LZMA2Options extends FilterOptions {
    static final /* synthetic */ boolean $assertionsDisabled = false;
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
    private int depthLimit;
    private int dictSize;
    private int lc;
    private int lp;
    private int mf;
    private int mode;
    private int niceLen;
    private int pb;
    private byte[] presetDict = null;
    public static final int DICT_SIZE_DEFAULT = 8388608;
    private static final int[] presetToDictSize = {262144, 1048576, 2097152, 4194304, 4194304, DICT_SIZE_DEFAULT, DICT_SIZE_DEFAULT, 16777216, 33554432, 67108864};
    private static final int[] presetToDepthLimit = {4, 8, 24, 48};

    public LZMA2Options() {
        try {
            setPreset(6);
        } catch (UnsupportedOptionsException unused) {
            throw new RuntimeException();
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new RuntimeException();
        }
    }

    @Override // org.tukaani.xz.FilterOptions
    public int getDecoderMemoryUsage() {
        int i8 = this.dictSize - 1;
        int i9 = i8 | (i8 >>> 2);
        int i10 = i9 | (i9 >>> 3);
        int i11 = i10 | (i10 >>> 4);
        int i12 = i11 | (i11 >>> 8);
        return LZMA2InputStream.getMemoryUsage((i12 | (i12 >>> 16)) + 1);
    }

    public int getDepthLimit() {
        return this.depthLimit;
    }

    public int getDictSize() {
        return this.dictSize;
    }

    @Override // org.tukaani.xz.FilterOptions
    public int getEncoderMemoryUsage() {
        return this.mode == 0 ? UncompressedLZMA2OutputStream.getMemoryUsage() : LZMA2OutputStream.getMemoryUsage(this);
    }

    @Override // org.tukaani.xz.FilterOptions
    public FilterEncoder getFilterEncoder() {
        return new LZMA2Encoder(this);
    }

    @Override // org.tukaani.xz.FilterOptions
    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) {
        return new LZMA2InputStream(inputStream, this.dictSize, this.presetDict, arrayCache);
    }

    public int getLc() {
        return this.lc;
    }

    public int getLp() {
        return this.lp;
    }

    public int getMatchFinder() {
        return this.mf;
    }

    public int getMode() {
        return this.mode;
    }

    public int getNiceLen() {
        return this.niceLen;
    }

    @Override // org.tukaani.xz.FilterOptions
    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream, ArrayCache arrayCache) {
        return this.mode == 0 ? new UncompressedLZMA2OutputStream(finishableOutputStream, arrayCache) : new LZMA2OutputStream(finishableOutputStream, this, arrayCache);
    }

    public int getPb() {
        return this.pb;
    }

    public byte[] getPresetDict() {
        return this.presetDict;
    }

    public void setDepthLimit(int i8) throws UnsupportedOptionsException {
        if (i8 < 0) {
            throw new UnsupportedOptionsException(b.j(i8, "Depth limit cannot be negative: "));
        }
        this.depthLimit = i8;
    }

    public void setDictSize(int i8) throws UnsupportedOptionsException {
        if (i8 < 4096) {
            throw new UnsupportedOptionsException(b.k(i8, "LZMA2 dictionary size must be at least 4 KiB: ", " B"));
        }
        if (i8 > 805306368) {
            throw new UnsupportedOptionsException(b.k(i8, "LZMA2 dictionary size must not exceed 768 MiB: ", " B"));
        }
        this.dictSize = i8;
    }

    public void setLc(int i8) throws UnsupportedOptionsException {
        setLcLp(i8, this.lp);
    }

    public void setLcLp(int i8, int i9) throws UnsupportedOptionsException {
        if (i8 < 0 || i9 < 0 || i8 > 4 || i9 > 4 || i8 + i9 > 4) {
            throw new UnsupportedOptionsException(b.i(i8, i9, "lc + lp must not exceed 4: ", " + "));
        }
        this.lc = i8;
        this.lp = i9;
    }

    public void setLp(int i8) throws UnsupportedOptionsException {
        setLcLp(this.lc, i8);
    }

    public void setMatchFinder(int i8) throws UnsupportedOptionsException {
        if (i8 != 4 && i8 != 20) {
            throw new UnsupportedOptionsException(b.j(i8, "Unsupported match finder: "));
        }
        this.mf = i8;
    }

    public void setMode(int i8) throws UnsupportedOptionsException {
        if (i8 < 0 || i8 > 2) {
            throw new UnsupportedOptionsException(b.j(i8, "Unsupported compression mode: "));
        }
        this.mode = i8;
    }

    public void setNiceLen(int i8) throws UnsupportedOptionsException {
        if (i8 < 8) {
            throw new UnsupportedOptionsException(b.j(i8, "Minimum nice length of matches is 8 bytes: "));
        }
        if (i8 > 273) {
            throw new UnsupportedOptionsException(b.j(i8, "Maximum nice length of matches is 273: "));
        }
        this.niceLen = i8;
    }

    public void setPb(int i8) throws UnsupportedOptionsException {
        if (i8 < 0 || i8 > 4) {
            throw new UnsupportedOptionsException(b.j(i8, "pb must not exceed 4: "));
        }
        this.pb = i8;
    }

    public void setPreset(int i8) throws UnsupportedOptionsException {
        if (i8 < 0 || i8 > 9) {
            throw new UnsupportedOptionsException(b.j(i8, "Unsupported preset: "));
        }
        this.lc = 3;
        this.lp = 0;
        this.pb = 2;
        this.dictSize = presetToDictSize[i8];
        if (i8 <= 3) {
            this.mode = 1;
            this.mf = 4;
            this.niceLen = i8 <= 1 ? 128 : NICE_LEN_MAX;
            this.depthLimit = presetToDepthLimit[i8];
            return;
        }
        this.mode = 2;
        this.mf = 20;
        this.niceLen = i8 == 4 ? 16 : i8 == 5 ? 32 : 64;
        this.depthLimit = 0;
    }

    public void setPresetDict(byte[] bArr) {
        this.presetDict = bArr;
    }

    public LZMA2Options(int i8) throws UnsupportedOptionsException {
        setPreset(i8);
    }

    public LZMA2Options(int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) throws UnsupportedOptionsException {
        setDictSize(i8);
        setLcLp(i9, i10);
        setPb(i11);
        setMode(i12);
        setNiceLen(i13);
        setMatchFinder(i14);
        setDepthLimit(i15);
    }
}
