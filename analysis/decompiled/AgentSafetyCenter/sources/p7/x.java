package p7;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class x extends m7.n {

    /* renamed from: a, reason: collision with root package name */
    public final z f9915a;

    public x(z zVar) {
        this.f9915a = zVar;
    }

    public abstract Object a();

    public abstract Object b(Object obj);

    public abstract void c(Object obj, u7.a aVar, w wVar);

    @Override // m7.n
    public final Object read(u7.a aVar) throws IOException {
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        Object objA = a();
        Map map = this.f9915a.f9921a;
        try {
            aVar.e();
            while (aVar.H()) {
                w wVar = (w) map.get(aVar.S());
                if (wVar == null) {
                    aVar.e0();
                } else {
                    c(objA, aVar, wVar);
                }
            }
            aVar.o();
            return b(objA);
        } catch (IllegalAccessException e10) {
            ac.a aVar2 = r7.c.f10473a;
            od.f.g("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e10);
            return null;
        } catch (IllegalStateException e11) {
            throw new m7.h(e11);
        }
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) throws IllegalArgumentException, InvocationTargetException {
        if (obj == null) {
            cVar.C();
            return;
        }
        cVar.g();
        try {
            Iterator it = this.f9915a.f9922b.iterator();
            while (it.hasNext()) {
                ((w) it.next()).a(cVar, obj);
            }
            cVar.o();
        } catch (IllegalAccessException e10) {
            ac.a aVar = r7.c.f10473a;
            od.f.g("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e10);
        }
    }
}
