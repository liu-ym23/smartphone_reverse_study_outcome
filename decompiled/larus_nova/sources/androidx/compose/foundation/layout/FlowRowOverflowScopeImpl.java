package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0097\u0001J\u0015\u0010\u0014\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0097\u0001J!\u0010\u0014\u001a\u00020\u0011*\u00020\u00112\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u0018H\u0097\u0001J\r\u0010\u001a\u001a\u00020\u0011*\u00020\u0011H\u0097\u0001J\u0017\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\b\b\u0001\u0010\u001c\u001a\u00020\u001dH\u0097\u0001J\u001f\u0010\u001e\u001a\u00020\u0011*\u00020\u00112\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0097\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\n¨\u0006!"}, d2 = {"Landroidx/compose/foundation/layout/FlowRowOverflowScopeImpl;", "Landroidx/compose/foundation/layout/FlowRowScope;", "Landroidx/compose/foundation/layout/FlowRowOverflowScope;", "state", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflowState;)V", "totalItemCount", "", "getTotalItemCount", "()I", "totalItemCount$delegate", "Lkotlin/Lazy;", "shownItemCount", "getShownItemCount", "shownItemCount$delegate", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "alignBy", "alignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "alignByBaseline", "fillMaxRowHeight", "fraction", "", "weight", LynxVideoManagerLite.FILL, "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FlowRowOverflowScopeImpl implements FlowRowScope, FlowRowOverflowScope {
    public static final int $stable = 0;
    private final /* synthetic */ FlowRowScopeInstance $$delegate_0;
    private final Lazy shownItemCount$delegate;
    private final FlowLayoutOverflowState state;
    private final Lazy totalItemCount$delegate;

    public static /* synthetic */ int a(FlowRowOverflowScopeImpl r100) {
        return totalItemCount_delegate$lambda$0(r100);
    }

    public static /* synthetic */ int b(FlowRowOverflowScopeImpl r100) {
        return shownItemCount_delegate$lambda$1(r100);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier align(Modifier r100, Alignment.Vertical r101) {
        return this.$$delegate_0.align(r100, r101);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignBy(Modifier r100, HorizontalAlignmentLine r101) {
        return this.$$delegate_0.alignBy(r100, r101);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignBy(Modifier r100, Function1<? super Measured, Integer> r101) {
        return this.$$delegate_0.alignBy(r100, r101);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignByBaseline(Modifier r100) {
        return this.$$delegate_0.alignByBaseline(r100);
    }

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public Modifier fillMaxRowHeight(Modifier r100, float r101) {
        return this.$$delegate_0.fillMaxRowHeight(r100, r101);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier weight(Modifier r100, float r101, boolean r102) {
        return this.$$delegate_0.weight(r100, r101, r102);
    }

    @Override // androidx.compose.foundation.layout.FlowRowOverflowScope
    public int getShownItemCount() {
        return ((Number) this.shownItemCount$delegate.getValue()).intValue();
    }

    @Override // androidx.compose.foundation.layout.FlowRowOverflowScope
    public int getTotalItemCount() {
        return ((Number) this.totalItemCount$delegate.getValue()).intValue();
    }

    public FlowRowOverflowScopeImpl(FlowLayoutOverflowState r100) {
        this.$$delegate_0 = FlowRowScopeInstance.INSTANCE;
        this.state = r100;
        this.totalItemCount$delegate = FlowLayoutOverflowKt.lazyInt$default(null, new d1(this), 1, null);
        this.shownItemCount$delegate = FlowLayoutOverflowKt.lazyInt(r100.getShownItemLazyErrorMessage$foundation_layout(), new e1(this));
    }

    private static final int shownItemCount_delegate$lambda$1(FlowRowOverflowScopeImpl r100) {
        return r100.state.getItemShown$foundation_layout();
    }

    private static final int totalItemCount_delegate$lambda$0(FlowRowOverflowScopeImpl r100) {
        return r100.state.getItemCount$foundation_layout();
    }
}
