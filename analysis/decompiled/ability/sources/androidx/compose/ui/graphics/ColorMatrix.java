package androidx.compose.ui.graphics;

import S7.n;
import androidx.core.text.util.LocalePreferences;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH\u0086\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0017J2\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\t2\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u0019H\u0082\b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001f\u0010\u0017J\u0015\u0010$\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\t¢\u0006\u0004\b\"\u0010#J-\u0010+\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t¢\u0006\u0004\b)\u0010*J\u0015\u0010-\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b,\u0010#J\u0015\u0010/\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b.\u0010#J\u0015\u00101\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b0\u0010#J\r\u00103\u001a\u00020\u000e¢\u0006\u0004\b2\u0010\u0013J\r\u00105\u001a\u00020\u000e¢\u0006\u0004\b4\u0010\u0013J\u0010\u00107\u001a\u000206HÖ\u0001¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b9\u0010:J\u001a\u0010=\u001a\u00020<2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b=\u0010>R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010?\u001a\u0004\b@\u0010A\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006B"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrix;", "", "", "values", "constructor-impl", "([F)[F", "", "row", "column", "", "get-impl", "([FII)F", "get", "v", "LC7/r;", "set-impl", "([FIIF)V", "set", "reset-impl", "([F)V", "reset", "src", "set-jHG-Opc", "([F[F)V", "degrees", "Lkotlin/Function2;", "block", "rotateInternal-impl", "([FFLS7/n;)V", "rotateInternal", "colorMatrix", "timesAssign-jHG-Opc", "timesAssign", LocalePreferences.FirstDayOfWeek.SATURDAY, "setToSaturation-impl", "([FF)V", "setToSaturation", "redScale", "greenScale", "blueScale", "alphaScale", "setToScale-impl", "([FFFFF)V", "setToScale", "setToRotateRed-impl", "setToRotateRed", "setToRotateGreen-impl", "setToRotateGreen", "setToRotateBlue-impl", "setToRotateBlue", "convertRgbToYuv-impl", "convertRgbToYuv", "convertYuvToRgb-impl", "convertYuvToRgb", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "[F", "getValues", "()[F", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorMatrix {
    private final float[] values;

    private /* synthetic */ ColorMatrix(float[] fArr) {
        this.values = fArr;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m4194boximpl(float[] fArr) {
        return new ColorMatrix(fArr);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static float[] m4195constructorimpl(float[] fArr) {
        return fArr;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m4196constructorimpl$default(float[] fArr, int i, e eVar) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
        return m4195constructorimpl(fArr);
    }

    /* renamed from: convertRgbToYuv-impl, reason: not valid java name */
    public static final void m4197convertRgbToYuvimpl(float[] fArr) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        fArr[0] = 0.299f;
        fArr[1] = 0.587f;
        fArr[2] = 0.114f;
        fArr[5] = -0.16874f;
        fArr[6] = -0.33126f;
        fArr[7] = 0.5f;
        fArr[10] = 0.5f;
        fArr[11] = -0.41869f;
        fArr[12] = -0.08131f;
    }

    /* renamed from: convertYuvToRgb-impl, reason: not valid java name */
    public static final void m4198convertYuvToRgbimpl(float[] fArr) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        fArr[2] = 1.402f;
        fArr[5] = 1.0f;
        fArr[6] = -0.34414f;
        fArr[7] = -0.71414f;
        fArr[10] = 1.0f;
        fArr[11] = 1.772f;
        fArr[12] = 0.0f;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4199equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof ColorMatrix) && k.b(fArr, ((ColorMatrix) obj).m4214unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4200equalsimpl0(float[] fArr, float[] fArr2) {
        return k.b(fArr, fArr2);
    }

    /* renamed from: get-impl, reason: not valid java name */
    public static final float m4201getimpl(float[] fArr, int i, int i6) {
        return fArr[(i * 5) + i6];
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4202hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: reset-impl, reason: not valid java name */
    public static final void m4203resetimpl(float[] fArr) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
    }

    /* renamed from: rotateInternal-impl, reason: not valid java name */
    private static final void m4204rotateInternalimpl(float[] fArr, float f, n nVar) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f7 = f * 0.0027777778f;
        float fFloor = (0.25f + f7) - ((float) Math.floor(r8 + 0.5f));
        float fAbs = Math.abs(fFloor) * 2.0f;
        float f9 = 1.0f - fAbs;
        float fFloor2 = f7 - ((float) Math.floor(0.5f + f7));
        float fAbs2 = Math.abs(fFloor2) * 2.0f;
        float f10 = 1.0f - fAbs2;
        nVar.invoke(Float.valueOf(((fFloor * 8.0f) * f9) / (1.25f - (fAbs * f9))), Float.valueOf(((fFloor2 * 8.0f) * f10) / (1.25f - (fAbs2 * f10))));
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m4205setimpl(float[] fArr, int i, int i6, float f) {
        fArr[(i * 5) + i6] = f;
    }

    /* renamed from: set-jHG-Opc, reason: not valid java name */
    public static final void m4206setjHGOpc(float[] fArr, float[] fArr2) {
        if (fArr.length >= 20 && fArr2.length >= 20) {
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            fArr[2] = fArr2[2];
            fArr[3] = fArr2[3];
            fArr[4] = fArr2[4];
            fArr[5] = fArr2[5];
            fArr[6] = fArr2[6];
            fArr[7] = fArr2[7];
            fArr[8] = fArr2[8];
            fArr[9] = fArr2[9];
            fArr[10] = fArr2[10];
            fArr[11] = fArr2[11];
            fArr[12] = fArr2[12];
            fArr[13] = fArr2[13];
            fArr[14] = fArr2[14];
            fArr[15] = fArr2[15];
            fArr[16] = fArr2[16];
            fArr[17] = fArr2[17];
            fArr[18] = fArr2[18];
            fArr[19] = fArr2[19];
        }
    }

    /* renamed from: setToRotateBlue-impl, reason: not valid java name */
    public static final void m4207setToRotateBlueimpl(float[] fArr, float f) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f7 = f * 0.0027777778f;
        float fFloor = (0.25f + f7) - ((float) Math.floor(r3 + 0.5f));
        float fAbs = Math.abs(fFloor) * 2.0f;
        float f9 = 1.0f - fAbs;
        float f10 = ((fFloor * 8.0f) * f9) / (1.25f - (fAbs * f9));
        float fFloor2 = f7 - ((float) Math.floor(0.5f + f7));
        float fAbs2 = Math.abs(fFloor2) * 2.0f;
        float f11 = 1.0f - fAbs2;
        float f12 = ((fFloor2 * 8.0f) * f11) / (1.25f - (fAbs2 * f11));
        fArr[0] = f10;
        fArr[1] = f12;
        fArr[5] = -f12;
        fArr[6] = f10;
    }

    /* renamed from: setToRotateGreen-impl, reason: not valid java name */
    public static final void m4208setToRotateGreenimpl(float[] fArr, float f) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f7 = f * 0.0027777778f;
        float fFloor = (0.25f + f7) - ((float) Math.floor(r3 + 0.5f));
        float fAbs = Math.abs(fFloor) * 2.0f;
        float f9 = 1.0f - fAbs;
        float f10 = ((fFloor * 8.0f) * f9) / (1.25f - (fAbs * f9));
        float fFloor2 = f7 - ((float) Math.floor(0.5f + f7));
        float fAbs2 = Math.abs(fFloor2) * 2.0f;
        float f11 = 1.0f - fAbs2;
        float f12 = ((fFloor2 * 8.0f) * f11) / (1.25f - (fAbs2 * f11));
        fArr[0] = f10;
        fArr[2] = -f12;
        fArr[10] = f12;
        fArr[12] = f10;
    }

    /* renamed from: setToRotateRed-impl, reason: not valid java name */
    public static final void m4209setToRotateRedimpl(float[] fArr, float f) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f7 = f * 0.0027777778f;
        float fFloor = (0.25f + f7) - ((float) Math.floor(r2 + 0.5f));
        float fAbs = Math.abs(fFloor) * 2.0f;
        float f9 = 1.0f - fAbs;
        float f10 = ((fFloor * 8.0f) * f9) / (1.25f - (fAbs * f9));
        float fFloor2 = f7 - ((float) Math.floor(0.5f + f7));
        float fAbs2 = Math.abs(fFloor2) * 2.0f;
        float f11 = 1.0f - fAbs2;
        float f12 = ((fFloor2 * 8.0f) * f11) / (1.25f - (fAbs2 * f11));
        fArr[6] = f10;
        fArr[7] = f12;
        fArr[11] = -f12;
        fArr[12] = f10;
    }

    /* renamed from: setToSaturation-impl, reason: not valid java name */
    public static final void m4210setToSaturationimpl(float[] fArr, float f) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f7 = 1 - f;
        float f9 = 0.213f * f7;
        float f10 = 0.715f * f7;
        float f11 = f7 * 0.072f;
        fArr[0] = f9 + f;
        fArr[1] = f10;
        fArr[2] = f11;
        fArr[5] = f9;
        fArr[6] = f10 + f;
        fArr[7] = f11;
        fArr[10] = f9;
        fArr[11] = f10;
        fArr[12] = f11 + f;
    }

    /* renamed from: setToScale-impl, reason: not valid java name */
    public static final void m4211setToScaleimpl(float[] fArr, float f, float f7, float f9, float f10) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        fArr[0] = f;
        fArr[6] = f7;
        fArr[12] = f9;
        fArr[18] = f10;
    }

    /* renamed from: timesAssign-jHG-Opc, reason: not valid java name */
    public static final void m4212timesAssignjHGOpc(float[] fArr, float[] fArr2) {
        if (fArr.length < 20) {
            return;
        }
        float f = fArr[0];
        float f7 = fArr2[0];
        float f9 = fArr[1];
        float f10 = fArr2[5];
        float f11 = fArr[2];
        float f12 = fArr2[10];
        float f13 = f11 * f12;
        float f14 = fArr[3];
        float f15 = fArr2[15];
        float f16 = f14 * f15;
        float f17 = f16 + f13 + (f9 * f10) + (f * f7);
        float f18 = fArr2[1];
        float f19 = fArr2[6];
        float f20 = fArr2[11];
        float f21 = f11 * f20;
        float f22 = fArr2[16];
        float f23 = f14 * f22;
        float f24 = f23 + f21 + (f9 * f19) + (f * f18);
        float f25 = fArr2[2];
        float f26 = fArr2[7];
        float f27 = fArr2[12];
        float f28 = f11 * f27;
        float f29 = fArr2[17];
        float f30 = f14 * f29;
        float f31 = f30 + f28 + (f9 * f26) + (f * f25);
        float f32 = fArr2[3];
        float f33 = fArr2[8];
        float f34 = fArr2[13];
        float f35 = f11 * f34;
        float f36 = fArr2[18];
        float f37 = f14 * f36;
        float f38 = f37 + f35 + (f9 * f33) + (f * f32);
        float f39 = fArr2[4];
        float f40 = fArr2[9];
        float f41 = fArr2[14];
        float f42 = f11 * f41;
        float f43 = fArr2[19];
        float f44 = f14 * f43;
        float f45 = f44 + f42 + (f9 * f40) + (f * f39) + fArr[4];
        float f46 = fArr[5];
        float f47 = fArr[6];
        float f48 = fArr[7];
        float f49 = (f48 * f12) + (f47 * f10) + (f46 * f7);
        float f50 = fArr[8];
        float f51 = (f50 * f15) + f49;
        float f52 = (f50 * f22) + (f48 * f20) + (f47 * f19) + (f46 * f18);
        float f53 = (f50 * f29) + (f48 * f27) + (f47 * f26) + (f46 * f25);
        float f54 = (f50 * f36) + (f48 * f34) + (f47 * f33) + (f46 * f32);
        float f55 = f48 * f41;
        float f56 = f50 * f43;
        float f57 = f56 + f55 + (f47 * f40) + (f46 * f39) + fArr[9];
        float f58 = fArr[10];
        float f59 = fArr[11];
        float f60 = fArr[12];
        float f61 = (f60 * f12) + (f59 * f10) + (f58 * f7);
        float f62 = fArr[13];
        float f63 = (f62 * f15) + f61;
        float f64 = (f62 * f22) + (f60 * f20) + (f59 * f19) + (f58 * f18);
        float f65 = (f62 * f29) + (f60 * f27) + (f59 * f26) + (f58 * f25);
        float f66 = (f62 * f36) + (f60 * f34) + (f59 * f33) + (f58 * f32);
        float f67 = f60 * f41;
        float f68 = f62 * f43;
        float f69 = f68 + f67 + (f59 * f40) + (f58 * f39) + fArr[14];
        float f70 = fArr[15];
        float f71 = fArr[16];
        float f72 = (f10 * f71) + (f7 * f70);
        float f73 = fArr[17];
        float f74 = (f12 * f73) + f72;
        float f75 = fArr[18];
        float f76 = (f15 * f75) + f74;
        float f77 = f20 * f73;
        float f78 = f22 * f75;
        float f79 = f78 + f77 + (f19 * f71) + (f18 * f70);
        float f80 = f27 * f73;
        float f81 = f29 * f75;
        float f82 = f81 + f80 + (f26 * f71) + (f25 * f70);
        float f83 = f34 * f73;
        float f84 = f36 * f75;
        float f85 = f84 + f83 + (f33 * f71) + (f32 * f70);
        float f86 = f73 * f41;
        float f87 = f75 * f43;
        float f88 = f87 + f86 + (f71 * f40) + (f70 * f39) + fArr[19];
        fArr[0] = f17;
        fArr[1] = f24;
        fArr[2] = f31;
        fArr[3] = f38;
        fArr[4] = f45;
        fArr[5] = f51;
        fArr[6] = f52;
        fArr[7] = f53;
        fArr[8] = f54;
        fArr[9] = f57;
        fArr[10] = f63;
        fArr[11] = f64;
        fArr[12] = f65;
        fArr[13] = f66;
        fArr[14] = f69;
        fArr[15] = f76;
        fArr[16] = f79;
        fArr[17] = f82;
        fArr[18] = f85;
        fArr[19] = f88;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4213toStringimpl(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + ')';
    }

    public boolean equals(Object other) {
        return m4199equalsimpl(this.values, other);
    }

    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return m4202hashCodeimpl(this.values);
    }

    public String toString() {
        return m4213toStringimpl(this.values);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m4214unboximpl() {
        return this.values;
    }
}
