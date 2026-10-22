package H;

import java.util.ArrayList;
import q.l;

/* loaded from: classes.dex */
public final class f implements J.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f671a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f672b;

    public /* synthetic */ f(int i4, Object obj) {
        this.f671a = i4;
        this.f672b = obj;
    }

    public final void a(g gVar) {
        switch (this.f671a) {
            case 0:
                if (gVar == null) {
                    gVar = new g(-3);
                }
                ((B0.c) this.f672b).l(gVar);
                return;
            default:
                synchronized (h.f677c) {
                    try {
                        l lVar = h.f678d;
                        ArrayList arrayList = (ArrayList) lVar.get((String) this.f672b);
                        if (arrayList == null) {
                            return;
                        }
                        lVar.remove((String) this.f672b);
                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                            ((J.a) arrayList.get(i4)).accept(gVar);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }

    @Override // J.a
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f671a) {
            case 0:
                a((g) obj);
                break;
            default:
                a((g) obj);
                break;
        }
    }
}
