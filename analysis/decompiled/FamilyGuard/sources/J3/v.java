package J3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class v<T> extends AbstractC0350a<T, T> {

    static final class a<T> extends AtomicInteger implements x3.i<T>, Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3447a;

        /* renamed from: b, reason: collision with root package name */
        Q4.c f3448b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f3449c;

        /* renamed from: d, reason: collision with root package name */
        Throwable f3450d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f3451e;

        /* renamed from: f, reason: collision with root package name */
        final AtomicLong f3452f = new AtomicLong();

        /* renamed from: g, reason: collision with root package name */
        final AtomicReference<T> f3453g = new AtomicReference<>();

        a(Q4.b<? super T> bVar) {
            this.f3447a = bVar;
        }

        @Override // Q4.b
        public void a() {
            this.f3449c = true;
            c();
        }

        boolean b(boolean z5, boolean z6, Q4.b<?> bVar, AtomicReference<T> atomicReference) {
            if (this.f3451e) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z5) {
                return false;
            }
            Throwable th = this.f3450d;
            if (th != null) {
                atomicReference.lazySet(null);
                bVar.onError(th);
                return true;
            }
            if (!z6) {
                return false;
            }
            bVar.a();
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        
            if (r7 != r1.get()) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        
            r9 = r13.f3449c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
        
            if (r2.get() != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        
            if (b(r9, r10, r0, r2) == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        
            if (r7 == 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        
            R3.c.d(r1, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            r4 = addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void c() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L7
                goto L5e
            L7:
                Q4.b<? super T> r0 = r13.f3447a
                java.util.concurrent.atomic.AtomicLong r1 = r13.f3452f
                java.util.concurrent.atomic.AtomicReference<T> r2 = r13.f3453g
                r3 = 1
                r4 = r3
            Lf:
                r5 = 0
                r7 = r5
            L12:
                long r9 = r1.get()
                int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                r10 = 0
                if (r9 == 0) goto L38
                boolean r9 = r13.f3449c
                r11 = 0
                java.lang.Object r11 = r2.getAndSet(r11)
                if (r11 != 0) goto L26
                r12 = r3
                goto L27
            L26:
                r12 = r10
            L27:
                boolean r9 = r13.b(r9, r12, r0, r2)
                if (r9 == 0) goto L2e
                goto L5e
            L2e:
                if (r12 == 0) goto L31
                goto L38
            L31:
                r0.d(r11)
                r9 = 1
                long r7 = r7 + r9
                goto L12
            L38:
                long r11 = r1.get()
                int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r9 != 0) goto L50
                boolean r9 = r13.f3449c
                java.lang.Object r11 = r2.get()
                if (r11 != 0) goto L49
                r10 = r3
            L49:
                boolean r9 = r13.b(r9, r10, r0, r2)
                if (r9 == 0) goto L50
                goto L5e
            L50:
                int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r5 == 0) goto L57
                R3.c.d(r1, r7)
            L57:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto Lf
            L5e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.v.a.c():void");
        }

        @Override // Q4.c
        public void cancel() {
            if (this.f3451e) {
                return;
            }
            this.f3451e = true;
            this.f3448b.cancel();
            if (getAndIncrement() == 0) {
                this.f3453g.lazySet(null);
            }
        }

        @Override // Q4.b
        public void d(T t5) {
            this.f3453g.lazySet(t5);
            c();
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3448b, cVar)) {
                this.f3448b = cVar;
                this.f3447a.e(this);
                cVar.h(Long.MAX_VALUE);
            }
        }

        @Override // Q4.c
        public void h(long j5) {
            if (Q3.g.k(j5)) {
                R3.c.a(this.f3452f, j5);
                c();
            }
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            this.f3450d = th;
            this.f3449c = true;
            c();
        }
    }

    public v(x3.f<T> fVar) {
        super(fVar);
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        this.f3267b.V(new a(bVar));
    }
}
