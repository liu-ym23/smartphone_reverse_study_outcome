package T8;

import h8.InterfaceC1503K;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1540w;
import i8.C1557c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k8.C1640i;
import k8.Q;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;

/* renamed from: T8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0252d {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1540w f1217a;
    public final u1.d b;

    public C0252d(InterfaceC1540w module, u1.d notFoundClasses) {
        kotlin.jvm.internal.k.f(module, "module");
        kotlin.jvm.internal.k.f(notFoundClasses, "notFoundClasses");
        this.f1217a = module;
        this.b = notFoundClasses;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.Pair] */
    public final C1557c a(ProtoBuf$Annotation proto, D8.f nameResolver) {
        kotlin.jvm.internal.k.f(proto, "proto");
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        InterfaceC1522e interfaceC1522eC = kotlin.reflect.jvm.internal.impl.descriptors.a.c(this.f1217a, N9.j.s(nameResolver, proto.c), this.b);
        Map mapM = kotlin.collections.a.M();
        if (proto.d.size() != 0 && !Z8.i.f(interfaceC1522eC)) {
            int i = J8.e.f883a;
            if (J8.e.n(interfaceC1522eC, ClassKind.e)) {
                Collection collectionN = interfaceC1522eC.n();
                kotlin.jvm.internal.k.e(collectionN, "getConstructors(...)");
                C1640i c1640i = (C1640i) D7.v.V0(collectionN);
                if (c1640i != null) {
                    List listX = c1640i.x();
                    kotlin.jvm.internal.k.e(listX, "getValueParameters(...)");
                    List list = listX;
                    int iP = kotlin.collections.a.P(D7.w.c0(list, 10));
                    if (iP < 16) {
                        iP = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
                    for (Object obj : list) {
                        linkedHashMap.put(((Q) obj).getName(), obj);
                    }
                    List<ProtoBuf$Annotation.Argument> list2 = proto.d;
                    kotlin.jvm.internal.k.e(list2, "getArgumentList(...)");
                    ArrayList arrayList = new ArrayList();
                    for (ProtoBuf$Annotation.Argument argument : list2) {
                        kotlin.jvm.internal.k.c(argument);
                        Q q5 = (Q) linkedHashMap.get(N9.j.x(nameResolver, argument.c));
                        if (q5 != null) {
                            G8.f fVarX = N9.j.x(nameResolver, argument.c);
                            X8.w type = q5.getType();
                            kotlin.jvm.internal.k.e(type, "getType(...)");
                            ProtoBuf$Annotation.Argument.Value value = argument.d;
                            kotlin.jvm.internal.k.e(value, "getValue(...)");
                            L8.g gVarC = c(type, value, nameResolver);
                            pair = b(gVarC, type, value) ? gVarC : null;
                            if (pair == null) {
                                String message = "Unexpected argument value: actual type " + value.c + " != expected type " + type;
                                kotlin.jvm.internal.k.f(message, "message");
                                pair = new L8.j(message);
                            }
                            pair = new Pair(fVarX, pair);
                        }
                        if (pair != null) {
                            arrayList.add(pair);
                        }
                    }
                    mapM = kotlin.collections.a.X(arrayList);
                }
            }
        }
        return new C1557c(interfaceC1522eC.g(), mapM, InterfaceC1503K.f4577I);
    }

    public final boolean b(L8.g gVar, X8.w wVar, ProtoBuf$Annotation.Argument.Value value) {
        ProtoBuf$Annotation.Argument.Value.Type type = value.c;
        int i = type == null ? -1 : AbstractC0251c.f1216a[type.ordinal()];
        if (i == 10) {
            InterfaceC1524g interfaceC1524gD = wVar.Q().d();
            InterfaceC1522e interfaceC1522e = interfaceC1524gD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gD : null;
            if (interfaceC1522e == null) {
                return true;
            }
            G8.f fVar = e8.i.e;
            return e8.i.b(interfaceC1522e, e8.n.f4403Q);
        }
        InterfaceC1540w interfaceC1540w = this.f1217a;
        if (i != 13) {
            return kotlin.jvm.internal.k.b(gVar.a(interfaceC1540w), wVar);
        }
        if (gVar instanceof L8.b) {
            L8.b bVar = (L8.b) gVar;
            if (((List) bVar.f939a).size() == value.k.size()) {
                X8.w wVarF = interfaceC1540w.c().f(wVar);
                Iterable iterableF = H4.o.F((Collection) bVar.f939a);
                if ((iterableF instanceof Collection) && ((Collection) iterableF).isEmpty()) {
                    return true;
                }
                Y7.e it = iterableF.iterator();
                while (it.c) {
                    int iNextInt = it.nextInt();
                    L8.g gVar2 = (L8.g) ((List) bVar.f939a).get(iNextInt);
                    ProtoBuf$Annotation.Argument.Value value2 = (ProtoBuf$Annotation.Argument.Value) value.k.get(iNextInt);
                    kotlin.jvm.internal.k.e(value2, "getArrayElement(...)");
                    if (!b(gVar2, wVarF, value2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + gVar).toString());
    }

    public final L8.g c(X8.w wVar, ProtoBuf$Annotation.Argument.Value value, D8.f nameResolver) {
        kotlin.jvm.internal.k.f(value, "value");
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        boolean zBooleanValue = D8.e.f421N.c(value.m).booleanValue();
        ProtoBuf$Annotation.Argument.Value.Type type = value.c;
        switch (type == null ? -1 : AbstractC0251c.f1216a[type.ordinal()]) {
            case 1:
                byte b = (byte) value.d;
                return zBooleanValue ? new L8.y(b) : new L8.d(b);
            case 2:
                return new L8.e(Character.valueOf((char) value.d));
            case 3:
                short s5 = (short) value.d;
                return zBooleanValue ? new L8.y(s5) : new L8.v(s5);
            case 4:
                int i = (int) value.d;
                return zBooleanValue ? new L8.y(i) : new L8.k(i);
            case 5:
                long j5 = value.d;
                return zBooleanValue ? new L8.y(j5) : new L8.t(j5);
            case 6:
                return new L8.c(value.e);
            case 7:
                return new L8.c(value.f);
            case 8:
                return new L8.c(Boolean.valueOf(value.d != 0));
            case 9:
                return new L8.w(nameResolver.getString(value.g));
            case 10:
                return new L8.s(N9.j.s(nameResolver, value.h), value.l);
            case 11:
                return new L8.i(N9.j.s(nameResolver, value.h), N9.j.x(nameResolver, value.i));
            case 12:
                ProtoBuf$Annotation protoBuf$Annotation = value.f5015j;
                kotlin.jvm.internal.k.e(protoBuf$Annotation, "getAnnotation(...)");
                return new L8.a((Object) a(protoBuf$Annotation, nameResolver));
            case 13:
                List list = value.k;
                kotlin.jvm.internal.k.e(list, "getArrayElementList(...)");
                List<ProtoBuf$Annotation.Argument.Value> list2 = list;
                ArrayList arrayList = new ArrayList(D7.w.c0(list2, 10));
                for (ProtoBuf$Annotation.Argument.Value value2 : list2) {
                    X8.A aE = this.f1217a.c().e();
                    kotlin.jvm.internal.k.c(value2);
                    arrayList.add(c(aE, value2, nameResolver));
                }
                return new L8.x(arrayList, wVar);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.c + " (expected " + wVar + ')').toString());
        }
    }
}
