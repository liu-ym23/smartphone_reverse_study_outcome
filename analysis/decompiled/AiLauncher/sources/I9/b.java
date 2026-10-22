package I9;

import E9.l0;
import E9.m0;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class b extends m0 {

    /* renamed from: c, reason: collision with root package name */
    public static final b f3396c = new b();

    public b() {
        super("protected_and_package", true);
    }

    @Override // E9.m0
    public Integer a(m0 visibility) {
        p.i(visibility, "visibility");
        if (p.d(this, visibility)) {
            return 0;
        }
        if (visibility == l0.b.f2458c) {
            return null;
        }
        return l0.f2454a.b(visibility) ? 1 : -1;
    }

    @Override // E9.m0
    public String b() {
        return "protected/*protected and package*/";
    }

    @Override // E9.m0
    public m0 d() {
        return l0.g.f2463c;
    }
}
