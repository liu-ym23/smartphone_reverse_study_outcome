package com.obric.autogui.operator.a.a;

import android.content.Context;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: MatchAndPerformOperation.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends com.obric.autogui.operator.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f29260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.operator.a.a.a.a[] f29261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.operator.a.a.b.a[] f29262d;

    /* JADX INFO: compiled from: MatchAndPerformOperation.kt */
    public static class a implements com.obric.autogui.operator.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f29263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f29264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f29265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private e f29266d;

        public a() {
            this(false, 0, 0, null, 15, null);
        }

        public a(boolean r2, int r3, long r4, e r6) {
            o.e(r6, "matchingParams");
            this.f29263a = r2;
            this.f29264b = r3;
            this.f29265c = r4;
            this.f29266d = r6;
        }

        public void a(boolean r1) {
            this.f29263a = r1;
        }

        public boolean a() {
            return this.f29263a;
        }

        public /* synthetic */ a(boolean r9, int r10, long r11, e r13, int r14, h r15) {
            if ((r14 & 1) == 0) goto L6;
            r9 = true;
        L6:
            if ((r14 & 2) == 0) goto L8;
            r10 = 5;
        L8:
            int r16 = r10;
            if ((r14 & 4) == 0) goto L11;
            r11 = 500;
        L11:
            long r0 = r11;
            if ((r14 & 8) == 0) goto L14;
            e r2 = new e(null, null, null, 7, null);
        L15:
            this(r9, r16, r0, r2);
            return;
        L14:
            r2 = r13;
            goto L15
        }

        public final e b() {
            return this.f29266d;
        }
    }

    /* JADX INFO: compiled from: MatchAndPerformOperation.kt */
    @d.c.b.a.f(b = "MatchAndPerformOperation.kt", c = {79}, d = "match", e = "com.obric.autogui.operator.impl.matching.MatchAndPerformOperation")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29269c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29270d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29271e;
        /* synthetic */ Object f;
        final /* synthetic */ c g;
        int h;

        b(c r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return c.a(this.g, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MatchAndPerformOperation.kt */
    @d.c.b.a.f(b = "MatchAndPerformOperation.kt", c = {134, 143, 145}, d = "performSingletonOperation", e = "com.obric.autogui.operator.impl.matching.MatchAndPerformOperation")
    static final class C0742c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f29274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f29275d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29276e;

        C0742c(c r3, d.c.d<? super C0742c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29275d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29274c = r3;
            this.f29276e |= Integer.MIN_VALUE;
            return this.f29275d.c(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public abstract Object a(Context r1, d r2, d.c.d<? super com.obric.autogui.common.e> r3);

    public abstract String c();

    public Object d(Context r3, d.c.d<? super com.obric.autogui.common.e> r4) {
        return a(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public c() {
        this.f29261c = new com.obric.autogui.operator.a.a.a.a[0];
        this.f29262d = new com.obric.autogui.operator.a.a.b.a[]{new com.obric.autogui.operator.a.a.b.b()};
    }

    public static final /* synthetic */ Object a(c r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final a d() {
        return this.f29260b;
    }

    @Override // com.obric.autogui.operator.d
    public boolean b(com.obric.autogui.operator.b.a r3) {
        com.obric.autogui.operator.b.a r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "input");
        if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L6;
        return false;
    L6:
        this.f29260b = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
        return true;
    }

    static /* synthetic */ Object a(c r2, Context r3, d.c.d<? super com.obric.autogui.common.e> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.e.f29014b.b("no matched node is found to handle the `" + r2.c() + "` action.");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0090 -> B:33:0x00c5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00aa -> B:27:0x00ad). Please report as a decompilation issue!!! */
    private final Object a(d.c.d<? super com.obric.autogui.common.d<d>> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r15, b.class, "com.obric.aiagent.plugin");
        if ((r0.h & Integer.MIN_VALUE) == 0) goto L7;
        r0.h -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f;
        Object r2 = d.c.a.b.a();
        int r3 = r0.h;
        Object r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r13 = r0.f29271e;
        int r5 = r0.f29270d;
        com.obric.autogui.operator.a.a.b.a[] r6 = (com.obric.autogui.operator.a.a.b.a[]) ZeusTransformUtils.preCheckCast(r0.f29269c, com.obric.autogui.operator.a.a.b.a[].class, "com.obric.aiagent.plugin");
        a r7 = (a) ZeusTransformUtils.preCheckCast(r0.f29268b, a.class, "com.obric.aiagent.plugin");
        c r8 = (c) ZeusTransformUtils.preCheckCast(r0.f29267a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L27:
        Collection<? extends d> r17 = (Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin");
        if (r17.isEmpty() == false) goto L31;
    L32:
        c r11 = r8;
        Collection<? extends d> r9 = r17;
        c r18 = r11;
    L33:
        r5 = r5 + 1;
    L19:
        if (r5 >= r13) goto L35;
        com.obric.autogui.operator.a.a.b.a r10 = r6[r5];
        if (r10.a(r7.b()) == false) goto L33;
        e r12 = r7.b();
        r0.f29267a = r18;
        r0.f29268b = r7;
        r0.f29269c = r6;
        r0.f29270d = r5;
        r0.f29271e = r13;
        r0.h = 1;
        Object r19 = r10.a(r12, r0);
        if (r19 != r2) goto L26;
        return r2;
    L26:
        r8 = r18;
        r16 = r19;
    L35:
        if (r9 == null) goto L44;
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L38:
        if (r110.hasNext() == false) goto L42;
        Object r111 = r110.next();
        if ((!((d) ZeusTransformUtils.preCheckCast(r111, d.class, "com.obric.aiagent.plugin")).a()) == false) goto L38;
        r4 = r111;
    L42:
        r4 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
    L44:
        return com.obric.autogui.common.d.f29012a.a(r4);
    L31:
        if (r8.a(r7, r17) == true) goto L32;
        r9 = r17;
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r16);
        a r112 = this.f29260b;
        if (r112 == null) goto L17;
        com.obric.autogui.operator.a.a.b.a[] r20 = this.f29262d;
        r9 = null;
        r18 = this;
        r13 = r20.length;
        r7 = r112;
        r6 = r20;
        r5 = 0;
        goto L19
    L17:
        return com.obric.autogui.common.d.f29012a.a("null input");
    L7:
        r0 = new b(this, r15);
        goto L8
    }

    private final boolean a(a r7, Collection<? extends d> r8) {
        Collection<? extends d> r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.aiagent.plugin");
        if (r9.isEmpty() == false) goto L5;
        return true;
    L5:
        com.obric.autogui.operator.a.a.a.a[] r6 = this.f29261c;
        if (r6.length != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return false;
    L11:
        int r1 = r6.length;
        int r3 = 0;
    L12:
        if (r3 >= r1) goto L17;
        if (r6[r3].a(r7, r9) == r9.size()) goto L15;
        r3 = r3 + 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    L8:
        r0 = false;
        goto L9
    }

    @Override // com.obric.autogui.operator.a.b
    public final Object c(Context r12, d.c.d<? super com.obric.autogui.common.e> r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, C0742c.class) == false) goto L7;
        C0742c r1 = (C0742c) ZeusTransformUtils.preCheckCast(r15, C0742c.class, "com.obric.aiagent.plugin");
        if ((r1.f29276e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f29276e -= Integer.MIN_VALUE;
    L8:
        Object r16 = r1.f29274c;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f29276e;
        boolean r7 = true;
        if (r4 == 0) goto L24;
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L18;
        if (r4 != 3) goto L17;
        c this = (c) ZeusTransformUtils.preCheckCast(r1.f29272a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L56
    L41:
        com.obric.autogui.common.e r17 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r16, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
    L43:
        if (r17.g() == true) goto L55;
        a r18 = this.f29260b;     // Catch: Throwable -> L56
        if (r18 != null) goto L47;
    L49:
        r7 = false;
    L50:
        if (r7 == false) goto L55;
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[MatchAndPerform] performed failed `" + this.c() + "` with `abortIfFailed` == false. proceeding...");     // Catch: Throwable -> L56
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[MatchAndPerform] failed message = " + r17.h());     // Catch: Throwable -> L56
        r17 = com.obric.autogui.common.e.f29014b.a(r17.h());     // Catch: Throwable -> L56
        Loog r19 = Loog.INSTANCE;
        String r0 = LogUtil.INSTANCE.getCLAZZ_TAG(this);
        StringBuilder r2 = new StringBuilder();
    L53:
        r19.d(r0, r2.append("[MatchAndPerform] stopped `").append(this.c()).append("`.").toString());
        return r17;
    L47:
        if (r18.a() == true) goto L49;
    L55:
        r19 = Loog.INSTANCE;
        r0 = LogUtil.INSTANCE.getCLAZZ_TAG(this);
        r2 = new StringBuilder();
        goto L53
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        this = (c) ZeusTransformUtils.preCheckCast(r1.f29272a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L56
    L37:
        r17 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r16, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        goto L43
    L21:
        r14 = (Context) ZeusTransformUtils.preCheckCast(r1.f29273b, Context.class, "com.obric.aiagent.plugin");
        this = (c) ZeusTransformUtils.preCheckCast(r1.f29272a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L56
    L28:
        com.obric.autogui.common.d r110 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r16, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        if (r110.g() == true) goto L32;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[MatchAndPerform] stopped `" + this.c() + "`.");
        return r110;
    L32:
        d r111 = (d) ZeusTransformUtils.preCheckCast(r110.a(), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        if (r111 != null) goto L38;
        r1.f29272a = this;     // Catch: Throwable -> L56
        r1.f29273b = null;     // Catch: Throwable -> L56
        r1.f29276e = 2;     // Catch: Throwable -> L56
        r16 = this.d(r14, r1);     // Catch: Throwable -> L56
        if (r16 != r3) goto L37;
        return r3;
    L38:
        r1.f29272a = this;     // Catch: Throwable -> L56
        r1.f29273b = null;     // Catch: Throwable -> L56
        r1.f29276e = 3;     // Catch: Throwable -> L56
        r16 = this.a(r14, r111, r1);     // Catch: Throwable -> L56
        if (r16 != r3) goto L41;
        return r3;
    L24:
        d.o.a(r16);
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[MatchAndPerform] started `" + c() + "`.");
        r1.f29272a = this;     // Catch: Throwable -> L56
        r1.f29273b = r14;     // Catch: Throwable -> L56
        r1.f29276e = 1;     // Catch: Throwable -> L56
        r16 = a(r1);     // Catch: Throwable -> L56
        if (r16 != r3) goto L28;
        return r3;
    L56:
        th = move-exception;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[MatchAndPerform] stopped `" + this.c() + "`.");
        throw th;
    L7:
        r1 = new C0742c(this, r15);
        goto L8
    }
}
