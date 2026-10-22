package com.bytedance.android.livesdk.chatroom.replay.floatwindow;

import am2.a0;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.player.ReplayPlayPauseView;
import com.bytedance.android.livesdk.chatroom.replay.view.ReplayDragRelativeLayout;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeVideo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IStartLocation;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.utils.Error;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends FrameLayout implements wq1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f108642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.replay.floatwindow.a f108643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f108644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f108645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f108646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f108647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f108648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a0 f108649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f108650i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f108651j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IReplayInnerProgressService f108652k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C1645b f108653l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f108654m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SimpleMediaView f108655n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DataCenter f108656o;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.floatwindow.b$b, reason: collision with other inner class name */
    public static final class C1645b extends nic.l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f108657a;

        @Override // nic.l.a, nic.h
        public final void B(nic.p r100, tic.a r101) {
        }

        @Override // nic.l.a, nic.h
        public final void R(oic.f r100, tic.a r101, boolean r102) {
        }

        @Override // nic.l.a, nic.h
        public final void d(oic.f r100, tic.a r101, boolean r102) {
        }

        @Override // nic.l.a, nic.h
        public final void o(oic.f r100, tic.a r101) {
        }

        @Override // nic.l.a, nic.h
        public final void q(oic.f r100, tic.a r101, int r102, int r103) {
        }

        public C1645b(b r100) {
            this.f108657a = r100;
        }

        @Override // nic.l.a, nic.h
        public final void W(oic.f r100, tic.a r101) {
            ((FrameLayout) this.f108657a.a(R.id.float_edge)).setVisibility(0);
            this.f108657a.e(true, false);
            b r102 = this.f108657a;
            if (r102.f108648g == true) goto L5;
            r102.f108645d = System.currentTimeMillis();
            b r103 = this.f108657a;
            r103.f108648g = true;
            b.b(r103);
        L5:
            this.f108657a.d();
        }

        @Override // nic.l.a, nic.h
        public final void b(oic.f r100, tic.a r101) {
            if (wq1.b.f560685c == false) goto L9;
            com.bytedance.android.livesdk.chatroom.replay.floatwindow.a r102 = this.f108657a.f108643b;
            if (r102 == null) goto L7;
            r102.onClose();
        L7:
            com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.a();
            wq1.b.f560685c = false;
            return;
        L9:
            b.c(this.f108657a);
            this.f108657a.f();
        }

        @Override // nic.l.a, nic.h
        public final void s(oic.f r100, tic.a r101) {
            b r102 = this.f108657a;
            r102.f108647f = System.currentTimeMillis();
        }

        @Override // nic.l.a, nic.h
        public final void v(oic.f r100, tic.a r101, Error r102) {
            b.c(this.f108657a);
        }

        @Override // nic.l.a, nic.h
        public final void m(oic.f r100, tic.a r101, int r102, int r103) {
            this.f108657a.g(r102, r103);
        }
    }

    static {
    }

    public final void d() {
        long r100 = this.f108647f;
        long r101 = this.f108645d;
        if (1 <= r101) goto L6;
    L8:
        this.f108647f = 0;
        return;
    L6:
        if (r100 <= r101) goto L8;
        this.f108646e += System.currentTimeMillis() - this.f108647f;
        goto L8
    }

    public final void f() {
        d();
        if (this.f108645d <= 0) goto L11;
        DataCenter r100 = this.f108656o;
        if (r100 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d r101 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r100);
        Pair[] r102 = new Pair[4];
        r102[0] = TuplesKt.to("vs_window_type", Argument.OUT);
        if (this.f108644c == false) goto L9;
        String r103 = "1";
    L10:
        r102[1] = TuplesKt.to("vs_is_mini_window_auto_play", r103);
        r102[2] = TuplesKt.to("vs_from_episode_id", String.valueOf(this.f108650i));
        r102[3] = TuplesKt.to("duration", String.valueOf((System.currentTimeMillis() - this.f108645d) - this.f108646e));
        r101.d("video_mini_window_play_duration", MapsKt.mutableMapOf(r102), new Object[]{this.f108649h});
        goto L11
    L9:
        r103 = "0";
    L11:
        this.f108645d = 0;
        this.f108646e = 0;
        this.f108647f = 0;
    }

    public static final void b(b r100) {
        DataCenter r101 = r100.f108656o;
        if (r101 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d r102 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r101);
        Pair[] r103 = new Pair[3];
        r103[0] = TuplesKt.to("vs_window_type", Argument.OUT);
        if (r100.f108644c == false) goto L7;
        String r104 = "1";
    L8:
        r103[1] = TuplesKt.to("vs_is_mini_window_auto_play", r104);
        r103[2] = TuplesKt.to("vs_from_episode_id", String.valueOf(r100.f108650i));
        r102.d("video_mini_window_play", MapsKt.mutableMapOf(r103), new Object[]{r100.f108649h});
        return;
    L7:
        r104 = "0";
        goto L8
    }

    public static final void c(b r110) {
        r110.getClass();
        mq1.t r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e();
        if (r100 == null) goto L5;
        mq1.p r101 = r100.a(r110.f108656o);
    L7:
        if (r101 == null) goto L188;
        Episode r102 = r101.nextReplayItem();
        if (r102 == null) goto L188;
        Long r103 = r110.f108650i;
        long r104 = r102.getId();
        if (r103 != null) goto L14;
    L16:
        boolean r105 = false;
    L17:
        Long r106 = Long.valueOf(r102.getId());
        r110.f108650i = r106;
        boolean r107 = wq1.b.f560683a;
        if (r106 == null) goto L20;
        long r108 = r106.longValue();
    L21:
        wq1.b.f560684b = r108;
        if (r105 == false) goto L28;
        SimpleMediaView r109 = r110.f108655n;
        if (r109 == null) goto L26;
        r109.k();
    L26:
        r110.f108644c = true;
    L187:
        r110.f108648g = false;
        int r111 = a0.L;
        r110.f108649h = a0.a.a(r102);
        goto L188
    L28:
        if (r102.video != null) goto L31;
    L42:
        boolean r112 = false;
    L43:
        if (r112 == false) goto L187;
        tic.a r113 = new tic.a();
        String r114 = r102.getPlayVideoModel();
        int r115 = com.bytedance.android.livesdk.chatroom.vs_base.util.r.f118208a;
        VideoModel r116 = com.bytedance.android.livesdk.chatroom.vs_base.util.r.e(r114);
        if (r116 == null) goto L49;
        VideoRef r117 = r116.getVideoRef();
        if (r117 == null) goto L49;
        String r118 = r117.mVideoId;
    L50:
        if (r118 != null) goto L52;
    L55:
        boolean r119 = true;
    L56:
        if (r119 == false) goto L58;
        r118 = r102.getPlayVideoId();
    L58:
        if (r118 == null) goto L62;
        mq1.c r120 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.q.a();
        if (r120 == null) goto L62;
        Map<String, Pair<String, String>> r121 = r120.getLocalVideoPath(r118);
    L63:
        if (r121 != null) goto L65;
    L68:
        boolean r122 = true;
    L69:
        String r123 = "";
        if (r122 == true) goto L83;
        Set<String> r124 = r121.keySet();
        if (r124 != null) goto L74;
    L77:
        boolean r125 = true;
    L78:
        if (r125 == true) goto L83;
        String r126 = (String) CollectionsKt.first(r121.keySet());
        Pair<String, String> r127 = r121.get(r126);
        if (r127 == null) goto L82;
        String r128 = r127.getFirst();
        r123 = r127.getSecond();
        String r129 = r128;
    L84:
        r113.f546368f = r123;
        if (r129.length() != 0) goto L87;
        boolean r130 = true;
    L88:
        if (r130 == true) goto L90;
        r113.f546372j = r129;
    L90:
        VideoResolutionItem r131 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.b(r126);
        String r132 = r131.getName();
        if (r132 == null) goto L93;
        boolean r133 = StringsKt.startsWith$default(r132, "超高清", false, 2, null);
    L94:
        if (r133 == true) goto L96;
        com.bytedance.android.livesdk.sharedpref.e<VideoResolutionItem> r134 = nq1.d.f520093b;
        r134.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r134, r131);
    L96:
        ejc.b r135 = r113.f546377o;
        if (r116 == null) goto L108;
        Resolution[] r136 = r116.getSupportResolutions();
        if (r136 == null) goto L108;
        int r137 = r136.length;
        int r138 = 0;
    L101:
        if (r138 >= r137) goto L106;
        Resolution r139 = r136[r138];
        if (Intrinsics.areEqual(r139.toString(VideoRef.TYPE_VIDEO), r126) == true) goto L107;
        r138 = r138 + 1;
    L107:
        if (r139 == null) goto L108;
    L123:
        r135.f472909k = r139;
        EpisodeVideo r140 = r102.video;
        if (r140 == null) goto L126;
        int r141 = (int) r140.getDuration();
    L127:
        r110.f108651j = r141 * ((int) 1000);
        r113.f546366d = r116;
        r113.f546363a = r118;
        r113.f546373k = "vs_long_video";
        r113.f546374l = "vs_video_enter";
        r113.f546375m = true;
        VideoResolutionItem r142 = nq1.d.f520093b.getValue();
        if (TextUtils.isEmpty(r142.getKey()) == true) goto L140;
        int r143 = com.bytedance.android.livesdk.chatroom.vs_base.util.r.f118208a;
        VideoModel r144 = com.bytedance.android.livesdk.chatroom.vs_base.util.r.e(r114);
        if (r144 == null) goto L139;
        Resolution[] r145 = r144.getSupportResolutions();
        if (r145 == null) goto L139;
        int r146 = r145.length;
        int r147 = 0;
    L134:
        if (r147 >= r146) goto L139;
        Resolution r148 = r145[r147];
        if (Intrinsics.areEqual(r148.toString(VideoRef.TYPE_VIDEO), r142.getKey()) == true) goto L137;
        r147 = r147 + 1;
        goto L134
    L137:
        Resolution r149 = r148;
    L145:
        if (r149 != null) goto L152;
        Resolution[] r150 = Resolution.getAllResolutions();
        int r151 = r150.length;
        int r152 = 0;
    L147:
        if (r152 >= r151) goto L152;
        if (Intrinsics.areEqual(r150[r152].toString(VideoRef.TYPE_VIDEO), r142.getKey()) == true) goto L152;
        r152 = r152 + 1;
    L152:
        jq1.c r153 = sq1.c.a(r102.getId());
        EpisodeVideo r154 = r102.video;
        long r155 = 0;
        if (r154 == null) goto L157;
        IStartLocation r156 = r154.getStartPosition();
        if (r156 == null) goto L157;
        long r157 = r156.getTime() * 1000;
    L158:
        EpisodeVideo r158 = r102.video;
        if (r158 == null) goto L163;
        IStartLocation r159 = r158.getStartPosition();
        if (r159 == null) goto L163;
        long r160 = 1000 * r159.getLoc();
    L165:
        if (r157 >= r153.f500021b) goto L172;
        long r161 = r153.f500020a;
        if (r161 == 0) goto L172;
        if (r161 >= (((long) r110.f108651j) - 5000)) goto L171;
        Long r162 = Long.valueOf(r161);
    L173:
        if (r162 == null) goto L175;
        long r163 = r162.longValue();
    L177:
        if (r163 <= 0) goto L180;
        if (r162 == null) goto L180;
        r155 = r162.longValue();
    L180:
        r113.f546365c = r155;
        r113.f546377o.f472900b = false;
        SimpleMediaView r164 = r110.f108655n;
        if (r164 == null) goto L183;
        r164.setPlayEntity(r113);
    L183:
        SimpleMediaView r165 = r110.f108655n;
        if (r165 == null) goto L186;
        r165.k();
    L186:
        r110.f108644c = true;
        goto L187
    L175:
        r163 = 0;
        goto L177
    L171:
        r162 = 0L;
    L172:
        r162 = Long.valueOf(r160);
    L163:
        r160 = -1;
    L157:
        r157 = 0;
    L139:
        r149 = null;
        goto L145
    L140:
        int r166 = com.bytedance.android.livesdk.chatroom.vs_base.util.r.f118208a;
        VideoModel r167 = com.bytedance.android.livesdk.chatroom.vs_base.util.r.e(r114);
        if (r167 == null) goto L143;
        Resolution[] r168 = r167.getSupportResolutions();
    L144:
        r149 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.a(r168, r110.getContext());
        goto L145
    L143:
        r168 = null;
        goto L144
    L126:
        r141 = 0;
        goto L127
    L106:
        r139 = null;
    L108:
        if (r116 == null) goto L122;
        Resolution[] r169 = r116.getSupportResolutions();
        if (r169 == null) goto L122;
        int r170 = r169.length;
        int r171 = 0;
    L112:
        if (r171 >= r170) goto L122;
        Resolution r172 = r169[r171];
        String r173 = r172.toString(VideoRef.TYPE_VIDEO);
        Resolution[] r174 = r169;
        if (r173 != null) goto L116;
    L118:
        boolean r175 = false;
    L119:
        if (r175 == true) goto L120;
        r171 = r171 + 1;
        r169 = r174;
        goto L112
    L120:
        r139 = r172;
        goto L123
    L116:
        if (StringsKt.contains$default(r173, r126, false, 2, null) != true) goto L118;
        r175 = true;
    L122:
        r139 = null;
        goto L123
    L93:
        r133 = false;
        goto L94
    L87:
        r130 = false;
        goto L88
    L82:
        r129 = "";
        goto L84
    L74:
        if (r124.isEmpty() == true) goto L77;
        r125 = false;
    L83:
        r129 = "";
        r126 = r129;
        goto L84
    L65:
        if (r121.isEmpty() == true) goto L68;
        r122 = false;
    L62:
        r121 = null;
        goto L63
    L52:
        if (r118.length() == 0) goto L55;
        r119 = false;
    L49:
        r118 = null;
        goto L50
    L31:
        if (r102.getPlayVideoModel() == null) goto L42;
        if (r102.getPlayVideoId() == null) goto L42;
        int r176 = com.bytedance.android.livesdk.chatroom.vs_base.util.r.f118208a;
        VideoModel r177 = com.bytedance.android.livesdk.chatroom.vs_base.util.r.e(r102.getPlayVideoModel());
        if (r177 == null) goto L42;
        if (r177.getSupportResolutions() == null) goto L42;
        r112 = true;
        goto L43
    L20:
        r108 = -1;
        goto L21
    L14:
        if (r103.longValue() != r104) goto L16;
        r105 = true;
    L188:
        if (r101 == null) goto L199;
        r101.playNext(true);
        return;
    L199:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public final View a(int r100) {
        if (this.f108642a != null) goto L5;
        this.f108642a = new LinkedHashMap();
    L5:
        View r101 = this.f108642a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f108642a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        com.bytedance.android.livesdk.chatroom.replay.floatwindow.a r101 = this.f108643b;
        if (r101 == null) goto L6;
        r101.onConfigurationChanged(r100);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    public final void setEpisodeId(Long r100) {
        this.f108650i = r100;
        boolean r101 = wq1.b.f560683a;
        if (r100 == null) goto L5;
        long r102 = r100.longValue();
    L6:
        wq1.b.f560684b = r102;
        return;
    L5:
        r102 = -1;
        goto L6
    }

    public final void setFloatViewListener(com.bytedance.android.livesdk.chatroom.replay.floatwindow.a r100) {
        this.f108643b = r100;
    }

    public final void e(boolean r100, boolean r101) {
        if (r101 == false) goto L12;
        if (r100 == false) goto L6;
        ((ReplayPlayPauseView) a(R.id.iv_play)).b();
    L7:
        SimpleMediaView r102 = this.f108655n;
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.h() != true) goto L25;
        this.f108655n.j();
        boolean r103 = wq1.b.f560683a;
        return;
    L25:
        return;
    L6:
        ReplayPlayPauseView r104 = (ReplayPlayPauseView) a(R.id.iv_play);
        r104.a();
        r104.setProgress(50.0f);
        r104.f109527m = false;
        goto L7
    L12:
        if (r100 == false) goto L14;
        ((ReplayPlayPauseView) a(R.id.iv_play)).c();
    L15:
        SimpleMediaView r105 = this.f108655n;
        if (r105 != null) goto L18;
    L19:
        SimpleMediaView r106 = this.f108655n;
        if (r106 == null) goto L22;
        r106.k();
    L22:
        boolean r107 = wq1.b.f560683a;
        return;
    L18:
        if (r105.h() == true) goto L22;
    L14:
        ReplayPlayPauseView r108 = (ReplayPlayPauseView) a(R.id.iv_play);
        r108.a();
        r108.setProgress(0.0f);
        r108.f109527m = true;
        goto L15
    }

    public final void g(int r100, int r101) {
        SimpleMediaView r102 = this.f108655n;
        if (r102 == null) goto L5;
        r102.c();
    L5:
        float r103 = r101 / r100;
        int r104 = RangesKt.coerceAtMost(UIUtils.getScreenWidth(getContext()), UIUtils.getScreenHeight(getContext()));
        ViewGroup.LayoutParams r105 = null;
        if (r100 <= r101) goto L26;
        int r106 = (r104 * 3) / 5;
        ViewGroup.LayoutParams r107 = a(R.id.float_backward).getLayoutParams();
        if ((r107 instanceof FrameLayout.LayoutParams) == true) goto L10;
        r107 = null;
    L10:
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107;
        if (r108 == null) goto L13;
        r108.leftMargin = s1.f(38.0f);
        r108.bottomMargin = s1.f(17.0f);
    L13:
        ViewGroup.LayoutParams r109 = a(R.id.float_forward).getLayoutParams();
        if ((r109 instanceof FrameLayout.LayoutParams) == true) goto L16;
        r109 = null;
    L16:
        FrameLayout.LayoutParams r110 = (FrameLayout.LayoutParams) r109;
        if (r110 == null) goto L19;
        r110.rightMargin = s1.f(38.0f);
        r110.bottomMargin = s1.f(17.0f);
    L19:
        ViewGroup.LayoutParams r111 = ((ReplayPlayPauseView) a(R.id.iv_play)).getLayoutParams();
        if ((r111 instanceof FrameLayout.LayoutParams) == false) goto L23;
        r105 = r111;
    L23:
        FrameLayout.LayoutParams r112 = (FrameLayout.LayoutParams) r105;
        if (r112 == null) goto L46;
        r112.bottomMargin = s1.f(17.0f);
    L46:
        int r113 = (int) (r106 * r103);
        SimpleMediaView r114 = this.f108655n;
        if (r114 != null) goto L49;
    L51:
        ReplayPlayPauseView r115 = (ReplayPlayPauseView) a(R.id.iv_play);
        r115.a();
        r115.setProgress(50.0f);
        r115.f109527m = false;
    L52:
        com.bytedance.android.livesdk.chatroom.replay.floatwindow.a r116 = this.f108643b;
        if (r116 == null) goto L56;
        r116.a(r106, r113);
        return;
    L56:
        return;
    L49:
        if (r114.h() != true) goto L51;
        ReplayPlayPauseView r117 = (ReplayPlayPauseView) a(R.id.iv_play);
        r117.a();
        r117.setProgress(0.0f);
        r117.f109527m = true;
        goto L52
    L26:
        ViewGroup.LayoutParams r118 = a(R.id.float_backward).getLayoutParams();
        if ((r118 instanceof FrameLayout.LayoutParams) == true) goto L29;
        r118 = null;
    L29:
        FrameLayout.LayoutParams r119 = (FrameLayout.LayoutParams) r118;
        if (r119 == null) goto L32;
        r119.leftMargin = s1.f(6.0f);
        r119.bottomMargin = s1.f(32.0f);
    L32:
        ViewGroup.LayoutParams r120 = a(R.id.float_forward).getLayoutParams();
        if ((r120 instanceof FrameLayout.LayoutParams) == true) goto L35;
        r120 = null;
    L35:
        FrameLayout.LayoutParams r121 = (FrameLayout.LayoutParams) r120;
        if (r121 == null) goto L38;
        r121.rightMargin = s1.f(6.0f);
        r121.bottomMargin = s1.f(32.0f);
    L38:
        ViewGroup.LayoutParams r122 = ((ReplayPlayPauseView) a(R.id.iv_play)).getLayoutParams();
        if ((r122 instanceof FrameLayout.LayoutParams) == false) goto L42;
        r105 = r122;
    L42:
        FrameLayout.LayoutParams r123 = (FrameLayout.LayoutParams) r105;
        if (r123 == null) goto L45;
        r123.bottomMargin = s1.f(32.0f);
    L45:
        r106 = r104 / 3;
        goto L46
    }

    public b(Context r100, Context r101, SimpleMediaView r102, DataCenter r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "activityContext");
        super(r100);
        this.f108654m = r101;
        this.f108655n = r102;
        this.f108656o = r103;
        this.f108642a = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_replay_video_float_view, this);
        a(R.id.float_close).setOnClickListener(new c(this));
        a(R.id.float_close).setContentDescription("关闭");
        a(R.id.float_mute).setOnClickListener(new d(this));
        a(R.id.float_mute).setContentDescription("声音打开/声音关闭");
        a(R.id.float_backward).setOnClickListener(new e(this));
        a(R.id.float_forward).setOnClickListener(new f(this));
        ((ReplayPlayPauseView) a(R.id.iv_play)).setOnClickListener(new g(this));
        ((ReplayDragRelativeLayout) a(R.id.float_drag_container)).f110281d = false;
        this.f108653l = new C1645b(this);
    }
}
