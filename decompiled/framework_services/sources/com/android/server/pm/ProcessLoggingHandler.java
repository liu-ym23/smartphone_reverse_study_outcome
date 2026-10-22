package com.android.server.pm;

import android.app.admin.SecurityLog;
import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManagerInternal;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.os.BackgroundThread;
import com.android.server.scene.SceneUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcessLoggingHandler extends Handler {
    private static final int CHECKSUM_TYPE = 8;
    private static final String TAG = "ProcessLoggingHandler";
    private final Executor mExecutor;
    private final ArrayMap<String, LoggingInfo> mLoggingInfo;

    static class LoggingInfo {
        public String apkHash;
        public List<Bundle> pendingLogEntries;

        LoggingInfo() {
            this.apkHash = null;
            this.pendingLogEntries = new ArrayList();
        }
    }

    public static /* synthetic */ void $r8$lambda$AvUERcGr5gHBcuRst_1sEcdv8JM(ProcessLoggingHandler r0, LoggingInfo r1) {
        r0.lambda$enqueueProcessChecksum$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$uJ1-rR95R1RTlca2CWtk9awMWZw, reason: not valid java name */
    public static /* synthetic */ void m6886$r8$lambda$uJ1rR95R1RTlca2CWtk9awMWZw(ProcessLoggingHandler r0, Bundle r1, String r2) {
        r0.lambda$enqueueSecurityLogEvent$1(r1, r2);
    }

    ProcessLoggingHandler() {
        super(BackgroundThread.getHandler().getLooper());
        this.mExecutor = new HandlerExecutor(this);
        this.mLoggingInfo = new ArrayMap();
    }

    void logAppProcessStart(Context context, PackageManagerInternal pmi, String apkFile, String packageName, String processName, int uid, String seinfo, int pid) {
        Bundle data = new Bundle();
        data.putLong("startTimestamp", System.currentTimeMillis());
        data.putString("processName", processName);
        data.putInt("uid", uid);
        data.putString("seinfo", seinfo);
        data.putInt(SceneUtils.KEY_PID, pid);
        if (apkFile != null) goto L6;
        enqueueSecurityLogEvent(data, "No APK");
        return;
    L6:
        ArrayMap<String, LoggingInfo> r2 = this.mLoggingInfo;
        monitor-enter(r2);
        LoggingInfo cached = this.mLoggingInfo.get(apkFile);     // Catch: Throwable -> L15
        if (cached != null) goto L11;
        boolean r3 = true;
    L12:
        boolean requestChecksums = r3;
        if (requestChecksums == false) goto L17;
        cached = new LoggingInfo();     // Catch: Throwable -> L15
        this.mLoggingInfo.put(apkFile, cached);     // Catch: Throwable -> L15
    L17:
        final LoggingInfo loggingInfo = cached;
        monitor-exit(r2);     // Catch: Throwable -> L15
        monitor-enter(loggingInfo);
    L41:
        th = th;
    L57:
        monitor-exit(loggingInfo);     // Catch: Throwable -> L45
        throw th;
    L45:
        th = th;
        goto L57
    L21:
        if (TextUtils.isEmpty(loggingInfo.apkHash) == false) goto L49;
        loggingInfo.pendingLogEntries.add(data);     // Catch: Throwable -> L41
        monitor-exit(loggingInfo);     // Catch: Throwable -> L41
        if (requestChecksums == true) goto L55;
        return;
    L55:
        LoggingInfo loggingInfo2 = loggingInfo;
        pmi.requestChecksums(packageName, false, 0, 8, null, new AnonymousClass1(this, loggingInfo), context.getUserId(), this.mExecutor, this);     // Catch: Throwable -> L35
        return;
    L35:
        t = th;
    L39:
        Slog.e(TAG, "requestChecksums() failed", t);
        enqueueProcessChecksum(loggingInfo2, null);
        return;
    L37:
        t = th;
        loggingInfo2 = loggingInfo;
        goto L39
    L49:
        enqueueSecurityLogEvent(data, loggingInfo.apkHash);     // Catch: Throwable -> L25
        monitor-exit(loggingInfo);     // Catch: Throwable -> L25
        return;
    L25:
        th = th;
        goto L57
    L11:
        r3 = false;
    L15:
        th = move-exception;
        throw th;
    }

    void processChecksums(LoggingInfo loggingInfo, List<ApkChecksum> checksums) {
        int i = 0;
        int size = checksums.size();
    L3:
        if (i >= size) goto L9;
        ApkChecksum checksum = checksums.get(i);
        if (checksum.getType() == 8) goto L6;
        i = i + 1;
        goto L3
    L6:
        processChecksum(loggingInfo, checksum.getValue());
        return;
    L9:
        Slog.e(TAG, "requestChecksums() failed to return SHA256, see logs for details.");
        processChecksum(loggingInfo, null);
    }

    private /* synthetic */ void lambda$enqueueProcessChecksum$0(LoggingInfo loggingInfo) {
        processChecksum(loggingInfo, null);
    }

    void enqueueProcessChecksum(final LoggingInfo loggingInfo, byte[] hash) {
        post(new ProcessLoggingHandler$$ExternalSyntheticLambda1(this, loggingInfo));
    }

    void processChecksum(LoggingInfo loggingInfo, byte[] hash) {
        if (hash == null) goto L8;
        StringBuilder sb = new StringBuilder();
        int i = 0;
    L5:
        if (i >= hash.length) goto L7;
        sb.append(String.format("%02x", new Object[]{Byte.valueOf(hash[i])}));
        i = i + 1;
        goto L5
    L7:
        String apkHash = sb.toString();
    L9:
        monitor-enter(loggingInfo);
    L14:
        th = move-exception;
        throw th;
    L11:
        if (TextUtils.isEmpty(loggingInfo.apkHash) == true) goto L16;
        monitor-exit(loggingInfo);     // Catch: Throwable -> L14
        return;
    L16:
        loggingInfo.apkHash = apkHash;     // Catch: Throwable -> L14
        List<Bundle> pendingLogEntries = loggingInfo.pendingLogEntries;     // Catch: Throwable -> L14
        loggingInfo.pendingLogEntries = null;     // Catch: Throwable -> L14
        monitor-exit(loggingInfo);     // Catch: Throwable -> L14
        if (pendingLogEntries == null) goto L23;
        Iterator<Bundle> r2 = pendingLogEntries.iterator();
    L21:
        if (r2.hasNext() == false) goto L29;
        Bundle data = r2.next();
        logSecurityLogEvent(data, apkHash);
        goto L21
    L29:
        return;
    L23:
        return;
    L8:
        apkHash = "Failed to count APK hash";
        goto L9
    }

    void invalidateBaseApkHash(String apkFile) {
        ArrayMap<String, LoggingInfo> r0 = this.mLoggingInfo;
        monitor-enter(r0);
        this.mLoggingInfo.remove(apkFile);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$enqueueSecurityLogEvent$1(Bundle data, String apkHash) {
        logSecurityLogEvent(data, apkHash);
    }

    void enqueueSecurityLogEvent(final Bundle data, final String apkHash) {
        post(new ProcessLoggingHandler$$ExternalSyntheticLambda0(this, data, apkHash));
    }

    void logSecurityLogEvent(Bundle bundle, String apkHash) {
        long startTimestamp = bundle.getLong("startTimestamp");
        String processName = bundle.getString("processName");
        int uid = bundle.getInt("uid");
        String seinfo = bundle.getString("seinfo");
        int pid = bundle.getInt(SceneUtils.KEY_PID);
        SecurityLog.writeEvent(210005, new Object[]{processName, Long.valueOf(startTimestamp), Integer.valueOf(uid), Integer.valueOf(pid), seinfo, apkHash});
    }
}
