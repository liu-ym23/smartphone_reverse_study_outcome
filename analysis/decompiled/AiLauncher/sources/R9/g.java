package R9;

import P9.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;

/* loaded from: classes5.dex */
public final class g implements j {

    /* renamed from: c, reason: collision with root package name */
    public static final a f5583c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final P9.f f5584d = new P9.f(t.b(g.class));

    /* renamed from: a, reason: collision with root package name */
    public boolean f5585a;

    /* renamed from: b, reason: collision with root package name */
    public final List<N9.b> f5586b = new ArrayList();

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    public final List<N9.b> a() {
        return this.f5586b;
    }

    public final void b(boolean z10) {
        this.f5585a = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!p.d(g.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        p.g(obj, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmTypeExtension");
        g gVar = (g) obj;
        return this.f5585a == gVar.f5585a && p.d(this.f5586b, gVar.f5586b);
    }

    @Override // P9.e
    public P9.f getType() {
        return f5584d;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f5585a) * 31) + this.f5586b.hashCode();
    }
}
