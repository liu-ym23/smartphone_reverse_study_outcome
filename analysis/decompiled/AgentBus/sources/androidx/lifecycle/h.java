package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class h implements t {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f995f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final Object f996g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f997h;

    public h(f fVar, t tVar) {
        q7.k.e(fVar, "defaultLifecycleObserver");
        this.f996g = fVar;
        this.f997h = tVar;
    }

    @Override // androidx.lifecycle.t
    public final void b(v vVar, p pVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        switch (this.f995f) {
            case 0:
                f fVar = (f) this.f996g;
                switch (g.$EnumSwitchMapping$0[pVar.ordinal()]) {
                    case 1:
                        fVar.getClass();
                        break;
                    case 2:
                        fVar.d(vVar);
                        break;
                    case 3:
                        fVar.a(vVar);
                        break;
                    case 4:
                        fVar.getClass();
                        break;
                    case 5:
                        fVar.e(vVar);
                        break;
                    case 6:
                        fVar.getClass();
                        break;
                    case 7:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                    default:
                        throw new a4.u();
                }
                t tVar = (t) this.f997h;
                if (tVar != null) {
                    tVar.b(vVar, pVar);
                    return;
                }
                return;
            case 1:
                if (pVar == p.ON_START) {
                    ((x) this.f996g).f(this);
                    ((q6.b) this.f997h).N0();
                    return;
                }
                return;
            default:
                HashMap map = ((b) this.f997h).f976a;
                List list = (List) map.get(pVar);
                Object obj = this.f996g;
                b.a(list, vVar, pVar, obj);
                b.a((List) map.get(p.ON_ANY), vVar, pVar, obj);
                return;
        }
    }

    public h(u uVar) {
        this.f996g = uVar;
        d dVar = d.f988c;
        Class<?> cls = uVar.getClass();
        b bVar = (b) dVar.f989a.get(cls);
        this.f997h = bVar == null ? dVar.a(cls, null) : bVar;
    }

    public h(x xVar, q6.b bVar) {
        this.f996g = xVar;
        this.f997h = bVar;
    }
}
