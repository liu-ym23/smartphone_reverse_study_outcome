package com.android.server.companion.virtual;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.util.SparseArray;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class VirtualDeviceLog {
    private static final DateTimeFormatter DATE_FORMAT = null;
    private static final int MAX_ENTRIES = 16;
    public static int TYPE_CLOSED = 0;
    public static int TYPE_CREATED = 0;
    private static final String VIRTUAL_DEVICE_OWNER_SYSTEM = "system";
    private final Context mContext;
    private final ArrayDeque<LogEntry> mLogEntries;

    static class LogEntry {
        private final int mDeviceId;
        private final int mOwnerUid;
        private final long mTimestamp;
        private final int mType;

        LogEntry(int type, int deviceId, long timestamp, int ownerUid) {
            this.mType = type;
            this.mDeviceId = deviceId;
            this.mTimestamp = timestamp;
            this.mOwnerUid = ownerUid;
        }

        void dump(PrintWriter pw, String prefix, UidToPackageNameCache packageNameCache) {
            StringBuilder sb = new StringBuilder(prefix);
            sb.append(VirtualDeviceLog.m3015$$Nest$sfgetDATE_FORMAT().format(Instant.ofEpochMilli(this.mTimestamp)));
            sb.append(" - ");
            if (this.mType != VirtualDeviceLog.TYPE_CREATED) goto L5;
            String r1 = "START";
        L6:
            sb.append(r1);
            sb.append(" Device ID: ");
            sb.append(this.mDeviceId);
            sb.append(" ");
            sb.append(this.mOwnerUid);
            sb.append(" (");
            sb.append(packageNameCache.getPackageName(this.mOwnerUid));
            sb.append(")");
            pw.println(sb);
            return;
        L5:
            r1 = "CLOSE";
            goto L6
        }
    }

    private static class UidToPackageNameCache {
        private final PackageManager mPackageManager;
        private final SparseArray<String> mUidToPackagesCache;

        public UidToPackageNameCache(PackageManager packageManager) {
            this.mUidToPackagesCache = new SparseArray();
            this.mPackageManager = packageManager;
        }

        String getPackageName(int ownerUid) {
            if (this.mUidToPackagesCache.contains(ownerUid) == false) goto L7;
            return this.mUidToPackagesCache.get(ownerUid);
        L7:
            if (ownerUid != 1000) goto L10;
            return "system";
        L10:
            String[] packages = this.mPackageManager.getPackagesForUid(ownerUid);
            String packageName = "";
            if (packages != null) goto L13;
        L17:
            this.mUidToPackagesCache.put(ownerUid, packageName);
            return packageName;
        L13:
            if (packages.length <= 0) goto L17;
            packageName = packages[0];
            if (packages.length <= 1) goto L17;
            packageName = packageName + ",...";
            goto L17
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDATE_FORMAT, reason: not valid java name */
    static /* bridge */ /* synthetic */ DateTimeFormatter m3015$$Nest$sfgetDATE_FORMAT() {
        return DATE_FORMAT;
    }

    static {
        TYPE_CREATED = 0;
        TYPE_CLOSED = 1;
        DATE_FORMAT = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss.SSS").withZone(ZoneId.systemDefault());
    }

    VirtualDeviceLog(Context context) {
        this.mLogEntries = new ArrayDeque();
        this.mContext = context;
    }

    void logCreated(int deviceId, int ownerUid) {
        long token = Binder.clearCallingIdentity();
        addEntry(new LogEntry(TYPE_CREATED, deviceId, System.currentTimeMillis(), ownerUid));     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return;
    L8:
        th = move-exception;
        Throwable r10 = th;
    L12:
        Binder.restoreCallingIdentity(token);
        throw r10;
    L10:
        th = move-exception;
        r10 = th;
        goto L12
    }

    void logClosed(int deviceId, int ownerUid) {
        long token = Binder.clearCallingIdentity();
        addEntry(new LogEntry(TYPE_CLOSED, deviceId, System.currentTimeMillis(), ownerUid));     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return;
    L8:
        th = move-exception;
        Throwable r10 = th;
    L12:
        Binder.restoreCallingIdentity(token);
        throw r10;
    L10:
        th = move-exception;
        r10 = th;
        goto L12
    }

    private void addEntry(LogEntry entry) {
        this.mLogEntries.push(entry);
        if (this.mLogEntries.size() <= 16) goto L6;
        this.mLogEntries.removeLast();
        return;
    }

    void dump(PrintWriter pw) {
        long token = Binder.clearCallingIdentity();
        pw.println("VirtualDevice Log:");     // Catch: Throwable -> L8
        UidToPackageNameCache packageNameCache = new UidToPackageNameCache(this.mContext.getPackageManager());     // Catch: Throwable -> L8
        Iterator<LogEntry> r3 = this.mLogEntries.iterator();     // Catch: Throwable -> L8
    L5:
        if (r3.hasNext() == false) goto L10;
        LogEntry logEntry = r3.next();     // Catch: Throwable -> L8
        logEntry.dump(pw, "  ", packageNameCache);     // Catch: Throwable -> L8
        goto L5
    L10:
        Binder.restoreCallingIdentity(token);
        return;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }
}
