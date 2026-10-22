package com.stepos.ability.agentbusclient;

import C7.r;
import H7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.json.JSONObject;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class AbilityAgentBusNodeAgentBusBinding$base$2 extends FunctionReferenceImpl implements n {
    public AbilityAgentBusNodeAgentBusBinding$base$2(Object obj) {
        super(2, obj, AbilityAgentBusNodeAgentBusBinding.class, "dispatchFrame", "dispatchFrame(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // S7.n
    public final Object invoke(JSONObject jSONObject, c<? super r> cVar) {
        return ((AbilityAgentBusNodeAgentBusBinding) this.receiver).dispatchFrame(jSONObject, cVar);
    }
}
