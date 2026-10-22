package com.android.server.audio;

import com.android.media.permission.INativePermissionController;

/* JADX INFO: loaded from: classes.dex */
public interface AudioPolicyFacade {
    INativePermissionController getPermissionController();

    boolean isHotwordStreamSupported(boolean r1);

    void registerOnStartTask(Runnable r1);

    void setEnableHardening(boolean r1);
}
