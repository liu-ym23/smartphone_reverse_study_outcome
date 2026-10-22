package com.stepos.taskrobot.appwhitelist.repository;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.appwhitelist.model.WhitelistManifest;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/repository/MemoryCache;", "", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/taskrobot/appwhitelist/model/WhitelistManifest;", "get", "()Lcom/stepos/taskrobot/appwhitelist/model/WhitelistManifest;", "manifest", "LC7/r;", "replace", "(Lcom/stepos/taskrobot/appwhitelist/model/WhitelistManifest;)V", "current", "Lcom/stepos/taskrobot/appwhitelist/model/WhitelistManifest;", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MemoryCache {
    private volatile WhitelistManifest current = WhitelistManifest.INSTANCE.getEMPTY();

    /* renamed from: get, reason: from getter */
    public final WhitelistManifest getCurrent() {
        return this.current;
    }

    public final void replace(WhitelistManifest manifest) {
        k.f(manifest, "manifest");
        this.current = manifest;
    }
}
