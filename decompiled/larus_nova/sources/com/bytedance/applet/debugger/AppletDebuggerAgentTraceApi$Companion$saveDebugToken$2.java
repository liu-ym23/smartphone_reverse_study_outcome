package com.bytedance.applet.debugger;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.larus.network.bean.BizResponse;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/bytedance/applet/debugger/AppletDebuggerAgentTraceApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebuggerAgentTraceApi$Companion$saveDebugToken$2", f = "AppletDebuggerAgentTraceApi.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebuggerAgentTraceApi$Companion$saveDebugToken$2 extends SuspendLambda implements Function2<AppletDebuggerAgentTraceApi, Continuation<? super BizResponse<Unit>>, Object> {
    final /* synthetic */ r $request;
    private /* synthetic */ Object L$0;
    int label;

    public AppletDebuggerAgentTraceApi$Companion$saveDebugToken$2(r r100, Continuation<? super AppletDebuggerAgentTraceApi$Companion$saveDebugToken$2> r101) {
        this.$request = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AppletDebuggerAgentTraceApi$Companion$saveDebugToken$2 r102 = new AppletDebuggerAgentTraceApi$Companion$saveDebugToken$2(this.$request, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(AppletDebuggerAgentTraceApi r100, Continuation<? super BizResponse<Unit>> r101) {
        return ((AppletDebuggerAgentTraceApi$Companion$saveDebugToken$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(AppletDebuggerAgentTraceApi r100, Continuation<? super BizResponse<Unit>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L15:
        return r110;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        AppletDebuggerAgentTraceApi r111 = (AppletDebuggerAgentTraceApi) this.L$0;
        r r102 = this.$request;
        JsonObject r103 = new JsonObject();
        JsonArray r104 = new JsonArray();
        Iterator<T> r105 = r102.f191756a.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        q r106 = (q) r105.next();
        JsonObject r107 = new JsonObject();
        r107.addProperty("log_id", r106.f191754a);
        r107.addProperty("token", r106.f191755b);
        r104.add(r107);
        goto L10
    L12:
        Unit r108 = Unit.INSTANCE;
        r103.add("batch_data", r104);
        r103.addProperty("feedback_source", Integer.valueOf(r102.f191757b));
        this.label = 1;
        r110 = r111.saveDebugToken(r103, this);
        if (r110 != r100) goto L15;
        return r100;
    }
}
