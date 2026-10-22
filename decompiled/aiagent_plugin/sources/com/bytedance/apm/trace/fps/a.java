package com.bytedance.apm.trace.fps;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.c;
import com.bytedance.apm.h.e;
import com.bytedance.apm.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: FpsAggregateManger.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.apm.thread.b.InterfaceC0118b {
    private static final String TAG = "FpsAggregateManger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, C0120a> f4945b;

    /* JADX INFO: renamed from: com.bytedance.apm.trace.fps.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FpsAggregateManger.java */
    private static class C0120a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f4951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f4952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f4953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f4954e;

        C0120a(Map<String, String> r3, String r4, float r5) {
            this.f4951b = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            this.f4950a = r4;
            this.f4952c = r5;
            this.f4953d = System.currentTimeMillis();
            this.f4954e = 1;
        }

        void a(float r2) {
            this.f4952c += r2;
            this.f4954e++;
        }

        float a() {
            int r0 = this.f4954e;
            if (r0 > 0) goto L5;
            return -1.0f;
        L5:
            return this.f4952c / r0;
        }

        boolean a(long r3) {
            if ((r3 - this.f4953d) <= 120000) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: FpsAggregateManger.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f4955a = null;

        static /* synthetic */ a a() {
            return f4955a;
        }

        static {
            f4955a = new a(null);
        }
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ HashMap a(a r0) {
        return r0.f4945b;
    }

    private a() {
        this.f4945b = new HashMap();
        this.f4944a = true;
        com.bytedance.apm.thread.b.a().a(this);
    }

    public static a a() {
        return b.a();
    }

    public void a(Map<String, String> r3, final String r4, final float r5) {
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        com.bytedance.apm.thread.b.a().a(new AnonymousClass1(this, r4, r6, r5));
    }

    @Override // com.bytedance.apm.thread.b.InterfaceC0118b
    public void onTimeEvent(long r14) {
        if (this.f4945b.isEmpty() == true) goto L34;
        Iterator<Map.Entry<String, C0120a>> r0 = this.f4945b.entrySet().iterator();
        int r1 = g.b();
    L6:
        if (r0.hasNext() == false) goto L47;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
        C0120a r3 = (C0120a) ZeusTransformUtils.preCheckCast(r2.getValue(), C0120a.class, "com.obric.aiagent.plugin");
        if (r3.a(r14) == false) goto L6;
        r0.remove();
        float r4 = r3.a();
        boolean r11 = false;
        if (c.i() == false) goto L13;
        e.c(com.bytedance.apm.h.b.f4647c, new String[]{"aggregate fps: " + r7 + " , value: " + r4});
    L13:
        if (r4 <= 0.0f) goto L6;
        float r5 = r1;
        if (r4 <= r5) goto L36;
        r4 = r5;
    L36:
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L35
        r8.put("fps", r4);     // Catch: Exception -> L35
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L35
        r9.put(DBHelper.BATTERY_COL_SCENE, r7);     // Catch: Exception -> L35
        com.bytedance.apm.d.b.e r6 = new com.bytedance.apm.d.b.e("fps", r7, r8, r9, null);     // Catch: Exception -> L35
        com.bytedance.apm6.perf.base.b.a(r6, true);     // Catch: Exception -> L35
        JSONObject r10 = r6.f;     // Catch: Exception -> L35
        r10.put("refresh_rate", r1);     // Catch: Exception -> L35
        if (this.f4944a == false) goto L25;
        this.f4944a = false;     // Catch: Exception -> L35
        r10.put("device_max_refresh_rate", g.c());     // Catch: Exception -> L35
        if (g.d() == true) goto L23;
        r11 = true;
    L23:
        r10.put("refresh_rate_restricted", r11);     // Catch: Exception -> L35
    L25:
        if (r3.f4951b != null) goto L27;
    L32:
        com.bytedance.apm.d.a.a.c().a(r6);     // Catch: Exception -> L35
        goto L6
    L27:
        if (r3.f4951b.isEmpty() == true) goto L32;
        Iterator<Map.Entry<String, String>> r12 = r3.f4951b.entrySet().iterator();     // Catch: Exception -> L35
    L30:
        if (r12.hasNext() == false) goto L32;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L35
        r6.f.put((String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.aiagent.plugin"), r13.getValue());     // Catch: Exception -> L35
        goto L30
    L47:
        return;
    }
}
