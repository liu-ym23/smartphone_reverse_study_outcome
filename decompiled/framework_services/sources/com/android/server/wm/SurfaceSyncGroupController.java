package com.android.server.wm;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.window.AddToSurfaceSyncGroupResult;
import android.window.ISurfaceSyncGroupCompletedListener;
import android.window.ITransactionReadyCallback;
import android.window.SurfaceSyncGroup;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes3.dex */
class SurfaceSyncGroupController {
    private static final String TAG = "SurfaceSyncGroupController";
    private final Object mLock;
    private final ArrayMap<IBinder, SurfaceSyncGroupData> mSurfaceSyncGroups;

    private static class SurfaceSyncGroupData {
        final int mOwningUid;
        final SurfaceSyncGroup mSurfaceSyncGroup;

        /* synthetic */ SurfaceSyncGroupData(int r1, SurfaceSyncGroup r2, SurfaceSyncGroupControllerIA r3) {
            this(r1, r2);
        }

        private SurfaceSyncGroupData(int owningUid, SurfaceSyncGroup surfaceSyncGroup) {
            this.mOwningUid = owningUid;
            this.mSurfaceSyncGroup = surfaceSyncGroup;
        }
    }

    public static /* synthetic */ void $r8$lambda$EqQG4rGoO5nNw2e4s11USDwgzBY(ISurfaceSyncGroupCompletedListener r0) {
        lambda$addToSyncGroup$0(r0);
    }

    SurfaceSyncGroupController() {
        this.mLock = new Object();
        this.mSurfaceSyncGroups = new ArrayMap();
    }

    boolean addToSyncGroup(IBinder syncGroupToken, boolean parentSyncGroupMerge, final ISurfaceSyncGroupCompletedListener completedListener, AddToSurfaceSyncGroupResult outAddToSyncGroupResult) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SurfaceSyncGroupData syncGroupData = this.mSurfaceSyncGroups.get(syncGroupToken);     // Catch: Throwable -> L9
        if (syncGroupData != null) goto L12;
        SurfaceSyncGroup root = new SurfaceSyncGroup("SurfaceSyncGroupController-" + syncGroupToken.hashCode());     // Catch: Throwable -> L9
        if (completedListener == null) goto L11;
        root.addSyncCompleteCallback(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new SurfaceSyncGroupController$$ExternalSyntheticLambda0(completedListener));     // Catch: Throwable -> L9
    L11:
        this.mSurfaceSyncGroups.put(syncGroupToken, new SurfaceSyncGroupData(Binder.getCallingUid(), root, null));     // Catch: Throwable -> L9
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        ITransactionReadyCallback callback = root.createTransactionReadyCallback(parentSyncGroupMerge);
        if (callback != null) goto L18;
        return false;
    L18:
        outAddToSyncGroupResult.mParentSyncGroup = root.mISurfaceSyncGroup;
        outAddToSyncGroupResult.mTransactionReadyCallback = callback;
        return true;
    L12:
        root = syncGroupData.mSurfaceSyncGroup;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$addToSyncGroup$0(ISurfaceSyncGroupCompletedListener completedListener) {
        completedListener.onSurfaceSyncGroupComplete();     // Catch: RemoteException -> L4
        return;
    }

    void markSyncGroupReady(IBinder syncGroupToken) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SurfaceSyncGroupData syncGroupData = this.mSurfaceSyncGroups.get(syncGroupToken);     // Catch: Throwable -> L12
        if (syncGroupData == null) goto L17;
        if (syncGroupData.mOwningUid != Binder.getCallingUid()) goto L15;
        SurfaceSyncGroup root = syncGroupData.mSurfaceSyncGroup;     // Catch: Throwable -> L12
        this.mSurfaceSyncGroups.remove(syncGroupToken);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        root.markSyncReady();
        return;
    L15:
        throw new IllegalArgumentException("Only process that created the SurfaceSyncGroup can call markSyncGroupReady");     // Catch: Throwable -> L12
    L17:
        throw new IllegalArgumentException("SurfaceSyncGroup Token has not been set up or has already been marked as ready");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
