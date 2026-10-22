package com.android.server.print;

import android.app.ActivityManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.database.ContentObserver;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.os.UserManager;
import android.print.IPrintDocumentAdapter;
import android.print.IPrintJobStateChangeListener;
import android.print.IPrintManager;
import android.print.IPrintServicesChangeListener;
import android.print.IPrinterDiscoveryObserver;
import android.print.PrintAttributes;
import android.print.PrintJobId;
import android.print.PrintJobInfo;
import android.print.PrinterId;
import android.printservice.PrintServiceInfo;
import android.printservice.recommendation.IRecommendationsChangeListener;
import android.printservice.recommendation.RecommendationInfo;
import android.provider.Settings;
import android.util.Log;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import android.widget.Toast;
import com.android.internal.content.PackageMonitor;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PrintManagerService extends SystemService {
    private static final String LOG_TAG = "PrintManagerService";
    private final PrintManagerImpl mPrintManagerImpl;

    class PrintManagerImpl extends IPrintManager.Stub {
        private static final int BACKGROUND_USER_ID = -10;
        private final Context mContext;
        private final Object mLock;
        private final UserManager mUserManager;
        private final SparseArray<UserState> mUserStates;

        /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
        static /* bridge */ /* synthetic */ Context m7889$$Nest$fgetmContext(PrintManagerImpl r0) {
            return r0.mContext;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
        static /* bridge */ /* synthetic */ Object m7890$$Nest$fgetmLock(PrintManagerImpl r0) {
            return r0.mLock;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUserManager, reason: not valid java name */
        static /* bridge */ /* synthetic */ UserManager m7891$$Nest$fgetmUserManager(PrintManagerImpl r0) {
            return r0.mUserManager;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUserStates, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseArray m7892$$Nest$fgetmUserStates(PrintManagerImpl r0) {
            return r0.mUserStates;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetOrCreateUserStateLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ UserState m7893$$Nest$mgetOrCreateUserStateLocked(PrintManagerImpl r0, int r1, boolean r2, boolean r3) {
            return r0.getOrCreateUserStateLocked(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetOrCreateUserStateLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ UserState m7894$$Nest$mgetOrCreateUserStateLocked(PrintManagerImpl r0, int r1, boolean r2, boolean r3, boolean r4) {
            return r0.getOrCreateUserStateLocked(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mhandleUserStopped, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7895$$Nest$mhandleUserStopped(PrintManagerImpl r0, int r1) {
            r0.handleUserStopped(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mhandleUserUnlocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7896$$Nest$mhandleUserUnlocked(PrintManagerImpl r0, int r1) {
            r0.handleUserUnlocked(r1);
        }

        PrintManagerImpl(PrintManagerService this$0, Context context) {
            this.mLock = new Object();
            this.mUserStates = new SparseArray();
            this.mContext = context;
            this.mUserManager = (UserManager) context.getSystemService("user");
            registerContentObservers();
            registerBroadcastReceivers();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new PrintShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
        }

        public Bundle print(String printJobName, IPrintDocumentAdapter adapter, PrintAttributes attributes, String packageName, int appId, int userId) {
            adapter.getClass();
            if (isPrintingEnabled() == true) goto L23;
            DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
            int callingUserId = UserHandle.getCallingUserId();
            long identity = Binder.clearCallingIdentity();
            CharSequence disabledMessage = dpmi.getPrintingDisabledReasonForUser(callingUserId);     // Catch: Throwable -> L9
            if (disabledMessage == null) goto L11;
            Toast.makeText(this.mContext, Looper.getMainLooper(), disabledMessage, 1).show();     // Catch: Throwable -> L9
        L11:
            Binder.restoreCallingIdentity(identity);
            adapter.start();     // Catch: RemoteException -> L14
        L50:
            adapter.finish();     // Catch: RemoteException -> L18
        L20:
            return null;
        L19:
            Log.e(PrintManagerService.LOG_TAG, "Error calling IPrintDocumentAdapter.finish()");
        L15:
            Log.e(PrintManagerService.LOG_TAG, "Error calling IPrintDocumentAdapter.start()");
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L23:
            String printJobName2 = (String) Preconditions.checkStringNotEmpty(printJobName);
            String packageName2 = (String) Preconditions.checkStringNotEmpty(packageName);
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r2 = this.mLock;
            monitor-enter(r2);
        L41:
            th = th;
        L42:
            monitor-exit(r2);     // Catch: Throwable -> L41
            throw th;
        L29:
            th = th;
            goto L42
        L26:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L32;
            monitor-exit(r2);     // Catch: Throwable -> L29
            return null;
        L32:
            int resolvedAppId = resolveCallingAppEnforcingPermissions(appId);     // Catch: Throwable -> L41
            String resolvedPackageName = resolveCallingPackageNameEnforcingSecurity(packageName2);     // Catch: Throwable -> L41
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L41
            monitor-exit(r2);     // Catch: Throwable -> L41
            long identity2 = Binder.clearCallingIdentity();
            Bundle r0 = userState.print(printJobName2, adapter, attributes, resolvedPackageName, resolvedAppId);     // Catch: Throwable -> L38
            Binder.restoreCallingIdentity(identity2);
            return r0;
        L38:
            th = move-exception;
            Binder.restoreCallingIdentity(identity2);
            throw th;
        }

        public List<PrintJobInfo> getPrintJobInfos(int appId, int userId) {
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L11;
            monitor-exit(r1);     // Catch: Throwable -> L9
            return null;
        L11:
            int resolvedAppId = resolveCallingAppEnforcingPermissions(appId);     // Catch: Throwable -> L9
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            long identity = Binder.clearCallingIdentity();
            List<PrintJobInfo> r2 = userState.getPrintJobInfos(resolvedAppId);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(identity);
            return r2;
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public PrintJobInfo getPrintJobInfo(PrintJobId printJobId, int appId, int userId) {
            if (printJobId != null) goto L5;
            return null;
        L5:
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r2 = this.mLock;
            monitor-enter(r2);
        L11:
            th = move-exception;
            throw th;
        L8:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L13;
            monitor-exit(r2);     // Catch: Throwable -> L11
            return null;
        L13:
            int resolvedAppId = resolveCallingAppEnforcingPermissions(appId);     // Catch: Throwable -> L11
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            long identity = Binder.clearCallingIdentity();
            PrintJobInfo r3 = userState.getPrintJobInfo(printJobId, resolvedAppId);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(identity);
            return r3;
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public Icon getCustomPrinterIcon(PrinterId printerId, int userId) {
            printerId.getClass();
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L11;
            monitor-exit(r1);     // Catch: Throwable -> L9
            return null;
        L11:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            long identity = Binder.clearCallingIdentity();
            Icon icon = userState.getCustomPrinterIcon(printerId);     // Catch: Throwable -> L17
            Icon r5 = validateIconUserBoundary(icon, resolvedUserId);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(identity);
            return r5;
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private Icon validateIconUserBoundary(Icon icon, int resolvedCallingId) {
            if (icon != null) goto L4;
        L21:
            return icon;
        L4:
            if (icon.getType() != 4) goto L6;
        L8:
            int iconUserId = ContentProvider.getUserIdFromAuthority(icon.getUri().getAuthority(), resolvedCallingId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L15:
            th = move-exception;
            throw th;
        L11:
            if (resolveCallingProfileParentLocked(iconUserId) == getCurrentUserId()) goto L17;
            monitor-exit(r1);     // Catch: Throwable -> L15
            return null;
        L17:
            monitor-exit(r1);     // Catch: Throwable -> L15
            goto L21
        L6:
            if (icon.getType() != 6) goto L21;
            goto L8
        }

        public void cancelPrintJob(PrintJobId printJobId, int appId, int userId) {
            if (printJobId != null) goto L4;
            return;
        L4:
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L10:
            th = move-exception;
            throw th;
        L7:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L12;
            monitor-exit(r1);     // Catch: Throwable -> L10
            return;
        L12:
            int resolvedAppId = resolveCallingAppEnforcingPermissions(appId);     // Catch: Throwable -> L10
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            long identity = Binder.clearCallingIdentity();
            userState.cancelPrintJob(printJobId, resolvedAppId);     // Catch: Throwable -> L18
            Binder.restoreCallingIdentity(identity);
            return;
        L18:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void restartPrintJob(PrintJobId printJobId, int appId, int userId) {
            if (printJobId != null) goto L4;
            return;
        L4:
            if (isPrintingEnabled() == false) goto L29;
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L9:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L14;
            monitor-exit(r1);     // Catch: Throwable -> L12
            return;
        L14:
            int resolvedAppId = resolveCallingAppEnforcingPermissions(appId);     // Catch: Throwable -> L12
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            long identity = Binder.clearCallingIdentity();
            userState.restartPrintJob(printJobId, resolvedAppId);     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(identity);
            return;
        L20:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public List<PrintServiceInfo> getPrintServices(int selectionFlags, int userId) {
            Preconditions.checkFlagsArgument(selectionFlags, 3);
            this.mContext.enforceCallingOrSelfPermission("android.permission.READ_PRINT_SERVICES", null);
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return null;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            List<PrintServiceInfo> r2 = userState.getPrintServices(selectionFlags);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return r2;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setPrintServiceEnabled(ComponentName service, boolean isEnabled, int userId) {
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            int appId = UserHandle.getAppId(Binder.getCallingUid());
            if (appId == 1000) goto L12;
        L9:
            e = move-exception;
            Log.e(PrintManagerService.LOG_TAG, "Could not verify caller", e);
            return;
        L5:
            if (appId == UserHandle.getAppId(this.mContext.getPackageManager().getPackageUidAsUser("com.android.printspooler", resolvedUserId))) goto L12;
            throw new SecurityException("Only system and print spooler can call this");     // Catch: PackageManager.NameNotFoundException -> L9
        L12:
            service.getClass();
            Object r2 = this.mLock;
            monitor-enter(r2);
        L18:
            th = move-exception;
            throw th;
        L15:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L20;
            monitor-exit(r2);     // Catch: Throwable -> L18
            return;
        L20:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L18
            monitor-exit(r2);     // Catch: Throwable -> L18
            long identity = Binder.clearCallingIdentity();
            userState.setPrintServiceEnabled(service, isEnabled);     // Catch: Throwable -> L26
            Binder.restoreCallingIdentity(identity);
            return;
        L26:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public boolean isPrintServiceEnabled(ComponentName service, int userId) {
            String[] packages = this.mContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            boolean matchCalling = false;
            int i = 0;
        L4:
            if (i >= packages.length) goto L9;
            if (packages[i].equals(service.getPackageName()) == true) goto L7;
            i = i + 1;
            goto L4
        L7:
            matchCalling = true;
        L9:
            if (matchCalling == false) goto L25;
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r3 = this.mLock;
            monitor-enter(r3);
        L16:
            th = move-exception;
            throw th;
        L13:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L18;
            monitor-exit(r3);     // Catch: Throwable -> L16
            return false;
        L18:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L16
            monitor-exit(r3);     // Catch: Throwable -> L16
            return userState.isPrintServiceEnabled(service);
        L25:
            throw new SecurityException("PrintService does not share UID with caller.");
        }

        public List<RecommendationInfo> getPrintServiceRecommendations(int userId) {
            this.mContext.enforceCallingOrSelfPermission("android.permission.READ_PRINT_SERVICE_RECOMMENDATIONS", null);
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return null;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            List<RecommendationInfo> r2 = userState.getPrintServiceRecommendations();     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return r2;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void createPrinterDiscoverySession(IPrinterDiscoveryObserver observer, int userId) {
            observer.getClass();
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            userState.createPrinterDiscoverySession(observer);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void destroyPrinterDiscoverySession(IPrinterDiscoveryObserver observer, int userId) {
            observer.getClass();
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            userState.destroyPrinterDiscoverySession(observer);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void startPrinterDiscovery(IPrinterDiscoveryObserver observer, List<PrinterId> priorityList, int userId) {
            observer.getClass();
            if (priorityList == null) goto L5;
            priorityList = (List) Preconditions.checkCollectionElementsNotNull(priorityList, "PrinterId");
        L5:
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L8:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L13;
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L13:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            long identity = Binder.clearCallingIdentity();
            userState.startPrinterDiscovery(observer, priorityList);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(identity);
            return;
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void stopPrinterDiscovery(IPrinterDiscoveryObserver observer, int userId) {
            observer.getClass();
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            userState.stopPrinterDiscovery(observer);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void validatePrinters(List<PrinterId> printerIds, int userId) {
            List<PrinterId> printerIds2 = (List) Preconditions.checkCollectionElementsNotNull(printerIds, "PrinterId");
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            userState.validatePrinters(printerIds2);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void startPrinterStateTracking(PrinterId printerId, int userId) {
            printerId.getClass();
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            userState.startPrinterStateTracking(printerId);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void stopPrinterStateTracking(PrinterId printerId, int userId) {
            printerId.getClass();
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            userState.stopPrinterStateTracking(printerId);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void addPrintJobStateChangeListener(IPrintJobStateChangeListener listener, int appId, int userId) throws RemoteException {
            listener.getClass();
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            int resolvedAppId = resolveCallingAppEnforcingPermissions(appId);     // Catch: Throwable -> L8
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            userState.addPrintJobStateChangeListener(listener, resolvedAppId);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void removePrintJobStateChangeListener(IPrintJobStateChangeListener listener, int userId) {
            listener.getClass();
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            userState.removePrintJobStateChangeListener(listener);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void addPrintServicesChangeListener(IPrintServicesChangeListener listener, int userId) throws RemoteException {
            listener.getClass();
            this.mContext.enforceCallingOrSelfPermission("android.permission.READ_PRINT_SERVICES", null);
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            userState.addPrintServicesChangeListener(listener);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void removePrintServicesChangeListener(IPrintServicesChangeListener listener, int userId) {
            listener.getClass();
            this.mContext.enforceCallingOrSelfPermission("android.permission.READ_PRINT_SERVICES", null);
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            userState.removePrintServicesChangeListener(listener);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void addPrintServiceRecommendationsChangeListener(IRecommendationsChangeListener listener, int userId) throws RemoteException {
            listener.getClass();
            this.mContext.enforceCallingOrSelfPermission("android.permission.READ_PRINT_SERVICE_RECOMMENDATIONS", null);
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            userState.addPrintServiceRecommendationsChangeListener(listener);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void removePrintServiceRecommendationsChangeListener(IRecommendationsChangeListener listener, int userId) {
            listener.getClass();
            this.mContext.enforceCallingOrSelfPermission("android.permission.READ_PRINT_SERVICE_RECOMMENDATIONS", null);
            int resolvedUserId = resolveCallingUserEnforcingPermissions(userId);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (resolveCallingProfileParentLocked(resolvedUserId) == getCurrentUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            UserState userState = getOrCreateUserStateLocked(resolvedUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            long identity = Binder.clearCallingIdentity();
            userState.removePrintServiceRecommendationsChangeListener(listener);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            fd.getClass();
            if (DumpUtils.checkDumpPermission(this.mContext, PrintManagerService.LOG_TAG, pw) == true) goto L5;
            return;
        L5:
            int opti = 0;
            boolean dumpAsProto = false;
        L7:
            if (opti >= args.length) goto L20;
            String opt = args[opti];
            if (opt == null) goto L20;
            if (opt.length() <= 0) goto L20;
            if (opt.charAt(0) != '-') goto L20;
            opti = opti + 1;
            if ("--proto".equals(opt) == true) goto L17;
            pw.println("Unknown argument: " + opt + "; use -h for help");
            goto L7
        L17:
            dumpAsProto = true;
        L20:
            ArrayList<UserState> userStatesToDump = new ArrayList();
            Object r3 = this.mLock;
            monitor-enter(r3);
            int numUserStates = this.mUserStates.size();     // Catch: Throwable -> L25
            int i = 0;
        L23:
            if (i >= numUserStates) goto L28;
            userStatesToDump.add(this.mUserStates.valueAt(i));     // Catch: Throwable -> L25
            i = i + 1;     // Catch: Throwable -> L25
            goto L23
        L28:
            monitor-exit(r3);     // Catch: Throwable -> L25
            long identity = Binder.clearCallingIdentity();
            if (dumpAsProto == false) goto L34;
            dump(new DualDumpOutputStream(new ProtoOutputStream(fd)), userStatesToDump);     // Catch: Throwable -> L32
        L35:
            Binder.restoreCallingIdentity(identity);
            return;
        L34:
            pw.println("PRINT MANAGER STATE (dumpsys print)");     // Catch: Throwable -> L32
            dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), userStatesToDump);     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L25:
            th = move-exception;
            throw th;
        }

        public boolean getBindInstantServiceAllowed(int userId) {
            int callingUid = Binder.getCallingUid();
            if (callingUid == 2000) goto L8;
            if (callingUid == 0) goto L8;
            throw new SecurityException("Can only be called by uid 2000 or 0");
        L8:
            Object r1 = this.mLock;
            monitor-enter(r1);
            UserState userState = getOrCreateUserStateLocked(userId, false);     // Catch: Throwable -> L20
            monitor-exit(r1);     // Catch: Throwable -> L20
            long identity = Binder.clearCallingIdentity();
            boolean r2 = userState.getBindInstantServiceAllowed();     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(identity);
            return r2;
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L20:
            th = move-exception;
            throw th;
        }

        public void setBindInstantServiceAllowed(int userId, boolean allowed) {
            int callingUid = Binder.getCallingUid();
            if (callingUid == 2000) goto L8;
            if (callingUid == 0) goto L8;
            throw new SecurityException("Can only be called by uid 2000 or 0");
        L8:
            Object r1 = this.mLock;
            monitor-enter(r1);
            UserState userState = getOrCreateUserStateLocked(userId, false);     // Catch: Throwable -> L20
            monitor-exit(r1);     // Catch: Throwable -> L20
            long identity = Binder.clearCallingIdentity();
            userState.setBindInstantServiceAllowed(allowed);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(identity);
            return;
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L20:
            th = move-exception;
            throw th;
        }

        private boolean isPrintingEnabled() {
            return !this.mUserManager.hasUserRestriction("no_printing", Binder.getCallingUserHandle());
        }

        private void dump(DualDumpOutputStream dumpStream, ArrayList<UserState> userStatesToDump) {
            int userStateCount = userStatesToDump.size();
            int i = 0;
        L3:
            if (i >= userStateCount) goto L5;
            long token = dumpStream.start("user_states", 2246267895809L);
            userStatesToDump.get(i).dump(dumpStream);
            dumpStream.end(token);
            i = i + 1;
            goto L3
        L5:
            dumpStream.flush();
        }

        private void registerContentObservers() {
            final Uri enabledPrintServicesUri = Settings.Secure.getUriFor("disabled_print_services");
            final Handler r2 = BackgroundThread.getHandler();
            ContentObserver observer = new AnonymousClass1(this, r2, enabledPrintServicesUri);
            this.mContext.getContentResolver().registerContentObserver(enabledPrintServicesUri, false, observer, -1);
        }

        private void registerBroadcastReceivers() {
            final boolean r1 = true;
            PackageMonitor monitor = new AnonymousClass2(this, r1);
            monitor.register(this.mContext, BackgroundThread.getHandler().getLooper(), UserHandle.ALL, true);
        }

        private UserState getOrCreateUserStateLocked(int userId, boolean lowPriority) {
            return getOrCreateUserStateLocked(userId, lowPriority, true);
        }

        private UserState getOrCreateUserStateLocked(int userId, boolean lowPriority, boolean enforceUserUnlockingOrUnlocked) {
            return getOrCreateUserStateLocked(userId, lowPriority, enforceUserUnlockingOrUnlocked, false);
        }

        private UserState getOrCreateUserStateLocked(int userId, boolean lowPriority, boolean enforceUserUnlockingOrUnlocked, boolean shouldUpdateState) {
            if (enforceUserUnlockingOrUnlocked == true) goto L4;
        L8:
            UserState userState = this.mUserStates.get(userId);
            if (userState != null) goto L11;
            userState = new UserState(this.mContext, userId, this.mLock, lowPriority);
            this.mUserStates.put(userId, userState);
        L13:
            if (lowPriority == true) goto L15;
            userState.increasePriority();
        L15:
            return userState;
        L11:
            if (shouldUpdateState == false) goto L13;
            userState.updateIfNeededLocked();
            goto L13
        L4:
            if (this.mUserManager.isUserUnlockingOrUnlocked(userId) == true) goto L8;
            throw new IllegalStateException("User " + userId + " must be unlocked for printing to be available");
        }

        private void handleUserUnlocked(final int userId) {
            BackgroundThread.getHandler().post(new AnonymousClass3(this, userId));
        }

        private void handleUserStopped(final int userId) {
            BackgroundThread.getHandler().post(new AnonymousClass4(this, userId));
        }

        private int resolveCallingProfileParentLocked(int userId) {
            if (userId == getCurrentUserId()) goto L16;
            long identity = Binder.clearCallingIdentity();
            UserInfo parent = this.mUserManager.getProfileParent(userId);     // Catch: Throwable -> L10
            if (parent == null) goto L12;
            int r3 = parent.getUserHandle().getIdentifier();     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return r3;
        L12:
            Binder.restoreCallingIdentity(identity);
            return -10;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L16:
            return userId;
        }

        private int resolveCallingAppEnforcingPermissions(int appId) {
            int callingUid = Binder.getCallingUid();
            if (callingUid != 0) goto L5;
            return appId;
        L5:
            int callingAppId = UserHandle.getAppId(callingUid);
            if (appId != callingAppId) goto L8;
        L17:
            return appId;
        L8:
            if (callingAppId == 2000) goto L17;
            if (callingAppId == 1000) goto L17;
            if (this.mContext.checkCallingPermission("com.android.printspooler.permission.ACCESS_ALL_PRINT_JOBS") != 0) goto L16;
            return appId;
        L16:
            throw new SecurityException("Call from app " + callingAppId + " as app " + appId + " without com.android.printspooler.permission.ACCESS_ALL_PRINT_JOBS");
        }

        private int resolveCallingUserEnforcingPermissions(int userId) {
            return ActivityManager.getService().handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, true, true, "", null);
        L15:
            return userId;
        L10:
            return userId;
        }

        private String resolveCallingPackageNameEnforcingSecurity(String packageName) {
            String[] packages = this.mContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            int packageCount = packages.length;
            int i = 0;
        L3:
            if (i >= packageCount) goto L9;
            if (packageName.equals(packages[i]) == true) goto L6;
            i = i + 1;
            goto L3
        L6:
            return packageName;
        L9:
            throw new IllegalArgumentException("packageName has to belong to the caller");
        }

        private int getCurrentUserId() {
            long identity = Binder.clearCallingIdentity();
            int r2 = ActivityManager.getCurrentUser();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }
    }

    public PrintManagerService(Context context) {
        super(context);
        this.mPrintManagerImpl = new PrintManagerImpl(this, context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("print", this.mPrintManagerImpl);
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocking(SystemService.TargetUser user) {
        PrintManagerImpl.m7896$$Nest$mhandleUserUnlocked(this.mPrintManagerImpl, user.getUserIdentifier());
    }

    @Override // com.android.server.SystemService
    public void onUserStopping(SystemService.TargetUser user) {
        PrintManagerImpl.m7895$$Nest$mhandleUserStopped(this.mPrintManagerImpl, user.getUserIdentifier());
    }
}
