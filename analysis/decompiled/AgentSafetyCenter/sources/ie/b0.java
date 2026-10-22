package ie;

import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class b0 extends w0 {

    /* renamed from: b, reason: collision with root package name */
    public final String f5978b;

    /* renamed from: c, reason: collision with root package name */
    public final a f5979c;

    public b0(String str) {
        a aVar = a.f5967f;
        Objects.requireNonNull(str, "name == null");
        this.f5978b = str;
        this.f5979c = aVar;
    }

    @Override // ie.w0
    public final void a(l0 l0Var, Object obj) {
        if (obj == null) {
            return;
        }
        this.f5979c.getClass();
        String string = obj.toString();
        if (string == null) {
            return;
        }
        l0Var.b(this.f5978b, string);
    }
}
