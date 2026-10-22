package com.android.server.am;

import android.app.ActivityManager;
import android.app.IUidObserver;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.Slog;
import android.util.SparseIntArray;
import android.util.proto.ProtoOutputStream;
import android.util.proto.ProtoUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class UidObserverController {
    private static final int SLOW_UID_OBSERVER_THRESHOLD_MS = 20;
    private static final boolean VALIDATE_UID_STATES = true;
    private ChangeRecord[] mActiveUidChanges;
    private final ArrayList<ChangeRecord> mAvailUidChanges;
    private final Runnable mDispatchRunnable;
    private final Handler mHandler;
    private final Object mLock;
    private final ArrayList<ChangeRecord> mPendingUidChanges;
    private int mUidChangeDispatchCount;
    final RemoteCallbackList<IUidObserver> mUidObservers;
    private final ActiveUids mValidateUids;

    static final class ChangeRecord {
        public int capability;
        public int change;
        public boolean ephemeral;
        int frozenStat;
        public boolean isPending;
        UidRecordSmtBase.ChangeRecordSmtEx mSmtEx;
        public int procAdj;
        public int procState;
        public long procStateSeq;
        public int uid;

        ChangeRecord() {
            this.mSmtEx = new UidRecordSmtBase.ChangeRecordSmtEx();
        }

        void copyTo(ChangeRecord changeRecord) {
            changeRecord.isPending = this.isPending;
            changeRecord.uid = this.uid;
            changeRecord.change = this.change;
            changeRecord.procState = this.procState;
            changeRecord.procAdj = this.procAdj;
            changeRecord.capability = this.capability;
            changeRecord.ephemeral = this.ephemeral;
            changeRecord.procStateSeq = this.procStateSeq;
            UidRecordSmtBase.ChangeRecordSmtEx r0 = changeRecord.mSmtEx;
            r0.schedGroup = this.mSmtEx.schedGroup;
            UidRecordSmtBase.ChangeRecordSmtEx r1 = changeRecord.mSmtEx;
            r1.frozenStat = this.mSmtEx.frozenStat;
        }
    }

    public class FreezeEventRunnable implements Runnable {
        private boolean frozenStat;
        final /* synthetic */ UidObserverController this$0;
        private int uid;

        public FreezeEventRunnable(UidObserverController this$0, int uid, boolean frozenStat) {
            this.this$0 = this$0;
            this.uid = uid;
            this.frozenStat = frozenStat;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.handleDispatchUidFrozenStatForObserver(this.uid, this.frozenStat);
        }
    }

    private static final class UidObserverRegistration {
        private static final int[] ORIG_ENUMS = null;
        private static final int[] PROTO_ENUMS = null;
        private final boolean mCanInteractAcrossUsers;
        private final int mCutpoint;
        final SparseIntArray mLastProcStates;
        int mMaxDispatchTime;
        private final String mPkg;
        int mSlowDispatchCount;
        private final IBinder mToken;
        private final int mUid;
        private int[] mUids;
        private final int mWhich;

        /* JADX INFO: renamed from: -$$Nest$fgetmCanInteractAcrossUsers, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m1584$$Nest$fgetmCanInteractAcrossUsers(UidObserverRegistration r0) {
            return r0.mCanInteractAcrossUsers;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCutpoint, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1585$$Nest$fgetmCutpoint(UidObserverRegistration r0) {
            return r0.mCutpoint;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPkg, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m1586$$Nest$fgetmPkg(UidObserverRegistration r0) {
            return r0.mPkg;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1587$$Nest$fgetmUid(UidObserverRegistration r0) {
            return r0.mUid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmWhich, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1588$$Nest$fgetmWhich(UidObserverRegistration r0) {
            return r0.mWhich;
        }

        static {
            ORIG_ENUMS = new int[]{4, 8, 2, 1, 32, 64};
            PROTO_ENUMS = new int[]{3, 4, 2, 1, 6, 7};
        }

        UidObserverRegistration(int uid, String pkg, int which, int cutpoint, boolean canInteractAcrossUsers, int[] uids, IBinder token) {
            this.mUid = uid;
            this.mPkg = pkg;
            this.mWhich = which;
            this.mCutpoint = cutpoint;
            this.mCanInteractAcrossUsers = canInteractAcrossUsers;
            SparseIntArray r0 = null;
            if (uids == null) goto L5;
            this.mUids = (int[]) uids.clone();
            Arrays.sort(this.mUids);
        L6:
            this.mToken = token;
            if (cutpoint < 0) goto L10;
            r0 = new SparseIntArray();
        L10:
            this.mLastProcStates = r0;
            return;
        L5:
            this.mUids = null;
            goto L6
        }

        boolean isWatchingUid(int uid) {
            if (this.mUids != null) goto L6;
            return true;
        L6:
            if (Arrays.binarySearch(this.mUids, uid) >= 0) goto L10;
            return false;
        L10:
            return true;
        }

        void addUid(int uid) {
            if (this.mUids != null) goto L5;
            return;
        L5:
            int[] temp = this.mUids;
            this.mUids = new int[temp.length + 1];
            boolean inserted = false;
            int i = 0;
        L7:
            if (i >= temp.length) goto L20;
            if (inserted == false) goto L10;
            this.mUids[i + 1] = temp[i];
        L18:
            i = i + 1;
            goto L7
        L10:
            if (temp[i] >= uid) goto L13;
            this.mUids[i] = temp[i];
            goto L18
        L13:
            if (temp[i] == uid) goto L14;
            this.mUids[i] = uid;
            this.mUids[i + 1] = temp[i];
            inserted = true;
            goto L18
        L14:
            this.mUids = temp;
            return;
        L20:
            if (inserted == true) goto L28;
            this.mUids[temp.length] = uid;
            return;
        }

        void removeUid(int uid) {
            if (this.mUids != null) goto L5;
            return;
        L5:
            if (this.mUids.length == 0) goto L29;
            int[] temp = this.mUids;
            this.mUids = new int[temp.length - 1];
            boolean removed = false;
            int i = 0;
        L9:
            if (i >= temp.length) goto L22;
            if (removed == false) goto L12;
            this.mUids[i - 1] = temp[i];
        L20:
            i = i + 1;
            goto L9
        L12:
            if (temp[i] != uid) goto L15;
            removed = true;
            goto L20
        L15:
            if (i == (temp.length - 1)) goto L16;
            this.mUids[i] = temp[i];
            goto L20
        L16:
            this.mUids = temp;
            return;
        L22:
            return;
        }

        IBinder getToken() {
            return this.mToken;
        }

        void dump(PrintWriter pw, IUidObserver observer) {
            pw.print("    ");
            UserHandle.formatUid(pw, this.mUid);
            pw.print(" ");
            pw.print(this.mPkg);
            pw.print(" ");
            pw.print(observer.getClass().getTypeName());
            pw.print(":");
            if ((this.mWhich & 4) == 0) goto L6;
            pw.print(" IDLE");
        L6:
            if ((this.mWhich & 8) == 0) goto L9;
            pw.print(" ACT");
        L9:
            if ((this.mWhich & 2) == 0) goto L12;
            pw.print(" GONE");
        L12:
            if ((this.mWhich & 32) == 0) goto L15;
            pw.print(" CAP");
        L15:
            if ((this.mWhich & 1) == 0) goto L17;
            pw.print(" STATE");
            pw.print(" (cut=");
            pw.print(this.mCutpoint);
            pw.print(")");
        L17:
            pw.println();
            if (this.mLastProcStates == null) goto L22;
            int size = this.mLastProcStates.size();
            int j = 0;
        L20:
            if (j >= size) goto L24;
            pw.print("      Last ");
            UserHandle.formatUid(pw, this.mLastProcStates.keyAt(j));
            pw.print(": ");
            pw.println(this.mLastProcStates.valueAt(j));
            j = j + 1;
            goto L20
        L24:
            return;
        }

        void dumpDebug(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            proto.write(1120986464257L, this.mUid);
            proto.write(1138166333442L, this.mPkg);
            ProtoUtils.writeBitWiseFlagsToProtoEnum(proto, 2259152797699L, this.mWhich, ORIG_ENUMS, PROTO_ENUMS);
            proto.write(1120986464260L, this.mCutpoint);
            if (this.mLastProcStates == null) goto L7;
            int size = this.mLastProcStates.size();
            int i = 0;
        L5:
            if (i >= size) goto L7;
            long pToken = proto.start(2246267895813L);
            proto.write(1120986464257L, this.mLastProcStates.keyAt(i));
            proto.write(1120986464258L, this.mLastProcStates.valueAt(i));
            proto.end(pToken);
            i = i + 1;
        L7:
            proto.end(token);
        }
    }

    UidObserverController(Handler handler) {
        this.mLock = new Object();
        this.mUidObservers = new RemoteCallbackList();
        this.mPendingUidChanges = new ArrayList();
        this.mAvailUidChanges = new ArrayList();
        this.mActiveUidChanges = new ChangeRecord[5];
        this.mDispatchRunnable = new UidObserverController$$ExternalSyntheticLambda0(this);
        this.mHandler = handler;
        this.mValidateUids = new ActiveUids(null, false);
    }

    IBinder register(IUidObserver observer, int which, int cutpoint, String callingPackage, int callingUid, int[] uids) {
        IBinder token = new Binder("UidObserver-" + callingPackage + "-" + UUID.randomUUID().toString());
        Object r1 = this.mLock;
        monitor-enter(r1);
        boolean r3 = true;
        if (ActivityManager.checkComponentPermission("android.permission.INTERACT_ACROSS_USERS_FULL", callingUid, -1, true) != 0) goto L7;
    L6:
        boolean canInteractAcrossUsers = r3;
        this.mUidObservers.register(observer, new UidObserverRegistration(callingUid, callingPackage, which, cutpoint, canInteractAcrossUsers, uids, token));     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return token;
    L7:
        r3 = false;
    L11:
        th = move-exception;
        throw th;
    }

    void unregister(IUidObserver observer) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidObservers.unregister(observer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    final void addUidToObserver(IBinder observerToken, int uid) {
        Message msg = Message.obtain(this.mHandler, 80, uid, 0, observerToken);
        this.mHandler.sendMessage(msg);
    }

    public final void addUidToObserverImpl(IBinder observerToken, int uid) {
        int i = this.mUidObservers.beginBroadcast();
    L3:
        int i2 = i - 1;
        if (i <= 0) goto L11;
        UidObserverRegistration reg = (UidObserverRegistration) this.mUidObservers.getBroadcastCookie(i2);
        if (reg.getToken().equals(observerToken) == true) goto L7;
        if (i2 != 0) goto L10;
        Slog.e("ActivityManager", "Unable to find UidObserver by token");
    L10:
        i = i2;
        goto L3
    L7:
        reg.addUid(uid);
    L11:
        this.mUidObservers.finishBroadcast();
    }

    final void removeUidFromObserver(IBinder observerToken, int uid) {
        Message msg = Message.obtain(this.mHandler, 81, uid, 0, observerToken);
        this.mHandler.sendMessage(msg);
    }

    public final void removeUidFromObserverImpl(IBinder observerToken, int uid) {
        int i = this.mUidObservers.beginBroadcast();
    L3:
        int i2 = i - 1;
        if (i <= 0) goto L11;
        UidObserverRegistration reg = (UidObserverRegistration) this.mUidObservers.getBroadcastCookie(i2);
        if (reg.getToken().equals(observerToken) == true) goto L7;
        if (i2 != 0) goto L10;
        Slog.e("ActivityManager", "Unable to find UidObserver by token");
    L10:
        i = i2;
        goto L3
    L7:
        reg.removeUid(uid);
    L11:
        this.mUidObservers.finishBroadcast();
    }

    int enqueueUidChange(ChangeRecord currentRecord, int uid, int change, int procState, int procAdj, long procStateSeq, int capability, boolean ephemeral) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingUidChanges.size() == 0) goto L7;
    L12:
        if (currentRecord == null) goto L14;
        ChangeRecord changeRecord = currentRecord;
    L16:
        if (changeRecord.isPending == true) goto L18;
        changeRecord.isPending = true;     // Catch: Throwable -> L9
        this.mPendingUidChanges.add(changeRecord);     // Catch: Throwable -> L9
    L19:
        changeRecord.uid = uid;     // Catch: Throwable -> L9
        changeRecord.change = change;     // Catch: Throwable -> L9
        changeRecord.procState = procState;     // Catch: Throwable -> L9
        changeRecord.procAdj = procAdj;     // Catch: Throwable -> L9
        changeRecord.procStateSeq = procStateSeq;     // Catch: Throwable -> L9
        changeRecord.capability = capability;     // Catch: Throwable -> L9
        changeRecord.ephemeral = ephemeral;     // Catch: Throwable -> L9
        int r2 = changeRecord.change;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L18:
        change = mergeWithPendingChange(change, changeRecord.change);     // Catch: Throwable -> L9
        goto L19
    L14:
        changeRecord = getOrCreateChangeRecordLocked();     // Catch: Throwable -> L9
        goto L16
    L7:
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L11;
        Slog.i("ActivityManager", "*** Enqueueing dispatch uid changed!");     // Catch: Throwable -> L9
    L11:
        this.mHandler.post(this.mDispatchRunnable);     // Catch: Throwable -> L9
        goto L12
    }

    ArrayList<ChangeRecord> getPendingUidChangesForTest() {
        return this.mPendingUidChanges;
    }

    ActiveUids getValidateUidsForTest() {
        return this.mValidateUids;
    }

    Runnable getDispatchRunnableForTest() {
        return this.mDispatchRunnable;
    }

    static int mergeWithPendingChange(int currentChange, int pendingChange) {
        if ((currentChange & 6) != 0) goto L6;
        currentChange = currentChange | (pendingChange & 6);
    L6:
        if ((currentChange & 24) != 0) goto L9;
        currentChange = currentChange | (pendingChange & 24);
    L9:
        if ((currentChange & 1) == 0) goto L12;
        currentChange = currentChange & (-13);
    L12:
        if ((pendingChange & 32) == 0) goto L15;
        currentChange = currentChange | 32;
    L15:
        if ((pendingChange & Integer.MIN_VALUE) == 0) goto L18;
        currentChange = currentChange | Integer.MIN_VALUE;
    L18:
        if ((pendingChange & 64) != 0) goto L20;
        return currentChange;
    L20:
        return currentChange | 64;
    }

    private ChangeRecord getOrCreateChangeRecordLocked() {
        int size = this.mAvailUidChanges.size();
        if (size <= 0) goto L7;
        ChangeRecord changeRecord = this.mAvailUidChanges.remove(size - 1);
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L10;
        Slog.i("ActivityManager", "Retrieving available item: " + changeRecord);
    L10:
        return changeRecord;
    L7:
        changeRecord = new ChangeRecord();
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L10;
        Slog.i("ActivityManager", "Allocating new item: " + changeRecord);
        goto L10
    }

    void dispatchUidsChanged() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int numUidChanges = this.mPendingUidChanges.size();     // Catch: Throwable -> L7
        if (this.mActiveUidChanges.length >= numUidChanges) goto L9;
        this.mActiveUidChanges = new ChangeRecord[numUidChanges];     // Catch: Throwable -> L7
    L9:
        int i = 0;
    L11:
        if (i >= numUidChanges) goto L13;
        ChangeRecord changeRecord = this.mPendingUidChanges.get(i);     // Catch: Throwable -> L7
        this.mActiveUidChanges[i] = getOrCreateChangeRecordLocked();     // Catch: Throwable -> L7
        changeRecord.copyTo(this.mActiveUidChanges[i]);     // Catch: Throwable -> L7
        changeRecord.isPending = false;     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L11
    L13:
        this.mPendingUidChanges.clear();     // Catch: Throwable -> L7
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L16;
        Slog.i("ActivityManager", "*** Delivering " + numUidChanges + " uid changes");     // Catch: Throwable -> L7
    L16:
        this.mUidChangeDispatchCount += numUidChanges;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        int i2 = this.mUidObservers.beginBroadcast();
    L19:
        int i3 = i2 - 1;
        if (i2 <= 0) goto L22;
        dispatchUidsChangedForObserver((IUidObserver) this.mUidObservers.getBroadcastItem(i3), (UidObserverRegistration) this.mUidObservers.getBroadcastCookie(i3), numUidChanges);
        i2 = i3;
        goto L19
    L22:
        this.mUidObservers.finishBroadcast();
        Object r4 = this.mLock;
        monitor-enter(r4);
    L31:
        th = move-exception;
        throw th;
    L25:
        if (this.mUidObservers.getRegisteredCallbackCount() <= 0) goto L44;
        int j = 0;
    L27:
        if (j >= numUidChanges) goto L44;
        ChangeRecord item = this.mActiveUidChanges[j];     // Catch: Throwable -> L31
        if ((item.change & 1) == 0) goto L33;
        this.mValidateUids.remove(item.uid);     // Catch: Throwable -> L31
    L43:
        j = j + 1;     // Catch: Throwable -> L31
        goto L27
    L33:
        UidRecord validateUid = this.mValidateUids.get(item.uid);     // Catch: Throwable -> L31
        if (validateUid != null) goto L37;
        validateUid = new UidRecord(item.uid, null);     // Catch: Throwable -> L31
        this.mValidateUids.put(item.uid, validateUid);     // Catch: Throwable -> L31
    L37:
        if ((item.change & 2) == 0) goto L40;
        validateUid.setIdle(true);     // Catch: Throwable -> L31
    L42:
        validateUid.setSetProcState(item.procState);     // Catch: Throwable -> L31
        validateUid.setCurProcState(item.procState);     // Catch: Throwable -> L31
        validateUid.setSetCapability(item.capability);     // Catch: Throwable -> L31
        validateUid.setCurCapability(item.capability);     // Catch: Throwable -> L31
        goto L43
    L40:
        if ((item.change & 4) == 0) goto L42;
        validateUid.setIdle(false);     // Catch: Throwable -> L31
    L44:
        int j2 = 0;
    L45:
        if (j2 >= numUidChanges) goto L48;
        ChangeRecord changeRecord2 = this.mActiveUidChanges[j2];     // Catch: Throwable -> L31
        changeRecord2.isPending = false;     // Catch: Throwable -> L31
        this.mAvailUidChanges.add(changeRecord2);     // Catch: Throwable -> L31
        j2 = j2 + 1;     // Catch: Throwable -> L31
        goto L45
    L48:
        monitor-exit(r4);     // Catch: Throwable -> L31
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void dispatchUidFrozenStatForObserver(int uid, boolean frozenStat) {
        if (this.mHandler == null) goto L6;
        this.mHandler.post(new FreezeEventRunnable(this, uid, frozenStat));
        return;
    }

    public void handleDispatchUidFrozenStatForObserver(int uid, boolean frozenStat) {
        int i = this.mUidObservers.beginBroadcast();
    L3:
        int i2 = i - 1;
        if (i <= 0) goto L19;
        IUidObserver observer = this.mUidObservers.getBroadcastItem(i2);
        UidObserverRegistration reg = (UidObserverRegistration) this.mUidObservers.getBroadcastCookie(i2);
        if (observer == null) goto L18;
        if ((UidObserverRegistration.m1588$$Nest$fgetmWhich(reg) & 131072) == 0) goto L18;
        Parcel data = Parcel.obtain();     // Catch: RemoteException -> L16
        data.writeInterfaceToken("android.app.IUidObserver");     // Catch: RemoteException -> L16
        data.writeInt(uid);     // Catch: RemoteException -> L16
        if (frozenStat == false) goto L13;
        int r4 = 2;
    L14:
        data.writeInt(r4);     // Catch: RemoteException -> L16
        observer.asBinder().transact(1020, data, null, 1);     // Catch: RemoteException -> L16
        data.recycle();     // Catch: RemoteException -> L16
        goto L18
    L13:
        r4 = 0;
    L18:
        i = i2;
        goto L3
    L19:
        this.mUidObservers.finishBroadcast();
    }

    private void dispatchUidsChangedForObserver(IUidObserver observer, UidObserverRegistration reg, int changesSize) {
        String r0 = ": ";
        if (observer != null) goto L5;
        return;
    L5:
        int j = 0;
    L7:
        if (j >= changesSize) goto L126;
        ChangeRecord item = this.mActiveUidChanges[j];     // Catch: RemoteException -> L17
        long start = SystemClock.uptimeMillis();     // Catch: RemoteException -> L17
        int change = item.change;     // Catch: RemoteException -> L17
        if (reg.isWatchingUid(item.uid) == true) goto L13;
        r0 = r0;
    L124:
        j = j + 1;
        r0 = r0;
        goto L7
    L13:
        if (UserHandle.getUserId(item.uid) == UserHandle.getUserId(UidObserverRegistration.m1587$$Nest$fgetmUid(reg))) goto L20;
        if (UidObserverRegistration.m1584$$Nest$fgetmCanInteractAcrossUsers(reg) == true) goto L20;
        r0 = r0;
    L20:
        if (change != Integer.MIN_VALUE) goto L25;
        if ((UidObserverRegistration.m1588$$Nest$fgetmWhich(reg) & 1) != 0) goto L25;
        r0 = r0;
    L25:
        if (change != 64) goto L31;
        if ((UidObserverRegistration.m1588$$Nest$fgetmWhich(reg) & 64) != 0) goto L31;
        r0 = r0;
    L31:
        if ((change & 2) == 0) goto L39;
        if ((UidObserverRegistration.m1588$$Nest$fgetmWhich(reg) & 4) == 0) goto L47;
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L37;
        Slog.i("ActivityManager", "UID idle uid=" + item.uid);     // Catch: RemoteException -> L17
    L37:
        observer.onUidIdle(item.uid, item.ephemeral);     // Catch: RemoteException -> L17
    L47:
        if ((UidObserverRegistration.m1588$$Nest$fgetmWhich(reg) & 16) == 0) goto L61;
        if ((change & 8) == 0) goto L55;
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L53;
        Slog.i("ActivityManager", "UID cached uid=" + item.uid);     // Catch: RemoteException -> L17
    L53:
        observer.onUidCachedChanged(item.uid, true);     // Catch: RemoteException -> L17
        goto L61
    L55:
        if ((change & 16) == 0) goto L61;
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L59;
        Slog.i("ActivityManager", "UID active uid=" + item.uid);     // Catch: RemoteException -> L17
    L59:
        observer.onUidCachedChanged(item.uid, false);     // Catch: RemoteException -> L17
    L61:
        if ((change & 1) != 0) goto L63;
        boolean doReport = false;
        if ((UidObserverRegistration.m1588$$Nest$fgetmWhich(reg) & 1) == 0) goto L96;
        doReport = true;
        if (UidObserverRegistration.m1585$$Nest$fgetmCutpoint(reg) < 0) goto L95;
        boolean r18 = true;
        int lastState = reg.mLastProcStates.get(item.uid, -1);     // Catch: RemoteException -> L17
        if (lastState != (-1)) goto L79;
        int r6 = 20;
        if (item.procState == 20) goto L93;
        boolean r4 = true;
    L94:
        doReport = r4;
    L98:
        if ((UidObserverRegistration.m1588$$Nest$fgetmWhich(reg) & 32) != 0) goto L100;
        boolean doReport2 = doReport;
    L105:
        if (doReport2 == true) goto L107;
        int r1 = r6;
    L115:
        if ((UidObserverRegistration.m1588$$Nest$fgetmWhich(reg) & 64) != 0) goto L117;
    L119:
        int duration = (int) (SystemClock.uptimeMillis() - start);     // Catch: RemoteException -> L17
        if (reg.mMaxDispatchTime >= duration) goto L122;
        reg.mMaxDispatchTime = duration;     // Catch: RemoteException -> L17
    L122:
        if (duration < r1) goto L124;
        reg.mSlowDispatchCount++;     // Catch: RemoteException -> L17
        goto L124
    L117:
        if ((change & 64) == 0) goto L119;
        observer.onUidProcAdjChanged(item.uid, item.procAdj);     // Catch: RemoteException -> L17
        goto L119
    L107:
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L110;
        Slog.i("ActivityManager", "UID CHANGED uid=" + item.uid + r0 + item.procState + r0 + item.capability);     // Catch: RemoteException -> L17
    L110:
        if (reg.mLastProcStates == null) goto L112;
        reg.mLastProcStates.put(item.uid, item.procState);     // Catch: RemoteException -> L17
    L112:
        r1 = r6;
        observer.onUidStateChanged(item.uid, item.procState, item.procStateSeq, item.capability);     // Catch: RemoteException -> L17
        goto L115
    L100:
        if ((change & 32) == 0) goto L102;
        boolean r17 = r18;
    L103:
        doReport2 = doReport | r17;     // Catch: RemoteException -> L17
        goto L105
    L102:
        r17 = false;
        goto L103
    L93:
        r4 = false;
        goto L94
    L79:
        if (lastState > UidObserverRegistration.m1585$$Nest$fgetmCutpoint(reg)) goto L81;
        boolean lastAboveCut = true;
    L83:
        if (item.procState > UidObserverRegistration.m1585$$Nest$fgetmCutpoint(reg)) goto L85;
        boolean newAboveCut = true;
    L86:
        if (lastAboveCut == newAboveCut) goto L88;
        boolean r15 = true;
    L89:
        doReport = r15;
        r6 = 20;
        goto L98
    L88:
        r15 = false;
        goto L89
    L85:
        newAboveCut = false;
        goto L86
    L81:
        lastAboveCut = false;
        goto L83
    L95:
        r18 = true;
        r6 = 20;
        goto L98
    L96:
        r18 = true;
        r6 = 20;
        goto L98
    L63:
        if ((UidObserverRegistration.m1588$$Nest$fgetmWhich(reg) & 2) == 0) goto L69;
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L67;
        Slog.i("ActivityManager", "UID gone uid=" + item.uid);     // Catch: RemoteException -> L17
    L67:
        observer.onUidGone(item.uid, item.ephemeral);     // Catch: RemoteException -> L17
    L69:
        if (reg.mLastProcStates == null) goto L71;
        reg.mLastProcStates.delete(item.uid);     // Catch: RemoteException -> L17
        r0 = r0;
        r1 = 20;
        goto L119
    L71:
        r0 = r0;
        r1 = 20;
        goto L119
    L39:
        if ((change & 4) == 0) goto L47;
        if ((UidObserverRegistration.m1588$$Nest$fgetmWhich(reg) & 8) == 0) goto L47;
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L45;
        Slog.i("ActivityManager", "UID active uid=" + item.uid);     // Catch: RemoteException -> L17
    L45:
        observer.onUidActive(item.uid);     // Catch: RemoteException -> L17
    L136:
        return;
    }

    UidRecord getValidateUidRecord(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UidRecord r1 = this.mValidateUids.get(uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw, String dumpPackage) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int count = this.mUidObservers.getRegisteredCallbackCount();     // Catch: Throwable -> L11
        boolean printed = false;
        int i = 0;
    L5:
        if (i >= count) goto L18;
        UidObserverRegistration reg = (UidObserverRegistration) this.mUidObservers.getRegisteredCallbackCookie(i);     // Catch: Throwable -> L11
        if (dumpPackage == null) goto L13;
        if (dumpPackage.equals(UidObserverRegistration.m1586$$Nest$fgetmPkg(reg)) == true) goto L13;
    L16:
        i = i + 1;     // Catch: Throwable -> L11
    L13:
        if (printed == true) goto L15;
        pw.println("  mUidObservers:");     // Catch: Throwable -> L11
        printed = true;
    L15:
        reg.dump(pw, (IUidObserver) this.mUidObservers.getRegisteredCallbackItem(i));     // Catch: Throwable -> L11
        goto L16
    L18:
        if (dumpPackage != null) goto L22;
        pw.println();     // Catch: Throwable -> L11
        pw.print("  mUidChangeDispatchCount=");     // Catch: Throwable -> L11
        pw.print(this.mUidChangeDispatchCount);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("  Slow UID dispatches:");     // Catch: Throwable -> L11
        int i2 = 0;
    L20:
        if (i2 >= count) goto L22;
        UidObserverRegistration reg2 = (UidObserverRegistration) this.mUidObservers.getRegisteredCallbackCookie(i2);     // Catch: Throwable -> L11
        pw.print("    ");     // Catch: Throwable -> L11
        pw.print(this.mUidObservers.getRegisteredCallbackItem(i2).getClass().getTypeName());     // Catch: Throwable -> L11
        pw.print(": ");     // Catch: Throwable -> L11
        pw.print(reg2.mSlowDispatchCount);     // Catch: Throwable -> L11
        pw.print(" / Max ");     // Catch: Throwable -> L11
        pw.print(reg2.mMaxDispatchTime);     // Catch: Throwable -> L11
        pw.println("ms");     // Catch: Throwable -> L11
        i2 = i2 + 1;     // Catch: Throwable -> L11
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void dumpDebug(ProtoOutputStream proto, String dumpPackage) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int count = this.mUidObservers.getRegisteredCallbackCount();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= count) goto L16;
        UidObserverRegistration reg = (UidObserverRegistration) this.mUidObservers.getRegisteredCallbackCookie(i);     // Catch: Throwable -> L11
        if (dumpPackage == null) goto L13;
        if (dumpPackage.equals(UidObserverRegistration.m1586$$Nest$fgetmPkg(reg)) == true) goto L13;
    L14:
        i = i + 1;     // Catch: Throwable -> L11
    L13:
        reg.dumpDebug(proto, 2246267895831L);     // Catch: Throwable -> L11
        goto L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    boolean dumpValidateUids(PrintWriter pw, String dumpPackage, int dumpAppId, String header, boolean needSep) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        boolean r9 = this.mValidateUids.dump(pw, dumpPackage, dumpAppId, header, needSep);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r9;
    L9:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L11:
        th = move-exception;
        r10 = th;
        goto L13
    }

    void dumpValidateUidsProto(ProtoOutputStream proto, String dumpPackage, int dumpAppId, long fieldId) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mValidateUids.dumpProto(proto, dumpPackage, dumpAppId, fieldId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L9:
        th = move-exception;
        r9 = th;
        goto L13
    }
}
