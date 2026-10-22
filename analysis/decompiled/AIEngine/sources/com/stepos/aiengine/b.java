package com.stepos.aiengine;

import b6.d;
import com.stepos.core.ability.AbilityManager;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AIEngineApplication f5760a;

    public /* synthetic */ b(AIEngineApplication aIEngineApplication) {
        this.f5760a = aIEngineApplication;
    }

    @Override // zb.a
    public final Object invoke() {
        AIEngineApplication aIEngineApplication = this.f5760a;
        int i10 = AIEngineApplication.f5748d;
        AbilityManager abilityManager = AbilityManager.INSTANCE;
        com.stepos.aiengine.preheat.a aVar = aIEngineApplication.f5751c;
        abilityManager.startResidentPreheat(aVar != null ? new AIEngineApplication$performFullInitialization$gate$3$1$1(1, aVar, com.stepos.aiengine.preheat.a.class, "gate", "gate(Ljava/lang/String;)Z", 0) : null, new d(aIEngineApplication, 1));
        return n.f10413a;
    }
}
