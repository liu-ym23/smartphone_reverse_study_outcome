package com.android.server.pm;

import android.content.pm.UserInfo;
import android.util.SparseArray;
import com.android.internal.util.FrameworkStatsLog;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes2.dex */
public class UserJourneyLogger {
    public static final int ERROR_CODE_ABORTED = 3;
    public static final int ERROR_CODE_INCOMPLETE_OR_TIMEOUT = 2;
    public static final int ERROR_CODE_INVALID_SESSION_ID = 0;
    public static final int ERROR_CODE_NULL_USER_INFO = 4;
    public static final int ERROR_CODE_UNSPECIFIED = -1;
    public static final int ERROR_CODE_USER_ALREADY_AN_ADMIN = 5;
    public static final int ERROR_CODE_USER_IS_NOT_AN_ADMIN = 6;
    public static final int EVENT_STATE_BEGIN = 1;
    public static final int EVENT_STATE_CANCEL = 3;
    public static final int EVENT_STATE_ERROR = 4;
    public static final int EVENT_STATE_FINISH = 2;
    public static final int EVENT_STATE_NONE = 0;
    private static final int USER_ID_KEY_MULTIPLICATION = 100;
    public static final int USER_JOURNEY_GRANT_ADMIN = 7;
    public static final int USER_JOURNEY_REVOKE_ADMIN = 8;
    public static final int USER_JOURNEY_UNKNOWN = 0;
    public static final int USER_JOURNEY_USER_CREATE = 4;
    public static final int USER_JOURNEY_USER_LIFECYCLE = 9;
    public static final int USER_JOURNEY_USER_REMOVE = 6;
    public static final int USER_JOURNEY_USER_START = 3;
    public static final int USER_JOURNEY_USER_STOP = 5;
    public static final int USER_JOURNEY_USER_SWITCH_FG = 2;
    public static final int USER_JOURNEY_USER_SWITCH_UI = 1;
    public static final int USER_LIFECYCLE_EVENT_CREATE_USER = 3;
    public static final int USER_LIFECYCLE_EVENT_GRANT_ADMIN = 9;
    public static final int USER_LIFECYCLE_EVENT_REMOVE_USER = 8;
    public static final int USER_LIFECYCLE_EVENT_REVOKE_ADMIN = 10;
    public static final int USER_LIFECYCLE_EVENT_START_USER = 2;
    public static final int USER_LIFECYCLE_EVENT_STOP_USER = 7;
    public static final int USER_LIFECYCLE_EVENT_SWITCH_USER = 1;
    public static final int USER_LIFECYCLE_EVENT_UNKNOWN = 0;
    public static final int USER_LIFECYCLE_EVENT_UNLOCKED_USER = 6;
    public static final int USER_LIFECYCLE_EVENT_UNLOCKING_USER = 5;
    public static final int USER_LIFECYCLE_EVENT_USER_RUNNING_LOCKED = 4;
    private final Object mLock;
    private final SparseArray<UserJourneySession> mUserIdToUserJourneyMap;

    public @interface UserJourney {
    }

    public @interface UserJourneyErrorCode {
    }

    public static class UserJourneySession {
        public final int mJourney;
        public final long mSessionId;
        public final long mStartTimeInMills;

        public UserJourneySession(long sessionId, int journey) {
            this.mJourney = journey;
            this.mSessionId = sessionId;
            this.mStartTimeInMills = System.currentTimeMillis();
        }

        public UserJourneySession(long sessionId, int journey, long startTimeInMills) {
            this.mJourney = journey;
            this.mSessionId = sessionId;
            this.mStartTimeInMills = startTimeInMills;
        }
    }

    public @interface UserLifecycleEvent {
    }

    public @interface UserLifecycleEventState {
    }

    public UserJourneyLogger() {
        this.mLock = new Object();
        this.mUserIdToUserJourneyMap = new SparseArray();
    }

    private static int journeyToEvent(int journey) {
        switch(journey) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 10;
    L7:
        return 9;
    L9:
        return 8;
    L11:
        return 7;
    L13:
        return 3;
    L15:
        return 2;
    L17:
        return 1;
    }

    public static int getUserTypeForStatsd(String userType) {
        switch(userType.hashCode()) {
            case -1309576832: goto L30;
            case -1103927049: goto L27;
            case -159818852: goto L24;
            case 34001850: goto L21;
            case 485661392: goto L18;
            case 942013715: goto L15;
            case 1711075452: goto L12;
            case 1765400260: goto L9;
            case 1966344346: goto L6;
            default: goto L32;
        };
    L32:
        byte r0 = -1;
    L33:
        switch(r0) {
            case 0: goto L44;
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L40;
            case 5: goto L39;
            case 6: goto L38;
            case 7: goto L37;
            case 8: goto L35;
            default: goto L34;
        };
    L34:
        return 0;
    L35:
        return 9;
    L37:
        return 8;
    L38:
        return 7;
    L39:
        return 6;
    L40:
        return 5;
    L41:
        return 4;
    L42:
        return 3;
    L43:
        return 2;
    L44:
        return 1;
    L6:
        if (userType.equals("android.os.usertype.profile.CLONE") == false) goto L32;
        r0 = 7;
        goto L33
    L9:
        if (userType.equals("android.os.usertype.full.DEMO") == false) goto L32;
        r0 = 3;
        goto L33
    L12:
        if (userType.equals("android.os.usertype.full.RESTRICTED") == false) goto L32;
        r0 = 4;
        goto L33
    L15:
        if (userType.equals("android.os.usertype.full.SECONDARY") == false) goto L32;
        r0 = 1;
        goto L33
    L18:
        if (userType.equals("android.os.usertype.full.SYSTEM") == false) goto L32;
        r0 = 0;
        goto L33
    L21:
        if (userType.equals("android.os.usertype.system.HEADLESS") == false) goto L32;
        r0 = 6;
        goto L33
    L24:
        if (userType.equals("android.os.usertype.profile.MANAGED") == false) goto L32;
        r0 = 5;
        goto L33
    L27:
        if (userType.equals("android.os.usertype.full.GUEST") == false) goto L32;
        r0 = 2;
        goto L33
    L30:
        if (userType.equals("android.os.usertype.profile.PRIVATE") == false) goto L32;
        r0 = 8;
        goto L33
    }

    private static int errorToFinishState(int errorCode) {
        switch(errorCode) {
            case -1: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 4;
    L5:
        return 3;
    L7:
        return 2;
    }

    public void logUserLifecycleJourneyReported(UserJourneySession session, int journey, int originalUserId, int targetUserId, int userType, int userFlags, int errorCode) {
        if (session != null) goto L5;
        writeUserLifecycleJourneyReported(-1, journey, originalUserId, targetUserId, userType, userFlags, 0, -1);
        return;
    L5:
        long elapsedTime = System.currentTimeMillis() - session.mStartTimeInMills;
        writeUserLifecycleJourneyReported(session.mSessionId, journey, originalUserId, targetUserId, userType, userFlags, errorCode, elapsedTime);
    }

    public void writeUserLifecycleJourneyReported(long sessionId, int journey, int originalUserId, int targetUserId, int userType, int userFlags, int errorCode, long elapsedTime) {
        FrameworkStatsLog.write(264, sessionId, journey, originalUserId, targetUserId, userType, userFlags, errorCode, elapsedTime);
    }

    public void logUserLifecycleEventOccurred(UserJourneySession session, int targetUserId, int event, int state, int errorCode) {
        if (session != null) goto L5;
        writeUserLifecycleEventOccurred(-1, targetUserId, event, 4, 0);
        return;
    L5:
        writeUserLifecycleEventOccurred(session.mSessionId, targetUserId, event, state, errorCode);
    }

    public void writeUserLifecycleEventOccurred(long sessionId, int userId, int event, int state, int errorCode) {
        FrameworkStatsLog.write(265, sessionId, userId, event, state, errorCode);
    }

    public void logUserLifecycleEvent(int userId, int event, int eventState) {
        UserJourneySession userJourneySession = findUserJourneySession(userId);
        logUserLifecycleEventOccurred(userJourneySession, userId, event, eventState, -1);
    }

    private UserJourneySession findUserJourneySession(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int keyMapSize = this.mUserIdToUserJourneyMap.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= keyMapSize) goto L15;
        int key = this.mUserIdToUserJourneyMap.keyAt(i);     // Catch: Throwable -> L11
        if ((key / 100) == userId) goto L8;
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L8:
        UserJourneySession r4 = this.mUserIdToUserJourneyMap.get(key);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r4;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    private int getUserJourneyKey(int targetUserId, int journey) {
        return (targetUserId * 100) + journey;
    }

    public UserJourneySession finishAndClearIncompleteUserJourney(int targetUserId, int journey) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int key = getUserJourneyKey(targetUserId, journey);     // Catch: Throwable -> L25
        UserJourneySession userJourneySession = this.mUserIdToUserJourneyMap.get(key);     // Catch: Throwable -> L25
        if (userJourneySession == null) goto L28;
        logUserLifecycleEventOccurred(userJourneySession, targetUserId, journeyToEvent(userJourneySession.mJourney), 4, 2);     // Catch: Throwable -> L23
        logUserLifecycleJourneyReported(userJourneySession, journey, -1, targetUserId, getUserTypeForStatsd(""), -1, 2);     // Catch: Throwable -> L18
        this.mUserIdToUserJourneyMap.remove(key);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return userJourneySession;
    L18:
        th = move-exception;
        Throwable r13 = th;
    L31:
        monitor-exit(r1);     // Catch: Throwable -> L16
        throw r13;
    L20:
        th = th;
    L22:
        r13 = th;
    L23:
        th = th;
        goto L22
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return null;
    L25:
        th = move-exception;
        r13 = th;
    L16:
        th = move-exception;
        r13 = th;
        goto L31
    }

    public UserJourneySession logUserJourneyFinish(int originalUserId, UserInfo targetUser, int journey) {
        return logUserJourneyFinishWithError(originalUserId, targetUser, journey, -1);
    }

    public UserJourneySession logUserSwitchJourneyFinish(int originalUserId, UserInfo targetUser) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int key_fg = getUserJourneyKey(targetUser.id, 2);     // Catch: Throwable -> L9
        int key_ui = getUserJourneyKey(targetUser.id, 1);     // Catch: Throwable -> L9
        if (this.mUserIdToUserJourneyMap.contains(key_fg) == false) goto L12;
        UserJourneySession r2 = logUserJourneyFinish(originalUserId, targetUser, 2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        if (this.mUserIdToUserJourneyMap.contains(key_ui) == false) goto L16;
        UserJourneySession r3 = logUserJourneyFinish(originalUserId, targetUser, 1);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public UserJourneySession logUserJourneyFinishWithError(int originalUserId, UserInfo targetUser, int journey, int errorCode) {
        Object r9 = this.mLock;
        monitor-enter(r9);
        int state = errorToFinishState(errorCode);     // Catch: Throwable -> L9
        int key = getUserJourneyKey(targetUser.id, journey);     // Catch: Throwable -> L9
        UserJourneySession userJourneySession = this.mUserIdToUserJourneyMap.get(key);     // Catch: Throwable -> L9
        if (userJourneySession == null) goto L12;
        logUserLifecycleEventOccurred(userJourneySession, targetUser.id, journeyToEvent(userJourneySession.mJourney), state, errorCode);     // Catch: Throwable -> L9
        int state2 = targetUser.id;     // Catch: Throwable -> L9
        logUserLifecycleJourneyReported(userJourneySession, journey, originalUserId, state2, getUserTypeForStatsd(targetUser.userType), targetUser.flags, errorCode);     // Catch: Throwable -> L9
        this.mUserIdToUserJourneyMap.remove(key);     // Catch: Throwable -> L9
        monitor-exit(r9);     // Catch: Throwable -> L9
        return userJourneySession;
    L12:
        monitor-exit(r9);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public UserJourneySession logDelayedUserJourneyFinishWithError(int originalUserId, UserInfo targetUser, int journey, int errorCode) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int key = getUserJourneyKey(targetUser.id, journey);     // Catch: Throwable -> L13
        UserJourneySession userJourneySession = this.mUserIdToUserJourneyMap.get(key);     // Catch: Throwable -> L13
        if (userJourneySession == null) goto L16;
        logUserLifecycleJourneyReported(userJourneySession, journey, originalUserId, targetUser.id, getUserTypeForStatsd(targetUser.userType), targetUser.flags, errorCode);     // Catch: Throwable -> L11
        this.mUserIdToUserJourneyMap.remove(key);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return userJourneySession;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        Throwable r12 = th;
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L11
        throw r12;
    L13:
        th = move-exception;
        r12 = th;
        goto L19
    }

    public UserJourneySession logNullUserJourneyError(int journey, int currentUserId, int targetUserId, String targetUserType, int targetUserFlags) {
        Object r9 = this.mLock;
        monitor-enter(r9);
        int key = getUserJourneyKey(targetUserId, journey);     // Catch: Throwable -> L7
        UserJourneySession session = this.mUserIdToUserJourneyMap.get(key);     // Catch: Throwable -> L7
        logUserLifecycleEventOccurred(session, targetUserId, journeyToEvent(journey), 4, 4);     // Catch: Throwable -> L7
        logUserLifecycleJourneyReported(session, journey, currentUserId, targetUserId, getUserTypeForStatsd(targetUserType), targetUserFlags, 4);     // Catch: Throwable -> L7
        this.mUserIdToUserJourneyMap.remove(key);     // Catch: Throwable -> L7
        monitor-exit(r9);     // Catch: Throwable -> L7
        return session;
    L7:
        th = move-exception;
        throw th;
    }

    public UserJourneySession logUserCreateJourneyFinish(int originalUserId, UserInfo targetUser) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int key = getUserJourneyKey(-1, 4);     // Catch: Throwable -> L17
        UserJourneySession userJourneySession = this.mUserIdToUserJourneyMap.get(key);     // Catch: Throwable -> L17
        if (userJourneySession == null) goto L23;
        logUserLifecycleEventOccurred(userJourneySession, targetUser.id, 3, 2, -1);     // Catch: Throwable -> L20
        logUserLifecycleJourneyReported(userJourneySession, 4, originalUserId, targetUser.id, getUserTypeForStatsd(targetUser.userType), targetUser.flags, -1);     // Catch: Throwable -> L15
        this.mUserIdToUserJourneyMap.remove(key);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return userJourneySession;
    L20:
        th = th;
    L19:
        Throwable r12 = th;
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L15
        throw r12;
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return null;
    L15:
        th = move-exception;
        r12 = th;
    L17:
        th = th;
        goto L19
    }

    public UserJourneySession logUserJourneyBegin(int targetId, int journey) {
        long newSessionId = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
        Object r3 = this.mLock;
        monitor-enter(r3);
        int key = getUserJourneyKey(targetId, journey);     // Catch: Throwable -> L11
        UserJourneySession userJourneySession = new UserJourneySession(newSessionId, journey);     // Catch: Throwable -> L11
        this.mUserIdToUserJourneyMap.append(key, userJourneySession);     // Catch: Throwable -> L11
        logUserLifecycleEventOccurred(userJourneySession, targetId, journeyToEvent(userJourneySession.mJourney), 1, -1);     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
        return userJourneySession;
    L9:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r3);     // Catch: Throwable -> L9
        throw r12;
    L11:
        th = move-exception;
        r12 = th;
        goto L13
    }

    public UserJourneySession startSessionForDelayedJourney(int targetId, int journey, long startTime) {
        long newSessionId = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
        Object r1 = this.mLock;
        monitor-enter(r1);
        int key = getUserJourneyKey(targetId, journey);     // Catch: Throwable -> L11
        UserJourneySession userJourneySession = new UserJourneySession(newSessionId, journey, startTime);     // Catch: Throwable -> L9
        this.mUserIdToUserJourneyMap.append(key, userJourneySession);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return userJourneySession;
    L9:
        th = move-exception;
        Throwable r13 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r13;
    L11:
        th = move-exception;
        r13 = th;
        goto L13
    }
}
