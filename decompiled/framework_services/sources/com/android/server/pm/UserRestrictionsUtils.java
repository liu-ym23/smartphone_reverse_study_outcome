package com.android.server.pm;

import android.app.ActivityManager;
import android.app.AppGlobals;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManagerInternal;
import android.hardware.display.AmbientDisplayConfiguration;
import android.hardware.tv.mediaquality.ParameterName;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.Preconditions;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.BundleUtils;
import com.android.server.LocalServices;
import com.google.android.collect.Sets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public class UserRestrictionsUtils {
    private static final Set<String> DEFAULT_ENABLED_FOR_MANAGED_PROFILES = null;
    public static final Set<String> DEPRECATED_USER_RESTRICTIONS = null;
    private static final Set<String> DEVICE_OWNER_ONLY_RESTRICTIONS = null;
    private static final Set<String> FINANCED_DEVICE_OWNER_RESTRICTIONS = null;
    private static final Set<String> GLOBAL_RESTRICTIONS = null;
    private static final Set<String> IMMUTABLE_BY_OWNERS = null;
    private static final Set<String> MAIN_USER_ONLY_RESTRICTIONS = null;
    private static final Set<String> NON_PERSIST_USER_RESTRICTIONS = null;
    private static final Set<String> PROFILE_GLOBAL_RESTRICTIONS = null;
    private static final Set<String> PROFILE_OWNER_ORGANIZATION_OWNED_PARENT_GLOBAL_RESTRICTIONS = null;
    private static final Set<String> PROFILE_OWNER_ORGANIZATION_OWNED_PARENT_LOCAL_RESTRICTIONS = null;
    private static final Set<String> PROFILE_OWNER_ORGANIZATION_OWNED_PROFILE_RESTRICTIONS = null;
    private static final String TAG = "UserRestrictionsUtils";
    public static final Set<String> USER_RESTRICTIONS = null;

    private UserRestrictionsUtils() {
    }

    private static Set<String> newSetWithUniqueCheck(String[] strings) {
        Set<String> ret = Sets.newArraySet(strings);
        if (ret.size() != strings.length) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1);
        return ret;
    L5:
        r1 = false;
        goto L6
    }

    static {
        USER_RESTRICTIONS = newSetWithUniqueCheck(new String[]{"no_config_wifi", "no_config_locale", "no_modify_accounts", "no_install_apps", "no_uninstall_apps", "no_share_location", "no_install_unknown_sources", "no_install_unknown_sources_globally", "no_config_bluetooth", "no_bluetooth", "no_bluetooth_sharing", "no_usb_file_transfer", "no_config_credentials", "no_remove_user", "no_remove_managed_profile", "no_debugging_features", "no_config_vpn", "no_config_date_time", "no_config_tethering", "no_network_reset", "no_factory_reset", "no_add_user", "no_add_managed_profile", "no_add_clone_profile", "no_add_private_profile", "ensure_verify_apps", "no_config_cell_broadcasts", "no_config_mobile_networks", "no_control_apps", "no_physical_media", "no_unmute_microphone", "no_adjust_volume", "no_outgoing_calls", "no_sms", "no_fun", "no_create_windows", "no_system_error_dialogs", "no_cross_profile_copy_paste", "no_outgoing_beam", "no_wallpaper", "no_safe_boot", "allow_parent_profile_app_linking", "no_record_audio", "no_camera", "no_run_in_background", "no_data_roaming", "no_set_user_icon", "no_set_wallpaper", "no_oem_unlock", "disallow_unmute_device", "no_autofill", "no_content_capture", "no_content_suggestions", "no_user_switch", "no_unified_password", "no_config_location", "no_airplane_mode", "no_config_brightness", "no_sharing_into_profile", "no_ambient_display", "no_config_screen_timeout", "no_printing", "disallow_config_private_dns", "disallow_microphone_toggle", "disallow_camera_toggle", "no_change_wifi_state", "no_wifi_tethering", "no_grant_admin", "no_sharing_admin_configured_wifi", "no_wifi_direct", "no_add_wifi_config", "no_cellular_2g", "no_ultra_wideband_radio", "disallow_config_default_apps", "no_near_field_communication_radio", "no_sim_globally", "no_assist_content", "no_thread_network", "no_change_near_field_communication_radio"});
        DEPRECATED_USER_RESTRICTIONS = Sets.newArraySet(new String[]{"no_add_managed_profile", "no_remove_managed_profile"});
        NON_PERSIST_USER_RESTRICTIONS = Sets.newArraySet(new String[]{"no_record_audio"});
        MAIN_USER_ONLY_RESTRICTIONS = Sets.newArraySet(new String[]{"no_bluetooth", "no_usb_file_transfer", "no_config_tethering", "no_network_reset", "no_factory_reset", "no_add_user", "no_config_cell_broadcasts", "no_config_mobile_networks", "no_physical_media", "no_sms", "no_fun", "no_safe_boot", "no_create_windows", "no_data_roaming", "no_airplane_mode"});
        DEVICE_OWNER_ONLY_RESTRICTIONS = Sets.newArraySet(new String[]{"no_user_switch", "disallow_config_private_dns", "disallow_microphone_toggle", "disallow_camera_toggle", "no_change_wifi_state", "no_wifi_tethering", "no_wifi_direct", "no_add_wifi_config", "no_cellular_2g", "no_ultra_wideband_radio", "no_near_field_communication_radio", "no_thread_network", "no_change_near_field_communication_radio"});
        IMMUTABLE_BY_OWNERS = Sets.newArraySet(new String[]{"no_record_audio", "no_wallpaper", "no_oem_unlock"});
        GLOBAL_RESTRICTIONS = Sets.newArraySet(new String[]{"no_adjust_volume", "no_bluetooth_sharing", "no_config_date_time", "no_system_error_dialogs", "no_run_in_background", "no_unmute_microphone", "disallow_unmute_device", "no_camera", "no_assist_content", "disallow_config_default_apps"});
        PROFILE_OWNER_ORGANIZATION_OWNED_PARENT_GLOBAL_RESTRICTIONS = Sets.newArraySet(new String[]{"no_airplane_mode", "no_config_date_time", "disallow_config_private_dns", "no_change_wifi_state", "no_debugging_features", "no_wifi_tethering", "no_wifi_direct", "no_add_wifi_config", "no_cellular_2g", "no_ultra_wideband_radio", "no_near_field_communication_radio", "no_thread_network", "no_change_near_field_communication_radio"});
        PROFILE_OWNER_ORGANIZATION_OWNED_PROFILE_RESTRICTIONS = Sets.newArraySet(new String[]{"no_sim_globally"});
        PROFILE_OWNER_ORGANIZATION_OWNED_PARENT_LOCAL_RESTRICTIONS = Sets.newArraySet(new String[]{"no_config_bluetooth", "no_config_location", "no_config_wifi", "no_content_capture", "no_content_suggestions", "no_debugging_features", "no_share_location", "no_outgoing_calls", "no_camera", "no_bluetooth", "no_bluetooth_sharing", "no_config_cell_broadcasts", "no_config_mobile_networks", "no_config_tethering", "no_data_roaming", "no_safe_boot", "no_sms", "no_usb_file_transfer", "no_physical_media", "no_unmute_microphone", "disallow_config_default_apps", "no_add_private_profile", "no_config_brightness", "no_config_screen_timeout"});
        DEFAULT_ENABLED_FOR_MANAGED_PROFILES = Sets.newArraySet(new String[]{"no_bluetooth_sharing", "no_debugging_features"});
        PROFILE_GLOBAL_RESTRICTIONS = Sets.newArraySet(new String[]{"ensure_verify_apps", "no_airplane_mode", "no_install_unknown_sources_globally", "no_sim_globally"});
        FINANCED_DEVICE_OWNER_RESTRICTIONS = Sets.newArraySet(new String[]{"no_add_user", "no_debugging_features", "no_install_unknown_sources", "no_safe_boot", "no_config_date_time", "no_outgoing_calls"});
    }

    public static boolean isValidRestriction(String restriction) {
        if (USER_RESTRICTIONS.contains(restriction) == true) goto L23;
        int uid = Binder.getCallingUid();
        String[] pkgs = null;
        pkgs = AppGlobals.getPackageManager().getPackagesForUid(uid);     // Catch: RemoteException -> L7
    L8:
        StringBuilder msg = new StringBuilder("Unknown restriction queried by uid ");
        msg.append(uid);
        if (pkgs != null) goto L11;
    L16:
        msg.append(": ");
        msg.append(restriction);
        if (restriction != null) goto L19;
    L21:
        Slog.e(TAG, msg.toString());
    L22:
        return false;
    L19:
        if (isSystemApp(uid, pkgs) == false) goto L21;
        Slog.wtf(TAG, msg.toString());
        goto L22
    L11:
        if (pkgs.length <= 0) goto L16;
        msg.append(" (");
        msg.append(pkgs[0]);
        if (pkgs.length <= 1) goto L15;
        msg.append(" et al");
    L15:
        msg.append(")");
        goto L16
    L23:
        return true;
    }

    private static boolean isSystemApp(int uid, String[] packageList) {
        if (UserHandle.isCore(uid) == false) goto L6;
        return true;
    L6:
        if (packageList != null) goto L8;
        return false;
    L8:
        IPackageManager pm = AppGlobals.getPackageManager();
        int i = 0;
    L10:
        if (i >= packageList.length) goto L22;
        ApplicationInfo appInfo = pm.getApplicationInfo(packageList[i], 794624, UserHandle.getUserId(uid));     // Catch: RemoteException -> L17
        if (appInfo == null) goto L20;
        if (appInfo.isSystemApp() == false) goto L20;
        return true;
    L20:
        i = i + 1;
        goto L10
    L22:
        return false;
    }

    public static void writeRestrictions(XmlSerializer serializer, Bundle restrictions, String tag) throws IOException {
        writeRestrictions(XmlUtils.makeTyped(serializer), restrictions, tag);
    }

    public static void writeRestrictions(TypedXmlSerializer serializer, Bundle restrictions, String tag) throws IOException {
        if (restrictions != null) goto L4;
        return;
    L4:
        serializer.startTag(null, tag);
        Iterator<String> r1 = restrictions.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        String key = r1.next();
        if (NON_PERSIST_USER_RESTRICTIONS.contains(key) == true) goto L6;
        if (USER_RESTRICTIONS.contains(key) == true) goto L13;
        Log.w(TAG, "Unknown user restriction detected: " + key);
        goto L6
    L13:
        if (restrictions.getBoolean(key) == false) goto L6;
        serializer.attributeBoolean(null, key, true);
        goto L6
    L16:
        serializer.endTag(null, tag);
    }

    public static void readRestrictions(XmlPullParser parser, Bundle restrictions) {
        readRestrictions(XmlUtils.makeTyped(parser), restrictions);
    }

    public static void readRestrictions(TypedXmlPullParser parser, Bundle restrictions) {
        restrictions.clear();
        Iterator<String> r0 = USER_RESTRICTIONS.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String key = r0.next();
        boolean value = parser.getAttributeBoolean(null, key, false);
        if (value == false) goto L4;
        restrictions.putBoolean(key, true);
        goto L4
    }

    public static Bundle readRestrictions(XmlPullParser parser) {
        return readRestrictions(XmlUtils.makeTyped(parser));
    }

    public static Bundle readRestrictions(TypedXmlPullParser parser) {
        Bundle result = new Bundle();
        readRestrictions(parser, result);
        return result;
    }

    public static Bundle nonNull(Bundle in) {
        if (in == null) goto L5;
        return in;
    L5:
        return new Bundle();
    }

    public static boolean contains(Bundle in, String restriction) {
        if (in != null) goto L4;
    L6:
        return false;
    L4:
        if (in.getBoolean(restriction) == false) goto L6;
        return true;
    }

    public static void merge(Bundle dest, Bundle in) {
        dest.getClass();
        if (dest == in) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2);
        if (in != null) goto L9;
        return;
    L9:
        Iterator<String> r3 = in.keySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        String key = r3.next();
        if (in.getBoolean(key, false) == false) goto L11;
        dest.putBoolean(key, true);
        goto L11
    L16:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static boolean canDeviceOwnerChange(String restriction) {
        return !IMMUTABLE_BY_OWNERS.contains(restriction);
    }

    public static boolean canProfileOwnerChange(String restriction, boolean isMainUser, boolean isProfileOwnerOnOrgOwnedDevice) {
        if (IMMUTABLE_BY_OWNERS.contains(restriction) == false) goto L6;
        return false;
    L6:
        if (DEVICE_OWNER_ONLY_RESTRICTIONS.contains(restriction) == false) goto L8;
        return false;
    L8:
        if (isMainUser == false) goto L10;
    L13:
        if (isProfileOwnerOnOrgOwnedDevice == false) goto L15;
        return true;
    L15:
        if (PROFILE_OWNER_ORGANIZATION_OWNED_PROFILE_RESTRICTIONS.contains(restriction) == false) goto L19;
        return false;
    L19:
        return true;
    L10:
        if (MAIN_USER_ONLY_RESTRICTIONS.contains(restriction) == false) goto L13;
        return false;
    }

    public static boolean canParentOfProfileOwnerOfOrganizationOwnedDeviceChange(String restriction) {
        if (PROFILE_OWNER_ORGANIZATION_OWNED_PARENT_GLOBAL_RESTRICTIONS.contains(restriction) == false) goto L5;
    L8:
        return true;
    L5:
        if (PROFILE_OWNER_ORGANIZATION_OWNED_PARENT_LOCAL_RESTRICTIONS.contains(restriction) == true) goto L8;
        return false;
    }

    public static Set<String> getDefaultEnabledForManagedProfiles() {
        return DEFAULT_ENABLED_FOR_MANAGED_PROFILES;
    }

    public static boolean canFinancedDeviceOwnerChange(String restriction) {
        if (FINANCED_DEVICE_OWNER_RESTRICTIONS.contains(restriction) == true) goto L5;
    L7:
        return false;
    L5:
        if (canDeviceOwnerChange(restriction) == false) goto L7;
        return true;
    }

    public static boolean isGlobal(int restrictionOwnerType, String key) {
        if (restrictionOwnerType != 0) goto L8;
        if (MAIN_USER_ONLY_RESTRICTIONS.contains(key) == false) goto L6;
    L17:
        return true;
    L6:
        if (GLOBAL_RESTRICTIONS.contains(key) == true) goto L17;
    L8:
        if (restrictionOwnerType != 2) goto L12;
        if (PROFILE_OWNER_ORGANIZATION_OWNED_PARENT_GLOBAL_RESTRICTIONS.contains(key) == true) goto L17;
    L12:
        if (PROFILE_GLOBAL_RESTRICTIONS.contains(key) == true) goto L17;
        if (DEVICE_OWNER_ONLY_RESTRICTIONS.contains(key) == true) goto L17;
        return false;
    }

    public static boolean isLocal(int restrictionOwnerType, String key) {
        return !isGlobal(restrictionOwnerType, key);
    }

    public static boolean areEqual(Bundle a, Bundle b) {
        if (a != b) goto L6;
        return true;
    L6:
        if (BundleUtils.isEmpty(a) == false) goto L10;
        return BundleUtils.isEmpty(b);
    L10:
        if (BundleUtils.isEmpty(b) == false) goto L12;
        return false;
    L12:
        Iterator<String> r1 = a.keySet().iterator();
    L14:
        if (r1.hasNext() == false) goto L19;
        String key = r1.next();
        if (a.getBoolean(key) == b.getBoolean(key)) goto L14;
        return false;
    L19:
        Iterator<String> r2 = b.keySet().iterator();
    L21:
        if (r2.hasNext() == false) goto L26;
        String key2 = r2.next();
        if (a.getBoolean(key2) == b.getBoolean(key2)) goto L21;
        return false;
    L26:
        return true;
    }

    public static void applyUserRestrictions(Context context, int userId, Bundle newRestrictions, Bundle prevRestrictions) {
        Iterator<String> r0 = USER_RESTRICTIONS.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String key = r0.next();
        boolean newValue = newRestrictions.getBoolean(key);
        boolean prevValue = prevRestrictions.getBoolean(key);
        if (newValue == prevValue) goto L4;
        applyUserRestriction(context, userId, key, newValue);
        goto L4
    }

    private static void applyUserRestriction(Context context, int userId, String key, boolean newValue) {
        ContentResolver cr = context.getContentResolver();
        long id = Binder.clearCallingIdentity();
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(id);
        throw th;
    L4:
        int r7 = 1;
        switch(key.hashCode()) {
            case -1475388515: goto L43;
            case -1387500078: goto L40;
            case -1315771401: goto L37;
            case -1145953970: goto L34;
            case -1082175374: goto L31;
            case -6578707: goto L28;
            case 387189153: goto L25;
            case 721128150: goto L22;
            case 928851522: goto L19;
            case 995816019: goto L16;
            case 1095593830: goto L13;
            case 1760762284: goto L8;
            default: goto L45;
        };
    L45:
        byte r4 = -1;
    L47:
        switch(r4) {
            case 0: goto L84;
            case 1: goto L82;
            case 2: goto L79;
            case 3: goto L77;
            case 4: goto L76;
            case 5: goto L75;
            case 6: goto L65;
            case 7: goto L60;
            case 8: goto L52;
            case 9: goto L50;
            case 10: goto L49;
            case 11: goto L49;
            default: goto L93;
        };
    L49:
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: Throwable -> L10
        pmi.removeAllNonSystemPackageSuspensions(userId);     // Catch: Throwable -> L10
        pmi.removeAllDistractingPackageRestrictions(userId);     // Catch: Throwable -> L10
        pmi.flushPackageRestrictions(userId);     // Catch: Throwable -> L10
        goto L93
    L50:
        if (newValue == false) goto L93;
        AmbientDisplayConfiguration config = new AmbientDisplayConfiguration(context);     // Catch: Throwable -> L10
        config.disableDozeSettings(userId);     // Catch: Throwable -> L10
        goto L93
    L52:
        if (newValue == false) goto L93;
        if (android.provider.Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1) goto L57;
        r7 = 0;
    L57:
        if (r7 == 0) goto L93;
        android.provider.Settings.Global.putInt(context.getContentResolver(), "airplane_mode_on", 0);     // Catch: Throwable -> L10
        Intent intent = new Intent("android.intent.action.AIRPLANE_MODE");     // Catch: Throwable -> L10
        intent.putExtra("state", false);     // Catch: Throwable -> L10
        context.sendBroadcastAsUser(intent, UserHandle.ALL);     // Catch: Throwable -> L10
        goto L93
    L60:
        ContentResolver r0 = context.getContentResolver();     // Catch: Throwable -> L10
        if (newValue == true) goto L64;
        r7 = 0;
    L64:
        android.provider.Settings.Global.putInt(r0, "safe_boot_disallowed", r7);     // Catch: Throwable -> L10
        goto L93
    L65:
        if (newValue == false) goto L93;
        ActivityManager am = (ActivityManager) context.getSystemService(ActivityManager.class);     // Catch: Throwable -> L10
        if (am.isProfileForeground(UserHandle.of(userId)) == true) goto L93;
        if (userId == 0) goto L93;
        ActivityManager.getService().stopUserExceptCertainProfiles(userId, false, null);     // Catch: Throwable -> L10 RemoteException -> L71
    L71:
        e = move-exception;
        throw e.rethrowAsRuntimeException();     // Catch: Throwable -> L10
    L75:
        setInstallMarketAppsRestriction(cr, userId, getNewUserRestrictionSetting(context, userId, "no_install_unknown_sources_globally", newValue));     // Catch: Throwable -> L10
        goto L93
    L76:
        setInstallMarketAppsRestriction(cr, userId, getNewUserRestrictionSetting(context, userId, "no_install_unknown_sources", newValue));     // Catch: Throwable -> L10
        goto L93
    L77:
        if (newValue == false) goto L93;
        android.provider.Settings.Global.putStringForUser(context.getContentResolver(), "verifier_verify_adb_installs", "1", userId);     // Catch: Throwable -> L10
        goto L93
    L79:
        if (newValue == false) goto L93;
        if (userId != 0) goto L93;
        android.provider.Settings.Global.putStringForUser(cr, "adb_enabled", "0", userId);     // Catch: Throwable -> L10
        android.provider.Settings.Global.putStringForUser(cr, "adb_wifi_enabled", "0", userId);     // Catch: Throwable -> L10
        goto L93
    L82:
        if (newValue == false) goto L93;
        android.provider.Settings.Secure.putIntForUser(cr, "location_mode", 0, userId);     // Catch: Throwable -> L10
        goto L93
    L84:
        if (newValue == false) goto L93;
        SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService(SubscriptionManager.class);     // Catch: Throwable -> L10
        List<SubscriptionInfo> subscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();     // Catch: Throwable -> L10
        if (subscriptionInfoList == null) goto L92;
        Iterator<SubscriptionInfo> r6 = subscriptionInfoList.iterator();     // Catch: Throwable -> L10
    L90:
        if (r6.hasNext() == false) goto L92;
        SubscriptionInfo subInfo = r6.next();     // Catch: Throwable -> L10
        android.provider.Settings.Global.putStringForUser(cr, "data_roaming" + subInfo.getSubscriptionId(), "0", userId);     // Catch: Throwable -> L10
    L92:
        android.provider.Settings.Global.putStringForUser(cr, "data_roaming", "0", userId);     // Catch: Throwable -> L10
    L93:
        Binder.restoreCallingIdentity(id);
        return;
    L8:
        if (key.equals("no_debugging_features") == false) goto L45;
        r4 = 2;
        goto L47
    L13:
        if (key.equals("no_safe_boot") == false) goto L45;
        r4 = 7;
        goto L47
    L16:
        if (key.equals("no_share_location") == false) goto L45;
        r4 = 1;
        goto L47
    L19:
        if (key.equals("no_data_roaming") == false) goto L45;
        r4 = 0;
        goto L47
    L22:
        if (key.equals("no_run_in_background") == false) goto L45;
        r4 = 6;
        goto L47
    L25:
        if (key.equals("no_install_unknown_sources") == false) goto L45;
        r4 = 5;
        goto L47
    L28:
        if (key.equals("no_uninstall_apps") == false) goto L45;
        r4 = 11;
        goto L47
    L31:
        if (key.equals("no_airplane_mode") == false) goto L45;
        r4 = 8;
        goto L47
    L34:
        if (key.equals("no_install_unknown_sources_globally") == false) goto L45;
        r4 = 4;
        goto L47
    L37:
        if (key.equals("ensure_verify_apps") == false) goto L45;
        r4 = 3;
        goto L47
    L40:
        if (key.equals("no_control_apps") == false) goto L45;
        r4 = 10;
        goto L47
    L43:
        if (key.equals("no_ambient_display") == false) goto L45;
        r4 = 9;
        goto L47
    }

    public static boolean isSettingRestrictedForUser(Context context, String setting, int userId, String value, int callingUid) {
        setting.getClass();
        UserManager mUserManager = (UserManager) context.getSystemService(UserManager.class);
        switch(setting.hashCode()) {
            case -2099894345: goto L72;
            case -1796809747: goto L69;
            case -1490222856: goto L66;
            case -1115710219: goto L63;
            case -970351711: goto L60;
            case -693072130: goto L57;
            case -623873498: goto L54;
            case -416662510: goto L51;
            case -101820922: goto L48;
            case -32505807: goto L45;
            case 58027029: goto L42;
            case 258514750: goto L39;
            case 683724341: goto L36;
            case 926123534: goto L33;
            case 1073289638: goto L30;
            case 1223734380: goto L27;
            case 1275530062: goto L24;
            case 1334097968: goto L21;
            case 1602982312: goto L18;
            case 1646894952: goto L15;
            case 1661297501: goto L12;
            case 1701140351: goto L9;
            case 1735689732: goto L6;
            default: goto L74;
        };
    L74:
        byte r2 = -1;
    L76:
        switch(r2) {
            case 0: goto L128;
            case 1: goto L124;
            case 2: goto L120;
            case 3: goto L120;
            case 4: goto L116;
            case 5: goto L114;
            case 6: goto L108;
            case 7: goto L108;
            case 8: goto L108;
            case 9: goto L105;
            case 10: goto L101;
            case 11: goto L97;
            case 12: goto L97;
            case 13: goto L97;
            case 14: goto L97;
            case 15: goto L97;
            case 16: goto L93;
            case 17: goto L93;
            case 18: goto L90;
            case 19: goto L90;
            case 20: goto L87;
            case 21: goto L84;
            case 22: goto L84;
            default: goto L78;
        };
    L84:
        if (callingUid != 1000) goto L86;
        return false;
    L86:
        String restriction = "disallow_config_private_dns";
    L135:
        if (0 == 0) goto L139;
        return mUserManager.hasUserRestrictionOnAnyUser(restriction);
    L139:
        return mUserManager.hasUserRestriction(restriction, UserHandle.of(userId));
    L87:
        if (callingUid != 1000) goto L89;
        return false;
    L89:
        restriction = "no_config_screen_timeout";
        goto L135
    L90:
        if (callingUid != 1000) goto L92;
        return false;
    L92:
        restriction = "no_config_date_time";
        goto L135
    L93:
        if (callingUid != 1000) goto L95;
        return false;
    L95:
        restriction = "no_config_brightness";
        goto L135
    L108:
        int appId = UserHandle.getAppId(callingUid);
        if (appId == 1000) goto L113;
        if (appId == 0) goto L113;
        restriction = "no_config_vpn";
    L113:
        return false;
    L114:
        restriction = "no_config_mobile_networks";
        goto L135
    L78:
        if (setting.startsWith("data_roaming") == true) goto L80;
        return false;
    L80:
        if ("0".equals(value) == false) goto L82;
        return false;
    L82:
        restriction = "no_data_roaming";
        goto L135
    L97:
        if ("0".equals(value) == false) goto L99;
        return false;
    L99:
        restriction = "no_ambient_display";
        goto L135
    L101:
        if ("0".equals(value) == false) goto L103;
        return false;
    L103:
        restriction = "no_airplane_mode";
        goto L135
    L105:
        if ("1".equals(value) == false) goto L107;
        return false;
    L107:
        restriction = "no_safe_boot";
        goto L135
    L116:
        if ("1".equals(value) == false) goto L118;
        return false;
    L118:
        restriction = "ensure_verify_apps";
        goto L135
    L120:
        if ("0".equals(value) == false) goto L122;
        return false;
    L122:
        restriction = "no_debugging_features";
        goto L135
    L124:
        if ("0".equals(value) == false) goto L126;
        return false;
    L126:
        restriction = "no_install_unknown_sources";
        goto L135
    L128:
        if (mUserManager.hasUserRestriction("no_config_location", UserHandle.of(userId)) == false) goto L132;
        if (callingUid == 1000) goto L132;
        return true;
    L132:
        if (String.valueOf(0).equals(value) == false) goto L134;
        return false;
    L134:
        restriction = "no_share_location";
        goto L135
    L6:
        if (setting.equals("screen_brightness") == false) goto L74;
        r2 = 16;
        goto L76
    L9:
        if (setting.equals("install_non_market_apps") == false) goto L74;
        r2 = 1;
        goto L76
    L12:
        if (setting.equals("auto_time") == false) goto L74;
        r2 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L76
    L15:
        if (setting.equals("always_on_vpn_lockdown") == false) goto L74;
        r2 = 7;
        goto L76
    L18:
        if (setting.equals("doze_pulse_on_pick_up") == false) goto L74;
        r2 = 13;
        goto L76
    L21:
        if (setting.equals("always_on_vpn_lockdown_whitelist") == false) goto L74;
        r2 = 8;
        goto L76
    L24:
        if (setting.equals("auto_time_zone") == false) goto L74;
        r2 = ParameterName.FILM_MODE;
        goto L76
    L27:
        if (setting.equals("private_dns_specifier") == false) goto L74;
        r2 = ParameterName.COLOR_TUNE;
        goto L76
    L30:
        if (setting.equals("doze_pulse_on_double_tap") == false) goto L74;
        r2 = 15;
        goto L76
    L33:
        if (setting.equals("airplane_mode_on") == false) goto L74;
        r2 = 10;
        goto L76
    L36:
        if (setting.equals("private_dns_mode") == false) goto L74;
        r2 = ParameterName.BLUE_STRETCH;
        goto L76
    L39:
        if (setting.equals("screen_off_timeout") == false) goto L74;
        r2 = ParameterName.BLACK_STRETCH;
        goto L76
    L42:
        if (setting.equals("safe_boot_disallowed") == false) goto L74;
        r2 = 9;
        goto L76
    L45:
        if (setting.equals("doze_pulse_on_long_press") == false) goto L74;
        r2 = 14;
        goto L76
    L48:
        if (setting.equals("doze_always_on") == false) goto L74;
        r2 = 12;
        goto L76
    L51:
        if (setting.equals("preferred_network_mode") == false) goto L74;
        r2 = 5;
        goto L76
    L54:
        if (setting.equals("always_on_vpn_app") == false) goto L74;
        r2 = 6;
        goto L76
    L57:
        if (setting.equals("screen_brightness_mode") == false) goto L74;
        r2 = ParameterName.DE_CONTOUR;
        goto L76
    L60:
        if (setting.equals("adb_enabled") == false) goto L74;
        r2 = 2;
        goto L76
    L63:
        if (setting.equals("verifier_verify_adb_installs") == false) goto L74;
        r2 = 4;
        goto L76
    L66:
        if (setting.equals("doze_enabled") == false) goto L74;
        r2 = 11;
        goto L76
    L69:
        if (setting.equals("location_mode") == false) goto L74;
        r2 = 0;
        goto L76
    L72:
        if (setting.equals("adb_wifi_enabled") == false) goto L74;
        r2 = 3;
        goto L76
    }

    public static void dumpRestrictions(PrintWriter pw, String prefix, Bundle restrictions) {
        boolean noneSet = true;
        if (restrictions == null) goto L13;
        Iterator<String> r1 = restrictions.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        String key = r1.next();
        if (restrictions.getBoolean(key, false) == false) goto L6;
        pw.println(prefix + key);
        noneSet = false;
        goto L6
    L11:
        if (noneSet == false) goto L20;
        pw.println(prefix + "none");
        return;
    L20:
        return;
    L13:
        pw.println(prefix + "null");
    }

    public static void moveRestriction(String restrictionKey, SparseArray<RestrictionsSet> sourceRestrictionsSets, RestrictionsSet destRestrictionSet) {
        int i = 0;
    L4:
        if (i >= sourceRestrictionsSets.size()) goto L7;
        RestrictionsSet sourceRestrictionsSet = sourceRestrictionsSets.valueAt(i);
        sourceRestrictionsSet.moveRestriction(destRestrictionSet, restrictionKey);
        i = i + 1;
        goto L4
    }

    public static boolean restrictionsChanged(Bundle oldRestrictions, Bundle newRestrictions, String... restrictions) {
        if (restrictions.length == 0) goto L5;
        int r0 = restrictions.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L13;
        String restriction = restrictions[r2];
        if (oldRestrictions.getBoolean(restriction, false) != newRestrictions.getBoolean(restriction, false)) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return true;
    L13:
        return false;
    L5:
        return areEqual(oldRestrictions, newRestrictions);
    }

    private static void setInstallMarketAppsRestriction(ContentResolver cr, int userId, int settingValue) {
        android.provider.Settings.Secure.putIntForUser(cr, "install_non_market_apps", settingValue, userId);
    }

    private static int getNewUserRestrictionSetting(Context context, int userId, String userRestriction, boolean newValue) {
        if (newValue == false) goto L4;
    L7:
        return 0;
    L4:
        if (UserManager.get(context).hasUserRestriction(userRestriction, UserHandle.of(userId)) == true) goto L7;
        return 1;
    }
}
