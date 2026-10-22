package com.android.server.clipboard;

import android.content.ClipData;
import android.content.IObricClipboardManager;
import com.android.server.wm.IObricWindowManagerInternal;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes.dex */
public interface IObricClipboardService extends IObricBase {
    default ClipboardService.Clipboard getClipboardLockedInOautoDisplay(int userId, int deviceId) {
        return null;
    }

    default void setClipboardIsolate(boolean isolate) {
    }

    default boolean isClipboardIsolated() {
        return false;
    }

    default IObricClipboardManager getIObricExt() {
        return null;
    }

    default boolean isClipDataFromOauto(ClipData clip) {
        return false;
    }

    default void clearOautoPrimaryClipLocked(int userId, int deviceId) {
    }

    default boolean isAppLaunchInOautoDisplay(IObricWindowManagerInternal wms) {
        return false;
    }
}
