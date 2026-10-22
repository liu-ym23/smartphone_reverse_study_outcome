package com.bytedance.apm.perf.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.y;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BizTrafficStats.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "BizTrafficStats";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, C0117a> f4745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, C0117a> f4746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, C0117a> f4747e;
    private Map<String, C0117a> f;
    private Map<String, C0117a> g;
    private Map<String, C0117a> h;
    private y<h> i;
    private volatile long j;
    private Map<String, Map<String, C0117a>> k;
    private double l;
    private double m;

    /* JADX INFO: renamed from: com.bytedance.apm.perf.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BizTrafficStats.java */
    class C0117a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, Long> f4751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f4752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f4753d;

        public C0117a(a r3, String r4) {
            this.f4753d = r3;
            this.f4752c = 0;
            this.f4750a = r4;
            this.f4751b = new HashMap();
        }

        public void a(String r5, long r6) {
            if (this.f4751b.containsKey(r5) == false) goto L5;
            Map<String, Long> r0 = this.f4751b;
            r0.put(r5, Long.valueOf(((Long) ZeusTransformUtils.preCheckCast(r0.get(r5), Long.class, "com.obric.aiagent.plugin")).longValue() + r6));
        L6:
            this.f4752c += r6;
            return;
        L5:
            this.f4751b.put(r5, Long.valueOf(r6));
            goto L6
        }

        public JSONObject a() {
            JSONObject r1 = new JSONObject();
            r1.put("biz", this.f4750a);     // Catch: JSONException -> L13
            r1.put("usage", this.f4752c);     // Catch: JSONException -> L13
            JSONArray r2 = new JSONArray();     // Catch: JSONException -> L13
            Map<String, Long> r3 = this.f4751b;     // Catch: JSONException -> L13
            if (r3 != null) goto L6;
        L11:
            r1.put("detail", r2);     // Catch: JSONException -> L13
            goto L12
        L6:
            if (r3.size() <= 0) goto L11;
            Iterator<Map.Entry<String, Long>> r7 = this.f4751b.entrySet().iterator();     // Catch: JSONException -> L13
        L9:
            if (r7.hasNext() == false) goto L11;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L13
            JSONObject r5 = new JSONObject();     // Catch: JSONException -> L13
            r5.put("source_id", r4.getKey());     // Catch: JSONException -> L13
            r5.put("usage", r4.getValue());     // Catch: JSONException -> L13
            r2.put(r5);     // Catch: JSONException -> L13
        L12:
            return r1;
        }

        public JSONObject a(long r9) {
            JSONObject r2 = new JSONObject();
            r2.put("biz", this.f4750a);     // Catch: JSONException -> L15
            r2.put("usage", this.f4752c);     // Catch: JSONException -> L15
            JSONArray r3 = new JSONArray();     // Catch: JSONException -> L15
            Map<String, Long> r4 = this.f4751b;     // Catch: JSONException -> L15
            if (r4 != null) goto L6;
        L13:
            r2.put("detail", r3);     // Catch: JSONException -> L15
            goto L14
        L6:
            if (r4.size() <= 0) goto L13;
            Iterator<Map.Entry<String, Long>> r8 = this.f4751b.entrySet().iterator();     // Catch: JSONException -> L15
        L9:
            if (r8.hasNext() == false) goto L13;
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L15
            if (((Long) ZeusTransformUtils.preCheckCast(r5.getValue(), Long.class, "com.obric.aiagent.plugin")).longValue() < r9) goto L9;
            JSONObject r6 = new JSONObject();     // Catch: JSONException -> L15
            r6.put("source_id", r5.getKey());     // Catch: JSONException -> L15
            r6.put("usage", r5.getValue());     // Catch: JSONException -> L15
            r3.put(r6);     // Catch: JSONException -> L15
        L14:
            return r2;
        }
    }

    /* JADX INFO: compiled from: BizTrafficStats.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f4754a = null;

        static /* synthetic */ a a() {
            return f4754a;
        }

        static {
            f4754a = new a(null);
        }
    }

    @Deprecated
    public void a(JSONObject r1) {
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.f4743a;
    }

    public static a a() {
        return b.a();
    }

    private a() {
        this.j = 0;
        this.l = 102400.0d;
        this.m = 102400.0d;
    }

    public void b() {
        a(true);
        b(true);
        l();
        m();
    }

    private void a(boolean r1) {
        this.f4743a = r1;
    }

    private void b(boolean r1) {
        this.f4744b = r1;
        com.bytedance.apm.h.a.a(r1);
    }

    private void l() {
        com.bytedance.apm.d.a.d.c().a(new AnonymousClass1(this));
    }

    private void m() {
        com.bytedance.apm.d.a.a.c().a(new AnonymousClass2(this));
    }

    public void a(double r1) {
        this.l = r1;
    }

    public void b(double r1) {
        this.m = r1;
    }

    public void a(String r2) {
        if (this.k != null) goto L5;
        this.k = new HashMap();
    L5:
        this.k.put(r2, new HashMap());
    }

    private void a(String r6, long r7, String r9) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        boolean r0 = m.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        boolean r2 = false;
        com.bytedance.apm6.service.d.a r3 = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class), com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        r2 = r3.isForeground();
    L9:
        if (this.f4745c != null) goto L12;
        this.f4745c = new HashMap();
    L12:
        if (this.f4746d != null) goto L15;
        this.f4746d = new HashMap();
    L15:
        if (this.f4747e != null) goto L18;
        this.f4747e = new HashMap();
    L18:
        if (this.f != null) goto L21;
        this.f = new HashMap();
    L21:
        if (this.g != null) goto L24;
        this.g = new HashMap();
    L24:
        if (this.f4745c.containsKey(r6) == false) goto L26;
        ((C0117a) ZeusTransformUtils.preCheckCast(this.f4745c.get(r6), C0117a.class, "com.obric.aiagent.plugin")).a(r9, r7);
    L27:
        if (r0 == false) goto L33;
        if (r2 == true) goto L33;
        if (this.f4746d.containsKey(r6) == false) goto L32;
        ((C0117a) ZeusTransformUtils.preCheckCast(this.f4746d.get(r6), C0117a.class, "com.obric.aiagent.plugin")).a(r9, r7);
        goto L33
    L32:
        C0117a r4 = new C0117a(this, r6);
        r4.a(r9, r7);
        this.f4746d.put(r6, r4);
    L33:
        if (r0 == false) goto L39;
        if (r2 == false) goto L39;
        if (this.f4747e.containsKey(r6) == false) goto L38;
        ((C0117a) ZeusTransformUtils.preCheckCast(this.f4747e.get(r6), C0117a.class, "com.obric.aiagent.plugin")).a(r9, r7);
        goto L39
    L38:
        C0117a r5 = new C0117a(this, r6);
        r5.a(r9, r7);
        this.f4747e.put(r6, r5);
    L39:
        if (r0 == true) goto L45;
        if (r2 == true) goto L45;
        if (this.f.containsKey(r6) == false) goto L44;
        ((C0117a) ZeusTransformUtils.preCheckCast(this.f.get(r6), C0117a.class, "com.obric.aiagent.plugin")).a(r9, r7);
        goto L45
    L44:
        C0117a r8 = new C0117a(this, r6);
        r8.a(r9, r7);
        this.f.put(r6, r8);
    L45:
        if (r0 == true) goto L52;
        if (r2 == false) goto L52;
        if (this.g.containsKey(r6) == false) goto L50;
        ((C0117a) ZeusTransformUtils.preCheckCast(this.g.get(r6), C0117a.class, "com.obric.aiagent.plugin")).a(r9, r7);
        goto L52
    L50:
        C0117a r1 = new C0117a(this, r6);
        r1.a(r9, r7);
        this.g.put(r6, r1);
    L52:
        if (this.h != null) goto L55;
        this.h = new HashMap();
    L55:
        if (this.h.containsKey(r6) == false) goto L57;
        ((C0117a) ZeusTransformUtils.preCheckCast(this.h.get(r6), C0117a.class, "com.obric.aiagent.plugin")).a(r9, r7);
    L58:
        Map<String, Map<String, C0117a>> r10 = this.k;
        if (r10 == null) goto L67;
        Iterator<Map.Entry<String, Map<String, C0117a>>> r11 = r10.entrySet().iterator();
    L62:
        if (r11.hasNext() == false) goto L74;
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), Map.class, "com.obric.aiagent.plugin");
        if (r12.containsKey(r6) == true) goto L65;
        C0117a r13 = new C0117a(this, r6);
        r13.a(r9, r7);
        r12.put(r6, r13);
        goto L62
    L65:
        ((C0117a) ZeusTransformUtils.preCheckCast(r12.get(r6), C0117a.class, "com.obric.aiagent.plugin")).a(r9, r7);
        goto L62
    L74:
        return;
    L67:
        return;
    L57:
        C0117a r14 = new C0117a(this, r6);
        r14.a(r9, r7);
        this.h.put(r6, r14);
        goto L58
    L26:
        C0117a r15 = new C0117a(this, r6);
        r15.a(r9, r7);
        this.f4745c.put(r6, r15);
        goto L27
    }

    public Map<String, C0117a> c() {
        return this.h;
    }

    public void a(String r10, JSONObject r11) {
        if (this.f4743a == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L39;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.length() == 0) goto L41;
        String r1 = new URL(r10).getPath();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r1) == false) goto L14;
        return;
    L14:
        String r2 = r11.optString("net_consume_type", "ttnet");     // Catch: Throwable -> L34
        JSONObject r3 = r11.optJSONObject(MonitorConstants.REQUEST_LOG);     // Catch: Throwable -> L34
        if (r3 != null) goto L19;
        String r12 = r11.optString(MonitorConstants.REQUEST_LOG);     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r12) == true) goto L19;
        r3 = new JSONObject(r12);     // Catch: Throwable -> L34
    L19:
        JSONObject r13 = r3.optJSONObject("response");     // Catch: Throwable -> L34
        long r4 = 0;
        if (r13 == null) goto L22;
        r4 = r13.optLong("received_bytes") + r13.optLong("sent_bytes");     // Catch: Throwable -> L34
    L22:
        this.j += r4;     // Catch: Throwable -> L34
        if (r4 > this.l) goto L25;
    L28:
        if (TextUtils.isEmpty(r10) == false) goto L37;
    L31:
        a(r2, r4, r10);
        c.a().a(r4, r1, r2);
        return;
    L37:
        r10 = Uri.parse(r10).buildUpon().clearQuery().build().toString();     // Catch: Exception -> L33
        goto L31
    L25:
        if (this.i != null) goto L27;
        this.i = new y(30);     // Catch: Throwable -> L34
    L27:
        this.i.a(new h(r1, r4, r2));     // Catch: Throwable -> L34
    L42:
        return;
    L41:
        return;
    }

    public y<h> d() {
        return this.i;
    }

    public Map<String, C0117a> e() {
        return this.f4745c;
    }

    public Map<String, C0117a> f() {
        return this.f;
    }

    public Map<String, C0117a> g() {
        return this.g;
    }

    public Map<String, C0117a> h() {
        return this.f4747e;
    }

    public Map<String, C0117a> i() {
        return this.f4746d;
    }

    public long j() {
        return this.j;
    }

    public void k() {
        Map<String, C0117a> r0 = this.f4745c;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Map<String, C0117a> r1 = this.f4746d;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        Map<String, C0117a> r2 = this.f4747e;
        if (r2 == null) goto L11;
        r2.clear();
    L11:
        Map<String, C0117a> r3 = this.f;
        if (r3 == null) goto L14;
        r3.clear();
    L14:
        Map<String, C0117a> r4 = this.g;
        if (r4 == null) goto L17;
        r4.clear();
    L17:
        y<h> r5 = this.i;
        if (r5 == null) goto L20;
        r5.c();
    L20:
        this.j = 0;
    }
}
