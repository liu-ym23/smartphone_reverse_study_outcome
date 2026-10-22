package com.obric.autogui.agents.a.a;

import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.agents.a.m.s;
import com.obric.autogui.agents.a.m.t;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.operator.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;
import d.x;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ActionEffectAttempt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.autogui.agents.a.a.a.d, p {
    private static final String TAG = "ActionEffectAttempt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0658a f26158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.a.f.j f26159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f26160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.agents.a.l.d f26161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t f26162e;
    private final com.obric.autogui.operator.e f;
    private final i g;
    private final AtomicReference<e> h;
    private final AtomicReference<k> i;
    private final com.obric.autogui.agents.a.a.a.b j;
    private volatile com.obric.autogui.agents.a.l.c k;

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionEffectAttempt.kt */
    public static final class C0658a {
        public /* synthetic */ C0658a(d.h.b.h r1) {
            this();
        }

        private C0658a() {
        }
    }

    /* JADX INFO: compiled from: ActionEffectAttempt.kt */
    @d.c.b.a.f(b = "ActionEffectAttempt.kt", c = {219, 224}, d = "onBeforeOperation", e = "com.obric.autogui.agents.actioneffect.attempt.ActionEffectAttempt")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26166d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f26167e;
        int f;
        /* synthetic */ Object g;
        final /* synthetic */ a h;
        int i;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ActionEffectAttempt.kt */
    @d.c.b.a.f(b = "ActionEffectAttempt.kt", c = {354}, d = "prepareBaseline", e = "com.obric.autogui.agents.actioneffect.attempt.ActionEffectAttempt")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f26171d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f26172e;
        int f;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26172e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26171d = r3;
            this.f |= Integer.MIN_VALUE;
            return a.a(this.f26172e, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f26158a = new C0658a(null);
    }

    public a(com.obric.autogui.agents.a.f.j r9, String r10, com.obric.autogui.agents.a.l.d r11, t r12, Context r13, com.obric.autogui.operator.e r14, k r15) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        k r16 = (k) ZeusTransformUtils.wrapperContextForParams(r15, k.class, "com.obric.aiagent.plugin");
        o.e(r9, "policy");
        o.e(r10, "attemptId");
        o.e(r11, "snapshotProvider");
        o.e(r12, "timingRecorder");
        o.e(r4, "context");
        o.e(r14, "step");
        this.f26159b = r9;
        this.f26160c = r10;
        this.f26161d = r11;
        this.f26162e = r12;
        this.f = r14;
        this.g = new i();
        this.h = new AtomicReference(null);
        this.i = new AtomicReference(r16);
        this.j = com.obric.autogui.agents.a.a.a.c.f26174a.a(b(), r4, r14, b().a(), r10);
        this.k = com.obric.autogui.agents.a.l.c.f26541a.a();
    }

    public static final /* synthetic */ Object a(a r2, com.obric.autogui.operator.e.C0780e r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final String a() {
        return this.f26160c;
    }

    public final com.obric.autogui.agents.a.f.a b() {
        return this.f26159b.a();
    }

    @Override // com.obric.autogui.agents.a.a.a.d
    public com.obric.autogui.agents.a.l.c c() {
        return this.k;
    }

    public final Boolean d() {
        List<ViewHierarchyDump> r1 = c().b();
        if (r1 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(com.obric.autogui.agents.a.n.a.f26730a.e(r1));
    }

    public final boolean e() {
        return com.obric.autogui.agents.a.a.b.a(this.f26159b, c());
    }

    @Override // com.obric.autogui.agents.a.a.a.d
    public boolean a(com.obric.autogui.operator.b.EnumC0777b r2) {
        o.e(r2, "type");
        return this.g.b(r2);
    }

    @Override // com.obric.autogui.agents.a.a.a.d
    public e f() {
        return (e) ZeusTransformUtils.preCheckCast(this.h.get(), e.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.agents.a.a.a.d
    public boolean a(long r1) {
        return this.f26162e.a(r1);
    }

    @Override // com.obric.autogui.agents.a.a.a.d
    public String g() {
        return com.obric.autogui.agents.a.c.f26286a.a(this);
    }

    public final f a(String r15) {
        o.e(r15, DBHelper.BATTERY_COL_SOURCE);
        b(r15);
        Boolean r10 = d();
        boolean r11 = e();
        com.obric.autogui.agents.a.a.a.e r0 = this.j.a((com.obric.autogui.agents.a.a.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.a.a.a.d.class, "com.obric.aiagent.plugin"));
        this.f26162e.a(r0.b());
        e r1 = r0.a();
        if (r1 == null) goto L5;
        a(r1);
    L5:
        b(r15 + "_after_handler_freeze");
        com.obric.autogui.agents.a.f.j r3 = this.f26159b;
        String r4 = this.f26160c;
        com.obric.autogui.agents.a.l.c r5 = c();
        com.obric.autogui.agents.a.a.a.a r6 = this.j.b();
        e r14 = (e) ZeusTransformUtils.preCheckCast(this.h.get(), e.class, "com.obric.aiagent.plugin");
        Long r2 = r0.b();
        if (r2 == null) goto L8;
        Long r7 = Long.valueOf(n.a(r2.longValue(), 0));
    L10:
        return new f(r3, r4, r5, r6, r14, r7, n.a(r0.c(), 0), r10, r11);
    L8:
        r7 = null;
        goto L10
    }

    @Override // com.obric.autogui.agents.a.a.a.d
    public boolean b(String r6) {
        o.e(r6, DBHelper.BATTERY_COL_SOURCE);
        if (com.obric.autogui.agents.a.k.a.f26530a.a() == true) goto L13;
        e r5 = (e) ZeusTransformUtils.preCheckCast(this.h.get(), e.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L7;
        com.obric.autogui.agents.a.f.k r7 = r5.a();
    L9:
        if (r7 == com.obric.autogui.agents.a.f.k.f26443b) goto L15;
        return false;
    L15:
        return true;
    L7:
        r7 = null;
        goto L9
    L13:
        a(new e(com.obric.autogui.agents.a.f.k.f26443b, d.f26242a, "active operating space is secure"));
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] secure page detected " + g() + ", source=" + r6);
        return true;
    }

    public final void c(String r5) {
        o.e(r5, DBHelper.BATTERY_COL_SOURCE);
        a(new e(com.obric.autogui.agents.a.f.k.f26443b, d.f26242a, "snapshot provider reported secure page"));
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] secure snapshot detected " + g() + ", source=" + r5);
    }

    public final boolean h() {
        this.i.set(null);
        return this.j.b((com.obric.autogui.agents.a.a.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.a.a.a.d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x01da: IGET (r1 I:com.obric.autogui.agents.a.m.t) = (r13 I:com.obric.autogui.agents.a.a.a) (LINE:248) com.obric.autogui.agents.a.a.a.e com.obric.autogui.agents.a.m.t, block:B:82:0x01da */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.obric.autogui.agents.a.a.a] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.obric.autogui.agents.a.m.d, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.autogui.operator.p
    public Object a(com.obric.autogui.operator.e.C0780e r16, com.obric.autogui.operator.b r17, d.c.d<? super x> r18) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L7;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
        if ((r5.i & Integer.MIN_VALUE) == 0) goto L7;
        r5.i -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.g;
        ?? r6 = d.c.a.b.a();
        int r7 = r5.i;
        boolean r8 = false;
        if (r7 == 0) goto L32;
        if (r7 == 1) goto L23;
        if (r7 != 2) goto L22;
        int r1 = r5.f;
        s r2 = (s) ZeusTransformUtils.preCheckCast(r5.f26166d, s.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.m.d r9 = (com.obric.autogui.agents.a.m.d) ZeusTransformUtils.preCheckCast(r5.f26165c, com.obric.autogui.agents.a.m.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.e.C0780e r10 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r5.f26164b, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        a r11 = (a) ZeusTransformUtils.preCheckCast(r5.f26163a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L15 Exception -> L17 CancellationException -> L19
        a r13 = r11;
        com.obric.autogui.operator.e.C0780e r12 = r10;
    L53:
        if (r1 != 0) goto L85;
    L65:
        r13.f26162e.a(r9, r2);
        return x.f38692a;
    L85:
        r13.a(r12);     // Catch: Throwable -> L59 Exception -> L61 CancellationException -> L63
        Loog r0 = Loog.INSTANCE;     // Catch: Throwable -> L59 Exception -> L61 CancellationException -> L63
        StringBuilder r14 = new StringBuilder().append("[OAutoActionEffect] primary operation prepared ").append(r13.g()).append(", op=").append(r12.a()).append(", has_baseline_component=");     // Catch: Throwable -> L59 Exception -> L61 CancellationException -> L63
        if (r13.c().a() == null) goto L57;
        r8 = true;
    L57:
        r0.i(TAG, r14.append(r8).append(", baseline_error_count=").append(r13.c().f()).toString());     // Catch: Throwable -> L59 Exception -> L61 CancellationException -> L63
    L63:
        e = e;
    L79:
        s r15 = s.f26712c;     // Catch: Throwable -> L81
        throw e;     // Catch: Throwable -> L81
    L61:
        e = e;
    L73:
        s r19 = s.f26713d;     // Catch: Throwable -> L81
        if (r1 == 0) goto L76;
        r13.a(r12);     // Catch: Throwable -> L81
    L76:
        throw e;     // Catch: Throwable -> L81
    L59:
        th = th;
    L69:
        s r20 = s.f26713d;     // Catch: Throwable -> L81
        throw th;     // Catch: Throwable -> L81
    L19:
        e = e;
    L17:
        e = e;
        r13 = r11;
        r12 = r10;
    L15:
        th = th;
        goto L69
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        r1 = r5.f;
        r2 = (s) ZeusTransformUtils.preCheckCast(r5.f26167e, s.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.m.d r21 = (com.obric.autogui.agents.a.m.d) ZeusTransformUtils.preCheckCast(r5.f26166d, com.obric.autogui.agents.a.m.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.b r110 = (com.obric.autogui.operator.b) ZeusTransformUtils.preCheckCast(r5.f26165c, com.obric.autogui.operator.b.class, "com.obric.aiagent.plugin");
        r12 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r5.f26164b, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        r13 = (a) ZeusTransformUtils.preCheckCast(r5.f26163a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        com.obric.autogui.operator.b r22 = r110;
        com.obric.autogui.operator.e.C0780e r111 = r12;
        a r112 = r13;
    L43:
        com.obric.autogui.operator.e.C0780e r113 = r111;
        a r114 = r112;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L49;
        r112.a(r111);     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        x r23 = x.f38692a;     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        r112.f26162e.a(r21, r2);
        return r23;
    L49:
        com.obric.autogui.agents.a.a.a.b r24 = r114.j;     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        com.obric.autogui.agents.a.a.a.d r25 = (com.obric.autogui.agents.a.a.a.d) ZeusTransformUtils.preCheckCast(r114, com.obric.autogui.agents.a.a.a.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        r5.f26163a = r114;     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        r5.f26164b = r113;     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        r5.f26165c = r21;     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        r5.f26166d = r2;     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        r5.f26167e = null;     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        r5.f = r1;     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        r5.i = 2;     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        if (r24.a(r25, r113, r22, r5) != r6) goto L52;
        return r6;
    L52:
        r9 = r21;
        r12 = r113;
        r13 = r114;
    L30:
        e = e;
    L28:
        e = e;
    L26:
        th = th;
        goto L69
    L32:
        d.o.a(r4);
        if (r16.a() != this.j.a()) goto L35;
        int r26 = 1;
    L36:
        r21 = this.f26162e.a(com.obric.autogui.agents.a.m.a.f26648b);
        s r115 = s.f26710a;
        this.g.a(r16.a(), AOSystemTools.INSTANCE.bootTimeMillis());     // Catch: Throwable -> L67 Exception -> L71 CancellationException -> L77
        if (r26 == 0) goto L48;
        r5.f26163a = this;     // Catch: Throwable -> L67 Exception -> L71 CancellationException -> L77
        r5.f26164b = r16;     // Catch: Throwable -> L67 Exception -> L71 CancellationException -> L77
        r22 = r17;
        r5.f26165c = r22;     // Catch: Throwable -> L67 Exception -> L71 CancellationException -> L77
        r5.f26166d = r21;     // Catch: Throwable -> L67 Exception -> L71 CancellationException -> L77
        r5.f26167e = r115;     // Catch: Throwable -> L67 Exception -> L71 CancellationException -> L77
        r5.f = r26;     // Catch: Throwable -> L67 Exception -> L71 CancellationException -> L77
        r5.i = 1;     // Catch: Throwable -> L67 Exception -> L71 CancellationException -> L77
        Object r116 = a(r16, r5);     // Catch: Throwable -> L67 Exception -> L71 CancellationException -> L77
        if (r116 != r6) goto L42;
        return r6;
    L42:
        r112 = this;
        r1 = r26;
        r4 = r116;
        r111 = r16;
        r2 = r115;
        goto L43
    L48:
        r22 = r17;
        r114 = this;
        r113 = r16;
        r1 = r26;
        r2 = r115;
    L77:
        e = e;
    L71:
        e = e;
        r13 = this;
        r12 = r16;
        r1 = r26;
    L67:
        th = th;
        goto L69
    L35:
        r26 = 0;
    L81:
        th = move-exception;
        r13.f26162e.a(r6, r16);
        throw th;
    L7:
        r5 = new b(this, r3);
        goto L8
    }

    @Override // com.obric.autogui.operator.p
    public void a(com.obric.autogui.operator.e.C0780e r9, com.obric.autogui.operator.c r10) {
        com.obric.autogui.operator.c r11 = (com.obric.autogui.operator.c) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        o.e(r9, "operation");
        o.e(r11, "result");
        com.obric.autogui.agents.a.m.d r0 = this.f26162e.a(com.obric.autogui.agents.a.m.a.f26649c);
        s r2 = s.f26710a;
        long r3 = this.g.b(r9.a(), AOSystemTools.INSTANCE.bootTimeMillis());     // Catch: Throwable -> L8
        this.j.a((com.obric.autogui.agents.a.a.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.a.a.a.d.class, "com.obric.aiagent.plugin"), r9, r11);     // Catch: Throwable -> L8
        if (r9.a() != this.j.a()) goto L6;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] primary operation finished " + g() + ", op=" + r9.a() + ", failed=" + r11.a() + ", elapsed_ms=" + r3);     // Catch: Throwable -> L8
    L6:
        this.f26162e.a(r0, r2);
        return;
    L8:
        th = move-exception;
        r2 = s.f26713d;     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.f26162e.a(r0, r2);
        throw th;
    }

    @Override // com.obric.autogui.operator.p
    public void b(com.obric.autogui.operator.e.C0780e r6, com.obric.autogui.operator.c r7) {
        com.obric.autogui.operator.c r8 = (com.obric.autogui.operator.c) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        o.e(r6, "operation");
        o.e(r8, "result");
        com.obric.autogui.agents.a.m.d r0 = this.f26162e.a(com.obric.autogui.agents.a.m.a.f26650d);
        s r2 = s.f26710a;
        this.g.a(r6.a());     // Catch: Throwable -> L6
        this.j.b((com.obric.autogui.agents.a.a.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.a.a.a.d.class, "com.obric.aiagent.plugin"), r6, r8);     // Catch: Throwable -> L6
        this.f26162e.a(r0, r2);
        return;
    L6:
        th = move-exception;
        r2 = s.f26713d;     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.f26162e.a(r0, r2);
        throw th;
    }

    @Override // com.obric.autogui.agents.a.a.a.d
    public Object a(String r16, com.obric.autogui.agents.a.l.a r17, d.c.d<? super com.obric.autogui.agents.a.l.c> r18) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.agents.a.l.d.a(this.f26161d, com.obric.autogui.agents.a.a.f26155a.a(this), r16, r17, null, null, false, this.f26162e, com.obric.autogui.agents.a.m.o.f26693b, null, r12, 312, null);
    }

    @Override // com.obric.autogui.agents.a.a.a.d
    public void a(e r4) {
        o.e(r4, "candidate");
    L3:
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.h.get(), e.class, "com.obric.aiagent.plugin");
        e r1 = com.obric.autogui.agents.a.a.c.a(r0, r4);
        if (r1 == r0) goto L5;
        if (this.h.compareAndSet(r0, r1) == false) goto L3;
        return;
    }

    /* JADX WARN: Failed to calculate best type for var: r12v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v10 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v11 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v12 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v13 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v14 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v15 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v15 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v4 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v4 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v5 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v6 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v7 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v8 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v9 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v21 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v21 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v22 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v22 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v22 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v22 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v23 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v23 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v23 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v23 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v24 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v24 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v24 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v24 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v25 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v25 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v25 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v25 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v26 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v26 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v26 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v26 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v27 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v27 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v28 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v28 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v29 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v29 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v30 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v30 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v31 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v31 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v32 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v33 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v33 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v34 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v34 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v24 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v24 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v25 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v25 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v32 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v4 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    private final java.lang.Object a(com.obric.autogui.operator.e.C0780e r25, d.c.d<? super java.lang.Boolean> r26) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x014f: CONSTRUCTOR (r2v21 ?? I:java.lang.StringBuilder) =  A[DECLARE_VAR, MD:():void (c)] call: java.lang.StringBuilder.<init>():void type: CONSTRUCTOR in method: com.obric.autogui.agents.a.a.a.a(com.obric.autogui.operator.e$e, d.c.d<? super java.lang.Boolean>):java.lang.Object, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.autogui.agents.a.a.a.a(com.obric.autogui.operator.e$e, d.c.d):java.lang.Object");
    }

    private final void a(com.obric.autogui.operator.e.C0780e r6) {
        k r0 = (k) ZeusTransformUtils.preCheckCast(this.i.getAndSet(null), k.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
        return;
    L10:
        r0.onBeforePrimaryOperation(new j(c(), AOSystemTools.INSTANCE.nowTimeMillis()));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] pre-action observer failed " + g() + ", op=" + r6.a() + ", error_type=" + e.getClass().getSimpleName() + ", original_action_preserved=true");
    }
}
