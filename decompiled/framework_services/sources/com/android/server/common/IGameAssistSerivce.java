package com.android.server.common;

import android.os.Bundle;
import android.os.IBinder;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
public interface IGameAssistSerivce {
    IBinder getToken();

    boolean isGameScene();

    boolean isGameSpaceListApp(String r1);

    boolean isMutexWindow(String r1, WindowManager.LayoutParams r2);

    void sendToGameAssistServices(String r1, Bundle r2);

    default void sendToGameAssistServices(String actionName) {
        sendToGameAssistServices(actionName, new Bundle());
    }
}
