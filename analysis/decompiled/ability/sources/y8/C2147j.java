package y8;

import D7.w;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: y8.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2147j {

    /* renamed from: a, reason: collision with root package name */
    public final C2150m f6917a;
    public final ArrayList b;
    public final String c;
    public final C2147j d;

    public C2147j(C2150m c2150m, ArrayList arrayList, String str) {
        this.f6917a = c2150m;
        this.b = arrayList;
        this.c = str;
        C2147j c2147j = null;
        if (str != null) {
            C2150m c2150mA = c2150m != null ? c2150m.a() : null;
            ArrayList arrayList2 = new ArrayList(w.c0(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C2150m c2150m2 = (C2150m) it.next();
                arrayList2.add(c2150m2 != null ? c2150m2.a() : null);
            }
            c2147j = new C2147j(c2150mA, arrayList2, null);
        }
        this.d = c2147j;
    }
}
