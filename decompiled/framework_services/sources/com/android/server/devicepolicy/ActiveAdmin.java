package com.android.server.devicepolicy;

import android.app.admin.DeviceAdminInfo;
import android.app.admin.FactoryResetProtectionPolicy;
import android.app.admin.ManagedSubscriptionsPolicy;
import android.app.admin.PackagePolicy;
import android.app.admin.PasswordPolicy;
import android.app.admin.PreferentialNetworkServiceConfig;
import android.app.admin.WifiSsidPolicy;
import android.graphics.Color;
import android.net.wifi.WifiSsid;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.PrintWriterPrinter;
import com.android.internal.util.Preconditions;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.UserRestrictionsUtils;
import com.android.server.utils.Slogf;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class ActiveAdmin {
    private static final String ATTR_LAST_NETWORK_LOGGING_NOTIFICATION = "last-notification";
    private static final String ATTR_NUM_NETWORK_LOGGING_NOTIFICATIONS = "num-notifications";
    private static final String ATTR_PACKAGE_POLICY_MODE = "package-policy-type";
    private static final String ATTR_VALUE = "value";
    static final int DEF_KEYGUARD_FEATURES_DISABLED = 0;
    static final int DEF_MAXIMUM_FAILED_PASSWORDS_FOR_WIPE = 0;
    static final int DEF_MAXIMUM_NETWORK_LOGGING_NOTIFICATIONS_SHOWN = 2;
    static final long DEF_MAXIMUM_TIME_TO_UNLOCK = 0;
    static final int DEF_ORGANIZATION_COLOR = 0;
    static final long DEF_PASSWORD_EXPIRATION_DATE = 0;
    static final long DEF_PASSWORD_EXPIRATION_TIMEOUT = 0;
    static final int DEF_PASSWORD_HISTORY_LENGTH = 0;
    private static final int PROVISIONING_CONTEXT_LENGTH_LIMIT = 1000;
    private static final String TAG_ACCOUNT_TYPE = "account-type";
    private static final String TAG_ADMIN_CAN_GRANT_SENSORS_PERMISSIONS = "admin-can-grant-sensors-permissions";
    private static final String TAG_ALWAYS_ON_VPN_LOCKDOWN = "vpn-lockdown";
    private static final String TAG_ALWAYS_ON_VPN_PACKAGE = "vpn-package";
    private static final String TAG_COMMON_CRITERIA_MODE = "common-criteria-mode";
    private static final String TAG_CREDENTIAL_MANAGER_POLICY = "credential-manager-policy";
    private static final String TAG_CROSS_PROFILE_CALENDAR_PACKAGES = "cross-profile-calendar-packages";
    private static final String TAG_CROSS_PROFILE_CALENDAR_PACKAGES_NULL = "cross-profile-calendar-packages-null";
    private static final String TAG_CROSS_PROFILE_CALLER_ID_POLICY = "caller-id-policy";
    private static final String TAG_CROSS_PROFILE_CONTACTS_SEARCH_POLICY = "contacts-policy";
    private static final String TAG_CROSS_PROFILE_PACKAGES = "cross-profile-packages";
    private static final String TAG_CROSS_PROFILE_WIDGET_PROVIDERS = "cross-profile-widget-providers";
    private static final String TAG_DEFAULT_ENABLED_USER_RESTRICTIONS = "default-enabled-user-restrictions";
    private static final String TAG_DIALER_PACKAGE = "dialer_package";
    private static final String TAG_DISABLE_ACCOUNT_MANAGEMENT = "disable-account-management";
    private static final String TAG_DISABLE_BLUETOOTH_CONTACT_SHARING = "disable-bt-contacts-sharing";
    private static final String TAG_DISABLE_CALLER_ID = "disable-caller-id";
    private static final String TAG_DISABLE_CAMERA = "disable-camera";
    private static final String TAG_DISABLE_CONTACTS_SEARCH = "disable-contacts-search";
    private static final String TAG_DISABLE_KEYGUARD_FEATURES = "disable-keyguard-features";
    private static final String TAG_DISABLE_SCREEN_CAPTURE = "disable-screen-capture";
    private static final String TAG_ENCRYPTION_REQUESTED = "encryption-requested";
    private static final String TAG_END_USER_SESSION_MESSAGE = "end_user_session_message";
    private static final String TAG_ENROLLMENT_SPECIFIC_ID = "enrollment-specific-id";
    private static final String TAG_FACTORY_RESET_PROTECTION_POLICY = "factory_reset_protection_policy";
    private static final String TAG_FORCE_EPHEMERAL_USERS = "force_ephemeral_users";
    private static final String TAG_GLOBAL_PROXY_EXCLUSION_LIST = "global-proxy-exclusion-list";
    private static final String TAG_GLOBAL_PROXY_SPEC = "global-proxy-spec";
    private static final String TAG_IS_LOGOUT_ENABLED = "is_logout_enabled";
    private static final String TAG_IS_NETWORK_LOGGING_ENABLED = "is_network_logging_enabled";
    private static final String TAG_KEEP_UNINSTALLED_PACKAGES = "keep-uninstalled-packages";
    private static final String TAG_LONG_SUPPORT_MESSAGE = "long-support-message";
    private static final String TAG_MANAGED_SUBSCRIPTIONS_POLICY = "managed_subscriptions_policy";
    private static final String TAG_MANAGE_TRUST_AGENT_FEATURES = "manage-trust-agent-features";
    private static final String TAG_MAX_FAILED_PASSWORD_WIPE = "max-failed-password-wipe";
    private static final String TAG_MAX_TIME_TO_UNLOCK = "max-time-to-unlock";
    private static final String TAG_METERED_DATA_DISABLED_PACKAGES = "metered_data_disabled_packages";
    private static final String TAG_MIN_PASSWORD_LENGTH = "min-password-length";
    private static final String TAG_MIN_PASSWORD_LETTERS = "min-password-letters";
    private static final String TAG_MIN_PASSWORD_LOWERCASE = "min-password-lowercase";
    private static final String TAG_MIN_PASSWORD_NONLETTER = "min-password-nonletter";
    private static final String TAG_MIN_PASSWORD_NUMERIC = "min-password-numeric";
    private static final String TAG_MIN_PASSWORD_SYMBOLS = "min-password-symbols";
    private static final String TAG_MIN_PASSWORD_UPPERCASE = "min-password-uppercase";
    private static final String TAG_MTE_POLICY = "mte-policy";
    private static final String TAG_NEARBY_APP_STREAMING_POLICY = "nearby-app-streaming-policy";
    private static final String TAG_NEARBY_NOTIFICATION_STREAMING_POLICY = "nearby-notification-streaming-policy";
    private static final String TAG_ORGANIZATION_COLOR = "organization-color";
    private static final String TAG_ORGANIZATION_ID = "organization-id";
    private static final String TAG_ORGANIZATION_NAME = "organization-name";
    private static final String TAG_PACKAGE_LIST_ITEM = "item";
    private static final String TAG_PACKAGE_POLICY_PACKAGE_NAMES = "package-policy-packages";
    private static final String TAG_PARENT_ADMIN = "parent-admin";
    private static final String TAG_PASSWORD_COMPLEXITY = "password-complexity";
    private static final String TAG_PASSWORD_EXPIRATION_DATE = "password-expiration-date";
    private static final String TAG_PASSWORD_EXPIRATION_TIMEOUT = "password-expiration-timeout";
    private static final String TAG_PASSWORD_HISTORY_LENGTH = "password-history-length";
    private static final String TAG_PASSWORD_QUALITY = "password-quality";
    private static final String TAG_PERMITTED_ACCESSIBILITY_SERVICES = "permitted-accessiblity-services";
    private static final String TAG_PERMITTED_IMES = "permitted-imes";
    private static final String TAG_PERMITTED_NOTIFICATION_LISTENERS = "permitted-notification-listeners";
    private static final String TAG_POLICIES = "policies";
    private static final String TAG_PREFERENTIAL_NETWORK_SERVICE_CONFIG = "preferential_network_service_config";
    private static final String TAG_PREFERENTIAL_NETWORK_SERVICE_CONFIGS = "preferential_network_service_configs";
    private static final String TAG_PREFERENTIAL_NETWORK_SERVICE_ENABLED = "preferential-network-service-enabled";
    private static final String TAG_PROFILE_MAXIMUM_TIME_OFF = "profile-max-time-off";
    private static final String TAG_PROFILE_OFF_DEADLINE = "profile-off-deadline";
    private static final String TAG_PROTECTED_PACKAGES = "protected_packages";
    private static final String TAG_PROVIDER = "provider";
    private static final String TAG_PROVISIONING_CONTEXT = "provisioning-context";
    private static final String TAG_REQUIRE_AUTO_TIME = "require_auto_time";
    private static final String TAG_RESTRICTION = "restriction";
    private static final String TAG_SHORT_SUPPORT_MESSAGE = "short-support-message";
    private static final String TAG_SMS_PACKAGE = "sms_package";
    private static final String TAG_SPECIFIES_GLOBAL_PROXY = "specifies-global-proxy";
    private static final String TAG_SSID = "ssid";
    private static final String TAG_SSID_ALLOWLIST = "ssid-allowlist";
    private static final String TAG_SSID_DENYLIST = "ssid-denylist";
    private static final String TAG_START_USER_SESSION_MESSAGE = "start_user_session_message";
    private static final String TAG_STRONG_AUTH_UNLOCK_TIMEOUT = "strong-auth-unlock-timeout";
    private static final String TAG_SUSPENDED_PACKAGES = "suspended-packages";
    private static final String TAG_SUSPEND_PERSONAL_APPS = "suspend-personal-apps";
    private static final String TAG_TEST_ONLY_ADMIN = "test-only-admin";
    private static final String TAG_TRUST_AGENT_COMPONENT = "component";
    private static final String TAG_TRUST_AGENT_COMPONENT_OPTIONS = "trust-agent-component-options";
    private static final String TAG_USB_DATA_SIGNALING = "usb-data-signaling";
    private static final String TAG_USER_RESTRICTIONS = "user-restrictions";
    private static final String TAG_WIFI_MIN_SECURITY = "wifi-min-security";
    private static final boolean USB_DATA_SIGNALING_ENABLED_DEFAULT = true;
    final Set<String> accountTypesWithManagementDisabled;
    List<String> crossProfileWidgetProviders;
    final Set<String> defaultEnabledRestrictionsAlreadySet;
    boolean disableBluetoothContactSharing;
    boolean disableCallerId;
    boolean disableCamera;
    boolean disableContactsSearch;
    boolean disableScreenCapture;
    int disabledKeyguardFeatures;
    boolean encryptionRequested;
    String endUserSessionMessage;
    boolean forceEphemeralUsers;
    String globalProxyExclusionList;
    String globalProxySpec;
    DeviceAdminInfo info;
    boolean isLogoutEnabled;
    boolean isNetworkLoggingEnabled;
    final boolean isParent;
    List<String> keepUninstalledPackages;
    long lastNetworkLoggingNotificationTimeMs;
    CharSequence longSupportMessage;
    public boolean mAdminCanGrantSensorsPermissions;
    public boolean mAlwaysOnVpnLockdown;
    public String mAlwaysOnVpnPackage;
    boolean mCommonCriteriaMode;
    PackagePolicy mCredentialManagerPolicy;
    List<String> mCrossProfileCalendarPackages;
    List<String> mCrossProfilePackages;
    String mDialerPackage;
    public String mEnrollmentSpecificId;
    FactoryResetProtectionPolicy mFactoryResetProtectionPolicy;
    PackagePolicy mManagedProfileCallerIdAccess;
    PackagePolicy mManagedProfileContactsAccess;
    ManagedSubscriptionsPolicy mManagedSubscriptionsPolicy;
    int mNearbyAppStreamingPolicy;
    int mNearbyNotificationStreamingPolicy;
    public String mOrganizationId;
    int mPasswordComplexity;
    PasswordPolicy mPasswordPolicy;
    public List<PreferentialNetworkServiceConfig> mPreferentialNetworkServiceConfigs;
    long mProfileMaximumTimeOffMillis;
    long mProfileOffDeadline;
    private String mProvisioningContext;
    String mSmsPackage;
    boolean mSuspendPersonalApps;
    boolean mUsbDataSignalingEnabled;
    int mWifiMinimumSecurityLevel;
    WifiSsidPolicy mWifiSsidPolicy;
    int maximumFailedPasswordsForWipe;
    long maximumTimeToUnlock;
    List<String> meteredDisabledPackages;
    int mtePolicy;
    int numNetworkLoggingNotifications;
    int organizationColor;
    String organizationName;
    ActiveAdmin parentAdmin;
    long passwordExpirationDate;
    long passwordExpirationTimeout;
    int passwordHistoryLength;
    List<String> permittedAccessiblityServices;
    List<String> permittedInputMethods;
    List<String> permittedNotificationListeners;
    List<String> protectedPackages;
    boolean requireAutoTime;
    CharSequence shortSupportMessage;
    boolean specifiesGlobalProxy;
    String startUserSessionMessage;
    long strongAuthUnlockTimeout;
    List<String> suspendedPackages;
    boolean testOnlyAdmin;
    ArrayMap<String, TrustAgentInfo> trustAgentInfos;
    Bundle userRestrictions;

    static class TrustAgentInfo {
        public PersistableBundle options;

        TrustAgentInfo(PersistableBundle bundle) {
            this.options = bundle;
        }
    }

    public static /* synthetic */ void $r8$lambda$1nWGc_wvVWuAbWUlMYXRYykRVuE(IndentingPrintWriter r0, String r1) {
        lambda$dumpPackagePolicy$4(r0, r1);
    }

    public static /* synthetic */ String $r8$lambda$Qfu046a5YaKgv5serOCWIpek7ic(WifiSsid r0) {
        return lambda$ssidsToStrings$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$SfzQVKV3PSKgqwO7x-ge8YfeSs0, reason: not valid java name */
    public static /* synthetic */ boolean m3322$r8$lambda$SfzQVKV3PSKgqwO7xge8YfeSs0(int r0, String r1) {
        return lambda$getGlobalUserRestrictions$3(r0, r1);
    }

    public static /* synthetic */ WifiSsid $r8$lambda$q6ahR2FC7HWaNl5LPXznLd476c8(String r0) {
        return lambda$readWifiSsids$1(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$rGKiYblPQzsE_vWYB8QTu2GCERU(int r0, String r1) {
        return lambda$getLocalUserRestrictions$2(r0, r1);
    }

    static {
        DEF_ORGANIZATION_COLOR = Color.parseColor("#00796B");
    }

    ActiveAdmin(DeviceAdminInfo info, boolean isParent) {
        this.passwordHistoryLength = 0;
        this.mPasswordPolicy = new PasswordPolicy();
        this.mPasswordComplexity = 0;
        this.mNearbyNotificationStreamingPolicy = 3;
        this.mNearbyAppStreamingPolicy = 3;
        this.mFactoryResetProtectionPolicy = null;
        this.maximumTimeToUnlock = 0;
        this.strongAuthUnlockTimeout = 0;
        this.maximumFailedPasswordsForWipe = 0;
        this.passwordExpirationTimeout = 0;
        this.passwordExpirationDate = 0;
        this.disabledKeyguardFeatures = 0;
        this.encryptionRequested = false;
        this.testOnlyAdmin = false;
        this.disableCamera = false;
        this.disableCallerId = false;
        this.disableContactsSearch = false;
        this.disableBluetoothContactSharing = true;
        this.disableScreenCapture = false;
        this.requireAutoTime = false;
        this.forceEphemeralUsers = false;
        this.isNetworkLoggingEnabled = false;
        this.isLogoutEnabled = false;
        this.numNetworkLoggingNotifications = 0;
        this.lastNetworkLoggingNotificationTimeMs = 0;
        this.mtePolicy = 0;
        this.accountTypesWithManagementDisabled = new ArraySet();
        this.specifiesGlobalProxy = false;
        this.globalProxySpec = null;
        this.globalProxyExclusionList = null;
        this.trustAgentInfos = new ArrayMap();
        this.defaultEnabledRestrictionsAlreadySet = new ArraySet();
        this.shortSupportMessage = null;
        this.longSupportMessage = null;
        this.organizationColor = DEF_ORGANIZATION_COLOR;
        this.organizationName = null;
        this.startUserSessionMessage = null;
        this.endUserSessionMessage = null;
        this.mCrossProfileCalendarPackages = Collections.emptyList();
        this.mCrossProfilePackages = Collections.emptyList();
        this.mSuspendPersonalApps = false;
        this.mProfileMaximumTimeOffMillis = 0;
        this.mProfileOffDeadline = 0;
        this.mManagedProfileCallerIdAccess = null;
        this.mManagedProfileContactsAccess = null;
        this.mCredentialManagerPolicy = null;
        this.mPreferentialNetworkServiceConfigs = List.of(PreferentialNetworkServiceConfig.DEFAULT);
        this.mUsbDataSignalingEnabled = true;
        this.mWifiMinimumSecurityLevel = 0;
        this.info = info;
        this.isParent = isParent;
    }

    ActiveAdmin getParentActiveAdmin() {
        Preconditions.checkState(!this.isParent);
        if (this.parentAdmin != null) goto L6;
        this.parentAdmin = new ActiveAdmin(this.info, true);
    L6:
        return this.parentAdmin;
    }

    boolean hasParentActiveAdmin() {
        if (this.parentAdmin == null) goto L5;
        return true;
    L5:
        return false;
    }

    int getUid() {
        return this.info.getActivityInfo().applicationInfo.uid;
    }

    public UserHandle getUserHandle() {
        return UserHandle.of(UserHandle.getUserId(this.info.getActivityInfo().applicationInfo.uid));
    }

    public void setProvisioningContext(String provisioningContext) {
        if (TextUtils.isEmpty(provisioningContext) == false) goto L5;
        return;
    L5:
        if (provisioningContext.isBlank() == false) goto L7;
        return;
    L7:
        if (provisioningContext.length() <= 1000) goto L9;
        this.mProvisioningContext = provisioningContext.substring(0, 1000);
        return;
    L9:
        this.mProvisioningContext = provisioningContext;
    }

    void writeToXml(TypedXmlSerializer out) throws IllegalArgumentException, IllegalStateException, IOException {
        if (this.info == null) goto L6;
        out.startTag(null, TAG_POLICIES);
        this.info.writePoliciesToXml(out);
        out.endTag(null, TAG_POLICIES);
    L6:
        if (this.mPasswordPolicy.quality == 0) goto L29;
        writeAttributeValueToXml(out, TAG_PASSWORD_QUALITY, this.mPasswordPolicy.quality);
        if (this.mPasswordPolicy.length == 0) goto L11;
        writeAttributeValueToXml(out, TAG_MIN_PASSWORD_LENGTH, this.mPasswordPolicy.length);
    L11:
        if (this.mPasswordPolicy.upperCase == 0) goto L14;
        writeAttributeValueToXml(out, TAG_MIN_PASSWORD_UPPERCASE, this.mPasswordPolicy.upperCase);
    L14:
        if (this.mPasswordPolicy.lowerCase == 0) goto L17;
        writeAttributeValueToXml(out, TAG_MIN_PASSWORD_LOWERCASE, this.mPasswordPolicy.lowerCase);
    L17:
        if (this.mPasswordPolicy.letters == 1) goto L20;
        writeAttributeValueToXml(out, TAG_MIN_PASSWORD_LETTERS, this.mPasswordPolicy.letters);
    L20:
        if (this.mPasswordPolicy.numeric == 1) goto L23;
        writeAttributeValueToXml(out, TAG_MIN_PASSWORD_NUMERIC, this.mPasswordPolicy.numeric);
    L23:
        if (this.mPasswordPolicy.symbols == 1) goto L26;
        writeAttributeValueToXml(out, TAG_MIN_PASSWORD_SYMBOLS, this.mPasswordPolicy.symbols);
    L26:
        if (this.mPasswordPolicy.nonLetter <= 0) goto L29;
        writeAttributeValueToXml(out, TAG_MIN_PASSWORD_NONLETTER, this.mPasswordPolicy.nonLetter);
    L29:
        if (this.passwordHistoryLength == 0) goto L31;
        writeAttributeValueToXml(out, TAG_PASSWORD_HISTORY_LENGTH, this.passwordHistoryLength);
    L31:
        long r7 = 0;
        if (this.maximumTimeToUnlock == 0) goto L35;
        writeAttributeValueToXml(out, TAG_MAX_TIME_TO_UNLOCK, this.maximumTimeToUnlock);
    L35:
        if (this.strongAuthUnlockTimeout == 259200000) goto L38;
        writeAttributeValueToXml(out, TAG_STRONG_AUTH_UNLOCK_TIMEOUT, this.strongAuthUnlockTimeout);
    L38:
        if (this.maximumFailedPasswordsForWipe == 0) goto L41;
        writeAttributeValueToXml(out, TAG_MAX_FAILED_PASSWORD_WIPE, this.maximumFailedPasswordsForWipe);
    L41:
        if (this.specifiesGlobalProxy == false) goto L49;
        writeAttributeValueToXml(out, TAG_SPECIFIES_GLOBAL_PROXY, this.specifiesGlobalProxy);
        if (this.globalProxySpec == null) goto L46;
        writeAttributeValueToXml(out, TAG_GLOBAL_PROXY_SPEC, this.globalProxySpec);
    L46:
        if (this.globalProxyExclusionList == null) goto L49;
        writeAttributeValueToXml(out, TAG_GLOBAL_PROXY_EXCLUSION_LIST, this.globalProxyExclusionList);
    L49:
        if (this.passwordExpirationTimeout == 0) goto L52;
        writeAttributeValueToXml(out, TAG_PASSWORD_EXPIRATION_TIMEOUT, this.passwordExpirationTimeout);
    L52:
        if (this.passwordExpirationDate == 0) goto L55;
        writeAttributeValueToXml(out, TAG_PASSWORD_EXPIRATION_DATE, this.passwordExpirationDate);
    L55:
        if (this.encryptionRequested == false) goto L58;
        writeAttributeValueToXml(out, TAG_ENCRYPTION_REQUESTED, this.encryptionRequested);
    L58:
        if (this.testOnlyAdmin == false) goto L61;
        writeAttributeValueToXml(out, TAG_TEST_ONLY_ADMIN, this.testOnlyAdmin);
    L61:
        if (this.disableCamera == false) goto L64;
        writeAttributeValueToXml(out, TAG_DISABLE_CAMERA, this.disableCamera);
    L64:
        if (this.disableCallerId == false) goto L67;
        writeAttributeValueToXml(out, TAG_DISABLE_CALLER_ID, this.disableCallerId);
    L67:
        if (this.disableContactsSearch == false) goto L70;
        writeAttributeValueToXml(out, TAG_DISABLE_CONTACTS_SEARCH, this.disableContactsSearch);
    L70:
        if (this.disableBluetoothContactSharing == true) goto L73;
        writeAttributeValueToXml(out, TAG_DISABLE_BLUETOOTH_CONTACT_SHARING, this.disableBluetoothContactSharing);
    L73:
        if (this.disableScreenCapture == false) goto L76;
        writeAttributeValueToXml(out, TAG_DISABLE_SCREEN_CAPTURE, this.disableScreenCapture);
    L76:
        if (this.requireAutoTime == false) goto L79;
        writeAttributeValueToXml(out, TAG_REQUIRE_AUTO_TIME, this.requireAutoTime);
    L79:
        if (this.forceEphemeralUsers == false) goto L82;
        writeAttributeValueToXml(out, TAG_FORCE_EPHEMERAL_USERS, this.forceEphemeralUsers);
    L82:
        if (this.isNetworkLoggingEnabled == false) goto L85;
        out.startTag(null, TAG_IS_NETWORK_LOGGING_ENABLED);
        out.attributeBoolean(null, ATTR_VALUE, this.isNetworkLoggingEnabled);
        out.attributeInt(null, ATTR_NUM_NETWORK_LOGGING_NOTIFICATIONS, this.numNetworkLoggingNotifications);
        out.attributeLong(null, ATTR_LAST_NETWORK_LOGGING_NOTIFICATION, this.lastNetworkLoggingNotificationTimeMs);
        out.endTag(null, TAG_IS_NETWORK_LOGGING_ENABLED);
    L85:
        if (this.disabledKeyguardFeatures == 0) goto L88;
        writeAttributeValueToXml(out, TAG_DISABLE_KEYGUARD_FEATURES, this.disabledKeyguardFeatures);
    L88:
        if (this.accountTypesWithManagementDisabled.isEmpty() == true) goto L91;
        writeAttributeValuesToXml(out, TAG_DISABLE_ACCOUNT_MANAGEMENT, TAG_ACCOUNT_TYPE, this.accountTypesWithManagementDisabled);
    L91:
        if (this.trustAgentInfos.isEmpty() == true) goto L106;
        Set<Map.Entry<String, TrustAgentInfo>> set = this.trustAgentInfos.entrySet();
        out.startTag(null, TAG_MANAGE_TRUST_AGENT_FEATURES);
        Iterator<Map.Entry<String, TrustAgentInfo>> r10 = set.iterator();
    L94:
        if (r10.hasNext() == false) goto L105;
        Map.Entry<String, TrustAgentInfo> entry = r10.next();
        TrustAgentInfo trustAgentInfo = entry.getValue();
        out.startTag(null, TAG_TRUST_AGENT_COMPONENT);
        out.attribute(null, ATTR_VALUE, entry.getKey());
        if (trustAgentInfo.options == null) goto L103;
        out.startTag(null, TAG_TRUST_AGENT_COMPONENT_OPTIONS);
        trustAgentInfo.options.saveToXml(out);     // Catch: XmlPullParserException -> L100
    L102:
        out.endTag(null, TAG_TRUST_AGENT_COMPONENT_OPTIONS);
    L104:
        out.endTag(null, TAG_TRUST_AGENT_COMPONENT);
        r7 = r7;
    L100:
        e = move-exception;
        Slogf.e("DevicePolicyManager", e, "Failed to save TrustAgent options", new Object[0]);
        goto L102
    L103:
        r7 = r7;
        goto L104
    L105:
        long r16 = r7;
        out.endTag(null, TAG_MANAGE_TRUST_AGENT_FEATURES);
    L108:
        if (this.crossProfileWidgetProviders != null) goto L110;
    L112:
        writePackageListToXml(out, TAG_PERMITTED_ACCESSIBILITY_SERVICES, this.permittedAccessiblityServices);
        writePackageListToXml(out, TAG_PERMITTED_IMES, this.permittedInputMethods);
        writePackageListToXml(out, TAG_PERMITTED_NOTIFICATION_LISTENERS, this.permittedNotificationListeners);
        writePackageListToXml(out, TAG_KEEP_UNINSTALLED_PACKAGES, this.keepUninstalledPackages);
        writePackageListToXml(out, TAG_METERED_DATA_DISABLED_PACKAGES, this.meteredDisabledPackages);
        writePackageListToXml(out, TAG_PROTECTED_PACKAGES, this.protectedPackages);
        writePackageListToXml(out, TAG_SUSPENDED_PACKAGES, this.suspendedPackages);
        if (hasUserRestrictions() == false) goto L116;
        UserRestrictionsUtils.writeRestrictions(out, this.userRestrictions, TAG_USER_RESTRICTIONS);
    L116:
        if (this.defaultEnabledRestrictionsAlreadySet.isEmpty() == true) goto L119;
        writeAttributeValuesToXml(out, TAG_DEFAULT_ENABLED_USER_RESTRICTIONS, TAG_RESTRICTION, this.defaultEnabledRestrictionsAlreadySet);
    L119:
        if (TextUtils.isEmpty(this.shortSupportMessage) == true) goto L122;
        writeTextToXml(out, TAG_SHORT_SUPPORT_MESSAGE, this.shortSupportMessage.toString());
    L122:
        if (TextUtils.isEmpty(this.longSupportMessage) == true) goto L125;
        writeTextToXml(out, TAG_LONG_SUPPORT_MESSAGE, this.longSupportMessage.toString());
    L125:
        if (this.parentAdmin == null) goto L128;
        out.startTag(null, TAG_PARENT_ADMIN);
        this.parentAdmin.writeToXml(out);
        out.endTag(null, TAG_PARENT_ADMIN);
    L128:
        if (this.organizationColor == DEF_ORGANIZATION_COLOR) goto L131;
        writeAttributeValueToXml(out, TAG_ORGANIZATION_COLOR, this.organizationColor);
    L131:
        if (this.organizationName == null) goto L134;
        writeTextToXml(out, TAG_ORGANIZATION_NAME, this.organizationName);
    L134:
        if (this.isLogoutEnabled == false) goto L137;
        writeAttributeValueToXml(out, TAG_IS_LOGOUT_ENABLED, this.isLogoutEnabled);
    L137:
        if (this.startUserSessionMessage == null) goto L140;
        writeTextToXml(out, TAG_START_USER_SESSION_MESSAGE, this.startUserSessionMessage);
    L140:
        if (this.endUserSessionMessage == null) goto L143;
        writeTextToXml(out, TAG_END_USER_SESSION_MESSAGE, this.endUserSessionMessage);
    L143:
        if (this.mCrossProfileCalendarPackages != null) goto L145;
        out.startTag(null, TAG_CROSS_PROFILE_CALENDAR_PACKAGES_NULL);
        out.endTag(null, TAG_CROSS_PROFILE_CALENDAR_PACKAGES_NULL);
    L146:
        writePackageListToXml(out, TAG_CROSS_PROFILE_PACKAGES, this.mCrossProfilePackages);
        if (this.mFactoryResetProtectionPolicy == null) goto L150;
        out.startTag(null, TAG_FACTORY_RESET_PROTECTION_POLICY);
        this.mFactoryResetProtectionPolicy.writeToXml(out);
        out.endTag(null, TAG_FACTORY_RESET_PROTECTION_POLICY);
    L150:
        if (this.mSuspendPersonalApps == false) goto L153;
        writeAttributeValueToXml(out, TAG_SUSPEND_PERSONAL_APPS, this.mSuspendPersonalApps);
    L153:
        if (this.mProfileMaximumTimeOffMillis == r16) goto L156;
        writeAttributeValueToXml(out, TAG_PROFILE_MAXIMUM_TIME_OFF, this.mProfileMaximumTimeOffMillis);
    L156:
        if (this.mProfileMaximumTimeOffMillis == r16) goto L159;
        writeAttributeValueToXml(out, TAG_PROFILE_OFF_DEADLINE, this.mProfileOffDeadline);
    L159:
        if (TextUtils.isEmpty(this.mAlwaysOnVpnPackage) == true) goto L162;
        writeAttributeValueToXml(out, TAG_ALWAYS_ON_VPN_PACKAGE, this.mAlwaysOnVpnPackage);
    L162:
        if (this.mAlwaysOnVpnLockdown == false) goto L165;
        writeAttributeValueToXml(out, TAG_ALWAYS_ON_VPN_LOCKDOWN, this.mAlwaysOnVpnLockdown);
    L165:
        if (this.mCommonCriteriaMode == false) goto L168;
        writeAttributeValueToXml(out, TAG_COMMON_CRITERIA_MODE, this.mCommonCriteriaMode);
    L168:
        if (this.mPasswordComplexity == 0) goto L171;
        writeAttributeValueToXml(out, TAG_PASSWORD_COMPLEXITY, this.mPasswordComplexity);
    L171:
        if (this.mNearbyNotificationStreamingPolicy == 3) goto L174;
        writeAttributeValueToXml(out, TAG_NEARBY_NOTIFICATION_STREAMING_POLICY, this.mNearbyNotificationStreamingPolicy);
    L174:
        if (this.mNearbyAppStreamingPolicy == 3) goto L177;
        writeAttributeValueToXml(out, TAG_NEARBY_APP_STREAMING_POLICY, this.mNearbyAppStreamingPolicy);
    L177:
        if (TextUtils.isEmpty(this.mOrganizationId) == true) goto L180;
        writeTextToXml(out, TAG_ORGANIZATION_ID, this.mOrganizationId);
    L180:
        if (TextUtils.isEmpty(this.mEnrollmentSpecificId) == true) goto L182;
        writeTextToXml(out, TAG_ENROLLMENT_SPECIFIC_ID, this.mEnrollmentSpecificId);
    L182:
        writeAttributeValueToXml(out, TAG_ADMIN_CAN_GRANT_SENSORS_PERMISSIONS, this.mAdminCanGrantSensorsPermissions);
        if (this.mUsbDataSignalingEnabled == true) goto L186;
        writeAttributeValueToXml(out, TAG_USB_DATA_SIGNALING, this.mUsbDataSignalingEnabled);
    L186:
        if (this.mWifiMinimumSecurityLevel == 0) goto L189;
        writeAttributeValueToXml(out, TAG_WIFI_MIN_SECURITY, this.mWifiMinimumSecurityLevel);
    L189:
        if (this.mWifiSsidPolicy == null) goto L197;
        List<String> ssids = ssidsToStrings(this.mWifiSsidPolicy.getSsids());
        if (this.mWifiSsidPolicy.getPolicyType() != 0) goto L194;
        writeAttributeValuesToXml(out, TAG_SSID_ALLOWLIST, TAG_SSID, ssids);
        goto L197
    L194:
        if (this.mWifiSsidPolicy.getPolicyType() != 1) goto L197;
        writeAttributeValuesToXml(out, TAG_SSID_DENYLIST, TAG_SSID, ssids);
    L197:
        if (this.mPreferentialNetworkServiceConfigs.isEmpty() == true) goto L204;
        out.startTag(null, TAG_PREFERENTIAL_NETWORK_SERVICE_CONFIGS);
        Iterator<PreferentialNetworkServiceConfig> r4 = this.mPreferentialNetworkServiceConfigs.iterator();
    L200:
        if (r4.hasNext() == false) goto L202;
        PreferentialNetworkServiceConfig config = r4.next();
        config.writeToXml(out);
        goto L200
    L202:
        out.endTag(null, TAG_PREFERENTIAL_NETWORK_SERVICE_CONFIGS);
    L204:
        if (this.mtePolicy == 0) goto L206;
        writeAttributeValueToXml(out, TAG_MTE_POLICY, this.mtePolicy);
    L206:
        writePackagePolicy(out, TAG_CROSS_PROFILE_CALLER_ID_POLICY, this.mManagedProfileCallerIdAccess);
        writePackagePolicy(out, TAG_CROSS_PROFILE_CONTACTS_SEARCH_POLICY, this.mManagedProfileContactsAccess);
        writePackagePolicy(out, TAG_CREDENTIAL_MANAGER_POLICY, this.mCredentialManagerPolicy);
        if (this.mManagedSubscriptionsPolicy == null) goto L210;
        out.startTag(null, TAG_MANAGED_SUBSCRIPTIONS_POLICY);
        this.mManagedSubscriptionsPolicy.saveToXml(out);
        out.endTag(null, TAG_MANAGED_SUBSCRIPTIONS_POLICY);
    L210:
        if (TextUtils.isEmpty(this.mDialerPackage) == true) goto L213;
        writeAttributeValueToXml(out, TAG_DIALER_PACKAGE, this.mDialerPackage);
    L213:
        if (TextUtils.isEmpty(this.mSmsPackage) == true) goto L216;
        writeAttributeValueToXml(out, TAG_SMS_PACKAGE, this.mSmsPackage);
    L216:
        if (TextUtils.isEmpty(this.mProvisioningContext) == true) goto L225;
        out.startTag(null, TAG_PROVISIONING_CONTEXT);
        out.attribute(null, ATTR_VALUE, this.mProvisioningContext);
        out.endTag(null, TAG_PROVISIONING_CONTEXT);
        return;
    L225:
        return;
    L145:
        writePackageListToXml(out, TAG_CROSS_PROFILE_CALENDAR_PACKAGES, this.mCrossProfileCalendarPackages);
        goto L146
    L110:
        if (this.crossProfileWidgetProviders.isEmpty() == true) goto L112;
        writeAttributeValuesToXml(out, TAG_CROSS_PROFILE_WIDGET_PROVIDERS, TAG_PROVIDER, this.crossProfileWidgetProviders);
        goto L112
    L106:
        r16 = 0;
        goto L108
    }

    private void writePackagePolicy(TypedXmlSerializer out, String tag, PackagePolicy packagePolicy) throws IOException {
        if (packagePolicy != null) goto L4;
        return;
    L4:
        out.startTag(null, tag);
        out.attributeInt(null, ATTR_PACKAGE_POLICY_MODE, packagePolicy.getPolicyType());
        writePackageListToXml(out, TAG_PACKAGE_POLICY_PACKAGE_NAMES, new ArrayList(packagePolicy.getPackageNames()));
        out.endTag(null, tag);
    }

    private List<String> ssidsToStrings(Set<WifiSsid> ssids) {
        return (List) ssids.stream().map(new ActiveAdmin$$ExternalSyntheticLambda0()).collect(Collectors.toList());
    }

    private static /* synthetic */ String lambda$ssidsToStrings$0(WifiSsid ssid) {
        return new String(ssid.getBytes(), StandardCharsets.UTF_8);
    }

    void writeTextToXml(TypedXmlSerializer out, String tag, String text) throws IOException {
        out.startTag(null, tag);
        out.text(text);
        out.endTag(null, tag);
    }

    void writePackageListToXml(TypedXmlSerializer out, String outerTag, List<String> packageList) throws IllegalArgumentException, IllegalStateException, IOException {
        if (packageList != null) goto L4;
        return;
    L4:
        writeAttributeValuesToXml(out, outerTag, "item", packageList);
    }

    void writeAttributeValueToXml(TypedXmlSerializer out, String tag, String value) throws IOException {
        out.startTag(null, tag);
        out.attribute(null, ATTR_VALUE, value);
        out.endTag(null, tag);
    }

    void writeAttributeValueToXml(TypedXmlSerializer out, String tag, int value) throws IOException {
        out.startTag(null, tag);
        out.attributeInt(null, ATTR_VALUE, value);
        out.endTag(null, tag);
    }

    void writeAttributeValueToXml(TypedXmlSerializer out, String tag, long value) throws IOException {
        out.startTag(null, tag);
        out.attributeLong(null, ATTR_VALUE, value);
        out.endTag(null, tag);
    }

    void writeAttributeValueToXml(TypedXmlSerializer out, String tag, boolean value) throws IOException {
        out.startTag(null, tag);
        out.attributeBoolean(null, ATTR_VALUE, value);
        out.endTag(null, tag);
    }

    void writeAttributeValuesToXml(TypedXmlSerializer out, String outerTag, String innerTag, Collection<String> values) throws IOException {
        out.startTag(null, outerTag);
        Iterator<String> r1 = values.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String value = r1.next();
        out.startTag(null, innerTag);
        out.attribute(null, ATTR_VALUE, value);
        out.endTag(null, innerTag);
        goto L4
    L6:
        out.endTag(null, outerTag);
    }

    void readFromXml(TypedXmlPullParser parser, boolean shouldOverridePolicies) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L281;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tag = parser.getName();
        if (TAG_POLICIES.equals(tag) == true) goto L16;
        if (TAG_PASSWORD_QUALITY.equals(tag) == true) goto L20;
        if (TAG_MIN_PASSWORD_LENGTH.equals(tag) == true) goto L23;
        if (TAG_PASSWORD_HISTORY_LENGTH.equals(tag) == true) goto L26;
        if (TAG_MIN_PASSWORD_UPPERCASE.equals(tag) == true) goto L29;
        if (TAG_MIN_PASSWORD_LOWERCASE.equals(tag) == true) goto L32;
        if (TAG_MIN_PASSWORD_LETTERS.equals(tag) == true) goto L35;
        if (TAG_MIN_PASSWORD_NUMERIC.equals(tag) == true) goto L38;
        if (TAG_MIN_PASSWORD_SYMBOLS.equals(tag) == true) goto L41;
        if (TAG_MIN_PASSWORD_NONLETTER.equals(tag) == true) goto L44;
        if (TAG_MAX_TIME_TO_UNLOCK.equals(tag) == true) goto L47;
        if (TAG_STRONG_AUTH_UNLOCK_TIMEOUT.equals(tag) == true) goto L50;
        if (TAG_MAX_FAILED_PASSWORD_WIPE.equals(tag) == true) goto L53;
        if (TAG_SPECIFIES_GLOBAL_PROXY.equals(tag) == true) goto L56;
        if (TAG_GLOBAL_PROXY_SPEC.equals(tag) == true) goto L59;
        if (TAG_GLOBAL_PROXY_EXCLUSION_LIST.equals(tag) == true) goto L62;
        if (TAG_PASSWORD_EXPIRATION_TIMEOUT.equals(tag) == true) goto L65;
        if (TAG_PASSWORD_EXPIRATION_DATE.equals(tag) == true) goto L68;
        if (TAG_ENCRYPTION_REQUESTED.equals(tag) == true) goto L71;
        if (TAG_TEST_ONLY_ADMIN.equals(tag) == true) goto L74;
        if (TAG_DISABLE_CAMERA.equals(tag) == true) goto L77;
        if (TAG_DISABLE_CALLER_ID.equals(tag) == true) goto L80;
        if (TAG_DISABLE_CONTACTS_SEARCH.equals(tag) == true) goto L83;
        if (TAG_DISABLE_BLUETOOTH_CONTACT_SHARING.equals(tag) == true) goto L86;
        if (TAG_DISABLE_SCREEN_CAPTURE.equals(tag) == true) goto L89;
        if (TAG_REQUIRE_AUTO_TIME.equals(tag) == true) goto L92;
        if (TAG_FORCE_EPHEMERAL_USERS.equals(tag) == true) goto L95;
        if (TAG_IS_NETWORK_LOGGING_ENABLED.equals(tag) == true) goto L98;
        if (TAG_DISABLE_KEYGUARD_FEATURES.equals(tag) == true) goto L101;
        if (TAG_DISABLE_ACCOUNT_MANAGEMENT.equals(tag) == true) goto L104;
        if (TAG_MANAGE_TRUST_AGENT_FEATURES.equals(tag) == true) goto L107;
        if (TAG_CROSS_PROFILE_WIDGET_PROVIDERS.equals(tag) == true) goto L110;
        if (TAG_PERMITTED_ACCESSIBILITY_SERVICES.equals(tag) == true) goto L113;
        if (TAG_PERMITTED_IMES.equals(tag) == true) goto L116;
        if (TAG_PERMITTED_NOTIFICATION_LISTENERS.equals(tag) == true) goto L119;
        if (TAG_KEEP_UNINSTALLED_PACKAGES.equals(tag) == true) goto L122;
        if (TAG_METERED_DATA_DISABLED_PACKAGES.equals(tag) == true) goto L125;
        if (TAG_PROTECTED_PACKAGES.equals(tag) == true) goto L128;
        if (TAG_SUSPENDED_PACKAGES.equals(tag) == true) goto L131;
        if (TAG_USER_RESTRICTIONS.equals(tag) == true) goto L134;
        if (TAG_DEFAULT_ENABLED_USER_RESTRICTIONS.equals(tag) == true) goto L137;
        if (TAG_SHORT_SUPPORT_MESSAGE.equals(tag) == true) goto L141;
        if (TAG_LONG_SUPPORT_MESSAGE.equals(tag) == true) goto L147;
        if (TAG_PARENT_ADMIN.equals(tag) == true) goto L152;
        if (TAG_ORGANIZATION_COLOR.equals(tag) == true) goto L155;
        if (TAG_ORGANIZATION_NAME.equals(tag) == true) goto L159;
        if (TAG_IS_LOGOUT_ENABLED.equals(tag) == true) goto L164;
        if (TAG_START_USER_SESSION_MESSAGE.equals(tag) == true) goto L168;
        if (TAG_END_USER_SESSION_MESSAGE.equals(tag) == true) goto L174;
        if (TAG_CROSS_PROFILE_CALENDAR_PACKAGES.equals(tag) == true) goto L179;
        if (TAG_CROSS_PROFILE_CALENDAR_PACKAGES_NULL.equals(tag) == true) goto L182;
        if (TAG_CROSS_PROFILE_PACKAGES.equals(tag) == true) goto L185;
        if (TAG_FACTORY_RESET_PROTECTION_POLICY.equals(tag) == true) goto L188;
        if (TAG_SUSPEND_PERSONAL_APPS.equals(tag) == true) goto L191;
        if (TAG_PROFILE_MAXIMUM_TIME_OFF.equals(tag) == true) goto L194;
        if (TAG_PROFILE_OFF_DEADLINE.equals(tag) == true) goto L197;
        if (TAG_ALWAYS_ON_VPN_PACKAGE.equals(tag) == true) goto L200;
        if (TAG_ALWAYS_ON_VPN_LOCKDOWN.equals(tag) == true) goto L203;
        if (TAG_PREFERENTIAL_NETWORK_SERVICE_ENABLED.equals(tag) == true) goto L206;
        if (TAG_COMMON_CRITERIA_MODE.equals(tag) == true) goto L212;
        if (TAG_PASSWORD_COMPLEXITY.equals(tag) == true) goto L215;
        if (TAG_NEARBY_NOTIFICATION_STREAMING_POLICY.equals(tag) == true) goto L218;
        if (TAG_NEARBY_APP_STREAMING_POLICY.equals(tag) == true) goto L221;
        if (TAG_ORGANIZATION_ID.equals(tag) == true) goto L225;
        if (TAG_ENROLLMENT_SPECIFIC_ID.equals(tag) == true) goto L231;
        if (TAG_ADMIN_CAN_GRANT_SENSORS_PERMISSIONS.equals(tag) == true) goto L236;
        if (TAG_USB_DATA_SIGNALING.equals(tag) == true) goto L239;
        if (TAG_WIFI_MIN_SECURITY.equals(tag) == true) goto L242;
        if (TAG_SSID_ALLOWLIST.equals(tag) == true) goto L245;
        if (TAG_SSID_DENYLIST.equals(tag) == true) goto L248;
        if (TAG_PREFERENTIAL_NETWORK_SERVICE_CONFIGS.equals(tag) == true) goto L251;
        if (TAG_MTE_POLICY.equals(tag) == true) goto L257;
        if (TAG_CROSS_PROFILE_CALLER_ID_POLICY.equals(tag) == true) goto L260;
        if (TAG_CROSS_PROFILE_CONTACTS_SEARCH_POLICY.equals(tag) == true) goto L263;
        if (TAG_MANAGED_SUBSCRIPTIONS_POLICY.equals(tag) == true) goto L266;
        if (TAG_CREDENTIAL_MANAGER_POLICY.equals(tag) == true) goto L269;
        if (TAG_DIALER_PACKAGE.equals(tag) == true) goto L272;
        if (TAG_SMS_PACKAGE.equals(tag) == true) goto L275;
        if (TAG_PROVISIONING_CONTEXT.equals(tag) == true) goto L278;
        Slogf.w("DevicePolicyManager", "Unknown admin tag: %s", new Object[]{tag});
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L278:
        this.mProvisioningContext = parser.getAttributeValue(null, ATTR_VALUE);
        goto L3
    L275:
        this.mSmsPackage = parser.getAttributeValue(null, ATTR_VALUE);
        goto L3
    L272:
        this.mDialerPackage = parser.getAttributeValue(null, ATTR_VALUE);
        goto L3
    L269:
        this.mCredentialManagerPolicy = readPackagePolicy(parser);
        goto L3
    L266:
        this.mManagedSubscriptionsPolicy = ManagedSubscriptionsPolicy.readFromXml(parser);
        goto L3
    L263:
        this.mManagedProfileContactsAccess = readPackagePolicy(parser);
        goto L3
    L260:
        this.mManagedProfileCallerIdAccess = readPackagePolicy(parser);
        goto L3
    L257:
        this.mtePolicy = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L251:
        List<PreferentialNetworkServiceConfig> configs = getPreferentialNetworkServiceConfigs(parser, tag);
        if (configs.isEmpty() == true) goto L3;
        this.mPreferentialNetworkServiceConfigs = configs;
        goto L3
    L248:
        List<WifiSsid> ssids = readWifiSsids(parser, TAG_SSID);
        this.mWifiSsidPolicy = new WifiSsidPolicy(1, new ArraySet(ssids));
        goto L3
    L245:
        List<WifiSsid> ssids2 = readWifiSsids(parser, TAG_SSID);
        this.mWifiSsidPolicy = new WifiSsidPolicy(0, new ArraySet(ssids2));
        goto L3
    L242:
        this.mWifiMinimumSecurityLevel = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L239:
        this.mUsbDataSignalingEnabled = parser.getAttributeBoolean(null, ATTR_VALUE, true);
        goto L3
    L236:
        this.mAdminCanGrantSensorsPermissions = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L231:
        if (parser.next() == 4) goto L232;
        Slogf.w("DevicePolicyManager", "Missing Enrollment-specific ID.");
        goto L3
    L232:
        this.mEnrollmentSpecificId = parser.getText();
        goto L3
    L225:
        if (parser.next() == 4) goto L226;
        Slogf.w("DevicePolicyManager", "Missing Organization ID.");
        goto L3
    L226:
        this.mOrganizationId = parser.getText();
        goto L3
    L221:
        this.mNearbyAppStreamingPolicy = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L218:
        this.mNearbyNotificationStreamingPolicy = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L215:
        this.mPasswordComplexity = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L212:
        this.mCommonCriteriaMode = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L206:
        boolean preferentialNetworkServiceEnabled = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        if (preferentialNetworkServiceEnabled == false) goto L3;
        PreferentialNetworkServiceConfig.Builder configBuilder = new PreferentialNetworkServiceConfig.Builder();
        configBuilder.setEnabled(preferentialNetworkServiceEnabled);
        configBuilder.setNetworkId(1);
        this.mPreferentialNetworkServiceConfigs = List.of(configBuilder.build());
        goto L3
    L203:
        this.mAlwaysOnVpnLockdown = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L200:
        this.mAlwaysOnVpnPackage = parser.getAttributeValue(null, ATTR_VALUE);
        goto L3
    L197:
        this.mProfileOffDeadline = parser.getAttributeLong(null, ATTR_VALUE);
        goto L3
    L194:
        this.mProfileMaximumTimeOffMillis = parser.getAttributeLong(null, ATTR_VALUE);
        goto L3
    L191:
        this.mSuspendPersonalApps = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L188:
        this.mFactoryResetProtectionPolicy = FactoryResetProtectionPolicy.readFromXml(parser);
        goto L3
    L185:
        this.mCrossProfilePackages = readPackageList(parser, tag);
        goto L3
    L182:
        this.mCrossProfileCalendarPackages = null;
        goto L3
    L179:
        this.mCrossProfileCalendarPackages = readPackageList(parser, tag);
        goto L3
    L174:
        if (parser.next() == 4) goto L175;
        Slogf.w("DevicePolicyManager", "Missing text when loading end session message");
        goto L3
    L175:
        this.endUserSessionMessage = parser.getText();
        goto L3
    L168:
        if (parser.next() == 4) goto L169;
        Slogf.w("DevicePolicyManager", "Missing text when loading start session message");
        goto L3
    L169:
        this.startUserSessionMessage = parser.getText();
        goto L3
    L164:
        this.isLogoutEnabled = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L159:
        if (parser.next() == 4) goto L160;
        Slogf.w("DevicePolicyManager", "Missing text when loading organization name");
        goto L3
    L160:
        this.organizationName = parser.getText();
        goto L3
    L155:
        this.organizationColor = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L152:
        Preconditions.checkState(!this.isParent);
        this.parentAdmin = new ActiveAdmin(this.info, true);
        this.parentAdmin.readFromXml(parser, shouldOverridePolicies);
        goto L3
    L147:
        if (parser.next() == 4) goto L148;
        Slogf.w("DevicePolicyManager", "Missing text when loading long support message");
        goto L3
    L148:
        this.longSupportMessage = parser.getText();
        goto L3
    L141:
        if (parser.next() == 4) goto L142;
        Slogf.w("DevicePolicyManager", "Missing text when loading short support message");
        goto L3
    L142:
        this.shortSupportMessage = parser.getText();
        goto L3
    L137:
        readAttributeValues(parser, TAG_RESTRICTION, this.defaultEnabledRestrictionsAlreadySet);
        goto L3
    L134:
        this.userRestrictions = UserRestrictionsUtils.readRestrictions(parser);
        goto L3
    L131:
        this.suspendedPackages = readPackageList(parser, tag);
        goto L3
    L128:
        this.protectedPackages = readPackageList(parser, tag);
        goto L3
    L125:
        this.meteredDisabledPackages = readPackageList(parser, tag);
        goto L3
    L122:
        this.keepUninstalledPackages = readPackageList(parser, tag);
        goto L3
    L119:
        this.permittedNotificationListeners = readPackageList(parser, tag);
        goto L3
    L116:
        this.permittedInputMethods = readPackageList(parser, tag);
        goto L3
    L113:
        this.permittedAccessiblityServices = readPackageList(parser, tag);
        goto L3
    L110:
        this.crossProfileWidgetProviders = new ArrayList();
        readAttributeValues(parser, TAG_PROVIDER, this.crossProfileWidgetProviders);
        goto L3
    L107:
        this.trustAgentInfos = getAllTrustAgentInfos(parser, tag);
        goto L3
    L104:
        readAttributeValues(parser, TAG_ACCOUNT_TYPE, this.accountTypesWithManagementDisabled);
        goto L3
    L101:
        this.disabledKeyguardFeatures = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L98:
        this.isNetworkLoggingEnabled = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        this.lastNetworkLoggingNotificationTimeMs = parser.getAttributeLong(null, ATTR_LAST_NETWORK_LOGGING_NOTIFICATION);
        this.numNetworkLoggingNotifications = parser.getAttributeInt(null, ATTR_NUM_NETWORK_LOGGING_NOTIFICATIONS);
        goto L3
    L95:
        this.forceEphemeralUsers = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L92:
        this.requireAutoTime = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L89:
        this.disableScreenCapture = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L86:
        this.disableBluetoothContactSharing = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L83:
        this.disableContactsSearch = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L80:
        this.disableCallerId = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L77:
        this.disableCamera = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L74:
        this.testOnlyAdmin = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L71:
        this.encryptionRequested = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L68:
        this.passwordExpirationDate = parser.getAttributeLong(null, ATTR_VALUE);
        goto L3
    L65:
        this.passwordExpirationTimeout = parser.getAttributeLong(null, ATTR_VALUE);
        goto L3
    L62:
        this.globalProxyExclusionList = parser.getAttributeValue(null, ATTR_VALUE);
        goto L3
    L59:
        this.globalProxySpec = parser.getAttributeValue(null, ATTR_VALUE);
        goto L3
    L56:
        this.specifiesGlobalProxy = parser.getAttributeBoolean(null, ATTR_VALUE, false);
        goto L3
    L53:
        this.maximumFailedPasswordsForWipe = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L50:
        this.strongAuthUnlockTimeout = parser.getAttributeLong(null, ATTR_VALUE);
        goto L3
    L47:
        this.maximumTimeToUnlock = parser.getAttributeLong(null, ATTR_VALUE);
        goto L3
    L44:
        this.mPasswordPolicy.nonLetter = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L41:
        this.mPasswordPolicy.symbols = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L38:
        this.mPasswordPolicy.numeric = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L35:
        this.mPasswordPolicy.letters = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L32:
        this.mPasswordPolicy.lowerCase = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L29:
        this.mPasswordPolicy.upperCase = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L26:
        this.passwordHistoryLength = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L23:
        this.mPasswordPolicy.length = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L20:
        this.mPasswordPolicy.quality = parser.getAttributeInt(null, ATTR_VALUE);
        goto L3
    L16:
        if (shouldOverridePolicies == false) goto L3;
        Slogf.d("DevicePolicyManager", "Overriding device admin policies from XML.");
        this.info.readPoliciesFromXml(parser);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private PackagePolicy readPackagePolicy(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        int policy = parser.getAttributeInt(null, ATTR_PACKAGE_POLICY_MODE);
        Set<String> packageNames = new ArraySet(readPackageList(parser, TAG_PACKAGE_POLICY_PACKAGE_NAMES));
        return new PackagePolicy(policy, packageNames);
    }

    private List<WifiSsid> readWifiSsids(TypedXmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        List<String> ssidStrings = new ArrayList();
        readAttributeValues(parser, tag, ssidStrings);
        List<WifiSsid> ssids = (List) ssidStrings.stream().map(new ActiveAdmin$$ExternalSyntheticLambda2()).collect(Collectors.toList());
        return ssids;
    }

    private static /* synthetic */ WifiSsid lambda$readWifiSsids$1(String ssid) {
        return WifiSsid.fromBytes(ssid.getBytes(StandardCharsets.UTF_8));
    }

    private List<String> readPackageList(TypedXmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        List<String> result = new ArrayList();
        int outerDepth = parser.getDepth();
    L3:
        int outerType = parser.next();
        if (outerType == 1) goto L23;
        if (outerType == 3) goto L8;
    L10:
        if (outerType == 3) goto L3;
        if (outerType == 4) goto L3;
        String outerTag = parser.getName();
        if ("item".equals(outerTag) == true) goto L16;
        Slogf.w("DevicePolicyManager", "Unknown tag under %s: ", new Object[]{tag, outerTag});
        goto L3
    L16:
        String packageName = parser.getAttributeValue(null, ATTR_VALUE);
        if (packageName != null) goto L18;
        Slogf.w("DevicePolicyManager", "Package name missing under %s", new Object[]{outerTag});
        goto L3
    L18:
        result.add(packageName);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L23:
        return result;
    }

    private void readAttributeValues(TypedXmlPullParser parser, String tag, Collection<String> result) throws XmlPullParserException, IOException {
        result.clear();
        int outerDepthDAM = parser.getDepth();
    L3:
        int typeDAM = parser.next();
        if (typeDAM == 1) goto L19;
        if (typeDAM == 3) goto L8;
    L10:
        if (typeDAM == 3) goto L3;
        if (typeDAM == 4) goto L3;
        String tagDAM = parser.getName();
        if (tag.equals(tagDAM) == true) goto L16;
        Slogf.e("DevicePolicyManager", "Expected tag %s but found %s", new Object[]{tag, tagDAM});
        goto L3
    L16:
        result.add(parser.getAttributeValue(null, ATTR_VALUE));
        goto L3
    L8:
        if (parser.getDepth() > outerDepthDAM) goto L10;
        return;
    }

    private ArrayMap<String, TrustAgentInfo> getAllTrustAgentInfos(TypedXmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        int outerDepthDAM = parser.getDepth();
        ArrayMap<String, TrustAgentInfo> result = new ArrayMap();
    L3:
        int typeDAM = parser.next();
        if (typeDAM == 1) goto L19;
        if (typeDAM == 3) goto L8;
    L10:
        if (typeDAM == 3) goto L3;
        if (typeDAM == 4) goto L3;
        String tagDAM = parser.getName();
        if (TAG_TRUST_AGENT_COMPONENT.equals(tagDAM) == true) goto L16;
        Slogf.w("DevicePolicyManager", "Unknown tag under %s: %s", new Object[]{tag, tagDAM});
        goto L3
    L16:
        String component = parser.getAttributeValue(null, ATTR_VALUE);
        TrustAgentInfo trustAgentInfo = getTrustAgentInfo(parser, tag);
        result.put(component, trustAgentInfo);
        goto L3
    L8:
        if (parser.getDepth() > outerDepthDAM) goto L10;
    L19:
        return result;
    }

    private TrustAgentInfo getTrustAgentInfo(TypedXmlPullParser parser, String outerTag) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        TrustAgentInfo result = new TrustAgentInfo(null);
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tag = parser.getName();
        if (TAG_TRUST_AGENT_COMPONENT_OPTIONS.equals(tag) == true) goto L16;
        Slogf.w("DevicePolicyManager", "Unknown tag under %s: %s", new Object[]{outerTag, tag});
        goto L3
    L16:
        result.options = PersistableBundle.restoreFromXml(parser);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L19:
        return result;
    }

    private List<PreferentialNetworkServiceConfig> getPreferentialNetworkServiceConfigs(TypedXmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        List<PreferentialNetworkServiceConfig> result = new ArrayList();
    L3:
        int typeDAM = parser.next();
        if (typeDAM == 1) goto L19;
        if (typeDAM == 3) goto L8;
    L10:
        if (typeDAM == 3) goto L3;
        if (typeDAM == 4) goto L3;
        String tagDAM = parser.getName();
        if (TAG_PREFERENTIAL_NETWORK_SERVICE_CONFIG.equals(tagDAM) == true) goto L16;
        Slogf.w("DevicePolicyManager", "Unknown tag under %s: %s", new Object[]{tag, tagDAM});
        goto L3
    L16:
        PreferentialNetworkServiceConfig preferentialNetworkServiceConfig = PreferentialNetworkServiceConfig.getPreferentialNetworkServiceConfig(parser, tag);
        result.add(preferentialNetworkServiceConfig);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L19:
        return result;
    }

    boolean hasUserRestrictions() {
        if (this.userRestrictions != null) goto L5;
    L7:
        return false;
    L5:
        if (this.userRestrictions.size() <= 0) goto L7;
        return true;
    }

    Bundle ensureUserRestrictions() {
        if (this.userRestrictions != null) goto L6;
        this.userRestrictions = new Bundle();
    L6:
        return this.userRestrictions;
    }

    public void transfer(DeviceAdminInfo deviceAdminInfo) {
        if (hasParentActiveAdmin() == false) goto L5;
        this.parentAdmin.info = deviceAdminInfo;
    L5:
        this.info = deviceAdminInfo;
    }

    Bundle addSyntheticRestrictions(Bundle restrictions) {
        if (this.disableCamera == false) goto L6;
        restrictions.putBoolean("no_camera", true);
    L6:
        if (this.requireAutoTime == false) goto L8;
        restrictions.putBoolean("no_config_date_time", true);
    L8:
        return restrictions;
    }

    static Bundle removeDeprecatedRestrictions(Bundle restrictions) {
        Iterator<String> r0 = UserRestrictionsUtils.DEPRECATED_USER_RESTRICTIONS.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String deprecatedRestriction = r0.next();
        restrictions.remove(deprecatedRestriction);
        goto L4
    L6:
        return restrictions;
    }

    static Bundle filterRestrictions(Bundle restrictions, Predicate<String> filter) {
        Bundle result = new Bundle();
        Iterator<String> r1 = restrictions.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        String key = r1.next();
        if (restrictions.getBoolean(key) == false) goto L4;
        if (filter.test(key) == false) goto L4;
        result.putBoolean(key, true);
        goto L4
    L12:
        return result;
    }

    Bundle getEffectiveRestrictions() {
        return addSyntheticRestrictions(removeDeprecatedRestrictions(new Bundle(ensureUserRestrictions())));
    }

    Bundle getLocalUserRestrictions(final int adminType) {
        return filterRestrictions(getEffectiveRestrictions(), new ActiveAdmin$$ExternalSyntheticLambda3(adminType));
    }

    private static /* synthetic */ boolean lambda$getLocalUserRestrictions$2(int adminType, String key) {
        return UserRestrictionsUtils.isLocal(adminType, key);
    }

    Bundle getGlobalUserRestrictions(final int adminType) {
        return filterRestrictions(getEffectiveRestrictions(), new ActiveAdmin$$ExternalSyntheticLambda1(adminType));
    }

    private static /* synthetic */ boolean lambda$getGlobalUserRestrictions$3(int adminType, String key) {
        return UserRestrictionsUtils.isGlobal(adminType, key);
    }

    void dumpPackagePolicy(final IndentingPrintWriter pw, String name, PackagePolicy policy) {
        pw.print(name);
        pw.println(":");
        if (policy == null) goto L6;
        pw.increaseIndent();
        pw.print("policyType=");
        pw.println(policy.getPolicyType());
        pw.println("packageNames:");
        pw.increaseIndent();
        policy.getPackageNames().forEach(new ActiveAdmin$$ExternalSyntheticLambda4(pw));
        pw.decreaseIndent();
        pw.decreaseIndent();
        return;
    }

    private static /* synthetic */ void lambda$dumpPackagePolicy$4(IndentingPrintWriter pw, String item) {
        pw.println(item);
    }

    void dump(IndentingPrintWriter pw) {
        pw.print("uid=");
        pw.println(getUid());
        pw.print("testOnlyAdmin=");
        pw.println(this.testOnlyAdmin);
        if (this.info == null) goto L11;
        pw.println("policies:");
        ArrayList<DeviceAdminInfo.PolicyInfo> pols = this.info.getUsedPolicies();
        if (pols == null) goto L11;
        pw.increaseIndent();
        int i = 0;
    L8:
        if (i >= pols.size()) goto L10;
        pw.println(pols.get(i).tag);
        i = i + 1;
        goto L8
    L10:
        pw.decreaseIndent();
    L11:
        pw.print("passwordQuality=0x");
        pw.println(Integer.toHexString(this.mPasswordPolicy.quality));
        pw.print("minimumPasswordLength=");
        pw.println(this.mPasswordPolicy.length);
        pw.print("passwordHistoryLength=");
        pw.println(this.passwordHistoryLength);
        pw.print("minimumPasswordUpperCase=");
        pw.println(this.mPasswordPolicy.upperCase);
        pw.print("minimumPasswordLowerCase=");
        pw.println(this.mPasswordPolicy.lowerCase);
        pw.print("minimumPasswordLetters=");
        pw.println(this.mPasswordPolicy.letters);
        pw.print("minimumPasswordNumeric=");
        pw.println(this.mPasswordPolicy.numeric);
        pw.print("minimumPasswordSymbols=");
        pw.println(this.mPasswordPolicy.symbols);
        pw.print("minimumPasswordNonLetter=");
        pw.println(this.mPasswordPolicy.nonLetter);
        pw.print("maximumTimeToUnlock=");
        pw.println(this.maximumTimeToUnlock);
        pw.print("strongAuthUnlockTimeout=");
        pw.println(this.strongAuthUnlockTimeout);
        pw.print("maximumFailedPasswordsForWipe=");
        pw.println(this.maximumFailedPasswordsForWipe);
        pw.print("specifiesGlobalProxy=");
        pw.println(this.specifiesGlobalProxy);
        pw.print("passwordExpirationTimeout=");
        pw.println(this.passwordExpirationTimeout);
        pw.print("passwordExpirationDate=");
        pw.println(this.passwordExpirationDate);
        if (this.globalProxySpec == null) goto L15;
        pw.print("globalProxySpec=");
        pw.println(this.globalProxySpec);
    L15:
        if (this.globalProxyExclusionList == null) goto L17;
        pw.print("globalProxyEclusionList=");
        pw.println(this.globalProxyExclusionList);
    L17:
        pw.print("encryptionRequested=");
        pw.println(this.encryptionRequested);
        pw.print("disableCallerId=");
        pw.println(this.disableCallerId);
        pw.print("disableContactsSearch=");
        pw.println(this.disableContactsSearch);
        pw.print("disableBluetoothContactSharing=");
        pw.println(this.disableBluetoothContactSharing);
        pw.print("forceEphemeralUsers=");
        pw.println(this.forceEphemeralUsers);
        pw.print("isNetworkLoggingEnabled=");
        pw.println(this.isNetworkLoggingEnabled);
        pw.print("disabledKeyguardFeatures=");
        pw.println(this.disabledKeyguardFeatures);
        pw.print("crossProfileWidgetProviders=");
        pw.println(this.crossProfileWidgetProviders);
        if (this.permittedAccessiblityServices == null) goto L21;
        pw.print("permittedAccessibilityServices=");
        pw.println(this.permittedAccessiblityServices);
    L21:
        if (this.permittedNotificationListeners == null) goto L24;
        pw.print("permittedNotificationListeners=");
        pw.println(this.permittedNotificationListeners);
    L24:
        if (this.keepUninstalledPackages == null) goto L27;
        pw.print("keepUninstalledPackages=");
        pw.println(this.keepUninstalledPackages);
    L27:
        if (this.meteredDisabledPackages == null) goto L30;
        pw.print("meteredDisabledPackages=");
        pw.println(this.meteredDisabledPackages);
    L30:
        if (this.protectedPackages == null) goto L33;
        pw.print("protectedPackages=");
        pw.println(this.protectedPackages);
    L33:
        if (this.suspendedPackages == null) goto L35;
        pw.print("suspendedPackages=");
        pw.println(this.suspendedPackages);
    L35:
        pw.print("organizationColor=");
        pw.println(this.organizationColor);
        if (this.organizationName == null) goto L38;
        pw.print("organizationName=");
        pw.println(this.organizationName);
    L38:
        pw.print("defaultEnabledRestrictionsAlreadySet=");
        pw.println(this.defaultEnabledRestrictionsAlreadySet);
        dumpPackagePolicy(pw, "managedProfileCallerIdPolicy", this.mManagedProfileCallerIdAccess);
        dumpPackagePolicy(pw, "managedProfileContactsPolicy", this.mManagedProfileContactsAccess);
        dumpPackagePolicy(pw, "credentialManagerPolicy", this.mCredentialManagerPolicy);
        pw.print("isParent=");
        pw.println(this.isParent);
        if (this.parentAdmin == null) goto L42;
        pw.println("parentAdmin:");
        pw.increaseIndent();
        this.parentAdmin.dump(pw);
        pw.decreaseIndent();
    L42:
        if (this.mCrossProfileCalendarPackages == null) goto L44;
        pw.print("mCrossProfileCalendarPackages=");
        pw.println(this.mCrossProfileCalendarPackages);
    L44:
        pw.print("mCrossProfilePackages=");
        pw.println(this.mCrossProfilePackages);
        pw.print("mSuspendPersonalApps=");
        pw.println(this.mSuspendPersonalApps);
        pw.print("mProfileMaximumTimeOffMillis=");
        pw.println(this.mProfileMaximumTimeOffMillis);
        pw.print("mProfileOffDeadline=");
        pw.println(this.mProfileOffDeadline);
        pw.print("mAlwaysOnVpnPackage=");
        pw.println(this.mAlwaysOnVpnPackage);
        pw.print("mAlwaysOnVpnLockdown=");
        pw.println(this.mAlwaysOnVpnLockdown);
        pw.print("mCommonCriteriaMode=");
        pw.println(this.mCommonCriteriaMode);
        pw.print("mPasswordComplexity=");
        pw.println(this.mPasswordComplexity);
        pw.print("mNearbyNotificationStreamingPolicy=");
        pw.println(this.mNearbyNotificationStreamingPolicy);
        pw.print("mNearbyAppStreamingPolicy=");
        pw.println(this.mNearbyAppStreamingPolicy);
        if (TextUtils.isEmpty(this.mOrganizationId) == true) goto L48;
        pw.print("mOrganizationId=");
        pw.println(this.mOrganizationId);
    L48:
        if (TextUtils.isEmpty(this.mEnrollmentSpecificId) == true) goto L50;
        pw.print("mEnrollmentSpecificId=");
        pw.println(this.mEnrollmentSpecificId);
    L50:
        pw.print("mAdminCanGrantSensorsPermissions=");
        pw.println(this.mAdminCanGrantSensorsPermissions);
        pw.print("mWifiMinimumSecurityLevel=");
        pw.println(this.mWifiMinimumSecurityLevel);
        if (this.mWifiSsidPolicy == null) goto L58;
        if (this.mWifiSsidPolicy.getPolicyType() != 0) goto L55;
        pw.print("mSsidAllowlist=");
    L56:
        pw.println(ssidsToStrings(this.mWifiSsidPolicy.getSsids()));
        goto L58
    L55:
        pw.print("mSsidDenylist=");
    L58:
        if (this.mFactoryResetProtectionPolicy == null) goto L61;
        pw.println("mFactoryResetProtectionPolicy:");
        pw.increaseIndent();
        this.mFactoryResetProtectionPolicy.dump(pw);
        pw.decreaseIndent();
    L61:
        if (this.mPreferentialNetworkServiceConfigs == null) goto L67;
        pw.println("mPreferentialNetworkServiceConfigs:");
        pw.increaseIndent();
        Iterator<PreferentialNetworkServiceConfig> r0 = this.mPreferentialNetworkServiceConfigs.iterator();
    L64:
        if (r0.hasNext() == false) goto L66;
        PreferentialNetworkServiceConfig config = r0.next();
        config.dump(pw);
        goto L64
    L66:
        pw.decreaseIndent();
    L67:
        pw.print("mtePolicy=");
        pw.println(this.mtePolicy);
        pw.print("accountTypesWithManagementDisabled=");
        pw.println(this.accountTypesWithManagementDisabled);
        if (this.mManagedSubscriptionsPolicy == null) goto L70;
        pw.println("mManagedSubscriptionsPolicy:");
        pw.increaseIndent();
        pw.println(this.mManagedSubscriptionsPolicy);
        pw.decreaseIndent();
    L70:
        pw.print("mDialerPackage=");
        pw.println(this.mDialerPackage);
        pw.print("mSmsPackage=");
        pw.println(this.mSmsPackage);
        pw.print("mProvisioningContext=");
        pw.println(this.mProvisioningContext);
        if (this.info == null) goto L76;
        pw.println("DeviceAdminInfo:");
        pw.increaseIndent();
        this.info.dump(new PrintWriterPrinter(pw), "");
        pw.decreaseIndent();
        return;
    }
}
