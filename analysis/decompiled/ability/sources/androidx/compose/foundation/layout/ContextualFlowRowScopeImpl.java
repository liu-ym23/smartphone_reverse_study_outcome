package androidx.compose.foundation.layout;

import S7.k;
import androidx.annotation.FloatRange;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0097\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\u0013\u001a\u00020\u000b*\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0010H\u0097\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0013\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0097\u0001¢\u0006\u0004\b\u0013\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u000b*\u00020\u000bH\u0097\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001c\u001a\u00020\u000b*\u00020\u000b2\b\b\u0003\u0010\u001b\u001a\u00020\u001aH\u0097\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\u001e\u001a\u00020\u000b*\u00020\u000b2\b\b\u0001\u0010\u001e\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001fH\u0097\u0001¢\u0006\u0004\b\u001e\u0010!R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\u0005\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b%\u0010$R \u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(R \u0010\b\u001a\u00020\u00068\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b)\u0010(\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/foundation/layout/ContextualFlowRowScopeImpl;", "Landroidx/compose/foundation/layout/FlowRowScope;", "Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "", "lineIndex", "indexInLine", "Landroidx/compose/ui/unit/Dp;", "maxWidthInLine", "maxHeight", AppAgent.CONSTRUCT, "(IIFFLkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/Alignment$Vertical;", "alignment", "align", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "alignmentLineBlock", "alignBy", "(Landroidx/compose/ui/Modifier;LS7/k;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignmentLine", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/HorizontalAlignmentLine;)Landroidx/compose/ui/Modifier;", "alignByBaseline", "(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "", "fraction", "fillMaxRowHeight", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "weight", "", "fill", "(Landroidx/compose/ui/Modifier;FZ)Landroidx/compose/ui/Modifier;", "I", "getLineIndex", "()I", "getIndexInLine", "F", "getMaxWidthInLine-D9Ej5fM", "()F", "getMaxHeight-D9Ej5fM", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextualFlowRowScopeImpl implements FlowRowScope, ContextualFlowRowScope {
    public static final int $stable = 0;
    private final /* synthetic */ FlowRowScopeInstance $$delegate_0;
    private final int indexInLine;
    private final int lineIndex;
    private final float maxHeight;
    private final float maxWidthInLine;

    public /* synthetic */ ContextualFlowRowScopeImpl(int i, int i6, float f, float f7, e eVar) {
        this(i, i6, f, f7);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    public Modifier align(Modifier modifier, Alignment.Vertical vertical) {
        return this.$$delegate_0.align(modifier, vertical);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    public Modifier alignBy(Modifier modifier, k kVar) {
        return this.$$delegate_0.alignBy(modifier, kVar);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    public Modifier alignByBaseline(Modifier modifier) {
        return this.$$delegate_0.alignByBaseline(modifier);
    }

    @Override // androidx.compose.foundation.layout.FlowRowScope
    @ExperimentalLayoutApi
    public Modifier fillMaxRowHeight(Modifier modifier, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return this.$$delegate_0.fillMaxRowHeight(modifier, f);
    }

    @Override // androidx.compose.foundation.layout.ContextualFlowRowScope
    public int getIndexInLine() {
        return this.indexInLine;
    }

    @Override // androidx.compose.foundation.layout.ContextualFlowRowScope
    public int getLineIndex() {
        return this.lineIndex;
    }

    @Override // androidx.compose.foundation.layout.ContextualFlowRowScope
    /* renamed from: getMaxHeight-D9Ej5fM, reason: from getter */
    public float getMaxHeight() {
        return this.maxHeight;
    }

    @Override // androidx.compose.foundation.layout.ContextualFlowRowScope
    /* renamed from: getMaxWidthInLine-D9Ej5fM, reason: from getter */
    public float getMaxWidthInLine() {
        return this.maxWidthInLine;
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    public Modifier weight(Modifier modifier, @FloatRange(from = 0.0d, fromInclusive = false) float f, boolean z10) {
        return this.$$delegate_0.weight(modifier, f, z10);
    }

    private ContextualFlowRowScopeImpl(int i, int i6, float f, float f7) {
        this.lineIndex = i;
        this.indexInLine = i6;
        this.maxWidthInLine = f;
        this.maxHeight = f7;
        this.$$delegate_0 = FlowRowScopeInstance.INSTANCE;
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    public Modifier alignBy(Modifier modifier, HorizontalAlignmentLine horizontalAlignmentLine) {
        return this.$$delegate_0.alignBy(modifier, horizontalAlignmentLine);
    }
}
