package aa7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends a {
    static {
    }

    public f() {
    }

    @Override // aa7.a
    public final List<ca7.c> a(ba7.a r100, ea7.b r101, int r102) {
        int r103 = 0;
        List<ca7.c> r104 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 0), r102);
        List<ca7.c> r105 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 1), r102);
        ca7.g r106 = (ca7.g) ListProtector.get(r104, 0);
        ArrayList r107 = new ArrayList();
        if ((ListProtector.get(r105, 0) instanceof ca7.g) == false) goto L5;
        ca7.h r108 = new ca7.h(((ca7.g) ListProtector.get(r105, 0)).f22959c);
        r106.a(r108);
        r107.add(r108);
    L16:
        return r107;
    L5:
        Object r109 = ((ca7.d) ListProtector.get(r105, 0)).f22958c;
        if ((r109 instanceof Iterable) == false) goto L12;
        Iterator r110 = ((Iterable) r109).iterator();
    L9:
        if (r110.hasNext() == false) goto L16;
        Object r111 = r110.next();
        ca7.c r112 = r100.a(r111);
        r106.g(r111, r112);
        r107.add(r112);
        goto L9
    L12:
        if ((r109 instanceof Object[]) == false) goto L16;
        Object[] r113 = (Object[]) r109;
        int r114 = r113.length;
    L14:
        if (r103 >= r114) goto L16;
        Object r115 = r113[r103];
        ca7.c r116 = r100.a(r115);
        r106.g(r115, r116);
        r107.add(r116);
        r103 = r103 + 1;
        goto L14
    }
}
