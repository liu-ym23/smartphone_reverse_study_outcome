package com.bytedance.android.live.broadcastgame.api.xplay;

/* JADX INFO: loaded from: classes45.dex */
public interface f {
    XplayGuestType a();

    String getAppId();

    String getGameName();

    <T> T getService(Class<T> r100);

    void stop();
}
