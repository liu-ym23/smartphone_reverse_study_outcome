package ie;

import java.io.IOException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class y extends w0 {

    /* renamed from: b, reason: collision with root package name */
    public Method f6099b;

    /* renamed from: c, reason: collision with root package name */
    public int f6100c;

    /* renamed from: d, reason: collision with root package name */
    public l f6101d;

    @Override // ie.w0
    public final void a(l0 l0Var, Object obj) {
        int i = this.f6100c;
        Method method = this.f6099b;
        if (obj == null) {
            throw w0.n(method, i, "Body parameter value must not be null.", new Object[0]);
        }
        try {
            l0Var.f6016k = (ad.c0) this.f6101d.convert(obj);
        } catch (IOException e10) {
            throw w0.o(method, e10, i, "Unable to convert " + obj + " to RequestBody", new Object[0]);
        }
    }
}
