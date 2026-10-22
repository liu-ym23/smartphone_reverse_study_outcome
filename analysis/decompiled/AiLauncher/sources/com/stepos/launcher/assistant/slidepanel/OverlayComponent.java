package com.stepos.launcher.assistant.slidepanel;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.stepos.launcher.assistant.utils.reflect.ReflectUtils;

/* loaded from: classes.dex */
public class OverlayComponent extends DialogOverlayContextWrapper {
    private static final float FOCUS_MIN_WINDOW_ALPHA = 0.01f;
    public static final String KEY_OVERLAY_WINDOW_FOCUSABLE = "overlay_window_focusable";
    public static final String KEY_OVERLAY_WINDOW_TOUCHABLE = "overlay_window_touchable";
    public static final String TAG = "OverlayComponent";
    public Boolean isBackground;
    public boolean isWindowDecorViewAdded;
    protected final Handler mMainHandler;
    public int windowShift;

    public OverlayComponent(Context context, int i10) {
        super(context, i10);
        this.isBackground = Boolean.FALSE;
        this.isWindowDecorViewAdded = false;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        Log.i(TAG, "OverlayComponent init");
    }

    private Point getScreenSize() {
        WindowManager windowManager = this.mWindowContextWm;
        if (windowManager == null) {
            windowManager = this.mWindowManager;
        }
        if (windowManager == null) {
            return null;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        int i10 = point.x;
        int i11 = point.y;
        if (i10 > i11) {
            point.x = i11;
            point.y = i10;
        }
        return point;
    }

    private String getWindowTitle() {
        return "LauncherAssistantOverlayWindow:" + getPackageName();
    }

    private void initLayoutSize(WindowManager.LayoutParams layoutParams) {
        Point screenSize = getScreenSize();
        if (screenSize == null) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            layoutParams.width = screenSize.x;
            layoutParams.height = screenSize.y;
        }
    }

    public void addDecorViewIfNeeded() {
        View view;
        if (this.isWindowDecorViewAdded || (view = this.mDecorView) == null) {
            return;
        }
        try {
            this.mWindowManager.addView(view, this.mWindow.getAttributes());
            this.isWindowDecorViewAdded = true;
        } catch (Throwable th) {
            Log.w(TAG, "OverlayComponent addView ." + th);
        }
    }

    public void applyContentViewProperties(Bundle bundle) {
    }

    public boolean canGrantOverlayFocus() {
        View view;
        WindowManager.LayoutParams attributes;
        return isAttachToWindow() && (view = this.mDecorView) != null && view.getVisibility() == 0 && (attributes = this.mWindow.getAttributes()) != null && attributes.alpha > 0.01f;
    }

    public <T extends View> T findViewById(int i10) {
        View view = this.mDecorView;
        if (view == null) {
            return null;
        }
        return (T) view.findViewById(i10);
    }

    public void hide() {
        this.mDecorView.setVisibility(8);
        setTouchable(false);
    }

    @Override // com.stepos.launcher.assistant.slidepanel.DialogOverlayContextWrapper
    public boolean isAttachToWindow() {
        return this.mDecorView != null && this.isWindowDecorViewAdded;
    }

    public boolean isVisible() {
        return isAttachToWindow() && this.mDecorView.getVisibility() == 0;
    }

    public void navigateToDefaultPage() {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
        Log.i(TAG, "OverlayComponent. onDestroy");
        removeDecorViewIfNeeded();
    }

    public void onPause() {
        this.isBackground = Boolean.TRUE;
        Log.i(TAG, "OverlayComponent. onPause");
    }

    public void onPreCreated(WindowManager.LayoutParams layoutParams) {
        this.mWindow.setWindowManager(null, layoutParams.token, new ComponentName(this, getBaseContext().getClass()).flattenToShortString(), true);
        this.mWindowManager = this.mWindow.getWindowManager();
        layoutParams.flags = 8389640;
        layoutParams.gravity = 80;
        layoutParams.format = -2;
        layoutParams.type = 4;
        layoutParams.softInputMode = 16;
        layoutParams.alpha = 0.0f;
        layoutParams.setTitle(getWindowTitle());
        initLayoutSize(layoutParams);
        ReflectUtils.addPRIVATE_FLAG_INTERCEPT_GLOBAL_DRAG_AND_DROPFlag(layoutParams);
        this.mWindow.setLayout(-1, -1);
        this.mWindow.setStatusBarColor(0);
        this.mWindow.setNavigationBarColor(0);
        this.mWindow.setNavigationBarDividerColor(0);
        this.mWindow.setAttributes(layoutParams);
        this.mWindow.setNavigationBarContrastEnforced(false);
        this.mWindow.clearFlags(Integer.MIN_VALUE);
        this.mWindow.addFlags(Integer.MIN_VALUE);
    }

    public void onResume() {
        View view = this.mDecorView;
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.OverlayComponent.1
                @Override // java.lang.Runnable
                public void run() {
                    OverlayComponent.this.isBackground = Boolean.FALSE;
                }
            }, 100L);
        }
        Log.i(TAG, "OverlayComponent. onResume");
    }

    public void onStart() {
        Log.i(TAG, "OverlayComponent. onStart");
        if (isAttachToWindow()) {
            addDecorViewIfNeeded();
        }
    }

    public void onStop() {
        Log.i(TAG, "OverlayComponent. onStop");
    }

    @Override // com.stepos.launcher.assistant.slidepanel.DialogOverlayContextWrapper, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        int i10;
        Point screenSize = getScreenSize();
        if (screenSize != null && layoutParams != null && ((i10 = screenSize.x) != layoutParams.width || screenSize.y != layoutParams.height)) {
            layoutParams.width = i10;
            layoutParams.height = screenSize.y;
        }
        super.onWindowAttributesChanged(layoutParams);
    }

    public void removeDecorViewIfNeeded() {
        if (this.isWindowDecorViewAdded) {
            try {
                this.mWindowManager.removeView(this.mDecorView);
            } catch (Throwable th) {
                Log.w(TAG, "OverlayComponent removeView ." + th);
            }
            this.isWindowDecorViewAdded = false;
        }
        this.mDecorView = null;
    }

    public final void setFocusable(boolean z10) {
        if (!z10) {
            this.mWindow.clearFlags(1024);
            this.mWindow.addFlags(8);
        } else {
            if (!canGrantOverlayFocus()) {
                Log.w(TAG, "setFocusable(true) skipped: not visible or alpha=0");
                return;
            }
            this.mWindow.clearFlags(1032);
        }
        View view = this.mDecorView;
        if (view != null) {
            view.setSystemUiVisibility(1792);
        }
    }

    public final void setTouchable(boolean z10) {
        if (z10) {
            this.mWindow.clearFlags(16);
        } else {
            this.mWindow.addFlags(16);
        }
    }

    public void show() {
        this.mDecorView.setVisibility(0);
        setTouchable(true);
    }
}
