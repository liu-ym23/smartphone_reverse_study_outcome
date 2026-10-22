package com.android.server.blob;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.UserHandle;
import android.text.format.TimeMigrationUtils;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
class BlobStoreUtils {
    private static final String DESC_RES_TYPE_STRING = "string";
    private static final Object sLock = null;
    private static Handler sRevocableFdHandler;

    BlobStoreUtils() {
    }

    static Resources getPackageResources(Context context, String packageName, int userId) {
        return context.createContextAsUser(UserHandle.of(userId), 0).getPackageManager().getResourcesForApplication(packageName);
    L4:
        e = move-exception;
        Slog.d(BlobStoreConfig.TAG, "Unknown package in user " + userId + ": " + packageName, e);
        return null;
    }

    static int getDescriptionResourceId(Resources resources, String resourceEntryName, String packageName) {
        return resources.getIdentifier(resourceEntryName, DESC_RES_TYPE_STRING, packageName);
    }

    static int getDescriptionResourceId(Context context, String resourceEntryName, String packageName, int userId) {
        Resources resources = getPackageResources(context, packageName, userId);
        if (resources != null) goto L6;
        return 0;
    L6:
        return getDescriptionResourceId(resources, resourceEntryName, packageName);
    }

    static String formatTime(long timeMs) {
        return TimeMigrationUtils.formatMillisWithFixedFormat(timeMs);
    }

    static {
        sLock = new Object();
    }

    static Handler getRevocableFdHandler() {
        Object r0 = sLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sRevocableFdHandler == null) goto L11;
        Handler r1 = sRevocableFdHandler;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        HandlerThread t = new HandlerThread("BlobFuseLooper");     // Catch: Throwable -> L9
        t.start();     // Catch: Throwable -> L9
        sRevocableFdHandler = new Handler(t.getLooper());     // Catch: Throwable -> L9
        Handler r2 = sRevocableFdHandler;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    }
}
