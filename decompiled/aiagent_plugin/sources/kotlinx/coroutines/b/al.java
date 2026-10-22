package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.ce;

/* JADX INFO: compiled from: StateFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
final class al<T> extends kotlinx.coroutines.b.a.b<an> implements kotlinx.coroutines.b.a.q<T>, c<T>, x<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f38993b = null;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f38994a;

    /* JADX INFO: compiled from: StateFlow.kt */
    @d.c.b.a.f(b = "StateFlow.kt", c = {384, 396, 401}, d = "collect", e = "kotlinx.coroutines.flow.StateFlowImpl")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f38995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f38996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f38997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f38998d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f38999e;
        /* synthetic */ Object f;
        final /* synthetic */ al<T> g;
        int h;

        a(al<T> r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.collect(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f38993b = AtomicReferenceFieldUpdater.newUpdater(al.class, Object.class, "_state$volatile");
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater e() {
        return f38993b;
    }

    @Override // kotlinx.coroutines.b.a.b
    public /* synthetic */ kotlinx.coroutines.b.a.d[] b(int r2) {
        return (kotlinx.coroutines.b.a.d[]) ZeusTransformUtils.preCheckCast(a(r2), kotlinx.coroutines.b.a.d[].class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.b.a.b
    public /* synthetic */ kotlinx.coroutines.b.a.d g() {
        return (kotlinx.coroutines.b.a.d) ZeusTransformUtils.preCheckCast(d(), kotlinx.coroutines.b.a.d.class, "com.obric.aiagent.plugin");
    }

    public al(Object r1) {
        this._state$volatile = r1;
    }

    @Override // kotlinx.coroutines.b.x, kotlinx.coroutines.b.ak
    public T c() {
        kotlinx.coroutines.internal.al r0 = kotlinx.coroutines.b.a.t.f38938a;
        T r2 = (T) e().get(this);
        if (r2 != r0) goto L6;
        return null;
    L6:
        return r2;
    }

    @Override // kotlinx.coroutines.b.x
    public void b(T r2) {
        if (r2 != null) goto L4;
        r2 = (T) kotlinx.coroutines.b.a.t.f38938a;
    L4:
        b(null, r2);
    }

    @Override // kotlinx.coroutines.b.x
    public boolean a(T r1, T r2) {
        if (r1 != null) goto L4;
        r1 = (T) kotlinx.coroutines.b.a.t.f38938a;
    L4:
        if (r2 != null) goto L7;
        r2 = (T) kotlinx.coroutines.b.a.t.f38938a;
    L7:
        return b(r1, r2);
    }

    @Override // kotlinx.coroutines.b.w
    public boolean a(T r1) {
        b(r1);
        return true;
    }

    @Override // kotlinx.coroutines.b.w, kotlinx.coroutines.b.i
    public Object emit(T r3, d.c.d<? super d.x> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        b(r3);
        return d.x.f38692a;
    }

    @Override // kotlinx.coroutines.b.w
    public void b() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Class, java.lang.Class<kotlinx.coroutines.b.al>] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.coroutines.b.al] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, kotlinx.coroutines.b.an] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, kotlinx.coroutines.b.i] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0157 -> B:33:0x011f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0169 -> B:33:0x011f). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.b.h
    public Object collect(i<? super T> r12, d.c.d<?> r13) {
        ?? r0 = al.class;
        i r14 = (i) ZeusTransformUtils.wrapperContextForParams(r12, i.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, a.class) == false) goto L7;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r15, a.class, "com.obric.aiagent.plugin");
        if ((r1.h & Integer.MIN_VALUE) == 0) goto L7;
        r1.h -= Integer.MIN_VALUE;
    L8:
        Object r16 = r1.f;
        Object r3 = d.c.a.b.a();
        ?? r4 = r1.h;
        if (r4 == 0) goto L26;
        if (r4 != 1) goto L59;
        an r5 = (an) ZeusTransformUtils.preCheckCast(r1.f38997c, an.class, "com.obric.aiagent.plugin");
        r14 = (i) ZeusTransformUtils.preCheckCast(r1.f38996b, i.class, "com.obric.aiagent.plugin");
        al<T> this = (al) ZeusTransformUtils.preCheckCast(r1.f38995a, r0, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L53
        an r6 = r5;
    L32:
        ?? r8 = r14;
        ca r17 = (ca) ZeusTransformUtils.preCheckCast(r1.getContext().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L53
        Object r18 = null;
        r4 = r6;
    L33:
        Object r2 = e().get(this);     // Catch: Throwable -> L53
        if (r17 == null) goto L36;
        ce.b(r17);     // Catch: Throwable -> L53
    L36:
        if (r18 == null) goto L40;
        ?? r7 = r4;
        ?? r9 = r8;
        if (d.h.b.o.a(r18, r2) == false) goto L40;
    L48:
        boolean r10 = r7.b();     // Catch: Throwable -> L53
        r4 = r7;
        r8 = r9;
        if (r10 == true) goto L33;
        r1.f38995a = this;     // Catch: Throwable -> L53
        r1.f38996b = r9;     // Catch: Throwable -> L53
        r1.f38997c = r7;     // Catch: Throwable -> L53
        r1.f38998d = r17;     // Catch: Throwable -> L53
        r1.f38999e = r18;     // Catch: Throwable -> L53
        r1.h = 3;     // Catch: Throwable -> L53
        Object r11 = r7.a(r1);     // Catch: Throwable -> L53
        r4 = r7;
        r8 = r9;
        if (r11 != r3) goto L33;
        return r3;
    L40:
        if (r2 != kotlinx.coroutines.b.a.t.f38938a) goto L42;
        Object r19 = null;
    L43:
        r1.f38995a = this;     // Catch: Throwable -> L53
        r1.f38996b = r8;     // Catch: Throwable -> L53
        r1.f38997c = r4;     // Catch: Throwable -> L53
        r1.f38998d = r17;     // Catch: Throwable -> L53
        r1.f38999e = r2;     // Catch: Throwable -> L53
        r1.h = 2;     // Catch: Throwable -> L53
        if (r8.emit(r19, r1) != r3) goto L46;
        return r3;
    L46:
        al<T> r20 = this;
        Object r110 = r2;
        ?? r21 = r4;
        ?? r22 = r8;
    L47:
        r18 = r110;
        this = r20;
        r7 = r21;
        r9 = r22;
        goto L48
    L42:
        r19 = r2;
        goto L43
    L59:
        if (r4 == 2) goto L18;
        if (r4 != 3) goto L17;
        Object r111 = r1.f38999e;
        r17 = (ca) ZeusTransformUtils.preCheckCast(r1.f38998d, ca.class, "com.obric.aiagent.plugin");
        an r23 = (an) ZeusTransformUtils.preCheckCast(r1.f38997c, an.class, "com.obric.aiagent.plugin");
        i r24 = (i) ZeusTransformUtils.preCheckCast(r1.f38996b, i.class, "com.obric.aiagent.plugin");
        al<T> r25 = (al) ZeusTransformUtils.preCheckCast(r1.f38995a, r0, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L21
        r18 = r111;
        this = r25;
        r4 = r23;
        r8 = r24;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r110 = r1.f38999e;
        r17 = (ca) ZeusTransformUtils.preCheckCast(r1.f38998d, ca.class, "com.obric.aiagent.plugin");
        an r26 = (an) ZeusTransformUtils.preCheckCast(r1.f38997c, an.class, "com.obric.aiagent.plugin");
        i r27 = (i) ZeusTransformUtils.preCheckCast(r1.f38996b, i.class, "com.obric.aiagent.plugin");
        r20 = (al) ZeusTransformUtils.preCheckCast(r1.f38995a, r0, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L21
        r21 = r26;
        r22 = r27;
    L21:
        Throwable th = th;
    L55:
        r0.a((kotlinx.coroutines.b.a.d) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.b.a.d.class, "com.obric.aiagent.plugin"));
        throw th;
    L26:
        d.o.a(r16);
        an r28 = (an) ZeusTransformUtils.preCheckCast(j(), an.class, "com.obric.aiagent.plugin");
        r6 = r28;
        if (ZeusTransformUtils.instanceOf(r14, ao.class) == false) goto L32;
        ao r112 = (ao) ZeusTransformUtils.preCheckCast(r14, ao.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L53
        r1.f38995a = this;     // Catch: Throwable -> L53
        r1.f38996b = r14;     // Catch: Throwable -> L53
        r1.f38997c = r28;     // Catch: Throwable -> L53
        r1.h = 1;     // Catch: Throwable -> L53
        r6 = r28;
        if (r112.a(r1) != r3) goto L32;
        return r3;
    L53:
        th = move-exception;
        r0 = this;
        th = th;
    L7:
        r1 = new a(this, r15);
        goto L8
    }

    public an d() {
        return new an();
    }

    public an[] a(int r1) {
        return new an[r1];
    }

    @Override // kotlinx.coroutines.b.a.q
    public h<T> a_(d.c.g r3, int r4, kotlinx.coroutines.a.a r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        return am.a((ak) ZeusTransformUtils.preCheckCast(this, ak.class, "com.obric.aiagent.plugin"), r6, r4, r5);
    }

    private final boolean b(Object r7, Object r8) {
        monitor-enter(this);
        Object r0 = e().get(this);     // Catch: Throwable -> L42
        if (r7 == null) goto L11;
        if (d.h.b.o.a(r0, r7) == true) goto L11;
        monitor-exit(this);
        return false;
    L11:
        if (d.h.b.o.a(r0, r8) == false) goto L14;
        monitor-exit(this);
        return true;
    L14:
        e().set(this, r8);     // Catch: Throwable -> L42
        int r9 = this.f38994a;     // Catch: Throwable -> L42
        if ((r9 & 1) != 0) goto L39;
        int r10 = r9 + 1;     // Catch: Throwable -> L42
        this.f38994a = r10;     // Catch: Throwable -> L42
        an[] r11 = h();     // Catch: Throwable -> L42
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L42
        monitor-exit(this);
    L18:
        an[] r12 = (an[]) ZeusTransformUtils.preCheckCast(r11, an[].class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L26;
        int r3 = r12.length;
        int r4 = 0;
    L21:
        if (r4 >= r3) goto L26;
        an r5 = r12[r4];
        if (r5 == null) goto L25;
        r5.a();
    L25:
        r4 = r4 + 1;
    L26:
        monitor-enter(this);
        int r13 = this.f38994a;     // Catch: Throwable -> L35
        if (r13 == r10) goto L29;
        an[] r14 = h();     // Catch: Throwable -> L35
        d.x r6 = d.x.f38692a;     // Catch: Throwable -> L35
        monitor-exit(this);
        r11 = r14;
        r10 = r13;
        goto L18
    L29:
        this.f38994a = r10 + 1;     // Catch: Throwable -> L35
        monitor-exit(this);
        return true;
    L35:
        th = move-exception;
        throw th;
    L39:
        this.f38994a = r9 + 2;     // Catch: Throwable -> L42
        monitor-exit(this);
        return true;
    L42:
        th = move-exception;
        throw th;
    }
}
