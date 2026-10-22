package com.android.server.pm;

import android.os.Handler;
import android.os.UserManager;
import android.util.DebugUtils;
import android.util.Dumpable;
import android.util.EventLog;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.Log;
import android.util.SparseIntArray;
import com.android.internal.util.Preconditions;
import com.android.server.am.EventLogTags;
import com.android.server.am.ProcessList;
import com.android.server.utils.Slogf;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class UserVisibilityMediator implements Dumpable {
    public static final int ALWAYS_VISIBLE_PROFILE_GROUP_ID = -1;
    private static final boolean DBG = false;
    static final int INITIAL_CURRENT_USER_ID = 0;
    private static final String PREFIX_SECONDARY_DISPLAY_MAPPING = "SECONDARY_DISPLAY_MAPPING_";
    public static final int SECONDARY_DISPLAY_MAPPING_FAILED = -1;
    public static final int SECONDARY_DISPLAY_MAPPING_NEEDED = 1;
    public static final int SECONDARY_DISPLAY_MAPPING_NOT_NEEDED = 2;
    private static final String TAG = null;
    private static final boolean VERBOSE = false;
    private int mCurrentUserId;
    private final SparseIntArray mExtraDisplaysAssignedToUsers;
    private final Handler mHandler;
    final CopyOnWriteArrayList<UserManagerInternal.UserVisibilityListener> mListeners;
    private final Object mLock;
    private final List<Integer> mStartedInvisibleProfileUserIds;
    private final SparseIntArray mStartedVisibleProfileGroupIds;
    private final SparseIntArray mUsersAssignedToDisplayOnStart;
    private final boolean mVisibleBackgroundUserOnDefaultDisplayEnabled;
    private final boolean mVisibleBackgroundUsersEnabled;

    public @interface SecondaryDisplayMappingStatus {
    }

    public static /* synthetic */ void $r8$lambda$RwzqKlQYDyxdAxTJhHVafFhaCRE(UserManagerInternal.UserVisibilityListener r0, int r1, boolean r2) {
        lambda$dispatchVisibilityChanged$0(r0, r1, r2);
    }

    static {
        TAG = UserVisibilityMediator.class.getSimpleName();
        DBG = Log.isLoggable(TAG, 3);
    }

    UserVisibilityMediator(Handler handler) {
        this(UserManager.isVisibleBackgroundUsersEnabled(), UserManager.isVisibleBackgroundUsersOnDefaultDisplayEnabled(), handler);
    }

    UserVisibilityMediator(boolean visibleBackgroundUsersOnDisplaysEnabled, boolean visibleBackgroundUserOnDefaultDisplayEnabled, Handler handler) {
        this.mLock = new Object();
        this.mCurrentUserId = 0;
        this.mStartedVisibleProfileGroupIds = new SparseIntArray();
        this.mListeners = new CopyOnWriteArrayList();
        this.mVisibleBackgroundUsersEnabled = visibleBackgroundUsersOnDisplaysEnabled;
        if (visibleBackgroundUserOnDefaultDisplayEnabled == false) goto L8;
        if (visibleBackgroundUsersOnDisplaysEnabled == true) goto L8;
        throw new IllegalArgumentException("Cannot have visibleBackgroundUserOnDefaultDisplayEnabled without visibleBackgroundUsersOnDisplaysEnabled");
    L8:
        this.mVisibleBackgroundUserOnDefaultDisplayEnabled = visibleBackgroundUserOnDefaultDisplayEnabled;
        ArrayList r2 = null;
        if (this.mVisibleBackgroundUsersEnabled == false) goto L11;
        this.mUsersAssignedToDisplayOnStart = new SparseIntArray();
        this.mExtraDisplaysAssignedToUsers = new SparseIntArray();
    L13:
        if (DBG == false) goto L15;
        r2 = new ArrayList(4);
    L15:
        this.mStartedInvisibleProfileUserIds = r2;
        this.mHandler = handler;
        this.mStartedVisibleProfileGroupIds.put(0, 0);
        if (DBG == false) goto L19;
        Slogf.i(TAG, "UserVisibilityMediator created with DBG on");
        return;
    L19:
        return;
    L11:
        this.mUsersAssignedToDisplayOnStart = null;
        this.mExtraDisplaysAssignedToUsers = null;
        goto L13
    }

    public int assignUserToDisplayOnStart(int userId, int unResolvedProfileGroupId, int userStartMode, int displayId, boolean isAlwaysVisible) {
        Preconditions.checkArgument(!isSpecialUserId(userId), "user id cannot be generic: %d", new Object[]{Integer.valueOf(userId)});
        validateUserStartMode(userStartMode);
        int profileGroupId = resolveProfileGroupId(userId, unResolvedProfileGroupId, isAlwaysVisible);
        if (DBG == false) goto L5;
        Slogf.d(TAG, "assignUserToDisplayOnStart(%d, %d, %s, %d): actualProfileGroupId=%d", new Object[]{Integer.valueOf(userId), Integer.valueOf(unResolvedProfileGroupId), UserManagerInternal.userStartModeToString(userStartMode), Integer.valueOf(displayId), Integer.valueOf(profileGroupId)});
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        int result = getUserVisibilityOnStartLocked(userId, profileGroupId, userStartMode, displayId);     // Catch: Throwable -> L10
        if (DBG == false) goto L13;
        Slogf.d(TAG, "result of getUserVisibilityOnStartLocked(%s)", new Object[]{UserManagerInternal.userAssignmentResultToString(result)});     // Catch: Throwable -> L10
    L13:
        if (result == (-1)) goto L51;
        if (result == 3) goto L51;
        int mappingResult = canAssignUserToDisplayLocked(userId, profileGroupId, userStartMode, displayId);     // Catch: Throwable -> L10
        if (DBG == false) goto L20;
        Slogf.d(TAG, "mapping result: %s", new Object[]{secondaryDisplayMappingStatusToString(mappingResult)});     // Catch: Throwable -> L10
    L20:
        if (mappingResult != (-1)) goto L23;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return -1;
    L23:
        IntArray visibleUsersBefore = getVisibleUsers();     // Catch: Throwable -> L10
        switch(userStartMode) {
            case 1: goto L31;
            case 2: goto L27;
            case 3: goto L33;
            default: goto L25;
        };     // Catch: Throwable -> L10
    L25:
        Slogf.wtf(TAG, "invalid userStartMode passed to assignUserToDisplayOnStart: %d", new Object[]{Integer.valueOf(userStartMode)});     // Catch: Throwable -> L10
    L36:
        switch(mappingResult) {
            case 1: goto L42;
            case 2: goto L39;
            default: goto L37;
        };     // Catch: Throwable -> L10
    L37:
        Slogf.wtf(TAG, "invalid resut from canAssignUserToDisplayLocked: %d", new Object[]{Integer.valueOf(mappingResult)});     // Catch: Throwable -> L10
    L45:
        IntArray visibleUsersAfter = getVisibleUsers();     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        dispatchVisibilityChanged(visibleUsersBefore, visibleUsersAfter);
        if (DBG == false) goto L50;
        Slogf.d(TAG, "returning %s", new Object[]{UserManagerInternal.userAssignmentResultToString(result)});
    L50:
        return result;
    L39:
        if (DBG == false) goto L45;
        Slogf.d(TAG, "don't need to update mUsersOnSecondaryDisplays");     // Catch: Throwable -> L10
        goto L45
    L42:
        if (DBG == false) goto L44;
        Slogf.d(TAG, "adding user / display mapping (%d -> %d)", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});     // Catch: Throwable -> L10
    L44:
        this.mUsersAssignedToDisplayOnStart.put(userId, displayId);     // Catch: Throwable -> L10
        goto L45
    L31:
        this.mCurrentUserId = userId;     // Catch: Throwable -> L10
        goto L33
    L27:
        if (this.mStartedInvisibleProfileUserIds == null) goto L36;
        if (isProfile(userId, profileGroupId) == false) goto L36;
        Slogf.d(TAG, "adding user %d to list of invisible profiles", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L10
        this.mStartedInvisibleProfileUserIds.add(Integer.valueOf(userId));     // Catch: Throwable -> L10
    L33:
        if (DBG == false) goto L35;
        Slogf.d(TAG, "adding visible user / profile group id mapping (%d -> %d)", new Object[]{Integer.valueOf(userId), Integer.valueOf(profileGroupId)});     // Catch: Throwable -> L10
    L35:
        this.mStartedVisibleProfileGroupIds.put(userId, profileGroupId);     // Catch: Throwable -> L10
    L51:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return result;
    L10:
        th = move-exception;
        throw th;
    }

    private int resolveProfileGroupId(int userId, int unResolvedProfileGroupId, boolean isAlwaysVisible) {
        if (isAlwaysVisible == false) goto L6;
        return -1;
    L6:
        if (unResolvedProfileGroupId != (-10000)) goto L9;
        return userId;
    L9:
        return unResolvedProfileGroupId;
    }

    private int getUserVisibilityOnStartLocked(int userId, int profileGroupId, int userStartMode, int displayId) {
        if (userStartMode != 2) goto L7;
        if (displayId == 0) goto L7;
        Slogf.wtf(TAG, "cannot start user (%d) as BACKGROUND_USER on secondary display (%d) (it should be BACKGROUND_USER_VISIBLE", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});
        return -1;
    L7:
        boolean foreground = false;
        if (userStartMode != 3) goto L10;
        boolean visibleBackground = true;
    L11:
        if (displayId != 0) goto L25;
        if (visibleBackground == false) goto L25;
        if (this.mVisibleBackgroundUserOnDefaultDisplayEnabled == false) goto L20;
        if (isCurrentUserLocked(userId) == false) goto L20;
        Slogf.wtf(TAG, "trying to start current user (%d) visible in background on default display", new Object[]{Integer.valueOf(userId)});
        return 3;
    L20:
        if (this.mVisibleBackgroundUserOnDefaultDisplayEnabled == true) goto L25;
        if (isProfile(userId, profileGroupId) == true) goto L25;
        Slogf.wtf(TAG, "cannot start full user (%d) visible on default display", new Object[]{Integer.valueOf(userId)});
        return -1;
    L25:
        if (userStartMode != 1) goto L27;
        foreground = true;
    L27:
        if (displayId == 0) goto L36;
        if (foreground == false) goto L32;
        Slogf.w(TAG, "getUserVisibilityOnStartLocked(%d, %d, %s, %d) failed: cannot start foreground user on secondary display", new Object[]{Integer.valueOf(userId), Integer.valueOf(profileGroupId), UserManagerInternal.userStartModeToString(userStartMode), Integer.valueOf(displayId)});
        return -1;
    L32:
        if (this.mVisibleBackgroundUsersEnabled == true) goto L36;
        Slogf.w(TAG, "getUserVisibilityOnStartLocked(%d, %d, %s, %d) failed: called on device that doesn't support multiple users on multiple displays", new Object[]{Integer.valueOf(userId), Integer.valueOf(profileGroupId), UserManagerInternal.userStartModeToString(userStartMode), Integer.valueOf(displayId)});
        return -1;
    L36:
        if (isProfile(userId, profileGroupId) == false) goto L51;
        if (displayId == 0) goto L40;
        Slogf.w(TAG, "canStartUserLocked(%d, %d, %s, %d) failed: cannot start profile user on secondary display", new Object[]{Integer.valueOf(userId), Integer.valueOf(profileGroupId), UserManagerInternal.userStartModeToString(userStartMode), Integer.valueOf(displayId)});
        return -1;
    L40:
        switch(userStartMode) {
            case 1: goto L48;
            case 2: goto L47;
            case 3: goto L43;
            default: goto L58;
        };
    L47:
        return 2;
    L48:
        Slogf.w(TAG, "startUser(%d, %d, %s, %d) failed: cannot start profile user in foreground", new Object[]{Integer.valueOf(userId), Integer.valueOf(profileGroupId), UserManagerInternal.userStartModeToString(userStartMode), Integer.valueOf(displayId)});
        return -1;
    L58:
        if (foreground == true) goto L66;
        if (displayId != 0) goto L66;
        if (visibleBackground == true) goto L62;
        return 2;
    L62:
        if (this.mVisibleBackgroundUserOnDefaultDisplayEnabled == true) goto L66;
        return 2;
    L66:
        return 1;
    L43:
        if (isParentVisibleOnDisplay(profileGroupId, displayId) == true) goto L46;
        Slogf.w(TAG, "getUserVisibilityOnStartLocked(%d, %d, %s, %d) failed: cannot start profile user visible when its parent is not visible in that display", new Object[]{Integer.valueOf(userId), Integer.valueOf(profileGroupId), UserManagerInternal.userStartModeToString(userStartMode), Integer.valueOf(displayId)});
        return -1;
    L46:
        return 1;
    L51:
        if (this.mUsersAssignedToDisplayOnStart == null) goto L58;
        if (isUserAssignedToDisplayOnStartLocked(userId, displayId) == false) goto L58;
        if (DBG == false) goto L57;
        Slogf.d(TAG, "full user %d is already visible on display %d", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});
    L57:
        return 3;
    L10:
        visibleBackground = false;
        goto L11
    }

    private int canAssignUserToDisplayLocked(int userId, int profileGroupId, int userStartMode, int displayId) {
        if (displayId != 0) goto L25;
        boolean mappingNeeded = false;
        if (this.mVisibleBackgroundUserOnDefaultDisplayEnabled == true) goto L7;
    L14:
        if (mappingNeeded == false) goto L16;
    L20:
        if (mappingNeeded == true) goto L25;
        if (DBG == false) goto L24;
        Slogf.d(TAG, "Ignoring mapping for default display for user %d starting as %s", new Object[]{Integer.valueOf(userId), UserManagerInternal.userStartModeToString(userStartMode)});
    L24:
        return 2;
    L16:
        if (this.mVisibleBackgroundUsersEnabled == false) goto L20;
        if (isProfile(userId, profileGroupId) == false) goto L20;
        mappingNeeded = true;
        goto L20
    L7:
        if (userStartMode != 3) goto L14;
        int userStartedOnDefaultDisplay = getUserStartedOnDisplay(0);
        if (userStartedOnDefaultDisplay == (-10000)) goto L13;
        if (userStartedOnDefaultDisplay == profileGroupId) goto L13;
        Slogf.w(TAG, "canAssignUserToDisplayLocked(): cannot start user %d visible on default display because user %d already did so", new Object[]{Integer.valueOf(userId), Integer.valueOf(userStartedOnDefaultDisplay)});
        return -1;
    L13:
        mappingNeeded = true;
    L25:
        if (userId != 0) goto L28;
        Slogf.w(TAG, "Cannot assign system user to secondary display (%d)", new Object[]{Integer.valueOf(displayId)});
        return -1;
    L28:
        if (displayId != (-1)) goto L32;
        Slogf.w(TAG, "Cannot assign to INVALID_DISPLAY (%d)", new Object[]{Integer.valueOf(displayId)});
        return -1;
    L32:
        if (userId != this.mCurrentUserId) goto L36;
        Slogf.w(TAG, "Cannot assign current user (%d) to other displays", new Object[]{Integer.valueOf(userId)});
        return -1;
    L36:
        if (isProfile(userId, profileGroupId) == false) goto L45;
        if (displayId == 0) goto L41;
        Slogf.w(TAG, "Profile user can only be started in the default display");
        return -1;
    L41:
        if (DBG == false) goto L43;
        Slogf.d(TAG, "Don't need to map profile user %d to default display", new Object[]{Integer.valueOf(userId)});
    L43:
        return 2;
    L45:
        if (this.mUsersAssignedToDisplayOnStart != null) goto L48;
        Slogf.wtf(TAG, "canAssignUserToDisplayLocked(%d, %d, %d, %d) is trying to check mUsersAssignedToDisplayOnStart when it's not set", new Object[]{Integer.valueOf(userId), Integer.valueOf(profileGroupId), Integer.valueOf(userStartMode), Integer.valueOf(displayId)});
        return -1;
    L48:
        int i = 0;
    L50:
        if (i >= this.mUsersAssignedToDisplayOnStart.size()) goto L61;
        int assignedUserId = this.mUsersAssignedToDisplayOnStart.keyAt(i);
        int assignedDisplayId = this.mUsersAssignedToDisplayOnStart.valueAt(i);
        if (DBG == false) goto L54;
        Slogf.d(TAG, "%d: assignedUserId=%d, assignedDisplayId=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(assignedUserId), Integer.valueOf(assignedDisplayId)});
    L54:
        if (displayId == assignedDisplayId) goto L55;
        if (userId == assignedUserId) goto L58;
        i = i + 1;
        goto L50
    L58:
        Slogf.w(TAG, "Cannot assign user %d to display %d because such user is as already assigned to display %d", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId), Integer.valueOf(assignedUserId)});
        return -1;
    L55:
        Slogf.w(TAG, "Cannot assign user %d to display %d because such display is already assigned to user %d", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId), Integer.valueOf(assignedUserId)});
        return -1;
    L61:
        return 1;
    }

    public boolean assignUserToExtraDisplay(int userId, int displayId) {
        if (DBG == false) goto L6;
        Slogf.d(TAG, "assignUserToExtraDisplay(%d, %d)", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});
    L6:
        if (this.mVisibleBackgroundUsersEnabled == true) goto L10;
        Slogf.w(TAG, "assignUserToExtraDisplay(%d, %d): called when not supported", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});
        return false;
    L10:
        if (displayId != (-1)) goto L13;
        Slogf.w(TAG, "assignUserToExtraDisplay(%d, %d): called with INVALID_DISPLAY", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});
        return false;
    L13:
        if (displayId != 0) goto L16;
        Slogf.w(TAG, "assignUserToExtraDisplay(%d, %d): DEFAULT_DISPLAY is automatically assigned to current user", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});
        return false;
    L16:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (isUserVisible(userId) == true) goto L26;
        Slogf.w(TAG, "assignUserToExtraDisplay(%d, %d): failed because user is not visible", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return false;
    L26:
        if (isStartedVisibleProfileLocked(userId) == false) goto L31;
        Slogf.w(TAG, "assignUserToExtraDisplay(%d, %d): failed because user is a profile", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return false;
    L31:
        if (this.mExtraDisplaysAssignedToUsers.get(displayId, ProcessList.INVALID_ADJ) != userId) goto L35;
        Slogf.w(TAG, "assignUserToExtraDisplay(%d, %d): failed because user is already assigned to that display", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return false;
    L35:
        int userAssignedToDisplay = getUserStartedOnDisplay(displayId);     // Catch: Throwable -> L23
        if (userAssignedToDisplay == (-10000)) goto L40;
        Slogf.w(TAG, "assignUserToExtraDisplay(%d, %d): failed because display was assigned to user %d on start", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId), Integer.valueOf(userAssignedToDisplay)});     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return false;
    L40:
        int userAssignedToDisplay2 = this.mExtraDisplaysAssignedToUsers.get(displayId, ProcessList.INVALID_ADJ);     // Catch: Throwable -> L23
        if (userAssignedToDisplay2 == (-10000)) goto L46;
        Slogf.w(TAG, "assignUserToExtraDisplay(%d, %d): failed because user %d was already assigned to extra display", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId), Integer.valueOf(userAssignedToDisplay2)});     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return false;
    L46:
        if (DBG == false) goto L48;
        Slogf.d(TAG, "addding %d -> %d to mExtraDisplaysAssignedToUsers", new Object[]{Integer.valueOf(displayId), Integer.valueOf(userId)});     // Catch: Throwable -> L23
    L48:
        this.mExtraDisplaysAssignedToUsers.put(displayId, userId);     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return true;
    }

    public boolean unassignUserFromExtraDisplay(int userId, int displayId) {
        if (DBG == false) goto L6;
        Slogf.d(TAG, "unassignUserFromExtraDisplay(%d, %d)", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});
    L6:
        if (this.mVisibleBackgroundUsersEnabled == true) goto L9;
        Slogf.w(TAG, "unassignUserFromExtraDisplay(%d, %d): called when not supported", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});
        return false;
    L9:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int assignedUserId = this.mExtraDisplaysAssignedToUsers.get(displayId, ProcessList.INVALID_ADJ);     // Catch: Throwable -> L16
        if (assignedUserId != (-10000)) goto L18;
        Slogf.w(TAG, "unassignUserFromExtraDisplay(%d, %d): not assigned to any user", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return false;
    L18:
        if (assignedUserId == userId) goto L23;
        Slogf.w(TAG, "unassignUserFromExtraDisplay(%d, %d): was assigned to user %d", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId), Integer.valueOf(assignedUserId)});     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return false;
    L23:
        if (DBG == false) goto L25;
        Slogf.d(TAG, "removing %d from map", new Object[]{Integer.valueOf(displayId)});     // Catch: Throwable -> L16
    L25:
        this.mExtraDisplaysAssignedToUsers.delete(displayId);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    public void unassignUserFromDisplayOnStop(int userId) {
        if (DBG == false) goto L5;
        Slogf.d(TAG, "unassignUserFromDisplayOnStop(%d)", new Object[]{Integer.valueOf(userId)});
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        IntArray visibleUsersBefore = getVisibleUsers();     // Catch: Throwable -> L11
        unassignUserFromAllDisplaysOnStopLocked(userId);     // Catch: Throwable -> L11
        IntArray visibleUsersAfter = getVisibleUsers();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        dispatchVisibilityChanged(visibleUsersBefore, visibleUsersAfter);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void unassignUserFromAllDisplaysOnStopLocked(int userId) {
        if (DBG == false) goto L5;
        Slogf.d(TAG, "Removing %d from mStartedVisibleProfileGroupIds (%s)", new Object[]{Integer.valueOf(userId), this.mStartedVisibleProfileGroupIds});
    L5:
        this.mStartedVisibleProfileGroupIds.delete(userId);
        if (this.mStartedInvisibleProfileUserIds == null) goto L9;
        Slogf.d(TAG, "Removing %d from list of invisible profiles", new Object[]{Integer.valueOf(userId)});
        this.mStartedInvisibleProfileUserIds.remove(Integer.valueOf(userId));
    L9:
        if (this.mVisibleBackgroundUsersEnabled == true) goto L12;
        return;
    L12:
        if (DBG == false) goto L14;
        Slogf.d(TAG, "Removing user %d from mUsersOnDisplaysMap (%s)", new Object[]{Integer.valueOf(userId), this.mUsersAssignedToDisplayOnStart});
    L14:
        this.mUsersAssignedToDisplayOnStart.delete(userId);
        int i = this.mExtraDisplaysAssignedToUsers.size() - 1;
    L15:
        if (i < 0) goto L24;
        if (this.mExtraDisplaysAssignedToUsers.valueAt(i) != userId) goto L22;
        if (DBG == false) goto L21;
        Slogf.d(TAG, "Removing display %d from mExtraDisplaysAssignedToUsers (%s)", new Object[]{Integer.valueOf(this.mExtraDisplaysAssignedToUsers.keyAt(i)), this.mExtraDisplaysAssignedToUsers});
    L21:
        this.mExtraDisplaysAssignedToUsers.removeAt(i);
    L22:
        i = i - 1;
        goto L15
    }

    public boolean isUserVisible(int userId) {
        if (isCurrentUserOrRunningProfileOfCurrentUser(userId) == false) goto L7;
        return true;
    L7:
        if (this.mVisibleBackgroundUsersEnabled == true) goto L10;
        return false;
    L10:
        Object r0 = this.mLock;
        monitor-enter(r0);
        Object r1 = this.mLock;     // Catch: Throwable -> L21
        monitor-enter(r1);     // Catch: Throwable -> L21
        int profileGroupId = this.mStartedVisibleProfileGroupIds.get(userId, ProcessList.INVALID_ADJ);     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
    L17:
        if (isProfile(userId, profileGroupId) == false) goto L23;
        boolean r2 = isUserAssignedToDisplayOnStartLocked(profileGroupId);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return r2;
    L23:
        boolean r3 = isUserAssignedToDisplayOnStartLocked(userId);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return r3;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    private boolean isUserAssignedToDisplayOnStartLocked(int userId) {
        if (this.mUsersAssignedToDisplayOnStart.indexOfKey(userId) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isUserAssignedToDisplayOnStartLocked(int userId, int displayId) {
        if (this.mUsersAssignedToDisplayOnStart != null) goto L7;
        Slogf.wtf(TAG, "isUserAssignedToDisplayOnStartLocked(%d, %d): called when mUsersAssignedToDisplayOnStart is null", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});
        return false;
    L7:
        if (displayId != (-1)) goto L9;
        return false;
    L9:
        if (this.mUsersAssignedToDisplayOnStart.get(userId, -1) != displayId) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean isParentVisibleOnDisplay(int profileGroupId, int displayId) {
        if (profileGroupId != (-1)) goto L7;
        return true;
    L7:
        return isUserVisible(profileGroupId, displayId);
    }

    public boolean isUserVisible(int userId, int displayId) {
        if (displayId != (-1)) goto L6;
        return false;
    L6:
        if (isCurrentUserOrRunningProfileOfCurrentUser(userId) == false) goto L13;
        if (displayId != 0) goto L9;
        return true;
    L9:
        if (this.mVisibleBackgroundUsersEnabled == true) goto L13;
        return true;
    L13:
        if (this.mVisibleBackgroundUsersEnabled == false) goto L15;
        Object r0 = this.mLock;
        monitor-enter(r0);
        Object r1 = this.mLock;     // Catch: Throwable -> L29
        monitor-enter(r1);     // Catch: Throwable -> L29
        int profileGroupId = this.mStartedVisibleProfileGroupIds.get(userId, ProcessList.INVALID_ADJ);     // Catch: Throwable -> L34
        monitor-exit(r1);     // Catch: Throwable -> L34
    L25:
        if (isProfile(userId, profileGroupId) == false) goto L31;
        boolean r2 = isFullUserVisibleOnBackgroundLocked(profileGroupId, displayId);     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        return r2;
    L31:
        boolean r3 = isFullUserVisibleOnBackgroundLocked(userId, displayId);     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        return r3;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    L15:
        if (DBG == false) goto L17;
        Slogf.d(TAG, "isUserVisible(%d, %d): returning false as device does not support visible background users", new Object[]{Integer.valueOf(userId), Integer.valueOf(displayId)});
    L17:
        return false;
    }

    private boolean isFullUserVisibleOnBackgroundLocked(int userId, int displayId) {
        if (this.mUsersAssignedToDisplayOnStart.get(userId, -1) != displayId) goto L6;
        return true;
    L6:
        if (this.mExtraDisplaysAssignedToUsers.get(displayId, ProcessList.INVALID_ADJ) == userId) goto L10;
        return false;
    L10:
        return true;
    }

    public int getMainDisplayAssignedToUser(int userId) {
        if (isCurrentUserOrRunningProfileOfCurrentUser(userId) == false) goto L21;
        if (this.mVisibleBackgroundUserOnDefaultDisplayEnabled == false) goto L19;
        Object r0 = this.mLock;
        monitor-enter(r0);
        int userStartedOnDefaultDisplay = getUserStartedOnDisplay(0);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        if (userStartedOnDefaultDisplay == (-10000)) goto L19;
        if (DBG == false) goto L15;
        Slogf.d(TAG, "getMainDisplayAssignedToUser(%d): returning INVALID_DISPLAY for current user user %d was started on DEFAULT_DISPLAY", new Object[]{Integer.valueOf(userId), Integer.valueOf(userStartedOnDefaultDisplay)});
    L15:
        return -1;
    L16:
        th = move-exception;
        throw th;
    L19:
        return 0;
    L21:
        if (this.mVisibleBackgroundUsersEnabled == true) goto L23;
        return -1;
    L23:
        Object r1 = this.mLock;
        monitor-enter(r1);
        int r2 = this.mUsersAssignedToDisplayOnStart.get(userId, -1);     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
        return r2;
    L28:
        th = move-exception;
        throw th;
    }

    public int[] getDisplaysAssignedToUser(int userId) {
        int mainDisplayId = getMainDisplayAssignedToUser(userId);
        if (mainDisplayId == (-1)) goto L5;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L22:
        th = move-exception;
        throw th;
    L12:
        if (this.mExtraDisplaysAssignedToUsers != null) goto L14;
    L32:
        int[] results = {mainDisplayId};     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        return results;
    L14:
        if (this.mExtraDisplaysAssignedToUsers.size() == 0) goto L32;
        int[] displayIds = new int[this.mExtraDisplaysAssignedToUsers.size() + 1];     // Catch: Throwable -> L22
        int count = 0 + 1;     // Catch: Throwable -> L22
        displayIds[0] = mainDisplayId;     // Catch: Throwable -> L22
        int i = 0;
    L18:
        if (i >= this.mExtraDisplaysAssignedToUsers.size()) goto L25;
        if (this.mExtraDisplaysAssignedToUsers.valueAt(i) != userId) goto L24;
        displayIds[count] = this.mExtraDisplaysAssignedToUsers.keyAt(i);     // Catch: Throwable -> L22
        count = count + 1;     // Catch: Throwable -> L22
    L24:
        i = i + 1;     // Catch: Throwable -> L22
        goto L18
    L25:
        int i2 = displayIds.length;     // Catch: Throwable -> L22
        if (i2 != count) goto L29;
        monitor-exit(r1);     // Catch: Throwable -> L22
        return displayIds;
    L29:
        int[] results2 = new int[count];     // Catch: Throwable -> L22
        System.arraycopy(displayIds, 0, results2, 0, count);     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        return results2;
    L5:
        if (DBG == false) goto L41;
        Slogf.d(TAG, "getDisplaysAssignedToUser(): returning null because there is no display assigned to user %d", new Object[]{Integer.valueOf(userId)});
        return null;
    L41:
        return null;
    }

    public int getUserAssignedToDisplay(int displayId) {
        return getUserAssignedToDisplay(displayId, true);
    }

    private int getUserStartedOnDisplay(int displayId) {
        return getUserAssignedToDisplay(displayId, false);
    }

    private int getUserAssignedToDisplay(int displayId, boolean returnCurrentUserByDefault) {
        if (returnCurrentUserByDefault == false) goto L10;
        if (displayId != 0) goto L7;
        if (this.mVisibleBackgroundUserOnDefaultDisplayEnabled == true) goto L7;
    L9:
        return getCurrentUserId();
    L7:
        if (this.mVisibleBackgroundUsersEnabled == false) goto L9;
    L10:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L45:
    L22:
        th = move-exception;
        throw th;
    L14:
        if (i >= this.mUsersAssignedToDisplayOnStart.size()) goto L28;
        if (this.mUsersAssignedToDisplayOnStart.valueAt(i) != displayId) goto L27;
        int userId = this.mUsersAssignedToDisplayOnStart.keyAt(i);     // Catch: Throwable -> L22
        if (isStartedVisibleProfileLocked(userId) == false) goto L20;
        if (DBG == false) goto L27;
        Slogf.d(TAG, "getUserAssignedToDisplay(%d): skipping user %d because it's a profile", new Object[]{Integer.valueOf(displayId), Integer.valueOf(userId)});     // Catch: Throwable -> L22
        goto L27
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return userId;
    L27:
        i = i + 1;     // Catch: Throwable -> L22
        goto L45
    L28:
        int userAssignedToExtraDisplay = this.mExtraDisplaysAssignedToUsers.get(displayId, ProcessList.INVALID_ADJ);     // Catch: Throwable -> L22
        if (userAssignedToExtraDisplay == (-10000)) goto L33;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return userAssignedToExtraDisplay;
    L33:
        monitor-exit(r0);     // Catch: Throwable -> L22
        if (returnCurrentUserByDefault == false) goto L36;
        int currentUserId = getCurrentUserId();
        if (DBG == false) goto L42;
        Slogf.d(TAG, "getUserAssignedToDisplay(%d): no user assigned to display, returning current user (%d) instead", new Object[]{Integer.valueOf(displayId), Integer.valueOf(currentUserId)});
    L42:
        return currentUserId;
    L36:
        if (DBG == false) goto L38;
        Slogf.d(TAG, "getUserAssignedToDisplay(%d): no user assigned to display, returning USER_NULL instead", new Object[]{Integer.valueOf(displayId)});
    L38:
        return ProcessList.INVALID_ADJ;
    }

    public IntArray getVisibleUsers() {
        IntArray visibleUsers = new IntArray();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = 0;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mStartedVisibleProfileGroupIds.size()) goto L14;
        int userId = this.mStartedVisibleProfileGroupIds.keyAt(i);     // Catch: Throwable -> L10
        if (isUserVisible(userId) == false) goto L12;
        visibleUsers.add(userId);     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L18
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return visibleUsers;
    }

    public void addListener(UserManagerInternal.UserVisibilityListener listener) {
        if (DBG == false) goto L5;
        Slogf.d(TAG, "adding listener %s", new Object[]{listener});
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mListeners.add(listener);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void removeListener(UserManagerInternal.UserVisibilityListener listener) {
        if (DBG == false) goto L5;
        Slogf.d(TAG, "removing listener %s", new Object[]{listener});
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mListeners.remove(listener);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void onSystemUserVisibilityChanged(boolean visible) {
        dispatchVisibilityChanged(this.mListeners, 0, visible);
    }

    private void dispatchVisibilityChanged(IntArray visibleUsersBefore, IntArray visibleUsersAfter) {
        if (visibleUsersBefore == null) goto L4;
        CopyOnWriteArrayList<UserManagerInternal.UserVisibilityListener> listeners = this.mListeners;
        if (DBG == false) goto L10;
        Slogf.d(TAG, "dispatchVisibilityChanged(): visibleUsersBefore=%s, visibleUsersAfter=%s, %d listeners (%s)", new Object[]{visibleUsersBefore, visibleUsersAfter, Integer.valueOf(listeners.size()), listeners});
    L10:
        int i = 0;
    L12:
        if (i >= visibleUsersBefore.size()) goto L17;
        int userId = visibleUsersBefore.get(i);
        if (visibleUsersAfter.indexOf(userId) != (-1)) goto L16;
        dispatchVisibilityChanged(listeners, userId, false);
    L16:
        i = i + 1;
        goto L12
    L17:
        int i2 = 0;
    L19:
        if (i2 >= visibleUsersAfter.size()) goto L25;
        int userId2 = visibleUsersAfter.get(i2);
        if (visibleUsersBefore.indexOf(userId2) != (-1)) goto L23;
        dispatchVisibilityChanged(listeners, userId2, true);
    L23:
        i2 = i2 + 1;
        goto L19
    L25:
        return;
    L4:
        if (DBG == false) goto L32;
        Slogf.d(TAG, "dispatchVisibilityChanged(): ignoring, no listeners");
        return;
    }

    private void dispatchVisibilityChanged(CopyOnWriteArrayList<UserManagerInternal.UserVisibilityListener> r5, final int r6, final boolean r7) {
        EventLog.writeEvent(EventLogTags.UM_USER_VISIBILITY_CHANGED, new Object[]{Integer.valueOf(r6), Integer.valueOf(r7 ? 1 : 0)});
        if (DBG == false) goto L5;
        Slogf.d(TAG, "dispatchVisibilityChanged(%d -> %b): sending to %d listeners", new Object[]{Integer.valueOf(r6), Boolean.valueOf(r7), Integer.valueOf(r5.size())});
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mListeners.size()) goto L10;
        final UserManagerInternal.UserVisibilityListener r1 = this.mListeners.get(r0);
        this.mHandler.post(new UserVisibilityMediator$$ExternalSyntheticLambda0(r1, r6, r7));
        r0 = r0 + 1;
        goto L7
    }

    private static /* synthetic */ void lambda$dispatchVisibilityChanged$0(UserManagerInternal.UserVisibilityListener listener, int userId, boolean visible) {
        listener.onUserVisibilityChanged(userId, visible);
    }

    private void dump(IndentingPrintWriter ipw) {
        ipw.println("UserVisibilityMediator");
        ipw.increaseIndent();
        ipw.print("DBG: ");
        ipw.println(DBG);
        Object r0 = this.mLock;
        monitor-enter(r0);
        ipw.print("Current user id: ");     // Catch: Throwable -> L7
        ipw.println(this.mCurrentUserId);     // Catch: Throwable -> L7
        ipw.print("Visible users: ");     // Catch: Throwable -> L7
        ipw.println(getVisibleUsers());     // Catch: Throwable -> L7
        dumpSparseIntArray(ipw, this.mStartedVisibleProfileGroupIds, "started visible user / profile group", "u", "pg");     // Catch: Throwable -> L7
        if (this.mStartedInvisibleProfileUserIds == null) goto L9;
        ipw.print("Profiles started invisible: ");     // Catch: Throwable -> L7
        ipw.println(this.mStartedInvisibleProfileUserIds);     // Catch: Throwable -> L7
    L9:
        ipw.print("Supports visible background users on displays: ");     // Catch: Throwable -> L7
        ipw.println(this.mVisibleBackgroundUsersEnabled);     // Catch: Throwable -> L7
        ipw.print("Supports visible background users on default display: ");     // Catch: Throwable -> L7
        ipw.println(this.mVisibleBackgroundUserOnDefaultDisplayEnabled);     // Catch: Throwable -> L7
        dumpSparseIntArray(ipw, this.mUsersAssignedToDisplayOnStart, "user / display", "u", "d");     // Catch: Throwable -> L7
        dumpSparseIntArray(ipw, this.mExtraDisplaysAssignedToUsers, "extra display / user", "d", "u");     // Catch: Throwable -> L7
        int numberListeners = this.mListeners.size();     // Catch: Throwable -> L7
        ipw.print("Number of listeners: ");     // Catch: Throwable -> L7
        ipw.println(numberListeners);     // Catch: Throwable -> L7
        if (numberListeners <= 0) goto L15;
        ipw.increaseIndent();     // Catch: Throwable -> L7
        int i = 0;
    L12:
        if (i >= numberListeners) goto L14;
        ipw.print(i);     // Catch: Throwable -> L7
        ipw.print(": ");     // Catch: Throwable -> L7
        ipw.println(this.mListeners.get(i));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L12
    L14:
        ipw.decreaseIndent();     // Catch: Throwable -> L7
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L7
        ipw.decreaseIndent();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void dumpSparseIntArray(IndentingPrintWriter ipw, SparseIntArray array, String arrayDescription, String keyName, String valueName) {
        if (array != null) goto L5;
        ipw.print("No ");
        ipw.print(arrayDescription);
        ipw.println(" mappings");
        return;
    L5:
        ipw.print("Number of ");
        ipw.print(arrayDescription);
        ipw.print(" mappings: ");
        ipw.println(array.size());
        if (array.size() > 0) goto L8;
        return;
    L8:
        ipw.increaseIndent();
        int i = 0;
    L10:
        if (i >= array.size()) goto L12;
        ipw.print(keyName);
        ipw.print(':');
        ipw.print(array.keyAt(i));
        ipw.print(" -> ");
        ipw.print(valueName);
        ipw.print(':');
        ipw.println(array.valueAt(i));
        i = i + 1;
        goto L10
    L12:
        ipw.decreaseIndent();
    }

    @Override // android.util.Dumpable
    public void dump(PrintWriter pw, String[] args) {
        if ((pw instanceof IndentingPrintWriter) == false) goto L6;
        dump((IndentingPrintWriter) pw);
        return;
    L6:
        dump(new IndentingPrintWriter(pw));
    }

    private static boolean isSpecialUserId(int userId) {
        switch(userId) {
            case -10000: goto L5;
            case -3: goto L5;
            case -2: goto L5;
            case -1: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    private static boolean isProfile(int userId, int profileGroupId) {
        if (profileGroupId == (-10000)) goto L6;
        if (profileGroupId == userId) goto L6;
        return true;
    L6:
        return false;
    }

    private int getCurrentUserId() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mCurrentUserId;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isCurrentUserLocked(int userId) {
        if (userId != (-10000)) goto L5;
    L11:
        return false;
    L5:
        if (this.mCurrentUserId == (-10000)) goto L11;
        if (this.mCurrentUserId != userId) goto L12;
        return true;
    L12:
        return false;
    }

    private boolean isCurrentUserOrRunningProfileOfCurrentUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = false;
        if (userId == (-10000)) goto L22;
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mCurrentUserId == (-10000)) goto L22;
        if (this.mCurrentUserId != userId) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L15:
        int profileGroupId = this.mStartedVisibleProfileGroupIds.get(userId, ProcessList.INVALID_ADJ);     // Catch: Throwable -> L13
        if (profileGroupId != this.mCurrentUserId) goto L18;
    L19:
        r1 = true;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L18:
        if (profileGroupId != (-1)) goto L20;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    }

    private boolean isStartedVisibleProfileLocked(int userId) {
        int profileGroupId = this.mStartedVisibleProfileGroupIds.get(userId, ProcessList.INVALID_ADJ);
        return isProfile(userId, profileGroupId);
    }

    private void validateUserStartMode(int userStartMode) {
        switch(userStartMode) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return;
    L4:
        throw new IllegalArgumentException("Invalid user start mode: " + userStartMode);
    }

    private static String secondaryDisplayMappingStatusToString(int status) {
        return DebugUtils.constantToString(UserVisibilityMediator.class, PREFIX_SECONDARY_DISPLAY_MAPPING, status);
    }
}
