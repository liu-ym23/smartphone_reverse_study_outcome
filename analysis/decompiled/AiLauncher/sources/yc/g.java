package yc;

import android.annotation.TargetApi;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.HttpException;
import yc.e;

@TargetApi(24)
@IgnoreJRERequirement
/* loaded from: classes5.dex */
public final class g extends e.a {

    @IgnoreJRERequirement
    public static final class a<R> implements e<R, CompletableFuture<R>> {

        /* renamed from: a, reason: collision with root package name */
        public final Type f44315a;

        @IgnoreJRERequirement
        /* renamed from: yc.g$a$a, reason: collision with other inner class name */
        public class C0560a implements f<R> {

            /* renamed from: a, reason: collision with root package name */
            public final CompletableFuture<R> f44316a;

            public C0560a(CompletableFuture<R> completableFuture) {
                this.f44316a = completableFuture;
            }

            @Override // yc.f
            public void a(d<R> dVar, v<R> vVar) {
                if (vVar.f()) {
                    this.f44316a.complete(vVar.a());
                } else {
                    this.f44316a.completeExceptionally(new HttpException(vVar));
                }
            }

            @Override // yc.f
            public void b(d<R> dVar, Throwable th) {
                this.f44316a.completeExceptionally(th);
            }
        }

        public a(Type type) {
            this.f44315a = type;
        }

        @Override // yc.e
        public Type a() {
            return this.f44315a;
        }

        @Override // yc.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<R> b(d<R> dVar) {
            b bVar = new b(dVar);
            dVar.A(new C0560a(bVar));
            return bVar;
        }
    }

    @IgnoreJRERequirement
    public static final class b<T> extends CompletableFuture<T> {

        /* renamed from: a, reason: collision with root package name */
        public final d<?> f44318a;

        public b(d<?> dVar) {
            this.f44318a = dVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            if (z10) {
                this.f44318a.cancel();
            }
            return super.cancel(z10);
        }
    }

    @IgnoreJRERequirement
    public static final class c<R> implements e<R, CompletableFuture<v<R>>> {

        /* renamed from: a, reason: collision with root package name */
        public final Type f44319a;

        @IgnoreJRERequirement
        public class a implements f<R> {

            /* renamed from: a, reason: collision with root package name */
            public final CompletableFuture<v<R>> f44320a;

            public a(CompletableFuture<v<R>> completableFuture) {
                this.f44320a = completableFuture;
            }

            @Override // yc.f
            public void a(d<R> dVar, v<R> vVar) {
                this.f44320a.complete(vVar);
            }

            @Override // yc.f
            public void b(d<R> dVar, Throwable th) {
                this.f44320a.completeExceptionally(th);
            }
        }

        public c(Type type) {
            this.f44319a = type;
        }

        @Override // yc.e
        public Type a() {
            return this.f44319a;
        }

        @Override // yc.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<v<R>> b(d<R> dVar) {
            b bVar = new b(dVar);
            dVar.A(new a(bVar));
            return bVar;
        }
    }

    @Override // yc.e.a
    public e<?, ?> a(Type type, Annotation[] annotationArr, w wVar) {
        if (e.a.c(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeB = e.a.b(0, (ParameterizedType) type);
        if (e.a.c(typeB) != v.class) {
            return new a(typeB);
        }
        if (typeB instanceof ParameterizedType) {
            return new c(e.a.b(0, (ParameterizedType) typeB));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
