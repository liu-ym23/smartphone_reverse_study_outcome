package T9;

import C9.o;
import S9.F;
import W9.C1101j;
import Z9.InterfaceC1178a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import ga.b;
import java.util.Map;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f5891a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final ga.e f5892b;

    /* renamed from: c, reason: collision with root package name */
    public static final ga.e f5893c;

    /* renamed from: d, reason: collision with root package name */
    public static final ga.e f5894d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map<ga.c, ga.c> f5895e;

    static {
        ga.e eVarJ = ga.e.j("message");
        p.h(eVarJ, "identifier(...)");
        f5892b = eVarJ;
        ga.e eVarJ2 = ga.e.j("allowedTargets");
        p.h(eVarJ2, "identifier(...)");
        f5893c = eVarJ2;
        ga.e eVarJ3 = ga.e.j(UxipConstants.f30680s);
        p.h(eVarJ3, "identifier(...)");
        f5894d = eVarJ3;
        f5895e = kotlin.collections.a.m(Y8.j.a(o.a.f1860H, F.f5686d), Y8.j.a(o.a.f1868L, F.f5688f), Y8.j.a(o.a.f1876P, F.f5691i));
    }

    public static /* synthetic */ F9.c f(d dVar, InterfaceC1178a interfaceC1178a, V9.k kVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return dVar.e(interfaceC1178a, kVar, z10);
    }

    public final F9.c a(ga.c kotlinName, Z9.d annotationOwner, V9.k c10) {
        InterfaceC1178a interfaceC1178aD;
        p.i(kotlinName, "kotlinName");
        p.i(annotationOwner, "annotationOwner");
        p.i(c10, "c");
        if (p.d(kotlinName, o.a.f1942y)) {
            ga.c DEPRECATED_ANNOTATION = F.f5690h;
            p.h(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
            InterfaceC1178a interfaceC1178aD2 = annotationOwner.d(DEPRECATED_ANNOTATION);
            if (interfaceC1178aD2 != null || annotationOwner.A()) {
                return new h(interfaceC1178aD2, c10);
            }
        }
        ga.c cVar = f5895e.get(kotlinName);
        if (cVar == null || (interfaceC1178aD = annotationOwner.d(cVar)) == null) {
            return null;
        }
        return f(f5891a, interfaceC1178aD, c10, false, 4, null);
    }

    public final ga.e b() {
        return f5892b;
    }

    public final ga.e c() {
        return f5894d;
    }

    public final ga.e d() {
        return f5893c;
    }

    public final F9.c e(InterfaceC1178a annotation, V9.k c10, boolean z10) {
        p.i(annotation, "annotation");
        p.i(c10, "c");
        ga.b bVarJ = annotation.j();
        b.a aVar = ga.b.f32721d;
        ga.c TARGET_ANNOTATION = F.f5686d;
        p.h(TARGET_ANNOTATION, "TARGET_ANNOTATION");
        if (p.d(bVarJ, aVar.c(TARGET_ANNOTATION))) {
            return new n(annotation, c10);
        }
        ga.c RETENTION_ANNOTATION = F.f5688f;
        p.h(RETENTION_ANNOTATION, "RETENTION_ANNOTATION");
        if (p.d(bVarJ, aVar.c(RETENTION_ANNOTATION))) {
            return new l(annotation, c10);
        }
        ga.c DOCUMENTED_ANNOTATION = F.f5691i;
        p.h(DOCUMENTED_ANNOTATION, "DOCUMENTED_ANNOTATION");
        if (p.d(bVarJ, aVar.c(DOCUMENTED_ANNOTATION))) {
            return new c(c10, annotation, o.a.f1876P);
        }
        ga.c DEPRECATED_ANNOTATION = F.f5690h;
        p.h(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
        if (p.d(bVarJ, aVar.c(DEPRECATED_ANNOTATION))) {
            return null;
        }
        return new C1101j(c10, annotation, z10);
    }
}
