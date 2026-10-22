package com.android.server.appfunctions;

import android.app.appsearch.AppSearchManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataSyncPerUser {
    private static final String TAG = null;
    private static final Object sLock = null;
    private static final SparseArray<MetadataSyncAdapter> sPerUserMetadataSyncAdapter = null;

    public MetadataSyncPerUser() {
    }

    static {
        TAG = MetadataSyncPerUser.class.getSimpleName();
        sPerUserMetadataSyncAdapter = new SparseArray();
        sLock = new Object();
    }

    public static MetadataSyncAdapter getPerUserMetadataSyncAdapter(UserHandle user, Context userContext) {
        Object r0 = sLock;
        monitor-enter(r0);
        MetadataSyncAdapter metadataSyncAdapter = sPerUserMetadataSyncAdapter.get(user.getIdentifier(), null);     // Catch: Throwable -> L11
        if (metadataSyncAdapter != null) goto L13;
        AppSearchManager perUserAppSearchManager = (AppSearchManager) userContext.getSystemService(AppSearchManager.class);     // Catch: Throwable -> L11
        PackageManager perUserPackageManager = userContext.getPackageManager();     // Catch: Throwable -> L11
        if (perUserAppSearchManager == null) goto L13;
        MetadataSyncAdapter metadataSyncAdapter2 = new MetadataSyncAdapter(perUserPackageManager, perUserAppSearchManager);     // Catch: Throwable -> L11
        sPerUserMetadataSyncAdapter.put(user.getIdentifier(), metadataSyncAdapter2);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return metadataSyncAdapter2;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return metadataSyncAdapter;
    L11:
        th = move-exception;
        throw th;
    }

    public static void removeUserSyncAdapter(UserHandle user) {
        Object r0 = sLock;
        monitor-enter(r0);
        MetadataSyncAdapter metadataSyncAdapter = sPerUserMetadataSyncAdapter.get(user.getIdentifier(), null);     // Catch: Throwable -> L7
        if (metadataSyncAdapter == null) goto L9;
        metadataSyncAdapter.shutDown();     // Catch: Throwable -> L7
        sPerUserMetadataSyncAdapter.remove(user.getIdentifier());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
