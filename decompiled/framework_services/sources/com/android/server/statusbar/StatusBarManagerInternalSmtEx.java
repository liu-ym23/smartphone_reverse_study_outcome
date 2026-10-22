package com.android.server.statusbar;

import com.android.internal.statusbar.SystemUiDecoration;
import com.android.internal.view.AppearanceRegion;

/* JADX INFO: loaded from: classes3.dex */
public interface StatusBarManagerInternalSmtEx {
    void onSystemBarAppearanceChangedSmt(int r1, int r2, AppearanceRegion[] r3, boolean r4, SystemUiDecoration r5);

    void onThumpSwipeFromTopStatusBar();

    void onTouchScreenByUser();

    void showGameBar();

    void toggleNotificationsPanel(int r1);

    void toggleRecentPerspective(boolean r1, boolean r2);

    void toggleTntRecentApps();

    void toggleTorch();
}
