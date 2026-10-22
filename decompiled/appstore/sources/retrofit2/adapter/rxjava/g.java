package retrofit2.adapter.rxjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Completable;
import rx.Observable;
import rx.Single;

/* JADX INFO: loaded from: classes4.dex */
public final class g extends CallAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jg.a f24004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f24005b;

    public g(jg.a r10, boolean r11) {
        this.f24004a = r10;
        this.f24005b = r11;
    }

    public static g d() {
        return new g(null, false);
    }

    @Override // retrofit2.CallAdapter.a
    public CallAdapter a(Type r11, Annotation[] r12, Retrofit r13) {
        Class r14 = CallAdapter.a.c(r11);
        if (r14 != Single.class) goto L5;
        boolean r10 = true;
    L7:
        if (r14 != Completable.class) goto L9;
        boolean r15 = true;
    L11:
        if (r14 == Observable.class) goto L16;
        if (r10 == true) goto L16;
        if (r15 == true) goto L16;
        return null;
    L16:
        if (r15 == false) goto L20;
        return new f(Void.class, this.f24004a, this.f24005b, false, true, false, true);
    L20:
        if ((r11 instanceof ParameterizedType) == true) goto L26;
        if (r10 == false) goto L23;
        String r16 = "Single";
    L25:
        throw new IllegalStateException(r16 + " return type must be parameterized as " + r16 + "<Foo> or " + r16 + "<? extends Foo>");
    L23:
        r16 = "Observable";
        goto L25
    L26:
        Type r17 = CallAdapter.a.b(0, (ParameterizedType) r11);
        Class r18 = CallAdapter.a.c(r17);
        if (r18 != Response.class) goto L34;
        if ((r17 instanceof ParameterizedType) == false) goto L32;
        Type r19 = CallAdapter.a.b(0, (ParameterizedType) r17);
        boolean r20 = false;
        boolean r21 = false;
    L42:
        return new f(r19, this.f24004a, this.f24005b, r20, r21, r10, false);
    L32:
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    L34:
        if (r18 == d.class) goto L36;
        r19 = r17;
        r21 = true;
        r20 = false;
        goto L42
    L36:
        if ((r17 instanceof ParameterizedType) == false) goto L39;
        r19 = CallAdapter.a.b(0, (ParameterizedType) r17);
        r20 = true;
        r21 = false;
        goto L42
    L39:
        throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
    L9:
        r15 = false;
        goto L11
    L5:
        r10 = false;
        goto L7
    }
}
