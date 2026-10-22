package com.android.server.os;

import android.os.Binder;
import android.os.IBinder;
import android.os.ISchedulingPolicyService;
import android.os.Process;
import android.util.Log;
import com.android.server.SystemServerInitThreadPool;
import com.android.server.policy.WindowManagerPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class SchedulingPolicyService extends ISchedulingPolicyService.Stub {
    private static final String[] MEDIA_PROCESS_NAMES = null;
    private static final int PRIORITY_MAX = 3;
    private static final int PRIORITY_MIN = 1;
    private static final String TAG = "SchedulingPolicyService";
    private int mBoostedPid;
    private IBinder mClient;
    private final IBinder.DeathRecipient mDeathRecipient;

    public static /* synthetic */ void $r8$lambda$KlPgkKRnOe1m4zokkdzlozJ7zLQ(SchedulingPolicyService r0) {
        r0.lambda$new$0();
    }

    static {
        MEDIA_PROCESS_NAMES = new String[]{"media.swcodec"};
    }

    public SchedulingPolicyService() {
        this.mDeathRecipient = new AnonymousClass1(this);
        this.mBoostedPid = -1;
        SystemServerInitThreadPool.submit(new SchedulingPolicyService$$ExternalSyntheticLambda0(this), "SchedulingPolicyService.<init>");
    }

    private /* synthetic */ void lambda$new$0() {
        IBinder.DeathRecipient r0 = this.mDeathRecipient;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mBoostedPid != (-1)) goto L13;
        int[] nativePids = Process.getPidsForCommands(MEDIA_PROCESS_NAMES);     // Catch: Throwable -> L11
        if (nativePids == null) goto L13;
        if (nativePids.length != 1) goto L13;
        this.mBoostedPid = nativePids[0];     // Catch: Throwable -> L11
        disableCpusetBoost(nativePids[0]);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public int requestPriority(int pid, int tid, int prio, boolean isForApp) {
        if (isPermitted() == true) goto L5;
    L34:
        return -1;
    L5:
        if (prio < 1) goto L34;
        if (prio > 3) goto L34;
        if (Process.getThreadGroupLeader(tid) != pid) goto L34;
        if (Binder.getCallingUid() != 1041) goto L18;
        if (isForApp == true) goto L18;
        if (Process.getUidForPid(tid) == 1041) goto L18;
        return -1;
    L18:
        if (Binder.getCallingUid() == 1002) goto L37;
        if (isForApp == true) goto L21;
        int r0 = 4;
    L35:
        Process.setThreadGroup(tid, r0);     // Catch: RuntimeException -> L24
    L24:
        e = move-exception;
        Log.e(TAG, "Failed setThreadGroup: " + e);
        return -1;
    L21:
        r0 = 6;
    L37:
        Process.setThreadScheduler(tid, WindowManagerPolicy.COLOR_FADE_LAYER, prio);     // Catch: RuntimeException -> L31
        return 0;
    L31:
        e = move-exception;
        Log.e(TAG, "Failed setThreadScheduler: " + e);
        return -1;
    }

    public int requestCpusetBoost(boolean enable, IBinder client) {
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
    L7:
        int[] nativePids = Process.getPidsForCommands(MEDIA_PROCESS_NAMES);
        if (nativePids != null) goto L10;
    L26:
        Log.e(TAG, "requestCpusetBoost: can't find media.codec process");
        return -1;
    L10:
        if (nativePids.length != 1) goto L26;
        IBinder.DeathRecipient r1 = this.mDeathRecipient;
        monitor-enter(r1);
        if (enable == false) goto L21;
        int r2 = enableCpusetBoost(nativePids[0], client);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r2;
    L21:
        int r3 = disableCpusetBoost(nativePids[0]);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r3;
    L19:
        th = move-exception;
        throw th;
    L5:
        if (Binder.getCallingUid() == 1013) goto L7;
        return -1;
    }

    private int enableCpusetBoost(int pid, IBinder client) {
        if (this.mBoostedPid != pid) goto L5;
        return 0;
    L5:
        this.mBoostedPid = -1;
        if (this.mClient != null) goto L29;
    L25:
        client.linkToDeath(this.mDeathRecipient, 0);     // Catch: Exception -> L18
        Log.i(TAG, "Moving " + pid + " to group 5");     // Catch: Exception -> L18
        Process.setProcessGroup(pid, 5);     // Catch: Exception -> L18
        this.mBoostedPid = pid;     // Catch: Exception -> L18
        this.mClient = client;     // Catch: Exception -> L18
        return 0;
    L18:
        e = move-exception;
        Log.e(TAG, "Failed enableCpusetBoost: " + e);
        client.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Exception -> L22
    L24:
        return -1;
    L29:
        this.mClient.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L10 Exception -> L12
    L10:
        th = move-exception;
        this.mClient = null;
        throw th;
    L9:
        this.mClient = null;
        goto L25
    }

    private int disableCpusetBoost(int pid) {
        int boostedPid = this.mBoostedPid;
        this.mBoostedPid = -1;
        if (this.mClient != null) goto L21;
    L13:
        if (boostedPid == pid) goto L19;
    L18:
        return 0;
    L19:
        Log.i(TAG, "Moving " + pid + " back to group default");     // Catch: Exception -> L16
        Process.setProcessGroup(pid, -1);     // Catch: Exception -> L16
    L17:
        Log.w(TAG, "Couldn't move pid " + pid + " back to group default");
        goto L18
    L21:
        this.mClient.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L7 Exception -> L9
    L7:
        th = move-exception;
        this.mClient = null;
        throw th;
    L6:
        this.mClient = null;
        goto L13
    }

    private boolean isPermitted() {
        if (Binder.getCallingPid() != Process.myPid()) goto L6;
        return true;
    L6:
        switch(Binder.getCallingUid()) {
            case 1001: goto L9;
            case 1002: goto L9;
            case 1041: goto L9;
            case 1047: goto L9;
            default: goto L7;
        };
    L7:
        return false;
    L9:
        return true;
    }
}
