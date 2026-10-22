package qa;

import F9.AbstractC0226d;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes4.dex */
public final class B extends U {
    public final /* synthetic */ int d = 0;
    public final Method e;
    public final int f;
    public final InterfaceC1859k g;
    public final Object h;

    public B(Method method, int i, F9.w wVar, InterfaceC1859k interfaceC1859k) {
        this.e = method;
        this.f = i;
        this.h = wVar;
        this.g = interfaceC1859k;
    }

    @Override // qa.U
    public final void a(I i, Object obj) {
        switch (this.d) {
            case 0:
                if (obj == null) {
                    return;
                }
                try {
                    i.c((F9.w) this.h, (F9.K) this.g.convert(obj));
                    return;
                } catch (IOException e) {
                    throw U.l(this.e, this.f, androidx.compose.foundation.b.s(obj, "Unable to convert ", " to RequestBody"), e);
                }
            default:
                Map map = (Map) obj;
                int i6 = this.f;
                Method method = this.e;
                if (map == null) {
                    throw U.l(method, i6, "Part map was null.", new Object[0]);
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null) {
                        throw U.l(method, i6, "Part map contained null key.", new Object[0]);
                    }
                    Object value = entry.getValue();
                    if (value == null) {
                        throw U.l(method, i6, B7.a.m("Part map contained null value for key '", str, "'."), new Object[0]);
                    }
                    i.c(AbstractC0226d.i("Content-Disposition", B7.a.m("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", (String) this.h), (F9.K) this.g.convert(value));
                }
                return;
        }
    }

    public B(Method method, int i, InterfaceC1859k interfaceC1859k, String str) {
        this.e = method;
        this.f = i;
        this.g = interfaceC1859k;
        this.h = str;
    }
}
