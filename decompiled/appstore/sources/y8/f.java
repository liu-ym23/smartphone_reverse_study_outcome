package y8;

import android.content.Context;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HurlStack;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.network.core.ImageLoader;
import com.bytedanceos.common.toolbox.c0;
import com.obric.capabilitykit.common.UiType;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RequestQueue f26149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static RequestQueue f26150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static f f26151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object f26152d;

    public class a implements RequestQueue.RequestFilter {
        public a() {
        }

        @Override // com.android.volley.RequestQueue.RequestFilter
        public boolean apply(Request r10) {
            return r10 instanceof g;
        }
    }

    public class b implements RequestQueue.RequestFilter {
        public b() {
        }

        @Override // com.android.volley.RequestQueue.RequestFilter
        public boolean apply(Request r10) {
            return r10 instanceof g;
        }
    }

    public class c implements RequestQueue.RequestFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f26153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f26154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f26155c;

        public c(f r10, g r11, int r12) {
            this.f26155c = r10;
            this.f26153a = r11;
            this.f26154b = r12;
        }

        @Override // com.android.volley.RequestQueue.RequestFilter
        public boolean apply(Request r10) {
            if ((r10 instanceof g) == false) goto L6;
            f r11 = this.f26155c;
            return f.a(r11, (g) r10, this.f26153a, this.f26154b);
        L6:
            return false;
        }
    }

    static {
        f26149a = k();
        f26150b = j();
        f26151c = new f();
        f26152d = new Object();
    }

    public f() {
    }

    public static /* synthetic */ boolean a(f r10, g r11, g r12, int r13) {
        return r10.i(r11, r12, r13);
    }

    public static void b(Request r10) {
        f26149a.add(r10);
    }

    public static void c(Object r10) {
        f26149a.cancelAll(r10);
    }

    public static void d() {
        f26149a.cancelAll(new a());
        f26150b.cancelAll(new b());
    }

    public static void f(boolean r10) {
        if (r10 == false) goto L4;
        x8.a r11 = new x8.a(new File(BaseApplication.c().getCacheDir(), "json"), UiType.FLAG_APP_CHOOSER_CARD);
    L5:
        r11.clear();
        return;
    L4:
        r11 = new x8.a(new File(BaseApplication.c().getCacheDir(), "temp"), 15728640);
        goto L5
    }

    public static RequestQueue g() {
        return f26150b;
    }

    public static f h() {
        return f26151c;
    }

    public static RequestQueue j() {
        x8.a r10 = new x8.a(new File(BaseApplication.c().getCacheDir(), "temp"), 15728640);
        return l(BaseApplication.c(), r10, 3);
    }

    public static RequestQueue k() {
        x8.a r10 = new x8.a(new File(BaseApplication.c().getCacheDir(), "json"), UiType.FLAG_APP_CHOOSER_CARD);
        r10.c();
        return l(BaseApplication.c(), r10, 2);
    }

    public static RequestQueue l(Context r10, x8.a r11, int r12) {
        RequestQueue r13 = new RequestQueue(r11, new com.bytedanceos.common.network.core.a(new HurlStack(null, e.a("TLS"))), r12);
        r13.start();
        return r13;
    }

    public static void m() {
        d();
        ImageLoader.g();
        x8.b.c().a();
    }

    public void e(g r10, int r11) {
        f26149a.cancelAll(new c(this, r10, r11));
    }

    public final boolean i(g r10, g r11, int r12) {
        if (r10.d(r12) == true) goto L5;
    L7:
        String r13 = r10.getUrl();
        if (TextUtils.isEmpty(r13) == false) goto L11;
        return false;
    L11:
        if (TextUtils.equals(r13, r11.getUrl()) == false) goto L40;
    L17:
        e = move-exception;
        e.printStackTrace();
    L38:
        return true;
    L13:
        if (r10.getBody() != null) goto L20;
        if (r11.getBody() != null) goto L20;
        return true;
    L20:
        if (r10.getBody() != null) goto L24;
        if (r11.getBody() == null) goto L24;
    L27:
        return false;
    L24:
        if (r10.getBody() != null) goto L26;
    L28:
        String r14 = c0.d(r10.getBody());     // Catch: Exception -> L17
        String r15 = c0.d(r11.getBody());     // Catch: Exception -> L17
        if (r14.length() == r15.length()) goto L31;
        return false;
    L31:
        int r16 = r14.length();     // Catch: Exception -> L17
        int r17 = 0;
    L32:
        if (r17 >= r16) goto L38;
        if (r14.charAt(r17) != r15.charAt(r17)) goto L35;
        r17 = r17 + 1;
        goto L32
    L35:
        return false;
    L26:
        if (r11.getBody() != null) goto L28;
    L40:
        if (r12 != 400002) goto L49;
        if (r13.contains("/category/apps/") == false) goto L47;
        if (r13.contains("type=rank") == true) goto L47;
        return true;
    L47:
        return false;
    L49:
        if (r12 == 400003) goto L51;
        return false;
    L51:
        if (r13.contains("/category/apps/") == false) goto L56;
        if (r13.contains("type=rank") == false) goto L56;
        return true;
    L56:
        return false;
    L5:
        if (r12 != 500001) goto L7;
        return true;
    }
}
