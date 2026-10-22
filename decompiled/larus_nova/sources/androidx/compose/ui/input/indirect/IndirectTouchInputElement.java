package androidx.compose.ui.input.indirect;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\f\u0010\u0011\u001a\u00020\u000f*\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/input/indirect/IndirectTouchInputElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/indirect/IndirectTouchInputNode;", "onIndirectTouchEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/indirect/IndirectTouchEvent;", "", "onPreIndirectTouchEvent", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnIndirectTouchEvent", "()Lkotlin/jvm/functions/Function1;", "getOnPreIndirectTouchEvent", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class IndirectTouchInputElement extends ModifierNodeElement<IndirectTouchInputNode> {
    private final Function1<IndirectTouchEvent, Boolean> onIndirectTouchEvent;
    private final Function1<IndirectTouchEvent, Boolean> onPreIndirectTouchEvent;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public IndirectTouchInputNode create() {
        return new IndirectTouchInputNode(this.onIndirectTouchEvent, this.onPreIndirectTouchEvent);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        Function1<IndirectTouchEvent, Boolean> r100 = this.onIndirectTouchEvent;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function1<IndirectTouchEvent, Boolean> r104 = this.onPreIndirectTouchEvent;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final Function1<IndirectTouchEvent, Boolean> getOnIndirectTouchEvent() {
        return this.onIndirectTouchEvent;
    }

    public final Function1<IndirectTouchEvent, Boolean> getOnPreIndirectTouchEvent() {
        return this.onPreIndirectTouchEvent;
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
        if ((r100 instanceof IndirectTouchInputElement) == true) goto L8;
        return false;
    L8:
        IndirectTouchInputElement r101 = (IndirectTouchInputElement) r100;
        if (this.onIndirectTouchEvent == r101.onIndirectTouchEvent) goto L12;
        return false;
    L12:
        if (this.onPreIndirectTouchEvent == r101.onPreIndirectTouchEvent) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        Function1<IndirectTouchEvent, Boolean> r101 = this.onIndirectTouchEvent;
        if (r101 == null) goto L5;
        r100.setName("onIndirectTouchEvent");
        r100.getProperties().set("onIndirectTouchEvent", r101);
    L5:
        Function1<IndirectTouchEvent, Boolean> r102 = this.onPreIndirectTouchEvent;
        if (r102 == null) goto L9;
        r100.setName("onPreIndirectTouchEvent");
        r100.getProperties().set("onPreIndirectTouchEvent", r102);
        return;
    }

    public void update(IndirectTouchInputNode r100) {
        r100.setOnEvent(this.onIndirectTouchEvent);
        r100.setOnPreEvent(this.onPreIndirectTouchEvent);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((IndirectTouchInputNode) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IndirectTouchInputElement(Function1<? super IndirectTouchEvent, Boolean> r100, Function1<? super IndirectTouchEvent, Boolean> r101) {
        this.onIndirectTouchEvent = r100;
        this.onPreIndirectTouchEvent = r101;
    }
}
