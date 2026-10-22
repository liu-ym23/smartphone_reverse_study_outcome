package ce;

import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2268a;

    /* renamed from: b, reason: collision with root package name */
    public final ge.d f2269b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f2270c;

    public /* synthetic */ d(f fVar, ge.d dVar, int i) {
        this.f2268a = i;
        this.f2270c = fVar;
        this.f2269b = dVar;
    }

    @Override // ce.g
    public final zd.g a() {
        int i = this.f2268a;
        f fVar = this.f2270c;
        ge.d dVar = this.f2269b;
        int i3 = 0;
        int i10 = 1;
        int i11 = 4;
        switch (i) {
            case 0:
                fe.b bVar = fVar.f2275a;
                fe.b bVar2 = fVar.f2275a;
                if (!bVar.c(22)) {
                    if (!bVar2.d(4, 3)) {
                        fVar.f2277c.g(new b(fVar, i11));
                        HashMap map = f.f2274g;
                        break;
                    } else {
                        fVar.f2279e = new b(fVar, i11);
                        break;
                    }
                } else {
                    fVar.f2279e = new d(fVar, dVar, i3);
                    break;
                }
            default:
                fe.b bVar3 = fVar.f2275a;
                fe.b bVar4 = fVar.f2275a;
                if (!bVar3.c(22)) {
                    int i12 = 18;
                    if (!bVar4.d(4, 15, 20, 3)) {
                        fVar.f2277c.g(new b(fVar, i12));
                        HashMap map2 = f.f2274g;
                        break;
                    } else {
                        fVar.f2279e = new b(fVar, i12);
                        break;
                    }
                } else {
                    fVar.f2279e = new d(fVar, dVar, i10);
                    break;
                }
        }
        return f.a(fVar, dVar.f4745b);
    }
}
