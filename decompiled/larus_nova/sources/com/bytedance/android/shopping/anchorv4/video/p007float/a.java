package com.bytedance.android.shopping.anchorv4.video.p007float;

import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.video.f;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.i;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import fj.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import x73.d;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DragRelativeLayout f167585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.video.p007float.c f167586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f167587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f167588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f167589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f167590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f167591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m f167592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f167593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f167594j;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.video.float.a$a, reason: collision with other inner class name */
    public static final class C2528a {
    }

    public static final class b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public gj.b f167595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f167596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f167597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f167598d;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.video.float.a$b$a, reason: collision with other inner class name */
        public static final class C2529a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f167599a;

            @Override // fj.e
            public final void B0() {
            }

            @Override // fj.e
            public final void Q(float r100) {
            }

            @Override // fj.e
            public final void R2() {
            }

            @Override // fj.e
            public final void y(boolean r100) {
            }

            @Override // fj.e
            public final void Z2() {
                a r100 = this.f167599a.f167598d;
                if (r100.f167587c == true) goto L9;
                r100.f167587c = true;
                Float r101 = r100.f167594j.f167620d.f167658h;
                if (r101 == null) goto L9;
                float r102 = r101.floatValue();
                gj.b r103 = this.f167599a.f167595a;
                if (r103 == null) goto L9;
                r103.seek(r102);
            L9:
                com.bytedance.android.shopping.anchorv4.video.p007float.c r104 = this.f167599a.f167598d.f167586b;
                if (r104 == null) goto L14;
                f r105 = r104.f167580d;
                if (r105 == null) goto L14;
                f.a.b(r105, r104, false, 6);
            L14:
                this.f167599a.f167598d.f167594j.getClass();
                this.f167599a.f167598d.f167592h.b();
                a r106 = this.f167599a.f167598d;
                r106.f167588d = SystemClock.elapsedRealtime();
                m r107 = this.f167599a.f167598d.f167592h;
                z r108 = r107.f167638a;
                if (r108 != null) goto L17;
                Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
            L17:
                ECDraweeView r109 = r108.getIvCover();
                if (r109 == null) goto L20;
                Object r110 = r109.getTag();
            L21:
                if (r110 != null) goto L43;
                z r111 = r107.f167638a;
                if (r111 != null) goto L26;
                Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
            L26:
                ECDraweeView r112 = r111.getIvCover();
                if (r112 == null) goto L29;
                r112.setTag(r107);
            L29:
                z r113 = r107.f167638a;
                if (r113 != null) goto L32;
                Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
            L32:
                ECDraweeView r114 = r113.getIvCover();
                if (r114 == null) goto L40;
                ViewPropertyAnimator r115 = r114.animate();
                if (r115 == null) goto L41;
                ViewPropertyAnimator r116 = r115.alpha(0.0f);
                if (r116 == null) goto L42;
                r116.setDuration(300);
                r116.setListener(new q(r107));
                r116.start();
                return;
            L42:
                return;
            L41:
                return;
            L40:
                return;
            L43:
                return;
            L20:
                r110 = null;
                goto L21
            }

            @Override // fj.e
            public final void e() {
                if (this.f167599a.f167598d.f167594j.a() == false) goto L6;
                s.a.a(this.f167599a, false, false, true, false, 10);
                return;
            }

            @Override // fj.e
            public final void H() {
                Z2();
            }

            public C2529a(b r100) {
                this.f167599a = r100;
            }

            @Override // fj.e
            public final void m3(boolean r100) {
                a r101 = this.f167599a.f167598d;
                if (r101.f167589e == false) goto L5;
                r101.f167589e = false;
            L6:
                Lazy r102 = UIUtils.f45548a;
                UIUtils.c().post(new com.bytedance.android.shopping.anchorv4.video.p007float.b(this));
                return;
            L5:
                r101.f167592h.b();
                goto L6
            }
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.p007float.s
        public final void d() {
            gj.b r100 = this.f167595a;
            if (r100 != null) goto L5;
        L10:
            this.f167598d.d();
            return;
        L5:
            if (r100.isPlaying() != true) goto L10;
            t r101 = this.f167598d.f167594j.f167622f;
            if (r101 == null) goto L12;
            r101.a();
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.p007float.s
        public final gj.b e() {
            w r100 = this.f167598d.f167594j.f167620d;
            if (this.f167595a != null) goto L30;
            boolean r101 = true;
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L16;
            a r102 = this.f167598d;
            if (r102.f167594j.f167620d.f167657g == null) goto L9;
            boolean r103 = true;
        L10:
            if (r103 == true) goto L21;
            z73.a<String, gj.b> r104 = PlayAbilityUtil.f164933a;
            com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r105 = r100.f167655e;
            ViewGroup r106 = r102.f167592h.getVideoContainer();
            PlayerViewScene r107 = r100.f167655e.f164973e;
            AVScene r108 = r100.f167654d;
            com.bytedance.android.shopping.api.video.d r109 = new com.bytedance.android.shopping.api.video.d(false, true, 0, 0, false, 509);
            if (this.f167598d.f167594j.f167620d.f167657g != null) goto L15;
            r101 = false;
        L15:
            r109.f170648h = r101;
            Unit r110 = Unit.INSTANCE;
            this.f167595a = PlayAbilityUtil.d(r105, r106, r107, r108, r109, PlayAbilityCacheScene.SCENE_FLOAT_VIDEO);
        L21:
            f();
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == true) goto L26;
            gj.b r111 = this.f167595a;
            if (r111 == null) goto L26;
            r111.t();
        L26:
            gj.b r112 = this.f167595a;
            if (r112 == null) goto L30;
            r112.A(new C2529a(this));
            goto L30
        L9:
            r103 = false;
            goto L10
        L16:
            z73.a<String, gj.b> r113 = PlayAbilityUtil.f164933a;
            com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r114 = r100.f167655e;
            ViewGroup r115 = this.f167598d.f167592h.getVideoContainer();
            PlayerViewScene r116 = r100.f167655e.f164973e;
            AVScene r117 = r100.f167654d;
            com.bytedance.android.shopping.api.video.d r118 = new com.bytedance.android.shopping.api.video.d(false, true, 0, 0, false, 509);
            if (this.f167598d.f167594j.f167620d.f167657g != null) goto L20;
            r101 = false;
        L20:
            r118.f170648h = r101;
            Unit r119 = Unit.INSTANCE;
            this.f167595a = PlayAbilityUtil.d(r114, r115, r116, r117, r118, null);
        L30:
            return this.f167595a;
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.p007float.s
        public final i getParams() {
            return this.f167598d.f167594j;
        }

        public final void f() {
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L16;
            x73.c r100 = this.f167598d.f167594j.f167620d.f167657g;
            if (r100 == null) goto L31;
            gj.b r101 = r100.i(this.f167597c);
            this.f167595a = r101;
            if (r101 != null) goto L9;
            return;
        L9:
            r101.V(this.f167598d.f167592h.getVideoContainer(), true);
            boolean r102 = r101.isMute();
            if (this.f167596b == r102) goto L15;
            this.f167596b = r102;
            com.bytedance.android.shopping.anchorv4.video.p007float.c r103 = this.f167598d.f167586b;
            if (r103 == null) goto L14;
            r103.n(r102, false);
        L14:
            this.f167598d.f167592h.a();
        L15:
            r101.resume();
            return;
        L31:
            return;
        L16:
            gj.b r104 = this.f167595a;
            if ((r104 instanceof g) == true) goto L19;
            r104 = null;
        L19:
            g r105 = (g) r104;
            x73.c r106 = this.f167598d.f167594j.f167620d.f167657g;
            if (r105 == null) goto L33;
            if (r106 == null) goto L34;
            r105.H(r106.j(this.f167597c));
            boolean r107 = this.f167596b;
            i r108 = r106.f562819d;
            if (r108 != null) goto L25;
        L26:
            c(false);
        L27:
            gj.b r109 = e();
            if (r109 == null) goto L35;
            r109.resume();
            return;
        L35:
            return;
        L25:
            if (r107 == ((ECVideoPlayerView) r108).f()) goto L27;
        L34:
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.p007float.s
        public final boolean b() {
            return this.f167596b;
        }

        public b(a r100) {
            this.f167598d = r100;
            this.f167597c = new d();
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.p007float.s
        public final void c(boolean r100) {
            this.f167596b = !this.f167596b;
            gj.b r101 = e();
            if (r101 == null) goto L5;
            r101.a(this.f167596b);
        L5:
            com.bytedance.android.shopping.anchorv4.video.p007float.c r102 = this.f167598d.f167586b;
            if (r102 == null) goto L8;
            r102.n(this.f167596b, r100);
        L8:
            this.f167598d.f167592h.a();
            c r103 = this.f167598d.f167593i;
            boolean r104 = this.f167596b;
            r103.getClass();
            if (r104 == true) goto L11;
            String r105 = "open";
        L12:
            r103.b("pd_sound_icon_click", MapsKt.mapOf(TuplesKt.to("click_type", r105)));
            return;
        L11:
            r105 = "close";
            goto L12
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.p007float.s
        public final void a(boolean r100, boolean r101, boolean r102, boolean r103) {
            a r104 = this.f167598d;
            if (r104.f167594j.f167620d.f167657g == null) goto L5;
            boolean r105 = true;
        L6:
            if (r105 == false) goto L30;
            if (r101 == true) goto L30;
            gj.b r106 = null;
            if (r100 == true) goto L14;
            if (r102 == true) goto L14;
            if (r103 == true) goto L14;
            Boolean r107 = null;
        L15:
            x73.c r108 = this.f167598d.f167594j.f167620d.f167657g;
            if (r108 != null) goto L18;
        L21:
            this.f167598d.f167594j.f167619c.removeAllViews();
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == true) goto L37;
            gj.b r109 = this.f167595a;
            if ((r109 instanceof g) == false) goto L27;
            r106 = r109;
        L27:
            g r110 = (g) r106;
            if (r110 == null) goto L37;
            r110.d0();
        L37:
            t r111 = this.f167598d.f167594j.f167622f;
            if (r111 == null) goto L40;
            r111.onClose(r100);
        L40:
            a r112 = this.f167598d;
            com.bytedance.android.shopping.anchorv4.video.p007float.c r113 = r112.f167586b;
            if (r113 == null) goto L43;
            r112.f167594j.f167620d.f167651a.g(r113);
        L43:
            this.f167598d.f167593i.a(r102, "quit");
            return;
        L18:
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L20;
            r108.g(this.f167597c, Boolean.TRUE);
            goto L21
        L20:
            r108.h(this.f167597c, r107);
        L14:
            r104.pause();
            r107 = Boolean.FALSE;
        L30:
            gj.b r114 = this.f167595a;
            if (r114 == null) goto L33;
            r114.r();
        L33:
            gj.b r115 = this.f167595a;
            if (r115 == null) goto L36;
            r115.release();
        L36:
            this.f167598d.f167594j.f167619c.removeAllViews();
            goto L37
        L5:
            r105 = false;
            goto L6
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f167600a;

        public c(a r100) {
            this.f167600a = r100;
        }

        public final void a(boolean r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "stopType");
            if (this.f167600a.f167594j.a() == false) goto L6;
            return;
        L6:
            if (this.f167600a.f167588d >= 0) goto L8;
            return;
        L8:
            long r102 = SystemClock.elapsedRealtime();
            a r103 = this.f167600a;
            long r104 = r102 - r103.f167588d;
            r103.f167588d = -1;
            Pair[] r105 = new Pair[4];
            if (r100 == false) goto L11;
            String r106 = "1";
        L12:
            r105[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_PLAY_OVER, r106);
            r105[1] = TuplesKt.to("duration", Long.valueOf(r104));
            r105[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STOP_TYPE, r101);
            r105[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_VIDEO_SOURCE_TYPE, Integer.valueOf(k.f(this.f167600a.f167594j.f167620d.f167655e.h())));
            b("pd_video_play_time", MapsKt.mutableMapOf(r105));
            return;
        L11:
            r106 = "0";
            goto L12
        }

        public final void b(String r100, Map<String, ? extends Object> r110) {
            int r101 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
            AnchorV4TrackerImpl r102 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.f167600a.f167594j.f167617a);
            if (r102 == null) goto L14;
            LinkedHashMap r103 = new LinkedHashMap();
            Map<String, Object> r104 = this.f167600a.f167594j.f167623g;
            if (r104 == null) goto L7;
            r103.putAll(r104);
        L7:
            if (r110 == null) goto L9;
            r103.putAll(r110);
        L9:
            String r111 = this.f167600a.f167594j.f167620d.f167655e.j();
            if (r111 != null) goto L12;
            r111 = "";
        L12:
            r103.put("video_id", r111);
            Unit r112 = Unit.INSTANCE;
            r102.f167498c = r103;
            AnchorV4TrackerImpl.b(r102, r100, false, null, false, null, 30);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.p007float.r
    public final void Q0() {
        d83.c r100 = this.f167594j.f167617a.getHeadViewAbilityNew();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L12;
        if (this.f167594j.a() == false) goto L12;
        return;
    L12:
        if (c() == false) goto L18;
        this.f167589e = true;
        com.bytedance.android.shopping.anchorv4.video.p007float.c r102 = this.f167586b;
        if (r102 == null) goto L18;
        f r103 = r102.f167580d;
        if (r103 == null) goto L18;
        r103.a(r102);
    L18:
        pause();
        return;
    L5:
        if (r100.a() != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.p007float.r
    public final void a() {
        b r100 = this.f167591g;
        r100.getClass();
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L7;
        x73.c r101 = r100.f167598d.f167594j.f167620d.f167657g;
        if (r101 == null) goto L11;
        r101.g(r100.f167597c, Boolean.TRUE);
        return;
    L11:
        return;
    L7:
        x73.c r102 = r100.f167598d.f167594j.f167620d.f167657g;
        if (r102 == null) goto L13;
        d r103 = r100.f167597c;
        boolean r104 = x73.c.f562815f;
        r102.h(r103, null);
        return;
    }

    public final boolean c() {
        if (this.f167594j.a() == false) goto L5;
    L9:
        gj.b r100 = this.f167591g.e();
        if (r100 != null) goto L12;
    L14:
        return false;
    L12:
        if (r100.isPlaying() != true) goto L14;
        return true;
    L5:
        if (this.f167594j.f167620d.f167656f == false) goto L9;
        if (this.f167590f == true) goto L9;
        return true;
    }

    public final void d() {
        gj.b r100 = this.f167591g.e();
        if (r100 == null) goto L6;
        r100.play();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.p007float.r
    public final void onPageDestroy() {
        s.a.a(this.f167591g, false, true, false, false, 12);
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.p007float.r
    public final void pause() {
        gj.b r100 = this.f167591g.e();
        if (r100 == null) goto L5;
        r100.pause();
    L5:
        this.f167590f = true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.p007float.r
    public final void resume() {
        gj.b r100 = this.f167591g.e();
        if (r100 == null) goto L6;
        r100.resume();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.p007float.r
    public final void show() {
        DragRelativeLayout r100 = new DragRelativeLayout(this.f167594j.getContext());
        r100.setDockMode(2);
        boolean r101 = false;
        r100.f176420b = 0;
        r100.f176422d = 0;
        r100.f176421c = 0;
        r100.f176423e = 0;
        r100.setOnViewPositionChanged(new FloatVideo$initView$$inlined$apply$lambda$1(this));
        r100.setEnableKeepLayout(true);
        m r102 = this.f167592h;
        RelativeLayout.LayoutParams r103 = new RelativeLayout.LayoutParams(-2, -2);
        x r104 = this.f167594j.f167621e;
        r103.topMargin = r104.f167659a;
        if (r104.f167660b == false) goto L5;
        r103.addRule(11, -1);
    L5:
        Unit r105 = Unit.INSTANCE;
        r100.addView(r102, r103);
        r100.b();
        this.f167594j.f167619c.addView(r100);
        this.f167585a = r100;
        if (this.f167594j.f167621e.f167664f == false) goto L18;
        this.f167592h.setVisibility(4);
        m r106 = this.f167592h;
        if (ViewCompat.isLaidOut(r106) == true) goto L10;
    L16:
        r106.addOnLayoutChangeListener(new d(this, r100));
        goto L18
    L10:
        if (r106.isLayoutRequested() == true) goto L16;
        r106.setVisibility(0);
        if (this.f167594j.f167621e.f167660b == false) goto L14;
        r106.setTranslationX(r100.getWidth() - r106.getLeft());
    L15:
        r106.animate().translationX(0.0f).setDuration(300).start();
        goto L18
    L14:
        r106.setTranslationX(-r106.getRight());
    L18:
        if (this.f167594j.f167620d.f167656f == true) goto L21;
        this.f167592h.b();
    L21:
        if (this.f167586b != null) goto L23;
        w r107 = this.f167594j.f167620d;
        com.bytedance.android.shopping.anchorv4.video.p007float.c r108 = new com.bytedance.android.shopping.anchorv4.video.p007float.c(this, r107.f167651a, r107.f167652b);
        this.f167594j.f167620d.f167651a.c(r108);
        this.f167586b = r108;
    L23:
        Boolean r109 = this.f167594j.f167620d.f167653c;
        if (r109 == null) goto L26;
        this.f167591g.f167596b = r109.booleanValue();
    L33:
        gj.b r110 = this.f167591g.e();
        if (r110 == null) goto L36;
        r110.a(this.f167591g.f167596b);
    L36:
        this.f167592h.a();
        c r111 = this.f167593i;
        boolean r112 = this.f167591g.f167596b;
        r111.getClass();
        if (r112 == true) goto L39;
        String r113 = "open";
    L40:
        r111.b("pd_sound_icon_show", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ICON_STATUS, r113)));
        if (this.f167594j.f167620d.f167656f == true) goto L43;
    L58:
        t r114 = this.f167594j.f167622f;
        if (r114 == null) goto L62;
        r114.onShow();
        return;
    L62:
        return;
    L43:
        if (this.f167591g.f167598d.f167594j.f167620d.f167657g == null) goto L45;
        r101 = true;
    L45:
        if (r101 == true) goto L47;
        d();
    L51:
        if (c() == false) goto L58;
        Float r115 = this.f167594j.f167620d.f167658h;
        if (r115 == null) goto L57;
        float r116 = r115.floatValue();
        gj.b r117 = this.f167591g.e();
        if (r117 == null) goto L57;
        r117.seek(r116);
    L57:
        this.f167587c = true;
        goto L58
    L47:
        if (c() == true) goto L51;
        d();
        goto L51
    L39:
        r113 = "close";
        goto L40
    L26:
        b r118 = this.f167591g;
        com.bytedance.android.shopping.anchorv4.video.p007float.c r119 = this.f167586b;
        if (r119 == null) goto L31;
        f r120 = r119.f167580d;
        if (r120 == null) goto L31;
        boolean r121 = r120.h(r119);
    L32:
        r118.f167596b = r121;
    L31:
        r121 = r118.f167596b;
        goto L32
    }

    public a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f167594j = r100;
        this.f167588d = -1;
        b r101 = new b(this);
        this.f167591g = r101;
        this.f167592h = new m(r100.getContext(), r101);
        this.f167593i = new c(this);
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.p007float.r
    public final void b(x73.c r100) {
        Intrinsics.checkNotNullParameter(r100, "sharePlayer");
        b r101 = this.f167591g;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "sharePlayer");
        x73.c r102 = r101.f167598d.f167594j.f167620d.f167657g;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L9;
        if (r102 == null) goto L7;
        r102.g(r101.f167597c, Boolean.TRUE);
    L7:
        if ((!Intrinsics.areEqual(r100, r102)) == false) goto L14;
        r101.f167598d.f167594j.f167620d.f167657g = r100;
    L14:
        r101.f();
        return;
    L9:
        if (r102 == null) goto L12;
        d r103 = r101.f167597c;
        boolean r104 = x73.c.f562815f;
        r102.h(r103, null);
    L12:
        if ((!Intrinsics.areEqual(r100, r102)) == false) goto L14;
        r101.f167598d.f167594j.f167620d.f167657g = r100;
        goto L14
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.p007float.r
    public final void close(boolean r100) {
        s.a.a(this.f167591g, false, false, false, r100, 6);
    }
}
