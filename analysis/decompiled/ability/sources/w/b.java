package w;

import e2.InterfaceC1405b;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public final class b implements InterfaceC1405b {
    public static volatile ConcurrentHashMap b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet f6799a = new CopyOnWriteArraySet();

    public static b c(String str) {
        b bVar;
        b bVar2 = (b) b.get(str);
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (b.class) {
            bVar = new b();
            b.put(str, bVar);
        }
        return bVar;
    }

    @Override // e2.InterfaceC1405b
    public final void a(String str, String str2, String str3) {
        Iterator it = this.f6799a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1405b) it.next()).a(str, str2, str3);
        }
    }

    @Override // e2.InterfaceC1405b
    public final void b(boolean z10, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator it = this.f6799a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1405b) it.next()).b(z10, str, str2, str3, str4, str5, str6);
        }
    }
}
