package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"androidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "leftBound", "getLeftBound", "()Ljava/lang/Object;", "setLeftBound", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "rightBound", "getRightBound", "setRightBound", "distance", "", "getDistance", "()F", "setDistance", "(F)V", "dragTo", "", "newOffset", "lastKnownVelocity", "updateIfNeeded", "isMovingForward", "", "updateBounds", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnchoredDraggableState$anchoredDragScope$1 implements AnchoredDragScope {
    private float distance;
    private T leftBound;
    private T rightBound;
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    public final float getDistance() {
        return this.distance;
    }

    public final T getLeftBound() {
        return this.leftBound;
    }

    public final T getRightBound() {
        return this.rightBound;
    }

    public AnchoredDraggableState$anchoredDragScope$1(AnchoredDraggableState<T> r100) {
        this.this$0 = r100;
        this.distance = Float.NaN;
    }

    public final void setDistance(float r100) {
        this.distance = r100;
    }

    public final void setLeftBound(T r100) {
        this.leftBound = r100;
    }

    public final void setRightBound(T r100) {
        this.rightBound = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v15, types: [T, java.lang.Object] */
    public final void updateBounds(boolean r100) {
        float r101 = this.this$0.getAnchors().positionOf(this.this$0.getCurrentValue());
        if (this.this$0.getOffset() != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L17;
        float r103 = this.this$0.getOffset();
        if (r100 == false) goto L10;
        float r104 = 1.0f;
    L11:
        float r105 = r103 + r104;
        Object r106 = this.this$0.getAnchors().closestAnchor(r105, r100);
        T r107 = r106;
        if (r106 != null) goto L14;
        r107 = this.this$0.getCurrentValue();
    L14:
        if (r100 == false) goto L16;
        this.leftBound = this.this$0.getCurrentValue();
        this.rightBound = r107;
    L24:
        DraggableAnchors r108 = this.this$0.getAnchors();
        T r109 = this.leftBound;
        Intrinsics.checkNotNull(r109);
        float r110 = r108.positionOf(r109);
        DraggableAnchors r111 = this.this$0.getAnchors();
        T r112 = this.rightBound;
        Intrinsics.checkNotNull(r112);
        this.distance = Math.abs(r110 - r111.positionOf(r112));
        return;
    L16:
        this.leftBound = r107;
        this.rightBound = this.this$0.getCurrentValue();
        goto L24
    L10:
        r104 = -1.0f;
        goto L11
    L17:
        Object r113 = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset(), false);
        T r114 = r113;
        if (r113 != null) goto L20;
        r114 = this.this$0.getCurrentValue();
    L20:
        Object r115 = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset(), true);
        T r116 = r115;
        if (r115 != null) goto L23;
        r116 = this.this$0.getCurrentValue();
    L23:
        this.leftBound = r114;
        this.rightBound = r116;
        goto L24
    L5:
        r102 = false;
        goto L6
    }

    public final void updateIfNeeded(boolean r100) {
        updateBounds(r100);
        if (Math.abs(this.this$0.getOffset() - this.this$0.getAnchors().positionOf(this.this$0.getCurrentValue())) < (this.distance / 2.0f)) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L16;
        if (r100 == false) goto L9;
        Object r102 = this.rightBound;
    L10:
        if (r102 != null) goto L13;
        r102 = this.this$0.getCurrentValue();
    L13:
        if (((Boolean) this.this$0.getConfirmValueChange$foundation_release().invoke(r102)).booleanValue() == false) goto L17;
        AnchoredDraggableState.access$setCurrentValue(this.this$0, r102);
        return;
    L17:
        return;
    L9:
        r102 = this.leftBound;
        goto L10
    L16:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.compose.foundation.gestures.AnchoredDragScope
    public void dragTo(float r100, float r101) {
        float r102 = this.this$0.getOffset();
        AnchoredDraggableState.access$setOffset(this.this$0, r100);
        AnchoredDraggableState.access$setLastVelocity(this.this$0, r101);
        if (Float.isNaN(r102) == false) goto L6;
        return;
    L6:
        if (r100 < r102) goto L8;
        boolean r103 = true;
    L9:
        updateIfNeeded(r103);
        return;
    L8:
        r103 = false;
        goto L9
    }
}
