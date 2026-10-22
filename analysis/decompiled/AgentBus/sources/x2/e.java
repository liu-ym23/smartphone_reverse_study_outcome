package x2;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f11109f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11110g;

    public e(List list, int i2, Throwable th) {
        ib.c.n(list, "initCallbacks cannot be null");
        this.f11109f = new ArrayList(list);
        this.f11110g = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f11109f;
        int size = arrayList.size();
        int i2 = 0;
        if (this.f11110g != 1) {
            while (i2 < size) {
                ((z1.g) arrayList.get(i2)).f11781b.f7326g = z1.j.f11784a;
                i2++;
            }
            return;
        }
        while (i2 < size) {
            z1.g gVar = (z1.g) arrayList.get(i2);
            gVar.f11780a.setValue(Boolean.TRUE);
            gVar.f11781b.f7326g = new z1.k(true);
            i2++;
        }
    }
}
