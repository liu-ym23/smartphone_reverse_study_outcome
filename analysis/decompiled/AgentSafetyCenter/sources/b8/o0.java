package b8;

import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o0 implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ androidx.room.q f1997c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f1998f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ w7.n f1999g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ int f2000h;
    public /* synthetic */ String i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ String f2001j;

    @Override // java.util.function.Supplier
    public final Object get() {
        androidx.room.q qVar = this.f1997c;
        String str = this.f1998f;
        w7.n nVar = this.f1999g;
        int i = this.f2000h;
        String str2 = this.i;
        String str3 = this.f2001j;
        ConcurrentMap concurrentMap = (ConcurrentMap) qVar.f1603f;
        ConcurrentMap concurrentMap2 = (ConcurrentMap) qVar.f1604g;
        w7.l lVarE = (w7.l) concurrentMap.get(str);
        if (lVarE == null && (lVarE = ((w7.o) qVar.f1601d).e(nVar)) != null) {
            androidx.room.q qVar2 = lVarE.f15333j;
            ConcurrentMap concurrentMap3 = (ConcurrentMap) qVar2.f1603f;
            ConcurrentMap concurrentMap4 = (ConcurrentMap) qVar2.f1602e;
            if (!concurrentMap3.isEmpty()) {
                concurrentMap.putAll(concurrentMap3);
            }
            ConcurrentMap concurrentMap5 = (ConcurrentMap) qVar2.f1604g;
            if (!concurrentMap4.isEmpty()) {
                ((ConcurrentMap) qVar.f1602e).putAll(concurrentMap4);
            }
            if (!concurrentMap5.isEmpty()) {
                concurrentMap2.putAll(concurrentMap5);
            }
        }
        if (i < 0) {
            if (lVarE == null) {
                return null;
            }
            return lVarE;
        }
        String strSubstring = str2.substring(i);
        String str4 = nVar.f15339a + strSubstring;
        w7.l lVarN = (w7.l) concurrentMap.get(str4);
        if (lVarN == null) {
            lVarN = (w7.l) concurrentMap2.get(str4);
        }
        if (lVarN == null) {
            lVarN = i.n(lVarE, qVar, strSubstring, str3);
        }
        if (lVarN == null) {
            return null;
        }
        return lVarN;
    }
}
