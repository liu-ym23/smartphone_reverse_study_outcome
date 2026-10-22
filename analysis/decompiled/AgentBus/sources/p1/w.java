package p1;

import i1.f0;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class w implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8376a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8377b;

    public /* synthetic */ w(int i2, Object obj) {
        this.f8376a = i2;
        this.f8377b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f8376a) {
            case 0:
                int iCompare = ((Comparator) this.f8377b).compare(obj, obj2);
                if (iCompare != 0) {
                    return iCompare;
                }
                return f0.S.compare(((n) obj).f8314c, ((n) obj2).f8314c);
            case 1:
                int iCompare2 = ((w) this.f8377b).compare(obj, obj2);
                return iCompare2 != 0 ? iCompare2 : ib.k.q(Integer.valueOf(((n) obj).f8318g), Integer.valueOf(((n) obj2).f8318g));
            default:
                v9.v vVar = (v9.v) obj;
                p7.k kVar = (p7.k) this.f8377b;
                q7.k.d(vVar, "it");
                String string = kVar.invoke(vVar).toString();
                v9.v vVar2 = (v9.v) obj2;
                q7.k.d(vVar2, "it");
                return ib.k.q(string, kVar.invoke(vVar2).toString());
        }
    }

    public w(Comparator comparator) {
        this.f8376a = 0;
        this.f8377b = comparator;
    }
}
