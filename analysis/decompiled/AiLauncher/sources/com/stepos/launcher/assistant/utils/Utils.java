package com.stepos.launcher.assistant.utils;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;

/* loaded from: classes.dex */
public class Utils {
    public static final boolean ATLEAST_BAKLAVA;
    public static final boolean ATLEAST_S;
    private static final String CONFIG_OVERLAY_KEY = "launcher_overlay_pkg";
    private static final String TAG = "Utils";
    private static volatile Boolean sCachedAssistantEnabled;

    static {
        int i10 = Build.VERSION.SDK_INT;
        ATLEAST_S = true;
        ATLEAST_BAKLAVA = i10 >= 36;
    }

    public static int boundToRange(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i10, i12));
    }

    public static Context createThemeContext(Context context, int i10) {
        return i10 != -1 ? new ContextThemeWrapper(context, i10) : context;
    }

    public static int dip2px(float f10) {
        return (int) ((f10 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static ApplicationInfo getApplicationInfo(Context context, String str, UserHandle userHandle, int i10) throws PackageManager.NameNotFoundException {
        if (userHandle == null) {
            Log.d(TAG, "Null user found in getApplicationInfo");
            return null;
        }
        try {
            ApplicationInfo applicationInfo = ((LauncherApps) context.getSystemService(LauncherApps.class)).getApplicationInfo(str, i10, userHandle);
            if ((applicationInfo.flags & 8388608) != 0) {
                if (applicationInfo.enabled) {
                    return applicationInfo;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static String getAssistantPkg(Context context) {
        String string = Settings.Global.getString(context.getContentResolver(), CONFIG_OVERLAY_KEY);
        return TextUtils.isEmpty(string) ? "com.stepos.ailauncher" : string;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", UxipConstants.f30662a);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void invalidateAssistantEnableCache() {
        sCachedAssistantEnabled = null;
    }

    public static boolean isAppInstalled(Context context, String str, UserHandle userHandle) {
        return getApplicationInfo(context, str, userHandle, 0) != null;
    }

    public static boolean isAssistantEnable(Context context) {
        Boolean bool = sCachedAssistantEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zQueryAgentEnabled = queryAgentEnabled(context);
        sCachedAssistantEnabled = Boolean.valueOf(zQueryAgentEnabled);
        return zQueryAgentEnabled;
    }

    public static boolean isSystemApp(Context context, String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        if (str != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                    if ((applicationInfo.flags & 1) != 0) {
                        return true;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean isSystemWidgetInfo(Context context, AppWidgetProviderInfo appWidgetProviderInfo) {
        ComponentName componentName;
        if (appWidgetProviderInfo == null || (componentName = appWidgetProviderInfo.provider) == null) {
            return false;
        }
        return isSystemApp(context, componentName.getPackageName());
    }

    private static boolean queryAgentEnabled(Context context) {
        Boolean agentEnabledFromProvider = readAgentEnabledFromProvider(context);
        if (agentEnabledFromProvider != null) {
            return agentEnabledFromProvider.booleanValue();
        }
        return true;
    }

    private static Boolean readAgentEnabledFromProvider(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(AiLauncherStateContract.URI_AGENT_ENABLED, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        Boolean boolValueOf = Boolean.valueOf(cursorQuery.getInt(0) == 1);
                        cursorQuery.close();
                        return boolValueOf;
                    }
                } finally {
                }
            }
            Log.w(TAG, "readAgentEnabledFromProvider: empty cursor, default enabled");
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (SecurityException e10) {
            Log.w(TAG, "readAgentEnabledFromProvider: SecurityException, default enabled", e10);
            return null;
        } catch (RuntimeException e11) {
            Log.w(TAG, "readAgentEnabledFromProvider: query failed, default enabled", e11);
            return null;
        }
    }

    public static int dip2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
