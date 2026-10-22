package com.bytedance.android.livesdk.player.statehandler;

import android.content.Context;
import android.view.Surface;
import com.bytedance.android.livesdk.player.Event;
import com.bytedance.android.livesdk.player.LivePlayerContext;
import com.bytedance.android.livesdk.player.LivePlayerService;
import com.bytedance.android.livesdk.player.LivePlayerSpmLogger;
import com.bytedance.android.livesdk.player.LivePlayerStateMachine;
import com.bytedance.android.livesdk.player.api.ITTLivePlayer;
import com.bytedance.android.livesdk.player.i0;
import com.bytedance.android.livesdk.player.utils.g;
import com.bytedance.android.livesdkapi.model.AudioFirst;
import com.bytedance.android.livesdkapi.model.AudioFrameDrop;
import com.bytedance.android.livesdkapi.model.LiveDynamicSRConfig;
import com.bytedance.android.livesdkapi.model.LiveStreamType;
import com.bytedance.android.livesdkapi.model.PlayerConfig;
import com.bytedance.android.livesdkapi.model.PlayerMixedAudioConfig;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class PlayingStateHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LivePlayerContext f156072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LivePlayerStateMachine f156073b;

    public final void a(final i0 r110) {
        Intrinsics.checkNotNullParameter(r110, "effect");
        if ((r110 instanceof i0.d) == true) goto L5;
        return;
    L5:
        this.f156072a.N.getEventController().onPlaying();
        LivePlayerSpmLogger.Companion.getClass();
        if (LivePlayerSpmLogger.access$getPlayerLoggerSimplifyV2$cp() == true) goto L8;
    L10:
        boolean r100 = false;
    L11:
        this.f156072a.e("PlayingStateHandler handle() " + r110, r100);
        final LivePlayerContext r101 = this.f156072a;
        final LiveRequest r102 = r101.f154925a;
        if (r102 != null) goto L14;
        return;
    L14:
        LivePlayerService r103 = LivePlayerService.INSTANCE;
        AudioFrameDrop r104 = null;
        if (((PlayerConfig) r103.getConfig(PlayerConfig.class)).getAudioFocusRefactor() == true) goto L17;
    L18:
        no2.a r105 = r101.L;
        if (r105 == null) goto L25;
        IRenderView r106 = r101.b();
        if (r106 == null) goto L23;
        Context r107 = r106.getContext();
    L24:
        r105.e(r107, ((i0.d) r110).f155404b, null);
        goto L25
    L23:
        r107 = null;
    L25:
        ITTLivePlayer r108 = r101.f154929e;
        if (r108 != null) goto L28;
        r101.e("play failed! player is null", true);
    L107:
        no2.a r109 = r101.L;
        if (r109 == null) goto L110;
        r109.d(false);
    L110:
        g.e(0, true, false, new PlayingStateHandler$handle$$inlined$run$lambda$2(r101, this, r110, r102), 5);
        LiveRequest r111 = this.f156072a.f154925a;
        if (r111 != null) goto L113;
        return;
    L113:
        if (r111.getInBackground() != true) goto L117;
        this.f156073b.e(Event.Background.INSTANCE);
        return;
    L117:
        return;
    L28:
        if (r102.getEnableSetAudioAddrAfterPlay() == false) goto L30;
        LiveRequest r112 = r102;
    L31:
        if (r112 == null) goto L33;
        r108.R();
    L33:
        Long r113 = Long.valueOf(r102.getAudioAddr());
        if (r113.longValue() == (-1)) goto L36;
        boolean r114 = true;
    L37:
        if (r114 == true) goto L40;
        r113 = null;
    L40:
        if (r113 == null) goto L42;
        r108.setProcessAudioAddr(r113.longValue());
    L42:
        Surface r115 = r101.K;
        if (r115 == null) goto L45;
        r101.N.setSurfaceDisplay(r115);
    L45:
        i0.d r116 = (i0.d) r110;
        r108.setMute(r116.f155404b);
        if (((PlayerMixedAudioConfig) r103.getConfig(PlayerMixedAudioConfig.class)).getEnableMixedAudioCheck() == true) goto L48;
    L50:
        AudioFirst r117 = r102.getAudioFirst();
        if (r117 == null) goto L85;
        Integer r118 = r117.getEnable();
        if (r118 != null) goto L56;
    L57:
        boolean r119 = true;
    L59:
        if (r119 == true) goto L62;
        r117 = null;
    L62:
        if (r117 == null) goto L85;
        Integer r120 = r117.getEnable();
        if (r120 == null) goto L85;
        int r121 = r120.intValue();
        ITTLivePlayer r122 = r101.f154929e;
        if (r122 == null) goto L85;
        if (r121 != 1) goto L84;
        Integer r123 = r117.getEnableMute();
        if (r123 == null) goto L84;
        if (r123.intValue() != 0) goto L84;
        if (Intrinsics.areEqual(r101.M.f155071p.getValue(), Boolean.TRUE) == false) goto L77;
    L80:
        boolean r124 = true;
    L81:
        if (r124 == false) goto L83;
        r121 = 0;
        goto L84
    L83:
        r121 = 1;
        goto L84
    L77:
        if (r122.getVolume() < 1.0d) goto L80;
        r124 = false;
    L84:
        r122.Z(r121);
        goto L85
    L56:
        if (r118.intValue() != (-1)) goto L57;
        r119 = false;
    L85:
        AudioFrameDrop r125 = r102.getAudioFrameDrop();
        if (r125 == null) goto L105;
        Integer r126 = r125.getEnable();
        if (r126 != null) goto L91;
    L92:
        boolean r127 = true;
    L94:
        if (r127 == false) goto L96;
        r104 = r125;
    L96:
        if (r104 == null) goto L105;
        Integer r128 = r104.getEnable();
        if (r128 == null) goto L105;
        int r129 = r128.intValue();
        Integer r130 = r104.getCount();
        if (r130 == null) goto L105;
        int r131 = r130.intValue();
        ITTLivePlayer r132 = r101.f154929e;
        if (r132 == null) goto L105;
        r132.v0(r129, r131);
        goto L105
    L91:
        if (r126.intValue() != (-1)) goto L92;
        r127 = false;
    L105:
        r108.start();
        b(r102);
        goto L107
    L48:
        if ((!Intrinsics.areEqual(r101.M.f155071p.getValue(), Boolean.valueOf(r116.f155404b))) == false) goto L50;
        g.e(0, true, false, new PlayingStateHandler$handle$$inlined$run$lambda$1(r101, this, r110, r102), 5);
        goto L50
    L36:
        r114 = false;
        goto L37
    L30:
        r112 = null;
        goto L31
    L17:
        if (((i0.d) r110).f155404b == true) goto L25;
    L8:
        if (Intrinsics.areEqual(this.f156072a.M.f155066k.getValue(), Boolean.TRUE) == false) goto L10;
        r100 = true;
        goto L11
    }

    public final void b(LiveRequest r100) {
        LivePlayerService r101 = LivePlayerService.INSTANCE;
        LiveDynamicSRConfig r102 = (LiveDynamicSRConfig) r101.getConfig(LiveDynamicSRConfig.class);
        if (r102.isFirstFrameDSREnable() == false) goto L7;
        ITTLivePlayer r103 = this.f156072a.f154929e;
        if (r103 == null) goto L7;
        r103.x0(r102.getAiServiceSrEnable());
    L7:
        LiveStreamType r104 = r100.getStreamType();
        LiveStreamType r105 = LiveStreamType.AUDIO;
        boolean r106 = true;
        if (r104 == r105) goto L10;
        boolean r107 = true;
    L11:
        ITTLivePlayer r108 = this.f156072a.f154929e;
        if (r108 == null) goto L14;
        r108.t0(r107);
    L14:
        ITTLivePlayer r109 = this.f156072a.f154929e;
        if (r109 == null) goto L17;
        r109.C0(false);
    L17:
        boolean r110 = r101.clientIsPreviewUse(this.f156072a.N);
        if (r100.getStreamType() == r105) goto L23;
        if (r110 == false) goto L25;
        if (r102.getPreviewEnableSr() == false) goto L23;
    L25:
        if (r102.isPlayingDSREnable() == false) goto L29;
        ITTLivePlayer r111 = this.f156072a.f154929e;
        if (r111 == null) goto L29;
        r111.x0(false);
    L29:
        ITTLivePlayer r112 = this.f156072a.f154929e;
        if (r112 == null) goto L33;
        r112.setEnableSr(r106);
        return;
    L33:
        return;
    L23:
        r106 = false;
        goto L25
    L10:
        r107 = false;
        goto L11
    }

    public PlayingStateHandler(LivePlayerContext r100, LivePlayerStateMachine r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "livePlayerStateMachine");
        this.f156072a = r100;
        this.f156073b = r101;
    }
}
