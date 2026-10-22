package x4;

import java.util.Iterator;
import s4.C1058G;
import s4.InterfaceC1057F;

/* renamed from: x4.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1308h {
    public static final void a(Z3.i iVar, Throwable th) {
        Iterator<InterfaceC1057F> it = C1307g.a().iterator();
        while (it.hasNext()) {
            try {
                it.next().v(iVar, th);
            } catch (Throwable th2) {
                C1307g.b(C1058G.b(th, th2));
            }
        }
        try {
            V3.a.a(th, new C1309i(iVar));
        } catch (Throwable unused) {
        }
        C1307g.b(th);
    }
}
