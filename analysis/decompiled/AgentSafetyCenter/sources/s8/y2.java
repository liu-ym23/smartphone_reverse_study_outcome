package s8;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f12124a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12125b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12126c;

    /* renamed from: d, reason: collision with root package name */
    public final List f12127d;

    /* renamed from: e, reason: collision with root package name */
    public final String f12128e;

    /* renamed from: f, reason: collision with root package name */
    public final List f12129f;

    /* renamed from: g, reason: collision with root package name */
    public final String f12130g;

    /* renamed from: h, reason: collision with root package name */
    public final String f12131h;
    public final String i;

    /* renamed from: j, reason: collision with root package name */
    public final String f12132j;

    /* renamed from: k, reason: collision with root package name */
    public final String f12133k;

    /* renamed from: l, reason: collision with root package name */
    public final u8.p f12134l;

    /* renamed from: m, reason: collision with root package name */
    public final String f12135m;

    /* renamed from: n, reason: collision with root package name */
    public final String f12136n;

    /* renamed from: o, reason: collision with root package name */
    public final String f12137o;

    /* renamed from: p, reason: collision with root package name */
    public final List f12138p;

    /* renamed from: q, reason: collision with root package name */
    public final List f12139q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f12140r;

    public y2(String str, String str2, String str3, List list, String str4, List list2, String str5, String str6, String str7, String str8, String str9, u8.p pVar, String str10, String str11, String str12, List list3, List list4, boolean z10) {
        str2.getClass();
        list.getClass();
        str7.getClass();
        str8.getClass();
        str9.getClass();
        pVar.getClass();
        list4.getClass();
        this.f12124a = str;
        this.f12125b = str2;
        this.f12126c = str3;
        this.f12127d = list;
        this.f12128e = str4;
        this.f12129f = list2;
        this.f12130g = str5;
        this.f12131h = str6;
        this.i = str7;
        this.f12132j = str8;
        this.f12133k = str9;
        this.f12134l = pVar;
        this.f12135m = str10;
        this.f12136n = str11;
        this.f12137o = str12;
        this.f12138p = list3;
        this.f12139q = list4;
        this.f12140r = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y2)) {
            return false;
        }
        y2 y2Var = (y2) obj;
        return this.f12124a.equals(y2Var.f12124a) && yb.k.a(this.f12125b, y2Var.f12125b) && this.f12126c.equals(y2Var.f12126c) && yb.k.a(this.f12127d, y2Var.f12127d) && yb.k.a(this.f12128e, y2Var.f12128e) && this.f12129f.equals(y2Var.f12129f) && yb.k.a(this.f12130g, y2Var.f12130g) && yb.k.a(this.f12131h, y2Var.f12131h) && yb.k.a(this.i, y2Var.i) && yb.k.a(this.f12132j, y2Var.f12132j) && yb.k.a(this.f12133k, y2Var.f12133k) && this.f12134l == y2Var.f12134l && yb.k.a(this.f12135m, y2Var.f12135m) && yb.k.a(this.f12136n, y2Var.f12136n) && yb.k.a(this.f12137o, y2Var.f12137o) && this.f12138p.equals(y2Var.f12138p) && yb.k.a(this.f12139q, y2Var.f12139q) && this.f12140r == y2Var.f12140r;
    }

    public final int hashCode() {
        int iE = androidx.activity.b.e(this.f12127d, androidx.activity.b.d(androidx.activity.b.d(this.f12124a.hashCode() * 31, 31, this.f12125b), 31, this.f12126c), 31);
        String str = this.f12128e;
        int iE2 = androidx.activity.b.e(this.f12129f, (iE + (str == null ? 0 : str.hashCode())) * 31, 31);
        String str2 = this.f12130g;
        int iHashCode = (iE2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f12131h;
        int iHashCode2 = (this.f12134l.hashCode() + androidx.activity.b.d(androidx.activity.b.d(androidx.activity.b.d((iHashCode + (str3 == null ? 0 : str3.hashCode())) * 31, 31, this.i), 31, this.f12132j), 31, this.f12133k)) * 31;
        String str4 = this.f12135m;
        int iHashCode3 = (iHashCode2 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f12136n;
        int iHashCode4 = (iHashCode3 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f12137o;
        return Boolean.hashCode(this.f12140r) + androidx.activity.b.e(this.f12139q, androidx.activity.b.e(this.f12138p, (iHashCode4 + (str6 != null ? str6.hashCode() : 0)) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sbP = androidx.activity.b.p("RevokeDialogItem(key=", this.f12124a, ", title=", this.f12125b, ", description=");
        sbP.append(this.f12126c);
        sbP.append(", thumbnailUrls=");
        sbP.append(this.f12127d);
        sbP.append(", recoverPath=");
        sbP.append(this.f12128e);
        sbP.append(", recoverPaths=");
        sbP.append(this.f12129f);
        sbP.append(", previewContentUri=");
        androidx.activity.b.u(sbP, this.f12130g, ", trashPath=", this.f12131h, ", sessionId=");
        androidx.activity.b.u(sbP, this.i, ", taskId=", this.f12132j, ", toolCallId=");
        sbP.append(this.f12133k);
        sbP.append(", undoDomain=");
        sbP.append(this.f12134l);
        sbP.append(", contactDisplayName=");
        androidx.activity.b.u(sbP, this.f12135m, ", contactPhoneMasked=", this.f12136n, ", contactPhotoUri=");
        sbP.append(this.f12137o);
        sbP.append(", contacts=");
        sbP.append(this.f12138p);
        sbP.append(", notes=");
        sbP.append(this.f12139q);
        sbP.append(", selected=");
        sbP.append(this.f12140r);
        sbP.append(")");
        return sbP.toString();
    }
}
