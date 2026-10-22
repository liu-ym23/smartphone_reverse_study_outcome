package bc;

import com.obric.matrix.platform.sdk.ones.account.api.ILogger;
import hc.b;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements ILogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5978a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ILogger f5979b;

    /* JADX INFO: renamed from: bc.a$a, reason: collision with other inner class name */
    public static final class C0066a implements ILogger {
        public C0066a() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
        public void d(String r10, String r11, Throwable r12) {
            q.g(r10, "tag");
            q.g(r11, "msg");
            b.a(r10, r11, r12);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
        public void e(String r10, String r11, Throwable r12) {
            q.g(r10, "tag");
            q.g(r11, "msg");
            b.c(r10, r11, r12);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
        public void i(String r10, String r11, Throwable r12) {
            q.g(r10, "tag");
            q.g(r11, "msg");
            b.f(r10, r11, r12);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
        public void v(String r10, String r11, Throwable r12) {
            q.g(r10, "tag");
            q.g(r11, "msg");
            b.k(r10, r11, r12);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
        public void w(String r10, String r11, Throwable r12) {
            q.g(r10, "tag");
            q.g(r11, "msg");
            b.l(r10, r11, r12);
        }
    }

    static {
        f5978a = new a();
        f5979b = new C0066a();
    }

    public a() {
    }

    public static final void a(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        f5978a.d(r10, r11, null);
    }

    public static final void b(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        f5978a.e(r10, r11, null);
    }

    public static final void c(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        f5978a.i(r10, r11, null);
    }

    public static final void f(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        f5978a.w(r10, r11, null);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void d(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        f5979b.d(r10, r11, r12);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void e(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        f5979b.e(r10, r11, r12);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void i(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        f5979b.i(r10, r11, r12);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void v(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        f5979b.v(r10, r11, r12);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void w(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        f5979b.w(r10, r11, r12);
    }
}
