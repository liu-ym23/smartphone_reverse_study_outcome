package O8;

import O8.h;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class a {
    public void a(List<? extends h.b> list) {
        for (h.b bVar : list) {
            if (bVar.e()) {
                b((h.d) bVar);
            } else {
                c((h.e) bVar);
            }
        }
    }

    public abstract void b(h.d dVar);

    public abstract void c(h.e eVar);
}
