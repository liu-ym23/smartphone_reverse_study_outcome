package aa7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class k extends a {
    static {
    }

    public k() {
    }

    @Override // aa7.a
    public final List<ca7.c> a(ba7.a r100, ea7.b r101, int r102) {
        int r103 = 0;
        List<ca7.c> r104 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 0), r102);
        List<ca7.c> r105 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 1), r102);
        ca7.g r106 = (ca7.g) ListProtector.get(r104, 0);
        Object r107 = ((ca7.d) ListProtector.get(r105, 0)).f22958c;
        ca7.j r108 = new ca7.j();
        r100.f18422d.add(r108);
        if ((r107 instanceof Iterable) == false) goto L9;
        Iterator r109 = ((Iterable) r107).iterator();
    L6:
        if (r109.hasNext() == false) goto L13;
        Object r110 = r109.next();
        ca7.c r111 = r100.a(r110);
        r106.g(r110, r111);
        r111.a(r108);
    L13:
        ArrayList r112 = new ArrayList();
        r112.add(r108);
        return r112;
    L9:
        if ((r107 instanceof Object[]) == false) goto L13;
        Object[] r113 = (Object[]) r107;
        int r114 = r113.length;
    L11:
        if (r103 >= r114) goto L13;
        Object r115 = r113[r103];
        ca7.c r116 = r100.a(r115);
        r106.g(r115, r116);
        r116.a(r108);
        r103 = r103 + 1;
        goto L11
    }
}
