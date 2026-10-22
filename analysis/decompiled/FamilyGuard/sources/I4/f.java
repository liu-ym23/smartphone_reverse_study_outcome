package I4;

import I4.h;
import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class f implements Closeable {

    /* renamed from: z, reason: collision with root package name */
    private static final ExecutorService f3021z = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), D4.e.H("OkHttp Http2Connection", true));

    /* renamed from: a, reason: collision with root package name */
    final boolean f3022a;

    /* renamed from: b, reason: collision with root package name */
    final j f3023b;

    /* renamed from: d, reason: collision with root package name */
    final String f3025d;

    /* renamed from: e, reason: collision with root package name */
    int f3026e;

    /* renamed from: f, reason: collision with root package name */
    int f3027f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3028g;

    /* renamed from: h, reason: collision with root package name */
    private final ScheduledExecutorService f3029h;

    /* renamed from: i, reason: collision with root package name */
    private final ExecutorService f3030i;

    /* renamed from: j, reason: collision with root package name */
    final I4.l f3031j;

    /* renamed from: s, reason: collision with root package name */
    long f3040s;

    /* renamed from: u, reason: collision with root package name */
    final m f3042u;

    /* renamed from: v, reason: collision with root package name */
    final Socket f3043v;

    /* renamed from: w, reason: collision with root package name */
    final I4.j f3044w;

    /* renamed from: x, reason: collision with root package name */
    final l f3045x;

    /* renamed from: y, reason: collision with root package name */
    final Set<Integer> f3046y;

    /* renamed from: c, reason: collision with root package name */
    final Map<Integer, I4.i> f3024c = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name */
    private long f3032k = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f3033l = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f3034m = 0;

    /* renamed from: n, reason: collision with root package name */
    private long f3035n = 0;

    /* renamed from: o, reason: collision with root package name */
    private long f3036o = 0;

    /* renamed from: p, reason: collision with root package name */
    private long f3037p = 0;

    /* renamed from: q, reason: collision with root package name */
    private long f3038q = 0;

    /* renamed from: r, reason: collision with root package name */
    long f3039r = 0;

    /* renamed from: t, reason: collision with root package name */
    m f3041t = new m();

    class a extends D4.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3047b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ I4.b f3048c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i5, I4.b bVar) {
            super(str, objArr);
            this.f3047b = i5;
            this.f3048c = bVar;
        }

        @Override // D4.b
        public void k() throws IOException {
            try {
                f.this.n0(this.f3047b, this.f3048c);
            } catch (IOException e6) {
                f.this.D(e6);
            }
        }
    }

    class b extends D4.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3050b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f3051c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i5, long j5) {
            super(str, objArr);
            this.f3050b = i5;
            this.f3051c = j5;
        }

        @Override // D4.b
        public void k() throws IOException {
            try {
                f.this.f3044w.D(this.f3050b, this.f3051c);
            } catch (IOException e6) {
                f.this.D(e6);
            }
        }
    }

    class c extends D4.b {
        c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // D4.b
        public void k() throws IOException {
            f.this.m0(false, 2, 0);
        }
    }

    class d extends D4.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3054b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f3055c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i5, List list) {
            super(str, objArr);
            this.f3054b = i5;
            this.f3055c = list;
        }

        @Override // D4.b
        public void k() {
            if (f.this.f3031j.a(this.f3054b, this.f3055c)) {
                try {
                    f.this.f3044w.A(this.f3054b, I4.b.CANCEL);
                    synchronized (f.this) {
                        f.this.f3046y.remove(Integer.valueOf(this.f3054b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    class e extends D4.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3057b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f3058c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f3059d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i5, List list, boolean z5) {
            super(str, objArr);
            this.f3057b = i5;
            this.f3058c = list;
            this.f3059d = z5;
        }

        @Override // D4.b
        public void k() {
            boolean zB = f.this.f3031j.b(this.f3057b, this.f3058c, this.f3059d);
            if (zB) {
                try {
                    f.this.f3044w.A(this.f3057b, I4.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (zB || this.f3059d) {
                synchronized (f.this) {
                    f.this.f3046y.remove(Integer.valueOf(this.f3057b));
                }
            }
        }
    }

    /* renamed from: I4.f$f, reason: collision with other inner class name */
    class C0039f extends D4.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3061b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ L4.e f3062c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f3063d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f3064e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0039f(String str, Object[] objArr, int i5, L4.e eVar, int i6, boolean z5) {
            super(str, objArr);
            this.f3061b = i5;
            this.f3062c = eVar;
            this.f3063d = i6;
            this.f3064e = z5;
        }

        @Override // D4.b
        public void k() {
            try {
                boolean zC = f.this.f3031j.c(this.f3061b, this.f3062c, this.f3063d, this.f3064e);
                if (zC) {
                    f.this.f3044w.A(this.f3061b, I4.b.CANCEL);
                }
                if (zC || this.f3064e) {
                    synchronized (f.this) {
                        f.this.f3046y.remove(Integer.valueOf(this.f3061b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    class g extends D4.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3066b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ I4.b f3067c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, Object[] objArr, int i5, I4.b bVar) {
            super(str, objArr);
            this.f3066b = i5;
            this.f3067c = bVar;
        }

        @Override // D4.b
        public void k() {
            f.this.f3031j.d(this.f3066b, this.f3067c);
            synchronized (f.this) {
                f.this.f3046y.remove(Integer.valueOf(this.f3066b));
            }
        }
    }

    public static class h {

        /* renamed from: a, reason: collision with root package name */
        Socket f3069a;

        /* renamed from: b, reason: collision with root package name */
        String f3070b;

        /* renamed from: c, reason: collision with root package name */
        L4.g f3071c;

        /* renamed from: d, reason: collision with root package name */
        L4.f f3072d;

        /* renamed from: e, reason: collision with root package name */
        j f3073e = j.f3078a;

        /* renamed from: f, reason: collision with root package name */
        I4.l f3074f = I4.l.f3149a;

        /* renamed from: g, reason: collision with root package name */
        boolean f3075g;

        /* renamed from: h, reason: collision with root package name */
        int f3076h;

        public h(boolean z5) {
            this.f3075g = z5;
        }

        public f a() {
            return new f(this);
        }

        public h b(j jVar) {
            this.f3073e = jVar;
            return this;
        }

        public h c(int i5) {
            this.f3076h = i5;
            return this;
        }

        public h d(Socket socket, String str, L4.g gVar, L4.f fVar) {
            this.f3069a = socket;
            this.f3070b = str;
            this.f3071c = gVar;
            this.f3072d = fVar;
            return this;
        }
    }

    final class i extends D4.b {
        i() {
            super("OkHttp %s ping", f.this.f3025d);
        }

        @Override // D4.b
        public void k() throws IOException {
            boolean z5;
            synchronized (f.this) {
                if (f.this.f3033l < f.this.f3032k) {
                    z5 = true;
                } else {
                    f.o(f.this);
                    z5 = false;
                }
            }
            if (z5) {
                f.this.D(null);
            } else {
                f.this.m0(false, 1, 0);
            }
        }
    }

    public static abstract class j {

        /* renamed from: a, reason: collision with root package name */
        public static final j f3078a = new a();

        class a extends j {
            a() {
            }

            @Override // I4.f.j
            public void b(I4.i iVar) {
                iVar.d(I4.b.REFUSED_STREAM, null);
            }
        }

        public void a(f fVar) {
        }

        public abstract void b(I4.i iVar);
    }

    final class k extends D4.b {

        /* renamed from: b, reason: collision with root package name */
        final boolean f3079b;

        /* renamed from: c, reason: collision with root package name */
        final int f3080c;

        /* renamed from: d, reason: collision with root package name */
        final int f3081d;

        k(boolean z5, int i5, int i6) {
            super("OkHttp %s ping %08x%08x", f.this.f3025d, Integer.valueOf(i5), Integer.valueOf(i6));
            this.f3079b = z5;
            this.f3080c = i5;
            this.f3081d = i6;
        }

        @Override // D4.b
        public void k() throws IOException {
            f.this.m0(this.f3079b, this.f3080c, this.f3081d);
        }
    }

    class l extends D4.b implements h.b {

        /* renamed from: b, reason: collision with root package name */
        final I4.h f3083b;

        class a extends D4.b {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ I4.i f3085b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, I4.i iVar) {
                super(str, objArr);
                this.f3085b = iVar;
            }

            @Override // D4.b
            public void k() {
                try {
                    f.this.f3023b.b(this.f3085b);
                } catch (IOException e6) {
                    okhttp3.internal.platform.f.get().log(4, "Http2Connection.Listener failure for " + f.this.f3025d, e6);
                    try {
                        this.f3085b.d(I4.b.PROTOCOL_ERROR, e6);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        class b extends D4.b {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f3087b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ m f3088c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(String str, Object[] objArr, boolean z5, m mVar) {
                super(str, objArr);
                this.f3087b = z5;
                this.f3088c = mVar;
            }

            @Override // D4.b
            public void k() {
                l.this.l(this.f3087b, this.f3088c);
            }
        }

        class c extends D4.b {
            c(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // D4.b
            public void k() {
                f fVar = f.this;
                fVar.f3023b.a(fVar);
            }
        }

        l(I4.h hVar) {
            super("OkHttp %s", f.this.f3025d);
            this.f3083b = hVar;
        }

        @Override // I4.h.b
        public void a(int i5, I4.b bVar) {
            if (f.this.W(i5)) {
                f.this.V(i5, bVar);
                return;
            }
            I4.i iVarX = f.this.X(i5);
            if (iVarX != null) {
                iVarX.o(bVar);
            }
        }

        @Override // I4.h.b
        public void b() {
        }

        @Override // I4.h.b
        public void c(boolean z5, int i5, L4.g gVar, int i6) throws IOException {
            if (f.this.W(i5)) {
                f.this.O(i5, gVar, i6, z5);
                return;
            }
            I4.i iVarE = f.this.E(i5);
            if (iVarE == null) {
                f.this.o0(i5, I4.b.PROTOCOL_ERROR);
                long j5 = i6;
                f.this.j0(j5);
                gVar.skip(j5);
                return;
            }
            iVarE.m(gVar, i6);
            if (z5) {
                iVarE.n(D4.e.f1208c, true);
            }
        }

        @Override // I4.h.b
        public void d(int i5, I4.b bVar, L4.h hVar) {
            I4.i[] iVarArr;
            hVar.w();
            synchronized (f.this) {
                iVarArr = (I4.i[]) f.this.f3024c.values().toArray(new I4.i[f.this.f3024c.size()]);
                f.this.f3028g = true;
            }
            for (I4.i iVar : iVarArr) {
                if (iVar.g() > i5 && iVar.j()) {
                    iVar.o(I4.b.REFUSED_STREAM);
                    f.this.X(iVar.g());
                }
            }
        }

        @Override // I4.h.b
        public void e(boolean z5, int i5, int i6, List<I4.c> list) {
            if (f.this.W(i5)) {
                f.this.T(i5, list, z5);
                return;
            }
            synchronized (f.this) {
                try {
                    I4.i iVarE = f.this.E(i5);
                    if (iVarE != null) {
                        iVarE.n(D4.e.J(list), z5);
                        return;
                    }
                    if (f.this.f3028g) {
                        return;
                    }
                    f fVar = f.this;
                    if (i5 <= fVar.f3026e) {
                        return;
                    }
                    if (i5 % 2 == fVar.f3027f % 2) {
                        return;
                    }
                    I4.i iVar = new I4.i(i5, f.this, false, z5, D4.e.J(list));
                    f fVar2 = f.this;
                    fVar2.f3026e = i5;
                    fVar2.f3024c.put(Integer.valueOf(i5), iVar);
                    f.f3021z.execute(new a("OkHttp %s stream %d", new Object[]{f.this.f3025d, Integer.valueOf(i5)}, iVar));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // I4.h.b
        public void f(int i5, long j5) {
            if (i5 == 0) {
                synchronized (f.this) {
                    f fVar = f.this;
                    fVar.f3040s += j5;
                    fVar.notifyAll();
                }
                return;
            }
            I4.i iVarE = f.this.E(i5);
            if (iVarE != null) {
                synchronized (iVarE) {
                    iVarE.a(j5);
                }
            }
        }

        @Override // I4.h.b
        public void g(boolean z5, m mVar) {
            try {
                f.this.f3029h.execute(new b("OkHttp %s ACK Settings", new Object[]{f.this.f3025d}, z5, mVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // I4.h.b
        public void h(boolean z5, int i5, int i6) {
            if (!z5) {
                try {
                    f.this.f3029h.execute(f.this.new k(true, i5, i6));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (f.this) {
                try {
                    if (i5 == 1) {
                        f.f(f.this);
                    } else if (i5 == 2) {
                        f.x(f.this);
                    } else if (i5 == 3) {
                        f.A(f.this);
                        f.this.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // I4.h.b
        public void i(int i5, int i6, int i7, boolean z5) {
        }

        @Override // I4.h.b
        public void j(int i5, int i6, List<I4.c> list) throws Throwable {
            f.this.U(i6, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4, types: [I4.h, java.io.Closeable] */
        @Override // D4.b
        protected void k() throws Throwable {
            I4.b bVar;
            I4.b bVar2 = I4.b.INTERNAL_ERROR;
            IOException e6 = null;
            try {
                try {
                    this.f3083b.f(this);
                    while (this.f3083b.c(false, this)) {
                    }
                    I4.b bVar3 = I4.b.NO_ERROR;
                    try {
                        bVar2 = I4.b.CANCEL;
                        f.this.C(bVar3, bVar2, null);
                        bVar = bVar3;
                    } catch (IOException e7) {
                        e6 = e7;
                        bVar2 = I4.b.PROTOCOL_ERROR;
                        f fVar = f.this;
                        fVar.C(bVar2, bVar2, e6);
                        bVar = fVar;
                        this = this.f3083b;
                        D4.e.g(this);
                    }
                } catch (Throwable th) {
                    th = th;
                    f.this.C(bVar, bVar2, e6);
                    D4.e.g(this.f3083b);
                    throw th;
                }
            } catch (IOException e8) {
                e6 = e8;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                f.this.C(bVar, bVar2, e6);
                D4.e.g(this.f3083b);
                throw th;
            }
            this = this.f3083b;
            D4.e.g(this);
        }

        void l(boolean z5, m mVar) {
            I4.i[] iVarArr;
            long j5;
            synchronized (f.this.f3044w) {
                synchronized (f.this) {
                    try {
                        int iD = f.this.f3042u.d();
                        if (z5) {
                            f.this.f3042u.a();
                        }
                        f.this.f3042u.h(mVar);
                        int iD2 = f.this.f3042u.d();
                        iVarArr = null;
                        if (iD2 == -1 || iD2 == iD) {
                            j5 = 0;
                        } else {
                            j5 = iD2 - iD;
                            if (!f.this.f3024c.isEmpty()) {
                                iVarArr = (I4.i[]) f.this.f3024c.values().toArray(new I4.i[f.this.f3024c.size()]);
                            }
                        }
                    } finally {
                    }
                }
                try {
                    f fVar = f.this;
                    fVar.f3044w.a(fVar.f3042u);
                } catch (IOException e6) {
                    f.this.D(e6);
                }
            }
            if (iVarArr != null) {
                for (I4.i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(j5);
                    }
                }
            }
            f.f3021z.execute(new c("OkHttp %s settings", f.this.f3025d));
        }
    }

    f(h hVar) {
        m mVar = new m();
        this.f3042u = mVar;
        this.f3046y = new LinkedHashSet();
        this.f3031j = hVar.f3074f;
        boolean z5 = hVar.f3075g;
        this.f3022a = z5;
        this.f3023b = hVar.f3073e;
        int i5 = z5 ? 1 : 2;
        this.f3027f = i5;
        if (z5) {
            this.f3027f = i5 + 2;
        }
        if (z5) {
            this.f3041t.i(7, 16777216);
        }
        String str = hVar.f3070b;
        this.f3025d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, D4.e.H(D4.e.q("OkHttp %s Writer", str), false));
        this.f3029h = scheduledThreadPoolExecutor;
        if (hVar.f3076h != 0) {
            i iVar = new i();
            int i6 = hVar.f3076h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, i6, i6, TimeUnit.MILLISECONDS);
        }
        this.f3030i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), D4.e.H(D4.e.q("OkHttp %s Push Observer", str), true));
        mVar.i(7, ExifInterface.COLOR_SPACE_UNCALIBRATED);
        mVar.i(5, 16384);
        this.f3040s = mVar.d();
        this.f3043v = hVar.f3069a;
        this.f3044w = new I4.j(hVar.f3072d, z5);
        this.f3045x = new l(new I4.h(hVar.f3071c, z5));
    }

    static /* synthetic */ long A(f fVar) {
        long j5 = fVar.f3037p;
        fVar.f3037p = 1 + j5;
        return j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(@Nullable IOException iOException) throws IOException {
        I4.b bVar = I4.b.PROTOCOL_ERROR;
        C(bVar, bVar, iOException);
    }

    private I4.i L(int i5, List<I4.c> list, boolean z5) {
        Throwable th;
        f fVar;
        int i6;
        I4.i iVar;
        boolean z6;
        boolean z7 = !z5;
        synchronized (this.f3044w) {
            try {
                try {
                    synchronized (this) {
                        try {
                            if (this.f3027f > 1073741823) {
                                try {
                                    c0(I4.b.REFUSED_STREAM);
                                } catch (Throwable th2) {
                                    th = th2;
                                    fVar = this;
                                    throw th;
                                }
                            }
                            if (this.f3028g) {
                                throw new I4.a();
                            }
                            i6 = this.f3027f;
                            this.f3027f = i6 + 2;
                            iVar = new I4.i(i6, this, z7, false, null);
                            z6 = !z5 || this.f3040s == 0 || iVar.f3111b == 0;
                            if (iVar.k()) {
                                this.f3024c.put(Integer.valueOf(i6), iVar);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fVar = this;
                            th = th;
                            throw th;
                        }
                    }
                    if (i5 == 0) {
                        this.f3044w.u(z7, i6, list);
                    } else {
                        if (this.f3022a) {
                            throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                        }
                        this.f3044w.x(i5, i6, list);
                    }
                } finally {
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        if (z6) {
            this.f3044w.flush();
        }
        return iVar;
    }

    private synchronized void S(D4.b bVar) {
        if (!this.f3028g) {
            this.f3030i.execute(bVar);
        }
    }

    static /* synthetic */ long f(f fVar) {
        long j5 = fVar.f3033l;
        fVar.f3033l = 1 + j5;
        return j5;
    }

    static /* synthetic */ long o(f fVar) {
        long j5 = fVar.f3032k;
        fVar.f3032k = 1 + j5;
        return j5;
    }

    static /* synthetic */ long x(f fVar) {
        long j5 = fVar.f3035n;
        fVar.f3035n = 1 + j5;
        return j5;
    }

    void C(I4.b bVar, I4.b bVar2, @Nullable IOException iOException) throws IOException {
        I4.i[] iVarArr;
        try {
            c0(bVar);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.f3024c.isEmpty()) {
                    iVarArr = null;
                } else {
                    iVarArr = (I4.i[]) this.f3024c.values().toArray(new I4.i[this.f3024c.size()]);
                    this.f3024c.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (iVarArr != null) {
            for (I4.i iVar : iVarArr) {
                try {
                    iVar.d(bVar2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f3044w.close();
        } catch (IOException unused3) {
        }
        try {
            this.f3043v.close();
        } catch (IOException unused4) {
        }
        this.f3029h.shutdown();
        this.f3030i.shutdown();
    }

    synchronized I4.i E(int i5) {
        return this.f3024c.get(Integer.valueOf(i5));
    }

    public synchronized boolean G(long j5) {
        if (this.f3028g) {
            return false;
        }
        if (this.f3035n < this.f3034m) {
            if (j5 >= this.f3038q) {
                return false;
            }
        }
        return true;
    }

    public synchronized int I() {
        return this.f3042u.e(Integer.MAX_VALUE);
    }

    public I4.i N(List<I4.c> list, boolean z5) {
        return L(0, list, z5);
    }

    void O(int i5, L4.g gVar, int i6, boolean z5) throws IOException {
        L4.e eVar = new L4.e();
        long j5 = i6;
        gVar.q0(j5);
        gVar.e(eVar, j5);
        if (eVar.size() == j5) {
            S(new C0039f("OkHttp %s Push Data[%s]", new Object[]{this.f3025d, Integer.valueOf(i5)}, i5, eVar, i6, z5));
            return;
        }
        throw new IOException(eVar.size() + " != " + i6);
    }

    void T(int i5, List<I4.c> list, boolean z5) {
        try {
            S(new e("OkHttp %s Push Headers[%s]", new Object[]{this.f3025d, Integer.valueOf(i5)}, i5, list, z5));
        } catch (RejectedExecutionException unused) {
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:19:0x003f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    void U(int r9, java.util.List<I4.c> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Set<java.lang.Integer> r0 = r8.f3046y     // Catch: java.lang.Throwable -> L3a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L3a
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L18
            I4.b r10 = I4.b.PROTOCOL_ERROR     // Catch: java.lang.Throwable -> L14
            r8.o0(r9, r10)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L14
            return
        L14:
            r0 = move-exception
            r9 = r0
            r3 = r8
            goto L3d
        L18:
            java.util.Set<java.lang.Integer> r0 = r8.f3046y     // Catch: java.lang.Throwable -> L3a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L3a
            r0.add(r1)     // Catch: java.lang.Throwable -> L3a
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L3a
            I4.f$d r2 = new I4.f$d     // Catch: java.util.concurrent.RejectedExecutionException -> L39
            java.lang.String r4 = "OkHttp %s Push Request[%s]"
            java.lang.String r0 = r8.f3025d     // Catch: java.util.concurrent.RejectedExecutionException -> L39
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.util.concurrent.RejectedExecutionException -> L39
            java.lang.Object[] r5 = new java.lang.Object[]{r0, r1}     // Catch: java.util.concurrent.RejectedExecutionException -> L39
            r3 = r8
            r6 = r9
            r7 = r10
            r2.<init>(r4, r5, r6, r7)     // Catch: java.util.concurrent.RejectedExecutionException -> L39
            r3.S(r2)     // Catch: java.util.concurrent.RejectedExecutionException -> L39
        L39:
            return
        L3a:
            r0 = move-exception
            r3 = r8
        L3c:
            r9 = r0
        L3d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3f
            throw r9
        L3f:
            r0 = move-exception
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: I4.f.U(int, java.util.List):void");
    }

    void V(int i5, I4.b bVar) {
        S(new g("OkHttp %s Push Reset[%s]", new Object[]{this.f3025d, Integer.valueOf(i5)}, i5, bVar));
    }

    boolean W(int i5) {
        return i5 != 0 && (i5 & 1) == 0;
    }

    synchronized I4.i X(int i5) {
        I4.i iVarRemove;
        iVarRemove = this.f3024c.remove(Integer.valueOf(i5));
        notifyAll();
        return iVarRemove;
    }

    void Y() {
        synchronized (this) {
            try {
                long j5 = this.f3035n;
                long j6 = this.f3034m;
                if (j5 < j6) {
                    return;
                }
                this.f3034m = j6 + 1;
                this.f3038q = System.nanoTime() + 1000000000;
                try {
                    this.f3029h.execute(new c("OkHttp %s ping", this.f3025d));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c0(I4.b bVar) {
        synchronized (this.f3044w) {
            synchronized (this) {
                if (this.f3028g) {
                    return;
                }
                this.f3028g = true;
                this.f3044w.r(this.f3026e, bVar, D4.e.f1206a);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        C(I4.b.NO_ERROR, I4.b.CANCEL, null);
    }

    public void d0() {
        h0(true);
    }

    public void flush() {
        this.f3044w.flush();
    }

    void h0(boolean z5) {
        if (z5) {
            this.f3044w.c();
            this.f3044w.C(this.f3041t);
            if (this.f3041t.d() != 65535) {
                this.f3044w.D(0, r5 - ExifInterface.COLOR_SPACE_UNCALIBRATED);
            }
        }
        new Thread(this.f3045x).start();
    }

    synchronized void j0(long j5) {
        long j6 = this.f3039r + j5;
        this.f3039r = j6;
        if (j6 >= this.f3041t.d() / 2) {
            p0(0, this.f3039r);
            this.f3039r = 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.f3044w.v());
        r6 = r2;
        r8.f3040s -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k0(int r9, boolean r10, L4.e r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            I4.j r8 = r8.f3044w
            r8.f(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r4 = r8.f3040s     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L32
            java.util.Map<java.lang.Integer, I4.i> r2 = r8.f3024c     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r2 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L65
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L28
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L28
            I4.j r4 = r8.f3044w     // Catch: java.lang.Throwable -> L28
            int r4 = r4.v()     // Catch: java.lang.Throwable -> L28
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.f3040s     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.f3040s = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            I4.j r4 = r8.f3044w
            if (r10 == 0) goto L53
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = r3
        L54:
            r4.f(r5, r9, r11, r2)
            goto Ld
        L58:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L28
            r9.interrupt()     // Catch: java.lang.Throwable -> L28
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: I4.f.k0(int, boolean, L4.e, long):void");
    }

    void l0(int i5, boolean z5, List<I4.c> list) {
        this.f3044w.u(z5, i5, list);
    }

    void m0(boolean z5, int i5, int i6) throws IOException {
        try {
            this.f3044w.w(z5, i5, i6);
        } catch (IOException e6) {
            D(e6);
        }
    }

    void n0(int i5, I4.b bVar) {
        this.f3044w.A(i5, bVar);
    }

    void o0(int i5, I4.b bVar) {
        try {
            this.f3029h.execute(new a("OkHttp %s stream %d", new Object[]{this.f3025d, Integer.valueOf(i5)}, i5, bVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    void p0(int i5, long j5) {
        try {
            this.f3029h.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f3025d, Integer.valueOf(i5)}, i5, j5));
        } catch (RejectedExecutionException unused) {
        }
    }
}
