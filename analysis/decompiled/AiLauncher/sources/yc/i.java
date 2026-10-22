package yc;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import tb.C5528A;
import yc.e;
import yc.i;

/* loaded from: classes5.dex */
public final class i extends e.a {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f44322a;

    public class a implements e<Object, d<?>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f44323a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f44324b;

        public a(Type type, Executor executor) {
            this.f44323a = type;
            this.f44324b = executor;
        }

        @Override // yc.e
        public Type a() {
            return this.f44323a;
        }

        @Override // yc.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d<Object> b(d<Object> dVar) {
            Executor executor = this.f44324b;
            return executor == null ? dVar : new b(executor, dVar);
        }
    }

    public static final class b<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Executor f44326a;

        /* renamed from: b, reason: collision with root package name */
        public final d<T> f44327b;

        public class a implements f<T> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f44328a;

            public a(f fVar) {
                this.f44328a = fVar;
            }

            public static /* synthetic */ void d(a aVar, f fVar, v vVar) {
                if (b.this.f44327b.e()) {
                    fVar.b(b.this, new IOException("Canceled"));
                } else {
                    fVar.a(b.this, vVar);
                }
            }

            @Override // yc.f
            public void a(d<T> dVar, final v<T> vVar) {
                Executor executor = b.this.f44326a;
                final f fVar = this.f44328a;
                executor.execute(new Runnable() { // from class: yc.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b.a.d(this.f44330a, fVar, vVar);
                    }
                });
            }

            @Override // yc.f
            public void b(d<T> dVar, final Throwable th) {
                Executor executor = b.this.f44326a;
                final f fVar = this.f44328a;
                executor.execute(new Runnable() { // from class: yc.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        fVar.b(i.b.this, th);
                    }
                });
            }
        }

        public b(Executor executor, d<T> dVar) {
            this.f44326a = executor;
            this.f44327b = dVar;
        }

        @Override // yc.d
        public void A(f<T> fVar) {
            Objects.requireNonNull(fVar, "callback == null");
            this.f44327b.A(new a(fVar));
        }

        @Override // yc.d
        public C5528A b() {
            return this.f44327b.b();
        }

        @Override // yc.d
        public void cancel() {
            this.f44327b.cancel();
        }

        @Override // yc.d
        public boolean e() {
            return this.f44327b.e();
        }

        @Override // yc.d
        public d<T> clone() {
            return new b(this.f44326a, this.f44327b.clone());
        }
    }

    public i(Executor executor) {
        this.f44322a = executor;
    }

    @Override // yc.e.a
    public e<?, ?> a(Type type, Annotation[] annotationArr, w wVar) {
        if (e.a.c(type) != d.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(A.g(0, (ParameterizedType) type), A.l(annotationArr, y.class) ? null : this.f44322a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
