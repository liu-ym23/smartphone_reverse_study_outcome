package com.bytedance.android.live.revlink.impl.pk.service;

/* JADX INFO: loaded from: classes47.dex */
public interface f {
    long channelId();

    int duration();

    String getConnectSource();

    IPkAudienceLoadService.LoadType getLoadType();

    String guestUserId();

    int matchType();

    void reportUiFirstLoad();

    String theme();
}
