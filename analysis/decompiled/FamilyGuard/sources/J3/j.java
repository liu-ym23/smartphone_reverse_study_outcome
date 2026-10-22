package J3;

/* loaded from: classes.dex */
public final class j<T> extends x3.f<T> {

    /* renamed from: b, reason: collision with root package name */
    final T[] f3373b;

    static final class a<T> extends c<T> {

        /* renamed from: d, reason: collision with root package name */
        final G3.a<? super T> f3374d;

        a(G3.a<? super T> aVar, T[] tArr) {
            super(tArr);
            this.f3374d = aVar;
        }

        @Override // J3.j.c
        void a() {
            T[] tArr = this.f3376a;
            int length = tArr.length;
            G3.a<? super T> aVar = this.f3374d;
            for (int i5 = this.f3377b; i5 != length; i5++) {
                if (this.f3378c) {
                    return;
                }
                T t5 = tArr[i5];
                if (t5 == null) {
                    aVar.onError(new NullPointerException("The element at index " + i5 + " is null"));
                    return;
                }
                aVar.f(t5);
            }
            if (this.f3378c) {
                return;
            }
            aVar.a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        
            r10.f3377b = r2;
            r11 = addAndGet(-r6);
         */
        @Override // J3.j.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void c(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.f3376a
                int r1 = r0.length
                int r2 = r10.f3377b
                G3.a<? super T> r3 = r10.f3374d
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L44
                if (r2 == r1) goto L44
                boolean r8 = r10.f3378c
                if (r8 == 0) goto L15
                goto L61
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L38
                java.lang.NullPointerException r10 = new java.lang.NullPointerException
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r12 = "The element at index "
                r11.append(r12)
                r11.append(r2)
                java.lang.String r12 = " is null"
                r11.append(r12)
                java.lang.String r11 = r11.toString()
                r10.<init>(r11)
                r3.onError(r10)
                return
            L38:
                boolean r8 = r3.f(r8)
                if (r8 == 0) goto L41
                r8 = 1
                long r6 = r6 + r8
            L41:
                int r2 = r2 + 1
                goto La
            L44:
                if (r2 != r1) goto L4e
                boolean r10 = r10.f3378c
                if (r10 != 0) goto L61
                r3.a()
                return
            L4e:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.f3377b = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
            L61:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.j.a.c(long):void");
        }
    }

    static final class b<T> extends c<T> {

        /* renamed from: d, reason: collision with root package name */
        final Q4.b<? super T> f3375d;

        b(Q4.b<? super T> bVar, T[] tArr) {
            super(tArr);
            this.f3375d = bVar;
        }

        @Override // J3.j.c
        void a() {
            T[] tArr = this.f3376a;
            int length = tArr.length;
            Q4.b<? super T> bVar = this.f3375d;
            for (int i5 = this.f3377b; i5 != length; i5++) {
                if (this.f3378c) {
                    return;
                }
                T t5 = tArr[i5];
                if (t5 == null) {
                    bVar.onError(new NullPointerException("The element at index " + i5 + " is null"));
                    return;
                }
                bVar.d(t5);
            }
            if (this.f3378c) {
                return;
            }
            bVar.a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
        
            r10.f3377b = r2;
            r11 = addAndGet(-r6);
         */
        @Override // J3.j.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void c(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.f3376a
                int r1 = r0.length
                int r2 = r10.f3377b
                Q4.b<? super T> r3 = r10.f3375d
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L41
                if (r2 == r1) goto L41
                boolean r8 = r10.f3378c
                if (r8 == 0) goto L15
                goto L5e
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L38
                java.lang.NullPointerException r10 = new java.lang.NullPointerException
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r12 = "The element at index "
                r11.append(r12)
                r11.append(r2)
                java.lang.String r12 = " is null"
                r11.append(r12)
                java.lang.String r11 = r11.toString()
                r10.<init>(r11)
                r3.onError(r10)
                return
            L38:
                r3.d(r8)
                r8 = 1
                long r6 = r6 + r8
                int r2 = r2 + 1
                goto La
            L41:
                if (r2 != r1) goto L4b
                boolean r10 = r10.f3378c
                if (r10 != 0) goto L5e
                r3.a()
                return
            L4b:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.f3377b = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
            L5e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.j.b.c(long):void");
        }
    }

    static abstract class c<T> extends Q3.b<T> {

        /* renamed from: a, reason: collision with root package name */
        final T[] f3376a;

        /* renamed from: b, reason: collision with root package name */
        int f3377b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f3378c;

        c(T[] tArr) {
            this.f3376a = tArr;
        }

        abstract void a();

        @Override // G3.b
        public final int b(int i5) {
            return i5 & 1;
        }

        abstract void c(long j5);

        @Override // Q4.c
        public final void cancel() {
            this.f3378c = true;
        }

        @Override // G3.f
        public final void clear() {
            this.f3377b = this.f3376a.length;
        }

        @Override // Q4.c
        public final void h(long j5) {
            if (Q3.g.k(j5) && R3.c.a(this, j5) == 0) {
                if (j5 == Long.MAX_VALUE) {
                    a();
                } else {
                    c(j5);
                }
            }
        }

        @Override // G3.f
        public final boolean isEmpty() {
            return this.f3377b == this.f3376a.length;
        }

        @Override // G3.f
        public final T poll() {
            int i5 = this.f3377b;
            T[] tArr = this.f3376a;
            if (i5 == tArr.length) {
                return null;
            }
            this.f3377b = i5 + 1;
            return (T) F3.b.d(tArr[i5], "array element is null");
        }
    }

    public j(T[] tArr) {
        this.f3373b = tArr;
    }

    @Override // x3.f
    public void W(Q4.b<? super T> bVar) {
        if (bVar instanceof G3.a) {
            bVar.e(new a((G3.a) bVar, this.f3373b));
        } else {
            bVar.e(new b(bVar, this.f3373b));
        }
    }
}
