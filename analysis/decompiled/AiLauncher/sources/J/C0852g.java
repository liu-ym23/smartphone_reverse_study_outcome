package J;

import J.W;
import U.C1038t;
import java.util.List;

/* renamed from: J.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0852g extends W.a {

    /* renamed from: a, reason: collision with root package name */
    public final C1038t<W.b> f3627a;

    /* renamed from: b, reason: collision with root package name */
    public final C1038t<W.b> f3628b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3629c;

    /* renamed from: d, reason: collision with root package name */
    public final List<Integer> f3630d;

    public C0852g(C1038t<W.b> c1038t, C1038t<W.b> c1038t2, int i10, List<Integer> list) {
        if (c1038t == null) {
            throw new NullPointerException("Null edge");
        }
        this.f3627a = c1038t;
        if (c1038t2 == null) {
            throw new NullPointerException("Null postviewEdge");
        }
        this.f3628b = c1038t2;
        this.f3629c = i10;
        if (list == null) {
            throw new NullPointerException("Null outputFormats");
        }
        this.f3630d = list;
    }

    @Override // J.W.a
    public C1038t<W.b> a() {
        return this.f3627a;
    }

    @Override // J.W.a
    public int b() {
        return this.f3629c;
    }

    @Override // J.W.a
    public List<Integer> c() {
        return this.f3630d;
    }

    @Override // J.W.a
    public C1038t<W.b> d() {
        return this.f3628b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof W.a) {
            W.a aVar = (W.a) obj;
            if (this.f3627a.equals(aVar.a()) && this.f3628b.equals(aVar.d()) && this.f3629c == aVar.b() && this.f3630d.equals(aVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f3630d.hashCode() ^ ((((((this.f3627a.hashCode() ^ 1000003) * 1000003) ^ this.f3628b.hashCode()) * 1000003) ^ this.f3629c) * 1000003);
    }

    public String toString() {
        return "In{edge=" + this.f3627a + ", postviewEdge=" + this.f3628b + ", inputFormat=" + this.f3629c + ", outputFormats=" + this.f3630d + "}";
    }
}
