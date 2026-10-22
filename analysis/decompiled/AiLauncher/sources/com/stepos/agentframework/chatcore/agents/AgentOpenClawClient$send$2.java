package com.stepos.agentframework.chatcore.agents;

import I4.ResultBean;
import Ua.M;
import Z8.Q;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.agents.AgentOpenClawClient;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.ailauncher.chat.wake.circle.F;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$send$2", f = "AgentOpenClawClient.kt", l = {F.GESTURE_WIDTH_DP}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentOpenClawClient$send$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentDispatcher.b $callback;
    final /* synthetic */ AtomicReference<com.stepos.agentframework.adapter.netcore.n> $cancelHandleRef;
    final /* synthetic */ AgentOpenClawClient.b $eventListener;
    final /* synthetic */ RequestParameter $parameter;
    final /* synthetic */ AtomicBoolean $pendingCancel;
    Object L$0;
    int label;
    final /* synthetic */ AgentOpenClawClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentOpenClawClient$send$2(RequestParameter requestParameter, AgentOpenClawClient.b bVar, AtomicReference<com.stepos.agentframework.adapter.netcore.n> atomicReference, AtomicBoolean atomicBoolean, AgentOpenClawClient agentOpenClawClient, AgentDispatcher.b bVar2, InterfaceC4014c<? super AgentOpenClawClient$send$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$parameter = requestParameter;
        this.$eventListener = bVar;
        this.$cancelHandleRef = atomicReference;
        this.$pendingCancel = atomicBoolean;
        this.this$0 = agentOpenClawClient;
        this.$callback = bVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentOpenClawClient$send$2(this.$parameter, this.$eventListener, this.$cancelHandleRef, this.$pendingCancel, this.this$0, this.$callback, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentOpenClawClient$send$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C0918n c0918nA;
        String message;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                if (this.$parameter.getIsToolResult()) {
                    Object extra = this.$parameter.getExtra();
                    kotlin.jvm.internal.p.g(extra, "null cannot be cast to non-null type com.stepos.common.ChatReplyInfo");
                    c0918nA = ExtKt.z((C0917m) extra);
                    RequestParameter requestParameter = this.$parameter;
                    AgentOpenClawClient agentOpenClawClient = this.this$0;
                    HashMap<String, ResultBean> mapN = requestParameter.n();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(Q.e(mapN.size()));
                    for (Object obj2 : mapN.entrySet()) {
                        Object key = ((Map.Entry) obj2).getKey();
                        ResultBean resultBean = (ResultBean) ((Map.Entry) obj2).getValue();
                        if (resultBean.getSuccess()) {
                            message = resultBean.getResultRspContent();
                            if (message == null) {
                                message = "";
                            }
                        } else {
                            message = resultBean.getMessage();
                            if (message == null) {
                                message = "";
                            }
                        }
                        linkedHashMap.put(key, message);
                    }
                    c0918nA.H(new HashMap<>(linkedHashMap));
                    String traceId = c0918nA.getTraceId();
                    if (traceId == null || traceId.length() == 0) {
                        c0918nA.I(requestParameter.getTraceId());
                        C4148a.k(agentOpenClawClient.getTAG(), "supplement traceId:" + c0918nA.getTraceId(), false, 4, null);
                    }
                } else {
                    c0918nA = ExtKt.A(this.$parameter);
                }
                ApiManager apiManager = ApiManager.INSTANCE;
                ApiType apiType = ApiType.OPENCLAW;
                AgentOpenClawClient.b bVar = this.$eventListener;
                this.L$0 = g9.h.a(c0918nA);
                this.label = 1;
                obj = apiManager.q(apiType, c0918nA, bVar, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            com.stepos.agentframework.adapter.netcore.n nVar = (com.stepos.agentframework.adapter.netcore.n) obj;
            this.$cancelHandleRef.set(nVar);
            if (this.$pendingCancel.get()) {
                C4148a.k(this.this$0.getTAG(), "Cancel request executed after cancelHandle ready.", false, 4, null);
                if (nVar != null) {
                    C4109a.a(com.stepos.agentframework.adapter.netcore.n.a(nVar, null, 1, null));
                }
            }
        } catch (Exception e10) {
            AgentDispatcher.b bVar2 = this.$callback;
            String message2 = e10.getMessage();
            bVar2.i(new AgentError(AgentError.ERROR_CODE_UNKNOWN, message2 != null ? message2 : "", e10.getCause()));
        }
        return Y8.t.f7040a;
    }
}
