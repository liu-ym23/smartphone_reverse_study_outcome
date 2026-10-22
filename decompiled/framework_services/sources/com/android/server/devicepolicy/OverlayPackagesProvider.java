package com.android.server.devicepolicy;

import android.R;
import android.app.role.RoleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.view.inputmethod.InputMethodInfo;
import com.android.internal.util.Preconditions;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.pm.ApexManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class OverlayPackagesProvider {
    protected static final String TAG = "OverlayPackagesProvider";
    private static final Map<String, String> sActionToMetadataKeyMap = null;
    private static final Set<String> sAllowedActions = null;
    private final Context mContext;
    private final Injector mInjector;
    private final PackageManager mPm;
    private final RecursiveStringArrayResourceResolver mRecursiveStringArrayResourceResolver;

    private static final class DefaultInjector implements Injector {
        /* JADX INFO: renamed from: $r8$lambda$qCGXkqwkcf5V9wRzTfUiBMin-Wk, reason: not valid java name */
        public static /* synthetic */ String m3514$r8$lambda$qCGXkqwkcf5V9wRzTfUiBMinWk(Context r0) {
            return lambda$getDevicePolicyManagementRoleHolderPackageName$0(r0);
        }

        /* synthetic */ DefaultInjector(OverlayPackagesProviderIA r1) {
            this();
        }

        private DefaultInjector() {
        }

        @Override // com.android.server.devicepolicy.OverlayPackagesProvider.Injector
        public List<InputMethodInfo> getInputMethodListAsUser(int userId) {
            return InputMethodManagerInternal.get().getInputMethodListAsUser(userId);
        }

        @Override // com.android.server.devicepolicy.OverlayPackagesProvider.Injector
        public String getActiveApexPackageNameContainingPackage(String packageName) {
            return ApexManager.getInstance().getActiveApexPackageNameContainingPackage(packageName);
        }

        @Override // com.android.server.devicepolicy.OverlayPackagesProvider.Injector
        public String getDevicePolicyManagementRoleHolderPackageName(final Context context) {
            return (String) Binder.withCleanCallingIdentity(new OverlayPackagesProvider$DefaultInjector$$ExternalSyntheticLambda0(context));
        }

        private static /* synthetic */ String lambda$getDevicePolicyManagementRoleHolderPackageName$0(Context context) throws Exception {
            RoleManager roleManager = (RoleManager) context.getSystemService(RoleManager.class);
            List<String> roleHolders = roleManager.getRoleHolders("android.app.role.DEVICE_POLICY_MANAGEMENT");
            if (roleHolders.isEmpty() == false) goto L7;
            return null;
        L7:
            return roleHolders.get(0);
        }
    }

    interface Injector {
        String getActiveApexPackageNameContainingPackage(String r1);

        String getDevicePolicyManagementRoleHolderPackageName(Context r1);

        List<InputMethodInfo> getInputMethodListAsUser(int r1);
    }

    public static /* synthetic */ String[] $r8$lambda$3E9LftquJJwQKjbYZVbYgoZnplQ(int r0) {
        return lambda$dump$11(r0);
    }

    public static /* synthetic */ String[] $r8$lambda$8fE0w5L9mBDN45HMGaSGzNyLpKE(int r0) {
        return lambda$dump$1(r0);
    }

    public static /* synthetic */ String[] $r8$lambda$AgvqN3ACCsQvAonVzz3UNrxhaHI(int r0) {
        return lambda$dump$3(r0);
    }

    public static /* synthetic */ String[] $r8$lambda$Bpjpq7H0ZG9cFZSBuC5EGmSvass(int r0) {
        return lambda$dump$7(r0);
    }

    public static /* synthetic */ String[] $r8$lambda$E4bSHfMDQZoM2Ov4YSaLYAT9_t4(int r0) {
        return lambda$dump$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$I0-s-JSLF5g9FufW_YOqabQDof4, reason: not valid java name */
    public static /* synthetic */ String[] m3511$r8$lambda$I0sJSLF5g9FufW_YOqabQDof4(int r0) {
        return lambda$dump$6(r0);
    }

    public static /* synthetic */ String[] $r8$lambda$NzqhlktApwF1oiRBpnqDoLN3694(int r0) {
        return lambda$dump$4(r0);
    }

    public static /* synthetic */ String[] $r8$lambda$Uwai4rObQEoI1nHq8I8uV6pqJ5Q(int r0) {
        return lambda$dump$9(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Zc-HKCg2M3bZJ_9l2v3XK68XZRc, reason: not valid java name */
    public static /* synthetic */ String[] m3512$r8$lambda$ZcHKCg2M3bZJ_9l2v3XK68XZRc(int r0) {
        return lambda$dump$5(r0);
    }

    public static /* synthetic */ String[] $r8$lambda$sTWJC8t6yX8DrrM2220p8pxQmvk(int r0) {
        return lambda$dump$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$v4hXO-GM_I95TUz9ZBGDfE9WXS4, reason: not valid java name */
    public static /* synthetic */ String[] m3513$r8$lambda$v4hXOGM_I95TUz9ZBGDfE9WXS4(int r0) {
        return lambda$dump$10(r0);
    }

    public static /* synthetic */ String[] $r8$lambda$wON8JPwohRauKszRcb44jdGS1rU(int r0) {
        return lambda$dump$8(r0);
    }

    static {
        sActionToMetadataKeyMap = new HashMap();
        sActionToMetadataKeyMap.put("android.app.action.PROVISION_MANAGED_USER", "android.app.REQUIRED_APP_MANAGED_USER");
        sActionToMetadataKeyMap.put("android.app.action.PROVISION_MANAGED_PROFILE", "android.app.REQUIRED_APP_MANAGED_PROFILE");
        sActionToMetadataKeyMap.put("android.app.action.PROVISION_MANAGED_DEVICE", "android.app.REQUIRED_APP_MANAGED_DEVICE");
        sAllowedActions = new HashSet();
        sAllowedActions.add("android.app.action.PROVISION_MANAGED_USER");
        sAllowedActions.add("android.app.action.PROVISION_MANAGED_PROFILE");
        sAllowedActions.add("android.app.action.PROVISION_MANAGED_DEVICE");
    }

    public OverlayPackagesProvider(Context context) {
        this(context, new DefaultInjector(null), new RecursiveStringArrayResourceResolver(context.getResources()));
    }

    OverlayPackagesProvider(Context context, Injector injector, RecursiveStringArrayResourceResolver recursiveStringArrayResourceResolver) {
        this.mContext = context;
        PackageManager r0 = context.getPackageManager();
        r0.getClass();
        this.mPm = r0;
        injector.getClass();
        this.mInjector = injector;
        recursiveStringArrayResourceResolver.getClass();
        this.mRecursiveStringArrayResourceResolver = recursiveStringArrayResourceResolver;
    }

    public Set<String> getNonRequiredApps(ComponentName admin, int userId, String provisioningAction) {
        admin.getClass();
        Preconditions.checkArgument(sAllowedActions.contains(provisioningAction));
        Set<String> nonRequiredApps = getLaunchableApps(userId);
        nonRequiredApps.removeAll(getRequiredApps(provisioningAction, admin.getPackageName()));
        nonRequiredApps.removeAll(getSystemInputMethods(userId));
        nonRequiredApps.addAll(getDisallowedApps(provisioningAction));
        nonRequiredApps.removeAll(getRequiredAppsMainlineModules(nonRequiredApps, provisioningAction));
        nonRequiredApps.removeAll(getDeviceManagerRoleHolders());
        return nonRequiredApps;
    }

    private Set<String> getDeviceManagerRoleHolders() {
        HashSet<String> result = new HashSet();
        String deviceManagerRoleHolderPackageName = this.mInjector.getDevicePolicyManagementRoleHolderPackageName(this.mContext);
        if (deviceManagerRoleHolderPackageName == null) goto L5;
        result.add(deviceManagerRoleHolderPackageName);
    L5:
        return result;
    }

    private Set<String> getRequiredAppsMainlineModules(Set<String> packageNames, String provisioningAction) {
        Set<String> result = new HashSet();
        Iterator<String> r1 = packageNames.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        String packageName = r1.next();
        if (isMainlineModule(packageName) == false) goto L4;
        if (isRequiredAppDeclaredInMetadata(packageName, provisioningAction) == false) goto L4;
        result.add(packageName);
        goto L4
    L12:
        return result;
    }

    private boolean isRequiredAppDeclaredInMetadata(String packageName, String provisioningAction) {
        PackageInfo packageInfo = this.mPm.getPackageInfo(packageName, 128);     // Catch: PackageManager.NameNotFoundException -> L12
        if (packageInfo.applicationInfo != null) goto L7;
    L11:
        return false;
    L7:
        if (packageInfo.applicationInfo.metaData == null) goto L11;
        String metadataKey = sActionToMetadataKeyMap.get(provisioningAction);
        return packageInfo.applicationInfo.metaData.getBoolean(metadataKey);
    L13:
        return false;
    }

    private boolean isMainlineModule(String packageName) {
        if (isRegularMainlineModule(packageName) == false) goto L5;
    L8:
        return true;
    L5:
        if (isApkInApexMainlineModule(packageName) == true) goto L8;
        return false;
    }

    private boolean isRegularMainlineModule(String packageName) {
        this.mPm.getModuleInfo(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L7:
        return false;
    }

    private boolean isApkInApexMainlineModule(String packageName) {
        String apexPackageName = this.mInjector.getActiveApexPackageNameContainingPackage(packageName);
        if (apexPackageName == null) goto L5;
        return true;
    L5:
        return false;
    }

    private Set<String> getLaunchableApps(int userId) {
        Intent launcherIntent = new Intent("android.intent.action.MAIN");
        launcherIntent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> resolveInfos = this.mPm.queryIntentActivitiesAsUser(launcherIntent, 795136, userId);
        Set<String> apps = new ArraySet();
        Iterator<ResolveInfo> r3 = resolveInfos.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ResolveInfo resolveInfo = r3.next();
        apps.add(resolveInfo.activityInfo.packageName);
        goto L4
    L6:
        return apps;
    }

    private Set<String> getSystemInputMethods(int userId) {
        List<InputMethodInfo> inputMethods = this.mInjector.getInputMethodListAsUser(userId);
        Set<String> systemInputMethods = new ArraySet();
        Iterator<InputMethodInfo> r2 = inputMethods.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        InputMethodInfo inputMethodInfo = r2.next();
        ApplicationInfo applicationInfo = inputMethodInfo.getServiceInfo().applicationInfo;
        if (applicationInfo.isSystemApp() == false) goto L4;
        systemInputMethods.add(inputMethodInfo.getPackageName());
        goto L4
    L9:
        return systemInputMethods;
    }

    private Set<String> getRequiredApps(String provisioningAction, String dpcPackageName) {
        Set<String> requiredApps = new ArraySet();
        requiredApps.addAll(getRequiredAppsSet(provisioningAction));
        requiredApps.addAll(getVendorRequiredAppsSet(provisioningAction));
        requiredApps.add(dpcPackageName);
        return requiredApps;
    }

    private Set<String> getDisallowedApps(String provisioningAction) {
        Set<String> disallowedApps = new ArraySet();
        disallowedApps.addAll(getDisallowedAppsSet(provisioningAction));
        disallowedApps.addAll(getVendorDisallowedAppsSet(provisioningAction));
        return disallowedApps;
    }

    private Set<String> getRequiredAppsSet(String provisioningAction) {
        switch(provisioningAction.hashCode()) {
            case -920528692: goto L12;
            case -514404415: goto L9;
            case -340845101: goto L6;
            default: goto L14;
        };
    L14:
        byte r0 = -1;
    L15:
        switch(r0) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            default: goto L17;
        };
    L18:
        int resId = 17236285;
    L22:
        return resolveStringArray(resId);
    L19:
        resId = 17236286;
        goto L22
    L20:
        resId = 17236287;
        goto L22
    L17:
        throw new IllegalArgumentException("Provisioning type " + provisioningAction + " not supported.");
    L6:
        if (provisioningAction.equals("android.app.action.PROVISION_MANAGED_PROFILE") == false) goto L14;
        r0 = 1;
        goto L15
    L9:
        if (provisioningAction.equals("android.app.action.PROVISION_MANAGED_USER") == false) goto L14;
        r0 = 0;
        goto L15
    L12:
        if (provisioningAction.equals("android.app.action.PROVISION_MANAGED_DEVICE") == false) goto L14;
        r0 = 2;
        goto L15
    }

    private Set<String> getDisallowedAppsSet(String provisioningAction) {
        switch(provisioningAction.hashCode()) {
            case -920528692: goto L12;
            case -514404415: goto L9;
            case -340845101: goto L6;
            default: goto L14;
        };
    L14:
        byte r0 = -1;
    L15:
        switch(r0) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            default: goto L17;
        };
    L18:
        int resId = R.array.stoppable_fgs_system_apps;
    L22:
        return resolveStringArray(resId);
    L19:
        resId = R.array.supported_locales;
        goto L22
    L20:
        resId = R.array.theming_defaults;
        goto L22
    L17:
        throw new IllegalArgumentException("Provisioning type " + provisioningAction + " not supported.");
    L6:
        if (provisioningAction.equals("android.app.action.PROVISION_MANAGED_PROFILE") == false) goto L14;
        r0 = 1;
        goto L15
    L9:
        if (provisioningAction.equals("android.app.action.PROVISION_MANAGED_USER") == false) goto L14;
        r0 = 0;
        goto L15
    L12:
        if (provisioningAction.equals("android.app.action.PROVISION_MANAGED_DEVICE") == false) goto L14;
        r0 = 2;
        goto L15
    }

    private Set<String> getVendorRequiredAppsSet(String provisioningAction) {
        switch(provisioningAction.hashCode()) {
            case -920528692: goto L12;
            case -514404415: goto L9;
            case -340845101: goto L6;
            default: goto L14;
        };
    L14:
        byte r0 = -1;
    L15:
        switch(r0) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            default: goto L17;
        };
    L18:
        int resId = 17236310;
    L22:
        return resolveStringArray(resId);
    L19:
        resId = 17236311;
        goto L22
    L20:
        resId = 17236312;
        goto L22
    L17:
        throw new IllegalArgumentException("Provisioning type " + provisioningAction + " not supported.");
    L6:
        if (provisioningAction.equals("android.app.action.PROVISION_MANAGED_PROFILE") == false) goto L14;
        r0 = 1;
        goto L15
    L9:
        if (provisioningAction.equals("android.app.action.PROVISION_MANAGED_USER") == false) goto L14;
        r0 = 0;
        goto L15
    L12:
        if (provisioningAction.equals("android.app.action.PROVISION_MANAGED_DEVICE") == false) goto L14;
        r0 = 2;
        goto L15
    }

    private Set<String> getVendorDisallowedAppsSet(String provisioningAction) {
        switch(provisioningAction.hashCode()) {
            case -920528692: goto L12;
            case -514404415: goto L9;
            case -340845101: goto L6;
            default: goto L14;
        };
    L14:
        byte r0 = -1;
    L15:
        switch(r0) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            default: goto L17;
        };
    L18:
        int resId = 17236306;
    L22:
        return resolveStringArray(resId);
    L19:
        resId = 17236307;
        goto L22
    L20:
        resId = 17236308;
        goto L22
    L17:
        throw new IllegalArgumentException("Provisioning type " + provisioningAction + " not supported.");
    L6:
        if (provisioningAction.equals("android.app.action.PROVISION_MANAGED_PROFILE") == false) goto L14;
        r0 = 1;
        goto L15
    L9:
        if (provisioningAction.equals("android.app.action.PROVISION_MANAGED_USER") == false) goto L14;
        r0 = 0;
        goto L15
    L12:
        if (provisioningAction.equals("android.app.action.PROVISION_MANAGED_DEVICE") == false) goto L14;
        r0 = 2;
        goto L15
    }

    private Set<String> resolveStringArray(int resId) {
        return new ArraySet(Arrays.asList(this.mContext.getResources().getStringArray(resId)));
    }

    void dump(IndentingPrintWriter pw) {
        pw.println(TAG);
        pw.increaseIndent();
        DevicePolicyManagerService.dumpApps(pw, "required_apps_managed_device", (String[]) resolveStringArray(17236285).toArray(new OverlayPackagesProvider$$ExternalSyntheticLambda0()));
        DevicePolicyManagerService.dumpApps(pw, "required_apps_managed_user", (String[]) resolveStringArray(17236287).toArray(new OverlayPackagesProvider$$ExternalSyntheticLambda3()));
        DevicePolicyManagerService.dumpApps(pw, "required_apps_managed_profile", (String[]) resolveStringArray(17236286).toArray(new OverlayPackagesProvider$$ExternalSyntheticLambda4()));
        DevicePolicyManagerService.dumpApps(pw, "disallowed_apps_managed_device", (String[]) resolveStringArray(R.array.stoppable_fgs_system_apps).toArray(new OverlayPackagesProvider$$ExternalSyntheticLambda5()));
        DevicePolicyManagerService.dumpApps(pw, "disallowed_apps_managed_user", (String[]) resolveStringArray(R.array.theming_defaults).toArray(new OverlayPackagesProvider$$ExternalSyntheticLambda6()));
        DevicePolicyManagerService.dumpApps(pw, "disallowed_apps_managed_device", (String[]) resolveStringArray(R.array.stoppable_fgs_system_apps).toArray(new OverlayPackagesProvider$$ExternalSyntheticLambda7()));
        DevicePolicyManagerService.dumpApps(pw, "vendor_required_apps_managed_device", (String[]) resolveStringArray(17236310).toArray(new OverlayPackagesProvider$$ExternalSyntheticLambda8()));
        DevicePolicyManagerService.dumpApps(pw, "vendor_required_apps_managed_user", (String[]) resolveStringArray(17236312).toArray(new OverlayPackagesProvider$$ExternalSyntheticLambda9()));
        DevicePolicyManagerService.dumpApps(pw, "vendor_required_apps_managed_profile", (String[]) resolveStringArray(17236311).toArray(new OverlayPackagesProvider$$ExternalSyntheticLambda10()));
        DevicePolicyManagerService.dumpApps(pw, "vendor_disallowed_apps_managed_user", (String[]) resolveStringArray(17236308).toArray(new OverlayPackagesProvider$$ExternalSyntheticLambda11()));
        DevicePolicyManagerService.dumpApps(pw, "vendor_disallowed_apps_managed_device", (String[]) resolveStringArray(17236306).toArray(new OverlayPackagesProvider$$ExternalSyntheticLambda1()));
        DevicePolicyManagerService.dumpApps(pw, "vendor_disallowed_apps_managed_profile", (String[]) resolveStringArray(17236307).toArray(new OverlayPackagesProvider$$ExternalSyntheticLambda2()));
        pw.decreaseIndent();
    }

    private static /* synthetic */ String[] lambda$dump$0(int x$0) {
        return new String[x$0];
    }

    private static /* synthetic */ String[] lambda$dump$1(int x$0) {
        return new String[x$0];
    }

    private static /* synthetic */ String[] lambda$dump$2(int x$0) {
        return new String[x$0];
    }

    private static /* synthetic */ String[] lambda$dump$3(int x$0) {
        return new String[x$0];
    }

    private static /* synthetic */ String[] lambda$dump$4(int x$0) {
        return new String[x$0];
    }

    private static /* synthetic */ String[] lambda$dump$5(int x$0) {
        return new String[x$0];
    }

    private static /* synthetic */ String[] lambda$dump$6(int x$0) {
        return new String[x$0];
    }

    private static /* synthetic */ String[] lambda$dump$7(int x$0) {
        return new String[x$0];
    }

    private static /* synthetic */ String[] lambda$dump$8(int x$0) {
        return new String[x$0];
    }

    private static /* synthetic */ String[] lambda$dump$9(int x$0) {
        return new String[x$0];
    }

    private static /* synthetic */ String[] lambda$dump$10(int x$0) {
        return new String[x$0];
    }

    private static /* synthetic */ String[] lambda$dump$11(int x$0) {
        return new String[x$0];
    }
}
