package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import j9.n;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b.\b\u0087@\u0018\u0000 T2\u00020\u0001:\u0001TB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0012\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0017\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0086\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020!¢\u0006\u0004\b\u001f\u0010\"J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010*\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\r\u0010-\u001a\u00020\u0014¢\u0006\u0004\b+\u0010,J\r\u0010/\u001a\u00020\u0014¢\u0006\u0004\b.\u0010,J\u0015\u00102\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0000¢\u0006\u0004\b1\u0010%J\u0015\u00106\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u000f¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u000f¢\u0006\u0004\b7\u00105J\u0015\u0010:\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u000f¢\u0006\u0004\b9\u00105J+\u0010@\u001a\u00020\u00142\b\b\u0002\u0010;\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010=\u001a\u00020\u000f¢\u0006\u0004\b>\u0010?J+\u0010B\u001a\u00020\u00142\b\b\u0002\u0010;\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010=\u001a\u00020\u000f¢\u0006\u0004\bA\u0010?J{\u0010P\u001a\u00020\u00142\b\b\u0002\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020\u000f2\b\b\u0002\u0010E\u001a\u00020\u000f2\b\b\u0002\u0010F\u001a\u00020\u000f2\b\b\u0002\u0010G\u001a\u00020\u000f2\b\b\u0002\u0010H\u001a\u00020\u000f2\b\b\u0002\u0010I\u001a\u00020\u000f2\b\b\u0002\u0010J\u001a\u00020\u000f2\b\b\u0002\u0010K\u001a\u00020\u000f2\b\b\u0002\u0010L\u001a\u00020\u000f2\b\b\u0002\u0010M\u001a\u00020\u000f¢\u0006\u0004\bN\u0010OR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010Q\u001a\u0004\bR\u0010S\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006U"}, d2 = {"Landroidx/compose/ui/graphics/Matrix;", "", "", "values", "constructor-impl", "([F)[F", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "row", "column", "", "get-impl", "([FII)F", "get", "v", "LC7/r;", "set-impl", "([FIIF)V", "set", "Landroidx/compose/ui/geometry/Offset;", "point", "map-MK-Hz9U", "([FJ)J", "map", "Landroidx/compose/ui/geometry/Rect;", "rect", "map-impl", "([FLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/MutableRect;", "([FLandroidx/compose/ui/geometry/MutableRect;)V", "m", "timesAssign-58bKbWc", "([F[F)V", "timesAssign", "", "toString-impl", "([F)Ljava/lang/String;", "toString", "invert-impl", "([F)V", "invert", "reset-impl", "reset", "matrix", "setFrom-58bKbWc", "setFrom", "degrees", "rotateX-impl", "([FF)V", "rotateX", "rotateY-impl", "rotateY", "rotateZ-impl", "rotateZ", "x", "y", "z", "scale-impl", "([FFFF)V", "scale", "translate-impl", "translate", "pivotX", "pivotY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "scaleZ", "resetToPivotedTransform-impl", "([FFFFFFFFFFFF)V", "resetToPivotedTransform", "[F", "getValues", "()[F", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Matrix {
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;
    private final float[] values;

    private /* synthetic */ Matrix(float[] fArr) {
        this.values = fArr;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Matrix m4378boximpl(float[] fArr) {
        return new Matrix(fArr);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static float[] m4379constructorimpl(float[] fArr) {
        return fArr;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m4380constructorimpl$default(float[] fArr, int i, e eVar) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return m4379constructorimpl(fArr);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4381equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && k.b(fArr, ((Matrix) obj).m4403unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4382equalsimpl0(float[] fArr, float[] fArr2) {
        return k.b(fArr, fArr2);
    }

    /* renamed from: get-impl, reason: not valid java name */
    public static final float m4383getimpl(float[] fArr, int i, int i6) {
        return fArr[(i * 4) + i6];
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4384hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: invert-impl, reason: not valid java name */
    public static final void m4385invertimpl(float[] fArr) {
        if (fArr.length < 16) {
            return;
        }
        float f = fArr[0];
        float f7 = fArr[1];
        float f9 = fArr[2];
        float f10 = fArr[3];
        float f11 = fArr[4];
        float f12 = fArr[5];
        float f13 = fArr[6];
        float f14 = fArr[7];
        float f15 = fArr[8];
        float f16 = fArr[9];
        float f17 = fArr[10];
        float f18 = fArr[11];
        float f19 = fArr[12];
        float f20 = fArr[13];
        float f21 = fArr[14];
        float f22 = fArr[15];
        float f23 = (f * f12) - (f7 * f11);
        float f24 = (f * f13) - (f9 * f11);
        float f25 = (f * f14) - (f10 * f11);
        float f26 = (f7 * f13) - (f9 * f12);
        float f27 = (f7 * f14) - (f10 * f12);
        float f28 = (f9 * f14) - (f10 * f13);
        float f29 = (f15 * f20) - (f16 * f19);
        float f30 = (f15 * f21) - (f17 * f19);
        float f31 = (f15 * f22) - (f18 * f19);
        float f32 = (f16 * f21) - (f17 * f20);
        float f33 = (f16 * f22) - (f18 * f20);
        float f34 = (f17 * f22) - (f18 * f21);
        float f35 = (f28 * f29) + (((f26 * f31) + ((f25 * f32) + ((f23 * f34) - (f24 * f33)))) - (f27 * f30));
        if (f35 == 0.0f) {
            return;
        }
        float f36 = 1.0f / f35;
        fArr[0] = androidx.appfunctions.metadata.a.a(f14, f32, (f12 * f34) - (f13 * f33), f36);
        fArr[1] = androidx.compose.foundation.b.a(f10, f32, (f9 * f33) + ((-f7) * f34), f36);
        fArr[2] = androidx.appfunctions.metadata.a.a(f22, f26, (f20 * f28) - (f21 * f27), f36);
        fArr[3] = androidx.compose.foundation.b.a(f18, f26, (f17 * f27) + ((-f16) * f28), f36);
        float f37 = -f11;
        fArr[4] = androidx.compose.foundation.b.a(f14, f30, (f13 * f31) + (f37 * f34), f36);
        fArr[5] = androidx.appfunctions.metadata.a.a(f10, f30, (f34 * f) - (f9 * f31), f36);
        float f38 = -f19;
        fArr[6] = androidx.compose.foundation.b.a(f22, f24, (f21 * f25) + (f38 * f28), f36);
        fArr[7] = androidx.appfunctions.metadata.a.a(f18, f24, (f15 * f28) - (f17 * f25), f36);
        fArr[8] = androidx.appfunctions.metadata.a.a(f14, f29, (f11 * f33) - (f12 * f31), f36);
        fArr[9] = androidx.compose.foundation.b.a(f10, f29, (f31 * f7) + ((-f) * f33), f36);
        fArr[10] = androidx.appfunctions.metadata.a.a(f22, f23, (f19 * f27) - (f20 * f25), f36);
        fArr[11] = androidx.compose.foundation.b.a(f18, f23, (f25 * f16) + ((-f15) * f27), f36);
        fArr[12] = androidx.compose.foundation.b.a(f13, f29, (f12 * f30) + (f37 * f32), f36);
        fArr[13] = androidx.appfunctions.metadata.a.a(f9, f29, (f * f32) - (f7 * f30), f36);
        fArr[14] = androidx.compose.foundation.b.a(f21, f23, (f20 * f24) + (f38 * f26), f36);
        fArr[15] = androidx.appfunctions.metadata.a.a(f17, f23, (f15 * f26) - (f16 * f24), f36);
    }

    /* renamed from: map-MK-Hz9U, reason: not valid java name */
    public static final long m4386mapMKHz9U(float[] fArr, long j5) {
        if (fArr.length < 16) {
            return j5;
        }
        float f = fArr[0];
        float f7 = fArr[1];
        float f9 = fArr[3];
        float f10 = fArr[4];
        float f11 = fArr[5];
        float f12 = fArr[7];
        float f13 = fArr[12];
        float f14 = fArr[13];
        float f15 = fArr[15];
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L));
        float f16 = 1 / (((f12 * fIntBitsToFloat2) + (f9 * fIntBitsToFloat)) + f15);
        if ((Float.floatToRawIntBits(f16) & Integer.MAX_VALUE) >= 2139095040) {
            f16 = 0.0f;
        }
        float f17 = ((f11 * fIntBitsToFloat2) + (f7 * fIntBitsToFloat) + f14) * f16;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits((((f10 * fIntBitsToFloat2) + (f * fIntBitsToFloat)) + f13) * f16) << 32) | (Float.floatToRawIntBits(f17) & 4294967295L));
    }

    /* renamed from: map-impl, reason: not valid java name */
    public static final Rect m4387mapimpl(float[] fArr, Rect rect) {
        if (fArr.length < 16) {
            return rect;
        }
        float f = fArr[0];
        float f7 = fArr[1];
        float f9 = fArr[3];
        float f10 = fArr[4];
        float f11 = fArr[5];
        float f12 = fArr[7];
        float f13 = fArr[12];
        float f14 = fArr[13];
        float f15 = fArr[15];
        float left = rect.getLeft();
        float top = rect.getTop();
        float right = rect.getRight();
        float bottom = rect.getBottom();
        float f16 = f9 * left;
        float f17 = f12 * top;
        float f18 = 1.0f / ((f16 + f17) + f15);
        if ((Float.floatToRawIntBits(f18) & Integer.MAX_VALUE) >= 2139095040) {
            f18 = 0.0f;
        }
        float f19 = f * left;
        float f20 = f10 * top;
        float f21 = (f19 + f20 + f13) * f18;
        float f22 = left * f7;
        float f23 = top * f11;
        float f24 = f18 * (f22 + f23 + f14);
        float f25 = f12 * bottom;
        float f26 = 1.0f / ((f16 + f25) + f15);
        if ((Float.floatToRawIntBits(f26) & Integer.MAX_VALUE) >= 2139095040) {
            f26 = 0.0f;
        }
        float f27 = f10 * bottom;
        float f28 = (f19 + f27 + f13) * f26;
        float f29 = f11 * bottom;
        float f30 = (f22 + f29 + f14) * f26;
        float f31 = f9 * right;
        float f32 = 1.0f / ((f17 + f31) + f15);
        if ((Float.floatToRawIntBits(f32) & Integer.MAX_VALUE) >= 2139095040) {
            f32 = 0.0f;
        }
        float f33 = f * right;
        float f34 = (f33 + f20 + f13) * f32;
        float f35 = right * f7;
        float f36 = (f23 + f35 + f14) * f32;
        float f37 = 1.0f / ((f31 + f25) + f15);
        float f38 = (Float.floatToRawIntBits(f37) & Integer.MAX_VALUE) < 2139095040 ? f37 : 0.0f;
        float f39 = (f33 + f27 + f13) * f38;
        float f40 = (f35 + f29 + f14) * f38;
        return new Rect(Math.min(f21, Math.min(f28, Math.min(f34, f39))), Math.min(f24, Math.min(f30, Math.min(f36, f40))), Math.max(f21, Math.max(f28, Math.max(f34, f39))), Math.max(f24, Math.max(f30, Math.max(f36, f40))));
    }

    /* renamed from: reset-impl, reason: not valid java name */
    public static final void m4389resetimpl(float[] fArr) {
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 1.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
    }

    /* renamed from: resetToPivotedTransform-impl, reason: not valid java name */
    public static final void m4390resetToPivotedTransformimpl(float[] fArr, float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        double d = f12 * 0.017453292519943295d;
        float fSin = (float) Math.sin(d);
        float fCos = (float) Math.cos(d);
        float f18 = -fSin;
        float f19 = (f10 * fCos) - (f11 * fSin);
        float f20 = (f11 * fCos) + (f10 * fSin);
        double d6 = f13 * 0.017453292519943295d;
        float fSin2 = (float) Math.sin(d6);
        float fCos2 = (float) Math.cos(d6);
        float f21 = -fSin2;
        float f22 = fSin * fSin2;
        float f23 = fSin * fCos2;
        float f24 = fCos * fSin2;
        float f25 = fCos * fCos2;
        float f26 = (f20 * fSin2) + (f9 * fCos2);
        float f27 = (f20 * fCos2) + ((-f9) * fSin2);
        double d10 = f14 * 0.017453292519943295d;
        float fSin3 = (float) Math.sin(d10);
        float fCos3 = (float) Math.cos(d10);
        float f28 = -fSin3;
        float f29 = (fCos3 * f22) + (f28 * fCos2);
        float f30 = ((f22 * fSin3) + (fCos2 * fCos3)) * f15;
        float f31 = fSin3 * fCos * f15;
        float f32 = ((fSin3 * f23) + (fCos3 * f21)) * f15;
        float f33 = f29 * f16;
        float f34 = fCos * fCos3 * f16;
        float f35 = ((fCos3 * f23) + (f28 * f21)) * f16;
        float f36 = f24 * f17;
        float f37 = f18 * f17;
        float f38 = f25 * f17;
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = f30;
        fArr[1] = f31;
        fArr[2] = f32;
        fArr[3] = 0.0f;
        fArr[4] = f33;
        fArr[5] = f34;
        fArr[6] = f35;
        fArr[7] = 0.0f;
        fArr[8] = f36;
        fArr[9] = f37;
        fArr[10] = f38;
        fArr[11] = 0.0f;
        float f39 = -f;
        fArr[12] = ((f30 * f39) - (f33 * f7)) + f26 + f;
        fArr[13] = ((f31 * f39) - (f34 * f7)) + f19 + f7;
        fArr[14] = ((f39 * f32) - (f7 * f35)) + f27;
        fArr[15] = 1.0f;
    }

    /* renamed from: resetToPivotedTransform-impl$default, reason: not valid java name */
    public static /* synthetic */ void m4391resetToPivotedTransformimpl$default(float[] fArr, float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f7 = 0.0f;
        }
        if ((i & 4) != 0) {
            f9 = 0.0f;
        }
        if ((i & 8) != 0) {
            f10 = 0.0f;
        }
        if ((i & 16) != 0) {
            f11 = 0.0f;
        }
        if ((i & 32) != 0) {
            f12 = 0.0f;
        }
        if ((i & 64) != 0) {
            f13 = 0.0f;
        }
        if ((i & 128) != 0) {
            f14 = 0.0f;
        }
        if ((i & 256) != 0) {
            f15 = 1.0f;
        }
        if ((i & 512) != 0) {
            f16 = 1.0f;
        }
        if ((i & 1024) != 0) {
            f17 = 1.0f;
        }
        m4390resetToPivotedTransformimpl(fArr, f, f7, f9, f10, f11, f12, f13, f14, f15, f16, f17);
    }

    /* renamed from: rotateX-impl, reason: not valid java name */
    public static final void m4392rotateXimpl(float[] fArr, float f) {
        if (fArr.length < 16) {
            return;
        }
        double d = f * 0.017453292519943295d;
        float fSin = (float) Math.sin(d);
        float fCos = (float) Math.cos(d);
        float f7 = fArr[1];
        float f9 = fArr[2];
        float f10 = fArr[5];
        float f11 = fArr[6];
        float f12 = fArr[9];
        float f13 = fArr[10];
        float f14 = fArr[13];
        float f15 = fArr[14];
        fArr[1] = (f7 * fCos) - (f9 * fSin);
        fArr[2] = (f9 * fCos) + (f7 * fSin);
        fArr[5] = (f10 * fCos) - (f11 * fSin);
        fArr[6] = (f11 * fCos) + (f10 * fSin);
        fArr[9] = (f12 * fCos) - (f13 * fSin);
        fArr[10] = (f13 * fCos) + (f12 * fSin);
        fArr[13] = (f14 * fCos) - (f15 * fSin);
        fArr[14] = (f15 * fCos) + (f14 * fSin);
    }

    /* renamed from: rotateY-impl, reason: not valid java name */
    public static final void m4393rotateYimpl(float[] fArr, float f) {
        if (fArr.length < 16) {
            return;
        }
        double d = f * 0.017453292519943295d;
        float fSin = (float) Math.sin(d);
        float fCos = (float) Math.cos(d);
        float f7 = fArr[0];
        float f9 = fArr[2];
        float f10 = fArr[4];
        float f11 = fArr[6];
        float f12 = fArr[8];
        float f13 = fArr[10];
        float f14 = fArr[12];
        float f15 = fArr[14];
        fArr[0] = (f9 * fSin) + (f7 * fCos);
        fArr[2] = (f9 * fCos) + ((-f7) * fSin);
        fArr[4] = (f11 * fSin) + (f10 * fCos);
        fArr[6] = (f11 * fCos) + ((-f10) * fSin);
        fArr[8] = (f13 * fSin) + (f12 * fCos);
        fArr[10] = (f13 * fCos) + ((-f12) * fSin);
        fArr[12] = (f15 * fSin) + (f14 * fCos);
        fArr[14] = (f15 * fCos) + ((-f14) * fSin);
    }

    /* renamed from: rotateZ-impl, reason: not valid java name */
    public static final void m4394rotateZimpl(float[] fArr, float f) {
        if (fArr.length < 16) {
            return;
        }
        double d = f * 0.017453292519943295d;
        float fSin = (float) Math.sin(d);
        float fCos = (float) Math.cos(d);
        float f7 = fArr[0];
        float f9 = fArr[4];
        float f10 = (fSin * f9) + (fCos * f7);
        float f11 = -fSin;
        float f12 = fArr[1];
        float f13 = fArr[5];
        float f14 = (fSin * f13) + (fCos * f12);
        float f15 = fArr[2];
        float f16 = fArr[6];
        float f17 = (fSin * f16) + (fCos * f15);
        float f18 = fArr[3];
        float f19 = fArr[7];
        fArr[0] = f10;
        fArr[1] = f14;
        fArr[2] = f17;
        fArr[3] = (fSin * f19) + (fCos * f18);
        fArr[4] = (f9 * fCos) + (f7 * f11);
        fArr[5] = (f13 * fCos) + (f12 * f11);
        fArr[6] = (f16 * fCos) + (f15 * f11);
        fArr[7] = (fCos * f19) + (f11 * f18);
    }

    /* renamed from: scale-impl, reason: not valid java name */
    public static final void m4395scaleimpl(float[] fArr, float f, float f7, float f9) {
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = fArr[0] * f;
        fArr[1] = fArr[1] * f;
        fArr[2] = fArr[2] * f;
        fArr[3] = fArr[3] * f;
        fArr[4] = fArr[4] * f7;
        fArr[5] = fArr[5] * f7;
        fArr[6] = fArr[6] * f7;
        fArr[7] = fArr[7] * f7;
        fArr[8] = fArr[8] * f9;
        fArr[9] = fArr[9] * f9;
        fArr[10] = fArr[10] * f9;
        fArr[11] = fArr[11] * f9;
    }

    /* renamed from: scale-impl$default, reason: not valid java name */
    public static /* synthetic */ void m4396scaleimpl$default(float[] fArr, float f, float f7, float f9, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f7 = 1.0f;
        }
        if ((i & 4) != 0) {
            f9 = 1.0f;
        }
        m4395scaleimpl(fArr, f, f7, f9);
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m4397setimpl(float[] fArr, int i, int i6, float f) {
        fArr[(i * 4) + i6] = f;
    }

    /* renamed from: setFrom-58bKbWc, reason: not valid java name */
    public static final void m4398setFrom58bKbWc(float[] fArr, float[] fArr2) {
        if (fArr.length >= 16 && fArr2.length >= 16) {
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
        }
    }

    /* renamed from: timesAssign-58bKbWc, reason: not valid java name */
    public static final void m4399timesAssign58bKbWc(float[] fArr, float[] fArr2) {
        if (fArr.length >= 16 && fArr2.length >= 16) {
            float f = fArr[0];
            float f7 = fArr2[0];
            float f9 = fArr[1];
            float f10 = fArr2[4];
            float f11 = fArr[2];
            float f12 = fArr2[8];
            float f13 = f11 * f12;
            float f14 = fArr[3];
            float f15 = fArr2[12];
            float f16 = f14 * f15;
            float f17 = f16 + f13 + (f9 * f10) + (f * f7);
            float f18 = fArr2[1];
            float f19 = fArr2[5];
            float f20 = fArr2[9];
            float f21 = f11 * f20;
            float f22 = fArr2[13];
            float f23 = f14 * f22;
            float f24 = f23 + f21 + (f9 * f19) + (f * f18);
            float f25 = fArr2[2];
            float f26 = fArr2[6];
            float f27 = fArr2[10];
            float f28 = f11 * f27;
            float f29 = fArr2[14];
            float f30 = f14 * f29;
            float f31 = f30 + f28 + (f9 * f26) + (f * f25);
            float f32 = fArr2[3];
            float f33 = fArr2[7];
            float f34 = fArr2[11];
            float f35 = f11 * f34;
            float f36 = fArr2[15];
            float f37 = f14 * f36;
            float f38 = f37 + f35 + (f9 * f33) + (f * f32);
            float f39 = fArr[4];
            float f40 = fArr[5];
            float f41 = fArr[6];
            float f42 = (f41 * f12) + (f40 * f10) + (f39 * f7);
            float f43 = fArr[7];
            float f44 = (f43 * f15) + f42;
            float f45 = (f43 * f22) + (f41 * f20) + (f40 * f19) + (f39 * f18);
            float f46 = (f43 * f29) + (f41 * f27) + (f40 * f26) + (f39 * f25);
            float f47 = f41 * f34;
            float f48 = f43 * f36;
            float f49 = f48 + f47 + (f40 * f33) + (f39 * f32);
            float f50 = fArr[8];
            float f51 = fArr[9];
            float f52 = fArr[10];
            float f53 = (f52 * f12) + (f51 * f10) + (f50 * f7);
            float f54 = fArr[11];
            float f55 = (f54 * f15) + f53;
            float f56 = (f54 * f22) + (f52 * f20) + (f51 * f19) + (f50 * f18);
            float f57 = (f54 * f29) + (f52 * f27) + (f51 * f26) + (f50 * f25);
            float f58 = f52 * f34;
            float f59 = f54 * f36;
            float f60 = f59 + f58 + (f51 * f33) + (f50 * f32);
            float f61 = fArr[12];
            float f62 = fArr[13];
            float f63 = (f10 * f62) + (f7 * f61);
            float f64 = fArr[14];
            float f65 = (f12 * f64) + f63;
            float f66 = fArr[15];
            float f67 = (f15 * f66) + f65;
            float f68 = f20 * f64;
            float f69 = f22 * f66;
            float f70 = f69 + f68 + (f19 * f62) + (f18 * f61);
            float f71 = f27 * f64;
            float f72 = f29 * f66;
            float f73 = f72 + f71 + (f26 * f62) + (f25 * f61);
            float f74 = f64 * f34;
            float f75 = f66 * f36;
            fArr[0] = f17;
            fArr[1] = f24;
            fArr[2] = f31;
            fArr[3] = f38;
            fArr[4] = f44;
            fArr[5] = f45;
            fArr[6] = f46;
            fArr[7] = f49;
            fArr[8] = f55;
            fArr[9] = f56;
            fArr[10] = f57;
            fArr[11] = f60;
            fArr[12] = f67;
            fArr[13] = f70;
            fArr[14] = f73;
            fArr[15] = f75 + f74 + (f62 * f33) + (f61 * f32);
        }
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4400toStringimpl(float[] fArr) {
        return n.R("\n            |" + fArr[0] + ' ' + fArr[1] + ' ' + fArr[2] + ' ' + fArr[3] + "|\n            |" + fArr[4] + ' ' + fArr[5] + ' ' + fArr[6] + ' ' + fArr[7] + "|\n            |" + fArr[8] + ' ' + fArr[9] + ' ' + fArr[10] + ' ' + fArr[11] + "|\n            |" + fArr[12] + ' ' + fArr[13] + ' ' + fArr[14] + ' ' + fArr[15] + "|\n        ");
    }

    /* renamed from: translate-impl, reason: not valid java name */
    public static final void m4401translateimpl(float[] fArr, float f, float f7, float f9) {
        if (fArr.length < 16) {
            return;
        }
        float f10 = (fArr[8] * f9) + (fArr[4] * f7) + (fArr[0] * f) + fArr[12];
        float f11 = (fArr[9] * f9) + (fArr[5] * f7) + (fArr[1] * f) + fArr[13];
        float f12 = (fArr[10] * f9) + (fArr[6] * f7) + (fArr[2] * f) + fArr[14];
        float f13 = (fArr[11] * f9) + (fArr[7] * f7) + (fArr[3] * f) + fArr[15];
        fArr[12] = f10;
        fArr[13] = f11;
        fArr[14] = f12;
        fArr[15] = f13;
    }

    /* renamed from: translate-impl$default, reason: not valid java name */
    public static /* synthetic */ void m4402translateimpl$default(float[] fArr, float f, float f7, float f9, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f7 = 0.0f;
        }
        if ((i & 4) != 0) {
            f9 = 0.0f;
        }
        m4401translateimpl(fArr, f, f7, f9);
    }

    public boolean equals(Object other) {
        return m4381equalsimpl(this.values, other);
    }

    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return m4384hashCodeimpl(this.values);
    }

    public String toString() {
        return m4400toStringimpl(this.values);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m4403unboximpl() {
        return this.values;
    }

    /* renamed from: map-impl, reason: not valid java name */
    public static final void m4388mapimpl(float[] fArr, MutableRect mutableRect) {
        if (fArr.length < 16) {
            return;
        }
        float f = fArr[0];
        float f7 = fArr[1];
        float f9 = fArr[3];
        float f10 = fArr[4];
        float f11 = fArr[5];
        float f12 = fArr[7];
        float f13 = fArr[12];
        float f14 = fArr[13];
        float f15 = fArr[15];
        float left = mutableRect.getLeft();
        float top = mutableRect.getTop();
        float right = mutableRect.getRight();
        float bottom = mutableRect.getBottom();
        float f16 = f9 * left;
        float f17 = f12 * top;
        float f18 = 1.0f / ((f16 + f17) + f15);
        if ((Float.floatToRawIntBits(f18) & Integer.MAX_VALUE) >= 2139095040) {
            f18 = 0.0f;
        }
        float f19 = f * left;
        float f20 = f10 * top;
        float f21 = (f19 + f20 + f13) * f18;
        float f22 = left * f7;
        float f23 = top * f11;
        float f24 = (f22 + f23 + f14) * f18;
        float f25 = f12 * bottom;
        float f26 = 1.0f / ((f16 + f25) + f15);
        if ((Float.floatToRawIntBits(f26) & Integer.MAX_VALUE) >= 2139095040) {
            f26 = 0.0f;
        }
        float f27 = f10 * bottom;
        float f28 = (f19 + f27 + f13) * f26;
        float f29 = f11 * bottom;
        float f30 = (f22 + f29 + f14) * f26;
        float f31 = f9 * right;
        float f32 = 1.0f / ((f17 + f31) + f15);
        if ((Float.floatToRawIntBits(f32) & Integer.MAX_VALUE) >= 2139095040) {
            f32 = 0.0f;
        }
        float f33 = f * right;
        float f34 = (f33 + f20 + f13) * f32;
        float f35 = right * f7;
        float f36 = (f23 + f35 + f14) * f32;
        float f37 = 1.0f / ((f31 + f25) + f15);
        float f38 = (Float.floatToRawIntBits(f37) & Integer.MAX_VALUE) < 2139095040 ? f37 : 0.0f;
        float f39 = (f33 + f27 + f13) * f38;
        float f40 = (f35 + f29 + f14) * f38;
        mutableRect.setLeft(Math.min(f21, Math.min(f28, Math.min(f34, f39))));
        mutableRect.setTop(Math.min(f24, Math.min(f30, Math.min(f36, f40))));
        mutableRect.setRight(Math.max(f21, Math.max(f28, Math.max(f34, f39))));
        mutableRect.setBottom(Math.max(f24, Math.max(f30, Math.max(f36, f40))));
    }
}
