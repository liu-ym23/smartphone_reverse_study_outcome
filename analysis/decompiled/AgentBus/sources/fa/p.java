package fa;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class p implements j {

    /* renamed from: a, reason: collision with root package name */
    public final j f3642a;

    /* renamed from: b, reason: collision with root package name */
    public final p7.k f3643b;

    public p(j jVar, p7.k kVar) {
        q7.k.e(kVar, "transformer");
        this.f3642a = jVar;
        this.f3643b = kVar;
    }

    @Override // fa.j
    public final Iterator iterator() {
        return new o(this);
    }
}
