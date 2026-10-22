package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\f\u0010\u0019\u001a\u00020\u000b*\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Landroidx/compose/ui/layout/OnFirstVisibleElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/OnFirstVisibleNode;", "minDurationMs", "", "minFractionVisible", "", "viewportBounds", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "callback", "Lkotlin/Function0;", "", "<init>", "(JFLandroidx/compose/ui/layout/LayoutBoundsHolder;Lkotlin/jvm/functions/Function0;)V", "getMinDurationMs", "()J", "getMinFractionVisible", "()F", "getViewportBounds", "()Landroidx/compose/ui/layout/LayoutBoundsHolder;", "getCallback", "()Lkotlin/jvm/functions/Function0;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OnFirstVisibleElement extends ModifierNodeElement<OnFirstVisibleNode> {
    private final Function0<Unit> callback;
    private final long minDurationMs;
    private final float minFractionVisible;
    private final LayoutBoundsHolder viewportBounds;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public OnFirstVisibleNode create() {
        return new OnFirstVisibleNode(this.minDurationMs, this.minFractionVisible, this.viewportBounds, this.callback);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        long r100 = this.minDurationMs;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + Float.floatToIntBits(this.minFractionVisible)) * 31;
        LayoutBoundsHolder r102 = this.viewportBounds;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return ((r101 + r103) * 31) + this.callback.hashCode();
    L5:
        r103 = 0;
        goto L7
    }

    public final Function0<Unit> getCallback() {
        return this.callback;
    }

    public final long getMinDurationMs() {
        return this.minDurationMs;
    }

    public final float getMinFractionVisible() {
        return this.minFractionVisible;
    }

    public final LayoutBoundsHolder getViewportBounds() {
        return this.viewportBounds;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ Modifier.Node create() {
        return create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L26:
        return false;
    L8:
        if (OnFirstVisibleElement.class != r100.getClass()) goto L26;
        OnFirstVisibleElement r101 = (OnFirstVisibleElement) r100;
        if (this.minDurationMs == r101.minDurationMs) goto L14;
        return false;
    L14:
        if (this.minFractionVisible != r101.minFractionVisible) goto L16;
        boolean r102 = true;
    L17:
        if (r102 == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.viewportBounds, r101.viewportBounds) == true) goto L23;
        return false;
    L23:
        if (this.callback == r101.callback) goto L25;
        return false;
    L25:
        return true;
    L16:
        r102 = false;
        goto L17
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName("onFirstVisible");
        r100.getProperties().set("minDurationMs", Long.valueOf(this.minDurationMs));
        r100.getProperties().set("minFractionVisible", Float.valueOf(this.minFractionVisible));
        r100.getProperties().set("viewportBounds", this.viewportBounds);
        r100.getProperties().set("callback", this.callback);
    }

    public void update(OnFirstVisibleNode r100) {
        r100.setMinDurationMs(this.minDurationMs);
        r100.setMinFractionVisible(this.minFractionVisible);
        r100.setCallback(this.callback);
        r100.setViewportBounds(this.viewportBounds);
        r100.forceUpdate();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((OnFirstVisibleNode) r100);
    }

    public OnFirstVisibleElement(long r100, float r101, LayoutBoundsHolder r102, Function0<Unit> r103) {
        this.minDurationMs = r100;
        this.minFractionVisible = r101;
        this.viewportBounds = r102;
        this.callback = r103;
    }
}
