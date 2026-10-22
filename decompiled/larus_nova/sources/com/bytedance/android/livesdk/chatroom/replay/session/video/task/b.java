package com.bytedance.android.livesdk.chatroom.replay.session.video.task;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.floatwindow.ReplayFloatWindowManager;
import com.bytedance.android.livesdk.chatroom.replay.floatwindow.m;
import com.bytedance.android.livesdk.chatroom.replay.session.room.ReplayVideoEngine;
import com.bytedance.android.livesdk.chatroom.vs_base.base.model.ReplayRoomState;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.n;
import com.bytedance.android.livesdk.chatroom.vs_base.session.video.h;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.MatchData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import fq1.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.bytedance.android.livesdk.chatroom.vs_base.base.api.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f109944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f109945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f109946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final jm1.b f109947e;

    public final void c() {
        ReplayRoomState r100 = this.f109946d.f118128b;
        ReplayRoomState r101 = ReplayRoomState.INITIALIZED;
        if (UtilityKotlinExtentionsKt.e(r100, new Object[]{ReplayRoomState.IDLE, r101}) == false) goto L5;
        return;
    L5:
        Map<String, m> r102 = ReplayFloatWindowManager.f108617j;
        ReplayFloatWindowManager r103 = ReplayFloatWindowManager.c.a();
        vlc.d r104 = null;
        r103.f108624e = null;
        r103.f108622c = null;
        boolean r105 = wq1.b.f560683a;
        h r106 = this.f109946d;
        if (r106.f118128b != ReplayRoomState.VIDEO_FINISHED) goto L8;
        return;
    L8:
        r106.f118130d.f118054h.setValue(Boolean.FALSE);
        ReplayRoomState r107 = this.f109946d.f118128b;
        ReplayRoomState r108 = ReplayRoomState.PREPARING_WITH_PRE_SHOW;
        if (UtilityKotlinExtentionsKt.e(r107, new Object[]{r108, ReplayRoomState.VIDEO_STARTED}) == false) goto L11;
        com.bytedance.android.livesdk.chatroom.vs_base.base.api.b.a.a(a(), g.class);
    L11:
        ReplayRoomState r109 = this.f109946d.f118128b;
        ReplayRoomState r110 = ReplayRoomState.PREPARED;
        ReplayRoomState r111 = ReplayRoomState.PREPARING;
        if (UtilityKotlinExtentionsKt.e(r109, new Object[]{r110, r111, r108}) == false) goto L23;
        this.f109946d.f118130d.f118070x.setValue(Boolean.TRUE);
        if (UtilityKotlinExtentionsKt.e(this.f109946d.f118128b, new Object[]{r111, r108, r110}) == false) goto L23;
        vq1.b r112 = this.f109946d.f118146t;
        if (r112 == null) goto L19;
        r112.stop();
    L19:
        h r113 = this.f109946d;
        r113.f118146t = null;
        vq1.b r114 = r113.f118145s;
        if (r114 == null) goto L22;
        r114.stop();
    L22:
        h r115 = this.f109946d;
        r115.f118145s = null;
        r115.a(r101);
        this.f109946d.getClass();
    L23:
        DataCenter r116 = this.f109946d.f118151y;
        if (r116 == null) goto L26;
        r104 = (vlc.d) r116.get("data_message_manager", null);
    L26:
        if (r104 == null) goto L29;
        r104.r(true);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.api.a
    public final void b(Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "extra");
        this.f109944b = this.f109946d.getContext();
        this.f109946d.getClass();
        Object r100 = r110.get("key_error");
        if ((r100 instanceof ls2.e) == true) goto L5;
        r100 = null;
    L5:
        ls2.e r101 = (ls2.e) r100;
        Object r111 = r110.get("key_end_reason");
        if ((r111 instanceof EndReason) == true) goto L8;
        r111 = null;
    L8:
        EndReason r112 = (EndReason) r111;
        if (r112 != null) goto L13;
        if (r101 == null) goto L12;
        r112 = r101.getReasonV2();
        goto L13
    L12:
        r112 = null;
    L13:
        if (r112 != null) goto L15;
        return;
    L15:
        r.a().d("ttlive_room", "end room task " + this.f109946d.f118149w + ", end reason " + r112);
        if (r101 == null) goto L19;
        String r102 = r101.getErrPromptV2();
        if (r102 == null) goto L19;
    L23:
        this.f109946d.f118130d.f118059m.setValue(Boolean.TRUE);
        Episode r103 = this.f109946d.f118132f;
        if (r103 == null) goto L30;
        EpisodeBasicInfo r104 = r103.episodeBasicInfo;
        if (r104 == null) goto L30;
        MatchData r105 = r104.getMatchData();
        if (r105 == null) goto L30;
        String.valueOf(r105.getMatchId());
    L30:
        Episode r106 = this.f109946d.f118132f;
        if (r106 == null) goto L33;
        Long r107 = Long.valueOf(r106.roomId);
    L34:
        String r108 = String.valueOf(r107);
        Episode r109 = this.f109946d.f118132f;
        if (r109 == null) goto L49;
        EpisodeBasicInfo r113 = r109.episodeBasicInfo;
        if (r113 == null) goto L49;
        MultiTab r114 = r113.getReplaysTabs();
        if (r114 == null) goto L49;
        List<MultiTab.TabItem> r115 = r114.getValidTabs();
        if (r115 == null) goto L49;
        Iterator<T> r116 = r115.iterator();
    L44:
        if (r116.hasNext() == false) goto L49;
        String r117 = ((MultiTab.TabItem) r116.next()).getSchema();
        if (r117 == null) goto L48;
        com.bytedance.android.annie.container.fragment.a.d(com.bytedance.android.annie.container.fragment.a.a(r117 + "&room_id=" + r108));
    L48:
        ALogger.d("ReplayEndTask", "回放房间anniecard释放");
    L49:
        List<Episode> r118 = n.f117946a;
        Episode r119 = this.f109946d.f118132f;
        if (r119 == null) goto L53;
        ((ArrayList) n.f117946a).remove(r119);
    L53:
        if (Intrinsics.areEqual(r112, EndReason.ENTER_FAILED.INSTANCE) == false) goto L55;
    L110:
        r.a().d("ttlive_room", "end room task " + this.f109946d.f118149w + ", exit room");
        if (this.f109945c == true) goto L113;
    L134:
        this.f109945c = false;
        this.f109946d.f118130d.f118060n.setValue(Boolean.TRUE);
    L135:
        jm1.b r120 = this.f109947e;
        h r121 = this.f109946d;
        long r122 = r121.f118149w;
        String r123 = r121.f118150x;
        boolean r124 = r121.f118129c.f118109m;
        Episode r125 = r121.f118132f;
        if (r101 != null) goto L138;
        r101 = new ls2.e(-1);
        r101.setReasonV2(r112);
        Unit r126 = Unit.INSTANCE;
    L138:
        r120.fX(r122, r123, r124, r125, r101);
        return;
    L113:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a == false) goto L124;
        Context r127 = this.f109944b;
        if (r127 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L117:
        if (r127 == null) goto L134;
        if (TextUtils.isEmpty(r102) == true) goto L134;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.x().a(r127, r102) == true) goto L134;
        Toast.makeText(r127, r102, 0).show();
        goto L134
    L124:
        Context r128 = this.f109944b;
        if (r128 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L127:
        if (r128 == null) goto L134;
        if (TextUtils.isEmpty(r102) == true) goto L134;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.x().c(r128, r102) == true) goto L134;
        Toast.makeText(r128, r102, 0).show();
        goto L134
    L55:
        if (Intrinsics.areEqual(r112, EndReason.PLAYER_ERROR.INSTANCE) == true) goto L110;
        if (Intrinsics.areEqual(r112, EndReason.EMPTY_URL.INSTANCE) == false) goto L88;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a == false) goto L75;
        Context r129 = this.f109944b;
        if (r129 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L64:
        Context r130 = this.f109944b;
        if (r130 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L67:
        String r131 = r130.getResources().getString(R.string.ttlive_replay_live_enter_failed);
        if (r129 != null) goto L70;
    L86:
        this.f109946d.f118130d.f118060n.setValue(Boolean.TRUE);
        goto L135
    L70:
        if (TextUtils.isEmpty(r131) == true) goto L86;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.x().a(r129, r131) == true) goto L86;
        Toast.makeText(r129, r131, 0).show();
        goto L86
    L75:
        Context r132 = this.f109944b;
        if (r132 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L78:
        if (r132 != null) goto L80;
        r132 = s1.getContext();
    L80:
        String r133 = r132.getString(R.string.ttlive_replay_live_enter_failed);
        if (TextUtils.isEmpty(r133) == true) goto L86;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.x().c(r132, r133) == true) goto L86;
        Toast.makeText(r132, r133, 0).show();
        goto L86
    L88:
        if (Intrinsics.areEqual(r112, EndReason.PING_LOST_FOCUS.INSTANCE) == false) goto L90;
    L104:
        com.bytedance.android.livesdk.chatroom.vs_base.base.api.b.a.a(a(), g.class);
        DataCenter r134 = this.f109946d.f118151y;
        if (r134 == null) goto L109;
        vlc.d r135 = (vlc.d) r134.get("data_message_manager", null);
        if (r135 == null) goto L109;
        r135.r(true);
    L109:
        this.f109946d.f118130d.f118070x.setValue(Boolean.TRUE);
        this.f109946d.getClass();
        goto L135
    L90:
        if (Intrinsics.areEqual(r112, EndReason.BACKGROUND_TIMEOUT.INSTANCE) == true) goto L104;
        if (Intrinsics.areEqual(r112, EndReason.JUMP_TO_OTHER.INSTANCE) == false) goto L95;
    L103:
        c();
        goto L135
    L95:
        if (Intrinsics.areEqual(r112, EndReason.JUMP_TO_OTHER_MIX_ROOM.INSTANCE) == true) goto L103;
        if (Intrinsics.areEqual(r112, EndReason.STOP_WITHOUT_RELEASE_PLAYER.INSTANCE) == false) goto L101;
        c();
        goto L135
    L101:
        if (Intrinsics.areEqual(r112, EndReason.USER_CLOSE.INSTANCE) == false) goto L135;
        c();
        this.f109946d.f118130d.f118060n.setValue(Boolean.TRUE);
        goto L135
    L33:
        r107 = null;
    L19:
        Context r136 = this.f109944b;
        if (r136 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L22:
        r102 = r136.getString(R.string.ttlive_replay_live_enter_failed);
        goto L23
    }

    public b(h r100, ReplayVideoEngine.a r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "lifecycleObserver");
        this.f109946d = r100;
        this.f109947e = r101;
        this.f109945c = true;
    }
}
