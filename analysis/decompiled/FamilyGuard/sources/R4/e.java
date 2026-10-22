package R4;

import R4.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class e extends c.a {

    /* renamed from: a, reason: collision with root package name */
    static final c.a f5000a = new e();

    private static final class a<R> implements R4.c<R, CompletableFuture<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final Type f5001a;

        /* renamed from: R4.e$a$a, reason: collision with other inner class name */
        private class C0076a implements d<R> {

            /* renamed from: a, reason: collision with root package name */
            private final CompletableFuture<R> f5002a;

            public C0076a(CompletableFuture<R> completableFuture) {
                this.f5002a = completableFuture;
            }

            @Override // R4.d
            public void a(R4.b<R> bVar, t<R> tVar) {
                if (tVar.e()) {
                    this.f5002a.complete(tVar.a());
                } else {
                    this.f5002a.completeExceptionally(new j(tVar));
                }
            }

            @Override // R4.d
            public void b(R4.b<R> bVar, Throwable th) {
                this.f5002a.completeExceptionally(th);
            }
        }

        a(Type type) {
            this.f5001a = type;
        }

        @Override // R4.c
        public Type b() {
            return this.f5001a;
        }

        @Override // R4.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<R> a(R4.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.o(new C0076a(bVar2));
            return bVar2;
        }
    }

    private static final class b<T> extends CompletableFuture<T> {

        /* renamed from: a, reason: collision with root package name */
        private final R4.b<?> f5004a;

        b(R4.b<?> bVar) {
            this.f5004a = bVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z5) {
            if (z5) {
                this.f5004a.cancel();
            }
            return super.cancel(z5);
        }
    }

    private static final class c<R> implements R4.c<R, CompletableFuture<t<R>>> {

        /* renamed from: a, reason: collision with root package name */
        private final Type f5005a;

        private class a implements d<R> {

            /* renamed from: a, reason: collision with root package name */
            private final CompletableFuture<t<R>> f5006a;

            public a(CompletableFuture<t<R>> completableFuture) {
                this.f5006a = completableFuture;
            }

            @Override // R4.d
            public void a(R4.b<R> bVar, t<R> tVar) {
                this.f5006a.complete(tVar);
            }

            @Override // R4.d
            public void b(R4.b<R> bVar, Throwable th) {
                this.f5006a.completeExceptionally(th);
            }
        }

        c(Type type) {
            this.f5005a = type;
        }

        @Override // R4.c
        public Type b() {
            return this.f5005a;
        }

        @Override // R4.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<t<R>> a(R4.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.o(new a(bVar2));
            return bVar2;
        }
    }

    e() {
    }

    @Override // R4.c.a
    @Nullable
    public R4.c<?, ?> a(Type type, Annotation[] annotationArr, u uVar) {
        if (c.a.c(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeB = c.a.b(0, (ParameterizedType) type);
        if (c.a.c(typeB) != t.class) {
            return new a(typeB);
        }
        if (typeB instanceof ParameterizedType) {
            return new c(c.a.b(0, (ParameterizedType) typeB));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
