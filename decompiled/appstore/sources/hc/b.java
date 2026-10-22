package hc;

import android.util.Log;
import com.obric.matrix.platform.sdk.ones.IMatrixBridge;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20398a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f20399b;

    static {
        f20398a = new b();
    }

    public b() {
    }

    public static final void a(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        if (f20399b == false) goto L5;
        Log.d(r10, r11, r12);
    L5:
        f20398a.h(r10, r11, r12);
    }

    public static /* synthetic */ void b(String r10, String r11, Throwable r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        a(r10, r11, r12);
    }

    public static final void c(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        if (f20399b == false) goto L5;
        Log.e(r10, r11, r12);
    L5:
        f20398a.i(r10, r11, r12);
    }

    public static /* synthetic */ void d(String r10, String r11, Throwable r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        c(r10, r11, r12);
    }

    public static final void e(String r10) {
        q.g(r10, "msg");
        g("matrix_ones", r10, null, 4, null);
    }

    public static final void f(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        if (f20399b == false) goto L5;
        Log.i(r10, r11, r12);
    L5:
        f20398a.i(r10, r11, r12);
    }

    public static /* synthetic */ void g(String r10, String r11, Throwable r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        f(r10, r11, r12);
    }

    public static final void k(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        if (f20399b == false) goto L5;
        Log.v(r10, r11, r12);
    L5:
        f20398a.h(r10, r11, r12);
    }

    public static final void l(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        if (f20399b == false) goto L5;
        Log.w(r10, r11, r12);
    L5:
        f20398a.i(r10, r11, r12);
    }

    public static /* synthetic */ void m(String r10, String r11, Throwable r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        l(r10, r11, r12);
    }

    public final void h(String r10, String r11, Throwable r12) {
        IMatrixBridge r13 = ac.a.f80a.b();
        if (r13 == null) goto L6;
        r13.logd(r10, "MatrixOnesSdk: " + r11, r12);
        return;
    }

    public final void i(String r10, String r11, Throwable r12) {
        IMatrixBridge r13 = ac.a.f80a.b();
        if (r13 == null) goto L6;
        r13.loge(r10, "MatrixOnesSdk: " + r11, r12);
        return;
    }

    public final void j(boolean r10) {
        f20399b = r10;
    }
}
