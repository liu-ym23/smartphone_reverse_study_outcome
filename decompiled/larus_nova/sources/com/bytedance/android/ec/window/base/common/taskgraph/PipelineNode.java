package com.bytedance.android.ec.window.base.common.taskgraph;

import com.bytedance.android.ec.window.base.common.taskgraph.context.NodeState;
import com.bytedance.android.ec.window.base.common.taskgraph.context.NodeType;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes44.dex */
public abstract class PipelineNode<IN, OUT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<OUT> f49168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ao.b<IN, OUT> f49169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<IN, OUT> f49170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<IN, Unit> f49171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineContext f49172e;

    public final String toString() {
        return this.f49169b.f15692a;
    }

    public NodeType c() {
        return NodeType.NORMAL;
    }

    public final OUT b(IN r100, ao.a r101) {
        if (this.f49168a.get() != null) goto L5;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        NodeState r103 = NodeState.IDLE;     // Catch: Throwable -> L8
        Object r104 = (OUT) Result.m9449constructorimpl(this.f49170c.invoke(r100));
    L11:
        if (Result.m9456isSuccessimpl(r104) == true) goto L13;
        NodeState r105 = NodeState.IDLE;
        Throwable r106 = Result.m9452exceptionOrNullimpl(r104);
        if ((r106 instanceof Exception) == false) goto L21;
        Exception r107 = (Exception) r106;
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "node");
        Intrinsics.checkNotNullParameter(r107, "e");
        bo.a r108 = r101.f15691c;
        r108.getClass();
        Intrinsics.checkNotNullParameter(this, "node");
        Intrinsics.checkNotNullParameter(r107, "e");
        Iterator<T> r109 = r108.f19787a.iterator();
    L19:
        if (r109.hasNext() == false) goto L21;
        ((bo.b) r109.next()).onError();
    L21:
        r104 = (OUT) null;
    L22:
        if (r104 != null) goto L26;
        Function1<IN, Unit> r110 = this.f49171d;
        if (r110 == null) goto L27;
        Unit r111 = r110.invoke(r100);
    L27:
        return (OUT) r104;
    L26:
        NodeState r112 = NodeState.IDLE;
        this.f49168a.set((OUT) r104);
        goto L27
    L13:
        if (Result.m9455isFailureimpl(r104) == false) goto L22;
    L8:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L5:
        return this.f49168a.get();
    }

    public PipelineNode(ao.b r100, Function1 r101, CoroutineContext r102) {
        Intrinsics.checkNotNullParameter(r100, "nodeId");
        Intrinsics.checkNotNullParameter(r101, "taskAction");
        this.f49169b = r100;
        this.f49170c = r101;
        this.f49171d = null;
        this.f49172e = r102;
        this.f49168a = new AtomicReference();
        NodeState r103 = NodeState.IDLE;
    }

    public Object a(PipelineNode<?, IN> r100, IN r101, ao.a r102, Continuation<? super OUT> r103) {
        if (r100 == null) goto L4;
        r102.a(r100, this);
    L4:
        CoroutineContext r104 = this.f49172e;
        if (r104 != null) goto L8;
        return b(r101, r102);
    L8:
        return BuildersKt.withContext(r104, new PipelineNode$execute$2(this, r101, r102, null), r103);
    }
}
