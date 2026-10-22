package com.android.server.locksettings.recoverablekeystore;

import android.app.PendingIntent;
import android.util.ArraySet;
import android.util.Log;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
public class RecoverySnapshotListenersStorage {
    private static final String TAG = "RecoverySnapshotLstnrs";
    private SparseArray<PendingIntent> mAgentIntents;
    private ArraySet<Integer> mAgentsWithPendingSnapshots;

    public RecoverySnapshotListenersStorage() {
        this.mAgentIntents = new SparseArray();
        this.mAgentsWithPendingSnapshots = new ArraySet();
    }

    public synchronized void setSnapshotListener(int recoveryAgentUid, PendingIntent intent) {
        monitor-enter(this);
        Log.i(TAG, "Registered listener for agent with uid " + recoveryAgentUid);     // Catch: Throwable -> L7
        this.mAgentIntents.put(recoveryAgentUid, intent);     // Catch: Throwable -> L7
        if (this.mAgentsWithPendingSnapshots.contains(Integer.valueOf(recoveryAgentUid)) == false) goto L9;
        Log.i(TAG, "Snapshot already created for agent. Immediately triggering intent.");     // Catch: Throwable -> L7
        tryToSendIntent(recoveryAgentUid, intent);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized boolean hasListener(int recoveryAgentUid) {
        monitor-enter(this);
        if (this.mAgentIntents.get(recoveryAgentUid) == null) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void recoverySnapshotAvailable(int recoveryAgentUid) {
        monitor-enter(this);
        PendingIntent intent = this.mAgentIntents.get(recoveryAgentUid);     // Catch: Throwable -> L8
        if (intent != null) goto L10;
        Log.i(TAG, "Snapshot available for agent " + recoveryAgentUid + " but agent has not yet initialized. Will notify agent when it does.");     // Catch: Throwable -> L8
        this.mAgentsWithPendingSnapshots.add(Integer.valueOf(recoveryAgentUid));     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        tryToSendIntent(recoveryAgentUid, intent);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private synchronized void tryToSendIntent(int recoveryAgentUid, PendingIntent intent) {
        monitor-enter(this);
        intent.send();     // Catch: Throwable -> L5 PendingIntent.CanceledException -> L7
        this.mAgentsWithPendingSnapshots.remove(Integer.valueOf(recoveryAgentUid));     // Catch: Throwable -> L5 PendingIntent.CanceledException -> L7
        Log.d(TAG, "Successfully notified listener.");     // Catch: Throwable -> L5 PendingIntent.CanceledException -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        e = move-exception;
        Log.e(TAG, "Failed to trigger PendingIntent for " + recoveryAgentUid, e);     // Catch: Throwable -> L5
        this.mAgentsWithPendingSnapshots.add(Integer.valueOf(recoveryAgentUid));     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }
}
