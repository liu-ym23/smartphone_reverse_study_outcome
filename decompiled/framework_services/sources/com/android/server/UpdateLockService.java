package com.android.server;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.IUpdateLock;
import android.os.RemoteException;
import android.os.TokenWatcher;
import android.os.UserHandle;
import com.android.internal.util.DumpUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class UpdateLockService extends IUpdateLock.Stub {
    static final boolean DEBUG = false;
    static final String PERMISSION = "android.permission.UPDATE_LOCK";
    static final String TAG = "UpdateLockService";
    Context mContext;
    LockWatcher mLocks;

    class LockWatcher extends TokenWatcher {
        final /* synthetic */ UpdateLockService this$0;

        LockWatcher(UpdateLockService this$0, Handler h, String tag) {
            this.this$0 = this$0;
            super(h, tag);
        }

        @Override // android.os.TokenWatcher
        public void acquired() {
            this.this$0.sendLockChangedBroadcast(false);
        }

        @Override // android.os.TokenWatcher
        public void released() {
            this.this$0.sendLockChangedBroadcast(true);
        }
    }

    UpdateLockService(Context context) {
        this.mContext = context;
        this.mLocks = new LockWatcher(this, new Handler(), "UpdateLocks");
        sendLockChangedBroadcast(true);
    }

    void sendLockChangedBroadcast(boolean state) {
        long oldIdent = Binder.clearCallingIdentity();
        Intent intent = new Intent("android.os.UpdateLock.UPDATE_LOCK_CHANGED").putExtra("nowisconvenient", state).putExtra("timestamp", System.currentTimeMillis()).addFlags(67108864);     // Catch: Throwable -> L6
        this.mContext.sendStickyBroadcastAsUser(intent, UserHandle.ALL);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(oldIdent);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(oldIdent);
        throw th;
    }

    public void acquireUpdateLock(IBinder token, String tag) throws RemoteException {
        this.mContext.enforceCallingOrSelfPermission(PERMISSION, "acquireUpdateLock");
        this.mLocks.acquire(token, makeTag(tag));
    }

    public void releaseUpdateLock(IBinder token) throws RemoteException {
        this.mContext.enforceCallingOrSelfPermission(PERMISSION, "releaseUpdateLock");
        this.mLocks.release(token);
    }

    private String makeTag(String tag) {
        return "{tag=" + tag + " uid=" + Binder.getCallingUid() + " pid=" + Binder.getCallingPid() + '}';
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        this.mLocks.dump(pw);
    }
}
