package stepos.window;

import android.content.Context;
import android.provider.Settings;
import com.android.internal.chooser.QuickLookStrategy;
import com.stepos.settings.config.StepOSSettingsKeys;

/* loaded from: classes.dex */
public class WindowModeUtils {
    public static boolean isShareWithQuickLook(Context context, QuickLookStrategy quickLookStrategy) {
        return quickLookStrategy == QuickLookStrategy.FORCE_QUICK_LOOK || (quickLookStrategy == QuickLookStrategy.FOLLOW_SYSTEM && isShareWithQuickLook(context));
    }

    public static boolean isShareWithQuickLook(Context context) {
        return Settings.System.getInt(context.getContentResolver(), StepOSSettingsKeys.SYSTEM_WINDOW_MODE_SHARE_TO, 0) == 1;
    }

    public static void setShareWithQuickLook(Context context, boolean z) {
        Settings.System.putInt(context.getContentResolver(), StepOSSettingsKeys.SYSTEM_WINDOW_MODE_SHARE_TO, z ? 1 : 0);
    }
}
