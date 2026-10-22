package com.bytedance.android.livesdk.chatroom.replay.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class p extends ir1.c {
    public final int p() {
        if (g() == false) goto L12;
        if (f() == false) goto L9;
        if (b() == false) goto L9;
    L10:
        return R.layout.ttlive_tetris_replay_player_land_pad_opt;
    L9:
        if (l() == true) goto L10;
    L12:
        if (g() == false) goto L17;
        if (c() == false) goto L17;
        return R.layout.ttlive_tetris_replay_player_pad;
    L17:
        if (b() == false) goto L19;
        return R.layout.ttlive_replay_tetris_video_player_land_opt;
    L19:
        return R.layout.ttlive_replay_tetris_video_player;
    }

    public p() {
    }

    public static float o(Context r100) {
        int r101 = com.bytedance.android.livesdk.chatroom.vs_base.util.m.f118199a;
        if (r100 == null) goto L7;
        Resources r102 = r100.getResources();
        if (r102 == null) goto L7;
        Configuration r103 = r102.getConfiguration();
    L9:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.m.b(r103) == false) goto L11;
        return 22.0f;
    L11:
        return 0.0f;
    L7:
        r103 = null;
        goto L9
    }
}
