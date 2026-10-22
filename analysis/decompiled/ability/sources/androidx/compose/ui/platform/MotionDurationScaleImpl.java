package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.MotionDurationScale;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Landroidx/compose/ui/platform/MotionDurationScaleImpl;", "Landroidx/compose/ui/MotionDurationScale;", AppAgent.CONSTRUCT, "()V", "<set-?>", "", "scaleFactor", "getScaleFactor", "()F", "setScaleFactor", "(F)V", "scaleFactor$delegate", "Landroidx/compose/runtime/MutableFloatState;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class MotionDurationScaleImpl implements MotionDurationScale {

    /* renamed from: scaleFactor$delegate, reason: from kotlin metadata */
    private final MutableFloatState scaleFactor = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);

    @Override // androidx.compose.ui.MotionDurationScale, H7.h
    public <R> R fold(R r5, S7.n nVar) {
        return (R) MotionDurationScale.DefaultImpls.fold(this, r5, nVar);
    }

    @Override // androidx.compose.ui.MotionDurationScale, H7.h
    public <E extends H7.f> E get(H7.g gVar) {
        return (E) MotionDurationScale.DefaultImpls.get(this, gVar);
    }

    @Override // androidx.compose.ui.MotionDurationScale
    public float getScaleFactor() {
        return this.scaleFactor.getFloatValue();
    }

    @Override // androidx.compose.ui.MotionDurationScale, H7.h
    public H7.h minusKey(H7.g gVar) {
        return MotionDurationScale.DefaultImpls.minusKey(this, gVar);
    }

    @Override // androidx.compose.ui.MotionDurationScale, H7.h
    public H7.h plus(H7.h hVar) {
        return MotionDurationScale.DefaultImpls.plus(this, hVar);
    }

    public void setScaleFactor(float f) {
        this.scaleFactor.setFloatValue(f);
    }
}
