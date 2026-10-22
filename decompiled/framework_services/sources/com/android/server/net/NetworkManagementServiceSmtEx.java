package com.android.server.net;

import android.app.SmtOpsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import com.android.internal.net.IOemNetd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkManagementServiceSmtEx {
    private Context mContext;
    private ArrayList<Integer> mDisabledDataUids;
    private ArrayList<Integer> mDisabledWlanUids;
    private Handler mHandler;
    private ArrayList<OpRecord> mOpsQueue;
    private NetworkManagementService mService;
    protected SmtOpsManager mSmtOps;
    private SmtOpsManager.OnOpChangedInternalListener mSmtOpsChangeListener;
    private BroadcastReceiver mUidRemovedReceiver;

    private class OpRecord {
        int mOpCode;
        String mPackageName;

        public OpRecord(NetworkManagementServiceSmtEx r1, String pkgName, int code) {
            this.mPackageName = pkgName;
            this.mOpCode = code;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisabledDataUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m5951$$Nest$fgetmDisabledDataUids(NetworkManagementServiceSmtEx r0) {
        return r0.mDisabledDataUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisabledWlanUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m5952$$Nest$fgetmDisabledWlanUids(NetworkManagementServiceSmtEx r0) {
        return r0.mDisabledWlanUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m5953$$Nest$fgetmHandler(NetworkManagementServiceSmtEx r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOpsQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m5954$$Nest$fgetmOpsQueue(NetworkManagementServiceSmtEx r0) {
        return r0.mOpsQueue;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOpChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5955$$Nest$mhandleOpChanged(NetworkManagementServiceSmtEx r0, String r1, int r2) {
        r0.handleOpChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mprocessNextOp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5956$$Nest$mprocessNextOp(NetworkManagementServiceSmtEx r0) {
        r0.processNextOp();
    }

    public NetworkManagementServiceSmtEx(Context context, NetworkManagementService service, Handler handler) {
        this.mOpsQueue = new ArrayList();
        this.mDisabledDataUids = new ArrayList();
        this.mDisabledWlanUids = new ArrayList();
        this.mSmtOpsChangeListener = new AnonymousClass1(this);
        this.mUidRemovedReceiver = new AnonymousClass2(this);
        this.mContext = context;
        this.mService = service;
        this.mHandler = handler;
        this.mSmtOps = (SmtOpsManager) this.mContext.getSystemService("smtops");
    }

    public void setUidNetworkPolicy(int uid, String iface, boolean enable) {
        Object r0 = this.mService.mQuotaLock;
        monitor-enter(r0);
        IOemNetd oemNetd = getOemNetdService();     // Catch: Throwable -> L7 Exception -> L9
        if (enable == false) goto L11;
        oemNetd.bandwidthRemoveBlockedUid(uid, iface);     // Catch: Throwable -> L7 Exception -> L9
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L11:
        oemNetd.bandwidthAddBlockedUid(uid, iface);     // Catch: Throwable -> L7 Exception -> L9
    L9:
        e = move-exception;
        throw new IllegalStateException(e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private IOemNetd getOemNetdService() throws Exception {
        IBinder binder = this.mService.mNetdService.getOemNetd();
        if (binder == null) goto L7;
        return IOemNetd.Stub.asInterface(Binder.allowBlocking(binder));
    L7:
        throw new IllegalStateException("Failed to get IOemNetd binder");
    }

    void prepareOemRules() {
        if (this.mSmtOps.getEnabled() == false) goto L5;
        updateAllPackagesRule(true);
    L5:
        this.mContext.registerReceiver(this.mUidRemovedReceiver, new IntentFilter("android.intent.action.UID_REMOVED"), null, this.mHandler);
        this.mSmtOps.startWatchingMode(16, null, this.mSmtOpsChangeListener);
        this.mSmtOps.startWatchingMode(17, null, this.mSmtOpsChangeListener);
    }

    private void updateAllPackagesRule(boolean enable) {
        List<SmtOpsManager.PackageOps> pkgOps = this.mSmtOps.getPackagesForOps(new int[]{16, 17});
        if (pkgOps != null) goto L5;
        return;
    L5:
        Iterator<SmtOpsManager.PackageOps> r1 = pkgOps.iterator();
    L7:
        if (r1.hasNext() == false) goto L34;
        SmtOpsManager.PackageOps ops = r1.next();
        ops.getPackageName();
        List<SmtOpsManager.OpEntry> entries = ops.getOps();
        if (entries == null) goto L7;
        int N = entries.size();
        int n = 0;
    L11:
        if (n >= N) goto L7;
        SmtOpsManager.OpEntry entry = entries.get(n);
        switch(entry.getOp()) {
            case 17: goto L22;
            default: goto L14;
        };
    L14:
        String iface = "rmnet+";
        ArrayList<OpRecord> r11 = this.mOpsQueue;
        monitor-enter(r11);
        ArrayList<Integer> array = this.mDisabledDataUids;     // Catch: Throwable -> L19
        monitor-exit(r11);     // Catch: Throwable -> L19
    L27:
        if (entry.getMode() != 1) goto L29;
        setUidNetworkPolicy(ops.getUid(), iface, false);
        array.add(Integer.valueOf(ops.getUid()));
    L29:
        n = n + 1;
    L19:
        th = move-exception;
        throw th;
    L22:
        iface = "wlan+";
        ArrayList<OpRecord> r8 = this.mOpsQueue;
        monitor-enter(r8);
        array = this.mDisabledWlanUids;     // Catch: Throwable -> L30
        monitor-exit(r8);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    private void updatePackageRuleLocked(String pkg, int op) {
        PackageManager pm = this.mContext.getPackageManager();
        int uid = pm.getPackageUid(pkg, 0);     // Catch: PackageManager.NameNotFoundException -> L7
        int mode = this.mSmtOps.checkOpNoThrow(op, uid, pkg);     // Catch: PackageManager.NameNotFoundException -> L7
        String iface = "rmnet+";
        switch(op) {
            case 17: goto L9;
            default: goto L6;
        };
    L6:
        ArrayList<Integer> array = this.mDisabledDataUids;     // Catch: PackageManager.NameNotFoundException -> L7
    L11:
        if (mode != 1) goto L16;
        if (array.contains(Integer.valueOf(uid)) == true) goto L22;
        setUidNetworkPolicy(uid, iface, false);     // Catch: PackageManager.NameNotFoundException -> L7
        array.add(Integer.valueOf(uid));     // Catch: PackageManager.NameNotFoundException -> L7
        return;
    L22:
        return;
    L16:
        if (array.contains(Integer.valueOf(uid)) == false) goto L24;
        setUidNetworkPolicy(uid, iface, true);     // Catch: PackageManager.NameNotFoundException -> L7
        array.remove(Integer.valueOf(uid));     // Catch: PackageManager.NameNotFoundException -> L7
        return;
    L24:
        return;
    L9:
        iface = "wlan+";
        array = this.mDisabledWlanUids;     // Catch: PackageManager.NameNotFoundException -> L7
        goto L11
    }

    private void handleOpChanged(String pkg, int code) {
        ArrayList<OpRecord> r0 = this.mOpsQueue;
        monitor-enter(r0);
        OpRecord r = new OpRecord(this, pkg, code);     // Catch: Throwable -> L7
        this.mOpsQueue.add(r);     // Catch: Throwable -> L7
        if (this.mOpsQueue.size() != 1) goto L9;
        schedulOpChangedLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void processNextOp() {
        ArrayList<OpRecord> r0 = this.mOpsQueue;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mOpsQueue.size() <= 0) goto L12;
        OpRecord r = this.mOpsQueue.remove(0);     // Catch: Throwable -> L9
        if (r == null) goto L12;
        updatePackageRuleLocked(r.mPackageName, r.mOpCode);     // Catch: Throwable -> L9
    L12:
        if (this.mOpsQueue.size() <= 0) goto L14;
        schedulOpChangedLocked();     // Catch: Throwable -> L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void schedulOpChangedLocked() {
        this.mHandler.post(new AnonymousClass3(this));
    }
}
