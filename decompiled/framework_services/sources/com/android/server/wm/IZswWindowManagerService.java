package com.android.server.wm;

import android.os.PowerManager;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswWindowManagerService {
    void defendReportOnePixelActivityFind(Session r1, WindowManager.LayoutParams r2);

    boolean disableSafemode();

    int[] getVisibleWindowUidSet();

    void initWakelock(PowerManager r1);

    boolean performEnableScreenBlock();
}
