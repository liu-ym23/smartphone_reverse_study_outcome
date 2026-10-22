package com.obric.agent.trace.omni;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: OmniReportPersistence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    private static final String TAG = "OmniReportPersistence";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f15674a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f15675b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.f f15676c = null;

    /* JADX INFO: compiled from: OmniReportPersistence.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0319a f15677a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f15678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<String, List<b>> f15679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<Map<String, b>> f15680d;

        /* JADX INFO: renamed from: com.obric.agent.trace.omni.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OmniReportPersistence.kt */
        public static final class C0319a {
            public /* synthetic */ C0319a(d.h.b.h r1) {
                this();
            }

            private C0319a() {
            }

            public final a a(f r8, long r9) {
                d.h.b.o.e(r8, "bucket");
                Map r7 = (Map) ZeusTransformUtils.preCheckCast(r8.a(), Map.class, "com.obric.aiagent.plugin");
                Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r7.size())), Map.class, "com.obric.aiagent.plugin");
                Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
            L4:
                if (r10.hasNext() == false) goto L10;
                Object r2 = r10.next();
                Object r4 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.aiagent.plugin")).getKey();
                Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), Iterable.class, "com.obric.aiagent.plugin");
                Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
                Iterator r6 = r3.iterator();
            L7:
                if (r6.hasNext() == false) goto L9;
                Object r11 = r6.next();
                r5.add(b.f15681a.a(r11));
                goto L7
            L9:
                r0.put(r4, (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"));
                goto L4
            L10:
                Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r8.b(), Iterable.class, "com.obric.aiagent.plugin");
                Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r12, 10)), Collection.class, "com.obric.aiagent.plugin");
                Iterator r14 = r12.iterator();
            L12:
                if (r14.hasNext() == false) goto L19;
                Map<String, Object> r15 = ((e) ZeusTransformUtils.preCheckCast(r14.next(), e.class, "com.obric.aiagent.plugin")).a();
                Map r16 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r15.size())), Map.class, "com.obric.aiagent.plugin");
                Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r15.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
            L15:
                if (r17.hasNext() == false) goto L17;
                Object r18 = r17.next();
                Object r19 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r18, Map.Entry.class, "com.obric.aiagent.plugin")).getKey();
                Map.Entry r20 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18, Map.Entry.class, "com.obric.aiagent.plugin");
                r16.put(r19, b.f15681a.a(r20.getValue()));
                goto L15
            L17:
                r13.add(r16);
                goto L12
            L19:
                return new a(r9, r0, (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"));
            }
        }

        static {
            f15677a = new C0319a(null);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if (this.f15678b == r10.f15678b) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15679c, r10.f15679c) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15680d, r10.f15680d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f15678b) * 31) + this.f15679c.hashCode()) * 31) + this.f15680d.hashCode();
        }

        public String toString() {
            return "PersistedBucket(createTime=" + this.f15678b + ", params=" + this.f15679c + ", timeline=" + this.f15680d + ')';
        }

        public a(long r3, Map<String, ? extends List<b>> r5, List<? extends Map<String, b>> r6) {
            Map<String, List<b>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            List<Map<String, b>> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r7, "params");
            d.h.b.o.e(r8, "timeline");
            this.f15678b = r3;
            this.f15679c = r7;
            this.f15680d = r8;
        }

        public final long a() {
            return this.f15678b;
        }

        public final f b() {
            ConcurrentHashMap r0 = new ConcurrentHashMap();
            Iterator<Map.Entry<String, List<b>>> r1 = this.f15679c.entrySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L10;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
            List r3 = (List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.aiagent.plugin");
            Map r5 = (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r6, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r8 = r6.iterator();
        L7:
            if (r8.hasNext() == false) goto L9;
            r7.add(((b) ZeusTransformUtils.preCheckCast(r8.next(), b.class, "com.obric.aiagent.plugin")).a());
            goto L7
        L9:
            r5.put(r4, new CopyOnWriteArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
            goto L4
        L10:
            CopyOnWriteArrayList r9 = new CopyOnWriteArrayList();
            Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f15680d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L12:
            if (r10.hasNext() == false) goto L19;
            Map r11 = (Map) ZeusTransformUtils.preCheckCast(r10.next(), Map.class, "com.obric.aiagent.plugin");
            Map r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r11.size())), Map.class, "com.obric.aiagent.plugin");
            Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L15:
            if (r13.hasNext() == false) goto L17;
            Object r14 = r13.next();
            r12.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r14, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), ((b) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r14, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), b.class, "com.obric.aiagent.plugin")).a());
            goto L15
        L17:
            r9.add(new e(r12));
            goto L12
        L19:
            return new f(r0, (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniReportPersistence.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15681a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15683c;

        /* JADX INFO: compiled from: OmniReportPersistence.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }

            public final b a(Object r4) {
                if (r4 != null) goto L6;
                return new b(WsChannelMultiProcessSharedProvider.STRING_TYPE, null);
            L6:
                if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L10;
                b r0 = new b(WsChannelMultiProcessSharedProvider.STRING_TYPE, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
            L42:
                return r0;
            L10:
                if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L14;
                b r3 = new b(WsChannelMultiProcessSharedProvider.LONG_TYPE, String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue()));
            L43:
                return r3;
            L14:
                if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L17;
                r3 = new b("int", String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue()));
                goto L43
            L17:
                if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L20;
                r3 = new b(WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE, String.valueOf(((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));
                goto L43
            L20:
                if (ZeusTransformUtils.instanceOf(r4, Double.class) == false) goto L23;
                r3 = new b("double", String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).doubleValue()));
                goto L43
            L23:
                if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L26;
                r3 = new b(WsChannelMultiProcessSharedProvider.FLOAT_TYPE, String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).floatValue()));
                goto L43
            L26:
                if (ZeusTransformUtils.instanceOf(r4, t.class) == false) goto L29;
                r3 = new b("dispatch_intent", j.a().toJson(r4));
                goto L43
            L29:
                if (ZeusTransformUtils.instanceOf(r4, s.class) == false) goto L32;
                r3 = new b("clarify", j.a().toJson(r4));
                goto L43
            L32:
                if (ZeusTransformUtils.instanceOf(r4, r.class) == false) goto L35;
                r3 = new b("call_user", j.a().toJson(r4));
                goto L43
            L35:
                if (ZeusTransformUtils.instanceOf(r4, u.class) == false) goto L38;
                r3 = new b("taking_over", j.a().toJson(r4));
                goto L43
            L38:
                if (ZeusTransformUtils.instanceOf(r4, JsonElement.class) == false) goto L40;
                r3 = new b("json", ((JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin")).toString());
                goto L43
            L40:
                r0 = new b(WsChannelMultiProcessSharedProvider.STRING_TYPE, r4.toString());
                goto L42
            }
        }

        static {
            f15681a = new a(null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15682b, r6.f15682b) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15683c, r6.f15683c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f15682b.hashCode() * 31;
            String r1 = this.f15683c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "PersistedValue(type=" + this.f15682b + ", json=" + this.f15683c + ')';
        }

        public b(String r2, String r3) {
            d.h.b.o.e(r2, "type");
            this.f15682b = r2;
            this.f15683c = r3;
        }

        public final String getType() {
            return this.f15682b;
        }

        public final Object a() {
            String r1 = this.f15682b;
            switch(r1.hashCode()) {
                case -1325958191: goto L61;
                case -1046022900: goto L57;
                case -891985903: goto L53;
                case 104431: goto L47;
                case 3271912: goto L36;
                case 3327612: goto L30;
                case 64711720: goto L24;
                case 97526364: goto L18;
                case 193608879: goto L14;
                case 853581410: goto L10;
                case 1090703873: goto L6;
                default: goto L67;
            };
        L6:
            if (r1.equals("dispatch_intent") == false) goto L67;
            return j.a().fromJson(this.f15683c, t.class);
        L10:
            if (r1.equals("clarify") == false) goto L67;
            return j.a().fromJson(this.f15683c, s.class);
        L14:
            if (r1.equals("taking_over") == false) goto L67;
            return j.a().fromJson(this.f15683c, u.class);
        L18:
            if (r1.equals(WsChannelMultiProcessSharedProvider.FLOAT_TYPE) == false) goto L67;
            String r4 = this.f15683c;
            if (r4 != null) goto L74;
            return null;
        L74:
            return d.o.o.b(r4);
        L24:
            if (r1.equals(WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE) == false) goto L67;
            String r5 = this.f15683c;
            if (r5 != null) goto L76;
            return null;
        L76:
            return d.o.o.f(r5);
        L30:
            if (r1.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L67;
            String r6 = this.f15683c;
            if (r6 != null) goto L78;
            return null;
        L78:
            return d.o.o.e(r6);
        L36:
            if (r1.equals("json") == false) goto L67;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L40
            b r7 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
            Object r8 = d.n.f((JsonElement) ZeusTransformUtils.preCheckCast(j.a().fromJson(r7.f15683c, JsonElement.class), JsonElement.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L40
        L43:
            if (d.n.b(r8) == false) goto L79;
            return null;
        L79:
            return r8;
        L40:
            th = move-exception;
            d.n.a r0 = d.n.f38560a;
            r8 = d.n.f(d.o.a(th));
            goto L43
        L47:
            if (r1.equals("int") == false) goto L67;
            String r9 = this.f15683c;
            if (r9 != null) goto L81;
            return null;
        L81:
            return d.o.o.d(r9);
        L53:
            if (r1.equals(WsChannelMultiProcessSharedProvider.STRING_TYPE) == false) goto L67;
            return this.f15683c;
        L57:
            if (r1.equals("call_user") == false) goto L67;
            return j.a().fromJson(this.f15683c, r.class);
        L61:
            if (r1.equals("double") == false) goto L67;
            String r10 = this.f15683c;
            if (r10 != null) goto L85;
            return null;
        L85:
            return d.o.o.c(r10);
        L67:
            return this.f15683c;
        }
    }

    /* JADX INFO: compiled from: OmniReportPersistence.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f15684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f15685b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
            return false;
        L8:
            c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15684a, r8.f15684a) == true) goto L12;
            return false;
        L12:
            if (this.f15685b == r8.f15685b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f15684a.hashCode() * 31) + Long.hashCode(this.f15685b);
        }

        public String toString() {
            return "RestoredBucket(bucket=" + this.f15684a + ", createTime=" + this.f15685b + ')';
        }

        public c(f r2, long r3) {
            d.h.b.o.e(r2, "bucket");
            this.f15684a = r2;
            this.f15685b = r3;
        }

        public final f a() {
            return this.f15684a;
        }

        public final long b() {
            return this.f15685b;
        }
    }

    public static /* synthetic */ x lambda$brx4NyT8WJCbcfHZfTl0O1P4Cts(String r0) {
        return h(r0);
    }

    public static /* synthetic */ x lambda$cGdPC7lT3mQi508bRpAhgM4R8M0(String r0) {
        return i(r0);
    }

    public static /* synthetic */ Keva lambda$fWDS8cqhIYm74XyM1lCc78ZgA_A() {
        return d();
    }

    private j() {
    }

    public static final /* synthetic */ Gson a() {
        return f15675b;
    }

    static {
        f15674a = new j();
        f15675b = new Gson();
        f15676c = d.g.a($$Lambda$j$fWDS8cqhIYm74XyM1lCc78ZgA_A.INSTANCE);
    }

    private final Keva b() {
        Object r2 = f15676c.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (Keva) ZeusTransformUtils.preCheckCast(r2, Keva.class, "com.obric.aiagent.plugin");
    }

    private static final Keva d() {
        return Keva.getRepo("omni_report_store", 1);
    }

    public final c a(String r11) {
        d.h.b.o.e(r11, "messageId");
        String r2 = b().getString(f(r11), "");
        d.h.b.o.a(r2);
        Object r5 = null;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L22;
        return null;
    L22:
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L11
        j r10 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        a r4 = (a) ZeusTransformUtils.preCheckCast(f15675b.fromJson(r2, a.class), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if ((System.currentTimeMillis() - r4.a()) <= 43200000) goto L8;
        r10.e(r11);     // Catch: Throwable -> L11
        r10.a("bucket_index", r11);     // Catch: Throwable -> L11
        ISecureLogDepend.Companion.w(TAG, "restoreBucket ignored: persisted bucket expired, messageId=" + r11);     // Catch: Throwable -> L11
        c r12 = null;
    L9:
        Object r13 = d.n.f(r12);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = d.n.c(r13);
        if (r6 == null) goto L17;
        ISecureLogDepend.Companion.e(TAG, "restoreBucket failed, messageId=" + r11, r6);
        j r1 = f15674a;
        r1.e(r11);
        r1.a("bucket_index", r11);
    L17:
        if (d.n.b(r13) == true) goto L21;
        r5 = r13;
    L21:
        return (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
    L8:
        ISecureLogDepend.Companion.i(TAG, "restoreBucket success, messageId=" + r11);     // Catch: Throwable -> L11
        r12 = new c(r4.b(), r4.a());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r13 = d.n.f(d.o.a(th));
        goto L13
    }

    public final void a(String r3, f r4, long r5) {
        d.h.b.o.e(r3, "messageId");
        d.h.b.o.e(r4, "bucket");
        b().storeString(f(r3), f15675b.toJson(a.f15677a.a(r4, r5)));
    }

    public final List<String> b(String r3) {
        d.h.b.o.e(r3, "messageId");
        return a("bucket_index", r3, $$Lambda$j$brx4NyT8WJCbcfHZfTl0O1P4Cts.INSTANCE);
    }

    private static final x h(String r1) {
        d.h.b.o.e(r1, "evicted");
        f15674a.e(r1);
        return x.f38692a;
    }

    public final List<String> a(String r3, long r4) {
        d.h.b.o.e(r3, "messageId");
        e(r3);
        a("bucket_index", r3);
        b().storeLong(g(r3), r4);
        List<String> r2 = a("finished_index", r3, $$Lambda$j$cGdPC7lT3mQi508bRpAhgM4R8M0.INSTANCE);
        ISecureLogDepend.Companion.i(TAG, "markFinished success, messageId=" + r3 + ", evicted=" + r2.size());
        return r2;
    }

    private static final x i(String r2) {
        d.h.b.o.e(r2, "evicted");
        j r0 = f15674a;
        r0.b().erase(r0.g(r2));
        return x.f38692a;
    }

    public final boolean c(String r2) {
        d.h.b.o.e(r2, "messageId");
        return b().contains(g(r2));
    }

    private final List<String> a(String r11, String r12, d.h.a.b<? super String, x> r13) {
        d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        int r0 = c();
        List<String> r2 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(d(r11), Collection.class, "com.obric.aiagent.plugin"));
        r2.remove(r12);
        r2.add(r12);
        List<String> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L4:
        if (r2.size() <= r0) goto L6;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.remove(0), String.class, "com.obric.aiagent.plugin");
        r3.add(r4);
        r14.invoke(r4);
        ISecureLogDepend.Companion.i(TAG, "touchIndex evict persisted record, indexKey=" + r11 + ", messageId=" + r4);
        goto L4
    L6:
        a(r11, r2, r0);
        ISecureLogDepend.Companion.i(TAG, "maxRecords=" + r0 + ", indexKey=" + r11 + ", evicted=" + r3.size() + "， index=" + r2.size() + ", messageId=" + r12);
        return r3;
    }

    private final void a(String r4, String r5) {
        List<String> r0 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(d(r4), Collection.class, "com.obric.aiagent.plugin"));
        if (r0.remove(r5) == false) goto L6;
        a(r4, r0, c());
        return;
    }

    private final List<String> d(String r3) {
        String r4 = b().getString(r3, "");
        d.h.b.o.a(r4);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L8
        j r2 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        Object r5 = f15675b.fromJson(r4, String[].class);     // Catch: Throwable -> L8
        d.h.b.o.c(r5, "fromJson(...)");     // Catch: Throwable -> L8
        Object r6 = d.n.f(d.a.i.g((Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L8
    L10:
        List r7 = d.a.p.b();
        if (d.n.b(r6) == false) goto L14;
        r6 = r7;
    L14:
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
    L8:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L10
    L5:
        return d.a.p.b();
    }

    private final void a(String r3, List<String> r4, int r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        b().storeString(r3, f15675b.toJson(d.a.p.f(r6, r5)));
    }

    private final int c() {
        return d.l.n.c(AutoActionConfigs.INSTANCE.getIntCfg("omni.report.max_persisted_records", 20), 1);
    }

    private final void e(String r2) {
        b().erase(f(r2));
    }

    private final String f(String r2) {
        return "bucket_" + r2;
    }

    private final String g(String r2) {
        return "finished_" + r2;
    }
}
