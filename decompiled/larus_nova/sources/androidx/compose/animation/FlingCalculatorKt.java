package androidx.compose.animation;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"GravityEarth", "", "InchesPerMeter", "DecelerationRate", "computeDeceleration", "friction", "density", GXTemplateKey.GAIAX_ANIMATION}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FlingCalculatorKt {
    private static final float DecelerationRate = 0.0f;
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.37f;

    private static final float computeDeceleration(float r100, float r101) {
        return ((r101 * 386.0878f) * 160.0f) * r100;
    }

    static {
        DecelerationRate = (float) (Math.log(0.78d) / Math.log(0.9d));
    }

    public static final /* synthetic */ float access$getDecelerationRate$p() {
        return DecelerationRate;
    }

    public static final /* synthetic */ float access$computeDeceleration(float r100, float r101) {
        return computeDeceleration(r100, r101);
    }
}
