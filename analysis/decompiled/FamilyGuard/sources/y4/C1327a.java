package y4;

import V3.n;
import V3.o;
import V3.v;
import Z3.e;
import a4.C0428b;
import i4.InterfaceC0772l;
import i4.p;
import x4.C1311k;

/* renamed from: y4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1327a {
    private static final void a(e<?> eVar, Throwable th) throws Throwable {
        n.a aVar = n.f5531a;
        eVar.resumeWith(n.a(o.a(th)));
        throw th;
    }

    public static final void b(e<? super v> eVar, e<?> eVar2) throws Throwable {
        try {
            e eVarC = C0428b.c(eVar);
            n.a aVar = n.f5531a;
            C1311k.c(eVarC, n.a(v.f5542a), null, 2, null);
        } catch (Throwable th) {
            a(eVar2, th);
        }
    }

    public static final <R, T> void c(p<? super R, ? super e<? super T>, ? extends Object> pVar, R r5, e<? super T> eVar, InterfaceC0772l<? super Throwable, v> interfaceC0772l) throws Throwable {
        try {
            e eVarC = C0428b.c(C0428b.a(pVar, r5, eVar));
            n.a aVar = n.f5531a;
            C1311k.b(eVarC, n.a(v.f5542a), interfaceC0772l);
        } catch (Throwable th) {
            a(eVar, th);
        }
    }

    public static /* synthetic */ void d(p pVar, Object obj, e eVar, InterfaceC0772l interfaceC0772l, int i5, Object obj2) throws Throwable {
        if ((i5 & 4) != 0) {
            interfaceC0772l = null;
        }
        c(pVar, obj, eVar, interfaceC0772l);
    }
}
