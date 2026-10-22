package ie;

import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class a0 extends w0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5973b;

    /* renamed from: c, reason: collision with root package name */
    public Method f5974c;

    /* renamed from: d, reason: collision with root package name */
    public int f5975d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5976e;

    @Override // ie.w0
    public final void a(l0 l0Var, Object obj) {
        switch (this.f5973b) {
            case 0:
                Map map = (Map) obj;
                int i = this.f5975d;
                Method method = this.f5974c;
                if (map == null) {
                    throw w0.n(method, i, "Field map was null.", new Object[0]);
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null) {
                        throw w0.n(method, i, "Field map contained null key.", new Object[0]);
                    }
                    Object value = entry.getValue();
                    if (value == null) {
                        throw w0.n(method, i, k0.a.C("Field map contained null value for key '", str, "'."), new Object[0]);
                    }
                    String string = value.toString();
                    if (string == null) {
                        throw w0.n(method, i, "Field map value '" + value + "' converted to null by " + a.class.getName() + " for key '" + str + "'.", new Object[0]);
                    }
                    l0Var.a(str, string, this.f5976e);
                }
                return;
            default:
                Map map2 = (Map) obj;
                int i3 = this.f5975d;
                Method method2 = this.f5974c;
                if (map2 == null) {
                    throw w0.n(method2, i3, "Query map was null", new Object[0]);
                }
                for (Map.Entry entry2 : map2.entrySet()) {
                    String str2 = (String) entry2.getKey();
                    if (str2 == null) {
                        throw w0.n(method2, i3, "Query map contained null key.", new Object[0]);
                    }
                    Object value2 = entry2.getValue();
                    if (value2 == null) {
                        throw w0.n(method2, i3, k0.a.C("Query map contained null value for key '", str2, "'."), new Object[0]);
                    }
                    String string2 = value2.toString();
                    if (string2 == null) {
                        throw w0.n(method2, i3, "Query map value '" + value2 + "' converted to null by " + a.class.getName() + " for key '" + str2 + "'.", new Object[0]);
                    }
                    l0Var.d(str2, string2, this.f5976e);
                }
                return;
        }
    }
}
