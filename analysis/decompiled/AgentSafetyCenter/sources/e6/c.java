package e6;

import android.graphics.Bitmap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public kc.p f3512a;

    /* renamed from: b, reason: collision with root package name */
    public kc.p f3513b;

    /* renamed from: c, reason: collision with root package name */
    public kc.p f3514c;

    /* renamed from: d, reason: collision with root package name */
    public kc.p f3515d;

    /* renamed from: e, reason: collision with root package name */
    public h6.e f3516e;

    /* renamed from: f, reason: collision with root package name */
    public f6.d f3517f;

    /* renamed from: g, reason: collision with root package name */
    public Bitmap.Config f3518g;

    /* renamed from: h, reason: collision with root package name */
    public b f3519h;
    public b i;

    /* renamed from: j, reason: collision with root package name */
    public b f3520j;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return yb.k.a(this.f3512a, cVar.f3512a) && yb.k.a(this.f3513b, cVar.f3513b) && yb.k.a(this.f3514c, cVar.f3514c) && yb.k.a(this.f3515d, cVar.f3515d) && yb.k.a(this.f3516e, cVar.f3516e) && this.f3517f == cVar.f3517f && this.f3518g == cVar.f3518g && this.f3519h == cVar.f3519h && this.i == cVar.i && this.f3520j == cVar.f3520j;
    }

    public final int hashCode() {
        return this.f3520j.hashCode() + ((this.i.hashCode() + ((this.f3519h.hashCode() + k0.a.h(k0.a.h((this.f3518g.hashCode() + ((this.f3517f.hashCode() + ((this.f3516e.hashCode() + ((this.f3515d.hashCode() + ((this.f3514c.hashCode() + ((this.f3513b.hashCode() + (this.f3512a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31, true), 923521, false)) * 31)) * 31);
    }
}
