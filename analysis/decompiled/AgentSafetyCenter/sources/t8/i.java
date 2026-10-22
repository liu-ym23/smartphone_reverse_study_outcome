package t8;

import android.net.Uri;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final k f13245a;

    /* renamed from: b, reason: collision with root package name */
    public final g f13246b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f13247c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13248d;

    /* renamed from: e, reason: collision with root package name */
    public final j f13249e;

    /* renamed from: f, reason: collision with root package name */
    public final String f13250f;

    public i(k kVar, g gVar, Uri uri, String str, j jVar, String str2, int i) {
        uri = (i & 4) != 0 ? null : uri;
        str = (i & 8) != 0 ? null : str;
        jVar = (i & 16) != 0 ? null : jVar;
        this.f13245a = kVar;
        this.f13246b = gVar;
        this.f13247c = uri;
        this.f13248d = str;
        this.f13249e = jVar;
        this.f13250f = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f13245a == iVar.f13245a && this.f13246b == iVar.f13246b && yb.k.a(this.f13247c, iVar.f13247c) && yb.k.a(this.f13248d, iVar.f13248d) && this.f13249e == iVar.f13249e && this.f13250f.equals(iVar.f13250f);
    }

    public final int hashCode() {
        int iHashCode = (this.f13246b.hashCode() + (this.f13245a.hashCode() * 31)) * 31;
        Uri uri = this.f13247c;
        int iHashCode2 = (iHashCode + (uri == null ? 0 : uri.hashCode())) * 31;
        String str = this.f13248d;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        j jVar = this.f13249e;
        return this.f13250f.hashCode() + ((iHashCode3 + (jVar != null ? jVar.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "TrashResolveResult(status=" + this.f13245a + ", confidence=" + this.f13246b + ", trashUri=" + this.f13247c + ", trashRealPath=" + this.f13248d + ", source=" + this.f13249e + ", reason=" + this.f13250f + ")";
    }
}
