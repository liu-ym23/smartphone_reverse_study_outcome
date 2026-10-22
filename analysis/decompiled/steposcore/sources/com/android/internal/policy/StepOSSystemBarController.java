package com.android.internal.policy;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.util.Singleton;
import com.android.internal.graphics.ColorUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import stepos.app.StepOSWindowManager;

/* loaded from: classes.dex */
public class StepOSSystemBarController {
    private static final String ALL_WINDOW = "*";
    private static final String ANDROID = "android";
    private static final int BOTH_BLACK = 3;
    private static final int BOTH_TRANSPARENT = 4;
    private static final int BOTH_WHITE = 0;
    public static final int COLO_BLACK = -16777216;
    public static final int COLO_WHITE = -1;
    private static final String COM_ANDROID = "com.android";
    private static final String COM_STEP = "com.stepos";
    public static final int DARK = -1;
    private static final int DARK_MODE = 1;
    public static final int LIGHT = 1;
    private static final int RV_DARK_MODE = 2;
    public static final int UNKNOWN = 0;
    public static final int WHITE = -1;
    private static final Singleton<StepOSSystemBarController> sInstance = new Singleton<StepOSSystemBarController>() { // from class: com.android.internal.policy.StepOSSystemBarController.1
        /* renamed from: create, reason: merged with bridge method [inline-methods] */
        public StepOSSystemBarController m483create() {
            return new StepOSSystemBarController();
        }
    };
    private final Map<String, StepOSColorBarInfo> mColorBarInfoMap;
    private boolean mFakeNighMode;
    private boolean mHasFetched;

    private StepOSSystemBarController() {
        this.mFakeNighMode = false;
        this.mColorBarInfoMap = new HashMap();
        this.mHasFetched = false;
    }

    private void ensureCached(Context context) {
        if (this.mHasFetched) {
            return;
        }
        boolean isSystemApp = true;
        this.mHasFetched = true;
        String pkg = context.getPackageName();
        if (pkg == null || pkg.startsWith(ANDROID) || pkg.startsWith(COM_STEP)) {
            return;
        }
        if (pkg.startsWith(COM_ANDROID)) {
            try {
                ApplicationInfo application = context.getApplicationInfo();
                if (application != null) {
                    if ((1 & application.flags) == 0) {
                        isSystemApp = false;
                    }
                }
            } catch (Throwable th) {
            }
            if (isSystemApp) {
                return;
            }
        }
        List<StepOSColorBarInfo> list = StepOSWindowManager.getInstance().getAllColorBarInfo(pkg);
        if (list == null) {
            return;
        }
        for (StepOSColorBarInfo info : list) {
            this.mColorBarInfoMap.put(info.className, info);
        }
    }

    public static StepOSSystemBarController getInstance() {
        return (StepOSSystemBarController) sInstance.get();
    }

    public boolean isOnlyDefault(String className, Context context) {
        ensureCached(context);
        StepOSColorBarInfo targetInfo = this.mColorBarInfoMap.get(className);
        StepOSColorBarInfo allWindow = this.mColorBarInfoMap.get(ALL_WINDOW);
        StepOSColorBarInfo validInfo = null;
        if (targetInfo != null) {
            validInfo = targetInfo;
        }
        if (validInfo == null && allWindow != null) {
            validInfo = allWindow;
        }
        if (validInfo != null) {
            return validInfo.defOnly;
        }
        return false;
    }

    public boolean isForceWindowDraw(String className, Context context) {
        ensureCached(context);
        StepOSColorBarInfo targetInfo = this.mColorBarInfoMap.get(className);
        StepOSColorBarInfo allWindow = this.mColorBarInfoMap.get(ALL_WINDOW);
        StepOSColorBarInfo validInfo = null;
        if (targetInfo != null) {
            validInfo = targetInfo;
        }
        if (validInfo == null && allWindow != null) {
            validInfo = allWindow;
        }
        if (validInfo != null) {
            return validInfo.windowDraw;
        }
        return false;
    }

    public boolean isNightMode(Context context) {
        if (isFakeDarkMode()) {
            return this.mFakeNighMode;
        }
        Configuration configuration = context.getResources().getConfiguration();
        int uiModeMask = configuration.uiMode & 48;
        return 32 == uiModeMask;
    }

    public Integer getStatusBarColor(String className, Context context) {
        ensureCached(context);
        boolean nightMode = isNightMode(context);
        StepOSColorBarInfo targetInfo = this.mColorBarInfoMap.get(className);
        StepOSColorBarInfo allWindow = this.mColorBarInfoMap.get(ALL_WINDOW);
        int statusState = -1;
        if (targetInfo != null) {
            statusState = targetInfo.statusBarColor;
        }
        if (statusState == -1 && allWindow != null) {
            statusState = allWindow.statusBarColor;
        }
        switch (statusState) {
            case 0:
                return -1;
            case 1:
                if (!nightMode) {
                    return -1;
                }
                return Integer.valueOf(COLO_BLACK);
            case 2:
                if (nightMode) {
                    return -1;
                }
                return Integer.valueOf(COLO_BLACK);
            case 3:
                return Integer.valueOf(COLO_BLACK);
            case 4:
                return 0;
            default:
                return null;
        }
    }

    public int getStatusBarFlag(String className, Context context) {
        ensureCached(context);
        boolean nightMode = isNightMode(context);
        StepOSColorBarInfo targetInfo = this.mColorBarInfoMap.get(className);
        StepOSColorBarInfo allWindow = this.mColorBarInfoMap.get(ALL_WINDOW);
        int statusState = -1;
        if (targetInfo != null) {
            statusState = targetInfo.statusBarColor;
        }
        if (statusState == -1 && allWindow != null) {
            statusState = allWindow.statusBarColor;
        }
        if (statusState > 10) {
            statusState -= 10;
        }
        switch (statusState) {
            case 1:
                if (!nightMode) {
                    break;
                }
                break;
            case 2:
                if (nightMode) {
                    break;
                }
                break;
        }
        return 1;
    }

    public Integer getNavigationBarColor(String className, Context context) {
        ensureCached(context);
        boolean nightMode = isNightMode(context);
        StepOSColorBarInfo targetInfo = this.mColorBarInfoMap.get(className);
        StepOSColorBarInfo allWindow = this.mColorBarInfoMap.get(ALL_WINDOW);
        Integer navBarColor = null;
        if (targetInfo != null) {
            if (nightMode) {
                navBarColor = targetInfo.colorNavBarDark;
            } else {
                navBarColor = targetInfo.colorNavBarLight;
            }
        }
        if (navBarColor == null && allWindow != null) {
            if (nightMode) {
                Integer navBarColor2 = allWindow.colorNavBarDark;
                return navBarColor2;
            }
            Integer navBarColor3 = allWindow.colorNavBarLight;
            return navBarColor3;
        }
        return navBarColor;
    }

    public boolean isForceFitsNavBar(String className) {
        StepOSColorBarInfo targetInfo = this.mColorBarInfoMap.get(className);
        return targetInfo != null && targetInfo.fitsNavBar;
    }

    public boolean isFakeDarkMode() {
        StepOSColorBarInfo allWindow = this.mColorBarInfoMap.get(ALL_WINDOW);
        return allWindow != null && allWindow.fakeDarkMode;
    }

    public void checkFakeDarkMode(Context context, int color) {
        if ((context instanceof Activity) && isFakeDarkMode()) {
            double luminance = ColorUtils.calculateLuminance(color);
            this.mFakeNighMode = luminance < 0.5d;
        }
    }
}
