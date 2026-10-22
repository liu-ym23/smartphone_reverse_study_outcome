package aa7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends a {
    static {
    }

    public b() {
    }

    @Override // aa7.a
    public final List<ca7.c> a(ba7.a r100, ea7.b r101, int r102) {
        ca7.a r103 = new ca7.a();
        List<ca7.c> r104 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 0), r102);
        List<ca7.c> r105 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 1), r102);
        Iterator<ca7.c> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        r106.next().a(r103.f22952c);
        goto L4
    L6:
        Iterator<ca7.c> r107 = r105.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        r107.next().a(r103.f22953d);
        goto L8
    L10:
        ArrayList r108 = new ArrayList();
        r108.add(r103);
        return r108;
    }
}
