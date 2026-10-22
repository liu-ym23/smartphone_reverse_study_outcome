package com.android.server.am;

import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.AppGlobals;
import android.app.PendingIntent;
import android.app.PendingIntentStats;
import android.app.compat.CompatChanges;
import android.content.IIntentSender;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.RingBuffer;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.AlarmManagerInternal;
import com.android.server.LocalServices;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.SafeActivityOptions;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PendingIntentController {
    private static final int RECENT_N = 10;
    private static final String TAG = "ActivityManager";
    private static final String TAG_MU = "ActivityManager_MU";
    ActivityManagerInternal mAmInternal;
    final ActivityTaskManagerInternal mAtmInternal;
    private final ActivityManagerConstants mConstants;
    final Handler mH;
    final HashMap<PendingIntentRecord.Key, WeakReference<PendingIntentRecord>> mIntentSenderRecords;
    private final SparseIntArray mIntentsPerUid;
    final Object mLock;
    private final SparseArray<RingBuffer<String>> mRecentIntentsPerUid;
    final UserController mUserController;

    public static /* synthetic */ void $r8$lambda$8vj5VIrljGq4Dukmp0KCav7XWBE(PendingIntentController r0, IBinder r1, WeakReference r2) {
        r0.clearPendingResultForActivity(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Y9H9gAAIG9kPXv00oSEIO4TUeCM(PendingIntentController r0, RemoteCallbackList r1) {
        r0.handlePendingIntentCancelled(r1);
    }

    PendingIntentController(Looper looper, UserController userController, ActivityManagerConstants constants) {
        this.mLock = new Object();
        this.mIntentSenderRecords = new HashMap();
        this.mIntentsPerUid = new SparseIntArray();
        this.mRecentIntentsPerUid = new SparseArray();
        this.mH = new Handler(looper);
        this.mAtmInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        this.mUserController = userController;
        this.mConstants = constants;
    }

    void onActivityManagerInternalAdded() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAmInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public PendingIntentRecord getIntentSender(int type, String packageName, String featureId, int callingUid, int userId, IBinder token, String resultWho, int requestCode, Intent[] intents, String[] resolvedTypes, int flags, Bundle bOptions) {
        Object r15 = this.mLock;
        monitor-enter(r15);
    L65:
        th = th;
    L79:
        monitor-exit(r15);     // Catch: Throwable -> L65
        throw th;
    L7:
        th = th;
        goto L79
    L5:
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L10;
        Slog.v(TAG_MU, "getIntentSender(): uid=" + callingUid);     // Catch: Throwable -> L7
    L10:
        if (intents == null) goto L15;
        int i = 0;
    L13:
        if (i >= intents.length) goto L15;
        intents[i].setDefusable(true);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
    L15:
        Bundle.setDefusable(bOptions, true);     // Catch: Throwable -> L7
        ActivityOptions opts = ActivityOptions.fromBundle(bOptions);     // Catch: Throwable -> L7
        boolean r5 = false;
        if (opts != null) goto L84;
    L29:
        String r8 = packageName;
    L31:
        if ((flags & 536870912) == 0) goto L33;
        boolean r6 = true;
    L34:
        boolean noCreate = r6;
        if ((flags & 268435456) == 0) goto L37;
        boolean r7 = true;
    L38:
        boolean cancelCurrent = r7;
        if ((flags & 134217728) == 0) goto L41;
        r5 = true;
    L41:
        boolean updateCurrent = r5;
    L48:
        th = th;
        goto L79
    L44:
        PendingIntentRecord.Key key = new PendingIntentRecord.Key(type, r8, featureId, token, resultWho, requestCode, intents, resolvedTypes, flags & (-939524097), new SafeActivityOptions(opts, Binder.getCallingPid(), Binder.getCallingUid()), userId);     // Catch: Throwable -> L65
        WeakReference<PendingIntentRecord> ref = this.mIntentSenderRecords.get(key);     // Catch: Throwable -> L48
        if (ref == null) goto L50;
        PendingIntentRecord rec = ref.get();     // Catch: Throwable -> L48
    L51:
        if (rec == null) goto L73;
        if (cancelCurrent == true) goto L71;
        if (updateCurrent == false) goto L69;
        if (rec.key.requestIntent == null) goto L61;
        Intent r9 = rec.key.requestIntent;     // Catch: Throwable -> L48
        if (intents == null) goto L59;
        Intent r10 = intents[intents.length - 1];     // Catch: Throwable -> L48
    L60:
        r9.replaceExtras(r10);     // Catch: Throwable -> L48
        goto L61
    L59:
        r10 = null;
    L61:
        if (intents == null) goto L67;
        intents[intents.length - 1] = rec.key.requestIntent;     // Catch: Throwable -> L48
        rec.key.allIntents = intents;     // Catch: Throwable -> L48
        rec.key.allResolvedTypes = resolvedTypes;     // Catch: Throwable -> L65
        goto L69
    L67:
        rec.key.allIntents = null;     // Catch: Throwable -> L65
        rec.key.allResolvedTypes = null;     // Catch: Throwable -> L65
    L69:
        monitor-exit(r15);     // Catch: Throwable -> L65
        return rec;
    L71:
        makeIntentSenderCanceled(rec, 32);     // Catch: Throwable -> L65
        this.mIntentSenderRecords.remove(key);     // Catch: Throwable -> L65
        decrementUidStatLocked(rec);     // Catch: Throwable -> L65
    L73:
        if (noCreate == false) goto L76;
        monitor-exit(r15);     // Catch: Throwable -> L65
        return rec;
    L76:
        PendingIntentRecord rec2 = new PendingIntentRecord(this, key, callingUid);     // Catch: Throwable -> L65
        this.mIntentSenderRecords.put(key, rec2.ref);     // Catch: Throwable -> L65
        incrementUidStatLocked(rec2);     // Catch: Throwable -> L65
        monitor-exit(r15);     // Catch: Throwable -> L65
        return rec2;
    L50:
        rec = null;
        goto L51
    L37:
        r7 = false;
        goto L38
    L33:
        r6 = false;
        goto L34
    L84:
    L27:
        th = th;
        goto L79
    L19:
        if (opts.getPendingIntentBackgroundActivityStartMode() == 0) goto L29;
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L27
        r11.append("Resetting option setPendingIntentBackgroundActivityStartMode(");     // Catch: Throwable -> L27
        r11.append(opts.getPendingIntentBackgroundActivityStartMode());     // Catch: Throwable -> L27
        r11.append(") to SYSTEM_DEFINED from the options provided by the pending intent creator (");     // Catch: Throwable -> L27
        r8 = packageName;
        r11.append(r8);     // Catch: Throwable -> L7
        r11.append(") because this option is meant for the pending intent sender");     // Catch: Throwable -> L7
        Slog.wtf(TAG, r11.toString());     // Catch: Throwable -> L7
        if (CompatChanges.isChangeEnabled(320664730, callingUid) == true) goto L26;
        opts.setPendingIntentBackgroundActivityStartMode(0);     // Catch: Throwable -> L7
        goto L31
    L26:
        throw new IllegalArgumentException("pendingIntentBackgroundActivityStartMode must not be set when creating a PendingIntent");     // Catch: Throwable -> L7
    }

    boolean removePendingIntentsForPackage(String packageName, int userId, int appId, boolean doIt, int cancelReason) {
        boolean didSomething = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntentSenderRecords.size() > 0) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L11:
        Iterator<WeakReference<PendingIntentRecord>> it = this.mIntentSenderRecords.values().iterator();     // Catch: Throwable -> L9
    L13:
        if (it.hasNext() == false) goto L44;
        WeakReference<PendingIntentRecord> wpir = it.next();     // Catch: Throwable -> L9
        if (wpir == null) goto L16;
        PendingIntentRecord pir = wpir.get();     // Catch: Throwable -> L9
        if (pir == null) goto L19;
        if (packageName == null) goto L22;
        if (UserHandle.getAppId(pir.uid) != appId) goto L13;
        if (userId == (-1)) goto L33;
        if (pir.key.userId != userId) goto L13;
    L33:
        if (pir.key.packageName.equals(packageName) == false) goto L13;
    L35:
        if (doIt == false) goto L36;
        didSomething = true;
        it.remove();     // Catch: Throwable -> L9
        makeIntentSenderCanceled(pir, cancelReason);     // Catch: Throwable -> L9
        decrementUidStatLocked(pir);     // Catch: Throwable -> L9
        if (pir.key.activity == null) goto L13;
        Message m = PooledLambda.obtainMessage(new PendingIntentController$$ExternalSyntheticLambda0(), this, pir.key.activity, pir.ref);     // Catch: Throwable -> L9
        this.mH.sendMessage(m);     // Catch: Throwable -> L9
        goto L13
    L36:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return true;
    L22:
        if (pir.key.userId == userId) goto L35;
    L19:
        it.remove();     // Catch: Throwable -> L9
        goto L13
    L16:
        it.remove();     // Catch: Throwable -> L9
        goto L13
    L44:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return didSomething;
    }

    public void cancelIntentSender(IIntentSender sender) {
        if ((sender instanceof PendingIntentRecord) == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        PendingIntentRecord rec = (PendingIntentRecord) sender;     // Catch: Throwable -> L14
        int uid = AppGlobals.getPackageManager().getPackageUid(rec.key.packageName, 268435456, UserHandle.getCallingUserId());     // Catch: Throwable -> L14 RemoteException -> L18
        if (UserHandle.isSameApp(uid, Binder.getCallingUid()) == true) goto L11;
        String msg = "Permission Denial: cancelIntentSender() from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " is not allowed to cancel package " + rec.key.packageName;     // Catch: Throwable -> L14 RemoteException -> L18
        Slog.w(TAG, msg);     // Catch: Throwable -> L14 RemoteException -> L18
        throw new SecurityException(msg);     // Catch: Throwable -> L14 RemoteException -> L18
    L11:
        cancelIntentSender(rec, true, 8);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L18:
        e = move-exception;
        throw new SecurityException(e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public void cancelIntentSender(PendingIntentRecord rec, boolean cleanActivity, int cancelReason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        makeIntentSenderCanceled(rec, cancelReason);     // Catch: Throwable -> L9
        this.mIntentSenderRecords.remove(rec.key);     // Catch: Throwable -> L9
        decrementUidStatLocked(rec);     // Catch: Throwable -> L9
        if (cleanActivity == true) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (rec.key.activity == null) goto L11;
        Message m = PooledLambda.obtainMessage(new PendingIntentController$$ExternalSyntheticLambda0(), this, rec.key.activity, rec.ref);     // Catch: Throwable -> L9
        this.mH.sendMessage(m);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    boolean registerIntentSenderCancelListener(IIntentSender sender, IResultReceiver receiver) {
        if ((sender instanceof PendingIntentRecord) == true) goto L6;
        Slog.w(TAG, "registerIntentSenderCancelListener called on non-PendingIntentRecord");
        return true;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        PendingIntentRecord pendingIntent = (PendingIntentRecord) sender;     // Catch: Throwable -> L13
        boolean isCancelled = pendingIntent.canceled;     // Catch: Throwable -> L13
        if (isCancelled == true) goto L15;
        pendingIntent.registerCancelListenerLocked(receiver);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    void unregisterIntentSenderCancelListener(IIntentSender sender, IResultReceiver receiver) {
        if ((sender instanceof PendingIntentRecord) == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        ((PendingIntentRecord) sender).unregisterCancelListenerLocked(receiver);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void setPendingIntentAllowlistDuration(IIntentSender target, IBinder allowlistToken, long duration, int type, int reasonCode, String reason) {
        if ((target instanceof PendingIntentRecord) == true) goto L6;
        Slog.w(TAG, "markAsSentFromNotification(): not a PendingIntentRecord: " + target);
        return;
    L6:
        Object r1 = this.mLock;
        monitor-enter(r1);
        ((PendingIntentRecord) target).setAllowlistDurationLocked(allowlistToken, duration, type, reasonCode, reason);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    int getPendingIntentFlags(IIntentSender target) {
        if ((target instanceof PendingIntentRecord) == true) goto L6;
        Slog.w(TAG, "markAsSentFromNotification(): not a PendingIntentRecord: " + target);
        return 0;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = ((PendingIntentRecord) target).key.flags;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    private void makeIntentSenderCanceled(PendingIntentRecord rec, int cancelReason) {
        rec.canceled = true;
        rec.cancelReason = cancelReason;
        RemoteCallbackList<IResultReceiver> callbacks = rec.detachCancelListenersLocked();
        if (callbacks == null) goto L5;
        Message m = PooledLambda.obtainMessage(new PendingIntentController$$ExternalSyntheticLambda1(), this, callbacks);
        this.mH.sendMessage(m);
    L5:
        AlarmManagerInternal ami = (AlarmManagerInternal) LocalServices.getService(AlarmManagerInternal.class);
        ami.remove(new PendingIntent(rec));
    }

    private void handlePendingIntentCancelled(RemoteCallbackList<IResultReceiver> callbacks) {
        int N = callbacks.beginBroadcast();
        int i = 0;
    L3:
        if (i >= N) goto L8;
        callbacks.getBroadcastItem(i).send(0, null);     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        callbacks.finishBroadcast();
        callbacks.kill();
    }

    private void clearPendingResultForActivity(IBinder activityToken, WeakReference<PendingIntentRecord> pir) {
        this.mAtmInternal.clearPendingResultForActivity(activityToken, pir);
    }

    void dumpPendingIntents(PrintWriter pw, boolean dumpAll, String dumpPackage) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean printed = false;
        pw.println("ACTIVITY MANAGER PENDING INTENTS (dumpsys activity intents)");     // Catch: Throwable -> L13
        if (this.mIntentSenderRecords.size() <= 0) goto L43;
        ArrayMap<String, ArrayList<PendingIntentRecord>> byPackage = new ArrayMap();     // Catch: Throwable -> L13
        ArrayList<WeakReference<PendingIntentRecord>> weakRefs = new ArrayList();     // Catch: Throwable -> L13
        Iterator<WeakReference<PendingIntentRecord>> it = this.mIntentSenderRecords.values().iterator();     // Catch: Throwable -> L13
    L9:
        if (it.hasNext() == false) goto L26;
        WeakReference<PendingIntentRecord> ref = it.next();     // Catch: Throwable -> L13
        if (ref == null) goto L15;
        PendingIntentRecord rec = ref.get();     // Catch: Throwable -> L13
    L16:
        if (rec == null) goto L17;
        if (dumpPackage == null) goto L22;
        if (dumpPackage.equals(rec.key.packageName) == false) goto L9;
    L22:
        ArrayList<PendingIntentRecord> list = byPackage.get(rec.key.packageName);     // Catch: Throwable -> L13
        if (list != null) goto L25;
        list = new ArrayList();     // Catch: Throwable -> L13
        byPackage.put(rec.key.packageName, list);     // Catch: Throwable -> L13
    L25:
        list.add(rec);     // Catch: Throwable -> L13
        goto L9
    L17:
        weakRefs.add(ref);     // Catch: Throwable -> L13
        goto L9
    L15:
        rec = null;
        goto L16
    L26:
        int i = 0;
    L28:
        if (i >= byPackage.size()) goto L37;
        ArrayList<PendingIntentRecord> intents = byPackage.valueAt(i);     // Catch: Throwable -> L13
        printed = true;
        pw.print("  * ");     // Catch: Throwable -> L13
        pw.print(byPackage.keyAt(i));     // Catch: Throwable -> L13
        pw.print(": ");     // Catch: Throwable -> L13
        pw.print(intents.size());     // Catch: Throwable -> L13
        pw.println(" items");     // Catch: Throwable -> L13
        int j = 0;
    L31:
        if (j >= intents.size()) goto L36;
        pw.print("    #");     // Catch: Throwable -> L13
        pw.print(j);     // Catch: Throwable -> L13
        pw.print(": ");     // Catch: Throwable -> L13
        pw.println(intents.get(j));     // Catch: Throwable -> L13
        if (dumpAll == false) goto L35;
        intents.get(j).dump(pw, "      ");     // Catch: Throwable -> L13
    L35:
        j = j + 1;     // Catch: Throwable -> L13
        goto L31
    L36:
        i = i + 1;     // Catch: Throwable -> L13
        goto L28
    L37:
        int i2 = weakRefs.size();     // Catch: Throwable -> L13
        if (i2 <= 0) goto L43;
        printed = true;
        pw.println("  * WEAK REFS:");     // Catch: Throwable -> L13
        int i3 = 0;
    L41:
        if (i3 >= weakRefs.size()) goto L43;
        pw.print("    #");     // Catch: Throwable -> L13
        pw.print(i3);     // Catch: Throwable -> L13
        pw.print(": ");     // Catch: Throwable -> L13
        pw.println(weakRefs.get(i3));     // Catch: Throwable -> L13
        i3 = i3 + 1;     // Catch: Throwable -> L13
    L43:
        int sizeOfIntentsPerUid = this.mIntentsPerUid.size();     // Catch: Throwable -> L13
        if (sizeOfIntentsPerUid <= 0) goto L48;
        int i4 = 0;
    L46:
        if (i4 >= sizeOfIntentsPerUid) goto L48;
        pw.print("  * UID: ");     // Catch: Throwable -> L13
        pw.print(this.mIntentsPerUid.keyAt(i4));     // Catch: Throwable -> L13
        pw.print(" total: ");     // Catch: Throwable -> L13
        pw.println(this.mIntentsPerUid.valueAt(i4));     // Catch: Throwable -> L13
        i4 = i4 + 1;     // Catch: Throwable -> L13
    L48:
        if (printed == true) goto L50;
        pw.println("  (nothing)");     // Catch: Throwable -> L13
    L50:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public List<PendingIntentStats> dumpPendingIntentStatsForStatsd() {
        List<PendingIntentStats> pendingIntentStats = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntentSenderRecords.size() <= 0) goto L24;
        SparseIntArray countsByUid = new SparseIntArray();     // Catch: Throwable -> L17
        SparseIntArray bundleSizesByUid = new SparseIntArray();     // Catch: Throwable -> L17
        Iterator<WeakReference<PendingIntentRecord>> r4 = this.mIntentSenderRecords.values().iterator();     // Catch: Throwable -> L17
    L8:
        if (r4.hasNext() == false) goto L21;
        WeakReference<PendingIntentRecord> reference = r4.next();     // Catch: Throwable -> L17
        if (reference == null) goto L8;
        if (reference.get() == null) goto L8;
        PendingIntentRecord record = reference.get();     // Catch: Throwable -> L17
        int index = countsByUid.indexOfKey(record.uid);     // Catch: Throwable -> L17
        if (index >= 0) goto L19;
        countsByUid.put(record.uid, 1);     // Catch: Throwable -> L17
        bundleSizesByUid.put(record.uid, record.key.requestIntent.getExtrasTotalSize());     // Catch: Throwable -> L17
        goto L8
    L19:
        countsByUid.put(record.uid, countsByUid.valueAt(index) + 1);     // Catch: Throwable -> L17
        bundleSizesByUid.put(record.uid, bundleSizesByUid.valueAt(index) + record.key.requestIntent.getExtrasTotalSize());     // Catch: Throwable -> L17
        goto L8
    L21:
        int i = 0;
        int size = countsByUid.size();     // Catch: Throwable -> L17
    L22:
        if (i >= size) goto L24;
        pendingIntentStats.add(new PendingIntentStats(countsByUid.keyAt(i), countsByUid.valueAt(i), bundleSizesByUid.valueAt(i) / 1024));     // Catch: Throwable -> L17
        i = i + 1;     // Catch: Throwable -> L17
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return pendingIntentStats;
    }

    void incrementUidStatLocked(PendingIntentRecord pir) {
        int uid = pir.uid;
        int idx = this.mIntentsPerUid.indexOfKey(uid);
        int newCount = 1;
        if (idx < 0) goto L5;
        newCount = this.mIntentsPerUid.valueAt(idx) + 1;
        this.mIntentsPerUid.setValueAt(idx, newCount);
    L6:
        int lowBound = (this.mConstants.PENDINGINTENT_WARNING_THRESHOLD - 10) + 1;
        RingBuffer<String> recentHistory = null;
        if (newCount != lowBound) goto L9;
        recentHistory = new RingBuffer(String.class, 10);
        this.mRecentIntentsPerUid.put(uid, recentHistory);
    L13:
        if (recentHistory != null) goto L15;
        return;
    L15:
        recentHistory.append(pir.key.toString());
        if (newCount != this.mConstants.PENDINGINTENT_WARNING_THRESHOLD) goto L19;
        Slog.wtf(TAG, "Too many PendingIntent created for uid " + uid + ", recent 10: " + Arrays.toString(recentHistory.toArray()));
        this.mRecentIntentsPerUid.remove(uid);
        return;
    L19:
        return;
    L9:
        if (newCount <= lowBound) goto L13;
        if (newCount > this.mConstants.PENDINGINTENT_WARNING_THRESHOLD) goto L13;
        recentHistory = this.mRecentIntentsPerUid.get(uid);
        goto L13
    L5:
        this.mIntentsPerUid.put(uid, 1);
        goto L6
    }

    void decrementUidStatLocked(PendingIntentRecord pir) {
        int uid = pir.uid;
        int idx = this.mIntentsPerUid.indexOfKey(uid);
        if (idx < 0) goto L11;
        int newCount = this.mIntentsPerUid.valueAt(idx) - 1;
        if (newCount != (this.mConstants.PENDINGINTENT_WARNING_THRESHOLD - 10)) goto L7;
        this.mRecentIntentsPerUid.delete(uid);
    L7:
        if (newCount != 0) goto L9;
        this.mIntentsPerUid.removeAt(idx);
        return;
    L9:
        this.mIntentsPerUid.setValueAt(idx, newCount);
        return;
    }
}
