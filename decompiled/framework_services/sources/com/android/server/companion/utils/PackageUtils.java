package com.android.server.companion.utils;

import android.R;
import android.app.ecm.EnhancedConfirmationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.os.Binder;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PackageUtils {
    private static final Intent COMPANION_SERVICE_INTENT = null;
    private static final String PROPERTY_PRIMARY_TAG = "android.companion.PROPERTY_PRIMARY_COMPANION_DEVICE_SERVICE";
    private static final String TAG = "CDM_PackageUtils";

    /* JADX INFO: renamed from: $r8$lambda$l3VcVK-VVbQBiUAquOE_YuuqIGY, reason: not valid java name */
    public static /* synthetic */ PackageInfo m2974$r8$lambda$l3VcVKVVbQBiUAquOE_YuuqIGY(PackageManager r0, String r1, PackageManager.PackageInfoFlags r2, int r3) {
        return lambda$getPackageInfo$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ List $r8$lambda$wvKrkgWPc_EZbyL_kj2nKjr_W4Y(String r0) {
        return lambda$getCompanionServicesForUser$1(r0);
    }

    public PackageUtils() {
    }

    static {
        COMPANION_SERVICE_INTENT = new Intent("android.companion.CompanionDeviceService");
    }

    public static PackageInfo getPackageInfo(Context context, final int userId, final String packageName) {
        final PackageManager pm = context.getPackageManager();
        final PackageManager.PackageInfoFlags flags = PackageManager.PackageInfoFlags.of(20480);
        return (PackageInfo) Binder.withCleanCallingIdentity(new PackageUtils$$ExternalSyntheticLambda1(pm, packageName, flags, userId));
    }

    private static /* synthetic */ PackageInfo lambda$getPackageInfo$0(PackageManager pm, String packageName, PackageManager.PackageInfoFlags flags, int userId) throws Exception {
        return pm.getPackageInfoAsUser(packageName, flags, userId);
    L5:
        Slog.e(TAG, "Package [" + packageName + "] is not found.");
        return null;
    }

    public static void enforceUsesCompanionDeviceFeature(Context context, int userId, String packageName) {
        if (Binder.getCallingUid() != 1000) goto L5;
        return;
    L5:
        PackageInfo packageInfo = getPackageInfo(context, userId, packageName);
        if (packageInfo == null) goto L19;
        FeatureInfo[] requestedFeatures = packageInfo.reqFeatures;
        if (requestedFeatures == null) goto L17;
        int r2 = requestedFeatures.length;
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L17;
        FeatureInfo requestedFeature = requestedFeatures[r3];
        if ("android.software.companion_device_setup".equals(requestedFeature.name) == true) goto L14;
        r3 = r3 + 1;
        goto L11
    L14:
        return;
    L17:
        throw new IllegalStateException("Must declare uses-feature android.software.companion_device_setup in manifest to use this API");
    L19:
        throw new IllegalArgumentException("Package " + packageName + " doesn't exist.");
    }

    public static Map<String, List<ComponentName>> getCompanionServicesForUser(Context context, int userId) {
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> companionServices = pm.queryIntentServicesAsUser(COMPANION_SERVICE_INTENT, PackageManager.ResolveInfoFlags.of(0), userId);
        Map<String, List<ComponentName>> packageNameToServiceInfoList = new HashMap(companionServices.size());
        Iterator<ResolveInfo> r3 = companionServices.iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        ResolveInfo resolveInfo = r3.next();
        ServiceInfo service = resolveInfo.serviceInfo;
        boolean requiresPermission = "android.permission.BIND_COMPANION_DEVICE_SERVICE".equals(resolveInfo.serviceInfo.permission);
        if (requiresPermission == false) goto L7;
        ArrayList<ComponentName> services = (ArrayList) packageNameToServiceInfoList.computeIfAbsent(service.packageName, new PackageUtils$$ExternalSyntheticLambda0());
        ComponentName componentName = service.getComponentName();
        if (isPrimaryCompanionDeviceService(pm, componentName, userId) == true) goto L10;
        services.add(componentName);
        goto L4
    L10:
        services.add(0, componentName);
        goto L4
    L7:
        Slog.w(TAG, "CompanionDeviceService " + service.getComponentName().flattenToShortString() + " must require android.permission.BIND_COMPANION_DEVICE_SERVICE");
        goto L4
    L13:
        return packageNameToServiceInfoList;
    }

    private static /* synthetic */ List lambda$getCompanionServicesForUser$1(String it) {
        return new ArrayList(1);
    }

    private static boolean isPrimaryCompanionDeviceService(PackageManager pm, ComponentName componentName, int userId) {
        return pm.getPropertyAsUser(PROPERTY_PRIMARY_TAG, componentName.getPackageName(), componentName.getClassName(), userId).getBoolean();
    L5:
        return false;
    }

    public static boolean isPackageAllowlisted(Context context, PackageManagerInternal packageManagerInternal, String packageName) {
        return isPackageAllowlisted(context, packageManagerInternal, packageName, R.array.config_deviceStatesOnWhichToSleep, R.array.config_deviceStatesAvailableForAppRequests);
    }

    public static boolean isPermSyncAutoEnabled(Context context, PackageManagerInternal packageManagerInternal, String packageName) {
        return isPackageAllowlisted(context, packageManagerInternal, packageName, R.array.config_deviceStatesToReverseDefaultDisplayRotationAroundZAxis, R.array.config_deviceStatesOnWhichToWakeUp);
    }

    private static boolean isPackageAllowlisted(Context context, PackageManagerInternal packageManagerInternal, String packageName, int packagesConfig, int certsConfig) {
        String[] allowlistedPackages = context.getResources().getStringArray(packagesConfig);
        int r2 = 0;
        if (ArrayUtils.contains(allowlistedPackages, packageName) == true) goto L6;
        Slog.d(TAG, packageName + " is not allowlisted.");
        return false;
    L6:
        String[] allowlistedPackagesSignatureDigests = context.getResources().getStringArray(certsConfig);
        Set<String> allowlistedSignatureDigestsForRequestingPackage = new HashSet();
        int i = 0;
    L8:
        if (i >= allowlistedPackages.length) goto L13;
        if (allowlistedPackages[i].equals(packageName) == false) goto L12;
        String digest = allowlistedPackagesSignatureDigests[i].replaceAll(":", "");
        allowlistedSignatureDigestsForRequestingPackage.add(digest);
    L12:
        i = i + 1;
        goto L8
    L13:
        Signature[] requestingPackageSignatures = packageManagerInternal.getPackage(packageName).getSigningDetails().getSignatures();
        String[] requestingPackageSignatureDigests = android.util.PackageUtils.computeSignaturesSha256Digests(requestingPackageSignatures);
        boolean requestingPackageSignatureAllowlisted = false;
        int r8 = requestingPackageSignatureDigests.length;
    L15:
        if (r2 >= r8) goto L20;
        String signatureDigest = requestingPackageSignatureDigests[r2];
        if (allowlistedSignatureDigestsForRequestingPackage.contains(signatureDigest) == true) goto L18;
        r2 = r2 + 1;
        goto L15
    L18:
        requestingPackageSignatureAllowlisted = true;
    L20:
        if (requestingPackageSignatureAllowlisted == true) goto L22;
        Slog.w(TAG, "Certificate mismatch for allowlisted package " + packageName);
    L22:
        return requestingPackageSignatureAllowlisted;
    }

    public static boolean isRestrictedSettingsAllowed(Context context, String packageName, int uid) {
        EnhancedConfirmationManager ecm = (EnhancedConfirmationManager) context.getSystemService(EnhancedConfirmationManager.class);
        return true ^ ecm.isRestricted(packageName, "android:access_notifications");
    L7:
        return true;
    }
}
