package com.android.server.wm;

import android.content.Context;
import android.os.Handler;
import android.view.InsetsState;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IObricDisplayPolicy extends IObricBase {
    default void onInit(DisplayContent displayContent, Context context, Handler handler) {
    }

    default boolean checkAllowShowToastWhenLocked(WindowState win, boolean allowShowWhenLocked) {
        return allowShowWhenLocked;
    }

    default boolean isAutoImeShowing() {
        return false;
    }

    default boolean setAutoImeShowing(boolean b) {
        return false;
    }

    default DisplayPolicy.DecorInsets.Info getDecorInsetsInfo(int rotation, int w, int h) {
        return null;
    }

    default void adjustImeInAuto(InsetsTarget caller, int changedTypes) {
    }

    default void adjustInsetsForWindow(WindowState target, InsetsState state) {
    }
}
