package androidx.compose.ui.scrollcapture;

import H7.f;
import H7.g;
import H7.h;
import S7.n;
import androidx.compose.ui.MotionDurationScale;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/scrollcapture/DisableAnimationMotionDurationScale;", "Landroidx/compose/ui/MotionDurationScale;", AppAgent.CONSTRUCT, "()V", "scaleFactor", "", "getScaleFactor", "()F", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class DisableAnimationMotionDurationScale implements MotionDurationScale {
    public static final DisableAnimationMotionDurationScale INSTANCE = new DisableAnimationMotionDurationScale();

    private DisableAnimationMotionDurationScale() {
    }

    @Override // androidx.compose.ui.MotionDurationScale, H7.h
    public <R> R fold(R r5, n nVar) {
        return (R) MotionDurationScale.DefaultImpls.fold(this, r5, nVar);
    }

    @Override // androidx.compose.ui.MotionDurationScale, H7.h
    public <E extends f> E get(g gVar) {
        return (E) MotionDurationScale.DefaultImpls.get(this, gVar);
    }

    @Override // androidx.compose.ui.MotionDurationScale
    public float getScaleFactor() {
        return 0.0f;
    }

    @Override // androidx.compose.ui.MotionDurationScale, H7.h
    public h minusKey(g gVar) {
        return MotionDurationScale.DefaultImpls.minusKey(this, gVar);
    }

    @Override // androidx.compose.ui.MotionDurationScale, H7.h
    public h plus(h hVar) {
        return MotionDurationScale.DefaultImpls.plus(this, hVar);
    }
}
