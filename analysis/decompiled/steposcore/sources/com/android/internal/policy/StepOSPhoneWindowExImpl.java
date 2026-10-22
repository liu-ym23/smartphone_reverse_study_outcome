package com.android.internal.policy;

import android.app.ActivityThread;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.android.internal.graphics.ColorUtils;

/* loaded from: classes.dex */
public class StepOSPhoneWindowExImpl implements IStepOSPhoneWindowExt {
    private static final String TAG = "PhoneWindowExt";
    private PhoneWindow mPhoneWindow;
    private String mClassName = null;
    private Context mContext = null;
    private final StepOSSystemBarController mSystemBarController = StepOSSystemBarController.getInstance();

    public boolean hookDefaultNavBarLightFlag(boolean lightFlag) {
        Integer navBarColor = this.mSystemBarController.getNavigationBarColor(this.mClassName, this.mContext);
        if (navBarColor != null && Color.alpha(navBarColor.intValue()) != 0) {
            double luminance = ColorUtils.calculateLuminance(navBarColor.intValue());
            return luminance >= 0.5d;
        }
        return lightFlag;
    }

    public boolean hookDefaultStatusLightFlag(boolean lightFlag) {
        int statusColor = this.mSystemBarController.getStatusBarFlag(this.mClassName, this.mContext);
        if (statusColor != 0) {
            return statusColor == 1;
        }
        return lightFlag;
    }

    public void hookDefaultStatusBarColor(TypedArray typedArray) {
        Integer statusBarColor = this.mSystemBarController.getStatusBarColor(this.mClassName, this.mContext);
        if (statusBarColor != null) {
            if (ActivityThread.DEBUG_BAR_COLOR) {
                Log.d(TAG, "hookDefaultStatusBarColor class=" + this.mClassName + " hit=" + String.format("#%08X", statusBarColor) + " origin=" + String.format("#%08X", Integer.valueOf(this.mPhoneWindow.mStatusBarColor)));
            }
            this.mPhoneWindow.mStatusBarColor = statusBarColor.intValue();
        }
    }

    public void hookDefaultNavigationBarColor(TypedArray typedArray, int navBarDefaultColor) {
        this.mSystemBarController.checkFakeDarkMode(this.mContext, navBarDefaultColor);
        Integer navBarColor = this.mSystemBarController.getNavigationBarColor(this.mClassName, this.mContext);
        if (navBarColor != null) {
            if (ActivityThread.DEBUG_BAR_COLOR) {
                Log.d(TAG, "hookDefaultNavigationBarColor class=" + this.mClassName + " hit=" + String.format("#%08X", navBarColor) + " origin=" + String.format("#%08X", Integer.valueOf(this.mPhoneWindow.mNavigationBarColor)));
            }
            this.mPhoneWindow.mNavigationBarColor = navBarColor.intValue();
        }
    }

    public void updateNavigationBarColor(int color) {
        Integer navBarColor;
        this.mSystemBarController.checkFakeDarkMode(this.mContext, color);
        if (!this.mSystemBarController.isOnlyDefault(this.mClassName, this.mContext) && (navBarColor = this.mSystemBarController.getNavigationBarColor(this.mClassName, this.mContext)) != null) {
            if (ActivityThread.DEBUG_BAR_COLOR) {
                Log.d(TAG, "updateNavigationBarColor class=" + this.mClassName + " hit=" + String.format("#%08X", navBarColor) + " origin=" + String.format("#%08X", Integer.valueOf(this.mPhoneWindow.mNavigationBarColor)));
            }
            this.mPhoneWindow.mNavigationBarColor = navBarColor.intValue();
        }
    }

    public boolean forceWindowDraw() {
        return this.mSystemBarController.isForceWindowDraw(this.mClassName, this.mContext);
    }

    public void hookWindowBackground(Drawable drawable) {
        if (forceWindowDraw() && (drawable instanceof ColorDrawable)) {
            ColorDrawable colorDrawable = (ColorDrawable) drawable;
            Integer navBarColor = this.mSystemBarController.getNavigationBarColor(this.mClassName, this.mContext);
            if (navBarColor != null) {
                colorDrawable.setColor(navBarColor.intValue());
            }
        }
    }

    public void onAttach(PhoneWindow host) {
        this.mPhoneWindow = host;
        this.mContext = this.mPhoneWindow.getContext();
        this.mClassName = this.mContext.getClass().getName();
    }
}
