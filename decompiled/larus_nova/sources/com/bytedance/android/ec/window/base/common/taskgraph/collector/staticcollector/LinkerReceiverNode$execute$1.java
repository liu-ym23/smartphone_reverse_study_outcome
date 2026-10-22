package com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0002\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/ec/window/base/common/taskgraph/PipelineNode;", "preNode", "input", "Lao/a;", "nodeContextMgr", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "execute"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.LinkerReceiverNode", f = "LinkerReceiverNode.kt", i = {0, 0, 0, 0, 1}, l = {40, 26}, m = "execute$suspendImpl", n = {"this", "input", "nodeContextMgr", "$this$withLock$iv$iv", "$this$withLock$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
public final class LinkerReceiverNode$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LinkerReceiverNode this$0;

    public LinkerReceiverNode$execute$1(LinkerReceiverNode r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return LinkerReceiverNode.g(this.this$0, null, null, this);
    }
}
