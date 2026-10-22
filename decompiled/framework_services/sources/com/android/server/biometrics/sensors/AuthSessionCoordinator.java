package com.android.server.biometrics.sensors;

import android.os.SystemClock;
import android.util.Slog;
import java.time.Clock;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: loaded from: classes.dex */
public class AuthSessionCoordinator implements AuthSessionListener {
    private static final String TAG = "AuthSessionCoordinator";
    private final Set<Integer> mAuthOperations;
    private AuthResultCoordinator mAuthResultCoordinator;
    private boolean mIsAuthenticating;
    private final MultiBiometricLockoutState mMultiBiometricLockoutState;
    private final RingBuffer mRingBuffer;
    private int mUserId;

    private static class RingBuffer {
        private int mApiCallNumber;
        private final String[] mApiCalls;
        private int mCurr;
        private final int mSize;

        RingBuffer(int size) {
            if (size > 0) goto L5;
            Slog.wtf(AuthSessionCoordinator.TAG, "Cannot initialize ring buffer of size: " + size);
        L5:
            this.mApiCalls = new String[size];
            this.mCurr = 0;
            this.mSize = size;
            this.mApiCallNumber = 0;
        }

        synchronized void addApiCall(String str) {
            monitor-enter(this);
            this.mApiCalls[this.mCurr] = str;     // Catch: Throwable -> L6
            this.mCurr++;     // Catch: Throwable -> L6
            this.mCurr %= this.mSize;     // Catch: Throwable -> L6
            this.mApiCallNumber++;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized String toString() {
            monitor-enter(this);
            String buffer = "";
            if (this.mApiCallNumber <= this.mSize) goto L8;
            int apiCall = this.mApiCallNumber - this.mSize;     // Catch: Throwable -> L6
        L9:
            int i = 0;
        L10:
            if (i >= this.mSize) goto L18;
            int location = (this.mCurr + i) % this.mSize;     // Catch: Throwable -> L6
            if (this.mApiCalls[location] == null) goto L16;
            StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L6
            r4.append(buffer);     // Catch: Throwable -> L6
            int apiCall2 = apiCall + 1;     // Catch: Throwable -> L6
            r4.append(String.format("#%-5d %s\n", new Object[]{Integer.valueOf(apiCall), this.mApiCalls[location]}));     // Catch: Throwable -> L6
            buffer = r4.toString();     // Catch: Throwable -> L6
            apiCall = apiCall2;
        L16:
            i = i + 1;
            goto L10
        L18:
            monitor-exit(this);
            return buffer;
        L8:
            apiCall = 0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public AuthSessionCoordinator() {
        this(SystemClock.elapsedRealtimeClock());
    }

    AuthSessionCoordinator(Clock clock) {
        this.mAuthOperations = new HashSet();
        this.mAuthResultCoordinator = new AuthResultCoordinator();
        this.mMultiBiometricLockoutState = new MultiBiometricLockoutState(clock);
        this.mRingBuffer = new RingBuffer(100);
    }

    void onAuthSessionStarted(int userId) {
        this.mAuthOperations.clear();
        this.mUserId = userId;
        this.mIsAuthenticating = true;
        this.mAuthResultCoordinator = new AuthResultCoordinator();
        this.mRingBuffer.addApiCall("internal : onAuthSessionStarted(" + userId + ")");
    }

    void endAuthSession() {
        Map<Integer, Integer> result = this.mAuthResultCoordinator.getResult();
        Iterator r1 = Arrays.asList(new Integer[]{Integer.valueOf(UnixStat.PERM_MASK), 255, 15}).iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        int authenticator = ((Integer) r1.next()).intValue();
        Integer value = result.get(Integer.valueOf(authenticator));
        if ((value.intValue() & 4) == 4) goto L7;
        if ((value.intValue() & 1) == 1) goto L10;
        if ((value.intValue() & 2) != 2) goto L4;
        this.mMultiBiometricLockoutState.setTimedLockout(this.mUserId, authenticator);
        goto L4
    L10:
        this.mMultiBiometricLockoutState.setPermanentLockOut(this.mUserId, authenticator);
        goto L4
    L7:
        this.mMultiBiometricLockoutState.clearPermanentLockOut(this.mUserId, authenticator);
        this.mMultiBiometricLockoutState.clearTimedLockout(this.mUserId, authenticator);
        goto L4
    L16:
        if (this.mAuthOperations.isEmpty() == false) goto L30;
        this.mRingBuffer.addApiCall("internal : onAuthSessionEnded(" + this.mUserId + ")");
        clearSession();
        return;
    }

    private void clearSession() {
        this.mIsAuthenticating = false;
        this.mAuthOperations.clear();
    }

    public int getLockoutStateFor(int userId, int strength) {
        return this.mMultiBiometricLockoutState.getLockoutState(userId, strength);
    }

    @Override // com.android.server.biometrics.sensors.AuthSessionListener
    public void authStartedFor(int userId, int sensorId, long requestId) {
        this.mRingBuffer.addApiCall("authStartedFor(userId=" + userId + ", sensorId=" + sensorId + ", requestId=" + requestId + ")");
        if (this.mIsAuthenticating == true) goto L6;
        onAuthSessionStarted(userId);
    L6:
        if (this.mAuthOperations.contains(Integer.valueOf(sensorId)) == false) goto L10;
        Slog.e(TAG, "Error, authStartedFor(" + sensorId + ") without being finished");
        return;
    L10:
        if (this.mUserId == userId) goto L13;
        Slog.e(TAG, "Error authStartedFor(" + userId + ") Incorrect userId, expected" + this.mUserId + ", ignoring...");
        return;
    L13:
        this.mAuthOperations.add(Integer.valueOf(sensorId));
    }

    @Override // com.android.server.biometrics.sensors.AuthSessionListener
    public void lockedOutFor(int userId, int biometricStrength, int sensorId, long requestId) {
        String lockedOutStr = "lockOutFor(userId=" + userId + ", biometricStrength=" + biometricStrength + ", sensorId=" + sensorId + ", requestId=" + requestId + ")";
        this.mRingBuffer.addApiCall(lockedOutStr);
        this.mAuthResultCoordinator.lockedOutFor(biometricStrength);
        attemptToFinish(userId, sensorId, lockedOutStr);
    }

    @Override // com.android.server.biometrics.sensors.AuthSessionListener
    public void lockOutTimed(int userId, int biometricStrength, int sensorId, long time, long requestId) {
        String lockedOutStr = "lockOutTimedFor(userId=" + userId + ", biometricStrength=" + biometricStrength + ", sensorId=" + sensorId + "time=" + time + ", requestId=" + requestId + ")";
        this.mRingBuffer.addApiCall(lockedOutStr);
        this.mAuthResultCoordinator.lockOutTimed(biometricStrength);
        attemptToFinish(userId, sensorId, lockedOutStr);
    }

    @Override // com.android.server.biometrics.sensors.AuthSessionListener
    public void authEndedFor(int userId, int biometricStrength, int sensorId, long requestId, boolean wasSuccessful) {
        String authEndedStr = "authEndedFor(userId=" + userId + " ,biometricStrength=" + biometricStrength + ", sensorId=" + sensorId + ", requestId=" + requestId + ", wasSuccessful=" + wasSuccessful + ")";
        this.mRingBuffer.addApiCall(authEndedStr);
        if (wasSuccessful == false) goto L5;
        this.mAuthResultCoordinator.authenticatedFor(biometricStrength);
    L5:
        attemptToFinish(userId, sensorId, authEndedStr);
    }

    @Override // com.android.server.biometrics.sensors.AuthSessionListener
    public void resetLockoutFor(int userId, int biometricStrength, long requestId) {
        String resetLockStr = "resetLockoutFor(userId=" + userId + " ,biometricStrength=" + biometricStrength + ", requestId=" + requestId + ")";
        this.mRingBuffer.addApiCall(resetLockStr);
        if (biometricStrength != 15) goto L6;
        clearSession();
        this.mMultiBiometricLockoutState.clearPermanentLockOut(userId, biometricStrength);
        this.mMultiBiometricLockoutState.clearTimedLockout(userId, biometricStrength);
        return;
    }

    private void attemptToFinish(int userId, int sensorId, String description) {
        boolean didFail = false;
        if (this.mAuthOperations.contains(Integer.valueOf(sensorId)) == true) goto L6;
        Slog.e(TAG, "Error unable to find auth operation : " + description);
        didFail = true;
    L6:
        if (userId == this.mUserId) goto L8;
        Slog.e(TAG, "Error mismatched userId, expected=" + this.mUserId + " for " + description);
        didFail = true;
    L8:
        if (didFail == false) goto L10;
        return;
    L10:
        this.mAuthOperations.remove(Integer.valueOf(sensorId));
        if (this.mIsAuthenticating == false) goto L14;
        endAuthSession();
        return;
    }

    public String toString() {
        return this.mRingBuffer + "\n" + this.mMultiBiometricLockoutState;
    }
}
