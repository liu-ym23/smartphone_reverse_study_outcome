package a9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final long f283a;

    /* renamed from: b, reason: collision with root package name */
    public final String f284b;

    /* renamed from: c, reason: collision with root package name */
    public final String f285c;

    /* renamed from: d, reason: collision with root package name */
    public final String f286d;

    /* renamed from: e, reason: collision with root package name */
    public final long f287e;

    /* renamed from: f, reason: collision with root package name */
    public final String f288f;

    /* renamed from: g, reason: collision with root package name */
    public final String f289g;

    public l(long j10, long j11, String str, String str2, String str3, String str4, String str5) {
        this.f283a = j10;
        this.f284b = str;
        this.f285c = str2;
        this.f286d = str3;
        this.f287e = j11;
        this.f288f = str4;
        this.f289g = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f283a == lVar.f283a && this.f284b.equals(lVar.f284b) && this.f285c.equals(lVar.f285c) && this.f286d.equals(lVar.f286d) && this.f287e == lVar.f287e && this.f288f.equals(lVar.f288f) && this.f289g.equals(lVar.f289g);
    }

    public final int hashCode() {
        return this.f289g.hashCode() + androidx.activity.b.d(k0.a.i(this.f287e, androidx.activity.b.d(androidx.activity.b.d(androidx.activity.b.d(Long.hashCode(this.f283a) * 31, 31, this.f284b), 31, this.f285c), 31, this.f286d), 31), 31, this.f288f);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("GarbageRecord(id=");
        sb2.append(this.f283a);
        sb2.append(", originalPath=");
        sb2.append(this.f284b);
        androidx.activity.b.u(sb2, ", garbagePath=", this.f285c, ", displayName=", this.f286d);
        sb2.append(", deletedTime=");
        sb2.append(this.f287e);
        sb2.append(", dbPath=");
        sb2.append(this.f288f);
        sb2.append(", mimeType=");
        sb2.append(this.f289g);
        sb2.append(")");
        return sb2.toString();
    }
}
