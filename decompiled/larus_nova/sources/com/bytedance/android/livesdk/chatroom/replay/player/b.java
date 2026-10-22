package com.bytedance.android.livesdk.chatroom.replay.player;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.replay.element.ReplayPlayerWidget;
import com.bytedance.android.livesdk.chatroom.replay.element.z;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayABSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.q;
import com.bytedance.android.livesdk.chatroom.vs_base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.u;
import com.bytedance.android.livesdkapi.replay.ReplayPlayerConfiger;
import com.bytedance.android.livesdkapi.vsplayer.ShareVideoData;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements com.bytedance.android.livesdk.chatroom.vs_base.player.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleMediaView f109555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public tic.a f109556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.bytedance.android.livesdk.chatroom.vs_base.player.d> f109557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f109558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f109559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f109560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f109561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f109562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f109563i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.vs_base.player.b f109564j;

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public void i() {
        int r100 = i.f109585a;
        i.a("onAttachedToFragment, episode_id = " + this.f109564j.id() + " ,scene = " + getScene().getDesc() + " hashCode = " + hashCode() + '}');
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public void o() {
        if (this.f109561g == false) goto L5;
        return;
    L5:
        VideoModel r100 = this.f109564j.c();
        this.f109555a.setPlayUrlConstructor(new sic.a());
        Resolution r101 = null;
        this.f109555a.setAttachListener(null);
        if (r100 == null) goto L8;
        int r102 = r.f118208a;
        this.f109564j.id();
        this.f109564j.e();
        r101 = r.a(r100);
    L8:
        ReplayPlayerConfiger r103 = new ReplayPlayerConfiger();
        r103.targetResolution = r101;
        this.f109555a.setVideoPlayConfiger(r103);
        LayerHostMediaLayout r104 = this.f109555a.getLayerHostMediaLayout();
        if (r104 == null) goto L11;
        r104.setVideoPlayConfiger(r103);
    L11:
        this.f109555a.setLoop(true);
        this.f109555a.setUseSurfaceView(ReplayABSettingKeys.LIVE_REPLAY_PLAYER_USE_SURFACEVIEW.getValue().booleanValue());
        this.f109555a.setReleaseEngineEnabled(true);
        qic.d r105 = ShareVideoData.INSTANCE.getSnapshotInfo();
        if (this.f109564j.e() == false) goto L38;
        if (r105 == null) goto L38;
        SimpleMediaView r106 = this.f109555a;
        zic.b[] r107 = {new z()};
        LayerHostMediaLayout r108 = r106.f455992c;
        if (r108 == null) goto L17;
        r108.n0(r107);
    L27:
        this.f109555a.getLayerHostMediaLayout().setPlayEntity(g());
        this.f109555a.setPlayEntity(g());
        VideoContext r109 = VideoContext.n0(this.f109563i);
        r109.I0(this.f109555a);
        r109.G0(this.f109555a.getLayerHostMediaLayout());
        r105.f533263c = g();
        this.f109555a.setUseBlackCover(false);
        SimpleMediaView r110 = this.f109555a;
        LayerHostMediaLayout r111 = r110.f455992c;
        if (r111 == null) goto L30;
        r111.t0(r105);
    L37:
        this.f109555a.j();
    L39:
        SimpleMediaView r112 = this.f109555a;
        c r113 = a();
        VideoContext r114 = r112.f455994e;
        if (r114 == null) goto L42;
        r114.D0(r113);
    L42:
        this.f109561g = true;
        int r115 = i.f109585a;
        i.a("config simpleMediaView, episode_id = " + this.f109564j.id() + " ,scene = " + getScene().getDesc() + ", hasShareView = " + this.f109564j.e() + ", resolution = " + r101 + ", hashCode = " + hashCode());
        return;
    L30:
        VideoContext r116 = r110.f455994e;
        if (r116 == null) goto L37;
        if (r116.r0(r110) == false) goto L37;
        LayerHostMediaLayout r117 = r110.f455994e.f455949c;
        if (r117 == null) goto L37;
        r117.t0(r105);
        goto L37
    L17:
        VideoContext r118 = r106.f455994e;
        if (r118 != null) goto L20;
    L24:
        r106.e(r106.getContext());
        LayerHostMediaLayout r119 = r106.f455992c;
        if (r119 == null) goto L27;
        r119.n0(r107);
        goto L27
    L20:
        if (r118.r0(r106) == false) goto L24;
        LayerHostMediaLayout r120 = r106.f455994e.f455949c;
        if (r120 == null) goto L27;
        r120.n0(r107);
    L38:
        this.f109555a.setPlayEntity(g());
        goto L39
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public void p() {
        PlaybackParams r100 = this.f109555a.getPlayBackParams();
        if (r100 != null) goto L5;
        r100 = new PlaybackParams();
    L5:
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r101 = ReplayDataContext.a.a();
        if (r101 == null) goto L12;
        com.bytedance.live.datacontext.m<Float> r102 = r101.getVideoSpeed();
        if (r102 == null) goto L12;
        Float r103 = r102.getValue();
        if (r103 == null) goto L12;
        float r104 = r103.floatValue();
    L13:
        r100.setSpeed(r104);
        this.f109555a.setPlayBackParams(r100);
        if (this.f109562h == false) goto L18;
        a().k0(System.currentTimeMillis());
        int r105 = i.f109585a;
        i.a("do first play, on MediaView start slay, episode_id = " + this.f109564j.id() + " ,scene = " + getScene().getDesc() + " hashCode = " + hashCode() + '}');
        if (this.f109564j.e() == false) goto L19;
        a().B(this.f109555a.getVideoStateInquirer(), this.f109555a.getPlayEntity());
    L19:
        this.f109555a.k();
        this.f109562h = false;
        return;
    L18:
        int r106 = i.f109585a;
        i.a("do play, is playing = " + this.f109555a.h() + ", episode_id = " + this.f109564j.id() + " ,scene = " + getScene().getDesc() + " hashCode = " + hashCode() + '}');
    L12:
        r104 = 1.0f;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public void q() {
        if (this.f109560f == false) goto L5;
        return;
    L5:
        String r100 = this.f109564j.b();
        Resolution r101 = null;
        if (r100 == null) goto L10;
        mq1.c r102 = q.a();
        if (r102 == null) goto L10;
        Map<String, Pair<String, String>> r103 = r102.getLocalVideoPath(r100);
    L11:
        boolean r104 = false;
        if (r103 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == true) goto L30;
        Set<String> r106 = r103.keySet();
        if (r106 != null) goto L22;
    L25:
        boolean r107 = true;
    L26:
        if (r107 == true) goto L30;
        String r108 = (String) CollectionsKt.first(r103.keySet());
        Pair<String, String> r109 = r103.get(r108);
        if (r109 == null) goto L31;
        String r110 = r109.getFirst();
        String r111 = r109.getSecond();
    L32:
        VideoModel r112 = this.f109564j.c();
        if (r112 != null) goto L43;
        if (r111 != null) goto L36;
    L39:
        boolean r113 = true;
    L40:
        if (r113 == false) goto L43;
        int r114 = i.f109585a;
        i.a("config play entity, video model null invalid, episode_id = " + this.f109564j.id() + " ,scene = " + getScene().getDesc() + " ,hashCode = " + hashCode());
        return;
    L36:
        if (r111.length() == 0) goto L39;
        r113 = false;
    L43:
        tic.a r115 = g();
        if (this.f109564j.e() == true) goto L98;
        if (r111 != null) goto L47;
    L50:
        boolean r116 = true;
    L51:
        if (r116 == true) goto L98;
        r115.f546368f = r111;
        if (r110 != null) goto L56;
    L59:
        boolean r117 = true;
    L60:
        if (r117 == true) goto L62;
        r115.f546372j = r110;
    L62:
        ejc.b r118 = r115.f546377o;
        if (r112 == null) goto L74;
        Resolution[] r119 = r112.getSupportResolutions();
        if (r119 == null) goto L74;
        int r120 = r119.length;
        int r121 = 0;
    L67:
        if (r121 >= r120) goto L72;
        Resolution r122 = r119[r121];
        if (Intrinsics.areEqual(r122.toString(VideoRef.TYPE_VIDEO), r108) == true) goto L73;
        r121 = r121 + 1;
    L73:
        if (r122 == null) goto L74;
    L89:
        if (r122 != null) goto L97;
        Resolution[] r123 = Resolution.values();
        int r124 = r123.length;
        int r125 = 0;
    L91:
        if (r125 >= r124) goto L96;
        Resolution r126 = r123[r125];
        if (Intrinsics.areEqual(r126.toString(), r108) == true) goto L94;
        r125 = r125 + 1;
        goto L91
    L94:
        r101 = r126;
    L96:
        r122 = r101;
    L97:
        r118.f472909k = r122;
        this.f109558d = true;
    L99:
        r115.f546373k = "vs_long_video";
        r115.f546374l = "vs_video_enter";
        r115.f546375m = true;
        u r127 = this.f109564j.d();
        g().f546365c = r127.f118216a;
        g().f546377o.f472900b = false;
        this.f109560f = true;
        int r128 = i.f109585a;
        StringBuilder r129 = new StringBuilder("config play entity, episode_id = ");
        r129.append(this.f109564j.id());
        r129.append(" ,scene = ");
        r129.append(getScene().getDesc());
        r129.append(", hasShareView = ");
        r129.append(this.f109564j.e());
        r129.append(", isFromCache = ");
        if (r111 != null) goto L102;
    L103:
        r104 = true;
    L104:
        r129.append(!r104);
        r129.append(", startInfo = ");
        r129.append(r127.toString());
        r129.append(" hashCode = ");
        r129.append(hashCode());
        i.a(r129.toString());
        return;
    L102:
        if (r111.length() != 0) goto L104;
    L72:
        r122 = null;
    L74:
        if (r112 == null) goto L88;
        Resolution[] r130 = r112.getSupportResolutions();
        if (r130 == null) goto L88;
        int r131 = r130.length;
        int r132 = 0;
    L78:
        if (r132 >= r131) goto L88;
        r122 = r130[r132];
        String r133 = r122.toString(VideoRef.TYPE_VIDEO);
        if (r133 != null) goto L82;
    L84:
        boolean r134 = false;
    L85:
        if (r134 == true) goto L89;
        r132 = r132 + 1;
        goto L78
    L82:
        if (StringsKt.contains$default(r133, r108, false, 2, null) != true) goto L84;
        r134 = true;
    L88:
        r122 = null;
        goto L89
    L56:
        if (r110.length() == 0) goto L59;
        r117 = false;
        goto L60
    L47:
        if (r111.length() == 0) goto L50;
        r116 = false;
    L98:
        r115.f546366d = r112;
    L31:
        r111 = null;
        r110 = null;
        goto L32
    L22:
        if (r106.isEmpty() == true) goto L25;
        r107 = false;
    L30:
        r108 = "";
        goto L31
    L14:
        if (r103.isEmpty() == true) goto L17;
        r105 = false;
    L10:
        r103 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public void release() {
        int r100 = i.f109585a;
        i.a("release, episode_id = " + this.f109564j.id() + " ,scene = " + getScene().getDesc() + " hashCode = " + hashCode() + '}');
        this.f109555a.p(a());
        this.f109557c.clear();
        this.f109555a.m();
        b(new tic.a());
        this.f109562h = true;
        ConcurrentHashMap<Long, WeakReference<com.bytedance.android.livesdk.chatroom.vs_base.player.c>> r101 = m.f109599a;
        m.f109599a.remove(Long.valueOf(this.f109564j.id()));
        this.f109560f = false;
        this.f109561g = false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public final boolean m() {
        String r100 = g().f546368f;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public c a() {
        return this.f109559e;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public tic.a g() {
        return this.f109556b;
    }

    public final Context getContext() {
        return this.f109563i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public final SimpleMediaView h() {
        return this.f109555a;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public final com.bytedance.android.livesdk.chatroom.vs_base.player.b r() {
        return this.f109564j;
    }

    public void b(tic.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f109556b = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public final void j(f r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f109564j = r100;
        this.f109560f = false;
        this.f109561g = false;
        this.f109562h = false;
        int r101 = i.f109585a;
        i.a("updatePlayParams, episode_id = " + this.f109564j.id() + " ,scene = " + getScene().getDesc() + " hashCode = " + hashCode() + '}');
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public void k(com.bytedance.android.livesdk.chatroom.vs_base.player.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f109557c.contains(r100) == true) goto L6;
        this.f109557c.add(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public final void l(ReplayPlayerWidget.p r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f109557c.remove(r100);
    }

    public b(Context r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "playParams");
        this.f109563i = r100;
        this.f109564j = r101;
        this.f109555a = new SimpleMediaView(r100);
        this.f109556b = new tic.a();
        this.f109557c = new CopyOnWriteArrayList();
        this.f109559e = new a(this, new BaseReplayRoomPlayer$listenerDelegate$2(this));
        this.f109562h = true;
    }
}
