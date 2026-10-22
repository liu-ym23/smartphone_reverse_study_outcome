package xd;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.HttpException;
import xd.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@IgnoreJRERequirement
/* loaded from: classes.dex */
public final class e extends c.a {

    /* renamed from: a, reason: collision with root package name */
    public static final e f13786a = new e();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @IgnoreJRERequirement
    public static final class a<R> implements xd.c<R, CompletableFuture<R>> {

        /* renamed from: a, reason: collision with root package name */
        public final Type f13787a;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @IgnoreJRERequirement
        /* renamed from: xd.e$a$a, reason: collision with other inner class name */
        public class C0172a implements d<R> {

            /* renamed from: g, reason: collision with root package name */
            public final b f13788g;

            public C0172a(b bVar) {
                this.f13788g = bVar;
            }

            @Override // xd.d
            public final void a(xd.b<R> bVar, Throwable th) {
                this.f13788g.completeExceptionally(th);
            }

            @Override // xd.d
            public final void b(xd.b<R> bVar, r<R> rVar) {
                boolean z = rVar.f13907a.r;
                b bVar2 = this.f13788g;
                if (z) {
                    bVar2.complete(rVar.f13908b);
                } else {
                    bVar2.completeExceptionally(new HttpException(rVar));
                }
            }
        }

        public a(Type type) {
            this.f13787a = type;
        }

        @Override // xd.c
        public final Type a() {
            return this.f13787a;
        }

        @Override // xd.c
        public final Object b(j jVar) {
            b bVar = new b(jVar);
            jVar.K(new C0172a(bVar));
            return bVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @IgnoreJRERequirement
    public static final class b<T> extends CompletableFuture<T> {

        /* renamed from: a, reason: collision with root package name */
        public final j f13789a;

        public b(j jVar) {
            this.f13789a = jVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            if (z) {
                this.f13789a.cancel();
            }
            return super.cancel(z);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @IgnoreJRERequirement
    public static final class c<R> implements xd.c<R, CompletableFuture<r<R>>> {

        /* renamed from: a, reason: collision with root package name */
        public final Type f13790a;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @IgnoreJRERequirement
        public class a implements d<R> {

            /* renamed from: g, reason: collision with root package name */
            public final b f13791g;

            public a(b bVar) {
                this.f13791g = bVar;
            }

            @Override // xd.d
            public final void a(xd.b<R> bVar, Throwable th) {
                this.f13791g.completeExceptionally(th);
            }

            @Override // xd.d
            public final void b(xd.b<R> bVar, r<R> rVar) {
                this.f13791g.complete(rVar);
            }
        }

        public c(Type type) {
            this.f13790a = type;
        }

        @Override // xd.c
        public final Type a() {
            return this.f13790a;
        }

        @Override // xd.c
        public final Object b(j jVar) {
            b bVar = new b(jVar);
            jVar.K(new a(bVar));
            return bVar;
        }
    }

    @Override // xd.c.a
    public final xd.c a(Type type, Annotation[] annotationArr) {
        if (retrofit2.b.e(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeD = retrofit2.b.d(0, (ParameterizedType) type);
        if (retrofit2.b.e(typeD) != r.class) {
            return new a(typeD);
        }
        if (typeD instanceof ParameterizedType) {
            return new c(retrofit2.b.d(0, (ParameterizedType) typeD));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
