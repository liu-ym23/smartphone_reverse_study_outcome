package com.bytedanceos.common.ui.utils;

import android.content.Context;
import cn.jzvd.JZUtils;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdMgr;
import cn.jzvd.JzvdStd;

/* JADX INFO: loaded from: classes2.dex */
public class JzvdUtil {
    public JzvdUtil() {
    }

    public static void autoPause(JzvdStd r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isPausedByUser() == false) goto L6;
        return;
    L6:
        if (r10.getState() != 3) goto L8;
        Jzvd.goOnPlayOnPause();
        JZUtils.saveProgress(r10.getContext(), r10.getCurrentUrl(), r10.getCurrentPositionWhenPlaying());
        return;
    L8:
        r10.release();
    }

    public static boolean autoPlay(Jzvd r10) {
        if (canAutoPlay(r10) == false) goto L13;
        int r11 = r10.getState();
        if (r11 != 0) goto L7;
        r10.startVideo();
    L10:
        if (r10.getState() != 3) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r11 == 3) goto L10;
        Jzvd.goOnPlayOnResume();
        goto L10
    L13:
        return false;
    }

    public static boolean canAutoPlay(Jzvd r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.isPausedByUser() == false) goto L8;
        return false;
    L8:
        if (r10.isCached() == false) goto L10;
    L11:
        return true;
    L10:
        if (JZUtils.isWifiConnected(r10.getContext()) == true) goto L11;
        return false;
    }

    public static void clearSavedProgress(Context r10, String r11) {
        Jzvd.clearSavedProgress(r10, r11);
    }

    public static void onDestroy(JzvdStd r10) {
        onDestroy(r10, false);
    }

    public static void onPause(JzvdStd r10) {
        autoPause(r10);
    }

    public static void onResume(JzvdStd r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (autoPlay(r10) == true) goto L8;
        r10.updateVideoView();
        return;
    }

    public static void quitFullScreen(JzvdStd r10) {
        if (r10 == null) goto L5;
        Jzvd.backPress();
        return;
    }

    public static void release(JzvdStd r10) {
        if (r10 == null) goto L5;
        r10.release();
        return;
    }

    public static void onDestroy(JzvdStd r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10 != JzvdMgr.getFirstFloor()) goto L6;
        r10.release();
    L6:
        if (r11 == false) goto L10;
        clearSavedProgress(r10.getContext(), r10.getCurrentUrl().toString());
        return;
    }
}
