package T9;

import C9.o;
import E9.InterfaceC0819y;
import E9.i0;
import Z8.A;
import Z8.C1174w;
import Z8.Y;
import Z9.InterfaceC1179b;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ma.AbstractC4927g;
import ma.C4922b;
import ya.S;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f5897a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, EnumSet<KotlinTarget>> f5898b = kotlin.collections.a.m(Y8.j.a("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), Y8.j.a("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), Y8.j.a("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), Y8.j.a("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), Y8.j.a("FIELD", EnumSet.of(KotlinTarget.FIELD)), Y8.j.a("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), Y8.j.a("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), Y8.j.a("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), Y8.j.a("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), Y8.j.a("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));

    /* renamed from: c, reason: collision with root package name */
    public static final Map<String, KotlinRetention> f5899c = kotlin.collections.a.m(Y8.j.a("RUNTIME", KotlinRetention.RUNTIME), Y8.j.a("CLASS", KotlinRetention.BINARY), Y8.j.a("SOURCE", KotlinRetention.SOURCE));

    public static final S e(InterfaceC0819y module) {
        S type;
        p.i(module, "module");
        i0 i0VarB = a.b(d.f5891a.d(), module.g().p(o.a.f1860H));
        return (i0VarB == null || (type = i0VarB.getType()) == null) ? Aa.i.d(ErrorTypeKind.UNMAPPED_ANNOTATION_TARGET_TYPE, new String[0]) : type;
    }

    public final AbstractC4927g<?> b(InterfaceC1179b interfaceC1179b) {
        Z9.m mVar = interfaceC1179b instanceof Z9.m ? (Z9.m) interfaceC1179b : null;
        if (mVar != null) {
            Map<String, KotlinRetention> map = f5899c;
            ga.e eVarE = mVar.e();
            KotlinRetention kotlinRetention = map.get(eVarE != null ? eVarE.b() : null);
            if (kotlinRetention != null) {
                ga.b bVarC = ga.b.f32721d.c(o.a.f1866K);
                ga.e eVarJ = ga.e.j(kotlinRetention.name());
                p.h(eVarJ, "identifier(...)");
                return new ma.k(bVarC, eVarJ);
            }
        }
        return null;
    }

    public final Set<KotlinTarget> c(String str) {
        EnumSet<KotlinTarget> enumSet = f5898b.get(str);
        return enumSet != null ? enumSet : Y.e();
    }

    public final AbstractC4927g<?> d(List<? extends InterfaceC1179b> arguments) {
        p.i(arguments, "arguments");
        ArrayList<Z9.m> arrayList = new ArrayList();
        for (Object obj : arguments) {
            if (obj instanceof Z9.m) {
                arrayList.add(obj);
            }
        }
        ArrayList<KotlinTarget> arrayList2 = new ArrayList();
        for (Z9.m mVar : arrayList) {
            f fVar = f5897a;
            ga.e eVarE = mVar.e();
            A.E(arrayList2, fVar.c(eVarE != null ? eVarE.b() : null));
        }
        ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
        for (KotlinTarget kotlinTarget : arrayList2) {
            ga.b bVarC = ga.b.f32721d.c(o.a.f1864J);
            ga.e eVarJ = ga.e.j(kotlinTarget.name());
            p.h(eVarJ, "identifier(...)");
            arrayList3.add(new ma.k(bVarC, eVarJ));
        }
        return new C4922b(arrayList3, e.f5896a);
    }
}
