package S9;

import Z8.C1172u;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;

/* loaded from: classes5.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public final ReportLevel f5673a;

    /* renamed from: b, reason: collision with root package name */
    public final ReportLevel f5674b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<ga.c, ReportLevel> f5675c;

    /* renamed from: d, reason: collision with root package name */
    public final Y8.h f5676d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f5677e;

    /* JADX WARN: Multi-variable type inference failed */
    public D(ReportLevel globalLevel, ReportLevel reportLevel, Map<ga.c, ? extends ReportLevel> userDefinedLevelForSpecificAnnotation) {
        kotlin.jvm.internal.p.i(globalLevel, "globalLevel");
        kotlin.jvm.internal.p.i(userDefinedLevelForSpecificAnnotation, "userDefinedLevelForSpecificAnnotation");
        this.f5673a = globalLevel;
        this.f5674b = reportLevel;
        this.f5675c = userDefinedLevelForSpecificAnnotation;
        this.f5676d = C4848b.b(new C(this));
        ReportLevel reportLevel2 = ReportLevel.IGNORE;
        this.f5677e = globalLevel == reportLevel2 && reportLevel == reportLevel2 && userDefinedLevelForSpecificAnnotation.isEmpty();
    }

    public static final String[] b(D d10) {
        List listC = C1172u.c();
        listC.add(d10.f5673a.getDescription());
        ReportLevel reportLevel = d10.f5674b;
        if (reportLevel != null) {
            listC.add("under-migration:" + reportLevel.getDescription());
        }
        for (Map.Entry<ga.c, ReportLevel> entry : d10.f5675c.entrySet()) {
            listC.add('@' + entry.getKey() + ':' + entry.getValue().getDescription());
        }
        return (String[]) C1172u.a(listC).toArray(new String[0]);
    }

    public final ReportLevel c() {
        return this.f5673a;
    }

    public final ReportLevel d() {
        return this.f5674b;
    }

    public final Map<ga.c, ReportLevel> e() {
        return this.f5675c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d10 = (D) obj;
        return this.f5673a == d10.f5673a && this.f5674b == d10.f5674b && kotlin.jvm.internal.p.d(this.f5675c, d10.f5675c);
    }

    public final boolean f() {
        return this.f5677e;
    }

    public int hashCode() {
        int iHashCode = this.f5673a.hashCode() * 31;
        ReportLevel reportLevel = this.f5674b;
        return ((iHashCode + (reportLevel == null ? 0 : reportLevel.hashCode())) * 31) + this.f5675c.hashCode();
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.f5673a + ", migrationLevel=" + this.f5674b + ", userDefinedLevelForSpecificAnnotation=" + this.f5675c + ')';
    }

    public /* synthetic */ D(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, int i10, kotlin.jvm.internal.i iVar) {
        this(reportLevel, (i10 & 2) != 0 ? null : reportLevel2, (i10 & 4) != 0 ? kotlin.collections.a.i() : map);
    }
}
