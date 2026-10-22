package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.Context;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.voicechat.interactacting.InteractActingContext;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.live.kmp.util.KmpToastUtil;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f80886a = 0;

    static {
    }

    public static void a(Context r110, Function0 r111, v r112, VoiceInteractSceneUtil.a r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "voiceSceneSwitchRealFuncDelegate");
        Intrinsics.checkNotNullParameter(r112, "voiceSceneSwitchConfirmDialogParam");
        int r100 = r112.f80878a;
        int r101 = r112.f80879b;
        if (r100 == r101) goto L5;
    L7:
        int r102 = m.f80872a;
        if (vm2.e.m() == false) goto L11;
    L20:
        boolean r103 = true;
    L21:
        if (r103 == true) goto L23;
        return;
    L23:
        int r104 = r112.f80878a;
        Integer r105 = null;
        int r114 = R.string.ttlive_link_room_fight_voice_game_switch_conflict;
        if (r104 == 5) goto L54;
        if (r104 != 9) goto L27;
        int r106 = r112.f80880c;
        if (r106 == 61) goto L35;
    L37:
        if (r106 != 61) goto L42;
        if (r112.f80879b != 5) goto L42;
        b(r110, Integer.valueOf(R.string.ttlive_audio_talk_room_real_time_chorus_switch_to_chatroom_confirm_title), R.string.ttlive_audio_talk_room_real_time_chorus_switch_to_chatroom_confirm_tips, r111, r113);
        return;
    L42:
        if (r112.f80881d == 61) goto L44;
    L46:
        if (r106 == 0) goto L48;
    L50:
        r111.invoke();
        if (r113 == null) goto L180;
        r113.c();
        return;
    L180:
        return;
    L48:
        if (r112.f80879b != 5) goto L50;
        b(r110, Integer.valueOf(R.string.ttlive_audio_talk_room_ktv_switch_to_chatroom_confirm_title), R.string.ttlive_audio_talk_room_ktv_switch_to_chatroom_confirm_tips, r111, r113);
        return;
    L44:
        if (r112.f80879b != 9) goto L46;
        b(r110, null, R.string.ttlive_audio_talk_room_ktv_switch_to_real_time_chorus_confirm_tips, r111, r113);
        return;
    L35:
        if (r112.f80879b != 9) goto L37;
        b(r110, Integer.valueOf(R.string.ttlive_audio_talk_room_real_time_chorus_switch_to_ktv_confirm_title), R.string.ttlive_audio_talk_room_real_time_chorus_switch_to_ktv_confirm_tips, r111, r113);
        return;
    L27:
        if (r104 == 16) goto L31;
        r111.invoke();
        if (r113 == null) goto L173;
        r113.c();
        return;
    L173:
        return;
    L31:
        f2.b(R.string.ttlive_link_room_fight_voice_game_switch_conflict, 0);
        return;
    L54:
        if (GuestBattleContext.Companion.e() == false) goto L59;
        r111.invoke();
        if (r113 == null) goto L182;
        r113.c();
        return;
    L182:
        return;
    L59:
        if (TeamFightContext.Companion.h() == false) goto L68;
        int r107 = r112.f80881d;
        if (r107 == 30) goto L65;
        if (r107 == 27) goto L65;
        int r108 = R.string.ttlive_team_fight_voice_game_switch_conflict;
    L66:
        f2.b(r108, 0);
        return;
    L65:
        r108 = R.string.ttlive_team_fight_voice_game_switch_conflict_v2;
        goto L66
    L68:
        if (LinkRoomFightContext.Companion.c() == false) goto L75;
        int r109 = r112.f80881d;
        if (r109 == 30) goto L72;
        if (r109 == 27) goto L72;
    L73:
        f2.b(r114, 0);
        return;
    L72:
        r114 = R.string.ttlive_link_room_fight_game_switch_confict_v2;
        goto L73
    L75:
        if (InteractiveSongContext.Companion.f() == false) goto L82;
        if (r112.f80879b == 5) goto L82;
        if (r112.f80881d == 61) goto L82;
        f2.b(R.string.ttlive_live_guest_switch_interact_song_iteration_conflict, 0);
        return;
    L82:
        if (InteractActingContext.Companion.a() == true) goto L84;
    L88:
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L91;
        f2.b(R.string.ttlive_adventure_voice_game_switch_conflict, 0);
        return;
    L91:
        ReadOnlyProperty r115 = vm2.e.f556040b0;
        KProperty<?>[] r116 = vm2.e.f556037a;
        if (((Boolean) r115.getValue(null, r116[52])).booleanValue() == false) goto L99;
        if (r112.f80880c != 29) goto L99;
        r111.invoke();
        if (r113 == null) goto L189;
        r113.c();
        return;
    L189:
        return;
    L99:
        if (((Boolean) r115.getValue(null, r116[52])).booleanValue() == false) goto L115;
        int r117 = r112.f80881d;
        if (r117 == 30) goto L104;
        if (r117 != 27) goto L115;
    L104:
        if (r112.f80880c == 28) goto L108;
        if (ThemedCompetitionContext.Companion.h() == false) goto L115;
    L108:
        if (r112.f80880c != 28) goto L111;
        int r118 = R.string.ttlive_link_room_avartar_hamlet_switch_confict;
    L114:
        f2.b(r118, 0);
        return;
    L111:
        if (ThemedCompetitionContext.Companion.h() == false) goto L113;
        r118 = R.string.ttlive_talk_room_cannot_switch_in_themed_competition;
        goto L114
    L113:
        r118 = R.string.ttlive_link_room_default_switch_confict;
    L115:
        int r119 = r112.f80879b;
        if (r119 == 9) goto L118;
    L130:
        if (r119 == 9) goto L132;
        if (r119 != 5) goto L169;
        int r120 = r112.f80881d;
        if (r120 == 21) goto L165;
        if (r120 == 22) goto L164;
        if (r120 == 26) goto L163;
        if (r120 == 27) goto L165;
        if (r120 == 30) goto L162;
        int r121 = R.string.ttlive_audio_talk_switch_to_chatroom_layout_default_tips;
    L166:
        if (r120 != 30) goto L168;
        r105 = Integer.valueOf(R.string.ttlive_voice_room_enlarge_c_position_dialog_title);
    L168:
        b(r110, r105, r121, r111, r113);
        return;
    L162:
        r121 = R.string.ttlive_voice_room_enlarge_c_position_dialog_msg;
        goto L166
    L163:
        r121 = R.string.ttlive_audio_talk_switch_to_chatroom_layout_2x4x4_tips;
        goto L166
    L164:
        r121 = R.string.ttlive_audio_talk_switch_to_chatroom_layout_3x3_tips;
    L165:
        r121 = R.string.ttlive_audio_talk_switch_to_chatroom_layout_1x8_tips;
        goto L166
    L169:
        r111.invoke();
        if (r113 == null) goto L197;
        r113.c();
        return;
    L197:
        return;
    L132:
        if (r112.f80880c == 26) goto L135;
    L136:
        boolean r122 = false;
    L149:
        if (r122 == false) goto L151;
        b(r110, null, R.string.ttlive_audio_talk_room_chatroom_switch_to_ktv_confirm_tips, r111, r113);
        return;
    L151:
        r111.invoke();
        if (r113 == null) goto L194;
        r113.c();
        return;
    L194:
        return;
    L135:
        if (Intrinsics.areEqual(com.bytedance.android.live.ktv.common.util.a.c().getAnchorAbValue("linkmic_audience_anchor_hide"), "1") == false) goto L136;
        IInteractService r123 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r123 == null) goto L144;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r124 = r123.getLinkUserInfoCenter();
        if (r124 == null) goto L144;
        List<T> r125 = r124.getOnlineUserList();
        if (r125 == 0) goto L144;
        int r126 = r125.size();
    L145:
        if (r126 <= 9) goto L147;
        boolean r127 = true;
    L148:
        r122 = r127;
        goto L149
    L147:
        r127 = false;
    L144:
        r126 = 0;
        goto L145
    L118:
        if (r112.f80881d != 61) goto L130;
        if (((Boolean) vm2.i.O.getValue(null, vm2.i.f556291a[39])).booleanValue() == false) goto L128;
        int r128 = r112.f80880c;
        if (r128 == 27) goto L127;
        if (r128 == 22) goto L127;
        if (r128 == 26) goto L127;
        if (r128 == 21) goto L127;
        if (r128 != 28) goto L128;
    L127:
        int r129 = R.string.ttlive_audio_talk_room_ktv_switch_to_real_time_chorus_confirm_tips2;
    L129:
        b(r110, null, r129, r111, r113);
        return;
    L128:
        r129 = R.string.ttlive_audio_talk_room_ktv_switch_to_real_time_chorus_confirm_tips;
        goto L129
    L84:
        if (r112.f80879b == 5) goto L88;
        if (r112.f80881d == 61) goto L88;
        f2.b(R.string.ttlive_live_guest_switch_interact_acting_iteration_conflict_ktv, 0);
        return;
    L11:
        if (r100 == 5) goto L13;
        if (r100 == 9) goto L13;
    L15:
        if (r100 != 10) goto L20;
        if (r101 == 5) goto L18;
        if (r101 != 9) goto L20;
    L18:
        KmpToastUtil.a("请先切换电台，暂不支持直接切换", 0);
    L19:
        r103 = false;
    L13:
        if (r101 != 10) goto L15;
        KmpToastUtil.a("请先切换电台，暂不支持直接切换", 0);
        goto L19
    L5:
        if (r112.f80880c != r112.f80881d) goto L7;
    }

    public static void b(Context r100, Integer r101, int r102, Function0 r103, VoiceInteractSceneUtil.a r104) {
        if (r104 == null) goto L4;
        r104.d();
    L4:
        x0.b r105 = new x0.b(r100, 0);
        if (r101 != null) goto L7;
        r105.f162238a.f162242a = 4;
    L8:
        r105.l(r102);
        r105.i(1, R.string.ttlive_cancel, new w(r104));
        r105.i(0, R.string.ttlive_interactive_conflict_guess_confirm, new x(r104, r103));
        r105.f162238a.f162252k = false;
        r105.n();
        return;
    L7:
        r105.f162238a.f162242a = 5;
        r105.m(r101.intValue());
        goto L8
    }
}
