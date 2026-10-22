package com.obric.agent.trace.toolmetrics;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: OmniClientToolTraceState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0321a f15866a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f15868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f15869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Long f15870e;
    private Long f;
    private String g;
    private Boolean h;
    private l i;
    private k j;
    private Long k;
    private Long l;
    private Long m;
    private long n;
    private String o;
    private final StringBuilder p;
    private y q;
    private m r;
    private m s;
    private final Map<String, Object> t;

    /* JADX INFO: renamed from: com.obric.agent.trace.toolmetrics.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OmniClientToolTraceState.kt */
    private static final class C0321a {
        public /* synthetic */ C0321a(d.h.b.h r1) {
            this();
        }

        private C0321a() {
        }
    }

    static {
        f15866a = new C0321a(null);
    }

    public a(String r2, long r3, long r5) {
        d.h.b.o.e(r2, "traceId");
        this.f15867b = r2;
        this.f15868c = r3;
        this.f15869d = r5;
        this.n = r3;
        this.o = "core.started";
        this.p = new StringBuilder("core.started");
        this.t = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public final String a() {
        return this.f15867b;
    }

    public final long b() {
        return this.f15868c;
    }

    public final long c() {
        return this.f15869d;
    }

    public final void a(Long r1) {
        this.f15870e = r1;
    }

    public final void b(Long r1) {
        this.f = r1;
    }

    public final void a(String r1) {
        this.g = r1;
    }

    public final void a(Boolean r1) {
        this.h = r1;
    }

    public final void a(l r1) {
        this.i = r1;
    }

    public final l d() {
        return this.i;
    }

    public final void a(k r1) {
        this.j = r1;
    }

    public final k e() {
        return this.j;
    }

    public final void c(Long r1) {
        this.k = r1;
    }

    public final Long f() {
        return this.k;
    }

    public final void d(Long r1) {
        this.l = r1;
    }

    public final Long g() {
        return this.l;
    }

    public final void e(Long r1) {
        this.m = r1;
    }

    public final void a(long r1) {
        this.n = r1;
    }

    public final long h() {
        return this.n;
    }

    public final void b(String r1) {
        this.o = r1;
    }

    public final StringBuilder i() {
        return this.p;
    }

    public final void a(y r1) {
        this.q = r1;
    }

    public final y j() {
        return this.q;
    }

    public final void a(m r1) {
        this.r = r1;
    }

    public final m k() {
        return this.r;
    }

    public final void b(m r1) {
        this.s = r1;
    }

    public final m l() {
        return this.s;
    }

    public final Map<String, Object> m() {
        return this.t;
    }

    public static /* synthetic */ w a(a r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.f(r1);
    }

    public final w f(Long r26) {
        String r2 = this.f15867b;
        l r3 = o();
        k r1 = this.j;
        if (r1 != null) goto L5;
        k r4 = new k(null, null, null, null, 15, null);
    L6:
        Long r5 = this.f15870e;
        Long r6 = this.f;
        String r7 = this.g;
        Boolean r8 = this.h;
        long r9 = this.f15868c;
        Long r11 = this.k;
        Long r12 = this.l;
        Long r13 = this.m;
        long r14 = this.n;
        String r10 = this.o;
        String r15 = this.p.toString();
        d.h.b.o.c(r15, "toString(...)");
        y r16 = this.q;
        if (r16 != null) goto L10;
        r16 = y.f15947d;
    L10:
        return new w(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r10, r15, r16, this.r, this.s, r26, ao.d(this.t));
    L5:
        r4 = r1;
        goto L6
    }

    public final long n() {
        Long r0 = this.f15870e;
        if (r0 == null) goto L6;
        return r0.longValue();
    L6:
        return this.f15868c;
    }

    private final l o() {
        l r1 = this.i;
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new l(SensitiveType.UNKNOWN, SensitiveType.UNKNOWN, SensitiveType.UNKNOWN);
    }
}
