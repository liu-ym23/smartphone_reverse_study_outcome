package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@c(c = "androidx.compose.foundation.gestures.ScrollableNode$drag$2$1", f = "Scrollable.kt", l = {344}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/NestedScrollScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/NestedScrollScope;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ScrollableNode$drag$2$1 extends SuspendLambda implements n {
    final /* synthetic */ n $forEachDelta;
    final /* synthetic */ ScrollingLogic $this_with;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableNode$drag$2$1(n nVar, ScrollingLogic scrollingLogic, H7.c<? super ScrollableNode$drag$2$1> cVar) {
        super(2, cVar);
        this.$forEachDelta = nVar;
        this.$this_with = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        ScrollableNode$drag$2$1 scrollableNode$drag$2$1 = new ScrollableNode$drag$2$1(this.$forEachDelta, this.$this_with, cVar);
        scrollableNode$drag$2$1.L$0 = obj;
        return scrollableNode$drag$2$1;
    }

    @Override // S7.n
    public final Object invoke(NestedScrollScope nestedScrollScope, H7.c<? super r> cVar) {
        return ((ScrollableNode$drag$2$1) create(nestedScrollScope, cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.L$0;
            n nVar = this.$forEachDelta;
            final ScrollingLogic scrollingLogic = this.$this_with;
            k kVar = new k() { // from class: androidx.compose.foundation.gestures.ScrollableNode$drag$2$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((DragEvent.DragDelta) obj2);
                    return r.f317a;
                }

                public final void invoke(DragEvent.DragDelta dragDelta) {
                    nestedScrollScope.mo473scrollByWithOverscrollOzD1aCk(scrollingLogic.m516singleAxisOffsetMKHz9U(dragDelta.getDelta()), NestedScrollSource.INSTANCE.m5312getUserInputWNlRxjI());
                }
            };
            this.label = 1;
            if (nVar.invoke(kVar, this) == coroutineSingletons) {
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
}
