package S9;

import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final class A {

    /* renamed from: d, reason: collision with root package name */
    public static final a f5667d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final D f5668a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5074l<ga.c, ReportLevel> f5669b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5670c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final ReportLevel c(Y8.f fVar, ga.c it) {
            kotlin.jvm.internal.p.i(it, "it");
            return x.c(it, fVar);
        }

        public final A b(Y8.f kotlinVersion) {
            kotlin.jvm.internal.p.i(kotlinVersion, "kotlinVersion");
            return new A(x.a(kotlinVersion), new z(kotlinVersion));
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public A(D jsr305, InterfaceC5074l<? super ga.c, ? extends ReportLevel> getReportLevelForAnnotation) {
        kotlin.jvm.internal.p.i(jsr305, "jsr305");
        kotlin.jvm.internal.p.i(getReportLevelForAnnotation, "getReportLevelForAnnotation");
        this.f5668a = jsr305;
        this.f5669b = getReportLevelForAnnotation;
        this.f5670c = jsr305.f() || getReportLevelForAnnotation.invoke(x.d()) == ReportLevel.IGNORE;
    }

    public final boolean a() {
        return this.f5670c;
    }

    public final InterfaceC5074l<ga.c, ReportLevel> b() {
        return this.f5669b;
    }

    public final D c() {
        return this.f5668a;
    }

    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.f5668a + ", getReportLevelForAnnotation=" + this.f5669b + ')';
    }
}
