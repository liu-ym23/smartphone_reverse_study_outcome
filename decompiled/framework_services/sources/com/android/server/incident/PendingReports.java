package com.android.server.incident;

import android.app.AppOpsManager;
import android.app.BroadcastOptions;
import android.content.AttributionSource;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IIncidentAuthListener;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.permission.PermissionManager;
import android.util.Log;
import com.android.server.scene.SceneUtils;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.ActivityTaskManagerService;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class PendingReports {
    static final String TAG = "IncidentCompanionService";
    private final AppOpsManager mAppOpsManager;
    private final Context mContext;
    private final Handler mHandler;
    private final Object mLock;
    private int mNextPendingId;
    private final PackageManager mPackageManager;
    private final ArrayList<PendingReportRec> mPending;
    private final PermissionManager mPermissionManager;
    private final RequestQueue mRequestQueue;

    private final class PendingReportRec {
        public long addedRealtime;
        public long addedWalltime;
        public String callingPackage;
        public int flags;
        public int id;
        public IIncidentAuthListener listener;
        public String receiverClass;
        public String reportId;

        PendingReportRec(PendingReports r3, String callingPackage, String receiverClass, String reportId, int flags, IIncidentAuthListener listener) {
            int r0 = PendingReports.m4453$$Nest$fgetmNextPendingId(r3);
            PendingReports.m4454$$Nest$fputmNextPendingId(r3, r0 + 1);
            this.id = r0;
            this.callingPackage = callingPackage;
            this.flags = flags;
            this.listener = listener;
            this.addedRealtime = SystemClock.elapsedRealtime();
            this.addedWalltime = System.currentTimeMillis();
            this.receiverClass = receiverClass;
            this.reportId = reportId;
        }

        Uri getUri() {
            Uri.Builder builder = new Uri.Builder().scheme(ActivityTaskManagerInternal.ASSIST_KEY_CONTENT).authority("android.os.IncidentManager").path("/pending").appendQueryParameter("id", Integer.toString(this.id)).appendQueryParameter(SceneUtils.KEY_PKG, this.callingPackage).appendQueryParameter("flags", Integer.toString(this.flags)).appendQueryParameter("t", Long.toString(this.addedWalltime));
            if (this.receiverClass == null) goto L8;
            if (this.receiverClass.length() <= 0) goto L8;
            builder.appendQueryParameter("receiver", this.receiverClass);
        L8:
            if (this.reportId == null) goto L13;
            if (this.reportId.length() <= 0) goto L13;
            builder.appendQueryParameter(ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD, this.reportId);
        L13:
            return builder.build();
        }
    }

    public static /* synthetic */ void $r8$lambda$2qOJaLU0RhoIlEf4xr_R8_8v88U(PendingReports r0, IIncidentAuthListener r1, ComponentName r2, int r3) {
        r0.lambda$authorizeReportImpl$2(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$FYLkJXVTORodH1jCsMtHCfs8WUs(PendingReports r0, int r1, String r2, String r3, String r4, int r5, IIncidentAuthListener r6) {
        r0.lambda$authorizeReport$0(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$W9Z0BeX72HV5Knu0K4b83ChSE74(PendingReports r0, IIncidentAuthListener r1) {
        r0.lambda$cancelAuthorization$1(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNextPendingId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4453$$Nest$fgetmNextPendingId(PendingReports r0) {
        return r0.mNextPendingId;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNextPendingId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4454$$Nest$fputmNextPendingId(PendingReports r0, int r1) {
        r0.mNextPendingId = r1;
    }

    PendingReports(Context context) {
        this.mHandler = new Handler();
        this.mRequestQueue = new RequestQueue(this.mHandler);
        this.mLock = new Object();
        this.mPending = new ArrayList();
        this.mNextPendingId = 1;
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
        this.mAppOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        this.mPermissionManager = (PermissionManager) context.getSystemService(PermissionManager.class);
    }

    public void authorizeReport(final int callingUid, final String callingPackage, final String receiverClass, final String reportId, final int flags, final IIncidentAuthListener listener) {
        this.mRequestQueue.enqueue(listener.asBinder(), true, new PendingReports$$ExternalSyntheticLambda0(this, callingUid, callingPackage, receiverClass, reportId, flags, listener));
    }

    private /* synthetic */ void lambda$authorizeReport$0(int callingUid, String callingPackage, String receiverClass, String reportId, int flags, IIncidentAuthListener listener) {
        authorizeReportImpl(callingUid, callingPackage, receiverClass, reportId, flags, listener);
    }

    public void cancelAuthorization(final IIncidentAuthListener listener) {
        this.mRequestQueue.enqueue(listener.asBinder(), false, new PendingReports$$ExternalSyntheticLambda1(this, listener));
    }

    private /* synthetic */ void lambda$cancelAuthorization$1(IIncidentAuthListener listener) {
        cancelReportImpl(listener);
    }

    public List<String> getPendingReports() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int size = this.mPending.size();     // Catch: Throwable -> L7
        ArrayList<String> result = new ArrayList(size);     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= size) goto L10;
        result.add(this.mPending.get(i).getUri().toString());     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return result;
    L7:
        th = move-exception;
        throw th;
    }

    public void approveReport(String uri) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PendingReportRec rec = findAndRemovePendingReportRecLocked(uri);     // Catch: Throwable -> L9
        if (rec != null) goto L11;
        Log.e(TAG, "confirmApproved: Couldn't find record for uri: " + uri);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        sendBroadcast();
        Log.i(TAG, "Approved report: " + uri);
        rec.listener.onReportApproved();     // Catch: RemoteException -> L15
        return;
    L15:
        ex = move-exception;
        Log.w(TAG, "Failed calling back for approval for: " + uri, ex);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void denyReport(String uri) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PendingReportRec rec = findAndRemovePendingReportRecLocked(uri);     // Catch: Throwable -> L9
        if (rec != null) goto L11;
        Log.e(TAG, "confirmDenied: Couldn't find record for uri: " + uri);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        sendBroadcast();
        Log.i(TAG, "Denied report: " + uri);
        rec.listener.onReportDenied();     // Catch: RemoteException -> L15
        return;
    L15:
        ex = move-exception;
        Log.w(TAG, "Failed calling back for denial for: " + uri, ex);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        if (args.length != 0) goto L16;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Object r1 = this.mLock;
        monitor-enter(r1);
        int size = this.mPending.size();     // Catch: Throwable -> L9
        writer.println("mPending: (" + size + ")");     // Catch: Throwable -> L9
        int i = 0;
    L7:
        if (i >= size) goto L12;
        PendingReportRec entry = this.mPending.get(i);     // Catch: Throwable -> L9
        writer.println(String.format("  %11d %s: %s", new Object[]{Long.valueOf(entry.addedRealtime), df.format(new Date(entry.addedWalltime)), entry.getUri().toString()}));     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L7
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void onBootCompleted() {
        this.mRequestQueue.start();
    }

    private void authorizeReportImpl(int callingUid, String callingPackage, String receiverClass, String reportId, int flags, final IIncidentAuthListener listener) {
        if (callingUid != 0) goto L5;
    L8:
        final int currentAdminUser = getCurrentUserIfAdmin();
        int callingUser = UserHandle.getUserId(callingUid);
        if (currentAdminUser != (-10000)) goto L11;
    L64:
        Log.w(TAG, "Calling user " + callingUser + " doesn't belong to the same profile group of the current admin user " + currentAdminUser);
        denyReportBeforeAddingRec(listener, callingPackage);
        return;
    L11:
        if (isSameProfileGroupUser(callingUser, currentAdminUser) == false) goto L64;
        final ComponentName receiver = getApproverComponent(currentAdminUser);
        if (receiver != null) goto L17;
        denyReportBeforeAddingRec(listener, callingPackage);
        return;
    L17:
        AttributionSource attributionSource = new AttributionSource.Builder(callingUid).setPackageName(callingPackage).build();
        boolean r4 = true;
        if (Build.IS_USERDEBUG == true) goto L22;
        if (Build.IS_ENG == true) goto L22;
    L28:
        boolean captureConsentlessBugreportOnUserdebugBuildGranted = false;
    L30:
        if (this.mPermissionManager.checkPermissionForDataDelivery("android.permission.CAPTURE_CONSENTLESS_BUGREPORT_DELEGATED_CONSENT", attributionSource, null) == 0) goto L33;
        r4 = false;
    L33:
        boolean captureConsentlessBugreportDelegatedConsentGranted = r4;
        if (captureConsentlessBugreportOnUserdebugBuildGranted == true) goto L69;
        if (captureConsentlessBugreportDelegatedConsentGranted == true) goto L69;
    L46:
        Object r2 = this.mLock;
        monitor-enter(r2);
        PendingReportRec rec = new PendingReportRec(this, callingPackage, receiverClass, reportId, flags, listener);     // Catch: Throwable -> L58
        this.mPending.add(rec);     // Catch: Throwable -> L58
        monitor-exit(r2);     // Catch: Throwable -> L58
        listener.asBinder().linkToDeath(new PendingReports$$ExternalSyntheticLambda2(this, listener, receiver, currentAdminUser), 0);     // Catch: RemoteException -> L54
    L56:
        sendBroadcast(receiver, currentAdminUser);
        return;
    L55:
        Log.e(TAG, "Remote died while trying to register death listener: " + rec.getUri());
        cancelReportImpl(listener, receiver, currentAdminUser);
    L58:
        th = th;
    L62:
        monitor-exit(r2);     // Catch: Throwable -> L58
        throw th;
    L60:
        th = th;
    L69:
        PendingReportRec rec2 = new PendingReportRec(this, callingPackage, receiverClass, reportId, flags, listener);     // Catch: RemoteException -> L39
        if (captureConsentlessBugreportOnUserdebugBuildGranted == false) goto L41;
        Log.d(TAG, "approving consentless report: " + rec2.getUri());     // Catch: RemoteException -> L39
    L41:
        if (captureConsentlessBugreportDelegatedConsentGranted == false) goto L43;
        Log.d(TAG, "delegating consent for report: " + rec2.getUri());     // Catch: RemoteException -> L39
    L43:
        listener.onReportApproved();     // Catch: RemoteException -> L39
        return;
    L39:
        e = move-exception;
        Log.e(TAG, "authorizeReportImpl listener.onReportApproved RemoteException: ", e);
    L22:
        if ((flags & 2) == 0) goto L28;
        if (this.mPermissionManager.checkPermissionForDataDelivery("android.permission.CAPTURE_CONSENTLESS_BUGREPORT_ON_USERDEBUG_BUILD", attributionSource, null) != 0) goto L26;
        boolean r3 = true;
    L27:
        boolean captureConsentlessBugreportOnUserdebugBuildGranted2 = r3;
        captureConsentlessBugreportOnUserdebugBuildGranted = captureConsentlessBugreportOnUserdebugBuildGranted2;
        goto L30
    L26:
        r3 = false;
        goto L27
    L5:
        if (isPackageInUid(callingUid, callingPackage) == true) goto L8;
        Log.w(TAG, "Calling uid " + callingUid + " doesn't match package " + callingPackage);
        denyReportBeforeAddingRec(listener, callingPackage);
    }

    private /* synthetic */ void lambda$authorizeReportImpl$2(IIncidentAuthListener listener, ComponentName receiver, int currentAdminUser) {
        Log.i(TAG, "Got death notification listener=" + listener);
        cancelReportImpl(listener, receiver, currentAdminUser);
    }

    private void cancelReportImpl(IIncidentAuthListener listener) {
        int currentAdminUser = getCurrentUserIfAdmin();
        ComponentName receiver = getApproverComponent(currentAdminUser);
        if (currentAdminUser == (-10000)) goto L7;
        if (receiver == null) goto L8;
        cancelReportImpl(listener, receiver, currentAdminUser);
        return;
    L8:
        return;
    }

    private void cancelReportImpl(IIncidentAuthListener listener, ComponentName receiver, int user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removePendingReportRecLocked(listener);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        sendBroadcast(receiver, user);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void sendBroadcast() {
        int currentAdminUser = getCurrentUserIfAdmin();
        if (currentAdminUser != (-10000)) goto L5;
        return;
    L5:
        ComponentName receiver = getApproverComponent(currentAdminUser);
        if (receiver != null) goto L8;
        return;
    L8:
        sendBroadcast(receiver, currentAdminUser);
    }

    private void sendBroadcast(ComponentName receiver, int currentUser) {
        Intent intent = new Intent("android.intent.action.PENDING_INCIDENT_REPORTS_CHANGED");
        intent.setComponent(receiver);
        intent.addFlags(268435456);
        intent.addFlags(16777216);
        BroadcastOptions options = BroadcastOptions.makeBasic();
        options.setBackgroundActivityStartsAllowed(true);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.of(currentUser), "android.permission.APPROVE_INCIDENT_REPORTS", options.toBundle());
    }

    private PendingReportRec findAndRemovePendingReportRecLocked(String uriString) {
        Uri uri = Uri.parse(uriString);
        String idStr = uri.getQueryParameter("id");     // Catch: NumberFormatException -> L14
        int id = Integer.parseInt(idStr);     // Catch: NumberFormatException -> L14
        Iterator<PendingReportRec> i = this.mPending.iterator();
    L6:
        if (i.hasNext() == false) goto L13;
        PendingReportRec rec = i.next();
        if (rec.id != id) goto L6;
        i.remove();
        return rec;
    L13:
        return null;
    L15:
        Log.w(TAG, "Can't parse id from: " + uriString);
        return null;
    }

    private void removePendingReportRecLocked(IIncidentAuthListener listener) {
        Iterator<PendingReportRec> i = this.mPending.iterator();
    L4:
        if (i.hasNext() == false) goto L10;
        PendingReportRec rec = i.next();
        if (rec.listener.asBinder() != listener.asBinder()) goto L4;
        Log.i(TAG, "  ...Removed PendingReportRec index=" + i + ": " + rec.getUri());
        i.remove();
        goto L4
    }

    private void denyReportBeforeAddingRec(IIncidentAuthListener listener, String pkg) {
        listener.onReportDenied();     // Catch: RemoteException -> L4
        return;
    L4:
        ex = move-exception;
        Log.w(TAG, "Failed calling back for denial for " + pkg, ex);
    }

    private int getCurrentUserIfAdmin() {
        return IncidentCompanionService.getCurrentUserIfAdmin();
    }

    private ComponentName getApproverComponent(int userId) {
        Intent intent = new Intent("android.intent.action.PENDING_INCIDENT_REPORTS_CHANGED");
        List<ResolveInfo> matches = this.mPackageManager.queryBroadcastReceiversAsUser(intent, 1835008, userId);
        if (matches.size() == 1) goto L5;
        Log.w(TAG, "Didn't find exactly one BroadcastReceiver to handle android.intent.action.PENDING_INCIDENT_REPORTS_CHANGED. The report will be denied. size=" + matches.size() + ": matches=" + matches);
        return null;
    L5:
        return matches.get(0).getComponentInfo().getComponentName();
    }

    private boolean isPackageInUid(int uid, String packageName) {
        this.mAppOpsManager.checkPackage(uid, packageName);     // Catch: SecurityException -> L5
        return true;
    L6:
        return false;
    }

    private boolean isSameProfileGroupUser(int currentAdminUser, int callingUser) {
        return UserManager.get(this.mContext).isSameProfileGroup(currentAdminUser, callingUser);
    }
}
