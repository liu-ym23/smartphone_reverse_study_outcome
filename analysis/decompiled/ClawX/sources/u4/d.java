package u4;

import b8.h;
import kotlin.jvm.internal.p;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Serializable
/* loaded from: classes.dex */
public final class d implements Comparable<d> {
    public static final c Companion = new c();

    /* renamed from: k, reason: collision with root package name */
    public static final b5.e[] f5642k;

    /* renamed from: a, reason: collision with root package name */
    public final int f5643a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5644b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5645c;
    public final f d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5646e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5647f;

    /* renamed from: g, reason: collision with root package name */
    public final e f5648g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5649h;

    /* renamed from: j, reason: collision with root package name */
    public final long f5650j;

    static {
        b5.f fVar = b5.f.f889a;
        f5642k = new b5.e[]{null, null, null, h.w(fVar, new q3.a(5)), null, null, h.w(fVar, new q3.a(6)), null, null};
        a.a(0L);
    }

    public /* synthetic */ d(int i8, int i9, int i10, int i11, f fVar, int i12, int i13, e eVar, int i14, long j4) {
        if (511 != (i8 & 511)) {
            PluginExceptionsKt.throwMissingFieldException(i8, 511, b.f5641a.getDescriptor());
        }
        this.f5643a = i9;
        this.f5644b = i10;
        this.f5645c = i11;
        this.d = fVar;
        this.f5646e = i12;
        this.f5647f = i13;
        this.f5648g = eVar;
        this.f5649h = i14;
        this.f5650j = j4;
    }

    @Override // java.lang.Comparable
    public final int compareTo(d dVar) {
        d other = dVar;
        p.e(other, "other");
        return p.h(this.f5650j, other.f5650j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f5643a == dVar.f5643a && this.f5644b == dVar.f5644b && this.f5645c == dVar.f5645c && this.d == dVar.d && this.f5646e == dVar.f5646e && this.f5647f == dVar.f5647f && this.f5648g == dVar.f5648g && this.f5649h == dVar.f5649h && this.f5650j == dVar.f5650j;
    }

    public final int hashCode() {
        return Long.hashCode(this.f5650j) + a8.b.C(this.f5649h, (this.f5648g.hashCode() + a8.b.C(this.f5647f, a8.b.C(this.f5646e, (this.d.hashCode() + a8.b.C(this.f5645c, a8.b.C(this.f5644b, Integer.hashCode(this.f5643a) * 31, 31), 31)) * 31, 31), 31)) * 31, 31);
    }

    public final String toString() {
        return "GMTDate(seconds=" + this.f5643a + ", minutes=" + this.f5644b + ", hours=" + this.f5645c + ", dayOfWeek=" + this.d + ", dayOfMonth=" + this.f5646e + ", dayOfYear=" + this.f5647f + ", month=" + this.f5648g + ", year=" + this.f5649h + ", timestamp=" + this.f5650j + ')';
    }

    public d(int i8, int i9, int i10, f dayOfWeek, int i11, int i12, e month, int i13, long j4) {
        p.e(dayOfWeek, "dayOfWeek");
        p.e(month, "month");
        this.f5643a = i8;
        this.f5644b = i9;
        this.f5645c = i10;
        this.d = dayOfWeek;
        this.f5646e = i11;
        this.f5647f = i12;
        this.f5648g = month;
        this.f5649h = i13;
        this.f5650j = j4;
    }
}
