package androidx.compose.ui.platform;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"invertTo", "", "Landroidx/compose/ui/graphics/Matrix;", "other", "invertTo-JiSxe2E", "([F[F)Z", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InvertMatrixKt {
    /* renamed from: invertTo-JiSxe2E, reason: not valid java name */
    public static final boolean m6018invertToJiSxe2E(float[] fArr, float[] fArr2) {
        if (fArr.length < 16 || fArr2.length < 16) {
            return false;
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
        if (f35 != 0.0f) {
            float f36 = 1.0f / f35;
            fArr2[0] = androidx.appfunctions.metadata.a.a(f14, f32, (f12 * f34) - (f13 * f33), f36);
            fArr2[1] = androidx.compose.foundation.b.a(f10, f32, (f9 * f33) + ((-f7) * f34), f36);
            fArr2[2] = androidx.appfunctions.metadata.a.a(f22, f26, (f20 * f28) - (f21 * f27), f36);
            fArr2[3] = androidx.compose.foundation.b.a(f18, f26, (f17 * f27) + ((-f16) * f28), f36);
            float f37 = -f11;
            fArr2[4] = androidx.compose.foundation.b.a(f14, f30, (f13 * f31) + (f37 * f34), f36);
            fArr2[5] = androidx.appfunctions.metadata.a.a(f10, f30, (f34 * f) - (f9 * f31), f36);
            float f38 = -f19;
            fArr2[6] = androidx.compose.foundation.b.a(f22, f24, (f21 * f25) + (f38 * f28), f36);
            fArr2[7] = androidx.appfunctions.metadata.a.a(f18, f24, (f15 * f28) - (f17 * f25), f36);
            fArr2[8] = androidx.appfunctions.metadata.a.a(f14, f29, (f11 * f33) - (f12 * f31), f36);
            fArr2[9] = androidx.compose.foundation.b.a(f10, f29, (f31 * f7) + ((-f) * f33), f36);
            fArr2[10] = androidx.appfunctions.metadata.a.a(f22, f23, (f19 * f27) - (f20 * f25), f36);
            fArr2[11] = androidx.compose.foundation.b.a(f18, f23, (f25 * f16) + ((-f15) * f27), f36);
            fArr2[12] = androidx.compose.foundation.b.a(f13, f29, (f12 * f30) + (f37 * f32), f36);
            fArr2[13] = androidx.appfunctions.metadata.a.a(f9, f29, (f * f32) - (f7 * f30), f36);
            fArr2[14] = androidx.compose.foundation.b.a(f21, f23, (f20 * f24) + (f38 * f26), f36);
            fArr2[15] = androidx.appfunctions.metadata.a.a(f17, f23, (f15 * f26) - (f16 * f24), f36);
        }
        return !(f35 == 0.0f);
    }
}
