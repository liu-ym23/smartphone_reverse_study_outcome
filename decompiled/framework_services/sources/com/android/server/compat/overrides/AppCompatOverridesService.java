package com.android.server.compat.overrides;

import android.app.compat.PackageOverride;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.provider.DeviceConfig;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.compat.CompatibilityOverrideConfig;
import com.android.internal.compat.CompatibilityOverridesByPackageConfig;
import com.android.internal.compat.CompatibilityOverridesToRemoveByPackageConfig;
import com.android.internal.compat.CompatibilityOverridesToRemoveConfig;
import com.android.internal.compat.IPlatformCompat;
import com.android.server.SystemService;
import com.android.server.pm.Settings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatOverridesService {
    private static final List<String> SUPPORTED_NAMESPACES = null;
    private static final String TAG = "AppCompatOverridesService";
    private final Context mContext;
    private final List<DeviceConfigListener> mDeviceConfigListeners;
    private final AppCompatOverridesParser mOverridesParser;
    private final PackageManager mPackageManager;
    private final PackageReceiver mPackageReceiver;
    private final IPlatformCompat mPlatformCompat;
    private final List<String> mSupportedNamespaces;

    private final class DeviceConfigListener implements DeviceConfig.OnPropertiesChangedListener {
        private final Context mContext;
        private final String mNamespace;
        final /* synthetic */ AppCompatOverridesService this$0;

        /* JADX INFO: renamed from: -$$Nest$mregister, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3052$$Nest$mregister(DeviceConfigListener r0) {
            r0.register();
        }

        /* synthetic */ DeviceConfigListener(AppCompatOverridesService r1, Context r2, String r3, AppCompatOverridesServiceIA r4) {
            this(r1, r2, r3);
        }

        private DeviceConfigListener(AppCompatOverridesService r1, Context context, String namespace) {
            this.this$0 = r1;
            this.mContext = context;
            this.mNamespace = namespace;
        }

        private void register() {
            DeviceConfig.addOnPropertiesChangedListener(this.mNamespace, this.mContext.getMainExecutor(), this);
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            boolean removeOverridesFlagChanged = properties.getKeyset().contains("remove_overrides");
            boolean ownedChangedIdsFlagChanged = properties.getKeyset().contains("owned_change_ids");
            Set<Long> ownedChangeIds = AppCompatOverridesService.m3051$$Nest$smgetOwnedChangeIds(this.mNamespace);
            Map<String, Set<Long>> overridesToRemove = AppCompatOverridesService.m3047$$Nest$mgetOverridesToRemove(this.this$0, this.mNamespace, ownedChangeIds);
            if (removeOverridesFlagChanged == true) goto L5;
            if (ownedChangedIdsFlagChanged == true) goto L5;
        L6:
            if (removeOverridesFlagChanged == false) goto L8;
            AppCompatOverridesService.m3045$$Nest$mapplyAllOverrides(this.this$0, this.mNamespace, ownedChangeIds, overridesToRemove);
            return;
        L8:
            AppCompatOverridesService.m3046$$Nest$mapplyOverrides(this.this$0, properties, ownedChangeIds, overridesToRemove);
            return;
        L5:
            AppCompatOverridesService.m3050$$Nest$mremoveOverrides(this.this$0, overridesToRemove);
            goto L6
        }
    }

    public static final class Lifecycle extends SystemService {
        private AppCompatOverridesService mService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mService = new AppCompatOverridesService(getContext(), null);
            this.mService.registerDeviceConfigListeners();
            this.mService.registerPackageReceiver();
        }
    }

    private final class PackageReceiver extends BroadcastReceiver {
        private final Context mContext;
        private final IntentFilter mIntentFilter;
        final /* synthetic */ AppCompatOverridesService this$0;

        /* JADX INFO: renamed from: -$$Nest$mregister, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3053$$Nest$mregister(PackageReceiver r0) {
            r0.register();
        }

        /* synthetic */ PackageReceiver(AppCompatOverridesService r1, Context r2, AppCompatOverridesServiceIA r3) {
            this(r1, r2);
        }

        private PackageReceiver(AppCompatOverridesService r2, Context context) {
            this.this$0 = r2;
            this.mContext = context;
            this.mIntentFilter = new IntentFilter();
            this.mIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            this.mIntentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
            this.mIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            this.mIntentFilter.addDataScheme(Settings.ATTR_PACKAGE);
        }

        private void register() {
            this.mContext.registerReceiverForAllUsers(this, this.mIntentFilter, null, null);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Uri data = intent.getData();
            if (data != null) goto L6;
            Slog.w(AppCompatOverridesService.TAG, "Failed to get package name in package receiver");
            return;
        L6:
            String packageName = data.getSchemeSpecificPart();
            String action = intent.getAction();
            if (action != null) goto L11;
            Slog.w(AppCompatOverridesService.TAG, "Failed to get action in package receiver");
            return;
        L11:
            switch(action.hashCode()) {
                case 172491798: goto L20;
                case 525384130: goto L17;
                case 1544582882: goto L14;
                default: goto L22;
            };
        L22:
            byte r4 = -1;
        L23:
            switch(r4) {
                case 0: goto L28;
                case 1: goto L28;
                case 2: goto L26;
                default: goto L24;
            };
        L24:
            Slog.w(AppCompatOverridesService.TAG, "Unsupported action in package receiver: " + action);
            return;
        L28:
            AppCompatOverridesService.m3044$$Nest$maddAllPackageOverrides(this.this$0, packageName);
            return;
        L26:
            if (AppCompatOverridesService.m3048$$Nest$misInstalledForAnyUser(this.this$0, packageName) == true) goto L31;
            AppCompatOverridesService.m3049$$Nest$mremoveAllPackageOverrides(this.this$0, packageName);
            return;
        L31:
            return;
        L14:
            if (action.equals("android.intent.action.PACKAGE_ADDED") == false) goto L22;
            r4 = 0;
            goto L23
        L17:
            if (action.equals("android.intent.action.PACKAGE_REMOVED") == false) goto L22;
            r4 = 2;
            goto L23
        L20:
            if (action.equals("android.intent.action.PACKAGE_CHANGED") == false) goto L22;
            r4 = 1;
            goto L23
        }
    }

    /* JADX INFO: renamed from: -$$Nest$maddAllPackageOverrides, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3044$$Nest$maddAllPackageOverrides(AppCompatOverridesService r0, String r1) {
        r0.addAllPackageOverrides(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mapplyAllOverrides, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3045$$Nest$mapplyAllOverrides(AppCompatOverridesService r0, String r1, Set r2, Map r3) {
        r0.applyAllOverrides(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mapplyOverrides, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3046$$Nest$mapplyOverrides(AppCompatOverridesService r0, DeviceConfig.Properties r1, Set r2, Map r3) {
        r0.applyOverrides(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetOverridesToRemove, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m3047$$Nest$mgetOverridesToRemove(AppCompatOverridesService r0, String r1, Set r2) {
        return r0.getOverridesToRemove(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misInstalledForAnyUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3048$$Nest$misInstalledForAnyUser(AppCompatOverridesService r0, String r1) {
        return r0.isInstalledForAnyUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveAllPackageOverrides, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3049$$Nest$mremoveAllPackageOverrides(AppCompatOverridesService r0, String r1) {
        r0.removeAllPackageOverrides(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveOverrides, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3050$$Nest$mremoveOverrides(AppCompatOverridesService r0, Map r1) {
        r0.removeOverrides(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetOwnedChangeIds, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m3051$$Nest$smgetOwnedChangeIds(String r0) {
        return getOwnedChangeIds(r0);
    }

    /* synthetic */ AppCompatOverridesService(Context r1, AppCompatOverridesServiceIA r2) {
        this(r1);
    }

    static {
        SUPPORTED_NAMESPACES = Arrays.asList(new String[]{"app_compat_overrides"});
    }

    private AppCompatOverridesService(Context context) {
        this(context, IPlatformCompat.Stub.asInterface(ServiceManager.getService("platform_compat")), SUPPORTED_NAMESPACES);
    }

    AppCompatOverridesService(Context context, IPlatformCompat platformCompat, List<String> supportedNamespaces) {
        this.mContext = context;
        this.mPackageManager = this.mContext.getPackageManager();
        this.mPlatformCompat = platformCompat;
        this.mSupportedNamespaces = supportedNamespaces;
        this.mOverridesParser = new AppCompatOverridesParser(this.mPackageManager);
        AppCompatOverridesServiceIA r2 = null;
        this.mPackageReceiver = new PackageReceiver(this, this.mContext, r2);
        this.mDeviceConfigListeners = new ArrayList();
        Iterator<String> r0 = this.mSupportedNamespaces.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String namespace = r0.next();
        this.mDeviceConfigListeners.add(new DeviceConfigListener(this, this.mContext, namespace, r2));
        goto L4
    }

    void registerDeviceConfigListeners() {
        Iterator<DeviceConfigListener> r0 = this.mDeviceConfigListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DeviceConfigListener listener = r0.next();
        DeviceConfigListener.m3052$$Nest$mregister(listener);
        goto L4
    }

    void registerPackageReceiver() {
        PackageReceiver.m3053$$Nest$mregister(this.mPackageReceiver);
    }

    private void applyAllOverrides(String namespace, Set<Long> ownedChangeIds, Map<String, Set<Long>> packageToChangeIdsToSkip) {
        applyOverrides(DeviceConfig.getProperties(namespace, new String[0]), ownedChangeIds, packageToChangeIdsToSkip);
    }

    private void applyOverrides(DeviceConfig.Properties properties, Set<Long> ownedChangeIds, Map<String, Set<Long>> packageToChangeIdsToSkip) {
        Set<String> packageNames = new ArraySet(properties.getKeyset());
        packageNames.remove("owned_change_ids");
        packageNames.remove("remove_overrides");
        Map<String, CompatibilityOverrideConfig> packageNameToOverridesToAdd = new ArrayMap();
        Map<String, CompatibilityOverridesToRemoveConfig> packageNameToOverridesToRemove = new ArrayMap();
        Iterator<String> r3 = packageNames.iterator();
    L4:
        if (r3.hasNext() == false) goto L24;
        String packageName = r3.next();
        Set<Long> changeIdsToSkip = packageToChangeIdsToSkip.getOrDefault(packageName, Collections.emptySet());
        Map<Long, PackageOverride> overridesToAdd = Collections.emptyMap();
        Long versionCode = getVersionCodeOrNull(packageName);
        if (versionCode == null) goto L9;
        overridesToAdd = this.mOverridesParser.parsePackageOverrides(properties.getString(packageName, ""), packageName, versionCode.longValue(), changeIdsToSkip);
    L9:
        if (overridesToAdd.isEmpty() == true) goto L11;
        packageNameToOverridesToAdd.put(packageName, new CompatibilityOverrideConfig(overridesToAdd));
    L11:
        Set<Long> overridesToRemove = new ArraySet();
        Iterator<Long> r6 = ownedChangeIds.iterator();
    L13:
        if (r6.hasNext() == false) goto L21;
        Long changeId = r6.next();
        if (overridesToAdd.containsKey(changeId) == true) goto L13;
        if (changeIdsToSkip.contains(changeId) == true) goto L13;
        overridesToRemove.add(changeId);
        goto L13
    L21:
        if (overridesToRemove.isEmpty() == true) goto L4;
        packageNameToOverridesToRemove.put(packageName, new CompatibilityOverridesToRemoveConfig(overridesToRemove));
        goto L4
    L24:
        putAllPackageOverrides(packageNameToOverridesToAdd);
        removeAllPackageOverrides(packageNameToOverridesToRemove);
    }

    private void addAllPackageOverrides(String packageName) {
        Long versionCode = getVersionCodeOrNull(packageName);
        if (versionCode != null) goto L5;
        return;
    L5:
        Iterator<String> r1 = this.mSupportedNamespaces.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        String namespace = r1.next();
        Set<Long> ownedChangeIds = getOwnedChangeIds(namespace);
        AppCompatOverridesParser r4 = this.mOverridesParser;
        String r5 = DeviceConfig.getString(namespace, packageName, "");
        long r7 = versionCode.longValue();
        Set<Long> r9 = getOverridesToRemove(namespace, ownedChangeIds).getOrDefault(packageName, Collections.emptySet());
        String packageName2 = packageName;
        putPackageOverrides(packageName2, r4.parsePackageOverrides(r5, packageName2, r7, r9));
        packageName = packageName2;
        goto L7
    }

    private void removeAllPackageOverrides(String packageName) {
        Iterator<String> r0 = this.mSupportedNamespaces.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String namespace = r0.next();
        if (DeviceConfig.getString(namespace, packageName, "").isEmpty() == true) goto L4;
        removePackageOverrides(packageName, getOwnedChangeIds(namespace));
        goto L4
    }

    private void removeOverrides(Map<String, Set<Long>> packageNameToOverridesToRemove) {
        Map<String, CompatibilityOverridesToRemoveConfig> packageNameToConfig = new ArrayMap();
        Iterator<Map.Entry<String, Set<Long>>> r1 = packageNameToOverridesToRemove.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, Set<Long>> packageNameAndChangeIds = r1.next();
        packageNameToConfig.put(packageNameAndChangeIds.getKey(), new CompatibilityOverridesToRemoveConfig(packageNameAndChangeIds.getValue()));
        goto L4
    L6:
        removeAllPackageOverrides(packageNameToConfig);
    }

    private Map<String, Set<Long>> getOverridesToRemove(String namespace, Set<Long> ownedChangeIds) {
        return this.mOverridesParser.parseRemoveOverrides(DeviceConfig.getString(namespace, "remove_overrides", ""), ownedChangeIds);
    }

    private static Set<Long> getOwnedChangeIds(String namespace) {
        return AppCompatOverridesParser.parseOwnedChangeIds(DeviceConfig.getString(namespace, "owned_change_ids", ""));
    }

    private void putAllPackageOverrides(Map<String, CompatibilityOverrideConfig> packageNameToOverrides) {
        if (packageNameToOverrides.isEmpty() == false) goto L5;
        return;
    L5:
        CompatibilityOverridesByPackageConfig config = new CompatibilityOverridesByPackageConfig(packageNameToOverrides);
        this.mPlatformCompat.putAllOverridesOnReleaseBuilds(config);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to call IPlatformCompat#putAllOverridesOnReleaseBuilds", e);
    }

    private void putPackageOverrides(String packageName, Map<Long, PackageOverride> overridesToAdd) {
        if (overridesToAdd.isEmpty() == false) goto L5;
        return;
    L5:
        CompatibilityOverrideConfig config = new CompatibilityOverrideConfig(overridesToAdd);
        this.mPlatformCompat.putOverridesOnReleaseBuilds(config, packageName);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to call IPlatformCompat#putOverridesOnReleaseBuilds", e);
    }

    private void removeAllPackageOverrides(Map<String, CompatibilityOverridesToRemoveConfig> packageNameToOverridesToRemove) {
        if (packageNameToOverridesToRemove.isEmpty() == false) goto L5;
        return;
    L5:
        CompatibilityOverridesToRemoveByPackageConfig config = new CompatibilityOverridesToRemoveByPackageConfig(packageNameToOverridesToRemove);
        this.mPlatformCompat.removeAllOverridesOnReleaseBuilds(config);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to call IPlatformCompat#removeAllOverridesOnReleaseBuilds", e);
    }

    private void removePackageOverrides(String packageName, Set<Long> overridesToRemove) {
        if (overridesToRemove.isEmpty() == false) goto L5;
        return;
    L5:
        CompatibilityOverridesToRemoveConfig config = new CompatibilityOverridesToRemoveConfig(overridesToRemove);
        this.mPlatformCompat.removeOverridesOnReleaseBuilds(config, packageName);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to call IPlatformCompat#removeOverridesOnReleaseBuilds", e);
    }

    private boolean isInstalledForAnyUser(String packageName) {
        if (getVersionCodeOrNull(packageName) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private Long getVersionCodeOrNull(String packageName) {
        ApplicationInfo applicationInfo = this.mPackageManager.getApplicationInfo(packageName, 4194304);     // Catch: PackageManager.NameNotFoundException -> L4
        return Long.valueOf(applicationInfo.longVersionCode);
    L5:
        return null;
    }
}
