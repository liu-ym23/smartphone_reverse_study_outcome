package b8;

import androidx.compose.material3.internal.TextFieldImplKt;
import g8.C1468d;
import h8.InterfaceC1503K;
import h8.InterfaceC1519b;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import h8.InterfaceC1540w;
import i8.InterfaceC1555a;
import i8.InterfaceC1556b;
import i8.InterfaceC1561g;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.PropertyReference;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import m8.C1681a;
import n8.AbstractC1744c;

/* loaded from: classes4.dex */
public abstract class v0 {

    /* renamed from: a, reason: collision with root package name */
    public static final G8.c f2060a = new G8.c("kotlin.jvm.JvmStatic");

    public static final AbstractC0857s a(Object obj) {
        AbstractC0857s abstractC0857s = obj instanceof AbstractC0857s ? (AbstractC0857s) obj : null;
        if (abstractC0857s != null) {
            return abstractC0857s;
        }
        C0832E c0832eB = b(obj);
        return c0832eB != null ? c0832eB : c(obj);
    }

    public static final C0832E b(Object obj) {
        C0832E c0832e = obj instanceof C0832E ? (C0832E) obj : null;
        if (c0832e != null) {
            return c0832e;
        }
        FunctionReference functionReference = obj instanceof FunctionReference ? (FunctionReference) obj : null;
        Z7.c cVarCompute = functionReference != null ? functionReference.compute() : null;
        if (cVarCompute instanceof C0832E) {
            return (C0832E) cVarCompute;
        }
        return null;
    }

    public static final i0 c(Object obj) {
        i0 i0Var = obj instanceof i0 ? (i0) obj : null;
        if (i0Var != null) {
            return i0Var;
        }
        PropertyReference propertyReference = obj instanceof PropertyReference ? (PropertyReference) obj : null;
        Z7.c cVarCompute = propertyReference != null ? propertyReference.compute() : null;
        if (cVarCompute instanceof i0) {
            return (i0) cVarCompute;
        }
        return null;
    }

    public static final ArrayList d(InterfaceC1555a interfaceC1555a) throws IllegalAccessException, IllegalArgumentException, NegativeArraySizeException, InvocationTargetException {
        List listM;
        kotlin.jvm.internal.k.f(interfaceC1555a, "<this>");
        InterfaceC1561g annotations = interfaceC1555a.getAnnotations();
        ArrayList arrayList = new ArrayList();
        Iterator it = annotations.iterator();
        while (true) {
            Annotation annotationJ = null;
            if (!it.hasNext()) {
                break;
            }
            InterfaceC1556b interfaceC1556b = (InterfaceC1556b) it.next();
            InterfaceC1503K source = interfaceC1556b.getSource();
            if (source instanceof C1681a) {
                annotationJ = ((C1681a) source).f5306a;
            } else if (source instanceof m8.f) {
                n8.l lVar = ((m8.f) source).f5310a;
                n8.d dVar = lVar instanceof n8.d ? (n8.d) lVar : null;
                if (dVar != null) {
                    annotationJ = dVar.f5356a;
                }
            } else {
                annotationJ = j(interfaceC1556b);
            }
            if (annotationJ != null) {
                arrayList.add(annotationJ);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (M.a.Z(M.a.V((Annotation) it2.next())).getSimpleName().equals(TextFieldImplKt.ContainerId)) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        Annotation annotation = (Annotation) it3.next();
                        Class clsZ = M.a.Z(M.a.V(annotation));
                        if (!clsZ.getSimpleName().equals(TextFieldImplKt.ContainerId) || clsZ.getAnnotation(kotlin.jvm.internal.o.class) == null) {
                            listM = H4.o.M(annotation);
                        } else {
                            Object objInvoke = clsZ.getDeclaredMethod("value", null).invoke(annotation, null);
                            kotlin.jvm.internal.k.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                            listM = D7.q.L((Annotation[]) objInvoke);
                        }
                        D7.A.e0(listM, arrayList2);
                    }
                    return arrayList2;
                }
            }
        }
        return arrayList;
    }

    public static final Object e(Type type) {
        kotlin.jvm.internal.k.f(type, "type");
        if (!(type instanceof Class)) {
            return null;
        }
        Class cls = (Class) type;
        if (!cls.isPrimitive()) {
            return null;
        }
        if (cls.equals(Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (cls.equals(Character.TYPE)) {
            return (char) 0;
        }
        if (cls.equals(Byte.TYPE)) {
            return (byte) 0;
        }
        if (cls.equals(Short.TYPE)) {
            return (short) 0;
        }
        if (cls.equals(Integer.TYPE)) {
            return 0;
        }
        if (cls.equals(Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (cls.equals(Long.TYPE)) {
            return 0L;
        }
        if (cls.equals(Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (cls.equals(Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException("Unknown primitive: " + type);
    }

    public static final InterfaceC1519b f(Class moduleAnchor, GeneratedMessageLite.ExtendableMessage proto, D8.f nameResolver, D8.j jVar, D8.a metadataVersion, S7.n createDescriptor) {
        List list;
        kotlin.jvm.internal.k.f(moduleAnchor, "moduleAnchor");
        kotlin.jvm.internal.k.f(proto, "proto");
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.k.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.k.f(createDescriptor, "createDescriptor");
        m8.e eVarA = o0.a(moduleAnchor);
        if (proto instanceof ProtoBuf$Function) {
            list = ((ProtoBuf$Function) proto).i;
        } else {
            if (!(proto instanceof ProtoBuf$Property)) {
                throw new IllegalStateException(("Unsupported message: " + proto).toString());
            }
            list = ((ProtoBuf$Property) proto).i;
        }
        List list2 = list;
        T8.k kVar = eVarA.f5309a;
        InterfaceC1540w interfaceC1540w = kVar.b;
        D8.k kVar2 = D8.k.b;
        kotlin.jvm.internal.k.c(list2);
        return (InterfaceC1519b) createDescriptor.invoke(new T8.v(new T8.m(kVar, nameResolver, interfaceC1540w, jVar, kVar2, metadataVersion, null, null, list2)), proto);
    }

    public static final k8.u g(InterfaceC1519b interfaceC1519b) {
        kotlin.jvm.internal.k.f(interfaceC1519b, "<this>");
        if (interfaceC1519b.E() == null) {
            return null;
        }
        InterfaceC1527j interfaceC1527jD = interfaceC1519b.d();
        kotlin.jvm.internal.k.d(interfaceC1527jD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((InterfaceC1522e) interfaceC1527jD).B0();
    }

    public static final boolean h(l0 l0Var) {
        X8.w wVar = l0Var.f2046a;
        return wVar != null && J8.g.h(wVar);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class i(ClassLoader classLoader, G8.b bVar, int i) {
        String str = C1468d.f4490a;
        G8.e eVarI = bVar.a().i();
        kotlin.jvm.internal.k.e(eVarI, "toUnsafe(...)");
        G8.b bVarF = C1468d.f(eVarI);
        if (bVarF != null) {
            bVar = bVarF;
        }
        String strB = bVar.f687a.b();
        String strB2 = bVar.b.b();
        if (strB.equals("kotlin")) {
            switch (strB2.hashCode()) {
                case -901856463:
                    if (strB2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (strB2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (strB2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (strB2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (strB2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (strB2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (strB2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (strB2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (strB2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (i > 0) {
            for (int i6 = 0; i6 < i; i6++) {
                sb.append("[");
            }
            sb.append("L");
        }
        if (strB.length() > 0) {
            sb.append(strB.concat("."));
        }
        sb.append(j9.t.b0(strB2, '.', '$'));
        if (i > 0) {
            sb.append(";");
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return U7.a.Y(classLoader, string);
    }

    public static final Annotation j(InterfaceC1556b interfaceC1556b) throws NegativeArraySizeException {
        InterfaceC1522e interfaceC1522eD = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(interfaceC1556b);
        Class clsK = interfaceC1522eD != null ? k(interfaceC1522eD) : null;
        if (clsK == null) {
            clsK = null;
        }
        if (clsK == null) {
            return null;
        }
        Set<Map.Entry> setEntrySet = interfaceC1556b.a().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : setEntrySet) {
            G8.f fVar = (G8.f) entry.getKey();
            L8.g gVar = (L8.g) entry.getValue();
            ClassLoader classLoader = clsK.getClassLoader();
            kotlin.jvm.internal.k.e(classLoader, "getClassLoader(...)");
            Object objL = l(gVar, classLoader);
            Pair pair = objL != null ? new Pair(fVar.b(), objL) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Map mapX = kotlin.collections.a.X(arrayList);
        Set setKeySet = mapX.keySet();
        ArrayList arrayList2 = new ArrayList(D7.w.c0(setKeySet, 10));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList2.add(clsK.getDeclaredMethod((String) it.next(), null));
        }
        return (Annotation) com.stepos.statsrpk.d.q(clsK, mapX, arrayList2);
    }

    public static final Class k(InterfaceC1522e interfaceC1522e) {
        kotlin.jvm.internal.k.f(interfaceC1522e, "<this>");
        InterfaceC1503K source = interfaceC1522e.getSource();
        kotlin.jvm.internal.k.e(source, "getSource(...)");
        if (source instanceof z8.q) {
            return ((z8.q) source).f6987a.f5307a;
        }
        if (source instanceof m8.f) {
            n8.l lVar = ((m8.f) source).f5310a;
            kotlin.jvm.internal.k.d(lVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a) lVar).f4985a;
        }
        G8.b bVarF = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(interfaceC1522e);
        if (bVarF == null) {
            return null;
        }
        return i(AbstractC1744c.d(interfaceC1522e.getClass()), bVarF, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object l(L8.g gVar, ClassLoader classLoader) throws NegativeArraySizeException {
        X8.w wVar;
        Class clsI;
        if (gVar instanceof L8.a) {
            return j((InterfaceC1556b) ((L8.a) gVar).f939a);
        }
        int i = 0;
        if (gVar instanceof L8.b) {
            L8.b bVar = (L8.b) gVar;
            L8.x xVar = bVar instanceof L8.x ? (L8.x) bVar : null;
            if (xVar != null && (wVar = xVar.c) != null) {
                Object obj = bVar.f939a;
                Iterable iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(D7.w.c0(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(l((L8.g) it.next(), classLoader));
                }
                G8.f fVar = e8.i.e;
                InterfaceC1524g interfaceC1524gD = wVar.Q().d();
                PrimitiveType primitiveTypeR = interfaceC1524gD == null ? null : e8.i.r(interfaceC1524gD);
                switch (primitiveTypeR == null ? -1 : u0.f2058a[primitiveTypeR.ordinal()]) {
                    case -1:
                        if (!e8.i.y(wVar)) {
                            throw new IllegalStateException(("Not an array type: " + wVar).toString());
                        }
                        X8.w wVarB = ((X8.N) D7.v.U0(wVar.L())).b();
                        kotlin.jvm.internal.k.e(wVarB, "getType(...)");
                        InterfaceC1524g interfaceC1524gD2 = wVarB.Q().d();
                        InterfaceC1522e interfaceC1522e = interfaceC1524gD2 instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gD2 : null;
                        if (interfaceC1522e == null) {
                            throw new IllegalStateException(("Not a class type: " + wVarB).toString());
                        }
                        if (e8.i.G(wVarB)) {
                            int size = ((List) obj).size();
                            String[] strArr = new String[size];
                            while (i < size) {
                                Object obj2 = arrayList.get(i);
                                kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlin.String");
                                strArr[i] = obj2;
                                i++;
                            }
                            return strArr;
                        }
                        if (e8.i.b(interfaceC1522e, e8.n.f4403Q)) {
                            int size2 = ((List) obj).size();
                            Class[] clsArr = new Class[size2];
                            while (i < size2) {
                                Object obj3 = arrayList.get(i);
                                kotlin.jvm.internal.k.d(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                                clsArr[i] = obj3;
                                i++;
                            }
                            return clsArr;
                        }
                        G8.b bVarF = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(interfaceC1522e);
                        if (bVarF != null && (clsI = i(classLoader, bVarF, 0)) != null) {
                            Object objNewInstance = Array.newInstance((Class<?>) clsI, ((List) obj).size());
                            kotlin.jvm.internal.k.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                            Object[] objArr = (Object[]) objNewInstance;
                            int size3 = arrayList.size();
                            while (i < size3) {
                                objArr[i] = arrayList.get(i);
                                i++;
                            }
                            return objArr;
                        }
                        break;
                    case 0:
                    default:
                        throw new NoWhenBranchMatchedException();
                    case 1:
                        int size4 = ((List) obj).size();
                        boolean[] zArr = new boolean[size4];
                        while (i < size4) {
                            Object obj4 = arrayList.get(i);
                            kotlin.jvm.internal.k.d(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                            zArr[i] = ((Boolean) obj4).booleanValue();
                            i++;
                        }
                        return zArr;
                    case 2:
                        int size5 = ((List) obj).size();
                        char[] cArr = new char[size5];
                        while (i < size5) {
                            Object obj5 = arrayList.get(i);
                            kotlin.jvm.internal.k.d(obj5, "null cannot be cast to non-null type kotlin.Char");
                            cArr[i] = ((Character) obj5).charValue();
                            i++;
                        }
                        return cArr;
                    case 3:
                        int size6 = ((List) obj).size();
                        byte[] bArr = new byte[size6];
                        while (i < size6) {
                            Object obj6 = arrayList.get(i);
                            kotlin.jvm.internal.k.d(obj6, "null cannot be cast to non-null type kotlin.Byte");
                            bArr[i] = ((Byte) obj6).byteValue();
                            i++;
                        }
                        return bArr;
                    case 4:
                        int size7 = ((List) obj).size();
                        short[] sArr = new short[size7];
                        while (i < size7) {
                            Object obj7 = arrayList.get(i);
                            kotlin.jvm.internal.k.d(obj7, "null cannot be cast to non-null type kotlin.Short");
                            sArr[i] = ((Short) obj7).shortValue();
                            i++;
                        }
                        return sArr;
                    case 5:
                        int size8 = ((List) obj).size();
                        int[] iArr = new int[size8];
                        while (i < size8) {
                            Object obj8 = arrayList.get(i);
                            kotlin.jvm.internal.k.d(obj8, "null cannot be cast to non-null type kotlin.Int");
                            iArr[i] = ((Integer) obj8).intValue();
                            i++;
                        }
                        return iArr;
                    case 6:
                        int size9 = ((List) obj).size();
                        float[] fArr = new float[size9];
                        while (i < size9) {
                            Object obj9 = arrayList.get(i);
                            kotlin.jvm.internal.k.d(obj9, "null cannot be cast to non-null type kotlin.Float");
                            fArr[i] = ((Float) obj9).floatValue();
                            i++;
                        }
                        return fArr;
                    case 7:
                        int size10 = ((List) obj).size();
                        long[] jArr = new long[size10];
                        while (i < size10) {
                            Object obj10 = arrayList.get(i);
                            kotlin.jvm.internal.k.d(obj10, "null cannot be cast to non-null type kotlin.Long");
                            jArr[i] = ((Long) obj10).longValue();
                            i++;
                        }
                        return jArr;
                    case 8:
                        int size11 = ((List) obj).size();
                        double[] dArr = new double[size11];
                        while (i < size11) {
                            Object obj11 = arrayList.get(i);
                            kotlin.jvm.internal.k.d(obj11, "null cannot be cast to non-null type kotlin.Double");
                            dArr[i] = ((Double) obj11).doubleValue();
                            i++;
                        }
                        return dArr;
                }
            }
        } else if (gVar instanceof L8.i) {
            Pair pair = (Pair) ((L8.i) gVar).f939a;
            G8.b bVar2 = (G8.b) pair.f4886a;
            G8.f fVar2 = (G8.f) pair.b;
            Class clsI2 = i(classLoader, bVar2, 0);
            if (clsI2 != null) {
                return Enum.valueOf(clsI2, fVar2.b());
            }
        } else {
            if (!(gVar instanceof L8.s)) {
                if ((gVar instanceof L8.j) || (gVar instanceof L8.u)) {
                    return null;
                }
                return gVar.b();
            }
            L8.r rVar = (L8.r) ((L8.s) gVar).f939a;
            if (rVar instanceof L8.q) {
                L8.f fVar3 = ((L8.q) rVar).f943a;
                return i(classLoader, fVar3.f938a, fVar3.b);
            }
            if (!(rVar instanceof L8.p)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC1524g interfaceC1524gD3 = ((L8.p) rVar).f942a.Q().d();
            InterfaceC1522e interfaceC1522e2 = interfaceC1524gD3 instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gD3 : null;
            if (interfaceC1522e2 != null) {
                return k(interfaceC1522e2);
            }
        }
        return null;
    }
}
