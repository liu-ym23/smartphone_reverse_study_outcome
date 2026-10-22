package com.obric.aiagent.skill.ovirt.impl.g;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.aiagent.skill.virt.api.r;
import com.obric.aiagent.skill.virt.api.s;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f.k;
import d.h.b.o;
import d.m;
import d.n;
import d.x;
import java.io.File;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ShellOutputStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f21424a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f21427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Gson f21428e;
    private final ConcurrentHashMap<String, Object> f;
    private final ConcurrentHashMap<String, b> g;

    /* JADX INFO: compiled from: ShellOutputStore.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ShellOutputStore.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StringBuilder f21429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final StringBuilder f21430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final File f21431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final File f21432d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final h f21433e;
        private final h f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f21429a, r6.f21429a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f21430b, r6.f21430b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f21431c, r6.f21431c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f21432d, r6.f21432d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f21433e, r6.f21433e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((this.f21429a.hashCode() * 31) + this.f21430b.hashCode()) * 31) + this.f21431c.hashCode()) * 31) + this.f21432d.hashCode()) * 31;
            h r1 = this.f21433e;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            h r5 = this.f;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "LiveOutput(stdout=" + this.f21429a + ", stderr=" + this.f21430b + ", stdoutFile=" + this.f21431c + ", stderrFile=" + this.f21432d + ", stdoutSanitiser=" + this.f21433e + ", stderrSanitiser=" + this.f + ')';
        }

        public b(StringBuilder r2, StringBuilder r3, File r4, File r5, h r6, h r7) {
            o.e(r2, "stdout");
            o.e(r3, "stderr");
            o.e(r4, "stdoutFile");
            o.e(r5, "stderrFile");
            this.f21429a = r2;
            this.f21430b = r3;
            this.f21431c = r4;
            this.f21432d = r5;
            this.f21433e = r6;
            this.f = r7;
        }

        public final StringBuilder a() {
            return this.f21429a;
        }

        public final StringBuilder b() {
            return this.f21430b;
        }

        public final File c() {
            return this.f21431c;
        }

        public final File d() {
            return this.f21432d;
        }

        public final void a(String r4) {
            o.e(r4, MonitorConstants.CHUNK);
            a(r4, this.f21429a, this.f21431c, this.f21433e);
        }

        public final void b(String r4) {
            o.e(r4, MonitorConstants.CHUNK);
            a(r4, this.f21430b, this.f21432d, this.f);
        }

        private final void a(String r3, StringBuilder r4, File r5, h r6) {
            if (r6 != null) goto L6;
            r4.append(r3);
            k.b(r5, r3, null, 2, null);
            return;
        L6:
            g r7 = r6.a(r3);
            if (ZeusTransformUtils.instanceOf(r7, g.a.class) == false) goto L15;
            String r8 = ((g.a) ZeusTransformUtils.preCheckCast(r7, g.a.class, "com.obric.aiagent.plugin")).a();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
            boolean r9 = true;
        L12:
            if (r9 == false) goto L20;
            r4.append(r8);
            k.b(r5, r8, null, 2, null);
            return;
        L20:
            return;
        L11:
            r9 = false;
            goto L12
        L15:
            if (ZeusTransformUtils.instanceOf(r7, g.b.class) == false) goto L19;
            d.o.o.a(r4);
            r4.append(((g.b) ZeusTransformUtils.preCheckCast(r7, g.b.class, "com.obric.aiagent.plugin")).a());
            k.a(r5, ((g.b) ZeusTransformUtils.preCheckCast(r7, g.b.class, "com.obric.aiagent.plugin")).a(), null, 2, null);
            return;
        L19:
            throw new d.k();
        }
    }

    /* JADX INFO: compiled from: ShellOutputStore.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21434a = null;

        static {
            int[] r0 = new int[s.values().length];
            r0[s.f21602a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[s.f21603b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f21434a = r0;
        }
    }

    /* JADX INFO: compiled from: ShellOutputStore.kt */
    @d.c.b.a.f(b = "ShellOutputStore.kt", c = {113}, d = "keepCompletedOutput", e = "com.obric.aiagent.skill.ovirt.impl.shell.ShellOutputStore")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f21438d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f21439e;
        int f;

        d(i r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21439e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21438d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f21439e.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f21424a = new a(null);
    }

    public static /* synthetic */ b lambda$1w94LhVnSjMRZPUqEV9sh2pZZLw(i r0, r r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Object lambda$CldR1hwGJK0MnXxcEK5HAGCR0BU(String r0) {
        return e(r0);
    }

    public static /* synthetic */ b lambda$RplGGg_VJ56ffjvmdrh_W6td1T8(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$skTVbR4i4l7tzMH57-hetMYD0dI, reason: not valid java name */
    public static /* synthetic */ Object m362lambda$skTVbR4i4l7tzMH57hetMYD0dI(d.h.a.b r0, Object r1) {
        return b(r0, r1);
    }

    public i(File r2, String r3, boolean r4) {
        o.e(r2, "rootDir");
        o.e(r3, "shellGroupId");
        this.f21425b = r3;
        this.f21426c = r4;
        File r5 = new File(r2, r3);
        this.f21427d = r5;
        Gson r6 = new GsonBuilder().create();
        o.c(r6, "create(...)");
        this.f21428e = r6;
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        r5.mkdirs();
    }

    public final com.obric.aiagent.skill.ovirt.api.b.b.c a(j r9) {
        o.e(r9, "processSnapshot");
        b r0 = new b(new StringBuilder(), new StringBuilder(), a(r9.b(), "stdout.log"), a(r9.b(), "stderr.log"), b(), b());
        File r1 = r0.c().getParentFile();
        if (r1 == null) goto L5;
        r1.mkdirs();
    L5:
        k.a(r0.c(), "", null, 2, null);
        k.a(r0.d(), "", null, 2, null);
        ((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.aiagent.plugin")).put(r9.b(), r0);
        b(r9);
        return a(r9, r0);
    }

    public final void a(final r r6) {
        o.e(r6, "event");
        if (o.a(r6.a(), this.f21425b) == true) goto L5;
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6.d(), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L28;
        ConcurrentHashMap<String, b> r1 = this.g;
        String r2 = r6.b();
        final d.h.a.b r3 = new $$Lambda$i$1w94LhVnSjMRZPUqEV9sh2pZZLw(this, r6);
        b r4 = r1.computeIfAbsent(r2, new $$Lambda$i$RplGGg_VJ56ffjvmdrh_W6td1T8(r3));
        o.c(r4, "computeIfAbsent(...)");
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        Object r7 = d(r6.b());
        monitor-enter(r7);
        int r8 = c.f21434a[r6.c().ordinal()];     // Catch: Throwable -> L23
        if (r8 != 1) goto L15;
        r5.a(r6.d());     // Catch: Throwable -> L23
    L20:
        x r9 = x.f38692a;     // Catch: Throwable -> L23
        monitor-exit(r7);
        return;
    L15:
        if (r8 != 2) goto L18;
        r5.b(r6.d());     // Catch: Throwable -> L23
        goto L20
    L18:
        throw new d.k();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L28:
        return;
    L7:
        r0 = false;
        goto L8
    }

    private static final b a(d.h.a.b r2, Object r3) {
        return (b) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), b.class, "com.obric.aiagent.plugin");
    }

    private static final b a(i r8, r r9, String r10) {
        o.e(r10, "it");
        b r11 = new b(new StringBuilder(), new StringBuilder(), r8.a(r9.b(), "stdout.log"), r8.a(r9.b(), "stderr.log"), r8.b(), r8.b());
        File r12 = r11.c().getParentFile();
        if (r12 == null) goto L6;
        r12.mkdirs();
    L6:
        if (r11.c().exists() == true) goto L9;
        k.a(r11.c(), "", null, 2, null);
    L9:
        if (r11.d().exists() == true) goto L11;
        k.a(r11.d(), "", null, 2, null);
    L11:
        return r11;
    }

    public final com.obric.aiagent.skill.ovirt.api.b.b.c update(j r4) {
        o.e(r4, "processSnapshot");
        b(r4);
        com.obric.aiagent.skill.ovirt.api.b.b.c r0 = a(r4, (b) ZeusTransformUtils.preCheckCast(this.g.get(r4.b()), b.class, "com.obric.aiagent.plugin"));
        if (r4.f() == false) goto L5;
        this.g.remove(r4.b());
    L5:
        return r0;
    }

    public final Object a(String r26, com.obric.aiagent.skill.ovirt.impl.g.b r27, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b.b.c> r28) {
        i r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L7;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f21438d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r4.f21437c, b.class, "com.obric.aiagent.plugin");
        j r7 = (j) ZeusTransformUtils.preCheckCast(r4.f21436b, j.class, "com.obric.aiagent.plugin");
        i r8 = (i) ZeusTransformUtils.preCheckCast(r4.f21435a, i.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        b r9 = r1;
        j r10 = r7;
        r0 = r8;
    L41:
        com.obric.aiagent.skill.ovirt.impl.g.c r11 = (com.obric.aiagent.skill.ovirt.impl.g.c) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.ovirt.impl.g.c.class, "com.obric.aiagent.plugin");
        String r12 = r11.a();
        if (r12 != null) goto L44;
        r12 = r10.l();
    L44:
        String r21 = r12;
        String r13 = r11.b();
        if (r13 != null) goto L47;
        r13 = r10.m();
    L47:
        j r14 = j.a(r10, null, null, null, null, null, false, null, false, 0, 0, null, r21, r13, 2047, null);
        r0.b(r14);
        return r0.a(r14, r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        j r15 = b(r26);
        if (r15 != null) goto L19;
        return null;
    L19:
        if (r15.f() == true) goto L23;
        return r0.a(r15, (b) ZeusTransformUtils.preCheckCast(r0.g.get(r26), b.class, "com.obric.aiagent.plugin"));
    L23:
        if (r15.l() != null) goto L25;
    L28:
        r9 = (b) ZeusTransformUtils.preCheckCast(r0.g.get(r26), b.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L32;
        File r16 = r9.c();
        if (r16 == null) goto L32;
    L33:
        if (r9 == null) goto L36;
        File r17 = r9.d();
        if (r17 == null) goto L36;
    L37:
        r4.f21435a = r0;
        r4.f21436b = r15;
        r4.f21437c = r9;
        r4.f = 1;
        Object r18 = r27.a(r26, r16, r17, r4);
        if (r18 != r5) goto L40;
        return r5;
    L40:
        r10 = r15;
        r3 = r18;
    L36:
        r17 = r0.a(r26, "stderr.log");
    L32:
        r16 = r0.a(r26, "stdout.log");
        goto L33
    L25:
        if (r15.m() == null) goto L28;
        return r0.a(r15, (b) ZeusTransformUtils.preCheckCast(r0.g.get(r26), b.class, "com.obric.aiagent.plugin"));
    L7:
        r4 = new d(r0, r2);
        goto L8
    }

    public final com.obric.aiagent.skill.ovirt.api.b.b.c a(String r4) {
        o.e(r4, "executionId");
        j r0 = b(r4);
        if (r0 != null) goto L7;
        return null;
    L7:
        return a(r0, (b) ZeusTransformUtils.preCheckCast(this.g.get(r4), b.class, "com.obric.aiagent.plugin"));
    }

    public final void a() {
        k.h(this.f21427d);
        this.g.clear();
        this.f.clear();
    }

    private final com.obric.aiagent.skill.ovirt.api.b.b.c a(j r25, b r26) {
        File r1 = a(r25.b(), "stdout.log");
        File r2 = a(r25.b(), "stderr.log");
        if (r26 == null) goto L12;
        Object r3 = d(r25.b());
        monitor-enter(r3);
        m r0 = d.s.a(r26.a().toString(), r26.b().toString());     // Catch: Throwable -> L9
        monitor-exit(r3);
    L13:
        Object r4 = r0.c();
        o.c(r4, "component1(...)");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        Object r5 = r0.d();
        o.c(r5, "component2(...)");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        String r6 = r25.a();
        String r7 = r25.b();
        String r8 = r25.c();
        String r11 = r25.d();
        String r12 = r25.e();
        boolean r13 = r25.f();
        Integer r14 = r25.g();
        boolean r15 = r25.h();
        long r16 = r25.i();
        long r17 = r25.j();
        if (r1.exists() == false) goto L16;
        File r19 = r1;
    L18:
        if (r2.exists() == false) goto L20;
        File r20 = r2;
    L22:
        return new com.obric.aiagent.skill.ovirt.api.b.b.c(r6, r7, r8, r11, r9, r10, r12, r13, r14, r15, r16, r17, r19, r20, r25.l(), r25.m(), r25.k());
    L20:
        r20 = null;
        goto L22
    L16:
        r19 = null;
    L9:
        th = move-exception;
        throw th;
    L12:
        r0 = d.s.a(a(r1), a(r2));
        goto L13
    }

    private final void b(j r8) {
        Object r0 = d(r8.b());
        monitor-enter(r0);
        File r1 = c(r8.b());     // Catch: Throwable -> L30
        n.a r2 = n.f38560a;     // Catch: Throwable -> L26
        i r7 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        File r3 = r1.getParentFile();     // Catch: Throwable -> L26
        if (r3 == null) goto L8;
        r3.mkdirs();     // Catch: Throwable -> L26
    L8:
        File r4 = new File(r1.getParentFile(), "process.json.tmp");     // Catch: Throwable -> L26
        String r9 = r7.f21428e.toJson(r8);     // Catch: Throwable -> L26
        o.c(r9, "toJson(...)");     // Catch: Throwable -> L26
        k.a(r4, r9, null, 2, null);     // Catch: Throwable -> L26
        n.a r5 = n.f38560a;     // Catch: Throwable -> L12
        Object r10 = n.f(Files.move(r4.toPath(), r1.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE}));     // Catch: Throwable -> L12
    L14:
        Throwable r6 = n.c(r10);     // Catch: Throwable -> L26
        if (r6 != null) goto L36;
    L24:
        d.o.a(r10);     // Catch: Throwable -> L26
        n.f((Path) ZeusTransformUtils.preCheckCast(r10, Path.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L26
    L28:
        monitor-exit(r0);
        return;
    L36:
        n.a r11 = n.f38560a;     // Catch: Throwable -> L21
        if (ZeusTransformUtils.instanceOf(r6, AtomicMoveNotSupportedException.class) == false) goto L20;
        Object r12 = n.f(Files.move(r4.toPath(), r1.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING}));     // Catch: Throwable -> L21
    L23:
        r10 = r12;
        goto L24
    L20:
        throw r6;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        n.a r13 = n.f38560a;     // Catch: Throwable -> L26
        r12 = n.f(d.o.a(th));     // Catch: Throwable -> L26
        goto L23
    L12:
        th = move-exception;
        n.a r14 = n.f38560a;     // Catch: Throwable -> L26
        r10 = n.f(d.o.a(th));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        n.a r15 = n.f38560a;     // Catch: Throwable -> L30
        n.f(d.o.a(th));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    private final j b(String r5) {
        File r0 = c(r5);
        Object r2 = null;
        if (r0.isFile() == true) goto L5;
        return null;
    L5:
        Object r6 = d(r5);
        monitor-enter(r6);
        n.a r1 = n.f38560a;     // Catch: Throwable -> L9
        Object r4 = n.f((j) ZeusTransformUtils.preCheckCast(((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin")).f21428e.fromJson(k.a(r0, null, 1, null), j.class), j.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
    L12:
        if (n.b(r4) == true) goto L15;
        r2 = r4;
    L15:
        j r7 = (j) ZeusTransformUtils.preCheckCast(r2, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        monitor-exit(r6);
        return r7;
    L18:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L18
        r4 = n.f(d.o.a(th));     // Catch: Throwable -> L18
        goto L12
    }

    private final File c(String r3) {
        return new File(new File(this.f21427d, r3), "process.json");
    }

    private final File a(String r3, String r4) {
        return new File(new File(this.f21427d, r3), r4);
    }

    private static final Object b(d.h.a.b r2, Object r3) {
        return ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3);
    }

    private final Object d(String r3) {
        ConcurrentHashMap<String, Object> r2 = this.f;
        final $$Lambda$i$CldR1hwGJK0MnXxcEK5HAGCR0BU r0 = $$Lambda$i$CldR1hwGJK0MnXxcEK5HAGCR0BU.INSTANCE;
        Object r4 = r2.computeIfAbsent(r3, new $$Lambda$i$skTVbR4i4l7tzMH57hetMYD0dI(r0));
        o.c(r4, "computeIfAbsent(...)");
        return r4;
    }

    private static final Object e(String r1) {
        o.e(r1, "it");
        return new Object();
    }

    private final String a(File r4) {
        Object r2 = "";
        if (r4.isFile() == true) goto L15;
        return "";
    L15:
        n.a r1 = n.f38560a;     // Catch: Throwable -> L7
        i r3 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        Object r5 = n.f(k.a(r4, null, 1, null));     // Catch: Throwable -> L7
    L10:
        if (n.b(r5) == true) goto L14;
        r2 = r5;
    L14:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L7:
        th = move-exception;
        n.a r6 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L10
    }

    private final h b() {
        if (this.f21426c == true) goto L7;
        return null;
    L7:
        return new h();
    }
}
