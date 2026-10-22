package android.content.res.stepostheme;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.stepos.theme.IStepOSThemeService;
import java.io.File;

/* loaded from: classes.dex */
public class StepOSThemeManagerExtImpl implements IStepOSThemeManagerExt {
    private static final int DEFAULT_TRIAL_INTERVAL_MS = 0;
    private static final int DEFAULT_TRIAL_WAKEUP_COUNT = 1;
    private static final String STEPOS_THEME_SERVICE = "stepos_theme";
    private static final String TAG = "StepOSThemeManager";
    private String mFontTrialIntentAction;
    private String mTrialIntentAction;
    private String mTrialWakeUpType;
    private boolean mTrialWakeUpScheduled = false;
    private long mNextTrialWakeUpTime = -1;
    private boolean mFontTrialScheduled = false;
    private long mNextFontTrialTime = -1;
    private String mCurrentThemePackage = null;

    public void startWakeUpTrialService(String intentAction, String wakeUpType, long triggerTime) {
        IStepOSThemeService service = getThemeService();
        if (service == null) {
            Log.w(TAG, "startWakeUpTrialService: theme service unavailable, skipping");
            return;
        }
        try {
            service.startWakeUpTrialService(triggerTime, intentAction, 1, 0);
            this.mTrialIntentAction = intentAction;
            this.mTrialWakeUpType = wakeUpType;
            this.mNextTrialWakeUpTime = triggerTime;
            this.mTrialWakeUpScheduled = true;
            StepOSLogUtil.d("Scheduled trial wake-up: " + intentAction + " type=" + wakeUpType + " at " + triggerTime);
        } catch (RemoteException e) {
            Log.w(TAG, "startWakeUpTrialService RPC failed, local state not updated: " + e.getMessage());
        }
    }

    public void cancelWakeUpTrialService() {
        IStepOSThemeService service = getThemeService();
        if (service == null) {
            Log.w(TAG, "cancelWakeUpTrialService: theme service unavailable, skipping");
            return;
        }
        try {
            service.cancelWakeUpTrialService();
            this.mTrialWakeUpScheduled = false;
            this.mNextTrialWakeUpTime = -1L;
            this.mTrialIntentAction = null;
            this.mTrialWakeUpType = null;
            StepOSLogUtil.d("Cancelled trial wake-up service");
        } catch (RemoteException e) {
            Log.w(TAG, "cancelWakeUpTrialService RPC failed, local state not updated: " + e.getMessage());
        }
    }

    public boolean isTrialWakeUpScheduled() {
        return this.mTrialWakeUpScheduled && this.mNextTrialWakeUpTime > System.currentTimeMillis();
    }

    public long getNextTrialWakeUpTime() {
        if (this.mTrialWakeUpScheduled) {
            return this.mNextTrialWakeUpTime;
        }
        return -1L;
    }

    public void startFontWakeUpTrialService(String intentAction, long triggerTime) {
        IStepOSThemeService service = getThemeService();
        if (service == null) {
            Log.w(TAG, "startFontWakeUpTrialService: theme service unavailable, skipping");
            return;
        }
        try {
            service.startFontWakeUpTrialService(triggerTime, intentAction, 1, 0);
            this.mFontTrialIntentAction = intentAction;
            this.mNextFontTrialTime = triggerTime;
            this.mFontTrialScheduled = true;
            StepOSLogUtil.d("Scheduled font trial wake-up: " + intentAction + " at " + triggerTime);
        } catch (RemoteException e) {
            Log.w(TAG, "startFontWakeUpTrialService RPC failed, local state not updated: " + e.getMessage());
        }
    }

    public void cancelFontWakeUpTrialService() {
        IStepOSThemeService service = getThemeService();
        if (service == null) {
            Log.w(TAG, "cancelFontWakeUpTrialService: theme service unavailable, skipping");
            return;
        }
        try {
            service.cancelFontWakeUpTrialService();
            this.mFontTrialScheduled = false;
            this.mNextFontTrialTime = -1L;
            this.mFontTrialIntentAction = null;
            StepOSLogUtil.d("Cancelled font trial wake-up service");
        } catch (RemoteException e) {
            Log.w(TAG, "cancelFontWakeUpTrialService RPC failed, local state not updated: " + e.getMessage());
        }
    }

    public boolean isTrialFontAvailable() {
        String fontPath = IStepOSFontsHelperExt.get().getCurStepOSTypefacePath();
        if (fontPath != null) {
            File fontFile = new File(fontPath);
            return fontFile.exists();
        }
        return false;
    }

    public void createChangeWallpaper(String intentAction, String changeType, long triggerTime) {
        IStepOSWallpaperExt.get().createScheduledWallpaperChange(intentAction, changeType, triggerTime);
    }

    public void cancelChangeWallpaper() {
        IStepOSWallpaperExt.get().cancelScheduledWallpaperChange();
    }

    public boolean applyTheme(String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            return resetToDefaultTheme();
        }
        if (!isThemeValid(packageName)) {
            Log.w(TAG, "Theme package is not valid: " + packageName);
            return false;
        }
        this.mCurrentThemePackage = packageName;
        IStepOSConfigurationExt.get().setThemePackage(packageName);
        IStepOSConfigurationExt.get().incrementThemeVersion();
        StepOSLogUtil.d("Applied theme: " + packageName);
        return true;
    }

    public boolean resetToDefaultTheme() {
        this.mCurrentThemePackage = null;
        IStepOSConfigurationExt.get().setThemePackage((String) null);
        IStepOSConfigurationExt.get().incrementThemeVersion();
        StepOSLogUtil.d("Reset to default theme");
        return true;
    }

    public String getCurrentThemePackage() {
        if (this.mCurrentThemePackage != null) {
            return this.mCurrentThemePackage;
        }
        return IStepOSConfigurationExt.get().getThemePackage();
    }

    public boolean isThemeInstalled(String packageName) {
        String themePath;
        if (packageName == null || packageName.isEmpty() || (themePath = IStepOSThemeUtilsExt.get().getThemePath()) == null) {
            return false;
        }
        File themeDir = new File(themePath);
        return themeDir.exists() && themeDir.isDirectory();
    }

    public boolean isThemeValid(String packageName) {
        if (!isThemeInstalled(packageName)) {
            return false;
        }
        return true;
    }

    private static IStepOSThemeService getThemeService() {
        IBinder binder = ServiceManager.getService("stepos_theme");
        if (binder != null) {
            return IStepOSThemeService.Stub.asInterface(binder);
        }
        return null;
    }
}
