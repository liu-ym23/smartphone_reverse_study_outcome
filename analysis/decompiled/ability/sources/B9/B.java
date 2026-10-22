package B9;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class B extends V {
    public final boolean l;

    public B(String str, C c) {
        super(str, c, 1);
        this.l = true;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [C7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2, types: [C7.f, java.lang.Object] */
    @Override // B9.V
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof B) {
            z9.g gVar = (z9.g) obj;
            if (this.f232a.equals(gVar.h())) {
                B b = (B) obj;
                if (b.l && Arrays.equals((z9.g[]) this.f233j.getF4884a(), (z9.g[]) b.f233j.getF4884a())) {
                    int iD = gVar.d();
                    int i = this.c;
                    if (i == iD) {
                        for (int i6 = 0; i6 < i; i6++) {
                            if (kotlin.jvm.internal.k.b(g(i6).h(), gVar.g(i6).h()) && kotlin.jvm.internal.k.b(g(i6).getKind(), gVar.g(i6).getKind())) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // B9.V
    public final int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // z9.g
    public final boolean isInline() {
        return this.l;
    }
}
