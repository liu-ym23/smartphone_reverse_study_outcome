package com.android.server.pm;

import android.text.TextUtils;
import com.android.internal.util.ArrayUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class KnownPackages {
    public static final int LAST_KNOWN_PACKAGE = 19;
    public static final int PACKAGE_AMBIENT_CONTEXT_DETECTION = 18;
    public static final int PACKAGE_APP_PREDICTOR = 12;
    public static final int PACKAGE_BROWSER = 5;
    public static final int PACKAGE_COMPANION = 15;
    public static final int PACKAGE_CONFIGURATOR = 10;
    public static final int PACKAGE_DOCUMENTER = 9;
    public static final int PACKAGE_INCIDENT_REPORT_APPROVER = 11;
    public static final int PACKAGE_INSTALLER = 2;
    public static final int PACKAGE_OVERLAY_CONFIG_SIGNATURE = 13;
    public static final int PACKAGE_PERMISSION_CONTROLLER = 7;
    public static final int PACKAGE_RECENTS = 17;
    public static final int PACKAGE_RETAIL_DEMO = 16;
    public static final int PACKAGE_SETUP_WIZARD = 1;
    public static final int PACKAGE_SYSTEM = 0;
    public static final int PACKAGE_SYSTEM_TEXT_CLASSIFIER = 6;
    public static final int PACKAGE_UNINSTALLER = 3;
    public static final int PACKAGE_VERIFIER = 4;
    public static final int PACKAGE_WEARABLE_SENSING = 19;
    public static final int PACKAGE_WELLBEING = 8;
    public static final int PACKAGE_WIFI = 14;
    static final String SYSTEM_PACKAGE_NAME = "android";
    private final String mAmbientContextDetectionPackage;
    private final String mAppPredictionServicePackage;
    private final String mCompanionPackage;
    private final String mConfiguratorPackage;
    private final DefaultAppProvider mDefaultAppProvider;
    private final String mDefaultTextClassifierPackage;
    private final String mIncidentReportApproverPackage;
    private final String mOverlayConfigSignaturePackage;
    private final String mRecentsPackage;
    private final String mRequiredInstallerPackage;
    private final String mRequiredPermissionControllerPackage;
    private final String mRequiredUninstallerPackage;
    private final String[] mRequiredVerifierPackages;
    private final String mRetailDemoPackage;
    private final String mSetupWizardPackage;
    private final String mSystemTextClassifierPackageName;
    private final String mWearableSensingPackage;

    @Retention(RetentionPolicy.SOURCE)
    public @interface KnownPackage {
    }

    KnownPackages(DefaultAppProvider defaultAppProvider, String requiredInstallerPackage, String requiredUninstallerPackage, String setupWizardPackage, String[] requiredVerifierPackages, String defaultTextClassifierPackage, String systemTextClassifierPackageName, String requiredPermissionControllerPackage, String configuratorPackage, String incidentReportApproverPackage, String ambientContextDetectionPackage, String wearableSensingPackage, String appPredictionServicePackage, String companionPackageName, String retailDemoPackage, String overlayConfigSignaturePackage, String recentsPackage) {
        this.mDefaultAppProvider = defaultAppProvider;
        this.mRequiredInstallerPackage = requiredInstallerPackage;
        this.mRequiredUninstallerPackage = requiredUninstallerPackage;
        this.mSetupWizardPackage = setupWizardPackage;
        this.mRequiredVerifierPackages = requiredVerifierPackages;
        this.mDefaultTextClassifierPackage = defaultTextClassifierPackage;
        this.mSystemTextClassifierPackageName = systemTextClassifierPackageName;
        this.mRequiredPermissionControllerPackage = requiredPermissionControllerPackage;
        this.mConfiguratorPackage = configuratorPackage;
        this.mIncidentReportApproverPackage = incidentReportApproverPackage;
        this.mAmbientContextDetectionPackage = ambientContextDetectionPackage;
        this.mWearableSensingPackage = wearableSensingPackage;
        this.mAppPredictionServicePackage = appPredictionServicePackage;
        this.mCompanionPackage = companionPackageName;
        this.mRetailDemoPackage = retailDemoPackage;
        this.mOverlayConfigSignaturePackage = overlayConfigSignaturePackage;
        this.mRecentsPackage = recentsPackage;
    }

    static String knownPackageToString(int knownPackage) {
        switch(knownPackage) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            case 6: goto L31;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L25;
            case 10: goto L23;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            case 17: goto L9;
            case 18: goto L7;
            case 19: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "Wearable sensing";
    L7:
        return "Ambient Context Detection";
    L9:
        return "Recents";
    L11:
        return "Retail Demo";
    L13:
        return "Companion";
    L15:
        return "Wi-Fi";
    L17:
        return "Overlay Config Signature";
    L19:
        return "App Predictor";
    L21:
        return "Incident Report Approver";
    L23:
        return "Configurator";
    L25:
        return "Documenter";
    L27:
        return "Wellbeing";
    L29:
        return "Permission Controller";
    L31:
        return "System Text Classifier";
    L33:
        return "Browser";
    L35:
        return "Verifier";
    L37:
        return "Uninstaller";
    L39:
        return "Installer";
    L41:
        return "Setup Wizard";
    L43:
        return "System";
    }

    String[] getKnownPackageNames(Computer snapshot, int knownPackage, int userId) {
        switch(knownPackage) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            case 6: goto L30;
            case 7: goto L28;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L26;
            case 11: goto L24;
            case 12: goto L22;
            case 13: goto L20;
            case 14: goto L5;
            case 15: goto L18;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 19: goto L7;
            default: goto L5;
        };
    L5:
        return (String[]) ArrayUtils.emptyArray(String.class);
    L7:
        return snapshot.filterOnlySystemPackages(new String[]{this.mWearableSensingPackage});
    L9:
        return snapshot.filterOnlySystemPackages(new String[]{this.mAmbientContextDetectionPackage});
    L11:
        return snapshot.filterOnlySystemPackages(new String[]{this.mRecentsPackage});
    L13:
        if (TextUtils.isEmpty(this.mRetailDemoPackage) == false) goto L16;
        return (String[]) ArrayUtils.emptyArray(String.class);
    L16:
        return new String[]{this.mRetailDemoPackage};
    L18:
        return snapshot.filterOnlySystemPackages(new String[]{this.mCompanionPackage});
    L20:
        return snapshot.filterOnlySystemPackages(new String[]{this.mOverlayConfigSignaturePackage});
    L22:
        return snapshot.filterOnlySystemPackages(new String[]{this.mAppPredictionServicePackage});
    L24:
        return snapshot.filterOnlySystemPackages(new String[]{this.mIncidentReportApproverPackage});
    L26:
        return snapshot.filterOnlySystemPackages(new String[]{this.mConfiguratorPackage});
    L28:
        return snapshot.filterOnlySystemPackages(new String[]{this.mRequiredPermissionControllerPackage});
    L30:
        return snapshot.filterOnlySystemPackages(new String[]{this.mDefaultTextClassifierPackage, this.mSystemTextClassifierPackageName});
    L32:
        return new String[]{this.mDefaultAppProvider.getDefaultBrowser(userId)};
    L34:
        return snapshot.filterOnlySystemPackages(this.mRequiredVerifierPackages);
    L36:
        return snapshot.filterOnlySystemPackages(new String[]{this.mRequiredUninstallerPackage});
    L38:
        return snapshot.filterOnlySystemPackages(new String[]{this.mRequiredInstallerPackage});
    L40:
        return snapshot.filterOnlySystemPackages(new String[]{this.mSetupWizardPackage});
    L42:
        return new String[]{"android"};
    }
}
