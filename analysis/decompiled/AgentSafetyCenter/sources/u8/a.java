package u8;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f14185a;

    /* renamed from: b, reason: collision with root package name */
    public List f14186b;

    /* renamed from: c, reason: collision with root package name */
    public String f14187c;

    /* renamed from: d, reason: collision with root package name */
    public long f14188d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return yb.k.a(this.f14185a, aVar.f14185a) && yb.k.a(this.f14186b, aVar.f14186b) && yb.k.a(this.f14187c, aVar.f14187c) && this.f14188d == aVar.f14188d;
    }

    public final int hashCode() {
        int iE = androidx.activity.b.e(this.f14186b, this.f14185a.hashCode() * 31, 31);
        String str = this.f14187c;
        return Long.hashCode(this.f14188d) + ((iE + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "ContactUndoDisplay(displayName=" + this.f14185a + ", phoneNumbers=" + this.f14186b + ", photoUri=" + this.f14187c + ", backupId=" + this.f14188d + ")";
    }
}
