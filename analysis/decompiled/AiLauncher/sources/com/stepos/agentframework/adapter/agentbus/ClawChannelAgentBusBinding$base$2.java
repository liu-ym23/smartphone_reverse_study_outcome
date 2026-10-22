package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.json.JSONObject;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class ClawChannelAgentBusBinding$base$2 extends FunctionReferenceImpl implements p9.p<JSONObject, InterfaceC4014c<? super Y8.t>, Object> {
    public ClawChannelAgentBusBinding$base$2(Object obj) {
        super(2, obj, ClawChannelAgentBusBinding.class, "dispatchAgentEvent", "dispatchAgentEvent(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // p9.p
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Object invoke(JSONObject jSONObject, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ClawChannelAgentBusBinding) this.receiver).r(jSONObject, interfaceC4014c);
    }
}
