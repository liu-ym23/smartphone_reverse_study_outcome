package com.android.server.am;

import android.app.IInstrumentationWatcher;
import android.content.ComponentName;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.job.controllers.JobStatus;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class InstrumentationReporter {
    static final boolean DEBUG = false;
    static final int REPORT_TYPE_FINISHED = 1;
    static final int REPORT_TYPE_STATUS = 0;
    static final String TAG = "ActivityManager";
    final Object mLock;
    ArrayList<Report> mPendingReports;
    Thread mThread;

    final class MyThread extends Thread {
        final /* synthetic */ InstrumentationReporter this$0;

        public MyThread(InstrumentationReporter this$0) {
            this.this$0 = this$0;
            super("InstrumentationReporter");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(0);
            boolean waited = false;
        L3:
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            ArrayList<Report> reports = this.this$0.mPendingReports;     // Catch: Throwable -> L25
            this.this$0.mPendingReports = null;     // Catch: Throwable -> L25
            if (reports == null) goto L27;
            if (reports.isEmpty() == true) goto L27;
            monitor-exit(r1);     // Catch: Throwable -> L25
            waited = false;
            int i = 0;
        L13:
            if (i >= reports.size()) goto L3;
            Report rep = reports.get(i);
            if (rep.mType != 0) goto L20;
            rep.mWatcher.instrumentationStatus(rep.mName, rep.mResultCode, rep.mResults);     // Catch: RemoteException -> L18
        L23:
            i = i + 1;
            goto L13
        L20:
            rep.mWatcher.instrumentationFinished(rep.mName, rep.mResultCode, rep.mResults);     // Catch: RemoteException -> L18
        L22:
            Slog.i(InstrumentationReporter.TAG, "Failure reporting to instrumentation watcher: comp=" + rep.mName + " results=" + rep.mResults);
        L27:
            if (waited == true) goto L34;
            this.this$0.mLock.wait(JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);     // Catch: Throwable -> L25 InterruptedException -> L30
        L31:
            waited = true;
            monitor-exit(r1);     // Catch: Throwable -> L25
            goto L3
        L34:
            this.this$0.mThread = null;     // Catch: Throwable -> L25
            monitor-exit(r1);     // Catch: Throwable -> L25
            return;
        L25:
            th = move-exception;
            throw th;
        }
    }

    final class Report {
        final ComponentName mName;
        final int mResultCode;
        final Bundle mResults;
        final int mType;
        final IInstrumentationWatcher mWatcher;

        Report(InstrumentationReporter this$0, int type, IInstrumentationWatcher watcher, ComponentName name, int resultCode, Bundle results) {
            this.mType = type;
            this.mWatcher = watcher;
            this.mName = name;
            this.mResultCode = resultCode;
            this.mResults = results;
            Binder.allowBlocking(this.mWatcher.asBinder());
        }
    }

    public InstrumentationReporter() {
        this.mLock = new Object();
    }

    public void reportStatus(IInstrumentationWatcher watcher, ComponentName name, int resultCode, Bundle results) {
        report(new Report(this, 0, watcher, name, resultCode, results));
    }

    public void reportFinished(IInstrumentationWatcher watcher, ComponentName name, int resultCode, Bundle results) {
        report(new Report(this, 1, watcher, name, resultCode, results));
    }

    private void report(Report report) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mThread != null) goto L10;
        this.mThread = new MyThread(this);     // Catch: Throwable -> L7
        this.mThread.start();     // Catch: Throwable -> L7
    L10:
        if (this.mPendingReports != null) goto L12;
        this.mPendingReports = new ArrayList();     // Catch: Throwable -> L7
    L12:
        this.mPendingReports.add(report);     // Catch: Throwable -> L7
        this.mLock.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }
}
