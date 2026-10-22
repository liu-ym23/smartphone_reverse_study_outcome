package stepos.inputmethod.sms;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import stepos.app.IStepOSWindowManager;
import stepos.app.StepOSWindowManager;
import stepos.inputmethod.sms.ISmsOtpCapsuleService;

/* loaded from: classes.dex */
public final class SmsOtpCapsuleManager {
    private static final String SERVICE_NAME = "sms_otp_capsule";
    private static final String TAG = "SmsOtpCapsuleManager";
    private static SmsOtpCapsuleManager sInstance;
    private final Context mContext;
    private ISmsOtpCapsuleService mService;

    public static synchronized SmsOtpCapsuleManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SmsOtpCapsuleManager(context.getApplicationContext());
        }
        return sInstance;
    }

    private SmsOtpCapsuleManager(Context context) {
        this.mContext = context;
    }

    private synchronized ISmsOtpCapsuleService getService() {
        IStepOSWindowManager wm;
        if (this.mService != null && this.mService.asBinder().isBinderAlive()) {
            return this.mService;
        }
        this.mService = null;
        try {
            try {
                try {
                    wm = StepOSWindowManager.getInstance().getService();
                } catch (RemoteException e) {
                    e = e;
                    Log.w(TAG, "getService", e);
                    return this.mService;
                }
            } catch (Throwable t) {
                Log.w(TAG, "getService: StepOSWindowManager not available", t);
            }
        } catch (RemoteException e2) {
            e = e2;
        }
        if (wm == null) {
            Log.w(TAG, "getService: StepOSWindowManager.getService() returned null");
            return null;
        }
        IBinder binder = wm.getSubService(SERVICE_NAME);
        if (binder == null) {
            Log.w(TAG, "getService: getSubService('sms_otp_capsule') returned null");
            return null;
        }
        this.mService = ISmsOtpCapsuleService.Stub.asInterface(binder);
        return this.mService;
    }

    public void show(CharSequence label, CharSequence code, int ttlSeconds, Icon icon) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "show: label=" + ((Object) label) + " code=" + ((Object) code) + " ttl=" + ttlSeconds + "s");
        }
        if (TextUtils.isEmpty(code)) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "show: empty code, dropped");
                return;
            }
            return;
        }
        if (ttlSeconds <= 0) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "show: non-positive ttl, dropped");
                return;
            }
            return;
        }
        ISmsOtpCapsuleService svc = getService();
        if (svc != null) {
            long expiry = SystemClock.elapsedRealtime() + (ttlSeconds * 1000);
            SmsOtp otp = new SmsOtp(label, code, expiry, icon);
            try {
                svc.show(otp);
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "show: IPC succeeded, expiry=" + expiry);
                    return;
                }
                return;
            } catch (RemoteException e) {
                Log.w(TAG, "show", e);
                this.mService = null;
                return;
            }
        }
        Log.w(TAG, "show: service is null, cannot deliver OTP");
    }

    public void clear() {
        ISmsOtpCapsuleService svc = getService();
        if (svc == null) {
            return;
        }
        try {
            svc.clear();
        } catch (RemoteException e) {
            Log.w(TAG, "clear", e);
            this.mService = null;
        }
    }
}
