package com.obric.appstore.network;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.u;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes3.dex */
public final class CoroutineCallAdapterFactory extends CallAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10953a = null;

    public static final class BodyCallAdapter implements CallAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f10954a;

        public static final class a implements Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CompletableDeferred f10955a;

            public a(CompletableDeferred r10) {
                this.f10955a = r10;
            }

            @Override // retrofit2.Callback
            public void onFailure(Call r10, Throwable r11) {
                q.g(r10, "call");
                q.g(r11, "t");
                this.f10955a.completeExceptionally(r11);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call r10, Response r11) {
                q.g(r10, "call");
                q.g(r11, "response");
                if (r11.f() == false) goto L5;
                CompletableDeferred r12 = this.f10955a;
                Object r13 = r11.a();
                q.d(r13);
                r12.complete(r13);
                return;
            L5:
                this.f10955a.completeExceptionally(new HttpException(r11));
            }
        }

        public BodyCallAdapter(Type r10) {
            q.g(r10, "responseType");
            this.f10954a = r10;
        }

        public Deferred a(final Call r10) {
            q.g(r10, "call");
            final CompletableDeferred r11 = u.b(null, 1, null);
            r11.invokeOnCompletion(new CoroutineCallAdapterFactory$BodyCallAdapter$adapt$1(r11, r10));
            r10.enqueue(new a(r11));
            return r11;
        }

        @Override // retrofit2.CallAdapter
        public /* bridge */ /* synthetic */ Object adapt(Call r10) {
            return a(r10);
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.f10954a;
        }
    }

    public static final class ResponseCallAdapter implements CallAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f10956a;

        public static final class a implements Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CompletableDeferred f10957a;

            public a(CompletableDeferred r10) {
                this.f10957a = r10;
            }

            @Override // retrofit2.Callback
            public void onFailure(Call r10, Throwable r11) {
                q.g(r10, "call");
                q.g(r11, "t");
                this.f10957a.completeExceptionally(r11);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call r10, Response r11) {
                q.g(r10, "call");
                q.g(r11, "response");
                this.f10957a.complete(r11);
            }
        }

        public ResponseCallAdapter(Type r10) {
            q.g(r10, "responseType");
            this.f10956a = r10;
        }

        public Deferred a(final Call r10) {
            q.g(r10, "call");
            final CompletableDeferred r11 = u.b(null, 1, null);
            r11.invokeOnCompletion(new CoroutineCallAdapterFactory$ResponseCallAdapter$adapt$1(r11, r10));
            r10.enqueue(new a(r11));
            return r11;
        }

        @Override // retrofit2.CallAdapter
        public /* bridge */ /* synthetic */ Object adapt(Call r10) {
            return a(r10);
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.f10956a;
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final CoroutineCallAdapterFactory a() {
            return new CoroutineCallAdapterFactory(null);
        }

        public a() {
        }
    }

    static {
        f10953a = new a(null);
    }

    public /* synthetic */ CoroutineCallAdapterFactory(DefaultConstructorMarker r10) {
        this();
    }

    @Override // retrofit2.CallAdapter.a
    public CallAdapter a(Type r10, Annotation[] r11, Retrofit r12) {
        q.g(r10, "returnType");
        q.g(r11, "annotations");
        q.g(r12, "retrofit");
        if (q.b(Deferred.class, CallAdapter.a.c(r10)) == true) goto L7;
        return null;
    L7:
        if ((r10 instanceof ParameterizedType) == false) goto L18;
        Type r13 = CallAdapter.a.b(0, (ParameterizedType) r10);
        if (q.b(CallAdapter.a.c(r13), Response.class) == true) goto L11;
        q.d(r13);
        return new BodyCallAdapter(r13);
    L11:
        if ((r13 instanceof ParameterizedType) == false) goto L14;
        Type r14 = CallAdapter.a.b(0, (ParameterizedType) r13);
        q.f(r14, "getParameterUpperBound(...)");
        return new ResponseCallAdapter(r14);
    L14:
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<out Foo>");
    L18:
        throw new IllegalStateException("Deferred return type must be parameterized as Deferred<Foo> or Deferred<out Foo>");
    }

    public CoroutineCallAdapterFactory() {
    }
}
