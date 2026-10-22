package z7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: z7.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2183d implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6976a = new HashMap();
    public final ArrayList b = new ArrayList();

    public C2183d(HashMap map) {
        String str = (String) map.get("cookie");
        if (str != null) {
            for (String str2 : str.split(";")) {
                String[] strArrSplit = str2.trim().split("=");
                if (strArrSplit.length == 2) {
                    this.f6976a.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
    }

    public final void b() {
        Iterator it = this.b.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f6976a.keySet().iterator();
    }
}
