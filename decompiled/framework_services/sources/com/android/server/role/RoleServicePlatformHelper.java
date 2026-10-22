package com.android.server.role;

import android.annotation.SystemApi;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public interface RoleServicePlatformHelper {
    String computePackageStateHash(int r1);

    Map<String, Set<String>> getLegacyRoleState(int r1);
}
