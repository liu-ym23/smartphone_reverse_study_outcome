package q8;

import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;

/* renamed from: q8.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1844q {
    public static final C1844q d = new C1844q(ReportLevel.d, 6);

    /* renamed from: a, reason: collision with root package name */
    public final ReportLevel f5607a;
    public final C7.e b;
    public final ReportLevel c;

    public C1844q(ReportLevel reportLevel, C7.e eVar, ReportLevel reportLevel2) {
        this.f5607a = reportLevel;
        this.b = eVar;
        this.c = reportLevel2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1844q)) {
            return false;
        }
        C1844q c1844q = (C1844q) obj;
        return this.f5607a == c1844q.f5607a && kotlin.jvm.internal.k.b(this.b, c1844q.b) && this.c == c1844q.c;
    }

    public final int hashCode() {
        int iHashCode = this.f5607a.hashCode() * 31;
        C7.e eVar = this.b;
        return this.c.hashCode() + ((iHashCode + (eVar == null ? 0 : eVar.d)) * 31);
    }

    public final String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f5607a + ", sinceVersion=" + this.b + ", reportLevelAfter=" + this.c + ')';
    }

    public C1844q(ReportLevel reportLevel, int i) {
        this(reportLevel, (i & 2) != 0 ? new C7.e(1, 0, 0) : null, reportLevel);
    }
}
