package kotlinx.coroutines.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.h;
import d.h.a.q;
import d.h.b.p;
import d.x;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.dk;
import kotlinx.coroutines.e.j;
import kotlinx.coroutines.internal.al;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: compiled from: Mutex.kt */
/* JADX INFO: loaded from: classes4.dex */
public class b extends e implements kotlinx.coroutines.f.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39320b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q<j<?>, Object, Object, d.h.a.b<Throwable, x>> f39321a;
    private volatile /* synthetic */ Object owner$volatile;

    /* JADX INFO: compiled from: Mutex.kt */
    private final class a implements dk, n<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o<x> f39322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f39323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f39324c;

        /* JADX INFO: renamed from: kotlinx.coroutines.f.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Mutex.kt */
        static final class C1059a extends p implements d.h.a.b<Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f39325a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f39326b;

            C1059a(b r1, a r2) {
                this.f39325a = r1;
                this.f39326b = r2;
                super(1);
            }

            public final void a(Throwable r1) {
                this.f39325a.b(this.f39326b.f39323b);
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.f.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Mutex.kt */
        static final class C1060b extends p implements d.h.a.b<Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f39327a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f39328b;

            C1060b(b r1, a r2) {
                this.f39327a = r1;
                this.f39328b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(Throwable r3) {
                b r4 = this.f39327a;
                a r0 = this.f39328b;
                if (aq.a() == false) goto L15;
                Object r5 = b.b().get(r4);
                if (r5 != c.a()) goto L7;
            L10:
                boolean r6 = true;
            L11:
                if (r6 == true) goto L15;
                throw new AssertionError();
            L7:
                if (r5 == r0.f39323b) goto L10;
                r6 = false;
            L15:
                b.b().set(this.f39327a, this.f39328b.f39323b);
                this.f39327a.b(this.f39328b.f39323b);
            }
        }

        @Override // kotlinx.coroutines.n
        public Object a(Throwable r1) {
            return this.f39322a.a(r1);
        }

        @Override // kotlinx.coroutines.n
        public void a(d.h.a.b<? super Throwable, x> r3) {
            d.h.a.b<? super Throwable, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            this.f39322a.a(r4);
        }

        @Override // kotlinx.coroutines.n
        public void a(Object r1) {
            this.f39322a.a(r1);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(ai r1, x r2) {
            this.f39322a.a(r1, r2);
        }

        @Override // kotlinx.coroutines.dk
        public void a(kotlinx.coroutines.internal.ai<?> r1, int r2) {
            this.f39322a.a(r1, r2);
        }

        @Override // kotlinx.coroutines.n
        public boolean a() {
            return this.f39322a.a();
        }

        @Override // kotlinx.coroutines.n
        public boolean b() {
            return this.f39322a.b();
        }

        @Override // kotlinx.coroutines.n
        public boolean b(Throwable r1) {
            return this.f39322a.b(r1);
        }

        @Override // d.c.d
        public d.c.g getContext() {
            return this.f39322a.getContext();
        }

        @Override // d.c.d
        public void resumeWith(Object r1) {
            this.f39322a.resumeWith(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(b r1, o<? super x> r2, Object r3) {
            this.f39324c = r1;
            this.f39322a = r2;
            this.f39323b = r3;
        }

        @Override // kotlinx.coroutines.n
        public /* synthetic */ Object a(x r3, Object r4, d.h.a.b r5) {
            d.h.a.b<? super Throwable, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
            return a2((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.aiagent.plugin"), r4, r6);
        }

        @Override // kotlinx.coroutines.n
        public /* synthetic */ void a(x r3, d.h.a.b r4) {
            d.h.a.b<? super Throwable, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            a2((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // kotlinx.coroutines.n
        public /* synthetic */ void a(ai r3, x r4) {
            a2(r3, (x) ZeusTransformUtils.preCheckCast(r4, x.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public Object a2(x r6, Object r7, d.h.a.b<? super Throwable, x> r8) {
            d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
            b r10 = this.f39324c;
            boolean r2 = true;
            if (aq.a() == true) goto L5;
        L12:
            Object r11 = this.f39322a.a(r6, r7, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C1060b(this.f39324c, this), d.h.a.b.class, "com.obric.aiagent.plugin"));
            if (r11 == null) goto L25;
            b r12 = this.f39324c;
            if (aq.a() == true) goto L17;
        L24:
            b.b().set(this.f39324c, this.f39323b);
            goto L25
        L17:
            if (b.b().get(r12) == c.a()) goto L20;
            r2 = false;
        L20:
            if (r2 == true) goto L24;
            throw new AssertionError();
        L25:
            return r11;
        L5:
            if (b.b().get(r10) != c.a()) goto L7;
            boolean r13 = true;
        L8:
            if (r13 == true) goto L12;
            throw new AssertionError();
        L7:
            r13 = false;
            goto L8
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(x r4, d.h.a.b<? super Throwable, x> r5) {
            d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
            b r7 = this.f39324c;
            if (aq.a() == true) goto L5;
        L12:
            b.b().set(this.f39324c, this.f39323b);
            this.f39322a.a(r4, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C1059a(this.f39324c, this), d.h.a.b.class, "com.obric.aiagent.plugin"));
            return;
        L5:
            if (b.b().get(r7) != c.a()) goto L7;
            boolean r8 = true;
        L8:
            if (r8 == true) goto L12;
            throw new AssertionError();
        L7:
            r8 = false;
            goto L8
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Mutex.kt */
    static final class C1061b extends p implements q<j<?>, Object, Object, d.h.a.b<? super Throwable, ? extends x>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f39329a;

        /* JADX INFO: renamed from: kotlinx.coroutines.f.b$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: Mutex.kt */
        static final class AnonymousClass1 extends p implements d.h.a.b<Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f39330a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f39331b;

            AnonymousClass1(b r1, Object r2) {
                this.f39330a = r1;
                this.f39331b = r2;
                super(1);
            }

            public final void a(Throwable r1) {
                this.f39330a.b(this.f39331b);
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }
        }

        C1061b(b r1) {
            this.f39329a = r1;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ d.h.a.b<? super Throwable, ? extends x> invoke(j<?> r3, Object r4, Object r5) {
            return a((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin"), r4, r5);
        }

        public final d.h.a.b<Throwable, x> a(j<?> r2, Object r3, Object r4) {
            j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
            return (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f39329a, r3), d.h.a.b.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f39320b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "owner$volatile");
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater f() {
        return f39320b;
    }

    @Override // kotlinx.coroutines.f.a
    public Object a(Object r3, d.c.d<? super x> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public b(boolean r3) {
        super(1, r3 ? 1 : 0);
        if (r3 == false) goto L5;
        al r4 = null;
    L6:
        this.owner$volatile = r4;
        this.f39321a = (q) ZeusTransformUtils.preCheckCast(new C1061b(this), q.class, "com.obric.aiagent.plugin");
        return;
    L5:
        r4 = c.a();
        goto L6
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater b() {
        return f();
    }

    @Override // kotlinx.coroutines.f.a
    public boolean a() {
        if (d() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final int c(Object r3) {
    L3:
        if (a() == false) goto L4;
        Object r0 = f().get(this);
        if (r0 == c.a()) goto L3;
        if (r0 != r3) goto L10;
        return 1;
    L10:
        return 2;
    L4:
        return 0;
    }

    static /* synthetic */ Object a(b r2, Object r3, d.c.d<? super x> r4) {
        d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (r2.a(r3) == true) goto L5;
        Object r6 = r2.b(r3, r5);
        if (r6 != d.c.a.b.a()) goto L10;
        return r6;
    L10:
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    @Override // kotlinx.coroutines.f.a
    public boolean a(Object r3) {
        int r2 = d(r3);
        if (r2 == 0) goto L13;
        if (r2 != 1) goto L6;
        return false;
    L6:
        if (r2 == 2) goto L10;
        throw new IllegalStateException("unexpected".toString());
    L10:
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + r3).toString());
    L13:
        return true;
    }

    private final int d(Object r5) {
    L2:
        boolean r1 = true;
        if (e() == true) goto L5;
        if (r5 == null) goto L17;
        int r0 = c(r5);
        if (r0 == 1) goto L23;
        if (r0 != 2) goto L2;
        return 1;
    L23:
        return 2;
    L17:
        return 1;
    L5:
        if (aq.a() == true) goto L7;
    L14:
        f().set(this, r5);
        return 0;
    L7:
        if (f().get(this) == c.a()) goto L10;
        r1 = false;
    L10:
        if (r1 == true) goto L14;
        throw new AssertionError();
    }

    @Override // kotlinx.coroutines.f.a
    public void b(Object r4) {
    L3:
        if (a() == false) goto L19;
        Object r0 = f().get(this);
        if (r0 == c.a()) goto L3;
        if (r0 == r4) goto L10;
        if (r4 == null) goto L10;
        boolean r1 = false;
    L11:
        if (r1 == false) goto L17;
        if (f().compareAndSet(this, r0, c.a()) == false) goto L3;
        c();
        return;
    L17:
        throw new IllegalStateException(("This mutex is locked by " + r0 + ", but " + r4 + " is expected").toString());
    L10:
        r1 = true;
        goto L11
    L19:
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public String toString() {
        return "Mutex@" + ar.a(this) + "[isLocked=" + a() + ",owner=" + f().get(this) + ']';
    }

    private final Object b(Object r4, d.c.d<? super x> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        o r0 = kotlinx.coroutines.q.a(d.c.a.b.a(r6));
        a((n) ZeusTransformUtils.preCheckCast(new a(this, r0, r4), n.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
        Object r3 = r0.h();
        if (r3 != d.c.a.b.a()) goto L8;
        h.c(r6);
    L8:
        if (r3 != d.c.a.b.a()) goto L11;
        return r3;
    L11:
        return x.f38692a;
    L12:
        th = move-exception;
        r0.i();
        throw th;
    }
}
