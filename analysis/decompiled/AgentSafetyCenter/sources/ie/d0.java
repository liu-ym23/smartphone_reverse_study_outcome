package ie;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class d0 extends w0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5983b = 1;

    /* renamed from: c, reason: collision with root package name */
    public Method f5984c;

    /* renamed from: d, reason: collision with root package name */
    public int f5985d;

    /* renamed from: e, reason: collision with root package name */
    public l f5986e;

    /* renamed from: f, reason: collision with root package name */
    public Object f5987f;

    public d0(Method method, int i, ad.n nVar, l lVar) {
        this.f5984c = method;
        this.f5985d = i;
        this.f5987f = nVar;
        this.f5986e = lVar;
    }

    @Override // ie.w0
    public final void a(l0 l0Var, Object obj) {
        switch (this.f5983b) {
            case 0:
                if (obj == null) {
                    return;
                }
                try {
                    l0Var.c((ad.n) this.f5987f, (ad.c0) this.f5986e.convert(obj));
                    return;
                } catch (IOException e10) {
                    throw w0.n(this.f5984c, this.f5985d, "Unable to convert " + obj + " to RequestBody", e10);
                }
            default:
                Map map = (Map) obj;
                int i = this.f5985d;
                Method method = this.f5984c;
                if (map == null) {
                    throw w0.n(method, i, "Part map was null.", new Object[0]);
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null) {
                        throw w0.n(method, i, "Part map contained null key.", new Object[0]);
                    }
                    Object value = entry.getValue();
                    if (value == null) {
                        throw w0.n(method, i, k0.a.C("Part map contained null value for key '", str, "'."), new Object[0]);
                    }
                    l0Var.c(id.c.z("Content-Disposition", k0.a.C("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", (String) this.f5987f), (ad.c0) this.f5986e.convert(value));
                }
                return;
        }
    }

    public /* synthetic */ d0() {
    }
}
