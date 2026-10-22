package com.android.server.biometrics;

import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class AuthenticationStats {
    private static final float FRR_NOT_ENOUGH_ATTEMPTS = -1.0f;
    private static final String TAG = "AuthenticationStats";
    private int mEnrollmentNotifications;
    private long mLastEnrollmentTime;
    private long mLastFrrNotificationTime;
    private final int mModality;
    private int mRejectedAttempts;
    private int mTotalAttempts;
    private final int mUserId;

    public AuthenticationStats(int userId, int totalAttempts, int rejectedAttempts, int enrollmentNotifications, long lastEnrollmentTime, long lastFrrNotificationTime, int modality) {
        this.mUserId = userId;
        this.mTotalAttempts = totalAttempts;
        this.mRejectedAttempts = rejectedAttempts;
        this.mEnrollmentNotifications = enrollmentNotifications;
        this.mLastEnrollmentTime = lastEnrollmentTime;
        this.mLastFrrNotificationTime = lastFrrNotificationTime;
        this.mModality = modality;
    }

    public AuthenticationStats(int userId, int modality) {
        this.mUserId = userId;
        this.mTotalAttempts = 0;
        this.mRejectedAttempts = 0;
        this.mEnrollmentNotifications = 0;
        this.mLastEnrollmentTime = 0;
        this.mLastFrrNotificationTime = 0;
        this.mModality = modality;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public int getTotalAttempts() {
        return this.mTotalAttempts;
    }

    public int getRejectedAttempts() {
        return this.mRejectedAttempts;
    }

    public int getEnrollmentNotifications() {
        return this.mEnrollmentNotifications;
    }

    public int getModality() {
        return this.mModality;
    }

    public long getLastEnrollmentTime() {
        return this.mLastEnrollmentTime;
    }

    public long getLastFrrNotificationTime() {
        return this.mLastFrrNotificationTime;
    }

    public float getFrr() {
        if (this.mTotalAttempts > 0) goto L5;
        return -1.0f;
    L5:
        return this.mRejectedAttempts / this.mTotalAttempts;
    }

    public void authenticate(boolean authenticated) {
        if (authenticated == true) goto L4;
        this.mRejectedAttempts++;
    L4:
        this.mTotalAttempts++;
    }

    public void resetData() {
        this.mTotalAttempts = 0;
        this.mRejectedAttempts = 0;
        Slog.d(TAG, "Reset Counters.");
    }

    public void updateNotificationCounter() {
        this.mEnrollmentNotifications++;
    }

    public void updateLastEnrollmentTime(long lastEnrollmentTime) {
        this.mLastEnrollmentTime = lastEnrollmentTime;
    }

    public void updateLastFrrNotificationTime(long lastFrrNotificationTime) {
        this.mLastFrrNotificationTime = lastFrrNotificationTime;
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof AuthenticationStats) == true) goto L8;
        return false;
    L8:
        AuthenticationStats target = (AuthenticationStats) obj;
        if (getUserId() != target.getUserId()) goto L24;
        if (getTotalAttempts() != target.getTotalAttempts()) goto L24;
        if (getRejectedAttempts() != target.getRejectedAttempts()) goto L24;
        if (getEnrollmentNotifications() != target.getEnrollmentNotifications()) goto L24;
        if (getLastEnrollmentTime() != target.getLastEnrollmentTime()) goto L24;
        if (getLastFrrNotificationTime() != target.getLastFrrNotificationTime()) goto L24;
        if (getModality() != target.getModality()) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return String.format("userId: %d, totalAttempts: %d, rejectedAttempts: %d, enrollmentNotifications: %d, modality: %d", new Object[]{Integer.valueOf(this.mUserId), Integer.valueOf(this.mTotalAttempts), Integer.valueOf(this.mRejectedAttempts), Integer.valueOf(this.mEnrollmentNotifications), Integer.valueOf(this.mModality)}).hashCode();
    }
}
