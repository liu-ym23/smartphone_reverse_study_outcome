package O9;

import N9.e;
import N9.k;
import N9.l;
import N9.m;
import N9.o;
import N9.q;
import N9.r;
import N9.s;
import N9.t;
import N9.u;
import N9.v;
import N9.w;
import P9.n;
import Z8.C1173v;
import ea.C4018b;
import ea.InterfaceC4020d;
import ea.g;
import ea.h;
import ea.i;
import ea.j;
import java.util.Iterator;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException;
import kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind;
import kotlin.reflect.jvm.internal.impl.km.KmEffectType;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;

/* loaded from: classes5.dex */
public final class f {

    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5302a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f5303b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f5304c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f5305d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f5306e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f5307f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f5308g;

        static {
            int[] iArr = new int[ProtoBuf$TypeParameter.Variance.values().length];
            try {
                iArr[ProtoBuf$TypeParameter.Variance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf$TypeParameter.Variance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf$TypeParameter.Variance.INV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5302a = iArr;
            int[] iArr2 = new int[ProtoBuf$Type.Argument.Projection.values().length];
            try {
                iArr2[ProtoBuf$Type.Argument.Projection.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ProtoBuf$Type.Argument.Projection.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ProtoBuf$Type.Argument.Projection.INV.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ProtoBuf$Type.Argument.Projection.STAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            f5303b = iArr2;
            int[] iArr3 = new int[ProtoBuf$VersionRequirement.VersionKind.values().length];
            try {
                iArr3[ProtoBuf$VersionRequirement.VersionKind.LANGUAGE_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ProtoBuf$VersionRequirement.VersionKind.COMPILER_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ProtoBuf$VersionRequirement.VersionKind.API_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            f5304c = iArr3;
            int[] iArr4 = new int[DeprecationLevel.values().length];
            try {
                iArr4[DeprecationLevel.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[DeprecationLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[DeprecationLevel.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            f5305d = iArr4;
            int[] iArr5 = new int[ProtoBuf$Effect.EffectType.values().length];
            try {
                iArr5[ProtoBuf$Effect.EffectType.RETURNS_CONSTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr5[ProtoBuf$Effect.EffectType.CALLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr5[ProtoBuf$Effect.EffectType.RETURNS_NOT_NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            f5306e = iArr5;
            int[] iArr6 = new int[ProtoBuf$Effect.InvocationKind.values().length];
            try {
                iArr6[ProtoBuf$Effect.InvocationKind.AT_MOST_ONCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr6[ProtoBuf$Effect.InvocationKind.EXACTLY_ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr6[ProtoBuf$Effect.InvocationKind.AT_LEAST_ONCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            f5307f = iArr6;
            int[] iArr7 = new int[ProtoBuf$Expression.ConstantValue.values().length];
            try {
                iArr7[ProtoBuf$Expression.ConstantValue.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr7[ProtoBuf$Expression.ConstantValue.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr7[ProtoBuf$Expression.ConstantValue.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            f5308g = iArr7;
        }
    }

    public static final int a(int i10) {
        Boolean boolD = C4018b.f32376c.d(i10);
        p.h(boolD, "get(...)");
        return C4018b.b(boolD.booleanValue(), C4018b.f32377d.d(i10), C4018b.f32378e.d(i10), false, false, false);
    }

    public static final int b(ProtoBuf$Property protoBuf$Property) {
        p.i(protoBuf$Property, "<this>");
        return protoBuf$Property.c1() ? protoBuf$Property.L0() : a(protoBuf$Property.H0());
    }

    public static final int c(ProtoBuf$Property protoBuf$Property) {
        p.i(protoBuf$Property, "<this>");
        return protoBuf$Property.j1() ? protoBuf$Property.V0() : a(protoBuf$Property.H0());
    }

    public static final int d(ProtoBuf$Type protoBuf$Type) {
        boolean zD0 = protoBuf$Type.d0();
        return (zD0 ? 1 : 0) + (protoBuf$Type.Z() << 1);
    }

    public static final int e(ProtoBuf$TypeParameter protoBuf$TypeParameter) {
        return protoBuf$TypeParameter.O() ? 1 : 0;
    }

    public static final u f(q qVar) {
        u uVar = new u(0, "_");
        uVar.e(qVar);
        return uVar;
    }

    public static final ProtoBuf$Type g(ProtoBuf$Class protoBuf$Class, d dVar) {
        ProtoBuf$Type protoBuf$TypeI = g.i(protoBuf$Class, dVar.g());
        if (protoBuf$TypeI != null) {
            return protoBuf$TypeI;
        }
        if (!protoBuf$Class.j1()) {
            return null;
        }
        List<ProtoBuf$Property> listR0 = protoBuf$Class.R0();
        p.h(listR0, "getPropertyList(...)");
        Iterator<T> it = listR0.iterator();
        boolean z10 = false;
        Object obj = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z10) {
                    break;
                }
            } else {
                Object next = it.next();
                ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) next;
                p.f(protoBuf$Property);
                if (g.m(protoBuf$Property, dVar.g()) == null && p.d(dVar.b(protoBuf$Property.M0()), dVar.b(protoBuf$Class.L0()))) {
                    if (z10) {
                        break;
                    }
                    z10 = true;
                    obj = next;
                }
            }
        }
        obj = null;
        ProtoBuf$Property protoBuf$Property2 = (ProtoBuf$Property) obj;
        if (protoBuf$Property2 != null) {
            return g.o(protoBuf$Property2, dVar.g());
        }
        return null;
    }

    public static final w h(int i10, d dVar) {
        KmVersionRequirementVersionKind kmVersionRequirementVersionKind;
        KmVersionRequirementLevel kmVersionRequirementLevel;
        i.b bVarE;
        w wVar = new w();
        i iVarA = i.f32412f.a(i10, dVar.e(), dVar.h());
        if (iVarA == null && !dVar.d()) {
            throw new InconsistentKotlinMetadataException("No VersionRequirement with the given id in the table", null, 2, null);
        }
        ProtoBuf$VersionRequirement.VersionKind versionKindB = iVarA != null ? iVarA.b() : null;
        int i11 = versionKindB == null ? -1 : a.f5304c[versionKindB.ordinal()];
        if (i11 == -1) {
            kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.UNKNOWN;
        } else if (i11 == 1) {
            kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.LANGUAGE_VERSION;
        } else if (i11 == 2) {
            kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.COMPILER_VERSION;
        } else {
            if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.API_VERSION;
        }
        DeprecationLevel deprecationLevelC = iVarA != null ? iVarA.c() : null;
        int i12 = deprecationLevelC == null ? -1 : a.f5305d[deprecationLevelC.ordinal()];
        if (i12 == -1) {
            kmVersionRequirementLevel = KmVersionRequirementLevel.HIDDEN;
        } else if (i12 == 1) {
            kmVersionRequirementLevel = KmVersionRequirementLevel.WARNING;
        } else if (i12 != 2) {
            if (i12 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            kmVersionRequirementLevel = KmVersionRequirementLevel.HIDDEN;
        } else {
            kmVersionRequirementLevel = KmVersionRequirementLevel.ERROR;
        }
        wVar.e(kmVersionRequirementVersionKind);
        wVar.f(kmVersionRequirementLevel);
        wVar.d(iVarA != null ? iVarA.a() : null);
        wVar.g(iVarA != null ? iVarA.d() : null);
        if (iVarA == null || (bVarE = iVarA.e()) == null) {
            bVarE = i.b.f32420e;
        }
        wVar.h(new v(bVarE.b(), bVarE.c(), bVarE.d()));
        return wVar;
    }

    public static final N9.d i(ProtoBuf$Class protoBuf$Class, InterfaceC4020d strings, boolean z10, List<? extends Object> contextExtensions) {
        p.i(protoBuf$Class, "<this>");
        p.i(strings, "strings");
        p.i(contextExtensions, "contextExtensions");
        N9.d dVar = new N9.d();
        ProtoBuf$TypeTable protoBuf$TypeTableD1 = protoBuf$Class.d1();
        p.h(protoBuf$TypeTableD1, "getTypeTable(...)");
        h hVar = new h(protoBuf$TypeTableD1);
        j.a aVar = j.f32424b;
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTableF1 = protoBuf$Class.f1();
        p.h(protoBuf$VersionRequirementTableF1, "getVersionRequirementTable(...)");
        d dVar2 = new d(strings, hVar, aVar.a(protoBuf$VersionRequirementTableF1), z10, null, contextExtensions, 16, null);
        List<ProtoBuf$TypeParameter> listC1 = protoBuf$Class.c1();
        p.h(listC1, "getTypeParameterList(...)");
        d dVarI = dVar2.i(listC1);
        dVar.s(protoBuf$Class.G0());
        dVar.v(dVarI.a(protoBuf$Class.H0()));
        List<ProtoBuf$TypeParameter> listC12 = protoBuf$Class.c1();
        p.h(listC12, "getTypeParameterList(...)");
        List<s> listP = dVar.p();
        for (ProtoBuf$TypeParameter protoBuf$TypeParameter : listC12) {
            p.f(protoBuf$TypeParameter);
            listP.add(t(protoBuf$TypeParameter, dVarI));
        }
        List<ProtoBuf$Type> listP2 = g.p(protoBuf$Class, dVarI.g());
        List<q> listO = dVar.o();
        Iterator<T> it = listP2.iterator();
        while (it.hasNext()) {
            listO.add(r((ProtoBuf$Type) it.next(), dVarI));
        }
        List<ProtoBuf$Constructor> listW0 = protoBuf$Class.w0();
        p.h(listW0, "getConstructorList(...)");
        List<N9.g> listE = dVar.e();
        for (ProtoBuf$Constructor protoBuf$Constructor : listW0) {
            p.f(protoBuf$Constructor);
            listE.add(k(protoBuf$Constructor, dVarI));
        }
        List<ProtoBuf$Function> listK0 = protoBuf$Class.K0();
        p.h(listK0, "getFunctionList(...)");
        List<ProtoBuf$Property> listR0 = protoBuf$Class.R0();
        p.h(listR0, "getPropertyList(...)");
        List<ProtoBuf$TypeAlias> listZ0 = protoBuf$Class.Z0();
        p.h(listZ0, "getTypeAliasList(...)");
        v(dVar, listK0, listR0, listZ0, dVarI);
        if (protoBuf$Class.g1()) {
            dVar.r(dVarI.b(protoBuf$Class.r0()));
        }
        List<Integer> listO0 = protoBuf$Class.O0();
        p.h(listO0, "getNestedClassNameList(...)");
        List<String> listM = dVar.m();
        for (Integer num : listO0) {
            p.f(num);
            listM.add(dVarI.b(num.intValue()));
        }
        Iterator<ProtoBuf$EnumEntry> it2 = protoBuf$Class.F0().iterator();
        while (true) {
            if (!it2.hasNext()) {
                List<Integer> listS0 = protoBuf$Class.S0();
                p.h(listS0, "getSealedSubclassFqNameList(...)");
                List<String> listN = dVar.n();
                for (Integer num2 : listS0) {
                    p.f(num2);
                    listN.add(dVarI.a(num2.intValue()));
                }
                if (protoBuf$Class.j1()) {
                    dVar.t(dVarI.b(protoBuf$Class.L0()));
                }
                ProtoBuf$Type protoBuf$TypeG = g(protoBuf$Class, dVarI);
                dVar.u(protoBuf$TypeG != null ? r(protoBuf$TypeG, dVarI) : null);
                List<ProtoBuf$Type> listB = g.b(protoBuf$Class, dVarI.g());
                List<q> listF = dVar.f();
                Iterator<T> it3 = listB.iterator();
                while (it3.hasNext()) {
                    listF.add(r((ProtoBuf$Type) it3.next(), dVarI));
                }
                List<Integer> listE1 = protoBuf$Class.e1();
                p.h(listE1, "getVersionRequirementList(...)");
                List<w> listQ = dVar.q();
                for (Integer num3 : listE1) {
                    p.f(num3);
                    listQ.add(h(num3.intValue(), dVarI));
                }
                Iterator<T> it4 = dVarI.c().iterator();
                while (it4.hasNext()) {
                    ((n) it4.next()).e(dVar, protoBuf$Class, dVarI);
                }
                return dVar;
            }
            ProtoBuf$EnumEntry next = it2.next();
            if (!next.L()) {
                throw new InconsistentKotlinMetadataException("No name for EnumEntry", null, 2, null);
            }
            dVar.g().add(dVarI.b(next.K()));
            List<l> listK = dVar.k();
            p.f(next);
            listK.add(o(next, dVarI));
        }
    }

    public static /* synthetic */ N9.d j(ProtoBuf$Class protoBuf$Class, InterfaceC4020d interfaceC4020d, boolean z10, List list, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            list = C1173v.m();
        }
        return i(protoBuf$Class, interfaceC4020d, z10, list);
    }

    public static final N9.g k(ProtoBuf$Constructor protoBuf$Constructor, d dVar) {
        N9.g gVar = new N9.g(protoBuf$Constructor.S());
        List<ProtoBuf$ValueParameter> listV = protoBuf$Constructor.V();
        p.h(listV, "getValueParameterList(...)");
        List<u> listD = gVar.d();
        for (ProtoBuf$ValueParameter protoBuf$ValueParameter : listV) {
            p.f(protoBuf$ValueParameter);
            listD.add(u(protoBuf$ValueParameter, dVar));
        }
        List<Integer> listW = protoBuf$Constructor.W();
        p.h(listW, "getVersionRequirementList(...)");
        List<w> listE = gVar.e();
        for (Integer num : listW) {
            p.f(num);
            listE.add(h(num.intValue(), dVar));
        }
        Iterator<T> it = dVar.c().iterator();
        while (it.hasNext()) {
            ((n) it.next()).c(gVar, protoBuf$Constructor, dVar);
        }
        return gVar;
    }

    public static final N9.h l(ProtoBuf$Contract protoBuf$Contract, d dVar) {
        KmEffectType kmEffectType;
        KmEffectInvocationKind kmEffectInvocationKind;
        N9.h hVar = new N9.h();
        for (ProtoBuf$Effect protoBuf$Effect : protoBuf$Contract.v()) {
            if (protoBuf$Effect.J()) {
                ProtoBuf$Effect.EffectType effectTypeE = protoBuf$Effect.E();
                if (effectTypeE == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                int i10 = a.f5306e[effectTypeE.ordinal()];
                if (i10 == 1) {
                    kmEffectType = KmEffectType.RETURNS_CONSTANT;
                } else if (i10 == 2) {
                    kmEffectType = KmEffectType.CALLS;
                } else {
                    if (i10 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    kmEffectType = KmEffectType.RETURNS_NOT_NULL;
                }
                if (protoBuf$Effect.K()) {
                    ProtoBuf$Effect.InvocationKind invocationKindF = protoBuf$Effect.F();
                    if (invocationKindF == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    int i11 = a.f5307f[invocationKindF.ordinal()];
                    if (i11 == 1) {
                        kmEffectInvocationKind = KmEffectInvocationKind.AT_MOST_ONCE;
                    } else if (i11 == 2) {
                        kmEffectInvocationKind = KmEffectInvocationKind.EXACTLY_ONCE;
                    } else {
                        if (i11 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        kmEffectInvocationKind = KmEffectInvocationKind.AT_LEAST_ONCE;
                    }
                } else {
                    kmEffectInvocationKind = null;
                }
                List<N9.j> listA = hVar.a();
                p.f(protoBuf$Effect);
                listA.add(m(protoBuf$Effect, kmEffectType, kmEffectInvocationKind, dVar));
            }
        }
        return hVar;
    }

    public static final N9.j m(ProtoBuf$Effect protoBuf$Effect, KmEffectType kmEffectType, KmEffectInvocationKind kmEffectInvocationKind, d dVar) {
        N9.j jVar = new N9.j(kmEffectType, kmEffectInvocationKind);
        List<ProtoBuf$Expression> listD = protoBuf$Effect.D();
        p.h(listD, "getEffectConstructorArgumentList(...)");
        List<k> listA = jVar.a();
        for (ProtoBuf$Expression protoBuf$Expression : listD) {
            p.f(protoBuf$Expression);
            listA.add(n(protoBuf$Expression, dVar));
        }
        if (protoBuf$Effect.G()) {
            ProtoBuf$Expression protoBuf$ExpressionX = protoBuf$Effect.x();
            p.h(protoBuf$ExpressionX, "getConclusionOfConditionalEffect(...)");
            jVar.b(n(protoBuf$ExpressionX, dVar));
        }
        return jVar;
    }

    public static final k n(ProtoBuf$Expression protoBuf$Expression, d dVar) {
        Boolean bool;
        k kVar = new k();
        kVar.e(protoBuf$Expression.G());
        kVar.g(protoBuf$Expression.S() ? Integer.valueOf(protoBuf$Expression.N()) : null);
        if (protoBuf$Expression.O()) {
            ProtoBuf$Expression.ConstantValue constantValueE = protoBuf$Expression.E();
            if (constantValueE == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            int i10 = a.f5308g[constantValueE.ordinal()];
            if (i10 == 1) {
                bool = Boolean.TRUE;
            } else if (i10 == 2) {
                bool = Boolean.FALSE;
            } else {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                bool = null;
            }
            kVar.d(new N9.f(bool));
        }
        ProtoBuf$Type protoBuf$TypeJ = g.j(protoBuf$Expression, dVar.g());
        kVar.f(protoBuf$TypeJ != null ? r(protoBuf$TypeJ, dVar) : null);
        List<ProtoBuf$Expression> listD = protoBuf$Expression.D();
        p.h(listD, "getAndArgumentList(...)");
        List<k> listA = kVar.a();
        for (ProtoBuf$Expression protoBuf$Expression2 : listD) {
            p.f(protoBuf$Expression2);
            listA.add(n(protoBuf$Expression2, dVar));
        }
        List<ProtoBuf$Expression> listM = protoBuf$Expression.M();
        p.h(listM, "getOrArgumentList(...)");
        List<k> listC = kVar.c();
        for (ProtoBuf$Expression protoBuf$Expression3 : listM) {
            p.f(protoBuf$Expression3);
            listC.add(n(protoBuf$Expression3, dVar));
        }
        return kVar;
    }

    public static final l o(ProtoBuf$EnumEntry protoBuf$EnumEntry, d dVar) {
        l lVar = new l(dVar.b(protoBuf$EnumEntry.K()));
        Iterator<T> it = dVar.c().iterator();
        while (it.hasNext()) {
            ((n) it.next()).f(lVar, protoBuf$EnumEntry, dVar);
        }
        return lVar;
    }

    public static final N9.n p(ProtoBuf$Function protoBuf$Function, d dVar) {
        N9.n nVar = new N9.n(protoBuf$Function.v0(), dVar.b(protoBuf$Function.w0()));
        List<ProtoBuf$TypeParameter> listE0 = protoBuf$Function.E0();
        p.h(listE0, "getTypeParameterList(...)");
        d dVarI = dVar.i(listE0);
        List<ProtoBuf$TypeParameter> listE02 = protoBuf$Function.E0();
        p.h(listE02, "getTypeParameterList(...)");
        List<s> listF = nVar.f();
        for (ProtoBuf$TypeParameter protoBuf$TypeParameter : listE02) {
            p.f(protoBuf$TypeParameter);
            listF.add(t(protoBuf$TypeParameter, dVarI));
        }
        ProtoBuf$Type protoBuf$TypeL = g.l(protoBuf$Function, dVarI.g());
        nVar.k(protoBuf$TypeL != null ? r(protoBuf$TypeL, dVarI) : null);
        List<ProtoBuf$ValueParameter> listK0 = protoBuf$Function.k0();
        p.h(listK0, "getContextParameterList(...)");
        List<u> listB = nVar.b();
        for (ProtoBuf$ValueParameter protoBuf$ValueParameter : listK0) {
            p.f(protoBuf$ValueParameter);
            listB.add(u(protoBuf$ValueParameter, dVarI));
        }
        if (protoBuf$Function.k0().isEmpty()) {
            List<ProtoBuf$Type> listO0 = protoBuf$Function.o0();
            p.h(listO0, "getContextReceiverTypeList(...)");
            if (!listO0.isEmpty()) {
                List<ProtoBuf$Type> listC = g.c(protoBuf$Function, dVarI.g());
                List<u> listB2 = nVar.b();
                Iterator<T> it = listC.iterator();
                while (it.hasNext()) {
                    listB2.add(f(r((ProtoBuf$Type) it.next(), dVarI)));
                }
            }
        }
        List<ProtoBuf$ValueParameter> listI0 = protoBuf$Function.I0();
        p.h(listI0, "getValueParameterList(...)");
        List<u> listG = nVar.g();
        for (ProtoBuf$ValueParameter protoBuf$ValueParameter2 : listI0) {
            p.f(protoBuf$ValueParameter2);
            listG.add(u(protoBuf$ValueParameter2, dVarI));
        }
        nVar.l(r(g.n(protoBuf$Function, dVarI.g()), dVarI));
        if (protoBuf$Function.K0()) {
            ProtoBuf$Contract protoBuf$ContractP0 = protoBuf$Function.p0();
            p.h(protoBuf$ContractP0, "getContract(...)");
            nVar.i(l(protoBuf$ContractP0, dVarI));
        }
        List<Integer> listJ0 = protoBuf$Function.J0();
        p.h(listJ0, "getVersionRequirementList(...)");
        List<w> listH = nVar.h();
        for (Integer num : listJ0) {
            p.f(num);
            listH.add(h(num.intValue(), dVarI));
        }
        Iterator<T> it2 = dVarI.c().iterator();
        while (it2.hasNext()) {
            ((n) it2.next()).m(nVar, protoBuf$Function, dVarI);
        }
        return nVar;
    }

    public static final o q(ProtoBuf$Property protoBuf$Property, d outer) {
        p.i(protoBuf$Property, "<this>");
        p.i(outer, "outer");
        o oVar = new o(protoBuf$Property.H0(), outer.b(protoBuf$Property.M0()), b(protoBuf$Property), c(protoBuf$Property));
        List<ProtoBuf$TypeParameter> listZ0 = protoBuf$Property.Z0();
        p.h(listZ0, "getTypeParameterList(...)");
        d dVarI = outer.i(listZ0);
        List<ProtoBuf$TypeParameter> listZ02 = protoBuf$Property.Z0();
        p.h(listZ02, "getTypeParameterList(...)");
        List<s> listJ = oVar.j();
        for (ProtoBuf$TypeParameter protoBuf$TypeParameter : listZ02) {
            p.f(protoBuf$TypeParameter);
            listJ.add(t(protoBuf$TypeParameter, dVarI));
        }
        ProtoBuf$Type protoBuf$TypeM = g.m(protoBuf$Property, dVarI.g());
        oVar.n(protoBuf$TypeM != null ? r(protoBuf$TypeM, dVarI) : null);
        List<ProtoBuf$ValueParameter> listU0 = protoBuf$Property.u0();
        p.h(listU0, "getContextParameterList(...)");
        List<u> listC = oVar.c();
        for (ProtoBuf$ValueParameter protoBuf$ValueParameter : listU0) {
            p.f(protoBuf$ValueParameter);
            listC.add(u(protoBuf$ValueParameter, dVarI));
        }
        if (protoBuf$Property.u0().isEmpty()) {
            List<ProtoBuf$Type> listY0 = protoBuf$Property.y0();
            p.h(listY0, "getContextReceiverTypeList(...)");
            if (!listY0.isEmpty()) {
                List<ProtoBuf$Type> listD = g.d(protoBuf$Property, dVarI.g());
                List<u> listC2 = oVar.c();
                Iterator<T> it = listD.iterator();
                while (it.hasNext()) {
                    listC2.add(f(r((ProtoBuf$Type) it.next(), dVarI)));
                }
            }
        }
        if (protoBuf$Property.k1()) {
            ProtoBuf$ValueParameter protoBuf$ValueParameterW0 = protoBuf$Property.W0();
            p.h(protoBuf$ValueParameterW0, "getSetterValueParameter(...)");
            oVar.p(u(protoBuf$ValueParameterW0, dVarI));
        }
        oVar.o(r(g.o(protoBuf$Property, dVarI.g()), dVarI));
        List<Integer> listA1 = protoBuf$Property.a1();
        p.h(listA1, "getVersionRequirementList(...)");
        List<w> listK = oVar.k();
        for (Integer num : listA1) {
            p.f(num);
            listK.add(h(num.intValue(), dVarI));
        }
        Iterator<T> it2 = dVarI.c().iterator();
        while (it2.hasNext()) {
            ((n) it2.next()).h(oVar, protoBuf$Property, dVarI);
        }
        return oVar;
    }

    public static final q r(ProtoBuf$Type protoBuf$Type, d dVar) {
        N9.e cVar;
        q qVarR;
        KmVariance kmVariance;
        q qVar = new q(d(protoBuf$Type));
        m mVar = null;
        mVar = null;
        if (protoBuf$Type.l0()) {
            cVar = new e.a(dVar.a(protoBuf$Type.W()));
        } else if (protoBuf$Type.t0()) {
            cVar = new e.b(dVar.a(protoBuf$Type.g0()));
        } else if (protoBuf$Type.u0()) {
            cVar = new e.c(protoBuf$Type.h0());
        } else {
            if (!protoBuf$Type.v0()) {
                throw new InconsistentKotlinMetadataException("No classifier (class, type alias or type parameter) recorded for Type", null, 2, null);
            }
            Integer numF = dVar.f(protoBuf$Type.i0());
            if (numF == null) {
                throw new InconsistentKotlinMetadataException("No type parameter id for " + dVar.b(protoBuf$Type.i0()), null, 2, null);
            }
            cVar = new e.c(numF.intValue());
        }
        qVar.f(cVar);
        for (ProtoBuf$Type.Argument argument : protoBuf$Type.V()) {
            ProtoBuf$Type.Argument.Projection projectionV = argument.v();
            if (projectionV == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            int i10 = a.f5303b[projectionV.ordinal()];
            if (i10 == 1) {
                kmVariance = KmVariance.IN;
            } else if (i10 == 2) {
                kmVariance = KmVariance.OUT;
            } else if (i10 == 3) {
                kmVariance = KmVariance.INVARIANT;
            } else {
                if (i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                kmVariance = null;
            }
            if (kmVariance != null) {
                p.f(argument);
                ProtoBuf$Type protoBuf$TypeQ = g.q(argument, dVar.g());
                if (protoBuf$TypeQ == null) {
                    throw new InconsistentKotlinMetadataException("No type argument for non-STAR projection in Type", null, 2, null);
                }
                qVar.a().add(new t(kmVariance, r(protoBuf$TypeQ, dVar)));
            } else {
                qVar.a().add(t.f5016d);
            }
        }
        ProtoBuf$Type protoBuf$TypeA = g.a(protoBuf$Type, dVar.g());
        qVar.e(protoBuf$TypeA != null ? r(protoBuf$TypeA, dVar) : null);
        ProtoBuf$Type protoBuf$TypeK = g.k(protoBuf$Type, dVar.g());
        qVar.i(protoBuf$TypeK != null ? r(protoBuf$TypeK, dVar) : null);
        ProtoBuf$Type protoBuf$TypeF = g.f(protoBuf$Type, dVar.g());
        if (protoBuf$TypeF != null && (qVarR = r(protoBuf$TypeF, dVar)) != null) {
            mVar = new m(qVarR, protoBuf$Type.n0() ? dVar.b(protoBuf$Type.a0()) : null);
        }
        qVar.h(mVar);
        Iterator<T> it = dVar.c().iterator();
        while (it.hasNext()) {
            ((n) it.next()).k(qVar, protoBuf$Type, dVar);
        }
        return qVar;
    }

    public static final r s(ProtoBuf$TypeAlias protoBuf$TypeAlias, d dVar) {
        r rVar = new r(protoBuf$TypeAlias.Z(), dVar.b(protoBuf$TypeAlias.a0()));
        List<ProtoBuf$TypeParameter> listD0 = protoBuf$TypeAlias.d0();
        p.h(listD0, "getTypeParameterList(...)");
        d dVarI = dVar.i(listD0);
        List<ProtoBuf$TypeParameter> listD02 = protoBuf$TypeAlias.d0();
        p.h(listD02, "getTypeParameterList(...)");
        List<s> listC = rVar.c();
        for (ProtoBuf$TypeParameter protoBuf$TypeParameter : listD02) {
            p.f(protoBuf$TypeParameter);
            listC.add(t(protoBuf$TypeParameter, dVarI));
        }
        rVar.g(r(g.s(protoBuf$TypeAlias, dVarI.g()), dVarI));
        rVar.e(r(g.e(protoBuf$TypeAlias, dVarI.g()), dVarI));
        List<ProtoBuf$Annotation> listS = protoBuf$TypeAlias.S();
        p.h(listS, "getAnnotationList(...)");
        List<N9.b> listA = rVar.a();
        for (ProtoBuf$Annotation protoBuf$Annotation : listS) {
            p.f(protoBuf$Annotation);
            listA.add(e.b(protoBuf$Annotation, dVarI.e()));
        }
        List<Integer> listG0 = protoBuf$TypeAlias.g0();
        p.h(listG0, "getVersionRequirementList(...)");
        List<w> listD = rVar.d();
        for (Integer num : listG0) {
            p.f(num);
            listD.add(h(num.intValue(), dVarI));
        }
        Iterator<T> it = dVarI.c().iterator();
        while (it.hasNext()) {
            ((n) it.next()).o(rVar, protoBuf$TypeAlias, dVarI);
        }
        return rVar;
    }

    public static final s t(ProtoBuf$TypeParameter protoBuf$TypeParameter, d dVar) {
        KmVariance kmVariance;
        ProtoBuf$TypeParameter.Variance varianceT = protoBuf$TypeParameter.T();
        if (varianceT == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        int i10 = a.f5302a[varianceT.ordinal()];
        if (i10 == 1) {
            kmVariance = KmVariance.IN;
        } else if (i10 == 2) {
            kmVariance = KmVariance.OUT;
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            kmVariance = KmVariance.INVARIANT;
        }
        s sVar = new s(e(protoBuf$TypeParameter), dVar.b(protoBuf$TypeParameter.N()), protoBuf$TypeParameter.M(), kmVariance);
        List<ProtoBuf$Type> listT = g.t(protoBuf$TypeParameter, dVar.g());
        List<q> listC = sVar.c();
        Iterator<T> it = listT.iterator();
        while (it.hasNext()) {
            listC.add(r((ProtoBuf$Type) it.next(), dVar));
        }
        Iterator<T> it2 = dVar.c().iterator();
        while (it2.hasNext()) {
            ((n) it2.next()).n(sVar, protoBuf$TypeParameter, dVar);
        }
        return sVar;
    }

    public static final u u(ProtoBuf$ValueParameter protoBuf$ValueParameter, d dVar) {
        u uVar = new u(protoBuf$ValueParameter.R(), dVar.b(protoBuf$ValueParameter.S()));
        uVar.e(r(g.r(protoBuf$ValueParameter, dVar.g()), dVar));
        ProtoBuf$Type protoBuf$TypeU = g.u(protoBuf$ValueParameter, dVar.g());
        uVar.f(protoBuf$TypeU != null ? r(protoBuf$TypeU, dVar) : null);
        if (protoBuf$ValueParameter.X()) {
            ProtoBuf$Annotation.Argument.Value valueO = protoBuf$ValueParameter.O();
            p.h(valueO, "getAnnotationParameterDefaultValue(...)");
            uVar.c(e.c(valueO, dVar.e()));
        }
        Iterator<T> it = dVar.c().iterator();
        while (it.hasNext()) {
            ((n) it.next()).d(uVar, protoBuf$ValueParameter, dVar);
        }
        return uVar;
    }

    public static final void v(N9.i iVar, List<ProtoBuf$Function> list, List<ProtoBuf$Property> list2, List<ProtoBuf$TypeAlias> list3, d dVar) {
        List<N9.n> listC = iVar.c();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            listC.add(p((ProtoBuf$Function) it.next(), dVar));
        }
        List<o> listA = iVar.a();
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            listA.add(q((ProtoBuf$Property) it2.next(), dVar));
        }
        List<r> listB = iVar.b();
        Iterator<T> it3 = list3.iterator();
        while (it3.hasNext()) {
            listB.add(s((ProtoBuf$TypeAlias) it3.next(), dVar));
        }
    }
}
