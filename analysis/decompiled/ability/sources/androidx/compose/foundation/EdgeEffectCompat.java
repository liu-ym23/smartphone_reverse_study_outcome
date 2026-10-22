package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\t*\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0018\u001a\u00020\t*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/EdgeEffectCompat;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "Landroid/widget/EdgeEffect;", "create", "(Landroid/content/Context;)Landroid/widget/EdgeEffect;", "", "deltaDistance", "displacement", "onPullDistanceCompat", "(Landroid/widget/EdgeEffect;FF)F", "", "velocity", "LC7/r;", "onAbsorbCompat", "(Landroid/widget/EdgeEffect;I)V", "delta", "onReleaseWithOppositeDelta", "(Landroid/widget/EdgeEffect;F)V", "getDistanceCompat", "(Landroid/widget/EdgeEffect;)F", "distanceCompat", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    public static final int $stable = 0;
    public static final EdgeEffectCompat INSTANCE = new EdgeEffectCompat();

    private EdgeEffectCompat() {
    }

    public final EdgeEffect create(Context context) {
        return Api31Impl.INSTANCE.create(context, null);
    }

    public final float getDistanceCompat(EdgeEffect edgeEffect) {
        return Api31Impl.INSTANCE.getDistance(edgeEffect);
    }

    public final void onAbsorbCompat(EdgeEffect edgeEffect, int i) {
        edgeEffect.onAbsorb(i);
    }

    public final float onPullDistanceCompat(EdgeEffect edgeEffect, float f, float f7) {
        return Api31Impl.INSTANCE.onPullDistance(edgeEffect, f, f7);
    }

    public final void onReleaseWithOppositeDelta(EdgeEffect edgeEffect, float f) {
        if (edgeEffect instanceof GlowEdgeEffectCompat) {
            ((GlowEdgeEffectCompat) edgeEffect).releaseWithOppositeDelta(f);
        } else {
            edgeEffect.onRelease();
        }
    }
}
