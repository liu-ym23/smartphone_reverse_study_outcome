package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.ui.unit.Density;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Inflection", "", "StartTension", "EndTension", DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "computeSplineInfo", "", "splinePositions", "", "splineTimes", "nbSamples", "", "splineBasedDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", ExifInterface.GPS_DIRECTION_TRUE, "density", "Landroidx/compose/ui/unit/Density;", GXTemplateKey.GAIAX_ANIMATION}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SplineBasedDecayKt {
    private static final float EndTension = 1.0f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final float StartTension = 0.5f;

    public static final <T> DecayAnimationSpec<T> splineBasedDecay(Density r100) {
        return DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(r100));
    }

    public static final /* synthetic */ void access$computeSplineInfo(float[] r100, float[] r101, int r102) {
        computeSplineInfo(r100, r101, r102);
    }

    private static final void computeSplineInfo(float[] r110, float[] r210, int r211) {
        float r100 = 0.0f;
        float r101 = 0.0f;
        int r102 = 0;
    L4:
        if (r102 >= r211) goto L21;
        float r103 = r102 / r211;
        float r104 = 1.0f;
    L6:
        float r105 = ((r104 - r100) / 2.0f) + r100;
        float r111 = 1.0f - r105;
        float r112 = (r105 * 3.0f) * r111;
        float r113 = (r105 * r105) * r105;
        float r114 = (((r111 * P1) + (r105 * P2)) * r112) + r113;
        if (Math.abs(r114 - r103) < 1.0E-5d) goto L12;
        if (r114 > r103) goto L10;
        r100 = r105;
        goto L6
    L10:
        r104 = r105;
        goto L6
    L12:
        float r106 = 0.5f;
        r110[r102] = (r112 * ((r111 * 0.5f) + r105)) + r113;
        float r107 = 1.0f;
    L13:
        float r108 = ((r107 - r101) / 2.0f) + r101;
        float r115 = 1.0f - r108;
        float r116 = (r108 * 3.0f) * r115;
        float r117 = (r108 * r108) * r108;
        float r118 = (((r115 * r106) + r108) * r116) + r117;
        if (Math.abs(r118 - r103) < 1.0E-5d) goto L20;
        if (r118 <= r103) goto L18;
        r107 = r108;
    L19:
        r106 = 0.5f;
        goto L13
    L18:
        r101 = r108;
        goto L19
    L20:
        r210[r102] = (r116 * ((r115 * P1) + (r108 * P2))) + r117;
        r102 = r102 + 1;
        goto L4
    L21:
        r210[r211] = 1.0f;
        r110[r211] = 1.0f;
    }
}
