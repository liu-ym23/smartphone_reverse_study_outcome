package com.bytedance.apm.trace.fps;

import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.g;
import com.bytedance.apm.util.i;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.perf.monitor.ReportConst;
import g1.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import m1.e;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Long f6590u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Long f6591v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static g1.b f6592w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f6594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g1.b.d f6595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FpsTracer.IFPSCallBack f6596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FpsTracer.IFrameCallBack f6597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile FpsTracer.IDropFrameCallback f6598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile FpsTracer.IHtrFrmaeCallback f6599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile FpsTracer.IBlockTimeCallBack f6600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinkedList f6601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HashMap f6602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f6603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6604l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6605m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f6606n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f6607o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f6608p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b f6609q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WindowManager f6610r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f6611s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final JSONObject f6612t;

    /* JADX INFO: renamed from: com.bytedance.apm.trace.fps.a$a, reason: collision with other inner class name */
    public class RunnableC0077a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f6613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f6614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g1.b.d f6615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f6616d;

        public RunnableC0077a(a r10, List r11, Map r12, g1.b.d r13) {
            this.f6616d = r10;
            this.f6613a = r11;
            this.f6614b = r12;
            this.f6615c = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
        L15:
            e = move-exception;
            if (c.B() == false) goto L68;
            e.printStackTrace();
            return;
        L68:
            return;
        L4:
            if (ListUtils.b(this.f6613a) == false) goto L6;
            return;
        L6:
            float r10 = g.c();     // Catch: Exception -> L15
            int r11 = g.e();     // Catch: Exception -> L15
            int r12 = r11 - 1;     // Catch: Exception -> L15
            int[] r13 = new int[r11];     // Catch: Exception -> L15
            int[] r14 = new int[r11];     // Catch: Exception -> L15
            Iterator r15 = this.f6613a.iterator();     // Catch: Exception -> L15
            int r16 = 0;
            int r17 = 0;
            int r18 = 0;
        L8:
            if (r15.hasNext() == false) goto L18;
            Integer r19 = (Integer) r15.next();     // Catch: Exception -> L15
            int r110 = a.f(r19.intValue(), r10);     // Catch: Exception -> L15
            if (r110 <= 0) goto L12;
            r16 = r16 + r110;     // Catch: Exception -> L15
        L12:
            int r111 = r16;
            if (r19.intValue() < 833.0d) goto L17;
            r17 = r17 + (r19.intValue() / 100);     // Catch: Exception -> L15
        L17:
            int r20 = Math.max(Math.min(r110, r12), 0);     // Catch: Exception -> L15
            r13[r20] = r13[r20] + 1;     // Catch: Exception -> L15
            r14[r20] = (int) (((double) r14[r20]) + (((double) r19.intValue()) / 100.0d));     // Catch: Exception -> L15
            r18 = r18 + (r19.intValue() / 100);     // Catch: Exception -> L15
            r17 = r17;
            r16 = r111;
            goto L8
        L18:
            int r21 = ((this.f6613a.size() * 100) * r11) / (this.f6613a.size() + r16);     // Catch: Exception -> L15
            this.f6614b.put("report_list_size", Integer.toString(this.f6613a.size()));     // Catch: Exception -> L15
            a.g(this.f6616d, this.f6614b, (float) (((double) r21) / 100.0d));     // Catch: Exception -> L15
            int r22 = (int) ((this.f6613a.size() + r16) * r10);     // Catch: Exception -> L15
            JSONObject r23 = new JSONObject();     // Catch: Exception -> L15
            int r112 = 0;
        L19:
            if (r112 > r12) goto L24;
            if (r13[r112] <= 0) goto L23;
            r23.put(String.valueOf(r112), r13[r112]);     // Catch: Exception -> L15
            int r113 = r13[r112];     // Catch: Exception -> L15
        L23:
            r112 = r112 + 1;     // Catch: Exception -> L15
            goto L19
        L24:
            JSONObject r24 = new JSONObject();     // Catch: Exception -> L15
            int r114 = 0;
        L25:
            if (r114 > r12) goto L31;
            if (r14[r114] <= 0.1d) goto L29;
            r24.put(String.valueOf(r114), r14[r114]);     // Catch: Exception -> L15
        L29:
            r114 = r114 + 1;     // Catch: Exception -> L15
            goto L25
        L31:
            if (a.h(this.f6616d) == null) goto L34;
            a.h(this.f6616d).dropFrame(i.b(r23));     // Catch: Exception -> L15
        L34:
            if (a.i(this.f6616d) == null) goto L37;
            FpsTracer.IBlockTimeCallBack r25 = a.i(this.f6616d);     // Catch: Exception -> L15
            g1.b.d r26 = this.f6615c;     // Catch: Exception -> L15
            r25.blockTimeCallBack(r26.f19797c, r26.f19796b);     // Catch: Exception -> L15
        L37:
            if (a.j(this.f6616d) == null) goto L39;
            a.j(this.f6616d).dropHtrFrame(i.b(r24), r22);     // Catch: Exception -> L15
        L39:
            JSONObject r27 = new JSONObject();     // Catch: Exception -> L15
            r27.put("scene", a.k(this.f6616d));     // Catch: Exception -> L15
            JSONObject r28 = new JSONObject();     // Catch: Exception -> L15
            r28.put(ReportConst.SCROLL_TIME, r18);     // Catch: Exception -> L15
            r28.put("dur", r22);     // Catch: Exception -> L15
            r28.put("hitch_dur_dic", r24);     // Catch: Exception -> L15
            r28.put("hitch_dur", r17);     // Catch: Exception -> L15
            r28.put("velocity", a.a(this.f6616d) + "," + a.b(this.f6616d));     // Catch: Exception -> L15
            r28.put("distance", a.c(this.f6616d) + "," + a.d(this.f6616d));     // Catch: Exception -> L15
            r28.put("frame_count", this.f6613a.size());     // Catch: Exception -> L15
            r28.put("drop_count", r16);     // Catch: Exception -> L15
            if (a.e(this.f6616d) == null) goto L42;
            r28.put(WsConstants.KEY_EXTRA, a.e(this.f6616d));     // Catch: Exception -> L15
        L42:
            r28.put(CommonKey.KEY_DROP_RATE, 1.0f - ((this.f6613a.size() * 1.0f) / ((int) (r18 / r10))));     // Catch: Exception -> L15
            e r29 = new e("fps_drop", a.k(this.f6616d), r23, r27, r28);     // Catch: Exception -> L15
            m3.b.a(r29, true);     // Catch: Exception -> L15
            r29.f22047g.put("refresh_rate", r11);     // Catch: Exception -> L15
            Map r30 = this.f6614b;     // Catch: Exception -> L15
            if (r30 != null) goto L45;
        L50:
            l1.a.p().e(r29);     // Catch: Exception -> L15
            return;
        L45:
            if (r30.isEmpty() == true) goto L50;
            Iterator r31 = this.f6614b.entrySet().iterator();     // Catch: Exception -> L15
        L48:
            if (r31.hasNext() == false) goto L50;
            Map.Entry r32 = (Map.Entry) r31.next();     // Catch: Exception -> L15
            r29.f22047g.put((String) r32.getKey(), r32.getValue());     // Catch: Exception -> L15
            goto L48
        }
    }

    public class b extends View {
    }

    static {
        f6590u = 200L;
        f6591v = 1000L;
    }

    public a(String r10, boolean r11, JSONObject r12) {
        this.f6594b = false;
        this.f6595c = new g1.b.d();
        this.f6597e = null;
        this.f6602j = new HashMap();
        this.f6603k = 0.0f;
        this.f6604l = 0.0f;
        this.f6605m = 0.0f;
        this.f6606n = 0.0f;
        this.f6607o = 0;
        this.f6608p = 0;
        this.f6610r = null;
        this.f6593a = r10;
        this.f6611s = r11;
        this.f6612t = r12;
        this.f6601i = new LinkedList();
    }

    public static /* synthetic */ float a(a r10) {
        return r10.f6603k;
    }

    public static /* synthetic */ float b(a r10) {
        return r10.f6604l;
    }

    public static /* synthetic */ float c(a r10) {
        return r10.f6605m;
    }

    public static /* synthetic */ float d(a r10) {
        return r10.f6606n;
    }

    public static /* synthetic */ JSONObject e(a r10) {
        return r10.f6612t;
    }

    public static /* synthetic */ int f(int r10, float r11) {
        return q(r10, r11);
    }

    public static /* synthetic */ void g(a r10, Map r11, float r12) {
        r10.l(r11, r12);
    }

    public static /* synthetic */ FpsTracer.IDropFrameCallback h(a r10) {
        return r10.f6598f;
    }

    public static /* synthetic */ FpsTracer.IBlockTimeCallBack i(a r10) {
        return r10.f6600h;
    }

    public static /* synthetic */ FpsTracer.IHtrFrmaeCallback j(a r10) {
        return r10.f6599g;
    }

    public static /* synthetic */ String k(a r10) {
        return r10.f6593a;
    }

    public static int q(int r10, float r11) {
        return r10 / ((int) (r11 * 100.0f));
    }

    public static void w(g1.b r10) {
        f6592w = r10;
    }

    public synchronized void A() {
        monitor-enter(this);
        p();     // Catch: Throwable -> L6
        FpsTracer.A(this.f6593a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void l(Map r10, float r11) {
        FpsTracer.IFPSCallBack r12 = this.f6596d;
        if (r12 == null) goto L5;
        r12.fpsCallBack(r11);
    L5:
        g2.a.c().b(r10, this.f6593a, r11);
    }

    public void m(long r10, boolean r11) {
        this.f6595c.a(r10, r11);
    }

    public void n(long r10) {
        if (r10 >= 0) goto L5;
        return;
    L5:
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.f6601i.size() <= 20000) goto L11;
        this.f6601i.poll();     // Catch: Throwable -> L9
    L11:
        this.f6601i.add(Integer.valueOf(((int) r10) * 100));     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
    }

    public final void o(long r10, long r11) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f6601i.isEmpty() == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.f6608p = 0;     // Catch: Throwable -> L7
        LinkedList r12 = this.f6601i;     // Catch: Throwable -> L7
        this.f6601i = new LinkedList();     // Catch: Throwable -> L7
        g1.b.d r13 = this.f6595c;     // Catch: Throwable -> L7
        this.f6595c = new g1.b.d();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        HashMap r14 = new HashMap();
        r14.putAll(this.f6602j);
        AsyncEventManager.e().h(new RunnableC0077a(this, r12, r14, r13));
    }

    public final void p() {
        g1.b r10 = f6592w;
        if (r10 == null) goto L9;
        r10.m(this);
        if (this.f6594b == true) goto L7;
        return;
    L7:
        o(this.f6607o, SystemClock.uptimeMillis());
        this.f6594b = false;
        return;
    }

    public final boolean r() {
        return b2.b.d("fps_drop", this.f6593a);
    }

    public boolean s() {
        if (d.A().E() == false) goto L13;
        if (c.H() == true) goto L7;
        return false;
    L7:
        if (r() == true) goto L11;
        if (t() == true) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (c.H() == true) goto L19;
        if (r() == true) goto L19;
        if (t() == true) goto L19;
        return false;
    L19:
        return true;
    }

    public final boolean t() {
        return b2.b.d("fps", this.f6593a);
    }

    public final void u() {
        this.f6603k = 0.0f;
        this.f6604l = 0.0f;
        this.f6605m = 0.0f;
        this.f6606n = 0.0f;
        this.f6607o = 0;
    }

    public void v(FpsTracer.IDropFrameCallback r10) {
        this.f6598f = r10;
    }

    public void x(FpsTracer.IFPSCallBack r10) {
        this.f6596d = r10;
    }

    public void y() {
        if (this.f6594b == false) goto L6;
        return;
    L6:
        if (this.f6611s == false) goto L8;
    L10:
        u();
        z();
        FpsTracer.q(this.f6593a);
        this.f6607o = SystemClock.uptimeMillis();
        this.f6594b = true;
        return;
    L8:
        if (s() == true) goto L10;
    }

    public final void z() {
        if (f6592w == null) goto L6;
        this.f6594b = true;
        f6592w.j(this);
        return;
    }
}
