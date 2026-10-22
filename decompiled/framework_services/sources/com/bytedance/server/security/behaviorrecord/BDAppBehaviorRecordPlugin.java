package com.bytedance.server.security.behaviorrecord;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.bytedance.security.behaviorrecord.IAppBehaviorRecordService;
import com.bytedance.server.security.IBDSecurityPlugin;
import com.bytedance.server.security.behaviorrecord.record.BDAppBehaviorManager;
import com.bytedance.server.security.utils.Utils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class BDAppBehaviorRecordPlugin implements IBDSecurityPlugin {
    public static final IBDSecurityPlugin.Creator CREATOR = null;
    private static final String TAG = "BDAppBehaviorRecordPlug";
    private BDAppBehaviorManager mBehaviorRecord;
    private final Context mContext;
    private Set<Integer> mValidUid;

    private class BDAppBehaviorRecordService extends IAppBehaviorRecordService.Stub {
        private static final Object mLock = null;
        final /* synthetic */ BDAppBehaviorRecordPlugin this$0;

        /* synthetic */ BDAppBehaviorRecordService(BDAppBehaviorRecordPlugin r1, BDAppBehaviorRecordPluginIA r2) {
            this(r1);
        }

        private BDAppBehaviorRecordService(BDAppBehaviorRecordPlugin r1) {
            this.this$0 = r1;
        }

        static {
            mLock = new Object();
        }

        public void recordBehavior(long startTime, int opId, String packageName, int uid, int uidState, int operation) {
            Object r1 = mLock;
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (BDAppBehaviorRecordPlugin.m10549$$Nest$mcheckAccessPermission(this.this$0) == true) goto L11;
            Log.e(BDAppBehaviorRecordPlugin.TAG, "Forbidden access.");     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L11:
            BDAppBehaviorRecordPlugin.m10548$$Nest$fgetmBehaviorRecord(this.this$0).recordBehaviorLocked(startTime, opId, packageName, uid, uidState, operation);     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
        }

        public List<String> getLatestRecord() {
            Object r0 = mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (BDAppBehaviorRecordPlugin.m10549$$Nest$mcheckAccessPermission(this.this$0) == true) goto L12;
            Log.e(BDAppBehaviorRecordPlugin.TAG, "Forbidden access.");     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return null;
        L12:
            List<String> r1 = BDAppBehaviorRecordPlugin.m10548$$Nest$fgetmBehaviorRecord(this.this$0).getLatestRecord();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        }

        public void stopAppRecord(boolean isStop) {
            Object r0 = mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (BDAppBehaviorRecordPlugin.m10549$$Nest$mcheckAccessPermission(this.this$0) == true) goto L11;
            Log.e(BDAppBehaviorRecordPlugin.TAG, "Forbidden access.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            BDAppBehaviorRecordPlugin.m10548$$Nest$fgetmBehaviorRecord(this.this$0).stopAppRecord(isStop);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        public boolean isAppRecordEnable() {
            Object r0 = mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (BDAppBehaviorRecordPlugin.m10549$$Nest$mcheckAccessPermission(this.this$0) == true) goto L12;
            Log.e(BDAppBehaviorRecordPlugin.TAG, "Forbidden access.");     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return false;
        L12:
            boolean r1 = BDAppBehaviorRecordPlugin.m10548$$Nest$fgetmBehaviorRecord(this.this$0).isAppRecordEnable();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBehaviorRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ BDAppBehaviorManager m10548$$Nest$fgetmBehaviorRecord(BDAppBehaviorRecordPlugin r0) {
        return r0.mBehaviorRecord;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckAccessPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10549$$Nest$mcheckAccessPermission(BDAppBehaviorRecordPlugin r0) {
        return r0.checkAccessPermission();
    }

    /* synthetic */ BDAppBehaviorRecordPlugin(Context r1, BDAppBehaviorRecordPluginIA r2) {
        this(r1);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // com.bytedance.server.security.IBDSecurityPlugin
    public IBinder asBinder() {
        return new BDAppBehaviorRecordService(this, null);
    }

    @Override // com.bytedance.server.security.IBDSecurityPlugin
    public void onStart() {
        this.mBehaviorRecord = BDAppBehaviorManager.getInstance();
        this.mBehaviorRecord.init(this.mContext);
        this.mBehaviorRecord.registerBroadcast();
    }

    @Override // com.bytedance.server.security.IBDSecurityPlugin
    public void onStop() {
    }

    private boolean checkAccessPermission() {
        if (Binder.getCallingUid() != 1000) goto L5;
        return true;
    L5:
        if (Binder.getCallingUid() != 0) goto L8;
        return true;
    L8:
        if (this.mValidUid.isEmpty() == false) goto L14;
        Iterator<String> r0 = AppBehaviorConst.VALID_ACCESS_APPS.iterator();
    L11:
        if (r0.hasNext() == false) goto L14;
        String pkg = r0.next();
        this.mValidUid.add(Integer.valueOf(Utils.getUidByPackageName(this.mContext, pkg)));
    L14:
        return this.mValidUid.contains(Integer.valueOf(Binder.getCallingUid()));
    }

    private BDAppBehaviorRecordPlugin(Context context) {
        this.mValidUid = new HashSet();
        this.mContext = context;
    }
}
