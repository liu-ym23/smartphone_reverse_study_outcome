package androidx.compose.foundation.lazy.layout;

import C7.r;
import J7.c;
import S7.a;
import S7.k;
import S7.n;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u000eJ\u0013\u0010\u0014\u001a\u00020\u000f*\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R$\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010$¨\u0006+"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "itemProviderLambda", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "", "userScrollEnabled", "reverseScrolling", AppAgent.CONSTRUCT, "(LS7/a;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZ)V", "LC7/r;", "updateCachedSemanticsValues", "()V", "update", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "applySemantics", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "LS7/a;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "Landroidx/compose/foundation/gestures/Orientation;", "Z", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "scrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "Lkotlin/Function1;", "", "", "indexForKeyMapping", "LS7/k;", "scrollToIndexAction", "isVertical", "()Z", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "()Landroidx/compose/ui/semantics/CollectionInfo;", "collectionInfo", "getShouldAutoInvalidate", "shouldAutoInvalidate", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class LazyLayoutSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {
    private final k indexForKeyMapping = new k() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$indexForKeyMapping$1
        {
            super(1);
        }

        @Override // S7.k
        public final Integer invoke(Object obj) {
            LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.this$0.itemProviderLambda.invoke();
            int itemCount = lazyLayoutItemProvider.getItemCount();
            int i = 0;
            while (true) {
                if (i >= itemCount) {
                    i = -1;
                    break;
                }
                if (kotlin.jvm.internal.k.b(lazyLayoutItemProvider.getKey(i), obj)) {
                    break;
                }
                i++;
            }
            return Integer.valueOf(i);
        }
    };
    private a itemProviderLambda;
    private Orientation orientation;
    private boolean reverseScrolling;
    private ScrollAxisRange scrollAxisRange;
    private k scrollToIndexAction;
    private LazyLayoutSemanticState state;
    private boolean userScrollEnabled;

    public LazyLayoutSemanticsModifierNode(a aVar, LazyLayoutSemanticState lazyLayoutSemanticState, Orientation orientation, boolean z10, boolean z11) {
        this.itemProviderLambda = aVar;
        this.state = lazyLayoutSemanticState;
        this.orientation = orientation;
        this.userScrollEnabled = z10;
        this.reverseScrolling = z11;
        updateCachedSemanticsValues();
    }

    private final CollectionInfo getCollectionInfo() {
        return this.state.collectionInfo();
    }

    private final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }

    private final void updateCachedSemanticsValues() {
        this.scrollAxisRange = new ScrollAxisRange(new a() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.1
            {
                super(0);
            }

            @Override // S7.a
            public final Float invoke() {
                return Float.valueOf(LazyLayoutSemanticsModifierNode.this.state.getScrollOffset());
            }
        }, new a() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.2
            {
                super(0);
            }

            @Override // S7.a
            public final Float invoke() {
                return Float.valueOf(LazyLayoutSemanticsModifierNode.this.state.getMaxScrollOffset());
            }
        }, this.reverseScrolling);
        this.scrollToIndexAction = this.userScrollEnabled ? new k() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.3

            @c(c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2", f = "LazyLayoutSemantics.kt", l = {205}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2, reason: invalid class name */
            public static final class AnonymousClass2 extends SuspendLambda implements n {
                final /* synthetic */ int $index;
                int label;
                final /* synthetic */ LazyLayoutSemanticsModifierNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode, int i, H7.c<? super AnonymousClass2> cVar) {
                    super(2, cVar);
                    this.this$0 = lazyLayoutSemanticsModifierNode;
                    this.$index = i;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    return new AnonymousClass2(this.this$0, this.$index, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                    int i = this.label;
                    if (i == 0) {
                        b.b(obj);
                        LazyLayoutSemanticState lazyLayoutSemanticState = this.this$0.state;
                        int i6 = this.$index;
                        this.label = 1;
                        if (lazyLayoutSemanticState.scrollToItem(i6, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        b.b(obj);
                    }
                    return r.f317a;
                }

                @Override // S7.n
                public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                    return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                }
            }

            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Boolean invoke(int i) {
                LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) LazyLayoutSemanticsModifierNode.this.itemProviderLambda.invoke();
                if (i >= 0 && i < lazyLayoutItemProvider.getItemCount()) {
                    AbstractC1683A.n(LazyLayoutSemanticsModifierNode.this.getCoroutineScope(), null, new AnonymousClass2(LazyLayoutSemanticsModifierNode.this, i, null), 3);
                    return Boolean.TRUE;
                }
                StringBuilder sbU = B7.a.u(i, "Can't scroll to index ", ", it is out of bounds [0, ");
                sbU.append(lazyLayoutItemProvider.getItemCount());
                sbU.append(')');
                throw new IllegalArgumentException(sbU.toString().toString());
            }
        } : null;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        SemanticsPropertiesKt.indexForKey(semanticsPropertyReceiver, this.indexForKeyMapping);
        if (isVertical()) {
            ScrollAxisRange scrollAxisRange = this.scrollAxisRange;
            if (scrollAxisRange == null) {
                kotlin.jvm.internal.k.n("scrollAxisRange");
                throw null;
            }
            SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, scrollAxisRange);
        } else {
            ScrollAxisRange scrollAxisRange2 = this.scrollAxisRange;
            if (scrollAxisRange2 == null) {
                kotlin.jvm.internal.k.n("scrollAxisRange");
                throw null;
            }
            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, scrollAxisRange2);
        }
        k kVar = this.scrollToIndexAction;
        if (kVar != null) {
            SemanticsPropertiesKt.scrollToIndex$default(semanticsPropertyReceiver, null, kVar, 1, null);
        }
        SemanticsPropertiesKt.getScrollViewportLength$default(semanticsPropertyReceiver, null, new a() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.applySemantics.2
            {
                super(0);
            }

            @Override // S7.a
            public final Float invoke() {
                return Float.valueOf(LazyLayoutSemanticsModifierNode.this.state.getViewport() - LazyLayoutSemanticsModifierNode.this.state.getContentPadding());
            }
        }, 1, null);
        SemanticsPropertiesKt.setCollectionInfo(semanticsPropertyReceiver, getCollectionInfo());
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final void update(a itemProviderLambda, LazyLayoutSemanticState state, Orientation orientation, boolean userScrollEnabled, boolean reverseScrolling) {
        this.itemProviderLambda = itemProviderLambda;
        this.state = state;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (this.userScrollEnabled == userScrollEnabled && this.reverseScrolling == reverseScrolling) {
            return;
        }
        this.userScrollEnabled = userScrollEnabled;
        this.reverseScrolling = reverseScrolling;
        updateCachedSemanticsValues();
        SemanticsModifierNodeKt.invalidateSemantics(this);
    }
}
