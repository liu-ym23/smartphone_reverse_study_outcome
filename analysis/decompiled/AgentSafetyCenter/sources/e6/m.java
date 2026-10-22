package e6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3573a;

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap.Config f3574b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorSpace f3575c;

    /* renamed from: d, reason: collision with root package name */
    public final f6.g f3576d;

    /* renamed from: e, reason: collision with root package name */
    public final f6.f f3577e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3578f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3579g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f3580h;
    public final String i;

    /* renamed from: j, reason: collision with root package name */
    public final ad.n f3581j;

    /* renamed from: k, reason: collision with root package name */
    public final r f3582k;

    /* renamed from: l, reason: collision with root package name */
    public final p f3583l;

    /* renamed from: m, reason: collision with root package name */
    public final b f3584m;

    /* renamed from: n, reason: collision with root package name */
    public final b f3585n;

    /* renamed from: o, reason: collision with root package name */
    public final b f3586o;

    public m(Context context, Bitmap.Config config, ColorSpace colorSpace, f6.g gVar, f6.f fVar, boolean z10, boolean z11, boolean z12, String str, ad.n nVar, r rVar, p pVar, b bVar, b bVar2, b bVar3) {
        this.f3573a = context;
        this.f3574b = config;
        this.f3575c = colorSpace;
        this.f3576d = gVar;
        this.f3577e = fVar;
        this.f3578f = z10;
        this.f3579g = z11;
        this.f3580h = z12;
        this.i = str;
        this.f3581j = nVar;
        this.f3582k = rVar;
        this.f3583l = pVar;
        this.f3584m = bVar;
        this.f3585n = bVar2;
        this.f3586o = bVar3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return yb.k.a(this.f3573a, mVar.f3573a) && this.f3574b == mVar.f3574b && yb.k.a(this.f3575c, mVar.f3575c) && yb.k.a(this.f3576d, mVar.f3576d) && this.f3577e == mVar.f3577e && this.f3578f == mVar.f3578f && this.f3579g == mVar.f3579g && this.f3580h == mVar.f3580h && yb.k.a(this.i, mVar.i) && yb.k.a(this.f3581j, mVar.f3581j) && yb.k.a(this.f3582k, mVar.f3582k) && yb.k.a(this.f3583l, mVar.f3583l) && this.f3584m == mVar.f3584m && this.f3585n == mVar.f3585n && this.f3586o == mVar.f3586o;
    }

    public final int hashCode() {
        int iHashCode = (this.f3574b.hashCode() + (this.f3573a.hashCode() * 31)) * 31;
        ColorSpace colorSpace = this.f3575c;
        int iH = k0.a.h(k0.a.h(k0.a.h((this.f3577e.hashCode() + ((this.f3576d.hashCode() + ((iHashCode + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31)) * 31)) * 31, 31, this.f3578f), 31, this.f3579g), 31, this.f3580h);
        String str = this.i;
        return this.f3586o.hashCode() + ((this.f3585n.hashCode() + ((this.f3584m.hashCode() + ((this.f3583l.f3591c.hashCode() + ((this.f3582k.f3600a.hashCode() + ((((iH + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f3581j.f548c)) * 31)) * 31)) * 31)) * 31)) * 31);
    }
}
