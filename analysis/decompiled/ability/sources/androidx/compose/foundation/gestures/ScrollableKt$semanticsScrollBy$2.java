package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.n;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$FloatRef;

@c(c = "androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2", f = "Scrollable.kt", l = {967}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/NestedScrollScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/NestedScrollScope;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ScrollableKt$semanticsScrollBy$2 extends SuspendLambda implements n {
    final /* synthetic */ long $offset;
    final /* synthetic */ Ref$FloatRef $previousValue;
    final /* synthetic */ ScrollingLogic $this_semanticsScrollBy;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableKt$semanticsScrollBy$2(ScrollingLogic scrollingLogic, long j5, Ref$FloatRef ref$FloatRef, H7.c<? super ScrollableKt$semanticsScrollBy$2> cVar) {
        super(2, cVar);
        this.$this_semanticsScrollBy = scrollingLogic;
        this.$offset = j5;
        this.$previousValue = ref$FloatRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$2 = new ScrollableKt$semanticsScrollBy$2(this.$this_semanticsScrollBy, this.$offset, this.$previousValue, cVar);
        scrollableKt$semanticsScrollBy$2.L$0 = obj;
        return scrollableKt$semanticsScrollBy$2;
    }

    @Override // S7.n
    public final Object invoke(NestedScrollScope nestedScrollScope, H7.c<? super r> cVar) {
        return ((ScrollableKt$semanticsScrollBy$2) create(nestedScrollScope, cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.L$0;
            float fM517toFloatk4lQ0M = this.$this_semanticsScrollBy.m517toFloatk4lQ0M(this.$offset);
            final Ref$FloatRef ref$FloatRef = this.$previousValue;
            final ScrollingLogic scrollingLogic = this.$this_semanticsScrollBy;
            n nVar = new n() { // from class: androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                    return r.f317a;
                }

                public final void invoke(float f, float f7) {
                    float f9 = f - ref$FloatRef.f4917a;
                    ScrollingLogic scrollingLogic2 = scrollingLogic;
                    ref$FloatRef.f4917a += scrollingLogic2.reverseIfNeeded(scrollingLogic2.m517toFloatk4lQ0M(nestedScrollScope.mo472scrollByOzD1aCk(scrollingLogic2.m518toOffsettuRUvjQ(scrollingLogic2.reverseIfNeeded(f9)), NestedScrollSource.INSTANCE.m5312getUserInputWNlRxjI())));
                }
            };
            this.label = 1;
            if (SuspendAnimationKt.animate$default(0.0f, fM517toFloatk4lQ0M, 0.0f, null, nVar, this, 12, null) == coroutineSingletons) {
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
