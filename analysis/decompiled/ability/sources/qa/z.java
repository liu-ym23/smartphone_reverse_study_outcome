package qa;

import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes4.dex */
public final class z extends U {
    public final /* synthetic */ int d;
    public final Method e;
    public final int f;
    public final boolean g;

    public /* synthetic */ z(Method method, int i, boolean z10, int i6) {
        this.d = i6;
        this.e = method;
        this.f = i;
        this.g = z10;
    }

    @Override // qa.U
    public final void a(I i, Object obj) {
        switch (this.d) {
            case 0:
                Map map = (Map) obj;
                int i6 = this.f;
                Method method = this.e;
                if (map == null) {
                    throw U.l(method, i6, "Field map was null.", new Object[0]);
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null) {
                        throw U.l(method, i6, "Field map contained null key.", new Object[0]);
                    }
                    Object value = entry.getValue();
                    if (value == null) {
                        throw U.l(method, i6, B7.a.m("Field map contained null value for key '", str, "'."), new Object[0]);
                    }
                    String string = value.toString();
                    if (string == null) {
                        throw U.l(method, i6, "Field map value '" + value + "' converted to null by " + C1849a.class.getName() + " for key '" + str + "'.", new Object[0]);
                    }
                    i.a(str, string, this.g);
                }
                return;
            case 1:
                Map map2 = (Map) obj;
                int i10 = this.f;
                Method method2 = this.e;
                if (map2 == null) {
                    throw U.l(method2, i10, "Header map was null.", new Object[0]);
                }
                for (Map.Entry entry2 : map2.entrySet()) {
                    String str2 = (String) entry2.getKey();
                    if (str2 == null) {
                        throw U.l(method2, i10, "Header map contained null key.", new Object[0]);
                    }
                    Object value2 = entry2.getValue();
                    if (value2 == null) {
                        throw U.l(method2, i10, B7.a.m("Header map contained null value for key '", str2, "'."), new Object[0]);
                    }
                    i.b(str2, value2.toString(), this.g);
                }
                return;
            default:
                Map map3 = (Map) obj;
                int i11 = this.f;
                Method method3 = this.e;
                if (map3 == null) {
                    throw U.l(method3, i11, "Query map was null", new Object[0]);
                }
                for (Map.Entry entry3 : map3.entrySet()) {
                    String str3 = (String) entry3.getKey();
                    if (str3 == null) {
                        throw U.l(method3, i11, "Query map contained null key.", new Object[0]);
                    }
                    Object value3 = entry3.getValue();
                    if (value3 == null) {
                        throw U.l(method3, i11, B7.a.m("Query map contained null value for key '", str3, "'."), new Object[0]);
                    }
                    String string2 = value3.toString();
                    if (string2 == null) {
                        throw U.l(method3, i11, "Query map value '" + value3 + "' converted to null by " + C1849a.class.getName() + " for key '" + str3 + "'.", new Object[0]);
                    }
                    i.d(str3, string2, this.g);
                }
                return;
        }
    }
}
