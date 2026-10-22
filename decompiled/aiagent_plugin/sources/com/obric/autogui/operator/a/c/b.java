package com.obric.autogui.operator.a.c;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.operator.e;
import com.obric.autogui.operator.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PreChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.obric.autogui.operator.a.c.a> f29808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f29809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.autogui.operator.b.a f29810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.obric.autogui.operator.c f29811e;

    /* JADX INFO: compiled from: PreChecker.kt */
    @f(b = "PreChecker.kt", c = {50, 51}, d = "preCheck", e = "com.obric.autogui.operator.impl.precheck.PreChecker")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29815d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f29816e;
        int f;

        a(b r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29816e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29815d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f29816e.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ CharSequence lambda$AvA7avsI5dKyeezoaFR1V2pAUvg(com.obric.autogui.operator.a.c.a r0) {
        return a(r0);
    }

    public b(String r3, List<? extends com.obric.autogui.operator.a.c.a> r4) {
        List<com.obric.autogui.operator.a.c.a> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "opName");
        o.e(r5, "checks");
        this.f29807a = r3;
        this.f29808b = r5;
    }

    public final com.obric.autogui.operator.c a() {
        return this.f29811e;
    }

    public final void a(e r3, com.obric.autogui.operator.b.a r4) {
        com.obric.autogui.operator.b.a r5 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "step");
        o.e(r5, "input");
        this.f29809c = r3;
        this.f29810d = r5;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f29808b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((com.obric.autogui.operator.a.c.a) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.autogui.operator.a.c.a.class, "com.obric.aiagent.plugin")).a(r3);
        goto L4
    }

    public final void a(e r4) {
        o.e(r4, "step");
        this.f29809c = null;
        this.f29810d = null;
        this.f29811e = null;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f29808b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.obric.autogui.operator.a.c.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.autogui.operator.a.c.a.class, "com.obric.aiagent.plugin")).b(r4);
        goto L4
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0127 -> B:27:0x012a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x01a4 -> B:17:0x00e6). Please report as a decompilation issue!!! */
    public final Object a(d.c.d<? super com.obric.autogui.operator.c> r23) {
        b r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, a.class) == false) goto L7;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f29815d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        com.obric.autogui.operator.a.c.a r1 = (com.obric.autogui.operator.a.c.a) ZeusTransformUtils.preCheckCast(r4.f29814c, com.obric.autogui.operator.a.c.a.class, "com.obric.aiagent.plugin");
        Iterator<com.obric.autogui.operator.a.c.a> r7 = (Iterator) ZeusTransformUtils.preCheckCast(r4.f29813b, Iterator.class, "com.obric.aiagent.plugin");
        b r8 = (b) ZeusTransformUtils.preCheckCast(r4.f29812a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        com.obric.autogui.operator.a.c.a r9 = r1;
        r0 = r8;
        Iterator<com.obric.autogui.operator.a.c.a> r10 = r7;
        Object r11 = r3;
    L27:
        com.obric.autogui.common.e r12 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r12.g() == true) goto L31;
        Loog.INSTANCE.w(r0.f29807a, " - [PreChecker] " + r0.f29807a + " pre-check '" + r9.a() + "' failed. Aborting operation.");
        n r13 = new n(r12);
        r0.f29811e = (com.obric.autogui.operator.c) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        return r13;
    L31:
        Loog.INSTANCE.d(r0.f29807a, " - [PreChecker] " + r0.f29807a + " pre-check '" + r9.a() + "' passed.");
    L18:
        if (r10.hasNext() == false) goto L33;
        r9 = (com.obric.autogui.operator.a.c.a) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.autogui.operator.a.c.a.class, "com.obric.aiagent.plugin");
        r4.f29812a = r0;
        r4.f29813b = r10;
        r4.f29814c = r9;
        r4.f = 1;
        Object r14 = r9.a(r4);
        if (r14 != r5) goto L23;
        return r5;
    L23:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L32;
        String r15 = r0.f29807a;
        e r16 = r0.f29809c;
        com.obric.autogui.operator.b.a r17 = r0.f29810d;
        r4.f29812a = r0;
        r4.f29813b = r10;
        r4.f29814c = r9;
        r4.f = 2;
        r11 = r9.a(r15, r16, r17, r4);
        if (r11 != r5) goto L27;
        return r5;
    L32:
        Loog.INSTANCE.d(r0.f29807a, " - [PreChecker] " + r0.f29807a + " skipped pre-check '" + r9.a() + "' as it should not be checked.");
        goto L18
    L33:
        Loog.INSTANCE.d(r0.f29807a, "[PreChecker] " + r0.f29807a + " all pre-checks passed.");
        n r18 = new n(com.obric.autogui.common.e.f29014b.a());
        r0.f29811e = (com.obric.autogui.operator.c) ZeusTransformUtils.preCheckCast(r18, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        return r18;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.obric.autogui.operator.a.c.a r19 = (com.obric.autogui.operator.a.c.a) ZeusTransformUtils.preCheckCast(r4.f29814c, com.obric.autogui.operator.a.c.a.class, "com.obric.aiagent.plugin");
        Iterator<com.obric.autogui.operator.a.c.a> r20 = (Iterator) ZeusTransformUtils.preCheckCast(r4.f29813b, Iterator.class, "com.obric.aiagent.plugin");
        b r21 = (b) ZeusTransformUtils.preCheckCast(r4.f29812a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        r9 = r19;
        r0 = r21;
        r10 = r20;
        r14 = r3;
        goto L23
    L16:
        d.o.a(r3);
        Loog.INSTANCE.d(r0.f29807a, "[PreChecker] " + r0.f29807a + " running pre-checks: " + p.a((Iterable) ZeusTransformUtils.preCheckCast(r0.f29808b, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, $$Lambda$b$AvA7avsI5dKyeezoaFR1V2pAUvg.INSTANCE, 31, null));
        r10 = r0.f29808b.iterator();
    L7:
        r4 = new a(r0, r2);
        goto L8
    }

    private static final CharSequence a(com.obric.autogui.operator.a.c.a r2) {
        com.obric.autogui.operator.a.c.a r3 = (com.obric.autogui.operator.a.c.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.operator.a.c.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.aiagent.plugin");
    }
}
