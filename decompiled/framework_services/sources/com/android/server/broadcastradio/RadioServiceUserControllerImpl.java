package com.android.server.broadcastradio;

import android.app.ActivityManager;
import android.os.Binder;
import com.android.server.am.ProcessList;

/* JADX INFO: loaded from: classes.dex */
public final class RadioServiceUserControllerImpl implements RadioServiceUserController {
    public RadioServiceUserControllerImpl() {
    }

    @Override // com.android.server.broadcastradio.RadioServiceUserController
    public boolean isCurrentOrSystemUser() {
        int callingUser = getCallingUserId();
        if (callingUser == getCurrentUser()) goto L7;
        if (callingUser == 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.android.server.broadcastradio.RadioServiceUserController
    public int getCurrentUser() {
        int userId = ProcessList.INVALID_ADJ;
        long identity = Binder.clearCallingIdentity();
        userId = ActivityManager.getCurrentUser();     // Catch: Throwable -> L6 RuntimeException -> L9
        goto L5
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        Binder.restoreCallingIdentity(identity);
        return userId;
    }

    @Override // com.android.server.broadcastradio.RadioServiceUserController
    public int getCallingUserId() {
        return Binder.getCallingUserHandle().getIdentifier();
    }
}
