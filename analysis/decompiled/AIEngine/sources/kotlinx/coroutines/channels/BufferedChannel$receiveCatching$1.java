package kotlinx.coroutines.channels;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {759}, m = "receiveCatching-JP2dKIU$suspendImpl")
/* loaded from: classes.dex */
public final class BufferedChannel$receiveCatching$1<E> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatching$1(BufferedChannel<E> bufferedChannel, b<? super BufferedChannel$receiveCatching$1> bVar) {
        super(bVar);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM145receiveCatchingJP2dKIU$suspendImpl = BufferedChannel.m145receiveCatchingJP2dKIU$suspendImpl(this.this$0, this);
        return objM145receiveCatchingJP2dKIU$suspendImpl == CoroutineSingletons.f10059a ? objM145receiveCatchingJP2dKIU$suspendImpl : ChannelResult.m152boximpl(objM145receiveCatchingJP2dKIU$suspendImpl);
    }
}
