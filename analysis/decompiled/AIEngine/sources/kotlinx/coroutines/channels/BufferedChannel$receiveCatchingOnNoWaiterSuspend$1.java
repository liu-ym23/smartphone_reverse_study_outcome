package kotlinx.coroutines.channels;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {3117}, m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk")
/* loaded from: classes.dex */
public final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, b<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> bVar) {
        super(bVar);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM146receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m146receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return objM146receiveCatchingOnNoWaiterSuspendGKJJFZk == CoroutineSingletons.f10059a ? objM146receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m152boximpl(objM146receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
