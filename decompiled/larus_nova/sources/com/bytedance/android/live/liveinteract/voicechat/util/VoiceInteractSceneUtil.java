package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.TalkRoomFeedbackDialog;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.interactacting.InteractActingContext;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class VoiceInteractSceneUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final VoiceInteractSceneUtil f80838a = null;

    public static final class a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f80839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f80840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f80841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f80842d;

        @Override // com.bytedance.android.live.liveinteract.voicechat.util.u
        public final void a() {
            if (this.f80840b == 9) goto L5;
            return;
        L5:
            if (this.f80841c != 61) goto L9;
            VoiceInteractSceneUtil.a("reject");
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.voicechat.util.u
        public final void b() {
            if (this.f80840b == 9) goto L5;
            return;
        L5:
            if (this.f80841c != 61) goto L9;
            VoiceInteractSceneUtil.a("accept");
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.voicechat.util.u
        public final void c() {
            Function0 r100 = this.f80842d;
            if (r100 == null) goto L6;
            Unit r101 = (Unit) r100.invoke();
            return;
        }

        public final void d() {
            int r100 = this.f80839a;
            if (r100 == 5) goto L6;
            if (r100 == 9) goto L6;
        L11:
            if (this.f80839a != 9) goto L16;
            Function0 r101 = this.f80842d;
            if (r101 == null) goto L17;
            Unit r102 = (Unit) r101.invoke();
            return;
        L17:
            return;
        L16:
            return;
        L6:
            if (this.f80840b != 9) goto L11;
            if (this.f80841c != 61) goto L11;
            VoiceInteractSceneUtil r103 = VoiceInteractSceneUtil.f80838a;
            HashMap r104 = new HashMap();
            VoiceInteractSceneUtil.c(r104);
            j0.l().sendLog("livesdk_anchor_audience_connection_end_show", r104, new Object[]{IRoom.class});
            goto L11
        }

        public a(int r100, int r101, int r102, Function0 r103) {
            this.f80839a = r100;
            this.f80840b = r101;
            this.f80841c = r102;
            this.f80842d = r103;
        }
    }

    public VoiceInteractSceneUtil() {
    }

    static {
        f80838a = new VoiceInteractSceneUtil();
    }

    public static boolean b() {
        if (((IKtvService) jc1.k.n(IKtvService.class)).isKtvChallengeOpened() == false) goto L6;
        f2.b(R.string.ttlive_live_chorus_room_challenge_open, 0);
        return true;
    L6:
        return false;
    }

    public static Pair d() {
        com.bytedance.android.livesdk.chatroom.u r100 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        int r101 = 0;
        if (r100 == null) goto L11;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r102 = r100.s();
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r103 = r102.getValue();
        if (r103 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r104 = r103.t();
        if (r104 == null) goto L11;
        int r105 = r104.f114792a;
    L12:
        com.bytedance.android.livesdk.chatroom.u r106 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r106 == null) goto L22;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r107 = r106.s();
        if (r107 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r108 = r107.getValue();
        if (r108 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r109 = r108.t();
        if (r109 == null) goto L22;
        r101 = r109.f114793b;
    L22:
        return new Pair(Integer.valueOf(r105), Integer.valueOf(r101));
    L11:
        r105 = 0;
        goto L12
    }

    public static final void a(String r100) {
        HashMap r101 = new HashMap();
        c(r101);
        r101.put("act_type", r100);
        j0.l().sendLog("livesdk_anchor_audience_connection_end_click", r101, new Object[]{IRoom.class});
    }

    public static void c(HashMap r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        r100.put("function_type", ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2());
        r100.put("function_type2", ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2());
        if (je0.d.r() == false) goto L5;
        String r101 = "anchor";
    L6:
        r100.put("user_type", r101);
        return;
    L5:
        r101 = "user";
        goto L6
    }

    public static void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
        LinkedHashMap r101 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r101);
        r101.put("button", r100);
        j0.l().sendLog("livesdk_anchor_audience_connection_open", r101, new Object[]{IRoom.class});
    }

    public static void f(String r100) {
        HashMap r101 = new HashMap();
        r101.put(IPerformanceManager.Params.room_type, "radio");
        r101.put("live_type", "voice_live");
        r101.put("function_type", r100);
        r101.put("function_type2", r100);
        j0 r102 = j0.l();
        am2.x r103 = new am2.x();
        r103.f4350b = "live_detail";
        r103.f4349a = "live";
        r103.f4353e = "click";
        r102.sendLog("anchor_audience_connection_open", r101, new Object[]{r103, IRoom.class});
    }

    public static void g(boolean r100, int r101) {
        if (gd0.v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 8) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L10;
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r102 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r102 == null) goto L9;
        com.bytedance.android.live.liveinteract.voicechat.d.b.a(r102);
    L9:
        ((IKtvService) jc1.k.n(IKtvService.class)).finishAudioTalk();
        return;
    L10:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r103 = IVoiceChatGuestService.a.a();
        if (r103 == null) goto L13;
        IVoiceChatGuestService.b.b(r103, r101, false, !r100, false, 24);
    L13:
        IKtvService.b.a((IKtvService) jc1.k.n(IKtvService.class), r101, false, !r100, false, 24);
    }

    public final void i(int r110, FragmentManager r210, Context r211, Function0<Unit> r212) {
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r212 != null) goto L5;
        final Function0<Unit> r100 = VoiceInteractSceneUtil$selectMultiLinkMode$1.INSTANCE;
    L7:
        if (r110 != 1) goto L9;
        IInteractService r101 = (IInteractService) jc1.k.f(IInteractService.class);
        Object r102 = r100;
        if (r101 == null) goto L137;
        if (r100 == null) goto L136;
        r102 = new t(r100);
    L136:
        r101.initAndTurnOnRadioLinkmicRoom((Runnable) r102, null);
    L137:
        com.bytedance.android.livesdk.sharedpref.d.f158336e0.setValue(null, com.bytedance.android.livesdk.sharedpref.d.f158327a[55], Boolean.FALSE);
        e("audio_audience");
        return;
    L9:
        if (r110 != 2) goto L11;
        f("radio");
        Pair r103 = d();
        int r104 = ((Number) r103.component1()).intValue();
        int r105 = ((Number) r103.component2()).intValue();
        if (b() == false) goto L124;
        if (r100 == null) goto L131;
        Unit r106 = r100.invoke();
    L131:
        e("chatroom");
        return;
    L124:
        if (r104 == 0) goto L126;
        h(r104, 5, r105, 0, r211, r100);
        goto L131
    L126:
        IInteractService r107 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r107 == null) goto L129;
        r107.initAndTurnOnVoiceChatRoom();
    L129:
        if (r100 == null) goto L131;
        Unit r108 = r100.invoke();
        goto L131
    L11:
        if (r110 != 3) goto L13;
        f("ktv");
        j0.l().sendLog("anchor_ktv_open", null, new Object[]{IRoom.class, am2.x.class});
        if (b() == false) goto L109;
        if (r100 == null) goto L164;
        Unit r109 = r100.invoke();
        return;
    L164:
        return;
    L109:
        if (((IKtvService) jc1.k.n(IKtvService.class)).requestConflictCheck(KtvConflictScene.SCENE_KTV) == true) goto L112;
        if (r100 == null) goto L166;
        Unit r111 = r100.invoke();
        return;
    L166:
        return;
    L112:
        Pair r112 = d();
        int r113 = ((Number) r112.component1()).intValue();
        int r114 = ((Number) r112.component2()).intValue();
        if (r113 == 0) goto L115;
        h(r113, 9, r114, 0, r211, r100);
        return;
    L115:
        IInteractService r115 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r115 == null) goto L118;
        r115.initAndTurnOnKTV();
    L118:
        if (r100 == null) goto L169;
        Unit r116 = r100.invoke();
        return;
    L169:
        return;
    L13:
        if (r110 != 4) goto L15;
        f("chorus");
        if (b() == false) goto L93;
        if (r100 == null) goto L157;
        Unit r117 = r100.invoke();
        return;
    L157:
        return;
    L93:
        if (((IKtvService) jc1.k.n(IKtvService.class)).requestConflictCheck(KtvConflictScene.SCENE_KTV) == true) goto L96;
        if (r100 == null) goto L159;
        Unit r118 = r100.invoke();
        return;
    L159:
        return;
    L96:
        Pair r119 = d();
        int r120 = ((Number) r119.component1()).intValue();
        int r121 = ((Number) r119.component2()).intValue();
        if (r120 == 0) goto L99;
        h(r120, 9, r121, 61, r211, r100);
        return;
    L99:
        IInteractService r122 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r122 == null) goto L102;
        r122.initAndTurnOnChorusKTV();
    L102:
        if (r100 == null) goto L162;
        Unit r123 = r100.invoke();
        return;
    L162:
        return;
    L15:
        if (r110 != 5) goto L172;
        j0.l().sendLog("livesdk_anchor_voice_live_open", null, new Object[]{IRoom.class});
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r124 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r124 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r125 = r124.getValue();
        if (r125 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r126 = r125.t();
        if (r126 == null) goto L24;
        int r127 = r126.f114792a;
    L25:
        com.bytedance.android.livesdk.chatroom.u r128 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r128 == null) goto L34;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r129 = r128.s();
        if (r129 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r130 = r129.getValue();
        if (r130 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r131 = r130.t();
        if (r131 == null) goto L34;
        int r132 = r131.f114793b;
    L36:
        if (s0.c(true) == false) goto L76;
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == true) goto L41;
        if (r100 == null) goto L41;
        Unit r133 = r100.invoke();
    L41:
        if (r127 == 9) goto L43;
        if (r127 == 5) goto L56;
    L58:
        if (r127 != 5) goto L63;
        if (InteractActingContext.Companion.a() == false) goto L63;
        f2.b(R.string.ttlive_live_guest_switch_interact_acting_iteration_conflict_radio, 0);
        return;
    L63:
        if (je0.d.s() == false) goto L68;
        if (r100 == null) goto L66;
        Unit r134 = r100.invoke();
    L66:
        z0.a().getClass();
        x0.b r135 = z0.b(r211);
        r135.m(R.string.ttlive_live_link_room_fight_switch_to_radio_hint);
        r135.l(R.string.ttlive_link_room_fight_close_chat_room_tips);
        r135.setCornerRadius(2.0f);
        r135.j(0, s1.B(R.string.ttlive_link_room_fight_close_chat_room_close), r.f80875a);
        r135.j(1, s1.B(R.string.ttlive_link_room_fight_close_chat_room_cancel), s.f80876a);
        r135.n();
        return;
    L68:
        if (AdventureContext.a.a() == false) goto L70;
        f2.b(R.string.ttlive_adventure_voice_game_switch_audio, 0);
        return;
    L70:
        if (r210 == null) goto L154;
        int r136 = TalkRoomFeedbackDialog.f71958r;
        TalkRoomFeedbackDialog r137 = TalkRoomFeedbackDialog.a.a(r127, true, "scene_panel", null, false, null, null, null, 1016);
        LandscapeRestrictionOperation r138 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r137, "TalkRoomFeedbackDialog", r138);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r210, r137, r138) == true) goto L174;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L140
    L75:
        r137.show(r210, "TalkRoomFeedbackDialog");
        return;
    L174:
        return;
    L154:
        return;
    L56:
        if (InteractiveSongContext.Companion.f() == false) goto L58;
        f2.b(R.string.ttlive_live_guest_switch_interact_song_iteration_conflict, 0);
        return;
    L43:
        if (r132 != 61) goto L45;
        g(false, 200);
        return;
    L45:
        if (r132 != 0) goto L146;
        if (r210 == null) goto L147;
        LiveDialogFragment r139 = ((IKtvService) jc1.k.n(IKtvService.class)).getKtvFeedbackDialog("scene_panel", new o(), false);
        if (r139 == null) goto L148;
        LandscapeRestrictionOperation r140 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r139, "KtvFeedbackDialog", r140);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r210, r139, r140) == true) goto L173;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L139
    L53:
        r139.show(r210, "KtvFeedbackDialog");
        return;
    L173:
        return;
    L148:
        return;
    L147:
        return;
    L146:
        return;
    L76:
        HashMap r141 = new HashMap();
        if (r127 == 9) goto L79;
        String r142 = "chat_room";
    L80:
        r141.put("before_function", r142);
        r141.put("interact_function", "live_room");
        r141.put("request_page", "link_icon");
        j0.l().sendLog("anchor_switch_room_type", r141, new Object[]{IRoom.class, am2.x.class});
        if (r127 != 9) goto L83;
        String r143 = s1.B(R.string.ttlive_live_ktv_switch_to_radio_hint);
    L87:
        com.bytedance.android.livesdk.widget.j0.a r144 = new com.bytedance.android.livesdk.widget.j0.a(r211);
        r144.f161764a = r143;
        r144.b(s1.B(R.string.ttlive_interactive_conflict_guess_confirm), new p(r100));
        r144.a(s1.B(R.string.ttlive_cancel), q.f80874a);
        r144.c();
        return;
    L83:
        if (r132 != 29) goto L85;
        r143 = s1.B(R.string.ttlive_talk_room_feedback_title2);
        goto L87
    L85:
        r143 = s1.B(R.string.ttlive_live_voice_chat_switch_to_radio_hint);
        goto L87
    L79:
        r142 = "sing_room";
    L34:
        r132 = 0;
    L24:
        r127 = 0;
        goto L25
    L172:
        return;
    L5:
        r100 = r212;
        goto L7
    }

    public static void h(final int r100, final int r101, int r110, final int r111, Context r112, Function0 r113) {
        TalkRoomLogUtils.f77437e = "link_icon";
        int r102 = y.f80886a;
        y.a(r112, new VoiceInteractSceneUtil$sceneSwitchWithConfirmDialog$1(r100, r101, r111), new v(r100, r101, r110, r111, ""), new a(r100, r101, r111, r113));
    }
}
