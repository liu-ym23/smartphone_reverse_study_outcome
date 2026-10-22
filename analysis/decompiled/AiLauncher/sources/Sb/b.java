package Sb;

import Rb.d;
import Yb.u;
import cc.InterfaceC1510a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.commonmark.ext.gfm.tables.TableCell;

/* loaded from: classes5.dex */
public abstract class b implements InterfaceC1510a {
    @Override // cc.InterfaceC1510a
    public void a(u uVar) {
        if (uVar instanceof Rb.a) {
            b((Rb.a) uVar);
            return;
        }
        if (uVar instanceof Rb.c) {
            e((Rb.c) uVar);
            return;
        }
        if (uVar instanceof Rb.b) {
            c((Rb.b) uVar);
        } else if (uVar instanceof d) {
            f((d) uVar);
        } else if (uVar instanceof TableCell) {
            d((TableCell) uVar);
        }
    }

    public abstract void b(Rb.a aVar);

    public abstract void c(Rb.b bVar);

    public abstract void d(TableCell tableCell);

    public abstract void e(Rb.c cVar);

    public abstract void f(d dVar);

    @Override // cc.InterfaceC1510a
    public Set<Class<? extends u>> y() {
        return new HashSet(Arrays.asList(Rb.a.class, Rb.c.class, Rb.b.class, d.class, TableCell.class));
    }
}
