package com.android.server.broadcastradio.aidl;

import android.hardware.radio.Announcement;
import android.hardware.radio.IAnnouncementListener;
import android.hardware.radio.ICloseHandle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.IndentingPrintWriter;
import android.util.Log;
import com.android.server.utils.Slogf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AnnouncementAggregator extends ICloseHandle.Stub {
    private static final boolean DEBUG = false;
    private static final String TAG = "BcRadioAidlSrv.AnnAggr";
    private final IBinder.DeathRecipient mDeathRecipient;
    private boolean mIsClosed;
    private final IAnnouncementListener mListener;
    private final Object mLock;
    private final List<ModuleWatcher> mModuleWatchers;

    private class DeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ AnnouncementAggregator this$0;

        /* synthetic */ DeathRecipient(AnnouncementAggregator r1, AnnouncementAggregatorIA r2) {
            this(r1);
        }

        private DeathRecipient(AnnouncementAggregator r1) {
            this.this$0 = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.close();     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slogf.e(AnnouncementAggregator.TAG, ex, "Cannot close Announcement aggregator for DeathRecipient", new Object[0]);
        }
    }

    private final class ModuleWatcher extends IAnnouncementListener.Stub {
        private ICloseHandle mCloseHandle;
        public List<Announcement> mCurrentList;
        final /* synthetic */ AnnouncementAggregator this$0;

        /* synthetic */ ModuleWatcher(AnnouncementAggregator r1, AnnouncementAggregatorIA r2) {
            this(r1);
        }

        private ModuleWatcher(AnnouncementAggregator r1) {
            this.this$0 = r1;
            this.mCurrentList = new ArrayList();
        }

        public void onListUpdated(List<Announcement> active) {
            if (AnnouncementAggregator.m2797$$Nest$sfgetDEBUG() == false) goto L5;
            Slogf.d(AnnouncementAggregator.TAG, "onListUpdate for %s", new Object[]{active});
        L5:
            active.getClass();
            this.mCurrentList = active;
            AnnouncementAggregator.m2796$$Nest$monListUpdated(this.this$0);
        }

        public void setCloseHandle(ICloseHandle closeHandle) {
            if (AnnouncementAggregator.m2797$$Nest$sfgetDEBUG() == false) goto L5;
            Slogf.d(AnnouncementAggregator.TAG, "Set close handle %s", new Object[]{closeHandle});
        L5:
            closeHandle.getClass();
            this.mCloseHandle = closeHandle;
        }

        public void close() throws RemoteException {
            if (AnnouncementAggregator.m2797$$Nest$sfgetDEBUG() == false) goto L6;
            Slogf.d(AnnouncementAggregator.TAG, "Close module watcher.");
        L6:
            if (this.mCloseHandle == null) goto L9;
            this.mCloseHandle.close();
            return;
        }

        public void dumpInfo(IndentingPrintWriter pw) {
            pw.printf("ModuleWatcher:\n", new Object[0]);
            pw.increaseIndent();
            pw.printf("Close handle: %s\n", new Object[]{this.mCloseHandle});
            pw.printf("Current announcement list: %s\n", new Object[]{this.mCurrentList});
            pw.decreaseIndent();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$monListUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2796$$Nest$monListUpdated(AnnouncementAggregator r0) {
        r0.onListUpdated();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2797$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public AnnouncementAggregator(IAnnouncementListener listener, Object lock) {
        this.mDeathRecipient = new DeathRecipient(this, null);
        this.mModuleWatchers = new ArrayList();
        listener.getClass();
        this.mListener = listener;
        lock.getClass();
        this.mLock = lock;
        listener.asBinder().linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L5
        return;
    L5:
        ex = move-exception;
        ex.rethrowFromSystemServer();
    }

    private void onListUpdated() {
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "onListUpdated()");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mIsClosed == false) goto L14;
        Slogf.e(TAG, "Announcement aggregator is closed, it shouldn't receive callbacks");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        List<Announcement> combined = new ArrayList(this.mModuleWatchers.size());     // Catch: Throwable -> L12
        int i = 0;
    L16:
        if (i >= this.mModuleWatchers.size()) goto L28;
        combined.addAll(this.mModuleWatchers.get(i).mCurrentList);     // Catch: Throwable -> L12
        i = i + 1;
        goto L16
    L28:
        this.mListener.onListUpdated(combined);     // Catch: Throwable -> L12 RemoteException -> L22
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L22:
        ex = move-exception;
        Slogf.e(TAG, ex, "mListener.onListUpdated() failed", new Object[0]);     // Catch: Throwable -> L12
        goto L24
    }

    public void watchModule(RadioModule radioModule, int[] enabledTypes) {
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "Watch module for %s with enabled types %s", new Object[]{radioModule, Arrays.toString(enabledTypes)});
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.mIsClosed == true) goto L21;
        ModuleWatcher watcher = new ModuleWatcher(this, null);     // Catch: Throwable -> L14
        ICloseHandle closeHandle = radioModule.addAnnouncementListener(watcher, enabledTypes);     // Catch: Throwable -> L14 RemoteException -> L16
        watcher.setCloseHandle(closeHandle);     // Catch: Throwable -> L14
        this.mModuleWatchers.add(watcher);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L16:
        ex = move-exception;
        Slogf.e(TAG, ex, "Failed to add announcement listener", new Object[0]);     // Catch: Throwable -> L14
        return;
    L21:
        throw new IllegalStateException("Failed to watch modulesince announcement aggregator has already been closed");     // Catch: Throwable -> L14
    }

    public void close() throws RemoteException {
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "Close watchModule");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mIsClosed == false) goto L14;
        Slogf.w(TAG, "Announcement aggregator has already been closed.");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        this.mListener.asBinder().unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L12
        int i = 0;
    L16:
        if (i >= this.mModuleWatchers.size()) goto L23;
        ModuleWatcher moduleWatcher = this.mModuleWatchers.get(i);     // Catch: Throwable -> L12
        moduleWatcher.close();     // Catch: Throwable -> L12 Exception -> L20
    L22:
        i = i + 1;     // Catch: Throwable -> L12
    L20:
        e = move-exception;
        Slogf.e(TAG, "Failed to close module watcher %s: %s", new Object[]{moduleWatcher, e});     // Catch: Throwable -> L12
        goto L22
    L23:
        this.mModuleWatchers.clear();     // Catch: Throwable -> L12
        this.mIsClosed = true;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    protected void dump(FileDescriptor fd, PrintWriter printWriter, String[] args) {
        IndentingPrintWriter announcementPrintWriter = new IndentingPrintWriter(printWriter);
        announcementPrintWriter.printf("AnnouncementAggregator\n", new Object[0]);
        announcementPrintWriter.increaseIndent();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == false) goto L9;
        String r3 = "Yes";
    L10:
        announcementPrintWriter.printf("Is session closed? %s\n", new Object[]{r3});     // Catch: Throwable -> L7
        announcementPrintWriter.printf("Module Watchers [%d]:\n", new Object[]{Integer.valueOf(this.mModuleWatchers.size())});     // Catch: Throwable -> L7
        announcementPrintWriter.increaseIndent();     // Catch: Throwable -> L7
        int i = 0;
    L12:
        if (i >= this.mModuleWatchers.size()) goto L14;
        this.mModuleWatchers.get(i).dumpInfo(announcementPrintWriter);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L12
    L14:
        announcementPrintWriter.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        announcementPrintWriter.decreaseIndent();
        return;
    L9:
        r3 = "No";
        goto L10
    }
}
