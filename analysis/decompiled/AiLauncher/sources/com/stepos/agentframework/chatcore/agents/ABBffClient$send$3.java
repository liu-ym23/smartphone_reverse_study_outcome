package com.stepos.agentframework.chatcore.agents;

import I4.ResultBean;
import Ua.M;
import Z8.Q;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
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
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.ABBffClient$send$3", f = "ABBffClient.kt", l = {202}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ABBffClient$send$3 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentDispatcher.b $callback;
    final /* synthetic */ AtomicReference<com.stepos.agentframework.adapter.netcore.n> $cancelHandleRef;
    final /* synthetic */ ABBffClient$send$eventListener$1 $eventListener;
    final /* synthetic */ RequestParameter $parameter;
    final /* synthetic */ AtomicBoolean $pendingCancel;
    final /* synthetic */ AtomicReference<String> $pendingCancelReason;
    final /* synthetic */ String $sessionKey;
    Object L$0;
    int label;
    final /* synthetic */ ABBffClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABBffClient$send$3(RequestParameter requestParameter, ABBffClient$send$eventListener$1 aBBffClient$send$eventListener$1, AtomicReference<com.stepos.agentframework.adapter.netcore.n> atomicReference, ABBffClient aBBffClient, String str, AtomicBoolean atomicBoolean, AtomicReference<String> atomicReference2, AgentDispatcher.b bVar, InterfaceC4014c<? super ABBffClient$send$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$parameter = requestParameter;
        this.$eventListener = aBBffClient$send$eventListener$1;
        this.$cancelHandleRef = atomicReference;
        this.this$0 = aBBffClient;
        this.$sessionKey = str;
        this.$pendingCancel = atomicBoolean;
        this.$pendingCancelReason = atomicReference2;
        this.$callback = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ABBffClient$send$3(this.$parameter, this.$eventListener, this.$cancelHandleRef, this.this$0, this.$sessionKey, this.$pendingCancel, this.$pendingCancelReason, this.$callback, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ABBffClient$send$3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
                    }
                } else {
                    c0918nA = ExtKt.A(this.$parameter);
                    this.this$0.c0(c0918nA);
                }
                ApiManager apiManager = ApiManager.INSTANCE;
                ApiType apiType = ApiType.AGENTBUS_BFF;
                ABBffClient$send$eventListener$1 aBBffClient$send$eventListener$1 = this.$eventListener;
                this.L$0 = g9.h.a(c0918nA);
                this.label = 1;
                obj = apiManager.q(apiType, c0918nA, aBBffClient$send$eventListener$1, this);
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
            if (nVar != null) {
                this.this$0.inFlightCancelHandles.put(this.$sessionKey, nVar);
            }
            if (this.$pendingCancel.get()) {
                if (nVar != null) {
                    String str = this.$pendingCancelReason.get();
                    kotlin.jvm.internal.p.h(str, "get(...)");
                    C4109a.a(nVar.cancel(str));
                }
                ABBffClient.f0(this.$cancelHandleRef, this.this$0, this.$sessionKey);
            }
        } catch (Exception e10) {
            AgentDispatcher.b bVar = this.$callback;
            String message2 = e10.getMessage();
            bVar.i(new AgentError(AgentError.ERROR_CODE_UNKNOWN, message2 != null ? message2 : "", e10.getCause()));
        }
        return Y8.t.f7040a;
    }
}
