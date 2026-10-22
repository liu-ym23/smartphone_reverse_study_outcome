package qa;

import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class x extends U {
    public final Method d;
    public final int e;
    public final InterfaceC1859k f;

    public x(Method method, int i, InterfaceC1859k interfaceC1859k) {
        this.d = method;
        this.e = i;
        this.f = interfaceC1859k;
    }

    @Override // qa.U
    public final void a(I i, Object obj) {
        int i6 = this.e;
        Method method = this.d;
        if (obj == null) {
            throw U.l(method, i6, "Body parameter value must not be null.", new Object[0]);
        }
        try {
            i.k = (F9.K) this.f.convert(obj);
        } catch (IOException e) {
            throw U.m(method, e, i6, androidx.compose.foundation.b.s(obj, "Unable to convert ", " to RequestBody"), new Object[0]);
        }
    }
}
