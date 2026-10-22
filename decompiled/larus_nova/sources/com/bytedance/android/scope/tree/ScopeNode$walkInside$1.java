package com.bytedance.android.scope.tree;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "Lkotlin/sequences/SequenceScope;", "Lcom/bytedance/android/scope/tree/d;", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.scope.tree.ScopeNode$walkInside$1", f = "ScopeNode.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY}, m = "invokeSuspend", n = {"$this$sequence", "cur"}, s = {"L$0", "L$1"})
public final class ScopeNode$walkInside$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super d>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayDeque $queue;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ScopeNode$walkInside$1(ArrayDeque r100, Continuation r101) {
        this.$queue = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        ScopeNode$walkInside$1 r102 = new ScopeNode$walkInside$1(this.$queue, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super d> r100, Continuation<? super Unit> r101) {
        return ((ScopeNode$walkInside$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0044 -> B:14:0x0047). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        d r103 = (d) this.L$1;
        SequenceScope r104 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r100);
        ScopeNode$walkInside$1 r105 = this;
    L14:
        ReentrantReadWriteLock.ReadLock r106 = r103.f163461b.readLock();
        r106.lock();
        if (r103.f163460a == true) goto L23;
        Iterator<T> r107 = r103.f163465d.iterator();     // Catch: Throwable -> L25
    L19:
        if (r107.hasNext() == false) goto L23;
        a r108 = (a) r107.next();     // Catch: Throwable -> L25
        if ((r108 instanceof d) == false) goto L19;
        r105.$queue.addLast(r108);     // Catch: Throwable -> L25
    L23:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L25
        r106.unlock();
    L10:
        if ((!r105.$queue.isEmpty()) == false) goto L29;
        r103 = (d) r105.$queue.removeFirst();
        r105.L$0 = r104;
        r105.L$1 = r103;
        r105.label = 1;
        if (r104.yield(r103, r105) != r101) goto L14;
        return r101;
    L29:
        return Unit.INSTANCE;
    L25:
        th = move-exception;
        r106.unlock();
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        r104 = (SequenceScope) this.L$0;
        r105 = this;
        goto L10
    }
}
