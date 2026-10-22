package com.android.server.storage;

import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.content.pm.UserInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserManager;
import android.os.storage.VolumeInfo;
import android.util.Log;
import com.android.internal.os.BackgroundThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public class AppCollector {
    private static String TAG;
    private final BackgroundHandler mBackgroundHandler;
    private CompletableFuture<List<PackageStats>> mStats;

    private class BackgroundHandler extends Handler {
        static final int MSG_START_LOADING_SIZES = 0;
        private final PackageManager mPm;
        private final StorageStatsManager mStorageStatsManager;
        private final UserManager mUm;
        private final VolumeInfo mVolume;
        final /* synthetic */ AppCollector this$0;

        BackgroundHandler(AppCollector r1, Looper looper, VolumeInfo volume, PackageManager pm, UserManager um, StorageStatsManager storageStatsManager) {
            this.this$0 = r1;
            super(looper);
            this.mVolume = volume;
            this.mPm = pm;
            this.mUm = um;
            this.mStorageStatsManager = storageStatsManager;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L5;
                default: goto L27;
            };
        L5:
            ArrayList r0 = new ArrayList();
            List<UserInfo> users = this.mUm.getUsers();
            int userCount = 0;
            int userSize = users.size();
        L6:
            if (userCount >= userSize) goto L18;
            UserInfo user = users.get(userCount);
            List<ApplicationInfo> apps = this.mPm.getInstalledApplicationsAsUser(512, user.id);
            int appCount = 0;
            int size = apps.size();
        L8:
            if (appCount >= size) goto L17;
            ApplicationInfo app = apps.get(appCount);
            if (Objects.equals(app.volumeUuid, this.mVolume.getFsUuid()) == false) goto L16;
            StorageStats storageStats = this.mStorageStatsManager.queryStatsForPackage(app.storageUuid, app.packageName, user.getUserHandle());     // Catch: Throwable -> L14
            PackageStats packageStats = new PackageStats(app.packageName, user.id);     // Catch: Throwable -> L14
            packageStats.cacheSize = storageStats.getCacheBytes();     // Catch: Throwable -> L14
            packageStats.codeSize = storageStats.getAppBytes();     // Catch: Throwable -> L14
            packageStats.dataSize = storageStats.getDataBytes();     // Catch: Throwable -> L14
            r0.add(packageStats);     // Catch: Throwable -> L14
        L14:
            e = move-exception;
            Log.e(AppCollector.m8418$$Nest$sfgetTAG(), "An exception occurred while fetching app size", e);
        L16:
            appCount = appCount + 1;
            goto L8
        L17:
            userCount = userCount + 1;
            goto L6
        L18:
            AppCollector.m8417$$Nest$fgetmStats(this.this$0).complete(r0);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ CompletableFuture m8417$$Nest$fgetmStats(AppCollector r0) {
        return r0.mStats;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8418$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = "AppCollector";
    }

    public AppCollector(Context context, VolumeInfo volume) {
        volume.getClass();
        this.mBackgroundHandler = new BackgroundHandler(this, BackgroundThread.get().getLooper(), volume, context.getPackageManager(), (UserManager) context.getSystemService("user"), (StorageStatsManager) context.getSystemService("storagestats"));
    }

    public List<PackageStats> getPackageStats(long timeoutMillis) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mStats != null) goto L8;
        this.mStats = new CompletableFuture();     // Catch: Throwable -> L6
        this.mBackgroundHandler.sendEmptyMessage(0);     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        List<PackageStats> value = this.mStats.get(timeoutMillis, TimeUnit.MILLISECONDS);     // Catch: TimeoutException -> L13 Throwable -> L15
        goto L17
    L26:
        return value;
    L15:
        e = move-exception;
        Log.e(TAG, "An exception occurred while getting app storage", e);
        return null;
    L17:
        Log.e(TAG, "AppCollector timed out");
        return null;
    }
}
