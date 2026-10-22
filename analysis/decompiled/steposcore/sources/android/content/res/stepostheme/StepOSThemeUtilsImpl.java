package android.content.res.stepostheme;

import android.app.ActivityThread;
import android.app.Application;
import android.content.ContentResolver;
import android.content.pm.ApplicationInfo;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.StepOSCtsUtils;
import android.os.StrictMode;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

/* loaded from: classes.dex */
public class StepOSThemeUtilsImpl implements IStepOSThemeUtilsExt {
    private static final String ICON_WHITE_LIST_PREFIX = "com.stepos";
    private static volatile boolean sCachedIsUsingTheme;
    private static volatile String sCachedThemePath;
    private static volatile boolean sIconStyleObserverRegistered;
    private static volatile boolean sIsUsingThemeCached;
    private static volatile int sIsUsingThemeToken;
    private static volatile int sThemePathToken;
    private static final String[] WHITE_LIST = {"com.rsupport.rs.activity.stepos"};
    private static final String[] BLACK_LIST = {"com.stepos.watch", "com.stepos.speaker", "com.stepos.meijia", "com.stepos.router", "com.baidu.BaiduMap.stepos"};
    private static final String[] BLACK_PREFIX_LIST = {"com.stepos.smart."};
    private static volatile int sCachedIconStyle = 0;

    public int getResType(String resPackageName) {
        if (TextUtils.equals(resPackageName, "android")) {
            return 1;
        }
        if (TextUtils.equals(resPackageName, "stepos")) {
            return 2;
        }
        return 0;
    }

    public boolean isInWhiteList(ApplicationInfo appInfo) {
        if (appInfo == null || TextUtils.isEmpty(appInfo.packageName) || isInBlackListInternal(appInfo.packageName)) {
            return false;
        }
        if ((appInfo.flags & 1) != 0 || appInfo.packageName.startsWith(ICON_WHITE_LIST_PREFIX)) {
            return true;
        }
        for (String name : WHITE_LIST) {
            if (TextUtils.equals(name, appInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBlackListInternal(String packageName) {
        for (String prefix : BLACK_PREFIX_LIST) {
            if (packageName.startsWith(prefix)) {
                return true;
            }
        }
        for (String name : BLACK_LIST) {
            if (TextUtils.equals(packageName, name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isUseStepOSTheme() {
        return isUseStepOSThemeStatic();
    }

    public boolean isUseCustomizeTheme() {
        return isUseCustomizeThemeStatic();
    }

    public boolean isUseCustomSystem() {
        return isUseCustomSystemStatic();
    }

    public boolean isAppUsingTheme(String packageName) {
        File appThemeModuleFile = new File(getThemePathStatic() + packageName);
        return appThemeModuleFile.exists();
    }

    public boolean isUsingTheme() {
        return isUsingThemeStatic();
    }

    public boolean isInCTSState() {
        return isInCTSStateStatic();
    }

    public String getThemePath() {
        return getThemePathStatic();
    }

    public int getIconColor() {
        return getIconColorStatic();
    }

    public String getCornerSize() {
        return getCornerSizeStatic();
    }

    public float getForegroundScale() {
        return getForegroundScaleStatic();
    }

    public boolean isUseStepOSThemeStatic() {
        return true;
    }

    public boolean isUseCustomizeThemeStatic() {
        return true;
    }

    public boolean isUseCustomSystemStatic() {
        boolean ret = false;
        boolean shouldIgnore = ActivityThread.currentActivityThread() != null;
        StrictMode.ThreadPolicy oldPolicy = null;
        if (shouldIgnore) {
            oldPolicy = StrictMode.allowThreadDiskReads();
        }
        try {
            File custom = new File("/data/data/com.stepos.customizecenter/custom_flag/no_custom");
            ret = true ^ custom.exists();
        } catch (Exception e) {
            if (shouldIgnore) {
            }
        } catch (Throwable th) {
            if (shouldIgnore) {
                StrictMode.setThreadPolicy(oldPolicy);
            }
            throw th;
        }
        if (shouldIgnore) {
            StrictMode.setThreadPolicy(oldPolicy);
        }
        return ret;
    }

    public boolean isUsingThemeStatic() {
        int token = StepOSThemeResourceManager.getInstance().getThemeChanged();
        if (sIsUsingThemeCached && token == sIsUsingThemeToken) {
            return sCachedIsUsingTheme;
        }
        boolean isUsingTheme = false;
        boolean shouldIgnore = ActivityThread.currentActivityThread() != null;
        StrictMode.ThreadPolicy oldPolicy = null;
        if (shouldIgnore) {
            oldPolicy = StrictMode.allowThreadDiskReads();
        }
        File iconFile = new File(getThemePathStatic());
        String[] files = iconFile.list();
        if (iconFile.exists() && files != null && files.length > 0) {
            isUsingTheme = true;
        }
        if (shouldIgnore) {
            StrictMode.setThreadPolicy(oldPolicy);
        }
        sCachedIsUsingTheme = isUsingTheme;
        sIsUsingThemeToken = token;
        sIsUsingThemeCached = true;
        return isUsingTheme;
    }

    public boolean isInCTSStateStatic() {
        return StepOSCtsUtils.isCtsRunning();
    }

    public String getThemePathStatic() {
        String themePath;
        int token = StepOSThemeResourceManager.getInstance().getThemeChanged();
        String cached = sCachedThemePath;
        if (cached != null && token == sThemePathToken) {
            return cached;
        }
        boolean shouldIgnore = ActivityThread.currentActivityThread() != null;
        StrictMode.ThreadPolicy oldPolicy = null;
        if (shouldIgnore) {
            oldPolicy = StrictMode.allowThreadDiskReads();
        }
        File theme = new File("data/customizecenter/theme");
        if (theme.exists()) {
            themePath = "data/customizecenter/theme/";
        } else {
            themePath = "data/data/com.stepos.customizecenter/theme/";
        }
        if (shouldIgnore) {
            StrictMode.setThreadPolicy(oldPolicy);
        }
        sCachedThemePath = themePath;
        sThemePathToken = token;
        return themePath;
    }

    public int getIconColorStatic() {
        Application application = ActivityThread.currentApplication();
        if (application == null) {
            return 0;
        }
        ContentResolver cr = application.getContentResolver();
        return Settings.System.getInt(cr, "current_launcher_icon_color", 0);
    }

    public int getIconStyle() {
        ensureIconStyleObserver();
        Application application = ActivityThread.currentApplication();
        if (application == null) {
            return 0;
        }
        return Settings.System.getInt(application.getContentResolver(), "current_launcher_icon_style", 0);
    }

    private void ensureIconStyleObserver() {
        Application application;
        if (sIconStyleObserverRegistered || (application = ActivityThread.currentApplication()) == null) {
            return;
        }
        synchronized (StepOSThemeUtilsImpl.class) {
            if (sIconStyleObserverRegistered) {
                return;
            }
            final ContentResolver cr = application.getContentResolver();
            ContentObserver observer = new ContentObserver(this, new Handler(Looper.getMainLooper())) { // from class: android.content.res.stepostheme.StepOSThemeUtilsImpl.1
                @Override // android.database.ContentObserver
                public void onChange(boolean selfChange) {
                    StepOSThemeUtilsImpl.sCachedIconStyle = Settings.System.getInt(cr, "current_launcher_icon_style", 0);
                    StepOSThemeHelper.resetLauncherConfig();
                }
            };
            cr.registerContentObserver(Settings.System.getUriFor("current_launcher_icon_style"), false, observer);
            sCachedIconStyle = Settings.System.getInt(cr, "current_launcher_icon_style", 0);
            sIconStyleObserverRegistered = true;
        }
    }

    public String getCornerSizeStatic() {
        Application application = ActivityThread.currentApplication();
        if (application == null) {
            return "corner_size_3";
        }
        ContentResolver cr = application.getContentResolver();
        String cornerSize = Settings.System.getString(cr, "current_launcher_icon_corner_size");
        return cornerSize != null ? cornerSize : "corner_size_3";
    }

    public float getForegroundScaleStatic() {
        Application application = ActivityThread.currentApplication();
        if (application == null) {
            return 1.0f;
        }
        ContentResolver cr = application.getContentResolver();
        return Settings.System.getFloat(cr, "current_launcher_icon_content_size", 1.0f);
    }

    public boolean isColorManagementEnabled() {
        return SystemProperties.getBoolean("persist.sys.stepos.color_management", false);
    }

    public boolean isPoleStarTheme() {
        try {
            boolean isPoleStarTheme = SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
            return isPoleStarTheme;
        } catch (IllegalArgumentException e) {
            Log.e("StepOSAlertController", "get ro.stepos.build.channel error");
            return false;
        }
    }
}
