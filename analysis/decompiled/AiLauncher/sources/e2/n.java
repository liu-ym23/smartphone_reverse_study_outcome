package e2;

import java.util.Set;

/* loaded from: classes2.dex */
public final class n implements b2.f {

    /* renamed from: a, reason: collision with root package name */
    public final Set<b2.b> f32274a;

    /* renamed from: b, reason: collision with root package name */
    public final m f32275b;

    /* renamed from: c, reason: collision with root package name */
    public final q f32276c;

    public n(Set<b2.b> set, m mVar, q qVar) {
        this.f32274a = set;
        this.f32275b = mVar;
        this.f32276c = qVar;
    }

    @Override // b2.f
    public <T> b2.e<T> a(String str, Class<T> cls, b2.b bVar, b2.d<T, byte[]> dVar) {
        if (this.f32274a.contains(bVar)) {
            return new p(this.f32275b, str, bVar, dVar, this.f32276c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, this.f32274a));
    }
}
