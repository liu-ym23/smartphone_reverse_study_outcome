package com.bytedance.applog.priority.a;

import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.applog.priority.PriorityHttpResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.l.n;
import d.t;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Worker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ScheduledFuture<?> f5939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h.EnumC0139h f5940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PriorityCallback f5941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<f> f5942e;

    public j(h.EnumC0139h r3, PriorityCallback r4, List<f> r5) {
        PriorityCallback r6 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r4, PriorityCallback.class, "com.obric.aiagent.plugin");
        List<f> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.d(r3, "priorityName");
        o.d(r6, "callback");
        o.d(r7, "groups");
        this.f5940c = r3;
        this.f5941d = r6;
        this.f5942e = r7;
        this.f5938a = a(r7);
        this.f5939b = b();
    }

    public final void a(PriorityCallback r6, List<f> r7) {
        PriorityCallback r8 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r6, PriorityCallback.class, "com.obric.aiagent.plugin");
        List<f> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.d(r8, "callback");
        o.d(r9, "groups");
        r8.printLog(2, this + " upgrade by " + r9.size() + " groups: " + r9 + "...");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f5942e, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) ZeusTransformUtils.preCheckCast(r0.next(), f.class, "com.obric.aiagent.plugin")).f().set(false);
        goto L4
    L6:
        this.f5942e = r9;
        this.f5941d = r8;
        this.f5938a = a(r9);
        this.f5939b.cancel(true);
        if (this.f5939b.isCancelled() == false) goto L10;
        r8.printLog(2, this + " scheduler stop success!");
    L10:
        if (r9.isEmpty() == false) goto L13;
        r8.printLog(2, this + " no scheduler for no group!!!");
        return;
    L13:
        this.f5939b = b();
        r8.printLog(2, this + " upgrade completed!");
    }

    public final void a() {
        this.f5941d.printLog(2, this + " start flush to run...");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f5942e, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) ZeusTransformUtils.preCheckCast(r0.next(), f.class, "com.obric.aiagent.plugin")).b();
        goto L4
    L6:
        this.f5939b.cancel(false);
        this.f5939b = b();
    }

    private final long a(List<f> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        int r0 = r8.size();
        if (r0 != 0) goto L5;
        return Long.MAX_VALUE;
    L5:
        if (r0 == 1) goto L14;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r8.subList(1, r8.size()), Iterable.class, "com.obric.aiagent.plugin");
        long r2 = ((f) ZeusTransformUtils.preCheckCast(r8.get(0), f.class, "com.obric.aiagent.plugin")).e().c();
        Iterator r9 = r1.iterator();
        if (r9.hasNext() == false) goto L12;
        long r6 = a(r2, ((f) ZeusTransformUtils.preCheckCast(r9.next(), f.class, "com.obric.aiagent.plugin")).e().c());
        if (r6 != 1) goto L11;
        return 1;
    L11:
        return r6;
    L12:
        return r2;
    L14:
        return n.a(1, ((f) ZeusTransformUtils.preCheckCast(r8.get(0), f.class, "com.obric.aiagent.plugin")).e().c());
    }

    private final long a(long r5, long r7) {
        long r4 = n.a(1, r5);
        long r6 = n.a(1, r7);
    L3:
        long r2 = r4;
        r4 = r6;
        if (r4 == 0) goto L6;
        r6 = r2 % r4;
        goto L3
    L6:
        return r2;
    }

    private final ScheduledFuture<?> b() {
        ScheduledFuture<?> r7 = Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"), 0, this.f5938a, TimeUnit.SECONDS);
        o.b(r7, "Executors.newSingleThrea…imeUnit.SECONDS\n        )");
        return r7;
    }

    @Override // java.lang.Runnable
    public void run() {
        int r3 = 2;
        this.f5941d.printLog(2, "================ " + this + " start run ===============");
        if (this.f5941d.isNetworkAvailable() == true) goto L6;
        this.f5941d.printLog(2, this + " run with no network, now will skip...");
        return;
    L6:
        JSONObject r0 = (JSONObject) ZeusTransformUtils.preCheckCast(null, JSONObject.class, "com.obric.aiagent.plugin");
        Iterator<f> r2 = this.f5942e.iterator();
    L8:
        if (r2.hasNext() == false) goto L83;
        f r5 = (f) ZeusTransformUtils.preCheckCast(r2.next(), f.class, "com.obric.aiagent.plugin");
        if (r5.a() == false) goto L82;
        if (r5.f().get() == false) goto L82;
        if (r5.c() == true) goto L82;
        char r12 = ' ';
        this.f5941d.printLog(r3, this + ' ' + r5 + " run ...");
        int r13 = r5.e().d().f();
        int r15 = 0;
    L17:
        if (r15 >= r13) goto L82;
        if (r5.f().get() == false) goto L82;
        if (r5.c() == true) goto L82;
        int r6 = k.f5943a[r5.e().d().a().ordinal()];
        if (r6 == 1) goto L30;
        if (r6 == r3) goto L29;
        if (r6 == 3) goto L28;
    L31:
        Map<h.a, JSONObject> r7 = r5.a(r5.e().e().e(), r5.e().e().f(), 1000 * r5.e().e().g());
        if (r7.isEmpty() == true) goto L33;
        this.f5941d.printLog(r3, this + r12 + r5 + " run with " + r7.size() + " events...");
        JSONArray r8 = new JSONArray();
        JSONArray r9 = new JSONArray();
        JSONArray r10 = new JSONArray();
        Iterator<Map.Entry<h.a, JSONObject>> r11 = r7.entrySet().iterator();
    L36:
        if (r11.hasNext() == false) goto L48;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        h.a r4 = (h.a) ZeusTransformUtils.preCheckCast(r14.getKey(), h.a.class, "com.obric.aiagent.plugin");
        JSONObject r16 = (JSONObject) ZeusTransformUtils.preCheckCast(r14.getValue(), JSONObject.class, "com.obric.aiagent.plugin");
        int r17 = k.f5944b[r4.b().ordinal()];
        if (r17 != 1) goto L40;
        r8.put(r16);
        goto L36
    L40:
        if (r17 != 2) goto L42;
        r9.put(r16);
        goto L36
    L42:
        if (r17 != 3) goto L36;
        r10.put(r16);
        goto L36
    L48:
        if (r0 != null) goto L68;
        String r1 = this.f5941d.getHeaderJson();
        if (r1 == null) goto L66;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L54;
        boolean r18 = true;
    L55:
        if (r18 == true) goto L66;
        JSONObject r19 = new JSONObject(r1);     // Catch: Exception -> L63
        if (r19.length() == 0) goto L60;
        r0 = r19;
        goto L68
    L60:
        this.f5941d.printLog(2, this + " run blocked by header is empty!");
        return;
    L63:
        e = move-exception;
        this.f5941d.monitorError("priority parse header error", e.toString());
        this.f5941d.printLog(2, this + " run blocked by header parse error!");
        return;
    L54:
        r18 = false;
    L66:
        this.f5941d.printLog(2, this + " run blocked by header is not ready!");
        return;
    L68:
        JSONObject r20 = new JSONObject();
        r20.put("header", r0);
        if (r8.length() <= 0) goto L72;
        r20.put("event_v3", r8);
    L72:
        if (r9.length() <= 0) goto L75;
        r20.put("event", r9);
    L75:
        if (r10.length() <= 0) goto L77;
        r20.put("log_data", r10);
    L77:
        JSONObject r110 = new JSONObject();
        r110.put("backoff_priority", r5.e().d().e().a(Integer.valueOf(r5.e().a())));
        r110.put("group_priority", r5.e().b().a(Integer.valueOf(r5.e().a())));
        r110.put("event_priority_config", r5.e().e().b().a(r5.e().e().c().name()));
        r20.put("options", r110);
        this.f5941d.printLog(2, this + ' ' + r5 + " post log with " + r8.length() + " v3、" + r9.length() + " v1、" + r10.length() + " log_data...");
        this.f5941d.monitorIncreaseStats("REPORT_REQUEST_COUNT", 1);
        PriorityCallback r21 = this.f5941d;
        String r22 = r5.e().h();
        String r23 = r20.toString();
        o.b(r23, "packJson.toString()");
        Charset r111 = d.o.d.f38623b;
        if (r23 == null) goto L81;
        byte[] r24 = r23.getBytes(r111);
        o.b(r24, "(this as java.lang.String).getBytes(charset)");
        PriorityHttpResponse r25 = r21.doHttpPost(r22, r24);
        o.b(r25, "response");
        a(r25, r5, r7);
        r15 = r15 + 1;
        r3 = 2;
        r12 = ' ';
        goto L17
    L81:
        throw new t("null cannot be cast to non-null type java.lang.String");
    L33:
        this.f5941d.printLog(r3, this + r12 + r5 + " run broken for no events");
        goto L82
    L28:
        this.f5941d.printLog(r3, this + r12 + r5 + " run blocked by frequency...");
        goto L82
    L29:
        this.f5941d.printLog(r3, this + r12 + r5 + " run blocked by backoff...");
        goto L82
    L30:
        this.f5941d.printLog(r3, this + r12 + r5 + " run allowed...");
    L82:
        r3 = r3;
        goto L8
    }

    private final void a(PriorityHttpResponse r9, f r10, Map<h.a, ? extends JSONObject> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        int r0 = r9.getCode();
        if (200 > r0) goto L18;
        if (299 < r0) goto L18;
        r10.e().d().d();
        this.f5941d.printLog(2, this + ' ' + r10 + " post log response success: " + r9);
        JSONObject r1 = new JSONObject(r9.getData());
        if (o.a(r1.optString("message"), "success") == true) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L16;
        r10.a(p.o((Iterable) ZeusTransformUtils.preCheckCast(r12.keySet(), Iterable.class, "com.obric.aiagent.plugin")));
        a.a(this.f5941d, "3F", r12, r10.e().e().c(), r10.e().a());
        this.f5941d.monitorIncreaseStats("priority_request_success_cnt", 1);
        this.f5941d.printLog(2, this + ' ' + r10 + ' ' + r12.keySet().size() + " events deleted, remaining " + r10.d() + " events.");
        r10.e().e().a().b(r1);
        return;
    L16:
        this.f5941d.monitorError("send priority log biz error", "response: " + r9);
        this.f5941d.printLog(2, this + ' ' + r10 + " post log response success but biz not ok!!!: " + r9);
    L28:
        a.a(this.f5941d, "3B", r12, r10.e().e().c(), r10.e().a());
        this.f5941d.monitorIncreaseStats("priority_request_failed_cnt", 1);
        return;
    L10:
        if (o.a(r1.optString("magic_tag"), "ss_app_log") == false) goto L12;
        r6 = true;
    L18:
        if (500 > r0) goto L23;
        if (599 < r0) goto L23;
        r10.e().d().b();
        this.f5941d.monitorError("send priority log 5xx error", "response: " + r9);
    L23:
        if (400 > r0) goto L27;
        if (499 < r0) goto L27;
        r10.e().d().c();
        this.f5941d.printLog(2, this + ' ' + r10 + " post log response is 4xx -> " + r9);
        this.f5941d.monitorError("send priority log 4xx error", "response: " + r9);
    L27:
        this.f5941d.printLog(2, this + ' ' + r10 + " post log response is unknown error -> " + r9);
        this.f5941d.monitorError("send priority log unknown error", "response: " + r9);
        goto L28
    }

    public String toString() {
        return "Worker-" + this.f5940c.name();
    }
}
