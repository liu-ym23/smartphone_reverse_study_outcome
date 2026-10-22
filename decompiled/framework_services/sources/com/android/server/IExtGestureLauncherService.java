package com.android.server;

import android.content.Context;
import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes.dex */
public interface IExtGestureLauncherService extends IExtBase {
    default boolean launchWalletZTE(Context context, boolean isUserSetupComplete) {
        return false;
    }

    default boolean isDoubleTapLaunchWalletEnableZTE(Context context) {
        return false;
    }
}
