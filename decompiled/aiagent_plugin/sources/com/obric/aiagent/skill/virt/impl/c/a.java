package com.obric.aiagent.skill.virt.impl.c;

import android.os.SystemClock;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.virt.api.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ce;
import kotlinx.coroutines.co;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: ShellManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0474a f22080a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.skill.virt.impl.a.k f22081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.aiagent.skill.virt.impl.c.b f22082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final am f22083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, e> f22084e;
    private final ConcurrentHashMap.KeySetView<String, Boolean> f;
    private final Object g;
    private final Set<String> h;
    private final Object i;
    private final LinkedHashSet<String> j;
    private final IdentityHashMap<b, Set<String>> k;
    private b l;
    private w<x> m;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShellManager.kt */
    private static final class C0474a {
        public /* synthetic */ C0474a(d.h.b.h r1) {
            this();
        }

        private C0474a() {
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    private static final class b {
        public b() {
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    private static final class c extends d.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0475a f22085a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f22086b;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.c.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ShellManager.kt */
        public static final class C0475a implements d.c.g.c<c> {
            public /* synthetic */ C0475a(d.h.b.h r1) {
                this();
            }

            private C0475a() {
            }
        }

        static {
            f22085a = new C0475a(null);
        }

        public final b a() {
            return this.f22086b;
        }

        public c(b r4) {
            d.h.b.o.e(r4, "owner");
            super((d.c.g.c) ZeusTransformUtils.preCheckCast(f22085a, d.c.g.c.class, "com.obric.aiagent.plugin"));
            this.f22086b = r4;
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f22087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f22089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f22090d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f22091e;
        private final String f;
        private final boolean g;
        private final Integer h;
        private final boolean i;
        private final long j;
        private final long k;
        private final String l;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f22087a, r10.f22087a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f22088b, r10.f22088b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f22089c, r10.f22089c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f22090d, r10.f22090d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f22091e, r10.f22091e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r10.g) goto L30;
            return false;
        L30:
            if (d.h.b.o.a(this.h, r10.h) == true) goto L33;
            return false;
        L33:
            if (this.i == r10.i) goto L36;
            return false;
        L36:
            if (this.j == r10.j) goto L39;
            return false;
        L39:
            if (this.k == r10.k) goto L42;
            return false;
        L42:
            if (d.h.b.o.a(this.l, r10.l) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((((((this.f22087a.hashCode() * 31) + this.f22088b.hashCode()) * 31) + this.f22089c.hashCode()) * 31) + this.f22090d.hashCode()) * 31) + this.f22091e.hashCode()) * 31) + this.f.hashCode()) * 31) + Boolean.hashCode(this.g)) * 31;
            Integer r1 = this.h;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((((r0 + r3) * 31) + Boolean.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31) + Long.hashCode(this.k)) * 31;
            String r5 = this.l;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("ExecutionSnapshot(groupId=").append(this.f22087a).append(", executionId=").append(this.f22088b).append(", backendType=").append(this.f22089c).append(", workDir=").append(this.f22090d).append(", command=").append(this.f22091e).append(", status=").append(this.f).append(", completed=").append(this.g).append(", exitCode=").append(this.h).append(", killed=").append(this.i).append(", startedAtMs=").append(this.j).append(", durationMs=").append(this.k).append(", clientEgressResultJson=");
            r0.append(this.l).append(')');
            return r0.toString();
        }

        public d(String r2, String r3, String r4, String r5, String r6, String r7, boolean r8, Integer r9, boolean r10, long r11, long r13, String r15) {
            d.h.b.o.e(r2, "groupId");
            d.h.b.o.e(r3, "executionId");
            d.h.b.o.e(r4, "backendType");
            d.h.b.o.e(r5, "workDir");
            d.h.b.o.e(r6, "command");
            d.h.b.o.e(r7, "status");
            this.f22087a = r2;
            this.f22088b = r3;
            this.f22089c = r4;
            this.f22090d = r5;
            this.f22091e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r13;
            this.l = r15;
        }

        public final String a() {
            return this.f22087a;
        }

        public final String b() {
            return this.f22088b;
        }

        public final String c() {
            return this.f22090d;
        }

        public final String d() {
            return this.f22091e;
        }

        public final String e() {
            return this.f;
        }

        public final boolean f() {
            return this.g;
        }

        public final Integer g() {
            return this.h;
        }

        public final boolean h() {
            return this.i;
        }

        public final long i() {
            return this.j;
        }

        public final long j() {
            return this.k;
        }

        public final String k() {
            return this.l;
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.virt.impl.a.f f22092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f22094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f22095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f22096e;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
            return false;
        L8:
            e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f22092a, r10.f22092a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f22093b, r10.f22093b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f22094c, r10.f22094c) == true) goto L18;
            return false;
        L18:
            if (this.f22095d == r10.f22095d) goto L21;
            return false;
        L21:
            if (this.f22096e == r10.f22096e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f22092a.hashCode() * 31) + this.f22093b.hashCode()) * 31) + this.f22094c.hashCode()) * 31) + Long.hashCode(this.f22095d)) * 31) + Long.hashCode(this.f22096e);
        }

        public String toString() {
            return "ManagedExecution(calling=" + this.f22092a + ", backendType=" + this.f22093b + ", workDir=" + this.f22094c + ", startedAtMs=" + this.f22095d + ", hardTimeoutMs=" + this.f22096e + ')';
        }

        public e(com.obric.aiagent.skill.virt.impl.a.f r2, String r3, String r4, long r5, long r7) {
            d.h.b.o.e(r2, "calling");
            d.h.b.o.e(r3, "backendType");
            d.h.b.o.e(r4, "workDir");
            this.f22092a = r2;
            this.f22093b = r3;
            this.f22094c = r4;
            this.f22095d = r5;
            this.f22096e = r7;
        }

        public final com.obric.aiagent.skill.virt.impl.a.f a() {
            return this.f22092a;
        }

        public final String b() {
            return this.f22093b;
        }

        public final String c() {
            return this.f22094c;
        }

        public final long d() {
            return this.f22095d;
        }

        public final long e() {
            return this.f22096e;
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f22097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.aiagent.skill.virt.api.o f22098b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f22097a, r6.f22097a) == true) goto L12;
            return false;
        L12:
            if (this.f22098b == r6.f22098b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f22097a.hashCode() * 31) + this.f22098b.hashCode();
        }

        public String toString() {
            return "ObservedExecutionResult(snapshot=" + this.f22097a + ", returnReason=" + this.f22098b + ')';
        }

        public f(d r2, com.obric.aiagent.skill.virt.api.o r3) {
            d.h.b.o.e(r2, "snapshot");
            d.h.b.o.e(r3, "returnReason");
            this.f22097a = r2;
            this.f22098b = r3;
        }

        public final d a() {
            return this.f22097a;
        }

        public final com.obric.aiagent.skill.virt.api.o b() {
            return this.f22098b;
        }

        public /* synthetic */ f(d r1, com.obric.aiagent.skill.virt.api.o r2, int r3, d.h.b.h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = com.obric.aiagent.skill.virt.api.o.f21585a;
        L5:
            this(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    @d.c.b.a.f(b = "ShellManager.kt", c = {476}, d = "acquireShell", e = "com.obric.aiagent.skill.virt.impl.shell.ShellManager")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f22101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f22102d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f22103e;
        final /* synthetic */ a f;
        int g;

        g(a r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            this.f22103e = r4;
            this.g |= Integer.MIN_VALUE;
            return a.a(this.f, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    @d.c.b.a.f(b = "ShellManager.kt", c = {476}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.shell.ShellManager$acquireShell$2")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w<x> f22105b;

        h(w<x> r3, d.c.d<? super h> r4) {
            w<x> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22105b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f22105b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22104a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            w<x> r6 = this.f22105b;
            d.c.d<? super x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22104a = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    @d.c.b.a.f(b = "ShellManager.kt", c = {360}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.shell.ShellManager$executeSync$2")
    static final class i extends d.c.b.a.l implements d.h.a.b<d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f22106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f22107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f22108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.api.q f22109d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f22110e;
        final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.b f;

        i(com.obric.aiagent.skill.virt.api.q r3, a r4, com.obric.aiagent.skill.virt.impl.a.b r5, d.c.d<? super i> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22109d = r3;
            this.f22110e = r4;
            this.f = r5;
            super(1, r7);
        }

        public final Object a(d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c> r3) {
            return ((i) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f22109d, this.f22110e, this.f, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r28) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f22108c;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            long r3 = this.f22107b;
            long r7 = this.f22106a;
            d.o.a(r28);     // Catch: Throwable -> L8 CancellationException -> L10
            long r9 = r3;
            Object r4 = r28;
        L22:
            com.obric.aiagent.skill.virt.impl.a.c r1 = (com.obric.aiagent.skill.virt.impl.a.c) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.virt.impl.a.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37 CancellationException -> L46
            com.obric.aiagent.skill.virt.impl.c.b r11 = a.b(this.f22110e);     // Catch: Throwable -> L37 CancellationException -> L46
            com.obric.aiagent.skill.virt.api.q r5 = this.f22109d;     // Catch: Throwable -> L37 CancellationException -> L46
            if (r5 == null) goto L26;
            String r6 = r5.b();     // Catch: Throwable -> L37 CancellationException -> L46
            if (r6 == null) goto L26;
        L27:
            String r12 = r6;
            String r13 = a.a(this.f22110e).a();     // Catch: Throwable -> L37 CancellationException -> L46
            String r14 = this.f.a();     // Catch: Throwable -> L37 CancellationException -> L46
            if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.virt.impl.a.c.a.class) == false) goto L31;
            com.obric.aiagent.skill.virt.impl.c.b.c r8 = (com.obric.aiagent.skill.virt.impl.c.b.c) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.impl.c.b.c.C0477b(((com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin")).c()), com.obric.aiagent.skill.virt.impl.c.b.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37 CancellationException -> L46
        L33:
            r11.a(r12, r13, r14, r8, true, r7, d.l.n.a(r9 - r7, 0), 0, r1.a().length(), r1.b().length());     // Catch: Throwable -> L37 CancellationException -> L46
            return r1;
        L31:
            if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.virt.impl.a.c.b.class) == false) goto L36;
            r8 = (com.obric.aiagent.skill.virt.impl.c.b.c) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.virt.impl.c.b.c.d.f22163a, com.obric.aiagent.skill.virt.impl.c.b.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37 CancellationException -> L46
            goto L33
        L36:
            throw new d.k();     // Catch: Throwable -> L37 CancellationException -> L46
        L26:
            r6 = this.f.d();     // Catch: Throwable -> L37 CancellationException -> L46
            goto L27
        L10:
            e = e;
            long r15 = r7;
        L48:
            com.obric.aiagent.skill.virt.impl.c.b r10 = a.b(this.f22110e);
            com.obric.aiagent.skill.virt.api.q r16 = this.f22109d;
            if (r16 == null) goto L52;
            String r17 = r16.b();
            if (r17 == null) goto L52;
        L53:
            r10.a(r17, a.a(this.f22110e).a(), this.f.a(), (com.obric.aiagent.skill.virt.impl.c.b.c) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.virt.impl.c.b.c.a.f22160a, com.obric.aiagent.skill.virt.impl.c.b.c.class, "com.obric.aiagent.plugin"), true, r15, d.l.n.a(r3 - r15, 0), 0, 0, 0);
            throw e;
        L52:
            r17 = this.f.d();
        L8:
            th = th;
            long r18 = r7;
        L39:
            com.obric.aiagent.skill.virt.impl.c.b r19 = a.b(this.f22110e);
            com.obric.aiagent.skill.virt.api.q r20 = this.f22109d;
            if (r20 == null) goto L43;
            String r21 = r20.b();
            if (r21 == null) goto L43;
        L44:
            r19.a(r21, a.a(this.f22110e).a(), this.f.a(), (com.obric.aiagent.skill.virt.impl.c.b.c) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.virt.impl.c.b.c.C0478c.f22162a, com.obric.aiagent.skill.virt.impl.c.b.c.class, "com.obric.aiagent.plugin"), false, r18, d.l.n.a(r3 - r18, 0), 0, 0, 0);
            throw th;
        L43:
            r21 = this.f.d();
            goto L44
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r28);
            com.obric.aiagent.skill.virt.api.q r22 = this.f22109d;
            if (r22 == null) goto L17;
            r7 = r22.c();
        L18:
            r9 = SystemClock.elapsedRealtime();
            com.obric.aiagent.skill.virt.impl.a.k r23 = a.a(this.f22110e);     // Catch: Throwable -> L37 CancellationException -> L46
            com.obric.aiagent.skill.virt.impl.a.b r110 = com.obric.aiagent.skill.virt.impl.a.b.a(this.f, null, a.a(this.f22110e).a(this.f.b()), 0, null, 13, null);     // Catch: Throwable -> L37 CancellationException -> L46
            d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c> r111 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37 CancellationException -> L46
            this.f22106a = r7;     // Catch: Throwable -> L37 CancellationException -> L46
            this.f22107b = r9;     // Catch: Throwable -> L37 CancellationException -> L46
            this.f22108c = 1;     // Catch: Throwable -> L37 CancellationException -> L46
            r4 = r23.a(r110, r111);     // Catch: Throwable -> L37 CancellationException -> L46
            if (r4 != r0) goto L22;
            return r0;
        L46:
            e = e;
            r15 = r7;
            r3 = r9;
        L37:
            th = th;
            r18 = r7;
            r3 = r9;
            goto L39
        L17:
            r7 = SystemClock.elapsedRealtime();
            goto L18
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class j<T> implements Comparator {
        public j() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin")).d()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin")).d()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    @d.c.b.a.f(b = "ShellManager.kt", c = {437}, d = "reconcileExclusiveExecutions", e = "com.obric.aiagent.skill.virt.impl.shell.ShellManager")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f22113c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f22114d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f22115e;

        k(a r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22114d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22113c = r3;
            this.f22115e |= Integer.MIN_VALUE;
            return a.a(this.f22114d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    @d.c.b.a.f(b = "ShellManager.kt", c = {442}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.shell.ShellManager$reconcileExclusiveExecutions$3")
    static final class l extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set<String> f22117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f22118c;

        l(Set<String> r3, a r4, d.c.d<? super l> r5) {
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22117b = r6;
            this.f22118c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f22117b, this.f22118c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22116a;
            if (r1 == 0) goto L8;
            if (r1 == 1) goto L8;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
        L9:
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(this.f22117b, Iterable.class, "com.obric.aiagent.plugin");
            a r2 = this.f22118c;
            boolean r5 = false;
            if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L12;
        L14:
            Iterator r10 = r9.iterator();
        L16:
            if (r10.hasNext() == false) goto L25;
            d r4 = r2.c((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin"));
            if (r4 != null) goto L20;
        L22:
            boolean r6 = false;
        L23:
            if (r6 == false) goto L16;
            r5 = true;
            goto L25
        L20:
            if (r4.f() == true) goto L22;
            r6 = true;
        L25:
            if (r5 == false) goto L30;
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22116a = 1;
            if (ax.a(250, r11) != r0) goto L9;
            return r0;
        L30:
            return x.f38692a;
        L12:
            if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L14;
            goto L14
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    @d.c.b.a.f(b = "ShellManager.kt", c = {713}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.shell.ShellManager$scheduleHardTimeoutWatchdog$1")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f22120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f22121c;

        m(e r3, a r4, d.c.d<? super m> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22120b = r3;
            this.f22121c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f22120b, this.f22121c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22119a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            d r7 = this.f22121c.c(this.f22120b.a().a());
            if (r7 != null) goto L16;
            return x.f38692a;
        L16:
            if (r7.f() == false) goto L20;
            return x.f38692a;
        L20:
            if (IAppContext.Companion.isDebug() == false) goto L22;
            ILogDepend.Companion.w("Virt/Shell", "Killing shell execution " + this.f22120b.a().a() + " after hard timeout " + this.f22120b.e() + "ms");
        L23:
            a.a(this.f22121c, this.f22120b.a().a());
            return x.f38692a;
        L22:
            ILogDepend.Companion.w("Virt/Shell", "Killing shell execution after hard timeout " + this.f22120b.e() + "ms");
            goto L23
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            long r3 = this.f22120b.e();
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22119a = 1;
            if (ax.a(r3, r8) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    @d.c.b.a.f(b = "ShellManager.kt", c = {272, 274, 283, 302, 307, 343}, d = "startAsync", e = "com.obric.aiagent.skill.virt.impl.shell.ShellManager")
    static final class n extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f22124c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f22125d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f22126e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        long m;
        long n;
        /* synthetic */ Object o;
        final /* synthetic */ a p;
        int q;

        n(a r3, d.c.d<? super n> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.p = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r20) {
            this.o = r20;
            this.q |= Integer.MIN_VALUE;
            return this.p.a(null, null, null, null, null, 0, null, null, 0, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    @d.c.b.a.f(b = "ShellManager.kt", c = {570}, d = "startAsyncCommand", e = "com.obric.aiagent.skill.virt.impl.shell.ShellManager")
    static final class o extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f22129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f22130d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f22131e;
        final /* synthetic */ a f;
        int g;

        o(a r3, d.c.d<? super o> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            this.f22131e = r12;
            this.g |= Integer.MIN_VALUE;
            return a.a(this.f, null, null, null, null, null, 0, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    @d.c.b.a.f(b = "ShellManager.kt", c = {150, 160}, d = "withExclusiveExecution", e = "com.obric.aiagent.skill.virt.impl.shell.ShellManager")
    static final class p<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f22134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f22135d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f22136e;
        int f;

        p(a r3, d.c.d<? super p> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22136e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22135d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f22136e.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    @d.c.b.a.f(b = "ShellManager.kt", c = {161}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.shell.ShellManager$withExclusiveExecution$cleanupError$1")
    static final class q extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f22138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f22139c;

        q(a r3, b r4, d.c.d<? super q> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22138b = r3;
            this.f22139c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((q) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new q(this.f22138b, this.f22139c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22137a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            a r7 = this.f22138b;
            Set r2 = a.a(r7, this.f22139c);
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22137a = 1;
            if (a.a(r7, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ShellManager.kt */
    @d.c.b.a.f(b = "ShellManager.kt", c = {152}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.shell.ShellManager$withExclusiveExecution$outcome$1")
    static final class r<T> extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super T>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f22141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<d.c.d<? super T>, Object> f22142c;

        r(d.h.a.a<x> r3, d.h.a.b<? super d.c.d<? super T>, ? extends Object> r4, d.c.d<? super r> r5) {
            d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.b<d.c.d<? super T>, Object> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22141b = r6;
            this.f22142c = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super T> r4) {
            return ((r) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new r(this.f22141b, this.f22142c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, Object r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22140a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r4);
            this.f22141b.invoke();
            d.h.a.b<d.c.d<? super T>, Object> r5 = this.f22142c;
            this.f22140a = 1;
            r4 = r5.invoke(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShellManager.kt */
    @d.c.b.a.f(b = "ShellManager.kt", c = {415, 417}, d = "withSyncAdmission", e = "com.obric.aiagent.skill.virt.impl.shell.ShellManager")
    static final class s<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f22145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f22146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f22147e;
        int f;

        s(a r3, d.c.d<? super s> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22147e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22146d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f22147e.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f22080a = new C0474a(null);
    }

    /* JADX INFO: renamed from: lambda$IxY6P0lCpuz_OzX4zsK9Hm-S3kg, reason: not valid java name */
    public static /* synthetic */ x m381lambda$IxY6P0lCpuz_OzX4zsK9HmS3kg(AtomicLong r0, d.h.a.b r1, com.obric.aiagent.skill.virt.api.r r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$QFjVObQR-5oEl404C-9lsSUfXCI, reason: not valid java name */
    public static /* synthetic */ boolean m382lambda$QFjVObQR5oEl404C9lsSUfXCI(a r0, String r1) {
        return b(r0, r1);
    }

    public a(com.obric.aiagent.skill.virt.impl.a.k r5, com.obric.aiagent.skill.virt.impl.c.b r6) {
        com.obric.aiagent.skill.virt.impl.a.k r7 = (com.obric.aiagent.skill.virt.impl.a.k) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.virt.impl.a.k.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "backend");
        d.h.b.o.e(r6, "executionMonitor");
        this.f22081b = r7;
        this.f22082c = r6;
        this.f22083d = an.a(bd.b().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin")));
        this.f22084e = new ConcurrentHashMap();
        this.f = ConcurrentHashMap.newKeySet();
        this.g = new Object();
        this.h = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        this.i = new Object();
        this.j = new LinkedHashSet();
        this.k = new IdentityHashMap();
        this.m = y.a(null, 1, null);
    }

    public static final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.k a(a r0) {
        return r0.f22081b;
    }

    public static final /* synthetic */ Object a(a r2, String r3, long r4, d.c.d r6) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r13, String r14, String r15, String r16, Map r17, String r18, long r19, String r21, d.h.a.b r22, d.c.d r23) {
        return r13.a(r14, r15, r16, (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin"), r18, r19, r21, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, Set r3, d.c.d r4) {
        return r2.a((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Set a(a r0, b r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ boolean a(a r0, String r1) {
        return r0.e(r1);
    }

    public static final /* synthetic */ com.obric.aiagent.skill.virt.impl.c.b b(a r0) {
        return r0.f22082c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.obric.aiagent.skill.virt.impl.c.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v2, types: [d.h.a.a] */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.obric.aiagent.skill.virt.impl.c.a$b] */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2, types: [d.h.a.b] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [com.obric.aiagent.skill.virt.impl.c.a] */
    /* JADX WARN: Type inference failed for: r12v8, types: [com.obric.aiagent.skill.virt.impl.c.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v9 */
    public final <T> Object a(d.h.a.a<x> r11, d.h.a.b<? super d.c.d<? super T>, ? extends Object> r12, d.c.d<? super T> r13) {
        ?? r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
        ?? r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, p.class) == false) goto L7;
        p r1 = (p) ZeusTransformUtils.preCheckCast(r16, p.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        Object r17 = r1.f22135d;
        Object r2 = d.c.a.b.a();
        int r3 = r1.f;
        Throwable r6 = null;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        Object r10 = r1.f22134c;
        b r18 = (b) ZeusTransformUtils.preCheckCast(r1.f22133b, b.class, "com.obric.aiagent.plugin");
        a r19 = (a) ZeusTransformUtils.preCheckCast(r1.f22132a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r17);     // Catch: Throwable -> L15
        ?? this = r10;
        r14 = r18;
        r15 = r19;
    L59:
    L43:
        r15.b(r14);
        Throwable r110 = d.n.c(this);
        if (r110 == null) goto L48;
        if (r6 == null) goto L67;
        r110.addSuppressed(r6);
        throw r110;
    L67:
        throw r110;
    L48:
        if (r6 != null) goto L51;
        d.o.a(this);
        return this;
    L51:
        throw r6;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        b r111 = (b) ZeusTransformUtils.preCheckCast(r1.f22133b, b.class, "com.obric.aiagent.plugin");
        a r112 = (a) ZeusTransformUtils.preCheckCast(r1.f22132a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r17);     // Catch: Throwable -> L22
        b r113 = r111;
        this = r112;
        Object r114 = r17;
    L35:
        Object r115 = d.n.f(r114);     // Catch: Throwable -> L37
        ?? r116 = this;
    L39:
        ?? r117 = r116;
        Object r118 = r115;
        b r119 = r113;
        d.c.g r120 = (d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        d.h.a.m r0 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new q(r117, r119, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        r1.f22132a = r117;     // Catch: Throwable -> L15
        r1.f22133b = r119;     // Catch: Throwable -> L15
        r1.f22134c = r118;     // Catch: Throwable -> L15
        r1.f = 2;     // Catch: Throwable -> L15
        this = r118;
        r14 = r119;
        r15 = r117;
        if (kotlinx.coroutines.i.a(r120, r0, r1) != r2) goto L59;
        return r2;
    L37:
        Throwable th = th;
    L38:
        d.n.a r121 = d.n.f38560a;
        r115 = d.n.f(d.o.a(th));
        r116 = this;
    L22:
        th = th;
        r113 = r111;
        this = r112;
        goto L38
    L24:
        d.o.a(r17);
        r113 = new b();
        Object r4 = this.i;
        monitor-enter(r4);
    L56:
        th = move-exception;
        throw th;
    L27:
        if (this.l != null) goto L55;
        String r5 = (String) ZeusTransformUtils.preCheckCast(d.a.p.f((Iterable) ZeusTransformUtils.preCheckCast(this.j, Iterable.class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        if (r5 != null) goto L53;
        this.l = r113;     // Catch: Throwable -> L56
        ((Map) ZeusTransformUtils.preCheckCast(this.k, Map.class, "com.obric.aiagent.plugin")).put(r113, new LinkedHashSet());     // Catch: Throwable -> L56
        x r7 = x.f38692a;     // Catch: Throwable -> L56
        monitor-exit(r4);
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L37
        d.c.g r9 = (d.c.g) ZeusTransformUtils.preCheckCast(new c(r113), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        d.h.a.m r122 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new r(r14, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        r1.f22132a = this;     // Catch: Throwable -> L37
        r1.f22133b = r113;     // Catch: Throwable -> L37
        r1.f = 1;     // Catch: Throwable -> L37
        r114 = kotlinx.coroutines.i.a(r9, r122, r1);     // Catch: Throwable -> L37
        this = this;
        if (r114 != r2) goto L35;
        return r2;
    L53:
        throw new v(r5, null, 2, null);     // Catch: Throwable -> L56
    L55:
        throw new v(null, "Virt is already executing an exclusive segment", 1, null);     // Catch: Throwable -> L56
    L15:
        th = move-exception;
        r6 = th;
    L7:
        r1 = new p(this, r16);
        goto L8
    }

    public final boolean a(String r5) {
        d.h.b.o.e(r5, "executionId");
        this.f.remove(r5);
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.f22084e.get(r5), e.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L12;
        ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).d(r5);
        return false;
    L12:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L8
        a r0 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        d.n.f(d.n.g(r1.a().e()));     // Catch: Throwable -> L8
    L10:
        this.f22084e.remove(r5);
        i(r5);
        d(r5);
        return true;
    L8:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L10
    }

    public final boolean b(String r13) {
        d.h.b.o.e(r13, "groupId");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (d.h.b.o.a(((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin")).a(), r13) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r6 = 0;
        int r7 = 0;
    L10:
        if (r5.hasNext() == false) goto L20;
        d r8 = (d) ZeusTransformUtils.preCheckCast(r5.next(), d.class, "com.obric.aiagent.plugin");
        if (a(r8.b()) == false) goto L10;
        r6 = r6 + 1;
    L15:
        th = move-exception;
        r7 = r7 + 1;
        if (IAppContext.Companion.isDebug() == true) goto L18;
        ILogDepend.Companion.e("Virt/Shell", "discard execution failed");
        goto L10
    L18:
        ILogDepend.Companion.e("Virt/Shell", "discard execution failed groupId=" + r13 + " executionId=" + r8.b(), th);
        goto L10
    L20:
        ILogDepend.Companion.i("Virt/Shell", "discardExecutions candidates=" + r4.size() + " discarded=" + r6 + " failed=" + r7);
        if (r7 != 0) goto L41;
        return true;
    L41:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x0493 -> B:13:0x00c1). Please report as a decompilation issue!!! */
    public final Object a(String r23, String r24, String r25, Map<String, String> r26, String r27, long r28, Long r30, Long r31, long r32, String r34, d.h.a.b<? super d.c.d<? super x>, ? extends Object> r35, d.h.a.m<? super d, ? super d.c.d<? super x>, ? extends Object> r36, d.h.a.b<? super com.obric.aiagent.skill.virt.api.r, x> r37, d.c.d<? super f> r38) {
        Long r4 = r30;
        String r8 = "com.obric.aiagent.plugin";
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r26, Map.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r35, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m r10 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r36, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.b r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r37, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r38, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, n.class) == false) goto L7;
        n r13 = (n) ZeusTransformUtils.preCheckCast(r12, n.class, "com.obric.aiagent.plugin");
        if ((r13.q & Integer.MIN_VALUE) == 0) goto L7;
        r13.q -= Integer.MIN_VALUE;
    L8:
        Object r14 = r13.o;
        Object r15 = d.c.a.b.a();
        switch(r13.q) {
            case 0: goto L27;
            case 1: goto L26;
            case 2: goto L21;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        long r0 = r13.n;
        long r2 = r13.m;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r13.f, e.class, "com.obric.aiagent.plugin");
        AtomicLong r6 = (AtomicLong) ZeusTransformUtils.preCheckCast(r13.f22126e, AtomicLong.class, "com.obric.aiagent.plugin");
        d.h.a.m r16 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r13.f22125d, d.h.a.m.class, "com.obric.aiagent.plugin");
        Long r17 = (Long) ZeusTransformUtils.preCheckCast(r13.f22124c, Long.class, "com.obric.aiagent.plugin");
        Long r18 = (Long) ZeusTransformUtils.preCheckCast(r13.f22123b, Long.class, "com.obric.aiagent.plugin");
        a r19 = (a) ZeusTransformUtils.preCheckCast(r13.f22122a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
        Object r110 = r15;
        d.h.a.m r20 = r16;
        a r21 = r19;
        AtomicLong r22 = r6;
        long r29 = r2;
        e r3 = r5;
    L13:
        long r33 = r29;
    L63:
        ce.b(r13.getContext());
        d r39 = r21.b(r3);
        r13.f22122a = r21;
        r13.f22123b = r18;
        r13.f22124c = r17;
        r13.f22125d = r20;
        r13.f22126e = r22;
        r13.f = r3;
        r13.g = r39;
        r13.m = r33;
        r13.n = r0;
        r13.q = 5;
        if (r20.invoke(r39, r13) != r110) goto L66;
        return r110;
    L66:
        long r210 = r33;
        e r40 = r3;
        d r41 = r39;
        long r42 = r210;
    L68:
        if (r41.f() == false) goto L72;
        return new f(r41, null, 2, 0 == true ? 1 : 0);
    L72:
        if ((System.currentTimeMillis() - r0) < r42) goto L80;
        r21.a(r41.b(), true);
        d r1 = r21.c(r41.b());
        if (r1 == null) goto L78;
        r41 = r1;
    L78:
        return new f(r41, com.obric.aiagent.skill.virt.api.o.f21587c);
    L80:
        if (r17 != null) goto L82;
    L85:
        long r111 = System.currentTimeMillis() - r22.get();
        if (r18 != null) goto L88;
    L91:
        r13.f22122a = r21;
        r13.f22123b = r18;
        r13.f22124c = r17;
        r13.f22125d = r20;
        r13.f22126e = r22;
        r13.f = r40;
        r13.g = null;
        r13.m = r42;
        r13.n = r0;
        r13.q = 6;
        if (ax.a(250, r13) != r110) goto L94;
        return r110;
    L94:
        r29 = r42;
        r3 = r40;
        goto L13
    L88:
        if (r111 < r18.longValue()) goto L91;
        return new f(r41, com.obric.aiagent.skill.virt.api.o.f21586b);
    L82:
        if (SystemClock.elapsedRealtime() < r17.longValue()) goto L85;
        return new f(r41, com.obric.aiagent.skill.virt.api.o.f21586b);
    L14:
        r0 = r13.n;
        r42 = r13.m;
        r41 = (d) ZeusTransformUtils.preCheckCast(r13.g, d.class, "com.obric.aiagent.plugin");
        r40 = (e) ZeusTransformUtils.preCheckCast(r13.f, e.class, "com.obric.aiagent.plugin");
        AtomicLong r43 = (AtomicLong) ZeusTransformUtils.preCheckCast(r13.f22126e, AtomicLong.class, "com.obric.aiagent.plugin");
        d.h.a.m r44 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r13.f22125d, d.h.a.m.class, "com.obric.aiagent.plugin");
        Long r112 = (Long) ZeusTransformUtils.preCheckCast(r13.f22124c, Long.class, "com.obric.aiagent.plugin");
        Long r113 = (Long) ZeusTransformUtils.preCheckCast(r13.f22123b, Long.class, "com.obric.aiagent.plugin");
        a r45 = (a) ZeusTransformUtils.preCheckCast(r13.f22122a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
        r110 = r15;
        r20 = r44;
        r17 = r112;
        r18 = r113;
        r21 = r45;
        r22 = r43;
        goto L68
    L15:
        r0 = r13.n;
        long r46 = r13.m;
        e r47 = (e) ZeusTransformUtils.preCheckCast(r13.f, e.class, "com.obric.aiagent.plugin");
        AtomicLong r48 = (AtomicLong) ZeusTransformUtils.preCheckCast(r13.f22126e, AtomicLong.class, "com.obric.aiagent.plugin");
        d.h.a.m r49 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r13.f22125d, d.h.a.m.class, "com.obric.aiagent.plugin");
        r17 = (Long) ZeusTransformUtils.preCheckCast(r13.f22124c, Long.class, "com.obric.aiagent.plugin");
        r18 = (Long) ZeusTransformUtils.preCheckCast(r13.f22123b, Long.class, "com.obric.aiagent.plugin");
        a r50 = (a) ZeusTransformUtils.preCheckCast(r13.f22122a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
        r20 = r49;
        r21 = r50;
        r22 = r48;
        Object r51 = r15;
        r3 = r47;
        r33 = r46;
    L62:
        r110 = r51;
        goto L63
    L16:
        long r52 = r13.m;
        AtomicLong r53 = (AtomicLong) ZeusTransformUtils.preCheckCast(r13.f, AtomicLong.class, "com.obric.aiagent.plugin");
        d.h.a.m r54 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r13.f22126e, d.h.a.m.class, "com.obric.aiagent.plugin");
        Long r55 = (Long) ZeusTransformUtils.preCheckCast(r13.f22125d, Long.class, "com.obric.aiagent.plugin");
        Long r56 = (Long) ZeusTransformUtils.preCheckCast(r13.f22124c, Long.class, "com.obric.aiagent.plugin");
        String r57 = (String) ZeusTransformUtils.preCheckCast(r13.f22123b, String.class, "com.obric.aiagent.plugin");
        a r58 = (a) ZeusTransformUtils.preCheckCast(r13.f22122a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r14);     // Catch: Throwable -> L19
        r17 = r55;
        r18 = r56;
        String r114 = r57;
        r8 = "com.obric.aiagent.plugin";
        AtomicLong r59 = r53;
        d.h.a.m r60 = r54;
        r51 = r15;
    L57:
        e r61 = (e) ZeusTransformUtils.preCheckCast(r14, e.class, r8);     // Catch: Throwable -> L95
        long r115 = System.currentTimeMillis();
        d r62 = r58.b(r61);
        r13.f22122a = r58;
        r13.f22123b = r18;
        r13.f22124c = r17;
        r13.f22125d = r60;
        r13.f22126e = r59;
        r13.f = r61;
        r13.m = r52;
        r13.n = r115;
        r13.q = 4;
        if (r60.invoke(r62, r13) != r51) goto L61;
        return r51;
    L61:
        r3 = r61;
        r20 = r60;
        r21 = r58;
        r22 = r59;
        r33 = r52;
        r0 = r115;
    L95:
        Throwable th = th;
        r57 = r114;
    L97:
        r58.d(r57);
        throw th;
    L19:
        th = th;
        goto L97
    L21:
        long r63 = r13.m;
        final d.h.a.b r64 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r13.k, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m r65 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r13.j, d.h.a.m.class, "com.obric.aiagent.plugin");
        String r66 = (String) ZeusTransformUtils.preCheckCast(r13.i, String.class, "com.obric.aiagent.plugin");
        Long r67 = (Long) ZeusTransformUtils.preCheckCast(r13.h, Long.class, "com.obric.aiagent.plugin");
        Long r68 = (Long) ZeusTransformUtils.preCheckCast(r13.g, Long.class, "com.obric.aiagent.plugin");
        String r69 = (String) ZeusTransformUtils.preCheckCast(r13.f, String.class, "com.obric.aiagent.plugin");
        Map<String, String> r116 = (Map) ZeusTransformUtils.preCheckCast(r13.f22126e, Map.class, "com.obric.aiagent.plugin");
        r114 = (String) ZeusTransformUtils.preCheckCast(r13.f22125d, String.class, "com.obric.aiagent.plugin");
        String r117 = (String) ZeusTransformUtils.preCheckCast(r13.f22124c, String.class, "com.obric.aiagent.plugin");
        String r70 = (String) ZeusTransformUtils.preCheckCast(r13.f22123b, String.class, "com.obric.aiagent.plugin");
        a r71 = (a) ZeusTransformUtils.preCheckCast(r13.f22122a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r14);     // Catch: Throwable -> L24
        r58 = r71;
        d.h.a.m r118 = r65;
        String r119 = r66;
        Long r72 = r67;
        r4 = r68;
        r8 = "com.obric.aiagent.plugin";
        String r73 = r69;
        r7 = r116;
        String r120 = r117;
        long r74 = r63;
        r51 = r15;
    L52:
        String r310 = r119;
        final AtomicLong r75 = new AtomicLong(System.currentTimeMillis());
        d.h.a.b<? super com.obric.aiagent.skill.virt.api.r, x> r121 = new $$Lambda$a$IxY6P0lCpuz_OzX4zsK9HmS3kg(r75, r64);     // Catch: Throwable -> L95
        r13.f22122a = r58;     // Catch: Throwable -> L95
        r13.f22123b = r114;     // Catch: Throwable -> L95
        r13.f22124c = r4;     // Catch: Throwable -> L95
        r13.f22125d = r72;     // Catch: Throwable -> L95
        r13.f22126e = r118;     // Catch: Throwable -> L95
        r13.f = r75;     // Catch: Throwable -> L95
        r13.g = null;     // Catch: Throwable -> L95
        r13.h = null;     // Catch: Throwable -> L95
        r13.i = null;     // Catch: Throwable -> L95
        r13.j = null;     // Catch: Throwable -> L95
        r13.k = null;     // Catch: Throwable -> L95
        r13.m = r74;     // Catch: Throwable -> L95
        r13.q = 3;     // Catch: Throwable -> L95
        Object r76 = r58.a(r70, r120, r114, r7, r73, r74, r310, r121, r13);     // Catch: Throwable -> L95
        if (r76 != r51) goto L56;
        return r51;
    L56:
        r59 = r75;
        r60 = r118;
        r14 = r76;
        long r211 = r74;
        r17 = r72;
        r18 = r4;
        r52 = r211;
    L24:
        th = th;
    L101:
        r71.d(r114);
        throw th;
    L26:
        long r77 = r13.m;
        d.h.a.b r122 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r13.l, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m r123 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r13.k, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.b r78 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r13.j, d.h.a.b.class, "com.obric.aiagent.plugin");
        String r79 = (String) ZeusTransformUtils.preCheckCast(r13.i, String.class, "com.obric.aiagent.plugin");
        Long r80 = (Long) ZeusTransformUtils.preCheckCast(r13.h, Long.class, "com.obric.aiagent.plugin");
        r4 = (Long) ZeusTransformUtils.preCheckCast(r13.g, Long.class, "com.obric.aiagent.plugin");
        r73 = (String) ZeusTransformUtils.preCheckCast(r13.f, String.class, "com.obric.aiagent.plugin");
        r7 = (Map) ZeusTransformUtils.preCheckCast(r13.f22126e, Map.class, "com.obric.aiagent.plugin");
        String r124 = (String) ZeusTransformUtils.preCheckCast(r13.f22125d, String.class, "com.obric.aiagent.plugin");
        String r81 = (String) ZeusTransformUtils.preCheckCast(r13.f22124c, String.class, "com.obric.aiagent.plugin");
        String r82 = (String) ZeusTransformUtils.preCheckCast(r13.f22123b, String.class, "com.obric.aiagent.plugin");
        r58 = (a) ZeusTransformUtils.preCheckCast(r13.f22122a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
        r119 = r79;
        Long r83 = r80;
        r118 = r123;
        d.h.a.b r84 = r122;
        r51 = r15;
        d.h.a.b r125 = r78;
        r74 = r77;
    L115:
        r13.f22122a = r58;     // Catch: Throwable -> L99
        r13.f22123b = r82;     // Catch: Throwable -> L99
        r13.f22124c = r81;     // Catch: Throwable -> L99
        r13.f22125d = r124;     // Catch: Throwable -> L99
        r13.f22126e = r7;     // Catch: Throwable -> L99
        r13.f = r73;     // Catch: Throwable -> L99
        r13.g = r4;     // Catch: Throwable -> L99
        r13.h = r83;     // Catch: Throwable -> L99
        r13.i = r119;     // Catch: Throwable -> L99
        r13.j = r118;     // Catch: Throwable -> L99
        r13.k = r84;     // Catch: Throwable -> L99
        r120 = r81;
        r13.l = null;     // Catch: Throwable -> L99
        r13.m = r74;     // Catch: Throwable -> L99
        r13.q = 2;     // Catch: Throwable -> L99
        if (r125.invoke(r13) != r51) goto L51;
        return r51;
    L51:
        r70 = r82;
        r72 = r83;
        r64 = r84;
        r114 = r124;
    L99:
        th = th;
        r71 = r58;
        r114 = r124;
        goto L101
    L27:
        d.o.a(r14);
        boolean r126 = false;
        if (r28 <= 0) goto L30;
        boolean r85 = true;
    L31:
        if (r85 == false) goto L108;
        if (r4 != null) goto L34;
    L37:
        boolean r86 = true;
    L38:
        if (r86 == false) goto L106;
        if (r31 != null) goto L41;
    L42:
        r126 = true;
    L43:
        if (r126 == false) goto L104;
        r13.f22122a = this;
        r13.f22123b = r23;
        r13.f22124c = r24;
        r13.f22125d = r25;
        r13.f22126e = r7;
        r13.f = r27;
        r13.g = r4;
        r13.h = r31;
        r119 = r34;
        r13.i = r119;
        r13.j = r9;
        r13.k = r10;
        r13.l = r11;
        r13.m = r28;
        r13.q = 1;
        r51 = r15;
        if (a(r25, r32, r13) != r51) goto L47;
        return r51;
    L47:
        r83 = r31;
        r84 = r11;
        r73 = r27;
        r124 = r25;
        r82 = r23;
        r125 = r9;
        r58 = this;
        r81 = r24;
        r118 = r10;
        r74 = r28;
        goto L115
    L104:
        throw new IllegalArgumentException("firstReturnDeadlineElapsedRealtimeMs must be > 0 when provided".toString());
    L41:
        if (r31.longValue() <= 0) goto L43;
    L106:
        throw new IllegalArgumentException("inactivityReturnTimeoutMs must be > 0 when provided".toString());
    L34:
        if (r30.longValue() > 0) goto L37;
        r86 = false;
        goto L38
    L108:
        throw new IllegalArgumentException("hardTimeoutMs must be > 0".toString());
    L30:
        r85 = false;
        goto L31
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r13 = new n(this, r12);
        goto L8
    }

    private static final x a(AtomicLong r2, d.h.a.b r3, com.obric.aiagent.skill.virt.api.r r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "event");
        r2.set(System.currentTimeMillis());
        r5.invoke(r4);
        return x.f38692a;
    }

    public final Object a(com.obric.aiagent.skill.virt.impl.a.b r4, com.obric.aiagent.skill.virt.api.q r5, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a((d.h.a.b) ZeusTransformUtils.preCheckCast(new i(r5, this, r4, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r7);
    }

    public final <T> Object a(d.h.a.b<? super d.c.d<? super T>, ? extends Object> r11, d.c.d<? super T> r12) {
        d.h.a.b r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, s.class) == false) goto L7;
        s r1 = (s) ZeusTransformUtils.preCheckCast(r14, s.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        Object r15 = r1.f22146d;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L18;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r1.f22144b, String.class, "com.obric.aiagent.plugin");
        a r16 = (a) ZeusTransformUtils.preCheckCast(r1.f22143a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r15);     // Catch: Throwable -> L15
    L27:
        r16.d(r10);
        return r15;
    L15:
        Throwable th = th;
    L31:
        r16.d(r10);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        String r17 = (String) ZeusTransformUtils.preCheckCast(r1.f22145c, String.class, "com.obric.aiagent.plugin");
        r13 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r1.f22144b, d.h.a.b.class, "com.obric.aiagent.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(r1.f22143a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
        String r18 = r17;
        a this = r0;
    L33:
        r1.f22143a = this;     // Catch: Throwable -> L29
        r1.f22144b = r18;     // Catch: Throwable -> L29
        r1.f22145c = null;     // Catch: Throwable -> L29
        r1.f = 2;     // Catch: Throwable -> L29
        Object r19 = r13.invoke(r1);     // Catch: Throwable -> L29
        if (r19 != r3) goto L26;
        return r3;
    L26:
        r16 = this;
        r10 = r18;
        r15 = r19;
    L29:
        th = move-exception;
        r16 = this;
        r10 = r18;
        th = th;
        goto L31
    L20:
        d.o.a(r15);
        r18 = "sync-" + UUID.randomUUID();
        r1.f22143a = this;
        r1.f22144b = r13;
        r1.f22145c = r18;
        r1.f = 1;
        if (a(r18, 0, r1) != r3) goto L33;
        return r3;
    L7:
        r1 = new s(this, r14);
        goto L8
    }

    private final Object a(Set<String> r8, d.c.d<? super x> r9) {
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, k.class) == false) goto L7;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r11, k.class, "com.obric.aiagent.plugin");
        if ((r0.f22115e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f22115e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f22113c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f22115e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r10 = (Set) ZeusTransformUtils.preCheckCast(r0.f22112b, Set.class, "com.obric.aiagent.plugin");
        a this = (a) ZeusTransformUtils.preCheckCast(r0.f22111a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
    L29:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L31:
        if (r13.hasNext() == false) goto L40;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
        d r1 = this.c(r14);
        boolean r4 = false;
        if (r1 != null) goto L35;
    L37:
        if (r4 == true) goto L31;
        this.d(r14);
        goto L31
    L35:
        if (r1.f() == true) goto L37;
        r4 = true;
        goto L37
    L40:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        if (r10.isEmpty() == true) goto L17;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r15.hasNext() == false) goto L26;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        d r6 = c(r5);
        if (r6 == null) goto L20;
        if (r6.f() == true) goto L20;
        a(r5, true);
        goto L20
    L26:
        d.h.a.m r16 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(r10, this, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.f22111a = this;
        r0.f22112b = r10;
        r0.f22115e = 1;
        if (dg.b(5000, r16, r0) != r2) goto L29;
        return r2;
    L17:
        return x.f38692a;
    L7:
        r0 = new k(this, r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0140 -> B:44:0x0143). Please report as a decompilation issue!!! */
    private final Object a(String r12, long r13, d.c.d<? super x> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, g.class) == false) goto L7;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r16, g.class, "com.obric.aiagent.plugin");
        if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
        r0.g -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f22103e;
        Object r1 = d.c.a.b.a();
        int r2 = r0.g;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        long r11 = r0.f22102d;
        b r14 = (b) ZeusTransformUtils.preCheckCast(r0.f22101c, b.class, "com.obric.aiagent.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r0.f22100b, String.class, "com.obric.aiagent.plugin");
        a r3 = (a) ZeusTransformUtils.preCheckCast(r0.f22099a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r17);
        long r5 = r11;
        r12 = r18;
        a this = r3;
    L44:
        if (r17 == null) goto L47;
    L19:
        Object r19 = this.i;
        monitor-enter(r19);
        if (r14 != null) goto L53;
    L30:
        String r110 = (String) ZeusTransformUtils.preCheckCast(d.a.p.f((Iterable) ZeusTransformUtils.preCheckCast(this.j, Iterable.class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        if (r110 != null) goto L49;
        if (this.l != null) goto L37;
        ((Collection) ZeusTransformUtils.preCheckCast(this.j, Collection.class, "com.obric.aiagent.plugin")).add(r12);     // Catch: Throwable -> L50
        x r111 = x.f38692a;     // Catch: Throwable -> L50
        monitor-exit(r19);
        return r111;
    L37:
        w<x> r112 = this.m;     // Catch: Throwable -> L50
        monitor-exit(r19);
        long r7 = this.a(r5);
        if (r7 <= 0) goto L47;
        d.h.a.m r113 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r112, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.f22099a = this;
        r0.f22100b = r12;
        r0.f22101c = r14;
        r0.f22102d = r5;
        r0.g = 1;
        r17 = dg.b(r7, r113, r0);
        if (r17 != r1) goto L44;
        return r1;
    L49:
        throw new v(r110, null, 2, null);     // Catch: Throwable -> L50
    L53:
    L50:
        th = move-exception;
        throw th;
    L23:
        if (this.l != r14) goto L30;
        Map r114 = (Map) ZeusTransformUtils.preCheckCast(this.k, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        Object r115 = r114.get(r14);     // Catch: Throwable -> L50
        if (r115 != null) goto L27;
        r115 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        r114.put(r14, r115);     // Catch: Throwable -> L50
    L27:
        ((Collection) ZeusTransformUtils.preCheckCast(r115, Collection.class, "com.obric.aiagent.plugin")).add(r12);     // Catch: Throwable -> L50
        x r116 = x.f38692a;     // Catch: Throwable -> L50
        monitor-exit(r19);
        return r116;
    L47:
        throw new v(null, "Timed out waiting for the Virt exclusive segment", 1, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r17);
        c r117 = (c) ZeusTransformUtils.preCheckCast(r0.getContext().get((d.c.g.c) ZeusTransformUtils.preCheckCast(c.f22085a, d.c.g.c.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin");
        if (r117 == null) goto L17;
        b r118 = r117.a();
    L18:
        r5 = System.nanoTime() + (r13 * 1000000);
        r14 = r118;
        goto L19
    L17:
        r118 = null;
    L7:
        r0 = new g(this, r16);
        goto L8
    }

    private final void d(String r5) {
        Object r0 = this.i;
        monitor-enter(r0);
        this.j.remove(r5);     // Catch: Throwable -> L11
        Collection<Set<String>> r4 = this.k.values();     // Catch: Throwable -> L11
        d.h.b.o.c(r4, "<get-values>(...)");     // Catch: Throwable -> L11
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L11
    L6:
        if (r6.hasNext() == false) goto L8;
        ((Set) ZeusTransformUtils.preCheckCast(r6.next(), Set.class, "com.obric.aiagent.plugin")).remove(r5);     // Catch: Throwable -> L11
        goto L6
    L8:
        x r7 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private final Set<String> a(b r3) {
        Object r0 = this.i;
        monitor-enter(r0);
        Set r2 = (Set) ZeusTransformUtils.preCheckCast(this.k.get(r3), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r2 == null) goto L7;
        Set<String> r4 = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
    L8:
        if (r4 != null) goto L10;
        r4 = d.a.ax.b();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);
        return r4;
    L7:
        r4 = null;
    L12:
        th = move-exception;
        throw th;
    }

    private final void b(b r6) {
        Object r0 = this.i;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.l != r6) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L16;
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(this.j, Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Set r7 = (Set) ZeusTransformUtils.preCheckCast(this.k.remove(r6), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r7 != null) goto L12;
        r7 = d.a.ax.b();     // Catch: Throwable -> L17
    L12:
        d.a.p.a(r2, (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L17
        this.l = null;     // Catch: Throwable -> L17
        this.m.a(x.f38692a);     // Catch: Throwable -> L17
        this.m = y.a(null, 1, null);     // Catch: Throwable -> L17
        x r5 = x.f38692a;     // Catch: Throwable -> L17
        monitor-exit(r0);
        return;
    L16:
        throw new IllegalStateException("Virt exclusive owner changed before release".toString());     // Catch: Throwable -> L17
    L7:
        r1 = false;
        goto L8
    }

    private final long a(long r5) {
        long r6 = r5 - System.nanoTime();
        if (r6 > 0) goto L6;
        return 0;
    L6:
        return d.l.n.a(((r6 + 1000000) - 1) / 1000000, 1);
    }

    public final List<d> a() {
        Collection<e> r0 = this.f22084e.values();
        d.h.b.o.c(r0, "<get-values>(...)");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new j(), Comparator.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3.next(), e.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r4);
        r2.add(b(r4));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    }

    public final d c(String r3) {
        d.h.b.o.e(r3, "executionId");
        e r4 = (e) ZeusTransformUtils.preCheckCast(this.f22084e.get(r3), e.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return b(r4);
    }

    public final boolean a(String r2, boolean r3) {
        d.h.b.o.e(r2, "executionId");
        if (r3 == true) goto L5;
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.f22084e.get(r2), e.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L14;
        com.obric.aiagent.skill.virt.impl.a.f r4 = r1.a();
        if (r4 == null) goto L14;
        if (d.n.a(r4.d()) != true) goto L14;
        return true;
    L14:
        return false;
    L5:
        return e(r2);
    }

    private final boolean e(String r2) {
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.f22084e.get(r2), e.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L10;
        com.obric.aiagent.skill.virt.impl.a.f r3 = r1.a();
        if (r3 == null) goto L10;
        if (d.n.a(r3.e()) != true) goto L10;
        return true;
    L10:
        return false;
    }

    private final Object a(String r16, String r17, String r18, Map<String, String> r19, String r20, long r21, String r23, d.h.a.b<? super com.obric.aiagent.skill.virt.api.r, x> r24, d.c.d<? super e> r25) {
        String r11 = r18;
        String r0 = r23;
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super com.obric.aiagent.skill.virt.api.r, x> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, o.class) == false) goto L7;
        o r3 = (o) ZeusTransformUtils.preCheckCast(r2, o.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        o r10 = r3;
        Object r4 = r10.f22131e;
        Object r13 = d.c.a.b.a();
        int r5 = r10.g;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        long r1 = r10.f22130d;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r10.f22129c, String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r10.f22128b, String.class, "com.obric.aiagent.plugin");
        a r12 = (a) ZeusTransformUtils.preCheckCast(r10.f22127a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L14
        Object r14 = ((d.n) ZeusTransformUtils.preCheckCast(r4, d.n.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L14
        String r15 = r6;
        r11 = r8;
    L43:
        Throwable r22 = d.n.c(r14);     // Catch: Throwable -> L37
        if (r22 == null) goto L34;
        throw r22;     // Catch: Throwable -> L37
    L34:
        e r26 = new e((com.obric.aiagent.skill.virt.impl.a.f) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.skill.virt.impl.a.f.class, "com.obric.aiagent.plugin"), r12.f22081b.a(), r15, System.currentTimeMillis(), r1);
        ((Map) ZeusTransformUtils.preCheckCast(r12.f22084e, Map.class, "com.obric.aiagent.plugin")).put(r11, r26);
        r12.f.remove(r11);
        r12.a(r26);
        return r26;
    L37:
        th = th;
    L41:
        r12.f.remove(r11);
        r12.i(r11);
        throw th;
    L14:
        th = th;
        r11 = r8;
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r4);
        if (r0 != null) goto L21;
    L25:
        r0 = UUID.randomUUID().toString();
        d.h.b.o.c(r0, "toString(...)");
    L26:
        f(r11);
        h(r11);     // Catch: Throwable -> L39
        r15 = this.f22081b.a(r17);     // Catch: Throwable -> L39
        com.obric.aiagent.skill.virt.impl.a.k r27 = this.f22081b;     // Catch: Throwable -> L39
        r10.f22127a = this;     // Catch: Throwable -> L39
        r10.f22128b = r11;     // Catch: Throwable -> L39
        r10.f22129c = r15;     // Catch: Throwable -> L39
        r10.f22130d = r21;     // Catch: Throwable -> L39
        r10.g = 1;     // Catch: Throwable -> L39
        r14 = r27.a(r18, r0, r16, r15, r7, r20, r9, r10);     // Catch: Throwable -> L39
        if (r14 != r13) goto L30;
        return r13;
    L30:
        r12 = this;
        r1 = r21;
    L39:
        th = th;
        r12 = this;
        goto L41
    L21:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L24;
        r0 = null;
    L24:
        if (r0 != null) goto L26;
    L7:
        r3 = new o(this, r2);
        goto L8
    }

    private final void f(String r3) {
        if (g(r3) == false) goto L5;
        j("Rejecting launch: executionId already running id=" + r3);
        throw new com.obric.aiagent.skill.virt.impl.c.d(r3);
    L5:
        if (this.f.add(r3) == true) goto L7;
        j("Rejecting launch: executionId already being started id=" + r3);
        throw new com.obric.aiagent.skill.virt.impl.c.d(r3);
    L7:
        if (g(r3) == true) goto L9;
        return;
    L9:
        this.f.remove(r3);
        j("Rejecting launch: executionId became running after reserve id=" + r3);
        throw new com.obric.aiagent.skill.virt.impl.c.d(r3);
    }

    private final boolean g(String r2) {
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.f22084e.get(r2), e.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return false;
    L7:
        return !r1.a().f().e();
    }

    private final void h(String r6) {
        Object r0 = this.g;
        monitor-enter(r0);
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(this.h, Iterable.class, "com.obric.aiagent.plugin"), new $$Lambda$a$QFjVObQR5oEl404C9lsSUfXCI(this));     // Catch: Throwable -> L21
        int r1 = this.f22081b.c();     // Catch: Throwable -> L21
        boolean r2 = true;
        if (r1 <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L20;
        if (this.h.size() < r1) goto L13;
        r2 = false;
    L13:
        if (r2 == false) goto L18;
        ((Collection) ZeusTransformUtils.preCheckCast(this.h, Collection.class, "com.obric.aiagent.plugin")).add(r6);     // Catch: Throwable -> L21
        x r5 = x.f38692a;     // Catch: Throwable -> L21
        monitor-exit(r0);
        return;
    L18:
        throw new IllegalStateException(("Virt already has the maximum number of active shell executions: " + r1).toString());     // Catch: Throwable -> L21
    L20:
        throw new IllegalStateException(("Invalid backend shell capacity: " + r1).toString());     // Catch: Throwable -> L21
    L7:
        r4 = false;
    L21:
        th = move-exception;
        throw th;
    }

    private static final boolean b(a r1, String r2) {
        d.h.b.o.e(r2, "reservedId");
        e r3 = (e) ZeusTransformUtils.preCheckCast(r1.f22084e.get(r2), e.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.a().f().e() == false) goto L7;
        return true;
    }

    private final void i(String r2) {
        Object r0 = this.g;
        monitor-enter(r0);
        this.h.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void a(e r7) {
        kotlinx.coroutines.i.a(this.f22083d, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r7, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void j(String r2) {
        ILogDepend.Companion r1 = ILogDepend.Companion;
        if (IAppContext.Companion.isDebug() == true) goto L6;
        r2 = "Rejecting duplicate shell launch";
    L6:
        r1.w("Virt/Shell", r2);
    }

    private final d b(e r19) {
        com.obric.aiagent.skill.virt.impl.a.i r1 = r19.a().f();
        if (r1.e() == false) goto L6;
        i(r19.a().a());
        d(r19.a().a());
    L6:
        return new d(r1.a(), r19.a().a(), r19.b(), r19.c(), r19.a().b(), r1.b().a(), r1.e(), r1.c(), r1.f(), r19.d(), System.currentTimeMillis() - r19.d(), r1.d());
    }
}
