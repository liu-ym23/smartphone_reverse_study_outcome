package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f77061a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f77062b = null;

    static {
        int[] r100 = new int[DynamicUpdateType.values().length];
        f77061a = r100;
        r100[DynamicUpdateType.LOAD.ordinal()] = 1;
        r100[DynamicUpdateType.UNLOAD.ordinal()] = 2;
        r100[DynamicUpdateType.LAYER_ELEMENT.ordinal()] = 3;
        r100[DynamicUpdateType.ANIM.ordinal()] = 4;
        r100[DynamicUpdateType.SET_DATA.ordinal()] = 5;
        r100[DynamicUpdateType.COMMON_SET_DATA.ordinal()] = 6;
        r100[DynamicUpdateType.EFFECT.ordinal()] = 7;
        r100[DynamicUpdateType.PLAYMODE.ordinal()] = 8;
        r100[DynamicUpdateType.LOG.ordinal()] = 9;
        r100[DynamicUpdateType.CHECK_PERMISSION.ordinal()] = 10;
        r100[DynamicUpdateType.UPDATE_TRACKER.ordinal()] = 11;
        r100[DynamicUpdateType.SEAT_ANIMATE.ordinal()] = 12;
        r100[DynamicUpdateType.REQUEST_ANIMATE_QUEUE.ordinal()] = 13;
        r100[DynamicUpdateType.PUBLIC_SCREEN_AVOID_FRAME.ordinal()] = 14;
        r100[DynamicUpdateType.SEAT.ordinal()] = 15;
        r100[DynamicUpdateType.SNAPSHOT.ordinal()] = 16;
        r100[DynamicUpdateType.ICON_MOVE.ordinal()] = 17;
        r100[DynamicUpdateType.UPDATE_LAYOUT_CONFIG.ordinal()] = 18;
        r100[DynamicUpdateType.UPDATE_SEATLIST_OFFSET.ordinal()] = 19;
        r100[DynamicUpdateType.RELOAD_LAYOUT.ordinal()] = 20;
        r100[DynamicUpdateType.SET_DYNAMIC_UI_FEATURES.ordinal()] = 21;
        r100[DynamicUpdateType.SEAT_CLICK.ordinal()] = 22;
        r100[DynamicUpdateType.ITEM_LOAD_DURATION.ordinal()] = 23;
        r100[DynamicUpdateType.ROOM_BATTLE.ordinal()] = 24;
        r100[DynamicUpdateType.TEAM_FIGHT.ordinal()] = 25;
        r100[DynamicUpdateType.BARRAGE_GAME.ordinal()] = 26;
        r100[DynamicUpdateType.AUDIOCHAT_STAGE.ordinal()] = 27;
        r100[DynamicUpdateType.SUBTITLE.ordinal()] = 28;
        r100[DynamicUpdateType.PERF_STRATEGY.ordinal()] = 29;
        r100[DynamicUpdateType.AVATAR.ordinal()] = 30;
        r100[DynamicUpdateType.GUEST_LINK.ordinal()] = 31;
        r100[DynamicUpdateType.APPLY.ordinal()] = 32;
        r100[DynamicUpdateType.APPLY_FAST_MATCH.ordinal()] = 33;
        r100[DynamicUpdateType.APPLY_PAID_PRIORITY.ordinal()] = 34;
        r100[DynamicUpdateType.FAST_MATCH_JUMP.ordinal()] = 35;
        r100[DynamicUpdateType.UPDATE_WAITING_LIST_DATA.ordinal()] = 36;
        r100[DynamicUpdateType.AUDIENCE_APPLY_PANEL_LIFE_CYCLE.ordinal()] = 37;
        r100[DynamicUpdateType.LINK_SERVICE.ordinal()] = 38;
        r100[DynamicUpdateType.GET_CLIENT_SETTINGS.ordinal()] = 39;
        r100[DynamicUpdateType.SWITCH_LAYOUT.ordinal()] = 40;
        r100[DynamicUpdateType.LINKMIC_SETTING_UPDATE.ordinal()] = 41;
        r100[DynamicUpdateType.SETTING_PANEL_CLICK.ordinal()] = 42;
        r100[DynamicUpdateType.EDIT_MIC_POSITION.ordinal()] = 43;
        r100[DynamicUpdateType.FAST_MATCH.ordinal()] = 44;
        r100[DynamicUpdateType.OPEN_BEAUTY_PANEL.ordinal()] = 45;
        r100[DynamicUpdateType.UPDATE_ENLARGE_STATUS.ordinal()] = 46;
        r100[DynamicUpdateType.OPEN_CONTRIBUTION_LIST_PANEL.ordinal()] = 47;
        r100[DynamicUpdateType.INTERACT_PANEL_CLICK.ordinal()] = 48;
        r100[DynamicUpdateType.OPEN_SETTING_DIALOG.ordinal()] = 49;
        r100[DynamicUpdateType.MULTI_LINK_PANEL_LIFE_CYCLE.ordinal()] = 50;
        r100[DynamicUpdateType.CHORUS.ordinal()] = 51;
        r100[DynamicUpdateType.OPEN_EMOJI_PANEL.ordinal()] = 52;
        r100[DynamicUpdateType.INTERACTIVE_ORDER_SONG.ordinal()] = 53;
        r100[DynamicUpdateType.UPDATE_STAGE_LYRIC_FONT_STYLE.ordinal()] = 54;
        r100[DynamicUpdateType.KARAOKE.ordinal()] = 55;
        r100[DynamicUpdateType.MODIFY_RTC_NETWORK_STATUS_REPORT.ordinal()] = 56;
        r100[DynamicUpdateType.CELLULAR_ENHANCEMENT.ordinal()] = 57;
        r100[DynamicUpdateType.RTC_METHOD.ordinal()] = 58;
        int[] r101 = new int[DynamicGetType.values().length];
        f77062b = r101;
        r101[DynamicGetType.LINKMIC.ordinal()] = 1;
        r101[DynamicGetType.SEAT.ordinal()] = 2;
        r101[DynamicGetType.FRAME_INFO.ordinal()] = 3;
        r101[DynamicGetType.PLAYMODE.ordinal()] = 4;
        r101[DynamicGetType.GET_DATA.ordinal()] = 5;
        r101[DynamicGetType.COMMON_GET_DATA.ordinal()] = 6;
        r101[DynamicGetType.DRESS.ordinal()] = 7;
        r101[DynamicGetType.ENTER_INFO.ordinal()] = 8;
        r101[DynamicGetType.ROOM.ordinal()] = 9;
        r101[DynamicGetType.LIVE_STREAM_DELAY_TIME.ordinal()] = 10;
        r101[DynamicGetType.CHANNEL_INFO.ordinal()] = 11;
        r101[DynamicGetType.TEAM_FIGHT.ordinal()] = 12;
        r101[DynamicGetType.CREATE_CHECK.ordinal()] = 13;
        r101[DynamicGetType.LINK_SERVICE.ordinal()] = 14;
        r101[DynamicGetType.SETTING_PANEL_CONFIG.ordinal()] = 15;
        r101[DynamicGetType.INTERACT_PANEL_CONFIG.ordinal()] = 16;
        r101[DynamicGetType.KTV_ORDER_INFO.ordinal()] = 17;
        r101[DynamicGetType.SUBTITLE.ordinal()] = 18;
        r101[DynamicGetType.AVATAR.ordinal()] = 19;
        r101[DynamicGetType.CHORUS.ordinal()] = 20;
        r101[DynamicGetType.KARAOKE.ordinal()] = 21;
        r101[DynamicGetType.INTERACTIVE_ORDER_SONG.ordinal()] = 22;
    }
}
