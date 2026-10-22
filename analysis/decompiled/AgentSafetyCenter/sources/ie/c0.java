package ie;

import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class c0 extends w0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5980b;

    /* renamed from: c, reason: collision with root package name */
    public Method f5981c;

    /* renamed from: d, reason: collision with root package name */
    public int f5982d;

    @Override // ie.w0
    public final void a(l0 l0Var, Object obj) {
        switch (this.f5980b) {
            case 0:
                Map map = (Map) obj;
                int i = this.f5982d;
                Method method = this.f5981c;
                if (map == null) {
                    throw w0.n(method, i, "Header map was null.", new Object[0]);
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null) {
                        throw w0.n(method, i, "Header map contained null key.", new Object[0]);
                    }
                    Object value = entry.getValue();
                    if (value == null) {
                        throw w0.n(method, i, k0.a.C("Header map contained null value for key '", str, "'."), new Object[0]);
                    }
                    l0Var.b(str, value.toString());
                }
                return;
            case 1:
                ad.n nVar = (ad.n) obj;
                if (nVar == null) {
                    throw w0.n(this.f5981c, this.f5982d, "Headers parameter must not be null.", new Object[0]);
                }
                ne.b bVar = l0Var.f6012f;
                bVar.getClass();
                int size = nVar.size();
                for (int i3 = 0; i3 < size; i3++) {
                    bVar.b(nVar.b(i3), nVar.d(i3));
                }
                return;
            default:
                if (obj == null) {
                    throw w0.n(this.f5981c, this.f5982d, "@Url parameter is null.", new Object[0]);
                }
                l0Var.f6009c = obj.toString();
                return;
        }
    }
}
