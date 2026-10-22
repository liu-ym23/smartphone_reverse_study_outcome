package android.content.res.stepostheme;

import android.content.res.Resources;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class StepOSLauncherAppsExtImpl implements IStepOSLauncherAppsExt {
    private static final String CTS_SHORTCUTMANAGER_PREFIX = "android.content.pm.cts.shortcutmanager";
    private static final String CTS_SHORTCUT_PACKAGE = "android.content.pm.cts.shortcut.upgrade";
    private static final float LEGACY_ICON_SCALE = 0.7f;
    private static final String[] SYSTEM_SHORTCUT_ICON_LIST = {"com.stepos.filemanager", "com.stepos.media.gallery", "com.android.settings", "com.android.alarmclock", "com.stepos.notepaper", "com.android.email", "com.android.calendar", "com.android.dialer", "com.stepos.media.camera", "com.android.mms", "com.android.browser", "com.stepos.weather", "com.stepos.safe", "com.stepos.media.music", "com.stepos.logreport", "com.stepos.toolbox"};
    private static final String TAG = "StepOSLauncherAppsExt";

    public Drawable onHandleShortCutIcon(String packageName, Resources res, Drawable drawable) {
        if (drawable == null || res == null || onShouldSkipTheming(packageName)) {
            return drawable;
        }
        if (packageName != null) {
            try {
                for (String systemPackageName : SYSTEM_SHORTCUT_ICON_LIST) {
                    if (TextUtils.equals(systemPackageName, packageName)) {
                        return StepOSThemeHelper.makeStandardStyleIconWithThemeStyle("type_system_shortcut_icon", res, drawable);
                    }
                }
            } catch (Exception e) {
                StepOSLogUtil.e("handleShortCutIcon error: " + e.getMessage());
                return drawable;
            }
        }
        if (!(drawable instanceof BitmapDrawable) && !(drawable instanceof AdaptiveIconDrawable)) {
            return addWhitePlateBehind(drawable);
        }
        return StepOSThemeHelper.makeStandardStyleIconWithThemeStyle("type_shortcut_icon", res, drawable);
    }

    private Drawable addWhitePlateBehind(Drawable drawable) {
        float extraInset = AdaptiveIconDrawable.getExtraInsetFraction();
        float contentFraction = LEGACY_ICON_SCALE / ((extraInset * 2.0f) + 1.0f);
        float inset = (1.0f - contentFraction) / 2.0f;
        return new AdaptiveIconDrawable(new ColorDrawable(-1), new InsetDrawable(drawable, inset, inset, inset, inset));
    }

    public boolean onShouldSkipTheming(String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        return TextUtils.equals(CTS_SHORTCUT_PACKAGE, packageName) || packageName.startsWith(CTS_SHORTCUTMANAGER_PREFIX);
    }
}
