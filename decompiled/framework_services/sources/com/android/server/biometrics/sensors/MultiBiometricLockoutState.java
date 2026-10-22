package com.android.server.biometrics.sensors;

import android.hardware.biometrics.BiometricManager;
import android.util.Slog;
import java.time.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: loaded from: classes.dex */
class MultiBiometricLockoutState {
    private static final String TAG = "MultiBiometricLockoutState";
    private final Map<Integer, Map<Integer, AuthenticatorState>> mCanUserAuthenticate;
    private final Clock mClock;

    private static class AuthenticatorState {
        private Integer mAuthenticatorType;
        private boolean mPermanentlyLockedOut;
        private boolean mTimedLockout;

        /* JADX INFO: renamed from: -$$Nest$fgetmPermanentlyLockedOut, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2631$$Nest$fgetmPermanentlyLockedOut(AuthenticatorState r0) {
            return r0.mPermanentlyLockedOut;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTimedLockout, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2632$$Nest$fgetmTimedLockout(AuthenticatorState r0) {
            return r0.mTimedLockout;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmPermanentlyLockedOut, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2633$$Nest$fputmPermanentlyLockedOut(AuthenticatorState r0, boolean r1) {
            r0.mPermanentlyLockedOut = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmTimedLockout, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2634$$Nest$fputmTimedLockout(AuthenticatorState r0, boolean r1) {
            r0.mTimedLockout = r1;
        }

        AuthenticatorState(Integer authenticatorId, boolean permanentlyLockedOut, boolean timedLockout) {
            this.mAuthenticatorType = authenticatorId;
            this.mPermanentlyLockedOut = permanentlyLockedOut;
            this.mTimedLockout = timedLockout;
        }

        String toString(long currentTime) {
            String permanentLockout = "false";
            if (this.mTimedLockout == false) goto L5;
            String timedLockout = "true";
        L7:
            if (this.mPermanentlyLockedOut == false) goto L10;
            permanentLockout = "true";
        L10:
            return String.format("(%s, permanentLockout=%s, timedLockout=%s)", new Object[]{BiometricManager.authenticatorToStr(this.mAuthenticatorType.intValue()), permanentLockout, timedLockout});
        L5:
            timedLockout = "false";
            goto L7
        }
    }

    public static /* synthetic */ String $r8$lambda$Cnvi52ZROxI1SNjznEoQdMbkjAw(long r0, Map.Entry r2) {
        return lambda$toString$0(r0, r2);
    }

    MultiBiometricLockoutState(Clock clock) {
        this.mCanUserAuthenticate = new HashMap();
        this.mClock = clock;
    }

    private Map<Integer, AuthenticatorState> createUnlockedMap() {
        Map<Integer, AuthenticatorState> lockOutMap = new HashMap();
        lockOutMap.put(15, new AuthenticatorState(15, false, false));
        lockOutMap.put(255, new AuthenticatorState(255, false, false));
        Integer r1 = Integer.valueOf(UnixStat.PERM_MASK);
        lockOutMap.put(r1, new AuthenticatorState(r1, false, false));
        return lockOutMap;
    }

    private Map<Integer, AuthenticatorState> getAuthMapForUser(int userId) {
        if (this.mCanUserAuthenticate.containsKey(Integer.valueOf(userId)) == true) goto L6;
        this.mCanUserAuthenticate.put(Integer.valueOf(userId), createUnlockedMap());
    L6:
        return this.mCanUserAuthenticate.get(Integer.valueOf(userId));
    }

    void setPermanentLockOut(int userId, int strength) {
        Map<Integer, AuthenticatorState> authMap = getAuthMapForUser(userId);
        switch(strength) {
            case 15: goto L6;
            case 255: goto L7;
            case 4095: goto L8;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "increaseLockoutTime called for invalid strength : " + strength);
        return;
    L6:
        AuthenticatorState.m2633$$Nest$fputmPermanentlyLockedOut(authMap.get(15), true);
    L7:
        AuthenticatorState.m2633$$Nest$fputmPermanentlyLockedOut(authMap.get(255), true);
    L8:
        AuthenticatorState.m2633$$Nest$fputmPermanentlyLockedOut(authMap.get(Integer.valueOf(UnixStat.PERM_MASK)), true);
    }

    void clearPermanentLockOut(int userId, int strength) {
        Map<Integer, AuthenticatorState> authMap = getAuthMapForUser(userId);
        switch(strength) {
            case 15: goto L6;
            case 255: goto L7;
            case 4095: goto L8;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "increaseLockoutTime called for invalid strength : " + strength);
        return;
    L6:
        AuthenticatorState.m2633$$Nest$fputmPermanentlyLockedOut(authMap.get(15), false);
    L7:
        AuthenticatorState.m2633$$Nest$fputmPermanentlyLockedOut(authMap.get(255), false);
    L8:
        AuthenticatorState.m2633$$Nest$fputmPermanentlyLockedOut(authMap.get(Integer.valueOf(UnixStat.PERM_MASK)), false);
    }

    void setTimedLockout(int userId, int strength) {
        Map<Integer, AuthenticatorState> authMap = getAuthMapForUser(userId);
        switch(strength) {
            case 15: goto L6;
            case 255: goto L7;
            case 4095: goto L8;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "increaseLockoutTime called for invalid strength : " + strength);
        return;
    L6:
        AuthenticatorState.m2634$$Nest$fputmTimedLockout(authMap.get(15), true);
    L7:
        AuthenticatorState.m2634$$Nest$fputmTimedLockout(authMap.get(255), true);
    L8:
        AuthenticatorState.m2634$$Nest$fputmTimedLockout(authMap.get(Integer.valueOf(UnixStat.PERM_MASK)), true);
    }

    void clearTimedLockout(int userId, int strength) {
        Map<Integer, AuthenticatorState> authMap = getAuthMapForUser(userId);
        switch(strength) {
            case 15: goto L6;
            case 255: goto L7;
            case 4095: goto L8;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "increaseLockoutTime called for invalid strength : " + strength);
        return;
    L6:
        AuthenticatorState.m2634$$Nest$fputmTimedLockout(authMap.get(15), false);
    L7:
        AuthenticatorState.m2634$$Nest$fputmTimedLockout(authMap.get(255), false);
    L8:
        AuthenticatorState.m2634$$Nest$fputmTimedLockout(authMap.get(Integer.valueOf(UnixStat.PERM_MASK)), false);
    }

    int getLockoutState(int userId, int strength) {
        Map<Integer, AuthenticatorState> authMap = getAuthMapForUser(userId);
        if (authMap.containsKey(Integer.valueOf(strength)) == true) goto L6;
        Slog.e(TAG, "Error, getLockoutState for unknown strength: " + strength + " returning LOCKOUT_NONE");
        return 0;
    L6:
        AuthenticatorState state = authMap.get(Integer.valueOf(strength));
        if (AuthenticatorState.m2631$$Nest$fgetmPermanentlyLockedOut(state) == false) goto L11;
        return 2;
    L11:
        if (AuthenticatorState.m2632$$Nest$fgetmTimedLockout(state) == false) goto L14;
        return 1;
    L14:
        return 0;
    }

    public String toString() {
        String dumpState = "Permanent Lockouts\n";
        final long time = this.mClock.millis();
        Iterator<Map.Entry<Integer, Map<Integer, AuthenticatorState>>> r3 = this.mCanUserAuthenticate.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry<Integer, Map<Integer, AuthenticatorState>> userState = r3.next();
        int userId = userState.getKey().intValue();
        Map<Integer, AuthenticatorState> map = userState.getValue();
        String prettyStr = (String) map.entrySet().stream().map(new MultiBiometricLockoutState$$ExternalSyntheticLambda0(time)).collect(Collectors.joining(", "));
        dumpState = dumpState + "UserId=" + userId + ", {" + prettyStr + "}\n";
        goto L4
    L6:
        return dumpState;
    }

    private static /* synthetic */ String lambda$toString$0(long time, Map.Entry entry) {
        return ((AuthenticatorState) entry.getValue()).toString(time);
    }
}
