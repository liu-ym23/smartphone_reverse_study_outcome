package com.bytedance.applet.impl.moa;

import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.impl.moa.MoaGrantingNetworkGateway", f = "MoaGrantingNetworkGateway.kt", i = {0, 0, 0, 1, 1}, l = {22, 33}, m = "completeGranting", n = {"serverOption", "retryDelayMS", MapMonitorConst.ATTEMPT, "serverOption", "retryDelayMS"}, s = {"L$0", "L$1", "I$2", "L$0", "L$1"})
public final class MoaGrantingNetworkGateway$completeGranting$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaGrantingNetworkGateway this$0;

    public MoaGrantingNetworkGateway$completeGranting$1(MoaGrantingNetworkGateway r100, Continuation<? super MoaGrantingNetworkGateway$completeGranting$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
