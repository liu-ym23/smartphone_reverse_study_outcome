package q8;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;

/* renamed from: q8.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1846s {

    /* renamed from: a, reason: collision with root package name */
    public final ReportLevel f5609a;
    public final ReportLevel b;
    public final Map c;
    public final boolean d;

    public C1846s(ReportLevel reportLevel, ReportLevel reportLevel2) {
        Map mapM = kotlin.collections.a.M();
        this.f5609a = reportLevel;
        this.b = reportLevel2;
        this.c = mapM;
        kotlin.a.a(new I8.e(this, 27));
        ReportLevel reportLevel3 = ReportLevel.b;
        this.d = reportLevel == reportLevel3 && reportLevel2 == reportLevel3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1846s)) {
            return false;
        }
        C1846s c1846s = (C1846s) obj;
        return this.f5609a == c1846s.f5609a && this.b == c1846s.b && kotlin.jvm.internal.k.b(this.c, c1846s.c);
    }

    public final int hashCode() {
        int iHashCode = this.f5609a.hashCode() * 31;
        ReportLevel reportLevel = this.b;
        return this.c.hashCode() + ((iHashCode + (reportLevel == null ? 0 : reportLevel.hashCode())) * 31);
    }

    public final String toString() {
        return "Jsr305Settings(globalLevel=" + this.f5609a + ", migrationLevel=" + this.b + ", userDefinedLevelForSpecificAnnotation=" + this.c + ')';
    }
}
