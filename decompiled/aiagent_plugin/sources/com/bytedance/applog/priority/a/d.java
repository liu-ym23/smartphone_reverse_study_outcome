package com.bytedance.applog.priority.a;

import android.content.Context;
import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.applog.priority.PriorityHttpResponse;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.q;
import d.h.b.o;
import d.l.n;
import d.t;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Engine.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5853a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<h.EnumC0139h, j> f5854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h.c f5855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.applog.priority.a.b f5856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h.j f5857e;
    private h.j f;
    private h.j g;
    private final Context h;
    private final String i;
    private final PriorityCallback j;
    private final String k;
    private final String l;

    /* JADX INFO: compiled from: Engine.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public final d a(Context r8, String r9, PriorityCallback r10, String r11, String r12) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            PriorityCallback r4 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r10, PriorityCallback.class, "com.obric.aiagent.plugin");
            o.d(r2, "ctx");
            o.d(r9, "appId");
            o.d(r4, "callback");
            o.d(r11, "defaultReportHost");
            o.d(r12, "defaultReportPath");
            r4.printLog(2, "priority engine create with app id: " + r9 + "...");
            return new d(r2, r9, r4, r11, r12);
        }
    }

    /* JADX INFO: compiled from: Engine.kt */
    static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f5858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.applog.priority.a.c f5859b;

        b(d r1, com.bytedance.applog.priority.a.c r2) {
            this.f5858a = r1;
            this.f5859b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HashMap<h.a, JSONObject> r0 = this.f5859b.a(3145728, DownloadErrorCode.ERROR_CRONET_ERROR_BASE, 604800000);
            this.f5858a.d().printLog(2, this.f5858a + " handle missed group: " + this.f5859b + " with " + r0.size() + " events...");
            if (r0.isEmpty() == false) goto L6;
            d.a(this.f5858a).a(this.f5859b.c(), 0);
            return;
        L6:
            JSONArray r1 = new JSONArray();
            JSONArray r4 = new JSONArray();
            JSONArray r5 = new JSONArray();
            Iterator r6 = ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
        L8:
            if (r6.hasNext() == false) goto L18;
            Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            h.a r10 = (h.a) ZeusTransformUtils.preCheckCast(r8.getKey(), h.a.class, "com.obric.aiagent.plugin");
            JSONObject r9 = (JSONObject) ZeusTransformUtils.preCheckCast(r8.getValue(), JSONObject.class, "com.obric.aiagent.plugin");
            int r11 = e.f5861a[r10.b().ordinal()];
            if (r11 != 1) goto L11;
            r1.put(r9);
            goto L8
        L11:
            if (r11 != 2) goto L13;
            r4.put(r9);
            goto L8
        L13:
            if (r11 != 3) goto L8;
            r5.put(r9);
            goto L8
        L18:
            JSONObject r7 = new JSONObject();
            r7.put("header", d.a(this.f5858a, 10));
            if (r1.length() <= 0) goto L22;
            r7.put("event_v3", r1);
        L22:
            if (r4.length() <= 0) goto L25;
            r7.put("event", r4);
        L25:
            if (r5.length() <= 0) goto L27;
            r7.put("log_data", r5);
        L27:
            this.f5858a.d().printLog(2, this.f5858a + ' ' + this.f5859b + " post log with " + r1.length() + " v3、" + r4.length() + " v1、" + r5.length() + " log_data...");
            this.f5858a.d().monitorIncreaseStats("REPORT_REQUEST_COUNT", 1);
            this.f5858a.d().monitorIncreaseStats("REPORT_REQUEST_MISS_GROUP_COUNT", 1);
            String r2 = d.b(this.f5858a) + d.c(this.f5858a);
            PriorityCallback r12 = this.f5858a.d();
            String r13 = r7.toString();
            o.b(r13, "packJson.toString()");
            Charset r14 = d.o.d.f38623b;
            if (r13 == null) goto L37;
            byte[] r15 = r13.getBytes(r14);
            o.b(r15, "(this as java.lang.String).getBytes(charset)");
            PriorityHttpResponse r3 = r12.doHttpPost(r2, r15);
            o.b(r3, "response");
            int r16 = r3.getCode();
            if (200 > r16) goto L34;
            if (299 < r16) goto L34;
            this.f5858a.d().printLog(2, this.f5858a + ' ' + this.f5859b + " upload " + r0.size() + " events success and deleted locally, remaining " + this.f5859b.a() + " events.");
            com.bytedance.applog.priority.a.c r17 = this.f5859b;
            Set<h.a> r18 = r0.keySet();
            o.b(r18, "events.keys");
            r17.a(p.o((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")));
            com.bytedance.applog.priority.a.a.a(this.f5858a.d(), "3F", (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"), h.EnumC0139h.f5906c, 0);
            this.f5858a.d().monitorIncreaseStats("priority_request_success_cnt", 1);
            return;
        L34:
            this.f5858a.d().printLog(2, this.f5858a + ' ' + this.f5859b + " upload " + r0.size() + " events failed for response is " + r3 + '.');
            com.bytedance.applog.priority.a.a.a(this.f5858a.d(), "3B", (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"), h.EnumC0139h.f5906c, 0);
            this.f5858a.d().monitorIncreaseStats("priority_request_failed_cnt", 1);
            return;
        L37:
            throw new t("null cannot be cast to non-null type java.lang.String");
        }
    }

    /* JADX INFO: compiled from: Engine.kt */
    static final class c extends d.h.b.p implements q<JSONObject, JSONObject, String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f5860a;

        c(d r1) {
            this.f5860a = r1;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ Boolean invoke(JSONObject r3, JSONObject r4, String r5) {
            return Boolean.valueOf(a((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.aiagent.plugin"), (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin")));
        }

        public final boolean a(JSONObject r4, JSONObject r5, String r6) {
            o.d(r4, "newJson");
            o.d(r5, "finalJson");
            o.d(r6, "key");
            JSONObject r3 = r4.optJSONObject(r6);
            if (r3 == null) goto L12;
            JSONObject r7 = r5.optJSONObject(r6);
            if (r7 != null) goto L7;
            r5.put(r6, r3);
            return true;
        L7:
            if (h.j.f5934a.a(r3).a(h.j.f5934a.a(r7)) == false) goto L14;
            r5.put(r6, r3);
            return true;
        L14:
            return false;
        L12:
            return false;
        }
    }

    static {
        f5853a = new a(null);
    }

    public d(Context r3, String r4, PriorityCallback r5, String r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        PriorityCallback r9 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r5, PriorityCallback.class, "com.obric.aiagent.plugin");
        o.d(r8, "context");
        o.d(r4, "appId");
        o.d(r9, "callback");
        o.d(r6, "defaultReportHost");
        o.d(r7, "defaultReportPath");
        this.h = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.i = r4;
        this.j = r9;
        this.k = r6;
        this.l = r7;
        this.f5854b = new ConcurrentHashMap(3);
        this.f5855c = new h.c(new CopyOnWriteArrayList());
        this.f5856d = new com.bytedance.applog.priority.a.b(r4);
    }

    public static final /* synthetic */ com.bytedance.applog.priority.a.b a(d r0) {
        return r0.f5856d;
    }

    public static final /* synthetic */ JSONObject a(d r0, int r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ String b(d r0) {
        return r0.k;
    }

    public static final /* synthetic */ String c(d r0) {
        return r0.l;
    }

    public final Context getContext() {
        return this.h;
    }

    public final PriorityCallback d() {
        return this.j;
    }

    public final void a() {
        JSONObject r0 = this.f5856d.a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() != 0) goto L7;
        return;
    L7:
        a(r0);
    }

    public final synchronized void a(JSONObject r44) {
        monitor-enter(this);
        o.d(r44, "configJson");     // Catch: Throwable -> L54
        this.j.printLog(2, this + " init with config: " + r44 + "...");     // Catch: Throwable -> L54
        JSONObject r1 = r44.optJSONObject("backoff_priority_list");     // Catch: Throwable -> L54
        if (r1 != null) goto L8;
        r1 = new JSONObject();     // Catch: Throwable -> L54
    L8:
        h.i.b r12 = new h.i.b(r1);     // Catch: Throwable -> L54
        this.f5857e = r12.a();     // Catch: Throwable -> L54
        JSONObject r2 = r44.optJSONObject("event_priority_config");     // Catch: Throwable -> L54
        if (r2 != null) goto L12;
        r2 = new JSONObject();     // Catch: Throwable -> L54
    L12:
        h.i.f r10 = new h.i.f(r2);     // Catch: Throwable -> L54
        this.f = r10.a();     // Catch: Throwable -> L54
        JSONObject r0 = r44.optJSONObject("group_priority_list");     // Catch: Throwable -> L54
        if (r0 != null) goto L16;
        r0 = new JSONObject();     // Catch: Throwable -> L54
    L16:
        h.i.e r11 = new h.i.e(r0, this.k, this.l);     // Catch: Throwable -> L54
        this.g = r11.a();     // Catch: Throwable -> L54
        h.g r3 = new h.g(this, r10.a(), h.EnumC0139h.f5904a, r10.b().a().a(), r10.b().a().b(), r10.b().a().c(), r10.b().a().d(), this.j);     // Catch: Throwable -> L54
        h.g r17 = new h.g(this, r10.a(), h.EnumC0139h.f5905b, r10.b().b().a(), r10.b().b().b(), r10.b().b().c(), r10.b().b().d(), this.j);     // Catch: Throwable -> L54
        h.g r18 = new h.g(this, r10.a(), h.EnumC0139h.f5906c, r10.b().c().a(), r10.b().c().b(), r10.b().c().c(), r10.b().c().d(), this.j);     // Catch: Throwable -> L54
        CopyOnWriteArrayList r13 = new CopyOnWriteArrayList();     // Catch: Throwable -> L54
        List<f> r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        List<f> r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        List<f> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        Iterator<h.i.c> r19 = r11.b().iterator();     // Catch: Throwable -> L54
    L18:
        if (r19.hasNext() == false) goto L39;
        h.i.c r4 = (h.i.c) ZeusTransformUtils.preCheckCast(r19.next(), h.i.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        h.i.a r5 = (h.i.a) ZeusTransformUtils.preCheckCast(r12.d().get(Integer.valueOf(r4.a())), h.i.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        if (r5 == null) goto L27;
        if (r4.b() > 0) goto L24;
        boolean r22 = true;
    L25:
        h.e r25 = new h.e(r22, r12.a(), r5.a(), r5.b(), new AtomicInteger(0), new AtomicInteger(0), 0, 0);     // Catch: Throwable -> L54
    L31:
        String r30 = "applog_priority_origin@" + this.i + "_event_" + r4.f() + '_' + r4.a();     // Catch: Throwable -> L54
        String r29 = r4.c() + r4.d() + "?app_log_priority=" + r4.a();     // Catch: Throwable -> L54
        String r6 = r4.f();     // Catch: Throwable -> L54
        if (o.a(r6, h.EnumC0139h.f5904a.name()) == false) goto L34;
        List<f> r16 = r9;
        f r8 = new f(r30, new h.d(r4.a(), r11.a(), r4.b(), r25, r3, r4.g(), r4.e(), r29), this.f5856d, null, 8, null);     // Catch: Throwable -> L54
        r14.add(r8);     // Catch: Throwable -> L54
        r13.add(r8);     // Catch: Throwable -> L54
    L38:
        r9 = r16;
        goto L18
    L34:
        r16 = r9;
        if (o.a(r6, h.EnumC0139h.f5905b.name()) == false) goto L37;
        f r7 = new f(r30, new h.d(r4.a(), r11.a(), r4.b(), r25, r17, r4.g(), r4.e(), r29), this.f5856d, null, 8, null);     // Catch: Throwable -> L54
        r15.add(r7);     // Catch: Throwable -> L54
        r13.add(r7);     // Catch: Throwable -> L54
        goto L38
    L37:
        f r20 = new f(r30, new h.d(r4.a(), r11.a(), r4.b(), r25, r18, r4.g(), r4.e(), r29), this.f5856d, null, 8, null);     // Catch: Throwable -> L54
        r16.add(r20);     // Catch: Throwable -> L54
        r13.add(r20);     // Catch: Throwable -> L54
        goto L38
    L24:
        r22 = false;
        goto L25
    L27:
        if (r4.b() > 0) goto L29;
        boolean r33 = true;
    L30:
        r25 = new h.e(r33, r12.a(), r12.b(), r12.c(), new AtomicInteger(0), new AtomicInteger(0), 0, 0);     // Catch: Throwable -> L54
        goto L31
    L29:
        r33 = false;
        goto L30
    L39:
        List<f> r110 = r9;
        j r21 = (j) ZeusTransformUtils.preCheckCast(this.f5854b.get(h.EnumC0139h.f5904a), j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        if (r21 == null) goto L42;
        r21.a(this.j, r14);     // Catch: Throwable -> L54
    L43:
        j r23 = (j) ZeusTransformUtils.preCheckCast(this.f5854b.get(h.EnumC0139h.f5905b), j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        if (r23 == null) goto L46;
        r23.a(this.j, r15);     // Catch: Throwable -> L54
    L47:
        j r24 = (j) ZeusTransformUtils.preCheckCast(this.f5854b.get(h.EnumC0139h.f5906c), j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        if (r24 == null) goto L50;
        r24.a(this.j, r110);     // Catch: Throwable -> L54
    L51:
        this.j.printLog(2, this + " init success!");     // Catch: Throwable -> L54
        this.f5855c = new h.c(r13);     // Catch: Throwable -> L54
        e();     // Catch: Throwable -> L54
        monitor-exit(this);
        return;
    L50:
        d r26 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        ((Map) ZeusTransformUtils.preCheckCast(r26.f5854b, Map.class, "com.obric.aiagent.plugin")).put(h.EnumC0139h.f5906c, new j(h.EnumC0139h.f5906c, r26.j, r110));     // Catch: Throwable -> L54
        goto L51
    L46:
        d r27 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        ((Map) ZeusTransformUtils.preCheckCast(r27.f5854b, Map.class, "com.obric.aiagent.plugin")).put(h.EnumC0139h.f5905b, new j(h.EnumC0139h.f5905b, r27.j, r15));     // Catch: Throwable -> L54
        goto L47
    L42:
        d r28 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        ((Map) ZeusTransformUtils.preCheckCast(r28.f5854b, Map.class, "com.obric.aiagent.plugin")).put(h.EnumC0139h.f5904a, new j(h.EnumC0139h.f5904a, r28.j, r14));     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;
    }

    public final void b(JSONObject r8) {
        o.d(r8, "json");
        boolean r4 = false;
        if (r8.has("backoff_priority_list") == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        return;
    L13:
        c r2 = new c(this);
        JSONObject r6 = this.f5856d.a();
        if (r6 != null) goto L18;
        r6 = new JSONObject();
    L18:
        if (r2.a(r8, r6, "backoff_priority_list") == true) goto L20;
        boolean r0 = false;
    L22:
        if (r2.a(r8, r6, "event_priority_config") == true) goto L26;
        if (r0 == true) goto L26;
        boolean r3 = false;
    L28:
        if (r2.a(r8, r6, "group_priority_list") == true) goto L30;
        if (r3 == true) goto L30;
    L31:
        if (r4 == true) goto L34;
        this.j.printLog(2, this + " upgrade broken for same config!");
        return;
    L34:
        com.bytedance.applog.priority.a.b r9 = this.f5856d;
        String r5 = r6.toString();
        o.b(r5, "finalJson.toString()");
        r9.a(r5);
        a(r6);
        return;
    L30:
        r4 = true;
    L26:
        r3 = true;
        goto L28
    L20:
        r0 = true;
        goto L22
    L5:
        if (r8.has("event_priority_config") == true) goto L10;
        if (r8.has("group_priority_list") == true) goto L10;
        r1 = false;
        goto L11
    }

    public final boolean a(int r11, JSONObject r12) {
        o.d(r12, "json");
        this.j.printLog(2, this + " onEvent: " + r11 + " -> " + r12);
        h.b r0 = h.b.i.a(r11);
        f r1 = this.f5855c.a(r0, r12);
        if (r1 == null) goto L6;
        com.bytedance.applog.priority.a.a.a(this.j, "2A", r11, r12, r1.e().e().c(), r1.e().a());
        this.j.printLog(2, this + ' ' + r1 + " priority event: " + r1.a(r0, r12) + " inserted!");
        com.bytedance.applog.priority.a.a.a(this.j, "2F", r11, r12, r1.e().e().c(), r1.e().a());
        return true;
    L6:
        return false;
    }

    public final void b() {
        Iterator<j> r3 = this.f5854b.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((j) ZeusTransformUtils.preCheckCast(r3.next(), j.class, "com.obric.aiagent.plugin")).a();
        goto L4
    }

    private final void e() {
        List<String> r0 = this.f5856d.b();
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator<String> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L34;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        boolean r5 = true;
        int r4 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), "_", 0, false, 6, null) + 1;
        if (r3 == null) goto L32;
        String r6 = r3.substring(r4);
        o.b(r6, "(this as java.lang.String).substring(startIndex)");
        Integer r7 = d.o.o.d(r6);
        if (r7 == null) goto L10;
        int r8 = r7.intValue();
    L11:
        if (r8 < 0) goto L4;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(this.f5855c.a(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L16;
    L18:
        Iterator r10 = r9.iterator();
    L20:
        if (r10.hasNext() == false) goto L17;
        if (((f) ZeusTransformUtils.preCheckCast(r10.next(), f.class, "com.obric.aiagent.plugin")).e().a() != r8) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == false) goto L20;
    L26:
        if (r5 == true) goto L4;
        r1.add(com.bytedance.applog.priority.a.c.f5848a.a(r3, this.f5856d));
        if (r1.size() < 10) goto L4;
    L24:
        r11 = false;
    L17:
        r5 = false;
        goto L26
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L18;
    L10:
        r8 = -1;
        goto L11
    L32:
        throw new t("null cannot be cast to non-null type java.lang.String");
    L34:
        if (r1.isEmpty() == false) goto L36;
        return;
    L36:
        this.j.printLog(2, "start to handle " + r1.size() + " missed groups...");
        ExecutorService r12 = Executors.newFixedThreadPool(n.d(r1.size(), 3));
        Iterator r13 = r1.iterator();
    L38:
        if (r13.hasNext() == false) goto L40;
        r12.submit((Runnable) ZeusTransformUtils.preCheckCast(new b(this, (com.bytedance.applog.priority.a.c) ZeusTransformUtils.preCheckCast(r13.next(), com.bytedance.applog.priority.a.c.class, "com.obric.aiagent.plugin")), Runnable.class, "com.obric.aiagent.plugin"));
        goto L38
    }

    public final JSONObject c() {
        if (this.f5857e == null) goto L5;
    L10:
        JSONObject r0 = new JSONObject();
        h.j r1 = this.f5857e;
        if (r1 == null) goto L13;
        r0.put("backoff_priority", r1.a());
    L13:
        h.j r2 = this.f;
        if (r2 == null) goto L16;
        r0.put("event_priority_config", r2.a());
    L16:
        h.j r3 = this.g;
        if (r3 == null) goto L19;
        r0.put("group_priority", r3.a());
    L19:
        return r0;
    L5:
        if (this.f != null) goto L10;
        if (this.g != null) goto L10;
        return null;
    }

    private final JSONObject a(int r5) {
        String r0 = this.j.getHeaderJson();
        if (r0 != null) goto L5;
    L12:
        if (r5 <= 0) goto L15;
        Thread.sleep(300);
        return a(r5 - 1);
    L15:
        return null;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        return new JSONObject(r0);
    L7:
        r2 = false;
        goto L8
    }

    public String toString() {
        return "Engine-" + this.i;
    }
}
