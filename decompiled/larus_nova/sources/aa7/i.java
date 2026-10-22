package aa7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class i extends a {
    static {
    }

    public i() {
    }

    @Override // aa7.a
    public final List<ca7.c> a(ba7.a r100, ea7.b r101, int r102) {
        int r103 = ((com.bytedance.express.command.d) r101.f471626a).f243203b;
        List<ca7.c> r104 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 0), r102);
        ca7.j r105 = new ca7.j();
        r100.f18422d.add(r105);
        Iterator<ca7.c> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        r106.next().a(r105);
        goto L4
    L6:
        ArrayList r107 = new ArrayList();
        r107.add(r105);
        return r107;
    }
}
