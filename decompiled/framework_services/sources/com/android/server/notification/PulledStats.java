package com.android.server.notification;

import android.os.ParcelFileDescriptor;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PulledStats {
    static final String TAG = "PulledStats";
    private long mTimePeriodEndMs;
    private final long mTimePeriodStartMs;
    private List<String> mUndecoratedPackageNames;

    public PulledStats(long startMs) {
        this.mTimePeriodStartMs = startMs;
        this.mTimePeriodEndMs = startMs;
        this.mUndecoratedPackageNames = new ArrayList();
    }

    ParcelFileDescriptor toParcelFileDescriptor(final int report) throws IOException {
        final ParcelFileDescriptor[] fds = ParcelFileDescriptor.createPipe();
        switch(report) {
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        Slog.w(TAG, "Unknown pulled stats request: " + report);
    L7:
        return fds[0];
    L5:
        final String r2 = "NotificationManager pulled metric output";
        Thread thr = new AnonymousClass1(this, r2, fds, report);
        thr.start();
        goto L7
    }

    public long endTimeMs() {
        return this.mTimePeriodEndMs;
    }

    public void dump(int report, PrintWriter pw, NotificationManagerService.DumpFilter filter) {
        switch(report) {
            case 1: goto L4;
            default: goto L3;
        };
    L3:
        pw.println("Unknown pulled stats request: " + report);
        return;
    L4:
        pw.print("  Packages with undecordated notifications (");
        pw.print(this.mTimePeriodStartMs);
        pw.print(" - ");
        pw.print(this.mTimePeriodEndMs);
        pw.println("):");
        if (this.mUndecoratedPackageNames.size() != 0) goto L7;
        pw.println("    none");
        return;
    L7:
        Iterator<String> r0 = this.mUndecoratedPackageNames.iterator();
    L9:
        if (r0.hasNext() == false) goto L25;
        String pkg = r0.next();
        if (filter.filtered == false) goto L14;
        if (pkg.equals(filter.pkgFilter) == false) goto L9;
    L14:
        pw.println("    " + pkg);
        goto L9
    }

    void writeToProto(int report, ProtoOutputStream proto) {
        switch(report) {
            case 1: goto L4;
            default: goto L3;
        };
    L3:
        Slog.w(TAG, "Unknown pulled stats request: " + report);
        return;
    L4:
        Iterator<String> r0 = this.mUndecoratedPackageNames.iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        String pkg = r0.next();
        long token = proto.start(2246267895809L);
        proto.write(1138166333441L, pkg);
        proto.end(token);
        goto L6
    }

    public void addUndecoratedPackage(String packageName, long timestampMs) {
        this.mUndecoratedPackageNames.add(packageName);
        this.mTimePeriodEndMs = Math.max(this.mTimePeriodEndMs, timestampMs);
    }
}
