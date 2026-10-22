package B9;

/* renamed from: B9.v, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0194v extends V {
    public final z9.j l;
    public final C7.f m;

    public C0194v(final String str, final int i) {
        super(str, null, i);
        this.l = z9.j.c;
        this.m = kotlin.a.a(new S7.a() { // from class: B9.u
            @Override // S7.a
            public final Object invoke() {
                int i6 = i;
                z9.g[] gVarArr = new z9.g[i6];
                for (int i10 = 0; i10 < i6; i10++) {
                    gVarArr[i10] = z2.l.m(str + '.' + this.e[i10], z9.k.f, new z9.g[0]);
                }
                return gVarArr;
            }
        });
    }

    @Override // B9.V
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof z9.g)) {
            return false;
        }
        z9.g gVar = (z9.g) obj;
        return gVar.getKind() == z9.j.c && this.f232a.equals(gVar.h()) && kotlin.jvm.internal.k.b(T.b(this), T.b(gVar));
    }

    @Override // B9.V, z9.g
    public final z9.g g(int i) {
        return ((z9.g[]) this.m.getF4884a())[i];
    }

    @Override // B9.V, z9.g
    public final H4.o getKind() {
        return this.l;
    }

    @Override // B9.V
    public final int hashCode() {
        int iHashCode = this.f232a.hashCode();
        C7.i iVar = new C7.i(this);
        int iHashCode2 = 1;
        while (iVar.hasNext()) {
            int i = iHashCode2 * 31;
            String str = (String) iVar.next();
            iHashCode2 = i + (str != null ? str.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // B9.V
    public final String toString() {
        return D7.v.I0(new D7.s(this, 7), ", ", this.f232a.concat("("), ")", null, 56);
    }
}
