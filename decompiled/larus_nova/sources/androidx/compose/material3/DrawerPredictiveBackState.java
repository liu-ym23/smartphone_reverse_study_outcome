package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rJ\u0006\u0010!\u001a\u00020\u001aR+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012¨\u0006\""}, d2 = {"Landroidx/compose/material3/DrawerPredictiveBackState;", "", "<init>", "()V", "<set-?>", "", "swipeEdgeMatchesDrawer", "getSwipeEdgeMatchesDrawer", "()Z", "setSwipeEdgeMatchesDrawer", "(Z)V", "swipeEdgeMatchesDrawer$delegate", "Landroidx/compose/runtime/MutableState;", "", "scaleXDistance", "getScaleXDistance", "()F", "setScaleXDistance", "(F)V", "scaleXDistance$delegate", "Landroidx/compose/runtime/MutableFloatState;", "scaleYDistance", "getScaleYDistance", "setScaleYDistance", "scaleYDistance$delegate", "update", "", "progress", "swipeEdgeLeft", "isRtl", "maxScaleXDistanceGrow", "maxScaleXDistanceShrink", "maxScaleYDistance", "clear", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DrawerPredictiveBackState {
    public static final int $stable = 0;
    private final MutableFloatState scaleXDistance$delegate;
    private final MutableFloatState scaleYDistance$delegate;
    private final MutableState swipeEdgeMatchesDrawer$delegate;

    public final void clear() {
        setSwipeEdgeMatchesDrawer(true);
        setScaleXDistance(0.0f);
        setScaleYDistance(0.0f);
    }

    public final float getScaleXDistance() {
        return this.scaleXDistance$delegate.getFloatValue();
    }

    public final float getScaleYDistance() {
        return this.scaleYDistance$delegate.getFloatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getSwipeEdgeMatchesDrawer() {
        return ((Boolean) this.swipeEdgeMatchesDrawer$delegate.getValue()).booleanValue();
    }

    public DrawerPredictiveBackState() {
        this.swipeEdgeMatchesDrawer$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.scaleXDistance$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.scaleYDistance$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    }

    public final void setScaleXDistance(float r100) {
        this.scaleXDistance$delegate.setFloatValue(r100);
    }

    public final void setScaleYDistance(float r100) {
        this.scaleYDistance$delegate.setFloatValue(r100);
    }

    public final void setSwipeEdgeMatchesDrawer(boolean r100) {
        this.swipeEdgeMatchesDrawer$delegate.setValue(Boolean.valueOf(r100));
    }

    public final void update(float r100, boolean r101, boolean r102, float r103, float r104, float r105) {
        if (r101 == r102) goto L4;
        boolean r106 = true;
    L5:
        setSwipeEdgeMatchesDrawer(r106);
        if (getSwipeEdgeMatchesDrawer() == true) goto L9;
        r103 = r104;
    L9:
        setScaleXDistance(MathHelpersKt.lerp(0.0f, r103, r100));
        setScaleYDistance(MathHelpersKt.lerp(0.0f, r105, r100));
        return;
    L4:
        r106 = false;
        goto L5
    }
}
