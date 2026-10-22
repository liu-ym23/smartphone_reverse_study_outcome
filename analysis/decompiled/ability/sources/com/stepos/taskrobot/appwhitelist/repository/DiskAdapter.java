package com.stepos.taskrobot.appwhitelist.repository;

import com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/repository/DiskAdapter;", "", "Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;", "read", "()Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;", "dto", "LC7/r;", "write", "(Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;)V", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DiskAdapter {
    WhitelistManifestDto read();

    void write(WhitelistManifestDto dto);
}
