package com.android.server.wm;

import android.content.res.CompatibilityInfo;
import android.os.IBinder;
import android.util.Slog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class AppWindowTokenSmtBase {
    protected static final int STARTING_WINDOW_TYPE_NONE = 0;
    protected static final int STARTING_WINDOW_TYPE_SNAPSHOT = 1;
    protected static final int STARTING_WINDOW_TYPE_SPLASH_SCREEN = 2;
    public int animLayerAdjust;
    boolean mIsTranslucent;
    public boolean mNotReparentAnimationLayer;

    public AppWindowTokenSmtBase() {
        this.animLayerAdjust = 0;
        this.mNotReparentAnimationLayer = false;
        this.mIsTranslucent = false;
    }

    void cacheFirstFrame(StartingData startingData, WindowState win, ArrayList<WindowState> mChildren, WindowStateAnimator winAnimator) {
    }

    boolean isStartingWindowSmt(CompatibilityInfo compatInfo) {
        int bytedanceFlag = 0;
        String folderType = "";
        if (compatInfo == null) goto L5;
        bytedanceFlag = compatInfo.getSmtEx().getAppInfoBytedanceFlag();
        folderType = compatInfo.getSmtEx().getBytedancePreviewStartingWindowType();
    L6:
        if (folderType != null) goto L8;
    L10:
        boolean forceStartingWindow = false;
    L12:
        if ((bytedanceFlag & 16) != 0) goto L15;
        return false;
    L15:
        return forceStartingWindow;
    L8:
        if ("".equals(folderType) == true) goto L10;
        forceStartingWindow = true;
        goto L12
    L5:
        Slog.e("WindowManager", "bytedanceFlag is empty from CompatibilityInfo");
        goto L6
    }

    boolean needStartingWindowSmt(CompatibilityInfo compatInfo, boolean windowIsTranslucent, boolean windowIsFloating, boolean windowDisableStarting, boolean forceStartingWindow, IBinder transferFrom) {
        return true;
    }
}
