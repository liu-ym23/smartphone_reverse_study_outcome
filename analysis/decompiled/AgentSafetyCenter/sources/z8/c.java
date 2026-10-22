package z8;

import ad.n;
import ad.s;
import ad.w;
import androidx.activity.d0;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public String f16493a;

    /* renamed from: b, reason: collision with root package name */
    public w f16494b;

    /* renamed from: c, reason: collision with root package name */
    public s f16495c;

    public static l8.a a(c cVar, d0 d0Var, b bVar) {
        w wVar = cVar.f16494b;
        cVar.getClass();
        l8.b bVar2 = l8.b.f7755a;
        aa.g gVar = new aa.g(15);
        gVar.f319f = wVar;
        gVar.f320g = bVar;
        VarHandle.storeStoreFence();
        n nVar = (n) d0Var.invoke();
        l8.a aVar = (l8.a) gVar.invoke(nVar);
        if (aVar.f7752a == 401) {
            String strA = nVar.a("Authorization");
            if (strA == null) {
                strA = "";
            }
            if (bVar2.d(strA)) {
                return (l8.a) gVar.invoke(d0Var.invoke());
            }
        }
        return aVar;
    }
}
