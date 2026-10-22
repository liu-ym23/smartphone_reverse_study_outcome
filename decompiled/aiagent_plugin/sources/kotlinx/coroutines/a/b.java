package kotlinx.coroutines.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ae;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.dk;
import kotlinx.coroutines.internal.ad;
import kotlinx.coroutines.internal.ai;
import kotlinx.coroutines.internal.aj;
import kotlinx.coroutines.internal.ak;
import kotlinx.coroutines.internal.al;
import kotlinx.coroutines.internal.au;

/* JADX INFO: compiled from: BufferedChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
public class b<E> implements kotlinx.coroutines.a.d<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f38776e = null;
    private static final /* synthetic */ AtomicLongFieldUpdater f = null;
    private static final /* synthetic */ AtomicLongFieldUpdater g = null;
    private static final /* synthetic */ AtomicLongFieldUpdater h = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater i = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater j = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater k = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater l = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater m = null;
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.h.a.b<E, x> f38777a;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f38778c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.q<kotlinx.coroutines.e.j<?>, Object, Object, d.h.a.b<Throwable, x>> f38779d;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    /* JADX INFO: compiled from: BufferedChannel.kt */
    private final class a implements kotlinx.coroutines.a.f<E>, dk {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b<E> f38780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f38781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private kotlinx.coroutines.o<? super Boolean> f38782c;

        public a(b r1) {
            this.f38780a = r1;
            this.f38781b = kotlinx.coroutines.a.c.p();
        }

        public static final /* synthetic */ void a(a r0) {
            r0.d();
        }

        public static final /* synthetic */ void a(a r0, Object r1) {
            r0.f38781b = r1;
        }

        public static final /* synthetic */ void a(a r0, kotlinx.coroutines.o r1) {
            r0.f38782c = r1;
        }

        @Override // kotlinx.coroutines.a.f
        public Object a(d.c.d<? super Boolean> r15) {
            d.c.d<? super Boolean> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
            b<E> r16 = this.f38780a;
            i<E> r0 = (i) ZeusTransformUtils.preCheckCast(b.q().get(r16), i.class, "com.obric.aiagent.plugin");
        L4:
            if (r16.m() == true) goto L37;
            long r5 = b.r().getAndIncrement(r16);
            long r1 = r5 / ((long) kotlinx.coroutines.a.c.f38799a);
            int r4 = (int) (r5 % ((long) kotlinx.coroutines.a.c.f38799a));
            if (r0.f39364a == r1) goto L12;
            i<E> r2 = b.b(r16, r1, r0);
            if (r2 == null) goto L4;
            r0 = r2;
        L12:
            Object r3 = b.a(r16, r0, r4, r5, null);
            if (r3 == kotlinx.coroutines.a.c.k()) goto L26;
            if (r3 != kotlinx.coroutines.a.c.j()) goto L20;
            if (r5 >= r16.a()) goto L4;
            r0.f();
            goto L4
        L20:
            if (r3 == kotlinx.coroutines.a.c.l()) goto L22;
            r0.f();
            this.f38781b = r3;
            return d.c.b.a.b.a(true);
        L22:
            return a(r0, r4, r5, r7);
        L26:
            throw new IllegalStateException("unreachable".toString());
        L37:
            return d.c.b.a.b.a(c());
        }

        private final boolean c() {
            this.f38781b = kotlinx.coroutines.a.c.b();
            Throwable r1 = this.f38780a.h();
            if (r1 != null) goto L7;
            return false;
        L7:
            throw ak.a(r1);
        }

        private final Object a(i<E> r18, int r19, long r20, d.c.d<? super Boolean> r22) {
            d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
            b<E> r9 = this.f38780a;
            kotlinx.coroutines.o r10 = kotlinx.coroutines.q.a(d.c.a.b.a(r1));
            a(this, r10);     // Catch: Throwable -> L51
            Object r3 = b.a(r9, r18, r19, r20, (dk) ZeusTransformUtils.preCheckCast(this, dk.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L51
            if (r3 != kotlinx.coroutines.a.c.k()) goto L6;
            b.b(r9, (dk) ZeusTransformUtils.preCheckCast(this, dk.class, "com.obric.aiagent.plugin"), r18, r19);     // Catch: Throwable -> L51
        L47:
            Object r0 = r10.h();
            if (r0 != d.c.a.b.a()) goto L50;
            d.c.b.a.h.c(r1);
        L50:
            return r0;
        L6:
            d.h.a.b<Throwable, x> r12 = null;
            r12 = null;
            dk r13 = null;
            if (r3 == kotlinx.coroutines.a.c.j()) goto L9;
            r18.f();     // Catch: Throwable -> L51
            a(this, r3);     // Catch: Throwable -> L51
            a(this, null);     // Catch: Throwable -> L51
            Boolean r2 = d.c.b.a.b.a(true);     // Catch: Throwable -> L51
            d.h.a.b<E, x> r4 = r9.f38777a;     // Catch: Throwable -> L51
            if (r4 != null) goto L45;
        L40:
            r10.a(r2, r12);     // Catch: Throwable -> L51
            goto L47
        L45:
            r12 = ad.b(r4, r3, r10.getContext());     // Catch: Throwable -> L51
            goto L40
        L9:
            if (r20 >= r9.a()) goto L11;
            r18.f();     // Catch: Throwable -> L51
        L11:
            i r5 = (i) ZeusTransformUtils.preCheckCast(b.q().get(r9), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        L13:
            if (r9.m() == true) goto L14;
            long r14 = b.r().getAndIncrement(r9);     // Catch: Throwable -> L51
            long r6 = r14 / ((long) kotlinx.coroutines.a.c.f38799a);     // Catch: Throwable -> L51
            int r15 = (int) (r14 % ((long) kotlinx.coroutines.a.c.f38799a));     // Catch: Throwable -> L51
            if (r5.f39364a == r6) goto L21;
            i r7 = b.b(r9, r6, r5);     // Catch: Throwable -> L51
            if (r7 == null) goto L13;
            i r8 = r7;
        L22:
            i r11 = r8;
            i r16 = r8;
            Object r17 = b.a(r9, r11, r15, r14, (dk) ZeusTransformUtils.preCheckCast(this, dk.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L51
            if (r17 == kotlinx.coroutines.a.c.k()) goto L25;
            if (r17 != kotlinx.coroutines.a.c.j()) goto L36;
            if (r14 >= r9.a()) goto L34;
            r16.f();     // Catch: Throwable -> L51
        L34:
            r5 = r16;
            goto L13
        L36:
            if (r17 == kotlinx.coroutines.a.c.l()) goto L42;
            r16.f();     // Catch: Throwable -> L51
            a(this, r17);     // Catch: Throwable -> L51
            a(this, null);     // Catch: Throwable -> L51
            r2 = d.c.b.a.b.a(true);     // Catch: Throwable -> L51
            d.h.a.b<E, x> r21 = r9.f38777a;     // Catch: Throwable -> L51
            if (r21 == null) goto L40;
            r12 = ad.b(r21, r17, r10.getContext());     // Catch: Throwable -> L51
            goto L40
        L42:
            throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L51
        L25:
            if (ZeusTransformUtils.instanceOf((dk) ZeusTransformUtils.preCheckCast(this, dk.class, "com.obric.aiagent.plugin"), dk.class) == false) goto L27;
            r13 = (dk) ZeusTransformUtils.preCheckCast(this, dk.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        L27:
            if (r13 == null) goto L47;
            b.b(r9, r13, r16, r15);     // Catch: Throwable -> L51
            goto L47
        L21:
            r8 = r5;
            goto L22
        L14:
            a(this);     // Catch: Throwable -> L51
        L51:
            th = move-exception;
            r10.i();
            throw th;
        }

        @Override // kotlinx.coroutines.dk
        public void a(ai<?> r1, int r2) {
            kotlinx.coroutines.o<? super Boolean> r0 = this.f38782c;
            if (r0 == null) goto L6;
            r0.a(r1, r2);
            return;
        }

        private final void d() {
            kotlinx.coroutines.o<? super Boolean> r0 = this.f38782c;
            d.h.b.o.a(r0);
            this.f38782c = null;
            this.f38781b = kotlinx.coroutines.a.c.b();
            Throwable r5 = this.f38780a.h();
            if (r5 != null) goto L5;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r1 = d.n.f38560a;
            r6.resumeWith(d.n.f(false));
            return;
        L5:
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            if (aq.c() == true) goto L8;
        L11:
            d.n.a r3 = d.n.f38560a;
            r2.resumeWith(d.n.f(d.o.a(r5)));
            return;
        L8:
            if (ZeusTransformUtils.instanceOf((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin"), d.c.b.a.e.class) == false) goto L11;
            r5 = ak.a(r5, (d.c.b.a.e) ZeusTransformUtils.preCheckCast((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin"), d.c.b.a.e.class, "com.obric.aiagent.plugin"));
            goto L11
        }

        @Override // kotlinx.coroutines.a.f
        public E a() {
            E r0 = (E) this.f38781b;
            if (r0 == kotlinx.coroutines.a.c.p()) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L13;
            this.f38781b = kotlinx.coroutines.a.c.p();
            if (r0 == kotlinx.coroutines.a.c.b()) goto L11;
            return r0;
        L11:
            throw ak.a(b.a(this.f38780a));
        L13:
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        L5:
            r1 = false;
            goto L6
        }

        public final boolean a(E r5) {
            kotlinx.coroutines.o<? super Boolean> r0 = this.f38782c;
            d.h.b.o.a(r0);
            d.h.a.b<Throwable, x> r1 = null;
            this.f38782c = null;
            this.f38781b = r5;
            kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            d.h.a.b<E, x> r4 = this.f38780a.f38777a;
            if (r4 == null) goto L6;
            r1 = ad.b(r4, r5, r0.getContext());
        L6:
            return kotlinx.coroutines.a.c.a(r2, true, r1);
        }

        public final void b() {
            kotlinx.coroutines.o<? super Boolean> r0 = this.f38782c;
            d.h.b.o.a(r0);
            this.f38782c = null;
            this.f38781b = kotlinx.coroutines.a.c.b();
            Throwable r5 = this.f38780a.h();
            if (r5 != null) goto L5;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r1 = d.n.f38560a;
            r6.resumeWith(d.n.f(false));
            return;
        L5:
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            if (aq.c() == true) goto L8;
        L11:
            d.n.a r3 = d.n.f38560a;
            r2.resumeWith(d.n.f(d.o.a(r5)));
            return;
        L8:
            if (ZeusTransformUtils.instanceOf((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin"), d.c.b.a.e.class) == false) goto L11;
            r5 = ak.a(r5, (d.c.b.a.e) ZeusTransformUtils.preCheckCast((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin"), d.c.b.a.e.class, "com.obric.aiagent.plugin"));
            goto L11
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BufferedChannel.kt */
    private static final class C1044b implements dk {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlinx.coroutines.n<Boolean> f38783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final /* synthetic */ kotlinx.coroutines.o<Boolean> f38784b;

        @Override // kotlinx.coroutines.dk
        public void a(ai<?> r1, int r2) {
            this.f38784b.a(r1, r2);
        }

        public final kotlinx.coroutines.n<Boolean> a() {
            return this.f38783a;
        }
    }

    /* JADX INFO: compiled from: BufferedChannel.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.q<b<?>, kotlinx.coroutines.e.j<?>, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f38785a = null;

        static {
            f38785a = new c();
        }

        c() {
            super(3, b.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        public final void a(b<?> r2, kotlinx.coroutines.e.j<?> r3, Object r4) {
            b.a(r2, (kotlinx.coroutines.e.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(b<?> r3, kotlinx.coroutines.e.j<?> r4, Object r5) {
            a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"), (kotlinx.coroutines.e.j) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin"), r5);
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: BufferedChannel.kt */
    /* synthetic */ class d extends d.h.b.l implements d.h.a.q<b<?>, Object, Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f38786a = null;

        static {
            f38786a = new d();
        }

        d() {
            super(3, b.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        public final Object a(b<?> r1, Object r2, Object r3) {
            return b.a(r1, r2, r3);
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(b<?> r3, Object r4, Object r5) {
            return a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"), r4, r5);
        }
    }

    /* JADX INFO: compiled from: BufferedChannel.kt */
    static final class e extends d.h.b.p implements d.h.a.q<kotlinx.coroutines.e.j<?>, Object, Object, d.h.a.b<? super Throwable, ? extends x>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b<E> f38787a;

        /* JADX INFO: renamed from: kotlinx.coroutines.a.b$e$1, reason: invalid class name */
        /* JADX INFO: compiled from: BufferedChannel.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.b<Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f38788a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b<E> f38789b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.e.j<?> f38790c;

            AnonymousClass1(Object r3, b<E> r4, kotlinx.coroutines.e.j<?> r5) {
                kotlinx.coroutines.e.j<?> r6 = (kotlinx.coroutines.e.j) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin");
                this.f38788a = r3;
                this.f38789b = r4;
                this.f38790c = r6;
                super(1);
            }

            public final void a(Throwable r2) {
                if (this.f38788a == kotlinx.coroutines.a.c.b()) goto L6;
                ad.a(this.f38789b.f38777a, this.f38788a, this.f38790c.getContext());
                return;
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }
        }

        e(b<E> r1) {
            this.f38787a = r1;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ d.h.a.b<? super Throwable, ? extends x> invoke(kotlinx.coroutines.e.j<?> r3, Object r4, Object r5) {
            return a((kotlinx.coroutines.e.j) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin"), r4, r5);
        }

        public final d.h.a.b<Throwable, x> a(kotlinx.coroutines.e.j<?> r2, Object r3, Object r4) {
            kotlinx.coroutines.e.j r5 = (kotlinx.coroutines.e.j) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin");
            return (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4, this.f38787a, r5), d.h.a.b.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: BufferedChannel.kt */
    @d.c.b.a.f(b = "BufferedChannel.kt", c = {762}, d = "receiveCatching-JP2dKIU$suspendImpl", e = "kotlinx.coroutines.channels.BufferedChannel")
    static final class f<E> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f38791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b<E> f38792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f38793c;

        f(b<E> r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38792b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f38791a = r3;
            this.f38793c |= Integer.MIN_VALUE;
            Object r2 = b.b(this.f38792b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return h.i(r2);
        }
    }

    /* JADX INFO: compiled from: BufferedChannel.kt */
    @d.c.b.a.f(b = "BufferedChannel.kt", c = {3087}, d = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", e = "kotlinx.coroutines.channels.BufferedChannel")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f38794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f38795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f38796c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f38797d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f38798e;
        final /* synthetic */ b<E> f;
        int g;

        g(b<E> r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f38798e = r7;
            this.g |= Integer.MIN_VALUE;
            Object r6 = b.a(this.f, null, 0, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r6 != d.c.a.b.a()) goto L6;
            return r6;
        L6:
            return h.i(r6);
        }
    }

    static {
        f38776e = AtomicLongFieldUpdater.newUpdater(b.class, "sendersAndCloseStatus$volatile");
        f = AtomicLongFieldUpdater.newUpdater(b.class, "receivers$volatile");
        g = AtomicLongFieldUpdater.newUpdater(b.class, "bufferEnd$volatile");
        h = AtomicLongFieldUpdater.newUpdater(b.class, "completedExpandBuffersAndPauseFlag$volatile");
        i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "sendSegment$volatile");
        j = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "receiveSegment$volatile");
        k = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "bufferEndSegment$volatile");
        l = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_closeCause$volatile");
        m = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "closeHandler$volatile");
    }

    private static final /* synthetic */ AtomicLongFieldUpdater C() {
        return f38776e;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater D() {
        return f;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater E() {
        return g;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater F() {
        return h;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater G() {
        return i;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater H() {
        return j;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater I() {
        return k;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater J() {
        return l;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater K() {
        return m;
    }

    @Override // kotlinx.coroutines.a.s
    public Object a(d.c.d<? super E> r3) {
        return a(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.a.t
    public Object a(E r3, d.c.d<? super x> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.a.s
    public Object a_(d.c.d<? super h<? extends E>> r3) {
        return b(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public void c() {
    }

    public void d() {
    }

    public void j() {
    }

    public boolean k() {
        return false;
    }

    public b(int r11, d.h.a.b<? super E, x> r12) {
        d.h.a.b<E, x> r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        this.f38778c = r11;
        this.f38777a = r13;
        if (r11 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        this.bufferEnd$volatile = kotlinx.coroutines.a.c.a(r11);
        this.completedExpandBuffersAndPauseFlag$volatile = s();
        i r14 = new i(0, null, this, 3);
        this.sendSegment$volatile = r14;
        this.receiveSegment$volatile = r14;
        if (t() == false) goto L10;
        r14 = kotlinx.coroutines.a.c.c();
        d.h.b.o.a(r14, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
    L10:
        this.bufferEndSegment$volatile = r14;
        if (r13 == null) goto L13;
        d.h.a.q<kotlinx.coroutines.e.j<?>, Object, Object, d.h.a.b<Throwable, x>> r15 = (d.h.a.q) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.q.class, "com.obric.aiagent.plugin");
    L14:
        this.f38779d = r15;
        this._closeCause$volatile = kotlinx.coroutines.a.c.d();
        return;
    L13:
        r15 = null;
        goto L14
    L17:
        throw new IllegalArgumentException(("Invalid channel capacity: " + r11 + ", should be >=0").toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final /* synthetic */ int a(b r0, i r1, int r2, Object r3, long r4, Object r6, boolean r7) {
        return r0.a(r1, r2, r3, r4, r6, r7);
    }

    public static final /* synthetic */ Object a(b r0, Object r1, Object r2) {
        return r0.b(r1, r2);
    }

    public static final /* synthetic */ Object a(b r6, i r7, int r8, long r9, d.c.d r11) {
        return r6.b(r7, r8, r9, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r0, i r1, int r2, long r3, Object r5) {
        return r0.a(r1, r2, r3, r5);
    }

    public static final /* synthetic */ Throwable a(b r0) {
        return r0.v();
    }

    public static final /* synthetic */ i a(b r0, long r1, i r3) {
        return r0.a(r1, r3);
    }

    public static final /* synthetic */ void a(b r2, Object r3, kotlinx.coroutines.n r4) {
        r2.a(r3, (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(b r2, dk r3, i r4, int r5) {
        r2.a((dk) ZeusTransformUtils.wrapperContextForParams(r3, dk.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public static final /* synthetic */ void a(b r2, kotlinx.coroutines.e.j r3, Object r4) {
        r2.a((kotlinx.coroutines.e.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ void a(b r2, kotlinx.coroutines.n r3) {
        r2.a((kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean a(b r0, long r1) {
        return r0.h(r1);
    }

    public static final /* synthetic */ i b(b r0, long r1, i r3) {
        return r0.b(r1, r3);
    }

    public static final /* synthetic */ void b(b r2, dk r3, i r4, int r5) {
        r2.b((dk) ZeusTransformUtils.wrapperContextForParams(r3, dk.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public static final /* synthetic */ void b(b r2, kotlinx.coroutines.n r3) {
        r2.b((kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater o() {
        return G();
    }

    public static final /* synthetic */ AtomicLongFieldUpdater p() {
        return C();
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater q() {
        return H();
    }

    public static final /* synthetic */ AtomicLongFieldUpdater r() {
        return D();
    }

    public final long a() {
        return C().get(this) & 1152921504606846975L;
    }

    public final long b() {
        return D().get(this);
    }

    private final long s() {
        return E().get(this);
    }

    private final boolean t() {
        long r0 = s();
        if (r0 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r0 == Long.MAX_VALUE) goto L8;
        return false;
    }

    static /* synthetic */ <E> Object a(b<E> r16, E r17, d.c.d<? super x> r18) {
        d.c.d<? super x> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        i<E> r0 = (i) ZeusTransformUtils.preCheckCast(o().get(r16), i.class, "com.obric.aiagent.plugin");
    L3:
        long r1 = p().getAndIncrement(r16);
        long r11 = r1 & 1152921504606846975L;
        boolean r13 = a(r16, r1);
        long r2 = r11 / ((long) kotlinx.coroutines.a.c.f38799a);
        int r14 = (int) (r11 % ((long) kotlinx.coroutines.a.c.f38799a));
        if (r0.f39364a == r2) goto L12;
        i<E> r3 = a(r16, r2, r0);
        if (r3 == null) goto L7;
        i<E> r15 = r3;
    L13:
        int r4 = a(r16, r15, r14, r17, r11, null, r13);
        if (r4 == 0) goto L45;
        if (r4 == 1) goto L47;
        if (r4 == 2) goto L37;
        if (r4 == 3) goto L34;
        if (r4 == 4) goto L29;
        if (r4 != 5) goto L27;
        r15.f();
    L27:
        r0 = r15;
        goto L3
    L29:
        if (r11 >= r16.b()) goto L31;
        r15.f();
    L31:
        Object r5 = r16.b(r17, r10);
        if (r5 != d.c.a.b.a()) goto L47;
        return r5;
    L34:
        Object r6 = r16.a(r15, r14, r17, r11, r10);
        if (r6 != d.c.a.b.a()) goto L47;
        return r6;
    L37:
        if (r13 == false) goto L42;
        r15.l();
        Object r7 = r16.b(r17, r10);
        if (r7 != d.c.a.b.a()) goto L47;
        return r7;
    L42:
        if (aq.a() == false) goto L47;
        throw new AssertionError();
    L47:
        return x.f38692a;
    L45:
        r15.f();
        goto L47
    L7:
        if (r13 == false) goto L3;
        Object r8 = r16.b(r17, r10);
        if (r8 != d.c.a.b.a()) goto L47;
        return r8;
    L12:
        r15 = r0;
        goto L13
    }

    private final void a(dk r2, i<E> r3, int r4) {
        ((dk) ZeusTransformUtils.wrapperContextForParams(r2, dk.class, "com.obric.aiagent.plugin")).a((ai) ZeusTransformUtils.preCheckCast(r3, ai.class, "com.obric.aiagent.plugin"), r4 + kotlinx.coroutines.a.c.f38799a);
    }

    private final void a(E r4, kotlinx.coroutines.n<? super x> r5) {
        kotlinx.coroutines.n r6 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        d.h.a.b<E, x> r0 = this.f38777a;
        if (r0 == null) goto L5;
        ad.a(r0, r4, r6.getContext());
    L5:
        d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Throwable r3 = i();
        if (aq.c() == true) goto L8;
    L11:
        d.n.a r8 = d.n.f38560a;
        r7.resumeWith(d.n.f(d.o.a(r3)));
        return;
    L8:
        if (ZeusTransformUtils.instanceOf((d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin"), d.c.b.a.e.class) == false) goto L11;
        r3 = ak.a(r3, (d.c.b.a.e) ZeusTransformUtils.preCheckCast((d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin"), d.c.b.a.e.class, "com.obric.aiagent.plugin"));
        goto L11
    }

    @Override // kotlinx.coroutines.a.t
    public Object a_(E r17) {
        if (c(C().get(this)) == true) goto L5;
        al r9 = kotlinx.coroutines.a.c.e();
        i r0 = (i) ZeusTransformUtils.preCheckCast(o().get(this), i.class, "com.obric.aiagent.plugin");
    L7:
        long r1 = p().getAndIncrement(this);
        long r11 = r1 & 1152921504606846975L;
        boolean r13 = a(this, r1);
        long r2 = r11 / ((long) kotlinx.coroutines.a.c.f38799a);
        int r14 = (int) (r11 % ((long) kotlinx.coroutines.a.c.f38799a));
        if (r0.f39364a == r2) goto L14;
        i r3 = a(this, r2, r0);
        if (r3 == null) goto L11;
        i r15 = r3;
    L15:
        int r4 = a(this, r15, r14, r17, r11, r9, r13);
        if (r4 == 0) goto L45;
        if (r4 == 1) goto L47;
        if (r4 == 2) goto L35;
        if (r4 == 3) goto L34;
        if (r4 == 4) goto L31;
        if (r4 != 5) goto L29;
        r15.f();
    L29:
        r0 = r15;
        goto L7
    L31:
        if (r11 >= b()) goto L60;
        r15.f();
    L60:
        return h.f38809a.a(i());
    L34:
        throw new IllegalStateException("unexpected".toString());
    L35:
        if (r13 == false) goto L39;
        r15.l();
        goto L60
    L39:
        if (ZeusTransformUtils.instanceOf(r9, dk.class) == false) goto L41;
        dk r5 = (dk) ZeusTransformUtils.preCheckCast(r9, dk.class, "com.obric.aiagent.plugin");
    L42:
        if (r5 == null) goto L44;
        a(this, r5, r15, r14);
    L44:
        r15.l();
        return h.f38809a.a();
    L41:
        r5 = null;
    L47:
        return h.f38809a.a(x.f38692a);
    L45:
        r15.f();
        goto L47
    L11:
        if (r13 == false) goto L7;
    L14:
        r15 = r0;
        goto L15
    L5:
        return h.f38809a.a();
    }

    public final Object b(E r17) {
        al r9 = kotlinx.coroutines.a.c.f38800b;
        i r0 = (i) ZeusTransformUtils.preCheckCast(o().get(this), i.class, "com.obric.aiagent.plugin");
    L3:
        long r1 = p().getAndIncrement(this);
        long r11 = r1 & 1152921504606846975L;
        boolean r13 = a(this, r1);
        long r2 = r11 / ((long) kotlinx.coroutines.a.c.f38799a);
        int r14 = (int) (r11 % ((long) kotlinx.coroutines.a.c.f38799a));
        if (r0.f39364a == r2) goto L11;
        i r3 = a(this, r2, r0);
        if (r3 == null) goto L7;
        i r15 = r3;
    L12:
        int r4 = a(this, r15, r14, r17, r11, r9, r13);
        if (r4 == 0) goto L47;
        if (r4 == 1) goto L46;
        if (r4 == 2) goto L34;
        if (r4 == 3) goto L33;
        if (r4 == 4) goto L28;
        if (r4 != 5) goto L26;
        r15.f();
    L26:
        r0 = r15;
        goto L3
    L28:
        if (r11 >= b()) goto L31;
        r15.f();
    L31:
        return h.f38809a.a(i());
    L33:
        throw new IllegalStateException("unexpected".toString());
    L34:
        if (r13 == false) goto L38;
        r15.l();
        return h.f38809a.a(i());
    L38:
        if (ZeusTransformUtils.instanceOf(r9, dk.class) == false) goto L40;
        dk r5 = (dk) ZeusTransformUtils.preCheckCast(r9, dk.class, "com.obric.aiagent.plugin");
    L41:
        if (r5 == null) goto L43;
        a(this, r5, r15, r14);
    L43:
        a((r15.f39364a * ((long) kotlinx.coroutines.a.c.f38799a)) + ((long) r14));
        return h.f38809a.a(x.f38692a);
    L40:
        r5 = null;
        goto L41
    L46:
        return h.f38809a.a(x.f38692a);
    L47:
        r15.f();
        return h.f38809a.a(x.f38692a);
    L7:
        if (r13 == false) goto L3;
        return h.f38809a.a(i());
    L11:
        r15 = r0;
        goto L12
    }

    private final int a(i<E> r4, int r5, E r6, long r7, Object r9, boolean r10) {
        r4.a(r5, r6);
        if (r10 == true) goto L5;
        Object r0 = r4.d(r5);
        if (r0 != null) goto L21;
        if (d(r7) == true) goto L11;
        if (r9 != null) goto L17;
        return 3;
    L17:
        if (r4.a(r5, null, r9) == false) goto L31;
        return 2;
    L31:
        return b(r4, r5, r6, r7, r9, r10);
    L11:
        if (r4.a(r5, null, kotlinx.coroutines.a.c.f38800b) == false) goto L31;
        return 1;
    L21:
        if (ZeusTransformUtils.instanceOf(r0, dk.class) == false) goto L31;
        r4.c(r5);
        if (a(r0, r6) == false) goto L26;
        r4.b(r5, kotlinx.coroutines.a.c.f());
        d();
        return 0;
    L26:
        if (r4.c(r5, kotlinx.coroutines.a.c.g()) == kotlinx.coroutines.a.c.g()) goto L28;
        r4.a(r5, true);
    L28:
        return 5;
    L5:
        return b(r4, r5, r6, r7, r9, r10);
    }

    private final int b(i<E> r6, int r7, E r8, long r9, Object r11, boolean r12) {
    L2:
        Object r0 = r6.d(r7);
        if (r0 == null) goto L5;
        if (r0 != kotlinx.coroutines.a.c.h()) goto L28;
        if (r6.a(r7, r0, kotlinx.coroutines.a.c.f38800b) == false) goto L2;
        return 1;
    L28:
        if (r0 != kotlinx.coroutines.a.c.g()) goto L32;
        r6.c(r7);
        return 5;
    L32:
        if (r0 != kotlinx.coroutines.a.c.i()) goto L36;
        r6.c(r7);
        return 5;
    L36:
        if (r0 != kotlinx.coroutines.a.c.b()) goto L40;
        r6.c(r7);
        A();
        return 4;
    L40:
        if (aq.a() == true) goto L42;
    L52:
        r6.c(r7);
        if (ZeusTransformUtils.instanceOf(r0, u.class) == false) goto L56;
        r0 = ((u) ZeusTransformUtils.preCheckCast(r0, u.class, "com.obric.aiagent.plugin")).f38823a;
    L56:
        if (a(r0, r8) == false) goto L59;
        r6.b(r7, kotlinx.coroutines.a.c.f());
        d();
        return 0;
    L59:
        if (r6.c(r7, kotlinx.coroutines.a.c.g()) == kotlinx.coroutines.a.c.g()) goto L62;
        r6.a(r7, true);
    L62:
        return 5;
    L42:
        if (ZeusTransformUtils.instanceOf(r0, dk.class) == false) goto L44;
    L47:
        boolean r10 = true;
    L48:
        if (r10 == true) goto L52;
        throw new AssertionError();
    L44:
        if (ZeusTransformUtils.instanceOf(r0, u.class) == true) goto L47;
        r10 = false;
        goto L48
    L5:
        if (d(r9) == false) goto L10;
        if (r12 == true) goto L10;
        if (r6.a(r7, null, kotlinx.coroutines.a.c.f38800b) == false) goto L2;
        return 1;
    L10:
        if (r12 == true) goto L12;
        if (r11 == null) goto L16;
        if (r6.a(r7, null, r11) == false) goto L2;
        return 2;
    L16:
        return 3;
    L12:
        if (r6.a(r7, null, kotlinx.coroutines.a.c.e()) == false) goto L2;
        r6.a(r7, false);
        return 4;
    }

    private final boolean c(long r3) {
        if (h(r3) == false) goto L7;
        return false;
    L7:
        return !d(r3 & 1152921504606846975L);
    }

    private final boolean d(long r5) {
        if (r5 >= s()) goto L5;
    L8:
        return true;
    L5:
        if (r5 < (b() + ((long) this.f38778c))) goto L8;
        return false;
    }

    private final boolean a(Object r5, E r6) {
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.e.j.class) == true) goto L23;
        d.h.a.b<Throwable, x> r2 = null;
        if (ZeusTransformUtils.instanceOf(r5, r.class) == false) goto L12;
        d.h.b.o.a(r5, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
        r r0 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.n r1 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(((r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin")).f38822a, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        h r3 = h.i(h.f38809a.a(r6));
        d.h.a.b<E, x> r4 = this.f38777a;
        if (r4 == null) goto L24;
        r2 = ad.b(r4, r6, ((r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin")).f38822a.getContext());
    L24:
        return kotlinx.coroutines.a.c.a(r1, r3, r2);
    L12:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == false) goto L15;
        d.h.b.o.a(r5, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        a r7 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        return ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).a(r6);
    L15:
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.n.class) == false) goto L22;
        d.h.b.o.a(r5, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        kotlinx.coroutines.n r8 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.n r9 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        d.h.a.b<E, x> r10 = this.f38777a;
        if (r10 == null) goto L20;
        r2 = ad.b(r10, r6, ((kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin")).getContext());
    L20:
        return kotlinx.coroutines.a.c.a(r9, r6, r2);
    L22:
        throw new IllegalStateException(("Unexpected receiver type: " + r5).toString());
    L23:
        return ((kotlinx.coroutines.e.j) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin")).a(this, r6);
    }

    static /* synthetic */ <E> Object a(b<E> r11, d.c.d<? super E> r12) {
        d.c.d<? super E> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        i<E> r13 = (i) ZeusTransformUtils.preCheckCast(q().get(r11), i.class, "com.obric.aiagent.plugin");
    L4:
        if (r11.m() == true) goto L27;
        long r8 = r().getAndIncrement(r11);
        long r0 = r8 / ((long) kotlinx.coroutines.a.c.f38799a);
        int r10 = (int) (r8 % ((long) kotlinx.coroutines.a.c.f38799a));
        if (r13.f39364a == r0) goto L11;
        i<E> r1 = b(r11, r0, r13);
        if (r1 == null) goto L4;
        r13 = r1;
    L11:
        Object r2 = a(r11, r13, r10, r8, null);
        if (r2 == kotlinx.coroutines.a.c.k()) goto L25;
        if (r2 != kotlinx.coroutines.a.c.j()) goto L19;
        if (r8 >= r11.a()) goto L4;
        r13.f();
        goto L4
    L19:
        if (r2 == kotlinx.coroutines.a.c.l()) goto L21;
        r13.f();
        return r2;
    L21:
        return r11.a(r13, r10, r8, r7);
    L25:
        throw new IllegalStateException("unexpected".toString());
    L27:
        throw ak.a(r11.v());
    }

    private final void b(dk r3, i<E> r4, int r5) {
        dk r6 = (dk) ZeusTransformUtils.wrapperContextForParams(r3, dk.class, "com.obric.aiagent.plugin");
        c();
        r6.a((ai) ZeusTransformUtils.preCheckCast(r4, ai.class, "com.obric.aiagent.plugin"), r5);
    }

    private final void a(kotlinx.coroutines.n<? super E> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast((kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin"), d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;
        r4.resumeWith(d.n.f(d.o.a(v())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ <E> Object b(b<E> r14, d.c.d<? super h<? extends E>> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r16, f.class, "com.obric.aiagent.plugin");
        if ((r0.f38793c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f38793c -= Integer.MIN_VALUE;
    L8:
        f r7 = r0;
        Object r17 = r7.f38791a;
        Object r1 = d.c.a.b.a();
        int r2 = r7.f38793c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r17);
        return ((h) ZeusTransformUtils.preCheckCast(r17, h.class, "com.obric.aiagent.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r17);
        i<E> r3 = (i) ZeusTransformUtils.preCheckCast(q().get(r14), i.class, "com.obric.aiagent.plugin");
    L16:
        if (r14.m() == true) goto L51;
        long r5 = r().getAndIncrement(r14);
        long r8 = r5 / ((long) kotlinx.coroutines.a.c.f38799a);
        int r4 = (int) (r5 % ((long) kotlinx.coroutines.a.c.f38799a));
        if (r3.f39364a == r8) goto L24;
        i<E> r6 = b(r14, r8, r3);
        if (r6 == null) goto L16;
        r3 = r6;
    L24:
        Object r9 = a(r14, r3, r4, r5, null);
        if (r9 == kotlinx.coroutines.a.c.k()) goto L39;
        if (r9 != kotlinx.coroutines.a.c.j()) goto L32;
        if (r5 >= r14.a()) goto L16;
        r3.f();
        goto L16
    L32:
        if (r9 != kotlinx.coroutines.a.c.l()) goto L36;
        r7.f38793c = 1;
        Object r18 = r14.b(r3, r4, r5, r7);
        if (r18 != r1) goto L52;
        return r1;
    L52:
        return r18;
    L36:
        r3.f();
        return h.f38809a.a(r9);
    L39:
        throw new IllegalStateException("unexpected".toString());
    L51:
        return h.f38809a.a(r14.h());
    L7:
        r0 = new f(r14, r16);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object b(i<E> r18, int r19, long r20, d.c.d<? super h<? extends E>> r22) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, g.class) == false) goto L7;
        g r2 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.aiagent.plugin");
        if ((r2.g & Integer.MIN_VALUE) == 0) goto L7;
        r2.g -= Integer.MIN_VALUE;
    L8:
        g r12 = r2;
        Object r3 = r12.f38798e;
        Object r13 = d.c.a.b.a();
        int r4 = r12.g;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r5 = r12.f38797d;
        int r0 = r12.f38796c;
        i r6 = (i) ZeusTransformUtils.preCheckCast(r12.f38795b, i.class, "com.obric.aiagent.plugin");
        b r7 = (b) ZeusTransformUtils.preCheckCast(r12.f38794a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L68:
        return ((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        r12.f38794a = this;
        r12.f38795b = r18;
        r12.f38796c = r19;
        r12.f38797d = r20;
        r12.g = 1;
        kotlinx.coroutines.o r14 = kotlinx.coroutines.q.a(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin")));
        d.h.b.o.a(r14, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>");     // Catch: Throwable -> L69
        r r15 = new r(r14);     // Catch: Throwable -> L69
        Object r8 = a(this, r18, r19, r20, (dk) ZeusTransformUtils.preCheckCast(r15, dk.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L69
        if (r8 != kotlinx.coroutines.a.c.k()) goto L19;
        b(this, (dk) ZeusTransformUtils.preCheckCast(r15, dk.class, "com.obric.aiagent.plugin"), r18, r19);     // Catch: Throwable -> L69
    L62:
        r3 = r14.h();
        if (r3 != d.c.a.b.a()) goto L65;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin"));
    L65:
        if (r3 != r13) goto L68;
        return r13;
    L19:
        if (r8 == kotlinx.coroutines.a.c.j()) goto L21;
        r18.f();     // Catch: Throwable -> L69
        h r9 = h.i(h.f38809a.a(r8));     // Catch: Throwable -> L69
        d.h.a.b<E, x> r10 = this.f38777a;     // Catch: Throwable -> L69
        if (r10 == null) goto L61;
        d.h.a.b<Throwable, x> r11 = ad.b(r10, r8, r14.getContext());     // Catch: Throwable -> L69
    L54:
        r14.a(r9, r11);     // Catch: Throwable -> L69
        goto L62
    L61:
        r11 = null;
        goto L54
    L21:
        if (r20 >= a()) goto L23;
        r18.f();     // Catch: Throwable -> L69
    L23:
        i r16 = (i) ZeusTransformUtils.preCheckCast(q().get(this), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L69
    L25:
        if (m() == true) goto L26;
        long r17 = r().getAndIncrement(this);     // Catch: Throwable -> L69
        long r21 = r17 / ((long) kotlinx.coroutines.a.c.f38799a);     // Catch: Throwable -> L69
        int r23 = (int) (r17 % ((long) kotlinx.coroutines.a.c.f38799a));     // Catch: Throwable -> L69
        if (r16.f39364a == r21) goto L33;
        i r24 = b(this, r21, r16);     // Catch: Throwable -> L69
        if (r24 == null) goto L25;
        i r25 = r24;
    L34:
        i r26 = r25;
        Object r27 = a(this, r25, r23, r17, (dk) ZeusTransformUtils.preCheckCast(r15, dk.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L69
        if (r27 == kotlinx.coroutines.a.c.k()) goto L37;
        if (r27 != kotlinx.coroutines.a.c.j()) goto L49;
        if (r17 >= a()) goto L47;
        r26.f();     // Catch: Throwable -> L69
    L47:
        r16 = r26;
        goto L25
    L49:
        if (r27 == kotlinx.coroutines.a.c.l()) goto L56;
        r26.f();     // Catch: Throwable -> L69
        r9 = h.i(h.f38809a.a(r27));     // Catch: Throwable -> L69
        d.h.a.b<E, x> r28 = this.f38777a;     // Catch: Throwable -> L69
        if (r28 == null) goto L53;
        r11 = ad.b(r28, r27, r14.getContext());     // Catch: Throwable -> L69
        goto L54
    L53:
        r11 = null;
        goto L54
    L56:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L69
    L37:
        if (ZeusTransformUtils.instanceOf((dk) ZeusTransformUtils.preCheckCast(r15, dk.class, "com.obric.aiagent.plugin"), dk.class) == false) goto L39;
        dk r29 = (dk) ZeusTransformUtils.preCheckCast(r15, dk.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L69
    L40:
        if (r29 == null) goto L62;
        b(this, r29, r26, r23);     // Catch: Throwable -> L69
        goto L62
    L39:
        r29 = null;
        goto L40
    L33:
        r25 = r16;
        goto L34
    L26:
        b(this, (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r14, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        r14.i();
        throw th;
    L7:
        r2 = new g(this, r1);
        goto L8
    }

    private final void b(kotlinx.coroutines.n<? super h<? extends E>> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast((kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin"), d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;
        r4.resumeWith(d.n.f(h.i(h.f38809a.a(h()))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.a.s
    public Object r_() {
        long r0 = D().get(this);
        long r2 = C().get(this);
        if (i(r2) == false) goto L7;
        return h.f38809a.a(h());
    L7:
        if (r0 >= (r2 & 1152921504606846975L)) goto L9;
        al r6 = kotlinx.coroutines.a.c.g();
        i r1 = (i) ZeusTransformUtils.preCheckCast(q().get(this), i.class, "com.obric.aiagent.plugin");
    L12:
        if (m() == true) goto L50;
        long r8 = r().getAndIncrement(this);
        long r3 = r8 / ((long) kotlinx.coroutines.a.c.f38799a);
        int r10 = (int) (r8 % ((long) kotlinx.coroutines.a.c.f38799a));
        if (r1.f39364a == r3) goto L20;
        i r4 = b(this, r3, r1);
        if (r4 == null) goto L12;
        i r11 = r4;
    L21:
        Object r5 = a(this, r11, r10, r8, r6);
        if (r5 == kotlinx.coroutines.a.c.k()) goto L24;
        if (r5 != kotlinx.coroutines.a.c.j()) goto L37;
        if (r8 >= a()) goto L35;
        r11.f();
    L35:
        r1 = r11;
        goto L12
    L37:
        if (r5 == kotlinx.coroutines.a.c.l()) goto L41;
        r11.f();
        return h.f38809a.a(r5);
    L41:
        throw new IllegalStateException("unexpected".toString());
    L24:
        if (ZeusTransformUtils.instanceOf(r6, dk.class) == false) goto L26;
        dk r7 = (dk) ZeusTransformUtils.preCheckCast(r6, dk.class, "com.obric.aiagent.plugin");
    L27:
        if (r7 == null) goto L29;
        b(this, r7, r11, r10);
    L29:
        b(r8);
        r11.l();
        return h.f38809a.a();
    L26:
        r7 = null;
        goto L27
    L20:
        r11 = r1;
        goto L21
    L50:
        return h.f38809a.a(h());
    L9:
        return h.f38809a.a();
    }

    public final void a(long r11) {
        if (aq.a() == true) goto L5;
    L9:
        i<E> r0 = (i) ZeusTransformUtils.preCheckCast(H().get(this), i.class, "com.obric.aiagent.plugin");
    L10:
        long r8 = D().get(this);
        if (r11 < Math.max(((long) this.f38778c) + r8, s())) goto L12;
        if (D().compareAndSet(this, r8, r8 + 1) == false) goto L10;
        long r1 = r8 / ((long) kotlinx.coroutines.a.c.f38799a);
        int r4 = (int) (r8 % ((long) kotlinx.coroutines.a.c.f38799a));
        if (r0.f39364a == r1) goto L21;
        i<E> r2 = b(r1, r0);
        if (r2 == null) goto L10;
        r0 = r2;
    L21:
        Object r3 = a(r0, r4, r8, null);
        if (r3 == kotlinx.coroutines.a.c.j()) goto L24;
        r0.f();
        d.h.a.b<E, x> r5 = this.f38777a;
        if (r5 == null) goto L10;
        au r6 = ad.a(r5, r3, null, 2, null);
        if (r6 == null) goto L10;
        throw r6;
    L24:
        if (r8 >= a()) goto L10;
        r0.f();
        goto L10
    L12:
        return;
    L5:
        if (k() == true) goto L9;
        throw new AssertionError();
    }

    private final Object a(i<E> r6, int r7, long r8, Object r10) {
        Object r0 = r6.d(r7);
        if (r0 != null) goto L14;
        if (r8 < (C().get(this) & 1152921504606846975L)) goto L20;
        if (r10 != null) goto L10;
        return kotlinx.coroutines.a.c.l();
    L10:
        if (r6.a(r7, r0, r10) == false) goto L20;
        u();
        return kotlinx.coroutines.a.c.k();
    L20:
        return b(r6, r7, r8, r10);
    L14:
        if (r0 != kotlinx.coroutines.a.c.f38800b) goto L20;
        if (r6.a(r7, r0, kotlinx.coroutines.a.c.f()) == false) goto L20;
        u();
        return r6.b(r7);
    }

    private final Object b(i<E> r6, int r7, long r8, Object r10) {
    L2:
        Object r0 = r6.d(r7);
        if (r0 == null) goto L41;
        if (r0 == kotlinx.coroutines.a.c.h()) goto L41;
        if (r0 == kotlinx.coroutines.a.c.f38800b) goto L10;
        if (r0 == kotlinx.coroutines.a.c.e()) goto L16;
        if (r0 == kotlinx.coroutines.a.c.i()) goto L20;
        if (r0 == kotlinx.coroutines.a.c.b()) goto L23;
        if (r0 == kotlinx.coroutines.a.c.m()) goto L2;
        if (r6.a(r7, r0, kotlinx.coroutines.a.c.n()) == false) goto L2;
        boolean r9 = ZeusTransformUtils.instanceOf(r0, u.class);
        if (ZeusTransformUtils.instanceOf(r0, u.class) == false) goto L33;
        r0 = ((u) ZeusTransformUtils.preCheckCast(r0, u.class, "com.obric.aiagent.plugin")).f38823a;
    L33:
        if (a(r0, r6, r7) == false) goto L35;
        r6.b(r7, kotlinx.coroutines.a.c.f());
        u();
        return r6.b(r7);
    L35:
        r6.b(r7, kotlinx.coroutines.a.c.e());
        r6.a(r7, false);
        if (r9 == false) goto L39;
        u();
    L39:
        return kotlinx.coroutines.a.c.j();
    L23:
        u();
        return kotlinx.coroutines.a.c.j();
    L20:
        return kotlinx.coroutines.a.c.j();
    L16:
        return kotlinx.coroutines.a.c.j();
    L10:
        if (r6.a(r7, r0, kotlinx.coroutines.a.c.f()) == false) goto L2;
        u();
        return r6.b(r7);
    L41:
        if (r8 < (C().get(this) & 1152921504606846975L)) goto L43;
        if (r10 == null) goto L48;
        if (r6.a(r7, r0, r10) == false) goto L2;
        u();
        return kotlinx.coroutines.a.c.k();
    L48:
        return kotlinx.coroutines.a.c.l();
    L43:
        if (r6.a(r7, r0, kotlinx.coroutines.a.c.i()) == false) goto L2;
        u();
        return kotlinx.coroutines.a.c.j();
    }

    private final boolean a(Object r6, i<E> r7, int r8) {
        if (ZeusTransformUtils.instanceOf(r6, kotlinx.coroutines.n.class) == false) goto L6;
        d.h.b.o.a(r6, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        kotlinx.coroutines.n r5 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.a.c.a((kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin"), x.f38692a, null, 2, null);
    L6:
        if (ZeusTransformUtils.instanceOf(r6, kotlinx.coroutines.e.j.class) == false) goto L15;
        d.h.b.o.a(r6, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        kotlinx.coroutines.e.i r0 = (kotlinx.coroutines.e.i) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.e.i.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.e.m r9 = ((kotlinx.coroutines.e.i) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.e.i.class, "com.obric.aiagent.plugin")).b(this, x.f38692a);
        if (r9 != kotlinx.coroutines.e.m.f39313b) goto L11;
        r7.c(r8);
    L11:
        if (r9 == kotlinx.coroutines.e.m.f39312a) goto L22;
        return false;
    L22:
        return true;
    L15:
        if (ZeusTransformUtils.instanceOf(r6, C1044b.class) == false) goto L19;
        return kotlinx.coroutines.a.c.a(((C1044b) ZeusTransformUtils.preCheckCast(r6, C1044b.class, "com.obric.aiagent.plugin")).a(), true, null, 2, null);
    L19:
        throw new IllegalStateException(("Unexpected waiter: " + r6).toString());
    }

    private final void u() {
        if (t() == false) goto L5;
        return;
    L5:
        i<E> r0 = (i) ZeusTransformUtils.preCheckCast(I().get(this), i.class, "com.obric.aiagent.plugin");
    L6:
        long r7 = E().getAndIncrement(this);
        long r2 = r7 / ((long) kotlinx.coroutines.a.c.f38799a);
        if (a() <= r7) goto L9;
        if (r0.f39364a == r2) goto L22;
        i<E> r1 = a(r2, r0, r7);
        if (r1 == null) goto L6;
        r0 = r1;
    L22:
        if (a(r0, (int) (r7 % ((long) kotlinx.coroutines.a.c.f38799a)), r7) == true) goto L23;
        a(this, 0, 1, null);
        goto L6
    L23:
        a(this, 0, 1, null);
        return;
    L9:
        if (r0.f39364a < r2) goto L11;
    L13:
        a(this, 0, 1, null);
        return;
    L11:
        if (r0.c() == 0) goto L13;
        c(r2, r0);
        goto L13
    }

    private final boolean a(i<E> r4, int r5, long r6) {
        Object r0 = r4.d(r5);
        if (ZeusTransformUtils.instanceOf(r0, dk.class) == false) goto L14;
        if (r6 < D().get(this)) goto L14;
        if (r4.a(r5, r0, kotlinx.coroutines.a.c.m()) == false) goto L14;
        if (a(r0, r4, r5) == false) goto L11;
        r4.b(r5, kotlinx.coroutines.a.c.f38800b);
        return true;
    L11:
        r4.b(r5, kotlinx.coroutines.a.c.e());
        r4.a(r5, false);
        return false;
    L14:
        return b(r4, r5, r6);
    }

    private final boolean b(i<E> r7, int r8, long r9) {
    L2:
        Object r0 = r7.d(r8);
        if (ZeusTransformUtils.instanceOf(r0, dk.class) == true) goto L5;
        if (r0 == kotlinx.coroutines.a.c.e()) goto L18;
        if (r0 == null) goto L21;
        if (r0 == kotlinx.coroutines.a.c.f38800b) goto L25;
        if (r0 == kotlinx.coroutines.a.c.i()) goto L41;
        if (r0 == kotlinx.coroutines.a.c.f()) goto L41;
        if (r0 == kotlinx.coroutines.a.c.g()) goto L41;
        if (r0 == kotlinx.coroutines.a.c.b()) goto L35;
        if (r0 == kotlinx.coroutines.a.c.n()) goto L2;
        throw new IllegalStateException(("Unexpected cell state: " + r0).toString());
    L35:
        return true;
    L41:
        return true;
    L25:
        return true;
    L21:
        if (r7.a(r8, r0, kotlinx.coroutines.a.c.h()) == false) goto L2;
        return true;
    L18:
        return false;
    L5:
        if (r9 < D().get(this)) goto L7;
        if (r7.a(r8, r0, kotlinx.coroutines.a.c.m()) == false) goto L2;
        if (a(r0, r7, r8) == false) goto L14;
        r7.b(r8, kotlinx.coroutines.a.c.f38800b);
        return true;
    L14:
        r7.b(r8, kotlinx.coroutines.a.c.e());
        r7.a(r8, false);
        return false;
    L7:
        if (r7.a(r8, r0, new u((dk) ZeusTransformUtils.preCheckCast(r0, dk.class, "com.obric.aiagent.plugin"))) == false) goto L2;
        return true;
    }

    static /* synthetic */ void a(b r0, long r1, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = 1;
    L6:
        r0.e(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void e(long r8) {
        if ((F().addAndGet(this, r8) & 4611686018427387904L) == 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == true) goto L8;
        return;
    L8:
        if ((F().get(this) & 4611686018427387904L) == 0) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == true) goto L8;
        return;
    L10:
        r10 = false;
        goto L11
    L5:
        r9 = false;
        goto L6
    }

    public final void b(long r17) {
        if (t() == false) goto L6;
        return;
    L6:
        if (s() <= r17) goto L6;
        int r0 = kotlinx.coroutines.a.c.o();
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L16;
        long r2 = s();
        if (r2 != (F().get(this) & 4611686018427387903L)) goto L15;
        if (r2 != s()) goto L15;
        return;
    L15:
        r1 = r1 + 1;
        goto L9
    L16:
        AtomicLongFieldUpdater r10 = F();
    L17:
        long r3 = r10.get(this);
        if (r10.compareAndSet(this, r3, kotlinx.coroutines.a.c.a(r3 & 4611686018427387903L, true)) == false) goto L17;
    L19:
        long r4 = s();
        long r5 = F().get(this);
        long r6 = r5 & 4611686018427387903L;
        if ((4611686018427387904L & r5) == 0) goto L22;
        boolean r11 = true;
    L24:
        if (r4 == r6) goto L26;
    L31:
        if (r11 == true) goto L19;
        F().compareAndSet(this, r5, kotlinx.coroutines.a.c.a(r6, true));
        goto L19
    L26:
        if (r4 != s()) goto L31;
        AtomicLongFieldUpdater r12 = F();
    L28:
        long r7 = r12.get(this);
        if (r12.compareAndSet(this, r7, kotlinx.coroutines.a.c.a(r7 & 4611686018427387903L, false)) == false) goto L28;
        return;
    L22:
        r11 = false;
        goto L24
    }

    @Override // kotlinx.coroutines.a.s
    public kotlinx.coroutines.e.g<E> f() {
        c r1 = c.f38785a;
        d.h.b.o.a(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        d.h.a.q r2 = (d.h.a.q) ZeusTransformUtils.preCheckCast(ae.b(r1, 3), d.h.a.q.class, "com.obric.aiagent.plugin");
        d r3 = d.f38786a;
        d.h.b.o.a(r3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return (kotlinx.coroutines.e.g) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.e.h(this, r2, (d.h.a.q) ZeusTransformUtils.preCheckCast(ae.b(r3, 3), d.h.a.q.class, "com.obric.aiagent.plugin"), this.f38779d), kotlinx.coroutines.e.g.class, "com.obric.aiagent.plugin");
    }

    private final void a(kotlinx.coroutines.e.j<?> r2) {
        ((kotlinx.coroutines.e.j) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin")).a(kotlinx.coroutines.a.c.b());
    }

    private final Object b(Object r1, Object r2) {
        if (r2 == kotlinx.coroutines.a.c.b()) goto L6;
        return r2;
    L6:
        throw v();
    }

    @Override // kotlinx.coroutines.a.s
    public kotlinx.coroutines.a.f<E> g() {
        return (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(new a(this), kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
    }

    public final Throwable h() {
        return (Throwable) ZeusTransformUtils.preCheckCast(J().get(this), Throwable.class, "com.obric.aiagent.plugin");
    }

    public final Throwable i() {
        Throwable r2 = h();
        if (r2 == null) goto L5;
        return r2;
    L5:
        return (Throwable) ZeusTransformUtils.preCheckCast(new m("Channel was closed"), Throwable.class, "com.obric.aiagent.plugin");
    }

    private final Throwable v() {
        Throwable r2 = h();
        if (r2 == null) goto L5;
        return r2;
    L5:
        return (Throwable) ZeusTransformUtils.preCheckCast(new l("Channel was closed"), Throwable.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.a.t
    public boolean a(Throwable r2) {
        return a(r2, false);
    }

    @Override // kotlinx.coroutines.a.s
    public final void a(CancellationException r3) {
        b((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public boolean b(Throwable r3) {
        if (r3 != null) goto L5;
        r3 = (Throwable) ZeusTransformUtils.preCheckCast(new CancellationException("Channel was cancelled"), Throwable.class, "com.obric.aiagent.plugin");
    L5:
        return a(r3, true);
    }

    public boolean a(Throwable r3, boolean r4) {
        if (r4 == false) goto L4;
        z();
    L4:
        boolean r5 = J().compareAndSet(this, kotlinx.coroutines.a.c.d(), r3);
        if (r4 == false) goto L7;
        y();
    L8:
        A();
        j();
        if (r5 == false) goto L11;
        w();
    L11:
        return r5;
    L7:
        x();
        goto L8
    }

    private final void w() {
        AtomicReferenceFieldUpdater r0 = K();
    L3:
        Object r1 = r0.get(this);
        if (r1 != null) goto L6;
        al r2 = kotlinx.coroutines.a.c.q();
    L8:
        if (r0.compareAndSet(this, r1, r2) == false) goto L3;
        if (r1 != null) goto L11;
        return;
    L11:
        d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.preCheckCast(ae.b(r1, 1), d.h.a.b.class, "com.obric.aiagent.plugin");
        ((d.h.a.b) ZeusTransformUtils.preCheckCast(r1, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(h());
        return;
    L6:
        r2 = kotlinx.coroutines.a.c.r();
        goto L8
    }

    @Override // kotlinx.coroutines.a.t
    public void a(d.h.a.b<? super Throwable, x> r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (K().compareAndSet(this, null, r6) == false) goto L5;
        return;
    L5:
        AtomicReferenceFieldUpdater r0 = K();
    L6:
        Object r1 = r0.get(this);
        if (r1 != kotlinx.coroutines.a.c.q()) goto L13;
        if (K().compareAndSet(this, kotlinx.coroutines.a.c.q(), kotlinx.coroutines.a.c.r()) == false) goto L6;
        r6.invoke(h());
        return;
    L13:
        if (r1 != kotlinx.coroutines.a.c.r()) goto L17;
        throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
    L17:
        throw new IllegalStateException(("Another handler is already registered: " + r1).toString());
    }

    private final void x() {
        AtomicLongFieldUpdater r6 = C();
    L3:
        long r2 = r6.get(this);
        int r0 = (int) (r2 >> 60);
        if (r0 != 0) goto L6;
        long r1 = kotlinx.coroutines.a.c.a(r2 & 1152921504606846975L, 2);
    L11:
        if (r6.compareAndSet(this, r2, r1) == false) goto L3;
        return;
    L6:
        if (r0 != 1) goto L7;
        r1 = kotlinx.coroutines.a.c.a(r2 & 1152921504606846975L, 3);
        goto L11
    }

    private final void y() {
        AtomicLongFieldUpdater r6 = C();
    L3:
        long r2 = r6.get(this);
        if (r6.compareAndSet(this, r2, kotlinx.coroutines.a.c.a(1152921504606846975L & r2, 3)) == false) goto L3;
    }

    private final void z() {
        AtomicLongFieldUpdater r6 = C();
    L3:
        long r2 = r6.get(this);
        if (((int) (r2 >> 60)) != 0) goto L7;
        if (r6.compareAndSet(this, r2, kotlinx.coroutines.a.c.a(1152921504606846975L & r2, 1)) == false) goto L3;
        return;
    }

    private final void A() {
        l();
    }

    private final i<E> f(long r6) {
        i<E> r0 = B();
        if (k() == false) goto L7;
        long r1 = a(r0);
        if (r1 == (-1)) goto L7;
        a(r1);
    L7:
        a(r0, r6);
        return r0;
    }

    private final void g(long r1) {
        b(f(r1));
    }

    private final i<E> B() {
        Object r0 = I().get(this);
        i r1 = (i) ZeusTransformUtils.preCheckCast(G().get(this), i.class, "com.obric.aiagent.plugin");
        if (r1.f39364a <= ((i) ZeusTransformUtils.preCheckCast(r0, i.class, "com.obric.aiagent.plugin")).f39364a) goto L5;
        r0 = r1;
    L5:
        i r8 = (i) ZeusTransformUtils.preCheckCast(H().get(this), i.class, "com.obric.aiagent.plugin");
        if (r8.f39364a <= ((i) ZeusTransformUtils.preCheckCast(r0, i.class, "com.obric.aiagent.plugin")).f39364a) goto L9;
        r0 = r8;
    L9:
        return (i) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.internal.e.a((kotlinx.coroutines.internal.f) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.f.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin");
    }

    private final long a(i<E> r8) {
    L2:
        int r0 = kotlinx.coroutines.a.c.f38799a;
    L3:
        r0 = r0 - 1;
        if ((-1) >= r0) goto L20;
        long r3 = (r8.f39364a * ((long) kotlinx.coroutines.a.c.f38799a)) + ((long) r0);
        if (r3 < b()) goto L7;
    L8:
        Object r1 = r8.d(r0);
        if (r1 == null) goto L17;
        if (r1 == kotlinx.coroutines.a.c.h()) goto L17;
        if (r1 != kotlinx.coroutines.a.c.f38800b) goto L3;
        return r3;
    L17:
        if (r8.a(r0, r1, kotlinx.coroutines.a.c.b()) == false) goto L8;
        r8.l();
        goto L3
    L7:
        return -1;
    L20:
        r8 = (i) ZeusTransformUtils.preCheckCast(r8.e(), i.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L2;
        return -1;
    }

    private final void b(i<E> r13) {
        d.h.a.b<E, x> r0 = this.f38777a;
        au r1 = null;
        Object r3 = kotlinx.coroutines.internal.s.a(null, 1, null);
    L3:
        int r4 = kotlinx.coroutines.a.c.f38799a - 1;
    L5:
        if ((-1) >= r4) goto L50;
        long r7 = (r13.f39364a * ((long) kotlinx.coroutines.a.c.f38799a)) + ((long) r4);
    L7:
        Object r9 = r13.d(r4);
        if (r9 == kotlinx.coroutines.a.c.f()) goto L52;
        if (r9 == kotlinx.coroutines.a.c.f38800b) goto L12;
        if (r9 == kotlinx.coroutines.a.c.h()) goto L47;
        if (r9 == null) goto L47;
        if (ZeusTransformUtils.instanceOf(r9, dk.class) == true) goto L36;
        if (ZeusTransformUtils.instanceOf(r9, u.class) == true) goto L36;
        if (r9 == kotlinx.coroutines.a.c.m()) goto L52;
        if (r9 == kotlinx.coroutines.a.c.n()) goto L52;
        if (r9 == kotlinx.coroutines.a.c.m()) goto L7;
    L49:
        r4 = r4 - 1;
    L36:
        if (r7 < b()) goto L52;
        if (ZeusTransformUtils.instanceOf(r9, u.class) == false) goto L40;
        dk r10 = ((u) ZeusTransformUtils.preCheckCast(r9, u.class, "com.obric.aiagent.plugin")).f38823a;
    L42:
        if (r13.a(r4, r9, kotlinx.coroutines.a.c.b()) == false) goto L7;
        if (r0 == null) goto L45;
        r1 = ad.a(r0, r13.a(r4), r1);
    L45:
        r3 = kotlinx.coroutines.internal.s.a(r3, r10);
        r13.c(r4);
        r13.l();
        goto L49
    L40:
        r10 = (dk) ZeusTransformUtils.preCheckCast(r9, dk.class, "com.obric.aiagent.plugin");
    L47:
        if (r13.a(r4, r9, kotlinx.coroutines.a.c.b()) == false) goto L7;
        r13.l();
        goto L49
    L12:
        if (r7 < b()) goto L52;
        if (r13.a(r4, r9, kotlinx.coroutines.a.c.b()) == false) goto L7;
        if (r0 == null) goto L17;
        r1 = ad.a(r0, r13.a(r4), r1);
    L17:
        r13.c(r4);
        r13.l();
    L52:
        if (r3 != null) goto L54;
    L59:
        if (r1 != null) goto L61;
        return;
    L61:
        throw r1;
    L54:
        if (ZeusTransformUtils.instanceOf(r3, ArrayList.class) == true) goto L56;
        b((dk) ZeusTransformUtils.preCheckCast(r3, dk.class, "com.obric.aiagent.plugin"));
        goto L59
    L56:
        d.h.b.o.a(r3, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r14 = (ArrayList) ZeusTransformUtils.preCheckCast(r3, ArrayList.class, "com.obric.aiagent.plugin");
        int r2 = r14.size() - 1;
    L57:
        if ((-1) >= r2) goto L59;
        b((dk) ZeusTransformUtils.preCheckCast(r14.get(r2), dk.class, "com.obric.aiagent.plugin"));
        r2 = r2 - 1;
        goto L57
    L50:
        r13 = (i) ZeusTransformUtils.preCheckCast(r13.e(), i.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L3;
        goto L52
    }

    private final void a(i<E> r10, long r11) {
        Object r0 = kotlinx.coroutines.internal.s.a(null, 1, null);
    L4:
        if (r10 == null) goto L29;
        int r4 = kotlinx.coroutines.a.c.f38799a - 1;
    L6:
        if ((-1) >= r4) goto L28;
        if (((r10.f39364a * ((long) kotlinx.coroutines.a.c.f38799a)) + ((long) r4)) < r11) goto L29;
    L9:
        Object r5 = r10.d(r4);
        if (r5 == null) goto L25;
        if (r5 == kotlinx.coroutines.a.c.h()) goto L25;
        if (ZeusTransformUtils.instanceOf(r5, u.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r5, dk.class) == false) goto L27;
        if (r10.a(r4, r5, kotlinx.coroutines.a.c.b()) == false) goto L9;
        r0 = kotlinx.coroutines.internal.s.a(r0, r5);
        r10.a(r4, true);
    L27:
        r4 = r4 - 1;
        goto L6
    L17:
        if (r10.a(r4, r5, kotlinx.coroutines.a.c.b()) == false) goto L9;
        r0 = kotlinx.coroutines.internal.s.a(r0, ((u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin")).f38823a);
        r10.a(r4, true);
    L25:
        if (r10.a(r4, r5, kotlinx.coroutines.a.c.b()) == false) goto L9;
        r10.l();
        goto L27
    L28:
        r10 = (i) ZeusTransformUtils.preCheckCast(r10.e(), i.class, "com.obric.aiagent.plugin");
    L29:
        if (r0 != null) goto L31;
        return;
    L31:
        if (ZeusTransformUtils.instanceOf(r0, ArrayList.class) == true) goto L33;
        a((dk) ZeusTransformUtils.preCheckCast(r0, dk.class, "com.obric.aiagent.plugin"));
        return;
    L33:
        d.h.b.o.a(r0, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r12 = (ArrayList) ZeusTransformUtils.preCheckCast(r0, ArrayList.class, "com.obric.aiagent.plugin");
        int r13 = r12.size() - 1;
    L34:
        if ((-1) >= r13) goto L58;
        a((dk) ZeusTransformUtils.preCheckCast(r12.get(r13), dk.class, "com.obric.aiagent.plugin"));
        r13 = r13 - 1;
        goto L34
    }

    private final void a(dk r3) {
        a((dk) ZeusTransformUtils.wrapperContextForParams(r3, dk.class, "com.obric.aiagent.plugin"), true);
    }

    private final void b(dk r3) {
        a((dk) ZeusTransformUtils.wrapperContextForParams(r3, dk.class, "com.obric.aiagent.plugin"), false);
    }

    private final void a(dk r3, boolean r4) {
        dk r5 = (dk) ZeusTransformUtils.wrapperContextForParams(r3, dk.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, C1044b.class) == false) goto L6;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(((C1044b) ZeusTransformUtils.preCheckCast(r5, C1044b.class, "com.obric.aiagent.plugin")).a(), d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r6 = d.n.f38560a;
        r2.resumeWith(d.n.f(false));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.n.class) == false) goto L13;
        d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;
        if (r4 == false) goto L10;
        Throwable r8 = v();
    L11:
        r7.resumeWith(d.n.f(d.o.a(r8)));
        return;
    L10:
        r8 = i();
        goto L11
    L13:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == false) goto L16;
        d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(((r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin")).f38822a, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r10 = d.n.f38560a;
        r9.resumeWith(d.n.f(h.i(h.f38809a.a(h()))));
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == false) goto L19;
        ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).b();
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.e.j.class) == false) goto L23;
        ((kotlinx.coroutines.e.j) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin")).a(this, kotlinx.coroutines.a.c.b());
        return;
    L23:
        throw new IllegalStateException(("Unexpected waiter: " + r5).toString());
    }

    @Override // kotlinx.coroutines.a.t
    public boolean l() {
        return h(C().get(this));
    }

    private final boolean h(long r2) {
        return a(r2, false);
    }

    public boolean m() {
        return i(C().get(this));
    }

    private final boolean i(long r2) {
        return a(r2, true);
    }

    private final boolean a(long r7, boolean r9) {
        int r0 = (int) (r7 >> 60);
        if (r0 == 0) goto L18;
        if (r0 != 1) goto L6;
        return false;
    L6:
        if (r0 != 2) goto L8;
        f(r7 & 1152921504606846975L);
        if (r9 == true) goto L16;
    L20:
        return true;
    L16:
        if (n() == false) goto L20;
        return false;
    L8:
        if (r0 != 3) goto L12;
        g(r7 & 1152921504606846975L);
        goto L20
    L12:
        throw new IllegalStateException(("unexpected close status: " + r0).toString());
    L18:
        return false;
    }

    public final boolean n() {
    L2:
        i<E> r0 = (i) ZeusTransformUtils.preCheckCast(H().get(this), i.class, "com.obric.aiagent.plugin");
        long r5 = b();
        if (a() <= r5) goto L4;
        long r7 = r5 / ((long) kotlinx.coroutines.a.c.f38799a);
        if (r0.f39364a == r7) goto L12;
        r0 = b(r7, r0);
        if (r0 != null) goto L12;
        if (((i) ZeusTransformUtils.preCheckCast(H().get(this), i.class, "com.obric.aiagent.plugin")).f39364a >= r7) goto L2;
        return false;
    L12:
        r0.f();
        if (c(r0, (int) (r5 % ((long) kotlinx.coroutines.a.c.f38799a)), r5) == true) goto L14;
        D().compareAndSet(this, r5, r5 + 1);
        goto L2
    L14:
        return true;
    L4:
        return false;
    }

    private final boolean c(i<E> r4, int r5, long r6) {
    L2:
        Object r0 = r4.d(r5);
        if (r0 == null) goto L33;
        if (r0 == kotlinx.coroutines.a.c.h()) goto L33;
        if (r0 != kotlinx.coroutines.a.c.f38800b) goto L11;
        return true;
    L11:
        if (r0 != kotlinx.coroutines.a.c.e()) goto L14;
        return false;
    L14:
        if (r0 != kotlinx.coroutines.a.c.b()) goto L17;
        return false;
    L17:
        if (r0 != kotlinx.coroutines.a.c.f()) goto L20;
        return false;
    L20:
        if (r0 != kotlinx.coroutines.a.c.i()) goto L23;
        return false;
    L23:
        if (r0 != kotlinx.coroutines.a.c.m()) goto L26;
        return true;
    L26:
        if (r0 != kotlinx.coroutines.a.c.n()) goto L29;
        return false;
    L29:
        if (r6 == b()) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (r4.a(r5, r0, kotlinx.coroutines.a.c.i()) == false) goto L2;
        u();
        return false;
    }

    private final i<E> a(long r13, i<E> r15) {
        AtomicReferenceFieldUpdater r0 = G();
        d.h.a.m r1 = (d.h.a.m) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.a.c.a(), d.h.a.m.class, "com.obric.aiagent.plugin");
    L3:
        Object r2 = kotlinx.coroutines.internal.e.a((ai) ZeusTransformUtils.preCheckCast(r15, ai.class, "com.obric.aiagent.plugin"), r13, r1);
        boolean r5 = false;
        if (aj.a(r2) == true) goto L23;
        ai r4 = aj.b(r2);
    L6:
        ai r7 = (ai) ZeusTransformUtils.preCheckCast(r0.get(this), ai.class, "com.obric.aiagent.plugin");
        if (r7.f39364a >= r4.f39364a) goto L8;
        if (r4.j() == false) goto L11;
        if (r0.compareAndSet(this, r7, r4) == true) goto L15;
        if (r4.k() == false) goto L6;
        r4.i();
        goto L6
    L15:
        if (r7.k() == false) goto L8;
        r7.i();
        goto L8
    L11:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L3;
    L8:
        r6 = true;
    L23:
        if (aj.a(r2) == false) goto L27;
        A();
        if ((r15.f39364a * ((long) kotlinx.coroutines.a.c.f38799a)) >= b()) goto L55;
        r15.f();
        return null;
    L55:
        return null;
    L27:
        i<E> r16 = (i) ZeusTransformUtils.preCheckCast(aj.b(r2), i.class, "com.obric.aiagent.plugin");
        if (r16.f39364a <= r13) goto L33;
        j(r16.f39364a * ((long) kotlinx.coroutines.a.c.f38799a));
        if ((r16.f39364a * ((long) kotlinx.coroutines.a.c.f38799a)) >= b()) goto L57;
        r16.f();
        return null;
    L57:
        return null;
    L33:
        if (aq.a() == false) goto L42;
        if (r16.f39364a != r13) goto L37;
        r5 = true;
    L37:
        if (r5 == true) goto L42;
        throw new AssertionError();
    L42:
        return r16;
    }

    private final i<E> b(long r13, i<E> r15) {
        AtomicReferenceFieldUpdater r0 = H();
        d.h.a.m r1 = (d.h.a.m) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.a.c.a(), d.h.a.m.class, "com.obric.aiagent.plugin");
    L3:
        Object r2 = kotlinx.coroutines.internal.e.a((ai) ZeusTransformUtils.preCheckCast(r15, ai.class, "com.obric.aiagent.plugin"), r13, r1);
        boolean r5 = false;
        if (aj.a(r2) == true) goto L23;
        ai r4 = aj.b(r2);
    L6:
        ai r7 = (ai) ZeusTransformUtils.preCheckCast(r0.get(this), ai.class, "com.obric.aiagent.plugin");
        if (r7.f39364a >= r4.f39364a) goto L8;
        if (r4.j() == false) goto L11;
        if (r0.compareAndSet(this, r7, r4) == true) goto L15;
        if (r4.k() == false) goto L6;
        r4.i();
        goto L6
    L15:
        if (r7.k() == false) goto L8;
        r7.i();
        goto L8
    L11:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L3;
    L8:
        r6 = true;
    L23:
        if (aj.a(r2) == false) goto L27;
        A();
        if ((r15.f39364a * ((long) kotlinx.coroutines.a.c.f38799a)) >= a()) goto L79;
        r15.f();
        return null;
    L79:
        return null;
    L27:
        i<E> r16 = (i) ZeusTransformUtils.preCheckCast(aj.b(r2), i.class, "com.obric.aiagent.plugin");
        if (t() == true) goto L45;
        if (r13 > (s() / ((long) kotlinx.coroutines.a.c.f38799a))) goto L45;
        AtomicReferenceFieldUpdater r3 = I();
    L32:
        ai r8 = (ai) ZeusTransformUtils.preCheckCast(r3.get(this), ai.class, "com.obric.aiagent.plugin");
        if (r8.f39364a >= ((ai) ZeusTransformUtils.preCheckCast(r16, ai.class, "com.obric.aiagent.plugin")).f39364a) goto L45;
        if (((ai) ZeusTransformUtils.preCheckCast(r16, ai.class, "com.obric.aiagent.plugin")).j() == false) goto L45;
        if (r3.compareAndSet(this, r8, (ai) ZeusTransformUtils.preCheckCast(r16, ai.class, "com.obric.aiagent.plugin")) == true) goto L39;
        if (((ai) ZeusTransformUtils.preCheckCast(r16, ai.class, "com.obric.aiagent.plugin")).k() == false) goto L32;
        ((ai) ZeusTransformUtils.preCheckCast(r16, ai.class, "com.obric.aiagent.plugin")).i();
        goto L32
    L39:
        if (r8.k() == false) goto L45;
        r8.i();
    L45:
        if (r16.f39364a <= r13) goto L50;
        k(r16.f39364a * ((long) kotlinx.coroutines.a.c.f38799a));
        if ((r16.f39364a * ((long) kotlinx.coroutines.a.c.f38799a)) >= a()) goto L81;
        r16.f();
        return null;
    L81:
        return null;
    L50:
        if (aq.a() == false) goto L59;
        if (r16.f39364a != r13) goto L54;
        r5 = true;
    L54:
        if (r5 == true) goto L59;
        throw new AssertionError();
    L59:
        return r16;
    }

    private final i<E> a(long r17, i<E> r19, long r20) {
        AtomicReferenceFieldUpdater r2 = I();
        d.h.a.m r3 = (d.h.a.m) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.a.c.a(), d.h.a.m.class, "com.obric.aiagent.plugin");
    L3:
        Object r4 = kotlinx.coroutines.internal.e.a((ai) ZeusTransformUtils.preCheckCast(r19, ai.class, "com.obric.aiagent.plugin"), r17, r3);
        boolean r9 = false;
        if (aj.a(r4) == true) goto L23;
        ai r8 = aj.b(r4);
    L6:
        ai r11 = (ai) ZeusTransformUtils.preCheckCast(r2.get(this), ai.class, "com.obric.aiagent.plugin");
        if (r11.f39364a >= r8.f39364a) goto L8;
        if (r8.j() == false) goto L11;
        if (r2.compareAndSet(this, r11, r8) == true) goto L15;
        if (r8.k() == false) goto L6;
        r8.i();
        goto L6
    L15:
        if (r11.k() == false) goto L8;
        r11.i();
        goto L8
    L11:
        boolean r10 = false;
    L17:
        if (r10 == false) goto L3;
    L8:
        r10 = true;
    L23:
        if (aj.a(r4) == false) goto L25;
        A();
        c(r17, r19);
        a(this, 0, 1, null);
        return null;
    L25:
        i<E> r7 = (i) ZeusTransformUtils.preCheckCast(aj.b(r4), i.class, "com.obric.aiagent.plugin");
        if (r7.f39364a <= r17) goto L32;
        if (E().compareAndSet(this, r20 + 1, r7.f39364a * ((long) kotlinx.coroutines.a.c.f38799a)) == false) goto L30;
        e((r7.f39364a * ((long) kotlinx.coroutines.a.c.f38799a)) - r20);
        return null;
    L30:
        a(this, 0, 1, null);
        return null;
    L32:
        if (aq.a() == false) goto L41;
        if (r7.f39364a != r17) goto L36;
        r9 = true;
    L36:
        if (r9 == true) goto L41;
        throw new AssertionError();
    L41:
        return r7;
    }

    private final void c(long r7, i<E> r9) {
    L3:
        if (r9.f39364a >= r7) goto L9;
        i<E> r0 = (i) ZeusTransformUtils.preCheckCast(r9.c(), i.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        r9 = r0;
    L9:
        if (r9.h() == false) goto L14;
        i<E> r8 = (i) ZeusTransformUtils.preCheckCast(r9.c(), i.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L14;
        r9 = r8;
    L14:
        AtomicReferenceFieldUpdater r10 = I();
    L15:
        ai r11 = (ai) ZeusTransformUtils.preCheckCast(r10.get(this), ai.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        if (r11.f39364a >= ((ai) ZeusTransformUtils.preCheckCast(r9, ai.class, "com.obric.aiagent.plugin")).f39364a) goto L26;
        if (((ai) ZeusTransformUtils.preCheckCast(r9, ai.class, "com.obric.aiagent.plugin")).j() == false) goto L20;
        if (r10.compareAndSet(this, r11, (ai) ZeusTransformUtils.preCheckCast(r9, ai.class, "com.obric.aiagent.plugin")) == true) goto L24;
        if (((ai) ZeusTransformUtils.preCheckCast(r9, ai.class, "com.obric.aiagent.plugin")).k() == false) goto L15;
        ((ai) ZeusTransformUtils.preCheckCast(r9, ai.class, "com.obric.aiagent.plugin")).i();
        goto L15
    L24:
        if (r11.k() == false) goto L26;
        r11.i();
        goto L26
    L20:
        r2 = false;
    L26:
        if (r2 == false) goto L9;
    }

    private final void j(long r8) {
        AtomicLongFieldUpdater r0 = C();
    L3:
        long r3 = r0.get(this);
        long r1 = 1152921504606846975L & r3;
        if (r1 >= r8) goto L5;
        long r5 = kotlinx.coroutines.a.c.a(r1, (int) (r3 >> 60));
        if (C().compareAndSet(this, r3, r5) == false) goto L3;
        return;
    }

    private final void k(long r8) {
        AtomicLongFieldUpdater r0 = D();
    L3:
        long r3 = r0.get(this);
        if (r3 >= r8) goto L5;
        if (D().compareAndSet(this, r3, r8) == false) goto L3;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        StringBuilder r1 = new StringBuilder();
        int r2 = (int) (C().get(this) >> 60);
        if (r2 == 2) goto L7;
        if (r2 != 3) goto L8;
        r1.append("cancelled,");
    L8:
        r1.append("capacity=" + this.f38778c + ',');
        r1.append("data=[");
        int r6 = 0;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new i[]{H().get(this), G().get(this), I().get(this)}), Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L17;
        Object r8 = r5.next();
        if (((i) ZeusTransformUtils.preCheckCast(r8, i.class, "com.obric.aiagent.plugin")) == kotlinx.coroutines.a.c.c()) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == false) goto L10;
        r4.add(r8);
        goto L10
    L14:
        r9 = false;
        goto L15
    L17:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r7.hasNext() == false) goto L103;
        Object r10 = r7.next();
        if (r7.hasNext() == false) goto L28;
        long r11 = ((i) ZeusTransformUtils.preCheckCast(r10, i.class, "com.obric.aiagent.plugin")).f39364a;
    L23:
        Object r12 = r7.next();
        long r13 = ((i) ZeusTransformUtils.preCheckCast(r12, i.class, "com.obric.aiagent.plugin")).f39364a;
        if (r11 <= r13) goto L27;
        r10 = r12;
        r11 = r13;
    L27:
        if (r7.hasNext() == true) goto L23;
    L28:
        i r14 = (i) ZeusTransformUtils.preCheckCast(r10, i.class, "com.obric.aiagent.plugin");
        long r15 = b();
        long r16 = a();
    L29:
        int r0 = kotlinx.coroutines.a.c.f38799a;
        int r17 = r6;
    L30:
        if (r17 >= r0) goto L94;
        long r18 = (r14.f39364a * ((long) kotlinx.coroutines.a.c.f38799a)) + ((long) r17);
        if (r18 >= r16) goto L34;
    L35:
        Object r19 = r14.d(r17);
        Object r20 = r14.a(r17);
        if (ZeusTransformUtils.instanceOf(r19, kotlinx.coroutines.n.class) == false) goto L46;
        if (r18 >= r15) goto L41;
        if (r18 < r16) goto L41;
        String r21 = "receive";
    L90:
        if (r20 == null) goto L92;
        r1.append('(' + r21 + ',' + r20 + "),");
    L93:
        r17 = r17 + 1;
        goto L30
    L92:
        r1.append(r21 + ',');
    L41:
        if (r18 >= r16) goto L44;
        if (r18 < r15) goto L44;
        r21 = "send";
    L44:
        r21 = "cont";
        goto L90
    L46:
        if (ZeusTransformUtils.instanceOf(r19, kotlinx.coroutines.e.j.class) == false) goto L56;
        if (r18 >= r15) goto L51;
        if (r18 < r16) goto L51;
        r21 = "onReceive";
    L51:
        if (r18 >= r16) goto L54;
        if (r18 < r15) goto L54;
        r21 = "onSend";
    L54:
        r21 = "select";
        goto L90
    L56:
        if (ZeusTransformUtils.instanceOf(r19, r.class) == false) goto L59;
        r21 = "receiveCatching";
        goto L90
    L59:
        if (ZeusTransformUtils.instanceOf(r19, C1044b.class) == false) goto L62;
        r21 = "sendBroadcast";
        goto L90
    L62:
        if (ZeusTransformUtils.instanceOf(r19, u.class) == false) goto L65;
        r21 = "EB(" + r19 + ')';
        goto L90
    L65:
        if (d.h.b.o.a(r19, kotlinx.coroutines.a.c.n()) == false) goto L67;
        boolean r22 = true;
    L68:
        if (r22 == false) goto L70;
        r21 = "resuming_sender";
        goto L90
    L70:
        if (r19 != null) goto L72;
        boolean r23 = true;
    L73:
        if (r23 == false) goto L75;
        boolean r24 = true;
    L76:
        if (r24 == false) goto L78;
        boolean r25 = true;
    L79:
        if (r25 == false) goto L81;
        boolean r26 = true;
    L82:
        if (r26 == false) goto L84;
        boolean r27 = true;
    L85:
        if (r27 == false) goto L87;
        boolean r28 = true;
    L88:
        if (r28 == true) goto L93;
        r21 = r19.toString();
        goto L90
    L87:
        r28 = d.h.b.o.a(r19, kotlinx.coroutines.a.c.b());
        goto L88
    L84:
        r27 = d.h.b.o.a(r19, kotlinx.coroutines.a.c.e());
        goto L85
    L81:
        r26 = d.h.b.o.a(r19, kotlinx.coroutines.a.c.g());
        goto L82
    L78:
        r25 = d.h.b.o.a(r19, kotlinx.coroutines.a.c.i());
        goto L79
    L75:
        r24 = d.h.b.o.a(r19, kotlinx.coroutines.a.c.f());
        goto L76
    L72:
        r23 = d.h.b.o.a(r19, kotlinx.coroutines.a.c.h());
        goto L73
    L67:
        r22 = d.h.b.o.a(r19, kotlinx.coroutines.a.c.m());
        goto L68
    L34:
        if (r18 < r15) goto L35;
    L97:
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) != ',') goto L99;
        d.h.b.o.c(r1.deleteCharAt(r1.length() - 1), "deleteCharAt(...)");
    L99:
        r1.append("]");
        return r1.toString();
    L94:
        r14 = (i) ZeusTransformUtils.preCheckCast(r14.c(), i.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L97;
        r6 = 0;
        goto L29
    L103:
        throw new NoSuchElementException();
    L7:
        r1.append("closed,");
        goto L8
    }

    private final Object b(E r7, d.c.d<? super x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(d.c.a.b.a(r9), 1);
        r0.e();
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        d.h.a.b<E, x> r3 = this.f38777a;
        if (r3 == null) goto L14;
        au r10 = ad.a(r3, r7, null, 2, null);
        if (r10 == null) goto L14;
        d.a.a((Throwable) ZeusTransformUtils.preCheckCast(r10, Throwable.class, "com.obric.aiagent.plugin"), i());
        d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r4 = d.n.f38560a;
        if (aq.c() == true) goto L9;
    L12:
        Throwable r11 = (Throwable) ZeusTransformUtils.preCheckCast(r10, Throwable.class, "com.obric.aiagent.plugin");
    L13:
        r6.resumeWith(d.n.f(d.o.a(r11)));
    L21:
        Object r12 = r0.h();
        if (r12 != d.c.a.b.a()) goto L25;
        d.c.b.a.h.c(r9);
    L25:
        if (r12 != d.c.a.b.a()) goto L28;
        return r12;
    L28:
        return x.f38692a;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, d.c.b.a.e.class) == false) goto L12;
        r11 = ak.a((Throwable) ZeusTransformUtils.preCheckCast(r10, Throwable.class, "com.obric.aiagent.plugin"), (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r6, d.c.b.a.e.class, "com.obric.aiagent.plugin"));
    L14:
        d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
        Throwable r14 = i();
        d.n.a r5 = d.n.f38560a;
        if (aq.c() == true) goto L17;
    L20:
        r13.resumeWith(d.n.f(d.o.a(r14)));
        goto L21
    L17:
        if (ZeusTransformUtils.instanceOf(r13, d.c.b.a.e.class) == false) goto L20;
        r14 = ak.a(r14, (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r13, d.c.b.a.e.class, "com.obric.aiagent.plugin"));
        goto L20
    }

    private final Object a(i<E> r23, int r24, E r25, long r26, d.c.d<? super x> r28) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r12 = kotlinx.coroutines.q.a(d.c.a.b.a(r11));
        int r1 = a(this, r23, r24, r25, r26, (dk) ZeusTransformUtils.preCheckCast(r12, dk.class, "com.obric.aiagent.plugin"), false);     // Catch: Throwable -> L70
        if (r1 != 0) goto L6;
        r23.f();     // Catch: Throwable -> L70
        d.c.d r0 = (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L70
        Object r3 = d.n.f(x.f38692a);     // Catch: Throwable -> L70
    L50:
        r0.resumeWith(r3);     // Catch: Throwable -> L70
    L62:
        Object r4 = r12.h();
        if (r4 != d.c.a.b.a()) goto L66;
        d.c.b.a.h.c(r11);
    L66:
        if (r4 != d.c.a.b.a()) goto L69;
        return r4;
    L69:
        return x.f38692a;
    L6:
        if (r1 != 1) goto L8;
        r0 = (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L70
        r3 = d.n.f(x.f38692a);     // Catch: Throwable -> L70
        goto L50
    L8:
        if (r1 != 2) goto L10;
        a(this, (dk) ZeusTransformUtils.preCheckCast(r12, dk.class, "com.obric.aiagent.plugin"), r23, r24);     // Catch: Throwable -> L70
        goto L62
    L10:
        if (r1 == 4) goto L55;
        if (r1 != 5) goto L53;
        r23.f();     // Catch: Throwable -> L70
        i r6 = (i) ZeusTransformUtils.preCheckCast(o().get(this), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
    L14:
        long r7 = p().getAndIncrement(this);     // Catch: Throwable -> L70
        long r17 = r7 & 1152921504606846975L;     // Catch: Throwable -> L70
        boolean r19 = a(this, r7);     // Catch: Throwable -> L70
        long r8 = r17 / ((long) kotlinx.coroutines.a.c.f38799a);     // Catch: Throwable -> L70
        int r9 = (int) (r17 % ((long) kotlinx.coroutines.a.c.f38799a));     // Catch: Throwable -> L70
        if (r6.f39364a == r8) goto L22;
        i r10 = a(this, r8, r6);     // Catch: Throwable -> L70
        if (r10 == null) goto L18;
        i r13 = r10;
    L23:
        i r14 = r13;
        i r27 = r13;
        int r15 = a(this, r14, r9, r25, r17, (dk) ZeusTransformUtils.preCheckCast(r12, dk.class, "com.obric.aiagent.plugin"), r19);     // Catch: Throwable -> L70
        if (r15 == 0) goto L51;
        if (r15 == 1) goto L49;
        if (r15 == 2) goto L41;
        if (r15 == 3) goto L40;
        if (r15 == 4) goto L36;
        if (r15 != 5) goto L34;
        r27.f();     // Catch: Throwable -> L70
    L34:
        r6 = r27;
        goto L14
    L36:
        if (r17 >= b()) goto L38;
        r27.f();     // Catch: Throwable -> L70
    L38:
        kotlinx.coroutines.n r16 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
    L20:
        a(this, r25, r16);     // Catch: Throwable -> L70
        goto L62
    L40:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L70
    L41:
        if (r19 == false) goto L44;
        r27.l();     // Catch: Throwable -> L70
        r16 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        goto L20
    L44:
        if (ZeusTransformUtils.instanceOf((dk) ZeusTransformUtils.preCheckCast(r12, dk.class, "com.obric.aiagent.plugin"), dk.class) == false) goto L46;
        dk r18 = (dk) ZeusTransformUtils.preCheckCast(r12, dk.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
    L47:
        if (r18 == null) goto L62;
        a(this, r18, r27, r9);     // Catch: Throwable -> L70
        goto L62
    L46:
        r18 = null;
        goto L47
    L49:
        r0 = (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        d.n.a r20 = d.n.f38560a;     // Catch: Throwable -> L70
        r3 = d.n.f(x.f38692a);     // Catch: Throwable -> L70
        goto L50
    L51:
        r27.f();     // Catch: Throwable -> L70
        r0 = (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        d.n.a r21 = d.n.f38560a;     // Catch: Throwable -> L70
        r3 = d.n.f(x.f38692a);     // Catch: Throwable -> L70
        goto L50
    L18:
        if (r19 == false) goto L14;
        r16 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        goto L20
    L22:
        r13 = r6;
        goto L23
    L53:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L70
    L55:
        if (r26 >= b()) goto L57;
        r23.f();     // Catch: Throwable -> L70
    L57:
        r16 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        r12.i();
        throw th;
    }

    private final Object a(i<E> r11, int r12, long r13, d.c.d<? super E> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r0 = kotlinx.coroutines.q.a(d.c.a.b.a(r16));
        Object r2 = a(this, r11, r12, r13, (dk) ZeusTransformUtils.preCheckCast(r0, dk.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L49
        if (r2 != kotlinx.coroutines.a.c.k()) goto L6;
        b(this, (dk) ZeusTransformUtils.preCheckCast(r0, dk.class, "com.obric.aiagent.plugin"), r11, r12);     // Catch: Throwable -> L49
    L45:
        Object r10 = r0.h();
        if (r10 != d.c.a.b.a()) goto L48;
        d.c.b.a.h.c(r16);
    L48:
        return r10;
    L6:
        d.h.a.b<Throwable, x> r3 = null;
        r3 = null;
        dk r4 = null;
        if (r2 == kotlinx.coroutines.a.c.j()) goto L9;
        r11.f();     // Catch: Throwable -> L49
        d.h.a.b<E, x> r14 = this.f38777a;     // Catch: Throwable -> L49
        if (r14 != null) goto L43;
    L38:
        r0.a(r2, r3);     // Catch: Throwable -> L49
        goto L45
    L43:
        r3 = ad.b(r14, r2, r0.getContext());     // Catch: Throwable -> L49
        goto L38
    L9:
        if (r13 >= a()) goto L11;
        r11.f();     // Catch: Throwable -> L49
    L11:
        i r17 = (i) ZeusTransformUtils.preCheckCast(q().get(this), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
    L13:
        if (m() == true) goto L14;
        long r18 = r().getAndIncrement(this);     // Catch: Throwable -> L49
        long r5 = r18 / ((long) kotlinx.coroutines.a.c.f38799a);     // Catch: Throwable -> L49
        int r19 = (int) (r18 % ((long) kotlinx.coroutines.a.c.f38799a));     // Catch: Throwable -> L49
        if (r17.f39364a == r5) goto L21;
        i r6 = b(this, r5, r17);     // Catch: Throwable -> L49
        if (r6 == null) goto L13;
        r17 = r6;
    L21:
        i r7 = r17;
        r2 = a(this, r7, r19, r18, (dk) ZeusTransformUtils.preCheckCast(r0, dk.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L49
        if (r2 == kotlinx.coroutines.a.c.k()) goto L24;
        if (r2 != kotlinx.coroutines.a.c.j()) goto L34;
        if (r18 >= a()) goto L13;
        r17.f();     // Catch: Throwable -> L49
        goto L13
    L34:
        if (r2 == kotlinx.coroutines.a.c.l()) goto L40;
        r17.f();     // Catch: Throwable -> L49
        d.h.a.b<E, x> r110 = this.f38777a;     // Catch: Throwable -> L49
        if (r110 == null) goto L38;
        r3 = ad.b(r110, r2, r0.getContext());     // Catch: Throwable -> L49
        goto L38
    L40:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L49
    L24:
        if (ZeusTransformUtils.instanceOf((dk) ZeusTransformUtils.preCheckCast(r0, dk.class, "com.obric.aiagent.plugin"), dk.class) == false) goto L26;
        r4 = (dk) ZeusTransformUtils.preCheckCast(r0, dk.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
    L26:
        if (r4 == null) goto L45;
        b(this, r4, r17, r19);     // Catch: Throwable -> L49
        goto L45
    L14:
        a(this, (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        r0.i();
        throw th;
    }

    private final void a(kotlinx.coroutines.e.j<?> r11, Object r12) {
        kotlinx.coroutines.e.j<?> r13 = (kotlinx.coroutines.e.j) ZeusTransformUtils.wrapperContextForParams(r11, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin");
        i r14 = (i) ZeusTransformUtils.preCheckCast(q().get(this), i.class, "com.obric.aiagent.plugin");
    L4:
        if (m() == true) goto L5;
        long r7 = r().getAndIncrement(this);
        long r1 = r7 / ((long) kotlinx.coroutines.a.c.f38799a);
        int r9 = (int) (r7 % ((long) kotlinx.coroutines.a.c.f38799a));
        if (r14.f39364a == r1) goto L12;
        i r2 = b(this, r1, r14);
        if (r2 == null) goto L4;
        r14 = r2;
    L12:
        Object r3 = a(this, r14, r9, r7, r13);
        if (r3 == kotlinx.coroutines.a.c.k()) goto L15;
        if (r3 != kotlinx.coroutines.a.c.j()) goto L26;
        if (r7 >= a()) goto L4;
        r14.f();
        goto L4
    L26:
        if (r3 == kotlinx.coroutines.a.c.l()) goto L30;
        r14.f();
        r13.a(r3);
        return;
    L30:
        throw new IllegalStateException("unexpected".toString());
    L15:
        if (ZeusTransformUtils.instanceOf(r13, dk.class) == false) goto L17;
        dk r15 = (dk) ZeusTransformUtils.preCheckCast(r13, dk.class, "com.obric.aiagent.plugin");
    L18:
        if (r15 == null) goto L42;
        b(this, r15, r14, r9);
        return;
    L42:
        return;
    L17:
        r15 = null;
        goto L18
    L5:
        a(r13);
    }
}
