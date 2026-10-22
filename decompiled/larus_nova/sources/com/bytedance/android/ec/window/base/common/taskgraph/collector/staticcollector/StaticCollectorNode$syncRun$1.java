package com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0086H"}, d2 = {"IN", "Lkotlin/Function0;", "action", "Lkotlin/coroutines/Continuation;", "continuation", "", "syncRun"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.StaticCollectorNode", f = "StaticCollectorNode.kt", i = {0, 0}, l = {49}, m = "syncRun", n = {"action", "$this$withLock$iv"}, s = {"L$0", "L$1"})
public final class StaticCollectorNode$syncRun$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ e this$0;

    public StaticCollectorNode$syncRun$1(e r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        e r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        StaticCollectorNode$syncRun$1 r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L12;
        if (r106 != 1) goto L11;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r103.L$1;
        Function0 r108 = (Function0) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L22:
        r105 = r108.invoke();     // Catch: Throwable -> L19
        InlineMarker.finallyStart(2);
        r107.unlock(null);
        InlineMarker.finallyEnd(2);
    L18:
        return r105;
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r107.unlock(null);
        InlineMarker.finallyEnd(1);
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r104);
        r107 = r101.f49193h;
        r103.L$0 = null;
        r103.L$1 = r107;
        r103.label = 1;
        if (r107.a(null, r103) == r105) goto L18;
        r108 = null;
        goto L22
    L5:
        r103 = new StaticCollectorNode$syncRun$1(r101, this);
        goto L6
    }
}
