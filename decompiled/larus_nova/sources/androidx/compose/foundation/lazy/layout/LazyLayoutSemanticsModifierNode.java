package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ4\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\f\u0010 \u001a\u00020\u001f*\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "reverseScrolling", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZ)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "isVertical", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "()Landroidx/compose/ui/semantics/CollectionInfo;", "scrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "indexForKeyMapping", "Lkotlin/Function1;", "", "", "scrollToIndexAction", "update", "", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "updateCachedSemanticsValues", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LazyLayoutSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {
    private final Function1<Object, Integer> indexForKeyMapping;
    private Function0<? extends LazyLayoutItemProvider> itemProviderLambda;
    private Orientation orientation;
    private boolean reverseScrolling;
    private ScrollAxisRange scrollAxisRange;
    private Function1<? super Integer, Boolean> scrollToIndexAction;
    private LazyLayoutSemanticState state;
    private boolean userScrollEnabled;

    public static /* synthetic */ boolean a(LazyLayoutSemanticsModifierNode r100, int r101) {
        return updateCachedSemanticsValues$lambda$6(r100, r101);
    }

    public static /* synthetic */ float b(LazyLayoutSemanticsModifierNode r100) {
        return updateCachedSemanticsValues$lambda$4(r100);
    }

    public static /* synthetic */ Float c(LazyLayoutSemanticsModifierNode r100) {
        return applySemantics$lambda$2(r100);
    }

    public static /* synthetic */ float d(LazyLayoutSemanticsModifierNode r100) {
        return updateCachedSemanticsValues$lambda$3(r100);
    }

    public static /* synthetic */ int e(LazyLayoutSemanticsModifierNode r100, Object r101) {
        return indexForKeyMapping$lambda$0(r100, r101);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
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

    private final CollectionInfo getCollectionInfo() {
        return this.state.collectionInfo();
    }

    private final boolean isVertical() {
        if (this.orientation != Orientation.Vertical) goto L5;
        return true;
    L5:
        return false;
    }

    private final void updateCachedSemanticsValues() {
        this.scrollAxisRange = new ScrollAxisRange(new a0(this), new b0(this), this.reverseScrolling);
        if (this.userScrollEnabled == false) goto L5;
        Function1<? super Integer, Boolean> r100 = new c0(this);
    L6:
        this.scrollToIndexAction = r100;
        return;
    L5:
        r100 = null;
        goto L6
    }

    public static final /* synthetic */ LazyLayoutSemanticState access$getState$p(LazyLayoutSemanticsModifierNode r100) {
        return r100.state;
    }

    private static final Float applySemantics$lambda$2(LazyLayoutSemanticsModifierNode r100) {
        return Float.valueOf(r100.state.getViewport() - r100.state.getContentPadding());
    }

    private static final float updateCachedSemanticsValues$lambda$3(LazyLayoutSemanticsModifierNode r100) {
        return r100.state.getScrollOffset();
    }

    private static final float updateCachedSemanticsValues$lambda$4(LazyLayoutSemanticsModifierNode r100) {
        return r100.state.getMaxScrollOffset();
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver r100) {
        SemanticsPropertiesKt.setTraversalGroup(r100, true);
        SemanticsPropertiesKt.indexForKey(r100, this.indexForKeyMapping);
        if (isVertical() == false) goto L8;
        ScrollAxisRange r101 = this.scrollAxisRange;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("scrollAxisRange");
        r101 = null;
    L7:
        SemanticsPropertiesKt.setVerticalScrollAxisRange(r100, r101);
    L12:
        Function1<? super Integer, Boolean> r102 = this.scrollToIndexAction;
        if (r102 == null) goto L15;
        SemanticsPropertiesKt.scrollToIndex$default(r100, null, r102, 1, null);
    L15:
        SemanticsPropertiesKt.getScrollViewportLength$default(r100, null, new y(this), 1, null);
        SemanticsPropertiesKt.setCollectionInfo(r100, getCollectionInfo());
        return;
    L8:
        ScrollAxisRange r103 = this.scrollAxisRange;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("scrollAxisRange");
        r103 = null;
    L11:
        SemanticsPropertiesKt.setHorizontalScrollAxisRange(r100, r103);
        goto L12
    }

    private static final int indexForKeyMapping$lambda$0(LazyLayoutSemanticsModifierNode r100, Object r101) {
        LazyLayoutItemProvider r102 = r100.itemProviderLambda.invoke();
        int r103 = r102.getItemCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        if (Intrinsics.areEqual(r102.getKey(r104), r101) == true) goto L12;
        r104 = r104 + 1;
        goto L3
    L12:
        return r104;
    L8:
        return -1;
    }

    private static final boolean updateCachedSemanticsValues$lambda$6(LazyLayoutSemanticsModifierNode r100, int r101) {
        LazyLayoutItemProvider r102 = r100.itemProviderLambda.invoke();
        if (r101 >= 0) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("Can't scroll to index " + r101 + ", it is out of bounds [0, " + r102.getItemCount() + ')');
    L10:
        BuildersKt.launch$default(r100.getCoroutineScope(), null, null, new LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2(r100, r101, null), 3, null);
        return true;
    L5:
        if (r101 >= r102.getItemCount()) goto L7;
        r103 = true;
        goto L8
    }

    public LazyLayoutSemanticsModifierNode(Function0<? extends LazyLayoutItemProvider> r100, LazyLayoutSemanticState r101, Orientation r102, boolean r103, boolean r104) {
        this.itemProviderLambda = r100;
        this.state = r101;
        this.orientation = r102;
        this.userScrollEnabled = r103;
        this.reverseScrolling = r104;
        this.indexForKeyMapping = new z(this);
        updateCachedSemanticsValues();
    }

    public final void update(Function0<? extends LazyLayoutItemProvider> r100, LazyLayoutSemanticState r101, Orientation r102, boolean r103, boolean r104) {
        this.itemProviderLambda = r100;
        this.state = r101;
        if (this.orientation == r102) goto L6;
        this.orientation = r102;
        SemanticsModifierNodeKt.invalidateSemantics(this);
    L6:
        if (this.userScrollEnabled == r103) goto L8;
    L9:
        this.userScrollEnabled = r103;
        this.reverseScrolling = r104;
        updateCachedSemanticsValues();
        SemanticsModifierNodeKt.invalidateSemantics(this);
        return;
    L8:
        if (this.reverseScrolling != r104) goto L9;
    }
}
