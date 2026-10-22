package com.stepos.taskrobot.appwhitelist.repository;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/repository/DiskCacheAdapter;", "Lcom/stepos/taskrobot/appwhitelist/repository/DiskAdapter;", "Lcom/stepos/taskrobot/appwhitelist/repository/DiskCache;", "diskCache", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/appwhitelist/repository/DiskCache;)V", "Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;", "read", "()Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;", "dto", "LC7/r;", "write", "(Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;)V", "Lcom/stepos/taskrobot/appwhitelist/repository/DiskCache;", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DiskCacheAdapter implements DiskAdapter {
    private final DiskCache diskCache;

    public DiskCacheAdapter(DiskCache diskCache) {
        k.f(diskCache, "diskCache");
        this.diskCache = diskCache;
    }

    @Override // com.stepos.taskrobot.appwhitelist.repository.DiskAdapter
    public WhitelistManifestDto read() {
        return this.diskCache.read();
    }

    @Override // com.stepos.taskrobot.appwhitelist.repository.DiskAdapter
    public void write(WhitelistManifestDto dto) {
        k.f(dto, "dto");
        this.diskCache.write(dto);
    }
}
