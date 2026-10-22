package com.android.internal.policy;

import android.content.Context;
import android.graphics.Paint;
import android.os.StepOSCtsUtils;
import android.util.Log;

/* loaded from: classes.dex */
public class StepOSDecorViewExImpl implements IStepOSDecorViewExt {
    private static final int MAX_HOOK_COUNT = 20;
    private static final String TAG = "IStepOSDecorViewExt";
    private PhoneWindow mPhoneWindow;
    private String mClassName = null;
    private Context mContext = null;
    private int hookVisibilityTime = 0;
    private final boolean mIsCtsState = StepOSCtsUtils.isCtsRunning();
    private final StepOSSystemBarController mSystemBarController = StepOSSystemBarController.getInstance();

    public void setLegacyNavBarPaintColor(Paint paint) {
        Integer color = getNavVarOverlayColor();
        paint.setColor(color != null ? color.intValue() : StepOSSystemBarController.COLO_BLACK);
    }

    public void onAttach(PhoneWindow phoneWindow) {
        this.mContext = phoneWindow.getContext();
        this.mPhoneWindow = phoneWindow;
        this.mClassName = this.mContext.getClass().getName();
    }

    public Integer getNavVarOverlayColor() {
        if (this.mContext == null && this.mClassName == null) {
            return null;
        }
        return this.mSystemBarController.getNavigationBarColor(this.mClassName, this.mContext);
    }

    public boolean isForceFitsNavBar() {
        return this.mSystemBarController.isForceFitsNavBar(this.mClassName);
    }

    public int hookSysVisibility(int visibility) {
        int flag;
        if ((this.mContext != null || this.mClassName != null) && (flag = this.mSystemBarController.getStatusBarFlag(this.mClassName, this.mContext)) != 0 && this.hookVisibilityTime < 20) {
            this.hookVisibilityTime++;
            Log.d(TAG, "hookSysVisibility hookVisibilityTime:" + this.hookVisibilityTime);
            return (visibility & (-8193)) | (flag == 1 ? 8192 : 0);
        }
        return visibility;
    }

    public int hookSemiTransparentBarColor(int originColor) {
        if (this.mIsCtsState) {
            return originColor;
        }
        return 0;
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if (hasWindowFocus) {
            this.mSystemBarController.checkFakeDarkMode(this.mContext, this.mPhoneWindow.mNavigationBarColor);
        }
    }
}
