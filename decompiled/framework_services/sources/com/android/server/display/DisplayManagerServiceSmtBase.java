package com.android.server.display;

import android.hardware.display.IDisplayManagerCallback;
import android.os.RemoteException;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.ApplicationFreezerHelperSmt;
import com.android.server.ApplicationFreezerInternalSmt;
import com.android.server.am.ActivityManagerDebugConfigSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DisplayManagerServiceSmtBase {
    private static final String TAG = "DisplayManagerServiceSmtEx";
    protected DisplayManagerService mService;

    static final class CallbackRecordSmtEx implements ApplicationFreezerInternalSmt.IFrozenCallback {
        SparseArray<Integer> mAddEventDisplayIds;
        IDisplayManagerCallback mCallback;
        Object mLock;
        SparseArray<Integer> mPendingEvents;
        public final int mUid;

        CallbackRecordSmtEx(int uid, IDisplayManagerCallback callback) {
            this.mLock = new Object();
            this.mUid = uid;
            this.mCallback = callback;
        }

        @Override // com.android.server.ApplicationFreezerInternalSmt.IFrozenCallback
        public void onAppUnfreeze(int pid, int uid) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L28:
            th = move-exception;
            throw th;
        L5:
            if (this.mPendingEvents == null) goto L30;
            SparseArray<Integer> r1 = this.mPendingEvents;     // Catch: Throwable -> L28
            monitor-enter(r1);     // Catch: Throwable -> L28
            int N = this.mPendingEvents.size();     // Catch: Throwable -> L15
            int i = 0;
        L9:
            if (i >= N) goto L23;
            int dis = this.mPendingEvents.keyAt(i);     // Catch: Throwable -> L15
            int event = this.mPendingEvents.valueAt(i).intValue();     // Catch: Throwable -> L15
            this.mCallback.onDisplayEvent(dis, event);     // Catch: Throwable -> L15 RemoteException -> L17
            if (ActivityManagerDebugConfigSmtEx.DEBUG_FREEZE == false) goto L22;
            Slog.i(DisplayManagerServiceSmtBase.TAG, "send pending event, dis: " + dis + ", event: " + event + ", to pid: " + pid + ", uid: " + uid);     // Catch: Throwable -> L15 RemoteException -> L17
        L22:
            i = i + 1;     // Catch: Throwable -> L15
        L21:
            Slog.w(DisplayManagerServiceSmtBase.TAG, "Failed to send pending event dis: " + dis + ", event: " + event + ", to pid: " + pid + ", uid: " + uid);     // Catch: Throwable -> L15
            goto L22
        L23:
            this.mPendingEvents.clear();     // Catch: Throwable -> L15
            this.mAddEventDisplayIds.clear();     // Catch: Throwable -> L15
            monitor-exit(r1);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L28
        L30:
            monitor-exit(r0);     // Catch: Throwable -> L28
        }

        @Override // com.android.server.ApplicationFreezerInternalSmt.IFrozenCallback
        public void onAppFreeze(int pid, int uid) {
        }

        public void notifyDisplayPendingEvent(int pid, int displayId, int event) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mPendingEvents != null) goto L10;
            this.mPendingEvents = new SparseArray();     // Catch: Throwable -> L7
        L10:
            if (this.mAddEventDisplayIds != null) goto L12;
            this.mAddEventDisplayIds = new SparseArray();     // Catch: Throwable -> L7
        L12:
            SparseArray<Integer> r1 = this.mPendingEvents;     // Catch: Throwable -> L7
            monitor-enter(r1);     // Catch: Throwable -> L7
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L7
        L15:
            if (this.mPendingEvents.size() != 0) goto L20;
            ApplicationFreezerHelperSmt.registerFrozenCallbackByPidOnce(pid, this.mUid, this);     // Catch: Throwable -> L17
        L30:
            if (event != 1) goto L32;
            this.mAddEventDisplayIds.put(displayId, 0);     // Catch: Throwable -> L17
        L32:
            this.mPendingEvents.put(displayId, Integer.valueOf(event));     // Catch: Throwable -> L17
            monitor-exit(r1);     // Catch: Throwable -> L17
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L20:
            if (event != 3) goto L30;
            if (this.mAddEventDisplayIds.get(displayId) == null) goto L30;
            if (this.mPendingEvents.get(displayId) == null) goto L30;
            this.mPendingEvents.remove(displayId);     // Catch: Throwable -> L17
            this.mAddEventDisplayIds.remove(displayId);     // Catch: Throwable -> L17
            monitor-exit(r1);     // Catch: Throwable -> L17
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    public DisplayManagerServiceSmtBase(DisplayManagerService service) {
        this.mService = service;
    }
}
