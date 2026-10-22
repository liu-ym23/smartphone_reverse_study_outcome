package i8;

/* renamed from: i8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4177a<T> implements d {

    /* renamed from: a, reason: collision with root package name */
    public d<T> f33069a;

    public static <T> void a(d<T> dVar, d<T> dVar2) {
        b((C4177a) dVar, dVar2);
    }

    public static <T> void b(C4177a<T> c4177a, d<T> dVar) {
        c.b(dVar);
        if (c4177a.f33069a != null) {
            throw new IllegalStateException();
        }
        c4177a.f33069a = dVar;
    }

    @Override // X8.a
    public T get() {
        d<T> dVar = this.f33069a;
        if (dVar != null) {
            return dVar.get();
        }
        throw new IllegalStateException();
    }
}
