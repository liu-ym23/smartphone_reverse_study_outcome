package com.stepos.taskrobot.appwhitelist.repository;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/repository/DefaultManifestAdapter;", "Lcom/stepos/taskrobot/appwhitelist/repository/DefaultAdapter;", AgentBusWakeContract.EXTRA_SOURCE, "Lcom/stepos/taskrobot/appwhitelist/repository/DefaultManifestSource;", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/appwhitelist/repository/DefaultManifestSource;)V", "load", "Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultManifestAdapter implements DefaultAdapter {
    private final DefaultManifestSource source;

    public DefaultManifestAdapter(DefaultManifestSource source) {
        k.f(source, "source");
        this.source = source;
    }

    @Override // com.stepos.taskrobot.appwhitelist.repository.DefaultAdapter
    public WhitelistManifestDto load() {
        return this.source.load();
    }
}
