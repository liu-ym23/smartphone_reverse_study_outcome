package xc;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends c0 {

    /* renamed from: l, reason: collision with root package name */
    public boolean f15651l;

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, jb.d] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, jb.d] */
    @Override // xc.c0
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            vc.e eVar = (vc.e) obj;
            if (this.f15611a.equals(eVar.a())) {
                o oVar = (o) obj;
                if (oVar.f15651l && Arrays.equals((vc.e[]) this.f15619j.getValue(), (vc.e[]) oVar.f15619j.getValue())) {
                    int iD = eVar.d();
                    int i = this.f15613c;
                    if (i == iD) {
                        for (int i3 = 0; i3 < i; i3++) {
                            if (yb.k.a(f(i3).a(), eVar.f(i3).a()) && yb.k.a(f(i3).getKind(), eVar.f(i3).getKind())) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // xc.c0
    public final int hashCode() {
        return super.hashCode() * 31;
    }
}
