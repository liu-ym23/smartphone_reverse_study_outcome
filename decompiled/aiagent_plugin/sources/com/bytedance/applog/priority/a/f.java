package com.bytedance.applog.priority.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.o;
import d.h.b.p;
import d.n.m;
import d.t;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: compiled from: Group.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.priority.a.c f5862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicLong f5863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f5865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h.d f5866e;
    private AtomicBoolean f;

    /* JADX INFO: compiled from: Group.kt */
    static final class a extends p implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f5867a;

        a(Set r3) {
            this.f5867a = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return Boolean.valueOf(a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin")));
        }

        public final boolean a(String r1) {
            return this.f5867a.contains(r1);
        }
    }

    /* JADX INFO: compiled from: Group.kt */
    static final class b extends p implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f5868a;

        b(Set r3) {
            this.f5868a = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return Boolean.valueOf(a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin")));
        }

        public final boolean a(String r1) {
            return this.f5868a.contains(r1);
        }
    }

    /* JADX INFO: compiled from: Group.kt */
    static final class c extends p implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f5869a;

        c(Set r3) {
            this.f5869a = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return Boolean.valueOf(a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin")));
        }

        public final boolean a(String r1) {
            return this.f5869a.contains(r1);
        }
    }

    public f(String r2, h.d r3, com.bytedance.applog.priority.a.b r4, AtomicBoolean r5) {
        o.d(r2, "dbName");
        o.d(r3, "config");
        o.d(r4, "dbConfig");
        o.d(r5, "workable");
        this.f5866e = r3;
        this.f = r5;
        this.f5862a = com.bytedance.applog.priority.a.c.f5848a.a(r2, r4);
        this.f5863b = new AtomicLong(0);
    }

    public final h.d e() {
        return this.f5866e;
    }

    public /* synthetic */ f(String r1, h.d r2, com.bytedance.applog.priority.a.b r3, AtomicBoolean r4, int r5, d.h.b.h r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = new AtomicBoolean(true);
    L5:
        this(r1, r2, r3, r4);
    }

    public final AtomicBoolean f() {
        return this.f;
    }

    public final boolean a() {
        boolean r1 = true;
        if (this.f5866e.c() > 0) goto L6;
        return true;
    L6:
        if (this.f5865d <= System.currentTimeMillis()) goto L9;
        r1 = false;
    L9:
        if (r1 == false) goto L11;
        long r2 = System.currentTimeMillis();
        this.f5864c = r2;
        this.f5865d = r2 + ((long) (this.f5866e.c() * 1000));
    L11:
        return r1;
    }

    public final void b() {
        this.f5865d = 0;
    }

    public final boolean c() {
        return this.f5862a.b();
    }

    public final h.a a(h.b r14, JSONObject r15) {
        o.d(r14, "eventType");
        o.d(r15, "json");
        String r0 = r15.toString();
        o.b(r0, "json.toString()");
        Charset r2 = d.o.d.f38623b;
        if (r0 == null) goto L36;
        byte[] r3 = r0.getBytes(r2);
        o.b(r3, "(this as java.lang.String).getBytes(charset)");
        if (this.f5866e.e().d() >= r3.length) goto L29;
        int r1 = g.f5870a[r14.ordinal()];
        if (r1 != 1) goto L9;
        JSONObject r4 = new JSONObject();
        r4.put("params_cleared_by_event_size_limit", r3.length);
        r4.put("max_event_size", this.f5866e.e().d());
        r15.put("params", r4);
    L28:
        r0 = r15.toString();
        o.b(r0, "json.toString()");
        goto L29
    L9:
        if (r1 != 2) goto L11;
        Set r5 = ax.a(new String[]{"tag", "label", "monitor_id", "event_stained"});
        Iterator<String> r6 = r15.keys();
        o.b(r6, "json.keys()");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(m.g(m.b(m.a(r6), (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r5), d.h.a.b.class, "com.obric.aiagent.plugin"))), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L24:
        if (r7.hasNext() == false) goto L26;
        r15.remove((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"));
        goto L24
    L26:
        r15.put("params_cleared_by_event_size_limit", r3.length);
        r15.put("max_event_size", this.f5866e.e().d());
        goto L28
    L11:
        if (r1 == 3) goto L17;
        Set r8 = ax.a(new String[]{"monitor_id", "event_stained"});
        Iterator<String> r9 = r15.keys();
        o.b(r9, "json.keys()");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(m.g(m.b(m.a(r9), (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r8), d.h.a.b.class, "com.obric.aiagent.plugin"))), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r10.hasNext() == false) goto L16;
        r15.remove((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin"));
        goto L14
    L16:
        r15.put("params_cleared_by_event_size_limit", r3.length);
        r15.put("max_event_size", this.f5866e.e().d());
        goto L28
    L17:
        Set r11 = ax.a(new String[]{"log_type", "monitor_id", "event_stained"});
        Iterator<String> r12 = r15.keys();
        o.b(r12, "json.keys()");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(m.g(m.b(m.a(r12), (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r11), d.h.a.b.class, "com.obric.aiagent.plugin"))), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        r15.remove((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin"));
        goto L19
    L21:
        r15.put("params_cleared_by_event_size_limit", r3.length);
        r15.put("max_event_size", this.f5866e.e().d());
    L29:
        int r16 = this.f5866e.a();
        long r17 = System.currentTimeMillis();
        long r18 = this.f5863b.getAndIncrement();
        Charset r19 = d.o.d.f38623b;
        if (r0 == null) goto L34;
        byte[] r110 = r0.getBytes(r19);
        o.b(r110, "(this as java.lang.String).getBytes(charset)");
        h.a r111 = new h.a(r16, r17, r18, r14, r110.length);
        this.f5862a.insert(r111, r0);
        return r111;
    L34:
        throw new t("null cannot be cast to non-null type java.lang.String");
    L36:
        throw new t("null cannot be cast to non-null type java.lang.String");
    }

    public final Map<h.a, JSONObject> a(long r7, int r9, long r10) {
        return (Map) ZeusTransformUtils.preCheckCast(this.f5862a.a(r7, r9, r10), Map.class, "com.obric.aiagent.plugin");
    }

    public final void a(List<h.a> r3) {
        List<h.a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.d(r4, "keys");
        this.f5862a.a(r4);
    }

    public final int d() {
        return this.f5862a.a();
    }

    public final boolean a(h.b r7, String r8, JSONObject r9) {
        o.d(r7, "eventType");
        o.d(r8, "event");
        if (this.f5866e.g().contains(r7.a()) == true) goto L6;
        return false;
    L6:
        if (this.f5866e.f() != null) goto L9;
        return true;
    L9:
        if (h.b.f5876a == r7) goto L12;
        return false;
    L12:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f5866e.f().a(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L14;
    L16:
        if (r9 != null) goto L19;
        return false;
    L19:
        if ((!((Map) ZeusTransformUtils.preCheckCast(this.f5866e.f().b(), Map.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L51;
        List r10 = (List) ZeusTransformUtils.preCheckCast(this.f5866e.f().b().get(r8), List.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L35;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L25;
    L27:
        Iterator r12 = r11.iterator();
    L29:
        if (r12.hasNext() == false) goto L26;
        if (a(r9, (List) ZeusTransformUtils.preCheckCast(r12.next(), List.class, "com.obric.aiagent.plugin")) == false) goto L29;
        boolean r13 = true;
    L33:
        if (r13 == false) goto L35;
        return true;
    L26:
        r13 = false;
        goto L33
    L25:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L27;
    L35:
        List r14 = (List) ZeusTransformUtils.preCheckCast(this.f5866e.f().b().get("*"), List.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L51;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L40;
    L42:
        Iterator r16 = r15.iterator();
    L44:
        if (r16.hasNext() == false) goto L41;
        if (a(r9, (List) ZeusTransformUtils.preCheckCast(r16.next(), List.class, "com.obric.aiagent.plugin")) == false) goto L44;
        boolean r17 = true;
    L48:
        if (r17 == false) goto L51;
        return true;
    L41:
        r17 = false;
        goto L48
    L40:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L42;
    L51:
        if ((!((Map) ZeusTransformUtils.preCheckCast(this.f5866e.f().c(), Map.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L82;
        List r18 = (List) ZeusTransformUtils.preCheckCast(this.f5866e.f().c().get(r8), List.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L67;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r19, Collection.class) == true) goto L57;
    L59:
        Iterator r20 = r19.iterator();
    L61:
        if (r20.hasNext() == false) goto L58;
        if (a(r9, (HashMap) ZeusTransformUtils.preCheckCast(r20.next(), HashMap.class, "com.obric.aiagent.plugin")) == false) goto L61;
        boolean r21 = true;
    L65:
        if (r21 == false) goto L67;
        return true;
    L58:
        r21 = false;
        goto L65
    L57:
        if (((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L59;
    L67:
        List r22 = (List) ZeusTransformUtils.preCheckCast(this.f5866e.f().c().get("*"), List.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L82;
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r23, Collection.class) == true) goto L72;
    L74:
        Iterator r24 = r23.iterator();
    L76:
        if (r24.hasNext() == false) goto L73;
        if (a(r9, (HashMap) ZeusTransformUtils.preCheckCast(r24.next(), HashMap.class, "com.obric.aiagent.plugin")) == false) goto L76;
        boolean r6 = true;
    L80:
        if (r6 == false) goto L82;
        return true;
    L73:
        r6 = false;
        goto L80
    L72:
        if (((Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L74;
    L82:
        return false;
    L14:
        if (this.f5866e.f().a().contains(r8) == false) goto L16;
        return true;
    }

    private final boolean a(JSONObject r3, List<String> r4) {
        Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (r3.has((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin")) == true) goto L4;
        return false;
    L9:
        return true;
    }

    private final boolean a(JSONObject r5, HashMap<String, String> r6) {
        Iterator<Map.Entry<String, String>> r4 = r6.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L15;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.aiagent.plugin");
        if (o.a(r5.optString(r1), r8) == true) goto L4;
        Object r2 = r5.opt(r1);
        if (r2 == null) goto L10;
        String r3 = r2.toString();
    L12:
        if ((!o.a(r3, r8)) == false) goto L4;
        return false;
    L10:
        r3 = null;
        goto L12
    L15:
        return true;
    }

    public String toString() {
        return "Group-" + this.f5866e.a() + '-' + this.f5866e.c() + 's';
    }
}
