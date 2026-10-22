package dc;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.obric.matrix.platform.sdk.ones.commonmonitor.fps.IFPSCallBack;
import com.obric.matrix.platform.sdk.ones.commonmonitor.fps.LooperPrinterUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f19148k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f19149l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IFPSCallBack f19152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FpsTracer f19153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f19155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f19158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f19159j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements FpsTracer.IFPSCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f19160a;

        public b(c r10) {
            this.f19160a = r10;
        }

        @Override // com.bytedance.apm.trace.fps.FpsTracer.IFPSCallBack
        public void fpsCallBack(double r10) {
            c.e(this.f19160a, (d) c.a().poll());
            d r11 = c.c(this.f19160a);
            if (r11 == null) goto L7;
            r11.q(r10);
            return;
        }
    }

    /* JADX INFO: renamed from: dc.c$c, reason: collision with other inner class name */
    public static final class C0235c implements FpsTracer.IDropFrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f19161a;

        public C0235c(c r10) {
            this.f19161a = r10;
        }

        @Override // com.bytedance.apm.trace.fps.FpsTracer.IDropFrameCallback
        public void dropFrame(JSONObject r14) {
            if (r14 != null) goto L5;
            return;
        L5:
            if (c.c(this.f19161a) == null) goto L54;
            Iterator<String> r10 = r14.keys();     // Catch: Exception -> L40
            double r11 = 0.0d;
            int r12 = 0;
            int r13 = 0;
            int r15 = 0;
            double r16 = 0.0d;
        L8:
            if (r10.hasNext() == false) goto L22;
            String r17 = r10.next();     // Catch: Exception -> L40
            q.f(r17, "keyStr");     // Catch: Exception -> L40
            int r18 = Integer.parseInt(r17);     // Catch: Exception -> L40
            int r19 = r14.getInt(r17);     // Catch: Exception -> L40
            if (r18 == 0) goto L11;
            if (r18 <= 0) goto L8;
            r11 = r11 + ((double) (r18 * r19));     // Catch: Exception -> L40
            r16 = r16 + ((double) r19);     // Catch: Exception -> L40
            if (r18 < 25) goto L17;
            r15 = r15 + r19;     // Catch: Exception -> L40
        L17:
            if (r18 < 7) goto L20;
            r13 = r13 + r19;     // Catch: Exception -> L40
        L20:
            if (r18 < 3) goto L8;
            r12 = r12 + r19;     // Catch: Exception -> L40
            goto L8
        L11:
            r16 = r16 + ((double) r19);     // Catch: Exception -> L40
            goto L8
        L22:
            d r20 = c.c(this.f19161a);     // Catch: Exception -> L40
            if (r20 == null) goto L25;
            r20.m(e.f19177a.a(r11 / (r11 + r16)));     // Catch: Exception -> L40
            r20.k(r12);     // Catch: Exception -> L40
            r20.l(r13);     // Catch: Exception -> L40
            r20.j(r15);     // Catch: Exception -> L40
            r20.r((int) r16);     // Catch: Exception -> L40
        L25:
            hc.b.g("FPSMonitorOnScrollListener", "dropFrame: " + r14, null, 4, null);     // Catch: Exception -> L40
            hc.b.g("FPSMonitorOnScrollListener", "fpsCallBack: " + c.c(this.f19161a), null, 4, null);     // Catch: Exception -> L40
            d r110 = c.c(this.f19161a);     // Catch: Exception -> L40
            if (r110 == null) goto L28;
            JSONObject r111 = dc.a.f19146a.b(r110);     // Catch: Exception -> L40
        L29:
            d r21 = c.c(this.f19161a);     // Catch: Exception -> L40
            if (r21 == null) goto L32;
            ec.d.f19371l.a().w(c.d(this.f19161a), (float) r21.f(), r111);     // Catch: Exception -> L40
        L32:
            IFPSCallBack r112 = c.b(this.f19161a);     // Catch: Exception -> L40
            if (r112 == null) goto L35;
            r112.fpsCallBack(c.c(this.f19161a));     // Catch: Exception -> L40
        L35:
            d r113 = c.c(this.f19161a);     // Catch: Exception -> L40
            if (r113 == null) goto L38;
            r113.g();     // Catch: Exception -> L40
        L38:
            c.e(this.f19161a, null);     // Catch: Exception -> L40
            return;
        L28:
            r111 = null;
        L55:
            return;
        }
    }

    static {
        f19148k = new a(null);
        f19149l = new ConcurrentLinkedQueue();
    }

    public c(String r10, boolean r11, IFPSCallBack r12) {
        q.g(r10, "scene");
        this.f19150a = r10;
        this.f19151b = r11;
        this.f19152c = r12;
        this.f19153d = new FpsTracer(r10, r11);
        this.f19155f = -1;
        g();
    }

    public static final /* synthetic */ ConcurrentLinkedQueue a() {
        return f19149l;
    }

    public static final /* synthetic */ IFPSCallBack b(c r10) {
        return r10.f19152c;
    }

    public static final /* synthetic */ d c(c r10) {
        return r10.f19159j;
    }

    public static final /* synthetic */ String d(c r10) {
        return r10.f19150a;
    }

    public static final /* synthetic */ void e(c r10, d r11) {
        r10.f19159j = r11;
    }

    public final void f() {
        if (this.f19154e == false) goto L5;
        return;
    L5:
        if (dc.a.f19146a.a() != null) goto L18;
        hc.b.b("FPSMonitorOnScrollListener", "CurrentPrinter() == null, now reset.", null, 4, null);
        Field r10 = LooperPrinterUtils.class.getDeclaredField("a");     // Catch: Exception -> L10
        q.f(r10, "LooperPrinterUtils::clas…dField(\"sPrinterWrapper\")");     // Catch: Exception -> L10
        r10.setAccessible(true);     // Catch: Exception -> L10
        Object r11 = r10.get(null);     // Catch: Exception -> L10
        if (r11 == null) goto L13;
        Looper r12 = Looper.getMainLooper();     // Catch: Exception -> L10
        r12.setMessageLogging((Printer) r11);     // Catch: Exception -> L10
        this.f19154e = true;     // Catch: Exception -> L10
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void g() {
        this.f19153d.E(new b(this));
        this.f19153d.C(new C0235c(this));
    }

    public final void h() {
        this.f19156g = 0;
        this.f19157h = 0;
        this.f19155f = -1;
        d r10 = this.f19158i;
        if (r10 == null) goto L6;
        f19149l.add(r10);
        this.f19158i = null;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r10, int r11) {
        q.g(r10, "recyclerView");
        super.onScrollStateChanged(r10, r11);
        if (r11 != 0) goto L5;
        d r12 = this.f19158i;
        if (r12 != null) goto L20;
    L23:
        h();
        this.f19153d.I();
        return;
    L20:
        if (this.f19155f <= 0) goto L22;
        r12.n(SystemClock.elapsedRealtime() - this.f19155f);
    L22:
        r12.h(this.f19156g);
        r12.i(this.f19157h);
        r12.o(r10.computeHorizontalScrollOffset());
        r12.p(r10.computeVerticalScrollOffset());
        goto L23
    L5:
        if (r11 == 1) goto L8;
        return;
    L8:
        if (this.f19155f < 0) goto L10;
    L16:
        f();
        this.f19153d.F();
        return;
    L10:
        if (this.f19158i != null) goto L12;
        this.f19158i = d.f19162n.a();
    L12:
        d r13 = this.f19158i;
        if (r13 == null) goto L15;
        r13.s(r10.computeHorizontalScrollOffset());
        r13.t(r10.computeVerticalScrollOffset());
    L15:
        this.f19155f = SystemClock.elapsedRealtime();
        goto L16
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView r10, int r11, int r12) {
        q.g(r10, "recyclerView");
        super.onScrolled(r10, r11, r12);
        this.f19156g += Math.abs(r11);
        this.f19157h += Math.abs(r12);
    }
}
