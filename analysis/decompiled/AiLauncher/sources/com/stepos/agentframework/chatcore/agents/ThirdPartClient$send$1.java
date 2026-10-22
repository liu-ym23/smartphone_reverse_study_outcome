package com.stepos.agentframework.chatcore.agents;

import I4.ResultBean;
import Ua.M;
import Z8.Q;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.agents.ThirdPartClient;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import o4.C5005f;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.ThirdPartClient$send$1", f = "ThirdPartClient.kt", l = {148}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ThirdPartClient$send$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentDispatcher.b $callback;
    final /* synthetic */ ThirdPartClient.a $eventListener;
    final /* synthetic */ RequestParameter $parameter;
    final /* synthetic */ C5005f $requester;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdPartClient$send$1(RequestParameter requestParameter, C5005f c5005f, ThirdPartClient.a aVar, AgentDispatcher.b bVar, InterfaceC4014c<? super ThirdPartClient$send$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$parameter = requestParameter;
        this.$requester = c5005f;
        this.$eventListener = aVar;
        this.$callback = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ThirdPartClient$send$1(this.$parameter, this.$requester, this.$eventListener, this.$callback, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ThirdPartClient$send$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C0918n c0918nA;
        C5005f c5005f;
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
                    HashMap<String, ResultBean> mapN = this.$parameter.n();
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
                } else {
                    c0918nA = ExtKt.A(this.$parameter);
                }
                C5005f c5005f2 = this.$requester;
                ApiManager apiManager = ApiManager.INSTANCE;
                ApiType apiType = ApiType.COZE;
                ThirdPartClient.a aVar = this.$eventListener;
                this.L$0 = g9.h.a(c0918nA);
                this.L$1 = c5005f2;
                this.label = 1;
                obj = apiManager.q(apiType, c0918nA, aVar, this);
                if (obj == objG) {
                    return objG;
                }
                c5005f = c5005f2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c5005f = (C5005f) this.L$1;
                C4849c.b(obj);
            }
            c5005f.b(obj instanceof com.stepos.agentframework.adapter.netcore.i ? (com.stepos.agentframework.adapter.netcore.i) obj : null);
        } catch (Exception e10) {
            AgentDispatcher.b bVar = this.$callback;
            String message2 = e10.getMessage();
            bVar.i(new AgentError(AgentError.ERROR_CODE_UNKNOWN, message2 != null ? message2 : "", e10.getCause()));
        }
        return Y8.t.f7040a;
    }
}
