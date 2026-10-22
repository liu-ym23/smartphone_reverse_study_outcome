package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.Context;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class n {
    public static String a(Context r100, int r101, int r102) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r101 == 9) goto L18;
        if (r101 == 10) goto L16;
        if (r102 != 29) goto L14;
        return r100.getString(R.string.ttlive_audio_room_playing_name_radio_link);
    L14:
        return r100.getString(R.string.ttlive_audio_room_playing_name_chat);
    L16:
        return r100.getString(R.string.ttlive_audio_room_playing_name_short_video);
    L18:
        if (r102 != 61) goto L22;
        return r100.getString(R.string.ttlive_audio_room_playing_name_chorus);
    L22:
        if (r102 != 0) goto L26;
        return r100.getString(R.string.ttlive_audio_room_playing_name_ktv);
    L26:
        return r100.getString(R.string.ttlive_audio_room_playing_name_ktv);
    }
}
