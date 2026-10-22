package com.android.server.devicepolicy;

import android.app.admin.AccountTypePolicyKey;
import android.app.admin.BooleanPolicyValue;
import android.app.admin.DevicePolicyIdentifiers;
import android.app.admin.IntegerPolicyValue;
import android.app.admin.IntentFilterPolicyKey;
import android.app.admin.LockTaskPolicy;
import android.app.admin.NoArgsPolicyKey;
import android.app.admin.PackagePermissionPolicyKey;
import android.app.admin.PackagePolicyKey;
import android.app.admin.PolicyKey;
import android.app.admin.PolicyValue;
import android.app.admin.UserRestrictionPolicyKey;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import com.android.internal.util.function.QuadFunction;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.utils.Slogf;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class PolicyDefinition<V> {
    static PolicyDefinition<Integer> APP_FUNCTIONS = null;
    static PolicyDefinition<Boolean> AUDIT_LOGGING = null;
    static PolicyDefinition<Integer> AUTO_TIME = null;
    static PolicyDefinition<Integer> AUTO_TIME_ZONE = null;
    static PolicyDefinition<Integer> CONTENT_PROTECTION = null;
    private static final MostRestrictive<Boolean> FALSE_MORE_RESTRICTIVE = null;
    static PolicyDefinition<Boolean> GENERIC_ACCOUNT_MANAGEMENT_DISABLED = null;
    static PolicyDefinition<Boolean> GENERIC_APPLICATION_HIDDEN = null;
    static PolicyDefinition<Bundle> GENERIC_APPLICATION_RESTRICTIONS = null;
    static PolicyDefinition<Boolean> GENERIC_PACKAGE_UNINSTALL_BLOCKED = null;
    static final PolicyDefinition<Integer> GENERIC_PERMISSION_GRANT = null;
    static PolicyDefinition<ComponentName> GENERIC_PERSISTENT_PREFERRED_ACTIVITY = null;
    static PolicyDefinition<Integer> KEYGUARD_DISABLED_FEATURES = null;
    static PolicyDefinition<LockTaskPolicy> LOCK_TASK = null;
    static PolicyDefinition<Integer> MEMORY_TAGGING = null;
    static PolicyDefinition<Set<String>> PACKAGES_SUSPENDED = null;
    static PolicyDefinition<Integer> PASSWORD_COMPLEXITY = null;
    static PolicyDefinition<Set<String>> PERMITTED_INPUT_METHODS = null;
    static PolicyDefinition<Boolean> PERSONAL_APPS_SUSPENDED = null;
    private static final Map<String, PolicyDefinition<?>> POLICY_DEFINITIONS = null;
    private static final int POLICY_FLAG_GLOBAL_ONLY_POLICY = 1;
    private static final int POLICY_FLAG_INHERITABLE = 4;
    private static final int POLICY_FLAG_LOCAL_ONLY_POLICY = 2;
    private static final int POLICY_FLAG_NONE = 0;
    private static final int POLICY_FLAG_NON_COEXISTABLE_POLICY = 8;
    private static final int POLICY_FLAG_SKIP_ENFORCEMENT_IF_UNCHANGED = 32;
    private static final int POLICY_FLAG_USER_RESTRICTION_POLICY = 16;
    static PolicyDefinition<Long> RESET_PASSWORD_TOKEN = null;
    static PolicyDefinition<Boolean> SCREEN_CAPTURE_DISABLED = null;
    static PolicyDefinition<Boolean> SECURITY_LOGGING = null;
    static final String TAG = "PolicyDefinition";
    private static final MostRestrictive<Boolean> TRUE_MORE_RESTRICTIVE = null;
    static PolicyDefinition<Boolean> USB_DATA_SIGNALING;
    static PolicyDefinition<Set<String>> USER_CONTROLLED_DISABLED_PACKAGES;
    private static Map<String, Integer> USER_RESTRICTION_FLAGS;
    private final QuadFunction<V, Context, Integer, PolicyKey, CompletableFuture<Boolean>> mPolicyEnforcerCallback;
    private final int mPolicyFlags;
    private final PolicyKey mPolicyKey;
    private final PolicySerializer<V> mPolicySerializer;
    private final ResolutionMechanism<V> mResolutionMechanism;

    /* JADX INFO: renamed from: $r8$lambda$47gp_RDmPTRZnLdjPd-_ygMdBJo, reason: not valid java name */
    public static /* synthetic */ CompletableFuture m3517$r8$lambda$47gp_RDmPTRZnLdjPd_ygMdBJo(LockTaskPolicy r0, Context r1, Integer r2, PolicyKey r3) {
        return lambda$static$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ CompletableFuture $r8$lambda$NhTUFT2zcWLFPLkIMQbqt6nSVQo(Boolean r0, Context r1, Integer r2, PolicyKey r3) {
        return lambda$static$1(r0, r1, r2, r3);
    }

    static {
        FALSE_MORE_RESTRICTIVE = new MostRestrictive(List.of(new BooleanPolicyValue(false), new BooleanPolicyValue(true)));
        TRUE_MORE_RESTRICTIVE = new MostRestrictive(List.of(new BooleanPolicyValue(true), new BooleanPolicyValue(false)));
        AUTO_TIME_ZONE = new PolicyDefinition(new NoArgsPolicyKey("autoTimezone"), new TopPriority(List.of(EnforcingAdmin.getRoleAuthorityOf("android.app.role.SYSTEM_SUPERVISION"), EnforcingAdmin.getRoleAuthorityOf("android.app.role.SYSTEM_FINANCED_DEVICE_CONTROLLER"), "enterprise")), 1, new PolicyDefinition$$ExternalSyntheticLambda1(), new IntegerPolicySerializer());
        GENERIC_PERMISSION_GRANT = new PolicyDefinition(new PackagePermissionPolicyKey("permissionGrant"), new MostRestrictive(List.of(new IntegerPolicyValue(2), new IntegerPolicyValue(1), new IntegerPolicyValue(0))), 2, new PolicyDefinition$$ExternalSyntheticLambda10(), new IntegerPolicySerializer());
        SECURITY_LOGGING = new PolicyDefinition(new NoArgsPolicyKey("securityLogging"), TRUE_MORE_RESTRICTIVE, 1, new PolicyDefinition$$ExternalSyntheticLambda13(), new BooleanPolicySerializer());
        AUDIT_LOGGING = new PolicyDefinition(new NoArgsPolicyKey("auditLogging"), TRUE_MORE_RESTRICTIVE, 1, new PolicyDefinition$$ExternalSyntheticLambda14(), new BooleanPolicySerializer());
        LOCK_TASK = new PolicyDefinition(new NoArgsPolicyKey("lockTask"), new TopPriority(List.of(EnforcingAdmin.getRoleAuthorityOf("android.app.role.SYSTEM_FINANCED_DEVICE_CONTROLLER"), "enterprise")), 2, new PolicyDefinition$$ExternalSyntheticLambda15(), new LockTaskPolicySerializer());
        USER_CONTROLLED_DISABLED_PACKAGES = new PolicyDefinition(new NoArgsPolicyKey("userControlDisabledPackages"), new PackageSetUnion(), new PolicyDefinition$$ExternalSyntheticLambda16(), new PackageSetPolicySerializer());
        GENERIC_PERSISTENT_PREFERRED_ACTIVITY = new PolicyDefinition(new IntentFilterPolicyKey("persistentPreferredActivity"), new TopPriority(List.of(EnforcingAdmin.getRoleAuthorityOf("android.app.role.SYSTEM_FINANCED_DEVICE_CONTROLLER"), "enterprise")), 2, new PolicyDefinition$$ExternalSyntheticLambda17(), new ComponentNamePolicySerializer());
        GENERIC_PACKAGE_UNINSTALL_BLOCKED = new PolicyDefinition(new PackagePolicyKey("packageUninstallBlocked"), TRUE_MORE_RESTRICTIVE, 2, new PolicyDefinition$$ExternalSyntheticLambda18(), new BooleanPolicySerializer());
        GENERIC_APPLICATION_RESTRICTIONS = new PolicyDefinition(new PackagePolicyKey("applicationRestrictions"), new MostRecent(), 46, new PolicyDefinition$$ExternalSyntheticLambda19(), new BundlePolicySerializer());
        RESET_PASSWORD_TOKEN = new PolicyDefinition(new NoArgsPolicyKey("resetPasswordToken"), new MostRecent(), 10, new PolicyDefinition$$ExternalSyntheticLambda20(), new LongPolicySerializer());
        KEYGUARD_DISABLED_FEATURES = new PolicyDefinition(new NoArgsPolicyKey("keyguardDisabledFeatures"), new FlagUnion(), 2, new PolicyDefinition$$ExternalSyntheticLambda2(), new IntegerPolicySerializer());
        GENERIC_APPLICATION_HIDDEN = new PolicyDefinition(new PackagePolicyKey("applicationHidden"), TRUE_MORE_RESTRICTIVE, 6, new PolicyDefinition$$ExternalSyntheticLambda3(), new BooleanPolicySerializer());
        GENERIC_ACCOUNT_MANAGEMENT_DISABLED = new PolicyDefinition(new AccountTypePolicyKey("accountManagementDisabled"), TRUE_MORE_RESTRICTIVE, 6, new PolicyDefinition$$ExternalSyntheticLambda4(), new BooleanPolicySerializer());
        PERMITTED_INPUT_METHODS = new PolicyDefinition(new NoArgsPolicyKey("permittedInputMethods"), new MostRecent(), 6, new PolicyDefinition$$ExternalSyntheticLambda5(), new PackageSetPolicySerializer());
        SCREEN_CAPTURE_DISABLED = new PolicyDefinition(new NoArgsPolicyKey("screenCaptureDisabled"), TRUE_MORE_RESTRICTIVE, 4, new PolicyDefinition$$ExternalSyntheticLambda6(), new BooleanPolicySerializer());
        PERSONAL_APPS_SUSPENDED = new PolicyDefinition(new NoArgsPolicyKey("personalAppsSuspended"), new MostRecent(), 6, new PolicyDefinition$$ExternalSyntheticLambda7(), new BooleanPolicySerializer());
        USB_DATA_SIGNALING = new PolicyDefinition(new NoArgsPolicyKey("usbDataSignaling"), FALSE_MORE_RESTRICTIVE, 1, new PolicyDefinition$$ExternalSyntheticLambda8(), new BooleanPolicySerializer());
        CONTENT_PROTECTION = new PolicyDefinition(new NoArgsPolicyKey("contentProtection"), new MostRecent(), 2, new PolicyDefinition$$ExternalSyntheticLambda9(), new IntegerPolicySerializer());
        APP_FUNCTIONS = new PolicyDefinition(new NoArgsPolicyKey("appFunctions"), new MostRestrictive(List.of(new IntegerPolicyValue(1), new IntegerPolicyValue(2), new IntegerPolicyValue(0))), 2, new PolicyDefinition$$ExternalSyntheticLambda2(), new IntegerPolicySerializer());
        PASSWORD_COMPLEXITY = new PolicyDefinition(new NoArgsPolicyKey("passwordComplexity"), new MostRestrictive(List.of(new IntegerPolicyValue(327680), new IntegerPolicyValue(196608), new IntegerPolicyValue(65536), new IntegerPolicyValue(0))), 2, new PolicyDefinition$$ExternalSyntheticLambda2(), new IntegerPolicySerializer());
        PACKAGES_SUSPENDED = new PolicyDefinition(new NoArgsPolicyKey("packagesSuspended"), new PackageSetUnion(), new PolicyDefinition$$ExternalSyntheticLambda5(), new PackageSetPolicySerializer());
        MEMORY_TAGGING = new PolicyDefinition(new NoArgsPolicyKey("memoryTagging"), new TopPriority(List.of("enterprise")), new PolicyDefinition$$ExternalSyntheticLambda11(), new IntegerPolicySerializer());
        AUTO_TIME = new PolicyDefinition(new NoArgsPolicyKey("autoTime"), new TopPriority(List.of(EnforcingAdmin.getRoleAuthorityOf("android.app.role.SYSTEM_SUPERVISION"), EnforcingAdmin.getRoleAuthorityOf("android.app.role.SYSTEM_FINANCED_DEVICE_CONTROLLER"), "enterprise")), 1, new PolicyDefinition$$ExternalSyntheticLambda12(), new IntegerPolicySerializer());
        POLICY_DEFINITIONS = new HashMap();
        USER_RESTRICTION_FLAGS = new HashMap();
        POLICY_DEFINITIONS.put("autoTimezone", AUTO_TIME_ZONE);
        POLICY_DEFINITIONS.put("permissionGrant", GENERIC_PERMISSION_GRANT);
        POLICY_DEFINITIONS.put("securityLogging", SECURITY_LOGGING);
        POLICY_DEFINITIONS.put("auditLogging", AUDIT_LOGGING);
        POLICY_DEFINITIONS.put("lockTask", LOCK_TASK);
        POLICY_DEFINITIONS.put("userControlDisabledPackages", USER_CONTROLLED_DISABLED_PACKAGES);
        POLICY_DEFINITIONS.put("persistentPreferredActivity", GENERIC_PERSISTENT_PREFERRED_ACTIVITY);
        POLICY_DEFINITIONS.put("packageUninstallBlocked", GENERIC_PACKAGE_UNINSTALL_BLOCKED);
        POLICY_DEFINITIONS.put("applicationRestrictions", GENERIC_APPLICATION_RESTRICTIONS);
        POLICY_DEFINITIONS.put("resetPasswordToken", RESET_PASSWORD_TOKEN);
        POLICY_DEFINITIONS.put("keyguardDisabledFeatures", KEYGUARD_DISABLED_FEATURES);
        POLICY_DEFINITIONS.put("applicationHidden", GENERIC_APPLICATION_HIDDEN);
        POLICY_DEFINITIONS.put("accountManagementDisabled", GENERIC_ACCOUNT_MANAGEMENT_DISABLED);
        POLICY_DEFINITIONS.put("permittedInputMethods", PERMITTED_INPUT_METHODS);
        POLICY_DEFINITIONS.put("screenCaptureDisabled", SCREEN_CAPTURE_DISABLED);
        POLICY_DEFINITIONS.put("personalAppsSuspended", PERSONAL_APPS_SUSPENDED);
        POLICY_DEFINITIONS.put("usbDataSignaling", USB_DATA_SIGNALING);
        POLICY_DEFINITIONS.put("contentProtection", CONTENT_PROTECTION);
        POLICY_DEFINITIONS.put("appFunctions", APP_FUNCTIONS);
        POLICY_DEFINITIONS.put("passwordComplexity", PASSWORD_COMPLEXITY);
        POLICY_DEFINITIONS.put("packagesSuspended", PACKAGES_SUSPENDED);
        POLICY_DEFINITIONS.put("memoryTagging", MEMORY_TAGGING);
        POLICY_DEFINITIONS.put("autoTime", AUTO_TIME);
        USER_RESTRICTION_FLAGS.put("no_modify_accounts", 0);
        USER_RESTRICTION_FLAGS.put("no_config_wifi", 0);
        USER_RESTRICTION_FLAGS.put("no_change_wifi_state", 1);
        USER_RESTRICTION_FLAGS.put("no_wifi_tethering", 1);
        USER_RESTRICTION_FLAGS.put("no_grant_admin", 0);
        USER_RESTRICTION_FLAGS.put("no_sharing_admin_configured_wifi", 0);
        USER_RESTRICTION_FLAGS.put("no_wifi_direct", 1);
        USER_RESTRICTION_FLAGS.put("no_add_wifi_config", 1);
        USER_RESTRICTION_FLAGS.put("no_config_locale", 0);
        USER_RESTRICTION_FLAGS.put("no_install_apps", 0);
        USER_RESTRICTION_FLAGS.put("no_uninstall_apps", 0);
        USER_RESTRICTION_FLAGS.put("no_share_location", 0);
        USER_RESTRICTION_FLAGS.put("no_airplane_mode", 1);
        USER_RESTRICTION_FLAGS.put("no_config_brightness", 0);
        USER_RESTRICTION_FLAGS.put("no_ambient_display", 0);
        USER_RESTRICTION_FLAGS.put("no_config_screen_timeout", 0);
        USER_RESTRICTION_FLAGS.put("no_install_unknown_sources", 0);
        USER_RESTRICTION_FLAGS.put("no_install_unknown_sources_globally", 1);
        USER_RESTRICTION_FLAGS.put("no_config_bluetooth", 0);
        USER_RESTRICTION_FLAGS.put("no_bluetooth", 0);
        USER_RESTRICTION_FLAGS.put("no_bluetooth_sharing", 0);
        USER_RESTRICTION_FLAGS.put("no_usb_file_transfer", 0);
        USER_RESTRICTION_FLAGS.put("no_config_credentials", 0);
        USER_RESTRICTION_FLAGS.put("no_remove_user", 0);
        USER_RESTRICTION_FLAGS.put("no_remove_managed_profile", 0);
        USER_RESTRICTION_FLAGS.put("no_debugging_features", 0);
        USER_RESTRICTION_FLAGS.put("no_config_vpn", 0);
        USER_RESTRICTION_FLAGS.put("no_config_location", 0);
        USER_RESTRICTION_FLAGS.put("no_config_date_time", 0);
        USER_RESTRICTION_FLAGS.put("no_config_tethering", 0);
        USER_RESTRICTION_FLAGS.put("no_network_reset", 0);
        USER_RESTRICTION_FLAGS.put("no_factory_reset", 0);
        USER_RESTRICTION_FLAGS.put("no_add_user", 0);
        USER_RESTRICTION_FLAGS.put("no_add_managed_profile", 0);
        USER_RESTRICTION_FLAGS.put("no_add_clone_profile", 0);
        USER_RESTRICTION_FLAGS.put("no_add_private_profile", 0);
        USER_RESTRICTION_FLAGS.put("ensure_verify_apps", 1);
        USER_RESTRICTION_FLAGS.put("no_config_cell_broadcasts", 0);
        USER_RESTRICTION_FLAGS.put("no_config_mobile_networks", 0);
        USER_RESTRICTION_FLAGS.put("no_control_apps", 0);
        USER_RESTRICTION_FLAGS.put("no_physical_media", 0);
        USER_RESTRICTION_FLAGS.put("no_unmute_microphone", 0);
        USER_RESTRICTION_FLAGS.put("no_adjust_volume", 0);
        USER_RESTRICTION_FLAGS.put("no_outgoing_calls", 0);
        USER_RESTRICTION_FLAGS.put("no_sms", 0);
        USER_RESTRICTION_FLAGS.put("no_fun", 0);
        USER_RESTRICTION_FLAGS.put("no_create_windows", 0);
        USER_RESTRICTION_FLAGS.put("no_system_error_dialogs", 0);
        USER_RESTRICTION_FLAGS.put("no_cross_profile_copy_paste", 0);
        USER_RESTRICTION_FLAGS.put("no_outgoing_beam", 0);
        USER_RESTRICTION_FLAGS.put("no_wallpaper", 0);
        USER_RESTRICTION_FLAGS.put("no_set_wallpaper", 0);
        USER_RESTRICTION_FLAGS.put("no_safe_boot", 0);
        USER_RESTRICTION_FLAGS.put("no_record_audio", 0);
        USER_RESTRICTION_FLAGS.put("no_run_in_background", 0);
        USER_RESTRICTION_FLAGS.put("no_camera", 0);
        USER_RESTRICTION_FLAGS.put("disallow_unmute_device", 0);
        USER_RESTRICTION_FLAGS.put("no_data_roaming", 0);
        USER_RESTRICTION_FLAGS.put("no_set_user_icon", 0);
        USER_RESTRICTION_FLAGS.put("no_oem_unlock", 0);
        USER_RESTRICTION_FLAGS.put("no_unified_password", 0);
        USER_RESTRICTION_FLAGS.put("allow_parent_profile_app_linking", 0);
        USER_RESTRICTION_FLAGS.put("no_autofill", 0);
        USER_RESTRICTION_FLAGS.put("no_content_capture", 0);
        USER_RESTRICTION_FLAGS.put("no_content_suggestions", 0);
        USER_RESTRICTION_FLAGS.put("no_user_switch", 1);
        USER_RESTRICTION_FLAGS.put("no_sharing_into_profile", 0);
        USER_RESTRICTION_FLAGS.put("no_printing", 0);
        USER_RESTRICTION_FLAGS.put("disallow_config_private_dns", 1);
        USER_RESTRICTION_FLAGS.put("disallow_microphone_toggle", 0);
        USER_RESTRICTION_FLAGS.put("disallow_camera_toggle", 0);
        USER_RESTRICTION_FLAGS.put("disallow_biometric", 0);
        USER_RESTRICTION_FLAGS.put("disallow_config_default_apps", 0);
        USER_RESTRICTION_FLAGS.put("no_cellular_2g", 1);
        USER_RESTRICTION_FLAGS.put("no_ultra_wideband_radio", 1);
        USER_RESTRICTION_FLAGS.put("no_near_field_communication_radio", 1);
        USER_RESTRICTION_FLAGS.put("no_sim_globally", 1);
        USER_RESTRICTION_FLAGS.put("no_assist_content", 0);
        USER_RESTRICTION_FLAGS.put("no_thread_network", 1);
        Iterator<String> r0 = USER_RESTRICTION_FLAGS.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String key = r0.next();
        createAndAddUserRestrictionPolicyDefinition(key, USER_RESTRICTION_FLAGS.get(key).intValue());
        goto L4
    }

    static PolicyDefinition<Integer> PERMISSION_GRANT(String packageName, String permissionName) {
        packageName.getClass();
        permissionName.getClass();
        return GENERIC_PERMISSION_GRANT.createPolicyDefinition(new PackagePermissionPolicyKey("permissionGrant", packageName, permissionName));
    }

    private static /* synthetic */ CompletableFuture lambda$static$0(LockTaskPolicy value, Context context, Integer userId, PolicyKey policyKey) {
        return PolicyEnforcerCallbacks.setLockTask(value, context, userId.intValue());
    }

    static PolicyDefinition<ComponentName> PERSISTENT_PREFERRED_ACTIVITY(IntentFilter intentFilter) {
        intentFilter.getClass();
        return GENERIC_PERSISTENT_PREFERRED_ACTIVITY.createPolicyDefinition(new IntentFilterPolicyKey("persistentPreferredActivity", intentFilter));
    }

    static PolicyDefinition<Boolean> PACKAGE_UNINSTALL_BLOCKED(String packageName) {
        packageName.getClass();
        return GENERIC_PACKAGE_UNINSTALL_BLOCKED.createPolicyDefinition(new PackagePolicyKey("packageUninstallBlocked", packageName));
    }

    static PolicyDefinition<Bundle> APPLICATION_RESTRICTIONS(String packageName) {
        packageName.getClass();
        return GENERIC_APPLICATION_RESTRICTIONS.createPolicyDefinition(new PackagePolicyKey("applicationRestrictions", packageName));
    }

    static PolicyDefinition<Boolean> APPLICATION_HIDDEN(String packageName) {
        packageName.getClass();
        return GENERIC_APPLICATION_HIDDEN.createPolicyDefinition(new PackagePolicyKey("applicationHidden", packageName));
    }

    static PolicyDefinition<Boolean> ACCOUNT_MANAGEMENT_DISABLED(String accountType) {
        accountType.getClass();
        return GENERIC_ACCOUNT_MANAGEMENT_DISABLED.createPolicyDefinition(new AccountTypePolicyKey("accountManagementDisabled", accountType));
    }

    private static /* synthetic */ CompletableFuture lambda$static$1(Boolean value, Context context, Integer userId, PolicyKey policyKey) {
        return PolicyEnforcerCallbacks.setUsbDataSignalingEnabled(value, context);
    }

    private PolicyDefinition<V> createPolicyDefinition(PolicyKey key) {
        return new PolicyDefinition(key, this.mResolutionMechanism, this.mPolicyFlags, this.mPolicyEnforcerCallback, this.mPolicySerializer);
    }

    static PolicyDefinition<Boolean> getPolicyDefinitionForUserRestriction(String restriction) {
        String key = DevicePolicyIdentifiers.getIdentifierForUserRestriction(restriction);
        if (POLICY_DEFINITIONS.containsKey(key) == false) goto L7;
        return (PolicyDefinition) POLICY_DEFINITIONS.get(key);
    L7:
        throw new IllegalArgumentException("Unsupported user restriction " + restriction);
    }

    PolicyKey getPolicyKey() {
        return this.mPolicyKey;
    }

    ResolutionMechanism<V> getResolutionMechanism() {
        return this.mResolutionMechanism;
    }

    boolean isGlobalOnlyPolicy() {
        if ((this.mPolicyFlags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    boolean isLocalOnlyPolicy() {
        if ((this.mPolicyFlags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isInheritable() {
        if ((this.mPolicyFlags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isNonCoexistablePolicy() {
        if ((this.mPolicyFlags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isUserRestrictionPolicy() {
        if ((this.mPolicyFlags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean shouldSkipEnforcementIfNotChanged() {
        if ((this.mPolicyFlags & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    PolicyValue<V> resolvePolicy(LinkedHashMap<EnforcingAdmin, PolicyValue<V>> adminsPolicy) {
        return this.mResolutionMechanism.resolve(adminsPolicy);
    }

    CompletableFuture<Boolean> enforcePolicy(V value, Context context, int userId) {
        return (CompletableFuture) this.mPolicyEnforcerCallback.apply(value, context, Integer.valueOf(userId), this.mPolicyKey);
    }

    private static void createAndAddUserRestrictionPolicyDefinition(String restriction, int flags) {
        String identifier = DevicePolicyIdentifiers.getIdentifierForUserRestriction(restriction);
        UserRestrictionPolicyKey key = new UserRestrictionPolicyKey(identifier, restriction);
        MostRestrictive<Boolean> r4 = TRUE_MORE_RESTRICTIVE;
        PolicyDefinition<Boolean> definition = new PolicyDefinition(key, r4, flags | 20, new PolicyDefinition$$ExternalSyntheticLambda0(), new BooleanPolicySerializer());
        POLICY_DEFINITIONS.put(key.getIdentifier(), definition);
    }

    private PolicyDefinition(PolicyKey key, ResolutionMechanism<V> resolutionMechanism, QuadFunction<V, Context, Integer, PolicyKey, CompletableFuture<Boolean>> policyEnforcerCallback, PolicySerializer<V> policySerializer) {
        this(key, resolutionMechanism, 0, policyEnforcerCallback, policySerializer);
    }

    private PolicyDefinition(PolicyKey policyKey, ResolutionMechanism<V> resolutionMechanism, int policyFlags, QuadFunction<V, Context, Integer, PolicyKey, CompletableFuture<Boolean>> policyEnforcerCallback, PolicySerializer<V> policySerializer) {
        policyKey.getClass();
        this.mPolicyKey = policyKey;
        this.mResolutionMechanism = resolutionMechanism;
        this.mPolicyFlags = policyFlags;
        this.mPolicyEnforcerCallback = policyEnforcerCallback;
        this.mPolicySerializer = policySerializer;
        if (isNonCoexistablePolicy() == true) goto L5;
        return;
    L5:
        if (isLocalOnlyPolicy() == false) goto L8;
        return;
    L8:
        throw new UnsupportedOperationException("Non-coexistable global policies not supported,please add support.");
    }

    static <V> PolicyDefinition<V> readFromXml(TypedXmlPullParser r6) throws XmlPullParserException, IOException {
        PolicyKey r0 = readPolicyKeyFromXml(r6);
        if (r0 != null) goto L6;
        Slogf.wtf(TAG, "Error parsing PolicyDefinition, PolicyKey is null.");
        return null;
    L6:
        PolicyDefinition<?> r3 = POLICY_DEFINITIONS.get(r0.getIdentifier());
        if (r3 != null) goto L11;
        Slogf.wtf(TAG, "Unknown generic policy key: " + r0);
        return null;
    L11:
        return (PolicyDefinition<V>) r3.createPolicyDefinition(r0);
    }

    static PolicyKey readPolicyKeyFromXml(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        PolicyKey policyKey = PolicyKey.readGenericPolicyKeyFromXml(parser);
        if (policyKey != null) goto L6;
        Slogf.wtf(TAG, "Error parsing PolicyKey, GenericPolicyKey is null");
        return null;
    L6:
        PolicyDefinition<?> genericPolicyDefinition = POLICY_DEFINITIONS.get(policyKey.getIdentifier());
        if (genericPolicyDefinition != null) goto L11;
        Slogf.wtf(TAG, "Error parsing PolicyKey, Unknown generic policy key: " + policyKey);
        return null;
    L11:
        return ((PolicyDefinition) genericPolicyDefinition).mPolicyKey.readFromXml(parser);
    }

    void savePolicyValueToXml(TypedXmlSerializer serializer, V value) throws IOException {
        this.mPolicySerializer.saveToXml(serializer, value);
    }

    PolicyValue<V> readPolicyValueFromXml(TypedXmlPullParser parser) {
        return this.mPolicySerializer.readFromXml(parser);
    }

    public String toString() {
        return "PolicyDefinition{ mPolicyKey= " + this.mPolicyKey + ", mResolutionMechanism= " + this.mResolutionMechanism + ", mPolicyFlags= " + this.mPolicyFlags + " }";
    }
}
