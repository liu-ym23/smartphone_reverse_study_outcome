package com.android.server.policy;

import android.content.Context;
import android.content.res.CompatibilityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import com.android.internal.policy.PhoneWindow;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneWindowManagerSmtBase {
    static final int LONG_PRESS_HOME_RECENT_SYSTEM_UI = 1;
    static final String TAG = "WindowManager";
    static final GradientDrawable mStartingWindowBg = null;
    protected Handler mHandler;
    protected PhoneWindowManager mPhoneWindowManager;

    public PhoneWindowManagerSmtBase(PhoneWindowManager manager, Handler handler) {
        this.mPhoneWindowManager = manager;
        this.mHandler = handler;
    }

    static {
        mStartingWindowBg = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1513240, -855310});
    }

    protected void handleCustomizedBytedanceStatusBar(String packageName) {
    }

    protected View handleTntMode(Context context, CompatibilityInfo compatInfo, Bitmap bm, PhoneWindow win, WindowManager.LayoutParams params) {
        return null;
    }
}
