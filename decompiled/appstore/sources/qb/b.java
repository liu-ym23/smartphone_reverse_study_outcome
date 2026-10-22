package qb;

import android.util.Log;
import com.obric.common.oea.foundation.util.OEALog;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static OEALog f23625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f23626b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f23627c = null;

    public static final class a implements OEALog {
        public a() {
        }

        @Override // com.obric.common.oea.foundation.util.OEALog
        public void d(String r10, String r11) {
            q.g(r10, "tag");
            q.g(r11, "msg");
            Log.d("OEA_SDK", r10 + "->" + r11);
        }

        @Override // com.obric.common.oea.foundation.util.OEALog
        public void e(String r10, String r11, Throwable r12) {
            q.g(r10, "tag");
            q.g(r11, "msg");
            Log.e("OEA_SDK", r10 + "->" + r11, r12);
        }

        @Override // com.obric.common.oea.foundation.util.OEALog
        public void i(String r10, String r11) {
            q.g(r10, "tag");
            q.g(r11, "msg");
            Log.i("OEA_SDK", r10 + "->" + r11);
        }

        @Override // com.obric.common.oea.foundation.util.OEALog
        public void v(String r10, String r11) {
            q.g(r10, "tag");
            q.g(r11, "msg");
            Log.v("OEA_SDK", r10 + "->" + r11);
        }

        @Override // com.obric.common.oea.foundation.util.OEALog
        public void w(String r10, String r11) {
            q.g(r10, "tag");
            q.g(r11, "msg");
            Log.w("OEA_SDK", r10 + "->" + r11);
        }
    }

    static {
        f23627c = new b();
        f23626b = new a();
    }

    public b() {
    }

    public static /* synthetic */ void c(b r10, String r11, String r12, Throwable r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = null;
    L5:
        r10.b(r11, r12, r13);
    }

    public final void a(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        OEALog r12 = f23625a;
        if (r12 == null) goto L6;
        r12.d(r10, r11);
        return;
    }

    public final void b(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        OEALog r13 = f23625a;
        if (r13 == null) goto L6;
        if (r13 == null) goto L8;
        r13.e(r10, r11, r12);
        return;
    L8:
        return;
    L6:
        f23626b.e(r10, r11, r12);
    }

    public final void d() {
        f23625a = f23626b;
    }

    public final void e(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        OEALog r12 = f23625a;
        if (r12 == null) goto L6;
        r12.i(r10, r11);
        return;
    }

    public final void f(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        OEALog r12 = f23625a;
        if (r12 == null) goto L6;
        if (r12 == null) goto L8;
        r12.i(r10, r11);
        return;
    L8:
        return;
    L6:
        f23626b.i(r10, r11);
    }

    public final void g(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        OEALog r12 = f23625a;
        if (r12 == null) goto L6;
        r12.v(r10, r11);
        return;
    }

    public final void h(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        OEALog r12 = f23625a;
        if (r12 == null) goto L6;
        if (r12 == null) goto L8;
        r12.w(r10, r11);
        return;
    L8:
        return;
    L6:
        f23626b.w(r10, r11);
    }
}
