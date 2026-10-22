package androidx.camera.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class DynamicRange {
    public static final int BIT_DEPTH_10_BIT = 10;
    public static final int BIT_DEPTH_8_BIT = 8;
    public static final int BIT_DEPTH_UNSPECIFIED = 0;
    public static final DynamicRange DOLBY_VISION_10_BIT = null;
    public static final DynamicRange DOLBY_VISION_8_BIT = null;
    public static final int ENCODING_DOLBY_VISION = 6;
    public static final int ENCODING_HDR10 = 4;
    public static final int ENCODING_HDR10_PLUS = 5;
    public static final int ENCODING_HDR_UNSPECIFIED = 2;
    public static final int ENCODING_HLG = 3;
    public static final int ENCODING_SDR = 1;
    public static final int ENCODING_UNSPECIFIED = 0;
    public static final DynamicRange HDR10_10_BIT = null;
    public static final DynamicRange HDR10_PLUS_10_BIT = null;
    public static final DynamicRange HDR_UNSPECIFIED_10_BIT = null;
    public static final DynamicRange HLG_10_BIT = null;
    public static final DynamicRange SDR = null;
    public static final DynamicRange UNSPECIFIED = null;
    private final int mBitDepth;
    private final int mEncoding;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BitDepth {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DynamicRangeEncoding {
    }

    private static String getEncodingLabel(int r100) {
        switch(r100) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return "<Unknown>";
    L5:
        return "DOLBY_VISION";
    L7:
        return "HDR10_PLUS";
    L9:
        return "HDR10";
    L11:
        return "HLG";
    L13:
        return "HDR_UNSPECIFIED";
    L15:
        return "SDR";
    L17:
        return "UNSPECIFIED";
    }

    static {
        UNSPECIFIED = new DynamicRange(0, 0);
        SDR = new DynamicRange(1, 8);
        HDR_UNSPECIFIED_10_BIT = new DynamicRange(2, 10);
        HLG_10_BIT = new DynamicRange(3, 10);
        HDR10_10_BIT = new DynamicRange(4, 10);
        HDR10_PLUS_10_BIT = new DynamicRange(5, 10);
        DOLBY_VISION_10_BIT = new DynamicRange(6, 10);
        DOLBY_VISION_8_BIT = new DynamicRange(6, 8);
    }

    public int hashCode() {
        return ((this.mEncoding ^ 1000003) * 1000003) ^ this.mBitDepth;
    }

    public String toString() {
        return "DynamicRange@" + Integer.toHexString(System.identityHashCode(this)) + "{encoding=" + getEncodingLabel(this.mEncoding) + ", bitDepth=" + this.mBitDepth + com.alipay.sdk.m.u.i.f25855d;
    }

    public boolean is10BitHdr() {
        if (isFullySpecified() == true) goto L5;
    L9:
        return false;
    L5:
        if (getEncoding() == 1) goto L9;
        if (getBitDepth() != 10) goto L9;
        return true;
    }

    public boolean isFullySpecified() {
        if (getEncoding() != 0) goto L5;
    L9:
        return false;
    L5:
        if (getEncoding() == 2) goto L9;
        if (getBitDepth() == 0) goto L9;
        return true;
    }

    public int getBitDepth() {
        return this.mBitDepth;
    }

    public int getEncoding() {
        return this.mEncoding;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof DynamicRange) == false) goto L14;
        DynamicRange r101 = (DynamicRange) r100;
        if (this.mEncoding == r101.getEncoding()) goto L10;
    L12:
        return false;
    L10:
        if (this.mBitDepth != r101.getBitDepth()) goto L12;
        return true;
    L14:
        return false;
    }

    public DynamicRange(int r100, int r101) {
        this.mEncoding = r100;
        this.mBitDepth = r101;
    }
}
