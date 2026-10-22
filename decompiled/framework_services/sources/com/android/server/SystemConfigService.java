package com.android.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.content.pm.SignedPackageParcel;
import android.os.Binder;
import android.os.CarrierAssociatedAppEntry;
import android.os.ISystemConfig;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.SparseArray;
import com.android.internal.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class SystemConfigService extends SystemService {
    private final Context mContext;
    private final ISystemConfig.Stub mInterface;

    /* JADX INFO: renamed from: com.android.server.SystemConfigService$1, reason: invalid class name */
    class AnonymousClass1 extends ISystemConfig.Stub {
        final /* synthetic */ SystemConfigService this$0;

        /* JADX INFO: renamed from: $r8$lambda$K-FTV_MSjeVQxh18cdPKyqVwTps, reason: not valid java name */
        public static /* synthetic */ boolean m392$r8$lambda$KFTV_MSjeVQxh18cdPKyqVwTps(PackageManagerInternal r0, String r1) {
            return lambda$getPreventUserDisablePackages$2(r0, r1);
        }

        public static /* synthetic */ List $r8$lambda$bzM45aiZwUxbT6RZbDCr1gxq5RQ(Map.Entry r0) {
            return lambda$getDisabledUntilUsedPreinstalledCarrierAssociatedApps$1(r0);
        }

        public static /* synthetic */ String $r8$lambda$wmomcORUH1VeWokGBddy8LiF3C4(CarrierAssociatedAppEntry r0) {
            return lambda$getDisabledUntilUsedPreinstalledCarrierAssociatedApps$0(r0);
        }

        AnonymousClass1(SystemConfigService this$0) {
            this.this$0 = this$0;
        }

        public List<String> getDisabledUntilUsedPreinstalledCarrierApps() {
            SystemConfigService.m391$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.READ_CARRIER_APP_INFO", "getDisabledUntilUsedPreInstalledCarrierApps requires READ_CARRIER_APP_INFO");
            return new ArrayList(SystemConfig.getInstance().getDisabledUntilUsedPreinstalledCarrierApps());
        }

        public Map getDisabledUntilUsedPreinstalledCarrierAssociatedApps() {
            SystemConfigService.m391$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.READ_CARRIER_APP_INFO", "getDisabledUntilUsedPreInstalledCarrierAssociatedApps requires READ_CARRIER_APP_INFO");
            return (Map) SystemConfig.getInstance().getDisabledUntilUsedPreinstalledCarrierAssociatedApps().entrySet().stream().collect(Collectors.toMap(new SystemConfigService$1$$ExternalSyntheticLambda3(), new SystemConfigService$1$$ExternalSyntheticLambda4()));
        }

        private static /* synthetic */ String lambda$getDisabledUntilUsedPreinstalledCarrierAssociatedApps$0(CarrierAssociatedAppEntry app) {
            return app.packageName;
        }

        private static /* synthetic */ List lambda$getDisabledUntilUsedPreinstalledCarrierAssociatedApps$1(Map.Entry e) {
            return (List) ((List) e.getValue()).stream().map(new SystemConfigService$1$$ExternalSyntheticLambda2()).collect(Collectors.toList());
        }

        public Map getDisabledUntilUsedPreinstalledCarrierAssociatedAppEntries() {
            SystemConfigService.m391$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.READ_CARRIER_APP_INFO", "getDisabledUntilUsedPreInstalledCarrierAssociatedAppEntries requires READ_CARRIER_APP_INFO");
            return SystemConfig.getInstance().getDisabledUntilUsedPreinstalledCarrierAssociatedApps();
        }

        public int[] getSystemPermissionUids(String permissionName) {
            SystemConfigService.m391$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.GET_RUNTIME_PERMISSIONS", "getSystemPermissionUids requires GET_RUNTIME_PERMISSIONS");
            List<Integer> uids = new ArrayList();
            SparseArray<ArraySet<String>> systemPermissions = SystemConfig.getInstance().getSystemPermissions();
            int i = 0;
        L4:
            if (i >= systemPermissions.size()) goto L12;
            ArraySet<String> permissions = systemPermissions.valueAt(i);
            if (permissions == null) goto L10;
            if (permissions.contains(permissionName) == false) goto L10;
            uids.add(Integer.valueOf(systemPermissions.keyAt(i)));
        L10:
            i = i + 1;
            goto L4
        L12:
            return ArrayUtils.convertToIntArray(uids);
        }

        public List<ComponentName> getEnabledComponentOverrides(String packageName) {
            ArrayMap<String, Boolean> systemComponents = SystemConfig.getInstance().getComponentsEnabledStates(packageName);
            List<ComponentName> enabledComponent = new ArrayList();
            if (systemComponents == null) goto L11;
            Iterator<Map.Entry<String, Boolean>> r2 = systemComponents.entrySet().iterator();
        L6:
            if (r2.hasNext() == false) goto L11;
            Map.Entry<String, Boolean> entry = r2.next();
            if (Boolean.TRUE.equals(entry.getValue()) == false) goto L6;
            enabledComponent.add(new ComponentName(packageName, entry.getKey()));
        L11:
            return enabledComponent;
        }

        public List<ComponentName> getDefaultVrComponents() {
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.QUERY_ALL_PACKAGES", "Caller must hold android.permission.QUERY_ALL_PACKAGES");
            return new ArrayList(SystemConfig.getInstance().getDefaultVrComponents());
        }

        public List<String> getPreventUserDisablePackages() {
            final PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
            return (List) SystemConfig.getInstance().getPreventUserDisablePackages().stream().filter(new SystemConfigService$1$$ExternalSyntheticLambda1(pmi)).collect(Collectors.toList());
        }

        private static /* synthetic */ boolean lambda$getPreventUserDisablePackages$2(PackageManagerInternal pmi, String preventUserDisablePackage) {
            return pmi.canQueryPackage(Binder.getCallingUid(), preventUserDisablePackage);
        }

        public List<SignedPackageParcel> getEnhancedConfirmationTrustedPackages() {
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.MANAGE_ENHANCED_CONFIRMATION_STATES", "Caller must hold android.permission.MANAGE_ENHANCED_CONFIRMATION_STATES");
            return SystemConfig.getInstance().getEnhancedConfirmationTrustedPackages().stream().map(new SystemConfigService$1$$ExternalSyntheticLambda0()).toList();
        }

        public List<SignedPackageParcel> getEnhancedConfirmationTrustedInstallers() {
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.MANAGE_ENHANCED_CONFIRMATION_STATES", "Caller must hold android.permission.MANAGE_ENHANCED_CONFIRMATION_STATES");
            return SystemConfig.getInstance().getEnhancedConfirmationTrustedInstallers().stream().map(new SystemConfigService$1$$ExternalSyntheticLambda0()).toList();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m391$$Nest$fgetmContext(SystemConfigService r0) {
        return r0.mContext;
    }

    public SystemConfigService(Context context) {
        super(context);
        this.mInterface = new AnonymousClass1(this);
        this.mContext = context;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("system_config", this.mInterface);
    }
}
