package com.android.server.pm;

import android.R;
import android.content.pm.PackageManagerInternal;
import android.content.pm.UserInfo;
import android.content.pm.UserProperties;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import com.android.internal.util.Preconditions;
import com.android.server.BundleUtils;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.AndroidPackage;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class UserTypeDetails {
    public static final int UNLIMITED_NUMBER_OF_USERS = -1;
    private final int mAccessibilityString;
    private final int[] mBadgeColors;
    private final int[] mBadgeLabels;
    private final int mBadgeNoBackground;
    private final int mBadgePlain;
    private final int mBaseType;
    private final int[] mDarkThemeBadgeColors;
    private final List<DefaultCrossProfileIntentFilter> mDefaultCrossProfileIntentFilters;
    private final Bundle mDefaultRestrictions;
    private final Bundle mDefaultSecureSettings;
    private final Bundle mDefaultSystemSettings;
    private final int mDefaultUserInfoPropertyFlags;
    private final UserProperties mDefaultUserProperties;
    private final boolean mEnabled;
    private final int mIconBadge;
    private final int[] mLabels;
    private final int mMaxAllowed;
    private final int mMaxAllowedPerParent;
    private final String mName;
    private final boolean mProfileParentRequired;
    private final int mStatusBarIcon;

    public static final class Builder {
        private int mAccessibilityString;
        private int[] mBadgeColors;
        private int[] mBadgeLabels;
        private int mBadgeNoBackground;
        private int mBadgePlain;
        private int mBaseType;
        private int[] mDarkThemeBadgeColors;
        private List<DefaultCrossProfileIntentFilter> mDefaultCrossProfileIntentFilters;
        private Bundle mDefaultRestrictions;
        private Bundle mDefaultSecureSettings;
        private Bundle mDefaultSystemSettings;
        private int mDefaultUserInfoPropertyFlags;
        private UserProperties mDefaultUserProperties;
        private int mEnabled;
        private int mIconBadge;
        private int[] mLabels;
        private int mMaxAllowed;
        private int mMaxAllowedPerParent;
        private String mName;
        private boolean mProfileParentRequired;
        private int mStatusBarIcon;

        public Builder() {
            this.mMaxAllowed = -1;
            this.mMaxAllowedPerParent = -1;
            this.mDefaultUserInfoPropertyFlags = 0;
            this.mDefaultRestrictions = null;
            this.mDefaultSystemSettings = null;
            this.mDefaultSecureSettings = null;
            this.mDefaultCrossProfileIntentFilters = null;
            this.mEnabled = 1;
            this.mLabels = null;
            this.mBadgeLabels = null;
            this.mBadgeColors = null;
            this.mDarkThemeBadgeColors = null;
            this.mProfileParentRequired = false;
            this.mIconBadge = 0;
            this.mBadgePlain = 0;
            this.mBadgeNoBackground = 0;
            this.mStatusBarIcon = 0;
            this.mAccessibilityString = 0;
            this.mDefaultUserProperties = null;
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        public Builder setEnabled(int enabled) {
            this.mEnabled = enabled;
            return this;
        }

        public Builder setMaxAllowed(int maxAllowed) {
            this.mMaxAllowed = maxAllowed;
            return this;
        }

        public Builder setMaxAllowedPerParent(int maxAllowedPerParent) {
            this.mMaxAllowedPerParent = maxAllowedPerParent;
            return this;
        }

        public Builder setBaseType(int baseType) {
            this.mBaseType = baseType;
            return this;
        }

        public Builder setDefaultUserInfoPropertyFlags(int flags) {
            this.mDefaultUserInfoPropertyFlags = flags;
            return this;
        }

        public Builder setBadgeLabels(int... badgeLabels) {
            this.mBadgeLabels = badgeLabels;
            return this;
        }

        public Builder setBadgeColors(int... badgeColors) {
            this.mBadgeColors = badgeColors;
            return this;
        }

        public Builder setDarkThemeBadgeColors(int... darkThemeBadgeColors) {
            this.mDarkThemeBadgeColors = darkThemeBadgeColors;
            return this;
        }

        public Builder setProfileParentRequired(boolean profileParentRequired) {
            this.mProfileParentRequired = profileParentRequired;
            return this;
        }

        public Builder setIconBadge(int badgeIcon) {
            this.mIconBadge = badgeIcon;
            return this;
        }

        public Builder setBadgePlain(int badgePlain) {
            this.mBadgePlain = badgePlain;
            return this;
        }

        public Builder setBadgeNoBackground(int badgeNoBackground) {
            this.mBadgeNoBackground = badgeNoBackground;
            return this;
        }

        public Builder setStatusBarIcon(int statusBarIcon) {
            this.mStatusBarIcon = statusBarIcon;
            return this;
        }

        public Builder setLabels(int... labels) {
            this.mLabels = labels;
            return this;
        }

        public Builder setDefaultRestrictions(Bundle restrictions) {
            this.mDefaultRestrictions = restrictions;
            return this;
        }

        public Builder setDefaultSystemSettings(Bundle settings) {
            this.mDefaultSystemSettings = settings;
            return this;
        }

        public Builder setDefaultSecureSettings(Bundle settings) {
            this.mDefaultSecureSettings = settings;
            return this;
        }

        public Builder setDefaultCrossProfileIntentFilters(List<DefaultCrossProfileIntentFilter> intentFilters) {
            this.mDefaultCrossProfileIntentFilters = intentFilters;
            return this;
        }

        public Builder setAccessibilityString(int accessibilityString) {
            this.mAccessibilityString = accessibilityString;
            return this;
        }

        public Builder setDefaultUserProperties(UserProperties.Builder userPropertiesBuilder) {
            this.mDefaultUserProperties = userPropertiesBuilder.build();
            return this;
        }

        public UserProperties getDefaultUserProperties() {
            if (this.mDefaultUserProperties != null) goto L6;
            this.mDefaultUserProperties = new UserProperties.Builder().build();
        L6:
            return this.mDefaultUserProperties;
        }

        int getBaseType() {
            return this.mBaseType;
        }

        public UserTypeDetails createUserTypeDetails() {
            if (this.mName == null) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkArgument(r1, "Cannot create a UserTypeDetails with no name.");
            Preconditions.checkArgument(hasValidBaseType(), "UserTypeDetails " + this.mName + " has invalid baseType: " + this.mBaseType);
            Preconditions.checkArgument(hasValidPropertyFlags(), "UserTypeDetails " + this.mName + " has invalid flags: " + Integer.toHexString(this.mDefaultUserInfoPropertyFlags));
            checkSystemAndMainUserPreconditions();
            if (hasBadge() == false) goto L22;
            if (this.mBadgeLabels != null) goto L11;
        L13:
            boolean r2 = false;
        L14:
            Preconditions.checkArgument(r2, "UserTypeDetails " + this.mName + " has badge but no badgeLabels.");
            if (this.mBadgeColors != null) goto L17;
        L19:
            boolean r3 = false;
        L20:
            Preconditions.checkArgument(r3, "UserTypeDetails " + this.mName + " has badge but no badgeColors.");
            goto L22
        L17:
            if (this.mBadgeColors.length == 0) goto L19;
            r3 = true;
            goto L20
        L11:
            if (this.mBadgeLabels.length == 0) goto L13;
            r2 = true;
        L22:
            if (isProfile() == false) goto L24;
        L31:
            String r7 = this.mName;
            if (this.mEnabled == 0) goto L34;
            boolean r8 = true;
        L35:
            int r9 = this.mMaxAllowed;
            int r10 = this.mBaseType;
            int r11 = this.mDefaultUserInfoPropertyFlags;
            int[] r12 = this.mLabels;
            int r13 = this.mMaxAllowedPerParent;
            boolean r14 = this.mProfileParentRequired;
            int r15 = this.mIconBadge;
            int r4 = this.mBadgePlain;
            int r5 = this.mBadgeNoBackground;
            int r6 = this.mStatusBarIcon;
            int[] r16 = this.mBadgeLabels;
            int[] r17 = this.mBadgeColors;
            if (this.mDarkThemeBadgeColors != null) goto L39;
            int[] r18 = this.mBadgeColors;
        L41:
            return new UserTypeDetails(r7, r8, r9, r10, r11, r12, r13, r14, r15, r4, r5, r6, r16, r17, r18, this.mDefaultRestrictions, this.mDefaultSystemSettings, this.mDefaultSecureSettings, this.mDefaultCrossProfileIntentFilters, this.mAccessibilityString, getDefaultUserProperties(), null);
        L39:
            r18 = this.mDarkThemeBadgeColors;
            goto L41
        L34:
            r8 = false;
            goto L35
        L24:
            if (this.mDefaultCrossProfileIntentFilters != null) goto L26;
        L29:
            boolean r19 = true;
        L30:
            Preconditions.checkArgument(r19, "UserTypeDetails %s has a non empty defaultCrossProfileIntentFilters", new Object[]{this.mName});
            Preconditions.checkArgument(!this.mProfileParentRequired, "UserTypeDetails %s requires a parent but isn't a profile", new Object[]{this.mName});
            goto L31
        L26:
            if (this.mDefaultCrossProfileIntentFilters.isEmpty() == true) goto L29;
            r19 = false;
            goto L30
        L5:
            r1 = false;
            goto L6
        }

        private boolean hasBadge() {
            if (this.mIconBadge == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean isProfile() {
            if ((this.mBaseType & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean hasValidBaseType() {
            if (this.mBaseType != 1024) goto L5;
        L12:
            return true;
        L5:
            if (this.mBaseType == 4096) goto L12;
            if (this.mBaseType == 2048) goto L12;
            if (this.mBaseType == 3072) goto L12;
            return false;
        }

        private boolean hasValidPropertyFlags() {
            if ((this.mDefaultUserInfoPropertyFlags & 7312) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        private void checkSystemAndMainUserPreconditions() {
            boolean r1 = false;
            if ((this.mBaseType & 2048) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((this.mDefaultUserInfoPropertyFlags & 1) == 0) goto L9;
            boolean r3 = true;
        L10:
            if (r0 != r3) goto L12;
            boolean r2 = true;
        L13:
            Preconditions.checkArgument(r2, "UserTypeDetails " + this.mName + " cannot be SYSTEM xor PRIMARY.");
            if ((this.mDefaultUserInfoPropertyFlags & 16384) != 0) goto L16;
        L17:
            r1 = true;
        L18:
            Preconditions.checkArgument(r1, "UserTypeDetails " + this.mName + " must not sanction more than one MainUser.");
            return;
        L16:
            if (this.mMaxAllowed != 1) goto L18;
        L12:
            r2 = false;
            goto L13
        L9:
            r3 = false;
            goto L10
        L5:
            r0 = false;
            goto L7
        }
    }

    /* synthetic */ UserTypeDetails(String r1, boolean r2, int r3, int r4, int r5, int[] r6, int r7, boolean r8, int r9, int r10, int r11, int r12, int[] r13, int[] r14, int[] r15, Bundle r16, Bundle r17, Bundle r18, List r19, int r20, UserProperties r21, UserTypeDetailsIA r22) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    private UserTypeDetails(String name, boolean enabled, int maxAllowed, int baseType, int defaultUserInfoPropertyFlags, int[] labels, int maxAllowedPerParent, boolean profileParentRequired, int iconBadge, int badgePlain, int badgeNoBackground, int statusBarIcon, int[] badgeLabels, int[] badgeColors, int[] darkThemeBadgeColors, Bundle defaultRestrictions, Bundle defaultSystemSettings, Bundle defaultSecureSettings, List<DefaultCrossProfileIntentFilter> defaultCrossProfileIntentFilters, int accessibilityString, UserProperties defaultUserProperties) {
        this.mName = name;
        this.mEnabled = enabled;
        this.mMaxAllowed = maxAllowed;
        this.mMaxAllowedPerParent = maxAllowedPerParent;
        this.mBaseType = baseType;
        this.mDefaultUserInfoPropertyFlags = defaultUserInfoPropertyFlags;
        this.mDefaultRestrictions = defaultRestrictions;
        this.mDefaultSystemSettings = defaultSystemSettings;
        this.mDefaultSecureSettings = defaultSecureSettings;
        this.mDefaultCrossProfileIntentFilters = defaultCrossProfileIntentFilters;
        this.mProfileParentRequired = profileParentRequired;
        this.mIconBadge = iconBadge;
        this.mBadgePlain = badgePlain;
        this.mBadgeNoBackground = badgeNoBackground;
        this.mStatusBarIcon = statusBarIcon;
        this.mLabels = labels;
        this.mBadgeLabels = badgeLabels;
        this.mBadgeColors = badgeColors;
        this.mDarkThemeBadgeColors = darkThemeBadgeColors;
        this.mAccessibilityString = accessibilityString;
        this.mDefaultUserProperties = defaultUserProperties;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public int getMaxAllowed() {
        return this.mMaxAllowed;
    }

    public int getMaxAllowedPerParent() {
        return this.mMaxAllowedPerParent;
    }

    public int getDefaultUserInfoFlags() {
        return this.mDefaultUserInfoPropertyFlags | this.mBaseType;
    }

    public boolean isProfileParentRequired() {
        return this.mProfileParentRequired;
    }

    public int getLabel(int badgeIndex) {
        if (this.mLabels != null) goto L5;
        return 0;
    L5:
        if (this.mLabels.length == 0) goto L12;
        if (badgeIndex >= 0) goto L9;
        return 0;
    L9:
        return this.mLabels[Math.min(badgeIndex, this.mLabels.length - 1)];
    L12:
        return 0;
    }

    public boolean hasBadge() {
        if (this.mIconBadge == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getIconBadge() {
        return this.mIconBadge;
    }

    public int getBadgePlain() {
        return this.mBadgePlain;
    }

    public int getBadgeNoBackground() {
        return this.mBadgeNoBackground;
    }

    public int getStatusBarIcon() {
        return this.mStatusBarIcon;
    }

    public int getBadgeLabel(int badgeIndex) {
        if (this.mBadgeLabels != null) goto L5;
        return 0;
    L5:
        if (this.mBadgeLabels.length == 0) goto L12;
        if (badgeIndex >= 0) goto L9;
        return 0;
    L9:
        return this.mBadgeLabels[Math.min(badgeIndex, this.mBadgeLabels.length - 1)];
    L12:
        return 0;
    }

    public int getBadgeColor(int badgeIndex) {
        if (this.mBadgeColors != null) goto L5;
        return 0;
    L5:
        if (this.mBadgeColors.length == 0) goto L12;
        if (badgeIndex >= 0) goto L9;
        return 0;
    L9:
        return this.mBadgeColors[Math.min(badgeIndex, this.mBadgeColors.length - 1)];
    L12:
        return 0;
    }

    public int getDarkThemeBadgeColor(int badgeIndex) {
        if (this.mDarkThemeBadgeColors == null) goto L11;
        if (this.mDarkThemeBadgeColors.length == 0) goto L11;
        if (badgeIndex < 0) goto L11;
        return this.mDarkThemeBadgeColors[Math.min(badgeIndex, this.mDarkThemeBadgeColors.length - 1)];
    L11:
        return getBadgeColor(badgeIndex);
    }

    public UserProperties getDefaultUserPropertiesReference() {
        return this.mDefaultUserProperties;
    }

    public int getAccessibilityString() {
        return this.mAccessibilityString;
    }

    public boolean isProfile() {
        if ((this.mBaseType & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFull() {
        if ((this.mBaseType & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSystem() {
        if ((this.mBaseType & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    Bundle getDefaultRestrictions() {
        return BundleUtils.clone(this.mDefaultRestrictions);
    }

    public void addDefaultRestrictionsTo(Bundle currentRestrictions) {
        UserRestrictionsUtils.merge(currentRestrictions, this.mDefaultRestrictions);
    }

    Bundle getDefaultSystemSettings() {
        return BundleUtils.clone(this.mDefaultSystemSettings);
    }

    Bundle getDefaultSecureSettings() {
        return BundleUtils.clone(this.mDefaultSecureSettings);
    }

    List<DefaultCrossProfileIntentFilter> getDefaultCrossProfileIntentFilters() {
        if (this.mDefaultCrossProfileIntentFilters == null) goto L6;
        return new ArrayList(getVerifiedDefaultCrossProfileIntentFilters());
    L6:
        return Collections.emptyList();
    }

    private List<DefaultCrossProfileIntentFilter> getVerifiedDefaultCrossProfileIntentFilters() {
        if (getName().equals("android.os.usertype.profile.MANAGED") == false) goto L5;
        AndroidPackage androidPackage = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getPackage("com.android.cts.verifier");
        if (androidPackage == null) goto L17;
        if (androidPackage.isEnabled() == false) goto L17;
        DefaultCrossProfileIntentFilter extra = DefaultCrossProfileIntentFiltersUtils.CTS_VERIFIER_REQUIRE;
        if (this.mDefaultCrossProfileIntentFilters.contains(extra) == true) goto L13;
        this.mDefaultCrossProfileIntentFilters.add(extra);
    L13:
        DefaultCrossProfileIntentFilter extra2 = DefaultCrossProfileIntentFiltersUtils.CTS_VERIFIER_REQUIRE_VIEW;
        if (this.mDefaultCrossProfileIntentFilters.contains(extra2) == true) goto L17;
        this.mDefaultCrossProfileIntentFilters.add(extra2);
    L17:
        return this.mDefaultCrossProfileIntentFilters;
    L5:
        return this.mDefaultCrossProfileIntentFilters;
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("mName: ");
        pw.println(this.mName);
        pw.print(prefix);
        pw.print("mBaseType: ");
        pw.println(UserInfo.flagsToString(this.mBaseType));
        pw.print(prefix);
        pw.print("mEnabled: ");
        pw.println(this.mEnabled);
        pw.print(prefix);
        pw.print("mMaxAllowed: ");
        pw.println(this.mMaxAllowed);
        pw.print(prefix);
        pw.print("mMaxAllowedPerParent: ");
        pw.println(this.mMaxAllowedPerParent);
        pw.print(prefix);
        pw.print("mDefaultUserInfoFlags: ");
        pw.println(UserInfo.flagsToString(this.mDefaultUserInfoPropertyFlags));
        this.mDefaultUserProperties.println(pw, prefix);
        String restrictionsPrefix = prefix + "    ";
        if (isSystem() == false) goto L16;
        pw.print(prefix);
        pw.println("config_defaultFirstUserRestrictions: ");
        Bundle restrictions = new Bundle();     // Catch: Resources.NotFoundException -> L10
        String[] defaultFirstUserRestrictions = Resources.getSystem().getStringArray(R.array.config_displayCutoutApproximationRectArray);     // Catch: Resources.NotFoundException -> L10
        int r3 = defaultFirstUserRestrictions.length;     // Catch: Resources.NotFoundException -> L10
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L13;
        String userRestriction = defaultFirstUserRestrictions[r4];     // Catch: Resources.NotFoundException -> L10
        if (UserRestrictionsUtils.isValidRestriction(userRestriction) == false) goto L12;
        restrictions.putBoolean(userRestriction, true);     // Catch: Resources.NotFoundException -> L10
    L12:
        r4 = r4 + 1;     // Catch: Resources.NotFoundException -> L10
        goto L6
    L13:
        UserRestrictionsUtils.dumpRestrictions(pw, restrictionsPrefix, restrictions);     // Catch: Resources.NotFoundException -> L10
    L17:
        pw.print(prefix);
        pw.print("mProfileParentRequired: ");
        pw.println(this.mProfileParentRequired);
        pw.print(prefix);
        pw.print("mIconBadge: ");
        pw.println(this.mIconBadge);
        pw.print(prefix);
        pw.print("mBadgePlain: ");
        pw.println(this.mBadgePlain);
        pw.print(prefix);
        pw.print("mBadgeNoBackground: ");
        pw.println(this.mBadgeNoBackground);
        pw.print(prefix);
        pw.print("mStatusBarIcon: ");
        pw.println(this.mStatusBarIcon);
        pw.print(prefix);
        pw.print("mBadgeLabels.length: ");
        Object r2 = "0(null)";
        if (this.mBadgeLabels == null) goto L20;
        Integer r1 = Integer.valueOf(this.mBadgeLabels.length);
    L21:
        pw.println(r1);
        pw.print(prefix);
        pw.print("mBadgeColors.length: ");
        if (this.mBadgeColors == null) goto L24;
        Integer r5 = Integer.valueOf(this.mBadgeColors.length);
    L25:
        pw.println(r5);
        pw.print(prefix);
        pw.print("mDarkThemeBadgeColors.length: ");
        if (this.mDarkThemeBadgeColors == null) goto L28;
        Integer r6 = Integer.valueOf(this.mDarkThemeBadgeColors.length);
    L29:
        pw.println(r6);
        pw.print(prefix);
        pw.print("mLabels.length: ");
        if (this.mLabels == null) goto L32;
        r2 = Integer.valueOf(this.mLabels.length);
    L32:
        pw.println(r2);
        return;
    L28:
        r6 = "0(null)";
        goto L29
    L24:
        r5 = "0(null)";
        goto L25
    L20:
        r1 = "0(null)";
    L15:
        pw.print(restrictionsPrefix);
        pw.println("none - resource not found");
        goto L17
    L16:
        pw.print(prefix);
        pw.println("mDefaultRestrictions: ");
        UserRestrictionsUtils.dumpRestrictions(pw, restrictionsPrefix, this.mDefaultRestrictions);
        goto L17
    }

    public boolean isManagedProfile() {
        return UserManager.isUserTypeManagedProfile(this.mName);
    }

    public boolean isCommunalProfile() {
        return UserManager.isUserTypeCommunalProfile(this.mName);
    }

    public boolean isPrivateProfile() {
        return UserManager.isUserTypePrivateProfile(this.mName);
    }
}
