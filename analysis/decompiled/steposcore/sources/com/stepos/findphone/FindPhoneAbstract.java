package com.stepos.findphone;

import android.content.Context;
import android.util.Log;
import com.stepos.service.find.FindPhoneData;

/* loaded from: classes.dex */
public class FindPhoneAbstract {
    public static final String FINDPHONE_LIMIT_TIME = "lockscreen.findphone_limit_time";
    public static final String FINDPHONE_LOCK_TIME_INTERVAL = "lockscreen.lock_time_interval";
    private static final String FIND_PHONE_CLASS_NAME = "com.stepos.findphone.FindPhoneUtils";
    public static final int MAX_LEFT_TIMES = 8;
    private static final String TAG = "FindPhoneAbstract";

    public static FindPhoneAbstract newInstance() {
        try {
            return (FindPhoneAbstract) Class.forName(FIND_PHONE_CLASS_NAME).newInstance();
        } catch (Exception e) {
            Log.w(TAG, "Failed to instantiate com.stepos.findphone.FindPhoneUtils, using default stub", e);
            return new FindPhoneAbstract();
        }
    }

    public static FindPhoneAbstract newFindphoneUtils() {
        return newInstance();
    }

    public void init(Context context) {
    }

    public boolean isFindPhoneLocked() {
        return false;
    }

    public int processLeftTimes(boolean reset) {
        return 8;
    }

    public void setCurrentUser(int userId) {
    }

    public int getCurrentUser() {
        return 0;
    }

    public void updateLimitedTime(FindPhoneData data) {
    }

    public long getLimitTime(long defaultTime) {
        return defaultTime;
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public long getDuration(long defaultDuration) {
        return defaultDuration;
    }
}
