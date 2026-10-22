package com.android.server.pm;

import android.R;
import android.content.pm.LauncherUserInfo;
import android.content.pm.UserInfo;
import android.content.pm.UserProperties;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.UserManager;
import android.util.DebugUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UserManagerInternal {
    public static final int OWNER_TYPE_DEVICE_OWNER = 0;
    public static final int OWNER_TYPE_NO_OWNER = 3;
    public static final int OWNER_TYPE_PROFILE_OWNER = 1;
    public static final int OWNER_TYPE_PROFILE_OWNER_OF_ORGANIZATION_OWNED_DEVICE = 2;
    private static final String PREFIX_USER_ASSIGNMENT_RESULT = "USER_ASSIGNMENT_RESULT_";
    private static final String PREFIX_USER_START_MODE = "USER_START_MODE_";
    public static final int USER_ASSIGNMENT_RESULT_FAILURE = -1;
    public static final int USER_ASSIGNMENT_RESULT_SUCCESS_ALREADY_VISIBLE = 3;
    public static final int USER_ASSIGNMENT_RESULT_SUCCESS_INVISIBLE = 2;
    public static final int USER_ASSIGNMENT_RESULT_SUCCESS_VISIBLE = 1;
    public static final int USER_START_MODE_BACKGROUND = 2;
    public static final int USER_START_MODE_BACKGROUND_VISIBLE = 3;
    public static final int USER_START_MODE_FOREGROUND = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface OwnerType {
    }

    public @interface UserAssignmentResult {
    }

    public interface UserLifecycleListener {
        default void onUserCreated(UserInfo user, Object token) {
        }

        default void onUserRemoved(UserInfo user) {
        }
    }

    public interface UserRestrictionsListener {
        void onUserRestrictionsChanged(int r1, Bundle r2, Bundle r3);
    }

    public @interface UserStartMode {
    }

    public interface UserVisibilityListener {
        void onUserVisibilityChanged(int r1, boolean r2);
    }

    public abstract void addUserLifecycleListener(UserLifecycleListener r1);

    public abstract void addUserRestrictionsListener(UserRestrictionsListener r1);

    public abstract void addUserVisibilityListener(UserVisibilityListener r1);

    public abstract int assignUserToDisplayOnStart(int r1, int r2, int r3, int r4);

    public abstract boolean assignUserToExtraDisplay(int r1, int r2);

    public abstract UserInfo createUserEvenWhenDisallowed(String r1, String r2, int r3, String[] r4, Object r5) throws UserManager.CheckedUserOperationException;

    public abstract boolean exists(int r1);

    public abstract int getBootUser(boolean r1) throws UserManager.CheckedUserOperationException;

    public abstract int getCommunalProfileId();

    public abstract int[] getDisplaysAssignedToUser(int r1);

    public abstract LauncherUserInfo getLauncherUserInfo(int r1);

    public abstract int getMainDisplayAssignedToUser(int r1);

    public abstract int getMainUserId();

    public abstract int[] getProfileIds(int r1, boolean r2);

    public abstract int[] getProfileIdsExcludingHidden(int r1, boolean r2);

    public abstract int getProfileParentId(int r1);

    public abstract int getSupervisingProfileId();

    public abstract int getUserAssignedToDisplay(int r1);

    public abstract int[] getUserIds();

    public abstract UserInfo getUserInfo(int r1);

    public abstract UserInfo[] getUserInfos();

    public abstract UserProperties getUserProperties(int r1);

    public abstract boolean getUserRestriction(int r1, String r2);

    public abstract int[] getUserTypesForStatsd(int[] r1);

    public abstract List<UserInfo> getUsers(boolean r1);

    public abstract List<UserInfo> getUsers(boolean r1, boolean r2, boolean r3);

    public abstract boolean hasUserRestriction(String r1, int r2);

    @Deprecated
    public abstract boolean isDeviceManaged();

    public abstract boolean isProfileAccessible(int r1, int r2, String r3, boolean r4);

    public abstract boolean isSettingRestrictedForUser(String r1, int r2, String r3, int r4);

    public abstract boolean isUserInitialized(int r1);

    @Deprecated
    public abstract boolean isUserManaged(int r1);

    public abstract boolean isUserRunning(int r1);

    public abstract boolean isUserUnlocked(int r1);

    public abstract boolean isUserUnlockingOrUnlocked(int r1);

    public abstract boolean isUserVisible(int r1);

    public abstract boolean isUserVisible(int r1, int r2);

    public abstract boolean isVisibleBackgroundFullUser(int r1);

    public abstract void onEphemeralUserStop(int r1);

    public abstract void onSystemUserVisibilityChanged(boolean r1);

    public abstract void removeAllUsers();

    public abstract boolean removeUserEvenWhenDisallowed(int r1);

    public abstract void removeUserLifecycleListener(UserLifecycleListener r1);

    public abstract void removeUserRestrictionsListener(UserRestrictionsListener r1);

    public abstract void removeUserState(int r1);

    public abstract void removeUserVisibilityListener(UserVisibilityListener r1);

    public abstract void setDefaultCrossProfileIntentFilters(int r1, int r2);

    @Deprecated
    public abstract void setDeviceManaged(boolean r1);

    public abstract void setDevicePolicyUserRestrictions(int r1, Bundle r2, RestrictionsSet r3, boolean r4);

    public abstract void setForceEphemeralUsers(boolean r1);

    public abstract void setUserIcon(int r1, Bitmap r2);

    @Deprecated
    public abstract void setUserManaged(int r1, boolean r2);

    public abstract void setUserRestriction(int r1, String r2, boolean r3);

    public abstract void setUserState(int r1, int r2);

    public abstract boolean shouldIgnorePrepareStorageErrors(int r1);

    public abstract void unassignUserFromDisplayOnStop(int r1);

    public abstract boolean unassignUserFromExtraDisplay(int r1, int r2);

    public UserManagerInternal() {
    }

    public static String userAssignmentResultToString(int result) {
        return DebugUtils.constantToString(UserManagerInternal.class, PREFIX_USER_ASSIGNMENT_RESULT, result);
    }

    public static String userStartModeToString(int mode) {
        return DebugUtils.constantToString(UserManagerInternal.class, PREFIX_USER_START_MODE, mode);
    }

    public static boolean shouldShowNotificationForBackgroundUserSounds() {
        if (Resources.getSystem().getBoolean(R.bool.config_skipScreenOffTransition) == true) goto L5;
    L7:
        return false;
    L5:
        if (UserManager.supportsMultipleUsers() == false) goto L7;
        return true;
    }
}
