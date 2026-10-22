package com.android.internal.chooser;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcelable;
import com.android.internal.chooser.utils.LogUtils;

/* loaded from: classes.dex */
public class IntentParser {
    public static final String KEY_CHECK_BOX_TEXT = "KEY_CHECK_BOX_TEXT";
    public static final String KEY_DISMISS_KEYGUARD = "KEY_DISMISS_KEYGUARD";
    public static final String KEY_EXCLUDE_COMPONENTS = "android.intent.extra.EXCLUDE_COMPONENTS";
    public static final String KEY_HIDE_STATUS_BAR_ON_LANDSCAPE = "KEY_NEED_HIDE_STATUS_BAR_ON_LANDSCAPE";
    public static final String KEY_HIDE_STATUS_BAR_ON_PORTRAIT = "KEY_HIDE_STATUS_BAR_ON_PORTRAIT";
    public static final String KEY_IS_CHECK_BOX_CHECKED = "KEY_IS_CHECK_BOX_CHECKED";
    public static final String KEY_IS_FORCE_KEEP = "KEY_IS_FORCE_KEEP";
    public static final String KEY_IS_NIGHT_MODE = "KEY_IS_NIGHT_MODE";
    public static final String KEY_IS_SHOW_CHECK_BOX = "KEY_IS_SHOW_CHECK_BOX";
    public static final String KEY_OPEN_WITH_QUICK_LOOK = "KEY_OPEN_WITH_QUICK_LOOK";
    public static final String KEY_SHOW_WHEN_LOCKED = "KEY_SHOW_WHEN_LOCKED";
    public static final String KEY_STEPOS_INTENT_SENDER = "KEY_STEPOS_INTENT_SENDER";
    public static final String KEY_STYLE_STATE = "KEY_STYLE_STATE";
    private static final int MAX_INITIAL_INTENTS = 2;
    private Intent mIntent;

    public IntentParser(Intent intent) {
        this.mIntent = intent;
        try {
            this.mIntent.getStringExtra("android.intent.extra.TITLE");
        } catch (Exception e) {
        }
    }

    public Intent getOriginIntent() {
        return this.mIntent;
    }

    public Intent getExtraIntent() {
        Parcelable targetParcelable = this.mIntent.getParcelableExtra("android.intent.extra.INTENT");
        if (!(targetParcelable instanceof Intent)) {
            LogUtils.w("Target is not an intent: " + targetParcelable);
            return null;
        }
        return (Intent) targetParcelable;
    }

    public String getTitle() {
        return this.mIntent.getStringExtra("android.intent.extra.TITLE");
    }

    public boolean isNightModeSet() {
        return this.mIntent.getExtras() != null && this.mIntent.getExtras().containsKey(KEY_IS_NIGHT_MODE);
    }

    public boolean isNightMode() {
        return this.mIntent.getBooleanExtra(KEY_IS_NIGHT_MODE, false);
    }

    public boolean isForceKeepNightMode() {
        return this.mIntent.getBooleanExtra(KEY_IS_FORCE_KEEP, false);
    }

    public int getStyleState() {
        return this.mIntent.getIntExtra(KEY_STYLE_STATE, 0);
    }

    public boolean isShowCheckBox() {
        return this.mIntent.getBooleanExtra(KEY_IS_SHOW_CHECK_BOX, false);
    }

    public boolean isCheckBoxChecked() {
        return this.mIntent.getBooleanExtra(KEY_IS_CHECK_BOX_CHECKED, false);
    }

    public String getCheckBoxText() {
        return this.mIntent.getStringExtra(KEY_CHECK_BOX_TEXT);
    }

    public boolean isHideStatusBarLandscape() {
        return this.mIntent.getBooleanExtra(KEY_HIDE_STATUS_BAR_ON_LANDSCAPE, false);
    }

    public boolean isHideStatusBarPortrait() {
        return this.mIntent.getBooleanExtra(KEY_HIDE_STATUS_BAR_ON_PORTRAIT, false);
    }

    public boolean showWhenLocked() {
        return this.mIntent.getBooleanExtra(KEY_SHOW_WHEN_LOCKED, false);
    }

    public boolean dismissKeyguard() {
        return this.mIntent.getBooleanExtra(KEY_DISMISS_KEYGUARD, false);
    }

    public Intent[] getInitialIntents() {
        return getInitialIntents(false);
    }

    public Intent[] getInitialIntents(boolean limit) {
        Parcelable[] pa = this.mIntent.getParcelableArrayExtra("android.intent.extra.INITIAL_INTENTS");
        if (pa == null) {
            return null;
        }
        int length = pa.length;
        if (limit && length > 2) {
            length = 2;
        }
        Intent[] initialIntents = new Intent[length];
        for (int i = 0; i < length; i++) {
            if (!(pa[i] instanceof Intent)) {
                LogUtils.w("Initial intent #" + i + " not an Intent: " + pa[i]);
                return null;
            }
            Intent in = (Intent) pa[i];
            initialIntents[i] = in;
        }
        return initialIntents;
    }

    public ComponentName[] getFilteredComponents() {
        Parcelable[] pa = this.mIntent.getParcelableArrayExtra(KEY_EXCLUDE_COMPONENTS);
        if (pa == null) {
            return null;
        }
        ComponentName[] names = new ComponentName[pa.length];
        for (int i = 0; i < pa.length; i++) {
            if (!(pa[i] instanceof ComponentName)) {
                LogUtils.w("Filtered component #" + i + " not a ComponentName: " + pa[i]);
                return null;
            }
            names[i] = (ComponentName) pa[i];
        }
        return names;
    }

    public IntentSender getIntentSender() {
        return (IntentSender) this.mIntent.getParcelableExtra(KEY_STEPOS_INTENT_SENDER);
    }

    public boolean isShowAllApp() {
        return this.mIntent.getBooleanExtra("isOpenAllSelect", false);
    }
}
