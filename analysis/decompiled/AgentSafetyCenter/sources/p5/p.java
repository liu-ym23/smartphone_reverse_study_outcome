package p5;

import androidx.recyclerview.widget.RecyclerView;
import androidx.work.OverwritingInputMerger;
import com.fasterxml.jackson.core.ErrorReportConfiguration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: y, reason: collision with root package name */
    public static final String f9762y = g5.u.f("WorkSpec");

    /* renamed from: z, reason: collision with root package name */
    public static final od.f f9763z = new od.f();

    /* renamed from: a, reason: collision with root package name */
    public final String f9764a;

    /* renamed from: b, reason: collision with root package name */
    public int f9765b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9766c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9767d;

    /* renamed from: e, reason: collision with root package name */
    public final g5.h f9768e;

    /* renamed from: f, reason: collision with root package name */
    public final g5.h f9769f;

    /* renamed from: g, reason: collision with root package name */
    public long f9770g;

    /* renamed from: h, reason: collision with root package name */
    public long f9771h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public g5.d f9772j;

    /* renamed from: k, reason: collision with root package name */
    public final int f9773k;

    /* renamed from: l, reason: collision with root package name */
    public int f9774l;

    /* renamed from: m, reason: collision with root package name */
    public long f9775m;

    /* renamed from: n, reason: collision with root package name */
    public long f9776n;

    /* renamed from: o, reason: collision with root package name */
    public final long f9777o;

    /* renamed from: p, reason: collision with root package name */
    public final long f9778p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9779q;

    /* renamed from: r, reason: collision with root package name */
    public final int f9780r;

    /* renamed from: s, reason: collision with root package name */
    public final int f9781s;

    /* renamed from: t, reason: collision with root package name */
    public final int f9782t;

    /* renamed from: u, reason: collision with root package name */
    public final long f9783u;

    /* renamed from: v, reason: collision with root package name */
    public final int f9784v;

    /* renamed from: w, reason: collision with root package name */
    public final int f9785w;

    /* renamed from: x, reason: collision with root package name */
    public String f9786x;

    public /* synthetic */ p(String str, int i, String str2, String str3, g5.h hVar, g5.h hVar2, long j10, long j11, long j12, g5.d dVar, int i3, int i10, long j13, long j14, long j15, long j16, boolean z10, int i11, int i12, long j17, int i13, int i14, String str4, int i15) {
        this(str, (i15 & 2) != 0 ? 1 : i, str2, (i15 & 8) != 0 ? OverwritingInputMerger.class.getName() : str3, (i15 & 16) != 0 ? g5.h.f4318b : hVar, (i15 & 32) != 0 ? g5.h.f4318b : hVar2, (i15 & 64) != 0 ? 0L : j10, (i15 & 128) != 0 ? 0L : j11, (i15 & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0 ? 0L : j12, (i15 & 512) != 0 ? g5.d.f4286j : dVar, (i15 & 1024) != 0 ? 0 : i3, (i15 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? 1 : i10, (i15 & 4096) != 0 ? 30000L : j13, (i15 & 8192) != 0 ? -1L : j14, (i15 & 16384) == 0 ? j15 : 0L, (32768 & i15) != 0 ? -1L : j16, (65536 & i15) != 0 ? false : z10, (131072 & i15) != 0 ? 1 : i11, (262144 & i15) != 0 ? 0 : i12, 0, (1048576 & i15) != 0 ? Long.MAX_VALUE : j17, (2097152 & i15) != 0 ? 0 : i13, (4194304 & i15) != 0 ? -256 : i14, (i15 & 8388608) != 0 ? null : str4);
    }

    public final long a() {
        return f.g(this.f9765b == 1 && this.f9773k > 0, this.f9773k, this.f9774l, this.f9775m, this.f9776n, this.f9781s, c(), this.f9770g, this.i, this.f9771h, this.f9783u);
    }

    public final boolean b() {
        return !yb.k.a(g5.d.f4286j, this.f9772j);
    }

    public final boolean c() {
        return this.f9771h != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return yb.k.a(this.f9764a, pVar.f9764a) && this.f9765b == pVar.f9765b && yb.k.a(this.f9766c, pVar.f9766c) && yb.k.a(this.f9767d, pVar.f9767d) && yb.k.a(this.f9768e, pVar.f9768e) && yb.k.a(this.f9769f, pVar.f9769f) && this.f9770g == pVar.f9770g && this.f9771h == pVar.f9771h && this.i == pVar.i && yb.k.a(this.f9772j, pVar.f9772j) && this.f9773k == pVar.f9773k && this.f9774l == pVar.f9774l && this.f9775m == pVar.f9775m && this.f9776n == pVar.f9776n && this.f9777o == pVar.f9777o && this.f9778p == pVar.f9778p && this.f9779q == pVar.f9779q && this.f9780r == pVar.f9780r && this.f9781s == pVar.f9781s && this.f9782t == pVar.f9782t && this.f9783u == pVar.f9783u && this.f9784v == pVar.f9784v && this.f9785w == pVar.f9785w && yb.k.a(this.f9786x, pVar.f9786x);
    }

    public final int hashCode() {
        int iB = s.f.b(this.f9785w, s.f.b(this.f9784v, k0.a.i(this.f9783u, s.f.b(this.f9782t, s.f.b(this.f9781s, (s.f.c(this.f9780r) + k0.a.h(k0.a.i(this.f9778p, k0.a.i(this.f9777o, k0.a.i(this.f9776n, k0.a.i(this.f9775m, (s.f.c(this.f9774l) + s.f.b(this.f9773k, (this.f9772j.hashCode() + k0.a.i(this.i, k0.a.i(this.f9771h, k0.a.i(this.f9770g, (this.f9769f.hashCode() + ((this.f9768e.hashCode() + androidx.activity.b.d(androidx.activity.b.d((s.f.c(this.f9765b) + (this.f9764a.hashCode() * 31)) * 31, 31, this.f9766c), 31, this.f9767d)) * 31)) * 31, 31), 31), 31)) * 31, 31)) * 31, 31), 31), 31), 31), 31, this.f9779q)) * 31, 31), 31), 31), 31), 31);
        String str = this.f9786x;
        return iB + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return k0.a.s(new StringBuilder("{WorkSpec: "), this.f9764a, '}');
    }

    public p(String str, int i, String str2, String str3, g5.h hVar, g5.h hVar2, long j10, long j11, long j12, g5.d dVar, int i3, int i10, long j13, long j14, long j15, long j16, boolean z10, int i11, int i12, int i13, long j17, int i14, int i15, String str4) {
        str.getClass();
        if (i == 0) {
            throw null;
        }
        str2.getClass();
        str3.getClass();
        hVar.getClass();
        hVar2.getClass();
        dVar.getClass();
        if (i10 != 0 && i11 != 0) {
            this.f9764a = str;
            this.f9765b = i;
            this.f9766c = str2;
            this.f9767d = str3;
            this.f9768e = hVar;
            this.f9769f = hVar2;
            this.f9770g = j10;
            this.f9771h = j11;
            this.i = j12;
            this.f9772j = dVar;
            this.f9773k = i3;
            this.f9774l = i10;
            this.f9775m = j13;
            this.f9776n = j14;
            this.f9777o = j15;
            this.f9778p = j16;
            this.f9779q = z10;
            this.f9780r = i11;
            this.f9781s = i12;
            this.f9782t = i13;
            this.f9783u = j17;
            this.f9784v = i14;
            this.f9785w = i15;
            this.f9786x = str4;
            return;
        }
        throw null;
    }
}
