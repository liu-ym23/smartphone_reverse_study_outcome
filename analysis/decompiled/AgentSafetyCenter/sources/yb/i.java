package yb;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i extends c implements h, fc.a, jb.b {

    /* renamed from: k, reason: collision with root package name */
    public final int f16089k;

    /* renamed from: l, reason: collision with root package name */
    public final int f16090l;

    public i(int i, Object obj, Class cls, String str, String str2, int i3, int i10) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.f16089k = i;
        this.f16090l = 0;
    }

    @Override // yb.c
    public final fc.a a() {
        v.f16099a.getClass();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [fc.a] */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return this.f16085h.equals(iVar.f16085h) && this.i.equals(iVar.i) && this.f16090l == iVar.f16090l && this.f16089k == iVar.f16089k && k.a(this.f16083f, iVar.f16083f) && d().equals(iVar.d());
        }
        if (!(obj instanceof i)) {
            return false;
        }
        ?? r02 = this.f16082c;
        if (r02 == 0) {
            a();
            this.f16082c = this;
        } else {
            this = r02;
        }
        return obj.equals(this);
    }

    @Override // yb.h
    public final int getArity() {
        return this.f16089k;
    }

    public final int hashCode() {
        d();
        return this.i.hashCode() + androidx.activity.b.d(d().hashCode() * 31, 31, this.f16085h);
    }

    public final String toString() {
        fc.a aVar = this.f16082c;
        if (aVar == null) {
            a();
            this.f16082c = this;
            aVar = this;
        }
        if (aVar != this) {
            return aVar.toString();
        }
        String str = this.f16085h;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : k0.a.C("function ", str, " (Kotlin reflection is not available)");
    }

    public i(int i, Class cls, String str, String str2, int i3) {
        this(i, b.f16081c, cls, str, str2, i3, 0);
    }
}
