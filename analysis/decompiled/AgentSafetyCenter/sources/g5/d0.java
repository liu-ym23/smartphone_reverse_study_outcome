package g5;

import java.util.HashSet;
import java.util.UUID;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public UUID f4295a;

    /* renamed from: b, reason: collision with root package name */
    public HashSet f4296b;

    /* renamed from: c, reason: collision with root package name */
    public h f4297c;

    /* renamed from: d, reason: collision with root package name */
    public h f4298d;

    /* renamed from: e, reason: collision with root package name */
    public int f4299e;

    /* renamed from: f, reason: collision with root package name */
    public int f4300f;

    /* renamed from: g, reason: collision with root package name */
    public d f4301g;

    /* renamed from: h, reason: collision with root package name */
    public long f4302h;
    public c0 i;

    /* renamed from: j, reason: collision with root package name */
    public long f4303j;

    /* renamed from: k, reason: collision with root package name */
    public int f4304k;

    /* renamed from: l, reason: collision with root package name */
    public int f4305l;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !d0.class.equals(obj.getClass())) {
            return false;
        }
        d0 d0Var = (d0) obj;
        if (this.f4299e == d0Var.f4299e && this.f4300f == d0Var.f4300f && this.f4295a.equals(d0Var.f4295a) && this.f4305l == d0Var.f4305l && yb.k.a(this.f4297c, d0Var.f4297c) && this.f4301g.equals(d0Var.f4301g) && this.f4302h == d0Var.f4302h && yb.k.a(this.i, d0Var.i) && this.f4303j == d0Var.f4303j && this.f4304k == d0Var.f4304k && this.f4296b.equals(d0Var.f4296b)) {
            return this.f4298d.equals(d0Var.f4298d);
        }
        return false;
    }

    public final int hashCode() {
        int i = k0.a.i(this.f4302h, (this.f4301g.hashCode() + ((((((this.f4298d.hashCode() + ((this.f4296b.hashCode() + ((this.f4297c.hashCode() + ((s.f.c(this.f4305l) + (this.f4295a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31) + this.f4299e) * 31) + this.f4300f) * 31)) * 31, 31);
        c0 c0Var = this.i;
        return Integer.hashCode(this.f4304k) + k0.a.i(this.f4303j, (i + (c0Var != null ? c0Var.hashCode() : 0)) * 31, 31);
    }

    public final String toString() {
        return "WorkInfo{id='" + this.f4295a + "', state=" + androidx.activity.b.z(this.f4305l) + ", outputData=" + this.f4297c + ", tags=" + this.f4296b + ", progress=" + this.f4298d + ", runAttemptCount=" + this.f4299e + ", generation=" + this.f4300f + ", constraints=" + this.f4301g + ", initialDelayMillis=" + this.f4302h + ", periodicityInfo=" + this.i + ", nextScheduleTimeMillis=" + this.f4303j + "}, stopReason=" + this.f4304k;
    }
}
