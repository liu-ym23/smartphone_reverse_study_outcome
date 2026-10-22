package n4;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f22393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ThreadPoolExecutor f22394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ThreadPoolExecutor f22395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ThreadPoolExecutor f22396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f22398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f22401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f22402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f22403k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f22404l;

    public static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThreadPoolExecutor f22405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ThreadPoolExecutor f22406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ThreadPoolExecutor f22407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ThreadPoolExecutor f22408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f22409e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f22410f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f22411g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f22412h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f22413i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f22414j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f22415k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f22416l;

        public b() {
            this.f22416l = true;
        }

        public static /* synthetic */ ThreadPoolExecutor a(b r10) {
            return r10.f22406b;
        }

        public static /* synthetic */ ThreadPoolExecutor b(b r10) {
            return r10.f22405a;
        }

        public static /* synthetic */ long c(b r10) {
            return r10.f22415k;
        }

        public static /* synthetic */ boolean d(b r10) {
            return r10.f22416l;
        }

        public static /* synthetic */ ThreadPoolExecutor e(b r10) {
            return r10.f22407c;
        }

        public static /* synthetic */ ThreadPoolExecutor f(b r10) {
            return r10.f22408d;
        }

        public static /* synthetic */ int g(b r10) {
            return r10.f22409e;
        }

        public static /* synthetic */ int h(b r10) {
            return r10.f22410f;
        }

        public static /* synthetic */ int i(b r10) {
            return r10.f22411g;
        }

        public static /* synthetic */ int j(b r10) {
            return r10.f22412h;
        }

        public static /* synthetic */ long k(b r10) {
            return r10.f22413i;
        }

        public static /* synthetic */ long l(b r10) {
            return r10.f22414j;
        }

        public c m() {
            return new c(this, null);
        }

        public b n(long r10) {
            if (r10 <= 0) goto L7;
            this.f22413i = r10;
            return this;
        L7:
            throw new IllegalArgumentException("Api keep alive time must set > 0 when allow core thread timeout.");
        }

        public b o(int r10, int r11) {
            if (r11 <= 0) goto L10;
            if (r10 <= 0) goto L10;
            if (r10 > r11) goto L8;
            this.f22409e = r11;
            this.f22411g = r10;
            return this;
        L8:
            throw new IllegalArgumentException("Core thread size must set less equal than Max thread size.");
        L10:
            throw new IllegalArgumentException("Api thread size must set > 0.");
        }

        public b p(long r10) {
            if (r10 <= 0) goto L7;
            this.f22414j = r10;
            return this;
        L7:
            throw new IllegalArgumentException("Download keep alive time must set > 0 when allow core thread timeout.");
        }

        public b q(int r10, int r11) {
            if (r11 <= 0) goto L10;
            if (r10 <= 0) goto L10;
            if (r10 > r11) goto L8;
            this.f22410f = r11;
            this.f22412h = r10;
            return this;
        L8:
            throw new IllegalArgumentException("Core thread size must set less equal than Max thread size.");
        L10:
            throw new IllegalArgumentException("Download thread size must set > 0.");
        }

        public b r(boolean r10) {
            this.f22416l = r10;
            return this;
        }

        public b s(long r10) {
            if (r10 <= 0) goto L7;
            this.f22415k = r10;
            return this;
        L7:
            throw new IllegalArgumentException("Immediate keep alive time must set > 0 when allow core thread timeout.");
        }
    }

    public /* synthetic */ c(b r10, a r11) {
        this(r10);
    }

    public static b m() {
        return new b();
    }

    public long a() {
        return this.f22401i;
    }

    public int b() {
        return this.f22399g;
    }

    public int c() {
        return this.f22400h;
    }

    public long d() {
        return this.f22402j;
    }

    public ThreadPoolExecutor e() {
        return this.f22396d;
    }

    public long f() {
        return this.f22403k;
    }

    public ThreadPoolExecutor g() {
        return this.f22393a;
    }

    public ThreadPoolExecutor h() {
        return this.f22394b;
    }

    public int i() {
        return this.f22397e;
    }

    public int j() {
        return this.f22398f;
    }

    public ThreadPoolExecutor k() {
        return this.f22395c;
    }

    public boolean l() {
        return this.f22404l;
    }

    public void n(boolean r10) {
        this.f22404l = r10;
    }

    public c(b r10) {
        this.f22397e = 8;
        this.f22398f = 8;
        this.f22399g = 8;
        this.f22400h = 8;
        this.f22401i = 30;
        this.f22402j = 10;
        this.f22403k = 10;
        this.f22404l = true;
        if (b.a(r10) == null) goto L6;
        this.f22393a = b.a(r10);
    L6:
        if (b.b(r10) == null) goto L9;
        this.f22394b = b.b(r10);
    L9:
        if (b.e(r10) == null) goto L12;
        this.f22395c = b.e(r10);
    L12:
        if (b.f(r10) == null) goto L15;
        this.f22396d = b.f(r10);
    L15:
        if (b.g(r10) <= 0) goto L18;
        this.f22397e = b.g(r10);
    L18:
        if (b.h(r10) <= 0) goto L21;
        this.f22398f = b.h(r10);
    L21:
        if (b.i(r10) <= 0) goto L24;
        this.f22399g = b.i(r10);
    L24:
        if (b.j(r10) <= 0) goto L27;
        this.f22400h = b.j(r10);
    L27:
        if (b.k(r10) <= 0) goto L30;
        this.f22401i = b.k(r10);
    L30:
        if (b.l(r10) <= 0) goto L33;
        this.f22402j = b.l(r10);
    L33:
        if (b.c(r10) <= 0) goto L35;
        this.f22403k = b.c(r10);
    L35:
        this.f22404l = b.d(r10);
    }
}
