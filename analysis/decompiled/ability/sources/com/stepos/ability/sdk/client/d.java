package com.stepos.ability.sdk.client;

import C7.r;
import S7.k;
import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.common.AbilityException;
import java.util.List;
import m9.C1718k;

/* loaded from: classes3.dex */
public final class d implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1718k f3249a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;

    public d(C1718k c1718k, String str, List list) {
        this.f3249a = c1718k;
        this.b = str;
        this.c = list;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        C1718k c1718k = this.f3249a;
        P3.b bVar = P3.c.f1086a;
        if (!zBooleanValue || AgentServiceClient.serviceManager == null) {
            bVar.invoke(6, "Ability_".concat("Ability_AgentServiceClient"), "queryAbilities Bind failed", null);
            AgentServiceClient.queryAbilities$lambda$0$safeResumeException(c1718k, new AbilityException(O3.b.e, null, null));
        } else {
            bVar.invoke(3, "Ability_".concat("Ability_AgentServiceClient"), "queryAbilities Bind success.", null);
            IAgentServiceManager iAgentServiceManager = AgentServiceClient.serviceManager;
            kotlin.jvm.internal.k.c(iAgentServiceManager);
            AgentServiceClient.queryAbilities$lambda$0$executeQueryAbility(this.b, this.c, c1718k, iAgentServiceManager);
        }
        return r.f317a;
    }
}
