package androidx.compose.ui.input.pointer;

import S7.k;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.TouchBoundsExpansion;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u000fJ'\u0010 \u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\u000fJ\u000f\u0010\"\u001a\u00020\rH\u0016¢\u0006\u0004\b\"\u0010\u000fJ\u0017\u0010'\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&J\u0019\u0010\u0011\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0011\u0010(R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R*\u0010\u0006\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u0010(R*\u0010\b\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00103R\u0016\u0010<\u001a\u0004\u0018\u0001098DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"Landroidx/compose/ui/input/pointer/HoverIconModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/input/pointer/PointerIcon;", "icon", "", "overrideDescendants", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "dpTouchBoundsExpansion", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/input/pointer/PointerIcon;ZLandroidx/compose/ui/node/DpTouchBoundsExpansion;)V", "LC7/r;", "onEnter", "()V", "onExit", "displayIcon", "displayIconIfDescendantsDoNotHavePriority", "findDescendantNodeWithCursorInBounds", "()Landroidx/compose/ui/input/pointer/HoverIconModifierNode;", "displayIconFromCurrentNodeOrDescendantsWithCursorInBounds", "findOverridingAncestorNode", "displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "pass", "Landroidx/compose/ui/unit/IntSize;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPointerEvent", "onCancelPointerInput", "onDetach", "Landroidx/compose/ui/input/pointer/PointerType;", "pointerType", "isRelevantPointerType-uerMTgs", "(I)Z", "isRelevantPointerType", "(Landroidx/compose/ui/input/pointer/PointerIcon;)V", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "getDpTouchBoundsExpansion", "()Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "setDpTouchBoundsExpansion", "(Landroidx/compose/ui/node/DpTouchBoundsExpansion;)V", "value", "Landroidx/compose/ui/input/pointer/PointerIcon;", "getIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "setIcon", "Z", "getOverrideDescendants", "()Z", "setOverrideDescendants", "(Z)V", "cursorInBoundsOfNode", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerIconService", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "getTouchBoundsExpansion-RZrCHBk", "()J", "touchBoundsExpansion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class HoverIconModifierNode extends Modifier.Node implements TraversableNode, PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private boolean cursorInBoundsOfNode;
    private DpTouchBoundsExpansion dpTouchBoundsExpansion;
    private PointerIcon icon;
    private boolean overrideDescendants;

    public /* synthetic */ HoverIconModifierNode(PointerIcon pointerIcon, boolean z10, DpTouchBoundsExpansion dpTouchBoundsExpansion, int i, e eVar) {
        this(pointerIcon, (i & 2) != 0 ? false : z10, (i & 4) != 0 ? null : dpTouchBoundsExpansion);
    }

    private final void displayIcon() {
        PointerIcon pointerIcon;
        HoverIconModifierNode hoverIconModifierNodeFindOverridingAncestorNode = findOverridingAncestorNode();
        if (hoverIconModifierNodeFindOverridingAncestorNode == null || (pointerIcon = hoverIconModifierNodeFindOverridingAncestorNode.icon) == null) {
            pointerIcon = this.icon;
        }
        displayIcon(pointerIcon);
    }

    private final void displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon() {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        TraversableNodeKt.traverseAncestors(this, new k() { // from class: androidx.compose.ui.input.pointer.HoverIconModifierNode.displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final Boolean invoke(HoverIconModifierNode hoverIconModifierNode) {
                if (ref$ObjectRef.f4920a == null && hoverIconModifierNode.cursorInBoundsOfNode) {
                    ref$ObjectRef.f4920a = hoverIconModifierNode;
                } else if (ref$ObjectRef.f4920a != null && hoverIconModifierNode.getOverrideDescendants() && hoverIconModifierNode.cursorInBoundsOfNode) {
                    ref$ObjectRef.f4920a = hoverIconModifierNode;
                }
                return Boolean.TRUE;
            }
        });
        HoverIconModifierNode hoverIconModifierNode = (HoverIconModifierNode) ref$ObjectRef.f4920a;
        if (hoverIconModifierNode != null) {
            hoverIconModifierNode.displayIcon();
        } else {
            displayIcon(null);
        }
    }

    private final void displayIconFromCurrentNodeOrDescendantsWithCursorInBounds() {
        HoverIconModifierNode hoverIconModifierNodeFindDescendantNodeWithCursorInBounds;
        if (this.cursorInBoundsOfNode) {
            if (!this.overrideDescendants && (hoverIconModifierNodeFindDescendantNodeWithCursorInBounds = findDescendantNodeWithCursorInBounds()) != null) {
                this = hoverIconModifierNodeFindDescendantNodeWithCursorInBounds;
            }
            this.displayIcon();
        }
    }

    private final void displayIconIfDescendantsDoNotHavePriority() {
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.f4916a = true;
        if (!this.overrideDescendants) {
            TraversableNodeKt.traverseDescendants(this, new k() { // from class: androidx.compose.ui.input.pointer.HoverIconModifierNode.displayIconIfDescendantsDoNotHavePriority.1
                {
                    super(1);
                }

                @Override // S7.k
                public final TraversableNode.Companion.TraverseDescendantsAction invoke(HoverIconModifierNode hoverIconModifierNode) {
                    if (!hoverIconModifierNode.cursorInBoundsOfNode) {
                        return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                    }
                    ref$BooleanRef.f4916a = false;
                    return TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal;
                }
            });
        }
        if (ref$BooleanRef.f4916a) {
            displayIcon();
        }
    }

    private final HoverIconModifierNode findDescendantNodeWithCursorInBounds() {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        TraversableNodeKt.traverseDescendants(this, new k() { // from class: androidx.compose.ui.input.pointer.HoverIconModifierNode.findDescendantNodeWithCursorInBounds.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final TraversableNode.Companion.TraverseDescendantsAction invoke(HoverIconModifierNode hoverIconModifierNode) {
                TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsAction = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                if (hoverIconModifierNode.cursorInBoundsOfNode) {
                    ref$ObjectRef.f4920a = hoverIconModifierNode;
                    if (hoverIconModifierNode.getOverrideDescendants()) {
                        return TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                    }
                }
                return traverseDescendantsAction;
            }
        });
        return (HoverIconModifierNode) ref$ObjectRef.f4920a;
    }

    private final HoverIconModifierNode findOverridingAncestorNode() {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        TraversableNodeKt.traverseAncestors(this, new k() { // from class: androidx.compose.ui.input.pointer.HoverIconModifierNode.findOverridingAncestorNode.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final Boolean invoke(HoverIconModifierNode hoverIconModifierNode) {
                if (hoverIconModifierNode.getOverrideDescendants() && hoverIconModifierNode.cursorInBoundsOfNode) {
                    ref$ObjectRef.f4920a = hoverIconModifierNode;
                }
                return Boolean.TRUE;
            }
        });
        return (HoverIconModifierNode) ref$ObjectRef.f4920a;
    }

    private final void onEnter() {
        this.cursorInBoundsOfNode = true;
        displayIconIfDescendantsDoNotHavePriority();
    }

    private final void onExit() {
        if (this.cursorInBoundsOfNode) {
            this.cursorInBoundsOfNode = false;
            if (getIsAttached()) {
                displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon();
            }
        }
    }

    public abstract void displayIcon(PointerIcon icon);

    public final DpTouchBoundsExpansion getDpTouchBoundsExpansion() {
        return this.dpTouchBoundsExpansion;
    }

    public final PointerIcon getIcon() {
        return this.icon;
    }

    public final boolean getOverrideDescendants() {
        return this.overrideDescendants;
    }

    public final PointerIconService getPointerIconService() {
        return (PointerIconService) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalPointerIconService());
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: getTouchBoundsExpansion-RZrCHBk, reason: not valid java name */
    public long mo5347getTouchBoundsExpansionRZrCHBk() {
        DpTouchBoundsExpansion dpTouchBoundsExpansion = this.dpTouchBoundsExpansion;
        return dpTouchBoundsExpansion != null ? dpTouchBoundsExpansion.m5738roundToTouchBoundsExpansionTW6G1oQ(DelegatableNodeKt.requireDensity(this)) : TouchBoundsExpansion.INSTANCE.m5959getNoneRZrCHBk();
    }

    /* renamed from: isRelevantPointerType-uerMTgs, reason: not valid java name */
    public abstract boolean mo5348isRelevantPointerTypeuerMTgs(int pointerType);

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        onExit();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        onExit();
        super.onDetach();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo212onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (pass == PointerEventPass.Main) {
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            for (int i = 0; i < size; i++) {
                if (mo5348isRelevantPointerTypeuerMTgs(changes.get(i).getType())) {
                    int type = pointerEvent.getType();
                    PointerEventType.Companion companion = PointerEventType.INSTANCE;
                    if (PointerEventType.m5370equalsimpl0(type, companion.m5374getEnter7fucELk())) {
                        onEnter();
                        return;
                    } else {
                        if (PointerEventType.m5370equalsimpl0(pointerEvent.getType(), companion.m5375getExit7fucELk())) {
                            onExit();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public final void setDpTouchBoundsExpansion(DpTouchBoundsExpansion dpTouchBoundsExpansion) {
        this.dpTouchBoundsExpansion = dpTouchBoundsExpansion;
    }

    public final void setIcon(PointerIcon pointerIcon) {
        if (kotlin.jvm.internal.k.b(this.icon, pointerIcon)) {
            return;
        }
        this.icon = pointerIcon;
        if (this.cursorInBoundsOfNode) {
            displayIconIfDescendantsDoNotHavePriority();
        }
    }

    public final void setOverrideDescendants(boolean z10) {
        if (this.overrideDescendants != z10) {
            this.overrideDescendants = z10;
            if (z10) {
                if (this.cursorInBoundsOfNode) {
                    displayIcon();
                }
            } else if (this.cursorInBoundsOfNode) {
                displayIconFromCurrentNodeOrDescendantsWithCursorInBounds();
            }
        }
    }

    public HoverIconModifierNode(PointerIcon pointerIcon, boolean z10, DpTouchBoundsExpansion dpTouchBoundsExpansion) {
        this.dpTouchBoundsExpansion = dpTouchBoundsExpansion;
        this.icon = pointerIcon;
        this.overrideDescendants = z10;
    }
}
