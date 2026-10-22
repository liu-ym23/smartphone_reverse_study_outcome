package com.android.server.inputmethod;

import android.os.RemoteException;
import android.os.ServiceManager;
import com.android.internal.compat.IPlatformCompat;

/* JADX INFO: loaded from: classes2.dex */
final class ImePlatformCompatUtils {
    private final IPlatformCompat mPlatformCompat;

    ImePlatformCompatUtils() {
        this.mPlatformCompat = IPlatformCompat.Stub.asInterface(ServiceManager.getService("platform_compat"));
    }

    public boolean shouldUseSetInteractiveProtocol(int imeUid) {
        return isChangeEnabledByUid(156215187, imeUid);
    }

    public boolean shouldClearShowForcedFlag(int clientUid) {
        return isChangeEnabledByUid(214016041, clientUid);
    }

    private boolean isChangeEnabledByUid(long changeFlag, int uid) {
        boolean result = this.mPlatformCompat.isChangeEnabledByUid(changeFlag, uid);     // Catch: RemoteException -> L5
        return result;
    L6:
        return false;
    }
}
