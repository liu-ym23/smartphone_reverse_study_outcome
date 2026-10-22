package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public final class b2 {
    public static void a(Bundle r100, Bundle r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_FROM_NEW_STYLE_EXTRA, false) == false) goto L14;
        r100.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_FROM_NEW_STYLE_EXTRA, r101.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_FROM_NEW_STYLE_EXTRA, false));
        r100.putString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_LIVE_SOURCE, r101.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_LIVE_SOURCE));
        r100.putString(ILiveRoomPlayFragmentConstant.EXTRA_WINDOW_MODE_EXTRA, "full_screen");
        Bundle r102 = com.bytedance.android.livesdk.chatroom.m0.a(r100);
        if (TextUtils.equals(r102.getString("enter_from_merge"), "vs_player_detail") == true) goto L9;
    L10:
        r100.putString("live.intent.extra.FEED_URL", r101.getString("live.intent.extra.FEED_URL", ""));
        return;
    L9:
        if (TextUtils.equals(r102.getString("enter_method"), "vs_relevant_live_panel") == false) goto L10;
        return;
    }

    public static void b(Bundle r100, DataCenter r101) {
        if (r101 == null) goto L8;
        Boolean r102 = Boolean.FALSE;
        if (((Boolean) r101.get("data_live_new_feed_style", r102)).booleanValue() == false) goto L9;
        r100.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_FROM_NEW_STYLE_EXTRA, ((Boolean) r101.get("data_live_new_feed_style", r102)).booleanValue());
        r100.putString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_LIVE_SOURCE, (String) r101.get("data_live_first_enter_source", ""));
        r100.putString(ILiveRoomPlayFragmentConstant.EXTRA_WINDOW_MODE_EXTRA, "full_screen");
        r100.putString("live.intent.extra.FEED_URL", (String) r101.get("data_live_new_feed_url", ""));
        return;
    L9:
        return;
    }
}
