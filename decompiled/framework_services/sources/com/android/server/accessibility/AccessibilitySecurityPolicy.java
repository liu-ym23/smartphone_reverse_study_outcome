package com.android.server.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.AppOpsManager;
import android.app.role.RoleManager;
import android.appwidget.AppWidgetManagerInternal;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodInfo;
import com.android.internal.util.ArrayUtils;
import com.android.server.am.ProcessList;
import com.android.server.inputmethod.InputMethodManagerInternal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilitySecurityPolicy {
    private static final int KEEP_SOURCE_EVENT_TYPES = 71547327;
    private static final String LOG_TAG = "AccessibilitySecurityPolicy";
    private static final int OWN_PROCESS_ID = 0;
    private final AccessibilityUserManager mAccessibilityUserManager;
    private AccessibilityWindowManager mAccessibilityWindowManager;
    private final AppOpsManager mAppOpsManager;
    private AppWidgetManagerInternal mAppWidgetService;
    private final Context mContext;
    private int mCurrentUserId;
    private final ArraySet<ComponentName> mNonA11yCategoryServices;
    private final PackageManager mPackageManager;
    private final PackageManagerInternal mPackageManagerInternal;
    private final PolicyWarningUIController mPolicyWarningUIController;
    private boolean mSendNonA11yToolNotificationEnabled;
    private final UserManager mUserManager;

    public interface AccessibilityUserManager {
        int getCurrentUserIdLocked();

        SparseBooleanArray getVisibleUserIdsLocked();
    }

    static {
        OWN_PROCESS_ID = Process.myPid();
    }

    public AccessibilitySecurityPolicy(PolicyWarningUIController policyWarningUIController, Context context, AccessibilityUserManager a11yUserManager, PackageManagerInternal packageManagerInternal) {
        this.mNonA11yCategoryServices = new ArraySet();
        this.mCurrentUserId = ProcessList.INVALID_ADJ;
        this.mSendNonA11yToolNotificationEnabled = false;
        this.mContext = context;
        this.mAccessibilityUserManager = a11yUserManager;
        this.mPackageManager = this.mContext.getPackageManager();
        this.mPackageManagerInternal = packageManagerInternal;
        this.mUserManager = (UserManager) this.mContext.getSystemService("user");
        this.mAppOpsManager = (AppOpsManager) context.getSystemService("appops");
        this.mPolicyWarningUIController = policyWarningUIController;
    }

    public void setSendingNonA11yToolNotificationLocked(boolean enable) {
        if (enable != this.mSendNonA11yToolNotificationEnabled) goto L5;
        return;
    L5:
        this.mSendNonA11yToolNotificationEnabled = enable;
        this.mPolicyWarningUIController.enableSendingNonA11yToolNotification(enable);
        if (enable == false) goto L11;
        int i = 0;
    L9:
        if (i >= this.mNonA11yCategoryServices.size()) goto L13;
        ComponentName service = this.mNonA11yCategoryServices.valueAt(i);
        this.mPolicyWarningUIController.onNonA11yCategoryServiceBound(this.mCurrentUserId, service);
        i = i + 1;
        goto L9
    L13:
        return;
    }

    public void setAccessibilityWindowManager(AccessibilityWindowManager awm) {
        this.mAccessibilityWindowManager = awm;
    }

    public void setAppWidgetManager(AppWidgetManagerInternal appWidgetManager) {
        this.mAppWidgetService = appWidgetManager;
    }

    public boolean canDispatchAccessibilityEventLocked(int userId, AccessibilityEvent event) {
        int eventType = event.getEventType();
        switch(eventType) {
            case 32: goto L6;
            case 64: goto L6;
            case 128: goto L6;
            case 256: goto L6;
            case 512: goto L6;
            case 1024: goto L6;
            case 16384: goto L6;
            case 262144: goto L6;
            case 524288: goto L6;
            case 1048576: goto L6;
            case 2097152: goto L6;
            case 4194304: goto L6;
            case 16777216: goto L6;
            default: goto L5;
        };
    L6:
        return true;
    L5:
        return isRetrievalAllowingWindowLocked(userId, event.getWindowId());
    }

    public String resolveValidReportedPackageLocked(CharSequence packageName, int appId, int userId, int pid) {
        if (packageName != null) goto L6;
        return null;
    L6:
        if (appId == 1000) goto L8;
        String packageNameStr = packageName.toString();
        int resolvedUid = UserHandle.getUid(userId, appId);
        if (isValidPackageForUid(packageNameStr, resolvedUid) == false) goto L14;
        return packageName.toString();
    L14:
        if (this.mAppWidgetService == null) goto L20;
        if (ArrayUtils.contains(this.mAppWidgetService.getHostedWidgetPackages(resolvedUid), packageNameStr) == false) goto L20;
        return packageName.toString();
    L20:
        if (this.mContext.checkPermission("android.permission.ACT_AS_PACKAGE_FOR_ACCESSIBILITY", pid, resolvedUid) == 0) goto L22;
        String[] packageNames = this.mPackageManager.getPackagesForUid(resolvedUid);
        if (ArrayUtils.isEmpty(packageNames) == false) goto L27;
        return null;
    L27:
        return packageNames[0];
    L22:
        return packageName.toString();
    L8:
        return packageName.toString();
    }

    public String[] computeValidReportedPackages(String targetPackage, int targetUid) {
        if (UserHandle.getAppId(targetUid) == 1000) goto L5;
        String[] uidPackages = {targetPackage};
        if (this.mAppWidgetService == null) goto L17;
        ArraySet<String> widgetPackages = this.mAppWidgetService.getHostedWidgetPackages(targetUid);
        if (widgetPackages == null) goto L17;
        if (widgetPackages.isEmpty() == true) goto L17;
        String[] validPackages = new String[uidPackages.length + widgetPackages.size()];
        System.arraycopy(uidPackages, 0, validPackages, 0, uidPackages.length);
        int widgetPackageCount = widgetPackages.size();
        int i = 0;
    L13:
        if (i >= widgetPackageCount) goto L16;
        validPackages[uidPackages.length + i] = widgetPackages.valueAt(i);
        i = i + 1;
        goto L13
    L16:
        return validPackages;
    L17:
        return uidPackages;
    L5:
        return EmptyArray.STRING;
    }

    public void updateEventSourceLocked(AccessibilityEvent event) {
        if ((event.getEventType() & KEEP_SOURCE_EVENT_TYPES) != 0) goto L6;
        event.setSource(null);
        return;
    }

    public boolean canGetAccessibilityNodeInfoLocked(int userId, AbstractAccessibilityServiceConnection service, int windowId) {
        if (canRetrieveWindowContentLocked(service) == true) goto L5;
    L7:
        return false;
    L5:
        if (isRetrievalAllowingWindowLocked(userId, windowId) == false) goto L7;
        return true;
    }

    public boolean canRetrieveWindowsLocked(AbstractAccessibilityServiceConnection service) {
        if (canRetrieveWindowContentLocked(service) == true) goto L5;
    L7:
        return false;
    L5:
        if (service.mRetrieveInteractiveWindows == false) goto L7;
        return true;
    }

    public boolean canRetrieveWindowContentLocked(AbstractAccessibilityServiceConnection service) {
        if ((service.getCapabilities() & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean canControlMagnification(AbstractAccessibilityServiceConnection service) {
        if ((service.getCapabilities() & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canPerformGestures(AccessibilityServiceConnection service) {
        if ((service.getCapabilities() & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canCaptureFingerprintGestures(AccessibilityServiceConnection service) {
        if ((service.getCapabilities() & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canTakeScreenshotLocked(AbstractAccessibilityServiceConnection service) {
        if ((service.getCapabilities() & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    int canEnableDisableInputMethod(String imeId, AbstractAccessibilityServiceConnection service, int callingUserId) throws SecurityException {
        String servicePackageName = service.getComponentName().getPackageName();
        InputMethodInfo inputMethodInfo = null;
        List<InputMethodInfo> inputMethodInfoList = InputMethodManagerInternal.get().getInputMethodListAsUser(callingUserId);
        if (inputMethodInfoList == null) goto L11;
        Iterator<InputMethodInfo> r3 = inputMethodInfoList.iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        InputMethodInfo info = r3.next();
        if (info.getId().equals(imeId) == false) goto L6;
        inputMethodInfo = info;
    L11:
        if (inputMethodInfo == null) goto L21;
        if (inputMethodInfo.getPackageName().equals(servicePackageName) == false) goto L21;
        if (RestrictedLockUtilsInternal.checkIfInputMethodDisallowed(this.mContext, inputMethodInfo.getPackageName(), callingUserId) == null) goto L18;
        return 1;
    L18:
        return 0;
    L21:
        throw new SecurityException("The input method is in a different package with the accessibility service");
    }

    public int resolveProfileParentLocked(int userId) {
        if (userId == this.mAccessibilityUserManager.getCurrentUserIdLocked()) goto L15;
        long identity = Binder.clearCallingIdentity();
        UserInfo parent = this.mUserManager.getProfileParent(userId);     // Catch: Throwable -> L10
        if (parent == null) goto L12;
        int r3 = parent.getUserHandle().getIdentifier();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return r3;
    L12:
        Binder.restoreCallingIdentity(identity);
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L15:
        return userId;
    }

    public int resolveCallingUserIdEnforcingPermissionsLocked(int userId) {
        int callingUid = Binder.getCallingUid();
        int currentUserId = this.mAccessibilityUserManager.getCurrentUserIdLocked();
        if (callingUid != 0) goto L5;
    L31:
        if (userId == (-2)) goto L36;
        if (userId == (-3)) goto L36;
        return resolveProfileParentLocked(userId);
    L36:
        return currentUserId;
    L5:
        if (callingUid == 1000) goto L31;
        if (callingUid == 2000) goto L31;
        int callingUserId = UserHandle.getUserId(callingUid);
        if (callingUserId == userId) goto L12;
        int callingUserParentId = resolveProfileParentLocked(callingUserId);
        if (callingUserParentId != currentUserId) goto L19;
        if (userId == (-2)) goto L17;
        if (userId != (-3)) goto L19;
    L17:
        return currentUserId;
    L19:
        if (hasPermission("android.permission.INTERACT_ACROSS_USERS") == false) goto L21;
    L25:
        if (userId == (-2)) goto L30;
        if (userId == (-3)) goto L30;
        return resolveProfileParentLocked(userId);
    L30:
        return currentUserId;
    L21:
        if (hasPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == true) goto L25;
        throw new SecurityException("Call from user " + callingUserId + " as user " + userId + " without permission INTERACT_ACROSS_USERS or INTERACT_ACROSS_USERS_FULL not allowed.");
    L12:
        return resolveProfileParentLocked(userId);
    }

    public boolean isCallerInteractingAcrossUsers(int userId) {
        int callingUid = Binder.getCallingUid();
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
    L12:
        return true;
    L5:
        if (callingUid == 2000) goto L12;
        if (userId == (-2)) goto L12;
        if (userId == (-3)) goto L12;
        return false;
    }

    private boolean isValidPackageForUid(String packageName, int uid) {
        long token = Binder.clearCallingIdentity();
        boolean r10 = this.mPackageManagerInternal.isSameApp(packageName, 4194304, uid, UserHandle.getUserId(uid));     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return r10;
    L8:
        th = move-exception;
        Throwable r11 = th;
    L12:
        Binder.restoreCallingIdentity(token);
        throw r11;
    L10:
        th = move-exception;
        r11 = th;
        goto L12
    }

    private boolean isRetrievalAllowingWindowLocked(int userId, int windowId) {
        if (Binder.getCallingUid() != 1000) goto L6;
        return true;
    L6:
        if (Binder.getCallingUid() != 2000) goto L11;
        if (isShellAllowedToRetrieveWindowLocked(userId, windowId) == true) goto L11;
        return false;
    L11:
        if (this.mAccessibilityWindowManager.resolveParentWindowIdLocked(windowId) != this.mAccessibilityWindowManager.getActiveWindowId(userId)) goto L14;
        return true;
    L14:
        if (this.mAccessibilityWindowManager.findA11yWindowInfoByIdLocked(windowId) == null) goto L17;
        return true;
    L17:
        return false;
    }

    private boolean isShellAllowedToRetrieveWindowLocked(int userId, int windowId) {
        long token = Binder.clearCallingIdentity();
        IBinder windowToken = this.mAccessibilityWindowManager.getWindowTokenForUserAndWindowIdLocked(userId, windowId);     // Catch: Throwable -> L16
        if (windowToken != null) goto L8;
        Binder.restoreCallingIdentity(token);
        return false;
    L8:
        int windowOwnerUserId = this.mAccessibilityWindowManager.getWindowOwnerUserId(windowToken);     // Catch: Throwable -> L16
        if (windowOwnerUserId != (-10000)) goto L13;
        Binder.restoreCallingIdentity(token);
        return false;
    L13:
        boolean r3 = !this.mUserManager.hasUserRestriction("no_debugging_features", UserHandle.of(windowOwnerUserId));
        Binder.restoreCallingIdentity(token);
        return r3;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void enforceCallingPermission(String permission, String function) {
        if (OWN_PROCESS_ID != Binder.getCallingPid()) goto L6;
        return;
    L6:
        if (hasPermission(permission) == false) goto L9;
        return;
    L9:
        throw new SecurityException("You do not have " + permission + " required to call " + function + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid());
    }

    public boolean hasPermission(String permission) {
        if (this.mContext.checkCallingPermission(permission) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canRegisterService(ServiceInfo serviceInfo) {
        if ("android.permission.BIND_ACCESSIBILITY_SERVICE".equals(serviceInfo.permission) == true) goto L7;
        Slog.w(LOG_TAG, "Skipping accessibility service " + new ComponentName(serviceInfo.packageName, serviceInfo.name).flattenToShortString() + ": it does not require the permission android.permission.BIND_ACCESSIBILITY_SERVICE");
        return false;
    L7:
        if ((serviceInfo.flags & 4) == 0) goto L10;
        Slog.w(LOG_TAG, "Skipping accessibility service " + new ComponentName(serviceInfo.packageName, serviceInfo.name).flattenToShortString() + ": the service is the external one and doesn't allow to register as an accessibility service ");
        return false;
    L10:
        int servicePackageUid = serviceInfo.applicationInfo.uid;
        if (this.mAppOpsManager.noteOpNoThrow("android:bind_accessibility_service", servicePackageUid, serviceInfo.packageName, null, null) == 0) goto L14;
        Slog.w(LOG_TAG, "Skipping accessibility service " + new ComponentName(serviceInfo.packageName, serviceInfo.name).flattenToShortString() + ": disallowed by AppOps");
        return false;
    L14:
        return true;
    }

    public boolean checkAccessibilityAccess(AbstractAccessibilityServiceConnection service) {
        String packageName = service.getComponentName().getPackageName();
        ResolveInfo resolveInfo = service.getServiceInfo().getResolveInfo();
        boolean r0 = true;
        if (resolveInfo != null) goto L5;
        return true;
    L5:
        int servicePackageUid = resolveInfo.serviceInfo.applicationInfo.uid;
        int callingPid = Binder.getCallingPid();
        long identityToken = Binder.clearCallingIdentity();
        String attributionTag = service.getAttributionTag();
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(identityToken);
        throw th;
    L7:
        if (OWN_PROCESS_ID != callingPid) goto L17;
        if (this.mAppOpsManager.noteOpNoThrow("android:access_accessibility", servicePackageUid, packageName, attributionTag, null) == 0) goto L12;
        r0 = false;
    L12:
        Binder.restoreCallingIdentity(identityToken);
        return r0;
    L17:
        if (this.mAppOpsManager.noteOp("android:access_accessibility", servicePackageUid, packageName, attributionTag, null) == 0) goto L20;
        r0 = false;
    L20:
        Binder.restoreCallingIdentity(identityToken);
        return r0;
    }

    public void enforceCallingOrSelfPermission(String permission) {
        if (this.mContext.checkCallingOrSelfPermission(permission) != 0) goto L6;
        return;
    L6:
        throw new SecurityException("Caller does not hold permission " + permission);
    }

    public void checkForAccessibilityPermissionOrRole() {
        int r1 = 0;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MANAGE_ACCESSIBILITY") != 0) goto L5;
        boolean canManageAccessibility = true;
    L6:
        if (canManageAccessibility == false) goto L8;
        return;
    L8:
        int callingUid = Binder.getCallingUid();
        long identity = Binder.clearCallingIdentity();
        RoleManager roleManager = (RoleManager) this.mContext.getSystemService(RoleManager.class);     // Catch: Throwable -> L20
        if (roleManager == null) goto L23;
        List<String> holders = roleManager.getRoleHoldersAsUser("android.app.role.COMPANION_DEVICE_APP_STREAMING", UserHandle.getUserHandleForUid(callingUid));     // Catch: Throwable -> L20
        String[] packageNames = this.mPackageManager.getPackagesForUid(callingUid);     // Catch: Throwable -> L20
        if (packageNames == null) goto L23;
        int r8 = packageNames.length;     // Catch: Throwable -> L20
    L14:
        if (r1 >= r8) goto L23;
        String packageName = packageNames[r1];     // Catch: Throwable -> L20
        if (holders.contains(packageName) == true) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        Binder.restoreCallingIdentity(identity);
        return;
    L23:
        throw new SecurityException("Cannot register a proxy for a device without the android.app.role.COMPANION_DEVICE_APP_STREAMING role or the MANAGE_ACCESSIBILITY permission.");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        canManageAccessibility = false;
        goto L6
    }

    public void onBoundServicesChangedLocked(int userId, ArrayList<AccessibilityServiceConnection> boundServices) {
        if (this.mAccessibilityUserManager.getCurrentUserIdLocked() == userId) goto L5;
        return;
    L5:
        ArraySet<ComponentName> tempNonA11yCategoryServices = new ArraySet();
        int i = 0;
    L7:
        if (i >= boundServices.size()) goto L17;
        AccessibilityServiceInfo a11yServiceInfo = boundServices.get(i).getServiceInfo();
        ComponentName service = a11yServiceInfo.getComponentName().clone();
        if (a11yServiceInfo.isAccessibilityTool() == true) goto L16;
        tempNonA11yCategoryServices.add(service);
        if (this.mNonA11yCategoryServices.contains(service) == false) goto L14;
        this.mNonA11yCategoryServices.remove(service);
        goto L16
    L14:
        if (this.mSendNonA11yToolNotificationEnabled == false) goto L16;
        this.mPolicyWarningUIController.onNonA11yCategoryServiceBound(userId, service);
    L16:
        i = i + 1;
        goto L7
    L17:
        int i2 = 0;
    L19:
        if (i2 >= this.mNonA11yCategoryServices.size()) goto L21;
        ComponentName service2 = this.mNonA11yCategoryServices.valueAt(i2);
        this.mPolicyWarningUIController.onNonA11yCategoryServiceUnbound(userId, service2);
        i2 = i2 + 1;
        goto L19
    L21:
        this.mNonA11yCategoryServices.clear();
        this.mNonA11yCategoryServices.addAll(tempNonA11yCategoryServices);
    }

    public void onSwitchUserLocked(int userId, Set<ComponentName> enabledServices) {
        if (this.mCurrentUserId != userId) goto L5;
        return;
    L5:
        this.mPolicyWarningUIController.onSwitchUser(userId, new ArraySet(enabledServices));
        int i = 0;
    L7:
        if (i >= this.mNonA11yCategoryServices.size()) goto L9;
        this.mPolicyWarningUIController.onNonA11yCategoryServiceUnbound(this.mCurrentUserId, this.mNonA11yCategoryServices.valueAt(i));
        i = i + 1;
        goto L7
    L9:
        this.mNonA11yCategoryServices.clear();
        this.mCurrentUserId = userId;
    }

    public void onEnabledServicesChangedLocked(int userId, Set<ComponentName> enabledServices) {
        if (this.mAccessibilityUserManager.getCurrentUserIdLocked() == userId) goto L5;
        return;
    L5:
        this.mPolicyWarningUIController.onEnabledServicesChanged(userId, new ArraySet(enabledServices));
    }
}
