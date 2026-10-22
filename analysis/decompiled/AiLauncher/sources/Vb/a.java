package Vb;

import Yb.u;
import cc.InterfaceC1510a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends u>, InterfaceC1510a> f6563a = new HashMap(32);

    public void a(InterfaceC1510a interfaceC1510a) {
        Iterator<Class<? extends u>> it = interfaceC1510a.y().iterator();
        while (it.hasNext()) {
            this.f6563a.put(it.next(), interfaceC1510a);
        }
    }

    public void b(u uVar) {
        InterfaceC1510a interfaceC1510a = this.f6563a.get(uVar.getClass());
        if (interfaceC1510a != null) {
            interfaceC1510a.a(uVar);
        }
    }
}
