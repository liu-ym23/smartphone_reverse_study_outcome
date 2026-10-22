package aa;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import za.C6468n;

/* loaded from: classes5.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    public static final F9.g f8175a;

    /* renamed from: b, reason: collision with root package name */
    public static final C1259g f8176b;

    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8177a;

        static {
            int[] iArr = new int[NullabilityQualifier.values().length];
            try {
                iArr[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f8177a = iArr;
        }
    }

    static {
        ga.c ENHANCED_NULLABILITY_ANNOTATION = S9.F.f5704v;
        kotlin.jvm.internal.p.h(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        f8175a = new C1259g(ENHANCED_NULLABILITY_ANNOTATION);
        ga.c ENHANCED_MUTABILITY_ANNOTATION = S9.F.f5705w;
        kotlin.jvm.internal.p.h(ENHANCED_MUTABILITY_ANNOTATION, "ENHANCED_MUTABILITY_ANNOTATION");
        f8176b = new C1259g(ENHANCED_MUTABILITY_ANNOTATION);
    }

    public static final F9.g e(List<? extends F9.g> list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? new F9.n((List<? extends F9.g>) Z8.F.m1(list)) : (F9.g) Z8.F.X0(list);
        }
        throw new IllegalStateException("At least one Annotations object expected");
    }

    public static final InterfaceC0799d f(InterfaceC0799d interfaceC0799d, C1261i c1261i, TypeComponentPosition typeComponentPosition) {
        D9.b bVar = D9.b.f2290a;
        if (!o0.a(typeComponentPosition) || !(interfaceC0799d instanceof InterfaceC0797b)) {
            return null;
        }
        if (c1261i.e() == MutabilityQualifier.READ_ONLY && typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
            InterfaceC0797b interfaceC0797b = (InterfaceC0797b) interfaceC0799d;
            if (bVar.c(interfaceC0797b)) {
                return bVar.a(interfaceC0797b);
            }
        }
        if (c1261i.e() == MutabilityQualifier.MUTABLE && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
            InterfaceC0797b interfaceC0797b2 = (InterfaceC0797b) interfaceC0799d;
            if (bVar.d(interfaceC0797b2)) {
                return bVar.b(interfaceC0797b2);
            }
        }
        return null;
    }

    public static final F9.g g() {
        return f8175a;
    }

    public static final Boolean h(C1261i c1261i, TypeComponentPosition typeComponentPosition) {
        if (!o0.a(typeComponentPosition)) {
            return null;
        }
        NullabilityQualifier nullabilityQualifierF = c1261i.f();
        int i10 = nullabilityQualifierF == null ? -1 : a.f8177a[nullabilityQualifierF.ordinal()];
        if (i10 == 1) {
            return Boolean.TRUE;
        }
        if (i10 != 2) {
            return null;
        }
        return Boolean.FALSE;
    }

    public static final boolean i(ya.S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        return r0.c(C6468n.f45422a, s10);
    }
}
