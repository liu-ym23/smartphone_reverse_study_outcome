package com.android.server.wm;

import android.content.Context;
import android.os.Handler;
import android.pico.utils.IExtBase;
import android.view.DisplayInfo;
import android.view.InsetsState;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtDisplayPolicy extends IExtBase {
    void adjustDisplayDecorInsets(InsetsState r1, int r2);

    InsetsState adjustInsetsForWindow(WindowState r1, InsetsState r2);

    void adjustLayoutWindowParamsForLandscapeCutout(WindowState r1, WindowManager.LayoutParams r2);

    int adjustNavBarAppearance(WindowState r1, int r2);

    void adjustWindowParamsLw(WindowState r1, WindowManager.LayoutParams r2);

    WindowState getKeyguard();

    WindowState getRecentsWindow();

    int getSideCutout();

    InsetsControlTarget getStatusControlTargetInLandscapeSplit(WindowState r1);

    boolean ignoreForceShowSystemBarsInLandscapeSplit();

    boolean isAutoImeShowing();

    boolean isGestureModeOn();

    boolean isStatusBarExpanded();

    boolean onAddWindowLw(WindowState r1, WindowManager.LayoutParams r2);

    void onApplyKeyguardPolicy(WindowState r1);

    void onApplyPostLayoutPolicyLw(WindowState r1, WindowManager.LayoutParams r2, WindowState r3, WindowState r4);

    void onBeginPostLayoutPolicyLw();

    void onConfigurationChanged();

    void onDisplayInfoChanged(DisplayInfo r1);

    void onFinishPostLayoutPolicyLw();

    void onFocusChangedLw(WindowState r1, WindowState r2);

    void onInit(DisplayContent r1, Context r2, Handler r3);

    void onKeyguardStatusChanged();

    boolean onRemoveWindowLw(WindowState r1);

    void onSetKeyguardOccludedLw(boolean r1, boolean r2, boolean r3);

    void onSetStatusBarDisabled(int r1, int r2, int r3, boolean r4);

    void onSystemReady();

    boolean setAutoImeShowing(boolean r1);

    void setForceHideKeyguard(boolean r1);
}
