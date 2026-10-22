package K;

import android.util.Size;
import java.util.Map;

/* renamed from: K.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0888k extends C0 {

    /* renamed from: a, reason: collision with root package name */
    public final Size f3988a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Integer, Size> f3989b;

    /* renamed from: c, reason: collision with root package name */
    public final Size f3990c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<Integer, Size> f3991d;

    /* renamed from: e, reason: collision with root package name */
    public final Size f3992e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<Integer, Size> f3993f;

    /* renamed from: g, reason: collision with root package name */
    public final Map<Integer, Size> f3994g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<Integer, Size> f3995h;

    /* renamed from: i, reason: collision with root package name */
    public final Map<Integer, Size> f3996i;

    public C0888k(Size size, Map<Integer, Size> map, Size size2, Map<Integer, Size> map2, Size size3, Map<Integer, Size> map3, Map<Integer, Size> map4, Map<Integer, Size> map5, Map<Integer, Size> map6) {
        if (size == null) {
            throw new NullPointerException("Null analysisSize");
        }
        this.f3988a = size;
        if (map == null) {
            throw new NullPointerException("Null s720pSizeMap");
        }
        this.f3989b = map;
        if (size2 == null) {
            throw new NullPointerException("Null previewSize");
        }
        this.f3990c = size2;
        if (map2 == null) {
            throw new NullPointerException("Null s1440pSizeMap");
        }
        this.f3991d = map2;
        if (size3 == null) {
            throw new NullPointerException("Null recordSize");
        }
        this.f3992e = size3;
        if (map3 == null) {
            throw new NullPointerException("Null maximumSizeMap");
        }
        this.f3993f = map3;
        if (map4 == null) {
            throw new NullPointerException("Null maximum4x3SizeMap");
        }
        this.f3994g = map4;
        if (map5 == null) {
            throw new NullPointerException("Null maximum16x9SizeMap");
        }
        this.f3995h = map5;
        if (map6 == null) {
            throw new NullPointerException("Null ultraMaximumSizeMap");
        }
        this.f3996i = map6;
    }

    @Override // K.C0
    public Size b() {
        return this.f3988a;
    }

    @Override // K.C0
    public Map<Integer, Size> d() {
        return this.f3995h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0) {
            C0 c02 = (C0) obj;
            if (this.f3988a.equals(c02.b()) && this.f3989b.equals(c02.n()) && this.f3990c.equals(c02.i()) && this.f3991d.equals(c02.l()) && this.f3992e.equals(c02.j()) && this.f3993f.equals(c02.h()) && this.f3994g.equals(c02.f()) && this.f3995h.equals(c02.d()) && this.f3996i.equals(c02.p())) {
                return true;
            }
        }
        return false;
    }

    @Override // K.C0
    public Map<Integer, Size> f() {
        return this.f3994g;
    }

    @Override // K.C0
    public Map<Integer, Size> h() {
        return this.f3993f;
    }

    public int hashCode() {
        return this.f3996i.hashCode() ^ ((((((((((((((((this.f3988a.hashCode() ^ 1000003) * 1000003) ^ this.f3989b.hashCode()) * 1000003) ^ this.f3990c.hashCode()) * 1000003) ^ this.f3991d.hashCode()) * 1000003) ^ this.f3992e.hashCode()) * 1000003) ^ this.f3993f.hashCode()) * 1000003) ^ this.f3994g.hashCode()) * 1000003) ^ this.f3995h.hashCode()) * 1000003);
    }

    @Override // K.C0
    public Size i() {
        return this.f3990c;
    }

    @Override // K.C0
    public Size j() {
        return this.f3992e;
    }

    @Override // K.C0
    public Map<Integer, Size> l() {
        return this.f3991d;
    }

    @Override // K.C0
    public Map<Integer, Size> n() {
        return this.f3989b;
    }

    @Override // K.C0
    public Map<Integer, Size> p() {
        return this.f3996i;
    }

    public String toString() {
        return "SurfaceSizeDefinition{analysisSize=" + this.f3988a + ", s720pSizeMap=" + this.f3989b + ", previewSize=" + this.f3990c + ", s1440pSizeMap=" + this.f3991d + ", recordSize=" + this.f3992e + ", maximumSizeMap=" + this.f3993f + ", maximum4x3SizeMap=" + this.f3994g + ", maximum16x9SizeMap=" + this.f3995h + ", ultraMaximumSizeMap=" + this.f3996i + "}";
    }
}
