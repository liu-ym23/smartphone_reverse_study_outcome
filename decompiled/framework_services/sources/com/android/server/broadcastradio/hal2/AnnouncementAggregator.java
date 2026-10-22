package com.android.server.broadcastradio.hal2;

import android.hardware.radio.Announcement;
import android.hardware.radio.IAnnouncementListener;
import android.hardware.radio.ICloseHandle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.server.utils.Slogf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AnnouncementAggregator extends ICloseHandle.Stub {
    private static final String TAG = "BcRadio2Srv.AnnAggr";
    private final IBinder.DeathRecipient mDeathRecipient;
    private boolean mIsClosed;
    private final IAnnouncementListener mListener;
    private final Object mLock;
    private final Collection<ModuleWatcher> mModuleWatchers;

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

    private class ModuleWatcher extends IAnnouncementListener.Stub {
        public List<Announcement> currentList;
        private ICloseHandle mCloseHandle;
        final /* synthetic */ AnnouncementAggregator this$0;

        /* synthetic */ ModuleWatcher(AnnouncementAggregator r1, AnnouncementAggregatorIA r2) {
            this(r1);
        }

        private ModuleWatcher(AnnouncementAggregator r1) {
            this.this$0 = r1;
            this.currentList = new ArrayList();
        }

        public void onListUpdated(List<Announcement> active) {
            active.getClass();
            this.currentList = active;
            AnnouncementAggregator.m2818$$Nest$monListUpdated(this.this$0);
        }

        public void setCloseHandle(ICloseHandle closeHandle) {
            closeHandle.getClass();
            this.mCloseHandle = closeHandle;
        }

        public void close() throws RemoteException {
            if (this.mCloseHandle == null) goto L6;
            this.mCloseHandle.close();
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$monListUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2818$$Nest$monListUpdated(AnnouncementAggregator r0) {
        r0.onListUpdated();
    }

    public AnnouncementAggregator(IAnnouncementListener listener, Object lock) {
        this.mDeathRecipient = new DeathRecipient(this, null);
        this.mModuleWatchers = new ArrayList();
        this.mIsClosed = false;
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
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == false) goto L11;
        Slogf.e(TAG, "Announcement aggregator is closed, it shouldn't receive callbacks");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        List<Announcement> combined = new ArrayList();     // Catch: Throwable -> L9
        Iterator<ModuleWatcher> r2 = this.mModuleWatchers.iterator();     // Catch: Throwable -> L9
    L13:
        if (r2.hasNext() == false) goto L25;
        ModuleWatcher watcher = r2.next();     // Catch: Throwable -> L9
        combined.addAll(watcher.currentList);     // Catch: Throwable -> L9
        goto L13
    L25:
        this.mListener.onListUpdated(combined);     // Catch: Throwable -> L9 RemoteException -> L18
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L18:
        ex = move-exception;
        Slogf.e(TAG, "mListener.onListUpdated() failed: ", ex);     // Catch: Throwable -> L9
        goto L20
    }

    public void watchModule(RadioModule module, int[] enabledTypes) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == true) goto L18;
        ModuleWatcher watcher = new ModuleWatcher(this, null);     // Catch: Throwable -> L11
        ICloseHandle closeHandle = module.addAnnouncementListener(enabledTypes, watcher);     // Catch: Throwable -> L11 RemoteException -> L13
        watcher.setCloseHandle(closeHandle);     // Catch: Throwable -> L11
        this.mModuleWatchers.add(watcher);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        ex = move-exception;
        Slogf.e(TAG, "Failed to add announcement listener", ex);     // Catch: Throwable -> L11
        return;
    L18:
        throw new IllegalStateException("Failed to watch modulesince announcement aggregator has already been closed");     // Catch: Throwable -> L11
    }

    public void close() throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mIsClosed = true;     // Catch: Throwable -> L8
        this.mListener.asBinder().unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L8
        Iterator<ModuleWatcher> r1 = this.mModuleWatchers.iterator();     // Catch: Throwable -> L8
    L12:
        if (r1.hasNext() == false) goto L14;
        ModuleWatcher watcher = r1.next();     // Catch: Throwable -> L8
        watcher.close();     // Catch: Throwable -> L8
        goto L12
    L14:
        this.mModuleWatchers.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }
}
