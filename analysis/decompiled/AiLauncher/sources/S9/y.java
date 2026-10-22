package S9;

import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;

/* loaded from: classes5.dex */
public final class y {

    /* renamed from: d, reason: collision with root package name */
    public static final a f5788d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final y f5789e = new y(ReportLevel.STRICT, null, null, 6, null);

    /* renamed from: a, reason: collision with root package name */
    public final ReportLevel f5790a;

    /* renamed from: b, reason: collision with root package name */
    public final Y8.f f5791b;

    /* renamed from: c, reason: collision with root package name */
    public final ReportLevel f5792c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final y a() {
            return y.f5789e;
        }

        public a() {
        }
    }

    public y(ReportLevel reportLevelBefore, Y8.f fVar, ReportLevel reportLevelAfter) {
        kotlin.jvm.internal.p.i(reportLevelBefore, "reportLevelBefore");
        kotlin.jvm.internal.p.i(reportLevelAfter, "reportLevelAfter");
        this.f5790a = reportLevelBefore;
        this.f5791b = fVar;
        this.f5792c = reportLevelAfter;
    }

    public final ReportLevel b() {
        return this.f5792c;
    }

    public final ReportLevel c() {
        return this.f5790a;
    }

    public final Y8.f d() {
        return this.f5791b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f5790a == yVar.f5790a && kotlin.jvm.internal.p.d(this.f5791b, yVar.f5791b) && this.f5792c == yVar.f5792c;
    }

    public int hashCode() {
        int iHashCode = this.f5790a.hashCode() * 31;
        Y8.f fVar = this.f5791b;
        return ((iHashCode + (fVar == null ? 0 : fVar.getVersion())) * 31) + this.f5792c.hashCode();
    }

    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f5790a + ", sinceVersion=" + this.f5791b + ", reportLevelAfter=" + this.f5792c + ')';
    }

    public /* synthetic */ y(ReportLevel reportLevel, Y8.f fVar, ReportLevel reportLevel2, int i10, kotlin.jvm.internal.i iVar) {
        this(reportLevel, (i10 & 2) != 0 ? new Y8.f(1, 0) : fVar, (i10 & 4) != 0 ? reportLevel : reportLevel2);
    }
}
