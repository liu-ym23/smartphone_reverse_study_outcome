package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class l {

    /* JADX INFO: compiled from: Channels.kt */
    @d.c.b.a.f(b = "Channels.kt", c = {32, 33}, d = "emitAllImpl$FlowKt__ChannelsKt", e = "kotlinx.coroutines.flow.FlowKt__ChannelsKt")
    static final class a<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f39030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f39031b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f39032c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f39033d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f39034e;
        int f;

        a(d.c.d<? super a> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f39034e = r2;
            this.f |= Integer.MIN_VALUE;
            return l.a(null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final /* synthetic */ Object a(i r2, kotlinx.coroutines.a.s r3, boolean r4, d.c.d r5) {
        return b((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin"), (kotlinx.coroutines.a.s) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.a.s.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> Object a(i<? super T> r2, kotlinx.coroutines.a.s<? extends T> r3, d.c.d<? super d.x> r4) {
        Object r5 = b((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin"), (kotlinx.coroutines.a.s) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.a.s.class, "com.obric.aiagent.plugin"), true, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        if (r5 != d.c.a.b.a()) goto L6;
        return r5;
    L6:
        return d.x.f38692a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, kotlinx.coroutines.b.i] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00de -> B:14:0x006f). Please report as a decompilation issue!!! */
    private static final <T> Object b(i<? super T> r9, kotlinx.coroutines.a.s<? extends T> r10, boolean r11, d.c.d<? super d.x> r12) {
        i r13 = (i) ZeusTransformUtils.wrapperContextForParams(r9, i.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.a.s r14 = (kotlinx.coroutines.a.s) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.a.s.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r15, a.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f39034e;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        r11 = r0.f39033d;
        kotlinx.coroutines.a.f r17 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(r0.f39032c, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
        r14 = (kotlinx.coroutines.a.s) ZeusTransformUtils.preCheckCast(r0.f39031b, kotlinx.coroutines.a.s.class, "com.obric.aiagent.plugin");
        i r4 = (i) ZeusTransformUtils.preCheckCast(r0.f39030a, i.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L35
        ?? r5 = r4;
    L14:
        kotlinx.coroutines.a.f r18 = r17;
        ?? r19 = r5;
    L22:
        r0.f39030a = r19;     // Catch: Throwable -> L35
        r0.f39031b = r14;     // Catch: Throwable -> L35
        r0.f39032c = r18;     // Catch: Throwable -> L35
        r0.f39033d = r11;     // Catch: Throwable -> L35
        r0.f = 1;     // Catch: Throwable -> L35
        Object r6 = r18.a(r0);     // Catch: Throwable -> L35
        if (r6 != r2) goto L25;
        return r2;
    L25:
        ?? r7 = r19;
        r17 = r18;
        r16 = r6;
    L27:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L31;
        Object r110 = r17.a();     // Catch: Throwable -> L35
        r0.f39030a = r7;     // Catch: Throwable -> L35
        r0.f39031b = r14;     // Catch: Throwable -> L35
        r0.f39032c = r17;     // Catch: Throwable -> L35
        r0.f39033d = r11;     // Catch: Throwable -> L35
        r0.f = 2;     // Catch: Throwable -> L35
        Object r111 = r7.emit(r110, r0);     // Catch: Throwable -> L35
        r5 = r7;
        if (r111 != r2) goto L14;
        return r2;
    L31:
        if (r11 == false) goto L34;
        kotlinx.coroutines.a.j.a(r14, null);
    L34:
        return d.x.f38692a;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r11 = r0.f39033d;
        r17 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(r0.f39032c, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
        r14 = (kotlinx.coroutines.a.s) ZeusTransformUtils.preCheckCast(r0.f39031b, kotlinx.coroutines.a.s.class, "com.obric.aiagent.plugin");
        i r8 = (i) ZeusTransformUtils.preCheckCast(r0.f39030a, i.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L35
        r7 = r8;
        goto L27
    L20:
        d.o.a(r16);
        j.a(r13);
        r18 = r14.g();     // Catch: Throwable -> L35
        r19 = r13;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        if (r11 == false) goto L40;
        kotlinx.coroutines.a.j.a(r14, th);
    L40:
        throw th;
    L7:
        r0 = new a(r15);
        goto L8
    }

    public static final <T> h<T> a(kotlinx.coroutines.a.s<? extends T> r10) {
        return (h) ZeusTransformUtils.preCheckCast(new d((kotlinx.coroutines.a.s) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.a.s.class, "com.obric.aiagent.plugin"), false, null, 0, null, 28, null), h.class, "com.obric.aiagent.plugin");
    }
}
