package com.android.server.permission.access.util;

import android.content.ApexEnvironment;
import android.os.UserHandle;
import java.io.File;

/* JADX INFO: compiled from: PermissionApex.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionApex {
    public static final PermissionApex INSTANCE = null;

    static {
        INSTANCE = new PermissionApex();
    }

    private PermissionApex() {
    }

    public final File getSystemDataDirectory() {
        return getApexEnvironment().getDeviceProtectedDataDir();
    }

    public final File getUserDataDirectory(int userId) {
        return getApexEnvironment().getDeviceProtectedDataDirForUser(UserHandle.of(userId));
    }

    private final ApexEnvironment getApexEnvironment() {
        return ApexEnvironment.getApexEnvironment("com.android.permission");
    }
}
