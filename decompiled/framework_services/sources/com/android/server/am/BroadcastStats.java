package com.android.server.am;

import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.TimeUtils;
import dalvik.annotation.optimization.NeverCompile;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class BroadcastStats {
    static final Comparator<ActionEntry> ACTIONS_COMPARATOR = null;
    final ArrayMap<String, ActionEntry> mActions;
    long mEndRealtime;
    long mEndUptime;
    final long mStartRealtime;
    final long mStartUptime;

    static final class ActionEntry {
        final String mAction;
        final ArrayMap<String, ViolationEntry> mBackgroundCheckViolations;
        long mMaxDispatchTime;
        final ArrayMap<String, PackageEntry> mPackages;
        int mReceiveCount;
        int mSkipCount;
        long mTotalDispatchTime;

        ActionEntry(String action) {
            this.mPackages = new ArrayMap();
            this.mBackgroundCheckViolations = new ArrayMap();
            this.mAction = action;
        }
    }

    static final class PackageEntry {
        int mSendCount;

        PackageEntry() {
        }
    }

    static final class ViolationEntry {
        int mCount;

        ViolationEntry() {
        }
    }

    static {
        ACTIONS_COMPARATOR = new AnonymousClass1();
    }

    public BroadcastStats() {
        this.mActions = new ArrayMap();
        this.mStartRealtime = SystemClock.elapsedRealtime();
        this.mStartUptime = SystemClock.uptimeMillis();
    }

    public void addBroadcast(String action, String srcPackage, int receiveCount, int skipCount, long dispatchTime) {
        ActionEntry ae = this.mActions.get(action);
        if (ae != null) goto L5;
        ae = new ActionEntry(action);
        this.mActions.put(action, ae);
    L5:
        ae.mReceiveCount += receiveCount;
        ae.mSkipCount += skipCount;
        ae.mTotalDispatchTime += dispatchTime;
        if (ae.mMaxDispatchTime >= dispatchTime) goto L8;
        ae.mMaxDispatchTime = dispatchTime;
    L8:
        PackageEntry pe = ae.mPackages.get(srcPackage);
        if (pe != null) goto L11;
        pe = new PackageEntry();
        ae.mPackages.put(srcPackage, pe);
    L11:
        pe.mSendCount++;
    }

    public void addBackgroundCheckViolation(String action, String targetPackage) {
        ActionEntry ae = this.mActions.get(action);
        if (ae != null) goto L5;
        ae = new ActionEntry(action);
        this.mActions.put(action, ae);
    L5:
        ViolationEntry ve = ae.mBackgroundCheckViolations.get(targetPackage);
        if (ve != null) goto L8;
        ve = new ViolationEntry();
        ae.mBackgroundCheckViolations.put(targetPackage, ve);
    L8:
        ve.mCount++;
    }

    @NeverCompile
    public boolean dumpStats(PrintWriter pw, String prefix, String dumpPackage) {
        boolean printedSomething = false;
        ArrayList<ActionEntry> actions = new ArrayList(this.mActions.size());
        int i = this.mActions.size() - 1;
    L3:
        if (i < 0) goto L5;
        actions.add(this.mActions.valueAt(i));
        i = i - 1;
        goto L3
    L5:
        Collections.sort(actions, ACTIONS_COMPARATOR);
        int i2 = actions.size() - 1;
    L6:
        if (i2 < 0) goto L21;
        ActionEntry ae = actions.get(i2);
        if (dumpPackage != null) goto L10;
    L12:
        printedSomething = true;
        pw.print(prefix);
        pw.print(ae.mAction);
        pw.println(":");
        pw.print(prefix);
        pw.print("  Number received: ");
        pw.print(ae.mReceiveCount);
        pw.print(", skipped: ");
        pw.println(ae.mSkipCount);
        pw.print(prefix);
        pw.print("  Total dispatch time: ");
        TimeUtils.formatDuration(ae.mTotalDispatchTime, pw);
        pw.print(", max: ");
        TimeUtils.formatDuration(ae.mMaxDispatchTime, pw);
        pw.println();
        int j = ae.mPackages.size();
    L13:
        j = j - 1;
        if (j < 0) goto L16;
        pw.print(prefix);
        pw.print("  Package ");
        pw.print(ae.mPackages.keyAt(j));
        pw.print(": ");
        PackageEntry pe = ae.mPackages.valueAt(j);
        pw.print(pe.mSendCount);
        pw.println(" times");
        goto L13
    L16:
        int j2 = ae.mBackgroundCheckViolations.size() - 1;
    L17:
        if (j2 < 0) goto L19;
        pw.print(prefix);
        pw.print("  Bg Check Violation ");
        pw.print(ae.mBackgroundCheckViolations.keyAt(j2));
        pw.print(": ");
        ViolationEntry ve = ae.mBackgroundCheckViolations.valueAt(j2);
        pw.print(ve.mCount);
        pw.println(" times");
        j2 = j2 - 1;
    L19:
        i2 = i2 - 1;
        goto L6
    L10:
        if (ae.mPackages.containsKey(dumpPackage) == true) goto L12;
    L21:
        return printedSomething;
    }

    @NeverCompile
    public void dumpCheckinStats(PrintWriter pw, String dumpPackage) {
        pw.print("broadcast-stats,1,");
        pw.print(this.mStartRealtime);
        pw.print(",");
        if (this.mEndRealtime != 0) goto L5;
        long r1 = SystemClock.elapsedRealtime();
    L6:
        pw.print(r1);
        pw.print(",");
        if (this.mEndUptime != 0) goto L9;
        long r2 = SystemClock.uptimeMillis();
    L10:
        pw.println(r2 - this.mStartUptime);
        int i = this.mActions.size() - 1;
    L11:
        if (i < 0) goto L25;
        ActionEntry ae = this.mActions.valueAt(i);
        if (dumpPackage != null) goto L15;
    L17:
        pw.print("a,");
        pw.print(this.mActions.keyAt(i));
        pw.print(",");
        pw.print(ae.mReceiveCount);
        pw.print(",");
        pw.print(ae.mSkipCount);
        pw.print(",");
        pw.print(ae.mTotalDispatchTime);
        pw.print(",");
        pw.print(ae.mMaxDispatchTime);
        pw.println();
        int j = ae.mPackages.size() - 1;
    L18:
        if (j < 0) goto L20;
        pw.print("p,");
        pw.print(ae.mPackages.keyAt(j));
        PackageEntry pe = ae.mPackages.valueAt(j);
        pw.print(",");
        pw.print(pe.mSendCount);
        pw.println();
        j = j - 1;
        goto L18
    L20:
        int j2 = ae.mBackgroundCheckViolations.size() - 1;
    L21:
        if (j2 < 0) goto L23;
        pw.print("v,");
        pw.print(ae.mBackgroundCheckViolations.keyAt(j2));
        ViolationEntry ve = ae.mBackgroundCheckViolations.valueAt(j2);
        pw.print(",");
        pw.print(ve.mCount);
        pw.println();
        j2 = j2 - 1;
    L23:
        i = i - 1;
        goto L11
    L15:
        if (ae.mPackages.containsKey(dumpPackage) == true) goto L17;
    L25:
        return;
    L9:
        r2 = this.mEndUptime;
        goto L10
    L5:
        r1 = this.mEndRealtime;
        goto L6
    }
}
