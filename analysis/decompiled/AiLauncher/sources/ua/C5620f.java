package ua;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0819y;
import E9.i0;
import Z8.C1173v;
import Z8.C1174w;
import ea.C4018b;
import ea.InterfaceC4020d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ka.C4828h;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import ma.AbstractC4927g;
import ma.C4916A;
import ma.C4917B;
import ma.C4918C;
import ma.C4919D;
import ma.C4921a;
import ma.C4922b;
import ma.C4923c;
import ma.C4924d;
import ma.C4925e;
import ma.C4929i;
import ma.C4930j;
import v9.C5685n;
import ya.AbstractC5990d0;

/* renamed from: ua.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5620f {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0819y f42594a;

    /* renamed from: b, reason: collision with root package name */
    public final E9.D f42595b;

    /* renamed from: ua.f$a */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42596a;

        static {
            int[] iArr = new int[ProtoBuf$Annotation.Argument.Value.Type.values().length];
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            f42596a = iArr;
        }
    }

    public C5620f(InterfaceC0819y module, E9.D notFoundClasses) {
        kotlin.jvm.internal.p.i(module, "module");
        kotlin.jvm.internal.p.i(notFoundClasses, "notFoundClasses");
        this.f42594a = module;
        this.f42595b = notFoundClasses;
    }

    public final F9.c a(ProtoBuf$Annotation proto, InterfaceC4020d nameResolver) {
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        InterfaceC0797b interfaceC0797bE = e(C5602L.a(nameResolver, proto.y()));
        Map mapI = kotlin.collections.a.i();
        if (proto.v() != 0 && !Aa.i.m(interfaceC0797bE) && C4828h.t(interfaceC0797bE)) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collectionH = interfaceC0797bE.h();
            kotlin.jvm.internal.p.h(collectionH, "getConstructors(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.b bVar = (kotlin.reflect.jvm.internal.impl.descriptors.b) Z8.F.Y0(collectionH);
            if (bVar != null) {
                List<i0> listI = bVar.i();
                kotlin.jvm.internal.p.h(listI, "getValueParameters(...)");
                List<i0> list = listI;
                LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
                for (Object obj : list) {
                    linkedHashMap.put(((i0) obj).getName(), obj);
                }
                List<ProtoBuf$Annotation.Argument> listW = proto.w();
                kotlin.jvm.internal.p.h(listW, "getArgumentList(...)");
                ArrayList arrayList = new ArrayList();
                for (ProtoBuf$Annotation.Argument argument : listW) {
                    kotlin.jvm.internal.p.f(argument);
                    Pair<ga.e, AbstractC4927g<?>> pairD = d(argument, linkedHashMap, nameResolver);
                    if (pairD != null) {
                        arrayList.add(pairD);
                    }
                }
                mapI = kotlin.collections.a.y(arrayList);
            }
        }
        return new F9.d(interfaceC0797bE.n(), mapI, E9.W.f2444a);
    }

    public final boolean b(AbstractC4927g<?> abstractC4927g, ya.S s10, ProtoBuf$Annotation.Argument.Value value) {
        ProtoBuf$Annotation.Argument.Value.Type typeS = value.S();
        int i10 = typeS == null ? -1 : a.f42596a[typeS.ordinal()];
        if (i10 == 10) {
            InterfaceC0799d interfaceC0799dD = s10.H0().d();
            InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
            return interfaceC0797b == null || C9.j.m0(interfaceC0797b);
        }
        if (i10 != 13) {
            return kotlin.jvm.internal.p.d(abstractC4927g.a(this.f42594a), s10);
        }
        if (!(abstractC4927g instanceof C4922b) || ((C4922b) abstractC4927g).b().size() != value.J().size()) {
            throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + abstractC4927g).toString());
        }
        ya.S sL = c().l(s10);
        if (sL == null) {
            return false;
        }
        C4922b c4922b = (C4922b) abstractC4927g;
        Iterable iterableN = C1173v.n(c4922b.b());
        if ((iterableN instanceof Collection) && ((Collection) iterableN).isEmpty()) {
            return true;
        }
        Iterator it = iterableN.iterator();
        while (it.hasNext()) {
            int iNextInt = ((Z8.M) it).nextInt();
            AbstractC4927g<?> abstractC4927g2 = c4922b.b().get(iNextInt);
            ProtoBuf$Annotation.Argument.Value valueG = value.G(iNextInt);
            kotlin.jvm.internal.p.h(valueG, "getArrayElement(...)");
            if (!b(abstractC4927g2, sL, valueG)) {
                return false;
            }
        }
        return true;
    }

    public final C9.j c() {
        return this.f42594a.g();
    }

    public final Pair<ga.e, AbstractC4927g<?>> d(ProtoBuf$Annotation.Argument argument, Map<ga.e, ? extends i0> map, InterfaceC4020d interfaceC4020d) {
        i0 i0Var = map.get(C5602L.b(interfaceC4020d, argument.u()));
        if (i0Var == null) {
            return null;
        }
        ga.e eVarB = C5602L.b(interfaceC4020d, argument.u());
        ya.S type = i0Var.getType();
        kotlin.jvm.internal.p.h(type, "getType(...)");
        ProtoBuf$Annotation.Argument.Value valueV = argument.v();
        kotlin.jvm.internal.p.h(valueV, "getValue(...)");
        return new Pair<>(eVarB, g(type, valueV, interfaceC4020d));
    }

    public final InterfaceC0797b e(ga.b bVar) {
        return FindClassInModuleKt.d(this.f42594a, bVar, this.f42595b);
    }

    public final AbstractC4927g<?> f(ya.S expectedType, ProtoBuf$Annotation.Argument.Value value, InterfaceC4020d nameResolver) {
        kotlin.jvm.internal.p.i(expectedType, "expectedType");
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        Boolean boolD = C4018b.f32373S.d(value.O());
        kotlin.jvm.internal.p.h(boolD, "get(...)");
        boolean zBooleanValue = boolD.booleanValue();
        ProtoBuf$Annotation.Argument.Value.Type typeS = value.S();
        switch (typeS == null ? -1 : a.f42596a[typeS.ordinal()]) {
            case 1:
                byte bQ = (byte) value.Q();
                return zBooleanValue ? new C4916A(bQ) : new C4924d(bQ);
            case 2:
                return new C4925e((char) value.Q());
            case 3:
                short sQ = (short) value.Q();
                return zBooleanValue ? new C4919D(sQ) : new ma.w(sQ);
            case 4:
                int iQ = (int) value.Q();
                return zBooleanValue ? new C4917B(iQ) : new ma.n(iQ);
            case 5:
                long jQ = value.Q();
                return zBooleanValue ? new C4918C(jQ) : new ma.t(jQ);
            case 6:
                return new ma.m(value.P());
            case 7:
                return new C4930j(value.M());
            case 8:
                return new C4923c(value.Q() != 0);
            case 9:
                return new ma.x(nameResolver.getString(value.R()));
            case 10:
                return new ma.s(C5602L.a(nameResolver, value.K()), value.F());
            case 11:
                return new ma.k(C5602L.a(nameResolver, value.K()), C5602L.b(nameResolver, value.N()));
            case 12:
                ProtoBuf$Annotation protoBuf$AnnotationE = value.E();
                kotlin.jvm.internal.p.h(protoBuf$AnnotationE, "getAnnotation(...)");
                return new C4921a(a(protoBuf$AnnotationE, nameResolver));
            case 13:
                C4929i c4929i = C4929i.f37195a;
                List<ProtoBuf$Annotation.Argument.Value> listJ = value.J();
                kotlin.jvm.internal.p.h(listJ, "getArrayElementList(...)");
                List<ProtoBuf$Annotation.Argument.Value> list = listJ;
                ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
                for (ProtoBuf$Annotation.Argument.Value value2 : list) {
                    AbstractC5990d0 abstractC5990d0I = c().i();
                    kotlin.jvm.internal.p.h(abstractC5990d0I, "getAnyType(...)");
                    kotlin.jvm.internal.p.f(value2);
                    arrayList.add(f(abstractC5990d0I, value2, nameResolver));
                }
                return c4929i.c(arrayList, expectedType);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.S() + " (expected " + expectedType + ')').toString());
        }
    }

    public final AbstractC4927g<?> g(ya.S s10, ProtoBuf$Annotation.Argument.Value value, InterfaceC4020d interfaceC4020d) {
        AbstractC4927g<?> abstractC4927gF = f(s10, value, interfaceC4020d);
        if (!b(abstractC4927gF, s10, value)) {
            abstractC4927gF = null;
        }
        if (abstractC4927gF != null) {
            return abstractC4927gF;
        }
        return ma.l.f37198b.a("Unexpected argument value: actual type " + value.S() + " != expected type " + s10);
    }
}
