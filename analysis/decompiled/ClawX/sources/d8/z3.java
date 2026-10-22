package d8;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class z3 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f2249f;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2249f = new ArrayList(2);
        while (uVar.f2171a.remaining() > 0) {
            this.f2249f.add(uVar.c());
        }
    }

    @Override // d8.w2
    public final String k() {
        if (this.f2249f.isEmpty()) {
            return "\"\"";
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f2249f.iterator();
        while (it.hasNext()) {
            sb.append(w2.a((byte[]) it.next(), true));
            if (it.hasNext()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        ArrayList arrayList = this.f2249f;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            jVar.i((byte[]) obj);
        }
    }
}
