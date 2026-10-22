package com.bytedance.android.live.ui;

import android.graphics.Path;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class c implements l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f102052u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f102053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f102054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f102055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f102056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f102057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f102058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animatable f102059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IVoiceLiveTheme f102060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.live.ui.b f102061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f102062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IVoiceLiveTheme f102063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f102064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f102065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f102066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HSImageView f102067o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HSImageView f102068p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public o f102069q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HSImageView f102070r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ImageView f102071s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.bytedance.android.live.ui.a f102072t;

    public static final class a {
    }

    public class b extends q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IVoiceLiveTheme f102073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f102074b;

        @Override // com.bytedance.android.live.core.utils.q0, com.bytedance.android.live.core.utils.p0
        public void a(ImageInfo r100, Animatable r101) {
        }

        @Override // com.bytedance.android.live.core.utils.q0
        public final void g(py.k r100) {
            com.bytedance.android.live.ui.a r101 = this.f102074b.f102072t;
            if (r101 == null) goto L5;
            r101.Ek(this.f102073a);
        L5:
            System.currentTimeMillis();
        }

        public b(c r100, IVoiceLiveTheme r101) {
            Intrinsics.checkNotNullParameter(r101, "theme");
            this.f102074b = r100;
            this.f102073a = r101;
        }

        @Override // com.bytedance.android.live.core.utils.q0
        public final void f(py.k r100, Exception r101) {
            com.bytedance.android.live.ui.a r102 = this.f102074b.f102072t;
            if (r102 == null) goto L6;
            r102.W9(false, this.f102073a);
            return;
        }

        @Override // com.bytedance.android.live.core.utils.q0
        public final void h(py.k r100, int r101, int r102) {
            com.bytedance.android.live.ui.a r103 = this.f102074b.f102072t;
            if (r103 == null) goto L6;
            r103.W9(true, this.f102073a);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.ui.c$c, reason: collision with other inner class name */
    public static final class RunnableC1548c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f102075a;

        public RunnableC1548c(c r100) {
            this.f102075a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o r100 = this.f102075a.f102069q;     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L4
            r100.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public void f() {
    }

    public abstract IVoiceLiveTheme g();

    public abstract int h();

    public final void j() {
        this.f102060h = null;
        HSImageView r100 = this.f102067o;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        this.f102053a = false;
        HSImageView r101 = this.f102068p;
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        this.f102059g = null;
        this.f102054b = false;
        HSImageView r102 = this.f102070r;
        if (r102 == null) goto L11;
        r102.setVisibility(8);
    L11:
        this.f102056d = false;
        o r103 = this.f102069q;
        if (r103 == null) goto L14;
        r103.c();
    L14:
        o r104 = this.f102069q;
        if (r104 == null) goto L17;
        r104.hide();
    L17:
        this.f102055c = false;
        ImageView r105 = this.f102071s;
        if (r105 == null) goto L20;
        r105.setVisibility(8);
    L20:
        this.f102057e = false;
    }

    public void o(Path r100) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.CLIP_PATH);
    }

    public abstract boolean q();

    public final void k() {
        if (this.f102062j == true) goto L13;
        this.f102062j = true;
        if (this.f102055c == false) goto L14;
        o r100 = this.f102069q;
        if (r100 == null) goto L9;
        r100.hide();
    L9:
        IVoiceLiveTheme r101 = this.f102063k;
        if (r101 == null) goto L15;
        i(r101);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void l() {
        if (this.f102053a == true) goto L8;
        HSImageView r100 = this.f102067o;
        if (r100 == null) goto L8;
        r100.setVisibility(8);
    L8:
        if (this.f102054b == true) goto L14;
        HSImageView r101 = this.f102068p;
        if (r101 == null) goto L12;
        r101.setVisibility(8);
    L12:
        this.f102059g = null;
    L14:
        if (this.f102055c == true) goto L19;
        o r102 = this.f102069q;
        if (r102 == null) goto L19;
        r102.hide();
    L19:
        if (this.f102056d == true) goto L24;
        HSImageView r103 = this.f102070r;
        if (r103 == null) goto L24;
        r103.setVisibility(8);
    L24:
        if (this.f102057e == true) goto L29;
        ImageView r104 = this.f102071s;
        if (r104 == null) goto L30;
        r104.setVisibility(8);
        return;
    L30:
        return;
    }

    public final void n() {
        if (this.f102062j == false) goto L11;
        this.f102062j = false;
        if (this.f102055c == false) goto L12;
        o r100 = this.f102069q;
        if (r100 == null) goto L9;
        r100.show();
    L9:
        l();
        return;
    L12:
        return;
    }

    public static final void e(c r100) {
        if (r100.f102055c == false) goto L24;
        o r101 = r100.f102069q;
        if (r101 == null) goto L25;
        boolean r102 = true;
        if (r101.isVisible() == true) goto L9;
        return;
    L9:
        if (r100.f102066n == false) goto L11;
    L13:
        r102 = false;
    L14:
        if (r102 == false) goto L27;
        o r103 = r100.f102069q;
        Intrinsics.checkNotNull(r103);
        if (r103.isPlaying() == false) goto L28;
        Object r104 = r100.f102069q;
        if ((r104 instanceof View) == true) goto L20;
        r104 = null;
    L20:
        View r105 = (View) r104;
        if (r105 == null) goto L29;
        r105.post(new d(r100));
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L11:
        if (r100.f102058f == true) goto L13;
    L25:
        return;
    }

    @Override // com.bytedance.android.live.ui.l
    public final void a(List<Pair<Float, Float>> r100) {
        HSImageView r101 = this.f102067o;
        if ((r101 instanceof ClipImageView) == false) goto L8;
        if (r101 == null) goto L7;
        ((ClipImageView) r101).setAlphaMask(r100);
        goto L8
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ui.ClipImageView");
    L8:
        HSImageView r102 = this.f102068p;
        if ((r102 instanceof ClipImageView) == false) goto L14;
        if (r102 == null) goto L13;
        ((ClipImageView) r102).setAlphaMask(r100);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ui.ClipImageView");
    }

    @Override // com.bytedance.android.live.ui.l
    public final void b(IVoiceLiveTheme r100) {
        if (r100 == null) goto L5;
        m(r100);
        return;
    }

    @Override // com.bytedance.android.live.ui.l
    public void c(IVoiceLiveTheme r100) {
        ALogger.i("[VideoTalk]BaseLiveBackground", "onUnload.theme:" + r100);
        j();
    }

    @Override // com.bytedance.android.live.ui.l
    public final void d(boolean r100) {
        if (this.f102058f != r100) goto L5;
        return;
    L5:
        if (this.f102066n == true) goto L54;
        this.f102058f = r100;
        if (this.f102055c == true) goto L16;
        if (this.f102054b == true) goto L16;
        if (r100 == false) goto L55;
        IVoiceLiveTheme r101 = this.f102060h;
        if (r101 == null) goto L56;
        m(r101);
        return;
    L56:
        return;
    L55:
        return;
    L16:
        if (this.f102054b == false) goto L37;
        HSImageView r102 = this.f102068p;
        if (r102 == null) goto L37;
        if (r102.getVisibility() != 0) goto L37;
        if (r100 == false) goto L29;
        Animatable r103 = this.f102059g;
        if (r103 == null) goto L37;
        if (r103.isRunning() == true) goto L37;
        Animatable r104 = this.f102059g;
        if (r104 == null) goto L37;
        r104.start();
        goto L37
    L29:
        Animatable r105 = this.f102059g;
        if (r105 == null) goto L37;
        if (r105.isRunning() != true) goto L37;
        Animatable r106 = this.f102059g;
        if (r106 == null) goto L37;
        r106.stop();
    L37:
        if (this.f102055c == false) goto L58;
        o r107 = this.f102069q;
        if (r107 != null) goto L41;
        return;
    L41:
        if (r107.isVisible() != true) goto L60;
        if (r100 == false) goto L46;
        o r108 = this.f102069q;
        Intrinsics.checkNotNull(r108);
        if (r108.isPlaying() == true) goto L61;
        o r109 = this.f102069q;
        Intrinsics.checkNotNull(r109);
        r109.tryResumePlay();
        return;
    L61:
        return;
    L46:
        Object r110 = this.f102069q;
        if ((r110 instanceof View) == true) goto L49;
        r110 = null;
    L49:
        View r111 = (View) r110;
        if (r111 == null) goto L63;
        r111.post(new RunnableC1548c(this));
        return;
    L63:
        return;
    L60:
        return;
    L58:
        return;
    }

    public final void i(IVoiceLiveTheme r100) {
        py.k r101 = null;
        if (r100 == null) goto L5;
        py.k r102 = r100.getStaticBackground();
    L7:
        if (IVoiceLiveThemeKt.isImageModelValid(r102) == false) goto L9;
        p(r100);
        return;
    L9:
        if (r100 == null) goto L12;
        r101 = r100.getSingleStaticBackground();
    L12:
        if (IVoiceLiveThemeKt.isImageModelValid(r101) == false) goto L19;
        HSImageView r103 = this.f102067o;
        if (r103 == null) goto L16;
        r103.setVisibility(0);
    L16:
        HSImageView r104 = this.f102067o;
        if (r104 == null) goto L32;
        k.c(r104, r100.getSingleStaticBackground(), h(), new b(this, r100));
        return;
    L32:
        return;
    L19:
        HSImageView r105 = this.f102067o;
        if (r105 == null) goto L22;
        r105.setVisibility(0);
    L22:
        HSImageView r106 = this.f102067o;
        if (r106 == null) goto L29;
        py.k r107 = g().getStaticBackground();
        int r108 = h();
        vh7.c r109 = jm2.a.d(g());
        if (r109 == null) goto L28;
        k.c(r106, r107, r108, new b(this, (IVoiceLiveTheme) r109));
        goto L29
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme");
    L29:
        this.f102053a = true;
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void m(IVoiceLiveTheme r100) {
        ALogger.i("[VideoTalk]BaseLiveBackground", "loadBackground.theme");
        this.f102060h = r100;
        HSImageView r101 = this.f102070r;
        if (r101 == null) goto L9;
        if (r100.getBgStatus() != 1) goto L7;
        r101.setVisibility(0);
        r101.setActualImageResource(R.drawable.ttlive_auditing_water_mask);
        this.f102056d = true;
        goto L9
    L7:
        r101.setVisibility(8);
        this.f102056d = false;
    L9:
        if (this.f102065m == false) goto L19;
        if (IVoiceLiveThemeKt.isLocalUgcTheme(r100) == false) goto L19;
        if (r100.getFormatType() != 1) goto L19;
        HSImageView r102 = this.f102067o;
        if (r102 == null) goto L17;
        r102.setVisibility(0);
    L17:
        ImageLoader.loadSdcardImage(this.f102067o, r100.getLocalPath());
        this.f102053a = true;
    L19:
        if (q() == false) goto L21;
    L100:
        i(r100);
        l();
        return;
    L21:
        if (this.f102066n == false) goto L23;
    L25:
        boolean r103 = false;
    L26:
        if (r103 == true) goto L100;
        com.bytedance.android.live.ui.b r104 = this.f102061i;
        if (r104 == null) goto L34;
        if (r104.a() != true) goto L34;
    L76:
        boolean r105 = false;
    L77:
        if (r105 == false) goto L80;
        l();
        return;
    L80:
        py.k r106 = null;
        if (r100 == null) goto L83;
        py.k r107 = r100.getAnimatedBackground();
    L85:
        if (IVoiceLiveThemeKt.isImageModelValid(r107) == false) goto L93;
        HSImageView r108 = this.f102068p;
        if (r108 == null) goto L89;
        r108.setVisibility(0);
    L89:
        HSImageView r109 = this.f102068p;
        if (r109 == null) goto L92;
        k.b(r109, r100.getAnimatedBackground(), new h(this, r100, r100), true);
    L92:
        this.f102054b = true;
    L93:
        if (r100 == null) goto L96;
        r106 = r100.getStaticBackground();
    L96:
        if (IVoiceLiveThemeKt.isImageModelValid(r106) == false) goto L98;
        p(r100);
    L98:
        l();
        return;
    L83:
        r107 = null;
    L34:
        if (this.f102069q == null) goto L72;
        IAnimatedBgInfo r110 = r100.getAnimatedBgInfo();
        if (r110 == null) goto L72;
        py.k r111 = r110.getAnimatedBg();
        if (r111 == null) goto L72;
        List<String> r112 = r111.getUrls();
        if (r112 == null) goto L72;
        if (r112.isEmpty() == true) goto L47;
    L49:
        ImageView r113 = this.f102071s;
        if (r113 == null) goto L52;
        r113.setVisibility(0);
    L52:
        this.f102057e = true;
        if (IVoiceLiveThemeKt.isVideoTheme(r100) == false) goto L63;
        if (this.f102062j == false) goto L57;
        i(r100);
    L58:
        this.f102055c = true;
        this.f102063k = r100;
        if (IVoiceLiveThemeKt.isLocalUgcTheme(r100) == false) goto L61;
        o r114 = this.f102069q;
        Intrinsics.checkNotNull(r114);
        r114.d(r100.getLocalPath(), "", new e(this, r100));
    L71:
        r105 = true;
        goto L77
    L61:
        o r115 = this.f102069q;
        Intrinsics.checkNotNull(r115);
        r115.d((String) ListProtector.get(r112, 0), r111.getUri(), new f(this, r100));
        goto L71
    L57:
        o r116 = this.f102069q;
        Intrinsics.checkNotNull(r116);
        r116.show();
        goto L58
    L63:
        if (IVoiceLiveThemeKt.isImageModelValid(r110.getAnimatedBg()) == false) goto L72;
        HSImageView r117 = this.f102068p;
        if (r117 == null) goto L67;
        r117.setVisibility(0);
    L67:
        HSImageView r118 = this.f102068p;
        if (r118 == null) goto L70;
        k.b(r118, r110.getAnimatedBg(), new b(this, r100), true);
    L70:
        this.f102054b = true;
        goto L71
    L47:
        if (IVoiceLiveThemeKt.isLocalUgcTheme(r100) == true) goto L49;
    L72:
        ImageView r119 = this.f102071s;
        if (r119 == null) goto L75;
        r119.setVisibility(8);
    L75:
        this.f102057e = false;
        goto L76
    L23:
        if (this.f102058f == true) goto L25;
        r103 = true;
        goto L26
    }

    @Override // com.bytedance.android.live.ui.l
    public final void onThemeChanged(IVoiceLiveTheme r100) {
        ALogger.i("[VideoTalk]BaseLiveBackground", "onThemeChanged.theme:" + r100);
        if (r100 == null) goto L6;
        j();
        m(r100);
        return;
    }

    public final void p(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        HSImageView r101 = this.f102067o;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        HSImageView r102 = this.f102067o;
        if (r102 == null) goto L8;
        k.c(r102, r100.getStaticBackground(), h(), new b(this, r100));
    L8:
        this.f102053a = true;
    }

    public c(boolean r100, boolean r101, HSImageView r102, HSImageView r103, o r104, HSImageView r105, ImageView r106, com.bytedance.android.live.ui.a r107) {
        this.f102065m = r100;
        this.f102066n = r101;
        this.f102067o = r102;
        this.f102068p = r103;
        this.f102069q = r104;
        this.f102070r = r105;
        this.f102071s = r106;
        this.f102072t = r107;
        this.f102058f = true;
    }
}
