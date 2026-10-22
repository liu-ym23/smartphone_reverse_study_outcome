package s8;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j3 {

    /* renamed from: a, reason: collision with root package name */
    public final String f11698a;

    /* renamed from: b, reason: collision with root package name */
    public final List f11699b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11700c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11701d;

    /* renamed from: e, reason: collision with root package name */
    public final List f11702e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11703f;

    /* renamed from: g, reason: collision with root package name */
    public final String f11704g;

    /* renamed from: h, reason: collision with root package name */
    public final String f11705h;
    public final long i;

    /* renamed from: j, reason: collision with root package name */
    public final String f11706j;

    public j3(String str, List list, int i, int i3, List list2, String str2, String str3, String str4, long j10, String str5) {
        list.getClass();
        str2.getClass();
        str3.getClass();
        this.f11698a = str;
        this.f11699b = list;
        this.f11700c = i;
        this.f11701d = i3;
        this.f11702e = list2;
        this.f11703f = str2;
        this.f11704g = str3;
        this.f11705h = str4;
        this.i = j10;
        this.f11706j = str5;
    }

    public static j3 a(j3 j3Var, List list, int i, int i3, List list2, String str, int i10) {
        String str2 = j3Var.f11698a;
        if ((i10 & 2) != 0) {
            list = j3Var.f11699b;
        }
        List list3 = list;
        if ((i10 & 4) != 0) {
            i = j3Var.f11700c;
        }
        int i11 = i;
        int i12 = (i10 & 8) != 0 ? j3Var.f11701d : i3;
        List list4 = (i10 & 16) != 0 ? j3Var.f11702e : list2;
        String str3 = j3Var.f11703f;
        String str4 = j3Var.f11704g;
        String str5 = (i10 & 128) != 0 ? j3Var.f11705h : str;
        long j10 = j3Var.i;
        String str6 = j3Var.f11706j;
        j3Var.getClass();
        list3.getClass();
        list4.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        return new j3(str2, list3, i11, i12, list4, str3, str4, str5, j10, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j3)) {
            return false;
        }
        j3 j3Var = (j3) obj;
        return this.f11698a.equals(j3Var.f11698a) && yb.k.a(this.f11699b, j3Var.f11699b) && this.f11700c == j3Var.f11700c && this.f11701d == j3Var.f11701d && this.f11702e.equals(j3Var.f11702e) && yb.k.a(this.f11703f, j3Var.f11703f) && yb.k.a(this.f11704g, j3Var.f11704g) && this.f11705h.equals(j3Var.f11705h) && this.i == j3Var.i && this.f11706j.equals(j3Var.f11706j);
    }

    public final int hashCode() {
        return this.f11706j.hashCode() + k0.a.i(this.i, androidx.activity.b.d(androidx.activity.b.d(androidx.activity.b.d(androidx.activity.b.e(this.f11702e, s.f.b(this.f11701d, s.f.b(this.f11700c, androidx.activity.b.e(this.f11699b, this.f11698a.hashCode() * 31, 31), 31), 31), 31), 31, this.f11703f), 31, this.f11704g), 31, this.f11705h), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TaskTimelineGroup(title=");
        sb2.append(this.f11698a);
        sb2.append(", visibleLines=");
        sb2.append(this.f11699b);
        sb2.append(", collapsedCount=");
        sb2.append(this.f11700c);
        sb2.append(", totalLineCount=");
        sb2.append(this.f11701d);
        sb2.append(", allLinesForDetail=");
        sb2.append(this.f11702e);
        sb2.append(", userAsk=");
        sb2.append(this.f11703f);
        sb2.append(", summaryIntro=");
        androidx.activity.b.u(sb2, this.f11704g, ", headerTime=", this.f11705h, ", sessionStartOfDayMillis=");
        sb2.append(this.i);
        sb2.append(", sessionId=");
        sb2.append(this.f11706j);
        sb2.append(")");
        return sb2.toString();
    }
}
