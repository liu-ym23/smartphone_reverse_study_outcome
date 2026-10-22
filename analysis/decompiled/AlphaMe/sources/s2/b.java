package s2;

import com.airbnb.lottie.h;
import com.stepos.alphame.utils.Property;
import com.stepos.renderfilter.RenderFilter;
import h2.C0590b;
import u2.AbstractC0940b;
import w2.C0975b;
import x2.C0981a;

/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: p, reason: collision with root package name */
    public static final float[] f14229p = new float[9];

    /* renamed from: f, reason: collision with root package name */
    public C0975b f14230f;

    /* renamed from: g, reason: collision with root package name */
    public C0981a f14231g;

    /* renamed from: h, reason: collision with root package name */
    public C0590b f14232h;

    /* renamed from: i, reason: collision with root package name */
    public int f14233i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f14234j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f14235k = 255;

    /* renamed from: l, reason: collision with root package name */
    public float f14236l = 1.0f;

    /* renamed from: m, reason: collision with root package name */
    public int f14237m = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f14238n = -1;

    /* renamed from: o, reason: collision with root package name */
    public final C2.c f14239o = new C2.c();

    @Override // s2.d
    public final void b() {
        RenderFilter renderFilterB = RenderFilter.b();
        renderFilterB.a();
        this.f14230f = h.j(renderFilterB.f12298a, "renderfilter/decor/decor_vertex.glsl", "renderfilter/decor/decor_frag.glsl");
        this.f14232h = AbstractC0940b.b(Property.DEFAULT_FLOAT_VALUE, 1.0f, 1.0f, 1.0f, 1.0f, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
    }

    @Override // s2.d
    public final void c() {
        h.k(this.f14230f);
        h.k(this.f14232h);
        this.f14230f = null;
        this.f14232h = null;
    }
}
