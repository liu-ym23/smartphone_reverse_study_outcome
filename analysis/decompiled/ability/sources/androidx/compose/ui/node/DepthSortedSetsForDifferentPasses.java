package androidx.compose.ui.node;

import S7.o;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u000bJ2\u0010\u0014\u001a\u00020\u000e2 \b\u0004\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0012H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001f\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0017¨\u0006 "}, d2 = {"Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "", "", "extraAssertions", AppAgent.CONSTRUCT, "(Z)V", "Landroidx/compose/ui/node/LayoutNode;", "node", "affectsLookahead", "contains", "(Landroidx/compose/ui/node/LayoutNode;Z)Z", "(Landroidx/compose/ui/node/LayoutNode;)Z", "Landroidx/compose/ui/node/Invalidation;", "invalidation", "LC7/r;", "add", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/Invalidation;)V", "remove", "Lkotlin/Function3;", "block", "popEach", "(LS7/o;)V", "isEmpty", "()Z", "isNotEmpty", "Landroidx/compose/ui/node/DepthSortedSet;", "lookaheadAndAncestorMeasureSet", "Landroidx/compose/ui/node/DepthSortedSet;", "lookaheadAndAncestorPlaceSet", "approachSet", "getAffectsLookaheadMeasure", "affectsLookaheadMeasure", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DepthSortedSetsForDifferentPasses {
    public static final int $stable = 8;
    private final DepthSortedSet approachSet;
    private final DepthSortedSet lookaheadAndAncestorMeasureSet;
    private final DepthSortedSet lookaheadAndAncestorPlaceSet;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Invalidation.values().length];
            try {
                iArr[Invalidation.LookaheadMeasurement.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Invalidation.LookaheadPlacement.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Invalidation.Measurement.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Invalidation.Placement.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DepthSortedSetsForDifferentPasses(boolean z10) {
        this.lookaheadAndAncestorMeasureSet = new DepthSortedSet(z10);
        this.lookaheadAndAncestorPlaceSet = new DepthSortedSet(z10);
        this.approachSet = new DepthSortedSet(z10);
    }

    public final void add(LayoutNode node, Invalidation invalidation) {
        int i = WhenMappings.$EnumSwitchMapping$0[invalidation.ordinal()];
        if (i == 1) {
            this.lookaheadAndAncestorMeasureSet.add(node);
            this.approachSet.add(node);
            return;
        }
        if (i == 2) {
            this.lookaheadAndAncestorPlaceSet.add(node);
            this.approachSet.add(node);
            return;
        }
        if (i == 3) {
            if (node.getLookaheadRoot() != null) {
                this.approachSet.add(node);
                return;
            } else {
                this.lookaheadAndAncestorMeasureSet.add(node);
                return;
            }
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (node.getLookaheadRoot() != null) {
            this.approachSet.add(node);
        } else {
            this.lookaheadAndAncestorPlaceSet.add(node);
        }
    }

    public final boolean contains(LayoutNode node, boolean affectsLookahead) {
        boolean z10 = node.getLookaheadRoot() == null;
        boolean z11 = this.lookaheadAndAncestorMeasureSet.contains(node) || this.lookaheadAndAncestorPlaceSet.contains(node);
        return affectsLookahead ? !z10 && z11 : (z10 && z11) || this.approachSet.contains(node);
    }

    public final boolean getAffectsLookaheadMeasure() {
        return (this.approachSet.isEmpty() || this.lookaheadAndAncestorMeasureSet.isEmpty()) ? false : true;
    }

    public final boolean isEmpty() {
        return this.lookaheadAndAncestorMeasureSet.isEmpty() && this.approachSet.isEmpty() && this.lookaheadAndAncestorPlaceSet.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final void popEach(o block) {
        LayoutNode layoutNodePop;
        while (true) {
            boolean z10 = false;
            if (!this.lookaheadAndAncestorMeasureSet.isEmpty()) {
                layoutNodePop = this.lookaheadAndAncestorMeasureSet.pop();
                z10 = layoutNodePop.getLookaheadRoot() != null;
                z = false;
            } else if (!this.lookaheadAndAncestorPlaceSet.isEmpty()) {
                layoutNodePop = this.lookaheadAndAncestorPlaceSet.pop();
                if (layoutNodePop.getLookaheadRoot() != null) {
                    z10 = true;
                }
            } else if (this.approachSet.isEmpty()) {
                return;
            } else {
                layoutNodePop = this.approachSet.pop();
            }
            block.invoke(layoutNodePop, Boolean.valueOf(z10), Boolean.valueOf(z));
        }
    }

    public final boolean remove(LayoutNode node) {
        return this.approachSet.remove(node) || this.lookaheadAndAncestorMeasureSet.remove(node) || this.lookaheadAndAncestorPlaceSet.remove(node);
    }

    public final boolean contains(LayoutNode node) {
        return this.lookaheadAndAncestorMeasureSet.contains(node) || this.lookaheadAndAncestorPlaceSet.contains(node) || this.approachSet.contains(node);
    }
}
