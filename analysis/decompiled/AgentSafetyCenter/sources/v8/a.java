package v8;

import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f14850a;

    /* renamed from: b, reason: collision with root package name */
    public long f14851b;

    /* renamed from: c, reason: collision with root package name */
    public String f14852c;

    /* renamed from: d, reason: collision with root package name */
    public Object f14853d;

    /* renamed from: e, reason: collision with root package name */
    public String f14854e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14855f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f14850a, aVar.f14850a) && this.f14851b == aVar.f14851b && k.a(this.f14852c, aVar.f14852c) && k.a(this.f14853d, aVar.f14853d) && k.a(this.f14854e, aVar.f14854e) && this.f14855f == aVar.f14855f;
    }

    public final int hashCode() {
        int iHashCode = (this.f14853d.hashCode() + androidx.activity.b.d(k0.a.i(this.f14851b, this.f14850a.hashCode() * 31, 31), 31, this.f14852c)) * 31;
        String str = this.f14854e;
        return Boolean.hashCode(this.f14855f) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "BackupContact(truthId=" + this.f14850a + ", backupId=" + this.f14851b + ", displayName=" + this.f14852c + ", phoneNumbers=" + this.f14853d + ", photoUri=" + this.f14854e + ", deleted=" + this.f14855f + ")";
    }
}
