package com.android.server.am;

import android.content.pm.ApplicationInfo;
import android.os.IBinder;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.compat.IPlatformCompat;
import com.android.server.compat.CompatChange;
import com.android.server.compat.PlatformCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class PlatformCompatCache {
    static final int CACHED_COMPAT_CHANGE_CAMERA_MICROPHONE_CAPABILITY = 1;
    static final long[] CACHED_COMPAT_CHANGE_IDS_MAPPING = null;
    static final int CACHED_COMPAT_CHANGE_PROCESS_CAPABILITY = 0;
    static final int CACHED_COMPAT_CHANGE_USE_SHORT_FGS_USAGE_INTERACTION_TIME = 2;
    private static PlatformCompatCache sPlatformCompatCache;
    private final boolean mCacheEnabled;
    private final LongSparseArray<CacheItem> mCaches;
    private final IPlatformCompat mIPlatformCompatProxy;
    private final PlatformCompat mPlatformCompat;

    static class CacheItem implements CompatChange.ChangeListener {
        private final ArrayMap<String, Pair<Boolean, WeakReference<ApplicationInfo>>> mCache;
        private final long mChangeId;
        private final Object mLock;
        private final PlatformCompat mPlatformCompat;

        CacheItem(PlatformCompat platformCompat, long changeId) {
            this.mLock = new Object();
            this.mCache = new ArrayMap();
            this.mPlatformCompat = platformCompat;
            this.mChangeId = changeId;
            this.mPlatformCompat.registerListener(changeId, this);
        }

        boolean isChangeEnabled(ApplicationInfo app) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int index = this.mCache.indexOfKey(app.packageName);     // Catch: Throwable -> L9
            if (index >= 0) goto L11;
            boolean r2 = fetchLocked(app, index);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L11:
            Pair<Boolean, WeakReference<ApplicationInfo>> p = this.mCache.valueAt(index);     // Catch: Throwable -> L9
            if (((WeakReference) p.second).get() != app) goto L16;
            boolean r3 = ((Boolean) p.first).booleanValue();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r3;
        L16:
            boolean r4 = fetchLocked(app, index);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r4;
        L9:
            th = move-exception;
            throw th;
        }

        void invalidate(ApplicationInfo app) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mCache.remove(app.packageName);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        boolean fetchLocked(ApplicationInfo app, int index) {
            Pair<Boolean, WeakReference<ApplicationInfo>> p = new Pair(Boolean.valueOf(this.mPlatformCompat.isChangeEnabledInternalNoLogging(this.mChangeId, app)), new WeakReference(app));
            if (index < 0) goto L5;
            this.mCache.setValueAt(index, p);
        L7:
            return ((Boolean) p.first).booleanValue();
        L5:
            this.mCache.put(app.packageName, p);
            goto L7
        }

        void onApplicationInfoChanged(ApplicationInfo app) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int index = this.mCache.indexOfKey(app.packageName);     // Catch: Throwable -> L7
            if (index < 0) goto L9;
            fetchLocked(app, index);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.compat.CompatChange.ChangeListener
        public void onCompatChange(String packageName) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int index = this.mCache.indexOfKey(packageName);     // Catch: Throwable -> L9
            if (index < 0) goto L12;
            ApplicationInfo app = (ApplicationInfo) ((WeakReference) this.mCache.valueAt(index).second).get();     // Catch: Throwable -> L9
            if (app == null) goto L11;
            fetchLocked(app, index);     // Catch: Throwable -> L9
            goto L12
        L11:
            this.mCache.removeAt(index);     // Catch: Throwable -> L9
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface CachedCompatChangeId {
    }

    static {
        CACHED_COMPAT_CHANGE_IDS_MAPPING = new long[]{136274596, 136219221, 183972877};
    }

    private PlatformCompatCache(long[] compatChanges) {
        this.mCaches = new LongSparseArray();
        IBinder b = ServiceManager.getService("platform_compat");
        int r4 = 0;
        if ((b instanceof PlatformCompat) == false) goto L8;
        this.mPlatformCompat = (PlatformCompat) ServiceManager.getService("platform_compat");
        int r0 = compatChanges.length;
    L5:
        if (r4 >= r0) goto L7;
        long changeId = compatChanges[r4];
        this.mCaches.put(changeId, new CacheItem(this.mPlatformCompat, changeId));
        r4 = r4 + 1;
        goto L5
    L7:
        this.mIPlatformCompatProxy = null;
        this.mCacheEnabled = true;
        return;
    L8:
        this.mIPlatformCompatProxy = IPlatformCompat.Stub.asInterface(b);
        this.mPlatformCompat = null;
        this.mCacheEnabled = false;
    }

    static PlatformCompatCache getInstance() {
        if (sPlatformCompatCache != null) goto L6;
        sPlatformCompatCache = new PlatformCompatCache(new long[]{136274596, 136219221, 183972877});
    L6:
        return sPlatformCompatCache;
    }

    private boolean isChangeEnabled(long changeId, ApplicationInfo app, boolean defaultValue) {
    L5:
        e = move-exception;
        Slog.w("ActivityManager", "Error reading platform compat change " + changeId, e);
        return defaultValue;
    L3:
        if (this.mCacheEnabled == false) goto L8;
        return this.mCaches.get(changeId).isChangeEnabled(app);
    L8:
        return this.mIPlatformCompatProxy.isChangeEnabled(changeId, app);
    }

    static boolean isChangeEnabled(int cachedCompatChangeId, ApplicationInfo app, boolean defaultValue) {
        return getInstance().isChangeEnabled(CACHED_COMPAT_CHANGE_IDS_MAPPING[cachedCompatChangeId], app, defaultValue);
    }

    void invalidate(ApplicationInfo app) {
        int i = this.mCaches.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mCaches.valueAt(i).invalidate(app);
        i = i - 1;
        goto L3
    }

    void onApplicationInfoChanged(ApplicationInfo app) {
        int i = this.mCaches.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mCaches.valueAt(i).onApplicationInfoChanged(app);
        i = i - 1;
        goto L3
    }
}
