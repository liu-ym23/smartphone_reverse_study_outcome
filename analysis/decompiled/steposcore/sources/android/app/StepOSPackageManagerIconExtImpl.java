package android.app;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.res.Resources;
import android.content.res.stepostheme.IStepOSThemeUtilsExt;
import android.content.res.stepostheme.StepOSThemeHelper;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

/* loaded from: classes.dex */
public class StepOSPackageManagerIconExtImpl implements IStepOSPackageManagerIconExt {
    private static final String TAG = "StepOSPkgMgrIcon";

    public boolean shouldSkipIconCache(String packageName) {
        return "com.android.calendar".equals(packageName);
    }

    public Drawable getThemeDrawable(String packageName, int resId, ApplicationInfo appInfo, Resources resources) {
        Drawable dr;
        if (!StepOSThemeHelper.isStepOSIconEnable()) {
            return null;
        }
        if (appInfo != null) {
            try {
                if (appInfo.icon != resId) {
                    return null;
                }
            } catch (Resources.NotFoundException e) {
                Log.w(TAG, "Failure retrieving resources for " + appInfo.packageName + ": " + e.getMessage());
                return null;
            } catch (RuntimeException e2) {
                Log.w(TAG, "Failure retrieving icon 0x" + Integer.toHexString(resId) + " in package " + packageName, e2);
                return null;
            }
        }
        if ("com.android.calendar".equals(packageName) && StepOSThemeHelper.isStepOSCalendarIconEnabled()) {
            dr = StepOSThemeHelper.getCalendarIcon();
        } else {
            dr = StepOSThemeHelper.getCustomIcon(packageName);
            if (dr != null && StepOSThemeHelper.isStepOSIcon(packageName)) {
                dr = StepOSThemeHelper.makeThemeIcon(resources, dr, appInfo, true);
            }
        }
        if (dr != null && !IStepOSThemeUtilsExt.get().isAppUsingTheme("icons") && (dr instanceof BitmapDrawable)) {
            String iconName = appInfo != null ? appInfo.packageName : packageName;
            Drawable wrapped = StepOSThemeHelper.makeStandardStyleIcon(iconName, resources, dr);
            if (wrapped != null) {
                return wrapped;
            }
            return dr;
        }
        return dr;
    }

    public Drawable applyThemeIcon(Resources res, Drawable srcDrawable, ApplicationInfo appInfo, boolean isForceCut) {
        if (appInfo == null || srcDrawable == null || !StepOSThemeHelper.isStepOSIconEnable()) {
            return srcDrawable;
        }
        Drawable dr = srcDrawable;
        try {
            if ("com.android.calendar".equals(appInfo.packageName) && StepOSThemeHelper.isStepOSCalendarIconEnabled()) {
                Drawable dr2 = StepOSThemeHelper.addDateToIcon((Drawable) null);
                dr = StepOSThemeHelper.addDayOfWeekToIcon(dr2);
            } else if ("android.content.cts".equals(appInfo.packageName)) {
                return srcDrawable;
            }
            Drawable themed = StepOSThemeHelper.makeThemeIcon(isForceCut, res, dr, appInfo);
            if (themed != null) {
                dr = themed;
            }
            if (dr instanceof BitmapDrawable) {
                BitmapDrawable maskDr = StepOSThemeHelper.makeMaskForActivityIcon(res, ((BitmapDrawable) dr).getBitmap(), appInfo);
                if (maskDr != null) {
                    return maskDr;
                }
                return dr;
            }
            return dr;
        } catch (Exception e) {
            Log.w(TAG, "Error applying theme icon for " + appInfo.packageName, e);
            return srcDrawable;
        }
    }

    public Drawable applyActivityIconMask(Resources res, Drawable srcDrawable, ApplicationInfo appInfo, String packageName) {
        if (!(srcDrawable instanceof BitmapDrawable) || !StepOSThemeHelper.isStepOSIconEnable() || isPackageInMaskBlocklist(packageName)) {
            return srcDrawable;
        }
        try {
            BitmapDrawable masked = StepOSThemeHelper.makeMaskForActivityIcon(res, ((BitmapDrawable) srcDrawable).getBitmap(), appInfo);
            return masked != null ? masked : srcDrawable;
        } catch (Exception e) {
            Log.w(TAG, "Error applying activity icon mask for " + packageName, e);
            return srcDrawable;
        }
    }

    private static boolean isPackageInMaskBlocklist(String packageName) {
        return false;
    }

    public Drawable loadThemedItemIcon(PackageItemInfo itemInfo, ApplicationInfo appInfo) {
        Drawable dr;
        if (!StepOSThemeHelper.isStepOSIconEnable()) {
            return null;
        }
        if ("com.android.calendar".equals(itemInfo.packageName) && StepOSThemeHelper.isStepOSCalendarIconEnabled() && (dr = StepOSThemeHelper.getCalendarIcon()) != null) {
            return dr;
        }
        if (itemInfo.packageName == null || appInfo == null) {
            return null;
        }
        return StepOSThemeHelper.getThemeIconForPackage(itemInfo.packageName, appInfo);
    }

    public Drawable processLoadedIcon(Drawable dr, ApplicationInfo appInfo, Resources res) {
        if (dr == null || appInfo == null || !StepOSThemeHelper.isStepOSIconEnable()) {
            return dr;
        }
        return StepOSThemeHelper.processIconDrawable(dr, appInfo, res);
    }
}
