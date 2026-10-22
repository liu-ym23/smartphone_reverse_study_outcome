package o3;

import java.util.concurrent.ConcurrentHashMap;
import n3.InterfaceC0780a;
import n3.InterfaceC0781b;

/* loaded from: classes2.dex */
public final class b implements InterfaceC0780a {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f13805a;

    public b(int i4) {
        if (i4 != 1) {
            this.f13805a = new ConcurrentHashMap();
        } else {
            this.f13805a = new ConcurrentHashMap();
        }
    }

    @Override // n3.InterfaceC0780a
    public final InterfaceC0781b getLogger(String str) {
        ConcurrentHashMap concurrentHashMap = this.f13805a;
        f fVar = (f) concurrentHashMap.get(str);
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(str);
        f fVar3 = (f) concurrentHashMap.putIfAbsent(str, fVar2);
        return fVar3 != null ? fVar3 : fVar2;
    }
}
