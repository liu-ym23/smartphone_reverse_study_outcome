package com.obric.aiagent.skill.ovirt.impl.g;

import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.virt.api.IVirtService;
import com.obric.aiagent.skill.virt.api.x;
import com.obric.aiagent.skill.virt.api.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import java.io.File;

/* JADX INFO: compiled from: BashOutputKeeping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f21351a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IVirtService f21352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final y f21353c;

    /* JADX INFO: compiled from: BashOutputKeeping.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BashOutputKeeping.kt */
    @d.c.b.a.f(b = "BashOutputKeeping.kt", c = {33, 34}, d = "keep", e = "com.obric.aiagent.skill.ovirt.impl.shell.BashOutputKeeping")
    static final class C0448b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f21357d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f21358e;
        int f;

        C0448b(b r3, d.c.d<? super C0448b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21358e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21357d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f21358e.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: BashOutputKeeping.kt */
    @d.c.b.a.f(b = "BashOutputKeeping.kt", c = {47}, d = "keepOne", e = "com.obric.aiagent.skill.ovirt.impl.shell.BashOutputKeeping")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21362d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f21363e;
        final /* synthetic */ b f;
        int g;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21363e = r3;
            this.g |= Integer.MIN_VALUE;
            return b.a(this.f, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f21351a = new a(null);
    }

    public b(IVirtService r3, y r4) {
        IVirtService r5 = (IVirtService) ZeusTransformUtils.wrapperContextForParams(r3, IVirtService.class, "com.obric.aiagent.plugin");
        o.e(r5, "virt");
        o.e(r4, "paths");
        this.f21352b = r5;
        this.f21353c = r4;
    }

    public static final /* synthetic */ Object a(b r2, String r3, String r4, File r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final Object a(String r7, File r8, File r9, d.c.d<? super com.obric.aiagent.skill.ovirt.impl.g.c> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, C0448b.class) == false) goto L7;
        C0448b r0 = (C0448b) ZeusTransformUtils.preCheckCast(r11, C0448b.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f21357d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r0.f21354a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
    L24:
        return new com.obric.aiagent.skill.ovirt.impl.g.c(r6, (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin"));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (File) ZeusTransformUtils.preCheckCast(r0.f21356c, File.class, "com.obric.aiagent.plugin");
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.f21355b, String.class, "com.obric.aiagent.plugin");
        b this = (b) ZeusTransformUtils.preCheckCast(r0.f21354a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
    L19:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin");
        r0.f21354a = r13;
        r0.f21355b = null;
        r0.f21356c = null;
        r0.f = 2;
        r12 = this.a(r7, "stderr.log", r9, r0);
        if (r12 != r2) goto L22;
        return r2;
    L22:
        r6 = r13;
        goto L24
    L16:
        d.o.a(r12);
        r0.f21354a = this;
        r0.f21355b = r7;
        r0.f21356c = r9;
        r0.f = 1;
        r12 = a(r7, "stdout.log", r8, r0);
        if (r12 != r2) goto L19;
        return r2;
    L7:
        r0 = new C0448b(this, r11);
        goto L8
    }

    private final Object a(String r22, String r23, File r24, d.c.d<? super String> r25) {
        b r1 = this;
        String r2 = r22;
        String r3 = r23;
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, c.class) == false) goto L7;
        c r7 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if ((r7.g & Integer.MIN_VALUE) == 0) goto L7;
        r7.g -= Integer.MIN_VALUE;
    L8:
        Object r6 = r7.f21363e;
        Object r8 = d.c.a.b.a();
        int r9 = r7.g;
        if (r9 == 0) goto L18;
        if (r9 != 1) goto L17;
        com.obric.aiagent.skill.virt.api.e r4 = (com.obric.aiagent.skill.virt.api.e) ZeusTransformUtils.preCheckCast(r7.f21362d, com.obric.aiagent.skill.virt.api.e.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r7.f21361c, String.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r7.f21360b, String.class, "com.obric.aiagent.plugin");
        b r12 = (b) ZeusTransformUtils.preCheckCast(r7.f21359a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L14
        Object r0 = r6;
        com.obric.aiagent.skill.virt.api.e r13 = r4;
        r1 = r12;
        r3 = r10;
        r2 = r11;
    L27:
        Object r14 = n.f((com.obric.aiagent.skill.virt.api.h) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.virt.api.h.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L29
    L31:
        Throwable r15 = n.c(r14);
        if (r15 == null) goto L40;
        if (IAppContext.Companion.isDebug() == false) goto L36;
        ILogDepend.Companion.e("SkRt/BashOutputKeeping", "keep failed executionId=" + r2 + " file=" + r3, r15);
        return null;
    L36:
        ILogDepend.Companion.w("SkRt/BashOutputKeeping", "keep output failed");
        return null;
    L40:
        return r1.f21353c.d(r13.a());
    L29:
        Throwable th = th;
    L30:
        n.a r16 = n.f38560a;
        r14 = n.f(d.o.a(th));
    L14:
        th = th;
        r13 = r4;
        r1 = r12;
        r3 = r10;
        r2 = r11;
        goto L30
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r6);
        if (r24 != null) goto L21;
        return null;
    L21:
        if (r24.isFile() == false) goto L48;
        r13 = r1.f21353c.a(".obric/shell-outputs/" + r2 + '/' + r3);
        n.a r17 = n.f38560a;     // Catch: Throwable -> L29
        IVirtService.b r18 = ((b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin")).f21352b.getFiles();     // Catch: Throwable -> L29
        com.obric.aiagent.skill.virt.api.g r19 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.api.g.b(r24), com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        x r20 = (x) ZeusTransformUtils.preCheckCast(r13, x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        com.obric.aiagent.skill.virt.api.f r110 = new com.obric.aiagent.skill.virt.api.f(true, true, false, false, 8, null);     // Catch: Throwable -> L29
        r7.f21359a = r1;     // Catch: Throwable -> L29
        r7.f21360b = r2;     // Catch: Throwable -> L29
        r7.f21361c = r3;     // Catch: Throwable -> L29
        r7.f21362d = r13;     // Catch: Throwable -> L29
        r7.g = 1;     // Catch: Throwable -> L29
        r0 = r18.a(r19, r20, r110, r7);     // Catch: Throwable -> L29
        if (r0 != r8) goto L27;
        return r8;
    L48:
        return null;
    L7:
        r7 = new c(r1, r5);
        goto L8
    }
}
