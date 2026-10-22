package com.android.server.pm;

import android.R;
import android.content.pm.UserInfo;
import android.content.pm.UserProperties;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.util.XmlUtils;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class UserTypeFactory {
    private static final String LOG_TAG = "UserTypeFactory";

    public static class UserTypeUpgrade {
        private final String mFromType;
        private final String mToType;
        private final int mUpToVersion;

        public UserTypeUpgrade(String fromType, String toType, int upToVersion) {
            this.mFromType = fromType;
            this.mToType = toType;
            this.mUpToVersion = upToVersion;
        }

        public String getFromType() {
            return this.mFromType;
        }

        public String getToType() {
            return this.mToType;
        }

        public int getUpToVersion() {
            return this.mUpToVersion;
        }
    }

    private UserTypeFactory() {
    }

    public static ArrayMap<String, UserTypeDetails> getUserTypes() {
        ArrayMap<String, UserTypeDetails.Builder> builders = getDefaultBuilders();
        XmlResourceParser parser = Resources.getSystem().getXml(R.xml.config_user_types);
        customizeBuilders(builders, parser);     // Catch: Throwable -> L12
        if (parser == null) goto L6;
        parser.close();
    L6:
        ArrayMap<String, UserTypeDetails> types = new ArrayMap(builders.size());
        int i = 0;
    L8:
        if (i >= builders.size()) goto L11;
        types.put(builders.keyAt(i), builders.valueAt(i).createUserTypeDetails());
        i = i + 1;
        goto L8
    L11:
        return types;
    L12:
        th = move-exception;
        if (parser != null) goto L19;
    L18:
        throw th;
    L19:
        parser.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    }

    private static ArrayMap<String, UserTypeDetails.Builder> getDefaultBuilders() {
        ArrayMap<String, UserTypeDetails.Builder> builders = new ArrayMap();
        builders.put("android.os.usertype.profile.MANAGED", getDefaultTypeProfileManaged());
        builders.put("android.os.usertype.full.SYSTEM", getDefaultTypeFullSystem());
        builders.put("android.os.usertype.full.SECONDARY", getDefaultTypeFullSecondary());
        builders.put("android.os.usertype.full.GUEST", getDefaultTypeFullGuest());
        builders.put("android.os.usertype.full.DEMO", getDefaultTypeFullDemo());
        builders.put("android.os.usertype.full.RESTRICTED", getDefaultTypeFullRestricted());
        builders.put("android.os.usertype.system.HEADLESS", getDefaultTypeSystemHeadless());
        builders.put("android.os.usertype.profile.CLONE", getDefaultTypeProfileClone());
        builders.put("android.os.usertype.profile.COMMUNAL", getDefaultTypeProfileCommunal());
        builders.put("android.os.usertype.profile.PRIVATE", getDefaultTypeProfilePrivate());
        builders.put("android.os.usertype.profile.SUPERVISING", getDefaultTypeProfileSupervising());
        if (Build.IS_DEBUGGABLE == false) goto L5;
        builders.put("android.os.usertype.profile.TEST", getDefaultTypeProfileTest());
    L5:
        return builders;
    }

    private static UserTypeDetails.Builder getDefaultTypeProfileClone() {
        return new UserTypeDetails.Builder().setName("android.os.usertype.profile.CLONE").setBaseType(4096).setMaxAllowedPerParent(1).setProfileParentRequired(true).setLabels(new int[]{R.string.serviceEnabledFor}).setIconBadge(R.drawable.ic_voice_search_api_holo_light).setBadgePlain(R.drawable.ic_voice_search_api_holo_dark).setBadgeNoBackground(R.drawable.ic_voice_search_api_holo_dark).setStatusBarIcon(0).setBadgeLabels(new int[]{R.string.config_customCountryDetector}).setBadgeColors(new int[]{R.color.system_neutral2_800}).setDarkThemeBadgeColors(new int[]{R.color.system_neutral2_900}).setAccessibilityString(R.string.accessibility_service_warning_description).setDefaultRestrictions(null).setDefaultCrossProfileIntentFilters(getDefaultCloneCrossProfileIntentFilter()).setDefaultSecureSettings(getDefaultNonManagedProfileSecureSettings()).setDefaultUserProperties(new UserProperties.Builder().setStartWithParent(true).setShowInLauncher(0).setShowInSettings(0).setInheritDevicePolicy(1).setUseParentsContacts(true).setUpdateCrossProfileIntentFiltersOnOTA(true).setCrossProfileIntentFilterAccessControl(10).setCrossProfileIntentResolutionStrategy(1).setShowInQuietMode(2).setShowInSharingSurfaces(0).setMediaSharedWithParent(true).setCredentialShareableWithParent(true).setDeleteAppWithParent(true).setCrossProfileContentSharingStrategy(1));
    }

    private static UserTypeDetails.Builder getDefaultTypeProfileManaged() {
        return new UserTypeDetails.Builder().setName("android.os.usertype.profile.MANAGED").setBaseType(4096).setDefaultUserInfoPropertyFlags(32).setMaxAllowedPerParent(1).setProfileParentRequired(true).setLabels(new int[]{R.string.set_up_screen_lock_title, R.string.sha1_fingerprint, R.string.sha256_fingerprint}).setIconBadge(R.drawable.ic_zen_mode_icon_gym).setBadgePlain(R.drawable.ic_zen_mode_icon_croissant).setBadgeNoBackground(R.drawable.ic_zen_mode_icon_gaming).setStatusBarIcon(17305217).setBadgeLabels(new int[]{R.string.mime_type_video_ext, R.string.miniresolver_call, R.string.miniresolver_call_in_work}).setBadgeColors(new int[]{17171406, 17171408, 17171410}).setDarkThemeBadgeColors(new int[]{17171407, 17171409, 17171411}).setAccessibilityString(R.string.accessibility_shortcut_enabling_service).setDefaultRestrictions(getDefaultProfileRestrictions()).setDefaultSecureSettings(getDefaultManagedProfileSecureSettings()).setDefaultCrossProfileIntentFilters(getDefaultManagedCrossProfileIntentFilter()).setDefaultUserProperties(new UserProperties.Builder().setStartWithParent(true).setShowInLauncher(1).setShowInSettings(1).setShowInQuietMode(0).setShowInSharingSurfaces(1).setAuthAlwaysRequiredToDisableQuietMode(false).setCredentialShareableWithParent(true));
    }

    private static UserTypeDetails.Builder getDefaultTypeProfileTest() {
        Bundle restrictions = getDefaultProfileRestrictions();
        restrictions.putBoolean("no_fun", true);
        return new UserTypeDetails.Builder().setName("android.os.usertype.profile.TEST").setBaseType(4096).setMaxAllowedPerParent(2).setProfileParentRequired(true).setLabels(new int[]{R.string.set_up_screen_lock_action_label, R.string.set_up_screen_lock_action_label, R.string.set_up_screen_lock_action_label}).setIconBadge(R.drawable.pointer_wait_vector_21).setBadgePlain(R.drawable.pointer_wait_vector_2).setBadgeNoBackground(R.drawable.pointer_wait_vector_20).setStatusBarIcon(R.drawable.pointer_wait_vector_2).setBadgeLabels(new int[]{R.string.mime_type_video_ext, R.string.miniresolver_call, R.string.miniresolver_call_in_work}).setBadgeColors(new int[]{17171406, 17171408, 17171410}).setDarkThemeBadgeColors(new int[]{17171407, 17171409, 17171411}).setDefaultRestrictions(restrictions).setDefaultSecureSettings(getDefaultNonManagedProfileSecureSettings());
    }

    private static UserTypeDetails.Builder getDefaultTypeProfileCommunal() {
        return new UserTypeDetails.Builder().setName("android.os.usertype.profile.COMMUNAL").setBaseType(4096).setMaxAllowed(1).setProfileParentRequired(false).setEnabled(UserManager.isCommunalProfileEnabled() ? 1 : 0).setLabels(new int[]{R.string.serviceErased}).setIconBadge(R.drawable.pointer_wait_vector_21).setBadgePlain(R.drawable.pointer_wait_vector_2).setBadgeNoBackground(R.drawable.pointer_wait_vector_20).setStatusBarIcon(R.drawable.pointer_wait_vector_2).setBadgeLabels(new int[]{R.string.mime_type_video_ext, R.string.miniresolver_call, R.string.miniresolver_call_in_work}).setBadgeColors(new int[]{17171406, 17171408, 17171410}).setDarkThemeBadgeColors(new int[]{17171407, 17171409, 17171411}).setDefaultRestrictions(getDefaultProfileRestrictions()).setDefaultSecureSettings(getDefaultNonManagedProfileSecureSettings()).setDefaultUserProperties(new UserProperties.Builder().setStartWithParent(false).setShowInLauncher(1).setShowInSettings(1).setCredentialShareableWithParent(false).setAlwaysVisible(true));
    }

    private static UserTypeDetails.Builder getDefaultTypeProfilePrivate() {
        return new UserTypeDetails.Builder().setName("android.os.usertype.profile.PRIVATE").setBaseType(4096).setProfileParentRequired(true).setMaxAllowedPerParent(1).setEnabled(UserManager.isPrivateProfileEnabled() ? 1 : 0).setLabels(new int[]{R.string.serviceNotProvisioned}).setIconBadge(R.drawable.pointer_wait_4).setBadgePlain(R.drawable.pointer_wait_39).setBadgeNoBackground(R.drawable.pointer_wait_39).setStatusBarIcon(17305218).setBadgeLabels(new int[]{R.string.serviceClassDataAsync}).setBadgeColors(new int[]{R.color.black}).setDarkThemeBadgeColors(new int[]{R.color.white}).setAccessibilityString(R.string.accessibility_shortcut_menu_item_status_off).setDefaultRestrictions(getDefaultPrivateProfileRestrictions()).setDefaultCrossProfileIntentFilters(getDefaultPrivateCrossProfileIntentFilter()).setDefaultUserProperties(new UserProperties.Builder().setStartWithParent(true).setCredentialShareableWithParent(true).setAuthAlwaysRequiredToDisableQuietMode(true).setAllowStoppingUserWithDelayedLocking(true).setMediaSharedWithParent(false).setShowInLauncher(1).setShowInSettings(1).setShowInQuietMode(1).setShowInSharingSurfaces(1).setCrossProfileIntentFilterAccessControl(10).setInheritDevicePolicy(1).setCrossProfileContentSharingStrategy(1).setProfileApiVisibility(1).setItemsRestrictedOnHomeScreen(true).setUpdateCrossProfileIntentFiltersOnOTA(true));
    }

    private static UserTypeDetails.Builder getDefaultTypeProfileSupervising() {
        return new UserTypeDetails.Builder().setName("android.os.usertype.profile.SUPERVISING").setBaseType(4096).setMaxAllowed(1).setProfileParentRequired(false).setEnabled(0).setLabels(new int[]{R.string.serviceRegistered}).setDefaultRestrictions(getDefaultSupervisingProfileRestrictions()).setDefaultSecureSettings(getDefaultNonManagedProfileSecureSettings()).setDefaultUserProperties(new UserProperties.Builder().setStartWithParent(false).setShowInLauncher(2).setShowInSettings(2).setShowInQuietMode(1).setCredentialShareableWithParent(false).setAlwaysVisible(true));
    }

    private static UserTypeDetails.Builder getDefaultTypeFullSecondary() {
        return new UserTypeDetails.Builder().setName("android.os.usertype.full.SECONDARY").setBaseType(1024).setMaxAllowed(-1).setDefaultRestrictions(getDefaultSecondaryUserRestrictions());
    }

    private static UserTypeDetails.Builder getDefaultTypeFullGuest() {
        boolean ephemeralGuests = Resources.getSystem().getBoolean(R.bool.config_hideNavBarForKeyboard);
        if (ephemeralGuests == false) goto L5;
        int r1 = 256;
    L6:
        int flags = r1 | 4;
        return new UserTypeDetails.Builder().setName("android.os.usertype.full.GUEST").setBaseType(1024).setDefaultUserInfoPropertyFlags(flags).setMaxAllowed(1).setDefaultRestrictions(getDefaultGuestUserRestrictions());
    L5:
        r1 = 0;
        goto L6
    }

    private static UserTypeDetails.Builder getDefaultTypeFullDemo() {
        return new UserTypeDetails.Builder().setName("android.os.usertype.full.DEMO").setBaseType(1024).setDefaultUserInfoPropertyFlags(512).setMaxAllowed(-1).setDefaultRestrictions(null);
    }

    private static UserTypeDetails.Builder getDefaultTypeFullRestricted() {
        return new UserTypeDetails.Builder().setName("android.os.usertype.full.RESTRICTED").setBaseType(1024).setDefaultUserInfoPropertyFlags(8).setMaxAllowed(-1).setProfileParentRequired(false).setDefaultRestrictions(null);
    }

    private static UserTypeDetails.Builder getDefaultTypeFullSystem() {
        return new UserTypeDetails.Builder().setName("android.os.usertype.full.SYSTEM").setBaseType(3072).setDefaultUserInfoPropertyFlags(16387).setMaxAllowed(1);
    }

    private static UserTypeDetails.Builder getDefaultTypeSystemHeadless() {
        return new UserTypeDetails.Builder().setName("android.os.usertype.system.HEADLESS").setBaseType(2048).setDefaultUserInfoPropertyFlags(3).setMaxAllowed(1);
    }

    private static Bundle getDefaultSecondaryUserRestrictions() {
        Bundle restrictions = new Bundle();
        restrictions.putBoolean("no_outgoing_calls", true);
        restrictions.putBoolean("no_sms", true);
        return restrictions;
    }

    private static Bundle getDefaultGuestUserRestrictions() {
        Bundle restrictions = getDefaultSecondaryUserRestrictions();
        restrictions.putBoolean("no_config_wifi", true);
        restrictions.putBoolean("no_install_unknown_sources", true);
        restrictions.putBoolean("no_config_credentials", true);
        return restrictions;
    }

    private static Bundle getDefaultProfileRestrictions() {
        Bundle restrictions = new Bundle();
        restrictions.putBoolean("no_wallpaper", true);
        return restrictions;
    }

    static Bundle getDefaultPrivateProfileRestrictions() {
        Bundle restrictions = getDefaultProfileRestrictions();
        restrictions.putBoolean("no_bluetooth_sharing", true);
        return restrictions;
    }

    private static Bundle getDefaultSupervisingProfileRestrictions() {
        Bundle restrictions = getDefaultProfileRestrictions();
        restrictions.putBoolean("no_install_apps", true);
        return restrictions;
    }

    private static Bundle getDefaultManagedProfileSecureSettings() {
        Bundle settings = new Bundle();
        settings.putString("managed_profile_contact_remote_search", "1");
        settings.putString("cross_profile_calendar_enabled", "1");
        return settings;
    }

    private static List<DefaultCrossProfileIntentFilter> getDefaultManagedCrossProfileIntentFilter() {
        return DefaultCrossProfileIntentFiltersUtils.getDefaultManagedProfileFilters();
    }

    private static List<DefaultCrossProfileIntentFilter> getDefaultCloneCrossProfileIntentFilter() {
        return DefaultCrossProfileIntentFiltersUtils.getDefaultCloneProfileFilters();
    }

    private static List<DefaultCrossProfileIntentFilter> getDefaultPrivateCrossProfileIntentFilter() {
        return DefaultCrossProfileIntentFiltersUtils.getDefaultPrivateProfileFilters();
    }

    private static Bundle getDefaultNonManagedProfileSecureSettings() {
        Bundle settings = new Bundle();
        settings.putString("user_setup_complete", "1");
        return settings;
    }

    static void customizeBuilders(ArrayMap<String, UserTypeDetails.Builder> builders, XmlResourceParser parser) {
        XmlUtils.beginDocument(parser, "user-types");     // Catch: Throwable -> L26
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L26
    L4:
        boolean isValid = true;
        if (parser.getEventType() == 1) goto L94;
        String elementName = parser.getName();     // Catch: Throwable -> L26
        if ("profile-type".equals(elementName) == false) goto L11;
        boolean isProfile = true;
    L13:
        String typeName = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L26 Throwable -> L26
        if (typeName == null) goto L69;
        if (typeName.equals("") == true) goto L69;
        String typeName2 = typeName.intern();     // Catch: Throwable -> L26 Throwable -> L26
        if (typeName2.startsWith("android.") == false) goto L40;
        Slog.i(LOG_TAG, "Customizing user type " + typeName2);     // Catch: Throwable -> L26 Throwable -> L26
        final UserTypeDetails.Builder builder = builders.get(typeName2);     // Catch: Throwable -> L26 Throwable -> L26
        if (builder == null) goto L39;
        if (isProfile == true) goto L24;
    L28:
        if (isProfile == false) goto L30;
    L32:
        isValid = false;
    L34:
        if (isValid == false) goto L37;
    L42:
        if (isProfile == false) goto L44;
        builder.getClass();     // Catch: Throwable -> L26 Throwable -> L26
        setIntAttribute(parser, "max-allowed-per-parent", new UserTypeFactory$$ExternalSyntheticLambda0(builder));     // Catch: Throwable -> L26 Throwable -> L26
        builder.getClass();     // Catch: Throwable -> L26 Throwable -> L26
        setResAttribute(parser, "icon-badge", new UserTypeFactory$$ExternalSyntheticLambda1(builder));     // Catch: Throwable -> L26 Throwable -> L26
        builder.getClass();     // Catch: Throwable -> L26 Throwable -> L26
        setResAttribute(parser, "badge-plain", new UserTypeFactory$$ExternalSyntheticLambda2(builder));     // Catch: Throwable -> L26 Throwable -> L26
        builder.getClass();     // Catch: Throwable -> L26 Throwable -> L26
        setResAttribute(parser, "badge-no-background", new UserTypeFactory$$ExternalSyntheticLambda3(builder));     // Catch: Throwable -> L26 Throwable -> L26
        builder.getClass();     // Catch: Throwable -> L26 Throwable -> L26
        setResAttribute(parser, "status-bar-icon", new UserTypeFactory$$ExternalSyntheticLambda4(builder));     // Catch: Throwable -> L26 Throwable -> L26
    L44:
        builder.getClass();     // Catch: Throwable -> L26 Throwable -> L26
        setIntAttribute(parser, ServiceConfigAccessor.PROVIDER_MODE_ENABLED, new UserTypeFactory$$ExternalSyntheticLambda5(builder));     // Catch: Throwable -> L26 Throwable -> L26
        builder.getClass();     // Catch: Throwable -> L26 Throwable -> L26
        setIntAttribute(parser, "max-allowed", new UserTypeFactory$$ExternalSyntheticLambda6(builder));     // Catch: Throwable -> L26 Throwable -> L26
        int depth = parser.getDepth();     // Catch: Throwable -> L26 Throwable -> L26
    L46:
        if (XmlUtils.nextElementWithin(parser, depth) == false) goto L74;
        String childName = parser.getName();     // Catch: Throwable -> L26 Throwable -> L26
        if ("default-restrictions".equals(childName) == false) goto L50;
        Bundle restrictions = UserRestrictionsUtils.readRestrictions(XmlUtils.makeTyped(parser));     // Catch: Throwable -> L26 Throwable -> L26
        builder.setDefaultRestrictions(restrictions);     // Catch: Throwable -> L26 Throwable -> L26
        goto L46
    L50:
        if (isProfile == true) goto L52;
    L54:
        if (isProfile == true) goto L56;
    L58:
        if (isProfile == false) goto L63;
        if ("badge-colors-dark".equals(childName) == false) goto L63;
        builder.getClass();     // Catch: Throwable -> L26 Throwable -> L26
        setResAttributeArray(parser, new UserTypeFactory$$ExternalSyntheticLambda9(builder));     // Catch: Throwable -> L26 Throwable -> L26
    L63:
        if ("user-properties".equals(childName) == false) goto L65;
        builder.getDefaultUserProperties().updateFromXml(XmlUtils.makeTyped(parser));     // Catch: Throwable -> L26 Throwable -> L26
        goto L46
    L65:
        Slog.w(LOG_TAG, "Unrecognized tag " + childName + " in " + parser.getPositionDescription());     // Catch: Throwable -> L26 Throwable -> L26
        goto L46
    L56:
        if ("badge-colors".equals(childName) == false) goto L58;
        builder.getClass();     // Catch: Throwable -> L26 Throwable -> L26
        setResAttributeArray(parser, new UserTypeFactory$$ExternalSyntheticLambda8(builder));     // Catch: Throwable -> L26 Throwable -> L26
        goto L46
    L52:
        if ("badge-labels".equals(childName) == false) goto L54;
        builder.getClass();     // Catch: Throwable -> L26 Throwable -> L26
        setResAttributeArray(parser, new UserTypeFactory$$ExternalSyntheticLambda7(builder));     // Catch: Throwable -> L26 Throwable -> L26
    L74:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L26 Throwable -> L26
        goto L4
    L37:
        throw new IllegalArgumentException("Wrong base type to customize user type (" + typeName2 + "), which is type " + UserInfo.flagsToString(builder.getBaseType()));     // Catch: Throwable -> L26 Throwable -> L26
    L30:
        if (builder.getBaseType() != 1024) goto L32;
    L24:
        if (builder.getBaseType() == 4096) goto L34;
    L39:
        throw new IllegalArgumentException("Illegal custom user type name " + typeName2 + ": Non-AOSP user types cannot start with 'android.'");     // Catch: Throwable -> L26 Throwable -> L26
    L40:
        if (isProfile == false) goto L68;
        Slog.i(LOG_TAG, "Creating custom user type " + typeName2);     // Catch: Throwable -> L26 Throwable -> L26
        builder = new UserTypeDetails.Builder();     // Catch: Throwable -> L26 Throwable -> L26
        builder.setName(typeName2);     // Catch: Throwable -> L26 Throwable -> L26
        builder.setBaseType(4096);     // Catch: Throwable -> L26 Throwable -> L26
        builder.setProfileParentRequired(true);     // Catch: Throwable -> L26 Throwable -> L26
        builders.put(typeName2, builder);     // Catch: Throwable -> L26 Throwable -> L26
        goto L42
    L68:
        throw new IllegalArgumentException("Creation of non-profile user type (" + typeName2 + ") is not currently supported.");     // Catch: Throwable -> L26 Throwable -> L26
    L69:
        Slog.w(LOG_TAG, "Skipping user type with no name in " + parser.getPositionDescription());     // Catch: Throwable -> L26 Throwable -> L26
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L26 Throwable -> L26
        goto L74
    L11:
        if ("full-type".equals(elementName) == false) goto L71;
        isProfile = false;
        goto L13
    L71:
        if ("change-user-type".equals(elementName) == false) goto L73;
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L26 Throwable -> L26
        goto L74
    L73:
        Slog.w(LOG_TAG, "Skipping unknown element " + elementName + " in " + parser.getPositionDescription());     // Catch: Throwable -> L26 Throwable -> L26
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L26 Throwable -> L26
        goto L74
    L94:
        return;
    L26:
        e = move-exception;
        Slog.w(LOG_TAG, "Cannot read user type configuration file.", e);
    }

    private static void setIntAttribute(XmlResourceParser parser, String attributeName, Consumer<Integer> fcn) {
        String intValue = parser.getAttributeValue(null, attributeName);
        if (intValue != null) goto L10;
        return;
    L10:
        fcn.accept(Integer.valueOf(Integer.parseInt(intValue)));     // Catch: NumberFormatException -> L7
        return;
    L7:
        e = move-exception;
        Slog.e(LOG_TAG, "Cannot parse value of '" + intValue + "' for " + attributeName + " in " + parser.getPositionDescription(), e);
        throw e;
    }

    private static void setResAttribute(XmlResourceParser parser, String attributeName, Consumer<Integer> fcn) {
        if (parser.getAttributeValue(null, attributeName) != null) goto L5;
        return;
    L5:
        int resId = parser.getAttributeResourceValue(null, attributeName, 0);
        fcn.accept(Integer.valueOf(resId));
    }

    private static void setResAttributeArray(XmlResourceParser parser, Consumer<int[]> fcn) throws IOException, XmlPullParserException {
        ArrayList<Integer> resList = new ArrayList();
        int depth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, depth) == false) goto L12;
        String elementName = parser.getName();
        if (Settings.TAG_ITEM.equals(elementName) == false) goto L7;
        int resId = parser.getAttributeResourceValue(null, "res", -1);
        if (resId == (-1)) goto L4;
        resList.add(Integer.valueOf(resId));
        goto L4
    L7:
        Slog.w(LOG_TAG, "Skipping unknown child element " + elementName + " in " + parser.getPositionDescription());
        XmlUtils.skipCurrentTag(parser);
        goto L4
    L12:
        int[] result = new int[resList.size()];
        int i = 0;
    L14:
        if (i >= resList.size()) goto L16;
        result[i] = resList.get(i).intValue();
        i = i + 1;
        goto L14
    L16:
        fcn.accept(result);
    }

    public static int getUserTypeVersion() {
        XmlResourceParser parser = Resources.getSystem().getXml(R.xml.config_user_types);
        int r1 = getUserTypeVersion(parser);     // Catch: Throwable -> L7
        if (parser == null) goto L6;
        parser.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (parser != null) goto L16;
    L13:
        throw th;
    L16:
        parser.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    static int getUserTypeVersion(XmlResourceParser parser) {
        XmlUtils.beginDocument(parser, "user-types");     // Catch: Throwable -> L7
        String versionValue = parser.getAttributeValue(null, "version");     // Catch: Throwable -> L7
        if (versionValue == null) goto L18;
        int version = Integer.parseInt(versionValue);     // Catch: Throwable -> L7 Throwable -> L7 NumberFormatException -> L9
        return version;
    L9:
        e = move-exception;
        Slog.e(LOG_TAG, "Cannot parse value of '" + versionValue + "' for version in " + parser.getPositionDescription(), e);     // Catch: Throwable -> L7 Throwable -> L7
        throw e;     // Catch: Throwable -> L7 Throwable -> L7
    L18:
        return 0;
    L7:
        e = move-exception;
        Slog.w(LOG_TAG, "Cannot read user type configuration file.", e);
        return 0;
    }

    public static List<UserTypeUpgrade> getUserTypeUpgrades() {
        XmlResourceParser parser = Resources.getSystem().getXml(R.xml.config_user_types);
        List<UserTypeUpgrade> userUpgrades = parseUserUpgrades(getDefaultBuilders(), parser);     // Catch: Throwable -> L7
        if (parser == null) goto L6;
        parser.close();
    L6:
        return userUpgrades;
    L7:
        th = move-exception;
        if (parser != null) goto L14;
    L13:
        throw th;
    L14:
        parser.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    static List<UserTypeUpgrade> parseUserUpgrades(ArrayMap<String, UserTypeDetails.Builder> builders, XmlResourceParser parser) {
        List<UserTypeUpgrade> userUpgrades = new ArrayList();
        XmlUtils.beginDocument(parser, "user-types");     // Catch: Throwable -> L11
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L11
    L5:
        if (parser.getEventType() == 1) goto L21;
        String elementName = parser.getName();     // Catch: Throwable -> L11
        if ("change-user-type".equals(elementName) == false) goto L16;
        String fromType = parser.getAttributeValue(null, "from");     // Catch: Throwable -> L11
        String toType = parser.getAttributeValue(null, "to");     // Catch: Throwable -> L11
        validateUserTypeIsProfile(fromType, builders);     // Catch: Throwable -> L11
        validateUserTypeIsProfile(toType, builders);     // Catch: Throwable -> L11
        int maxVersionToConvert = Integer.parseInt(parser.getAttributeValue(null, "whenVersionLeq"));     // Catch: Throwable -> L11 Throwable -> L11 NumberFormatException -> L13
        UserTypeUpgrade userTypeUpgrade = new UserTypeUpgrade(fromType, toType, maxVersionToConvert);     // Catch: Throwable -> L11 Throwable -> L11
        userUpgrades.add(userTypeUpgrade);     // Catch: Throwable -> L11 Throwable -> L11
    L17:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L11 Throwable -> L11
    L13:
        e = move-exception;
        Slog.e(LOG_TAG, "Cannot parse value of whenVersionLeq in " + parser.getPositionDescription(), e);     // Catch: Throwable -> L11 Throwable -> L11
        throw e;     // Catch: Throwable -> L11 Throwable -> L11
    L16:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L11 Throwable -> L11
    L21:
        return userUpgrades;
    L11:
        e = move-exception;
        Slog.w(LOG_TAG, "Cannot read user type configuration file.", e);
        goto L21
    }

    private static void validateUserTypeIsProfile(String userType, ArrayMap<String, UserTypeDetails.Builder> builders) {
        UserTypeDetails.Builder builder = builders.get(userType);
        if (builder != null) goto L5;
        return;
    L5:
        if (builder.getBaseType() != 4096) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Illegal upgrade of user type " + userType + " : Can only upgrade profiles user types");
    }
}
