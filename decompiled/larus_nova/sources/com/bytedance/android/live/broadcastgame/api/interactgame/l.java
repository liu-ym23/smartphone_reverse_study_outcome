package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f59313a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f59314b = null;

    static {
        f59313a = SetsKt.mutableSetOf(new String[]{"source", "status_code", "game_id", EventConstants.ExtraJson.GAME_NAME, "entrence", "status_code", "wtimor_game_mode", "invite_role", "first_frame_shown", IPerformanceManager.Params.is_anchor, ShareConstants.KEY_PANEL_TYPE, "is_first_time", "panel_state", "resource_type", "is_abort", "is_reload", "from", "app_id", "app_name", "mode", "is_from_cached", SeiMessageConst.MSG_TYPE, "is_show_sensitive_tip", com.alipay.sdk.m.p.e.f25671s, "live_type", BdpAppEventConstant.PARAMS_GAME_TYPE, "switch_game_id", "switch_game_name", "is_silent_install", "is_cut_short", WsConstants.KEY_CHANNEL_TYPE});
        f59314b = SetsKt.mutableSetOf(new String[]{"duration"});
    }
}
