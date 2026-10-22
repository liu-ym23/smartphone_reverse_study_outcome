package s2;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Trace;
import com.airbnb.lottie.h;
import com.stepos.alphame.utils.Property;
import com.stepos.renderfilter.RenderFilter;
import com.stepos.renderfilter.functor.DrawGlInfo;
import h2.C0590b;
import u2.AbstractC0940b;
import u2.C0939a;
import w2.C0975b;
import x2.C0981a;
import y2.g;

/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: f, reason: collision with root package name */
    public final Context f14240f;

    /* renamed from: g, reason: collision with root package name */
    public final float f14241g;

    /* renamed from: h, reason: collision with root package name */
    public final float f14242h;

    /* renamed from: i, reason: collision with root package name */
    public final float f14243i;

    /* renamed from: j, reason: collision with root package name */
    public C0939a f14244j;

    /* renamed from: k, reason: collision with root package name */
    public C0939a f14245k;

    /* renamed from: l, reason: collision with root package name */
    public C0975b f14246l;

    /* renamed from: m, reason: collision with root package name */
    public C0975b f14247m;

    /* renamed from: n, reason: collision with root package name */
    public C0590b f14248n;

    /* renamed from: o, reason: collision with root package name */
    public C0981a f14249o;

    public c(int i4, float f4, float f5) {
        RenderFilter renderFilterB = RenderFilter.b();
        renderFilterB.a();
        this.f14240f = renderFilterB.f12298a;
        this.f14241g = f5;
        float fMin = Math.min(i4, (int) Math.ceil(r4));
        this.f14242h = fMin;
        this.f14243i = (f4 / 3.0f) / fMin;
    }

    @Override // s2.d
    public final u2.c a(u2.c cVar, DrawGlInfo drawGlInfo) {
        Trace.beginSection("KawaseBlurFilter");
        super.a(cVar, drawGlInfo);
        Trace.beginSection("filterInput");
        C0939a c0939a = this.f14244j;
        c0939a.e(true);
        GLES20.glClearColor(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.f14246l.f15846k);
        GLES20.glUniformMatrix4fv(this.f14246l.b("u_projectionViewMatrix"), 1, false, this.f14249o.f15906f.f16337a, 0);
        cVar.b(10497);
        GLES20.glUniform1i(this.f14246l.b("u_photo"), 0);
        this.f14248n.a(this.f14246l);
        this.f14246l.getClass();
        c0939a.f();
        C0939a c0939a2 = this.f14244j;
        C0939a c0939a3 = this.f14245k;
        int i4 = 0;
        while (i4 < this.f14242h) {
            c0939a3.e(true);
            GLES20.glClearColor(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 1.0f);
            GLES20.glClear(16640);
            GLES20.glUseProgram(this.f14247m.f15846k);
            GLES20.glUniformMatrix4fv(this.f14247m.b("u_projectionViewMatrix"), 1, false, this.f14249o.f15906f.f16337a, 0);
            c0939a2.b(33648);
            GLES20.glUniform1i(this.f14247m.b("u_blur_texture"), 0);
            GLES20.glUniform2f(this.f14247m.b("in_blurOffset"), (Math.max(1, i4) * this.f14243i) / this.f14253d, (Math.max(1, i4) * this.f14243i) / this.f14254e);
            this.f14248n.a(this.f14247m);
            this.f14247m.getClass();
            c0939a3.f();
            i4++;
            C0939a c0939a4 = c0939a3;
            c0939a3 = c0939a2;
            c0939a2 = c0939a4;
        }
        Trace.endSection();
        Trace.endSection();
        return c0939a2;
    }

    @Override // s2.d
    public final void b() {
        Context context = this.f14240f;
        this.f14246l = h.j(context, "renderfilter/downscaling/downscaling_vertex.glsl", "renderfilter/downscaling/downscaling_frag.glsl");
        this.f14247m = h.j(context, "renderfilter/blur/kawase/kawase_vertex.glsl", "renderfilter/blur/kawase/kawase_frag.glsl");
    }

    @Override // s2.d
    public final void c() {
        h.k(this.f14246l);
        h.k(this.f14247m);
        h.k(this.f14244j);
        h.k(this.f14245k);
        h.k(this.f14248n);
        this.f14246l = null;
        this.f14247m = null;
        this.f14244j = null;
        this.f14245k = null;
        this.f14248n = null;
    }

    @Override // s2.d
    public final void e(int i4, int i5) {
        float f4 = this.f14241g;
        int iMax = Math.max(1, (int) (i4 * f4));
        int iMax2 = Math.max(1, (int) (i5 * f4));
        float f5 = iMax;
        float f6 = iMax2;
        C0981a c0981a = new C0981a(f5, f6);
        this.f14249o = c0981a;
        c0981a.f15901a.c(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 1.0f);
        this.f14249o.a(new g(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE));
        C0981a c0981a2 = this.f14249o;
        c0981a2.f15908h = Property.DEFAULT_FLOAT_VALUE;
        c0981a2.f15909i = 2.0f;
        c0981a2.b();
        h.k(this.f14248n);
        float f7 = (-iMax) / 2.0f;
        float f8 = f6 / 2.0f;
        float f9 = f5 / 2.0f;
        float f10 = (-iMax2) / 2.0f;
        this.f14248n = AbstractC0940b.b(f7, f8, f9, f8, f9, f10, f7, f10);
        h.k(this.f14244j);
        this.f14244j = new C0939a(iMax, iMax2);
        h.k(this.f14245k);
        this.f14245k = new C0939a(iMax, iMax2);
    }
}
