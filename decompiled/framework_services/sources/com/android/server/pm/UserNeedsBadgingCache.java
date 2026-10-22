package com.android.server.pm;

import android.content.pm.UserInfo;
import android.os.Binder;
import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: classes2.dex */
public class UserNeedsBadgingCache {
    private final Object mLock;
    private final SparseBooleanArray mUserCache;
    private final UserManagerService mUserManager;

    public UserNeedsBadgingCache(UserManagerService userManager) {
        this.mLock = new Object();
        this.mUserCache = new SparseBooleanArray();
        this.mUserManager = userManager;
    }

    public void delete(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserCache.delete(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean get(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int index = this.mUserCache.indexOfKey(userId);     // Catch: Throwable -> L9
        if (index < 0) goto L12;
        boolean r2 = this.mUserCache.valueAt(index);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        long token = Binder.clearCallingIdentity();
        UserInfo userInfo = this.mUserManager.getUserInfo(userId);     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(token);
        if (userInfo != null) goto L18;
    L20:
        boolean b = false;
    L21:
        Object r4 = this.mLock;
        monitor-enter(r4);
        this.mUserCache.put(userId, b);     // Catch: Throwable -> L26
        monitor-exit(r4);     // Catch: Throwable -> L26
        return b;
    L26:
        th = move-exception;
        throw th;
    L18:
        if (userInfo.isManagedProfile() == false) goto L20;
        b = true;
    L29:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L9:
        th = move-exception;
        throw th;
    }
}
