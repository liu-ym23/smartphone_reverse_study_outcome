package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements v {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1388c;

    /* renamed from: f, reason: collision with root package name */
    public Object f1389f;

    /* renamed from: g, reason: collision with root package name */
    public Object f1390g;

    public h(f fVar, v vVar) {
        this.f1388c = 0;
        fVar.getClass();
        this.f1389f = fVar;
        this.f1390g = vVar;
    }

    @Override // androidx.lifecycle.v
    public final void e(x xVar, o oVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        switch (this.f1388c) {
            case 0:
                f fVar = (f) this.f1389f;
                switch (g.f1380a[oVar.ordinal()]) {
                    case 1:
                        fVar.getClass();
                        break;
                    case 2:
                        fVar.o(xVar);
                        break;
                    case 3:
                        fVar.d(xVar);
                        break;
                    case 4:
                        fVar.getClass();
                        break;
                    case 5:
                        fVar.g(xVar);
                        break;
                    case 6:
                        fVar.i(xVar);
                        break;
                    case 7:
                        g5.f.s("ON_ANY must not been send by anybody");
                        break;
                    default:
                        g5.f.a();
                        break;
                }
                v vVar = (v) this.f1390g;
                if (vVar != null) {
                    vVar.e(xVar, oVar);
                    break;
                }
                break;
            case 1:
                if (oVar == o.ON_START) {
                    ((q) this.f1389f).c(this);
                    ((t4.d) this.f1390g).d();
                    break;
                }
                break;
            default:
                b bVar = (b) this.f1390g;
                w wVar = (w) this.f1389f;
                HashMap map = bVar.f1357a;
                b.a((List) map.get(oVar), xVar, oVar, wVar);
                b.a((List) map.get(o.ON_ANY), xVar, oVar, wVar);
                break;
        }
    }

    public /* synthetic */ h(int i) {
        this.f1388c = i;
    }
}
