package B0;

import androidx.room.AbstractC0351g;
import androidx.work.OverwritingInputMerger;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.RangesKt;
import s0.C;
import s0.C0847e;
import s0.C0850h;
import s0.EnumC0843a;
import s0.G;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: x, reason: collision with root package name */
    public static final String f166x;

    /* renamed from: a, reason: collision with root package name */
    public final String f167a;

    /* renamed from: b, reason: collision with root package name */
    public G f168b;

    /* renamed from: c, reason: collision with root package name */
    public final String f169c;

    /* renamed from: d, reason: collision with root package name */
    public final String f170d;

    /* renamed from: e, reason: collision with root package name */
    public final C0850h f171e;

    /* renamed from: f, reason: collision with root package name */
    public final C0850h f172f;

    /* renamed from: g, reason: collision with root package name */
    public long f173g;

    /* renamed from: h, reason: collision with root package name */
    public long f174h;

    /* renamed from: i, reason: collision with root package name */
    public long f175i;

    /* renamed from: j, reason: collision with root package name */
    public C0847e f176j;

    /* renamed from: k, reason: collision with root package name */
    public final int f177k;

    /* renamed from: l, reason: collision with root package name */
    public final EnumC0843a f178l;

    /* renamed from: m, reason: collision with root package name */
    public final long f179m;

    /* renamed from: n, reason: collision with root package name */
    public long f180n;

    /* renamed from: o, reason: collision with root package name */
    public final long f181o;

    /* renamed from: p, reason: collision with root package name */
    public final long f182p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f183q;

    /* renamed from: r, reason: collision with root package name */
    public final C f184r;

    /* renamed from: s, reason: collision with root package name */
    public final int f185s;

    /* renamed from: t, reason: collision with root package name */
    public final int f186t;

    /* renamed from: u, reason: collision with root package name */
    public long f187u;

    /* renamed from: v, reason: collision with root package name */
    public int f188v;

    /* renamed from: w, reason: collision with root package name */
    public final int f189w;

    static {
        String strF = s0.t.f("WorkSpec");
        Intrinsics.checkNotNullExpressionValue(strF, "tagWithPrefix(\"WorkSpec\")");
        f166x = strF;
    }

    public r(String id, G state, String workerClassName, String inputMergerClassName, C0850h input, C0850h output, long j4, long j5, long j6, C0847e constraints, int i4, EnumC0843a backoffPolicy, long j7, long j8, long j9, long j10, boolean z4, C outOfQuotaPolicy, int i5, int i6, long j11, int i7, int i8) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(inputMergerClassName, "inputMergerClassName");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(constraints, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.f167a = id;
        this.f168b = state;
        this.f169c = workerClassName;
        this.f170d = inputMergerClassName;
        this.f171e = input;
        this.f172f = output;
        this.f173g = j4;
        this.f174h = j5;
        this.f175i = j6;
        this.f176j = constraints;
        this.f177k = i4;
        this.f178l = backoffPolicy;
        this.f179m = j7;
        this.f180n = j8;
        this.f181o = j9;
        this.f182p = j10;
        this.f183q = z4;
        this.f184r = outOfQuotaPolicy;
        this.f185s = i5;
        this.f186t = i6;
        this.f187u = j11;
        this.f188v = i7;
        this.f189w = i8;
    }

    public static r b(r rVar, String str, G g4, String str2, C0850h c0850h, int i4, long j4, int i5, int i6, long j5, int i7, int i8) {
        boolean z4;
        int i9;
        String id = (i8 & 1) != 0 ? rVar.f167a : str;
        G state = (i8 & 2) != 0 ? rVar.f168b : g4;
        String workerClassName = (i8 & 4) != 0 ? rVar.f169c : str2;
        String inputMergerClassName = rVar.f170d;
        C0850h input = (i8 & 16) != 0 ? rVar.f171e : c0850h;
        C0850h output = rVar.f172f;
        long j6 = rVar.f173g;
        long j7 = rVar.f174h;
        long j8 = rVar.f175i;
        C0847e constraints = rVar.f176j;
        int i10 = (i8 & 1024) != 0 ? rVar.f177k : i4;
        EnumC0843a backoffPolicy = rVar.f178l;
        long j9 = rVar.f179m;
        long j10 = (i8 & 8192) != 0 ? rVar.f180n : j4;
        long j11 = rVar.f181o;
        long j12 = rVar.f182p;
        boolean z5 = rVar.f183q;
        C outOfQuotaPolicy = rVar.f184r;
        if ((i8 & 262144) != 0) {
            z4 = z5;
            i9 = rVar.f185s;
        } else {
            z4 = z5;
            i9 = i5;
        }
        int i11 = (524288 & i8) != 0 ? rVar.f186t : i6;
        long j13 = (1048576 & i8) != 0 ? rVar.f187u : j5;
        int i12 = (i8 & BmLocated.ALIGN_BOTTOM) != 0 ? rVar.f188v : i7;
        int i13 = rVar.f189w;
        rVar.getClass();
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(inputMergerClassName, "inputMergerClassName");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(constraints, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy, "outOfQuotaPolicy");
        return new r(id, state, workerClassName, inputMergerClassName, input, output, j6, j7, j8, constraints, i10, backoffPolicy, j9, j10, j11, j12, z4, outOfQuotaPolicy, i9, i11, j13, i12, i13);
    }

    public final long a() {
        long jCoerceAtMost;
        boolean z4 = this.f168b == G.f14153a && this.f177k > 0;
        long j4 = this.f180n;
        boolean zD = d();
        long j5 = this.f173g;
        long j6 = this.f175i;
        long j7 = this.f174h;
        long j8 = this.f187u;
        EnumC0843a backoffPolicy = this.f178l;
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        int i4 = this.f185s;
        if (j8 != LongCompanionObject.MAX_VALUE && zD) {
            return i4 == 0 ? j8 : RangesKt.coerceAtLeast(j8, j4 + 900000);
        }
        if (z4) {
            EnumC0843a enumC0843a = EnumC0843a.f14168b;
            int i5 = this.f177k;
            long j9 = this.f179m;
            jCoerceAtMost = RangesKt.coerceAtMost(backoffPolicy == enumC0843a ? j9 * i5 : (long) Math.scalb(j9, i5 - 1), 18000000L) + j4;
        } else if (zD) {
            long j10 = i4 == 0 ? j4 + j5 : j4 + j7;
            jCoerceAtMost = (j6 == j7 || i4 != 0) ? j10 : (j7 - j6) + j10;
        } else {
            jCoerceAtMost = j4 == -1 ? LongCompanionObject.MAX_VALUE : j4 + j5;
        }
        return jCoerceAtMost;
    }

    public final boolean c() {
        return !Intrinsics.areEqual(C0847e.f14184i, this.f176j);
    }

    public final boolean d() {
        return this.f174h != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Intrinsics.areEqual(this.f167a, rVar.f167a) && this.f168b == rVar.f168b && Intrinsics.areEqual(this.f169c, rVar.f169c) && Intrinsics.areEqual(this.f170d, rVar.f170d) && Intrinsics.areEqual(this.f171e, rVar.f171e) && Intrinsics.areEqual(this.f172f, rVar.f172f) && this.f173g == rVar.f173g && this.f174h == rVar.f174h && this.f175i == rVar.f175i && Intrinsics.areEqual(this.f176j, rVar.f176j) && this.f177k == rVar.f177k && this.f178l == rVar.f178l && this.f179m == rVar.f179m && this.f180n == rVar.f180n && this.f181o == rVar.f181o && this.f182p == rVar.f182p && this.f183q == rVar.f183q && this.f184r == rVar.f184r && this.f185s == rVar.f185s && this.f186t == rVar.f186t && this.f187u == rVar.f187u && this.f188v == rVar.f188v && this.f189w == rVar.f189w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iF = g.f(this.f182p, g.f(this.f181o, g.f(this.f180n, g.f(this.f179m, (this.f178l.hashCode() + g.d(this.f177k, (this.f176j.hashCode() + g.f(this.f175i, g.f(this.f174h, g.f(this.f173g, (this.f172f.hashCode() + ((this.f171e.hashCode() + AbstractC0351g.d(this.f170d, AbstractC0351g.d(this.f169c, (this.f168b.hashCode() + (this.f167a.hashCode() * 31)) * 31, 31), 31)) * 31)) * 31, 31), 31), 31)) * 31, 31)) * 31, 31), 31), 31), 31);
        boolean z4 = this.f183q;
        int i4 = z4;
        if (z4 != 0) {
            i4 = 1;
        }
        return Integer.hashCode(this.f189w) + g.d(this.f188v, g.f(this.f187u, g.d(this.f186t, g.d(this.f185s, (this.f184r.hashCode() + ((iF + i4) * 31)) * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        return g.q(new StringBuilder("{WorkSpec: "), this.f167a, '}');
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ r(String str, G g4, String str2, String str3, C0850h c0850h, C0850h c0850h2, long j4, long j5, long j6, C0847e c0847e, int i4, EnumC0843a enumC0843a, long j7, long j8, long j9, long j10, boolean z4, C c4, int i5, long j11, int i6, int i7, int i8) {
        String str4;
        C0850h c0850h3;
        C0850h c0850h4;
        G g5 = (i8 & 2) != 0 ? G.f14153a : g4;
        if ((i8 & 8) != 0) {
            String name = OverwritingInputMerger.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "OverwritingInputMerger::class.java.name");
            str4 = name;
        } else {
            str4 = str3;
        }
        if ((i8 & 16) != 0) {
            C0850h EMPTY = C0850h.f14200c;
            Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
            c0850h3 = EMPTY;
        } else {
            c0850h3 = c0850h;
        }
        if ((i8 & 32) != 0) {
            C0850h EMPTY2 = C0850h.f14200c;
            Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
            c0850h4 = EMPTY2;
        } else {
            c0850h4 = c0850h2;
        }
        this(str, g5, str2, str4, c0850h3, c0850h4, (i8 & 64) != 0 ? 0L : j4, (i8 & 128) != 0 ? 0L : j5, (i8 & 256) != 0 ? 0L : j6, (i8 & 512) != 0 ? C0847e.f14184i : c0847e, (i8 & 1024) != 0 ? 0 : i4, (i8 & 2048) != 0 ? EnumC0843a.f14167a : enumC0843a, (i8 & 4096) != 0 ? 30000L : j7, (i8 & 8192) != 0 ? -1L : j8, (i8 & 16384) != 0 ? 0L : j9, (32768 & i8) != 0 ? -1L : j10, (65536 & i8) != 0 ? false : z4, (131072 & i8) != 0 ? C.f14150a : c4, (262144 & i8) != 0 ? 0 : i5, 0, (1048576 & i8) != 0 ? Long.MAX_VALUE : j11, (2097152 & i8) != 0 ? 0 : i6, (i8 & BmLocated.ALIGN_LEFT) != 0 ? -256 : i7);
    }
}
