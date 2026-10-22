package com.bytedance.android.live.room.navi.tetris;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.IMiddlewareMicRoomService;
import com.bytedance.android.live.room.api.INavigationService;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.ui.d9;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.common.MarqueeTextView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeBasic;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/room/navi/tetris/LandscapeRoomNavigatorTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/d;", "Lo70/a;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeRoomNavigatorTetris extends LiveTetris<d90.d> implements o70.a, com.bytedance.android.livesdk.chatroom.vsplayer.model.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f99740o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f99741p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f99742q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f99743r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public MarqueeTextView f99744s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Disposable f99745t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LandscapeRoomNavigatorTetris$timerListener$1 f99746u;

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(bh1.a.class);
    }

    public LandscapeRoomNavigatorTetris() {
        this.f99746u = new LandscapeRoomNavigatorTetris$timerListener$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        Room r100 = d90.e.j((d90.d) K());
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isMergeVSRoom() == false) goto L7;
    L34:
        TextView r101 = this.f99743r;
        Disposable r102 = null;
        if (r101 == null) goto L61;
        INavigationProxyService r103 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r103 == null) goto L41;
        l81.c r104 = r103.getDataCenterExtProxy();
        if (r104 == null) goto L41;
        EpisodeBasic r105 = r104.a(((d90.d) K()).f467480h);
    L42:
        if (r105 == null) goto L48;
        EpisodeMod r106 = r105.getMod();
        if (r106 == null) goto L48;
        if (r106.episodeStage != EpisodeMod.EpisodeStageType.PREMIERE) goto L48;
        String r107 = "首播";
    L49:
        if (r105 == null) goto L51;
        String r108 = r105.getCurrentPeriod();
    L53:
        if (TextUtils.isEmpty(r108) == false) goto L55;
        String r109 = r107.concat("  |  ");
    L60:
        r101.setText(r109);
        goto L61
    L55:
        StringBuilder r110 = new StringBuilder();
        r110.append(r107);
        r110.append("  |  ");
        if (r105 == null) goto L58;
        String r111 = r105.getCurrentPeriod();
    L59:
        r110.append(r111);
        r110.append(tb2.c.DEFAULT_TEXT);
        r109 = r110.toString();
        goto L60
    L58:
        r111 = null;
        goto L59
    L51:
        r108 = null;
    L48:
        r107 = "直播";
    L41:
        r105 = null;
    L61:
        ViewGroup r112 = this.f99741p;
        if (r112 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mLlTitle");
    L64:
        if (r112 == null) goto L66;
        UtilityKotlinExtentionsKt.w(r112);
    L66:
        ViewGroup r113 = this.f99740o;
        if (r113 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
    L69:
        if (r113 == null) goto L72;
        UtilityKotlinExtentionsKt.t(r113);
    L72:
        if (wt2.e.a() == false) goto L116;
        TextView r114 = this.f99742q;
        if (r114 == null) goto L76;
        r114.setVisibility(8);
    L76:
        MarqueeTextView r115 = this.f99744s;
        boolean r116 = false;
        if (r115 == null) goto L79;
        r115.setVisibility(0);
    L79:
        MarqueeTextView r117 = this.f99744s;
        if (r117 == null) goto L82;
        r117.setTextSize(1, 19.0f);
    L82:
        MarqueeTextView r118 = this.f99744s;
        if (r118 == null) goto L85;
        r118.setIncludeFontPadding(true);
    L85:
        MarqueeTextView r119 = this.f99744s;
        if (r119 == null) goto L88;
        r119.setSpeed(UtilityKotlinExtentionsKt.i(38));
    L88:
        MarqueeTextView r120 = this.f99744s;
        if (r120 == null) goto L91;
        r120.post(new m(this));
    L91:
        r r121 = z51.a.e(((d90.d) K()).f467480h);
        if (r121 == null) goto L98;
        com.bytedance.live.datacontext.m<Boolean> r122 = r121.J();
        if (r122 == null) goto L98;
        Boolean r123 = r122.getValue();
        if (r123 == null) goto L98;
        r116 = r123.booleanValue();
    L98:
        if (r116 == false) goto L102;
        MarqueeTextView r124 = this.f99744s;
        if (r124 == null) goto L105;
        r124.setTextWithEllipsis(V());
    L105:
        r r125 = z51.a.e(((d90.d) K()).f467480h);
        if (r125 == null) goto L108;
        com.bytedance.live.datacontext.j<d9> r126 = r125.n();
    L109:
        if (r126 != null) goto L111;
    L112:
        if (r126 == null) goto L114;
        final long r127 = 111;
        final long r128 = 1000;
        r126.e(new LandscapeRoomNavigatorTetris$startAnimationListener$1(r127, r128));
    L114:
        if (r126 == null) goto L119;
        r126.c(new LandscapeRoomNavigatorTetris$startAnimationListener$2(this));
    L119:
        o r129 = z51.a.h(((d90.d) K()).f467480h, 2);
        if (r129 == null) goto L126;
        com.bytedance.live.datacontext.m<Long> r130 = r129.q2();
        if (r130 == null) goto L126;
        Observable<Long> r131 = r130.a();
        if (r131 == null) goto L126;
        r102 = r131.subscribe(new n(this));
    L126:
        this.f99745t = r102;
        return;
    L111:
        if (r126.hasValue() == true) goto L114;
    L108:
        r126 = null;
        goto L109
    L102:
        MarqueeTextView r132 = this.f99744s;
        if (r132 == null) goto L105;
        r132.setTextWithFading(V());
        goto L105
    L116:
        TextView r133 = this.f99742q;
        if (r133 == null) goto L119;
        r133.setText(V());
        goto L119
    L7:
        if (r100.isVsRoom() == true) goto L34;
        ViewGroup r134 = this.f99741p;
        if (r134 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mLlTitle");
    L12:
        if (r134 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r134);
    L14:
        ViewGroup r135 = this.f99740o;
        if (r135 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
    L17:
        if (r135 == null) goto L19;
        UtilityKotlinExtentionsKt.w(r135);
    L19:
        IMiddlewareMicRoomService r136 = (IMiddlewareMicRoomService) jc1.k.f(IMiddlewareMicRoomService.class);
        ViewGroup r137 = this.f99740o;
        if (r137 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
    L22:
        if (r137 == null) goto L129;
        if (r136 != null) goto L25;
    L33:
        LiveTetris.Q(this, ((INavigationService) jc1.k.n(INavigationService.class)).getUserInfoWidget(((d90.d) K()).f467480h), r137, false, null, 24);
        return;
    L25:
        if (r136.isMicRoom(r100) == false) goto L33;
        INavigationProxyService r138 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r138 == null) goto L130;
        l81.o r139 = r138.getMicRoomService();
        if (r139 == null) goto L131;
        Class<? extends LiveRecyclableWidget> r140 = r139.getMicRoomOfficialInfoWidget();
        if (r140 == null) goto L132;
        LiveTetris.Q(this, r140, r137, false, null, 24);
        return;
    L132:
        return;
    L131:
        return;
    L130:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String V() {
        DataCenter r100 = ((d90.d) K()).f467480h;
        String r101 = null;
        if (r100 == null) goto L5;
        IRoom r102 = a0.n(r100);
    L6:
        nm1.m r103 = pm1.f.l();
        if (r103 == null) goto L23;
        VSCameraInfo r104 = r103.K(((d90.d) K()).f467480h);
        if (r104 == null) goto L23;
        if (r104.cameraType != VSCameraType.CAMERA_TYPE_MATCH.getValue()) goto L23;
        nm1.m r105 = pm1.f.l();
        if (r105 == null) goto L18;
        VSCameraInfo r106 = r105.K(((d90.d) K()).f467480h);
        if (r106 == null) goto L18;
        String r107 = r106.title;
        if (r107 == null) goto L18;
        return r107;
    L18:
        if (r102 == null) goto L30;
        IEpisodeExtraInfo r108 = r102.getEpisodeExtra();
        if (r108 == null) goto L30;
        r101 = r108.getTitle();
    L30:
        return String.valueOf(r101);
    L23:
        if (r102 == null) goto L28;
        IEpisodeExtraInfo r109 = r102.getEpisodeExtra();
        if (r109 == null) goto L28;
        r101 = r109.getTitle();
    L28:
        return String.valueOf(r101);
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        MarqueeTextView r100 = this.f99744s;
        if (r100 == null) goto L5;
        r100.cancelAnimation();
    L5:
        r r101 = z51.a.e(((d90.d) K()).f467480h);
        if (r101 == null) goto L12;
        com.bytedance.live.datacontext.j<d9> r102 = r101.n();
        if (r102 == null) goto L12;
        d9 r103 = r102.getValue();
        if (r103 == null) goto L12;
        r103.c(this.f99746u);
    L12:
        Disposable r104 = this.f99745t;
        if (r104 == null) goto L16;
        r104.dispose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r110) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r111 = r110.b(R.layout.ttlive_landscape_interaction_row_one);
        this.f99740o = (ViewGroup) r111.findViewById(R.id.user_info_container);
        this.f99741p = (ViewGroup) r111.findViewById(R.id.ll_title);
        this.f99742q = (TextView) r111.findViewById(R.id.tv_title);
        this.f99743r = (TextView) r111.findViewById(R.id.tv_desc);
        this.f99744s = (MarqueeTextView) r111.findViewById(R.id.marquee_title);
        if (d90.e.i((d90.d) K()) == false) goto L11;
        IVSPlayerService r100 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r101 = r100.provideVSPlayerViewControlService(((d90.d) K()).f467480h);
    L8:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r102 = r101;
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r102, PlayerViewControl.KEY.LandscapeRoomTitle, PlayerViewControl.Type.TOP, PlayerViewControl.Style.HIDE, r111, 0.0f, true, false, this, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME);
        goto L11
    L7:
        r101 = null;
    L11:
        return r111;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return d90.e.i((d90.d) K());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // o70.a
    public void onEvent(o70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof bh1.a) == false) goto L19;
        boolean r101 = ((bh1.a) r100).f18995a;
        r r102 = z51.a.e(((d90.d) K()).f467480h);
        if (r102 != null) goto L7;
    L10:
        if (r101 == false) goto L12;
    L11:
        int r103 = 0;
    L13:
        ViewGroup r104 = this.f99740o;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
    L16:
        if (r104 == null) goto L20;
        r104.setVisibility(r103);
        return;
    L20:
        return;
    L12:
        r103 = 4;
        goto L13
    L7:
        if (r102.isInVrLandscape(((d90.d) K()).f467480h) != true) goto L10;
        if (r101 == false) goto L11;
    }
}
