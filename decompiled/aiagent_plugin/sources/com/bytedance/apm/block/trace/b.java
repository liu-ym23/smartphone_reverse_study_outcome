package com.bytedance.apm.block.trace;

import android.os.Build;
import android.view.FrameMetrics;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: FrameTracer.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.apm.block.trace.a {
    private static final String TAG = "FrameTracer";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4399b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f4400a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<RealFpsTracer> f4401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<String, C0112b> f4402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f4403e;

    /* JADX INFO: compiled from: FrameTracer.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f4413c;

        public a() {
            this.f4411a = 0;
            this.f4412b = 0;
            this.f4413c = 0;
        }

        public void a(long r3, boolean r5) {
            if (r5 == false) goto L4;
            this.f4411a++;
        L4:
            this.f4412b++;
            this.f4413c += r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.block.trace.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FrameTracer.java */
    private class C0112b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f4415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f4416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f4417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int[] f4418e;
        int f;
        final /* synthetic */ b g;

        C0112b(b r1, String r2) {
            this.g = r1;
            this.f4416c = 0;
            this.f4414a = r2;
            int r3 = com.bytedance.apm.util.g.b() - 1;
            this.f = r3;
            this.f4418e = new int[(r3 - 0) + 1];
        }

        void a(long r4) {
            float r0 = com.bytedance.apm.util.g.a();
            this.f4415b += r4;
            int r5 = Math.min(Math.max((int) (r4 / r0), 0), this.f);
            int[] r6 = this.f4418e;
            r6[r5] = r6[r5] + 1;
            this.f4417d += r5;
            this.f4416c++;
        }

        void a() {
            float r3 = com.bytedance.apm.util.g.a();     // Catch: Throwable -> L13
            JSONObject r7 = new JSONObject();     // Catch: Throwable -> L13
            int r4 = 0;
        L5:
            if (r4 > this.f) goto L10;
            if (this.f4418e[r4] <= 0) goto L9;
            r7.put(String.valueOf(r4), this.f4418e[r4]);     // Catch: Throwable -> L13
        L9:
            r4 = r4 + 1;     // Catch: Throwable -> L13
            goto L5
        L10:
            com.bytedance.apm.trace.fps.a.a().a(null, this.f4414a, (float) (((double) (((this.f4416c * 100) * com.bytedance.apm.util.g.b()) / (this.f4416c + this.f4417d))) / 100.0d));     // Catch: Throwable -> L13
            JSONObject r8 = new JSONObject();     // Catch: Throwable -> L13
            r8.put(DBHelper.BATTERY_COL_SCENE, this.f4414a);     // Catch: Throwable -> L13
            JSONObject r9 = new JSONObject();     // Catch: Throwable -> L13
            r9.put("total_scroll_time", this.f4415b);     // Catch: Throwable -> L13
            r9.put("drop_time_rate", 1.0f - ((this.f4416c * 1.0f) / ((int) (this.f4415b / r3))));     // Catch: Throwable -> L13
            r9.put("refresh_rate", this.f + 1);     // Catch: Throwable -> L13
            com.bytedance.apm.d.a.a.c().a(new com.bytedance.apm.d.b.e("fps_drop", this.f4414a, r7, r8, r9));     // Catch: Throwable -> L13
        L11:
            this.f4416c = 0;
            this.f4417d = 0;
            this.f4415b = 0;
        }

        public String toString() {
            return "visibleScene=" + this.f4414a + ", sumFrame=" + this.f4416c + ", sumDroppedFrames=" + this.f4417d + ", sumFrameCost=" + this.f4415b + ", dropLevel=" + Arrays.toString(this.f4418e);
        }
    }

    static {
    }

    static /* synthetic */ a a(b r0) {
        return r0.f4403e;
    }

    static /* synthetic */ ArrayList b(b r0) {
        return r0.f4401c;
    }

    public b() {
        this.f4400a = 10000;
        this.f4401c = new ArrayList();
        this.f4402d = new HashMap();
        this.f4403e = new a();
        f.a().a(true);
        FpsTracer.a(true);
    }

    public static void a(boolean r0) {
        f4399b = r0;
    }

    @Override // com.bytedance.apm.block.a
    public void a(String r3, long r4, long r6) {
        super.a(r3, r4, r6);
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return;
    L5:
        long r7 = r6 - r4;
        a(r3, r7);
        int r5 = 0;
    L7:
        if (r5 >= this.f4401c.size()) goto L9;
        ((RealFpsTracer) ZeusTransformUtils.preCheckCast(this.f4401c.get(r5), RealFpsTracer.class, "com.obric.aiagent.plugin")).a(r7);
        r5 = r5 + 1;
        goto L7
    }

    @Override // com.bytedance.apm.block.a
    public void a(String r3, long r4, int r6) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        a(r3, r4);
        int r5 = 0;
    L6:
        if (r5 >= this.f4401c.size()) goto L10;
        ((RealFpsTracer) ZeusTransformUtils.preCheckCast(this.f4401c.get(r5), RealFpsTracer.class, "com.obric.aiagent.plugin")).a(r4);
        r5 = r5 + 1;
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.apm.block.a
    public void a(String r5, FrameMetrics r6, int r7) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        int r8 = 0;
        long r0 = (((((r6.getMetric(0) + r6.getMetric(1)) + r6.getMetric(2)) + r6.getMetric(3)) + r6.getMetric(4)) + r6.getMetric(5)) / 1000000;
        a(r5, r0);
    L6:
        if (r8 >= this.f4401c.size()) goto L10;
        ((RealFpsTracer) ZeusTransformUtils.preCheckCast(this.f4401c.get(r8), RealFpsTracer.class, "com.obric.aiagent.plugin")).a(r0);
        r8 = r8 + 1;
        goto L6
    L10:
        return;
    }

    public void a(final long r3, final boolean r5) {
        f.a().f4429b.a(new AnonymousClass1(this, r3, r5));
    }

    public void a(final RealFpsTracer r3) {
        f.a().f4429b.a(new AnonymousClass2(this, r3));
    }

    public void b(final RealFpsTracer r3) {
        f.a().f4429b.a(new AnonymousClass3(this, r3));
    }

    private void a(String r4, long r5) {
        if (f4399b == true) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L16;
        C0112b r0 = (C0112b) ZeusTransformUtils.preCheckCast(this.f4402d.get(r4), C0112b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
        r0 = new C0112b(this, r4);
        this.f4402d.put(r4, r0);
    L10:
        r0.a(r5);
        if (r0.f4415b < 10000) goto L15;
        this.f4402d.remove(r4);
        r0.a();
        return;
    L15:
        return;
    }
}
