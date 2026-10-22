package C4;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.libpag.BuildConfig;

/* renamed from: C4.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0274d {

    /* renamed from: n, reason: collision with root package name */
    public static final C0274d f753n = new a().c().a();

    /* renamed from: o, reason: collision with root package name */
    public static final C0274d f754o = new a().d().b(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f755a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f756b;

    /* renamed from: c, reason: collision with root package name */
    private final int f757c;

    /* renamed from: d, reason: collision with root package name */
    private final int f758d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f759e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f760f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f761g;

    /* renamed from: h, reason: collision with root package name */
    private final int f762h;

    /* renamed from: i, reason: collision with root package name */
    private final int f763i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f764j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f765k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f766l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    String f767m;

    /* renamed from: C4.d$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f768a;

        /* renamed from: b, reason: collision with root package name */
        boolean f769b;

        /* renamed from: c, reason: collision with root package name */
        int f770c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f771d = -1;

        /* renamed from: e, reason: collision with root package name */
        int f772e = -1;

        /* renamed from: f, reason: collision with root package name */
        boolean f773f;

        /* renamed from: g, reason: collision with root package name */
        boolean f774g;

        /* renamed from: h, reason: collision with root package name */
        boolean f775h;

        public C0274d a() {
            return new C0274d(this);
        }

        public a b(int i5, TimeUnit timeUnit) {
            if (i5 >= 0) {
                long seconds = timeUnit.toSeconds(i5);
                this.f771d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i5);
        }

        public a c() {
            this.f768a = true;
            return this;
        }

        public a d() {
            this.f773f = true;
            return this;
        }
    }

    private C0274d(boolean z5, boolean z6, int i5, int i6, boolean z7, boolean z8, boolean z9, int i7, int i8, boolean z10, boolean z11, boolean z12, @Nullable String str) {
        this.f755a = z5;
        this.f756b = z6;
        this.f757c = i5;
        this.f758d = i6;
        this.f759e = z7;
        this.f760f = z8;
        this.f761g = z9;
        this.f762h = i7;
        this.f763i = i8;
        this.f764j = z10;
        this.f765k = z11;
        this.f766l = z12;
        this.f767m = str;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f755a) {
            sb.append("no-cache, ");
        }
        if (this.f756b) {
            sb.append("no-store, ");
        }
        if (this.f757c != -1) {
            sb.append("max-age=");
            sb.append(this.f757c);
            sb.append(", ");
        }
        if (this.f758d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f758d);
            sb.append(", ");
        }
        if (this.f759e) {
            sb.append("private, ");
        }
        if (this.f760f) {
            sb.append("public, ");
        }
        if (this.f761g) {
            sb.append("must-revalidate, ");
        }
        if (this.f762h != -1) {
            sb.append("max-stale=");
            sb.append(this.f762h);
            sb.append(", ");
        }
        if (this.f763i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f763i);
            sb.append(", ");
        }
        if (this.f764j) {
            sb.append("only-if-cached, ");
        }
        if (this.f765k) {
            sb.append("no-transform, ");
        }
        if (this.f766l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return BuildConfig.FLAVOR;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static C4.C0274d k(C4.v r23) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: C4.C0274d.k(C4.v):C4.d");
    }

    public boolean b() {
        return this.f759e;
    }

    public boolean c() {
        return this.f760f;
    }

    public int d() {
        return this.f757c;
    }

    public int e() {
        return this.f762h;
    }

    public int f() {
        return this.f763i;
    }

    public boolean g() {
        return this.f761g;
    }

    public boolean h() {
        return this.f755a;
    }

    public boolean i() {
        return this.f756b;
    }

    public boolean j() {
        return this.f764j;
    }

    public String toString() {
        String str = this.f767m;
        if (str != null) {
            return str;
        }
        String strA = a();
        this.f767m = strA;
        return strA;
    }

    C0274d(a aVar) {
        this.f755a = aVar.f768a;
        this.f756b = aVar.f769b;
        this.f757c = aVar.f770c;
        this.f758d = -1;
        this.f759e = false;
        this.f760f = false;
        this.f761g = false;
        this.f762h = aVar.f771d;
        this.f763i = aVar.f772e;
        this.f764j = aVar.f773f;
        this.f765k = aVar.f774g;
        this.f766l = aVar.f775h;
    }
}
