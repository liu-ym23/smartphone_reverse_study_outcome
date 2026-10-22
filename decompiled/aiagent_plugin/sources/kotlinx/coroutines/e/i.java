package kotlinx.coroutines.e;

import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.q;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bf;
import kotlinx.coroutines.internal.ai;
import kotlinx.coroutines.internal.ak;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: Select.kt */
/* JADX INFO: loaded from: classes4.dex */
public class i<R> implements kotlinx.coroutines.e.c<R>, k<R>, kotlinx.coroutines.m {
    private static final /* synthetic */ AtomicReferenceFieldUpdater f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.g f39289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<i<R>.a> f39290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f39291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f39292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f39293e;
    private volatile /* synthetic */ Object state$volatile;

    /* JADX INFO: compiled from: Select.kt */
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f39294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q<j<?>, Object, Object, d.h.a.b<Throwable, x>> f39295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f39296c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f39297d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ i<R> f39298e;
        private final q<Object, j<?>, Object, x> f;
        private final q<Object, Object, Object, Object> g;
        private final Object h;
        private final Object i;

        public a(i r3, Object r4, q<Object, ? super j<?>, Object, x> r5, q<Object, Object, Object, ? extends Object> r6, Object r7, Object r8, q<? super j<?>, Object, Object, ? extends d.h.a.b<? super Throwable, x>> r9) {
            q<Object, j<?>, Object, x> r10 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
            q<Object, Object, Object, Object> r11 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.aiagent.plugin");
            q<j<?>, Object, Object, d.h.a.b<Throwable, x>> r12 = (q) ZeusTransformUtils.wrapperContextForParams(r9, q.class, "com.obric.aiagent.plugin");
            this.f39298e = r3;
            this.f39294a = r4;
            this.f = r10;
            this.g = r11;
            this.h = r7;
            this.i = r8;
            this.f39295b = r12;
            this.f39297d = -1;
        }

        public final boolean a(i<R> r5) {
            if (aq.a() == false) goto L16;
            if (i.b(r5) == false) goto L7;
        L10:
            boolean r0 = true;
        L11:
            if (r0 == true) goto L16;
            throw new AssertionError();
        L7:
            if (i.c(r5) == true) goto L10;
            r0 = false;
        L16:
            if (aq.a() == true) goto L18;
        L25:
            this.f.invoke(this.f39294a, r5, this.h);
            if (i.a(r5) == l.d()) goto L28;
            return false;
        L28:
            return true;
        L18:
            if (i.a(r5) != l.d()) goto L20;
            boolean r1 = true;
        L21:
            if (r1 == true) goto L25;
            throw new AssertionError();
        L20:
            r1 = false;
            goto L21
        }

        public final Object a(Object r3) {
            return this.g.invoke(this.f39294a, this.h, r3);
        }

        public final Object a(Object r4, d.c.d<? super R> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            Object r0 = this.i;
            if (this.h != l.a()) goto L6;
            o.a(r0, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
            d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r0, d.h.a.b.class, "com.obric.aiagent.plugin");
            return ((d.h.a.b) ZeusTransformUtils.preCheckCast(r0, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r6);
        L6:
            o.a(r0, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            d.h.a.m r7 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r0, d.h.a.m.class, "com.obric.aiagent.plugin");
            return ((d.h.a.m) ZeusTransformUtils.preCheckCast(r0, d.h.a.m.class, "com.obric.aiagent.plugin")).invoke(r4, r6);
        }

        public final void a() {
            Object r0 = this.f39296c;
            i<R> r1 = this.f39298e;
            bf r3 = null;
            if (ZeusTransformUtils.instanceOf(r0, ai.class) == false) goto L6;
            ((ai) ZeusTransformUtils.preCheckCast(r0, ai.class, "com.obric.aiagent.plugin")).a(this.f39297d, null, r1.getContext());
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r0, bf.class) == false) goto L8;
            r3 = (bf) ZeusTransformUtils.preCheckCast(r0, bf.class, "com.obric.aiagent.plugin");
        L8:
            if (r3 == null) goto L12;
            r3.dispose();
            return;
        }

        public final d.h.a.b<Throwable, x> a(j<?> r3, Object r4) {
            j<?> r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
            q<j<?>, Object, Object, d.h.a.b<Throwable, x>> r0 = this.f39295b;
            if (r0 != null) goto L7;
            return null;
        L7:
            return (d.h.a.b) ZeusTransformUtils.preCheckCast(r0.invoke(r5, this.h, r4), d.h.a.b.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: Select.kt */
    @d.c.b.a.f(b = "Select.kt", c = {BDImageUploader.KeyIsImageCountThreshold, 441}, d = "doSelectSuspend", e = "kotlinx.coroutines.selects.SelectImplementation")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f39299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f39300b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i<R> f39301c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f39302d;

        b(i<R> r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39301c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f39300b = r3;
            this.f39302d |= Integer.MIN_VALUE;
            return i.b(this.f39301c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Select.kt */
    @d.c.b.a.f(b = "Select.kt", c = {712}, d = "processResultAndInvokeBlockRecoveringException", e = "kotlinx.coroutines.selects.SelectImplementation")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f39303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i<R> f39304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f39305c;

        c(i<R> r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39304b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f39303a = r3;
            this.f39305c |= Integer.MIN_VALUE;
            return i.a(this.f39304b, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "state$volatile");
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater e() {
        return f;
    }

    public Object a(d.c.d<? super R> r3) {
        return a(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public i(d.c.g r3) {
        this.f39289a = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        this.state$volatile = l.c();
        this.f39290b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(2), List.class, "com.obric.aiagent.plugin");
        this.f39292d = -1;
        this.f39293e = l.d();
    }

    public static final /* synthetic */ Object a(i r0) {
        return r0.f39293e;
    }

    public static final /* synthetic */ Object a(i r2, a r3, Object r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater a() {
        return e();
    }

    public static final /* synthetic */ void a(i r0, Object r1) {
        r0.c(r1);
    }

    public static final /* synthetic */ Object b(i r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean b(i r0) {
        return r0.b();
    }

    public static final /* synthetic */ boolean c(i r0) {
        return r0.d();
    }

    @Override // kotlinx.coroutines.e.j
    public d.c.g getContext() {
        return this.f39289a;
    }

    private final boolean b() {
        Object r1 = e().get(this);
        if (r1 != l.c()) goto L5;
    L8:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, List.class) == true) goto L8;
        return false;
    }

    private final boolean c() {
        return ZeusTransformUtils.instanceOf(e().get(this), a.class);
    }

    private final boolean d() {
        if (e().get(this) != l.e()) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ <R> Object a(i<R> r2, d.c.d<? super R> r3) {
        d.c.d<? super R> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if (r2.c() == false) goto L7;
        return r2.d(r4);
    L7:
        return r2.b(r4);
    }

    private final Object b(d.c.d<? super R> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin");
        if ((r0.f39302d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f39302d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f39300b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f39302d;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        d.o.a(r9);
    L22:
        return r9;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        i<R> this = (i) ZeusTransformUtils.preCheckCast(r0.f39299a, i.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L19:
        r0.f39299a = null;
        r0.f39302d = 2;
        r9 = this.d(r0);
        if (r9 != r2) goto L22;
        return r2;
    L16:
        d.o.a(r9);
        r0.f39299a = this;
        r0.f39302d = 1;
        if (c(r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new b(this, r8);
        goto L8
    }

    @Override // kotlinx.coroutines.e.c
    public void a(e r9, d.h.a.b<? super d.c.d<? super R>, ? extends Object> r10) {
        e r11 = (e) ZeusTransformUtils.wrapperContextForParams(r9, e.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        a(this, new a(this, r11.a(), r11.b(), r11.c(), l.a(), r6, r11.d()), false, 1, null);
    }

    @Override // kotlinx.coroutines.e.c
    public <Q> void a(g<? extends Q> r9, d.h.a.m<? super Q, ? super d.c.d<? super R>, ? extends Object> r10) {
        g r11 = (g) ZeusTransformUtils.wrapperContextForParams(r9, g.class, "com.obric.aiagent.plugin");
        d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.m.class, "com.obric.aiagent.plugin");
        a(this, new a(this, r11.a(), r11.b(), r11.c(), null, r6, r11.d()), false, 1, null);
    }

    public static /* synthetic */ void a(i r0, a r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r2 = false;
    L6:
        r0.a(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    public final void a(i<R>.a r3, boolean r4) {
        if (aq.a() == false) goto L13;
        if (e().get(this) == l.e()) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (ZeusTransformUtils.instanceOf(e().get(this), a.class) == false) goto L15;
        return;
    L15:
        if (r4 == true) goto L18;
        b(r3.f39294a);
    L18:
        if (r3.a(this) == false) goto L22;
        if (r4 == true) goto L21;
        List<i<R>.a> r5 = this.f39290b;
        o.a(r5);
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).add(r3);
    L21:
        r3.f39296c = this.f39291c;
        r3.f39297d = this.f39292d;
        this.f39291c = null;
        this.f39292d = -1;
        return;
    L22:
        e().set(this, r3);
    }

    private final void b(Object r6) {
        List<i<R>.a> r5 = this.f39290b;
        o.a(r5);
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L6;
        if (((a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.aiagent.plugin")).f39294a != r6) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L9;
    L15:
        if (r2 == false) goto L18;
        return;
    L18:
        throw new IllegalStateException(("Cannot use select clauses on the same object: " + r6).toString());
    L13:
        r0 = false;
    L6:
        r2 = true;
        goto L15
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    @Override // kotlinx.coroutines.e.j
    public void a(bf r3) {
        this.f39291c = (bf) ZeusTransformUtils.wrapperContextForParams(r3, bf.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.dk
    public void a(ai<?> r1, int r2) {
        this.f39291c = r1;
        this.f39292d = r2;
    }

    @Override // kotlinx.coroutines.e.j
    public void a(Object r1) {
        this.f39293e = r1;
    }

    private final void c(Object r2) {
        i<R>.a r3 = d(r2);
        o.a(r3);
        r3.f39296c = null;
        r3.f39297d = -1;
        a(r3, true);
    }

    @Override // kotlinx.coroutines.e.j
    public boolean a(Object r1, Object r2) {
        if (c(r1, r2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final m b(Object r1, Object r2) {
        return l.a(c(r1, r2));
    }

    private final int c(Object r7, Object r8) {
    L2:
        Object r0 = e().get(this);
        if (ZeusTransformUtils.instanceOf(r0, n.class) == true) goto L4;
        if (o.a(r0, l.f()) == false) goto L18;
        boolean r1 = true;
    L19:
        if (r1 == true) goto L20;
        if (o.a(r0, l.e()) == true) goto L24;
        if (o.a(r0, l.c()) == true) goto L28;
        if (ZeusTransformUtils.instanceOf(r0, List.class) == false) goto L36;
        if (e().compareAndSet(this, r0, p.a((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"), r7)) == false) goto L2;
        return 1;
    L36:
        throw new IllegalStateException(("Unexpected state: " + r0).toString());
    L28:
        if (e().compareAndSet(this, r0, p.a(r7)) == false) goto L2;
        return 1;
    L24:
        return 2;
    L20:
        return 3;
    L18:
        r1 = ZeusTransformUtils.instanceOf(r0, a.class);
        goto L19
    L4:
        i<R>.a r2 = d(r7);
        if (r2 == null) goto L2;
        d.h.a.b<Throwable, x> r4 = r2.a((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin"), r8);
        if (e().compareAndSet(this, r0, r2) == false) goto L2;
        n r9 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.aiagent.plugin");
        this.f39293e = r8;
        if (l.a(r9, r4) == false) goto L13;
        return 0;
    L13:
        this.f39293e = l.d();
        return 2;
    }

    private final i<R>.a d(Object r5) {
        List<i<R>.a> r4 = this.f39290b;
        Object r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        if (((a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin")).f39294a != r5) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L7;
        r0 = r1;
        goto L14
    L11:
        r3 = false;
    L14:
        i<R>.a r7 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L18;
        return r7;
    L18:
        throw new IllegalStateException(("Clause with object " + r5 + " is not found").toString());
    }

    private final Object d(d.c.d<? super R> r4) {
        d.c.d<? super R> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (aq.a() == true) goto L5;
    L9:
        Object r0 = e().get(this);
        o.a(r0, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        i<R>.a r1 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        Object r2 = this.f39293e;
        a(r1);
        if (aq.c() == true) goto L14;
        return r1.a(r1.a(r2), r5);
    L14:
        return a(r1, r2, r5);
    L5:
        if (c() == true) goto L9;
        throw new AssertionError();
    }

    private final Object a(i<R>.a r5, Object r6, d.c.d<? super R> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r8, c.class, "com.obric.aiagent.plugin");
        if ((r0.f39305c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f39305c -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f39303a;
        Object r9 = d.c.a.b.a();
        int r2 = r0.f39305c;
        if (r2 == 0) goto L17;
        if (r2 != 1) goto L16;
        d.o.a(r4);     // Catch: Throwable -> L13
    L30:
        return r4;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        d.o.a(r4);
        Object r10 = r5.a(r6);     // Catch: Throwable -> L13
        r0.f39305c = 1;     // Catch: Throwable -> L13
        r4 = r5.a(r10, r0);     // Catch: Throwable -> L13
        if (r4 != r9) goto L30;
        return r9;
    L13:
        th = move-exception;
        if (aq.c() == true) goto L25;
        throw th;
    L25:
        if (ZeusTransformUtils.instanceOf(r0, d.c.b.a.e.class) == true) goto L28;
        throw th;
    L28:
        throw ak.a(th, (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r0, d.c.b.a.e.class, "com.obric.aiagent.plugin"));
    L7:
        r0 = new c(this, r8);
        goto L8
    }

    private final void a(i<R>.a r5) {
        if (aq.a() == true) goto L5;
    L9:
        List<i<R>.a> r0 = this.f39290b;
        if (r0 != null) goto L12;
        return;
    L12:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r1.hasNext() == false) goto L18;
        i<R>.a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        if (r2 == r5) goto L14;
        r2.a();
        goto L14
    L18:
        e().set(this, l.f());
        this.f39293e = l.d();
        this.f39290b = null;
        return;
    L5:
        if (o.a(e().get(this), r5) == true) goto L9;
        throw new AssertionError();
    }

    @Override // kotlinx.coroutines.m
    public void a(Throwable r4) {
        AtomicReferenceFieldUpdater r5 = e();
    L3:
        Object r0 = r5.get(this);
        if (r0 == l.f()) goto L5;
        if (r5.compareAndSet(this, r0, l.e()) == false) goto L3;
        List<i<R>.a> r6 = this.f39290b;
        if (r6 != null) goto L11;
        return;
    L11:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        ((a) ZeusTransformUtils.preCheckCast(r7.next(), a.class, "com.obric.aiagent.plugin")).a();
        goto L13
    L15:
        this.f39293e = l.d();
        this.f39290b = null;
        return;
    }

    private final Object c(d.c.d<? super x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(d.c.a.b.a(r9), 1);
        r0.e();
        n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.aiagent.plugin");
        AtomicReferenceFieldUpdater r3 = a();
    L3:
        Object r4 = r3.get(this);
        if (r4 == l.c()) goto L6;
        if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L17;
        if (a().compareAndSet(this, r4, l.c()) == false) goto L3;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r6.hasNext() == false) goto L3;
        a(this, r6.next());
        goto L14
    L17:
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L28;
        r2.a(x.f38692a, ((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin")).a((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin"), a(this)));
    L19:
        Object r7 = r0.h();
        if (r7 != d.c.a.b.a()) goto L23;
        d.c.b.a.h.c(r9);
    L23:
        if (r7 != d.c.a.b.a()) goto L26;
        return r7;
    L26:
        return x.f38692a;
    L28:
        throw new IllegalStateException(("unexpected state: " + r4).toString());
    L6:
        if (a().compareAndSet(this, r4, r2) == false) goto L3;
        kotlinx.coroutines.q.a(r2, (kotlinx.coroutines.m) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.m.class, "com.obric.aiagent.plugin"));
        goto L19
    }
}
