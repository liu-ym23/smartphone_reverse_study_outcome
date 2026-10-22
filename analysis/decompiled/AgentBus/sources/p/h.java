package p;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final s.b f8111a;

    /* renamed from: b, reason: collision with root package name */
    public final ia.m f8112b;

    public h(s.b bVar, ia.m mVar) {
        this.f8111a = bVar;
        this.f8112b = mVar;
    }

    public final String toString() {
        ia.m mVar = this.f8112b;
        if (mVar.f4975j.o(ia.a0.f4916g) != null) {
            throw new ClassCastException();
        }
        StringBuilder sb2 = new StringBuilder("Request@");
        int iHashCode = hashCode();
        ib.c.o(16);
        String string = Integer.toString(iHashCode, 16);
        q7.k.d(string, "toString(this, checkRadix(radix))");
        sb2.append(string);
        sb2.append("(currentBounds()=");
        sb2.append(this.f8111a.c());
        sb2.append(", continuation=");
        sb2.append(mVar);
        sb2.append(')');
        return sb2.toString();
    }
}
