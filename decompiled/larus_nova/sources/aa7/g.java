package aa7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends a {
    static {
    }

    public g() {
    }

    @Override // aa7.a
    public final List<ca7.c> a(ba7.a r100, ea7.b r101, int r102) {
        int r103 = 0;
        List<ca7.c> r104 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 0), r102);
        List<ca7.c> r105 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 1), r102);
        ca7.g r106 = (ca7.g) ListProtector.get(r104, 0);
        r106.f22961e = true;
        Object r107 = ((ca7.d) ListProtector.get(r105, 0)).f22958c;
        ArrayList r108 = new ArrayList();
        if ((r107 instanceof Iterable) == false) goto L9;
        Iterator r109 = ((Iterable) r107).iterator();
    L6:
        if (r109.hasNext() == false) goto L13;
        Object r110 = r109.next();
        ca7.c r111 = r100.a(r110);
        r106.g(r110, r111);
        r108.add(r111);
    L13:
        return r108;
    L9:
        if ((r107 instanceof Object[]) == false) goto L13;
        Object[] r112 = (Object[]) r107;
        int r113 = r112.length;
    L11:
        if (r103 >= r113) goto L13;
        Object r114 = r112[r103];
        ca7.c r115 = r100.a(r114);
        r106.g(r114, r115);
        r108.add(r115);
        r103 = r103 + 1;
        goto L11
    }
}
