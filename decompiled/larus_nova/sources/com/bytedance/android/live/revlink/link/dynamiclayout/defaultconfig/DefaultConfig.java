package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AnchorHeightFixMode;
import com.bytedance.live.layout.AdjustBase;
import com.bytedance.live.layout.LayoutAlign;
import com.bytedance.live.layout.LayoutScale;
import jy0.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import t51.g;
import t51.i;
import y41.f;

/* JADX INFO: loaded from: classes47.dex */
public final class DefaultConfig {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f98578m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f98579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f98580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f98581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f98582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f98583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f98584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f98585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f98586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f98587i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f98588j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f98589k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f98590l;

    public static final class a {
    }

    static {
    }

    public final g c() {
        return (g) this.f98580b.getValue();
    }

    public static t51.a a() {
        t51.a r100 = new t51.a();
        r100.m(AdjustBase.CONTENT.ordinal());
        d();
        r100.t(LayoutScale.FIT_WIDTH.ordinal());
        d();
        r100.n(LayoutAlign.CENTER_TOP.ordinal());
        i r101 = new i();
        r101.j(0.0f);
        r101.m(0.19f);
        r101.k(1.0f);
        r101.i(1.0f);
        Unit r102 = Unit.INSTANCE;
        r100.v(r101);
        r100.p(AnchorHeightFixMode.RationTransformHeight.ordinal());
        r100.u(16);
        r100.q(16);
        return r100;
    }

    public static t51.a b() {
        t51.a r100 = new t51.a();
        r100.m(AdjustBase.CONTENT.ordinal());
        d();
        r100.t(LayoutScale.FIT_WIDTH.ordinal());
        r100.n(LayoutAlign.CENTER_TOP.ordinal());
        i r101 = new i();
        d();
        r101.j(0.0f);
        d();
        r101.m(0.19f);
        d();
        r101.k(1.0f);
        d();
        r101.i(1.0f);
        Unit r102 = Unit.INSTANCE;
        r100.v(r101);
        r100.p(AnchorHeightFixMode.RationTransformHeight.ordinal());
        d();
        f r103 = f.N;
        int r104 = 16;
        if (r103.c() == false) goto L5;
        int r105 = 32;
    L6:
        r100.u(r105);
        d();
        if (r103.c() == false) goto L9;
        r104 = 32;
    L9:
        r100.q(r104);
        return r100;
    L5:
        r105 = 16;
        goto L6
    }

    public static void d() {
        b03.a r100 = b03.a.f16857a;
        b.d("TripleFold", "isHarmonyNewStrategy h/w : " + (s1.w() / s1.y()) + ", h:" + s1.w() + ", w:" + s1.y());
    }

    public DefaultConfig() {
        this.f98579a = LazyKt.lazy(new DefaultConfig$entrance$2(this));
        this.f98580b = LazyKt.lazy(new DefaultConfig$normalConfig$2(this));
        this.f98581c = LazyKt.lazy(new DefaultConfig$enlargeConfig$2(this));
        this.f98582d = LazyKt.lazy(new DefaultConfig$fullConfig$2(this));
        this.f98583e = LazyKt.lazy(new DefaultConfig$fullRecordConfig$2(this));
        this.f98584f = LazyKt.lazy(new DefaultConfig$fullRecordNormalConfig$2(this));
        this.f98585g = LazyKt.lazy(new DefaultConfig$pkConfig$2(this));
        this.f98586h = LazyKt.lazy(new DefaultConfig$pkGameConfig$2(this));
        this.f98587i = LazyKt.lazy(new DefaultConfig$pkGameFullConfig$2(this));
        this.f98588j = LazyKt.lazy(new DefaultConfig$pkAudience$2(this));
        this.f98589k = LazyKt.lazy(new DefaultConfig$gameHorizontalConfig$2(this));
        this.f98590l = LazyKt.lazy(new DefaultConfig$gameLandscapeConfig$2(this));
    }
}
