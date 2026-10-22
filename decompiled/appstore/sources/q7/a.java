package q7;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0343a f23557a = null;

    /* JADX INFO: renamed from: q7.a$a, reason: collision with other inner class name */
    public static final class C0343a {
        public /* synthetic */ C0343a(DefaultConstructorMarker r10) {
            this();
        }

        public C0343a() {
        }
    }

    static {
        f23557a = new C0343a(null);
    }

    public a() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) {
        q.g(r10, "chain");
        Request r11 = r10.request();
        Response r12 = r10.proceed(r11);
        String r13 = r11.k().toString();
        q.f(r13, "toString(...)");
        int r14 = 0;
        if (StringsKt__StringsKt.E(r13, "search/SearchRecommendApps", false, 2, null) == false) goto L5;
        r14 = 300;
    L5:
        Response r15 = r12.n().o("pragma").a("Cache-Control", "max-age=" + r14).c();
        q.f(r15, "build(...)");
        return r15;
    }
}
