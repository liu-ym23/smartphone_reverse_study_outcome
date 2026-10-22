package com.stepos.ability.agentbusclient;

import android.app.Application;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ability/agentbusclient/AgentBusClientApplication;", "Landroid/app/Application;", AppAgent.CONSTRUCT, "()V", "LC7/r;", AppAgent.ON_CREATE, "Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding;", "binding", "Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding;", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentBusClientApplication extends Application {
    private AbilityAgentBusNodeAgentBusBinding binding;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
    }
}
