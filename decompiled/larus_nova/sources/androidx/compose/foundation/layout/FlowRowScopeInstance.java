package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0097\u0001J\u0015\u0010\f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0097\u0001J!\u0010\f\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0097\u0001J\r\u0010\u0013\u001a\u00020\u0006*\u00020\u0006H\u0097\u0001J\u001f\u0010\u0014\u001a\u00020\u0006*\u00020\u00062\b\b\u0001\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0097\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/layout/FlowRowScopeInstance;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/foundation/layout/FlowRowScope;", "<init>", "()V", "fillMaxRowHeight", "Landroidx/compose/ui/Modifier;", "fraction", "", "align", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "alignBy", "alignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignByBaseline", "weight", LynxVideoManagerLite.FILL, "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FlowRowScopeInstance implements RowScope, FlowRowScope {
    public static final int $stable = 0;
    public static final FlowRowScopeInstance INSTANCE = null;
    private final /* synthetic */ RowScopeInstance $$delegate_0;

    static {
        INSTANCE = new FlowRowScopeInstance();
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

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier weight(Modifier r100, float r101, boolean r102) {
        return this.$$delegate_0.weight(r100, r101, r102);
    }

    private FlowRowScopeInstance() {
        this.$$delegate_0 = RowScopeInstance.INSTANCE;
    }

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public Modifier fillMaxRowHeight(Modifier r100, float r101) {
        if (r101 >= 0.0f) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L11;
        InlineClassHelperKt.throwIllegalArgumentException("invalid fraction " + r101 + "; must be >= 0 and <= 1.0");
    L11:
        return r100.then(new FillCrossAxisSizeElement(r101));
    L5:
        if (r101 > 1.0f) goto L7;
        r102 = true;
        goto L8
    }
}
