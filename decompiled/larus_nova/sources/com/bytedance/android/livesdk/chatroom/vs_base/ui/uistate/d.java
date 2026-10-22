package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends g {
    @Override // com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.g
    public final int o() {
        if (p() != ReplayDialogUIStyle.RightStyle) goto L6;
        return UtilityKotlinExtentionsKt.c(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME);
    L6:
        return super.o();
    }

    public d() {
    }
}
