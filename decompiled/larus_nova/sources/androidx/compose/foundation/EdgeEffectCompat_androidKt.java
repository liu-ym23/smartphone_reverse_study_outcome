package androidx.compose.foundation;

import android.view.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Inflection", "", "PlatformFlingScrollFriction", "GravityEarth", "InchesPerMeter", "DecelerationRate", "", "DecelMinusOne", "flingDistance", "density", "Landroidx/compose/ui/unit/Density;", "velocity", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EdgeEffectCompat_androidKt {
    private static final double DecelMinusOne = 0.0d;
    private static final double DecelerationRate = 0.0d;
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.37f;
    private static final float Inflection = 0.35f;
    private static final float PlatformFlingScrollFriction = 0.0f;

    static {
        PlatformFlingScrollFriction = ViewConfiguration.getScrollFriction();
        double r100 = Math.log(0.78d) / Math.log(0.9d);
        DecelerationRate = r100;
        DecelMinusOne = r100 - 1.0d;
    }

    public static final /* synthetic */ float access$flingDistance(Density r100, float r101) {
        return flingDistance(r100, r101);
    }

    private static final float flingDistance(Density r100, float r101) {
        double r102 = ((r100.getDensity() * 386.0878f) * 160.0f) * 0.84f;
        double r103 = Math.abs(r101) * Inflection;
        float r104 = PlatformFlingScrollFriction;
        return (float) ((((double) r104) * r102) * Math.exp((DecelerationRate / DecelMinusOne) * Math.log(r103 / (((double) r104) * r102))));
    }
}
