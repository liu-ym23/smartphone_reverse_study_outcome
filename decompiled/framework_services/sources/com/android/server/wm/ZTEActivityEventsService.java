package com.android.server.wm;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.server.LocalServices;
import com.zte.activityevent.IActivityEventsCallback;
import com.zte.activityevent.IActivityEventsInnerCallback;
import com.zte.activityevent.IActivityEventsServer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ZTEActivityEventsService extends IActivityEventsServer.Stub {
    private static final String TAG = "ZTEActivityEventsService";
    private final ArrayMap<String, ClientRecord> mCallbacks;
    private final Context mContext;
    private final Handler mHandler;
    private final ArrayMap<String, ClientRecord> mInnerCallbacks;
    private final Object mLock;
    private WindowManagerService mWmService;

    private class ClientRecord implements IBinder.DeathRecipient {
        final IBinder binder;
        final int eventType;
        final boolean isInner;
        final String name;
        final /* synthetic */ ZTEActivityEventsService this$0;

        ClientRecord(ZTEActivityEventsService r3, String name, IBinder binder, int eventType, boolean isInner) {
            this.this$0 = r3;
            this.name = name;
            this.binder = binder;
            this.eventType = eventType;
            this.isInner = isInner;
            this.binder.linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(ZTEActivityEventsService.TAG, "Failed to link to death for client: " + name, e);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            ZTEActivityEventsService.m10497$$Nest$mdelCallBack(this.this$0, this.name, this.isInner, "binderDied");
        }
    }

    public class LocalService extends ZTEActivityEventsInternal {
        final /* synthetic */ ZTEActivityEventsService this$0;

        public LocalService(ZTEActivityEventsService this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.wm.ZTEActivityEventsInternal
        public void notifyActivityEvent(int eventId, int displayId, int userId, ActivityRecord activityRecord, int rootTaskId) {
            if (displayId != 0) goto L4;
            int eventId2 = eventId;
        L11:
            if (activityRecord == null) goto L13;
            ZTEActivityEventsService.m10498$$Nest$mnotifyActivityEvent(this.this$0, eventId2, activityRecord.mActivityComponent.getPackageName(), activityRecord.mActivityComponent.getClassName(), String.valueOf(userId), activityRecord.getWindowingMode(), activityRecord.getActivityType(), rootTaskId);
            return;
        L13:
            ZTEActivityEventsService.m10498$$Nest$mnotifyActivityEvent(this.this$0, eventId2, null, null, String.valueOf(userId), -1, -1, rootTaskId);
            return;
        L4:
            if (eventId != 128) goto L7;
            eventId2 = 2097152;
            goto L11
        L7:
            if (eventId != 1) goto L9;
            eventId2 = 1048576;
            goto L11
        }
    }

    public static /* synthetic */ boolean $r8$lambda$eTuaocDRnpbU37lyeRA7v9Mndto(ZTEActivityEventsService r0, List r1, ActivityRecord r2) {
        return r0.lambda$getVisiblePackageDates$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$mWLGq7FsYJAbE2_NwBH60kWxhKs(ZTEActivityEventsService r0, int r1, String r2, String r3, String r4, int r5, int r6, int r7) {
        r0.lambda$notifyActivityEvent$1(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$mdelCallBack, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10497$$Nest$mdelCallBack(ZTEActivityEventsService r0, String r1, boolean r2, String r3) {
        return r0.delCallBack(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyActivityEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10498$$Nest$mnotifyActivityEvent(ZTEActivityEventsService r0, int r1, String r2, String r3, String r4, int r5, int r6, int r7) {
        r0.notifyActivityEvent(r1, r2, r3, r4, r5, r6, r7);
    }

    public ZTEActivityEventsService(Context context, WindowManagerService wms) {
        this.mInnerCallbacks = new ArrayMap();
        this.mCallbacks = new ArrayMap();
        this.mLock = new Object();
        this.mContext = context;
        this.mHandler = new Handler();
        this.mWmService = wms;
        LocalServices.addService(ZTEActivityEventsInternal.class, new LocalService(this));
    }

    public boolean addInnerCallBack(String name, IBinder callback, int eventType) {
        return addCallBack(name, callback, eventType, true, "from client");
    }

    public boolean addCallBack(String name, IBinder callback, int eventType) {
        return addCallBack(name, callback, eventType, false, "from client");
    }

    public boolean delCallBack(String name) {
        return delCallBack(name, false, "from client");
    }

    public boolean delInnerCallBack(String name) {
        return delCallBack(name, true, "from client");
    }

    public List<Bundle> getVisiblePackageDates() {
        final List<Bundle> result = new ArrayList(3);
        int i = 0;
    L3:
        if (i >= 3) goto L5;
        result.add(null);
        i = i + 1;
        goto L3
    L5:
        Object r1 = this.mWmService.getWindowManagerLock();
        monitor-enter(r1);
        this.mWmService.mRoot.getDefaultDisplay().forAllActivities(new ZTEActivityEventsService$$ExternalSyntheticLambda1(this, result), true);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        Slog.i(TAG, "getVisiblePackageDates called: " + result);
        return result;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ boolean lambda$getVisiblePackageDates$0(List result, ActivityRecord activity) {
        if (activity.getRootTask() == null) goto L8;
        if (activity.getRootTask().shouldBeVisible(null) == true) goto L8;
        return true;
    L8:
        if (activity.inMultiWindowMode() == true) goto L13;
        if (result.get(0) != null) goto L20;
        result.set(0, putInfoToBundle(activity));
    L20:
        return false;
    L13:
        if (activity.inFreeformWindowingMode() == false) goto L18;
        if (result.get(1) != null) goto L20;
        result.set(1, putInfoToBundle(activity));
        goto L20
    L18:
        if (result.get(2) != null) goto L20;
        result.set(2, putInfoToBundle(activity));
        goto L20
    }

    public void collectActivityEventDetail(int eventid, String pkgname, String activity, String reserved, int windowMode, int activityType, int RootTaskId, String windowTitle) {
        notifyActivityEvent(eventid, pkgname, activity, reserved, windowMode, activityType, RootTaskId);
    }

    private Bundle putInfoToBundle(ActivityRecord record) {
        Bundle bundle = new Bundle();
        if (record == null) goto L5;
        bundle.putString("packageName", record.mActivityComponent.getPackageName());
        bundle.putString("topActivity", record.mActivityComponent.getClassName());
        bundle.putString("reserved", String.valueOf(record.mUserId));
        bundle.putInt("windowMode", record.getWindowingMode());
        bundle.putInt("activityType", record.getActivityType());
        bundle.putInt("rootTaskId", record.getRootTaskId());
        bundle.putString("windowTitle", null);
    L5:
        return bundle;
    }

    private void notifyActivityEvent(final int eventId, final String pkgName, final String activity, final String reserved, final int windowMode, final int activityType, final int rootTaskId) {
        this.mHandler.post(new ZTEActivityEventsService$$ExternalSyntheticLambda0(this, eventId, pkgName, activity, reserved, windowMode, activityType, rootTaskId));
    }

    private /* synthetic */ void lambda$notifyActivityEvent$1(int eventId, String pkgName, String activity, String reserved, int windowMode, int activityType, int rootTaskId) {
        StringBuilder r1 = new StringBuilder();
        r1.append("notifyActivityEvent: eventId: ");
        r1.append(Integer.toHexString(eventId));
        r1.append(", pkgName: ");
        r1.append(pkgName);
        r1.append(", activity: ");
        r1.append(activity);
        r1.append(", reserved: ");
        r1.append(reserved);
        r1.append(", windowMode: ");
        int r5 = windowMode;
        r1.append(r5);
        r1.append(", activityType: ");
        int r6 = activityType;
        r1.append(r6);
        r1.append(", rootTaskId: ");
        int r7 = rootTaskId;
        r1.append(r7);
        Slog.d(TAG, r1.toString());
        Object r8 = this.mLock;
        monitor-enter(r8);
        Iterator<ClientRecord> r9 = this.mInnerCallbacks.values().iterator();     // Catch: Throwable -> L12
    L6:
        if (r9.hasNext() == false) goto L17;
        ClientRecord record = r9.next();     // Catch: Throwable -> L12
        if ((record.eventType & eventId) == 0) goto L16;
        IActivityEventsInnerCallback.Stub.asInterface(record.binder).onNotifyActivityEvent(eventId, pkgName, activity, reserved, r5, r6, r7);     // Catch: Throwable -> L12 RemoteException -> L14
    L14:
        e = move-exception;
        Slog.w(TAG, "Failed to notify inner callback: " + record.name, e);     // Catch: Throwable -> L12
    L16:
        r5 = windowMode;
        r6 = activityType;
        r7 = rootTaskId;
        goto L6
    L17:
        Iterator<ClientRecord> r10 = this.mCallbacks.values().iterator();     // Catch: Throwable -> L12
    L19:
        if (r10.hasNext() == false) goto L28;
        ClientRecord record2 = r10.next();     // Catch: Throwable -> L12
        if ((record2.eventType & eventId) == 0) goto L19;
        IActivityEventsCallback.Stub.asInterface(record2.binder).notifiyActivityEvent(eventId, pkgName, activity, reserved);     // Catch: Throwable -> L12 RemoteException -> L25
    L25:
        e = move-exception;
        Slog.w(TAG, "Failed to notify callback: " + record2.name, e);     // Catch: Throwable -> L12
        goto L19
    L28:
        monitor-exit(r8);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private boolean addCallBack(String name, IBinder callback, int eventType, boolean isInner, String reason) {
        if (callback != null) goto L54;
        Slog.e(TAG, "addCallBack failed: binder is null for client " + name);
        return false;
    L54:
        String descriptor = callback.getInterfaceDescriptor();     // Catch: RemoteException -> L44
        if (isInner == true) goto L10;
        if (IActivityEventsCallback.class.getName().equals(descriptor) == true) goto L19;
        Slog.e(TAG, "addCallBack failed: wrong interface descriptor " + descriptor + " for client " + name + ", expected " + IActivityEventsCallback.class.getName());     // Catch: RemoteException -> L13
        return false;
    L19:
        Object r3 = this.mLock;
        monitor-enter(r3);
        if (isInner == true) goto L51;
        ArrayMap<String, ClientRecord> callbackList = this.mCallbacks;     // Catch: Throwable -> L40
    L28:
        if (callbackList.containsKey(name) == false) goto L32;
        Slog.w(TAG, "Callback name already exists, cannot add: " + name);     // Catch: Throwable -> L24
        monitor-exit(r3);     // Catch: Throwable -> L24
        return false;
    L24:
        th = th;
    L42:
        monitor-exit(r3);     // Catch: Throwable -> L38
        throw th;
    L32:
        ClientRecord record = new ClientRecord(this, name, callback, eventType, isInner);     // Catch: Throwable -> L38
        callbackList.put(name, record);     // Catch: Throwable -> L38
        Slog.i(TAG, "addCallBack success: name=" + name + ", isInner=" + isInner + ", callerPid: " + Binder.getCallingPid() + ", descriptor: " + descriptor + ", eventType=" + Integer.toHexString(eventType) + ", reason=" + reason);     // Catch: Throwable -> L38
        monitor-exit(r3);     // Catch: Throwable -> L38
        return true;
    L40:
        th = th;
        goto L42
    L51:
        callbackList = this.mInnerCallbacks;     // Catch: Throwable -> L24
    L38:
        th = th;
        goto L42
    L10:
        if (IActivityEventsInnerCallback.class.getName().equals(descriptor) == true) goto L19;
        Slog.e(TAG, "addInnerCallBack failed: wrong interface descriptor " + descriptor + " for client " + name + ", expected " + IActivityEventsInnerCallback.class.getName());     // Catch: RemoteException -> L13
        return false;
    L13:
        e = e;
    L46:
        Slog.e(TAG, "addCallBack failed: could not get interface descriptor for client " + name, e);
        return false;
    L44:
        e = e;
        goto L46
    }

    private boolean delCallBack(String name, boolean isInner, String reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (isInner == false) goto L8;
        ArrayMap<String, ClientRecord> callbackList = this.mInnerCallbacks;     // Catch: Throwable -> L6
    L9:
        ClientRecord record = callbackList.remove(name);     // Catch: Throwable -> L6
        if (record == null) goto L15;
        record.binder.unlinkToDeath(record, 0);     // Catch: Throwable -> L6
        Slog.i(TAG, "delCallBack success: name=" + name + ", isInner=" + isInner + ", reason=" + reason);     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
        return true;
    L15:
        Slog.w(TAG, "delCallBack failed, name not found: " + name + ", isInner: " + isInner + ", reason: " + reason);     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
        return false;
    L8:
        callbackList = this.mCallbacks;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
