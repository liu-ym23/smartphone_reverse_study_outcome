package s8;

import com.fasterxml.jackson.core.ErrorReportConfiguration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f11792a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11793b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11794c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11795d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11796e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11797f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11798g;

    /* renamed from: h, reason: collision with root package name */
    public final long f11799h;
    public final String i;

    public /* synthetic */ m1(String str, float f5, boolean z10, long j10, int i, int i3, int i10, String str2, int i11) {
        this(str, f5, z10, (i11 & 8) != 0 ? 0L : j10, (i11 & 16) != 0 ? 0 : i, (i11 & 32) != 0 ? 0 : i3, (i11 & 64) != 0 ? 0 : i10, 0L, (i11 & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0 ? null : str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return yb.k.a(this.f11792a, m1Var.f11792a) && Float.compare(this.f11793b, m1Var.f11793b) == 0 && this.f11794c == m1Var.f11794c && this.f11795d == m1Var.f11795d && this.f11796e == m1Var.f11796e && this.f11797f == m1Var.f11797f && this.f11798g == m1Var.f11798g && this.f11799h == m1Var.f11799h && yb.k.a(this.i, m1Var.i);
    }

    public final int hashCode() {
        int i = k0.a.i(this.f11799h, s.f.b(this.f11798g, s.f.b(this.f11797f, s.f.b(this.f11796e, k0.a.i(this.f11795d, k0.a.h(k0.a.g(this.f11792a.hashCode() * 31, this.f11793b, 31), 31, this.f11794c), 31), 31), 31), 31), 31);
        String str = this.i;
        return i + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "DayBar(label=" + this.f11792a + ", heightFraction=" + this.f11793b + ", isToday=" + this.f11794c + ", anchorDateMillis=" + this.f11795d + ", barOpsCount=" + this.f11796e + ", barRiskCount=" + this.f11797f + ", barUndoableCount=" + this.f11798g + ", rangeStartMillis=" + this.f11799h + ", tooltipTitle=" + this.i + ")";
    }

    public m1(String str, float f5, boolean z10, long j10, int i, int i3, int i10, long j11, String str2) {
        str.getClass();
        this.f11792a = str;
        this.f11793b = f5;
        this.f11794c = z10;
        this.f11795d = j10;
        this.f11796e = i;
        this.f11797f = i3;
        this.f11798g = i10;
        this.f11799h = j11;
        this.i = str2;
    }
}
