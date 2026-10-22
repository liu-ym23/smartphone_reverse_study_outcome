package com.android.server.location.contexthub;

import android.hardware.location.NanoAppInstanceInfo;
import android.hardware.location.NanoAppState;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class NanoAppStateManager {
    private static final boolean ENABLE_LOG_DEBUG = true;
    private static final String TAG = "NanoAppStateManager";
    private final HashMap<Integer, NanoAppInstanceInfo> mNanoAppHash;
    private int mNextHandle;

    NanoAppStateManager() {
        this.mNanoAppHash = new HashMap();
        this.mNextHandle = 0;
    }

    synchronized NanoAppInstanceInfo getNanoAppInstanceInfo(int nanoAppHandle) {
        monitor-enter(this);
        NanoAppInstanceInfo r0 = this.mNanoAppHash.get(Integer.valueOf(nanoAppHandle));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void foreachNanoAppInstanceInfo(Consumer<NanoAppInstanceInfo> consumer) {
        monitor-enter(this);
        Iterator<NanoAppInstanceInfo> r0 = this.mNanoAppHash.values().iterator();     // Catch: Throwable -> L8
    L5:
        if (r0.hasNext() == false) goto L10;
        NanoAppInstanceInfo info = r0.next();     // Catch: Throwable -> L8
        consumer.accept(info);     // Catch: Throwable -> L8
        goto L5
    L10:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized int getNanoAppHandle(int contextHubId, long nanoAppId) {
        monitor-enter(this);
        Iterator<NanoAppInstanceInfo> r0 = this.mNanoAppHash.values().iterator();     // Catch: Throwable -> L13
    L5:
        if (r0.hasNext() == false) goto L16;
        NanoAppInstanceInfo info = r0.next();     // Catch: Throwable -> L13
        if (info.getContexthubId() != contextHubId) goto L5;
        if (info.getAppId() != nanoAppId) goto L5;
        int r1 = info.getHandle();     // Catch: Throwable -> L13
        monitor-exit(this);
        return r1;
    L16:
        monitor-exit(this);
        return -1;
    L13:
        th = move-exception;
        throw th;
    }

    synchronized void addNanoAppInstance(int contextHubId, long nanoAppId, int nanoAppVersion) {
        monitor-enter(this);
        removeNanoAppInstance(contextHubId, nanoAppId);     // Catch: Throwable -> L8
        if (this.mNanoAppHash.size() != Integer.MAX_VALUE) goto L10;
        Log.e(TAG, "Error adding nanoapp instance: max limit exceeded");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        int nanoAppHandle = this.mNextHandle;     // Catch: Throwable -> L8
        int i = 0;
        int nanoAppHandle2 = nanoAppHandle;
    L11:
        if (i > Integer.MAX_VALUE) goto L24;
        int r9 = 0;
        if (this.mNanoAppHash.containsKey(Integer.valueOf(nanoAppHandle2)) == false) goto L14;
        int contextHubId2 = contextHubId;
        long nanoAppId2 = nanoAppId;
        int nanoAppVersion2 = nanoAppVersion;
        if (nanoAppHandle2 == Integer.MAX_VALUE) goto L23;
        r9 = nanoAppHandle2 + 1;     // Catch: Throwable -> L8
    L23:
        nanoAppHandle2 = r9;
        i = i + 1;     // Catch: Throwable -> L8
        nanoAppId = nanoAppId2;
        nanoAppVersion = nanoAppVersion2;
        contextHubId = contextHubId2;
        goto L11
    L14:
        int contextHubId3 = contextHubId;
        long nanoAppId3 = nanoAppId;
        int nanoAppVersion3 = nanoAppVersion;
        this.mNanoAppHash.put(Integer.valueOf(nanoAppHandle2), new NanoAppInstanceInfo(nanoAppHandle2, nanoAppId3, nanoAppVersion3, contextHubId3));     // Catch: Throwable -> L8
        if (nanoAppHandle2 == Integer.MAX_VALUE) goto L18;
        r9 = nanoAppHandle2 + 1;     // Catch: Throwable -> L8
    L18:
        this.mNextHandle = r9;     // Catch: Throwable -> L8
    L25:
        Log.v(TAG, "Added app instance with handle " + nanoAppHandle2 + " to hub " + contextHubId3 + ": ID=0x" + Long.toHexString(nanoAppId3) + ", version=0x" + Integer.toHexString(nanoAppVersion3));     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L24:
        contextHubId3 = contextHubId;
        nanoAppId3 = nanoAppId;
        nanoAppVersion3 = nanoAppVersion;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized void removeNanoAppInstance(int contextHubId, long nanoAppId) {
        monitor-enter(this);
        int nanoAppHandle = getNanoAppHandle(contextHubId, nanoAppId);     // Catch: Throwable -> L6
        this.mNanoAppHash.remove(Integer.valueOf(nanoAppHandle));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void updateCache(int contextHubId, List<NanoAppState> nanoappStateList) {
        monitor-enter(this);
        HashSet<Long> nanoAppIdSet = new HashSet();     // Catch: Throwable -> L7
        Iterator<NanoAppState> r1 = nanoappStateList.iterator();     // Catch: Throwable -> L7
    L5:
        if (r1.hasNext() == false) goto L9;
        NanoAppState nanoappState = r1.next();     // Catch: Throwable -> L7
        handleQueryAppEntry(contextHubId, nanoappState.getNanoAppId(), (int) nanoappState.getNanoAppVersion());     // Catch: Throwable -> L7
        nanoAppIdSet.add(Long.valueOf(nanoappState.getNanoAppId()));     // Catch: Throwable -> L7
        goto L5
    L9:
        Iterator<NanoAppInstanceInfo> iterator = this.mNanoAppHash.values().iterator();     // Catch: Throwable -> L7
    L10:
        if (iterator.hasNext() == false) goto L18;
        NanoAppInstanceInfo info = iterator.next();     // Catch: Throwable -> L7
        if (info.getContexthubId() != contextHubId) goto L10;
        if (nanoAppIdSet.contains(Long.valueOf(info.getAppId())) == true) goto L10;
        iterator.remove();     // Catch: Throwable -> L7
        goto L10
    L18:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void handleQueryAppEntry(int contextHubId, long nanoAppId, int nanoAppVersion) {
        int nanoAppHandle = getNanoAppHandle(contextHubId, nanoAppId);
        if (nanoAppHandle != (-1)) goto L5;
        addNanoAppInstance(contextHubId, nanoAppId, nanoAppVersion);
        return;
    L5:
        NanoAppInstanceInfo info = this.mNanoAppHash.get(Integer.valueOf(nanoAppHandle));
        if (info.getAppVersion() == nanoAppVersion) goto L9;
        this.mNanoAppHash.put(Integer.valueOf(nanoAppHandle), new NanoAppInstanceInfo(nanoAppHandle, nanoAppId, nanoAppVersion, contextHubId));
        Log.v(TAG, "Updated app instance with handle " + nanoAppHandle + " at hub " + contextHubId + ": ID=0x" + Long.toHexString(nanoAppId) + ", version=0x" + Integer.toHexString(nanoAppVersion));
        return;
    }
}
