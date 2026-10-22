package xd;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import xd.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends c.a {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f13794a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Executor f13795a;

        /* renamed from: b, reason: collision with root package name */
        public final b<T> f13796b;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: xd.h$a$a, reason: collision with other inner class name */
        public class C0173a implements d<T> {

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ d f13797g;

            public C0173a(d dVar) {
                this.f13797g = dVar;
            }

            @Override // xd.d
            public final void a(b<T> bVar, Throwable th) {
                a.this.f13795a.execute(new com.stepos.statsapp.v3.lib.plugin.emitter.remote.c(this, this.f13797g, th, 8));
            }

            @Override // xd.d
            public final void b(b<T> bVar, r<T> rVar) {
                a.this.f13795a.execute(new com.stepos.core.model.manager.i(this, this.f13797g, rVar, 9));
            }
        }

        public a(Executor executor, b<T> bVar) {
            this.f13795a = executor;
            this.f13796b = bVar;
        }

        @Override // xd.b
        public final void K(d<T> dVar) {
            this.f13796b.K(new C0173a(dVar));
        }

        @Override // xd.b
        public final okhttp3.h a() {
            return this.f13796b.a();
        }

        @Override // xd.b
        public final void cancel() {
            this.f13796b.cancel();
        }

        @Override // xd.b
        public final boolean isCanceled() {
            return this.f13796b.isCanceled();
        }

        @Override // xd.b
        public final b<T> clone() {
            return new a(this.f13795a, this.f13796b.clone());
        }
    }

    public h(Executor executor) {
        this.f13794a = executor;
    }

    @Override // xd.c.a
    public final c a(Type type, Annotation[] annotationArr) {
        if (retrofit2.b.e(type) != b.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new g(retrofit2.b.d(0, (ParameterizedType) type), retrofit2.b.h(annotationArr, v.class) ? null : this.f13794a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
