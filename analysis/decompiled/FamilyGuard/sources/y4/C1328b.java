package y4;

import V3.n;
import V3.o;
import Z3.e;
import Z3.i;
import a4.C0428b;
import i4.p;
import j4.z;
import kotlin.coroutines.jvm.internal.h;
import s4.C1096y;
import s4.v0;
import x4.C1290B;
import x4.C1298J;

/* renamed from: y4.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1328b {
    public static final <R, T> void a(p<? super R, ? super e<? super T>, ? extends Object> pVar, R r5, e<? super T> eVar) {
        e eVarA = h.a(eVar);
        try {
            i context = eVar.getContext();
            Object objC = C1298J.c(context, null);
            try {
                Object objD = !(pVar instanceof kotlin.coroutines.jvm.internal.a) ? C0428b.d(pVar, r5, eVarA) : ((p) z.b(pVar, 2)).invoke(r5, eVarA);
                C1298J.a(context, objC);
                if (objD != C0428b.e()) {
                    eVarA.resumeWith(n.a(objD));
                }
            } catch (Throwable th) {
                C1298J.a(context, objC);
                throw th;
            }
        } catch (Throwable th2) {
            n.a aVar = n.f5531a;
            eVarA.resumeWith(n.a(o.a(th2)));
        }
    }

    public static final <T, R> Object b(C1290B<? super T> c1290b, R r5, p<? super R, ? super e<? super T>, ? extends Object> pVar) {
        Object c1096y;
        Object objM0;
        try {
            c1096y = !(pVar instanceof kotlin.coroutines.jvm.internal.a) ? C0428b.d(pVar, r5, c1290b) : ((p) z.b(pVar, 2)).invoke(r5, c1290b);
        } catch (Throwable th) {
            c1096y = new C1096y(th, false, 2, null);
        }
        if (c1096y != C0428b.e() && (objM0 = c1290b.m0(c1096y)) != v0.f20385b) {
            if (objM0 instanceof C1096y) {
                throw ((C1096y) objM0).f20398a;
            }
            return v0.h(objM0);
        }
        return C0428b.e();
    }
}
