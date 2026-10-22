package aa7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class h extends a {
    static {
    }

    public h() {
    }

    @Override // aa7.a
    public final List<ca7.c> a(ba7.a r100, ea7.b r101, int r102) {
        List<ca7.c> r103 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 0), r102);
        List<ca7.c> r104 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 1), r102);
        ca7.g r105 = (ca7.g) ListProtector.get(r103, 0);
        ca7.d r106 = (ca7.d) ListProtector.get(r104, 0);
        Object r107 = r106.f22958c;
        ca7.j r108 = new ca7.j();
        r100.f18422d.add(r108);
        r105.g(r107, r106);
        r106.a(r108);
        ArrayList r109 = new ArrayList();
        r109.add(r108);
        return r109;
    }
}
