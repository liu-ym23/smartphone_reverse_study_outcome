package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.TouchBoundsExpansion;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import com.alipay.sdk.m.x.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\b\u0010)\u001a\u00020 H\u0002J\b\u0010*\u001a\u00020 H\u0002J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020 H\u0016J\u0017\u00101\u001a\u00020\b2\u0006\u00102\u001a\u000203H&¢\u0006\u0004\b4\u00105J\u0012\u00106\u001a\u00020 2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u00106\u001a\u00020 H\u0002J\b\u00107\u001a\u00020 H\u0002J\n\u00108\u001a\u0004\u0018\u00010\u0000H\u0002J\b\u00109\u001a\u00020 H\u0002J\n\u0010:\u001a\u0004\u0018\u00010\u0000H\u0002J\b\u0010;\u001a\u00020 H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006<"}, d2 = {"Landroidx/compose/ui/input/pointer/HoverIconModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "dpTouchBoundsExpansion", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "<init>", "(Landroidx/compose/ui/input/pointer/PointerIcon;ZLandroidx/compose/ui/node/DpTouchBoundsExpansion;)V", "getDpTouchBoundsExpansion", "()Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "setDpTouchBoundsExpansion", "(Landroidx/compose/ui/node/DpTouchBoundsExpansion;)V", "value", "getIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "setIcon", "(Landroidx/compose/ui/input/pointer/PointerIcon;)V", "getOverrideDescendants", "()Z", "setOverrideDescendants", "(Z)V", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "cursorInBoundsOfNode", "onPointerEvent", "", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onEnter", d.f25928r, "onCancelPointerInput", "onDetach", "touchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "getTouchBoundsExpansion-RZrCHBk", "()J", "isRelevantPointerType", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isRelevantPointerType-uerMTgs", "(I)Z", "displayIcon", "displayIconIfDescendantsDoNotHavePriority", "findDescendantNodeWithCursorInBounds", "displayIconFromCurrentNodeOrDescendantsWithCursorInBounds", "findOverridingAncestorNode", "displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class HoverIconModifierNode extends Modifier.Node implements TraversableNode, PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private boolean cursorInBoundsOfNode;
    private DpTouchBoundsExpansion dpTouchBoundsExpansion;
    private PointerIcon icon;
    private boolean overrideDescendants;

    private final void onEnter() {
        this.cursorInBoundsOfNode = true;
        displayIconIfDescendantsDoNotHavePriority();
    }

    public abstract void displayIcon(PointerIcon r100);

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    /* JADX INFO: renamed from: isRelevantPointerType-uerMTgs, reason: not valid java name */
    public abstract boolean mo6053isRelevantPointerTypeuerMTgs(int r100);

    @Override // androidx.compose.ui.Modifier.Node, androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.CC.$default$onDensityChange(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.CC.$default$onViewConfigurationChange(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon() {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        TraversableNodeKt.traverseAncestors(this, new AnonymousClass1(r100));
        HoverIconModifierNode r101 = (HoverIconModifierNode) r100.element;
        if (r101 == null) goto L5;
        r101.displayIcon();
        return;
    L5:
        displayIcon(null);
    }

    private final void displayIconFromCurrentNodeOrDescendantsWithCursorInBounds() {
        if (this.cursorInBoundsOfNode == true) goto L6;
        return;
    L6:
        if (this.overrideDescendants == true) goto L10;
        HoverIconModifierNode r100 = findDescendantNodeWithCursorInBounds();
        if (r100 == null) goto L10;
    L11:
        r100.displayIcon();
        return;
    L10:
        r100 = this;
        goto L11
    }

    private final void displayIconIfDescendantsDoNotHavePriority() {
        final Ref.BooleanRef r100 = new Ref.BooleanRef();
        r100.element = true;
        if (this.overrideDescendants == true) goto L6;
        TraversableNodeKt.traverseDescendants(this, new C87381(r100));
    L6:
        if (r100.element == false) goto L9;
        displayIcon();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final HoverIconModifierNode findDescendantNodeWithCursorInBounds() {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        TraversableNodeKt.traverseDescendants(this, new C87391(r100));
        return (HoverIconModifierNode) r100.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final HoverIconModifierNode findOverridingAncestorNode() {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        TraversableNodeKt.traverseAncestors(this, new C87401(r100));
        return (HoverIconModifierNode) r100.element;
    }

    private final void onExit() {
        if (this.cursorInBoundsOfNode == false) goto L8;
        this.cursorInBoundsOfNode = false;
        if (isAttached() == false) goto L9;
        displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon();
        return;
    L9:
        return;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk */
    public long mo195getTouchBoundsExpansionRZrCHBk() {
        DpTouchBoundsExpansion r100 = this.dpTouchBoundsExpansion;
        if (r100 == null) goto L6;
        return r100.m6445roundToTouchBoundsExpansionTW6G1oQ(DelegatableNodeKt.requireDensity(this));
    L6:
        return TouchBoundsExpansion.Companion.m6655getNoneRZrCHBk();
    }

    private final void displayIcon() {
        HoverIconModifierNode r100 = findOverridingAncestorNode();
        if (r100 == null) goto L6;
        PointerIcon r101 = r100.icon;
        if (r101 == null) goto L6;
    L7:
        displayIcon(r101);
        return;
    L6:
        r101 = this.icon;
        goto L7
    }

    public final PointerIconService getPointerIconService() {
        return (PointerIconService) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalPointerIconService());
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        onExit();
        super.onDetach();
    }

    public final DpTouchBoundsExpansion getDpTouchBoundsExpansion() {
        return this.dpTouchBoundsExpansion;
    }

    public final PointerIcon getIcon() {
        return this.icon;
    }

    public final boolean getOverrideDescendants() {
        return this.overrideDescendants;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        onExit();
    }

    public static final /* synthetic */ boolean access$getCursorInBoundsOfNode$p(HoverIconModifierNode r100) {
        return r100.cursorInBoundsOfNode;
    }

    public final void setDpTouchBoundsExpansion(DpTouchBoundsExpansion r100) {
        this.dpTouchBoundsExpansion = r100;
    }

    public final void setIcon(PointerIcon r100) {
        if (Intrinsics.areEqual(this.icon, r100) == true) goto L8;
        this.icon = r100;
        if (this.cursorInBoundsOfNode == false) goto L9;
        displayIconIfDescendantsDoNotHavePriority();
        return;
    L9:
        return;
    }

    public final void setOverrideDescendants(boolean r100) {
        if (this.overrideDescendants == r100) goto L13;
        this.overrideDescendants = r100;
        if (r100 == false) goto L10;
        if (this.cursorInBoundsOfNode == false) goto L14;
        displayIcon();
        return;
    L14:
        return;
    L10:
        if (this.cursorInBoundsOfNode == false) goto L16;
        displayIconFromCurrentNodeOrDescendantsWithCursorInBounds();
        return;
    L16:
        return;
    }

    public HoverIconModifierNode(PointerIcon r100, boolean r101, DpTouchBoundsExpansion r102) {
        this.dpTouchBoundsExpansion = r102;
        this.icon = r100;
        this.overrideDescendants = r101;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo202onPointerEventH0pRuoY(PointerEvent r100, PointerEventPass r101, long r102) {
        if (r101 != PointerEventPass.Main) goto L20;
        List<PointerInputChange> r103 = r100.getChanges();
        int r104 = r103.size();
        boolean r105 = false;
        int r106 = 0;
    L5:
        if (r106 >= r104) goto L10;
        if (mo6053isRelevantPointerTypeuerMTgs(((PointerInputChange) ListProtector.get(r103, r106)).m6129getTypeT8wyACA()) == true) goto L8;
        r106 = r106 + 1;
        goto L5
    L8:
        r105 = true;
    L10:
        if (r105 == false) goto L21;
        int r107 = r100.m6068getType7fucELk();
        PointerEventType.Companion r108 = PointerEventType.Companion;
        if (PointerEventType.m6075equalsimpl0(r107, r108.m6079getEnter7fucELk()) == false) goto L15;
        onEnter();
        return;
    L15:
        if (PointerEventType.m6075equalsimpl0(r100.m6068getType7fucELk(), r108.m6080getExit7fucELk()) == false) goto L23;
        onExit();
        return;
    L23:
        return;
    L21:
        return;
    }

    public /* synthetic */ HoverIconModifierNode(PointerIcon r100, boolean r101, DpTouchBoundsExpansion r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
