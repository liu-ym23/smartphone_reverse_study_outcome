package com.stepos.taskrobot.appwhitelist.remote;

import H7.c;
import com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/remote/WhitelistRemoteSource;", "", "Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;", "fetch", "(LH7/c;)Ljava/lang/Object;", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface WhitelistRemoteSource {
    Object fetch(c<? super WhitelistManifestDto> cVar);
}
