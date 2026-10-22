package Sb;

import Rb.d;
import Yb.u;
import dc.InterfaceC3968b;
import dc.e;
import java.io.IOException;
import java.util.Set;
import org.commonmark.ext.gfm.tables.TableCell;

/* loaded from: classes5.dex */
public class c extends b {

    /* renamed from: a, reason: collision with root package name */
    public final e f5817a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC3968b f5818b;

    public c(InterfaceC3968b interfaceC3968b) {
        this.f5817a = interfaceC3968b.c();
        this.f5818b = interfaceC3968b;
    }

    private void g(u uVar) {
        u uVarC = uVar.c();
        while (uVarC != null) {
            u uVarE = uVarC.e();
            if ((uVarC instanceof TableCell) && uVarE == null) {
                h((TableCell) uVarC);
            } else {
                this.f5818b.a(uVarC);
            }
            uVarC = uVarE;
        }
    }

    @Override // Sb.b, cc.InterfaceC1510a
    public /* bridge */ /* synthetic */ void a(u uVar) {
        super.a(uVar);
    }

    @Override // Sb.b
    public void b(Rb.a aVar) throws IOException {
        g(aVar);
        if (aVar.e() != null) {
            this.f5817a.g("\n");
        }
    }

    @Override // Sb.b
    public void c(Rb.b bVar) {
        g(bVar);
    }

    @Override // Sb.b
    public void d(TableCell tableCell) throws IOException {
        g(tableCell);
        this.f5817a.f('|');
        this.f5817a.e();
    }

    @Override // Sb.b
    public void e(Rb.c cVar) {
        g(cVar);
    }

    @Override // Sb.b
    public void f(d dVar) throws IOException {
        this.f5817a.d();
        g(dVar);
        this.f5817a.d();
    }

    public final void h(TableCell tableCell) {
        g(tableCell);
    }

    @Override // Sb.b, cc.InterfaceC1510a
    public /* bridge */ /* synthetic */ Set y() {
        return super.y();
    }
}
