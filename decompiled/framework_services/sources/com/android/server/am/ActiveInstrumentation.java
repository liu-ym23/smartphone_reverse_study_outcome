package com.android.server.am;

import android.app.IInstrumentationWatcher;
import android.app.IUiAutomationConnection;
import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.PrintWriterPrinter;
import android.util.proto.ProtoOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class ActiveInstrumentation {
    Bundle mArguments;
    ComponentName mClass;
    Bundle mCurResults;
    boolean mFinished;
    boolean mHasBackgroundActivityStartsPermission;
    boolean mHasBackgroundForegroundServiceStartsPermission;
    boolean mIsSdkInSandbox;
    boolean mNoRestart;
    String mProfileFile;
    ComponentName mResultClass;
    final ArrayList<ProcessRecord> mRunningProcesses;
    final ActivityManagerService mService;
    int mSourceUid;
    ApplicationInfo mTargetInfo;
    String[] mTargetProcesses;
    IUiAutomationConnection mUiAutomationConnection;
    IInstrumentationWatcher mWatcher;

    ActiveInstrumentation(ActivityManagerService service) {
        this.mRunningProcesses = new ArrayList();
        this.mService = service;
    }

    void removeProcess(ProcessRecord proc) {
        this.mFinished = true;
        this.mRunningProcesses.remove(proc);
        if (this.mRunningProcesses.size() != 0) goto L6;
        this.mService.mActiveInstrumentation.remove(this);
        return;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("ActiveInstrumentation{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(' ');
        sb.append(this.mClass.toShortString());
        if (this.mFinished == false) goto L5;
        sb.append(" FINISHED");
    L5:
        sb.append(" ");
        sb.append(this.mRunningProcesses.size());
        sb.append(" procs");
        sb.append('}');
        return sb.toString();
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("mClass=");
        pw.print(this.mClass);
        pw.print(" mFinished=");
        pw.println(this.mFinished);
        pw.print(prefix);
        pw.println("mRunningProcesses:");
        int i = 0;
    L4:
        if (i >= this.mRunningProcesses.size()) goto L6;
        pw.print(prefix);
        pw.print("  #");
        pw.print(i);
        pw.print(": ");
        pw.println(this.mRunningProcesses.get(i));
        i = i + 1;
        goto L4
    L6:
        pw.print(prefix);
        pw.print("mTargetProcesses=");
        pw.println(Arrays.toString(this.mTargetProcesses));
        pw.print(prefix);
        pw.print("mTargetInfo=");
        pw.println(this.mTargetInfo);
        if (this.mTargetInfo == null) goto L10;
        this.mTargetInfo.dump(new PrintWriterPrinter(pw), prefix + "  ", 0);
    L10:
        if (this.mProfileFile == null) goto L13;
        pw.print(prefix);
        pw.print("mProfileFile=");
        pw.println(this.mProfileFile);
    L13:
        if (this.mWatcher == null) goto L16;
        pw.print(prefix);
        pw.print("mWatcher=");
        pw.println(this.mWatcher);
    L16:
        if (this.mUiAutomationConnection == null) goto L18;
        pw.print(prefix);
        pw.print("mUiAutomationConnection=");
        pw.println(this.mUiAutomationConnection);
    L18:
        pw.print("mHasBackgroundActivityStartsPermission=");
        pw.println(this.mHasBackgroundActivityStartsPermission);
        pw.print("mHasBackgroundForegroundServiceStartsPermission=");
        pw.println(this.mHasBackgroundForegroundServiceStartsPermission);
        pw.print(prefix);
        pw.print("mArguments=");
        pw.println(this.mArguments);
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        this.mClass.dumpDebug(proto, 1146756268033L);
        proto.write(1133871366146L, this.mFinished);
        int i = 0;
    L4:
        if (i >= this.mRunningProcesses.size()) goto L6;
        this.mRunningProcesses.get(i).dumpDebug(proto, 2246267895811L);
        i = i + 1;
        goto L4
    L6:
        String[] r2 = this.mTargetProcesses;
        int r3 = r2.length;
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L10;
        String p = r2[r5];
        proto.write(2237677961220L, p);
        r5 = r5 + 1;
        goto L7
    L10:
        if (this.mTargetInfo == null) goto L12;
        this.mTargetInfo.dumpDebug(proto, 1146756268037L, 0);
    L12:
        proto.write(1138166333446L, this.mProfileFile);
        proto.write(1138166333447L, this.mWatcher.toString());
        proto.write(1138166333448L, this.mUiAutomationConnection.toString());
        if (this.mArguments == null) goto L15;
        this.mArguments.dumpDebug(proto, 1146756268042L);
    L15:
        proto.end(token);
    }
}
