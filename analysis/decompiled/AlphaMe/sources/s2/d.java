package s2;

import android.os.Trace;
import com.stepos.renderfilter.functor.DrawGlInfo;
import z2.InterfaceC1006a;

/* loaded from: classes.dex */
public abstract class d implements InterfaceC1006a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f14250a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f14251b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f14252c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f14253d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f14254e = -1;

    public u2.c a(u2.c cVar, DrawGlInfo drawGlInfo) {
        boolean z4;
        boolean z5 = false;
        if (this.f14251b == drawGlInfo.getTransformWidth() && this.f14252c == drawGlInfo.getTransformHeight()) {
            z4 = false;
        } else {
            this.f14251b = drawGlInfo.getTransformWidth();
            this.f14252c = drawGlInfo.getTransformHeight();
            z4 = true;
        }
        if (cVar != null && (this.f14253d != cVar.d() || this.f14254e != cVar.a())) {
            this.f14253d = cVar.d();
            this.f14254e = cVar.a();
            z5 = true;
        }
        if (!this.f14250a) {
            this.f14250a = true;
            Trace.beginSection("onCreate");
            b();
            Trace.endSection();
        }
        if (z4) {
            Trace.beginSection("onDrawSizeChanged");
            d();
            Trace.endSection();
        }
        if (!z5) {
            return null;
        }
        Trace.beginSection("onInputSizeChanged");
        e(this.f14253d, this.f14254e);
        Trace.endSection();
        return null;
    }

    public abstract void b();

    public abstract void c();

    public void d() {
    }

    @Override // z2.InterfaceC1006a
    public final void dispose() {
        c();
        this.f14250a = false;
        this.f14251b = -1;
        this.f14252c = -1;
        this.f14253d = -1;
        this.f14254e = -1;
    }

    public void e(int i4, int i5) {
    }
}
