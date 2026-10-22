package fa;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class g implements j {

    /* renamed from: a, reason: collision with root package name */
    public final j f3626a;

    /* renamed from: b, reason: collision with root package name */
    public final p7.k f3627b;

    /* renamed from: c, reason: collision with root package name */
    public final p7.k f3628c;

    public g(j jVar, p7.k kVar, p7.k kVar2) {
        q7.k.e(kVar, "transformer");
        this.f3626a = jVar;
        this.f3627b = kVar;
        this.f3628c = kVar2;
    }

    @Override // fa.j
    public final Iterator iterator() {
        return new e(this);
    }
}
