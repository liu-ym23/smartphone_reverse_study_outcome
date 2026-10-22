package g5;

import android.net.NetworkRequest;
import java.lang.invoke.VarHandle;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: j, reason: collision with root package name */
    public static final d f4286j;

    /* renamed from: a, reason: collision with root package name */
    public int f4287a;

    /* renamed from: b, reason: collision with root package name */
    public q5.d f4288b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4289c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4290d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4291e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4292f;

    /* renamed from: g, reason: collision with root package name */
    public long f4293g;

    /* renamed from: h, reason: collision with root package name */
    public long f4294h;
    public Set i;

    static {
        d dVar = new d();
        dVar.f4288b = new q5.d(null);
        dVar.f4287a = 1;
        dVar.f4289c = false;
        dVar.f4290d = false;
        dVar.f4291e = false;
        dVar.f4292f = false;
        dVar.f4293g = -1L;
        dVar.f4294h = -1L;
        dVar.i = kb.u.f7406c;
        VarHandle.storeStoreFence();
        f4286j = dVar;
    }

    public d(q5.d dVar, int i, boolean z10, boolean z11, boolean z12, boolean z13, long j10, long j11, Set set) {
        if (i == 0) {
            throw null;
        }
        this.f4288b = dVar;
        this.f4287a = i;
        this.f4289c = z10;
        this.f4290d = z11;
        this.f4291e = z12;
        this.f4292f = z13;
        this.f4293g = j10;
        this.f4294h = j11;
        this.i = set;
    }

    public final NetworkRequest a() {
        return (NetworkRequest) this.f4288b.f10084a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !d.class.equals(obj.getClass())) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f4289c == dVar.f4289c && this.f4290d == dVar.f4290d && this.f4291e == dVar.f4291e && this.f4292f == dVar.f4292f && this.f4293g == dVar.f4293g && this.f4294h == dVar.f4294h && yb.k.a(a(), dVar.a()) && this.f4287a == dVar.f4287a) {
            return yb.k.a(this.i, dVar.i);
        }
        return false;
    }

    public final int hashCode() {
        int iC = ((((((((s.f.c(this.f4287a) * 31) + (this.f4289c ? 1 : 0)) * 31) + (this.f4290d ? 1 : 0)) * 31) + (this.f4291e ? 1 : 0)) * 31) + (this.f4292f ? 1 : 0)) * 31;
        long j10 = this.f4293g;
        int i = (iC + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f4294h;
        int iHashCode = (this.i.hashCode() + ((i + ((int) (j11 ^ (j11 >>> 32)))) * 31)) * 31;
        NetworkRequest networkRequestA = a();
        return iHashCode + (networkRequestA != null ? networkRequestA.hashCode() : 0);
    }

    public final String toString() {
        return "Constraints{requiredNetworkType=" + androidx.activity.b.y(this.f4287a) + ", requiresCharging=" + this.f4289c + ", requiresDeviceIdle=" + this.f4290d + ", requiresBatteryNotLow=" + this.f4291e + ", requiresStorageNotLow=" + this.f4292f + ", contentTriggerUpdateDelayMillis=" + this.f4293g + ", contentTriggerMaxDelayMillis=" + this.f4294h + ", contentUriTriggers=" + this.i + ", }";
    }
}
