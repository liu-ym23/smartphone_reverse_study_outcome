package com.android.server.supervision;

import android.R;
import android.app.KeyguardManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.supervision.ISupervisionManager;
import android.app.supervision.SupervisionManagerInternal;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.util.SparseArray;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pm.UserManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SupervisionService extends ISupervisionManager.Stub {
    static final String ACTION_CONFIRM_SUPERVISION_CREDENTIALS = "android.app.supervision.action.CONFIRM_SUPERVISION_CREDENTIALS";
    private static final String LOG_TAG = "SupervisionService";
    private final Context mContext;
    private final Injector mInjector;
    final SupervisionManagerInternal mInternal;
    private final Object mLockDoNoUseDirectly;
    private final SparseArray<SupervisionUserData> mUserData;

    static class Injector {
        private final Context mContext;
        private DevicePolicyManagerInternal mDpmInternal;
        private KeyguardManager mKeyguardManager;
        private PackageManager mPackageManager;
        private UserManagerInternal mUserManagerInternal;

        Injector(Context context) {
            this.mContext = context;
        }

        DevicePolicyManagerInternal getDpmInternal() {
            if (this.mDpmInternal != null) goto L6;
            this.mDpmInternal = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        L6:
            return this.mDpmInternal;
        }

        KeyguardManager getKeyguardManager() {
            if (this.mKeyguardManager != null) goto L6;
            this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService(KeyguardManager.class);
        L6:
            return this.mKeyguardManager;
        }

        PackageManager getPackageManager() {
            if (this.mPackageManager != null) goto L6;
            this.mPackageManager = this.mContext.getPackageManager();
        L6:
            return this.mPackageManager;
        }

        UserManagerInternal getUserManagerInternal() {
            if (this.mUserManagerInternal != null) goto L6;
            this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        L6:
            return this.mUserManagerInternal;
        }
    }

    public static class Lifecycle extends SystemService {
        private final SupervisionService mSupervisionService;

        private final class ProfileOwnerBroadcastReceiver extends BroadcastReceiver {
            final /* synthetic */ Lifecycle this$0;

            /* synthetic */ ProfileOwnerBroadcastReceiver(Lifecycle r1, SupervisionServiceIA r2) {
                this(r1);
            }

            private ProfileOwnerBroadcastReceiver(Lifecycle r1) {
                this.this$0 = r1;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                SupervisionService.m8446$$Nest$msyncStateWithDevicePolicyManager(Lifecycle.m8447$$Nest$fgetmSupervisionService(this.this$0), getSendingUserId());
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSupervisionService, reason: not valid java name */
        static /* bridge */ /* synthetic */ SupervisionService m8447$$Nest$fgetmSupervisionService(Lifecycle r0) {
            return r0.mSupervisionService;
        }

        public Lifecycle(Context context) {
            super(context);
            this.mSupervisionService = new SupervisionService(context);
        }

        Lifecycle(Context context, SupervisionService supervisionService) {
            super(context);
            this.mSupervisionService = supervisionService;
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishLocalService(SupervisionManagerInternal.class, this.mSupervisionService.mInternal);
            publishBinderService("supervision", this.mSupervisionService);
        }

        void registerProfileOwnerListener() {
            IntentFilter poIntentFilter = new IntentFilter();
            poIntentFilter.addAction("android.app.action.PROFILE_OWNER_CHANGED");
            poIntentFilter.setPriority(1000);
            getContext().registerReceiverForAllUsers(new ProfileOwnerBroadcastReceiver(this, null), poIntentFilter, null, null);
        }

        @Override // com.android.server.SystemService
        public void onUserStarting(SystemService.TargetUser user) {
        }
    }

    private final class SupervisionManagerInternalImpl extends SupervisionManagerInternal {
        final /* synthetic */ SupervisionService this$0;

        /* synthetic */ SupervisionManagerInternalImpl(SupervisionService r1, SupervisionServiceIA r2) {
            this(r1);
        }

        private SupervisionManagerInternalImpl(SupervisionService r1) {
            this.this$0 = r1;
        }

        public boolean isActiveSupervisionApp(int uid) {
            int userId = UserHandle.getUserId(uid);
            String supervisionAppPackage = this.this$0.getActiveSupervisionAppPackage(userId);
            if (supervisionAppPackage != null) goto L5;
            return false;
        L5:
            String[] packages = SupervisionService.m8443$$Nest$fgetmInjector(this.this$0).getPackageManager().getPackagesForUid(uid);
            if (packages == null) goto L15;
            int r4 = packages.length;
            int r5 = 0;
        L9:
            if (r5 >= r4) goto L15;
            String packageName = packages[r5];
            if (supervisionAppPackage.equals(packageName) == true) goto L12;
            r5 = r5 + 1;
            goto L9
        L12:
            return true;
        L15:
            return false;
        }

        public boolean isSupervisionEnabledForUser(int userId) {
            return this.this$0.isSupervisionEnabledForUser(userId);
        }

        public void setSupervisionEnabledForUser(int userId, boolean enabled) {
            this.this$0.setSupervisionEnabledForUser(userId, enabled);
        }

        public boolean isSupervisionLockscreenEnabledForUser(int userId) {
            Object r0 = SupervisionService.m8445$$Nest$mgetLockObject(this.this$0);
            monitor-enter(r0);
            boolean r1 = this.this$0.getUserDataLocked(userId).supervisionLockScreenEnabled;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void setSupervisionLockscreenEnabledForUser(int userId, boolean enabled, PersistableBundle options) {
            Object r0 = SupervisionService.m8445$$Nest$mgetLockObject(this.this$0);
            monitor-enter(r0);
            SupervisionUserData data = this.this$0.getUserDataLocked(userId);     // Catch: Throwable -> L7
            data.supervisionLockScreenEnabled = enabled;     // Catch: Throwable -> L7
            data.supervisionLockScreenOptions = options;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private final class UserLifecycleListener implements UserManagerInternal.UserLifecycleListener {
        final /* synthetic */ SupervisionService this$0;

        /* synthetic */ UserLifecycleListener(SupervisionService r1, SupervisionServiceIA r2) {
            this(r1);
        }

        private UserLifecycleListener(SupervisionService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.pm.UserManagerInternal.UserLifecycleListener
        public void onUserRemoved(UserInfo user) {
            Object r0 = SupervisionService.m8445$$Nest$mgetLockObject(this.this$0);
            monitor-enter(r0);
            SupervisionService.m8444$$Nest$fgetmUserData(this.this$0).remove(user.id);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m8443$$Nest$fgetmInjector(SupervisionService r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserData, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m8444$$Nest$fgetmUserData(SupervisionService r0) {
        return r0.mUserData;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetLockObject, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8445$$Nest$mgetLockObject(SupervisionService r0) {
        return r0.getLockObject();
    }

    /* JADX INFO: renamed from: -$$Nest$msyncStateWithDevicePolicyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8446$$Nest$msyncStateWithDevicePolicyManager(SupervisionService r0, int r1) {
        r0.syncStateWithDevicePolicyManager(r1);
    }

    public SupervisionService(Context context) {
        this.mLockDoNoUseDirectly = new Object();
        this.mUserData = new SparseArray();
        SupervisionServiceIA r1 = null;
        this.mInternal = new SupervisionManagerInternalImpl(this, r1);
        this.mContext = context.createAttributionContext(LOG_TAG);
        this.mInjector = new Injector(context);
        this.mInjector.getUserManagerInternal().addUserLifecycleListener(new UserLifecycleListener(this, r1));
    }

    public boolean isSupervisionEnabledForUser(int userId) {
        enforceAnyPermission(new String[]{"android.permission.QUERY_USERS", "android.permission.MANAGE_USERS"});
        if (UserHandle.getUserId(Binder.getCallingUid()) == userId) goto L5;
        enforcePermission("android.permission.INTERACT_ACROSS_USERS");
    L5:
        Object r0 = getLockObject();
        monitor-enter(r0);
        boolean r1 = getUserDataLocked(userId).supervisionEnabled;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public void setSupervisionEnabledForUser(int userId, boolean enabled) {
        if (UserHandle.getUserId(Binder.getCallingUid()) == userId) goto L5;
        enforcePermission("android.permission.INTERACT_ACROSS_USERS");
    L5:
        setSupervisionEnabledForUserInternal(userId, enabled, getSystemSupervisionPackage());
    }

    public String getActiveSupervisionAppPackage(int userId) {
        if (UserHandle.getUserId(Binder.getCallingUid()) == userId) goto L5;
        enforcePermission("android.permission.INTERACT_ACROSS_USERS");
    L5:
        Object r0 = getLockObject();
        monitor-enter(r0);
        String r1 = getUserDataLocked(userId).supervisionAppPackage;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public Intent createConfirmSupervisionCredentialsIntent() {
        enforceAnyPermission(new String[]{"android.permission.QUERY_USERS", "android.permission.MANAGE_USERS"});
        if (isSupervisionEnabledForUser(this.mContext.getUserId()) == true) goto L5;
        return null;
    L5:
        int supervisingUserId = this.mInjector.getUserManagerInternal().getSupervisingProfileId();
        long token = Binder.clearCallingIdentity();
        if (supervisingUserId != (-10000)) goto L17;
    L15:
        Binder.restoreCallingIdentity(token);
        return null;
    L17:
        if (this.mInjector.getKeyguardManager().isDeviceSecure(supervisingUserId) == false) goto L15;
        Binder.restoreCallingIdentity(token);
        Intent intent = new Intent(ACTION_CONFIRM_SUPERVISION_CREDENTIALS);
        intent.setPackage("com.android.settings");
        return intent;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean shouldAllowBypassingSupervisionRoleQualification() {
        enforcePermission("android.permission.MANAGE_ROLE_HOLDERS");
        if (hasNonTestDefaultUsers() == false) goto L5;
        return false;
    L5:
        Object r0 = getLockObject();
        monitor-enter(r0);
        int i = 0;
    L23:
    L14:
        th = move-exception;
        throw th;
    L9:
        if (i >= this.mUserData.size()) goto L18;
        if (this.mUserData.valueAt(i).supervisionEnabled == true) goto L12;
        i = i + 1;     // Catch: Throwable -> L14
        goto L23
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    }

    private boolean hasNonTestDefaultUsers() {
        List<UserInfo> users = this.mInjector.getUserManagerInternal().getUsers(true);
        Iterator<UserInfo> r2 = users.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        UserInfo user = r2.next();
        if (user.isForTesting() == true) goto L4;
        if (user.isMain() == true) goto L4;
        if (isSystemUser(user) == true) goto L4;
        return true;
    L13:
        return false;
    }

    private static boolean isSystemUser(UserInfo userInfo) {
        if ((userInfo.flags & 2048) != 2048) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) throws RemoteException {
        new SupervisionServiceShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
    }

    protected void dump(FileDescriptor fd, PrintWriter printWriter, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, LOG_TAG, printWriter) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter pw = new IndentingPrintWriter(printWriter, "  ");
        pw.println("SupervisionService state:");     // Catch: Throwable -> L19
        pw.increaseIndent();     // Catch: Throwable -> L19
        List<UserInfo> users = this.mInjector.getUserManagerInternal().getUsers(false);     // Catch: Throwable -> L19
        Object r2 = getLockObject();     // Catch: Throwable -> L19
        monitor-enter(r2);     // Catch: Throwable -> L19
        Iterator<UserInfo> r3 = users.iterator();     // Catch: Throwable -> L12
    L10:
        if (r3.hasNext() == false) goto L14;
        UserInfo user = r3.next();     // Catch: Throwable -> L12
        getUserDataLocked(user.id).dump(pw);     // Catch: Throwable -> L12
        pw.println();     // Catch: Throwable -> L12
        goto L10
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L12
        pw.close();
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        pw.close();     // Catch: Throwable -> L22
    L24:
        throw th;
    L22:
        th = move-exception;
        th.addSuppressed(th);
        goto L24
    }

    private Object getLockObject() {
        return this.mLockDoNoUseDirectly;
    }

    SupervisionUserData getUserDataLocked(int userId) {
        SupervisionUserData data = this.mUserData.get(userId);
        if (data != null) goto L6;
        SupervisionUserData data2 = new SupervisionUserData(userId);
        this.mUserData.append(userId, data2);
        return data2;
    L6:
        return data;
    }

    private void setSupervisionEnabledForUserInternal(int userId, boolean enabled, String supervisionAppPackage) {
        Object r0 = getLockObject();
        monitor-enter(r0);
        SupervisionUserData data = getUserDataLocked(userId);     // Catch: Throwable -> L11
        data.supervisionEnabled = enabled;     // Catch: Throwable -> L11
        if (enabled == false) goto L7;
        String r2 = supervisionAppPackage;
    L8:
        data.supervisionAppPackage = r2;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r2 = null;
    L11:
        th = move-exception;
        throw th;
    }

    private void syncStateWithDevicePolicyManager(int userId) {
        DevicePolicyManagerInternal dpmInternal = this.mInjector.getDpmInternal();
        if (dpmInternal == null) goto L5;
        ComponentName po = dpmInternal.getProfileOwnerAsUser(userId);
    L7:
        if (po != null) goto L9;
    L11:
        if (po != null) goto L13;
        return;
    L13:
        if (po.equals(getSupervisionProfileOwnerComponent()) == false) goto L18;
        setSupervisionEnabledForUserInternal(userId, true, po.getPackageName());
        return;
    L18:
        return;
    L9:
        if (po.getPackageName().equals(getSystemSupervisionPackage()) == false) goto L11;
        setSupervisionEnabledForUserInternal(userId, true, getSystemSupervisionPackage());
        return;
    L5:
        po = null;
        goto L7
    }

    private ComponentName getSupervisionProfileOwnerComponent() {
        return ComponentName.unflattenFromString(this.mContext.getResources().getString(R.string.config_healthConnectMigratorPackageName));
    }

    private String getSystemSupervisionPackage() {
        return this.mContext.getResources().getString(R.string.config_systemSupervision);
    }

    private void enforcePermission(String permission) {
        if (this.mContext.checkCallingOrSelfPermission(permission) != 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkCallAuthorization(r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void enforceAnyPermission(String... permissions) {
        boolean authorized = false;
        int r1 = permissions.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        String permission = permissions[r2];
        if (this.mContext.checkCallingOrSelfPermission(permission) != 0) goto L7;
        authorized = true;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        Preconditions.checkCallAuthorization(authorized);
    }
}
