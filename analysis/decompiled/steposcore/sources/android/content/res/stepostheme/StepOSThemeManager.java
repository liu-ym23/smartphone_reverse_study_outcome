package android.content.res.stepostheme;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.stepos.theme.IStepOSThemeService;

/* loaded from: classes.dex */
public class StepOSThemeManager {
    public static final String STEPOS_THEME_SERVICE = "stepos_theme";
    private static final String TAG = "StepOSThemeManager";
    private final boolean DEBUG = Build.IS_DEBUGGABLE;
    final Context mContext;
    private IStepOSThemeService mService;
    public static String STEPOS_THEME_TRAIL_SERVICE_WAKE_UP_INTENT = "stepos_theme_trail_service_wake_up_intent";
    public static String STEPOS_THEME_TRAIL_PACKAGENAME_EXTRA = "stepos_theme_trail_packagename";
    public static String STEPOS_THEME_TRAIL_START_TIME_EXTRA = "stepos_theme_trail_start_time";
    public static String STEPOS_FONT_TRAIL_SERVICE_WAKE_UP_INTENT = "stepos_font_trail_service_wake_up_intent";
    public static String STEPOS_FONT_TRAIL_PACKAGENAME_EXTRA = "stepos_font_trail_packagename";
    public static String STEPOS_FONT_TRAIL_START_TIME_EXTRA = "stepos_font_trail_start_time";
    public static String STEPOS_CUSTOMIZE_SCREEN_OFF_INTENT = "stepos_customize_screen_off_intent";
    public static String IS_NEED_SEND_CC_SCREEN_OFF_BROADCAST = StepOSScreenOffManager.IS_NEED_SEND_CC_SCREEN_OFF_BROADCAST;
    public static String LAST_TIME_SEND_CC_SCREEN_OFF_BROADCAST = StepOSScreenOffManager.LAST_TIME_SEND_CC_SCREEN_OFF_BROADCAST;
    public static String SEND_CC_SCREEN_OFF_BROADCAST_MIN_TIME_INTERVAL = StepOSScreenOffManager.SEND_CC_SCREEN_OFF_BROADCAST_MIN_TIME_INTERVAL;

    public StepOSThemeManager(Context context, IStepOSThemeService service) {
        this.mContext = context;
        this.mService = service;
    }

    public StepOSThemeManager(Context context) {
        IBinder b = ServiceManager.getService(STEPOS_THEME_SERVICE);
        if (b != null) {
            this.mService = IStepOSThemeService.Stub.asInterface(b);
        }
        this.mContext = context;
    }

    public void startWakeUpTrialService(long startTime, String packageName, int wakeUpCount, int intervalTime) {
        RemoteException e;
        if (this.mService == null) {
            Log.w(TAG, "StepOSThemeService not running");
            return;
        }
        try {
        } catch (RemoteException e2) {
            e = e2;
        }
        try {
            this.mService.startWakeUpTrialService(startTime, packageName, wakeUpCount, intervalTime);
        } catch (RemoteException e3) {
            e = e3;
            e.printStackTrace();
        }
    }

    public void cancelWakeUpTrialService() {
        if (this.mService == null) {
            Log.w(TAG, "StepOSThemeService not running");
            return;
        }
        try {
            this.mService.cancelWakeUpTrialService();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public void createChangeWallpaper(String intentName, String changeType, long sendTime) {
        if (this.mService == null) {
            Log.w(TAG, "StepOSThemeService not running");
            return;
        }
        try {
            this.mService.createChangeWallpaper(intentName, changeType, sendTime);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public void cancelChangeWallpaper() {
        if (this.mService == null) {
            Log.w(TAG, "StepOSThemeService not running");
            return;
        }
        try {
            this.mService.cancelChangeWallpaper();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void startFontWakeUpTrialService(long startTime, String fontPackageName, int wakeUpCount, int intervalTime) {
        RemoteException e;
        if (this.mService == null) {
            Log.w(TAG, "StepOSThemeService not running");
            return;
        }
        try {
        } catch (RemoteException e2) {
            e = e2;
        }
        try {
            this.mService.startFontWakeUpTrialService(startTime, fontPackageName, wakeUpCount, intervalTime);
        } catch (RemoteException e3) {
            e = e3;
            e.printStackTrace();
        }
    }

    public void cancelFontWakeUpTrialService() {
        if (this.mService == null) {
            Log.w(TAG, "StepOSThemeService not running");
            return;
        }
        try {
            this.mService.cancelFontWakeUpTrialService();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean isTrialFontAvailable() {
        if (this.mService == null) {
            Log.w(TAG, "StepOSThemeService not running");
            return false;
        }
        try {
            return this.mService.isTrialFontAvailable();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
