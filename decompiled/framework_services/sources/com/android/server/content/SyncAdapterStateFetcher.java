package com.android.server.content;

import android.app.ActivityManagerInternal;
import android.app.usage.UsageStatsManagerInternal;
import android.content.pm.UserPackage;
import android.os.SystemClock;
import com.android.server.LocalServices;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
class SyncAdapterStateFetcher {
    private final HashMap<UserPackage, Integer> mBucketCache;

    public SyncAdapterStateFetcher() {
        this.mBucketCache = new HashMap();
    }

    public int getStandbyBucket(int userId, String packageName) {
        UserPackage key = UserPackage.of(userId, packageName);
        Integer cached = this.mBucketCache.get(key);
        if (cached != null) goto L5;
        UsageStatsManagerInternal usmi = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        if (usmi != null) goto L10;
        return -1;
    L10:
        int value = usmi.getAppStandbyBucket(packageName, userId, SystemClock.elapsedRealtime());
        this.mBucketCache.put(key, Integer.valueOf(value));
        return value;
    L5:
        return cached.intValue();
    }

    public boolean isAppActive(int uid) {
        ActivityManagerInternal ami = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        if (ami != null) goto L7;
        return false;
    L7:
        return ami.isUidActive(uid);
    }
}
