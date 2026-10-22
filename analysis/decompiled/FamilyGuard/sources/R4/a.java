package R4;

import C4.E;
import C4.G;
import R4.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class a extends f.a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4993a = true;

    /* renamed from: R4.a$a, reason: collision with other inner class name */
    static final class C0075a implements R4.f<G, G> {

        /* renamed from: a, reason: collision with root package name */
        static final C0075a f4994a = new C0075a();

        C0075a() {
        }

        @Override // R4.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public G a(G g5) {
            try {
                return y.a(g5);
            } finally {
                g5.close();
            }
        }
    }

    static final class b implements R4.f<E, E> {

        /* renamed from: a, reason: collision with root package name */
        static final b f4995a = new b();

        b() {
        }

        @Override // R4.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(E e6) {
            return e6;
        }
    }

    static final class c implements R4.f<G, G> {

        /* renamed from: a, reason: collision with root package name */
        static final c f4996a = new c();

        c() {
        }

        @Override // R4.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public G a(G g5) {
            return g5;
        }
    }

    static final class d implements R4.f<Object, String> {

        /* renamed from: a, reason: collision with root package name */
        static final d f4997a = new d();

        d() {
        }

        @Override // R4.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(Object obj) {
            return obj.toString();
        }
    }

    static final class e implements R4.f<G, V3.v> {

        /* renamed from: a, reason: collision with root package name */
        static final e f4998a = new e();

        e() {
        }

        @Override // R4.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public V3.v a(G g5) {
            g5.close();
            return V3.v.f5542a;
        }
    }

    static final class f implements R4.f<G, Void> {

        /* renamed from: a, reason: collision with root package name */
        static final f f4999a = new f();

        f() {
        }

        @Override // R4.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(G g5) {
            g5.close();
            return null;
        }
    }

    a() {
    }

    @Override // R4.f.a
    @Nullable
    public R4.f<?, E> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, u uVar) {
        if (E.class.isAssignableFrom(y.h(type))) {
            return b.f4995a;
        }
        return null;
    }

    @Override // R4.f.a
    @Nullable
    public R4.f<G, ?> d(Type type, Annotation[] annotationArr, u uVar) {
        if (type == G.class) {
            return y.l(annotationArr, U4.w.class) ? c.f4996a : C0075a.f4994a;
        }
        if (type == Void.class) {
            return f.f4999a;
        }
        if (!this.f4993a || type != V3.v.class) {
            return null;
        }
        try {
            return e.f4998a;
        } catch (NoClassDefFoundError unused) {
            this.f4993a = false;
            return null;
        }
    }
}
