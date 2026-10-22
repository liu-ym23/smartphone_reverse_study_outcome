package com.bytedance.android.live.broadcastgame.api;

import com.bytedance.android.live.broadcastgame.AudienceGameWidget;

/* JADX INFO: loaded from: classes45.dex */
public interface f {
    void a();

    void b();

    AudienceGameWidget getAudienceGameWidget(boolean r100);

    String getGameCategory();

    void onSei(String r100);

    void stopRunningPlugin(String r100);
}
