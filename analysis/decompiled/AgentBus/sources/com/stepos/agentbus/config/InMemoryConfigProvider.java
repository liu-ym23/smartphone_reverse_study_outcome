package com.stepos.agentbus.config;

import kotlin.Metadata;
import la.d0;
import la.k0;
import la.s0;
import la.u0;
import p7.k;
import q7.f;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentbus/config/InMemoryConfigProvider;", "Lcom/stepos/agentbus/config/ConfigProvider;", "Lcom/stepos/agentbus/config/AgentBusConfig;", "initial", "<init>", "(Lcom/stepos/agentbus/config/AgentBusConfig;)V", "Lkotlin/Function1;", "transform", "Lc7/r;", "update", "(Lp7/k;)V", "Lla/d0;", "state", "Lla/d0;", "Lla/s0;", "current", "Lla/s0;", "getCurrent", "()Lla/s0;", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InMemoryConfigProvider implements ConfigProvider {
    private final s0 current;
    private final d0 state;

    /* JADX WARN: Multi-variable type inference failed */
    public InMemoryConfigProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.stepos.agentbus.config.ConfigProvider
    public s0 getCurrent() {
        return this.current;
    }

    @Override // com.stepos.agentbus.config.ConfigProvider
    public void update(k transform) {
        q7.k.e(transform, "transform");
        d0 d0Var = this.state;
        ((u0) d0Var).f(transform.invoke(((u0) d0Var).getValue()));
    }

    public InMemoryConfigProvider(AgentBusConfig agentBusConfig) {
        q7.k.e(agentBusConfig, "initial");
        u0 u0VarC = k0.c(agentBusConfig);
        this.state = u0VarC;
        this.current = u0VarC;
    }

    public /* synthetic */ InMemoryConfigProvider(AgentBusConfig agentBusConfig, int i2, f fVar) {
        this((i2 & 1) != 0 ? new AgentBusConfig(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null) : agentBusConfig);
    }
}
