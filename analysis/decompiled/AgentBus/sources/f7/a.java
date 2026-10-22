package f7;

import java.util.Comparator;
import p7.k;
import p7.n;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3455a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3456b;

    public /* synthetic */ a(int i2, Object obj) {
        this.f3455a = i2;
        this.f3456b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i2 = this.f3455a;
        Object obj3 = this.f3456b;
        switch (i2) {
            case 0:
                for (k kVar : (k[]) obj3) {
                    int iQ = ib.k.q((Comparable) kVar.invoke(obj), (Comparable) kVar.invoke(obj2));
                    if (iQ != 0) {
                        return iQ;
                    }
                }
                return 0;
            default:
                return ((Number) ((n) obj3).invoke(obj, obj2)).intValue();
        }
    }
}
