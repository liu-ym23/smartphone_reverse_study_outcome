package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Be\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001e\u0010\u0005\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006\u0012\u001e\u0010\n\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\f\u0010\u0014\u001a\u00020\b*\u00020\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R(\u0010\n\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerNode;", "requester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", SendEventContainerMethodParamModel.EventKinds.onShow, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "onHide", "computeContentBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextContextMenuToolbarHandlerElement extends ModifierNodeElement<TextContextMenuToolbarHandlerNode> {
    private final Function1<LayoutCoordinates, Rect> computeContentBounds;
    private final Function1<Continuation<? super Unit>, Object> onHide;
    private final Function1<Continuation<? super Unit>, Object> onShow;
    private final ToolbarRequester requester;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public TextContextMenuToolbarHandlerNode create() {
        return new TextContextMenuToolbarHandlerNode(this.requester, this.onShow, this.onHide, this.computeContentBounds);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = 0;
        int r101 = (this.requester.hashCode() + 0) * 31;
        Function1<Continuation<? super Unit>, Object> r102 = this.onShow;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L6:
        int r104 = (r101 + r103) * 31;
        Function1<Continuation<? super Unit>, Object> r105 = this.onHide;
        if (r105 == null) goto L10;
        r100 = r105.hashCode();
    L10:
        return ((r104 + r100) * 31) + this.computeContentBounds.hashCode();
    L5:
        r103 = 0;
        goto L6
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
        if ((r100 instanceof TextContextMenuToolbarHandlerElement) == true) goto L8;
        return false;
    L8:
        TextContextMenuToolbarHandlerElement r101 = (TextContextMenuToolbarHandlerElement) r100;
        if (this.requester == r101.requester) goto L12;
        return false;
    L12:
        if (this.onShow == r101.onShow) goto L15;
        return false;
    L15:
        if (this.onHide == r101.onHide) goto L18;
        return false;
    L18:
        if (this.computeContentBounds == r101.computeContentBounds) goto L20;
        return false;
    L20:
        return true;
    }

    public void update(TextContextMenuToolbarHandlerNode r100) {
        r100.getRequester().setToolbarHandlerNode$foundation_release(null);
        r100.setRequester(this.requester);
        r100.getRequester().setToolbarHandlerNode$foundation_release(r100);
        r100.setOnShow(this.onShow);
        r100.setOnHide(this.onHide);
        r100.setComputeContentBounds(this.computeContentBounds);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((TextContextMenuToolbarHandlerNode) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextContextMenuToolbarHandlerElement(ToolbarRequester r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101, Function1<? super Continuation<? super Unit>, ? extends Object> r102, Function1<? super LayoutCoordinates, Rect> r103) {
        this.requester = r100;
        this.onShow = r101;
        this.onHide = r102;
        this.computeContentBounds = r103;
    }
}
