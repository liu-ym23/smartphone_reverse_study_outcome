package M0;

import android.util.Log;
import e1.AbstractC1402a;
import f1.C1431a;
import i1.C1552a;
import j1.C1593b;
import k1.InterfaceC1619a;
import s2.C1912a;

/* loaded from: classes2.dex */
public final class b implements InterfaceC1619a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f953a;

    public /* synthetic */ b(int i) {
        this.f953a = i;
    }

    @Override // k1.InterfaceC1619a
    public final Object create() {
        switch (this.f953a) {
            case 0:
                return AbstractC1402a.f4331a;
            case 1:
                l lVar = new l();
                C1593b.a().c();
                C1593b.a().b(new j(lVar, 1));
                return lVar;
            case 2:
                return new d();
            case 3:
                return new e();
            case 4:
                k kVar = new k(0);
                C1593b.a().c();
                C1593b.a().b(new j(kVar, 0));
                return kVar;
            case 5:
                C1552a c1552a = new C1552a();
                if (H.h.b) {
                    Log.d("APM6-Traffic-Config", U7.a.e(new String[]{"TrafficConfigManager constructed"}));
                }
                C1593b.a().c();
                C1593b.a().b(new j(c1552a, 2));
                return c1552a;
            default:
                return new C1431a();
        }
    }

    public /* synthetic */ b(C1912a c1912a, int i) {
        this.f953a = i;
    }
}
