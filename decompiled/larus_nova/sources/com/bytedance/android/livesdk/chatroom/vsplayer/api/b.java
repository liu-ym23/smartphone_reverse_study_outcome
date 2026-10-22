package com.bytedance.android.livesdk.chatroom.vsplayer.api;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;

/* JADX INFO: loaded from: classes8.dex */
public interface b {
    void hidePlayerTip(String r100);

    PlayerTipsContext provideVSPlayTipsContext();

    void showPlayerTip(String r100, CharSequence r101, boolean r102);

    void showPlayerTipWithCustomView(String r100, View r101);
}
