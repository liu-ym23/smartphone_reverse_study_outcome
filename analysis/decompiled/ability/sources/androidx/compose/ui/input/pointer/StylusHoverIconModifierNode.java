package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/input/pointer/StylusHoverIconModifierNode;", "Landroidx/compose/ui/input/pointer/HoverIconModifierNode;", "Landroidx/compose/ui/input/pointer/PointerIcon;", "icon", "", "overrideDescendants", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "touchBoundsExpansion", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/input/pointer/PointerIcon;ZLandroidx/compose/ui/node/DpTouchBoundsExpansion;)V", "Landroidx/compose/ui/input/pointer/PointerType;", "pointerType", "isRelevantPointerType-uerMTgs", "(I)Z", "isRelevantPointerType", "LC7/r;", "displayIcon", "(Landroidx/compose/ui/input/pointer/PointerIcon;)V", "", "traverseKey", "Ljava/lang/String;", "getTraverseKey", "()Ljava/lang/String;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StylusHoverIconModifierNode extends HoverIconModifierNode {
    public static final int $stable = 8;
    private final String traverseKey;

    public /* synthetic */ StylusHoverIconModifierNode(PointerIcon pointerIcon, boolean z10, DpTouchBoundsExpansion dpTouchBoundsExpansion, int i, e eVar) {
        this(pointerIcon, (i & 2) != 0 ? false : z10, (i & 4) != 0 ? null : dpTouchBoundsExpansion);
    }

    @Override // androidx.compose.ui.input.pointer.HoverIconModifierNode
    public void displayIcon(PointerIcon icon) {
        PointerIconService pointerIconService = getPointerIconService();
        if (pointerIconService != null) {
            pointerIconService.setStylusHoverIcon(icon);
        }
    }

    @Override // androidx.compose.ui.input.pointer.HoverIconModifierNode
    /* renamed from: isRelevantPointerType-uerMTgs */
    public boolean mo5348isRelevantPointerTypeuerMTgs(int pointerType) {
        PointerType.Companion companion = PointerType.INSTANCE;
        return PointerType.m5492equalsimpl0(pointerType, companion.m5498getStylusT8wyACA()) || PointerType.m5492equalsimpl0(pointerType, companion.m5496getEraserT8wyACA());
    }

    public StylusHoverIconModifierNode(PointerIcon pointerIcon, boolean z10, DpTouchBoundsExpansion dpTouchBoundsExpansion) {
        super(pointerIcon, z10, dpTouchBoundsExpansion);
        this.traverseKey = "androidx.compose.ui.input.pointer.StylusHoverIcon";
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public String getTraverseKey() {
        return this.traverseKey;
    }
}
