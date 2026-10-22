package J;

import J.C0868x;
import J.d0;
import U.C1038t;
import android.util.Size;
import java.util.List;

/* renamed from: J.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0847b extends C0868x.c {

    /* renamed from: f, reason: collision with root package name */
    public final Size f3596f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3597g;

    /* renamed from: h, reason: collision with root package name */
    public final List<Integer> f3598h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3599i;

    /* renamed from: j, reason: collision with root package name */
    public final D.X f3600j;

    /* renamed from: k, reason: collision with root package name */
    public final K f3601k;

    /* renamed from: l, reason: collision with root package name */
    public final C1038t<X> f3602l;

    /* renamed from: m, reason: collision with root package name */
    public final C1038t<d0.a> f3603m;

    public C0847b(Size size, int i10, List<Integer> list, boolean z10, D.X x10, K k10, C1038t<X> c1038t, C1038t<d0.a> c1038t2) {
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.f3596f = size;
        this.f3597g = i10;
        if (list == null) {
            throw new NullPointerException("Null outputFormats");
        }
        this.f3598h = list;
        this.f3599i = z10;
        this.f3600j = x10;
        this.f3601k = k10;
        if (c1038t == null) {
            throw new NullPointerException("Null requestEdge");
        }
        this.f3602l = c1038t;
        if (c1038t2 == null) {
            throw new NullPointerException("Null errorEdge");
        }
        this.f3603m = c1038t2;
    }

    @Override // J.C0868x.c
    public C1038t<d0.a> b() {
        return this.f3603m;
    }

    @Override // J.C0868x.c
    public D.X c() {
        return this.f3600j;
    }

    @Override // J.C0868x.c
    public int d() {
        return this.f3597g;
    }

    @Override // J.C0868x.c
    public List<Integer> e() {
        return this.f3598h;
    }

    public boolean equals(Object obj) {
        D.X x10;
        K k10;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0868x.c) {
            C0868x.c cVar = (C0868x.c) obj;
            if (this.f3596f.equals(cVar.k()) && this.f3597g == cVar.d() && this.f3598h.equals(cVar.e()) && this.f3599i == cVar.m() && ((x10 = this.f3600j) != null ? x10.equals(cVar.c()) : cVar.c() == null) && ((k10 = this.f3601k) != null ? k10.equals(cVar.f()) : cVar.f() == null) && this.f3602l.equals(cVar.h()) && this.f3603m.equals(cVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // J.C0868x.c
    public K f() {
        return this.f3601k;
    }

    @Override // J.C0868x.c
    public C1038t<X> h() {
        return this.f3602l;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f3596f.hashCode() ^ 1000003) * 1000003) ^ this.f3597g) * 1000003) ^ this.f3598h.hashCode()) * 1000003) ^ (this.f3599i ? 1231 : 1237)) * 1000003;
        D.X x10 = this.f3600j;
        int iHashCode2 = (iHashCode ^ (x10 == null ? 0 : x10.hashCode())) * 1000003;
        K k10 = this.f3601k;
        return this.f3603m.hashCode() ^ ((((iHashCode2 ^ (k10 != null ? k10.hashCode() : 0)) * 1000003) ^ this.f3602l.hashCode()) * 1000003);
    }

    @Override // J.C0868x.c
    public Size k() {
        return this.f3596f;
    }

    @Override // J.C0868x.c
    public boolean m() {
        return this.f3599i;
    }

    public String toString() {
        return "In{size=" + this.f3596f + ", inputFormat=" + this.f3597g + ", outputFormats=" + this.f3598h + ", virtualCamera=" + this.f3599i + ", imageReaderProxyProvider=" + this.f3600j + ", postviewSettings=" + this.f3601k + ", requestEdge=" + this.f3602l + ", errorEdge=" + this.f3603m + "}";
    }
}
