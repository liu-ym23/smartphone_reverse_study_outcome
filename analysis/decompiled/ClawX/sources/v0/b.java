package v0;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5789a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f5790b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f5791c;

    public /* synthetic */ b(g gVar, ArrayList arrayList, int i8) {
        this.f5789a = i8;
        this.f5791c = gVar;
        this.f5790b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5789a) {
            case 0:
                ArrayList arrayList = this.f5790b;
                int size = arrayList.size();
                g gVar = this.f5791c;
                if (size <= 0) {
                    arrayList.clear();
                    gVar.f5821m.remove(arrayList);
                    return;
                } else {
                    ((f) arrayList.get(0)).getClass();
                    gVar.getClass();
                    throw null;
                }
            case 1:
                ArrayList arrayList2 = this.f5790b;
                int size2 = arrayList2.size();
                int i8 = 0;
                while (true) {
                    g gVar2 = this.f5791c;
                    if (i8 >= size2) {
                        arrayList2.clear();
                        gVar2.f5822n.remove(arrayList2);
                        return;
                    } else {
                        Object obj = arrayList2.get(i8);
                        i8++;
                        ArrayList arrayList3 = gVar2.f5826r;
                        ((e) obj).getClass();
                    }
                }
            default:
                ArrayList arrayList4 = this.f5790b;
                int size3 = arrayList4.size();
                g gVar3 = this.f5791c;
                if (size3 <= 0) {
                    arrayList4.clear();
                    gVar3.f5820l.remove(arrayList4);
                    return;
                } else {
                    n0 n0Var = (n0) arrayList4.get(0);
                    gVar3.getClass();
                    n0Var.getClass();
                    throw null;
                }
        }
    }
}
