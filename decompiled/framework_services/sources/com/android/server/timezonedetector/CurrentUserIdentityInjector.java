package com.android.server.timezonedetector;

import android.app.ActivityManagerInternal;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes3.dex */
public interface CurrentUserIdentityInjector {
    public static final CurrentUserIdentityInjector REAL = null;

    public static class Real implements CurrentUserIdentityInjector {
        protected Real() {
        }

        @Override // com.android.server.timezonedetector.CurrentUserIdentityInjector
        public int getCurrentUserId() {
            return ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getCurrentUserId();
        }
    }

    int getCurrentUserId();

    static {
        REAL = new Real();
    }
}
