package com.stepos.agentbus.config;

import kotlin.Metadata;
import la.s0;
import p7.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/stepos/agentbus/config/ConfigProvider;", "", "Lkotlin/Function1;", "Lcom/stepos/agentbus/config/AgentBusConfig;", "transform", "Lc7/r;", "update", "(Lp7/k;)V", "Lla/s0;", "getCurrent", "()Lla/s0;", "current", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ConfigProvider {
    s0 getCurrent();

    void update(k transform);
}
