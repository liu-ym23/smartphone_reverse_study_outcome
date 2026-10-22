package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "Landroidx/compose/ui/input/pointer/HoverIconModifierNode;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "<init>", "(Landroidx/compose/ui/input/pointer/PointerIcon;Z)V", "traverseKey", "", "getTraverseKey", "()Ljava/lang/String;", "isRelevantPointerType", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isRelevantPointerType-uerMTgs", "(I)Z", "displayIcon", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PointerHoverIconModifierNode extends HoverIconModifierNode {
    public static final int $stable = 8;
    private final String traverseKey;

    @Override // androidx.compose.ui.node.TraversableNode
    public /* bridge */ /* synthetic */ Object getTraverseKey() {
        return getTraverseKey();
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public String getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.input.pointer.HoverIconModifierNode
    public void displayIcon(PointerIcon r100) {
        PointerIconService r101 = getPointerIconService();
        if (r101 == null) goto L6;
        r101.setIcon(r100);
        return;
    }

    @Override // androidx.compose.ui.input.pointer.HoverIconModifierNode
    /* JADX INFO: renamed from: isRelevantPointerType-uerMTgs */
    public boolean mo6053isRelevantPointerTypeuerMTgs(int r100) {
        PointerType.Companion r101 = PointerType.Companion;
        if (PointerType.m6198equalsimpl0(r100, r101.m6204getStylusT8wyACA()) == false) goto L5;
    L7:
        return false;
    L5:
        if (PointerType.m6198equalsimpl0(r100, r101.m6202getEraserT8wyACA()) == true) goto L7;
        return true;
    }

    public PointerHoverIconModifierNode(PointerIcon r100, boolean r101) {
        super(r100, r101, null, 4, null);
        this.traverseKey = "androidx.compose.ui.input.pointer.PointerHoverIcon";
    }

    public /* synthetic */ PointerHoverIconModifierNode(PointerIcon r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101);
    }
}
