package o8;

/* loaded from: classes.dex */
public final /* synthetic */ class s extends q7.h implements p7.k {

    /* renamed from: n, reason: collision with root package name */
    public static final s f7847n = new s(1);

    @Override // q7.c
    public final String A() {
        return "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;";
    }

    @Override // q7.c, w7.c
    public final String getName() {
        return "getDefaultReportLevelForAnnotation";
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        e9.c cVar = (e9.c) obj;
        q7.k.e(cVar, "p0");
        e9.c cVar2 = q.f7839a;
        a0.f7779e.getClass();
        nb.f fVar = z.f7892b;
        c7.e eVar = new c7.e(1, 7, 20);
        q7.k.e(fVar, "configuredReportLevels");
        b0 b0Var = (b0) ((b0.e) fVar.f6948h).invoke(cVar);
        if (b0Var != null) {
            return b0Var;
        }
        nb.f fVar2 = q.f7841c;
        fVar2.getClass();
        r rVar = (r) ((b0.e) fVar2.f6948h).invoke(cVar);
        if (rVar == null) {
            return b0.IGNORE;
        }
        c7.e eVar2 = rVar.f7845b;
        return (eVar2 == null || eVar2.f1969i - eVar.f1969i > 0) ? rVar.f7844a : rVar.f7846c;
    }

    @Override // q7.c
    public final w7.f y() {
        return q7.w.f8821a.c(q.class, "compiler.common.jvm");
    }
}
