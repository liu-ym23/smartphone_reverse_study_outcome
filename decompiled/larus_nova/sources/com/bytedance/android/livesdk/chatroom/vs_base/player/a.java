package com.bytedance.android.livesdk.chatroom.vs_base.player;

import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public interface a {
    IPlayerProgressService a(DataCenter r100);

    void releaseService(DataCenter r100);
}
