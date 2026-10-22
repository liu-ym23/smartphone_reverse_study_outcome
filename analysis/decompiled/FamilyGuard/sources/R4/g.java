package R4;

import C4.D;
import R4.c;
import R4.g;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class g extends c.a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Executor f5008a;

    class a implements c<Object, R4.b<?>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f5009a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f5010b;

        a(Type type, Executor executor) {
            this.f5009a = type;
            this.f5010b = executor;
        }

        @Override // R4.c
        public Type b() {
            return this.f5009a;
        }

        @Override // R4.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public R4.b<Object> a(R4.b<Object> bVar) {
            Executor executor = this.f5010b;
            return executor == null ? bVar : new b(executor, bVar);
        }
    }

    static final class b<T> implements R4.b<T> {

        /* renamed from: a, reason: collision with root package name */
        final Executor f5012a;

        /* renamed from: b, reason: collision with root package name */
        final R4.b<T> f5013b;

        class a implements d<T> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f5014a;

            a(d dVar) {
                this.f5014a = dVar;
            }

            public static /* synthetic */ void d(a aVar, d dVar, t tVar) {
                if (b.this.f5013b.c()) {
                    dVar.b(b.this, new IOException("Canceled"));
                } else {
                    dVar.a(b.this, tVar);
                }
            }

            @Override // R4.d
            public void a(R4.b<T> bVar, final t<T> tVar) {
                Executor executor = b.this.f5012a;
                final d dVar = this.f5014a;
                executor.execute(new Runnable() { // from class: R4.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.b.a.d(this.f5016a, dVar, tVar);
                    }
                });
            }

            @Override // R4.d
            public void b(R4.b<T> bVar, final Throwable th) {
                Executor executor = b.this.f5012a;
                final d dVar = this.f5014a;
                executor.execute(new Runnable() { // from class: R4.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        dVar.b(g.b.this, th);
                    }
                });
            }
        }

        b(Executor executor, R4.b<T> bVar) {
            this.f5012a = executor;
            this.f5013b = bVar;
        }

        @Override // R4.b
        public D a() {
            return this.f5013b.a();
        }

        @Override // R4.b
        public boolean c() {
            return this.f5013b.c();
        }

        @Override // R4.b
        public void cancel() {
            this.f5013b.cancel();
        }

        @Override // R4.b
        public t<T> execute() {
            return this.f5013b.execute();
        }

        @Override // R4.b
        public void o(d<T> dVar) {
            Objects.requireNonNull(dVar, "callback == null");
            this.f5013b.o(new a(dVar));
        }

        @Override // R4.b
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public R4.b<T> m0clone() {
            return new b(this.f5012a, this.f5013b.m0clone());
        }
    }

    g(@Nullable Executor executor) {
        this.f5008a = executor;
    }

    @Override // R4.c.a
    @Nullable
    public c<?, ?> a(Type type, Annotation[] annotationArr, u uVar) {
        if (c.a.c(type) != R4.b.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(y.g(0, (ParameterizedType) type), y.l(annotationArr, w.class) ? null : this.f5008a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
