package com.stepos.findphone;

import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextExt;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.android.internal.widget.ILockSettings;
import com.stepos.service.find.FindPhoneData;
import stepos.app.IStepOSLockSettings;
import stepos.os.IDeviceStateService;

/* loaded from: classes.dex */
public class FindPhoneUtils extends FindPhoneAbstract {
    private static final int REMOTE_HANDLE_LOCK = 3;
    private static final String TAG = "FindPhoneUtils";
    private static int sCurrentUserId = -10000;
    private Context mContext;
    private IDeviceStateService mDeviceStateService;

    @Override // com.stepos.findphone.FindPhoneAbstract
    public void init(Context context) {
        this.mContext = context;
        try {
            IBinder binder = ServiceManager.getService(ContextExt.DEVICE_STATE_SERVICE);
            if (binder == null) {
                Log.w(TAG, "device_states service not available");
            } else {
                this.mDeviceStateService = IDeviceStateService.Stub.asInterface(binder);
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to connect to device_states service", e);
        }
    }

    @Override // com.stepos.findphone.FindPhoneAbstract
    public boolean isFindPhoneLocked() {
        if (this.mDeviceStateService == null) {
            Log.w(TAG, "isFindPhoneLocked: device_states service unavailable");
            return false;
        }
        try {
            return this.mDeviceStateService.doCheckState(3) == 1;
        } catch (RemoteException e) {
            Log.e(TAG, "isFindPhoneLocked: remote call failed", e);
            return false;
        }
    }

    @Override // com.stepos.findphone.FindPhoneAbstract
    public int processLeftTimes(boolean reset) {
        try {
            IBinder binder = ServiceManager.getService("lock_settings");
            if (binder == null) {
                Log.w(TAG, "processLeftTimes: lock_settings service unavailable");
                return 8;
            }
            IBinder extension = binder.getExtension();
            if (extension == null) {
                Log.w(TAG, "processLeftTimes: lock_settings extension unavailable");
                return 8;
            }
            IStepOSLockSettings lockSettings = IStepOSLockSettings.Stub.asInterface(extension);
            return lockSettings.stepOSProcessLeftTimes(reset);
        } catch (RemoteException e) {
            Log.e(TAG, "processLeftTimes: remote call failed", e);
            return 8;
        }
    }

    @Override // com.stepos.findphone.FindPhoneAbstract
    public void setCurrentUser(int userId) {
        sCurrentUserId = userId;
    }

    @Override // com.stepos.findphone.FindPhoneAbstract
    public int getCurrentUser() {
        if (sCurrentUserId != -10000) {
            return sCurrentUserId;
        }
        return ActivityManager.getCurrentUser();
    }

    @Override // com.stepos.findphone.FindPhoneAbstract
    public void updateLimitedTime(FindPhoneData data) {
        if (data == null) {
            return;
        }
        int errorCode = data.mCode;
        long duration = data.mDuration;
        Log.d(TAG, "updateLimitedTime: code=" + errorCode + ", duration=" + duration + ", count=" + data.mCount);
        if (errorCode == 4 && duration > 0) {
            long limitTime = getLong(FindPhoneAbstract.FINDPHONE_LIMIT_TIME, 0L);
            long lastDuration = getLong(FindPhoneAbstract.FINDPHONE_LOCK_TIME_INTERVAL, 0L);
            long now = getCurrentTime();
            if (limitTime == 0 || now - limitTime > 60 * lastDuration * 1000) {
                setLong(FindPhoneAbstract.FINDPHONE_LIMIT_TIME, now);
                setLong(FindPhoneAbstract.FINDPHONE_LOCK_TIME_INTERVAL, duration);
                return;
            }
            return;
        }
        if (errorCode == 1 || errorCode == 4) {
            setLong(FindPhoneAbstract.FINDPHONE_LIMIT_TIME, 0L);
            setLong(FindPhoneAbstract.FINDPHONE_LOCK_TIME_INTERVAL, 0L);
        }
    }

    @Override // com.stepos.findphone.FindPhoneAbstract
    public long getLimitTime(long defaultTime) {
        return getLong(FindPhoneAbstract.FINDPHONE_LIMIT_TIME, defaultTime);
    }

    @Override // com.stepos.findphone.FindPhoneAbstract
    public long getDuration(long defaultDuration) {
        return getLong(FindPhoneAbstract.FINDPHONE_LOCK_TIME_INTERVAL, defaultDuration);
    }

    private ILockSettings getLockSettings() {
        IBinder binder = ServiceManager.getService("lock_settings");
        if (binder == null) {
            return null;
        }
        return ILockSettings.Stub.asInterface(binder);
    }

    private long getLong(String key, long defaultValue) {
        try {
            ILockSettings ls = getLockSettings();
            if (ls != null) {
                return ls.getLong(key, defaultValue, getCurrentUser());
            }
        } catch (RemoteException e) {
            Log.e(TAG, "getLong failed for " + key, e);
        }
        return defaultValue;
    }

    private void setLong(String key, long value) {
        try {
            ILockSettings ls = getLockSettings();
            if (ls != null) {
                ls.setLong(key, value, getCurrentUser());
            }
        } catch (RemoteException e) {
            Log.e(TAG, "setLong failed for " + key, e);
        }
    }
}
