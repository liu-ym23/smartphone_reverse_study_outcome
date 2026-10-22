package com.android.server.timezonedetector;

import android.app.ActivityManager;
import android.os.Binder;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes3.dex */
public interface CallerIdentityInjector {
    public static final CallerIdentityInjector REAL = null;

    public static class Real implements CallerIdentityInjector {
        protected Real() {
        }

        @Override // com.android.server.timezonedetector.CallerIdentityInjector
        public int resolveUserId(int userId, String debugName) {
            return ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, false, debugName, null);
        }

        @Override // com.android.server.timezonedetector.CallerIdentityInjector
        public int getCallingUserId() {
            return UserHandle.getCallingUserId();
        }

        @Override // com.android.server.timezonedetector.CallerIdentityInjector
        public long clearCallingIdentity() {
            return Binder.clearCallingIdentity();
        }

        @Override // com.android.server.timezonedetector.CallerIdentityInjector
        public void restoreCallingIdentity(long token) {
            Binder.restoreCallingIdentity(token);
        }
    }

    long clearCallingIdentity();

    int getCallingUserId();

    int resolveUserId(int r1, String r2);

    void restoreCallingIdentity(long r1);

    static {
        REAL = new Real();
    }
}
