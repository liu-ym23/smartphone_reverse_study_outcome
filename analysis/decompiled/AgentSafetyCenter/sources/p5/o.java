package p5;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f9746a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9747b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.h f9748c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9749d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9750e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9751f;

    /* renamed from: g, reason: collision with root package name */
    public final g5.d f9752g;

    /* renamed from: h, reason: collision with root package name */
    public final int f9753h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final long f9754j;

    /* renamed from: k, reason: collision with root package name */
    public final long f9755k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9756l;

    /* renamed from: m, reason: collision with root package name */
    public final int f9757m;

    /* renamed from: n, reason: collision with root package name */
    public final long f9758n;

    /* renamed from: o, reason: collision with root package name */
    public final int f9759o;

    /* renamed from: p, reason: collision with root package name */
    public final List f9760p;

    /* renamed from: q, reason: collision with root package name */
    public final List f9761q;

    public o(String str, int i, g5.h hVar, long j10, long j11, long j12, g5.d dVar, int i3, int i10, long j13, long j14, int i11, int i12, long j15, int i13, ArrayList arrayList, ArrayList arrayList2) {
        str.getClass();
        if (i == 0) {
            throw null;
        }
        hVar.getClass();
        if (i10 == 0) {
            throw null;
        }
        arrayList.getClass();
        arrayList2.getClass();
        this.f9746a = str;
        this.f9747b = i;
        this.f9748c = hVar;
        this.f9749d = j10;
        this.f9750e = j11;
        this.f9751f = j12;
        this.f9752g = dVar;
        this.f9753h = i3;
        this.i = i10;
        this.f9754j = j13;
        this.f9755k = j14;
        this.f9756l = i11;
        this.f9757m = i12;
        this.f9758n = j15;
        this.f9759o = i13;
        this.f9760p = arrayList;
        this.f9761q = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return yb.k.a(this.f9746a, oVar.f9746a) && this.f9747b == oVar.f9747b && yb.k.a(this.f9748c, oVar.f9748c) && this.f9749d == oVar.f9749d && this.f9750e == oVar.f9750e && this.f9751f == oVar.f9751f && this.f9752g.equals(oVar.f9752g) && this.f9753h == oVar.f9753h && this.i == oVar.i && this.f9754j == oVar.f9754j && this.f9755k == oVar.f9755k && this.f9756l == oVar.f9756l && this.f9757m == oVar.f9757m && this.f9758n == oVar.f9758n && this.f9759o == oVar.f9759o && yb.k.a(this.f9760p, oVar.f9760p) && yb.k.a(this.f9761q, oVar.f9761q);
    }

    public final int hashCode() {
        return this.f9761q.hashCode() + androidx.activity.b.e(this.f9760p, s.f.b(this.f9759o, k0.a.i(this.f9758n, s.f.b(this.f9757m, s.f.b(this.f9756l, k0.a.i(this.f9755k, k0.a.i(this.f9754j, (s.f.c(this.i) + s.f.b(this.f9753h, (this.f9752g.hashCode() + k0.a.i(this.f9751f, k0.a.i(this.f9750e, k0.a.i(this.f9749d, (this.f9748c.hashCode() + ((s.f.c(this.f9747b) + (this.f9746a.hashCode() * 31)) * 31)) * 31, 31), 31), 31)) * 31, 31)) * 31, 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("WorkInfoPojo(id=");
        sb2.append(this.f9746a);
        sb2.append(", state=");
        sb2.append(androidx.activity.b.z(this.f9747b));
        sb2.append(", output=");
        sb2.append(this.f9748c);
        sb2.append(", initialDelay=");
        sb2.append(this.f9749d);
        sb2.append(", intervalDuration=");
        sb2.append(this.f9750e);
        sb2.append(", flexDuration=");
        sb2.append(this.f9751f);
        sb2.append(", constraints=");
        sb2.append(this.f9752g);
        sb2.append(", runAttemptCount=");
        sb2.append(this.f9753h);
        sb2.append(", backoffPolicy=");
        int i = this.i;
        sb2.append(i != 1 ? i != 2 ? "null" : "LINEAR" : "EXPONENTIAL");
        sb2.append(", backoffDelayDuration=");
        sb2.append(this.f9754j);
        sb2.append(", lastEnqueueTime=");
        sb2.append(this.f9755k);
        sb2.append(", periodCount=");
        sb2.append(this.f9756l);
        sb2.append(", generation=");
        sb2.append(this.f9757m);
        sb2.append(", nextScheduleTimeOverride=");
        sb2.append(this.f9758n);
        sb2.append(", stopReason=");
        sb2.append(this.f9759o);
        sb2.append(", tags=");
        sb2.append(this.f9760p);
        sb2.append(", progress=");
        sb2.append(this.f9761q);
        sb2.append(')');
        return sb2.toString();
    }
}
