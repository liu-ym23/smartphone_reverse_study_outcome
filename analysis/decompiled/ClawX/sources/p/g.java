package p;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: m, reason: collision with root package name */
    public int f4621m;

    public g(o oVar) {
        super(oVar);
        if (oVar instanceof k) {
            this.f4613e = 2;
        } else {
            this.f4613e = 3;
        }
    }

    @Override // p.f
    public final void d(int i8) {
        if (this.f4618j) {
            return;
        }
        this.f4618j = true;
        this.f4615g = i8;
        ArrayList arrayList = this.f4619k;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            d dVar = (d) obj;
            dVar.a(dVar);
        }
    }
}
