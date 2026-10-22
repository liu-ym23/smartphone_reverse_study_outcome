package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b0 implements com.bytedance.android.livesdk.log.filter.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f77463a = null;

    public b0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f77463a = new b0();
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        if ((!Intrinsics.areEqual(r100, "livesdk_audience_playmode_room_watch")) == false) goto L14;
        if ((!Intrinsics.areEqual(r100, "livesdk_audience_playmode_room_watch_duration")) == false) goto L14;
        if ((!Intrinsics.areEqual(r100, "livesdk_anchor_playmode_open_success")) == false) goto L14;
        if ((!Intrinsics.areEqual(r100, "livesdk_anchor_playmode_over")) == false) goto L14;
        if (r101.containsKey(FastStartLiveConfig.PLAY_MODE) == true) goto L14;
        r101.put(FastStartLiveConfig.PLAY_MODE, u0.b());
    L14:
        if (Intrinsics.areEqual(r100, "livesdk_chatroom_game_bomb_crown_show") == false) goto L16;
    L27:
        boolean r102 = ii0.a.f489961b;
        r101.put("play_period", ii0.a.f(GuestBattleContext.Companion.b()));
        return;
    L16:
        if (Intrinsics.areEqual(r100, "livesdk_chatroom_game_bomb_crown_change") == true) goto L27;
        if (Intrinsics.areEqual(r100, "livesdk_audience_playmode_room_watch") == true) goto L27;
        if (Intrinsics.areEqual(r100, "livesdk_audience_playmode_room_watch_duration") == true) goto L27;
        if (Intrinsics.areEqual(r100, "livesdk_audience_playmode_room_link") == true) goto L27;
        if (Intrinsics.areEqual(r100, "livesdk_audience_playmode_room_link_duration") == true) goto L27;
        if (Intrinsics.areEqual(r100, "livesdk_chatroom_game_naming_show") == true) goto L27;
    }
}
