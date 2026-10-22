package com.android.server.incident;

import android.R;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IIncidentAuthListener;
import android.os.IIncidentCompanion;
import android.os.IIncidentManager;
import android.os.IncidentManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.util.Log;
import com.android.internal.util.DumpUtils;
import com.android.server.SystemService;
import com.android.server.am.ProcessList;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class IncidentCompanionService extends SystemService {
    private static final String[] DUMP_AND_USAGE_STATS_PERMISSIONS = null;
    private static String[] RESTRICTED_IMAGE_DUMP_ARGS = null;
    static final String TAG = "IncidentCompanionService";
    private PendingReports mPendingReports;

    private final class BinderService extends IIncidentCompanion.Stub {
        final /* synthetic */ IncidentCompanionService this$0;

        /* synthetic */ BinderService(IncidentCompanionService r1, IncidentCompanionServiceIA r2) {
            this(r1);
        }

        private BinderService(IncidentCompanionService r1) {
            this.this$0 = r1;
        }

        public void authorizeReport(int callingUid, String callingPackage, String receiverClass, String reportId, int flags, IIncidentAuthListener listener) {
            enforceRequestAuthorizationPermission();
            long ident = Binder.clearCallingIdentity();
            IncidentCompanionService.m4449$$Nest$fgetmPendingReports(this.this$0).authorizeReport(callingUid, callingPackage, receiverClass, reportId, flags, listener);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void cancelAuthorization(IIncidentAuthListener listener) {
            enforceRequestAuthorizationPermission();
            long ident = Binder.clearCallingIdentity();
            IncidentCompanionService.m4449$$Nest$fgetmPendingReports(this.this$0).cancelAuthorization(listener);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void sendReportReadyBroadcast(String pkg, String cls) {
            enforceRequestAuthorizationPermission();
            long ident = Binder.clearCallingIdentity();
            Context context = this.this$0.getContext();     // Catch: Throwable -> L11
            int currentAdminUser = IncidentCompanionService.getCurrentUserIfAdmin();     // Catch: Throwable -> L11
            if (currentAdminUser != (-10000)) goto L8;
            Binder.restoreCallingIdentity(ident);
            return;
        L8:
            Intent intent = new Intent("android.intent.action.INCIDENT_REPORT_READY");     // Catch: Throwable -> L11
            intent.setComponent(new ComponentName(pkg, cls));     // Catch: Throwable -> L11
            Log.d(IncidentCompanionService.TAG, "sendReportReadyBroadcast sending currentUser=" + currentAdminUser + " userHandle=" + UserHandle.of(currentAdminUser) + " intent=" + intent);     // Catch: Throwable -> L11
            context.sendBroadcastAsUserMultiplePermissions(intent, UserHandle.of(currentAdminUser), IncidentCompanionService.m4451$$Nest$sfgetDUMP_AND_USAGE_STATS_PERMISSIONS());     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(ident);
            return;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public List<String> getPendingReports() {
            enforceAuthorizePermission();
            return IncidentCompanionService.m4449$$Nest$fgetmPendingReports(this.this$0).getPendingReports();
        }

        public void approveReport(String uri) {
            enforceAuthorizePermission();
            long ident = Binder.clearCallingIdentity();
            IncidentCompanionService.m4449$$Nest$fgetmPendingReports(this.this$0).approveReport(uri);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void denyReport(String uri) {
            enforceAuthorizePermission();
            long ident = Binder.clearCallingIdentity();
            IncidentCompanionService.m4449$$Nest$fgetmPendingReports(this.this$0).denyReport(uri);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public List<String> getIncidentReportList(String pkg, String cls) throws RemoteException {
            enforceAccessReportsPermissions(null);
            long ident = Binder.clearCallingIdentity();
            List<String> r2 = IncidentCompanionService.m4450$$Nest$mgetIIncidentManager(this.this$0).getIncidentReportList(pkg, cls);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void deleteIncidentReports(String pkg, String cls, String id) throws RemoteException {
            if (pkg == null) goto L19;
            if (cls == null) goto L19;
            if (id == null) goto L19;
            if (pkg.length() == 0) goto L19;
            if (cls.length() == 0) goto L19;
            if (id.length() == 0) goto L19;
            enforceAccessReportsPermissions(pkg);
            long ident = Binder.clearCallingIdentity();
            IncidentCompanionService.m4450$$Nest$mgetIIncidentManager(this.this$0).deleteIncidentReports(pkg, cls, id);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(ident);
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L19:
            throw new RuntimeException("Invalid pkg, cls or id");
        }

        public void deleteAllIncidentReports(String pkg) throws RemoteException {
            if (pkg == null) goto L13;
            if (pkg.length() == 0) goto L13;
            enforceAccessReportsPermissions(pkg);
            long ident = Binder.clearCallingIdentity();
            IncidentCompanionService.m4450$$Nest$mgetIIncidentManager(this.this$0).deleteAllIncidentReports(pkg);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L13:
            throw new RuntimeException("Invalid pkg");
        }

        public IncidentManager.IncidentReport getIncidentReport(String pkg, String cls, String id) throws RemoteException {
            if (pkg == null) goto L19;
            if (cls == null) goto L19;
            if (id == null) goto L19;
            if (pkg.length() == 0) goto L19;
            if (cls.length() == 0) goto L19;
            if (id.length() == 0) goto L19;
            enforceAccessReportsPermissions(pkg);
            long ident = Binder.clearCallingIdentity();
            IncidentManager.IncidentReport r2 = IncidentCompanionService.m4450$$Nest$mgetIIncidentManager(this.this$0).getIncidentReport(pkg, cls, id);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(ident);
            return r2;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L19:
            throw new RuntimeException("Invalid pkg, cls or id");
        }

        protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), IncidentCompanionService.TAG, writer) == true) goto L6;
            return;
        L6:
            if (args.length == 1) goto L8;
        L10:
            IncidentCompanionService.m4449$$Nest$fgetmPendingReports(this.this$0).dump(fd, writer, args);
            return;
        L8:
            if ("--restricted_image".equals(args[0]) == false) goto L10;
            dumpRestrictedImages(fd);
        }

        private void dumpRestrictedImages(FileDescriptor fd) {
            if (Build.IS_ENG == false) goto L5;
        L7:
            Resources res = this.this$0.getContext().getResources();
            String[] services = res.getStringArray(R.array.config_sfps_sensor_props);
            int servicesCount = services.length;
            int i = 0;
        L8:
            if (i >= servicesCount) goto L18;
            String name = services[i];
            Log.d(IncidentCompanionService.TAG, "Looking up service " + name);
            IBinder service = ServiceManager.getService(name);
            if (service == null) goto L16;
            Log.d(IncidentCompanionService.TAG, "Calling dump on service: " + name);
            service.dump(fd, IncidentCompanionService.m4452$$Nest$sfgetRESTRICTED_IMAGE_DUMP_ARGS());     // Catch: RemoteException -> L14
        L14:
            ex = move-exception;
            Log.w(IncidentCompanionService.TAG, "dump --restricted_image of " + name + " threw", ex);
        L16:
            i = i + 1;
            goto L8
        L18:
            return;
        L5:
            if (Build.IS_USERDEBUG == true) goto L7;
        }

        private void enforceRequestAuthorizationPermission() {
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.REQUEST_INCIDENT_REPORT_APPROVAL", null);
        }

        private void enforceAuthorizePermission() {
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.APPROVE_INCIDENT_REPORTS", null);
        }

        private void enforceAccessReportsPermissions(String pkg) {
            if (this.this$0.getContext().checkCallingPermission("android.permission.APPROVE_INCIDENT_REPORTS") == 0) goto L8;
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.DUMP", null);
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.PACKAGE_USAGE_STATS", null);
            if (pkg == null) goto L9;
            enforceCallerIsSameApp(pkg);
            return;
        L9:
            return;
        }

        private void enforceCallerIsSameApp(String pkg) throws SecurityException {
            int uid = Binder.getCallingUid();     // Catch: PackageManager.NameNotFoundException -> L10
            int userId = UserHandle.getCallingUserId();     // Catch: PackageManager.NameNotFoundException -> L10
            ApplicationInfo ai = this.this$0.getContext().getPackageManager().getApplicationInfoAsUser(pkg, 0, userId);     // Catch: PackageManager.NameNotFoundException -> L10
            if (ai == null) goto L13;
            if (UserHandle.isSameApp(ai.uid, uid) == false) goto L9;
            return;
        L9:
            throw new SecurityException("Calling uid " + uid + " gave package " + pkg + " which is owned by uid " + ai.uid);     // Catch: PackageManager.NameNotFoundException -> L10
        L13:
            throw new SecurityException("Unknown package " + pkg);     // Catch: PackageManager.NameNotFoundException -> L10
        L10:
            re = move-exception;
            throw new SecurityException("Unknown package " + pkg + "\n" + re);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingReports, reason: not valid java name */
    static /* bridge */ /* synthetic */ PendingReports m4449$$Nest$fgetmPendingReports(IncidentCompanionService r0) {
        return r0.mPendingReports;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetIIncidentManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ IIncidentManager m4450$$Nest$mgetIIncidentManager(IncidentCompanionService r0) {
        return r0.getIIncidentManager();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDUMP_AND_USAGE_STATS_PERMISSIONS, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m4451$$Nest$sfgetDUMP_AND_USAGE_STATS_PERMISSIONS() {
        return DUMP_AND_USAGE_STATS_PERMISSIONS;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetRESTRICTED_IMAGE_DUMP_ARGS, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m4452$$Nest$sfgetRESTRICTED_IMAGE_DUMP_ARGS() {
        return RESTRICTED_IMAGE_DUMP_ARGS;
    }

    static {
        RESTRICTED_IMAGE_DUMP_ARGS = new String[]{"--hal", "--restricted_image"};
        DUMP_AND_USAGE_STATS_PERMISSIONS = new String[]{"android.permission.DUMP", "android.permission.PACKAGE_USAGE_STATS"};
    }

    public IncidentCompanionService(Context context) {
        super(context);
        this.mPendingReports = new PendingReports(context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("incidentcompanion", new BinderService(this, null));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        super.onBootPhase(phase);
        switch(phase) {
            case 1000: goto L5;
            default: goto L7;
        };
    L5:
        this.mPendingReports.onBootCompleted();
        return;
    }

    private IIncidentManager getIIncidentManager() throws RemoteException {
        return IIncidentManager.Stub.asInterface(ServiceManager.getService("incident"));
    }

    public static int getCurrentUserIfAdmin() {
        UserInfo currentUser = ActivityManager.getService().getCurrentUser();     // Catch: RemoteException -> L13
        if (currentUser != null) goto L8;
        Log.w(TAG, "No current user.  Nobody to approve the report. The report will be denied.");
        return ProcessList.INVALID_ADJ;
    L8:
        if (currentUser.isAdmin() == true) goto L12;
        Log.w(TAG, "Only an admin user running in foreground can approve bugreports, but the current foreground user is not an admin user. The report will be denied.");
        return ProcessList.INVALID_ADJ;
    L12:
        return currentUser.id;
    L13:
        ex = move-exception;
        throw new RuntimeException(ex);
    }
}
