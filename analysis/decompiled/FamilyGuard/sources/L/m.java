package L;

import V3.v;
import W3.C0403n;
import a4.C0428b;
import com.stepos.digitalwellbeing.server.net.category.CategoryEntity;
import i4.InterfaceC0761a;
import i4.InterfaceC0772l;
import j4.s;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import s4.C1093v;
import s4.I;
import s4.InterfaceC1091t;
import v4.InterfaceC1193b;
import v4.InterfaceC1194c;

/* loaded from: classes.dex */
public final class m<T> implements L.f<T> {

    /* renamed from: k, reason: collision with root package name */
    public static final a f3704k = new a(null);

    /* renamed from: l, reason: collision with root package name */
    private static final Set<String> f3705l = new LinkedHashSet();

    /* renamed from: m, reason: collision with root package name */
    private static final Object f3706m = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0761a<File> f3707a;

    /* renamed from: b, reason: collision with root package name */
    private final L.k<T> f3708b;

    /* renamed from: c, reason: collision with root package name */
    private final L.b<T> f3709c;

    /* renamed from: d, reason: collision with root package name */
    private final I f3710d;

    /* renamed from: e, reason: collision with root package name */
    private final InterfaceC1193b<T> f3711e;

    /* renamed from: f, reason: collision with root package name */
    private final String f3712f;

    /* renamed from: g, reason: collision with root package name */
    private final V3.f f3713g;

    /* renamed from: h, reason: collision with root package name */
    private final v4.j<L.n<T>> f3714h;

    /* renamed from: i, reason: collision with root package name */
    private List<? extends i4.p<? super L.i<T>, ? super Z3.e<? super v>, ? extends Object>> f3715i;

    /* renamed from: j, reason: collision with root package name */
    private final L.l<b<T>> f3716j;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        public final Set<String> a() {
            return m.f3705l;
        }

        public final Object b() {
            return m.f3706m;
        }

        private a() {
        }
    }

    private static abstract class b<T> {

        public static final class a<T> extends b<T> {

            /* renamed from: a, reason: collision with root package name */
            private final L.n<T> f3717a;

            public a(L.n<T> nVar) {
                super(null);
                this.f3717a = nVar;
            }

            public L.n<T> a() {
                return this.f3717a;
            }
        }

        /* renamed from: L.m$b$b, reason: collision with other inner class name */
        public static final class C0053b<T> extends b<T> {

            /* renamed from: a, reason: collision with root package name */
            private final i4.p<T, Z3.e<? super T>, Object> f3718a;

            /* renamed from: b, reason: collision with root package name */
            private final InterfaceC1091t<T> f3719b;

            /* renamed from: c, reason: collision with root package name */
            private final L.n<T> f3720c;

            /* renamed from: d, reason: collision with root package name */
            private final Z3.i f3721d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0053b(i4.p<? super T, ? super Z3.e<? super T>, ? extends Object> pVar, InterfaceC1091t<T> interfaceC1091t, L.n<T> nVar, Z3.i iVar) {
                super(null);
                j4.k.g(pVar, "transform");
                j4.k.g(interfaceC1091t, "ack");
                j4.k.g(iVar, "callerContext");
                this.f3718a = pVar;
                this.f3719b = interfaceC1091t;
                this.f3720c = nVar;
                this.f3721d = iVar;
            }

            public final InterfaceC1091t<T> a() {
                return this.f3719b;
            }

            public final Z3.i b() {
                return this.f3721d;
            }

            public L.n<T> c() {
                return this.f3720c;
            }

            public final i4.p<T, Z3.e<? super T>, Object> d() {
                return this.f3718a;
            }
        }

        public /* synthetic */ b(j4.g gVar) {
            this();
        }

        private b() {
        }
    }

    private static final class c extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        private final FileOutputStream f3722a;

        public c(FileOutputStream fileOutputStream) {
            j4.k.g(fileOutputStream, "fileOutputStream");
            this.f3722a = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f3722a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i5) throws IOException {
            this.f3722a.write(i5);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            j4.k.g(bArr, "b");
            this.f3722a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i5, int i6) throws IOException {
            j4.k.g(bArr, "bytes");
            this.f3722a.write(bArr, i5, i6);
        }
    }

    static final class d extends j4.l implements InterfaceC0772l<Throwable, v> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m<T> f3723a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(m<T> mVar) {
            super(1);
            this.f3723a = mVar;
        }

        public final void b(Throwable th) {
            if (th != null) {
                ((m) this.f3723a).f3714h.setValue(new L.h(th));
            }
            a aVar = m.f3704k;
            Object objB = aVar.b();
            m<T> mVar = this.f3723a;
            synchronized (objB) {
                aVar.a().remove(mVar.r().getAbsolutePath());
                v vVar = v.f5542a;
            }
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ v invoke(Throwable th) {
            b(th);
            return v.f5542a;
        }
    }

    static final class e extends j4.l implements i4.p<b<T>, Throwable, v> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f3724a = new e();

        e() {
            super(2);
        }

        public final void b(b<T> bVar, Throwable th) {
            j4.k.g(bVar, "msg");
            if (bVar instanceof b.C0053b) {
                InterfaceC1091t<T> interfaceC1091tA = ((b.C0053b) bVar).a();
                if (th == null) {
                    th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                }
                interfaceC1091tA.L(th);
            }
        }

        @Override // i4.p
        public /* bridge */ /* synthetic */ v invoke(Object obj, Throwable th) {
            b((b) obj, th);
            return v.f5542a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
    static final class f extends kotlin.coroutines.jvm.internal.l implements i4.p<b<T>, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f3725a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f3726b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ m<T> f3727c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(m<T> mVar, Z3.e<? super f> eVar) {
            super(2, eVar);
            this.f3727c = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            f fVar = new f(this.f3727c, eVar);
            fVar.f3726b = obj;
            return fVar;
        }

        @Override // i4.p
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(b<T> bVar, Z3.e<? super v> eVar) {
            return ((f) create(bVar, eVar)).invokeSuspend(v.f5542a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
        
            if (r4.f3727c.s((L.m.b.a) r5, r4) == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        
            if (r4.f3727c.t((L.m.b.C0053b) r5, r4) == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = a4.C0428b.e()
                int r1 = r4.f3725a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L17:
                V3.o.b(r5)
                goto L44
            L1b:
                V3.o.b(r5)
                java.lang.Object r5 = r4.f3726b
                L.m$b r5 = (L.m.b) r5
                boolean r1 = r5 instanceof L.m.b.a
                if (r1 == 0) goto L33
                L.m<T> r1 = r4.f3727c
                L.m$b$a r5 = (L.m.b.a) r5
                r4.f3725a = r3
                java.lang.Object r4 = L.m.i(r1, r5, r4)
                if (r4 != r0) goto L44
                goto L43
            L33:
                boolean r1 = r5 instanceof L.m.b.C0053b
                if (r1 == 0) goto L44
                L.m<T> r1 = r4.f3727c
                L.m$b$b r5 = (L.m.b.C0053b) r5
                r4.f3725a = r2
                java.lang.Object r4 = L.m.j(r1, r5, r4)
                if (r4 != r0) goto L44
            L43:
                return r0
            L44:
                V3.v r4 = V3.v.f5542a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: L.m.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
    static final class g extends kotlin.coroutines.jvm.internal.l implements i4.p<InterfaceC1194c<? super T>, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f3728a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f3729b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ m<T> f3730c;

        @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<L.n<T>, Z3.e<? super Boolean>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f3731a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f3732b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ L.n<T> f3733c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(L.n<T> nVar, Z3.e<? super a> eVar) {
                super(2, eVar);
                this.f3733c = nVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                a aVar = new a(this.f3733c, eVar);
                aVar.f3732b = obj;
                return aVar;
            }

            @Override // i4.p
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(L.n<T> nVar, Z3.e<? super Boolean> eVar) {
                return ((a) create(nVar, eVar)).invokeSuspend(v.f5542a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                C0428b.e();
                if (this.f3731a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                V3.o.b(obj);
                L.n<T> nVar = (L.n) this.f3732b;
                L.n<T> nVar2 = this.f3733c;
                boolean z5 = false;
                if (!(nVar2 instanceof L.c) && !(nVar2 instanceof L.h) && nVar == nVar2) {
                    z5 = true;
                }
                return kotlin.coroutines.jvm.internal.b.a(z5);
            }
        }

        public static final class b implements InterfaceC1193b<T> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ InterfaceC1193b f3734a;

            public static final class a implements InterfaceC1194c<L.n<T>> {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ InterfaceC1194c f3735a;

                @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2", f = "SingleProcessDataStore.kt", l = {137}, m = "emit")
                /* renamed from: L.m$g$b$a$a, reason: collision with other inner class name */
                public static final class C0054a extends kotlin.coroutines.jvm.internal.d {

                    /* renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f3736a;

                    /* renamed from: b, reason: collision with root package name */
                    int f3737b;

                    public C0054a(Z3.e eVar) {
                        super(eVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        this.f3736a = obj;
                        this.f3737b |= Integer.MIN_VALUE;
                        return a.this.g(null, this);
                    }
                }

                public a(InterfaceC1194c interfaceC1194c) {
                    this.f3735a = interfaceC1194c;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // v4.InterfaceC1194c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object g(java.lang.Object r5, Z3.e r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof L.m.g.b.a.C0054a
                        if (r0 == 0) goto L13
                        r0 = r6
                        L.m$g$b$a$a r0 = (L.m.g.b.a.C0054a) r0
                        int r1 = r0.f3737b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f3737b = r1
                        goto L18
                    L13:
                        L.m$g$b$a$a r0 = new L.m$g$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f3736a
                        java.lang.Object r1 = a4.C0428b.e()
                        int r2 = r0.f3737b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        V3.o.b(r6)
                        goto L53
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        V3.o.b(r6)
                        v4.c r4 = r4.f3735a
                        L.n r5 = (L.n) r5
                        boolean r6 = r5 instanceof L.j
                        if (r6 != 0) goto L6f
                        boolean r6 = r5 instanceof L.h
                        if (r6 != 0) goto L68
                        boolean r6 = r5 instanceof L.c
                        if (r6 == 0) goto L56
                        L.c r5 = (L.c) r5
                        java.lang.Object r5 = r5.b()
                        r0.f3737b = r3
                        java.lang.Object r4 = r4.g(r5, r0)
                        if (r4 != r1) goto L53
                        return r1
                    L53:
                        V3.v r4 = V3.v.f5542a
                        return r4
                    L56:
                        boolean r4 = r5 instanceof L.o
                        if (r4 == 0) goto L62
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
                        r4.<init>(r5)
                        throw r4
                    L62:
                        V3.l r4 = new V3.l
                        r4.<init>()
                        throw r4
                    L68:
                        L.h r5 = (L.h) r5
                        java.lang.Throwable r4 = r5.a()
                        throw r4
                    L6f:
                        L.j r5 = (L.j) r5
                        java.lang.Throwable r4 = r5.a()
                        throw r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: L.m.g.b.a.g(java.lang.Object, Z3.e):java.lang.Object");
                }
            }

            public b(InterfaceC1193b interfaceC1193b) {
                this.f3734a = interfaceC1193b;
            }

            @Override // v4.InterfaceC1193b
            public Object a(InterfaceC1194c interfaceC1194c, Z3.e eVar) {
                Object objA = this.f3734a.a(new a(interfaceC1194c), eVar);
                return objA == C0428b.e() ? objA : v.f5542a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(m<T> mVar, Z3.e<? super g> eVar) {
            super(2, eVar);
            this.f3730c = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            g gVar = new g(this.f3730c, eVar);
            gVar.f3729b = obj;
            return gVar;
        }

        @Override // i4.p
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC1194c<? super T> interfaceC1194c, Z3.e<? super v> eVar) {
            return ((g) create(interfaceC1194c, eVar)).invokeSuspend(v.f5542a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = C0428b.e();
            int i5 = this.f3728a;
            if (i5 == 0) {
                V3.o.b(obj);
                InterfaceC1194c interfaceC1194c = (InterfaceC1194c) this.f3729b;
                L.n nVar = (L.n) ((m) this.f3730c).f3714h.getValue();
                if (!(nVar instanceof L.c)) {
                    ((m) this.f3730c).f3716j.e(new b.a(nVar));
                }
                b bVar = new b(v4.d.a(((m) this.f3730c).f3714h, new a(nVar, null)));
                this.f3728a = 1;
                if (v4.d.b(interfaceC1194c, bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                V3.o.b(obj);
            }
            return v.f5542a;
        }
    }

    static final class h extends j4.l implements InterfaceC0761a<File> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m<T> f3739a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(m<T> mVar) {
            super(0);
            this.f3739a = mVar;
        }

        @Override // i4.InterfaceC0761a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            File file = (File) ((m) this.f3739a).f3707a.invoke();
            String absolutePath = file.getAbsolutePath();
            a aVar = m.f3704k;
            synchronized (aVar.b()) {
                if (aVar.a().contains(absolutePath)) {
                    throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                }
                Set<String> setA = aVar.a();
                j4.k.f(absolutePath, "it");
                setA.add(absolutePath);
            }
            return file;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {276, 281, 284}, m = "handleUpdate")
    static final class i extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f3740a;

        /* renamed from: b, reason: collision with root package name */
        Object f3741b;

        /* renamed from: c, reason: collision with root package name */
        Object f3742c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f3743d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m<T> f3744e;

        /* renamed from: f, reason: collision with root package name */
        int f3745f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(m<T> mVar, Z3.e<? super i> eVar) {
            super(eVar);
            this.f3744e = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f3743d = obj;
            this.f3745f |= Integer.MIN_VALUE;
            return this.f3744e.t(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {322, 348, 505}, m = "readAndInit")
    static final class j extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f3746a;

        /* renamed from: b, reason: collision with root package name */
        Object f3747b;

        /* renamed from: c, reason: collision with root package name */
        Object f3748c;

        /* renamed from: d, reason: collision with root package name */
        Object f3749d;

        /* renamed from: e, reason: collision with root package name */
        Object f3750e;

        /* renamed from: f, reason: collision with root package name */
        Object f3751f;

        /* renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f3752g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ m<T> f3753h;

        /* renamed from: i, reason: collision with root package name */
        int f3754i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(m<T> mVar, Z3.e<? super j> eVar) {
            super(eVar);
            this.f3753h = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f3752g = obj;
            this.f3754i |= Integer.MIN_VALUE;
            return this.f3753h.u(this);
        }
    }

    public static final class k implements L.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ B4.a f3755a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ s f3756b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j4.v<T> f3757c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ m<T> f3758d;

        @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", f = "SingleProcessDataStore.kt", l = {503, 337, CategoryEntity.OFFICE}, m = "updateData")
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a, reason: collision with root package name */
            Object f3759a;

            /* renamed from: b, reason: collision with root package name */
            Object f3760b;

            /* renamed from: c, reason: collision with root package name */
            Object f3761c;

            /* renamed from: d, reason: collision with root package name */
            Object f3762d;

            /* renamed from: e, reason: collision with root package name */
            Object f3763e;

            /* renamed from: f, reason: collision with root package name */
            /* synthetic */ Object f3764f;

            /* renamed from: h, reason: collision with root package name */
            int f3766h;

            a(Z3.e<? super a> eVar) {
                super(eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.f3764f = obj;
                this.f3766h |= Integer.MIN_VALUE;
                return k.this.b(null, this);
            }
        }

        k(B4.a aVar, s sVar, j4.v<T> vVar, m<T> mVar) {
            this.f3755a = aVar;
            this.f3756b = sVar;
            this.f3757c = vVar;
            this.f3758d = mVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00b8 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #1 {all -> 0x0056, blocks: (B:21:0x0052, B:35:0x00b0, B:37:0x00b8), top: B:53:0x0052 }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // L.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(i4.p<? super T, ? super Z3.e<? super T>, ? extends java.lang.Object> r9, Z3.e<? super T> r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 226
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: L.m.k.b(i4.p, Z3.e):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {302}, m = "readAndInitOrPropagateAndThrowFailure")
    static final class l extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f3767a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f3768b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ m<T> f3769c;

        /* renamed from: d, reason: collision with root package name */
        int f3770d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(m<T> mVar, Z3.e<? super l> eVar) {
            super(eVar);
            this.f3769c = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f3768b = obj;
            this.f3770d |= Integer.MIN_VALUE;
            return this.f3769c.v(this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {311}, m = "readAndInitOrPropagateFailure")
    /* renamed from: L.m$m, reason: collision with other inner class name */
    static final class C0055m extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f3771a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f3772b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ m<T> f3773c;

        /* renamed from: d, reason: collision with root package name */
        int f3774d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0055m(m<T> mVar, Z3.e<? super C0055m> eVar) {
            super(eVar);
            this.f3773c = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f3772b = obj;
            this.f3774d |= Integer.MIN_VALUE;
            return this.f3773c.w(this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {381}, m = "readData")
    static final class n extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f3775a;

        /* renamed from: b, reason: collision with root package name */
        Object f3776b;

        /* renamed from: c, reason: collision with root package name */
        Object f3777c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f3778d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m<T> f3779e;

        /* renamed from: f, reason: collision with root package name */
        int f3780f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(m<T> mVar, Z3.e<? super n> eVar) {
            super(eVar);
            this.f3779e = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f3778d = obj;
            this.f3780f |= Integer.MIN_VALUE;
            return this.f3779e.x(this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {359, 362, 365}, m = "readDataOrHandleCorruption")
    static final class o extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f3781a;

        /* renamed from: b, reason: collision with root package name */
        Object f3782b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f3783c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ m<T> f3784d;

        /* renamed from: e, reason: collision with root package name */
        int f3785e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(m<T> mVar, Z3.e<? super o> eVar) {
            super(eVar);
            this.f3784d = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f3783c = obj;
            this.f3785e |= Integer.MIN_VALUE;
            return this.f3784d.y(this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {402, 410}, m = "transformAndWrite")
    static final class p extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f3786a;

        /* renamed from: b, reason: collision with root package name */
        Object f3787b;

        /* renamed from: c, reason: collision with root package name */
        Object f3788c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f3789d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m<T> f3790e;

        /* renamed from: f, reason: collision with root package name */
        int f3791f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(m<T> mVar, Z3.e<? super p> eVar) {
            super(eVar);
            this.f3790e = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f3789d = obj;
            this.f3791f |= Integer.MIN_VALUE;
            return this.f3790e.z(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", l = {402}, m = "invokeSuspend")
    static final class q extends kotlin.coroutines.jvm.internal.l implements i4.p<I, Z3.e<? super T>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f3792a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i4.p<T, Z3.e<? super T>, Object> f3793b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ T f3794c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        q(i4.p<? super T, ? super Z3.e<? super T>, ? extends Object> pVar, T t5, Z3.e<? super q> eVar) {
            super(2, eVar);
            this.f3793b = pVar;
            this.f3794c = t5;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new q(this.f3793b, this.f3794c, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = C0428b.e();
            int i5 = this.f3792a;
            if (i5 != 0) {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                V3.o.b(obj);
                return obj;
            }
            V3.o.b(obj);
            i4.p<T, Z3.e<? super T>, Object> pVar = this.f3793b;
            T t5 = this.f3794c;
            this.f3792a = 1;
            Object objInvoke = pVar.invoke(t5, this);
            return objInvoke == objE ? objE : objInvoke;
        }

        @Override // i4.p
        public final Object invoke(I i5, Z3.e<? super T> eVar) {
            return ((q) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {426}, m = "writeData$datastore_core")
    static final class r extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f3795a;

        /* renamed from: b, reason: collision with root package name */
        Object f3796b;

        /* renamed from: c, reason: collision with root package name */
        Object f3797c;

        /* renamed from: d, reason: collision with root package name */
        Object f3798d;

        /* renamed from: e, reason: collision with root package name */
        Object f3799e;

        /* renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f3800f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ m<T> f3801g;

        /* renamed from: h, reason: collision with root package name */
        int f3802h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(m<T> mVar, Z3.e<? super r> eVar) {
            super(eVar);
            this.f3801g = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f3800f = obj;
            this.f3802h |= Integer.MIN_VALUE;
            return this.f3801g.A(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(InterfaceC0761a<? extends File> interfaceC0761a, L.k<T> kVar, List<? extends i4.p<? super L.i<T>, ? super Z3.e<? super v>, ? extends Object>> list, L.b<T> bVar, I i5) {
        j4.k.g(interfaceC0761a, "produceFile");
        j4.k.g(kVar, "serializer");
        j4.k.g(list, "initTasksList");
        j4.k.g(bVar, "corruptionHandler");
        j4.k.g(i5, "scope");
        this.f3707a = interfaceC0761a;
        this.f3708b = kVar;
        this.f3709c = bVar;
        this.f3710d = i5;
        this.f3711e = v4.d.e(new g(this, null));
        this.f3712f = ".tmp";
        this.f3713g = V3.g.b(new h(this));
        this.f3714h = v4.m.a(L.o.f3803a);
        this.f3715i = C0403n.U(list);
        this.f3716j = new L.l<>(i5, new d(this), e.f3724a, new f(this, null));
    }

    private final void q(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException(j4.k.m("Unable to create parent directories of ", file));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File r() {
        return (File) this.f3713g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(b.a<T> aVar, Z3.e<? super v> eVar) {
        L.n<T> value = this.f3714h.getValue();
        if (!(value instanceof L.c)) {
            if (value instanceof L.j) {
                if (value == aVar.a()) {
                    Object objW = w(eVar);
                    return objW == C0428b.e() ? objW : v.f5542a;
                }
            } else {
                if (j4.k.b(value, L.o.f3803a)) {
                    Object objW2 = w(eVar);
                    return objW2 == C0428b.e() ? objW2 : v.f5542a;
                }
                if (value instanceof L.h) {
                    throw new IllegalStateException("Can't read in final state.");
                }
            }
        }
        return v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b9, code lost:
    
        if (r8 == r1) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v0, types: [L.m, L.m<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [L.m] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(L.m.b.C0053b<T> r9, Z3.e<? super V3.v> r10) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L.m.t(L.m$b$b, Z3.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(Z3.e<? super V3.v> r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L.m.u(Z3.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(Z3.e<? super V3.v> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof L.m.l
            if (r0 == 0) goto L13
            r0 = r5
            L.m$l r0 = (L.m.l) r0
            int r1 = r0.f3770d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3770d = r1
            goto L18
        L13:
            L.m$l r0 = new L.m$l
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f3768b
            java.lang.Object r1 = a4.C0428b.e()
            int r2 = r0.f3770d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f3767a
            L.m r4 = (L.m) r4
            V3.o.b(r5)     // Catch: java.lang.Throwable -> L2d
            goto L45
        L2d:
            r5 = move-exception
            goto L48
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            V3.o.b(r5)
            r0.f3767a = r4     // Catch: java.lang.Throwable -> L2d
            r0.f3770d = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r4 = r4.u(r0)     // Catch: java.lang.Throwable -> L2d
            if (r4 != r1) goto L45
            return r1
        L45:
            V3.v r4 = V3.v.f5542a
            return r4
        L48:
            v4.j<L.n<T>> r4 = r4.f3714h
            L.j r0 = new L.j
            r0.<init>(r5)
            r4.setValue(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: L.m.v(Z3.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v0, types: [L.m, L.m<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [L.m] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(Z3.e<? super V3.v> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof L.m.C0055m
            if (r0 == 0) goto L13
            r0 = r5
            L.m$m r0 = (L.m.C0055m) r0
            int r1 = r0.f3774d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3774d = r1
            goto L18
        L13:
            L.m$m r0 = new L.m$m
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f3772b
            java.lang.Object r1 = a4.C0428b.e()
            int r2 = r0.f3774d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f3771a
            L.m r4 = (L.m) r4
            V3.o.b(r5)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L45
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            V3.o.b(r5)
            r0.f3771a = r4     // Catch: java.lang.Throwable -> L2d
            r0.f3774d = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r4 = r4.u(r0)     // Catch: java.lang.Throwable -> L2d
            if (r4 != r1) goto L4f
            return r1
        L45:
            v4.j<L.n<T>> r4 = r4.f3714h
            L.j r0 = new L.j
            r0.<init>(r5)
            r4.setValue(r0)
        L4f:
            V3.v r4 = V3.v.f5542a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: L.m.w(Z3.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12, types: [L.m] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2, types: [L.m$n, Z3.e] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [L.m] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v2, types: [L.k, L.k<T>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(Z3.e<? super T> r6) throws java.io.IOException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof L.m.n
            if (r0 == 0) goto L13
            r0 = r6
            L.m$n r0 = (L.m.n) r0
            int r1 = r0.f3780f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3780f = r1
            goto L18
        L13:
            L.m$n r0 = new L.m$n
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f3778d
            java.lang.Object r1 = a4.C0428b.e()
            int r2 = r0.f3780f
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.f3777c
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            java.lang.Object r1 = r0.f3776b
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r0 = r0.f3775a
            L.m r0 = (L.m) r0
            V3.o.b(r6)     // Catch: java.lang.Throwable -> L35
            goto L61
        L35:
            r5 = move-exception
            goto L6c
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            V3.o.b(r6)
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L72
            java.io.File r2 = r5.r()     // Catch: java.io.FileNotFoundException -> L72
            r6.<init>(r2)     // Catch: java.io.FileNotFoundException -> L72
            L.k<T> r2 = r5.f3708b     // Catch: java.lang.Throwable -> L67
            r0.f3775a = r5     // Catch: java.lang.Throwable -> L67
            r0.f3776b = r6     // Catch: java.lang.Throwable -> L67
            r4 = 0
            r0.f3777c = r4     // Catch: java.lang.Throwable -> L67
            r0.f3780f = r3     // Catch: java.lang.Throwable -> L67
            java.lang.Object r0 = r2.b(r6, r0)     // Catch: java.lang.Throwable -> L67
            if (r0 != r1) goto L5d
            return r1
        L5d:
            r1 = r6
            r6 = r0
            r0 = r5
            r5 = r4
        L61:
            f4.C0721a.a(r1, r5)     // Catch: java.io.FileNotFoundException -> L65
            return r6
        L65:
            r5 = move-exception
            goto L75
        L67:
            r0 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
            r1 = r6
        L6c:
            throw r5     // Catch: java.lang.Throwable -> L6d
        L6d:
            r6 = move-exception
            f4.C0721a.a(r1, r5)     // Catch: java.io.FileNotFoundException -> L65
            throw r6     // Catch: java.io.FileNotFoundException -> L65
        L72:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L75:
            java.io.File r6 = r0.r()
            boolean r6 = r6.exists()
            if (r6 != 0) goto L86
            L.k<T> r5 = r0.f3708b
            java.lang.Object r5 = r5.a()
            return r5
        L86:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: L.m.x(Z3.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(Z3.e<? super T> r8) throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r8 instanceof L.m.o
            if (r0 == 0) goto L13
            r0 = r8
            L.m$o r0 = (L.m.o) r0
            int r1 = r0.f3785e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3785e = r1
            goto L18
        L13:
            L.m$o r0 = new L.m$o
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f3783c
            java.lang.Object r1 = a4.C0428b.e()
            int r2 = r0.f3785e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L55
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r7 = r0.f3782b
            java.lang.Object r0 = r0.f3781a
            L.a r0 = (L.a) r0
            V3.o.b(r8)     // Catch: java.io.IOException -> L35
            return r7
        L35:
            r7 = move-exception
            goto L88
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            java.lang.Object r7 = r0.f3782b
            L.a r7 = (L.a) r7
            java.lang.Object r2 = r0.f3781a
            L.m r2 = (L.m) r2
            V3.o.b(r8)
            goto L77
        L4b:
            java.lang.Object r7 = r0.f3781a
            L.m r7 = (L.m) r7
            V3.o.b(r8)     // Catch: L.a -> L53
            return r8
        L53:
            r8 = move-exception
            goto L64
        L55:
            V3.o.b(r8)
            r0.f3781a = r7     // Catch: L.a -> L53
            r0.f3785e = r5     // Catch: L.a -> L53
            java.lang.Object r7 = r7.x(r0)     // Catch: L.a -> L53
            if (r7 != r1) goto L63
            goto L83
        L63:
            return r7
        L64:
            L.b<T> r2 = r7.f3709c
            r0.f3781a = r7
            r0.f3782b = r8
            r0.f3785e = r4
            java.lang.Object r2 = r2.a(r8, r0)
            if (r2 != r1) goto L73
            goto L83
        L73:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L77:
            r0.f3781a = r7     // Catch: java.io.IOException -> L85
            r0.f3782b = r8     // Catch: java.io.IOException -> L85
            r0.f3785e = r3     // Catch: java.io.IOException -> L85
            java.lang.Object r7 = r2.A(r8, r0)     // Catch: java.io.IOException -> L85
            if (r7 != r1) goto L84
        L83:
            return r1
        L84:
            return r8
        L85:
            r8 = move-exception
            r0 = r7
            r7 = r8
        L88:
            V3.a.a(r0, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: L.m.y(Z3.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(i4.p<? super T, ? super Z3.e<? super T>, ? extends java.lang.Object> r8, Z3.i r9, Z3.e<? super T> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof L.m.p
            if (r0 == 0) goto L13
            r0 = r10
            L.m$p r0 = (L.m.p) r0
            int r1 = r0.f3791f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3791f = r1
            goto L18
        L13:
            L.m$p r0 = new L.m$p
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f3789d
            java.lang.Object r1 = a4.C0428b.e()
            int r2 = r0.f3791f
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 == r5) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r7 = r0.f3787b
            java.lang.Object r8 = r0.f3786a
            L.m r8 = (L.m) r8
            V3.o.b(r10)
            goto L8f
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            java.lang.Object r7 = r0.f3788c
            java.lang.Object r8 = r0.f3787b
            L.c r8 = (L.c) r8
            java.lang.Object r9 = r0.f3786a
            L.m r9 = (L.m) r9
            V3.o.b(r10)
            goto L74
        L49:
            V3.o.b(r10)
            v4.j<L.n<T>> r10 = r7.f3714h
            java.lang.Object r10 = r10.getValue()
            L.c r10 = (L.c) r10
            r10.a()
            java.lang.Object r2 = r10.b()
            L.m$q r6 = new L.m$q
            r6.<init>(r8, r2, r3)
            r0.f3786a = r7
            r0.f3787b = r10
            r0.f3788c = r2
            r0.f3791f = r5
            java.lang.Object r8 = s4.C1072g.e(r9, r6, r0)
            if (r8 != r1) goto L6f
            goto L8c
        L6f:
            r9 = r10
            r10 = r8
            r8 = r9
            r9 = r7
            r7 = r2
        L74:
            r8.a()
            boolean r8 = j4.k.b(r7, r10)
            if (r8 == 0) goto L7e
            return r7
        L7e:
            r0.f3786a = r9
            r0.f3787b = r10
            r0.f3788c = r3
            r0.f3791f = r4
            java.lang.Object r7 = r9.A(r10, r0)
            if (r7 != r1) goto L8d
        L8c:
            return r1
        L8d:
            r8 = r9
            r7 = r10
        L8f:
            v4.j<L.n<T>> r8 = r8.f3714h
            L.c r9 = new L.c
            if (r7 == 0) goto L9a
            int r10 = r7.hashCode()
            goto L9b
        L9a:
            r10 = 0
        L9b:
            r9.<init>(r7, r10)
            r8.setValue(r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: L.m.z(i4.p, Z3.i, Z3.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(T r8, Z3.e<? super V3.v> r9) throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r9 instanceof L.m.r
            if (r0 == 0) goto L13
            r0 = r9
            L.m$r r0 = (L.m.r) r0
            int r1 = r0.f3802h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3802h = r1
            goto L18
        L13:
            L.m$r r0 = new L.m$r
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f3800f
            java.lang.Object r1 = a4.C0428b.e()
            int r2 = r0.f3802h
            r3 = 1
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r7 = r0.f3799e
            java.io.FileOutputStream r7 = (java.io.FileOutputStream) r7
            java.lang.Object r8 = r0.f3798d
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            java.lang.Object r1 = r0.f3797c
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r2 = r0.f3796b
            java.io.File r2 = (java.io.File) r2
            java.lang.Object r0 = r0.f3795a
            L.m r0 = (L.m) r0
            V3.o.b(r9)     // Catch: java.lang.Throwable -> L3d
            goto L89
        L3d:
            r7 = move-exception
            goto Lc2
        L40:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L48:
            V3.o.b(r9)
            java.io.File r9 = r7.r()
            r7.q(r9)
            java.io.File r2 = new java.io.File
            java.io.File r9 = r7.r()
            java.lang.String r9 = r9.getAbsolutePath()
            java.lang.String r4 = r7.f3712f
            java.lang.String r9 = j4.k.m(r9, r4)
            r2.<init>(r9)
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch: java.io.IOException -> Lbe
            r9.<init>(r2)     // Catch: java.io.IOException -> Lbe
            L.k<T> r4 = r7.f3708b     // Catch: java.lang.Throwable -> Lc0
            L.m$c r5 = new L.m$c     // Catch: java.lang.Throwable -> Lc0
            r5.<init>(r9)     // Catch: java.lang.Throwable -> Lc0
            r0.f3795a = r7     // Catch: java.lang.Throwable -> Lc0
            r0.f3796b = r2     // Catch: java.lang.Throwable -> Lc0
            r0.f3797c = r9     // Catch: java.lang.Throwable -> Lc0
            r6 = 0
            r0.f3798d = r6     // Catch: java.lang.Throwable -> Lc0
            r0.f3799e = r9     // Catch: java.lang.Throwable -> Lc0
            r0.f3802h = r3     // Catch: java.lang.Throwable -> Lc0
            java.lang.Object r8 = r4.c(r8, r5, r0)     // Catch: java.lang.Throwable -> Lc0
            if (r8 != r1) goto L85
            return r1
        L85:
            r0 = r7
            r7 = r9
            r1 = r7
            r8 = r6
        L89:
            java.io.FileDescriptor r7 = r7.getFD()     // Catch: java.lang.Throwable -> L3d
            r7.sync()     // Catch: java.lang.Throwable -> L3d
            V3.v r7 = V3.v.f5542a     // Catch: java.lang.Throwable -> L3d
            f4.C0721a.a(r1, r8)     // Catch: java.io.IOException -> Lbe
            java.io.File r7 = r0.r()     // Catch: java.io.IOException -> Lbe
            boolean r7 = r2.renameTo(r7)     // Catch: java.io.IOException -> Lbe
            if (r7 == 0) goto La2
            V3.v r7 = V3.v.f5542a
            return r7
        La2:
            java.io.IOException r7 = new java.io.IOException     // Catch: java.io.IOException -> Lbe
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lbe
            r8.<init>()     // Catch: java.io.IOException -> Lbe
            java.lang.String r9 = "Unable to rename "
            r8.append(r9)     // Catch: java.io.IOException -> Lbe
            r8.append(r2)     // Catch: java.io.IOException -> Lbe
            java.lang.String r9 = ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r8.append(r9)     // Catch: java.io.IOException -> Lbe
            java.lang.String r8 = r8.toString()     // Catch: java.io.IOException -> Lbe
            r7.<init>(r8)     // Catch: java.io.IOException -> Lbe
            throw r7     // Catch: java.io.IOException -> Lbe
        Lbe:
            r7 = move-exception
            goto Lc8
        Lc0:
            r7 = move-exception
            r1 = r9
        Lc2:
            throw r7     // Catch: java.lang.Throwable -> Lc3
        Lc3:
            r8 = move-exception
            f4.C0721a.a(r1, r7)     // Catch: java.io.IOException -> Lbe
            throw r8     // Catch: java.io.IOException -> Lbe
        Lc8:
            boolean r8 = r2.exists()
            if (r8 == 0) goto Ld1
            r2.delete()
        Ld1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: L.m.A(java.lang.Object, Z3.e):java.lang.Object");
    }

    @Override // L.f
    public InterfaceC1193b<T> a() {
        return this.f3711e;
    }

    @Override // L.f
    public Object b(i4.p<? super T, ? super Z3.e<? super T>, ? extends Object> pVar, Z3.e<? super T> eVar) throws Throwable {
        InterfaceC1091t interfaceC1091tB = C1093v.b(null, 1, null);
        this.f3716j.e(new b.C0053b(pVar, interfaceC1091tB, this.f3714h.getValue(), eVar.getContext()));
        return interfaceC1091tB.T(eVar);
    }
}
