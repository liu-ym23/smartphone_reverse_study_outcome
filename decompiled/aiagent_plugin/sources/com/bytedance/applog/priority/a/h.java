package com.bytedance.applog.priority.a;

import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.keva.KevaImpl;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;
import d.t;
import d.x;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Model.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: compiled from: Model.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0138a f5871a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f5873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f5874d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final b f5875e;
        private final int f;

        /* JADX INFO: renamed from: com.bytedance.applog.priority.a.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Model.kt */
        public static final class C0138a {
            private C0138a() {
            }

            public /* synthetic */ C0138a(d.h.b.h r1) {
                this();
            }

            public final a a(String r10) {
                o.d(r10, "key");
                List r9 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);
                if (r9.size() == 5) goto L5;
                return null;
            L5:
                return new a(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r9.get(0), String.class, "com.obric.aiagent.plugin")), Long.parseLong((String) ZeusTransformUtils.preCheckCast(r9.get(1), String.class, "com.obric.aiagent.plugin")), Long.parseLong((String) ZeusTransformUtils.preCheckCast(r9.get(2), String.class, "com.obric.aiagent.plugin")), b.i.a(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r9.get(3), String.class, "com.obric.aiagent.plugin"))), Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r9.get(4), String.class, "com.obric.aiagent.plugin")));
            }
        }

        static {
            f5871a = new C0138a(null);
        }

        public a(int r2, long r3, long r5, b r7, int r8) {
            o.d(r7, "eventType");
            this.f5872b = r2;
            this.f5873c = r3;
            this.f5874d = r5;
            this.f5875e = r7;
            this.f = r8;
        }

        public final long a() {
            return this.f5873c;
        }

        public final b b() {
            return this.f5875e;
        }

        public final int c() {
            return this.f;
        }

        public String toString() {
            return new StringBuilder().append(this.f5872b).append('-').append(this.f5873c).append('-').append(this.f5874d).append('-').append(this.f5875e.getType()).append('-').append(this.f).toString();
        }
    }

    /* JADX INFO: compiled from: Model.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5876a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f5877b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f5878c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f5879d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f5880e = null;
        public static final b f = null;
        public static final b g = null;
        public static final b h = null;
        public static final a i = null;
        private static final /* synthetic */ b[] j = null;
        private final int k;
        private final String l;

        /* JADX INFO: compiled from: Model.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            public final b a(int r6) {
                b[] r5 = b.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                b r3 = r5[r2];
                if (r3.getType() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L15;
                return r3;
            L15:
                return b.h;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }

            public final b a(String r7) {
                o.d(r7, "alias");
                b[] r6 = b.values();
                int r0 = r6.length;
                int r1 = 0;
            L3:
                if (r1 >= r0) goto L8;
                b r2 = r6[r1];
                String r3 = r2.a();
                Locale r4 = Locale.ROOT;
                o.b(r4, "Locale.ROOT");
                String r5 = r7.toLowerCase(r4);
                o.b(r5, "(this as java.lang.String).toLowerCase(locale)");
                if (o.a(r3, r5) == true) goto L9;
                r1 = r1 + 1;
            L9:
                if (r2 == null) goto L12;
                return r2;
            L12:
                return b.h;
            L8:
                r2 = null;
                goto L9
            }
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(j.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.k = r3;
            this.l = r4;
        }

        public final String a() {
            return this.l;
        }

        public final int getType() {
            return this.k;
        }

        static {
            b r1 = new b("V3", 0, 0, "event_v3");
            f5876a = r1;
            b r2 = new b("V1", 1, 1, "event_v1");
            f5877b = r2;
            b r3 = new b("LogData", 2, 2, "log_data");
            f5878c = r3;
            b r4 = new b("Launch", 3, 3, "launch");
            f5879d = r4;
            b r5 = new b("Terminate", 4, 4, "terminate");
            f5880e = r5;
            b r6 = new b("Impression", 5, 5, "item_impression");
            f = r6;
            b r7 = new b("ForwardV3", 6, 6, "forward_v3");
            g = r7;
            b r8 = new b("Unknown", 7, 99, SensitiveType.UNKNOWN);
            h = r8;
            j = new b[]{r1, r2, r3, r4, r5, r6, r7, r8};
            i = new a(null);
        }
    }

    /* JADX INFO: compiled from: Model.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f5881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f5882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<b> f5883c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CopyOnWriteArrayList<com.bytedance.applog.priority.a.f> f5884d;

        public c(CopyOnWriteArrayList<com.bytedance.applog.priority.a.f> r12) {
            o.d(r12, "groups");
            this.f5884d = r12;
            this.f5882b = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
            this.f5883c = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
            Iterator<com.bytedance.applog.priority.a.f> r13 = r12.iterator();
        L4:
            if (r13.hasNext() == false) goto L40;
            com.bytedance.applog.priority.a.f r0 = (com.bytedance.applog.priority.a.f) ZeusTransformUtils.preCheckCast(r13.next(), com.bytedance.applog.priority.a.f.class, "com.obric.aiagent.plugin");
            Iterator<String> r1 = r0.e().g().iterator();
        L7:
            if (r1.hasNext() == false) goto L4;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
            if (o.a(r3, b.f5876a.a()) == true) goto L11;
            this.f5883c.add(b.i.a(r3));
            goto L7
        L11:
            if (this.f5881a == true) goto L7;
            i.d r4 = r0.e().f();
            if (r4 == null) goto L38;
            Set<String> r5 = r4.a();
            if (r5.contains("*") == false) goto L18;
            this.f5881a = true;
            this.f5882b.clear();
        L22:
            HashMap<String, List<List<String>>> r6 = r4.b();
            if (((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin")).containsKey("*") == false) goto L25;
            this.f5881a = true;
            this.f5882b.clear();
        L29:
            HashMap<String, List<HashMap<String, String>>> r7 = r4.c();
            if (((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.aiagent.plugin")).containsKey("*") == false) goto L32;
            this.f5881a = true;
            this.f5882b.clear();
        L36:
            if (r7 == null) goto L38;
        L32:
            Set<String> r8 = r7.keySet();
            o.b(r8, "this.keys");
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L34:
            if (r9.hasNext() == false) goto L36;
            String r10 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin");
            Set<String> r11 = this.f5882b;
            o.b(r10, "e");
            r11.add(r10);
            goto L34
        L25:
            Set<String> r14 = r6.keySet();
            o.b(r14, "this.keys");
            Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L27:
            if (r15.hasNext() == false) goto L29;
            String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
            Set<String> r17 = this.f5882b;
            o.b(r16, "e");
            r17.add(r16);
            goto L27
        L18:
            Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L20:
            if (r18.hasNext() == false) goto L22;
            String r19 = (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.aiagent.plugin");
            this.f5882b.add(r19);
        L38:
            ((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin")).f5881a = true;
            x r20 = x.f38692a;
            goto L7
        }

        public final CopyOnWriteArrayList<com.bytedance.applog.priority.a.f> a() {
            return this.f5884d;
        }

        public final com.bytedance.applog.priority.a.f a(b r7, JSONObject r8) {
            o.d(r7, "eventType");
            o.d(r8, "json");
            Object r1 = null;
            if (com.bytedance.applog.priority.a.i.f5937a[r7.ordinal()] != 1) goto L5;
            String r3 = r8.optString("event");
            if (this.f5881a == false) goto L18;
        L21:
            JSONObject r9 = r8.optJSONObject("params");
            Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f5884d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L23:
            if (r6.hasNext() == false) goto L28;
            Object r4 = r6.next();
            com.bytedance.applog.priority.a.f r5 = (com.bytedance.applog.priority.a.f) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.priority.a.f.class, "com.obric.aiagent.plugin");
            o.b(r3, "event");
            if (r5.a(r7, r3, r9) == false) goto L23;
            r1 = r4;
        L28:
            return (com.bytedance.applog.priority.a.f) ZeusTransformUtils.preCheckCast(r1, com.bytedance.applog.priority.a.f.class, "com.obric.aiagent.plugin");
        L18:
            if (this.f5882b.contains(r3) == true) goto L21;
            return null;
        L5:
            if (this.f5883c.contains(r7) == false) goto L14;
            Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f5884d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L8:
            if (r10.hasNext() == false) goto L13;
            Object r11 = r10.next();
            if (((com.bytedance.applog.priority.a.f) ZeusTransformUtils.preCheckCast(r11, com.bytedance.applog.priority.a.f.class, "com.obric.aiagent.plugin")).a(r7, "", null) == false) goto L8;
            r1 = r11;
        L13:
            return (com.bytedance.applog.priority.a.f) ZeusTransformUtils.preCheckCast(r1, com.bytedance.applog.priority.a.f.class, "com.obric.aiagent.plugin");
        L14:
            return null;
        }
    }

    /* JADX INFO: compiled from: Model.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final j f5886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f5887c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final e f5888d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final g f5889e;
        private final i.d f;
        private final List<String> g;
        private final String h;

        public d(int r3, j r4, int r5, e r6, g r7, i.d r8, List<String> r9, String r10) {
            List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
            o.d(r4, "version");
            o.d(r6, "frequency");
            o.d(r7, "priority");
            o.d(r11, "supportEventTypes");
            o.d(r10, "reportUrl");
            this.f5885a = r3;
            this.f5886b = r4;
            this.f5887c = r5;
            this.f5888d = r6;
            this.f5889e = r7;
            this.f = r8;
            this.g = r11;
            this.h = r10;
            i();
        }

        public final int a() {
            return this.f5885a;
        }

        public final j b() {
            return this.f5886b;
        }

        public final int c() {
            return this.f5887c;
        }

        public final e d() {
            return this.f5888d;
        }

        public final g e() {
            return this.f5889e;
        }

        public final i.d f() {
            return this.f;
        }

        public final List<String> g() {
            return this.g;
        }

        public final String h() {
            return this.h;
        }

        public String toString() {
            return "GroupConfig-" + this.f5885a;
        }

        private final void i() {
            if (this.f5887c > 0) goto L7;
            this.f5888d.a(Integer.MAX_VALUE);
            return;
        L7:
            if (this.f5888d.f() <= 0) goto L9;
            return;
        L9:
            this.f5888d.a(n.c(60 / this.f5887c, 10));
        }
    }

    /* JADX INFO: compiled from: Model.kt */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f5892c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final j f5893d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f5894e;
        private int f;
        private AtomicInteger g;
        private AtomicInteger h;
        private long i;
        private long j;

        public final void c() {
        }

        public e(boolean r2, j r3, int r4, int r5, AtomicInteger r6, AtomicInteger r7, long r8, long r10) {
            o.d(r3, "version");
            o.d(r6, "level");
            o.d(r7, "levelSuccessCnt");
            this.f5892c = r2;
            this.f5893d = r3;
            this.f5894e = r4;
            this.f = r5;
            this.g = r6;
            this.h = r7;
            this.i = r8;
            this.j = r10;
            this.f5890a = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.f5891b = 5;
        }

        public final j e() {
            return this.f5893d;
        }

        public final void a(int r1) {
            this.f = r1;
        }

        public final int f() {
            return this.f;
        }

        public final f a() {
            long r0 = System.currentTimeMillis() / ((long) 1000);
            this.j = r0;
            if (this.f5892c == false) goto L15;
            if (this.g.get() <= 0) goto L13;
            long r1 = this.j;
            if ((r1 - this.i) <= 5) goto L11;
            this.i = r1;
            return f.f5895a;
        L11:
            return f.f5896b;
        L13:
            return f.f5895a;
        L15:
            if (a(r0) == true) goto L19;
            return f.f5896b;
        L19:
            if (g() == true) goto L23;
            return f.f5897c;
        L23:
            return f.f5895a;
        }

        public final void b() {
            this.h.set(this.f);
            this.i = this.j;
            if (this.g.incrementAndGet() <= 4) goto L6;
            this.g.set(4);
            return;
        }

        public final void d() {
            int r0 = this.h.incrementAndGet();
            if (this.g.get() > 0) goto L5;
            return;
        L5:
            if (r0 < this.f5891b) goto L7;
        L8:
            this.g.set(0);
            return;
        L7:
            if (this.f5892c == true) goto L8;
        }

        private final boolean a(long r9) {
            int r0 = this.g.get();
            if (r0 != 0) goto L12;
            if ((r9 - this.i) < 60) goto L7;
            boolean r10 = true;
        L8:
            if (r10 == false) goto L19;
            h();
            return true;
        L19:
            if (this.h.get() < this.f) goto L21;
            return false;
        L21:
            return true;
        L7:
            r10 = false;
            goto L8
        L12:
            if ((r9 - this.i) < (((long) 60) * ((long) Math.pow(2.0d, r0)))) goto L14;
            boolean r11 = true;
        L15:
            if (r11 == false) goto L19;
            h();
            return true;
        L14:
            r11 = false;
            goto L15
        }

        private final boolean g() {
            int r0 = this.f5894e;
            if (r0 != 0) goto L5;
        L12:
            return true;
        L5:
            if (r0 == this.f5890a) goto L12;
            if (new SecureRandom().nextInt(this.f5890a) <= this.f5894e) goto L10;
            return true;
        L10:
            this.h.incrementAndGet();
            return false;
        }

        private final void h() {
            this.h.set(0);
            this.i = this.j;
        }
    }

    /* JADX INFO: compiled from: Model.kt */
    public static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f5895a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f5896b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f5897c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ f[] f5898d = null;

        static {
            f r1 = new f("Allow", 0);
            f5895a = r1;
            f r2 = new f("BlockByFrequency", 1);
            f5896b = r2;
            f r3 = new f("BlockByBackoff", 2);
            f5897c = r3;
            f5898d = new f[]{r1, r2, r3};
        }

        public static f valueOf(String r2) {
            return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
        }

        public static f[] values() {
            return (f[]) ZeusTransformUtils.preCheckCast(f5898d.clone(), f[].class, "com.obric.aiagent.plugin");
        }

        private f(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: Model.kt */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.applog.priority.a.d f5899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final j f5900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final EnumC0139h f5901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f5902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f5903e;
        private final int f;
        private final long g;
        private final PriorityCallback h;

        public g(com.bytedance.applog.priority.a.d r3, j r4, EnumC0139h r5, long r6, long r8, int r10, long r11, PriorityCallback r13) {
            PriorityCallback r14 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r13, PriorityCallback.class, "com.obric.aiagent.plugin");
            o.d(r3, "engine");
            o.d(r4, "version");
            o.d(r5, "priorityName");
            o.d(r14, "callback");
            this.f5899a = r3;
            this.f5900b = r4;
            this.f5901c = r5;
            this.f5902d = r6;
            this.f5903e = r8;
            this.f = r10;
            this.g = r11;
            this.h = r14;
        }

        public final com.bytedance.applog.priority.a.d a() {
            return this.f5899a;
        }

        public final j b() {
            return this.f5900b;
        }

        public final EnumC0139h c() {
            return this.f5901c;
        }

        public final long d() {
            return this.f5902d;
        }

        public final long e() {
            return this.f5903e;
        }

        public final int f() {
            return this.f;
        }

        public final long g() {
            return this.g;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applog.priority.a.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Model.kt */
    public static final enum EnumC0139h extends Enum<EnumC0139h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0139h f5904a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0139h f5905b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0139h f5906c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0139h[] f5907d = null;

        static {
            EnumC0139h r1 = new EnumC0139h("P0", 0);
            f5904a = r1;
            EnumC0139h r2 = new EnumC0139h("P1", 1);
            f5905b = r2;
            EnumC0139h r3 = new EnumC0139h("P2", 2);
            f5906c = r3;
            f5907d = new EnumC0139h[]{r1, r2, r3};
        }

        public static EnumC0139h valueOf(String r2) {
            return (EnumC0139h) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0139h.class, r2), EnumC0139h.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0139h[] values() {
            return (EnumC0139h[]) ZeusTransformUtils.preCheckCast(f5907d.clone(), EnumC0139h[].class, "com.obric.aiagent.plugin");
        }

        private EnumC0139h(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: Model.kt */
    public static final class i {

        /* JADX INFO: compiled from: Model.kt */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f5908a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f5909b;

            public a(JSONObject r3) {
                o.d(r3, "json");
                this.f5908a = r3.optInt("backoff_ratio", 0);
                this.f5909b = r3.optInt("max_request_frequency", 10);
            }

            public final int a() {
                return this.f5908a;
            }

            public final int b() {
                return this.f5909b;
            }
        }

        /* JADX INFO: compiled from: Model.kt */
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final j f5910a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f5911b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final int f5912c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final ConcurrentHashMap<Integer, a> f5913d;

            public b(JSONObject r8) {
                o.d(r8, "json");
                int r2 = 0;
                this.f5910a = new j(r8.optInt("version", 0), r8.optJSONArray("config_ids"));
                this.f5911b = r8.optInt("backoff_ratio", 0);
                this.f5912c = r8.optInt("max_request_frequency", 10);
                this.f5913d = new ConcurrentHashMap();
                JSONArray r9 = r8.optJSONArray("priorities");
                if (r9 == null) goto L12;
                int r0 = r9.length();
            L5:
                if (r2 >= r0) goto L17;
                JSONObject r1 = r9.optJSONObject(r2);
                if (r1 == null) goto L11;
                int r3 = r1.optInt("global_priority");
                if (r3 <= 0) goto L11;
                ((Map) ZeusTransformUtils.preCheckCast(this.f5913d, Map.class, "com.obric.aiagent.plugin")).put(Integer.valueOf(r3), new a(r1));
            L11:
                r2 = r2 + 1;
                goto L5
            L17:
                return;
            }

            public final j a() {
                return this.f5910a;
            }

            public final int b() {
                return this.f5911b;
            }

            public final int c() {
                return this.f5912c;
            }

            public final ConcurrentHashMap<Integer, a> d() {
                return this.f5913d;
            }
        }

        /* JADX INFO: compiled from: Model.kt */
        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f5914a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f5915b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f5916c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final String f5917d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final List<String> f5918e;
            private final String f;
            private final d g;

            public c(JSONObject r7, String r8, String r9) {
                o.d(r7, "json");
                o.d(r8, "defaultReportHost");
                o.d(r9, "defaultReportPath");
                this.f5914a = r7.optInt("global_priority", 0);
                this.f5915b = n.c(r7.optInt("interval", 0), 0);
                String r10 = r7.optString("report_host", r8);
                o.b(r10, "json.optString(\"report_host\", defaultReportHost)");
                this.f5916c = r10;
                String r11 = r7.optString("report_path", r9);
                o.b(r11, "json.optString(\"report_path\", defaultReportPath)");
                this.f5917d = r11;
                this.f5918e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
                String r12 = r7.optString("event_priority", "P2");
                o.b(r12, "json.optString(\"event_priority\", \"P2\")");
                this.f = r12;
                JSONObject r13 = r7.optJSONObject("filter");
                if (r13 == null) goto L5;
                d r14 = new d(r13);
            L6:
                this.g = r14;
                JSONArray r15 = r7.optJSONArray("support_event_types");
                if (r15 == null) goto L24;
                int r16 = r15.length();
                int r17 = 0;
            L9:
                if (r17 >= r16) goto L29;
                String r2 = r15.optString(r17);
                CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
                if (r3 != null) goto L13;
            L16:
                boolean r4 = true;
            L17:
                if (r4 == true) goto L23;
                List<String> r5 = this.f5918e;
                Locale r6 = Locale.ROOT;
                o.b(r6, "Locale.ROOT");
                if (r2 == null) goto L22;
                String r18 = r2.toLowerCase(r6);
                o.b(r18, "(this as java.lang.String).toLowerCase(locale)");
                r5.add(r18);
                goto L23
            L22:
                throw new t("null cannot be cast to non-null type java.lang.String");
            L23:
                r17 = r17 + 1;
                goto L9
            L13:
                if (r3.length() == 0) goto L16;
                r4 = false;
                goto L17
            L29:
                return;
            L24:
                return;
            L5:
                r14 = null;
                goto L6
            }

            public final int a() {
                return this.f5914a;
            }

            public final int b() {
                return this.f5915b;
            }

            public final String c() {
                return this.f5916c;
            }

            public final String d() {
                return this.f5917d;
            }

            public final List<String> e() {
                return this.f5918e;
            }

            public final String f() {
                return this.f;
            }

            public final d g() {
                return this.g;
            }
        }

        /* JADX INFO: compiled from: Model.kt */
        public static final class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Set<String> f5919a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final HashMap<String, List<List<String>>> f5920b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final HashMap<String, List<HashMap<String, String>>> f5921c;

            public d(JSONObject r19) {
                o.d(r19, "json");
                this.f5919a = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
                this.f5920b = new HashMap();
                this.f5921c = new HashMap();
                JSONArray r2 = r19.optJSONArray("events");
                if (r2 == null) goto L16;
                int r6 = r2.length();
                int r7 = 0;
            L5:
                if (r7 >= r6) goto L16;
                String r8 = r2.optString(r7);
                CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
                if (r9 != null) goto L9;
            L12:
                boolean r10 = true;
            L13:
                if (r10 == true) goto L15;
                this.f5919a.add(r8);
            L15:
                r7 = r7 + 1;
                goto L5
            L9:
                if (r9.length() == 0) goto L12;
                r10 = false;
            L16:
                JSONObject r3 = r19.optJSONObject("param_keys");
                if (r3 == null) goto L41;
                Iterator<String> r11 = r3.keys();
                o.b(r11, "it.keys()");
            L20:
                if (r11.hasNext() == false) goto L41;
                String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");
                List r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
                JSONArray r14 = r3.optJSONArray(r12);
                if (r14 == null) goto L40;
                int r15 = r14.length();
                int r16 = 0;
            L24:
                if (r16 >= r15) goto L40;
                JSONArray r17 = r14.optJSONArray(r16);
                List r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
                if (r17 == null) goto L39;
                int r18 = r17.length();
                int r5 = 0;
            L28:
                if (r5 >= r18) goto L39;
                JSONObject r110 = r3;
                String r20 = r17.optString(r5);
                Iterator<String> r111 = r11;
                CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin");
                if (r21 != null) goto L32;
            L35:
                boolean r22 = true;
            L36:
                if (r22 == true) goto L38;
                r4.add(r20);
            L38:
                r5 = r5 + 1;
                r3 = r110;
                r11 = r111;
                goto L28
            L32:
                if (r21.length() == 0) goto L35;
                r22 = false;
            L39:
                r13.add(r4);
                r16 = r16 + 1;
                r3 = r3;
                r11 = r11;
            L40:
                JSONObject r112 = r3;
                Map r23 = (Map) ZeusTransformUtils.preCheckCast(this.f5920b, Map.class, "com.obric.aiagent.plugin");
                o.b(r12, "key");
                r23.put(r12, r13);
                r3 = r112;
                r11 = r11;
            L41:
                JSONObject r1 = r19.optJSONObject("param_key_values");
                if (r1 == null) goto L58;
                Iterator<String> r24 = r1.keys();
                o.b(r24, "it.keys()");
            L45:
                if (r24.hasNext() == false) goto L74;
                String r25 = (String) ZeusTransformUtils.preCheckCast(r24.next(), String.class, "com.obric.aiagent.plugin");
                List r26 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
                JSONArray r27 = r1.optJSONArray(r25);
                if (r27 == null) goto L57;
                int r28 = r27.length();
                int r29 = 0;
            L49:
                if (r29 >= r28) goto L57;
                JSONObject r113 = r27.optJSONObject(r29);
                HashMap r114 = new HashMap();
                if (r113 == null) goto L56;
                Iterator<String> r115 = r113.keys();
                o.b(r115, "v.keys()");
            L54:
                if (r115.hasNext() == false) goto L56;
                String r116 = (String) ZeusTransformUtils.preCheckCast(r115.next(), String.class, "com.obric.aiagent.plugin");
                Map r117 = (Map) ZeusTransformUtils.preCheckCast(r114, Map.class, "com.obric.aiagent.plugin");
                o.b(r116, "k");
                String r118 = r113.optString(r116);
                o.b(r118, "v.optString(k)");
                r117.put(r116, r118);
                r1 = r1;
            L56:
                r26.add(r114);
                r29 = r29 + 1;
                r1 = r1;
            L57:
                JSONObject r119 = r1;
                Map r30 = (Map) ZeusTransformUtils.preCheckCast(this.f5921c, Map.class, "com.obric.aiagent.plugin");
                o.b(r25, "key");
                r30.put(r25, r26);
                r1 = r119;
                goto L45
            L74:
                return;
            }

            public final Set<String> a() {
                return this.f5919a;
            }

            public final HashMap<String, List<List<String>>> b() {
                return this.f5920b;
            }

            public final HashMap<String, List<HashMap<String, String>>> c() {
                return this.f5921c;
            }
        }

        /* JADX INFO: compiled from: Model.kt */
        public static final class e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final j f5922a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List<c> f5923b;

            public e(JSONObject r6, String r7, String r8) {
                o.d(r6, "json");
                o.d(r7, "defaultReportHost");
                o.d(r8, "defaultReportPath");
                int r2 = 0;
                this.f5922a = new j(r6.optInt("version", 0), r6.optJSONArray("config_ids"));
                this.f5923b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
                JSONArray r9 = r6.optJSONArray("priorities");
                if (r9 == null) goto L10;
                int r0 = r9.length();
            L5:
                if (r2 >= r0) goto L14;
                JSONObject r1 = r9.optJSONObject(r2);
                if (r1 == null) goto L9;
                this.f5923b.add(new c(r1, r7, r8));
            L9:
                r2 = r2 + 1;
                goto L5
            L14:
                return;
            }

            public final j a() {
                return this.f5922a;
            }

            public final List<c> b() {
                return this.f5923b;
            }
        }

        /* JADX INFO: compiled from: Model.kt */
        public static final class f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final j f5924a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final g f5925b;

            public f(JSONObject r4) {
                o.d(r4, "json");
                this.f5924a = new j(r4.optInt("version", 0), r4.optJSONArray("config_ids"));
                JSONObject r5 = r4.optJSONObject("config");
                if (r5 != null) goto L6;
                r5 = new JSONObject();
            L6:
                this.f5925b = new g(r5);
            }

            public final j a() {
                return this.f5924a;
            }

            public final g b() {
                return this.f5925b;
            }
        }

        /* JADX INFO: compiled from: Model.kt */
        public static final class g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final C0140h f5926a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final C0140h f5927b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final C0140h f5928c;

            public g(JSONObject r3) {
                o.d(r3, "json");
                JSONObject r1 = r3.optJSONObject("P0");
                if (r1 != null) goto L6;
                r1 = new JSONObject();
            L6:
                this.f5926a = new C0140h(r1);
                JSONObject r2 = r3.optJSONObject("P1");
                if (r2 != null) goto L10;
                r2 = new JSONObject();
            L10:
                this.f5927b = new C0140h(r2);
                JSONObject r4 = r3.optJSONObject("P2");
                if (r4 != null) goto L14;
                r4 = new JSONObject();
            L14:
                this.f5928c = new C0140h(r4);
            }

            public final C0140h a() {
                return this.f5926a;
            }

            public final C0140h b() {
                return this.f5927b;
            }

            public final C0140h c() {
                return this.f5928c;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.applog.priority.a.h$i$h, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Model.kt */
        public static final class C0140h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f5929a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f5930b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final int f5931c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final long f5932d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final JSONObject f5933e;

            public C0140h(JSONObject r3) {
                o.d(r3, "json");
                this.f5933e = r3;
                this.f5929a = a("max_event_size", 1048576);
                this.f5930b = a("max_request_body_size", 3145728);
                this.f5931c = a("max_request_event_count", DownloadErrorCode.ERROR_CRONET_ERROR_BASE);
                this.f5932d = a("event_ttl", 604800);
            }

            public final long a() {
                return this.f5929a;
            }

            public final long b() {
                return this.f5930b;
            }

            public final int c() {
                return this.f5931c;
            }

            public final long d() {
                return this.f5932d;
            }

            private final long a(String r3, long r4) {
                long r2 = this.f5933e.optLong(r3);
                if (r2 <= 0) goto L5;
                return r2;
            L5:
                return r4;
            }

            private final int a(String r1, int r2) {
                int r0 = this.f5933e.optInt(r1);
                if (r0 <= 0) goto L5;
                return r0;
            L5:
                return r2;
            }
        }
    }

    /* JADX INFO: compiled from: Model.kt */
    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f5934a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final JSONArray f5936c;

        /* JADX INFO: compiled from: Model.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            public final j a(JSONObject r3) {
                o.d(r3, "json");
                return new j(r3.optInt("version", 0), r3.optJSONArray("config_ids"));
            }
        }

        static {
            f5934a = new a(null);
        }

        public j(int r1, JSONArray r2) {
            this.f5935b = r1;
            this.f5936c = r2;
        }

        public final JSONObject a(Object r5) {
            o.d(r5, "value");
            JSONObject r1 = new JSONObject();
            r1.put("version", this.f5935b);
            r1.put("value", r5);
            JSONArray r4 = this.f5936c;
            if (r4 == null) goto L5;
            r1.put("config_ids", r4);
        L5:
            return r1;
        }

        public final boolean a(j r5) {
            o.d(r5, "other");
            int r0 = this.f5935b;
            int r1 = r5.f5935b;
            if (r0 <= r1) goto L6;
            return true;
        L6:
            if (r0 >= r1) goto L8;
            return false;
        L8:
            JSONArray r4 = this.f5936c;
            String r2 = null;
            if (r4 == null) goto L11;
            String r6 = r4.toString();
        L12:
            JSONArray r7 = r5.f5936c;
            if (r7 == null) goto L16;
            r2 = r7.toString();
        L16:
            if ((!o.a(r6, r2)) == false) goto L18;
            return true;
        L18:
            return false;
        L11:
            r6 = null;
            goto L12
        }

        public final JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put("version", this.f5935b);
            JSONArray r3 = this.f5936c;
            if (r3 == null) goto L5;
            r0.put("config_ids", r3);
        L5:
            return r0;
        }
    }
}
