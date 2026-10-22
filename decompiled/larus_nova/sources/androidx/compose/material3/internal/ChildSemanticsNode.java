package androidx.compose.material3.internal;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B \u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\r\u001a\u00020\u0006*\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R+\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/internal/ChildSemanticsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getProperties", "()Lkotlin/jvm/functions/Function1;", "setProperties", "applySemantics", "onDetach", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChildSemanticsNode extends Modifier.Node implements SemanticsModifierNode {
    public static final int $stable = 8;
    private Function1<? super SemanticsPropertyReceiver, Unit> properties;

    public static /* synthetic */ boolean a(SemanticsPropertyReceiver r100, TraversableNode r101) {
        return applySemantics$lambda$1(r100, r101);
    }

    public static /* synthetic */ boolean b(TraversableNode r100) {
        return onDetach$lambda$2(r100);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldMergeDescendantSemantics(this);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.CC.$default$isImportantForBounds(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        TraversableNodeKt.traverseAncestors(this, ParentSemanticsNodeKey.INSTANCE, new s0());
    }

    public final Function1<SemanticsPropertyReceiver, Unit> getProperties() {
        return this.properties;
    }

    public ChildSemanticsNode(Function1<? super SemanticsPropertyReceiver, Unit> r100) {
        this.properties = r100;
    }

    private static final boolean onDetach$lambda$2(TraversableNode r100) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.material3.internal.ParentSemanticsNode");
        ((ParentSemanticsNode) r100).releaseSemantics();
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(final SemanticsPropertyReceiver r100) {
        TraversableNodeKt.traverseAncestors(this, ParentSemanticsNodeKey.INSTANCE, new r0(r100));
        this.properties.invoke(r100);
    }

    public final void setProperties(Function1<? super SemanticsPropertyReceiver, Unit> r100) {
        this.properties = r100;
    }

    private static final boolean applySemantics$lambda$1(SemanticsPropertyReceiver r100, TraversableNode r101) {
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.material3.internal.ParentSemanticsNode");
        ((ParentSemanticsNode) r101).obtainSemantics(r100);
        return false;
    }
}
