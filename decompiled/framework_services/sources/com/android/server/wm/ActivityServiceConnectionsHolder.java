package com.android.server.wm;

import android.util.ArraySet;
import android.util.Slog;
import java.io.PrintWriter;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityServiceConnectionsHolder<T> {
    private final ActivityRecord mActivity;
    private ArraySet<T> mConnections;
    private volatile boolean mIsDisconnecting;

    public static /* synthetic */ void $r8$lambda$EAi9VnxAGZQWsXgEuAgaGKr7s5k(ActivityServiceConnectionsHolder r0) {
        r0.lambda$disconnectActivityFromServices$0();
    }

    ActivityServiceConnectionsHolder(ActivityRecord activity) {
        this.mActivity = activity;
    }

    public void addConnection(T c) {
        ActivityRecord r0 = this.mActivity;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDisconnecting == false) goto L14;
        if (ActivityTaskManagerDebugConfig.DEBUG_CLEANUP == false) goto L11;
        Slog.e("ActivityTaskManager", "Skip adding connection " + c + " to a disconnecting holder of " + this.mActivity);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        if (this.mConnections != null) goto L16;
        this.mConnections = new ArraySet();     // Catch: Throwable -> L9
    L16:
        this.mConnections.add(c);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void removeConnection(T c) {
        ActivityRecord r0 = this.mActivity;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnections != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (ActivityTaskManagerDebugConfig.DEBUG_CLEANUP == true) goto L13;
    L15:
        this.mConnections.remove(c);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        if (this.mIsDisconnecting == false) goto L15;
        Slog.v("ActivityTaskManager", "Remove pending disconnecting " + c + " of " + this.mActivity);     // Catch: Throwable -> L8
        goto L15
    }

    public boolean isActivityVisible() {
        return this.mActivity.mVisibleForServiceConnection;
    }

    public int getActivityPid() {
        WindowProcessController wpc = this.mActivity.app;
        if (wpc != null) goto L7;
        return -1;
    L7:
        return wpc.getPid();
    }

    public void forEachConnection(Consumer<T> r4) {
        ActivityRecord r0 = this.mActivity;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnections == null) goto L18;
        if (this.mConnections.isEmpty() == true) goto L18;
        ArraySet<T> connections = new ArraySet(this.mConnections);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        int i = connections.size() - 1;
    L12:
        if (i < 0) goto L15;
        r4.accept(connections.valueAt(i));
        i = i - 1;
        goto L12
    L15:
        return;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    void disconnectActivityFromServices() {
        if (this.mConnections != null) goto L5;
        return;
    L5:
        if (this.mConnections.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.mIsDisconnecting == true) goto L13;
        this.mIsDisconnecting = true;
        this.mActivity.mAtmService.mH.post(new ActivityServiceConnectionsHolder$$ExternalSyntheticLambda0(this));
        return;
    }

    private /* synthetic */ void lambda$disconnectActivityFromServices$0() {
        this.mActivity.mAtmService.mAmInternal.disconnectActivityFromServices(this);
        this.mIsDisconnecting = false;
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "activity=" + this.mActivity);
    }

    public String toString() {
        ActivityRecord r0 = this.mActivity;
        monitor-enter(r0);
        String r1 = String.valueOf(this.mConnections);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
