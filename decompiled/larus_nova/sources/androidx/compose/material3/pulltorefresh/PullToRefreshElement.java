package androidx.compose.material3.pulltorefresh;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\f\u0010\u001b\u001a\u00020\u0007*\u00020\u001cH\u0016J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/pulltorefresh/PullToRefreshModifierNode;", "isRefreshing", "", com.alipay.sdk.m.x.d.f25926p, "Lkotlin/Function0;", "", "enabled", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "threshold", "Landroidx/compose/ui/unit/Dp;", "<init>", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "getOnRefresh", "()Lkotlin/jvm/functions/Function0;", "getEnabled", "getState", "()Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "getThreshold-D9Ej5fM", "()F", FaceService.girlLabel, "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PullToRefreshElement extends ModifierNodeElement<PullToRefreshModifierNode> {
    public static final int $stable = 0;
    private final boolean enabled;
    private final boolean isRefreshing;
    private final Function0<Unit> onRefresh;
    private final PullToRefreshState state;
    private final float threshold;

    public /* synthetic */ PullToRefreshElement(boolean r100, Function0 r101, boolean r102, PullToRefreshState r103, float r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public PullToRefreshModifierNode create() {
        return new PullToRefreshModifierNode(this.isRefreshing, this.onRefresh, this.enabled, this.state, this.threshold, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = 1231;
        if (this.isRefreshing == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enabled == true) goto L11;
        r100 = 1237;
    L11:
        return ((((((r102 + r100) * 31) + this.onRefresh.hashCode()) * 31) + this.state.hashCode()) * 31) + Dp.m7550hashCodeimpl(this.threshold);
    L5:
        r101 = 1237;
        goto L6
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function0<Unit> getOnRefresh() {
        return this.onRefresh;
    }

    public final PullToRefreshState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: getThreshold-D9Ej5fM, reason: not valid java name */
    public final float m3241getThresholdD9Ej5fM() {
        return this.threshold;
    }

    public final boolean isRefreshing() {
        return this.isRefreshing;
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
        if ((r100 instanceof PullToRefreshElement) == true) goto L8;
        return false;
    L8:
        PullToRefreshElement r101 = (PullToRefreshElement) r100;
        if (this.isRefreshing == r101.isRefreshing) goto L12;
        return false;
    L12:
        if (this.enabled == r101.enabled) goto L15;
        return false;
    L15:
        if (this.onRefresh == r101.onRefresh) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.state, r101.state) == true) goto L21;
        return false;
    L21:
        if (Dp.m7549equalsimpl0(this.threshold, r101.threshold) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName("PullToRefreshModifierNode");
        r100.getProperties().set("isRefreshing", Boolean.valueOf(this.isRefreshing));
        r100.getProperties().set(com.alipay.sdk.m.x.d.f25926p, this.onRefresh);
        r100.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r100.getProperties().set("state", this.state);
        r100.getProperties().set("threshold", Dp.m7542boximpl(this.threshold));
    }

    public void update(PullToRefreshModifierNode r100) {
        r100.setOnRefresh(this.onRefresh);
        r100.setEnabled(this.enabled);
        r100.setState(this.state);
        r100.m3250setThreshold0680j_4(this.threshold);
        boolean r101 = r100.isRefreshing();
        boolean r102 = this.isRefreshing;
        if (r101 == r102) goto L6;
        r100.setRefreshing(r102);
        r100.update();
        return;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((PullToRefreshModifierNode) r100);
    }

    private PullToRefreshElement(boolean r100, Function0<Unit> r101, boolean r102, PullToRefreshState r103, float r104) {
        this.isRefreshing = r100;
        this.onRefresh = r101;
        this.enabled = r102;
        this.state = r103;
        this.threshold = r104;
    }
}
