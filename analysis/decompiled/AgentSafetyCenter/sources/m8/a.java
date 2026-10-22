package m8;

import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import s8.a3;
import s8.b2;
import s8.d1;
import s8.g1;
import s8.t3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {
    public final List A;
    public final List B;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f8269a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8270b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8271c;

    /* renamed from: d, reason: collision with root package name */
    public final s8.t f8272d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8273e;

    /* renamed from: f, reason: collision with root package name */
    public final Set f8274f;

    /* renamed from: g, reason: collision with root package name */
    public final Set f8275g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f8276h;
    public final l0 i;

    /* renamed from: j, reason: collision with root package name */
    public final d1 f8277j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8278k;

    /* renamed from: l, reason: collision with root package name */
    public final s8.t f8279l;

    /* renamed from: m, reason: collision with root package name */
    public final s8.t f8280m;

    /* renamed from: n, reason: collision with root package name */
    public final k8.a f8281n;

    /* renamed from: o, reason: collision with root package name */
    public final List f8282o;

    /* renamed from: p, reason: collision with root package name */
    public final List f8283p;

    /* renamed from: q, reason: collision with root package name */
    public final int f8284q;

    /* renamed from: r, reason: collision with root package name */
    public final s8.t f8285r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f8286s;

    /* renamed from: t, reason: collision with root package name */
    public final a3 f8287t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f8288u;

    /* renamed from: v, reason: collision with root package name */
    public final String f8289v;

    /* renamed from: w, reason: collision with root package name */
    public final String f8290w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f8291x;

    /* renamed from: y, reason: collision with root package name */
    public final int f8292y;

    /* renamed from: z, reason: collision with root package name */
    public final b2 f8293z;

    public a(boolean z10, String str, String str2, s8.t tVar, int i, Set set, Set set2, boolean z11, l0 l0Var, d1 d1Var, int i3, s8.t tVar2, s8.t tVar3, k8.a aVar, List list, List list2, int i10, s8.t tVar4, boolean z12, a3 a3Var, boolean z13, String str3, String str4, boolean z14, int i11, b2 b2Var, List list3, List list4) {
        set.getClass();
        set2.getClass();
        l0Var.getClass();
        d1Var.getClass();
        list.getClass();
        list2.getClass();
        list3.getClass();
        list4.getClass();
        this.f8269a = z10;
        this.f8270b = str;
        this.f8271c = str2;
        this.f8272d = tVar;
        this.f8273e = i;
        this.f8274f = set;
        this.f8275g = set2;
        this.f8276h = z11;
        this.i = l0Var;
        this.f8277j = d1Var;
        this.f8278k = i3;
        this.f8279l = tVar2;
        this.f8280m = tVar3;
        this.f8281n = aVar;
        this.f8282o = list;
        this.f8283p = list2;
        this.f8284q = i10;
        this.f8285r = tVar4;
        this.f8286s = z12;
        this.f8287t = a3Var;
        this.f8288u = z13;
        this.f8289v = str3;
        this.f8290w = str4;
        this.f8291x = z14;
        this.f8292y = i11;
        this.f8293z = b2Var;
        this.A = list3;
        this.B = list4;
    }

    public static a a(a aVar, boolean z10, String str, String str2, s8.t tVar, int i, Set set, Set set2, boolean z11, l0 l0Var, d1 d1Var, int i3, s8.t tVar2, s8.t tVar3, k8.a aVar2, List list, List list2, int i10, s8.t tVar4, boolean z12, a3 a3Var, boolean z13, String str3, String str4, boolean z14, int i11, b2 b2Var, List list3, List list4, int i12) {
        boolean z15 = (i12 & 1) != 0 ? aVar.f8269a : z10;
        String str5 = (i12 & 2) != 0 ? aVar.f8270b : str;
        String str6 = (i12 & 4) != 0 ? aVar.f8271c : str2;
        s8.t tVar5 = (i12 & 8) != 0 ? aVar.f8272d : tVar;
        int i13 = (i12 & 16) != 0 ? aVar.f8273e : i;
        Set set3 = (i12 & 32) != 0 ? aVar.f8274f : set;
        Set set4 = (i12 & 64) != 0 ? aVar.f8275g : set2;
        boolean z16 = (i12 & 128) != 0 ? aVar.f8276h : z11;
        l0 l0Var2 = (i12 & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0 ? aVar.i : l0Var;
        d1 d1Var2 = (i12 & 512) != 0 ? aVar.f8277j : d1Var;
        int i14 = (i12 & 1024) != 0 ? aVar.f8278k : i3;
        s8.t tVar6 = (i12 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? aVar.f8279l : tVar2;
        s8.t tVar7 = (i12 & 4096) != 0 ? aVar.f8280m : tVar3;
        k8.a aVar3 = (i12 & 8192) != 0 ? aVar.f8281n : aVar2;
        boolean z17 = z15;
        List list5 = (i12 & 16384) != 0 ? aVar.f8282o : list;
        List list6 = (i12 & 32768) != 0 ? aVar.f8283p : list2;
        int i15 = (i12 & 65536) != 0 ? aVar.f8284q : i10;
        s8.t tVar8 = (i12 & 131072) != 0 ? aVar.f8285r : tVar4;
        boolean z18 = (i12 & 262144) != 0 ? aVar.f8286s : z12;
        a3 a3Var2 = (i12 & 524288) != 0 ? aVar.f8287t : a3Var;
        boolean z19 = (i12 & 1048576) != 0 ? aVar.f8288u : z13;
        String str7 = (i12 & 2097152) != 0 ? aVar.f8289v : str3;
        String str8 = (i12 & 4194304) != 0 ? aVar.f8290w : str4;
        aVar.getClass();
        aVar.getClass();
        String str9 = str8;
        boolean z20 = (i12 & 33554432) != 0 ? aVar.f8291x : z14;
        int i16 = (i12 & 67108864) != 0 ? aVar.f8292y : i11;
        b2 b2Var2 = (i12 & 134217728) != 0 ? aVar.f8293z : b2Var;
        List list7 = (i12 & 268435456) != 0 ? aVar.A : list3;
        List list8 = (i12 & 536870912) != 0 ? aVar.B : list4;
        aVar.getClass();
        tVar5.getClass();
        set3.getClass();
        set4.getClass();
        l0Var2.getClass();
        d1Var2.getClass();
        list5.getClass();
        list6.getClass();
        list7.getClass();
        list8.getClass();
        return new a(z17, str5, str6, tVar5, i13, set3, set4, z16, l0Var2, d1Var2, i14, tVar6, tVar7, aVar3, list5, list6, i15, tVar8, z18, a3Var2, z19, str7, str9, z20, i16, b2Var2, list7, list8);
    }

    public final s8.t b() {
        s8.t tVar = this.f8285r;
        return (tVar == null && (tVar = this.f8279l) == null) ? this.f8272d : tVar;
    }

    public final ArrayList c() {
        k8.a aVar;
        Iterable iterableO = kb.s.f7404c;
        s8.t tVar = this.f8280m;
        if (tVar != null && (aVar = this.f8281n) != null) {
            ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
            List list = tVar.f11967e;
            zoneIdSystemDefault.getClass();
            iterableO = g1.o(list, aVar, zoneIdSystemDefault);
        }
        Set set = this.f8275g;
        set.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterableO) {
            if (!set.contains(g1.P((t3) obj))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8269a == aVar.f8269a && this.f8270b.equals(aVar.f8270b) && yb.k.a(this.f8271c, aVar.f8271c) && this.f8272d.equals(aVar.f8272d) && this.f8273e == aVar.f8273e && yb.k.a(this.f8274f, aVar.f8274f) && yb.k.a(this.f8275g, aVar.f8275g) && this.f8276h == aVar.f8276h && this.i == aVar.i && this.f8277j == aVar.f8277j && this.f8278k == aVar.f8278k && yb.k.a(this.f8279l, aVar.f8279l) && yb.k.a(this.f8280m, aVar.f8280m) && yb.k.a(this.f8281n, aVar.f8281n) && yb.k.a(this.f8282o, aVar.f8282o) && yb.k.a(this.f8283p, aVar.f8283p) && this.f8284q == aVar.f8284q && yb.k.a(this.f8285r, aVar.f8285r) && this.f8286s == aVar.f8286s && yb.k.a(this.f8287t, aVar.f8287t) && this.f8288u == aVar.f8288u && yb.k.a(this.f8289v, aVar.f8289v) && yb.k.a(this.f8290w, aVar.f8290w) && this.f8291x == aVar.f8291x && this.f8292y == aVar.f8292y && yb.k.a(this.f8293z, aVar.f8293z) && yb.k.a(this.A, aVar.A) && yb.k.a(this.B, aVar.B);
    }

    public final int hashCode() {
        int iD = androidx.activity.b.d(Boolean.hashCode(this.f8269a) * 31, 31, this.f8270b);
        String str = this.f8271c;
        int iB = s.f.b(this.f8278k, (this.f8277j.hashCode() + ((this.i.hashCode() + k0.a.h((this.f8275g.hashCode() + ((this.f8274f.hashCode() + s.f.b(this.f8273e, (this.f8272d.hashCode() + ((iD + (str == null ? 0 : str.hashCode())) * 31)) * 31, 31)) * 31)) * 31, 31, this.f8276h)) * 31)) * 31, 31);
        s8.t tVar = this.f8279l;
        int iHashCode = (iB + (tVar == null ? 0 : tVar.hashCode())) * 31;
        s8.t tVar2 = this.f8280m;
        int iHashCode2 = (iHashCode + (tVar2 == null ? 0 : tVar2.hashCode())) * 31;
        k8.a aVar = this.f8281n;
        int iB2 = s.f.b(this.f8284q, androidx.activity.b.e(this.f8283p, androidx.activity.b.e(this.f8282o, (iHashCode2 + (aVar == null ? 0 : aVar.hashCode())) * 31, 31), 31), 31);
        s8.t tVar3 = this.f8285r;
        int iH = k0.a.h((iB2 + (tVar3 == null ? 0 : tVar3.hashCode())) * 31, 31, this.f8286s);
        a3 a3Var = this.f8287t;
        int iH2 = k0.a.h((iH + (a3Var == null ? 0 : a3Var.hashCode())) * 31, 31, this.f8288u);
        String str2 = this.f8289v;
        int iHashCode3 = (iH2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f8290w;
        int iB3 = s.f.b(this.f8292y, k0.a.h(s.f.b(0, k0.a.h((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31, 31, false), 31), 31, this.f8291x), 31);
        b2 b2Var = this.f8293z;
        return this.B.hashCode() + androidx.activity.b.e(this.A, (iB3 + (b2Var != null ? b2Var.hashCode() : 0)) * 31, 31);
    }

    public final String toString() {
        return "BehaviorAnalysisUiState(isRunning=" + this.f8269a + ", progressLog=" + this.f8270b + ", error=" + this.f8271c + ", dashboard=" + this.f8272d + ", pendingInterceptCount=" + this.f8273e + ", viewedInterceptRowKeys=" + this.f8274f + ", viewedUndoableKeys=" + this.f8275g + ", usingLiveDashboard=" + this.f8276h + ", dashboardSource=" + this.i + ", homeChartPeriod=" + this.f8277j + ", homeSelectedBarIndex=" + this.f8278k + ", homePeriodDashboard=" + this.f8279l + ", homeUndoableDashboard=" + this.f8280m + ", homeUndoableFocus=" + this.f8281n + ", homeAllChartBars=" + this.f8282o + ", homeMonthChartBars=" + this.f8283p + ", homePeriodPendingInterceptCount=" + this.f8284q + ", actionListDashboard=" + this.f8285r + ", isActionListLoading=" + this.f8286s + ", revokeDialogRequest=" + this.f8287t + ", isRevokeInProgress=" + this.f8288u + ", revokeError=" + this.f8289v + ", revokeToastMessage=" + this.f8290w + ", acceptancePreviewActive=false, acceptancePreviewDayCount=0, isAgentTaskRunning=" + this.f8291x + ", runningTaskCount=" + this.f8292y + ", homeSecurityReport=" + this.f8293z + ", homeTodayUnviewedPendingRows=" + this.A + ", homeTodayInterceptCardRows=" + this.B + ")";
    }
}
