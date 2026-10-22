package N8;

import D7.w;
import g9.InterfaceC1474a;
import h8.InterfaceC1520c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import k8.Q;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public final class a implements InterfaceC1474a {
    public static final a b = new a(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1013a;

    public /* synthetic */ a(int i) {
        this.f1013a = i;
    }

    @Override // g9.InterfaceC1474a
    public final Iterable c(Object obj) {
        Collection collectionE;
        switch (this.f1013a) {
            case 0:
                int i = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f5120a;
                Collection collectionE2 = ((Q) obj).e();
                ArrayList arrayList = new ArrayList(w.c0(collectionE2, 10));
                Iterator it = ((ArrayList) collectionE2).iterator();
                while (it.hasNext()) {
                    arrayList.add(((Q) it.next()).a());
                }
                return arrayList;
            default:
                InterfaceC1520c interfaceC1520c = (InterfaceC1520c) obj;
                return (interfaceC1520c == null || (collectionE = interfaceC1520c.e()) == null) ? EmptyList.f4893a : collectionE;
        }
    }
}
