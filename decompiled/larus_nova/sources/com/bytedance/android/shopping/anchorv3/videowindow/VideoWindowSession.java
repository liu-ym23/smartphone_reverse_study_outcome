package com.bytedance.android.shopping.anchorv3.videowindow;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.i2;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.h;
import com.bytedance.android.shopping.anchorv4.dto.business.BottomRightControl;
import com.bytedance.android.shopping.anchorv4.dto.business.BottomRightWidgetParam;
import com.bytedance.android.shopping.extensions.k;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/videowindow/VideoWindowSession;", "Landroidx/lifecycle/LifecycleObserver;", "Lfj/e;", "Ll53/a;", "", LiveCommonConstants.REASON_ON_DEDTROY, "onPause", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoWindowSession implements LifecycleObserver, fj.e, l53.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f165362t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f165363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f165364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f165365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f165366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f165367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f165368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f165369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f165370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f165371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f165372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f165373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Float f165374l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final FrameLayout f165375m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final fj.d f165376n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lifecycle f165377o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f165378p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final vg3.c f165379q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final BottomRightControl f165380r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv3.videowindow.a f165381s;

    public static final class a {
        public static String b(String r100, Map r101) {
            String r102 = null;
            if (r101 == null) goto L5;
            String r103 = (String) r101.get("search_params");
        L6:
            if (r101 == null) goto L8;
            String r104 = (String) r101.get("source_page");
        L10:
            if (r101 == null) goto L12;
            String r105 = (String) r101.get(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE);
        L14:
            if (k.c(r103) == false) goto L45;
            if (r100 != null) goto L17;
            return null;
        L17:
            UrlBuilderV2 r106 = new UrlBuilderV2(r100);
            JSONObject r107 = new JSONObject();
            JSONObject r108 = new JSONObject(r103);     // Catch: Exception -> L20
        L21:
            r107.put("search_params", r108);
            Unit r109 = Unit.INSTANCE;
            r106.addOrReplaceParam(com.bytedance.android.ec.core.event.a.KEY_TRACKER, r107.toString());
            String r110 = new JSONObject(r103).toString();     // Catch: Exception -> L24
        L25:
            r106.addOrReplaceParam("search_params", r110);
            if (r104 != null) goto L28;
        L33:
            if (r105 == null) goto L40;
            if (k.c(r105) == false) goto L37;
            r102 = r105;
        L37:
            if (r102 == null) goto L40;
            r106.addOrReplaceParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r102);
        L40:
            return r106.build();
        L28:
            if (k.c(r104) == true) goto L31;
            r104 = null;
        L31:
            if (r104 == null) goto L33;
            r106.addOrReplaceParam("enter_from", r104);
        L24:
            r110 = "";
        L20:
            r108 = new JSONObject();
            goto L21
        L45:
            return r100;
        L12:
            r105 = null;
            goto L14
        L8:
            r104 = null;
            goto L10
        L5:
            r103 = null;
            goto L6
        }

        public static VideoWindowSession a(FrameLayout r100, fj.d r110, Lifecycle r111, String r112, vg3.c r113, com.bytedance.android.shopping.anchorv3.videowindow.a r114, BottomRightControl r115) {
            Intrinsics.checkNotNullParameter(r100, "worldBox");
            Intrinsics.checkNotNullParameter(r110, "playInfo");
            Intrinsics.checkNotNullParameter(r111, NewBroadcastMonitor.STAGE.LIFECYCLE);
            return new VideoWindowSession(r100, r110, r111, r112, r113, r115, r114);
        }
    }

    static {
    }

    @Override // fj.e
    public final void B0() {
    }

    @Override // fj.e
    public final void R2() {
    }

    @Override // fj.e
    public final void e() {
    }

    public final ImageView g() {
        return (ImageView) this.f165368f.getValue();
    }

    public final h h() {
        return (h) this.f165366d.getValue();
    }

    public final RelativeLayout i() {
        return (RelativeLayout) this.f165364b.getValue();
    }

    @Override // fj.e
    public final void y(boolean r100) {
    }

    public final void f() {
        if (this.f165372j == true) goto L9;
        h().g0(true);
        h().release();
        this.f165375m.removeAllViews();
        this.f165377o.removeObserver(this);
        com.bytedance.android.shopping.anchorv3.videowindow.a r100 = this.f165381s;
        if (r100 == null) goto L7;
        r100.a();
    L7:
        this.f165372j = true;
        return;
    }

    @Override // fj.e
    public final void H() {
        i().setBackgroundColor(-16777216);
    }

    @Override // fj.e
    public final void Z2() {
        g().setImageResource(R.drawable.anchor_v3_hao_wu_video_pause);
        b r100 = this.f165373k;
        if (r100 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f r101 = r100.f167580d;
        if (r101 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f.a.b(r101, r100, false, 6);
    L7:
        Float r102 = this.f165374l;
        if (r102 == null) goto L11;
        float r103 = r102.floatValue();
        h().seek(r103);
        this.f165374l = null;
        return;
    }

    @Override // l53.a
    public final void a() {
        h().pause();
    }

    @Override // l53.a
    public final void b() {
        h().a(true);
        this.f165371i = true;
        ((ImageView) this.f165369g.getValue()).setImageResource(R.drawable.anchor_v3_little_video_icon_audio_off);
    }

    @Override // l53.a
    public final boolean isPlaying() {
        return h().isPlaying();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (isPlaying() == false) goto L9;
        b r100 = this.f165373k;
        if (r100 == null) goto L9;
        com.bytedance.android.shopping.anchorv4.video.f r101 = r100.f167580d;
        if (r101 == null) goto L9;
        r101.a(r100);
    L9:
        h().pause();
    }

    @Override // l53.a
    public final boolean c() {
        return this.f165371i;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        f();
    }

    @Override // fj.e
    public final void Q(float r100) {
        TextView r101 = (TextView) this.f165370h.getValue();
        int r102 = i2.f45613a;
        r101.setText(i2.a((long) (this.f165376n.f477439f * (1 - (r100 / 100.0f)))));
    }

    public final void d(boolean r100) {
        boolean r101 = !this.f165371i;
        this.f165371i = r101;
        if (r100 == false) goto L11;
        com.bytedance.android.shopping.anchorv3.videowindow.a r102 = this.f165381s;
        if (r102 == null) goto L11;
        String r103 = this.f165376n.f477436c;
        if (r101 == false) goto L9;
        String r104 = ITTVideoEngineEventSource.KEY_MUTE;
    L10:
        r102.c(r103, r104);
        goto L11
    L9:
        r104 = "unmute";
    L11:
        b r105 = this.f165373k;
        if (r105 == null) goto L14;
        r105.n(this.f165371i, r100);
    L14:
        h().a(this.f165371i);
        ImageView r106 = (ImageView) this.f165369g.getValue();
        if (this.f165371i == false) goto L17;
        int r107 = R.drawable.anchor_v3_little_video_icon_audio_off;
    L18:
        r106.setImageResource(r107);
        j(this, false, 3);
        return;
    L17:
        r107 = R.drawable.anchor_v3_little_video_icon_audio_on;
        goto L18
    }

    @Override // fj.e
    public final void m3(boolean r100) {
        g().setImageResource(R.drawable.anchor_v3_hao_wu_video_play);
        b r101 = this.f165373k;
        if (r101 == null) goto L8;
        com.bytedance.android.shopping.anchorv4.video.f r102 = r101.f167580d;
        if (r102 == null) goto L9;
        com.bytedance.android.shopping.anchorv4.video.f.a.a(r102, r101, false, false, 6);
        return;
    L9:
        return;
    }

    public final void k(com.bytedance.android.shopping.anchorv4.video.f r100, Boolean r110) {
        Intrinsics.checkNotNullParameter("float_video", "scene");
        Intrinsics.checkNotNullParameter(r100, "playerStateManager");
        if (this.f165373k != null) goto L5;
        b r101 = new b(this, r100, r100, r110);
        r100.c(r101);
        Unit r102 = Unit.INSTANCE;
        this.f165373k = r101;
    L5:
        b r103 = this.f165373k;
        if (r103 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.video.f r111 = r103.f167580d;
        if (r111 == null) goto L10;
        boolean r104 = r111.h(r103);
    L11:
        this.f165371i = r104;
        ImageView r105 = (ImageView) this.f165369g.getValue();
        if (this.f165371i == false) goto L14;
        int r112 = R.drawable.anchor_v3_little_video_icon_audio_off;
    L15:
        r105.setImageResource(r112);
        View r106 = (View) this.f165367e.getValue();
        if (r106 == null) goto L18;
        r106.setOnClickListener(new c(this));
    L18:
        g().setOnClickListener(new d(this));
        TextView r107 = (TextView) this.f165370h.getValue();
        int r113 = i2.f45613a;
        r107.setText(i2.a(this.f165376n.f477439f));
        ((ImageView) this.f165369g.getValue()).setOnClickListener(new e(this));
        i().setOnClickListener(new f(this));
        vg3.c r108 = this.f165379q;
        if (r108 == null) goto L22;
        r108.b(this);
    L22:
        if (this.f165376n.f477441h == false) goto L24;
        h().C();
    L24:
        fj.d r109 = this.f165376n;
        long r114 = r109.f477448o;
        if (r114 <= 0) goto L29;
        long r115 = r109.f477439f;
        if (r115 <= 0) goto L29;
        this.f165374l = Float.valueOf(r114 / r115);
    L29:
        fj.d r116 = this.f165376n;
        BottomRightControl r117 = this.f165380r;
        ViewGroup.LayoutParams r118 = i().getLayoutParams();
        if (r118 != null) goto L32;
    L39:
        if (r117 == null) goto L51;
        BottomRightWidgetParam r119 = r117.getSmallWindow();
        if (r119 == null) goto L51;
        Integer r120 = r119.getBottomMargin();
        if (r120 == null) goto L51;
        int r121 = r120.intValue();
        RelativeLayout r122 = i();
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        if ((r123 instanceof ViewGroup.MarginLayoutParams) == true) goto L48;
        r123 = null;
    L48:
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r123;
        if (r124 == null) goto L51;
        r124.bottomMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(RangesKt.coerceAtLeast(0, r121 - 70)));
        r122.setLayoutParams(r124);
    L51:
        h().A(this);
        this.f165377o.addObserver(this);
        com.bytedance.android.shopping.anchorv3.videowindow.a r125 = this.f165381s;
        if (r125 == null) goto L54;
        r125.d();
    L54:
        com.bytedance.android.shopping.anchorv3.videowindow.a r126 = this.f165381s;
        if (r126 == null) goto L58;
        r126.e();
    L58:
        if (this.f165371i == false) goto L61;
        h().a(true);
        return;
    L61:
        return;
    L32:
        if (r116.f477437d <= r116.f477438e) goto L34;
        boolean r127 = true;
    L35:
        if (r127 == false) goto L37;
        int r128 = 210;
    L38:
        r118.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r128));
        r118.height = com.bytedance.android.shopping.extensions.b.b(Long.valueOf((((long) r128) * r116.f477438e) / r116.f477437d));
        goto L39
    L37:
        r128 = 110;
        goto L38
    L34:
        r127 = false;
        goto L35
    L14:
        r112 = R.drawable.anchor_v3_little_video_icon_audio_on;
    L10:
        r104 = this.f165371i;
        goto L11
    }

    public static void j(VideoWindowSession r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if (r100.f165371i == true) goto L17;
        if (r101 == false) goto L10;
    L12:
        vg3.c r103 = r100.f165379q;
        if (r103 == null) goto L16;
        r103.e(r100);
        return;
    L16:
        return;
    L10:
        if (r100.h().isPlaying() == true) goto L12;
        return;
    }

    public VideoWindowSession(FrameLayout r100, fj.d r101, Lifecycle r102, String r103, vg3.c r104, BottomRightControl r105, com.bytedance.android.shopping.anchorv3.videowindow.a r106) {
        Intrinsics.checkNotNullParameter(r100, "worldBox");
        Intrinsics.checkNotNullParameter(r101, "playInfo");
        Intrinsics.checkNotNullParameter(r102, NewBroadcastMonitor.STAGE.LIFECYCLE);
        this.f165375m = r100;
        this.f165376n = r101;
        this.f165377o = r102;
        this.f165378p = r103;
        this.f165379q = r104;
        this.f165380r = r105;
        this.f165381s = r106;
        this.f165363a = LazyKt.lazy(new VideoWindowSession$dragLayout$2(this));
        this.f165364b = LazyKt.lazy(new VideoWindowSession$wrapBox$2(this));
        this.f165365c = LazyKt.lazy(new VideoWindowSession$videoWrapBox$2(this));
        this.f165366d = LazyKt.lazy(new VideoWindowSession$playAbility$2(this));
        this.f165367e = LazyKt.lazy(new VideoWindowSession$closeBtn$2(this));
        this.f165368f = LazyKt.lazy(new VideoWindowSession$iconPlayStatus$2(this));
        this.f165369g = LazyKt.lazy(new VideoWindowSession$iconAudioStatus$2(this));
        this.f165370h = LazyKt.lazy(new VideoWindowSession$tvTimeSpan$2(this));
    }
}
