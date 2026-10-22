package I9;

import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f851a;
    public final boolean b;
    public c c;
    public long d;

    public a(String name, boolean z10) {
        k.f(name, "name");
        this.f851a = name;
        this.b = z10;
        this.d = -1L;
    }

    public abstract long a();

    public final String toString() {
        return this.f851a;
    }
}
