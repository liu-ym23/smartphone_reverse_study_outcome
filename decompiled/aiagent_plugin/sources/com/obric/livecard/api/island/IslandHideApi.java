package com.obric.livecard.api.island;

import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.impl.IslandStatusCallback;

/* JADX INFO: compiled from: IslandHideApi.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IslandHideApi {
    void addIslandStatusCallback(IslandStatusCallback r1);

    void onLauncherFocused();

    void onNotificationVisible(boolean r1);

    void onSysUIFlagsChanged(long r1);

    void onVolumeButtonClick();

    void registerIslandService(IIslandService r1);

    void removeIslandStatusCallback(IslandStatusCallback r1);

    void setKeyguardLocked(boolean r1);

    void setVisible(boolean r1);
}
