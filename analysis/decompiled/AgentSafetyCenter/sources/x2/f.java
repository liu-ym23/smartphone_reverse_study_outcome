package x2;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class f extends e {

    /* renamed from: m, reason: collision with root package name */
    public int f15545m;

    public f(n nVar) {
        super(nVar);
        if (nVar instanceof j) {
            this.f15538e = 2;
        } else {
            this.f15538e = 3;
        }
    }

    @Override // x2.e
    public final void d(int i) {
        if (this.f15542j) {
            return;
        }
        this.f15542j = true;
        this.f15540g = i;
        ArrayList arrayList = this.f15543k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            d dVar = (d) obj;
            dVar.a(dVar);
        }
    }
}
