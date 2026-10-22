package S9;

import S9.y;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;

/* loaded from: classes5.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final ga.c f5780a;

    /* renamed from: b, reason: collision with root package name */
    public static final ga.c f5781b;

    /* renamed from: c, reason: collision with root package name */
    public static final ga.c f5782c;

    /* renamed from: d, reason: collision with root package name */
    public static final ga.c f5783d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f5784e;

    /* renamed from: f, reason: collision with root package name */
    public static final ga.c[] f5785f;

    /* renamed from: g, reason: collision with root package name */
    public static final H<y> f5786g;

    /* renamed from: h, reason: collision with root package name */
    public static final y f5787h;

    static {
        ga.c cVar = new ga.c("org.jspecify.nullness");
        f5780a = cVar;
        ga.c cVar2 = new ga.c("org.jspecify.annotations");
        f5781b = cVar2;
        ga.c cVar3 = new ga.c("io.reactivex.rxjava3.annotations");
        f5782c = cVar3;
        ga.c cVar4 = new ga.c("org.checkerframework.checker.nullness.compatqual");
        f5783d = cVar4;
        String strA = cVar3.a();
        f5784e = strA;
        f5785f = new ga.c[]{new ga.c(strA + ".Nullable"), new ga.c(strA + ".NonNull")};
        ga.c cVar5 = new ga.c("org.jetbrains.annotations");
        y.a aVar = y.f5788d;
        Pair pairA = Y8.j.a(cVar5, aVar.a());
        Pair pairA2 = Y8.j.a(new ga.c("androidx.annotation"), aVar.a());
        Pair pairA3 = Y8.j.a(new ga.c("android.support.annotation"), aVar.a());
        Pair pairA4 = Y8.j.a(new ga.c("android.annotation"), aVar.a());
        Pair pairA5 = Y8.j.a(new ga.c("com.android.annotations"), aVar.a());
        Pair pairA6 = Y8.j.a(new ga.c("org.eclipse.jdt.annotation"), aVar.a());
        Pair pairA7 = Y8.j.a(new ga.c("org.checkerframework.checker.nullness.qual"), aVar.a());
        Pair pairA8 = Y8.j.a(cVar4, aVar.a());
        Pair pairA9 = Y8.j.a(new ga.c("javax.annotation"), aVar.a());
        Pair pairA10 = Y8.j.a(new ga.c("edu.umd.cs.findbugs.annotations"), aVar.a());
        Pair pairA11 = Y8.j.a(new ga.c("io.reactivex.annotations"), aVar.a());
        ga.c cVar6 = new ga.c("androidx.annotation.RecentlyNullable");
        ReportLevel reportLevel = ReportLevel.WARN;
        Pair pairA12 = Y8.j.a(cVar6, new y(reportLevel, null, null, 4, null));
        Pair pairA13 = Y8.j.a(new ga.c("androidx.annotation.RecentlyNonNull"), new y(reportLevel, null, null, 4, null));
        Pair pairA14 = Y8.j.a(new ga.c("lombok"), aVar.a());
        Y8.f fVar = new Y8.f(2, 1);
        ReportLevel reportLevel2 = ReportLevel.STRICT;
        f5786g = new J(kotlin.collections.a.m(pairA, pairA2, pairA3, pairA4, pairA5, pairA6, pairA7, pairA8, pairA9, pairA10, pairA11, pairA12, pairA13, pairA14, Y8.j.a(cVar, new y(reportLevel, fVar, reportLevel2)), Y8.j.a(cVar2, new y(reportLevel, new Y8.f(2, 1), reportLevel2)), Y8.j.a(cVar3, new y(reportLevel, new Y8.f(1, 8), reportLevel2)), Y8.j.a(new ga.c("jakarta.annotation"), new y(reportLevel, new Y8.f(2, 4), reportLevel2))));
        f5787h = new y(reportLevel, null, null, 4, null);
    }

    public static final D a(Y8.f configuredKotlinVersion) {
        kotlin.jvm.internal.p.i(configuredKotlinVersion, "configuredKotlinVersion");
        y yVar = f5787h;
        ReportLevel reportLevelC = (yVar.d() == null || yVar.d().compareTo(configuredKotlinVersion) > 0) ? yVar.c() : yVar.b();
        return new D(reportLevelC, b(reportLevelC), null, 4, null);
    }

    public static final ReportLevel b(ReportLevel globalReportLevel) {
        kotlin.jvm.internal.p.i(globalReportLevel, "globalReportLevel");
        if (globalReportLevel == ReportLevel.WARN) {
            return null;
        }
        return globalReportLevel;
    }

    public static final ReportLevel c(ga.c annotationFqName, Y8.f configuredKotlinVersion) {
        kotlin.jvm.internal.p.i(annotationFqName, "annotationFqName");
        kotlin.jvm.internal.p.i(configuredKotlinVersion, "configuredKotlinVersion");
        return f(annotationFqName, H.f5731a.a(), configuredKotlinVersion);
    }

    public static final ga.c d() {
        return f5781b;
    }

    public static final ga.c[] e() {
        return f5785f;
    }

    public static final ReportLevel f(ga.c annotation, H<? extends ReportLevel> configuredReportLevels, Y8.f configuredKotlinVersion) {
        kotlin.jvm.internal.p.i(annotation, "annotation");
        kotlin.jvm.internal.p.i(configuredReportLevels, "configuredReportLevels");
        kotlin.jvm.internal.p.i(configuredKotlinVersion, "configuredKotlinVersion");
        ReportLevel reportLevelA = configuredReportLevels.a(annotation);
        if (reportLevelA != null) {
            return reportLevelA;
        }
        y yVarA = f5786g.a(annotation);
        return yVarA == null ? ReportLevel.IGNORE : (yVarA.d() == null || yVarA.d().compareTo(configuredKotlinVersion) > 0) ? yVarA.c() : yVarA.b();
    }
}
