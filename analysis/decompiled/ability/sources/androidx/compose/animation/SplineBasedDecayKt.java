package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.ui.unit.Density;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a'\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\"\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010\"\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010\"\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010\"\u0014\u0010\u0014\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"", "splinePositions", "splineTimes", "", "nbSamples", "LC7/r;", "computeSplineInfo", "([F[FI)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/animation/core/DecayAnimationSpec;", "splineBasedDecay", "(Landroidx/compose/ui/unit/Density;)Landroidx/compose/animation/core/DecayAnimationSpec;", "", "Inflection", "F", "StartTension", "EndTension", "P1", "P2", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SplineBasedDecayKt {
    private static final float EndTension = 1.0f;
    private static final float Inflection = 0.35f;

    /* renamed from: P1, reason: collision with root package name */
    private static final float f1705P1 = 0.175f;

    /* renamed from: P2, reason: collision with root package name */
    private static final float f1706P2 = 0.35000002f;
    private static final float StartTension = 0.5f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void computeSplineInfo(float[] fArr, float[] fArr2, int i) {
        float f;
        float f7;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16 = 0.0f;
        int i6 = 0;
        float f17 = 0.0f;
        while (true) {
            float f18 = 1.0f;
            if (i6 >= i) {
                fArr2[i] = 1.0f;
                fArr[i] = 1.0f;
                return;
            }
            float f19 = i6 / i;
            float f20 = 1.0f;
            while (true) {
                f = ((f20 - f16) / 2.0f) + f16;
                f7 = f18 - f;
                f9 = f * 3.0f * f7;
                f10 = f * f * f;
                float fA = androidx.appfunctions.metadata.a.a(f, f1706P2, f7 * f1705P1, f9) + f10;
                f11 = f18;
                if (Math.abs(fA - f19) < 1.0E-5d) {
                    break;
                }
                if (fA > f19) {
                    f20 = f;
                } else {
                    f16 = f;
                }
                f18 = f11;
            }
            float f21 = 0.5f;
            fArr[i6] = (((f7 * 0.5f) + f) * f9) + f10;
            float f22 = f11;
            while (true) {
                f12 = ((f22 - f17) / 2.0f) + f17;
                f13 = f11 - f12;
                f14 = f12 * 3.0f * f13;
                f15 = f12 * f12 * f12;
                float fA2 = androidx.appfunctions.metadata.a.a(f13, f21, f12, f14) + f15;
                float f23 = f19;
                if (Math.abs(fA2 - f19) >= 1.0E-5d) {
                    if (fA2 > f23) {
                        f22 = f12;
                    } else {
                        f17 = f12;
                    }
                    f19 = f23;
                    f21 = 0.5f;
                }
            }
            fArr2[i6] = (((f12 * f1706P2) + (f13 * f1705P1)) * f14) + f15;
            i6++;
        }
    }

    public static final <T> DecayAnimationSpec<T> splineBasedDecay(Density density) {
        return DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(density));
    }
}
