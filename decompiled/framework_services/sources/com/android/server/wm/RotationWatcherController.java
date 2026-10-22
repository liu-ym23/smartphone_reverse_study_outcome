package com.android.server.wm;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import android.view.IRotationWatcher;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class RotationWatcherController {
    private final ArrayList<DisplayRotationWatcher> mDisplayRotationWatchers;
    private volatile boolean mHasProposedRotationListeners;
    private final ArrayList<ProposedRotationListener> mProposedRotationListeners;
    private final WindowManagerService mService;

    private static class DisplayRotationWatcher extends RotationWatcher {
        final int mDisplayId;

        DisplayRotationWatcher(WindowManagerService wms, IRotationWatcher watcher, int displayId) {
            super(wms, watcher);
            this.mDisplayId = displayId;
        }
    }

    private static class ProposedRotationListener extends RotationWatcher {
        final IBinder mToken;

        ProposedRotationListener(WindowManagerService wms, IRotationWatcher watcher, IBinder token) {
            super(wms, watcher);
            this.mToken = token;
        }
    }

    private static class RotationWatcher implements IBinder.DeathRecipient {
        final int mOwnerUid;
        final IRotationWatcher mWatcher;
        final WindowManagerService mWms;

        RotationWatcher(WindowManagerService wms, IRotationWatcher watcher) {
            this.mOwnerUid = Binder.getCallingUid();
            this.mWms = wms;
            this.mWatcher = watcher;
        }

        void notifyRotation(int rotation) {
            this.mWatcher.onRotationChanged(rotation);     // Catch: RemoteException -> L4
            return;
        }

        void unlinkToDeath() {
            this.mWatcher.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.mWms.removeRotationWatcher(this.mWatcher);
        }
    }

    RotationWatcherController(WindowManagerService wms) {
        this.mDisplayRotationWatchers = new ArrayList();
        this.mProposedRotationListeners = new ArrayList();
        this.mService = wms;
    }

    void registerDisplayRotationWatcher(IRotationWatcher watcher, int displayId) {
        IBinder watcherBinder = watcher.asBinder();
        int i = this.mDisplayRotationWatchers.size() - 1;
    L3:
        if (i < 0) goto L9;
        if (watcherBinder == this.mDisplayRotationWatchers.get(i).mWatcher.asBinder()) goto L8;
        i = i - 1;
        goto L3
    L8:
        throw new IllegalArgumentException("Registering existed rotation watcher");
    L9:
        register(watcherBinder, new DisplayRotationWatcher(this.mService, watcher, displayId), this.mDisplayRotationWatchers);
    }

    void registerProposedRotationListener(IRotationWatcher listener, IBinder contextToken) {
        IBinder listenerBinder = listener.asBinder();
        int i = this.mProposedRotationListeners.size() - 1;
    L3:
        if (i < 0) goto L12;
        ProposedRotationListener watcher = this.mProposedRotationListeners.get(i);
        if (contextToken == watcher.mToken) goto L10;
        if (listenerBinder == watcher.mWatcher.asBinder()) goto L10;
        i = i - 1;
    L10:
        Slog.w("WindowManager", "Register rotation listener to a registered token, uid=" + Binder.getCallingUid());
        return;
    L12:
        register(listenerBinder, new ProposedRotationListener(this.mService, listener, contextToken), this.mProposedRotationListeners);
        this.mHasProposedRotationListeners = !this.mProposedRotationListeners.isEmpty();
    }

    private static <T extends RotationWatcher> void register(IBinder watcherBinder, T watcher, ArrayList<T> watcherList) {
        watcherBinder.linkToDeath(watcher, 0);     // Catch: RemoteException -> L5
        watcherList.add(watcher);     // Catch: RemoteException -> L5
        return;
    }

    private static <T extends RotationWatcher> boolean unregister(IRotationWatcher watcher, ArrayList<T> watcherList) {
        IBinder watcherBinder = watcher.asBinder();
        int i = watcherList.size() - 1;
    L3:
        if (i < 0) goto L9;
        RotationWatcher rotationWatcher = watcherList.get(i);
        if (watcherBinder == rotationWatcher.mWatcher.asBinder()) goto L7;
        i = i - 1;
        goto L3
    L7:
        watcherList.remove(i);
        rotationWatcher.unlinkToDeath();
        return true;
    L9:
        return false;
    }

    void removeRotationWatcher(IRotationWatcher watcher) {
        boolean removed = unregister(watcher, this.mProposedRotationListeners);
        if (removed == false) goto L5;
        this.mHasProposedRotationListeners = !this.mProposedRotationListeners.isEmpty();
        return;
    L5:
        unregister(watcher, this.mDisplayRotationWatchers);
    }

    void dispatchDisplayRotationChange(int displayId, int rotation) {
        int i = this.mDisplayRotationWatchers.size() - 1;
    L3:
        if (i < 0) goto L9;
        DisplayRotationWatcher rotationWatcher = this.mDisplayRotationWatchers.get(i);
        if (rotationWatcher.mDisplayId != displayId) goto L7;
        rotationWatcher.notifyRotation(rotation);
    L7:
        i = i - 1;
        goto L3
    }

    void dispatchProposedRotation(DisplayContent dc, int rotation) {
        int i = this.mProposedRotationListeners.size() - 1;
    L3:
        if (i < 0) goto L12;
        ProposedRotationListener listener = this.mProposedRotationListeners.get(i);
        WindowContainer<?> wc = getAssociatedWindowContainer(listener.mToken);
        if (wc != null) goto L7;
        this.mProposedRotationListeners.remove(i);
        this.mHasProposedRotationListeners = !this.mProposedRotationListeners.isEmpty();
        listener.unlinkToDeath();
    L10:
        i = i - 1;
        goto L3
    L7:
        if (wc.mDisplayContent != dc) goto L10;
        listener.notifyRotation(rotation);
        goto L10
    }

    boolean hasProposedRotationListeners() {
        return this.mHasProposedRotationListeners;
    }

    WindowContainer<?> getAssociatedWindowContainer(IBinder contextToken) {
        WindowContainer<?> wc = ActivityRecord.forTokenLocked(contextToken);
        if (wc == null) goto L6;
        return wc;
    L6:
        return this.mService.mWindowContextListenerController.getContainer(contextToken);
    }

    void dump(PrintWriter pw) {
        if (this.mDisplayRotationWatchers.isEmpty() == true) goto L9;
        pw.print("  mDisplayRotationWatchers: [");
        int i = this.mDisplayRotationWatchers.size() - 1;
    L5:
        if (i < 0) goto L7;
        pw.print(' ');
        DisplayRotationWatcher watcher = this.mDisplayRotationWatchers.get(i);
        pw.print(watcher.mOwnerUid);
        pw.print("->");
        pw.print(watcher.mDisplayId);
        i = i - 1;
        goto L5
    L7:
        pw.println(']');
    L9:
        if (this.mProposedRotationListeners.isEmpty() == true) goto L17;
        pw.print("  mProposedRotationListeners: [");
        int i2 = this.mProposedRotationListeners.size() - 1;
    L11:
        if (i2 < 0) goto L13;
        pw.print(' ');
        ProposedRotationListener listener = this.mProposedRotationListeners.get(i2);
        pw.print(listener.mOwnerUid);
        pw.print("->");
        pw.print(getAssociatedWindowContainer(listener.mToken));
        i2 = i2 - 1;
        goto L11
    L13:
        pw.println(']');
        return;
    }
}
