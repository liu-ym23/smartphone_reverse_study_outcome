package com.obric.agent.entitysync;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.JsonObject;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.r;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AppEntityRoundState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14512a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashMap<String, d> f14514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashMap<com.obric.agent.entitysync.c, List<c>> f14515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f14516e;
    private long f;
    private m g;
    private m h;

    /* JADX INFO: compiled from: AppEntityRoundState.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f14517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final i f14519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f14520d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f14521e;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if (this.f14517a == r10.f14517a) goto L12;
            return false;
        L12:
            if (o.a(this.f14518b, r10.f14518b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14519c, r10.f14519c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f14520d, r10.f14520d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f14521e, r10.f14521e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((Long.hashCode(this.f14517a) * 31) + this.f14518b.hashCode()) * 31) + this.f14519c.hashCode()) * 31) + this.f14520d.hashCode()) * 31;
            Long r2 = this.f14521e;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "ChangeEvent(version=" + this.f14517a + ", reportEcaId=" + this.f14518b + ", snapshot=" + this.f14519c + ", updateType=" + this.f14520d + ", firstReportedRound=" + this.f14521e + ')';
        }

        public a(long r2, String r4, i r5, String r6, Long r7) {
            o.e(r4, "reportEcaId");
            o.e(r5, "snapshot");
            o.e(r6, "updateType");
            this.f14517a = r2;
            this.f14518b = r4;
            this.f14519c = r5;
            this.f14520d = r6;
            this.f14521e = r7;
        }

        public /* synthetic */ a(long r8, String r10, i r11, String r12, Long r13, int r14, d.h.b.h r15) {
            if ((r14 & 16) == 0) goto L5;
            r13 = null;
        L5:
            this(r8, r10, r11, r12, r13);
        }

        public final long a() {
            return this.f14517a;
        }

        public final String b() {
            return this.f14518b;
        }

        public final i c() {
            return this.f14519c;
        }

        public final String d() {
            return this.f14520d;
        }

        public final void a(Long r1) {
            this.f14521e = r1;
        }

        public final Long e() {
            return this.f14521e;
        }
    }

    /* JADX INFO: compiled from: AppEntityRoundState.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: AppEntityRoundState.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<a> f14522a;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14522a, r6.f14522a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f14522a.hashCode();
        }

        public String toString() {
            return "EntityChangeHistory(events=" + this.f14522a + ')';
        }

        public c(List<a> r3) {
            List<a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "events");
            this.f14522a = r4;
        }

        public /* synthetic */ c(List r2, int r3, d.h.b.h r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            if ((r3 & 1) == 0) goto L5;
            r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        L5:
            this(r5);
        }

        public final List<a> a() {
            return this.f14522a;
        }
    }

    /* JADX INFO: compiled from: AppEntityRoundState.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f14523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<com.obric.agent.entitysync.c, e> f14524b;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
            if (this.f14523a == r10.f14523a) goto L12;
            return false;
        L12:
            if (o.a(this.f14524b, r10.f14524b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f14523a) * 31) + this.f14524b.hashCode();
        }

        public String toString() {
            return "TrackedCard(createdRound=" + this.f14523a + ", entities=" + this.f14524b + ')';
        }

        public d(long r3, Map<com.obric.agent.entitysync.c, e> r5) {
            Map<com.obric.agent.entitysync.c, e> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r6, "entities");
            this.f14523a = r3;
            this.f14524b = r6;
        }

        public final long a() {
            return this.f14523a;
        }

        public final Map<com.obric.agent.entitysync.c, e> b() {
            return this.f14524b;
        }
    }

    /* JADX INFO: compiled from: AppEntityRoundState.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private i f14525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f14526b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14525a, r6.f14525a) == true) goto L12;
            return false;
        L12:
            if (this.f14526b == r6.f14526b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f14525a.hashCode() * 31) + Boolean.hashCode(this.f14526b);
        }

        public String toString() {
            return "TrackedEntity(snapshot=" + this.f14525a + ", deleted=" + this.f14526b + ')';
        }

        public e(i r2, boolean r3) {
            o.e(r2, "snapshot");
            this.f14525a = r2;
            this.f14526b = r3;
        }

        public /* synthetic */ e(i r1, boolean r2, int r3, d.h.b.h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = false;
        L5:
            this(r1, r2);
        }

        public final i a() {
            return this.f14525a;
        }

        public final void a(i r2) {
            o.e(r2, "<set-?>");
            this.f14525a = r2;
        }

        public final void a(boolean r1) {
            this.f14526b = r1;
        }

        public final boolean b() {
            return this.f14526b;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class f<T> implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f14512a = new b(null);
    }

    public h() {
        this(0, 1, null);
    }

    public static /* synthetic */ d.n.j lambda$O4FrC29WclRTk7TlQJSNTqO4AVk(d r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$_HCZUjsE5ITQQqKREHWfTRaiQKE(m r0, h r1, a r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$duuQ13BsqrjYhxou2FOcf6RxPKQ(String r0, c r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$r91PP6rdDa7wAPhAbdXbCuXFiZE(m r0, h r1, c r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$v7-Xlitn8daLkWDxcZWqWlDSrEM, reason: not valid java name */
    public static /* synthetic */ boolean m76lambda$v7Xlitn8daLkWDxcZWqWlDSrEM(m r0, h r1, Map.Entry r2) {
        return a(r0, r1, r2);
    }

    public h(int r2) {
        this.f14513b = r2;
        this.f14514c = new LinkedHashMap();
        this.f14515d = new LinkedHashMap();
        if (r2 <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("maxRounds must be positive".toString());
    L5:
        r1 = false;
        goto L6
    }

    public /* synthetic */ h(int r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 5;
    L5:
        this(r1);
    }

    public final synchronized void a(String r11, List<i> r12) {
        monitor-enter(this);
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        o.e(r11, "cardKey");     // Catch: Throwable -> L27
        o.e(r13, "entities");     // Catch: Throwable -> L27
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
    L25:
        monitor-exit(this);
        return;
    L6:
        if (r13.isEmpty() == true) goto L25;
        d r0 = (d) ZeusTransformUtils.preCheckCast(this.f14514c.get(r11), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r0 == null) goto L11;
        long r1 = r0.a();     // Catch: Throwable -> L27
    L16:
        if (this.f14516e != 0) goto L18;
        this.f14516e = r1;     // Catch: Throwable -> L27
    L18:
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.f14514c, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(d.l.n.c(ao.a(p.a(r14, 10)), 16)), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L27
    L20:
        if (r15.hasNext() == false) goto L22;
        i r4 = (i) ZeusTransformUtils.preCheckCast(r15.next(), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        d.m r5 = s.a(r4.a(), new e(r4, false, 2, null));     // Catch: Throwable -> L27
        r3.put(r5.a(), r5.b());     // Catch: Throwable -> L27
        goto L20
    L22:
        r2.put(r11, new d(r1, ao.e(r3)));     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L11:
        m r6 = this.g;     // Catch: Throwable -> L27
        if (r6 == null) goto L14;
        r1 = r6.a();     // Catch: Throwable -> L27
        goto L16
    L14:
        r1 = d.l.n.a(this.f14516e, 1);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public final synchronized List<com.obric.agent.entitysync.a> a(g r3, List<i> r4) {
        monitor-enter(this);
        List<i> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        o.e(r3, "change");     // Catch: Throwable -> L6
        o.e(r5, "latestEntities");     // Catch: Throwable -> L6
        List<com.obric.agent.entitysync.a> r6 = a(r3, r5, false);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r6;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized List<com.obric.agent.entitysync.a> a(List<i> r3) {
        monitor-enter(this);
        List<i> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        o.e(r4, "latestEntities");     // Catch: Throwable -> L6
        List<com.obric.agent.entitysync.a> r5 = a(g.f14509c, r4, true);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [d.h.b.h, java.util.List] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r6v17, types: [com.obric.agent.entitysync.h$e] */
    private final List<com.obric.agent.entitysync.a> a(g r27, List<i> r28, boolean r29) {
        h r0 = this;
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.aiagent.plugin");
        if (r2.isEmpty() == true) goto L103;
        if (r0.f14514c.isEmpty() == true) goto L103;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r3.hasNext() == false) goto L96;
        i r5 = (i) ZeusTransformUtils.preCheckCast(r3.next(), i.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(r0.f14514c, Map.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r6.entrySet().iterator();
    L11:
        ?? r15 = 0;
        r r16 = null;
        if (r8.hasNext() == false) goto L18;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.aiagent.plugin");
        d r11 = (d) ZeusTransformUtils.preCheckCast(r9.getValue(), d.class, "com.obric.aiagent.plugin");
        e r12 = (e) ZeusTransformUtils.preCheckCast(r11.b().get(r5.a()), e.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L16;
        r16 = new r(r10, r12, r11);
    L16:
        if (r16 == null) goto L11;
        r7.add(r16);
        goto L11
    L18:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
        if (r14.isEmpty() == true) goto L95;
        int r13 = 1;
        if (r27 != g.f14509c) goto L35;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L25;
    L27:
        Iterator r18 = r17.iterator();
    L29:
        if (r18.hasNext() == false) goto L26;
        if (((e) ZeusTransformUtils.preCheckCast(((r) ZeusTransformUtils.preCheckCast(r18.next(), r.class, "com.obric.aiagent.plugin")).b(), e.class, "com.obric.aiagent.plugin")).b() == true) goto L29;
        boolean r19 = false;
    L33:
        if (r19 == false) goto L35;
        boolean r110 = true;
    L36:
        if (r110 == false) goto L39;
        if (r29 == false) goto L95;
    L39:
        if (r110 == true) goto L72;
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r20, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r22 = r20.iterator();
    L42:
        if (r22.hasNext() == false) goto L44;
        r21.add(((e) ZeusTransformUtils.preCheckCast(((r) ZeusTransformUtils.preCheckCast(r22.next(), r.class, "com.obric.aiagent.plugin")).b(), e.class, "com.obric.aiagent.plugin")).a());
        goto L42
    L44:
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        HashSet r24 = new HashSet();
        ArrayList r25 = new ArrayList();
        Iterator r26 = r23.iterator();
    L46:
        if (r26.hasNext() == false) goto L50;
        Object r30 = r26.next();
        if (r24.add(((i) ZeusTransformUtils.preCheckCast(r30, i.class, "com.obric.aiagent.plugin")).b()) == false) goto L46;
        r25.add(r30);
        goto L46
    L50:
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L52:
        if (r111.hasNext() == false) goto L72;
        i r112 = (i) ZeusTransformUtils.preCheckCast(r111.next(), i.class, "com.obric.aiagent.plugin");
        if (r27 != g.f14509c) goto L58;
        String r31 = "delete";
    L56:
        String r210 = r31;
        Collection r32 = (Collection) ZeusTransformUtils.preCheckCast(r0.a(r5.a(), r112.b()), Collection.class, "com.obric.aiagent.plugin");
        boolean r33 = r32.isEmpty();
        Collection r34 = r32;
        if (r33 == false) goto L67;
        c r35 = new c(r15, r13, r15);
        Map r36 = (Map) ZeusTransformUtils.preCheckCast(r0.f14515d, Map.class, "com.obric.aiagent.plugin");
        com.obric.agent.entitysync.c r37 = r5.a();
        Object r38 = r36.get(r37);
        if (r38 != null) goto L66;
        r38 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r36.put(r37, r38);
    L66:
        ((List) ZeusTransformUtils.preCheckCast(r38, List.class, "com.obric.aiagent.plugin")).add(r35);
        r34 = p.a(r35);
    L67:
        Iterator r211 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r34, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        ?? r113 = r15;
    L69:
        if (r211.hasNext() == false) goto L71;
        c r39 = (c) ZeusTransformUtils.preCheckCast(r211.next(), c.class, "com.obric.aiagent.plugin");
        r0.f++;
        r39.a().add(new a(r0.f, r112.b(), r5, r210, null, 16, null));
        r14 = r14;
        r13 = r13;
        r113 = 0;
        r0 = this;
        goto L69
    L71:
        r0 = this;
        r15 = r113;
        goto L52
    L58:
        if (o.a(r112.b(), r5.b()) == true) goto L60;
        r31 = "replace";
        goto L56
    L60:
        r31 = "update";
    L72:
        int r212 = r13;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L74:
        if (r1.hasNext() == false) goto L95;
        r r40 = (r) ZeusTransformUtils.preCheckCast(r1.next(), r.class, "com.obric.aiagent.plugin");
        String r41 = (String) ZeusTransformUtils.preCheckCast(r40.d(), String.class, "com.obric.aiagent.plugin");
        ?? r42 = (e) ZeusTransformUtils.preCheckCast(r40.e(), e.class, "com.obric.aiagent.plugin");
        i r43 = r42.a();
        boolean r44 = !o.a(r43.b(), r5.b());
        boolean r114 = r42.b();
        if (r110 == false) goto L78;
        i r115 = r42.a();
    L79:
        r42.a(r115);
        if (r27 != g.f14509c) goto L82;
        ?? r116 = r212;
    L83:
        r42.a(r116);
        if (r42.b() == false) goto L86;
        com.obric.agent.entitysync.e r45 = com.obric.agent.entitysync.e.f14503c;
    L91:
        Map r46 = (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin");
        Object r117 = r46.get(r41);
        if (r117 != null) goto L94;
        r117 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r46.put(r41, r117);
    L94:
        ((List) ZeusTransformUtils.preCheckCast(r117, List.class, "com.obric.aiagent.plugin")).add(new com.obric.agent.entitysync.d(r115, r45, r43));
        goto L74
    L86:
        if (r114 == true) goto L90;
        if (r44 == true) goto L90;
        r45 = com.obric.agent.entitysync.e.f14501a;
    L90:
        r45 = com.obric.agent.entitysync.e.f14502b;
        goto L91
    L82:
        r116 = 0;
        goto L83
    L78:
        r115 = r5;
    L26:
        r19 = true;
        goto L33
    L25:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L27;
    L35:
        r110 = false;
    L95:
        r0 = this;
        goto L9
    L96:
        Map r47 = (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin");
        Collection r48 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r47.size()), Collection.class, "com.obric.aiagent.plugin");
        Iterator r49 = r47.entrySet().iterator();
    L98:
        if (r49.hasNext() == false) goto L101;
        Map.Entry r50 = (Map.Entry) ZeusTransformUtils.preCheckCast(r49.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r48.add(new com.obric.agent.entitysync.a((String) ZeusTransformUtils.preCheckCast(r50.getKey(), String.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r50.getValue(), List.class, "com.obric.aiagent.plugin")));
        goto L98
    L101:
        return (List) ZeusTransformUtils.preCheckCast(r48, List.class, "com.obric.aiagent.plugin");
    L103:
        return p.b();
    }

    private final List<c> a(com.obric.agent.entitysync.c r2, final String r3) {
        List r1 = (List) ZeusTransformUtils.preCheckCast(this.f14515d.get(r2), List.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        r1 = p.b();
    L6:
        return d.n.m.g(d.n.m.a(p.y((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")), new $$Lambda$h$duuQ13BsqrjYhxou2FOcf6RxPKQ(r3)));
    }

    private static final boolean a(String r2, c r3) {
        o.e(r3, "history");
        a r4 = (a) ZeusTransformUtils.preCheckCast(p.n(r3.a()), a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        i r5 = r4.c();
        if (r5 == null) goto L7;
        String r6 = r5.b();
    L9:
        return o.a(r6, r2);
    L7:
        r6 = null;
        goto L9
    }

    public final synchronized m a(String r17) {
        monitor-enter(this);
        if (r17 != null) goto L66;
    L16:
        String r9 = null;
    L17:
        m r0 = this.g;     // Catch: Throwable -> L14
        if (r0 != null) goto L20;
    L26:
        m r1 = this.h;     // Catch: Throwable -> L14
        if (r1 != null) goto L29;
    L35:
        this.h = null;     // Catch: Throwable -> L14
        long r7 = this.f14516e + 1;     // Catch: Throwable -> L14
        long r11 = this.f;     // Catch: Throwable -> L14
        LinkedHashMap r2 = new LinkedHashMap();     // Catch: Throwable -> L14
        Collection<List<c>> r4 = this.f14515d.values();     // Catch: Throwable -> L14
        o.c(r4, "<get-values>(...)");     // Catch: Throwable -> L14
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L14
    L37:
        if (r5.hasNext() == false) goto L57;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r5.next(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        o.a(r6);     // Catch: Throwable -> L14
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L14
    L40:
        if (r8.hasNext() == false) goto L37;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(((c) ZeusTransformUtils.preCheckCast(r8.next(), c.class, "com.obric.aiagent.plugin")).a(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Iterator r13 = r10.iterator();     // Catch: Throwable -> L14
    L43:
        if (r13.hasNext() == false) goto L50;
        Object r14 = r13.next();     // Catch: Throwable -> L14
        if (((a) ZeusTransformUtils.preCheckCast(r14, a.class, "com.obric.aiagent.plugin")).a() > r11) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L43;
        r12.add(r14);     // Catch: Throwable -> L14
        goto L43
    L47:
        r15 = false;
        goto L48
    L50:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r16.isEmpty() == true) goto L40;
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        String r19 = ((a) ZeusTransformUtils.preCheckCast(p.k(r16), a.class, "com.obric.aiagent.plugin")).b();     // Catch: Throwable -> L14
        Object r110 = r18.get(r19);     // Catch: Throwable -> L14
        if (r110 != null) goto L56;
        r110 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r18.put(r19, r110);     // Catch: Throwable -> L14
    L56:
        ((List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.aiagent.plugin")).addAll((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        goto L40
    L57:
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Map r111 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r3.size())), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r3.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L14
    L59:
        if (r20.hasNext() == false) goto L61;
        Object r21 = r20.next();     // Catch: Throwable -> L14
        r111.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r21, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), (j) ZeusTransformUtils.preCheckCast(b(p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r21, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new f(), Comparator.class, "com.obric.aiagent.plugin"))).b(), j.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        goto L59
    L61:
        m r22 = new m(r7, r9, r111, r11);     // Catch: Throwable -> L14
        this.g = r22;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r22;
    L14:
        th = move-exception;
        throw th;
    L29:
        if (a(r1.b(), r9) == true) goto L32;
        r1 = null;
    L32:
        if (r1 == null) goto L35;
        monitor-exit(this);
        return r1;
    L20:
        if (b(r0.b(), r9) == true) goto L23;
        r0 = null;
    L23:
        if (r0 == null) goto L26;
        monitor-exit(this);
        return r0;
    L66:
        String r23 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L14
        if (r23 == null) goto L16;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
        boolean r24 = true;
    L12:
        if (r24 == false) goto L16;
        r9 = r23;
        goto L17
    L11:
        r24 = false;
        goto L12
    }

    public final synchronized void b(String r12) {
        monitor-enter(this);
        final m r0 = this.g;     // Catch: Throwable -> L38
        if (r0 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r12 == null) goto L17;
        String r13 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L38
        if (r13 == null) goto L17;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
    L19:
        if (o.a(r0.b(), r13) == true) goto L22;
        monitor-exit(this);
        return;
    L22:
        long r5 = r0.a();     // Catch: Throwable -> L38
        this.f14516e = r5;     // Catch: Throwable -> L38
        long r6 = (r5 - ((long) this.f14513b)) + 1;     // Catch: Throwable -> L38
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(this.f14514c, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        LinkedHashMap r7 = new LinkedHashMap();     // Catch: Throwable -> L38
        Iterator r15 = r14.entrySet().iterator();     // Catch: Throwable -> L38
    L24:
        if (r15.hasNext() == false) goto L31;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        if (((d) ZeusTransformUtils.preCheckCast(r8.getValue(), d.class, "com.obric.aiagent.plugin")).a() >= r6) goto L28;
        boolean r9 = true;
    L29:
        if (r9 == false) goto L24;
        r7.put(r8.getKey(), r8.getValue());     // Catch: Throwable -> L38
        goto L24
    L28:
        r9 = false;
        goto L29
    L31:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.aiagent.plugin")).keySet(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        LinkedHashMap<String, d> r1 = this.f14514c;     // Catch: Throwable -> L38
        Iterator r17 = r16.iterator();     // Catch: Throwable -> L38
    L33:
        if (r17.hasNext() == false) goto L35;
        r1.remove((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L38
        goto L33
    L35:
        Set<Map.Entry<com.obric.agent.entitysync.c, List<c>>> r18 = this.f14515d.entrySet();     // Catch: Throwable -> L38
        o.c(r18, "<get-entries>(...)");     // Catch: Throwable -> L38
        p.a((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin"), new $$Lambda$h$v7Xlitn8daLkWDxcZWqWlDSrEM(r0, this));     // Catch: Throwable -> L38
        this.g = null;     // Catch: Throwable -> L38
        this.h = r0;     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L14:
        r4 = false;
    L17:
        r13 = null;
    L38:
        th = move-exception;
        throw th;
    }

    private static final boolean a(final m r2, final h r3, Map.Entry r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.aiagent.plugin");
        o.e(r5, "<destruct>");
        Object r6 = r5.getValue();
        o.c(r6, "component2(...)");
        List r7 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        p.a(r7, new $$Lambda$h$r91PP6rdDa7wAPhAbdXbCuXFiZE(r2, r3));
        return r7.isEmpty();
    }

    private static final boolean a(final m r10, final h r11, c r12) {
        o.e(r12, "history");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r12.a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L3:
        boolean r4 = true;
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin")).a() <= r10.d()) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L3;
        r1.add(r3);
        goto L3
    L11:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L13:
        if (r7.hasNext() == false) goto L20;
        Object r8 = r7.next();
        if (((a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin")).e() != null) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == false) goto L13;
        r6.add(r8);
        goto L13
    L17:
        r9 = false;
        goto L18
    L20:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r13.hasNext() == false) goto L24;
        ((a) ZeusTransformUtils.preCheckCast(r13.next(), a.class, "com.obric.aiagent.plugin")).a(Long.valueOf(r10.a()));
        goto L22
    L24:
        p.a(r12.a(), new $$Lambda$h$_HCZUjsE5ITQQqKREHWfTRaiQKE(r10, r11));
        return r12.a().isEmpty();
    }

    private static final boolean a(m r5, h r6, a r7) {
        o.e(r7, "event");
        Long r8 = r7.e();
        if (r8 != null) goto L5;
        return false;
    L5:
        if (((r5.a() - r8.longValue()) + 1) < r6.f14513b) goto L9;
        return true;
    L9:
        return false;
    }

    public final synchronized Set<String> a() {
        monitor-enter(this);
        Set<String> r0 = this.f14514c.keySet();     // Catch: Throwable -> L6
        o.c(r0, "<get-keys>(...)");     // Catch: Throwable -> L6
        Set<String> r1 = p.q((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Set<String> b() {
        monitor-enter(this);
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.f14514c, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L15
        Iterator r2 = r0.entrySet().iterator();     // Catch: Throwable -> L15
    L5:
        if (r2.hasNext() == false) goto L12;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (((d) ZeusTransformUtils.preCheckCast(r3.getValue(), d.class, "com.obric.aiagent.plugin")).a() != this.f14516e) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L5;
        r1.put(r3.getKey(), r3.getValue());     // Catch: Throwable -> L15
        goto L5
    L9:
        r4 = false;
        goto L10
    L12:
        Set<String> r5 = ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).keySet();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r5;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized Set<String> a(g r11) {
        monitor-enter(this);
        o.e(r11, "change");     // Catch: Throwable -> L21
        if (r11 == g.f14509c) goto L8;
        Set<String> r12 = b();     // Catch: Throwable -> L21
        monitor-exit(this);
        return r12;
    L8:
        long r0 = d.l.n.a((this.f14516e - 5) + 1, 1);     // Catch: Throwable -> L21
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(this.f14514c, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        LinkedHashMap r2 = new LinkedHashMap();     // Catch: Throwable -> L21
        Iterator r14 = r13.entrySet().iterator();     // Catch: Throwable -> L21
    L10:
        if (r14.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        d r4 = (d) ZeusTransformUtils.preCheckCast(r3.getValue(), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        long r5 = this.f14516e;     // Catch: Throwable -> L21
        long r7 = r4.a();     // Catch: Throwable -> L21
        boolean r9 = false;
        if (r0 <= r7) goto L14;
    L16:
        if (r9 == false) goto L10;
        r2.put(r3.getKey(), r3.getValue());     // Catch: Throwable -> L21
        goto L10
    L14:
        if (r7 > r5) goto L16;
        r9 = true;
        goto L16
    L18:
        Set<String> r15 = ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")).keySet();     // Catch: Throwable -> L21
        monitor-exit(this);
        return r15;
    L21:
        th = move-exception;
        throw th;
    }

    public final synchronized i a(com.obric.agent.entitysync.c r6) {
        monitor-enter(this);
        o.e(r6, DownloadHelper.IDENTITY);     // Catch: Throwable -> L13
        Collection<d> r0 = this.f14514c.values();     // Catch: Throwable -> L13
        o.c(r0, "<get-values>(...)");     // Catch: Throwable -> L13
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L13
    L4:
        i r2 = null;
        if (r1.hasNext() == false) goto L11;
        e r3 = (e) ZeusTransformUtils.preCheckCast(((d) ZeusTransformUtils.preCheckCast(r1.next(), d.class, "com.obric.aiagent.plugin")).b().get(r6), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r3 == null) goto L10;
        r2 = r3.a();     // Catch: Throwable -> L13
    L10:
        if (r2 == null) goto L4;
    L11:
        monitor-exit(this);
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    private static final d.n.j a(d r2) {
        o.e(r2, "it");
        return p.y((Iterable) ZeusTransformUtils.preCheckCast(r2.b().keySet(), Iterable.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized com.obric.agent.entitysync.c a(String r9, int r10, String r11) {
        monitor-enter(this);
        o.e(r9, "packageName");     // Catch: Throwable -> L37
        o.e(r11, DbHelper.COL_ID);     // Catch: Throwable -> L37
        Collection<d> r0 = this.f14514c.values();     // Catch: Throwable -> L37
        o.c(r0, "<get-values>(...)");     // Catch: Throwable -> L37
        d.n.j r1 = d.n.m.c(p.y((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$h$O4FrC29WclRTk7TlQJSNTqO4AVk.INSTANCE);     // Catch: Throwable -> L37
        Iterator r2 = r1.a();     // Catch: Throwable -> L37
    L4:
        com.obric.agent.entitysync.c r5 = null;
        Object r6 = null;
        if (r2.hasNext() == false) goto L16;
        Object r3 = r2.next();     // Catch: Throwable -> L37
        com.obric.agent.entitysync.c r7 = (com.obric.agent.entitysync.c) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.entitysync.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r7.getType() == r10) goto L9;
    L13:
        Object[] r8 = false;
    L14:
        if (r8 == false) goto L4;
    L17:
        com.obric.agent.entitysync.c r4 = (com.obric.agent.entitysync.c) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.entitysync.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r4 == null) goto L20;
        r5 = r4;
    L35:
        monitor-exit(this);
        return r5;
    L20:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L35;
        Iterator r12 = r1.a();     // Catch: Throwable -> L37
    L23:
        if (r12.hasNext() == false) goto L32;
        Object r13 = r12.next();     // Catch: Throwable -> L37
        com.obric.agent.entitysync.c r14 = (com.obric.agent.entitysync.c) ZeusTransformUtils.preCheckCast(r13, com.obric.agent.entitysync.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r14.getType() == r10) goto L27;
    L29:
        Object[] r15 = false;
    L30:
        if (r15 == false) goto L23;
        r6 = r13;
        goto L32
    L27:
        if (o.a(r14.b(), r11) == false) goto L29;
        r15 = true;
    L32:
        r5 = (com.obric.agent.entitysync.c) ZeusTransformUtils.preCheckCast(r6, com.obric.agent.entitysync.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        goto L35
    L9:
        if (o.a(r7.b(), r11) == false) goto L13;
        if (o.a(r7.a(), r9) == false) goto L13;
        r8 = true;
        goto L14
    L16:
        r3 = null;
    L37:
        th = move-exception;
        throw th;
    }

    private final d.m<String, j> b(List<a> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        a r8 = (a) ZeusTransformUtils.preCheckCast(p.k(r6), a.class, "com.obric.aiagent.plugin");
        a r1 = (a) ZeusTransformUtils.preCheckCast(p.m(r6), a.class, "com.obric.aiagent.plugin");
        String r3 = "delete";
        if (o.a(r1.d(), "delete") == true) goto L19;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        boolean r4 = false;
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L8;
    L10:
        Iterator r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L16;
        if (o.a(((a) ZeusTransformUtils.preCheckCast(r10.next(), a.class, "com.obric.aiagent.plugin")).d(), "replace") == false) goto L12;
        r4 = true;
    L16:
        if (r4 == false) goto L18;
        r3 = "replace";
        goto L19
    L18:
        r3 = "update";
        goto L19
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
    L19:
        String r11 = r8.b();
        JsonObject r0 = r1.c().c().deepCopy();
        o.c(r0, "deepCopy(...)");
        return s.a(r11, new j(r0, r3));
    }

    private final boolean a(String r1, String r2) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (o.a(r1, r2) == false) goto L6;
        return true;
    }

    private final boolean b(String r1, String r2) {
        return o.a(r1, r2);
    }
}
