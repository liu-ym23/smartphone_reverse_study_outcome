package k3;

import java.util.ArrayList;
import p.p0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements m3.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7224a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f7225b;

    public /* synthetic */ e(int i) {
        this.f7224a = i;
    }

    @Override // m3.a
    public final void accept(Object obj) {
        switch (this.f7224a) {
            case 0:
                f fVar = (f) obj;
                if (fVar == null) {
                    fVar = new f(-3);
                }
                ((p5.e) this.f7225b).m(fVar);
                return;
            default:
                f fVar2 = (f) obj;
                synchronized (g.f7230c) {
                    try {
                        p0 p0Var = g.f7231d;
                        ArrayList arrayList = (ArrayList) p0Var.get((String) this.f7225b);
                        if (arrayList == null) {
                            return;
                        }
                        p0Var.remove((String) this.f7225b);
                        for (int i = 0; i < arrayList.size(); i++) {
                            ((m3.a) arrayList.get(i)).accept(fVar2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
