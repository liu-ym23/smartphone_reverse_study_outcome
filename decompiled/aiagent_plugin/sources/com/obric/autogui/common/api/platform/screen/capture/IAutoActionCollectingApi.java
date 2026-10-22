package com.obric.autogui.common.api.platform.screen.capture;

import android.content.Context;

/* JADX INFO: compiled from: IAutoActionCollectingApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionCollectingApi {
    boolean initCollecting(Context r1, boolean r2);

    boolean isSupported();

    void registerScreenOperationListener(IScreenOperationListener r1);

    void unregisterScreenOperationListener(IScreenOperationListener r1);
}
