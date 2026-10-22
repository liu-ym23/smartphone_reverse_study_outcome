package com.android.server.inputmethod;

import android.mifavor.MFVUtils;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswInputMethodManagerService {
    public static final String TAG = "IZswInputMethodManagerService";

    void hideCurrentInputLocked();

    void showCurrentInputInternal();

    void updateSystemUiLocked(int r1);

    static boolean startInputOrWindowGainedFocusInternalLockedDoubleApp(int userId, boolean defaultValue) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L10;
        if (defaultValue == true) goto L6;
    L8:
        return false;
    L6:
        if (userId == 999) goto L8;
        return true;
    L10:
        return defaultValue;
    }

    static boolean calledFromValidUserLockedDoubleApp(int userId, boolean defaultValue) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L11;
        if (defaultValue == false) goto L6;
    L9:
        return true;
    L6:
        if (userId == 999) goto L9;
        return false;
    L11:
        return defaultValue;
    }

    static int convertUserIdDoubleLay(int userId) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
    L8:
        return userId;
    L5:
        if (userId != 999) goto L8;
        Slog.d(TAG, "convertUserIdDoubleLay 999 fallback to 0 ");
        return 0;
    }

    static boolean isDoubleLay(int userId) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return false;
    L5:
        if (userId != 999) goto L10;
        return true;
    L10:
        return false;
    }
}
