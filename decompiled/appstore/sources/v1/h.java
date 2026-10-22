package v1;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.constant.StoreConsts;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedanceos.common.ad.common.AdConstant;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends v1.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25039h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f25040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f25041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f25042k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f25043l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f25044g;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f25045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f25046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f25047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f25048d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ThreadGroup f25049e;

        public a(boolean r10, int[] r11, String r12, int r13, ThreadGroup r14) {
            this.f25045a = r10;
            this.f25046b = r11;
            this.f25047c = r12;
            this.f25048d = r13;
            this.f25049e = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f25045a == false) goto L5;
        L28:
            JSONObject r10 = h.p(this.f25047c, this.f25048d, this.f25046b[0], null);     // Catch: Exception -> L25
            if (r10 == null) goto L34;
            l1.a.p().e(new m1.e("thread", null, null, r10));     // Catch: Exception -> L25
            return;
        L34:
            return;
        L35:
            return;
        L5:
            if (this.f25046b[0] < h.n()) goto L28;
            if (h.o() == false) goto L28;
            int[] r11 = this.f25046b;
            int r12 = r11[0];
            Thread[] r13 = new Thread[r12 + (r12 / 2)];
            r11[0] = this.f25049e.enumerate(r13);
            StringBuilder r14 = new StringBuilder();
            int r15 = 0;
        L10:
            int r16 = this.f25046b[0];
            if (r15 >= r16) goto L26;
            String r17 = r13[r15].getName();
            if (TextUtils.isEmpty(r17) == true) goto L15;
            r14.append(r17);
            r14.append(",");
        L15:
            r15 = r15 + 1;
            goto L10
        L26:
            JSONObject r18 = h.p(this.f25047c, this.f25048d, r16, r14.toString());     // Catch: Throwable -> L24
            if (r18 == null) goto L32;
            l1.a.p().e(new m1.e("thread", null, null, r18));     // Catch: Throwable -> L24
            return;
        L32:
            return;
        }
    }

    static {
        f25039h = Runtime.getRuntime().availableProcessors();
        f25040i = false;
        f25041j = 300;
        f25042k = false;
        f25043l = false;
    }

    public h() {
        this.f25044g = AdConstant.SPLASH_AD_INTERVAL;
        this.f24971e = "thread";
    }

    public static /* synthetic */ int n() {
        return f25041j;
    }

    public static /* synthetic */ boolean o() {
        return f25040i;
    }

    public static /* synthetic */ JSONObject p(String r10, int r11, int r12, String r13) {
        return q(r10, r11, r12, r13);
    }

    public static JSONObject q(String r10, int r11, int r12, String r13) {
        JSONObject r14 = new JSONObject();
        if (r11 > 0) goto L17;
    L7:
        r14.put("java_thread_count", r12);     // Catch: JSONException -> L5
        if (TextUtils.isEmpty(r10) == true) goto L11;
        r14.put("scene", r10);     // Catch: JSONException -> L5
    L11:
        if (TextUtils.isEmpty(r13) == true) goto L13;
        r14.put("thread_detail", r13);     // Catch: JSONException -> L5
    L13:
        r14.put("is_main_process", w0.c.F());     // Catch: JSONException -> L5
        r14.put("cpu_count", f25039h);     // Catch: JSONException -> L5
        r14.put("process_name", w0.c.h());     // Catch: JSONException -> L5
    L16:
        return r14;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L17:
        r14.put("total_thread_count", r11);     // Catch: JSONException -> L5
        goto L7
    }

    public static int s(String r11, boolean r12) {
        int r10 = new File("/proc/self/task/").list().length;     // Catch: Throwable -> L5
    L6:
        if (r10 != 0) goto L8;
        return 0;
    L8:
        ThreadGroup r13 = Looper.getMainLooper().getThread().getThreadGroup();
    L10:
        if (r13.getParent() == null) goto L12;
        r13 = r13.getParent();
        goto L10
    L12:
        int[] r14 = {r13.activeCount()};
        AsyncEventManager.e().h(new a(r12, r14, r11, r10, r13));
        return (r10 << 16) + r14[0];
    L5:
        r10 = 0;
        goto L6
    }

    @Override // v1.a
    public void b(JSONObject r10) {
        super.b(r10);
        boolean r11 = false;
        if (r10.optInt("enable_thread_collect", 0) != 1) goto L5;
        boolean r12 = true;
    L6:
        f25042k = r12;
        if (r10.optInt("enable_upload", 0) != 1) goto L9;
        r11 = true;
    L9:
        f25043l = r11;
        f25041j = r10.optInt(SlardarSettingsConsts.PERF_KEY_THREAD_COUNT_INTERVAL, 300);
        this.f25044g = r10.optLong("collect_interval", 10) * 60000;
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // v1.a
    public boolean e() {
        return true;
    }

    @Override // v1.a
    public void h() {
        super.h();
        if (f25042k == true) goto L5;
        return;
    L5:
        if (f25043l == true) goto L7;
        return;
    L7:
        if ((System.currentTimeMillis() - w0.c.s()) <= StoreConsts.CHECK_FREE_DISK_INTERVAL_MS) goto L12;
        r();
        return;
    }

    @Override // v1.a
    public long m() {
        return this.f25044g;
    }

    @Override // v1.a, com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        super.onReady();
        f25040i = true;
    }

    public final void r() {
        s(null, false);
    }
}
