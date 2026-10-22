package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.ui.unit.Density;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0012\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u00020\t*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\r*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tR\u0015\u0010\u0016\u001a\u00020\t*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/EdgeEffectCompat;", "", "<init>", "()V", "create", "Landroid/widget/EdgeEffect;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onPullDistanceCompat", "", "deltaDistance", "displacement", "onAbsorbCompat", "", "velocity", "", "absorbToRelaxIfNeeded", "edgeEffectLength", "density", "Landroidx/compose/ui/unit/Density;", "onReleaseWithOppositeDelta", "delta", "distanceCompat", "getDistanceCompat", "(Landroid/widget/EdgeEffect;)F", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EdgeEffectCompat {
    public static final int $stable = 0;
    public static final EdgeEffectCompat INSTANCE = null;

    static {
        INSTANCE = new EdgeEffectCompat();
    }

    private EdgeEffectCompat() {
    }

    public final EdgeEffect create(Context r100) {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        return Api31Impl.INSTANCE.create(r100, null);
    L6:
        return new GlowEdgeEffectCompat(r100);
    }

    public final float getDistanceCompat(EdgeEffect r100) {
        if (Build.VERSION.SDK_INT >= 31) goto L7;
        return 0.0f;
    L7:
        return Api31Impl.INSTANCE.getDistance(r100);
    }

    public final void onAbsorbCompat(EdgeEffect r100, int r101) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        r100.onAbsorb(r101);
        return;
    L7:
        if (r100.isFinished() == false) goto L10;
        r100.onAbsorb(r101);
        return;
    }

    public final void onReleaseWithOppositeDelta(EdgeEffect r100, float r101) {
        if ((r100 instanceof GlowEdgeEffectCompat) == false) goto L5;
        ((GlowEdgeEffectCompat) r100).releaseWithOppositeDelta(r101);
        return;
    L5:
        r100.onRelease();
    }

    public final float onPullDistanceCompat(EdgeEffect r100, float r101, float r102) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        r100.onPull(r101, r102);
        return r101;
    L5:
        return Api31Impl.INSTANCE.onPullDistance(r100, r101, r102);
    }

    public final float absorbToRelaxIfNeeded(EdgeEffect r100, float r101, float r102, Density r103) {
        if (EdgeEffectCompat_androidKt.access$flingDistance(r103, r101) > (getDistanceCompat(r100) * r102)) goto L5;
        onAbsorbCompat(r100, MathKt.roundToInt(r101));
        return r101;
    L5:
        return 0.0f;
    }
}
