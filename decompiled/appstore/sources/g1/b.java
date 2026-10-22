package g1;

import android.view.FrameMetrics;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.perf.monitor.ReportConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends g1.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f19783g = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f19784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f19785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap f19786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f19787f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f19788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f19789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f19790c;

        public a(b r10, long r11, boolean r12) {
            this.f19790c = r10;
            this.f19788a = r11;
            this.f19789b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.h(this.f19790c).a(this.f19788a, this.f19789b);
            int r10 = 0;
        L4:
            if (r10 >= b.i(this.f19790c).size()) goto L6;
            ((com.bytedance.apm.trace.fps.a) b.i(this.f19790c).get(r10)).m(this.f19788a, this.f19789b);
            r10 = r10 + 1;
            goto L4
        }
    }

    /* JADX INFO: renamed from: g1.b$b, reason: collision with other inner class name */
    public class RunnableC0252b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm.trace.fps.a f19791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f19792b;

        public RunnableC0252b(b r10, com.bytedance.apm.trace.fps.a r11) {
            this.f19792b = r10;
            this.f19791a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.i(this.f19792b).add(this.f19791a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm.trace.fps.a f19793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f19794b;

        public c(b r10, com.bytedance.apm.trace.fps.a r11) {
            this.f19794b = r10;
            this.f19793a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.i(this.f19794b).remove(this.f19793a);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f19797c;

        public d() {
            this.f19795a = 0;
            this.f19796b = 0;
            this.f19797c = 0;
        }

        public void a(long r10, boolean r11) {
            if (r11 == false) goto L4;
            this.f19795a++;
        L4:
            this.f19796b++;
            this.f19797c += r10;
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f19799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19800c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19801d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f19802e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19803f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ b f19804g;

        public e(b r10, String r11) {
            this.f19804g = r10;
            this.f19800c = 0;
            this.f19798a = r11;
            int r12 = com.bytedance.apm.util.g.e();
            this.f19803f = r12 - 1;
            this.f19802e = new int[r12];
        }

        public void a(long r10) {
            float r11 = com.bytedance.apm.util.g.c();
            this.f19799b += r10;
            int r12 = Math.min(Math.max((int) (r10 / r11), 0), this.f19803f);
            int[] r13 = this.f19802e;
            r13[r12] = r13[r12] + 1;
            this.f19801d += r12;
            this.f19800c++;
        }

        public void b() {
            float r10 = com.bytedance.apm.util.g.c();     // Catch: Throwable -> L13
            JSONObject r11 = new JSONObject();     // Catch: Throwable -> L13
            int r12 = 0;
        L5:
            if (r12 > this.f19803f) goto L10;
            if (this.f19802e[r12] <= 0) goto L9;
            r11.put(String.valueOf(r12), this.f19802e[r12]);     // Catch: Throwable -> L13
        L9:
            r12 = r12 + 1;     // Catch: Throwable -> L13
            goto L5
        L10:
            g2.a.c().b(null, this.f19798a, (float) (((double) (((this.f19800c * 100) * com.bytedance.apm.util.g.e()) / (this.f19800c + this.f19801d))) / 100.0d));     // Catch: Throwable -> L13
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L13
            r13.put("scene", this.f19798a);     // Catch: Throwable -> L13
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L13
            r14.put(ReportConst.SCROLL_TIME, this.f19799b);     // Catch: Throwable -> L13
            r14.put(CommonKey.KEY_DROP_RATE, 1.0f - ((this.f19800c * 1.0f) / ((int) (this.f19799b / r10))));     // Catch: Throwable -> L13
            r14.put("refresh_rate", this.f19803f + 1);     // Catch: Throwable -> L13
            l1.a.p().e(new m1.e("fps_drop", this.f19798a, r11, r13, r14));     // Catch: Throwable -> L13
        L11:
            this.f19800c = 0;
            this.f19801d = 0;
            this.f19799b = 0;
        }

        public String toString() {
            return "visibleScene=" + this.f19798a + ", sumFrame=" + this.f19800c + ", sumDroppedFrames=" + this.f19801d + ", sumFrameCost=" + this.f19799b + ", dropLevel=" + Arrays.toString(this.f19802e);
        }
    }

    static {
    }

    public b() {
        this.f19784c = 10000;
        this.f19785d = new ArrayList();
        this.f19786e = new HashMap();
        this.f19787f = new d();
        g1.d.A().Q(true);
        FpsTracer.D(true);
    }

    public static /* synthetic */ d h(b r10) {
        return r10.f19787f;
    }

    public static /* synthetic */ ArrayList i(b r10) {
        return r10.f19785d;
    }

    public static void n(boolean r10) {
        f19783g = r10;
    }

    @Override // com.bytedance.apm.block.a
    public void d(String r10, long r11, int r12) {
        l(r10, r11);
        int r13 = 0;
    L4:
        if (r13 >= this.f19785d.size()) goto L6;
        ((com.bytedance.apm.trace.fps.a) this.f19785d.get(r13)).n(r11);
        r13 = r13 + 1;
        goto L4
    }

    @Override // com.bytedance.apm.block.a
    public void e(String r10, FrameMetrics r11, int r12) {
        int r13 = 0;
        long r14 = (((((r11.getMetric(0) + r11.getMetric(1)) + r11.getMetric(2)) + r11.getMetric(3)) + r11.getMetric(4)) + r11.getMetric(5)) / BatteryFactorConfig.WIFI_BPS;
        l(r10, r14);
    L4:
        if (r13 >= this.f19785d.size()) goto L6;
        ((com.bytedance.apm.trace.fps.a) this.f19785d.get(r13)).n(r14);
        r13 = r13 + 1;
        goto L4
    }

    public void j(com.bytedance.apm.trace.fps.a r10) {
        g1.d.A().f19824o.b(new RunnableC0252b(this, r10));
    }

    public void k(long r10, boolean r11) {
        g1.d.A().f19824o.b(new a(this, r10, r11));
    }

    public final void l(String r10, long r11) {
        if (f19783g == true) goto L5;
        return;
    L5:
        if (r11 <= 0) goto L16;
        e r12 = (e) this.f19786e.get(r10);
        if (r12 != null) goto L10;
        r12 = new e(this, r10);
        this.f19786e.put(r10, r12);
    L10:
        r12.a(r11);
        if (r12.f19799b < 10000) goto L15;
        this.f19786e.remove(r10);
        r12.b();
        return;
    L15:
        return;
    }

    public void m(com.bytedance.apm.trace.fps.a r10) {
        g1.d.A().f19824o.b(new c(this, r10));
    }
}
