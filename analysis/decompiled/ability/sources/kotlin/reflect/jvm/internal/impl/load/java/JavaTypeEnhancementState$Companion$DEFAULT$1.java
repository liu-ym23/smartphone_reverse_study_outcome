package kotlin.reflect.jvm.internal.impl.load.java;

import C7.e;
import G8.c;
import S7.k;
import Z7.f;
import fa.C1449a;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.storage.b;
import q8.AbstractC1843p;
import q8.C1844q;
import q8.w;
import q8.x;

/* loaded from: classes4.dex */
final /* synthetic */ class JavaTypeEnhancementState$Companion$DEFAULT$1 extends FunctionReference implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final JavaTypeEnhancementState$Companion$DEFAULT$1 f4988a = new JavaTypeEnhancementState$Companion$DEFAULT$1();

    public JavaTypeEnhancementState$Companion$DEFAULT$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return "getDefaultReportLevelForAnnotation";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.c(AbstractC1843p.class, "compiler.common.jvm");
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;";
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        c p02 = (c) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        c cVar = AbstractC1843p.f5606a;
        x.f5618K.getClass();
        C1449a configuredReportLevels = w.b;
        e eVar = new e(1, 7, 20);
        kotlin.jvm.internal.k.f(configuredReportLevels, "configuredReportLevels");
        ReportLevel reportLevel = (ReportLevel) ((b) configuredReportLevels.c).invoke(p02);
        if (reportLevel != null) {
            return reportLevel;
        }
        C1449a c1449a = AbstractC1843p.c;
        c1449a.getClass();
        C1844q c1844q = (C1844q) ((b) c1449a.c).invoke(p02);
        if (c1844q == null) {
            return ReportLevel.b;
        }
        e eVar2 = c1844q.b;
        return (eVar2 == null || eVar2.d - eVar.d > 0) ? c1844q.f5607a : c1844q.c;
    }
}
