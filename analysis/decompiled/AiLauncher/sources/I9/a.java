package I9;

import E9.l0;
import E9.m0;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class a extends m0 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f3395c = new a();

    public a() {
        super("package", false);
    }

    @Override // E9.m0
    public Integer a(m0 visibility) {
        p.i(visibility, "visibility");
        if (this == visibility) {
            return 0;
        }
        return l0.f2454a.b(visibility) ? 1 : -1;
    }

    @Override // E9.m0
    public String b() {
        return "public/*package*/";
    }

    @Override // E9.m0
    public m0 d() {
        return l0.g.f2463c;
    }
}
