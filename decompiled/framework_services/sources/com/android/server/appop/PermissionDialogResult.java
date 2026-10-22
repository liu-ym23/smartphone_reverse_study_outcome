package com.android.server.appop;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class PermissionDialogResult {
    public SmtPermissionDialog mDialog;
    public List<Result> resultList;

    public static final class Result {
        boolean mHasResult;
        int mResult;

        public Result() {
            this.mHasResult = false;
        }

        public void set(int res) {
            monitor-enter(this);
            this.mHasResult = true;     // Catch: Throwable -> L7
            this.mResult = res;     // Catch: Throwable -> L7
            notifyAll();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public int get() {
            monitor-enter(this);
        L16:
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mHasResult == true) goto L11;
            wait();     // Catch: Throwable -> L7 InterruptedException -> L9
            goto L16
        L11:
            int r0 = this.mResult;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return r0;
        }
    }

    public PermissionDialogResult() {
        this.mDialog = null;
        this.resultList = new ArrayList();
    }

    public void register(Result res) {
        monitor-enter(this);
        this.resultList.add(res);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void notifyAll(int mode) {
        monitor-enter(this);
    L12:
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.resultList.size() == 0) goto L8;
        Result res = this.resultList.get(0);     // Catch: Throwable -> L6
        res.set(mode);     // Catch: Throwable -> L6
        this.resultList.remove(0);     // Catch: Throwable -> L6
        goto L12
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
    }
}
