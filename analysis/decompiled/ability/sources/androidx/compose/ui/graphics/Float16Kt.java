package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0011\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0016H\u0082\b\u001a\u0011\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0013H\u0080\b\u001a\u0011\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0016H\u0080\b\u001a\u001f\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001f\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\"\u0010 \"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Fp16SignShift", "", "Fp16SignMask", "Fp16ExponentShift", "Fp16ExponentMask", "Fp16SignificandMask", "Fp16ExponentBias", "Fp16Combined", "Fp16ExponentMax", "Fp16One", "Fp16TheNaN", "Fp32SignShift", "Fp32ExponentShift", "Fp32ExponentMask", "Fp32SignificandMask", "Fp32ExponentBias", "Fp32QNaNMask", "Fp32DenormalMagic", "Fp32DenormalFloat", "", "toCompareValue", "value", "", "floatToHalf", "f", "halfToFloat", "h", "min", "Landroidx/compose/ui/graphics/Float16;", "x", "y", "min-AoSsdG0", "(SS)S", "max", "max-AoSsdG0", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
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
    private static final int Fp32ExponentBias = 127;
    private static final int Fp32ExponentMask = 255;
    private static final int Fp32ExponentShift = 23;
    private static final int Fp32QNaNMask = 4194304;
    private static final int Fp32SignShift = 31;
    private static final int Fp32SignificandMask = 8388607;
    private static final int Fp32DenormalMagic = 1056964608;
    private static final float Fp32DenormalFloat = Float.intBitsToFloat(Fp32DenormalMagic);

    public static final short floatToHalf(float f) {
        int i;
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i6 = iFloatToRawIntBits >>> 31;
        int i10 = (iFloatToRawIntBits >>> 23) & 255;
        int i11 = Fp32SignificandMask & iFloatToRawIntBits;
        int i12 = 31;
        int i13 = 0;
        if (i10 != 255) {
            int i14 = i10 - 112;
            if (i14 >= 31) {
                i12 = 49;
            } else if (i14 > 0) {
                i13 = i11 >> 13;
                if ((iFloatToRawIntBits & 4096) != 0) {
                    i = (((i14 << 10) | i13) + 1) | (i6 << 15);
                    return (short) i;
                }
                i12 = i14;
            } else if (i14 >= -10) {
                int i15 = (8388608 | i11) >> (1 - i14);
                if ((i15 & 4096) != 0) {
                    i15 += 8192;
                }
                i12 = 0;
                i13 = i15 >> 13;
            } else {
                i12 = 0;
            }
        } else if (i11 != 0) {
            i13 = 512;
        }
        i = (i6 << 15) | (i12 << 10) | i13;
        return (short) i;
    }

    public static final float halfToFloat(short s5) {
        int i;
        int i6;
        int i10;
        int i11 = Short.MIN_VALUE & s5;
        int i12 = ((65535 & s5) >>> 10) & 31;
        int i13 = s5 & 1023;
        if (i12 != 0) {
            int i14 = i13 << 13;
            if (i12 == 31) {
                i = 255;
                if (i14 != 0) {
                    i14 |= 4194304;
                }
            } else {
                i = i12 + 112;
            }
            int i15 = i;
            i6 = i14;
            i10 = i15;
        } else {
            if (i13 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i13 + Fp32DenormalMagic) - Fp32DenormalFloat;
                return i11 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i10 = 0;
            i6 = 0;
        }
        return Float.intBitsToFloat((i10 << 23) | (i11 << 16) | i6);
    }

    /* renamed from: max-AoSsdG0, reason: not valid java name */
    public static final short m4285maxAoSsdG0(short s5, short s10) {
        return (Float16.m4258isNaNimpl(s5) || Float16.m4258isNaNimpl(s10)) ? Float16.Companion.m4280getNaNslo4al4() : Float16.m4245compareTo41bOqos(s5, s10) >= 0 ? s5 : s10;
    }

    /* renamed from: min-AoSsdG0, reason: not valid java name */
    public static final short m4286minAoSsdG0(short s5, short s10) {
        return (Float16.m4258isNaNimpl(s5) || Float16.m4258isNaNimpl(s10)) ? Float16.Companion.m4280getNaNslo4al4() : Float16.m4245compareTo41bOqos(s5, s10) <= 0 ? s5 : s10;
    }

    private static final int toCompareValue(short s5) {
        return (s5 & Short.MIN_VALUE) != 0 ? 32768 - (s5 & 65535) : s5 & 65535;
    }
}
