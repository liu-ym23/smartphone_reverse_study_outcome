package com.bytedance.apm.trace.fps;

import android.view.Choreographer;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.g;
import com.bytedance.apm.util.i;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.KevaImpl;
import com.bytedance.perf.monitor.ReportConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m1.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FpsTracer {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f6564u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Long f6565v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Long f6566w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f6568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IFPSCallBack f6569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IDropFrameCallback f6570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.apm.trace.fps.a f6571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IFrameCallBack f6572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Choreographer.FrameCallback f6573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinkedList f6574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap f6575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f6576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f6577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c f6580n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WindowManager f6581o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6582p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final JSONObject f6583q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f6584r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f6585s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6586t;

    public interface IBlockTimeCallBack {
        void blockTimeCallBack(long r10, int r11);
    }

    public interface IDropFrameCallback {
        void dropFrame(JSONObject r10);
    }

    public interface IFPSCallBack {
        void fpsCallBack(double r10);
    }

    public interface IFrameCallBack {
        void onFrame(long r10);
    }

    public interface IHtrFrmaeCallback {
        void dropHtrFrame(JSONObject r10, int r11);
    }

    public class a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FpsTracer f6587a;

        public a(FpsTracer r10) {
            this.f6587a = r10;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long r10) {
            if (FpsTracer.i(this.f6587a) != (-1)) goto L6;
            FpsTracer.j(this.f6587a, r10);
        L6:
            if (FpsTracer.k(this.f6587a) == null) goto L8;
            FpsTracer.k(this.f6587a).onFrame(r10 / BatteryFactorConfig.WIFI_BPS);
        L8:
            FpsTracer.l(this.f6587a);
            if (FpsTracer.a(this.f6587a) == false) goto L11;
            Choreographer.getInstance().postFrameCallback(this);
        L11:
            FpsTracer r11 = this.f6587a;
            FpsTracer.o(r11, FpsTracer.m(r11), r10);
            FpsTracer.n(this.f6587a, r10);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f6588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FpsTracer f6589b;

        public b(FpsTracer r10, List r11) {
            this.f6589b = r10;
            this.f6588a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
        L10:
            e = move-exception;
            if (w0.c.B() == false) goto L36;
            e.printStackTrace();
            return;
        L36:
            return;
        L4:
            if (ListUtils.b(this.f6588a) == false) goto L6;
            return;
        L6:
            float r10 = g.c();     // Catch: Exception -> L10
            int r11 = g.e();     // Catch: Exception -> L10
            int r12 = r11 - 1;     // Catch: Exception -> L10
            int[] r13 = new int[r11];     // Catch: Exception -> L10
            Iterator r14 = this.f6588a.iterator();     // Catch: Exception -> L10
            int r15 = 0;
            int r16 = 0;
        L8:
            if (r14.hasNext() == false) goto L12;
            Integer r17 = (Integer) r14.next();     // Catch: Exception -> L10
            int r18 = Math.max(Math.min(FpsTracer.p(r17.intValue(), r10), r12), 0);     // Catch: Exception -> L10
            r13[r18] = r13[r18] + 1;     // Catch: Exception -> L10
            r16 = r16 + (r17.intValue() / 100);     // Catch: Exception -> L10
            goto L8
        L12:
            JSONObject r19 = new JSONObject();     // Catch: Exception -> L10
        L13:
            if (r15 > r12) goto L19;
            if (r13[r15] <= 0) goto L17;
            r19.put(String.valueOf(r15), r13[r15]);     // Catch: Exception -> L10
        L17:
            r15 = r15 + 1;     // Catch: Exception -> L10
            goto L13
        L19:
            if (FpsTracer.b(this.f6589b) == null) goto L21;
            FpsTracer.b(this.f6589b).dropFrame(i.b(r19));     // Catch: Exception -> L10
        L21:
            JSONObject r110 = new JSONObject();     // Catch: Exception -> L10
            r110.put("scene", FpsTracer.c(this.f6589b));     // Catch: Exception -> L10
            JSONObject r111 = new JSONObject();     // Catch: Exception -> L10
            r111.put(ReportConst.SCROLL_TIME, r16);     // Catch: Exception -> L10
            r111.put("velocity", FpsTracer.d(this.f6589b) + "," + FpsTracer.e(this.f6589b));     // Catch: Exception -> L10
            r111.put("distance", FpsTracer.f(this.f6589b) + "," + FpsTracer.g(this.f6589b));     // Catch: Exception -> L10
            if (FpsTracer.h(this.f6589b) == null) goto L24;
            r111.put(WsConstants.KEY_EXTRA, FpsTracer.h(this.f6589b));     // Catch: Exception -> L10
        L24:
            r111.put(CommonKey.KEY_DROP_RATE, 1.0f - ((this.f6588a.size() * 1.0f) / ((int) (r16 / r10))));     // Catch: Exception -> L10
            e r20 = new e("fps_drop", FpsTracer.c(this.f6589b), r19, r110, r111);     // Catch: Exception -> L10
            m3.b.a(r20, true);     // Catch: Exception -> L10
            r20.f22047g.put("refresh_rate", r11);     // Catch: Exception -> L10
            l1.a.p().e(r20);     // Catch: Exception -> L10
        }
    }

    public class c extends View {
    }

    static {
        f6565v = 200L;
        f6566w = 1000L;
    }

    public FpsTracer(String r10, boolean r11) {
        this(r10, r11, null);
    }

    public static void A(String r10) {
        com.bytedance.apm.block.g.c(r10);
    }

    public static void D(boolean r10) {
        f6564u = r10;
    }

    public static /* synthetic */ boolean a(FpsTracer r10) {
        return r10.f6568b;
    }

    public static /* synthetic */ IDropFrameCallback b(FpsTracer r10) {
        return r10.f6570d;
    }

    public static /* synthetic */ String c(FpsTracer r10) {
        return r10.f6567a;
    }

    public static /* synthetic */ float d(FpsTracer r10) {
        return r10.f6576j;
    }

    public static /* synthetic */ float e(FpsTracer r10) {
        return r10.f6577k;
    }

    public static /* synthetic */ float f(FpsTracer r10) {
        return r10.f6578l;
    }

    public static /* synthetic */ float g(FpsTracer r10) {
        return r10.f6579m;
    }

    public static /* synthetic */ JSONObject h(FpsTracer r10) {
        return r10.f6583q;
    }

    public static /* synthetic */ long i(FpsTracer r10) {
        return r10.f6584r;
    }

    public static /* synthetic */ long j(FpsTracer r10, long r11) {
        r10.f6584r = r11;
        return r11;
    }

    public static /* synthetic */ IFrameCallBack k(FpsTracer r10) {
        return r10.f6572f;
    }

    public static /* synthetic */ int l(FpsTracer r10) {
        int r11 = r10.f6586t + 1;
        r10.f6586t = r11;
        return r11;
    }

    public static /* synthetic */ long m(FpsTracer r10) {
        return r10.f6585s;
    }

    public static /* synthetic */ long n(FpsTracer r10, long r11) {
        r10.f6585s = r11;
        return r11;
    }

    public static /* synthetic */ void o(FpsTracer r10, long r11, long r12) {
        r10.s(r11, r12);
    }

    public static /* synthetic */ int p(int r10, float r11) {
        return v(r10, r11);
    }

    public static void q(String r10) {
        com.bytedance.apm.block.g.a(r10);
    }

    public static int v(int r10, float r11) {
        int r12 = (int) (r11 * 100.0f);
        return ((r10 + (r12 - 1)) / r12) - 1;
    }

    public static String w() {
        return com.bytedance.apm.block.g.b();
    }

    public final void B() {
        this.f6576j = 0.0f;
        this.f6577k = 0.0f;
        this.f6578l = 0.0f;
        this.f6579m = 0.0f;
    }

    public void C(IDropFrameCallback r10) {
        com.bytedance.apm.trace.fps.a r11 = this.f6571e;
        if (r11 == null) goto L5;
        r11.v(r10);
    L5:
        this.f6570d = r10;
    }

    public void E(IFPSCallBack r10) {
        com.bytedance.apm.trace.fps.a r11 = this.f6571e;
        if (r11 == null) goto L5;
        r11.x(r10);
    L5:
        this.f6569c = r10;
    }

    public void F() {
        com.bytedance.apm.trace.fps.a r10 = this.f6571e;
        if (r10 == null) goto L7;
        r10.y();
        return;
    L7:
        if (this.f6568b == false) goto L10;
        return;
    L10:
        if (this.f6582p == false) goto L12;
    L14:
        B();
        G();
        q(this.f6567a);
        this.f6568b = true;
        return;
    L12:
        if (y() == true) goto L14;
    }

    public final void G() {
        monitor-enter(this);
        this.f6574h.clear();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        H();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void H() {
        this.f6584r = -1;
        this.f6585s = -1;
        this.f6586t = 0;
        this.f6573g = new a(this);
        Choreographer.getInstance().postFrameCallback(this.f6573g);     // Catch: Exception -> L5
        return;
    L5:
        this.f6568b = false;
        this.f6584r = -1;
        this.f6585s = -1;
        this.f6586t = 0;
        this.f6573g = null;
    }

    public synchronized void I() {
        monitor-enter(this);
        com.bytedance.apm.trace.fps.a r10 = this.f6571e;     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        r10.A();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        u();     // Catch: Throwable -> L8
        A(this.f6567a);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void r() {
        long r10 = this.f6585s - this.f6584r;
        if (r10 <= 0) goto L12;
        int r11 = this.f6586t;
        if (r11 <= 1) goto L13;
        long r12 = (((long) (r11 - 1)) * 1000000000) / r10;
        IFPSCallBack r13 = this.f6569c;
        if (r13 == null) goto L10;
        r13.fpsCallBack(r12);
    L10:
        g2.a.c().b(this.f6575i, this.f6567a, r12);
        return;
    L13:
        return;
    }

    public final void s(long r10, long r11) {
        if (this.f6585s > 0) goto L5;
        return;
    L5:
        long r12 = r11 - r10;
        if ((r12 / BatteryFactorConfig.WIFI_BPS) > 0) goto L8;
        return;
    L8:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L10:
        if (this.f6574h.size() <= 20000) goto L14;
        this.f6574h.poll();     // Catch: Throwable -> L12
    L14:
        this.f6574h.add(Integer.valueOf(((int) r12) / KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD));     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    }

    public final void t() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f6574h.isEmpty() == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        LinkedList r10 = this.f6574h;     // Catch: Throwable -> L7
        this.f6574h = new LinkedList();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        AsyncEventManager.e().h(new b(this, r10));
    }

    public final void u() {
        if (this.f6568b == true) goto L5;
        return;
    L5:
        r();
        if (this.f6573g == null) goto L8;
        Choreographer.getInstance().removeFrameCallback(this.f6573g);
    L8:
        t();
        this.f6568b = false;
    }

    public final boolean x() {
        return b2.b.d("fps_drop", this.f6567a);
    }

    public boolean y() {
        if (w0.c.H() == true) goto L5;
    L9:
        return false;
    L5:
        if (x() == false) goto L7;
    L8:
        return true;
    L7:
        if (z() == false) goto L9;
        goto L8
    }

    public final boolean z() {
        return b2.b.d("fps", this.f6567a);
    }

    public FpsTracer(String r10, boolean r11, JSONObject r12) {
        this.f6568b = false;
        this.f6572f = null;
        this.f6575i = new HashMap();
        this.f6576j = 0.0f;
        this.f6577k = 0.0f;
        this.f6578l = 0.0f;
        this.f6579m = 0.0f;
        this.f6581o = null;
        this.f6584r = -1;
        this.f6585s = -1;
        this.f6586t = 0;
        this.f6583q = r12;
        if (f6564u == false) goto L6;
        this.f6571e = new com.bytedance.apm.trace.fps.a(r10, r11, r12);
        return;
    L6:
        this.f6567a = r10;
        this.f6582p = r11;
        this.f6574h = new LinkedList();
    }
}
