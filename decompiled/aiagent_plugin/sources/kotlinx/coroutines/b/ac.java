package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bf;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.ce;

/* JADX INFO: compiled from: SharedFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ac<T> extends kotlinx.coroutines.b.a.b<ae> implements kotlinx.coroutines.b.a.q<T>, kotlinx.coroutines.b.c<T>, w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f38954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f38955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlinx.coroutines.a.a f38956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f38957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f38958e;
    private long f;
    private int g;
    private int h;

    /* JADX INFO: compiled from: SharedFlow.kt */
    private static final class a implements bf {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ac<?> f38959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f38960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f38961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d.c.d<d.x> f38962d;

        public a(ac<?> r3, long r4, Object r6, d.c.d<? super d.x> r7) {
            d.c.d<d.x> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38959a = r3;
            this.f38960b = r4;
            this.f38961c = r6;
            this.f38962d = r8;
        }

        @Override // kotlinx.coroutines.bf
        public void dispose() {
            ac.a(this.f38959a, this);
        }
    }

    /* JADX INFO: compiled from: SharedFlow.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38963a = null;

        static {
            int[] r0 = new int[kotlinx.coroutines.a.a.values().length];
            r0[kotlinx.coroutines.a.a.f38771a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[kotlinx.coroutines.a.a.f38773c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[kotlinx.coroutines.a.a.f38772b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f38963a = r0;
        }
    }

    /* JADX INFO: compiled from: SharedFlow.kt */
    @d.c.b.a.f(b = "SharedFlow.kt", c = {382, 389, 392}, d = "collect$suspendImpl", e = "kotlinx.coroutines.flow.SharedFlowImpl")
    static final class c<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f38964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f38965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f38966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f38967d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f38968e;
        final /* synthetic */ ac<T> f;
        int g;

        c(ac<T> r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f38968e = r3;
            this.g |= Integer.MIN_VALUE;
            return ac.a(this.f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // kotlinx.coroutines.b.h
    public Object collect(i<? super T> r3, d.c.d<?> r4) {
        return a(this, (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.b.w, kotlinx.coroutines.b.i
    public Object emit(T r3, d.c.d<? super d.x> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ int a(ac r0) {
        return r0.h;
    }

    public static final /* synthetic */ long a(ac r0, ae r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ void a(ac r0, int r1) {
        r0.h = r1;
    }

    public static final /* synthetic */ void a(ac r0, Object r1) {
        r0.d(r1);
    }

    public static final /* synthetic */ void a(ac r0, a r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ d.c.d[] a(ac r0, d.c.d[] r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ int b(ac r0) {
        return r0.f38955b;
    }

    public static final /* synthetic */ boolean b(ac r0, Object r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ long c(ac r2) {
        return r2.c();
    }

    public static final /* synthetic */ int d(ac r0) {
        return r0.l();
    }

    @Override // kotlinx.coroutines.b.a.b
    public /* synthetic */ kotlinx.coroutines.b.a.d[] b(int r2) {
        return (kotlinx.coroutines.b.a.d[]) ZeusTransformUtils.preCheckCast(a(r2), kotlinx.coroutines.b.a.d[].class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.b.a.b
    public /* synthetic */ kotlinx.coroutines.b.a.d g() {
        return (kotlinx.coroutines.b.a.d) ZeusTransformUtils.preCheckCast(f(), kotlinx.coroutines.b.a.d.class, "com.obric.aiagent.plugin");
    }

    public ac(int r1, int r2, kotlinx.coroutines.a.a r3) {
        this.f38954a = r1;
        this.f38955b = r2;
        this.f38956c = r3;
    }

    private final long c() {
        return Math.min(this.f, this.f38958e);
    }

    private final int k() {
        return (int) ((c() + ((long) this.g)) - this.f38958e);
    }

    private final int l() {
        return this.g + this.h;
    }

    private final long m() {
        return c() + ((long) this.g);
    }

    private final long n() {
        return (c() + ((long) this.g)) + ((long) this.h);
    }

    public final T d() {
        Object[] r0 = this.f38957d;
        d.h.b.o.a(r0);
        return (T) ad.a(r0, (this.f38958e + ((long) k())) - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Class, java.lang.Class<kotlinx.coroutines.b.ac>] */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlinx.coroutines.b.ac] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, kotlinx.coroutines.b.i] */
    /* JADX WARN: Type inference failed for: r10v22, types: [java.lang.Object, kotlinx.coroutines.b.ae] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object, kotlinx.coroutines.b.i] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x014f -> B:33:0x011e). Please report as a decompilation issue!!! */
    static /* synthetic */ <T> Object a(ac<T> r9, i<? super T> r10, d.c.d<?> r11) {
        ?? r0 = ac.class;
        ?? r12 = (i) ZeusTransformUtils.wrapperContextForParams(r10, i.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, c.class) == false) goto L7;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r13, c.class, "com.obric.aiagent.plugin");
        if ((r1.g & Integer.MIN_VALUE) == 0) goto L7;
        r1.g -= Integer.MIN_VALUE;
    L8:
        Object r14 = r1.f38968e;
        Object r3 = d.c.a.b.a();
        int r4 = r1.g;
        if (r4 != 0) goto L53;
        d.o.a(r14);
        ae r15 = (ae) ZeusTransformUtils.preCheckCast(r9.j(), ae.class, "com.obric.aiagent.plugin");
        boolean r2 = ZeusTransformUtils.instanceOf(r12, ao.class);     // Catch: Throwable -> L47
        ?? r16 = r12;
        r15 = r15;
        if (r2 == false) goto L32;
        ao r5 = (ao) ZeusTransformUtils.preCheckCast(r12, ao.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        r1.f38964a = r9;     // Catch: Throwable -> L47
        r1.f38965b = r12;     // Catch: Throwable -> L47
        r1.f38966c = r15;     // Catch: Throwable -> L47
        r1.g = 1;     // Catch: Throwable -> L47
        r16 = r12;
        r15 = r15;
        if (r5.a(r1) != r3) goto L32;
        return r3;
    L32:
        ca r6 = (ca) ZeusTransformUtils.preCheckCast(r1.getContext().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        ?? r17 = r16;
        ?? r18 = r15;
    L33:
        ?? r7 = r17;
        r12 = r18;
    L51:
        Object r19 = r9.a(r12);     // Catch: Throwable -> L45
        if (r19 != ad.f38969a) goto L39;
        r1.f38964a = r9;     // Catch: Throwable -> L45
        r1.f38965b = r7;     // Catch: Throwable -> L45
        r1.f38966c = r12;     // Catch: Throwable -> L45
        r1.f38967d = r6;     // Catch: Throwable -> L45
        r1.g = 2;     // Catch: Throwable -> L45
        if (r9.a(r12, r1) != r3) goto L51;
        return r3;
    L39:
        if (r6 == null) goto L41;
        ce.b(r6);     // Catch: Throwable -> L45
    L41:
        r1.f38964a = r9;     // Catch: Throwable -> L45
        r1.f38965b = r7;     // Catch: Throwable -> L45
        r1.f38966c = r12;     // Catch: Throwable -> L45
        r1.f38967d = r6;     // Catch: Throwable -> L45
        r1.g = 3;     // Catch: Throwable -> L45
        if (r7.emit(r19, r1) != r3) goto L44;
        return r3;
    L44:
        r18 = r12;
        r17 = r7;
    L45:
        th = move-exception;
        r0 = r9;
        th = th;
    L49:
        r0.a((kotlinx.coroutines.b.a.d) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.b.a.d.class, "com.obric.aiagent.plugin"));
        throw th;
    L47:
        th = move-exception;
        r0 = r9;
        th = th;
        r12 = r15;
        goto L49
    L53:
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L18;
        if (r4 != 3) goto L17;
        ca r20 = (ca) ZeusTransformUtils.preCheckCast(r1.f38967d, ca.class, "com.obric.aiagent.plugin");
        ae r110 = (ae) ZeusTransformUtils.preCheckCast(r1.f38966c, ae.class, "com.obric.aiagent.plugin");
        i r8 = (i) ZeusTransformUtils.preCheckCast(r1.f38965b, i.class, "com.obric.aiagent.plugin");
        ac<T> r21 = (ac) ZeusTransformUtils.preCheckCast(r1.f38964a, r0, "com.obric.aiagent.plugin");
        d.o.a(r14);     // Catch: Throwable -> L24
        r18 = r110;
        r17 = r8;
        r6 = r20;
        r9 = r21;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ca r22 = (ca) ZeusTransformUtils.preCheckCast(r1.f38967d, ca.class, "com.obric.aiagent.plugin");
        ae r111 = (ae) ZeusTransformUtils.preCheckCast(r1.f38966c, ae.class, "com.obric.aiagent.plugin");
        i r23 = (i) ZeusTransformUtils.preCheckCast(r1.f38965b, i.class, "com.obric.aiagent.plugin");
        ac<T> r24 = (ac) ZeusTransformUtils.preCheckCast(r1.f38964a, r0, "com.obric.aiagent.plugin");
        d.o.a(r14);     // Catch: Throwable -> L24
        r6 = r22;
        r9 = r24;
        r7 = r23;
        r12 = r111;
        goto L51
    L21:
        ae r112 = (ae) ZeusTransformUtils.preCheckCast(r1.f38966c, ae.class, "com.obric.aiagent.plugin");
        i r25 = (i) ZeusTransformUtils.preCheckCast(r1.f38965b, i.class, "com.obric.aiagent.plugin");
        ac<T> r26 = (ac) ZeusTransformUtils.preCheckCast(r1.f38964a, r0, "com.obric.aiagent.plugin");
        d.o.a(r14);     // Catch: Throwable -> L24
        r15 = r112;
        r16 = r25;
        r9 = r26;
    L24:
        th = th;
    L7:
        r1 = new c(r9, r13);
        goto L8
    }

    @Override // kotlinx.coroutines.b.w
    public boolean a(T r5) {
        d.c.d<d.x>[] r0 = kotlinx.coroutines.b.a.c.f38881a;
        monitor-enter(this);
        int r1 = 0;
        if (b(r5) == false) goto L8;
        r0 = a(r0);     // Catch: Throwable -> L17
        boolean r6 = true;
    L9:
        monitor-exit(this);
        int r4 = r0.length;
    L11:
        if (r1 >= r4) goto L16;
        d.c.d<d.x> r2 = r0[r1];
        if (r2 == null) goto L15;
        d.n.a r3 = d.n.f38560a;
        r2.resumeWith(d.n.f(d.x.f38692a));
    L15:
        r1 = r1 + 1;
        goto L11
    L16:
        return r6;
    L8:
        r6 = false;
    L17:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ <T> Object a(ac<T> r2, T r3, d.c.d<? super d.x> r4) {
        d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (r2.a(r3) == true) goto L5;
        Object r6 = r2.a(r3, r5);
        if (r6 != d.c.a.b.a()) goto L10;
        return r6;
    L10:
        return d.x.f38692a;
    L5:
        return d.x.f38692a;
    }

    private final boolean b(T r15) {
        if (i() != 0) goto L7;
        return c(r15);
    L7:
        if (this.g >= this.f38955b) goto L9;
    L18:
        d(r15);
        int r16 = this.g + 1;
        this.g = r16;
        if (r16 <= this.f38955b) goto L22;
        o();
    L22:
        if (k() <= this.f38954a) goto L24;
        a(this.f38958e + 1, this.f, m(), n());
    L24:
        return true;
    L9:
        if (this.f > this.f38958e) goto L18;
        kotlinx.coroutines.a.a r0 = this.f38956c;
        int r1 = b.f38963a[r0.ordinal()];
        if (r1 != 1) goto L13;
        return false;
    L13:
        if (r1 != 2) goto L18;
        return true;
    }

    private final boolean c(T r7) {
        if (aq.a() == false) goto L13;
        if (i() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (this.f38954a != 0) goto L15;
        return true;
    L15:
        d(r7);
        int r8 = this.g + 1;
        this.g = r8;
        if (r8 <= this.f38954a) goto L18;
        o();
    L18:
        this.f = c() + ((long) this.g);
        return true;
    }

    private final void o() {
        Object[] r0 = this.f38957d;
        d.h.b.o.a(r0);
        ad.a(r0, c(), null);
        this.g--;
        long r1 = c() + 1;
        if (this.f38958e >= r1) goto L6;
        this.f38958e = r1;
    L6:
        if (this.f >= r1) goto L9;
        b(r1);
    L9:
        if (aq.a() == true) goto L11;
        return;
    L11:
        if (c() != r1) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L17;
        return;
    L17:
        throw new AssertionError();
    L13:
        r4 = false;
        goto L14
    }

    private final void b(long r10) {
        kotlinx.coroutines.b.a.b r0 = (kotlinx.coroutines.b.a.b) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.b.a.b.class, "com.obric.aiagent.plugin");
        if (kotlinx.coroutines.b.a.b.a(r0) == 0) goto L16;
        kotlinx.coroutines.b.a.d[] r1 = kotlinx.coroutines.b.a.b.b(r0);
        if (r1 == null) goto L16;
        int r2 = 0;
        int r3 = r1.length;
    L7:
        if (r2 >= r3) goto L16;
        kotlinx.coroutines.b.a.d r4 = r1[r2];
        if (r4 == null) goto L15;
        ae r5 = (ae) ZeusTransformUtils.preCheckCast(r4, ae.class, "com.obric.aiagent.plugin");
        if (r5.f38970a < 0) goto L15;
        if (r5.f38970a >= r10) goto L15;
        r5.f38970a = r10;
    L15:
        r2 = r2 + 1;
    L16:
        this.f = r10;
    }

    private final void d(Object r7) {
        int r0 = l();
        Object[] r1 = this.f38957d;
        if (r1 != null) goto L6;
        r1 = a(null, 0, 2);
    L8:
        ad.a(r1, c() + ((long) r0), r7);
        return;
    L6:
        if (r0 < r1.length) goto L8;
        r1 = a(r1, r0, r1.length * 2);
        goto L8
    }

    private final Object[] a(Object[] r6, int r7, int r8) {
        int r0 = 0;
        if (r8 <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L15;
        Object[] r9 = new Object[r8];
        this.f38957d = r9;
        if (r6 != null) goto L10;
        return r9;
    L10:
        long r2 = c();
    L11:
        if (r0 >= r7) goto L13;
        long r3 = ((long) r0) + r2;
        ad.a(r9, r3, ad.a(r6, r3));
        r0 = r0 + 1;
        goto L11
    L13:
        return r9;
    L15:
        throw new IllegalStateException("Buffer size overflow".toString());
    L5:
        r1 = false;
        goto L6
    }

    public final long e() {
        long r0 = this.f38958e;
        if (r0 >= this.f) goto L5;
        this.f = r0;
    L5:
        return r0;
    }

    public final d.c.d<d.x>[] a(long r24) {
        if (aq.a() == false) goto L13;
        if (r24 < this.f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (r24 > this.f) goto L15;
        long r1 = c();
        long r2 = ((long) this.g) + r1;
        if (this.f38955b == 0) goto L19;
    L21:
        kotlinx.coroutines.b.a.b r4 = (kotlinx.coroutines.b.a.b) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.b.a.b.class, "com.obric.aiagent.plugin");
        if (kotlinx.coroutines.b.a.b.a(r4) == 0) goto L36;
        kotlinx.coroutines.b.a.d[] r5 = kotlinx.coroutines.b.a.b.b(r4);
        if (r5 == null) goto L36;
        int r8 = r5.length;
        int r12 = 0;
    L26:
        if (r12 >= r8) goto L36;
        kotlinx.coroutines.b.a.d r13 = r5[r12];
        if (r13 == null) goto L34;
        ae r14 = (ae) ZeusTransformUtils.preCheckCast(r13, ae.class, "com.obric.aiagent.plugin");
        if (r14.f38970a < 0) goto L34;
        if (r14.f38970a >= r2) goto L34;
        r2 = r14.f38970a;
    L34:
        r12 = r12 + 1;
    L36:
        if (aq.a() == false) goto L46;
        if (r2 < this.f) goto L40;
        boolean r6 = true;
    L41:
        if (r6 == true) goto L46;
        throw new AssertionError();
    L40:
        r6 = false;
    L46:
        if (r2 <= this.f) goto L48;
        long r15 = m();
        if (i() <= 0) goto L52;
        int r7 = Math.min(this.h, this.f38955b - ((int) (r15 - r2)));
    L53:
        d.c.d<d.x>[] r9 = kotlinx.coroutines.b.a.c.f38881a;
        long r16 = ((long) this.h) + r15;
        if (r7 <= 0) goto L67;
        r9 = new d.c.d[r7];
        Object[] r10 = this.f38957d;
        d.h.b.o.a(r10);
        long r11 = r15;
        int r17 = 0;
    L57:
        if (r15 >= r16) goto L65;
        Object r18 = ad.a(r10, r15);
        long r19 = r2;
        if (r18 == ad.f38969a) goto L63;
        d.h.b.o.a(r18, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
        a r3 = (a) ZeusTransformUtils.preCheckCast(r18, a.class, "com.obric.aiagent.plugin");
        int r20 = r17 + 1;
        r9[r17] = ((a) ZeusTransformUtils.preCheckCast(r18, a.class, "com.obric.aiagent.plugin")).f38962d;
        ad.a(r10, r15, ad.f38969a);
        ad.a(r10, r11, ((a) ZeusTransformUtils.preCheckCast(r18, a.class, "com.obric.aiagent.plugin")).f38961c);
        long r21 = 1;
        r11 = r11 + 1;
        if (r20 >= r7) goto L66;
        r17 = r20;
    L64:
        r15 = r15 + r21;
        r2 = r19;
    L66:
        r15 = r11;
    L68:
        d.c.d<d.x>[] r110 = r9;
        int r22 = (int) (r15 - r1);
        if (i() != 0) goto L71;
        long r23 = r15;
    L72:
        long r25 = Math.max(this.f38958e, r15 - ((long) Math.min(this.f38954a, r22)));
        if (this.f38955b == 0) goto L75;
    L79:
        a(r25, r23, r15, r16);
        p();
        if (r110.length != 0) goto L82;
        boolean r111 = true;
    L84:
        if ((!r111) == true) goto L86;
        return r110;
    L86:
        return a(r110);
    L82:
        r111 = false;
        goto L84
    L75:
        if (r25 >= r16) goto L79;
        Object[] r26 = this.f38957d;
        d.h.b.o.a(r26);
        if (d.h.b.o.a(ad.a(r26, r25), ad.f38969a) == false) goto L79;
        r15 = r15 + 1;
        r25 = r25 + 1;
        goto L79
    L71:
        r23 = r19;
        goto L72
    L63:
        r21 = 1;
        goto L64
    L65:
        r19 = r2;
        goto L66
    L67:
        r19 = r2;
        goto L68
    L52:
        r7 = this.h;
        goto L53
    L48:
        return kotlinx.coroutines.b.a.c.f38881a;
    L19:
        if (this.h <= 0) goto L21;
        r2 = r2 + 1;
        goto L21
    L15:
        return kotlinx.coroutines.b.a.c.f38881a;
    }

    private final void a(long r15, long r17, long r19, long r21) {
        long r5 = Math.min(r17, r15);
        boolean r8 = true;
        if (aq.a() == true) goto L5;
    L12:
        long r10 = c();
    L14:
        if (r10 >= r5) goto L16;
        Object[] r7 = this.f38957d;
        d.h.b.o.a(r7);
        ad.a(r7, r10, null);
        r10 = r10 + 1;
        goto L14
    L16:
        this.f38958e = r15;
        this.f = r17;
        this.g = (int) (r19 - r5);
        this.h = (int) (r21 - r19);
        if (aq.a() == false) goto L27;
        if (this.g < 0) goto L21;
        boolean r1 = true;
    L22:
        if (r1 == true) goto L27;
        throw new AssertionError();
    L21:
        r1 = false;
    L27:
        if (aq.a() == false) goto L37;
        if (this.h < 0) goto L31;
        boolean r2 = true;
    L32:
        if (r2 == true) goto L37;
        throw new AssertionError();
    L31:
        r2 = false;
    L37:
        if (aq.a() == true) goto L39;
        return;
    L39:
        if (this.f38958e <= (c() + ((long) this.g))) goto L42;
        r8 = false;
    L42:
        if (r8 == false) goto L45;
        return;
    L45:
        throw new AssertionError();
    L5:
        if (r5 < c()) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == true) goto L12;
        throw new AssertionError();
    L7:
        r9 = false;
        goto L8
    }

    private final void p() {
        if (this.f38955b == 0) goto L5;
    L7:
        Object[] r0 = this.f38957d;
        d.h.b.o.a(r0);
    L9:
        if (this.h <= 0) goto L13;
        if (ad.a(r0, (c() + ((long) l())) - 1) != ad.f38969a) goto L16;
        this.h--;
        ad.a(r0, c() + ((long) l()), null);
        goto L9
    L16:
        return;
    L13:
        return;
    L5:
        if (this.h > 1) goto L7;
    }

    private final Object a(ae r9) {
        d.c.d<d.x>[] r0 = kotlinx.coroutines.b.a.c.f38881a;
        monitor-enter(this);
        long r1 = b(r9);     // Catch: Throwable -> L17
        if (r1 >= 0) goto L7;
        Object r10 = ad.f38969a;     // Catch: Throwable -> L17
    L9:
        monitor-exit(this);
        int r8 = 0;
        int r2 = r0.length;
    L11:
        if (r8 >= r2) goto L16;
        d.c.d<d.x> r3 = r0[r8];
        if (r3 == null) goto L15;
        d.n.a r4 = d.n.f38560a;
        r3.resumeWith(d.n.f(d.x.f38692a));
    L15:
        r8 = r8 + 1;
        goto L11
    L16:
        return r10;
    L7:
        long r5 = r9.f38970a;     // Catch: Throwable -> L17
        Object r6 = c(r1);     // Catch: Throwable -> L17
        r9.f38970a = r1 + 1;     // Catch: Throwable -> L17
        r0 = a(r5);     // Catch: Throwable -> L17
        r10 = r6;
    L17:
        th = move-exception;
        throw th;
    }

    private final long b(ae r7) {
        long r0 = r7.f38970a;
        if (r0 >= m()) goto L6;
        return r0;
    L6:
        if (this.f38955b <= 0) goto L9;
        return -1;
    L9:
        if (r0 <= c()) goto L12;
        return -1;
    L12:
        if (this.h != 0) goto L14;
        return -1;
    L14:
        return r0;
    }

    private final Object c(long r1) {
        Object[] r0 = this.f38957d;
        d.h.b.o.a(r0);
        Object r2 = ad.a(r0, r1);
        if (ZeusTransformUtils.instanceOf(r2, a.class) == true) goto L5;
        return r2;
    L5:
        return ((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin")).f38961c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [d.c.d<d.x>[]] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    private final d.c.d<d.x>[] a(d.c.d<d.x>[] r12) {
        int r0 = r12.length;
        kotlinx.coroutines.b.a.b r1 = (kotlinx.coroutines.b.a.b) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.b.a.b.class, "com.obric.aiagent.plugin");
        if (kotlinx.coroutines.b.a.b.a(r1) == 0) goto L21;
        kotlinx.coroutines.b.a.d[] r2 = kotlinx.coroutines.b.a.b.b(r1);
        if (r2 == null) goto L21;
        int r3 = 0;
        int r4 = r2.length;
        r12 = r12;
    L7:
        if (r3 >= r4) goto L21;
        kotlinx.coroutines.b.a.d r5 = r2[r3];
        if (r5 == null) goto L19;
        ae r6 = (ae) ZeusTransformUtils.preCheckCast(r5, ae.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r7 = r6.f38971b;
        if (r7 == null) goto L19;
        if (b(r6) < 0) goto L19;
        int r8 = r12.length;
        r12 = r12;
        if (r0 < r8) goto L18;
        Object[] r13 = Arrays.copyOf(r12, Math.max(2, r12.length * 2));
        d.h.b.o.c(r13, "copyOf(...)");
        r12 = r13;
    L18:
        ((d.c.d[]) ZeusTransformUtils.preCheckCast(r12, d.c.d[].class, "com.obric.aiagent.plugin"))[r0] = r7;
        r6.f38971b = null;
        r0 = r0 + 1;
    L19:
        r3 = r3 + 1;
        r12 = r12;
    L21:
        return (d.c.d[]) ZeusTransformUtils.preCheckCast(r12, d.c.d[].class, "com.obric.aiagent.plugin");
    }

    public ae f() {
        return new ae();
    }

    public ae[] a(int r1) {
        return new ae[r1];
    }

    @Override // kotlinx.coroutines.b.a.q
    public h<T> a_(d.c.g r3, int r4, kotlinx.coroutines.a.a r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        return ad.a((ab) ZeusTransformUtils.preCheckCast(this, ab.class, "com.obric.aiagent.plugin"), r6, r4, r5);
    }

    private final Object a(T r12, d.c.d<? super d.x> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(d.c.a.b.a(r14), 1);
        r0.e();
        kotlinx.coroutines.n r1 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        d.c.d<d.x>[] r3 = kotlinx.coroutines.b.a.c.f38881a;
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (b(this, r12) == false) goto L7;
        d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(r1, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L28
        r15.resumeWith(d.n.f(d.x.f38692a));     // Catch: Throwable -> L28
        d.c.d<d.x>[] r16 = a(this, r3);     // Catch: Throwable -> L28
        a r4 = null;
    L11:
        monitor-exit(this);
        if (r4 == null) goto L14;
        kotlinx.coroutines.q.a(r1, (bf) ZeusTransformUtils.preCheckCast(r4, bf.class, "com.obric.aiagent.plugin"));
    L14:
        int r11 = 0;
        int r5 = r16.length;
    L15:
        if (r11 >= r5) goto L20;
        d.c.d<d.x> r6 = r16[r11];
        if (r6 == null) goto L19;
        d.n.a r7 = d.n.f38560a;
        r6.resumeWith(d.n.f(d.x.f38692a));
    L19:
        r11 = r11 + 1;
        goto L15
    L20:
        Object r17 = r0.h();
        if (r17 != d.c.a.b.a()) goto L24;
        d.c.b.a.h.c(r14);
    L24:
        if (r17 != d.c.a.b.a()) goto L27;
        return r17;
    L27:
        return d.x.f38692a;
    L7:
        long r8 = c(this);     // Catch: Throwable -> L28
        a r10 = new a(this, ((long) d(this)) + r8, r12, (d.c.d) ZeusTransformUtils.preCheckCast(r1, d.c.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L28
        a(this, r10);     // Catch: Throwable -> L28
        a(this, a(this) + 1);     // Catch: Throwable -> L28
        if (b(this) != 0) goto L10;
        r3 = a(this, r3);     // Catch: Throwable -> L28
    L10:
        r16 = r3;
        r4 = r10;
        goto L11
    }

    private final void a(a r5) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r5.f38960b >= c()) goto L8;
        monitor-exit(this);
        return;
    L8:
        Object[] r0 = this.f38957d;     // Catch: Throwable -> L15
        d.h.b.o.a(r0);     // Catch: Throwable -> L15
        if (ad.a(r0, r5.f38960b) == r5) goto L12;
        monitor-exit(this);
        return;
    L12:
        ad.a(r0, r5.f38960b, ad.f38969a);     // Catch: Throwable -> L15
        p();     // Catch: Throwable -> L15
        d.x r6 = d.x.f38692a;     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    private final Object a(ae r7, d.c.d<? super d.x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(d.c.a.b.a(r9), 1);
        r0.e();
        kotlinx.coroutines.n r1 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (a(this, r7) >= 0) goto L7;
        r7.f38971b = (d.c.d) ZeusTransformUtils.preCheckCast(r1, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        r7.f38971b = (d.c.d) ZeusTransformUtils.preCheckCast(r1, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
    L8:
        d.x r10 = d.x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(this);
        Object r6 = r0.h();
        if (r6 != d.c.a.b.a()) goto L14;
        d.c.b.a.h.c(r9);
    L14:
        if (r6 != d.c.a.b.a()) goto L17;
        return r6;
    L17:
        return d.x.f38692a;
    L7:
        d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(r1, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L18
        r11.resumeWith(d.n.f(d.x.f38692a));     // Catch: Throwable -> L18
        goto L8
    }

    @Override // kotlinx.coroutines.b.w
    public void b() {
        monitor-enter(this);
        a(m(), this.f, m(), n());     // Catch: Throwable -> L6
        d.x r0 = d.x.f38692a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
