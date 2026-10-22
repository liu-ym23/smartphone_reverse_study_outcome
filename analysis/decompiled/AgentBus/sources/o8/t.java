package o8;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: c, reason: collision with root package name */
    public static final t f7848c;

    /* renamed from: a, reason: collision with root package name */
    public final v f7849a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7850b;

    static {
        e9.c cVar = q.f7839a;
        c7.e eVar = c7.e.f1965j;
        q7.k.e(eVar, "configuredKotlinVersion");
        r rVar = q.f7842d;
        c7.e eVar2 = rVar.f7845b;
        b0 b0Var = (eVar2 == null || eVar2.f1969i - eVar.f1969i > 0) ? rVar.f7844a : rVar.f7846c;
        q7.k.e(b0Var, "globalReportLevel");
        v vVar = new v(b0Var, b0Var == b0.WARN ? null : b0Var);
        s sVar = s.f7847n;
        f7848c = new t(vVar);
    }

    public t(v vVar) {
        s sVar = s.f7847n;
        this.f7849a = vVar;
        this.f7850b = vVar.f7855d || sVar.invoke(q.f7839a) == b0.IGNORE;
    }

    public final String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.f7849a + ", getReportLevelForAnnotation=" + s.f7847n + ')';
    }
}
