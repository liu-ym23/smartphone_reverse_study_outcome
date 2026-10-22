package androidx.compose.ui.graphics;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import kotlin.Metadata;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0011\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0016H\u0082\b\u001a\u0011\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0013H\u0080\b\u001a\u0011\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0016H\u0080\b\u001a\u001f\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001f\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\"\u0010 \"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Fp16SignShift", "", "Fp16SignMask", "Fp16ExponentShift", "Fp16ExponentMask", "Fp16SignificandMask", "Fp16ExponentBias", "Fp16Combined", "Fp16ExponentMax", "Fp16One", "Fp16TheNaN", "Fp32SignShift", "Fp32ExponentShift", "Fp32ExponentMask", "Fp32SignificandMask", "Fp32ExponentBias", "Fp32QNaNMask", "Fp32DenormalMagic", "Fp32DenormalFloat", "", "toCompareValue", "value", "", "floatToHalf", "f", "halfToFloat", "h", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "Landroidx/compose/ui/graphics/Float16;", "x", "y", "min-AoSsdG0", "(SS)S", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "max-AoSsdG0", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Float16Kt {
    private static final int Fp16Combined = 32767;
    private static final int Fp16ExponentBias = 15;
    private static final int Fp16ExponentMask = 31;
    private static final int Fp16ExponentMax = 31744;
    private static final int Fp16ExponentShift = 10;
    private static final int Fp16One = 15360;
    private static final int Fp16SignMask = 32768;
    private static final int Fp16SignShift = 15;
    private static final int Fp16SignificandMask = 1023;
    private static final int Fp16TheNaN = 32256;
    private static final float Fp32DenormalFloat = 0.0f;
    private static final int Fp32DenormalMagic = 1056964608;
    private static final int Fp32ExponentBias = 127;
    private static final int Fp32ExponentMask = 255;
    private static final int Fp32ExponentShift = 23;
    private static final int Fp32QNaNMask = 4194304;
    private static final int Fp32SignShift = 31;
    private static final int Fp32SignificandMask = 8388607;

    private static final int toCompareValue(short r100) {
        if ((r100 & ShortCompanionObject.MIN_VALUE) == 0) goto L6;
        return 32768 - (r100 & 65535);
    L6:
        return r100 & 65535;
    }

    static {
        Fp32DenormalFloat = Float.intBitsToFloat(Fp32DenormalMagic);
    }

    public static final /* synthetic */ float access$getFp32DenormalFloat$p() {
        return Fp32DenormalFloat;
    }

    public static final short floatToHalf(float r100) {
        int r101 = Float.floatToRawIntBits(r100);
        int r102 = r101 >>> 31;
        int r103 = (r101 >>> 23) & 255;
        int r104 = r101 & Fp32SignificandMask;
        int r105 = 31;
        int r106 = 0;
        if (r103 != 255) goto L6;
        if (r104 == 0) goto L23;
        r106 = 512;
    L23:
        int r107 = ((r102 << 15) | (r105 << 10)) | r106;
    L21:
        return (short) r107;
    L6:
        int r108 = (r103 - 127) + 15;
        if (r108 < 31) goto L9;
        r105 = 49;
        goto L23
    L9:
        if (r108 <= 0) goto L11;
        r106 = r104 >> 13;
        if ((r104 & 4096) == 0) goto L22;
        r107 = (((r108 << 10) | r106) + 1) | (r102 << 15);
        goto L21
    L22:
        r105 = r108;
        goto L23
    L11:
        if (r108 < (-10)) goto L16;
        int r109 = (r104 | 8388608) >> (1 - r108);
        if ((r109 & 4096) == 0) goto L15;
        r109 = r109 + 8192;
    L15:
        r106 = r109 >> 13;
    L16:
        r105 = 0;
        goto L23
    }

    public static final float halfToFloat(short r100) {
        int r101 = r100 & 65535;
        int r102 = 32768 & r101;
        int r103 = (r101 >>> 10) & 31;
        int r104 = r101 & 1023;
        if (r103 != 0) goto L11;
        if (r104 == 0) goto L10;
        float r105 = Float.intBitsToFloat(r104 + Fp32DenormalMagic) - access$getFp32DenormalFloat$p();
        if (r102 != 0) goto L9;
        return r105;
    L9:
        return -r105;
    L10:
        int r106 = 0;
        int r107 = 0;
    L19:
        return Float.intBitsToFloat(((r106 << 23) | (r102 << 16)) | r107);
    L11:
        int r108 = r104 << 13;
        if (r103 == 31) goto L14;
        int r109 = (r103 - 15) + 127;
        r107 = r108;
        r106 = r109;
        goto L19
    L14:
        if (r108 == 0) goto L16;
        r108 = r108 | 4194304;
    L16:
        r107 = r108;
        r106 = 255;
        goto L19
    }

    /* JADX INFO: renamed from: max-AoSsdG0, reason: not valid java name */
    public static final short m4973maxAoSsdG0(short r100, short r101) {
        if (Float16.m4946isNaNimpl(r100) == true) goto L13;
        if (Float16.m4946isNaNimpl(r101) == true) goto L13;
        if (Float16.m4933compareTo41bOqos(r100, r101) < 0) goto L11;
        return r100;
    L11:
        return r101;
    L13:
        return Float16.Companion.m4968getNaNslo4al4();
    }

    /* JADX INFO: renamed from: min-AoSsdG0, reason: not valid java name */
    public static final short m4974minAoSsdG0(short r100, short r101) {
        if (Float16.m4946isNaNimpl(r100) == true) goto L13;
        if (Float16.m4946isNaNimpl(r101) == true) goto L13;
        if (Float16.m4933compareTo41bOqos(r100, r101) > 0) goto L11;
        return r100;
    L11:
        return r101;
    L13:
        return Float16.Companion.m4968getNaNslo4al4();
    }
}
