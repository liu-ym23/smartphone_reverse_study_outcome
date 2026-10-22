package u8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public String f14219a;

    /* renamed from: b, reason: collision with root package name */
    public String f14220b;

    /* renamed from: c, reason: collision with root package name */
    public long f14221c;

    /* renamed from: d, reason: collision with root package name */
    public String f14222d;

    /* renamed from: e, reason: collision with root package name */
    public String f14223e;

    /* renamed from: f, reason: collision with root package name */
    public w8.b f14224f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14225g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14226h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public int f14227j;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f14219a.equals(kVar.f14219a) && this.f14220b.equals(kVar.f14220b) && this.f14221c == kVar.f14221c && yb.k.a(this.f14222d, kVar.f14222d) && yb.k.a(this.f14223e, kVar.f14223e) && this.f14224f == kVar.f14224f && this.f14225g == kVar.f14225g && this.f14226h == kVar.f14226h && this.i == kVar.i && this.f14227j == kVar.f14227j;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f14227j) + k0.a.h(k0.a.h(k0.a.h((this.f14224f.hashCode() + androidx.activity.b.d(androidx.activity.b.d(k0.a.i(this.f14221c, androidx.activity.b.d(this.f14219a.hashCode() * 31, 31, this.f14220b), 31), 31, this.f14222d), 31, this.f14223e)) * 31, 31, this.f14225g), 31, this.f14226h), 31, this.i);
    }

    public final String toString() {
        String str = this.f14219a;
        String str2 = this.f14220b;
        long j10 = this.f14221c;
        String str3 = this.f14222d;
        String str4 = this.f14223e;
        w8.b bVar = this.f14224f;
        boolean z10 = this.f14225g;
        boolean z11 = this.f14226h;
        boolean z12 = this.i;
        int i = this.f14227j;
        StringBuilder sbP = androidx.activity.b.p("NoteUndoDisplay(title=", str, ", body=", str2, ", modifiedMillis=");
        sbP.append(j10);
        sbP.append(", uuid=");
        sbP.append(str3);
        sbP.append(", reservedId=");
        sbP.append(str4);
        sbP.append(", layout=");
        sbP.append(bVar);
        sbP.append(", hasImageBadge=");
        sbP.append(z10);
        sbP.append(", hasAudioBadge=");
        sbP.append(z11);
        sbP.append(", hasFileBadge=");
        sbP.append(z12);
        sbP.append(", imageCount=");
        sbP.append(i);
        sbP.append(")");
        return sbP.toString();
    }
}
