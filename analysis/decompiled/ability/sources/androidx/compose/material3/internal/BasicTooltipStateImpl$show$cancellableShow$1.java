package androidx.compose.material3.internal;

import C7.r;
import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.C1718k;

@c(c = "androidx.compose.material3.internal.BasicTooltipStateImpl$show$cancellableShow$1", f = "BasicTooltip.kt", l = {189}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class BasicTooltipStateImpl$show$cancellableShow$1 extends SuspendLambda implements k {
    Object L$0;
    int label;
    final /* synthetic */ BasicTooltipStateImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTooltipStateImpl$show$cancellableShow$1(BasicTooltipStateImpl basicTooltipStateImpl, H7.c<? super BasicTooltipStateImpl$show$cancellableShow$1> cVar) {
        super(1, cVar);
        this.this$0 = basicTooltipStateImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(H7.c<?> cVar) {
        return new BasicTooltipStateImpl$show$cancellableShow$1(this.this$0, cVar);
    }

    @Override // S7.k
    public final Object invoke(H7.c<? super r> cVar) {
        return ((BasicTooltipStateImpl$show$cancellableShow$1) create(cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            BasicTooltipStateImpl basicTooltipStateImpl = this.this$0;
            this.L$0 = basicTooltipStateImpl;
            this.label = 1;
            C1718k c1718k = new C1718k(1, U7.a.I(this));
            c1718k.y();
            basicTooltipStateImpl.setVisible(true);
            basicTooltipStateImpl.job = c1718k;
            if (c1718k.x() == coroutineSingletons) {
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
