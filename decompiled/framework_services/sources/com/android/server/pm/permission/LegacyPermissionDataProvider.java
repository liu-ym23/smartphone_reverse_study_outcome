package com.android.server.pm.permission;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface LegacyPermissionDataProvider {
    Map<String, Set<String>> getAllAppOpPermissionPackages();

    int[] getGidsForUid(int r1);

    LegacyPermissionState getLegacyPermissionState(int r1);

    List<LegacyPermission> getLegacyPermissions();

    void writeLegacyPermissionStateTEMP();
}
