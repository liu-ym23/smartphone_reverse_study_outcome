package s8;

import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p3 {
    public final u8.a A;
    public final List B;
    public final List C;
    public final boolean D;

    /* renamed from: a, reason: collision with root package name */
    public final String f11875a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11876b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11877c;

    /* renamed from: d, reason: collision with root package name */
    public final List f11878d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11879e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11880f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f11881g;

    /* renamed from: h, reason: collision with root package name */
    public final z8.g f11882h;
    public final Boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final String f11883j;

    /* renamed from: k, reason: collision with root package name */
    public final String f11884k;

    /* renamed from: l, reason: collision with root package name */
    public final String f11885l;

    /* renamed from: m, reason: collision with root package name */
    public final String f11886m;

    /* renamed from: n, reason: collision with root package name */
    public final String f11887n;

    /* renamed from: o, reason: collision with root package name */
    public final String f11888o;

    /* renamed from: p, reason: collision with root package name */
    public final String f11889p;

    /* renamed from: q, reason: collision with root package name */
    public final List f11890q;

    /* renamed from: r, reason: collision with root package name */
    public final String f11891r;

    /* renamed from: s, reason: collision with root package name */
    public final String f11892s;

    /* renamed from: t, reason: collision with root package name */
    public final List f11893t;

    /* renamed from: u, reason: collision with root package name */
    public final String f11894u;

    /* renamed from: v, reason: collision with root package name */
    public final long f11895v;

    /* renamed from: w, reason: collision with root package name */
    public final long f11896w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f11897x;

    /* renamed from: y, reason: collision with root package name */
    public final String f11898y;

    /* renamed from: z, reason: collision with root package name */
    public final u8.p f11899z;

    public p3(String str, String str2, String str3, List list, String str4, boolean z10, boolean z11, z8.g gVar, Boolean bool, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List list2, String str12, String str13, List list3, String str14, long j10, long j11, boolean z12, String str15, u8.p pVar, u8.a aVar, List list4, List list5, boolean z13) {
        str8.getClass();
        str9.getClass();
        str10.getClass();
        str15.getClass();
        this.f11875a = str;
        this.f11876b = str2;
        this.f11877c = str3;
        this.f11878d = list;
        this.f11879e = str4;
        this.f11880f = z10;
        this.f11881g = z11;
        this.f11882h = gVar;
        this.i = bool;
        this.f11883j = str5;
        this.f11884k = str6;
        this.f11885l = str7;
        this.f11886m = str8;
        this.f11887n = str9;
        this.f11888o = str10;
        this.f11889p = str11;
        this.f11890q = list2;
        this.f11891r = str12;
        this.f11892s = str13;
        this.f11893t = list3;
        this.f11894u = str14;
        this.f11895v = j10;
        this.f11896w = j11;
        this.f11897x = z12;
        this.f11898y = str15;
        this.f11899z = pVar;
        this.A = aVar;
        this.B = list4;
        this.C = list5;
        this.D = z13;
    }

    public static p3 a(p3 p3Var, z8.g gVar, Boolean bool, String str, String str2, String str3, String str4, List list, long j10, u8.p pVar, u8.a aVar, List list2, List list3, int i) {
        long j11;
        long j12;
        String str5 = p3Var.f11875a;
        String str6 = p3Var.f11876b;
        String str7 = p3Var.f11877c;
        List list4 = p3Var.f11878d;
        String str8 = p3Var.f11879e;
        boolean z10 = p3Var.f11880f;
        boolean z11 = p3Var.f11881g;
        z8.g gVar2 = (i & 128) != 0 ? p3Var.f11882h : gVar;
        Boolean bool2 = (i & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0 ? p3Var.i : bool;
        String str9 = p3Var.f11883j;
        z8.g gVar3 = gVar2;
        Boolean bool3 = bool2;
        String str10 = p3Var.f11884k;
        String str11 = (i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? p3Var.f11885l : str;
        String str12 = p3Var.f11886m;
        String str13 = (i & 8192) != 0 ? p3Var.f11887n : str2;
        String str14 = (i & 16384) != 0 ? p3Var.f11888o : str3;
        String str15 = (i & 32768) != 0 ? p3Var.f11889p : str4;
        List list5 = (i & 65536) != 0 ? p3Var.f11890q : list;
        String str16 = p3Var.f11891r;
        String str17 = p3Var.f11892s;
        List list6 = p3Var.f11893t;
        String str18 = p3Var.f11894u;
        String str19 = str14;
        long j13 = p3Var.f11895v;
        if ((i & 4194304) != 0) {
            j11 = j13;
            j12 = p3Var.f11896w;
        } else {
            j11 = j13;
            j12 = j10;
        }
        boolean z12 = (i & 8388608) != 0 ? p3Var.f11897x : true;
        String str20 = p3Var.f11898y;
        u8.p pVar2 = (i & 33554432) != 0 ? p3Var.f11899z : pVar;
        u8.a aVar2 = (i & 67108864) != 0 ? p3Var.A : aVar;
        List list7 = (i & 134217728) != 0 ? p3Var.B : list2;
        List list8 = (i & 268435456) != 0 ? p3Var.C : list3;
        boolean z13 = (i & 536870912) != 0 ? p3Var.D : true;
        p3Var.getClass();
        str5.getClass();
        str6.getClass();
        str7.getClass();
        list4.getClass();
        gVar3.getClass();
        str12.getClass();
        str13.getClass();
        str19.getClass();
        list5.getClass();
        list6.getClass();
        str20.getClass();
        pVar2.getClass();
        list7.getClass();
        list8.getClass();
        return new p3(str5, str6, str7, list4, str8, z10, z11, gVar3, bool3, str9, str10, str11, str12, str13, str19, str15, list5, str16, str17, list6, str18, j11, j12, z12, str20, pVar2, aVar2, list7, list8, z13);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p3)) {
            return false;
        }
        p3 p3Var = (p3) obj;
        return yb.k.a(this.f11875a, p3Var.f11875a) && yb.k.a(this.f11876b, p3Var.f11876b) && yb.k.a(this.f11877c, p3Var.f11877c) && yb.k.a(this.f11878d, p3Var.f11878d) && yb.k.a(this.f11879e, p3Var.f11879e) && this.f11880f == p3Var.f11880f && this.f11881g == p3Var.f11881g && this.f11882h == p3Var.f11882h && yb.k.a(this.i, p3Var.i) && yb.k.a(this.f11883j, p3Var.f11883j) && yb.k.a(this.f11884k, p3Var.f11884k) && yb.k.a(this.f11885l, p3Var.f11885l) && yb.k.a(this.f11886m, p3Var.f11886m) && yb.k.a(this.f11887n, p3Var.f11887n) && yb.k.a(this.f11888o, p3Var.f11888o) && yb.k.a(this.f11889p, p3Var.f11889p) && yb.k.a(this.f11890q, p3Var.f11890q) && yb.k.a(this.f11891r, p3Var.f11891r) && yb.k.a(this.f11892s, p3Var.f11892s) && yb.k.a(this.f11893t, p3Var.f11893t) && yb.k.a(this.f11894u, p3Var.f11894u) && this.f11895v == p3Var.f11895v && this.f11896w == p3Var.f11896w && this.f11897x == p3Var.f11897x && yb.k.a(this.f11898y, p3Var.f11898y) && this.f11899z == p3Var.f11899z && yb.k.a(this.A, p3Var.A) && yb.k.a(this.B, p3Var.B) && yb.k.a(this.C, p3Var.C) && this.D == p3Var.D;
    }

    public final int hashCode() {
        int iE = androidx.activity.b.e(this.f11878d, androidx.activity.b.d(androidx.activity.b.d(this.f11875a.hashCode() * 31, 31, this.f11876b), 31, this.f11877c), 31);
        String str = this.f11879e;
        int iHashCode = (this.f11882h.hashCode() + k0.a.h(k0.a.h((iE + (str == null ? 0 : str.hashCode())) * 31, 31, this.f11880f), 31, this.f11881g)) * 31;
        Boolean bool = this.i;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.f11883j;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f11884k;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f11885l;
        int iD = androidx.activity.b.d(androidx.activity.b.d(androidx.activity.b.d((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31, 31, this.f11886m), 31, this.f11887n), 31, this.f11888o);
        String str5 = this.f11889p;
        int iE2 = androidx.activity.b.e(this.f11890q, (iD + (str5 == null ? 0 : str5.hashCode())) * 31, 31);
        String str6 = this.f11891r;
        int iHashCode5 = (iE2 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f11892s;
        int iE3 = androidx.activity.b.e(this.f11893t, (iHashCode5 + (str7 == null ? 0 : str7.hashCode())) * 31, 31);
        String str8 = this.f11894u;
        int iHashCode6 = (this.f11899z.hashCode() + androidx.activity.b.d(k0.a.h(k0.a.i(this.f11896w, k0.a.i(this.f11895v, (iE3 + (str8 == null ? 0 : str8.hashCode())) * 31, 31), 31), 31, this.f11897x), 31, this.f11898y)) * 31;
        u8.a aVar = this.A;
        return Boolean.hashCode(this.D) + androidx.activity.b.e(this.C, androidx.activity.b.e(this.B, (iHashCode6 + (aVar != null ? aVar.hashCode() : 0)) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sbP = androidx.activity.b.p("TimelineLine(what=", this.f11875a, ", displayWhat=", this.f11876b, ", time=");
        sbP.append(this.f11877c);
        sbP.append(", tags=");
        sbP.append(this.f11878d);
        sbP.append(", severity=");
        sbP.append(this.f11879e);
        sbP.append(", isIntercepted=");
        sbP.append(this.f11880f);
        sbP.append(", isInterceptedPending=");
        sbP.append(this.f11881g);
        sbP.append(", undoState=");
        sbP.append(this.f11882h);
        sbP.append(", undoableFromApi=");
        sbP.append(this.i);
        sbP.append(", undoDeadlineIso=");
        sbP.append(this.f11883j);
        sbP.append(", undoBannerText=");
        androidx.activity.b.u(sbP, this.f11884k, ", undoOutcomeText=", this.f11885l, ", stepId=");
        androidx.activity.b.u(sbP, this.f11886m, ", sessionId=", this.f11887n, ", taskId=");
        androidx.activity.b.u(sbP, this.f11888o, ", recoverPath=", this.f11889p, ", recoverPaths=");
        sbP.append(this.f11890q);
        sbP.append(", recoverPreviewUri=");
        sbP.append(this.f11891r);
        sbP.append(", recoverTrashPath=");
        sbP.append(this.f11892s);
        sbP.append(", attachmentUrls=");
        sbP.append(this.f11893t);
        sbP.append(", undoConfirmDescription=");
        sbP.append(this.f11894u);
        sbP.append(", executedAtMillis=");
        sbP.append(this.f11895v);
        sbP.append(", revokedAtMillis=");
        sbP.append(this.f11896w);
        sbP.append(", revokeTrashResolvable=");
        sbP.append(this.f11897x);
        sbP.append(", sourceApp=");
        sbP.append(this.f11898y);
        sbP.append(", undoDomain=");
        sbP.append(this.f11899z);
        sbP.append(", contactDisplay=");
        sbP.append(this.A);
        sbP.append(", contactDisplays=");
        sbP.append(this.B);
        sbP.append(", noteDisplays=");
        sbP.append(this.C);
        sbP.append(", undoLocallyEnriched=");
        sbP.append(this.D);
        sbP.append(")");
        return sbP.toString();
    }
}
