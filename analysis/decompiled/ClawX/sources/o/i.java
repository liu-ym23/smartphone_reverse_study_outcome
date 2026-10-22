package o;

import java.util.ArrayList;
import p.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class i extends d {

    /* renamed from: p0, reason: collision with root package name */
    public d[] f4293p0 = new d[4];

    /* renamed from: q0, reason: collision with root package name */
    public int f4294q0 = 0;

    public final void M(int i8, ArrayList arrayList, n nVar) {
        for (int i9 = 0; i9 < this.f4294q0; i9++) {
            d dVar = this.f4293p0[i9];
            ArrayList arrayList2 = nVar.f4629a;
            if (!arrayList2.contains(dVar)) {
                arrayList2.add(dVar);
            }
        }
        for (int i10 = 0; i10 < this.f4294q0; i10++) {
            p.h.b(this.f4293p0[i10], i8, arrayList, nVar);
        }
    }

    public void N() {
    }
}
