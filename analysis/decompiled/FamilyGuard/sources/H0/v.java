package H0;

import A0.d;
import H0.n;
import z0.C1342h;
import z0.EnumC1335a;

/* loaded from: classes.dex */
public class v<Model> implements n<Model, Model> {

    /* renamed from: a, reason: collision with root package name */
    private static final v<?> f2036a = new v<>();

    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a, reason: collision with root package name */
        private static final a<?> f2037a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> c() {
            return (a<T>) f2037a;
        }

        @Override // H0.o
        public n<Model, Model> a(r rVar) {
            return v.c();
        }

        @Override // H0.o
        public void b() {
        }
    }

    private static class b<Model> implements A0.d<Model> {

        /* renamed from: a, reason: collision with root package name */
        private final Model f2038a;

        b(Model model) {
            this.f2038a = model;
        }

        @Override // A0.d
        public Class<Model> a() {
            return (Class<Model>) this.f2038a.getClass();
        }

        @Override // A0.d
        public void b() {
        }

        @Override // A0.d
        public void cancel() {
        }

        @Override // A0.d
        public EnumC1335a d() {
            return EnumC1335a.LOCAL;
        }

        @Override // A0.d
        public void e(v0.g gVar, d.a<? super Model> aVar) {
            aVar.f(this.f2038a);
        }
    }

    @Deprecated
    public v() {
    }

    public static <T> v<T> c() {
        return (v<T>) f2036a;
    }

    @Override // H0.n
    public boolean a(Model model) {
        return true;
    }

    @Override // H0.n
    public n.a<Model> b(Model model, int i5, int i6, C1342h c1342h) {
        return new n.a<>(new W0.b(model), new b(model));
    }
}
