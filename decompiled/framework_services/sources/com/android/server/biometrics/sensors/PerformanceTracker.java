package com.android.server.biometrics.sensors;

import android.util.SparseArray;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class PerformanceTracker {
    private static final String TAG = "PerformanceTracker";
    private static final ConcurrentHashMap<Integer, PerformanceTracker> sTrackers = null;
    private final SparseArray<Info> mAllUsersInfo;
    private int mHALDeathCount;

    private static class Info {
        int mAccept;
        int mAcceptCrypto;
        int mAcquire;
        int mAcquireCrypto;
        int mPermanentLockout;
        int mReject;
        int mRejectCrypto;
        int mTimedLockout;

        /* synthetic */ Info(PerformanceTrackerIA r1) {
            this();
        }

        private Info() {
        }
    }

    static {
        sTrackers = new ConcurrentHashMap();
    }

    public static PerformanceTracker getInstanceForSensorId(int sensorId) {
        PerformanceTracker tracker = sTrackers.putIfAbsent(Integer.valueOf(sensorId), new PerformanceTracker());
        if (tracker == null) goto L6;
        return tracker;
    L6:
        return sTrackers.get(Integer.valueOf(sensorId));
    }

    private PerformanceTracker() {
        this.mAllUsersInfo = new SparseArray();
    }

    private void createUserEntryIfNecessary(int userId) {
        if (this.mAllUsersInfo.contains(userId) == true) goto L6;
        this.mAllUsersInfo.put(userId, new Info(null));
        return;
    }

    public void incrementAuthForUser(int userId, boolean accepted) {
        createUserEntryIfNecessary(userId);
        if (accepted == false) goto L5;
        this.mAllUsersInfo.get(userId).mAccept++;
        return;
    L5:
        this.mAllUsersInfo.get(userId).mReject++;
    }

    void incrementCryptoAuthForUser(int userId, boolean accepted) {
        createUserEntryIfNecessary(userId);
        if (accepted == false) goto L5;
        this.mAllUsersInfo.get(userId).mAcceptCrypto++;
        return;
    L5:
        this.mAllUsersInfo.get(userId).mRejectCrypto++;
    }

    public void incrementAcquireForUser(int userId, boolean isCrypto) {
        createUserEntryIfNecessary(userId);
        if (isCrypto == false) goto L5;
        this.mAllUsersInfo.get(userId).mAcquireCrypto++;
        return;
    L5:
        this.mAllUsersInfo.get(userId).mAcquire++;
    }

    public void incrementTimedLockoutForUser(int userId) {
        createUserEntryIfNecessary(userId);
        this.mAllUsersInfo.get(userId).mTimedLockout++;
    }

    public void incrementPermanentLockoutForUser(int userId) {
        createUserEntryIfNecessary(userId);
        this.mAllUsersInfo.get(userId).mPermanentLockout++;
    }

    public void incrementHALDeathCount() {
        this.mHALDeathCount++;
    }

    public void clear() {
        this.mAllUsersInfo.clear();
        this.mHALDeathCount = 0;
    }

    public int getAcceptForUser(int userId) {
        if (this.mAllUsersInfo.contains(userId) == true) goto L7;
        return 0;
    L7:
        return this.mAllUsersInfo.get(userId).mAccept;
    }

    public int getRejectForUser(int userId) {
        if (this.mAllUsersInfo.contains(userId) == true) goto L7;
        return 0;
    L7:
        return this.mAllUsersInfo.get(userId).mReject;
    }

    public int getAcquireForUser(int userId) {
        if (this.mAllUsersInfo.contains(userId) == true) goto L7;
        return 0;
    L7:
        return this.mAllUsersInfo.get(userId).mAcquire;
    }

    public int getAcceptCryptoForUser(int userId) {
        if (this.mAllUsersInfo.contains(userId) == true) goto L7;
        return 0;
    L7:
        return this.mAllUsersInfo.get(userId).mAcceptCrypto;
    }

    public int getRejectCryptoForUser(int userId) {
        if (this.mAllUsersInfo.contains(userId) == true) goto L7;
        return 0;
    L7:
        return this.mAllUsersInfo.get(userId).mRejectCrypto;
    }

    public int getAcquireCryptoForUser(int userId) {
        if (this.mAllUsersInfo.contains(userId) == true) goto L7;
        return 0;
    L7:
        return this.mAllUsersInfo.get(userId).mAcquireCrypto;
    }

    public int getTimedLockoutForUser(int userId) {
        if (this.mAllUsersInfo.contains(userId) == true) goto L7;
        return 0;
    L7:
        return this.mAllUsersInfo.get(userId).mTimedLockout;
    }

    public int getPermanentLockoutForUser(int userId) {
        if (this.mAllUsersInfo.contains(userId) == true) goto L7;
        return 0;
    L7:
        return this.mAllUsersInfo.get(userId).mPermanentLockout;
    }

    public int getHALDeathCount() {
        return this.mHALDeathCount;
    }
}
