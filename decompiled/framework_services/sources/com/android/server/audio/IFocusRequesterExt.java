package com.android.server.audio;

import android.prometheus.ext.core.ExtLoader;

/* JADX INFO: loaded from: classes.dex */
public class IFocusRequesterExt {
    public static IFocusRequesterExt get(Object obj) {
        return (IFocusRequesterExt) ExtLoader.get(IFocusRequesterExt.class, obj);
    }

    public IFocusRequesterExt(Object base) {
    }

    public boolean frameworkHandleFocusLoss_onFlagPauseOnDuckableLoss(FocusRequester focusRequester, boolean forceDuck) {
        return false;
    }

    public int transformFocusLossFromGain(int focusGain, FocusRequester focusRequester, int fromLoss) {
        return fromLoss;
    }
}
