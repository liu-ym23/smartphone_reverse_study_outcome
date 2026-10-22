package b8;

import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class p0 implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ androidx.room.q f2006c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f2007f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ w7.l f2008g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ String f2009h;
    public /* synthetic */ String i;

    @Override // java.util.function.Supplier
    public final Object get() {
        androidx.room.q qVar = this.f2006c;
        String str = this.f2007f;
        w7.l lVar = this.f2008g;
        String str2 = this.f2009h;
        String str3 = this.i;
        w7.l lVarN = (w7.l) ((ConcurrentMap) qVar.f1603f).get(str);
        if (lVarN == null) {
            lVarN = (w7.l) ((ConcurrentMap) qVar.f1604g).get(str);
        }
        if (lVarN == null) {
            lVarN = i.n(lVar, qVar, str2, str3);
        }
        if (lVarN == null) {
            return null;
        }
        return lVarN;
    }
}
