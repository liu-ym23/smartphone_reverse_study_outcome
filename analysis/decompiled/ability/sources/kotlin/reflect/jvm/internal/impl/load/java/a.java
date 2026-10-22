package kotlin.reflect.jvm.internal.impl.load.java;

import C7.e;
import G8.c;
import S7.k;
import q8.AbstractC1843p;
import q8.C1844q;
import q8.C1846s;

/* loaded from: classes4.dex */
public final class a {
    public static final a d;

    /* renamed from: a, reason: collision with root package name */
    public final C1846s f4992a;
    public final k b;
    public final boolean c;

    static {
        c cVar = AbstractC1843p.f5606a;
        e configuredKotlinVersion = e.e;
        kotlin.jvm.internal.k.f(configuredKotlinVersion, "configuredKotlinVersion");
        C1844q c1844q = AbstractC1843p.d;
        e eVar = c1844q.b;
        ReportLevel globalReportLevel = (eVar == null || eVar.d - configuredKotlinVersion.d > 0) ? c1844q.f5607a : c1844q.c;
        kotlin.jvm.internal.k.f(globalReportLevel, "globalReportLevel");
        d = new a(new C1846s(globalReportLevel, globalReportLevel == ReportLevel.c ? null : globalReportLevel), JavaTypeEnhancementState$Companion$DEFAULT$1.f4988a);
    }

    public a(C1846s c1846s, k getReportLevelForAnnotation) {
        kotlin.jvm.internal.k.f(getReportLevelForAnnotation, "getReportLevelForAnnotation");
        this.f4992a = c1846s;
        this.b = getReportLevelForAnnotation;
        this.c = c1846s.d || getReportLevelForAnnotation.invoke(AbstractC1843p.f5606a) == ReportLevel.b;
    }

    public final String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.f4992a + ", getReportLevelForAnnotation=" + this.b + ')';
    }
}
