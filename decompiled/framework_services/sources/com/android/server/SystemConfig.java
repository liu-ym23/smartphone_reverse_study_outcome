package com.android.server;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.pm.FeatureInfo;
import android.content.pm.Signature;
import android.content.pm.SignedPackage;
import android.os.Build;
import android.os.CarrierAssociatedAppEntry;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Process;
import android.os.SystemProperties;
import android.os.VintfRuntimeInfo;
import android.os.incremental.IncrementalManager;
import android.os.storage.StorageManager;
import android.permission.PermissionManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimingsTraceLog;
import android.util.Xml;
import com.android.internal.pm.RoSystemFeatures;
import com.android.internal.pm.pkg.parsing.ParsingPackageUtils;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.build.UnboundedSdkLevel;
import com.android.server.am.HostingRecord;
import com.android.server.am.SettingsToPropertiesMapper;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.Settings;
import com.android.server.pm.permission.PermissionAllowlist;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import libcore.io.IoUtils;
import libcore.util.EmptyArray;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class SystemConfig {
    private static final int ALLOW_ALL = -1;
    private static final int ALLOW_APP_CONFIGS = 8;
    private static final int ALLOW_ASSOCIATIONS = 128;
    private static final int ALLOW_FEATURES = 1;
    private static final int ALLOW_HIDDENAPI_WHITELISTING = 64;
    private static final int ALLOW_IMPLICIT_BROADCASTS = 512;
    private static final int ALLOW_LIBS = 2;
    private static final int ALLOW_OEM_PERMISSIONS = 32;
    private static final int ALLOW_OVERRIDE_APP_RESTRICTIONS = 256;
    private static final int ALLOW_PERMISSIONS = 4;
    private static final int ALLOW_PRIVAPP_PERMISSIONS = 16;
    private static final int ALLOW_SIGNATURE_PERMISSIONS = 2048;
    private static final int ALLOW_VENDOR_APEX = 1024;
    private static final ArrayMap<String, ArraySet<String>> EMPTY_PERMISSIONS = null;
    private static final String NO_RIL_PROPERTY = "ro.radio.noril";
    private static final String PRODUCT_SKU_PROPERTY = "ro.boot.hardware.sku";
    private static final String SKU_PROPERTY = "ro.boot.product.hardware.sku";
    static final String TAG = "SystemConfig";
    private static final String VENDOR_SKU_PROPERTY = "ro.boot.product.vendor.sku";
    static SystemConfig sInstance;
    final ArrayMap<String, ArraySet<String>> mAllowAdasSettings;
    final ArrayMap<String, ArraySet<String>> mAllowIgnoreLocationSettings;
    final ArraySet<String> mAllowImplicitBroadcasts;
    final ArraySet<String> mAllowInDataUsageSave;
    final ArraySet<String> mAllowInPowerSave;
    final ArraySet<String> mAllowInPowerSaveExceptIdle;
    final ArraySet<String> mAllowUnthrottledLocation;
    final ArrayMap<String, ArraySet<String>> mAllowedAssociations;
    private final ArrayMap<String, String> mAllowedVendorApexes;
    final ArraySet<String> mAllowlistCameraPrivacy;
    private final ArraySet<String> mAppDataIsolationWhitelistedApps;
    private final ArrayMap<String, String> mAppMetadataFilePaths;
    final ArrayMap<String, FeatureInfo> mAvailableFeatures;
    final ArraySet<ComponentName> mBackupTransportWhitelist;
    final ArraySet<String> mBgRestrictionExemption;
    private final ArraySet<String> mBugreportWhitelistedPackages;
    final ArraySet<ComponentName> mDefaultVrComponents;
    final ArraySet<String> mDisabledUntilUsedPreinstalledCarrierApps;
    final ArrayMap<String, List<CarrierAssociatedAppEntry>> mDisabledUntilUsedPreinstalledCarrierAssociatedApps;
    private final ArraySet<SignedPackage> mEnhancedConfirmationTrustedInstallers;
    private final ArraySet<SignedPackage> mEnhancedConfirmationTrustedPackages;
    int[] mGlobalGids;
    final ArraySet<String> mHiddenApiPackageWhitelist;
    private final Set<String> mInitialNonStoppedSystemPackages;
    private final Injector mInjector;
    private final Set<String> mInstallConstraintsAllowlist;
    final ArraySet<String> mLinkedApps;
    private String mModulesInstallerPackageName;
    private Map<String, Map<String, String>> mNamedActors;
    private final ArrayMap<String, Integer> mOemDefinedUids;
    private String mOverlayConfigSignaturePackage;
    final ArrayMap<String, ArrayMap<String, Boolean>> mPackageComponentEnabledState;
    private final ArrayMap<String, String> mPackageToSharedUidAllowList;
    private ArrayMap<String, Set<String>> mPackageToUserTypeBlacklist;
    private ArrayMap<String, Set<String>> mPackageToUserTypeWhitelist;
    private final PermissionAllowlist mPermissionAllowlist;
    final ArrayMap<String, PermissionEntry> mPermissions;
    private final Set<String> mPreinstallPackagesWithStrictSignatureCheck;
    private final ArrayList<String> mPreventUserDisablePackages;
    private ArrayMap<String, Set<String>> mQtiAllowImplicitBroadcasts;
    private final ArraySet<String> mRollbackWhitelistedPackages;
    final ArrayMap<String, SharedLibraryEntry> mSharedLibraries;
    final ArrayList<PermissionManager.SplitPermissionInfo> mSplitPermissions;
    final SparseArray<ArraySet<String>> mSystemPermissions;
    final ArraySet<String> mUnavailableFeatures;
    private final ArrayMap<String, String> mUpdateOwnersForSystemApps;
    private final ArraySet<String> mWhitelistedStagedInstallers;

    public static class Injector {
        public Injector() {
        }

        public boolean isReadOnlySystemEnabledFeature(String featureName, int version) {
            return Boolean.TRUE.equals(RoSystemFeatures.maybeHasFeature(featureName, version));
        }

        public boolean isReadOnlySystemDisabledFeature(String featureName, int version) {
            return Boolean.FALSE.equals(RoSystemFeatures.maybeHasFeature(featureName, version));
        }

        public ArrayMap<String, FeatureInfo> getReadOnlySystemEnabledFeatures() {
            return RoSystemFeatures.getReadOnlySystemEnabledFeatures();
        }
    }

    public static final class PermissionEntry {
        public int[] gids;
        public final String name;
        public boolean perUser;

        PermissionEntry(String name, boolean perUser) {
            this.name = name;
            this.perUser = perUser;
        }
    }

    public static final class SharedLibraryEntry {
        public final boolean canBeSafelyIgnored;
        public final String[] dependencies;
        public final String filename;
        public final boolean isNative;
        public final String name;
        public final String onBootclasspathBefore;
        public final String onBootclasspathSince;

        public SharedLibraryEntry(String name, String filename, String[] dependencies, boolean isNative) {
            this(name, filename, dependencies, null, null, isNative);
        }

        public SharedLibraryEntry(String name, String filename, String[] dependencies, String onBootclasspathSince, String onBootclasspathBefore) {
            this(name, filename, dependencies, onBootclasspathSince, onBootclasspathBefore, false);
        }

        SharedLibraryEntry(String name, String filename, String[] dependencies, String onBootclasspathSince, String onBootclasspathBefore, boolean isNative) {
            this.name = name;
            this.filename = filename;
            this.dependencies = dependencies;
            this.onBootclasspathSince = onBootclasspathSince;
            this.onBootclasspathBefore = onBootclasspathBefore;
            this.isNative = isNative;
            if (this.onBootclasspathSince == null) goto L7;
            if (SystemConfig.m390$$Nest$smisAtLeastSdkLevel(this.onBootclasspathSince) == false) goto L7;
        L10:
            boolean r0 = true;
        L12:
            this.canBeSafelyIgnored = r0;
            return;
        L7:
            if (this.onBootclasspathBefore != null) goto L9;
        L11:
            r0 = false;
            goto L12
        L9:
            if (SystemConfig.m390$$Nest$smisAtLeastSdkLevel(this.onBootclasspathBefore) == true) goto L11;
            goto L10
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smisAtLeastSdkLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m390$$Nest$smisAtLeastSdkLevel(String r0) {
        return isAtLeastSdkLevel(r0);
    }

    static {
        EMPTY_PERMISSIONS = new ArrayMap();
    }

    private static boolean isAtLeastSdkLevel(String version) {
        return UnboundedSdkLevel.isAtLeast(version);
    L5:
        return false;
    }

    private static boolean isAtMostSdkLevel(String version) {
        return UnboundedSdkLevel.isAtMost(version);
    L5:
        return true;
    }

    public static SystemConfig getInstance() {
        if (isSystemProcess() == true) goto L6;
        Slog.wtf(TAG, "SystemConfig is being accessed by a process other than system_server.");
    L6:
        monitor-enter(SystemConfig.class);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (sInstance != null) goto L12;
        sInstance = new SystemConfig();     // Catch: Throwable -> L10
    L12:
        SystemConfig r1 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(SystemConfig.class);     // Catch: Throwable -> L10
        return r1;
    }

    public int[] getGlobalGids() {
        return this.mGlobalGids;
    }

    public SparseArray<ArraySet<String>> getSystemPermissions() {
        return this.mSystemPermissions;
    }

    public ArrayList<PermissionManager.SplitPermissionInfo> getSplitPermissions() {
        return this.mSplitPermissions;
    }

    public ArrayMap<String, SharedLibraryEntry> getSharedLibraries() {
        return this.mSharedLibraries;
    }

    public ArrayMap<String, FeatureInfo> getAvailableFeatures() {
        return this.mAvailableFeatures;
    }

    public ArrayMap<String, PermissionEntry> getPermissions() {
        return this.mPermissions;
    }

    public ArraySet<String> getAllowImplicitBroadcasts() {
        return this.mAllowImplicitBroadcasts;
    }

    public ArraySet<String> getAllowInPowerSaveExceptIdle() {
        return this.mAllowInPowerSaveExceptIdle;
    }

    public ArraySet<String> getAllowInPowerSave() {
        return this.mAllowInPowerSave;
    }

    public ArraySet<String> getAllowInDataUsageSave() {
        return this.mAllowInDataUsageSave;
    }

    public ArraySet<String> getAllowUnthrottledLocation() {
        return this.mAllowUnthrottledLocation;
    }

    public ArrayMap<String, ArraySet<String>> getAllowAdasLocationSettings() {
        return this.mAllowAdasSettings;
    }

    public ArrayMap<String, ArraySet<String>> getAllowIgnoreLocationSettings() {
        return this.mAllowIgnoreLocationSettings;
    }

    public ArraySet<String> getBgRestrictionExemption() {
        return this.mBgRestrictionExemption;
    }

    public ArraySet<String> getLinkedApps() {
        return this.mLinkedApps;
    }

    public ArraySet<String> getHiddenApiWhitelistedApps() {
        return this.mHiddenApiPackageWhitelist;
    }

    public ArraySet<ComponentName> getDefaultVrComponents() {
        return this.mDefaultVrComponents;
    }

    public ArraySet<ComponentName> getBackupTransportWhitelist() {
        return this.mBackupTransportWhitelist;
    }

    public ArrayMap<String, Boolean> getComponentsEnabledStates(String packageName) {
        return this.mPackageComponentEnabledState.get(packageName);
    }

    public ArraySet<String> getDisabledUntilUsedPreinstalledCarrierApps() {
        return this.mDisabledUntilUsedPreinstalledCarrierApps;
    }

    public ArrayMap<String, List<CarrierAssociatedAppEntry>> getDisabledUntilUsedPreinstalledCarrierAssociatedApps() {
        return this.mDisabledUntilUsedPreinstalledCarrierAssociatedApps;
    }

    public PermissionAllowlist getPermissionAllowlist() {
        return this.mPermissionAllowlist;
    }

    public ArrayMap<String, ArraySet<String>> getAllowedAssociations() {
        return this.mAllowedAssociations;
    }

    public ArraySet<String> getCameraPrivacyAllowlist() {
        return this.mAllowlistCameraPrivacy;
    }

    public ArraySet<String> getBugreportWhitelistedPackages() {
        return this.mBugreportWhitelistedPackages;
    }

    public Set<String> getRollbackWhitelistedPackages() {
        return this.mRollbackWhitelistedPackages;
    }

    public Set<String> getWhitelistedStagedInstallers() {
        return this.mWhitelistedStagedInstallers;
    }

    public Map<String, String> getAllowedVendorApexes() {
        return this.mAllowedVendorApexes;
    }

    public Set<String> getInstallConstraintsAllowlist() {
        return this.mInstallConstraintsAllowlist;
    }

    public String getModulesInstallerPackageName() {
        return this.mModulesInstallerPackageName;
    }

    public String getSystemAppUpdateOwnerPackageName(String packageName) {
        return this.mUpdateOwnersForSystemApps.get(packageName);
    }

    public ArraySet<String> getAppDataIsolationWhitelistedApps() {
        return this.mAppDataIsolationWhitelistedApps;
    }

    public ArrayList<String> getPreventUserDisablePackages() {
        return this.mPreventUserDisablePackages;
    }

    public ArrayMap<String, Set<String>> getAndClearPackageToUserTypeWhitelist() {
        ArrayMap<String, Set<String>> r = this.mPackageToUserTypeWhitelist;
        this.mPackageToUserTypeWhitelist = new ArrayMap(0);
        return r;
    }

    public ArrayMap<String, Set<String>> getQtiAllowImplicitBroadcasts() {
        ArrayMap<String, Set<String>> r = this.mQtiAllowImplicitBroadcasts;
        this.mQtiAllowImplicitBroadcasts = new ArrayMap(0);
        return r;
    }

    public ArrayMap<String, Set<String>> getAndClearPackageToUserTypeBlacklist() {
        ArrayMap<String, Set<String>> r = this.mPackageToUserTypeBlacklist;
        this.mPackageToUserTypeBlacklist = new ArrayMap(0);
        return r;
    }

    public Map<String, Map<String, String>> getNamedActors() {
        if (this.mNamedActors == null) goto L6;
        return this.mNamedActors;
    L6:
        return Collections.emptyMap();
    }

    public String getOverlayConfigSignaturePackage() {
        if (TextUtils.isEmpty(this.mOverlayConfigSignaturePackage) == false) goto L6;
        return null;
    L6:
        return this.mOverlayConfigSignaturePackage;
    }

    public Set<String> getInitialNonStoppedSystemPackages() {
        return this.mInitialNonStoppedSystemPackages;
    }

    public ArrayMap<String, String> getPackageToSharedUidAllowList() {
        return this.mPackageToSharedUidAllowList;
    }

    public ArrayMap<String, String> getAppMetadataFilePaths() {
        return this.mAppMetadataFilePaths;
    }

    public Set<String> getPreinstallPackagesWithStrictSignatureCheck() {
        return this.mPreinstallPackagesWithStrictSignatureCheck;
    }

    public ArraySet<SignedPackage> getEnhancedConfirmationTrustedPackages() {
        return this.mEnhancedConfirmationTrustedPackages;
    }

    public ArraySet<SignedPackage> getEnhancedConfirmationTrustedInstallers() {
        return this.mEnhancedConfirmationTrustedInstallers;
    }

    public ArrayMap<String, Integer> getOemDefinedUids() {
        return this.mOemDefinedUids;
    }

    public SystemConfig(boolean readPermissions) {
        this(readPermissions, new Injector());
    }

    public SystemConfig(boolean readPermissions, Injector injector) {
        this.mGlobalGids = EmptyArray.INT;
        this.mSystemPermissions = new SparseArray();
        this.mSplitPermissions = new ArrayList();
        this.mSharedLibraries = new ArrayMap();
        this.mUnavailableFeatures = new ArraySet();
        this.mPermissions = new ArrayMap();
        this.mAllowInPowerSaveExceptIdle = new ArraySet();
        this.mAllowInPowerSave = new ArraySet();
        this.mAllowInDataUsageSave = new ArraySet();
        this.mAllowUnthrottledLocation = new ArraySet();
        this.mAllowAdasSettings = new ArrayMap();
        this.mAllowIgnoreLocationSettings = new ArrayMap();
        this.mAllowlistCameraPrivacy = new ArraySet();
        this.mAllowImplicitBroadcasts = new ArraySet();
        this.mBgRestrictionExemption = new ArraySet();
        this.mLinkedApps = new ArraySet();
        this.mDefaultVrComponents = new ArraySet();
        this.mBackupTransportWhitelist = new ArraySet();
        this.mPackageComponentEnabledState = new ArrayMap();
        this.mHiddenApiPackageWhitelist = new ArraySet();
        this.mDisabledUntilUsedPreinstalledCarrierApps = new ArraySet();
        this.mDisabledUntilUsedPreinstalledCarrierAssociatedApps = new ArrayMap();
        this.mPermissionAllowlist = new PermissionAllowlist();
        this.mAllowedAssociations = new ArrayMap();
        this.mBugreportWhitelistedPackages = new ArraySet();
        this.mAppDataIsolationWhitelistedApps = new ArraySet();
        this.mPreventUserDisablePackages = new ArrayList();
        this.mPackageToUserTypeWhitelist = new ArrayMap();
        this.mPackageToUserTypeBlacklist = new ArrayMap();
        this.mQtiAllowImplicitBroadcasts = new ArrayMap();
        this.mRollbackWhitelistedPackages = new ArraySet();
        this.mWhitelistedStagedInstallers = new ArraySet();
        this.mAllowedVendorApexes = new ArrayMap();
        this.mInstallConstraintsAllowlist = new ArraySet();
        this.mUpdateOwnersForSystemApps = new ArrayMap();
        this.mInitialNonStoppedSystemPackages = new ArraySet();
        this.mPackageToSharedUidAllowList = new ArrayMap();
        this.mAppMetadataFilePaths = new ArrayMap();
        this.mPreinstallPackagesWithStrictSignatureCheck = new ArraySet();
        this.mEnhancedConfirmationTrustedPackages = new ArraySet();
        this.mEnhancedConfirmationTrustedInstallers = new ArraySet();
        this.mOemDefinedUids = new ArrayMap();
        this.mNamedActors = null;
        this.mInjector = injector;
        this.mAvailableFeatures = this.mInjector.getReadOnlySystemEnabledFeatures();
        if (readPermissions == false) goto L5;
        Slog.w(TAG, "Constructing a test SystemConfig");
        readAllPermissions();
        return;
    L5:
        Slog.w(TAG, "Constructing an empty test SystemConfig");
    }

    SystemConfig() {
        this.mGlobalGids = EmptyArray.INT;
        this.mSystemPermissions = new SparseArray();
        this.mSplitPermissions = new ArrayList();
        this.mSharedLibraries = new ArrayMap();
        this.mUnavailableFeatures = new ArraySet();
        this.mPermissions = new ArrayMap();
        this.mAllowInPowerSaveExceptIdle = new ArraySet();
        this.mAllowInPowerSave = new ArraySet();
        this.mAllowInDataUsageSave = new ArraySet();
        this.mAllowUnthrottledLocation = new ArraySet();
        this.mAllowAdasSettings = new ArrayMap();
        this.mAllowIgnoreLocationSettings = new ArrayMap();
        this.mAllowlistCameraPrivacy = new ArraySet();
        this.mAllowImplicitBroadcasts = new ArraySet();
        this.mBgRestrictionExemption = new ArraySet();
        this.mLinkedApps = new ArraySet();
        this.mDefaultVrComponents = new ArraySet();
        this.mBackupTransportWhitelist = new ArraySet();
        this.mPackageComponentEnabledState = new ArrayMap();
        this.mHiddenApiPackageWhitelist = new ArraySet();
        this.mDisabledUntilUsedPreinstalledCarrierApps = new ArraySet();
        this.mDisabledUntilUsedPreinstalledCarrierAssociatedApps = new ArrayMap();
        this.mPermissionAllowlist = new PermissionAllowlist();
        this.mAllowedAssociations = new ArrayMap();
        this.mBugreportWhitelistedPackages = new ArraySet();
        this.mAppDataIsolationWhitelistedApps = new ArraySet();
        this.mPreventUserDisablePackages = new ArrayList();
        this.mPackageToUserTypeWhitelist = new ArrayMap();
        this.mPackageToUserTypeBlacklist = new ArrayMap();
        this.mQtiAllowImplicitBroadcasts = new ArrayMap();
        this.mRollbackWhitelistedPackages = new ArraySet();
        this.mWhitelistedStagedInstallers = new ArraySet();
        this.mAllowedVendorApexes = new ArrayMap();
        this.mInstallConstraintsAllowlist = new ArraySet();
        this.mUpdateOwnersForSystemApps = new ArrayMap();
        this.mInitialNonStoppedSystemPackages = new ArraySet();
        this.mPackageToSharedUidAllowList = new ArrayMap();
        this.mAppMetadataFilePaths = new ArrayMap();
        this.mPreinstallPackagesWithStrictSignatureCheck = new ArraySet();
        this.mEnhancedConfirmationTrustedPackages = new ArraySet();
        this.mEnhancedConfirmationTrustedInstallers = new ArraySet();
        this.mOemDefinedUids = new ArrayMap();
        this.mNamedActors = null;
        this.mInjector = new Injector();
        this.mAvailableFeatures = this.mInjector.getReadOnlySystemEnabledFeatures();
        TimingsTraceLog log = new TimingsTraceLog(TAG, 524288);
        log.traceBegin("readAllPermissions");
        readAllPermissions();     // Catch: Throwable -> L6
        readPublicNativeLibrariesList();     // Catch: Throwable -> L6
        log.traceEnd();
        return;
    L6:
        th = move-exception;
        log.traceEnd();
        throw th;
    }

    private void readAllPermissions() {
        readAllPermissionsFromXml();
        readAllPermissionsFromEnvironment();
        Iterator<String> r0 = this.mUnavailableFeatures.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String featureName = r0.next();
        removeFeature(featureName);
        goto L4
    }

    private void readAllPermissionsFromXml() {
        XmlPullParser parser = Xml.newPullParser();
        readPermissions(parser, Environment.buildPath(Environment.getRootDirectory(), new String[]{"etc", "sysconfig"}), -1);
        readPermissions(parser, Environment.buildPath(Environment.getRootDirectory(), new String[]{"etc", "permissions"}), -1);
        int vendorPermissionFlag = 3219;
        if (Build.VERSION.DEVICE_INITIAL_SDK_INT > 27) goto L5;
        vendorPermissionFlag = 3219 | 12;
    L5:
        readPermissions(parser, Environment.buildPath(Environment.getVendorDirectory(), new String[]{"etc", "sysconfig"}), vendorPermissionFlag);
        readPermissions(parser, Environment.buildPath(Environment.getVendorDirectory(), new String[]{"etc", "permissions"}), vendorPermissionFlag);
        String vendorSkuProperty = SystemProperties.get(VENDOR_SKU_PROPERTY, "");
        if (vendorSkuProperty.isEmpty() == true) goto L8;
        String vendorSkuDir = "sku_" + vendorSkuProperty;
        readPermissions(parser, Environment.buildPath(Environment.getVendorDirectory(), new String[]{"etc", "sysconfig", vendorSkuDir}), vendorPermissionFlag);
        readPermissions(parser, Environment.buildPath(Environment.getVendorDirectory(), new String[]{"etc", "permissions", vendorSkuDir}), vendorPermissionFlag);
    L8:
        boolean noRilSupport = SystemProperties.getBoolean(NO_RIL_PROPERTY, false);
        if (noRilSupport == false) goto L11;
        readPermissions(parser, Environment.buildPath(Environment.getVendorDirectory(), new String[]{"etc", "sysconfig", "noRil"}), vendorPermissionFlag);
        readPermissions(parser, Environment.buildPath(Environment.getVendorDirectory(), new String[]{"etc", "permissions", "noRil"}), vendorPermissionFlag);
    L11:
        int odmPermissionFlag = vendorPermissionFlag;
        readPermissions(parser, Environment.buildPath(Environment.getOdmDirectory(), new String[]{"etc", "sysconfig"}), odmPermissionFlag);
        readPermissions(parser, Environment.buildPath(Environment.getOdmDirectory(), new String[]{"etc", "permissions"}), odmPermissionFlag);
        String skuProperty = SystemProperties.get(SKU_PROPERTY, "");
        if (skuProperty.isEmpty() == true) goto L14;
        String skuDir = "sku_" + skuProperty;
        readPermissions(parser, Environment.buildPath(Environment.getOdmDirectory(), new String[]{"etc", "sysconfig", skuDir}), odmPermissionFlag);
        readPermissions(parser, Environment.buildPath(Environment.getOdmDirectory(), new String[]{"etc", "permissions", skuDir}), odmPermissionFlag);
    L14:
        readPermissions(parser, Environment.buildPath(Environment.getOemDirectory(), new String[]{"etc", "sysconfig"}), 1185);
        readPermissions(parser, Environment.buildPath(Environment.getOemDirectory(), new String[]{"etc", "permissions"}), 1185);
        int productPermissionFlag = 4063;
        if (Build.VERSION.DEVICE_INITIAL_SDK_INT > 30) goto L17;
        productPermissionFlag = -1;
    L17:
        readPermissions(parser, Environment.buildPath(Environment.getProductDirectory(), new String[]{"etc", "sysconfig"}), productPermissionFlag);
        readPermissions(parser, Environment.buildPath(Environment.getProductDirectory(), new String[]{"etc", "permissions"}), productPermissionFlag);
        String productSkuProperty = SystemProperties.get(PRODUCT_SKU_PROPERTY, "");
        if (productSkuProperty.isEmpty() == true) goto L20;
        String productSkuDir = "sku_" + productSkuProperty;
        readPermissions(parser, Environment.buildPath(Environment.getProductDirectory(), new String[]{"etc", "sysconfig", productSkuDir}), productPermissionFlag);
        readPermissions(parser, Environment.buildPath(Environment.getProductDirectory(), new String[]{"etc", "permissions", productSkuDir}), productPermissionFlag);
    L20:
        readPermissions(parser, Environment.buildPath(Environment.getSystemExtDirectory(), new String[]{"etc", "sysconfig"}), -1);
        readPermissions(parser, Environment.buildPath(Environment.getSystemExtDirectory(), new String[]{"etc", "permissions"}), -1);
        if (isSystemProcess() == true) goto L23;
        return;
    L23:
        File[] r8 = FileUtils.listFilesOrEmpty(Environment.getApexDirectory());
        int r10 = r8.length;
        int r15 = 0;
    L24:
        if (r15 >= r10) goto L33;
        int vendorPermissionFlag2 = vendorPermissionFlag;
        File f = r8[r15];
        if (f.isFile() == true) goto L31;
        String productSkuProperty2 = productSkuProperty;
        String vendorSkuProperty2 = vendorSkuProperty;
        if (f.getPath().contains("@") == true) goto L32;
        readPermissions(parser, Environment.buildPath(f, new String[]{"etc", "permissions"}), 2067);
    L32:
        r15 = r15 + 1;
        vendorPermissionFlag = vendorPermissionFlag2;
        productSkuProperty = productSkuProperty2;
        vendorSkuProperty = vendorSkuProperty2;
        goto L24
    L31:
        productSkuProperty2 = productSkuProperty;
        vendorSkuProperty2 = vendorSkuProperty;
        goto L32
    }

    public void readPermissions(XmlPullParser parser, File libraryDir, int permissionFlag) {
        if (libraryDir.exists() == false) goto L31;
        if (libraryDir.isDirectory() == false) goto L31;
        if (libraryDir.canRead() == true) goto L11;
        Slog.w(TAG, "Directory " + libraryDir + " cannot be read");
        return;
    L11:
        File platformFile = null;
        File[] r3 = libraryDir.listFiles();
        int r4 = r3.length;
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L27;
        File f = r3[r5];
        if (f.isFile() == false) goto L26;
        if (f.getPath().endsWith("etc/permissions/platform.xml") == false) goto L20;
        platformFile = f;
        goto L26
    L20:
        if (f.getPath().endsWith(".xml") == true) goto L23;
        Slog.i(TAG, "Non-xml file " + f + " in " + libraryDir + " directory, ignoring");
        goto L26
    L23:
        if (f.canRead() == true) goto L25;
        Slog.w(TAG, "Permissions library file " + f + " cannot be read");
        goto L26
    L25:
        readPermissionsFromXml(parser, f, permissionFlag);
    L26:
        r5 = r5 + 1;
        goto L12
    L27:
        if (platformFile == null) goto L40;
        readPermissionsFromXml(parser, platformFile, permissionFlag);
        return;
    L40:
        return;
    L31:
        if (permissionFlag != (-1)) goto L41;
        Slog.w(TAG, "No directory " + libraryDir + ", skipping");
        return;
    }

    private void logNotAllowedInPartition(String name, File permFile, XmlPullParser parser) {
        Slog.w(TAG, "<" + name + "> not allowed in partition of " + permFile + " at " + parser.getPositionDescription());
    }

    private void readPermissionsFromXml(XmlPullParser parser, File permFile, int permissionFlag) {
        FileReader permReader = new FileReader(permFile);     // Catch: FileNotFoundException -> L743
        Slog.i(TAG, "Reading permissions from " + permFile);
        boolean lowRam = ActivityManager.isLowRamDeviceStatic();
        parser.setInput(permReader);     // Catch: Throwable -> L726 IOException -> L728 XmlPullParserException -> L730
    L6:
        int r0 = parser.next();     // Catch: Throwable -> L726 IOException -> L728 XmlPullParserException -> L730
        int type = r0;
        int r10 = 1;
        if (r0 == 2) goto L753;
        if (type != 1) goto L6;
    L753:
        if (type != 2) goto L733;
        if (parser.getName().equals("permissions") == true) goto L24;
    L20:
        e = e;
        FileReader permReader2 = permReader;
    L735:
        Slog.w(TAG, "Got exception parsing permissions.", e);     // Catch: Throwable -> L240
    L736:
        IoUtils.closeQuietly(permReader2);
        return;
    L22:
        e = e;
        permReader2 = permReader;
    L738:
        Slog.w(TAG, "Got exception parsing permissions.", e);     // Catch: Throwable -> L240
    L18:
        th = th;
        FileReader permReader3 = permReader;
    L741:
        IoUtils.closeQuietly(permReader3);
        throw th;
    L14:
        if (parser.getName().equals("config") == true) goto L24;
        throw new XmlPullParserException("Unexpected start tag in " + permFile + ": found " + parser.getName() + ", expected 'permissions' or 'config'");     // Catch: Throwable -> L18 IOException -> L20 XmlPullParserException -> L22
    L24:
        int r11 = -1;
        if (permissionFlag != (-1)) goto L27;
        boolean r1 = true;
    L28:
        boolean allowAll = r1;
        if ((permissionFlag & 2) == 0) goto L31;
        boolean r2 = true;
    L32:
        boolean allowLibs = r2;
        if ((permissionFlag & 1) == 0) goto L35;
        boolean r3 = true;
    L36:
        boolean allowFeatures = r3;
        if ((permissionFlag & 4) == 0) goto L39;
        boolean r4 = true;
    L40:
        boolean allowPermissions = r4;
        if ((permissionFlag & 8) == 0) goto L43;
        boolean r5 = true;
    L44:
        boolean allowAppConfigs = r5;
        if ((permissionFlag & 16) == 0) goto L47;
        boolean r6 = true;
    L48:
        boolean allowPrivappPermissions = r6;
        if ((permissionFlag & 2048) == 0) goto L51;
        boolean r7 = true;
    L52:
        boolean allowSignaturePermissions = r7;
        if ((permissionFlag & 32) == 0) goto L55;
        boolean r8 = true;
    L56:
        boolean allowOemPermissions = r8;
        if ((permissionFlag & 64) == 0) goto L59;
        boolean r9 = true;
    L60:
        boolean allowApiWhitelisting = r9;
        if ((permissionFlag & 128) == 0) goto L63;
        boolean r12 = true;
    L64:
        boolean allowAssociations = r12;
        if ((permissionFlag & 256) == 0) goto L67;
        boolean r13 = true;
    L68:
        boolean allowOverrideAppRestrictions = r13;
        if ((permissionFlag & 512) == 0) goto L71;
        boolean r14 = true;
    L72:
        boolean allowImplicitBroadcasts = r14;
        if ((permissionFlag & 1024) == 0) goto L75;
        boolean r15 = true;
    L76:
        boolean allowVendorApex = r15;
    L77:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L726 IOException -> L728 XmlPullParserException -> L730
        if (parser.getEventType() == r10) goto L79;
        String name = parser.getName();     // Catch: Throwable -> L726 IOException -> L728 XmlPullParserException -> L730
        if (name == null) goto L83;
        switch(name.hashCode()) {
            case -2110956849: goto L232;
            case -2040330235: goto L229;
            case -1882490007: goto L226;
            case -1602953450: goto L223;
            case -1582324217: goto L220;
            case -1554938271: goto L217;
            case -1461465444: goto L214;
            case -1390350881: goto L211;
            case -1205451484: goto L208;
            case -1005864890: goto L205;
            case -980620291: goto L202;
            case -979207434: goto L199;
            case -828905863: goto L196;
            case -642819164: goto L193;
            case -634266752: goto L190;
            case -625731345: goto L187;
            case -560717308: goto L184;
            case -517618225: goto L181;
            case -199241498: goto L178;
            case -150068154: goto L175;
            case -5781715: goto L172;
            case 72567535: goto L169;
            case 98629247: goto L166;
            case 166208699: goto L163;
            case 176950812: goto L160;
            case 180165796: goto L157;
            case 347247519: goto L154;
            case 357860339: goto L151;
            case 414198242: goto L148;
            case 783200107: goto L145;
            case 802332808: goto L142;
            case 953292141: goto L139;
            case 968751633: goto L136;
            case 1005096720: goto L133;
            case 1044015374: goto L130;
            case 1046683496: goto L127;
            case 1116987345: goto L124;
            case 1121420326: goto L121;
            case 1269564002: goto L118;
            case 1347585732: goto L115;
            case 1514510232: goto L112;
            case 1567330472: goto L109;
            case 1633270165: goto L106;
            case 1723146313: goto L103;
            case 1723586945: goto L100;
            case 1748566401: goto L97;
            case 1793277898: goto L94;
            case 1954925533: goto L91;
            case 2011364224: goto L88;
            default: goto L87;
        };
    L87:
        String name2 = name;
    L236:
        int r16 = r11;
    L237:
        FileReader permReader4 = permReader;
        boolean lowRam2 = lowRam;
        int type2 = type;
        boolean allowAll2 = allowAll;
        boolean allowLibs2 = allowLibs;
        boolean allowFeatures2 = allowFeatures;
        switch(r16) {
            case 0: goto L716;
            case 1: goto L709;
            case 2: goto L692;
            case 3: goto L688;
            case 4: goto L647;
            case 5: goto L647;
            case 6: goto L635;
            case 7: goto L626;
            case 8: goto L618;
            case 9: goto L610;
            case 10: goto L602;
            case 11: goto L594;
            case 12: goto L575;
            case 13: goto L566;
            case 14: goto L547;
            case 15: goto L539;
            case 16: goto L531;
            case 17: goto L523;
            case 18: goto L513;
            case 19: goto L512;
            case 20: goto L501;
            case 21: goto L482;
            case 22: goto L474;
            case 23: goto L474;
            case 24: goto L464;
            case 25: goto L444;
            case 26: goto L423;
            case 27: goto L419;
            case 28: goto L411;
            case 29: goto L398;
            case 30: goto L393;
            case 31: goto L388;
            case 32: goto L383;
            case 33: goto L382;
            case 34: goto L381;
            case 35: goto L356;
            case 36: goto L344;
            case 37: goto L339;
            case 38: goto L325;
            case 39: goto L313;
            case 40: goto L305;
            case 41: goto L297;
            case 42: goto L287;
            case 43: goto L279;
            case 44: goto L271;
            case 45: goto L266;
            case 46: goto L254;
            case 47: goto L250;
            case 48: goto L246;
            default: goto L239;
        };
    L239:
        Slog.w(TAG, "Tag " + name2 + " is unknown in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        int r27 = 1;
    L725:
        r10 = r27;
        permReader = permReader4;
        lowRam = lowRam2;
        type = type2;
        allowAll = allowAll2;
        allowLibs = allowLibs2;
        allowFeatures = allowFeatures2;
        r11 = -1;
        goto L77
    L246:
        SignedPackage signedPackage = parseEnhancedConfirmationTrustedPackage(parser, permFile, name2);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (signedPackage == null) goto L249;
        this.mEnhancedConfirmationTrustedInstallers.add(signedPackage);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L249:
        r27 = 1;
        goto L725
    L250:
        SignedPackage signedPackage2 = parseEnhancedConfirmationTrustedPackage(parser, permFile, name2);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (signedPackage2 == null) goto L253;
        this.mEnhancedConfirmationTrustedPackages.add(signedPackage2);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L253:
        r27 = 1;
        goto L725
    L254:
        String uidName = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String uidValue = parser.getAttributeValue(null, "uid");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (TextUtils.isEmpty(uidName) == false) goto L258;
        Slog.w(TAG, "<" + name2 + "> without valid uid name in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L265:
        r27 = 1;
        goto L725
    L258:
        if (TextUtils.isEmpty(uidValue) == false) goto L746;
        Slog.w(TAG, "<" + name2 + "> without valid uid value in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L265
    L746:
        int oemDefinedUid = Integer.parseInt(uidValue);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244 NumberFormatException -> L263
        this.mOemDefinedUids.put(uidName, Integer.valueOf(oemDefinedUid));     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244 NumberFormatException -> L263
    L264:
        Slog.w(TAG, "<" + name2 + "> with invalid uid value: " + uidValue + " in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L265
    L266:
        String packageName = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (TextUtils.isEmpty(packageName) == false) goto L269;
        Slog.w(TAG, "<" + name2 + "> without valid package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L270:
        r27 = 1;
        goto L725
    L269:
        this.mPreinstallPackagesWithStrictSignatureCheck.add(packageName);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L270
    L271:
        String packageName2 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String path = parser.getAttributeValue(null, "path");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (TextUtils.isEmpty(packageName2) == false) goto L275;
        Slog.w(TAG, "<" + name2 + "> without valid package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L278:
        r27 = 1;
        goto L725
    L275:
        if (TextUtils.isEmpty(path) == false) goto L277;
        Slog.w(TAG, "<" + name2 + "> without valid path in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L278
    L277:
        this.mAppMetadataFilePaths.put(packageName2, path);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L278
    L279:
        String pkgName = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String sharedUid = parser.getAttributeValue(null, "shareduid");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (TextUtils.isEmpty(pkgName) == false) goto L283;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L286:
        r27 = 1;
        goto L725
    L283:
        if (TextUtils.isEmpty(sharedUid) == false) goto L285;
        Slog.w(TAG, "<" + name2 + "> without shareduid in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L286
    L285:
        this.mPackageToSharedUidAllowList.put(pkgName, sharedUid);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L286
    L287:
        String pkgName2 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String stopped = parser.getAttributeValue(null, "stopped");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (TextUtils.isEmpty(pkgName2) == false) goto L291;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L296:
        r27 = 1;
        goto L725
    L291:
        if (TextUtils.isEmpty(stopped) == false) goto L294;
        Slog.w(TAG, "<" + name2 + "> without stopped in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L296
    L294:
        if (Boolean.parseBoolean(stopped) == true) goto L296;
        this.mInitialNonStoppedSystemPackages.add(pkgName2);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L296
    L297:
        String packageName3 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String installerName = parser.getAttributeValue(null, "installer");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (TextUtils.isEmpty(packageName3) == false) goto L301;
        Slog.w(TAG, "<" + name2 + "> without valid package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L304:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L301:
        if (TextUtils.isEmpty(installerName) == false) goto L303;
        Slog.w(TAG, "<" + name2 + "> without valid installer in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L304
    L303:
        this.mUpdateOwnersForSystemApps.put(packageName3, installerName);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L304
    L305:
        if (allowAppConfigs == false) goto L311;
        String packageName4 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (packageName4 != null) goto L309;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L312:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L309:
        this.mInstallConstraintsAllowlist.add(packageName4);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L312
    L311:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L312
    L313:
        if (allowVendorApex == false) goto L323;
        String pkgName3 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String installerPkgName = parser.getAttributeValue(null, "installerPackage");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgName3 != null) goto L317;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L317:
        if (installerPkgName != null) goto L319;
        Slog.w(TAG, "<" + name2 + "> without installerPackage in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L319:
        if (pkgName3 == null) goto L324;
        if (installerPkgName == null) goto L324;
        this.mAllowedVendorApexes.put(pkgName3, installerPkgName);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L324:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L323:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L324
    L325:
        if (allowAppConfigs == false) goto L337;
        String pkgname = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        boolean isModulesInstaller = XmlUtils.readBooleanAttribute(parser, "isModulesInstaller", false);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname != null) goto L329;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L330:
        if (isModulesInstaller == false) goto L338;
        if (this.mModulesInstallerPackageName != null) goto L335;
        this.mModulesInstallerPackageName = pkgname;     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L338
    L335:
        throw new IllegalStateException("Multiple modules installers");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L338:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L329:
        this.mWhitelistedStagedInstallers.add(pkgname);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L330
    L337:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L338
    L339:
        String pkgname2 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname2 != null) goto L342;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L343:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L342:
        this.mRollbackWhitelistedPackages.add(pkgname2);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L343
    L344:
        if (allowAll2 == false) goto L354;
        String pkgName4 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgName4 != null) goto L349;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L355:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L349:
        if (TextUtils.isEmpty(this.mOverlayConfigSignaturePackage) == false) goto L353;
        this.mOverlayConfigSignaturePackage = pkgName4.intern();     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L355
    L353:
        throw new IllegalStateException("Reference signature package defined as both " + this.mOverlayConfigSignaturePackage + " and " + pkgName4);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L354:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L355
    L356:
        String namespace = TextUtils.safeIntern(parser.getAttributeValue(null, "namespace"));     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String actorName = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String pkgName5 = TextUtils.safeIntern(parser.getAttributeValue(null, Settings.ATTR_PACKAGE));     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (TextUtils.isEmpty(namespace) == false) goto L360;
        Slog.wtf(TAG, "<" + name2 + "> without namespace in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L376:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L360:
        if (TextUtils.isEmpty(actorName) == false) goto L363;
        Slog.wtf(TAG, "<" + name2 + "> without actor name in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L376
    L363:
        if (TextUtils.isEmpty(pkgName5) == false) goto L366;
        Slog.wtf(TAG, "<" + name2 + "> without package name in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L376
    L366:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equalsIgnoreCase(namespace) == true) goto L380;
        if (this.mNamedActors != null) goto L370;
        this.mNamedActors = new ArrayMap();     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L370:
        Map<String, String> nameToPkgMap = this.mNamedActors.get(namespace);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (nameToPkgMap != null) goto L374;
        nameToPkgMap = new ArrayMap();     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        this.mNamedActors.put(namespace, nameToPkgMap);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L375:
        nameToPkgMap.put(actorName, pkgName5);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L376
    L374:
        if (nameToPkgMap.containsKey(actorName) == false) goto L375;
        String existing = nameToPkgMap.get(actorName);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        throw new IllegalStateException("Duplicate actor definition for " + namespace + SliceClientPermissions.SliceAuthority.DELIMITER + actorName + "; defined as both " + existing + " and " + pkgName5);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L380:
        throw new IllegalStateException("Defining " + actorName + " as " + pkgName5 + " for the android namespace is not allowed");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L381:
        MapOfImplicitBroadcastToPackageNames(parser, this.mQtiAllowImplicitBroadcasts);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L382:
        readInstallInUserType(parser, this.mPackageToUserTypeWhitelist, this.mPackageToUserTypeBlacklist);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L383:
        String pkgname3 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname3 != null) goto L386;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L387:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L386:
        this.mPreventUserDisablePackages.add(pkgname3);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L387
    L388:
        String pkgname4 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname4 != null) goto L391;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L392:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L391:
        this.mBugreportWhitelistedPackages.add(pkgname4);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L392
    L393:
        String pkgname5 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname5 != null) goto L396;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L397:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L396:
        this.mAppDataIsolationWhitelistedApps.add(pkgname5);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L397
    L398:
        if (allowAssociations == false) goto L409;
        String target = parser.getAttributeValue(null, "target");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (target != null) goto L402;
        Slog.w(TAG, "<" + name2 + "> without target in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L402:
        String allowed = parser.getAttributeValue(null, "allowed");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (allowed != null) goto L405;
        Slog.w(TAG, "<" + name2 + "> without allowed in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L405:
        String target2 = target.intern();     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String allowed2 = allowed.intern();     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        ArraySet<String> associations = this.mAllowedAssociations.get(target2);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (associations != null) goto L408;
        associations = new ArraySet();     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        this.mAllowedAssociations.put(target2, associations);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L408:
        Slog.i(TAG, "Adding association: " + target2 + " <- " + allowed2);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        associations.add(allowed2);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L410:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L409:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L410
    L411:
        if (allowApiWhitelisting == false) goto L417;
        String pkgname6 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname6 != null) goto L415;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L418:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L415:
        this.mHiddenApiPackageWhitelist.add(pkgname6);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L418
    L417:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L418
    L419:
        if (allowOemPermissions == false) goto L421;
        readOemPermissions(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L421:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L464:
        if (allowAppConfigs == false) goto L472;
        String pkgname7 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname7 != null) goto L469;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L473:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L469:
        if (this.mDisabledUntilUsedPreinstalledCarrierApps.remove(pkgname7) == true) goto L473;
        Slog.w(TAG, "<" + name2 + "> packagename:" + pkgname7 + " not includedin disabled-in-sku");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L473
    L472:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L473
    L474:
        if (allowAppConfigs == false) goto L480;
        String pkgname8 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname8 != null) goto L478;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L481:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L478:
        this.mDisabledUntilUsedPreinstalledCarrierApps.add(pkgname8);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L481
    L480:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L481
    L482:
        if (allowAppConfigs == false) goto L499;
        String pkgname9 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String carrierPkgname = parser.getAttributeValue(null, "carrierAppPackage");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname9 == null) goto L497;
        if (carrierPkgname == null) goto L497;
        int addedInSdk = -1;
        String addedInSdkStr = parser.getAttributeValue(null, "addedInSdk");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (TextUtils.isEmpty(addedInSdkStr) == false) goto L750;
    L493:
        List<CarrierAssociatedAppEntry> associatedPkgs = this.mDisabledUntilUsedPreinstalledCarrierAssociatedApps.get(carrierPkgname);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (associatedPkgs != null) goto L496;
        associatedPkgs = new ArrayList();     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        this.mDisabledUntilUsedPreinstalledCarrierAssociatedApps.put(carrierPkgname, associatedPkgs);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L496:
        associatedPkgs.add(new CarrierAssociatedAppEntry(pkgname9, addedInSdk));     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L500:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L750:
        addedInSdk = Integer.parseInt(addedInSdkStr);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244 NumberFormatException -> L491
    L492:
        Slog.w(TAG, "<" + name2 + "> addedInSdk not an integer in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
    L497:
        Slog.w(TAG, "<" + name2 + "> without package or carrierAppPackage in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L500
    L499:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L500
    L501:
        if (allowFeatures2 == false) goto L510;
        String serviceName = parser.getAttributeValue(null, HostingRecord.HOSTING_TYPE_SERVICE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (serviceName != null) goto L505;
        Slog.w(TAG, "<" + name2 + "> without service in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L511:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L505:
        ComponentName cn = ComponentName.unflattenFromString(serviceName);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (cn != null) goto L508;
        Slog.w(TAG, "<" + name2 + "> with invalid service name " + serviceName + " in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L511
    L508:
        this.mBackupTransportWhitelist.add(cn);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L511
    L510:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L511
    L512:
        readComponentOverrides(parser, permFile);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L513:
        if (allowAppConfigs == false) goto L521;
        String pkgname10 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String clsname = parser.getAttributeValue(null, "class");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname10 != null) goto L517;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L522:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L517:
        if (clsname != null) goto L519;
        Slog.w(TAG, "<" + name2 + "> without class in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L522
    L519:
        this.mDefaultVrComponents.add(new ComponentName(pkgname10, clsname));     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L522
    L521:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L522
    L523:
        if (allowOverrideAppRestrictions == false) goto L529;
        String pkgname11 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname11 != null) goto L527;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L530:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L527:
        this.mBgRestrictionExemption.add(pkgname11);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L530
    L529:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L530
    L531:
        if (allowAppConfigs == false) goto L537;
        String pkgname12 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname12 != null) goto L535;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L538:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L535:
        this.mLinkedApps.add(pkgname12);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L538
    L537:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L538
    L539:
        if (allowImplicitBroadcasts == false) goto L545;
        String action = parser.getAttributeValue(null, DomainVerificationPersistence.ATTR_ACTION);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (action != null) goto L543;
        Slog.w(TAG, "<" + name2 + "> without action in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L546:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L543:
        this.mAllowImplicitBroadcasts.add(action);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L546
    L545:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L546
    L547:
        if (allowOverrideAppRestrictions == false) goto L564;
        String pkgname13 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String attributionTag = parser.getAttributeValue(null, "attributionTag");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname13 != null) goto L551;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L565:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L551:
        ArraySet<String> tags = this.mAllowIgnoreLocationSettings.get(pkgname13);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (tags != null) goto L554;
    L555:
        if (tags != null) goto L558;
        tags = new ArraySet(1);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        this.mAllowIgnoreLocationSettings.put(pkgname13, tags);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L558:
        if (SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER.equals(attributionTag) == true) goto L565;
        if ("null".equals(attributionTag) == false) goto L562;
        attributionTag = null;
    L562:
        tags.add(attributionTag);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L565
    L554:
        if (tags.isEmpty() == true) goto L565;
    L564:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L565
    L566:
        if (allowOverrideAppRestrictions == false) goto L572;
        String pkgname14 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname14 != null) goto L570;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L573:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L570:
        this.mAllowlistCameraPrivacy.add(pkgname14);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L573
    L572:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L573
    L594:
        if (allowOverrideAppRestrictions == false) goto L600;
        String pkgname15 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname15 != null) goto L598;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L601:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L598:
        this.mAllowUnthrottledLocation.add(pkgname15);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L601
    L600:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L601
    L602:
        if (allowOverrideAppRestrictions == false) goto L608;
        String pkgname16 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname16 != null) goto L606;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L609:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L606:
        this.mAllowInDataUsageSave.add(pkgname16);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L609
    L608:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L609
    L610:
        if (allowOverrideAppRestrictions == false) goto L616;
        String pkgname17 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname17 != null) goto L614;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L617:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L614:
        this.mAllowInPowerSave.add(pkgname17);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L617
    L616:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L617
    L618:
        if (allowOverrideAppRestrictions == false) goto L624;
        String pkgname18 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname18 != null) goto L622;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L625:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L622:
        this.mAllowInPowerSaveExceptIdle.add(pkgname18);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L625
    L624:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L625
    L626:
        if (allowFeatures2 == false) goto L632;
        String fname = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (fname != null) goto L630;
        Slog.w(TAG, "<" + name2 + "> without name in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L633:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L630:
        this.mUnavailableFeatures.add(fname);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L633
    L632:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L633
    L647:
        r27 = 1;
        if (allowLibs2 == false) goto L686;
        String lname = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String lfile = parser.getAttributeValue(null, "file");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String ldependency = parser.getAttributeValue(null, "dependency");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String minDeviceSdk = parser.getAttributeValue(null, "min-device-sdk");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String maxDeviceSdk = parser.getAttributeValue(null, "max-device-sdk");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (lname != null) goto L652;
        Slog.w(TAG, "<" + name2 + "> without name in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L687:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L725
    L652:
        if (lfile != null) goto L654;
        Slog.w(TAG, "<" + name2 + "> without file in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L687
    L654:
        if (minDeviceSdk != null) goto L656;
    L659:
        boolean allowedMinSdk = true;
    L661:
        if (maxDeviceSdk != null) goto L663;
    L666:
        boolean allowedMaxSdk = true;
    L667:
        boolean exists = new File(lfile).exists();     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (allowedMinSdk == false) goto L677;
        if (allowedMaxSdk == false) goto L677;
        if (exists == false) goto L677;
        String bcpSince = parser.getAttributeValue(null, "on-bootclasspath-since");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String bcpBefore = parser.getAttributeValue(null, "on-bootclasspath-before");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (ldependency != null) goto L675;
        String[] r17 = new String[0];     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L676:
        SharedLibraryEntry entry = new SharedLibraryEntry(lname, lfile, r17, bcpSince, bcpBefore);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        this.mSharedLibraries.put(lname, entry);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L687
    L675:
        r17 = ldependency.split(":");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L677:
        StringBuilder msg = new StringBuilder("Ignore shared library ");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        msg.append(lname);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        msg.append(":");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (allowedMinSdk == true) goto L680;
        msg.append(" min-device-sdk=");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        msg.append(minDeviceSdk);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L680:
        if (allowedMaxSdk == true) goto L682;
        msg.append(" max-device-sdk=");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        msg.append(maxDeviceSdk);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L682:
        if (exists == true) goto L684;
        msg.append(" ");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        msg.append(lfile);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        msg.append(" does not exist");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L684:
        Slog.i(TAG, msg.toString());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L687
    L663:
        if (isAtMostSdkLevel(maxDeviceSdk) == true) goto L666;
        allowedMaxSdk = false;
        goto L667
    L656:
        if (isAtLeastSdkLevel(minDeviceSdk) == true) goto L659;
        allowedMinSdk = false;
        goto L661
    L686:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L687
    L688:
        r27 = 1;
        if (allowPermissions == false) goto L691;
        readSplitPermission(parser, permFile);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L725
    L691:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L725
    L692:
        r27 = 1;
        if (allowPermissions == false) goto L707;
        String perm = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (perm != null) goto L697;
        Slog.w(TAG, "<" + name2 + "> without name in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L725
    L697:
        String uidStr = parser.getAttributeValue(null, "uid");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (uidStr != null) goto L700;
        Slog.w(TAG, "<" + name2 + "> without uid in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L725
    L700:
        int uid = Process.getUidForName(uidStr);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (uid >= 0) goto L703;
        Slog.w(TAG, "<" + name2 + "> with unknown uid \"" + uidStr + "  in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L725
    L703:
        String perm2 = perm.intern();     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        ArraySet<String> perms = this.mSystemPermissions.get(uid);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (perms != null) goto L706;
        perms = new ArraySet();     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        this.mSystemPermissions.put(uid, perms);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L706:
        perms.add(perm2);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L708:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L725
    L707:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L708
    L709:
        r27 = 1;
        if (allowPermissions == false) goto L715;
        String perm3 = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (perm3 != null) goto L714;
        Slog.w(TAG, "<" + name2 + "> without name in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L725
    L714:
        readPermission(parser, perm3.intern());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L725
    L715:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L725
    L716:
        r27 = 1;
        if (allowAll2 == false) goto L723;
        String gidStr = parser.getAttributeValue(null, "gid");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (gidStr == null) goto L721;
        int gid = Process.getGidForName(gidStr);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        this.mGlobalGids = ArrayUtils.appendInt(this.mGlobalGids, gid);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L724:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L725
    L721:
        Slog.w(TAG, "<" + name2 + "> without gid in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L724
    L723:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L724
    L423:
        if (allowSignaturePermissions == true) goto L425;
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L425:
        if (permFile.toPath().startsWith(Environment.getVendorDirectory().toPath() + SliceClientPermissions.SliceAuthority.DELIMITER) == false) goto L427;
    L430:
        boolean vendor2 = true;
    L431:
        boolean product = permFile.toPath().startsWith(Environment.getProductDirectory().toPath() + SliceClientPermissions.SliceAuthority.DELIMITER);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        boolean systemExt = permFile.toPath().startsWith(Environment.getSystemExtDirectory().toPath() + SliceClientPermissions.SliceAuthority.DELIMITER);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        boolean apex = permFile.toPath().startsWith(Environment.getApexDirectory().toPath() + SliceClientPermissions.SliceAuthority.DELIMITER);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (vendor2 == false) goto L434;
        readSignatureAppPermissions(parser, this.mPermissionAllowlist.getVendorSignatureAppAllowlist());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L441:
        r27 = 1;
        goto L725
    L434:
        if (product == false) goto L436;
        readSignatureAppPermissions(parser, this.mPermissionAllowlist.getProductSignatureAppAllowlist());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L441
    L436:
        if (systemExt == false) goto L438;
        readSignatureAppPermissions(parser, this.mPermissionAllowlist.getSystemExtSignatureAppAllowlist());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L441
    L438:
        if (apex == false) goto L440;
        readSignatureAppPermissions(parser, this.mPermissionAllowlist.getApexSignatureAppAllowlist());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L441
    L440:
        readSignatureAppPermissions(parser, this.mPermissionAllowlist.getSignatureAppAllowlist());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L441
    L427:
        if (permFile.toPath().startsWith(Environment.getOdmDirectory().toPath() + SliceClientPermissions.SliceAuthority.DELIMITER) == true) goto L430;
        vendor2 = false;
        goto L431
    L444:
        if (allowPrivappPermissions == true) goto L446;
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L446:
        if (permFile.toPath().startsWith(Environment.getVendorDirectory().toPath() + SliceClientPermissions.SliceAuthority.DELIMITER) == false) goto L448;
    L451:
        boolean vendor3 = true;
    L452:
        boolean product2 = permFile.toPath().startsWith(Environment.getProductDirectory().toPath() + SliceClientPermissions.SliceAuthority.DELIMITER);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        boolean systemExt2 = permFile.toPath().startsWith(Environment.getSystemExtDirectory().toPath() + SliceClientPermissions.SliceAuthority.DELIMITER);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        boolean apex2 = permFile.toPath().startsWith(Environment.getApexDirectory().toPath() + SliceClientPermissions.SliceAuthority.DELIMITER);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (vendor3 == false) goto L455;
        readPrivAppPermissions(parser, this.mPermissionAllowlist.getVendorPrivilegedAppAllowlist());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L462:
        r27 = 1;
        goto L725
    L455:
        if (product2 == false) goto L457;
        readPrivAppPermissions(parser, this.mPermissionAllowlist.getProductPrivilegedAppAllowlist());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L462
    L457:
        if (systemExt2 == false) goto L459;
        readPrivAppPermissions(parser, this.mPermissionAllowlist.getSystemExtPrivilegedAppAllowlist());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L462
    L459:
        if (apex2 == false) goto L461;
        readApexPrivAppPermissions(parser, permFile, Environment.getApexDirectory().toPath());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L462
    L461:
        readPrivAppPermissions(parser, this.mPermissionAllowlist.getPrivilegedAppAllowlist());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L462
    L448:
        if (permFile.toPath().startsWith(Environment.getOdmDirectory().toPath() + SliceClientPermissions.SliceAuthority.DELIMITER) == true) goto L451;
        vendor3 = false;
        goto L452
    L575:
        if (allowOverrideAppRestrictions == false) goto L592;
        String pkgname19 = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        String attributionTag2 = parser.getAttributeValue(null, "attributionTag");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (pkgname19 != null) goto L579;
        Slog.w(TAG, "<" + name2 + "> without package in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L593:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        goto L725
    L579:
        ArraySet<String> tags2 = this.mAllowAdasSettings.get(pkgname19);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (tags2 != null) goto L582;
    L583:
        if (tags2 != null) goto L586;
        tags2 = new ArraySet(1);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        this.mAllowAdasSettings.put(pkgname19, tags2);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L586:
        if (SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER.equals(attributionTag2) == true) goto L593;
        if ("null".equals(attributionTag2) == false) goto L590;
        attributionTag2 = null;
    L590:
        tags2.add(attributionTag2);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L593
    L582:
        if (tags2.isEmpty() == true) goto L593;
    L592:
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L593
    L635:
        if (allowFeatures2 == false) goto L645;
        String fname2 = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        int fversion = XmlUtils.readIntAttribute(parser, "version", 0);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        if (lowRam2 == true) goto L639;
        boolean allowed3 = true;
        r27 = 1;
    L640:
        if (fname2 != null) goto L642;
        Slog.w(TAG, "<" + name2 + "> without name in " + permFile + " at " + parser.getPositionDescription());     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L646:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L725
    L642:
        if (allowed3 == false) goto L646;
        addFeature(fname2, fversion);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L646
    L639:
        String notLowRam = parser.getAttributeValue(null, "notLowRam");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        r27 = 1;
        allowed3 = !"true".equals(notLowRam);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L640
    L645:
        r27 = 1;
        logNotAllowedInPartition(name2, permFile, parser);     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
        goto L646
    L88:
        name2 = name;
        if (name2.equals("allow-package-shareduid") == false) goto L236;
        r16 = 43;
        goto L237
    L91:
        name2 = name;
        if (name2.equals("allow-implicit-broadcast") == false) goto L236;
        r16 = 15;
        goto L237
    L94:
        name2 = name;
        if (name2.equals("overlay-config-signature") == false) goto L236;
        r16 = 36;
        goto L237
    L97:
        name2 = name;
        if (name2.equals("initial-package-state") == false) goto L236;
        r16 = 42;
        goto L237
    L100:
        name2 = name;
        if (name2.equals("bugreport-whitelisted") == false) goto L236;
        r16 = 31;
        goto L237
    L103:
        name2 = name;
        if (name2.equals("privapp-permissions") == false) goto L236;
        r16 = 25;
        goto L237
    L106:
        name2 = name;
        if (name2.equals("disabled-until-used-preinstalled-carrier-associated-app") == false) goto L236;
        r16 = 21;
        goto L237
    L109:
        name2 = name;
        if (name2.equals("default-enabled-vr-app") == false) goto L236;
        r16 = 18;
        goto L237
    L112:
        name2 = name;
        if (name2.equals("enabled-in-sku-override") == false) goto L236;
        r16 = 24;
        goto L237
    L115:
        name2 = name;
        if (name2.equals("app-data-isolation-whitelisted-app") == false) goto L236;
        r16 = 30;
        goto L237
    L118:
        name2 = name;
        if (name2.equals("split-permission") == false) goto L236;
        r16 = 3;
        goto L237
    L121:
        name2 = name;
        if (name2.equals("app-link") == false) goto L236;
        r16 = 16;
        goto L237
    L124:
        name2 = name;
        if (name2.equals("enhanced-confirmation-trusted-installer") == false) goto L236;
        r16 = 48;
        goto L237
    L127:
        name2 = name;
        if (name2.equals("whitelisted-staged-installer") == false) goto L236;
        r16 = 38;
        goto L237
    L130:
        name2 = name;
        if (name2.equals("oem-permissions") == false) goto L236;
        r16 = 27;
        goto L237
    L133:
        name2 = name;
        if (name2.equals("apex-library") == false) goto L236;
        r16 = 4;
        goto L237
    L136:
        name2 = name;
        if (name2.equals("rollback-whitelisted-app") == false) goto L236;
        r16 = 37;
        goto L237
    L139:
        name2 = name;
        if (name2.equals("assign-permission") == false) goto L236;
        r16 = 2;
        goto L237
    L142:
        name2 = name;
        if (name2.equals("allow-in-data-usage-save") == false) goto L236;
        r16 = 10;
        goto L237
    L145:
        name2 = name;
        if (name2.equals("update-ownership") == false) goto L236;
        r16 = 41;
        goto L237
    L148:
        name2 = name;
        if (name2.equals("allowed-vendor-apex") == false) goto L236;
        r16 = 39;
        goto L237
    L151:
        name2 = name;
        if (name2.equals("prevent-disable") == false) goto L236;
        r16 = 32;
        goto L237
    L154:
        name2 = name;
        if (name2.equals("backup-transport-whitelisted-service") == false) goto L236;
        r16 = 20;
        goto L237
    L157:
        name2 = name;
        if (name2.equals("hidden-api-whitelisted-app") == false) goto L236;
        r16 = 28;
        goto L237
    L160:
        name2 = name;
        if (name2.equals("require-strict-signature") == false) goto L236;
        r16 = 45;
        goto L237
    L163:
        name2 = name;
        if (name2.equals("library") == false) goto L236;
        r16 = 5;
        goto L237
    L166:
        name2 = name;
        if (name2.equals("group") == false) goto L236;
        r16 = 0;
        goto L237
    L169:
        name2 = name;
        if (name2.equals("signature-permissions") == false) goto L236;
        r16 = 26;
        goto L237
    L172:
        name2 = name;
        if (name2.equals("camera-privacy-allowlisted-app") == false) goto L236;
        r16 = 13;
        goto L237
    L175:
        name2 = name;
        if (name2.equals("install-in-user-type") == false) goto L236;
        r16 = 33;
        goto L237
    L178:
        name2 = name;
        if (name2.equals("disabled-in-sku") == false) goto L236;
        r16 = 22;
        goto L237
    L181:
        name2 = name;
        if (name2.equals("permission") == false) goto L236;
        r16 = r10;
        goto L237
    L184:
        name2 = name;
        if (name2.equals("allow-ignore-location-settings") == false) goto L236;
        r16 = 14;
        goto L237
    L187:
        name2 = name;
        if (name2.equals("asl-file") == false) goto L236;
        r16 = 44;
        goto L237
    L190:
        name2 = name;
        if (name2.equals("bg-restriction-exemption") == false) goto L236;
        r16 = 17;
        goto L237
    L193:
        name2 = name;
        if (name2.equals("allow-in-power-save-except-idle") == false) goto L236;
        r16 = 8;
        goto L237
    L196:
        name2 = name;
        if (name2.equals("unavailable-feature") == false) goto L236;
        r16 = 7;
        goto L237
    L199:
        name2 = name;
        if (name2.equals("feature") == false) goto L236;
        r16 = 6;
        goto L237
    L202:
        name2 = name;
        if (name2.equals("allow-association") == false) goto L236;
        r16 = 29;
        goto L237
    L205:
        name2 = name;
        if (name2.equals("disabled-until-used-preinstalled-carrier-app") == false) goto L236;
        r16 = 23;
        goto L237
    L208:
        name2 = name;
        if (name2.equals("qti-allow-implicit-broadcast") == false) goto L236;
        r16 = 34;
        goto L237
    L211:
        name2 = name;
        if (name2.equals("install-constraints-allowed") == false) goto L236;
        r16 = 40;
        goto L237
    L214:
        name2 = name;
        if (name2.equals("component-override") == false) goto L236;
        r16 = 19;
        goto L237
    L217:
        name2 = name;
        if (name2.equals("named-actor") == false) goto L236;
        r16 = 35;
        goto L237
    L220:
        name2 = name;
        if (name2.equals("allow-adas-location-settings") == false) goto L236;
        r16 = 12;
        goto L237
    L223:
        name2 = name;
        if (name2.equals("oem-defined-uid") == false) goto L236;
        r16 = 46;
        goto L237
    L226:
        name2 = name;
        if (name2.equals("allow-in-power-save") == false) goto L236;
        r16 = 9;
        goto L237
    L229:
        name2 = name;
        if (name2.equals("allow-unthrottled-location") == false) goto L236;
        r16 = 11;
        goto L237
    L232:
        name2 = name;
        if (name2.equals("enhanced-confirmation-trusted-package") == false) goto L236;
        r16 = 47;
        goto L237
    L83:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L18 IOException -> L20 XmlPullParserException -> L22
        goto L77
    L79:
        IoUtils.closeQuietly(permReader);
        return;
    L75:
        r15 = false;
        goto L76
    L71:
        r14 = false;
        goto L72
    L67:
        r13 = false;
        goto L68
    L63:
        r12 = false;
        goto L64
    L59:
        r9 = false;
        goto L60
    L55:
        r8 = false;
        goto L56
    L51:
        r7 = false;
        goto L52
    L47:
        r6 = false;
        goto L48
    L43:
        r5 = false;
        goto L44
    L39:
        r4 = false;
        goto L40
    L35:
        r3 = false;
        goto L36
    L31:
        r2 = false;
        goto L32
    L27:
        r1 = false;
        goto L28
    L733:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L240 IOException -> L242 XmlPullParserException -> L244
    L242:
        e = e;
    L244:
        e = e;
    L240:
        th = th;
    L728:
        e = e;
        permReader2 = permReader;
    L730:
        e = e;
        permReader2 = permReader;
    L726:
        th = th;
        permReader3 = permReader;
    L744:
        Slog.w(TAG, "Couldn't find or open permissions file " + permFile);
    }

    private void readAllPermissionsFromEnvironment() {
        if (StorageManager.isFileEncrypted() == false) goto L6;
        addFeature("android.software.file_based_encryption", 0);
        addFeature("android.software.securely_removes_users", 0);
    L6:
        if (StorageManager.hasAdoptable() == false) goto L9;
        addFeature("android.software.adoptable_storage", 0);
    L9:
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L11;
        addFeature("android.hardware.ram.low", 0);
    L12:
        int incrementalVersion = IncrementalManager.getVersion();
        if (incrementalVersion <= 0) goto L15;
        addFeature("android.software.incremental_delivery", incrementalVersion);
    L15:
        addFeature("android.software.app_enumeration", 0);
        if (Build.VERSION.DEVICE_INITIAL_SDK_INT < 29) goto L18;
        addFeature("android.software.ipsec_tunnels", 0);
    L18:
        enableIpSecTunnelMigrationOnVsrUAndAbove();
        if (isErofsSupported() == true) goto L21;
        return;
    L21:
        if (isKernelVersionAtLeast(5, 10) == false) goto L24;
        addFeature("android.software.erofs", 0);
        return;
    L24:
        if (isKernelVersionAtLeast(4, 19) == false) goto L29;
        addFeature("android.software.erofs_legacy", 0);
        return;
    L29:
        return;
    L11:
        addFeature("android.hardware.ram.normal", 0);
        goto L12
    }

    private SignedPackage parseEnhancedConfirmationTrustedPackage(XmlPullParser parser, File permFile, String elementName) {
        String pkgName = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);
        if (TextUtils.isEmpty(pkgName) == false) goto L6;
        Slog.w(TAG, "<" + elementName + "> without package " + permFile + " at " + parser.getPositionDescription());
        return null;
    L6:
        String certificateDigestStr = parser.getAttributeValue(null, "sha256-cert-digest");
        if (TextUtils.isEmpty(certificateDigestStr) == false) goto L17;
        Slog.w(TAG, "<" + elementName + "> without sha256-cert-digest in " + permFile + " at " + parser.getPositionDescription());
        return null;
    L17:
        byte[] certificateDigest = new Signature(certificateDigestStr.replace(":", "")).toByteArray();     // Catch: IllegalArgumentException -> L14
        return new SignedPackage(pkgName, certificateDigest);
    L15:
        Slog.w(TAG, "<" + elementName + "> with invalid sha256-cert-digest in " + permFile + " at " + parser.getPositionDescription());
        return null;
    }

    private void enableIpSecTunnelMigrationOnVsrUAndAbove() {
        int vsrApi = SystemProperties.getInt("ro.vendor.api_level", Build.VERSION.DEVICE_INITIAL_SDK_INT);
        if (vsrApi <= 33) goto L6;
        addFeature("android.software.ipsec_tunnel_migration", 0);
        return;
    }

    private void addFeature(String name, int version) {
        if (this.mInjector.isReadOnlySystemDisabledFeature(name, version) == false) goto L6;
        Slog.w(TAG, "Skipping feature addition for compile-time disabled feature: " + name);
        return;
    L6:
        FeatureInfo fi = this.mAvailableFeatures.get(name);
        if (fi != null) goto L9;
        FeatureInfo fi2 = new FeatureInfo();
        fi2.name = name;
        fi2.version = version;
        this.mAvailableFeatures.put(name, fi2);
        return;
    L9:
        fi.version = Math.max(fi.version, version);
    }

    private void removeFeature(String name) {
        if (this.mInjector.isReadOnlySystemEnabledFeature(name, 0) == false) goto L7;
        Slog.w(TAG, "Skipping feature removal for compile-time enabled feature: " + name);
        return;
    L7:
        if (this.mAvailableFeatures.remove(name) == null) goto L10;
        Slog.d(TAG, "Removed unavailable feature " + name);
        return;
    }

    void readPermission(XmlPullParser parser, String name) throws IOException, XmlPullParserException {
        if (this.mPermissions.containsKey(name) == true) goto L29;
        boolean perUser = XmlUtils.readBooleanAttribute(parser, "perUser", false);
        PermissionEntry perm = new PermissionEntry(name, perUser);
        this.mPermissions.put(name, perm);
        int outerDepth = parser.getDepth();
    L5:
        int type = parser.next();
        if (type == 1) goto L27;
        if (type == 3) goto L10;
    L12:
        if (type == 3) goto L5;
        if (type == 4) goto L5;
        String tagName = parser.getName();
        if ("group".equals(tagName) == false) goto L26;
        String gidStr = parser.getAttributeValue(null, "gid");
        if (gidStr == null) goto L25;
        int gid = Process.getGidForName(gidStr);
        if (gid == (-1)) goto L23;
        perm.gids = ArrayUtils.appendInt(perm.gids, gid);
        goto L26
    L23:
        Slog.w(TAG, "<group> with unknown gid \"" + gidStr + " for permission " + name + " in " + parser.getPositionDescription());
        goto L26
    L25:
        Slog.w(TAG, "<group> without gid at " + parser.getPositionDescription());
    L26:
        XmlUtils.skipCurrentTag(parser);
        goto L5
    L10:
        if (parser.getDepth() > outerDepth) goto L12;
        return;
    L27:
        return;
    L29:
        throw new IllegalStateException("Duplicate permission definition for " + name);
    }

    private void readPrivAppPermissions(XmlPullParser parser, ArrayMap<String, ArrayMap<String, Boolean>> allowlist) throws IOException, XmlPullParserException {
        readPermissionAllowlist(parser, allowlist, "privapp-permissions");
    }

    private void readSignatureAppPermissions(XmlPullParser parser, ArrayMap<String, ArrayMap<String, Boolean>> allowlist) throws IOException, XmlPullParserException {
        readPermissionAllowlist(parser, allowlist, "signature-permissions");
    }

    private void readInstallInUserType(XmlPullParser parser, Map<String, Set<String>> doInstallMap, Map<String, Set<String>> nonInstallMap) throws IOException, XmlPullParserException {
        String packageName = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);
        if (TextUtils.isEmpty(packageName) == false) goto L6;
        Slog.w(TAG, "package is required for <install-in-user-type> in " + parser.getPositionDescription());
        return;
    L6:
        Set<String> userTypesYes = doInstallMap.get(packageName);
        Set<String> userTypesNo = nonInstallMap.get(packageName);
        int depth = parser.getDepth();
    L8:
        if (XmlUtils.nextElementWithin(parser, depth) == false) goto L27;
        String name = parser.getName();
        if ("install-in".equals(name) == true) goto L11;
        if ("do-not-install-in".equals(name) == true) goto L19;
        Slog.w(TAG, "unrecognized tag in <install-in-user-type> in " + parser.getPositionDescription());
        goto L8
    L19:
        String userType = parser.getAttributeValue(null, "user-type");
        if (TextUtils.isEmpty(userType) == true) goto L21;
        if (userTypesNo != null) goto L24;
        userTypesNo = new ArraySet();
        nonInstallMap.put(packageName, userTypesNo);
    L24:
        userTypesNo.add(userType);
        goto L8
    L21:
        Slog.w(TAG, "user-type is required for <install-in-user-type> in " + parser.getPositionDescription());
        goto L8
    L11:
        String userType2 = parser.getAttributeValue(null, "user-type");
        if (TextUtils.isEmpty(userType2) == true) goto L13;
        if (userTypesYes != null) goto L16;
        userTypesYes = new ArraySet();
        doInstallMap.put(packageName, userTypesYes);
    L16:
        userTypesYes.add(userType2);
        goto L8
    L13:
        Slog.w(TAG, "user-type is required for <install-in-user-type> in " + parser.getPositionDescription());
        goto L8
    }

    private void MapOfImplicitBroadcastToPackageNames(XmlPullParser parser, Map<String, Set<String>> broadcastPackagesMap) throws IOException, XmlPullParserException {
        String actionName = parser.getAttributeValue(null, DomainVerificationPersistence.ATTR_ACTION);
        if (TextUtils.isEmpty(actionName) == false) goto L6;
        Slog.w(TAG, "actionName is required for <qti-allow-implicit-broadcast> in " + parser.getPositionDescription());
        return;
    L6:
        Set<String> actionInSet = broadcastPackagesMap.get(actionName);
        int depth = parser.getDepth();
    L8:
        if (XmlUtils.nextElementWithin(parser, depth) == false) goto L19;
        String name = parser.getName();
        if ("package-name".equals(name) == true) goto L11;
        Slog.w(TAG, "unrecognized tag in <qti-allow-implicit-broadcast> in " + parser.getPositionDescription());
        goto L8
    L11:
        String realPackageName = parser.getAttributeValue(null, "packagename");
        if (TextUtils.isEmpty(realPackageName) == true) goto L13;
        if (actionInSet != null) goto L16;
        actionInSet = new ArraySet();
        broadcastPackagesMap.put(actionName, actionInSet);
    L16:
        actionInSet.add(realPackageName);
        goto L8
    L13:
        Slog.w(TAG, "package-name is required for <qti-allow-implicit-broadcast> in " + parser.getPositionDescription());
        goto L8
    }

    void readOemPermissions(XmlPullParser parser) throws IOException, XmlPullParserException {
        readPermissionAllowlist(parser, this.mPermissionAllowlist.getOemAppAllowlist(), "oem-permissions");
    }

    private static void readPermissionAllowlist(XmlPullParser parser, ArrayMap<String, ArrayMap<String, Boolean>> allowlist, String tagName) throws IOException, XmlPullParserException {
        String packageName = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);
        if (TextUtils.isEmpty(packageName) == false) goto L6;
        Slog.w(TAG, "package is required for <" + tagName + "> in " + parser.getPositionDescription());
        return;
    L6:
        ArrayMap<String, Boolean> permissions = allowlist.get(packageName);
        if (permissions != null) goto L9;
        permissions = new ArrayMap();
    L9:
        int depth = parser.getDepth();
    L11:
        if (XmlUtils.nextElementWithin(parser, depth) == false) goto L26;
        String name = parser.getName();
        if ("permission".equals(name) == true) goto L14;
        if ("deny-permission".equals(name) == false) goto L11;
        String permissionName = parser.getAttributeValue(null, "name");
        if (TextUtils.isEmpty(permissionName) == true) goto L23;
        permissions.put(permissionName, Boolean.FALSE);
        goto L11
    L23:
        Slog.w(TAG, "name is required for <deny-permission> in " + parser.getPositionDescription());
        goto L11
    L14:
        String permissionName2 = parser.getAttributeValue(null, "name");
        if (TextUtils.isEmpty(permissionName2) == true) goto L16;
        permissions.put(permissionName2, Boolean.TRUE);
        goto L11
    L16:
        Slog.w(TAG, "name is required for <permission> in " + parser.getPositionDescription());
        goto L11
    L26:
        allowlist.put(packageName, permissions);
    }

    private void readSplitPermission(XmlPullParser parser, File permFile) throws IOException, XmlPullParserException {
        if (ParsingPackageUtils.getAconfigFlags().skipCurrentElement(null, parser, true) == false) goto L6;
        XmlUtils.skipCurrentTag(parser);
        return;
    L6:
        String splitPerm = parser.getAttributeValue(null, "name");
        if (splitPerm != null) goto L10;
        Slog.w(TAG, "<split-permission> without name in " + permFile + " at " + parser.getPositionDescription());
        XmlUtils.skipCurrentTag(parser);
        return;
    L10:
        String targetSdkStr = parser.getAttributeValue(null, "targetSdk");
        int targetSdk = 10001;
        if (TextUtils.isEmpty(targetSdkStr) == false) goto L32;
    L17:
        int depth = parser.getDepth();
        List<String> newPermissions = new ArrayList();
    L19:
        if (XmlUtils.nextElementWithin(parser, depth) == false) goto L29;
        String name = parser.getName();
        if ("new-permission".equals(name) == true) goto L22;
        XmlUtils.skipCurrentTag(parser);
        goto L19
    L22:
        String newName = parser.getAttributeValue(null, "name");
        if (TextUtils.isEmpty(newName) == true) goto L24;
        newPermissions.add(newName);
        goto L19
    L24:
        Slog.w(TAG, "name is required for <new-permission> in " + parser.getPositionDescription());
        goto L19
    L29:
        if (newPermissions.isEmpty() == true) goto L43;
        this.mSplitPermissions.add(new PermissionManager.SplitPermissionInfo(splitPerm, newPermissions, targetSdk));
        return;
    L43:
        return;
    L32:
        targetSdk = Integer.parseInt(targetSdkStr);     // Catch: NumberFormatException -> L14
    L15:
        Slog.w(TAG, "<split-permission> targetSdk not an integer in " + permFile + " at " + parser.getPositionDescription());
        XmlUtils.skipCurrentTag(parser);
    }

    private void readComponentOverrides(XmlPullParser parser, File permFile) throws IOException, XmlPullParserException {
        String pkgname = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);
        if (pkgname != null) goto L6;
        Slog.w(TAG, "<component-override> without package in " + permFile + " at " + parser.getPositionDescription());
        return;
    L6:
        String pkgname2 = pkgname.intern();
        int depth = parser.getDepth();
    L8:
        if (XmlUtils.nextElementWithin(parser, depth) == false) goto L25;
        if ("component".equals(parser.getName()) == false) goto L8;
        String clsname = parser.getAttributeValue(null, "class");
        String enabled = parser.getAttributeValue(null, ServiceConfigAccessor.PROVIDER_MODE_ENABLED);
        if (clsname == null) goto L13;
        if (enabled == null) goto L16;
        if (clsname.startsWith(".") == false) goto L21;
        clsname = pkgname2 + clsname;
    L21:
        String clsname2 = clsname.intern();
        ArrayMap<String, Boolean> componentEnabledStates = this.mPackageComponentEnabledState.get(pkgname2);
        if (componentEnabledStates != null) goto L24;
        componentEnabledStates = new ArrayMap();
        this.mPackageComponentEnabledState.put(pkgname2, componentEnabledStates);
    L24:
        componentEnabledStates.put(clsname2, Boolean.valueOf(!"false".equals(enabled)));
        goto L8
    L16:
        Slog.w(TAG, "<component> without enabled in " + permFile + " at " + parser.getPositionDescription());
        return;
    L13:
        Slog.w(TAG, "<component> without class in " + permFile + " at " + parser.getPositionDescription());
        return;
    }

    private void readPublicNativeLibrariesList() {
        readPublicLibrariesListFile(new File("/vendor/etc/public.libraries.txt"));
        String[] dirs = {"/system/etc", "/system_ext/etc", "/product/etc"};
        int r1 = dirs.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L17;
        String dir = dirs[r3];
        File[] files = new File(dir).listFiles();
        if (files != null) goto L7;
        Slog.w(TAG, "Public libraries file folder missing: " + dir);
    L16:
        r3 = r3 + 1;
        goto L3
    L7:
        int r6 = files.length;
        int r7 = 0;
    L9:
        if (r7 >= r6) goto L16;
        File f = files[r7];
        String name = f.getName();
        if (name.startsWith("public.libraries-") == false) goto L15;
        if (name.endsWith(".txt") == false) goto L15;
        readPublicLibrariesListFile(f);
    L15:
        r7 = r7 + 1;
        goto L9
    }

    private void readPublicLibrariesListFile(File listFile) {
        BufferedReader br = new BufferedReader(new FileReader(listFile));     // Catch: IOException -> L18 FileNotFoundException -> L20
    L30:
        String line = br.readLine();     // Catch: Throwable -> L13
        if (line == null) goto L16;
        if (line.isEmpty() == true) goto L30;
        if (line.startsWith("#") == true) goto L30;
        String soname = line.trim().split(" ")[0];     // Catch: Throwable -> L13
        SharedLibraryEntry entry = new SharedLibraryEntry(soname, soname, new String[0], true);     // Catch: Throwable -> L13
        this.mSharedLibraries.put(entry.name, entry);     // Catch: Throwable -> L13
        goto L28
    L16:
        br.close();     // Catch: IOException -> L18 FileNotFoundException -> L20
        return;
    L13:
        th = move-exception;
        br.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: IOException -> L18 FileNotFoundException -> L20
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L18 FileNotFoundException -> L20
    L18:
        e = move-exception;
        Slog.w(TAG, "Failed to read public libraries file " + listFile, e);
        return;
    L28:
        Slog.d(TAG, listFile + " does not exist");
    }

    private String getApexModuleNameFromFilePath(Path path, Path apexDirectoryPath) {
        if (path.startsWith(apexDirectoryPath) == false) goto L11;
        if (path.getNameCount() <= (apexDirectoryPath.getNameCount() + 1)) goto L9;
        return path.getName(apexDirectoryPath.getNameCount()).toString();
    L9:
        throw new IllegalArgumentException("File " + path + " is in the APEX partition, but not inside a module.");
    L11:
        throw new IllegalArgumentException("File " + path + " is not part of an APEX.");
    }

    public void readApexPrivAppPermissions(XmlPullParser parser, File permFile, Path apexDirectoryPath) throws IOException, XmlPullParserException {
        String moduleName = getApexModuleNameFromFilePath(permFile.toPath(), apexDirectoryPath);
        ArrayMap<String, ArrayMap<String, ArrayMap<String, Boolean>>> allowlists = this.mPermissionAllowlist.getApexPrivilegedAppAllowlists();
        ArrayMap<String, ArrayMap<String, Boolean>> allowlist = allowlists.get(moduleName);
        if (allowlist != null) goto L5;
        allowlist = new ArrayMap();
        allowlists.put(moduleName, allowlist);
    L5:
        readPrivAppPermissions(parser, allowlist);
    }

    private static boolean isSystemProcess() {
        if (Process.myUid() != 1000) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isErofsSupported() {
        Path path = Paths.get("/sys/fs/erofs", new String[0]);     // Catch: Exception -> L5
        return Files.exists(path, new LinkOption[0]);
    L6:
        return false;
    }

    private static boolean isKernelVersionAtLeast(int major, int minor) {
        String kernelVersion = VintfRuntimeInfo.getKernelVersion();
        String[] parts = kernelVersion.split("\\.");
        if (parts.length >= 2) goto L13;
        return false;
    L13:
        int majorVersion = Integer.parseInt(parts[0]);     // Catch: NumberFormatException -> L11
        int minorVersion = Integer.parseInt(parts[1]);     // Catch: NumberFormatException -> L11
        if (majorVersion > major) goto L10;
        if (majorVersion != major) goto L15;
        if (minorVersion >= minor) goto L10;
        return false;
    L15:
        return false;
    L10:
        return true;
    L12:
        return false;
    }
}
