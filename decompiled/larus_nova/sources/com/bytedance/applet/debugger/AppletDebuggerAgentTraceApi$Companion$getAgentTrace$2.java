package com.bytedance.applet.debugger;

import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/bytedance/applet/debugger/AppletDebuggerAgentTraceData;", "Lcom/bytedance/applet/debugger/AppletDebuggerAgentTraceApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2", f = "AppletDebuggerAgentTraceApi.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2 extends SuspendLambda implements Function2<AppletDebuggerAgentTraceApi, Continuation<? super BizResponse<e>>, Object> {
    final /* synthetic */ String $logId;
    final /* synthetic */ String $token;
    final /* synthetic */ String $xTtToken;
    private /* synthetic */ Object L$0;
    int label;

    public AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2(String r100, String r101, String r102, Continuation<? super AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2> r103) {
        this.$logId = r100;
        this.$token = r101;
        this.$xTtToken = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2 r102 = new AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2(this.$logId, this.$token, this.$xTtToken, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(AppletDebuggerAgentTraceApi r100, Continuation<? super BizResponse<e>> r101) {
        return ((AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(AppletDebuggerAgentTraceApi r100, Continuation<? super BizResponse<e>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        AppletDebuggerAgentTraceApi r103 = (AppletDebuggerAgentTraceApi) this.L$0;
        String r104 = this.$logId;
        String r105 = this.$token;
        String r106 = this.$xTtToken;
        this.label = 1;
        r100 = r103.getAgentTrace(r104, r105, r106, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
