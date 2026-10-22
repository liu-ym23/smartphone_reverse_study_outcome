package com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector;

import com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode;
import com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode;
import com.bytedance.android.ec.window.base.common.taskgraph.context.NodeType;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class LinkerReceiverNode<T> extends ProcessorNode<T, Unit> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public T f49185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e<?> f49186i;

    @Override // com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode, com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode
    public final Object a(PipelineNode<?, T> r100, T r101, ao.a r102, Continuation<? super Unit> r103) {
        return g(this, r101, r102, r103);
    }

    public abstract Object h(ao.a r100, Continuation<? super Unit> r101);

    @Override // com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode
    public final NodeType c() {
        return NodeType.LINK;
    }

    public LinkerReceiverNode(String r100, e<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        Intrinsics.checkNotNullParameter(r101, "hostNode");
        super(new ao.b("linker-" + r100), AnonymousClass1.INSTANCE, null);
        this.f49186i = r101;
    }

    public static Object g(LinkerReceiverNode r100, Object r101, ao.a r102, Continuation r103) {
        if ((r103 instanceof LinkerReceiverNode$execute$1) == false) goto L7;
        LinkerReceiverNode$execute$1 r104 = (LinkerReceiverNode$execute$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L20;
        if (r108 == 1) goto L19;
        if (r108 != 2) goto L18;
        kotlinx.coroutines.sync.a r109 = (kotlinx.coroutines.sync.a) r104.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L15
    L27:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r109.unlock(null);
        return null;
    L15:
        Throwable th10 = th;
        kotlinx.coroutines.sync.a r111 = r109;
    L33:
        r111.unlock(null);
        throw th10;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r112 = (kotlinx.coroutines.sync.a) r104.L$3;
        r102 = (ao.a) r104.L$2;
        r101 = (T) r104.L$1;
        LinkerReceiverNode r113 = (LinkerReceiverNode) r104.L$0;
        ResultKt.throwOnFailure(r106);
        r111 = r112;
        r100 = r113;
    L37:
        r100.f49185h = (T) r101;     // Catch: Throwable -> L31
        r104.L$0 = r111;     // Catch: Throwable -> L31
        r104.L$1 = null;     // Catch: Throwable -> L31
        r104.L$2 = null;     // Catch: Throwable -> L31
        r104.L$3 = null;     // Catch: Throwable -> L31
        r104.label = 2;     // Catch: Throwable -> L31
        if (r100.h(r102, r104) != r107) goto L26;
        return r107;
    L26:
        r109 = r111;
    L31:
        th = move-exception;
        th10 = th;
        goto L33
    L20:
        ResultKt.throwOnFailure(r106);
        r102.b(r100, r100.f49186i);
        r102.a(r100, r100.f49186i);
        r111 = r100.f49186i.f49193h;
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r102;
        r104.L$3 = r111;
        r104.label = 1;
        if (r111.a(null, r104) != r107) goto L37;
        return r107;
    L7:
        r104 = new LinkerReceiverNode$execute$1(r100, r103);
        goto L8
    }
}
