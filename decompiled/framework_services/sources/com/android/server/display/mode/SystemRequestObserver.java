package com.android.server.display.mode;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
class SystemRequestObserver {
    private static final String TAG = "SystemRequestObserver";
    private final IBinder.DeathRecipient mDeathRecipient;
    private final Map<IBinder, SparseArray<List<Integer>>> mDisplaysRestrictions;
    private final Object mLock;
    private final VotesStorage mVotesStorage;

    public static /* synthetic */ void $r8$lambda$MpisVvszf_6fx6CYMrEstGqIF7Q(int r0, boolean[] r1, List r2, IBinder r3, SparseArray r4) {
        lambda$updateStorageLocked$0(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeathRecipient, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder.DeathRecipient m4138$$Nest$fgetmDeathRecipient(SystemRequestObserver r0) {
        return r0.mDeathRecipient;
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveSystemRequestedVotes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4139$$Nest$mremoveSystemRequestedVotes(SystemRequestObserver r0, IBinder r1) {
        r0.removeSystemRequestedVotes(r1);
    }

    SystemRequestObserver(VotesStorage storage) {
        this.mDeathRecipient = new AnonymousClass1(this);
        this.mLock = new Object();
        this.mDisplaysRestrictions = new HashMap();
        this.mVotesStorage = storage;
    }

    void requestDisplayModes(IBinder token, int displayId, int[] modeIds) {
        if (modeIds != null) goto L4;
        removeSystemRequestedVote(token, displayId);
        return;
    L4:
        addSystemRequestedVote(token, displayId, modeIds);
    }

    private void addSystemRequestedVote(IBinder token, int displayId, int[] modeIds) {
        boolean needLinkToDeath = false;
        List<Integer> modeIdsList = new ArrayList();     // Catch: RemoteException -> L6
        int r2 = modeIds.length;     // Catch: RemoteException -> L6
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L8;
        int mode = modeIds[r4];     // Catch: RemoteException -> L6
        modeIdsList.add(Integer.valueOf(mode));     // Catch: RemoteException -> L6
        r4 = r4 + 1;     // Catch: RemoteException -> L6
        goto L4
    L8:
        Object r3 = this.mLock;     // Catch: RemoteException -> L6
        monitor-enter(r3);     // Catch: RemoteException -> L6
        SparseArray<List<Integer>> modesByDisplay = this.mDisplaysRestrictions.get(token);     // Catch: Throwable -> L13
        if (modesByDisplay != null) goto L15;
        needLinkToDeath = true;
        modesByDisplay = new SparseArray();     // Catch: Throwable -> L13
        this.mDisplaysRestrictions.put(token, modesByDisplay);     // Catch: Throwable -> L13
    L15:
        modesByDisplay.put(displayId, modeIdsList);     // Catch: Throwable -> L13
        updateStorageLocked(displayId);     // Catch: Throwable -> L13
        monitor-exit(r3);     // Catch: Throwable -> L13
        if (needLinkToDeath == false) goto L29;
        Slog.d(TAG, "binder linking to death: " + token);     // Catch: RemoteException -> L6
        token.linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L6
        return;
    L29:
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L6
    L6:
        re = move-exception;
        Slog.d(TAG, "linking to death failed: " + token, re);
        removeSystemRequestedVotes(token);
    }

    private void removeSystemRequestedVote(IBinder token, int displayId) {
        boolean needToUnlink = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseArray<List<Integer>> modesByDisplay = this.mDisplaysRestrictions.get(token);     // Catch: Throwable -> L13
        if (modesByDisplay != null) goto L7;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        if (needToUnlink == false) goto L28;
        Slog.d(TAG, "binder unlinking to death: " + token);     // Catch: NoSuchElementException -> L19
        token.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: NoSuchElementException -> L19
        return;
    L19:
        e = move-exception;
        Slog.d(TAG, "unlinking to death failed: " + token, e);
        return;
    L28:
        return;
    L7:
        if (modesByDisplay.size() <= 0) goto L15;
        modesByDisplay.remove(displayId);     // Catch: Throwable -> L13
        if (modesByDisplay.size() != 0) goto L11;
        boolean r4 = true;
    L12:
        needToUnlink = r4;
        updateStorageLocked(displayId);     // Catch: Throwable -> L13
        goto L15
    L11:
        r4 = false;
    L13:
        th = move-exception;
        throw th;
    }

    private void removeSystemRequestedVotes(IBinder token) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseArray<List<Integer>> removed = this.mDisplaysRestrictions.remove(token);     // Catch: Throwable -> L10
        if (removed == null) goto L12;
        int i = 0;
    L8:
        if (i >= removed.size()) goto L12;
        updateStorageLocked(removed.keyAt(i));     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void updateStorageLocked(final int displayId) {
        final List<Integer> modeIds = new ArrayList();
        final boolean[] modesFound = new boolean[1];
        this.mDisplaysRestrictions.forEach(new SystemRequestObserver$$ExternalSyntheticLambda0(displayId, modesFound, modeIds));
        VotesStorage r2 = this.mVotesStorage;
        if (modesFound[0] == false) goto L5;
        Vote r3 = Vote.forSupportedModes(modeIds);
    L6:
        r2.updateVote(displayId, 17, r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    private static /* synthetic */ void lambda$updateStorageLocked$0(int displayId, boolean[] modesFound, List modeIds, IBinder key, SparseArray value) {
        List<Integer> modesForDisplay = (List) value.get(displayId);
        if (modesForDisplay != null) goto L5;
        return;
    L5:
        if (modesFound[0] == true) goto L7;
        modeIds.addAll(modesForDisplay);
        modesFound[0] = true;
        return;
    L7:
        modeIds.retainAll(modesForDisplay);
    }
}
