package J3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import x3.EnumC1285a;

/* renamed from: J3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0351b<T> extends x3.f<T> {

    /* renamed from: b, reason: collision with root package name */
    final x3.h<T> f3268b;

    /* renamed from: c, reason: collision with root package name */
    final EnumC1285a f3269c;

    /* renamed from: J3.b$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3270a;

        static {
            int[] iArr = new int[EnumC1285a.values().length];
            f3270a = iArr;
            try {
                iArr[EnumC1285a.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3270a[EnumC1285a.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3270a[EnumC1285a.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3270a[EnumC1285a.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: J3.b$b, reason: collision with other inner class name */
    static abstract class AbstractC0046b<T> extends AtomicLong implements x3.g<T>, Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3271a;

        /* renamed from: b, reason: collision with root package name */
        final E3.f f3272b = new E3.f();

        AbstractC0046b(Q4.b<? super T> bVar) {
            this.f3271a = bVar;
        }

        @Override // x3.g
        public final void a(A3.c cVar) {
            this.f3272b.b(cVar);
        }

        protected void b() {
            if (isCancelled()) {
                return;
            }
            try {
                this.f3271a.a();
            } finally {
                this.f3272b.dispose();
            }
        }

        protected boolean c(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.f3271a.onError(th);
                this.f3272b.dispose();
                return true;
            } catch (Throwable th2) {
                this.f3272b.dispose();
                throw th2;
            }
        }

        @Override // Q4.c
        public final void cancel() {
            this.f3272b.dispose();
            g();
        }

        public final void e(Throwable th) {
            if (i(th)) {
                return;
            }
            S3.a.r(th);
        }

        void f() {
        }

        void g() {
        }

        @Override // Q4.c
        public final void h(long j5) {
            if (Q3.g.k(j5)) {
                R3.c.a(this, j5);
                f();
            }
        }

        public boolean i(Throwable th) {
            return c(th);
        }

        @Override // x3.g
        public final boolean isCancelled() {
            return this.f3272b.g();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }

    /* renamed from: J3.b$c */
    static final class c<T> extends AbstractC0046b<T> {

        /* renamed from: c, reason: collision with root package name */
        final N3.c<T> f3273c;

        /* renamed from: d, reason: collision with root package name */
        Throwable f3274d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f3275e;

        /* renamed from: f, reason: collision with root package name */
        final AtomicInteger f3276f;

        c(Q4.b<? super T> bVar, int i5) {
            super(bVar);
            this.f3273c = new N3.c<>(i5);
            this.f3276f = new AtomicInteger();
        }

        @Override // x3.e
        public void d(T t5) {
            if (this.f3275e || isCancelled()) {
                return;
            }
            if (t5 == null) {
                e(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f3273c.offer(t5);
                j();
            }
        }

        @Override // J3.C0351b.AbstractC0046b
        void f() {
            j();
        }

        @Override // J3.C0351b.AbstractC0046b
        void g() {
            if (this.f3276f.getAndIncrement() == 0) {
                this.f3273c.clear();
            }
        }

        @Override // J3.C0351b.AbstractC0046b
        public boolean i(Throwable th) {
            if (this.f3275e || isCancelled()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f3274d = th;
            this.f3275e = true;
            j();
            return true;
        }

        void j() {
            if (this.f3276f.getAndIncrement() != 0) {
                return;
            }
            Q4.b<? super T> bVar = this.f3271a;
            N3.c<T> cVar = this.f3273c;
            int iAddAndGet = 1;
            do {
                long j5 = get();
                long j6 = 0;
                while (j6 != j5) {
                    if (isCancelled()) {
                        cVar.clear();
                        return;
                    }
                    boolean z5 = this.f3275e;
                    T tPoll = cVar.poll();
                    boolean z6 = tPoll == null;
                    if (z5 && z6) {
                        Throwable th = this.f3274d;
                        if (th != null) {
                            c(th);
                            return;
                        } else {
                            b();
                            return;
                        }
                    }
                    if (z6) {
                        break;
                    }
                    bVar.d(tPoll);
                    j6++;
                }
                if (j6 == j5) {
                    if (isCancelled()) {
                        cVar.clear();
                        return;
                    }
                    boolean z7 = this.f3275e;
                    boolean zIsEmpty = cVar.isEmpty();
                    if (z7 && zIsEmpty) {
                        Throwable th2 = this.f3274d;
                        if (th2 != null) {
                            c(th2);
                            return;
                        } else {
                            b();
                            return;
                        }
                    }
                }
                if (j6 != 0) {
                    R3.c.d(this, j6);
                }
                iAddAndGet = this.f3276f.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    /* renamed from: J3.b$d */
    static final class d<T> extends h<T> {
        d(Q4.b<? super T> bVar) {
            super(bVar);
        }

        @Override // J3.C0351b.h
        void j() {
        }
    }

    /* renamed from: J3.b$e */
    static final class e<T> extends h<T> {
        e(Q4.b<? super T> bVar) {
            super(bVar);
        }

        @Override // J3.C0351b.h
        void j() {
            e(new B3.c("create: could not emit value due to lack of requests"));
        }
    }

    /* renamed from: J3.b$f */
    static final class f<T> extends AbstractC0046b<T> {

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference<T> f3277c;

        /* renamed from: d, reason: collision with root package name */
        Throwable f3278d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f3279e;

        /* renamed from: f, reason: collision with root package name */
        final AtomicInteger f3280f;

        f(Q4.b<? super T> bVar) {
            super(bVar);
            this.f3277c = new AtomicReference<>();
            this.f3280f = new AtomicInteger();
        }

        @Override // x3.e
        public void d(T t5) {
            if (this.f3279e || isCancelled()) {
                return;
            }
            if (t5 == null) {
                e(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f3277c.set(t5);
                j();
            }
        }

        @Override // J3.C0351b.AbstractC0046b
        void f() {
            j();
        }

        @Override // J3.C0351b.AbstractC0046b
        void g() {
            if (this.f3280f.getAndIncrement() == 0) {
                this.f3277c.lazySet(null);
            }
        }

        @Override // J3.C0351b.AbstractC0046b
        public boolean i(Throwable th) {
            if (this.f3279e || isCancelled()) {
                return false;
            }
            if (th == null) {
                e(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.f3278d = th;
            this.f3279e = true;
            j();
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
        
            if (r9 != r5) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
        
            if (isCancelled() == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
        
            r2.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
        
            r5 = r17.f3279e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
        
            if (r2.get() != null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
        
            if (r5 == false) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0067, code lost:
        
            if (r12 == false) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0069, code lost:
        
            r1 = r17.f3278d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006b, code lost:
        
            if (r1 == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x006d, code lost:
        
            c(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0071, code lost:
        
            b();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0074, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0077, code lost:
        
            if (r9 == 0) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0079, code lost:
        
            R3.c.d(r17, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x007c, code lost:
        
            r4 = r17.f3280f.addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void j() {
            /*
                r17 = this;
                r0 = r17
                java.util.concurrent.atomic.AtomicInteger r1 = r0.f3280f
                int r1 = r1.getAndIncrement()
                if (r1 == 0) goto Lc
                goto L85
            Lc:
                Q4.b<? super T> r1 = r0.f3271a
                java.util.concurrent.atomic.AtomicReference<T> r2 = r0.f3277c
                r3 = 1
                r4 = r3
            L12:
                long r5 = r0.get()
                r7 = 0
                r9 = r7
            L19:
                int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
                r12 = 0
                r13 = 0
                if (r11 == 0) goto L50
                boolean r14 = r0.isCancelled()
                if (r14 == 0) goto L29
                r2.lazySet(r13)
                return
            L29:
                boolean r14 = r0.f3279e
                java.lang.Object r15 = r2.getAndSet(r13)
                if (r15 != 0) goto L34
                r16 = r3
                goto L36
            L34:
                r16 = r12
            L36:
                if (r14 == 0) goto L46
                if (r16 == 0) goto L46
                java.lang.Throwable r1 = r0.f3278d
                if (r1 == 0) goto L42
                r0.c(r1)
                return
            L42:
                r0.b()
                return
            L46:
                if (r16 == 0) goto L49
                goto L50
            L49:
                r1.d(r15)
                r11 = 1
                long r9 = r9 + r11
                goto L19
            L50:
                if (r11 != 0) goto L75
                boolean r5 = r0.isCancelled()
                if (r5 == 0) goto L5c
                r2.lazySet(r13)
                return
            L5c:
                boolean r5 = r0.f3279e
                java.lang.Object r6 = r2.get()
                if (r6 != 0) goto L65
                r12 = r3
            L65:
                if (r5 == 0) goto L75
                if (r12 == 0) goto L75
                java.lang.Throwable r1 = r0.f3278d
                if (r1 == 0) goto L71
                r0.c(r1)
                return
            L71:
                r0.b()
                return
            L75:
                int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r5 == 0) goto L7c
                R3.c.d(r0, r9)
            L7c:
                java.util.concurrent.atomic.AtomicInteger r5 = r0.f3280f
                int r4 = -r4
                int r4 = r5.addAndGet(r4)
                if (r4 != 0) goto L12
            L85:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.C0351b.f.j():void");
        }
    }

    /* renamed from: J3.b$g */
    static final class g<T> extends AbstractC0046b<T> {
        g(Q4.b<? super T> bVar) {
            super(bVar);
        }

        @Override // x3.e
        public void d(T t5) {
            long j5;
            if (isCancelled()) {
                return;
            }
            if (t5 == null) {
                e(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.f3271a.d(t5);
            do {
                j5 = get();
                if (j5 == 0) {
                    return;
                }
            } while (!compareAndSet(j5, j5 - 1));
        }
    }

    /* renamed from: J3.b$h */
    static abstract class h<T> extends AbstractC0046b<T> {
        h(Q4.b<? super T> bVar) {
            super(bVar);
        }

        @Override // x3.e
        public final void d(T t5) {
            if (isCancelled()) {
                return;
            }
            if (t5 == null) {
                e(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() == 0) {
                j();
            } else {
                this.f3271a.d(t5);
                R3.c.d(this, 1L);
            }
        }

        abstract void j();
    }

    public C0351b(x3.h<T> hVar, EnumC1285a enumC1285a) {
        this.f3268b = hVar;
        this.f3269c = enumC1285a;
    }

    @Override // x3.f
    public void W(Q4.b<? super T> bVar) {
        int i5 = a.f3270a[this.f3269c.ordinal()];
        AbstractC0046b cVar = i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? new c(bVar, x3.f.g()) : new f(bVar) : new d(bVar) : new e(bVar) : new g(bVar);
        bVar.e(cVar);
        try {
            this.f3268b.a(cVar);
        } catch (Throwable th) {
            B3.b.b(th);
            cVar.e(th);
        }
    }
}
