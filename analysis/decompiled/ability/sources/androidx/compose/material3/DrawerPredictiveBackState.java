package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Stable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0003R+\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010\"\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001d¨\u0006#"}, d2 = {"Landroidx/compose/material3/DrawerPredictiveBackState;", "", AppAgent.CONSTRUCT, "()V", "", "progress", "", "swipeEdgeLeft", "isRtl", "maxScaleXDistanceGrow", "maxScaleXDistanceShrink", "maxScaleYDistance", "LC7/r;", "update", "(FZZFFF)V", "clear", "<set-?>", "swipeEdgeMatchesDrawer$delegate", "Landroidx/compose/runtime/MutableState;", "getSwipeEdgeMatchesDrawer", "()Z", "setSwipeEdgeMatchesDrawer", "(Z)V", "swipeEdgeMatchesDrawer", "scaleXDistance$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getScaleXDistance", "()F", "setScaleXDistance", "(F)V", "scaleXDistance", "scaleYDistance$delegate", "getScaleYDistance", "setScaleYDistance", "scaleYDistance", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawerPredictiveBackState {
    public static final int $stable = 0;

    /* renamed from: swipeEdgeMatchesDrawer$delegate, reason: from kotlin metadata */
    private final MutableState swipeEdgeMatchesDrawer = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);

    /* renamed from: scaleXDistance$delegate, reason: from kotlin metadata */
    private final MutableFloatState scaleXDistance = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);

    /* renamed from: scaleYDistance$delegate, reason: from kotlin metadata */
    private final MutableFloatState scaleYDistance = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);

    public final void clear() {
        setSwipeEdgeMatchesDrawer(true);
        setScaleXDistance(0.0f);
        setScaleYDistance(0.0f);
    }

    public final float getScaleXDistance() {
        return this.scaleXDistance.getFloatValue();
    }

    public final float getScaleYDistance() {
        return this.scaleYDistance.getFloatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getSwipeEdgeMatchesDrawer() {
        return ((Boolean) this.swipeEdgeMatchesDrawer.getValue()).booleanValue();
    }

    public final void setScaleXDistance(float f) {
        this.scaleXDistance.setFloatValue(f);
    }

    public final void setScaleYDistance(float f) {
        this.scaleYDistance.setFloatValue(f);
    }

    public final void setSwipeEdgeMatchesDrawer(boolean z10) {
        this.swipeEdgeMatchesDrawer.setValue(Boolean.valueOf(z10));
    }

    public final void update(float progress, boolean swipeEdgeLeft, boolean isRtl, float maxScaleXDistanceGrow, float maxScaleXDistanceShrink, float maxScaleYDistance) {
        setSwipeEdgeMatchesDrawer(swipeEdgeLeft != isRtl);
        if (!getSwipeEdgeMatchesDrawer()) {
            maxScaleXDistanceGrow = maxScaleXDistanceShrink;
        }
        setScaleXDistance(MathHelpersKt.lerp(0.0f, maxScaleXDistanceGrow, progress));
        setScaleYDistance(MathHelpersKt.lerp(0.0f, maxScaleYDistance, progress));
    }
}
