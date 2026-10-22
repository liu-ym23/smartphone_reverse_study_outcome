package z7;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class x1 {

    /* renamed from: a, reason: collision with root package name */
    public static final e9.c f11989a = new e9.c("kotlin.jvm.JvmStatic");

    public static final s a(w7.c cVar) {
        s sVar = cVar instanceof s ? (s) cVar : null;
        if (sVar != null) {
            return sVar;
        }
        g0 g0VarB = b(cVar);
        return g0VarB != null ? g0VarB : c(cVar);
    }

    public static final g0 b(Object obj) {
        g0 g0Var = obj instanceof g0 ? (g0) obj : null;
        if (g0Var != null) {
            return g0Var;
        }
        q7.h hVar = obj instanceof q7.h ? (q7.h) obj : null;
        w7.c cVarA = hVar != null ? hVar.a() : null;
        if (cVarA instanceof g0) {
            return (g0) cVarA;
        }
        return null;
    }

    public static final k1 c(Object obj) {
        k1 k1Var = obj instanceof k1 ? (k1) obj : null;
        if (k1Var != null) {
            return k1Var;
        }
        q7.q qVar = obj instanceof q7.q ? (q7.q) obj : null;
        w7.c cVarA = qVar != null ? qVar.a() : null;
        if (cVarA instanceof k1) {
            return (k1) cVarA;
        }
        return null;
    }

    public static final ArrayList d(g8.a aVar) throws IllegalAccessException, IllegalArgumentException, NegativeArraySizeException, InvocationTargetException {
        List listS;
        q7.k.e(aVar, "<this>");
        g8.j annotations = aVar.getAnnotations();
        ArrayList arrayList = new ArrayList();
        Iterator it = annotations.iterator();
        while (true) {
            Annotation annotationI = null;
            if (!it.hasNext()) {
                break;
            }
            g8.c cVar = (g8.c) it.next();
            f8.n0 n0VarQ = cVar.q();
            if (n0VarQ instanceof k8.a) {
                annotationI = ((k8.a) n0VarQ).f5650f;
            } else if (n0VarQ instanceof k8.g) {
                l8.s sVar = ((k8.g) n0VarQ).f5659f;
                l8.e eVar = sVar instanceof l8.e ? (l8.e) sVar : null;
                if (eVar != null) {
                    annotationI = eVar.f5865a;
                }
            } else {
                annotationI = i(cVar);
            }
            if (annotationI != null) {
                arrayList.add(annotationI);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (nb.i.t(nb.i.p((Annotation) it2.next())).getSimpleName().equals("Container")) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        Annotation annotation = (Annotation) it3.next();
                        Class clsT = nb.i.t(nb.i.p(annotation));
                        if (!clsT.getSimpleName().equals("Container") || clsT.getAnnotation(q7.y.class) == null) {
                            listS = a.a.S(annotation);
                        } else {
                            Object objInvoke = clsT.getDeclaredMethod("value", null).invoke(annotation, null);
                            q7.k.c(objInvoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                            listS = d7.n.S((Annotation[]) objInvoke);
                        }
                        d7.x.D0(arrayList2, listS);
                    }
                    return arrayList2;
                }
            }
        }
        return arrayList;
    }

    public static final Object e(Type type) {
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (type.equals(Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (type.equals(Character.TYPE)) {
            return (char) 0;
        }
        if (type.equals(Byte.TYPE)) {
            return (byte) 0;
        }
        if (type.equals(Short.TYPE)) {
            return (short) 0;
        }
        if (type.equals(Integer.TYPE)) {
            return 0;
        }
        if (type.equals(Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (type.equals(Long.TYPE)) {
            return 0L;
        }
        if (type.equals(Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (type.equals(Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException("Unknown primitive: " + type);
    }

    public static final f8.b f(Class cls, f9.l lVar, b9.f fVar, b9.g gVar, b9.a aVar, p7.n nVar) {
        List list;
        q7.k.e(cls, "moduleAnchor");
        q7.k.e(lVar, "proto");
        q7.k.e(fVar, "nameResolver");
        q7.k.e(aVar, "metadataVersion");
        k8.f fVarA = p1.a(cls);
        if (lVar instanceof z8.x) {
            list = ((z8.x) lVar).f12451n;
        } else {
            if (!(lVar instanceof z8.f0)) {
                throw new IllegalStateException(("Unsupported message: " + lVar).toString());
            }
            list = ((z8.f0) lVar).f12140n;
        }
        List list2 = list;
        r9.i iVar = fVarA.f5657a;
        f8.z zVar = iVar.f9048b;
        b9.h hVar = b9.h.f1585b;
        q7.k.d(list2, "typeParameters");
        return (f8.b) nVar.invoke(new r9.r(new r9.k(iVar, fVar, zVar, gVar, hVar, aVar, null, null, list2)), lVar);
    }

    public static final i8.v g(f8.c cVar) {
        q7.k.e(cVar, "<this>");
        if (cVar.y() == null) {
            return null;
        }
        f8.j jVarP = cVar.p();
        q7.k.c(jVarP, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((f8.e) jVarP).B0();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class h(ClassLoader classLoader, e9.b bVar, int i2) {
        String str = e8.d.f3123a;
        e9.e eVarI = bVar.b().i();
        q7.k.d(eVarI, "kotlinClassId.asSingleFqName().toUnsafe()");
        e9.b bVarF = e8.d.f(eVarI);
        if (bVarF != null) {
            bVar = bVarF;
        }
        String strB = bVar.g().b();
        String strB2 = bVar.h().b();
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
        StringBuilder sb2 = new StringBuilder();
        if (i2 > 0) {
            for (int i10 = 0; i10 < i2; i10++) {
                sb2.append("[");
            }
            sb2.append("L");
        }
        if (strB.length() > 0) {
            sb2.append(strB.concat("."));
        }
        sb2.append(ga.r.d0(strB2, '.', '$'));
        if (i2 > 0) {
            sb2.append(";");
        }
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return s7.a.n0(classLoader, string);
    }

    public static final Annotation i(g8.c cVar) throws NegativeArraySizeException {
        f8.e eVarD = l9.d.d(cVar);
        Class clsJ = eVarD != null ? j(eVarD) : null;
        if (clsJ == null) {
            clsJ = null;
        }
        if (clsJ == null) {
            return null;
        }
        Set<Map.Entry> setEntrySet = cVar.b().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : setEntrySet) {
            e9.f fVar = (e9.f) entry.getKey();
            j9.g gVar = (j9.g) entry.getValue();
            ClassLoader classLoader = clsJ.getClassLoader();
            q7.k.d(classLoader, "annotationClass.classLoader");
            Object objK = k(gVar, classLoader);
            c7.j jVar = objK != null ? new c7.j(fVar.b(), objK) : null;
            if (jVar != null) {
                arrayList.add(jVar);
            }
        }
        Map mapZ = d7.e0.Z(arrayList);
        Set setKeySet = mapZ.keySet();
        ArrayList arrayList2 = new ArrayList(d7.t.A0(setKeySet, 10));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList2.add(clsJ.getDeclaredMethod((String) it.next(), null));
        }
        return (Annotation) a.a.k(clsJ, mapZ, arrayList2);
    }

    public static final Class j(f8.e eVar) {
        q7.k.e(eVar, "<this>");
        f8.n0 n0VarQ = eVar.q();
        q7.k.d(n0VarQ, "source");
        if (n0VarQ instanceof x8.n) {
            return ((x8.n) n0VarQ).f11272f.f5652a;
        }
        if (n0VarQ instanceof k8.g) {
            l8.s sVar = ((k8.g) n0VarQ).f5659f;
            q7.k.c(sVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((l8.o) sVar).f5878a;
        }
        e9.b bVarF = l9.d.f(eVar);
        if (bVarF == null) {
            return null;
        }
        return h(l8.d.d(eVar.getClass()), bVarF, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object k(j9.g gVar, ClassLoader classLoader) throws NegativeArraySizeException {
        v9.v vVar;
        Class clsH;
        if (gVar instanceof j9.a) {
            return i((g8.c) ((j9.a) gVar).f5408a);
        }
        int i2 = 0;
        if (gVar instanceof j9.b) {
            j9.b bVar = (j9.b) gVar;
            j9.x xVar = bVar instanceof j9.x ? (j9.x) bVar : null;
            if (xVar != null && (vVar = xVar.f5417c) != null) {
                Object obj = bVar.f5408a;
                Iterable iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(d7.t.A0(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(k((j9.g) it.next(), classLoader));
                }
                e9.f fVar = c8.h.f1999e;
                f8.g gVarC = vVar.E0().c();
                c8.j jVarR = gVarC == null ? null : c8.h.r(gVarC);
                switch (jVarR == null ? -1 : w1.$EnumSwitchMapping$0[jVarR.ordinal()]) {
                    case -1:
                        if (!c8.h.y(vVar)) {
                            throw new IllegalStateException(("Not an array type: " + vVar).toString());
                        }
                        v9.v vVarB = ((v9.p0) d7.r.f1(vVar.C0())).b();
                        q7.k.d(vVarB, "type.arguments.single().type");
                        f8.g gVarC2 = vVarB.E0().c();
                        f8.e eVar = gVarC2 instanceof f8.e ? (f8.e) gVarC2 : null;
                        if (eVar == null) {
                            throw new IllegalStateException(("Not a class type: " + vVarB).toString());
                        }
                        if (c8.h.G(vVarB)) {
                            int size = ((List) obj).size();
                            String[] strArr = new String[size];
                            while (i2 < size) {
                                Object obj2 = arrayList.get(i2);
                                q7.k.c(obj2, "null cannot be cast to non-null type kotlin.String");
                                strArr[i2] = obj2;
                                i2++;
                            }
                            return strArr;
                        }
                        if (c8.h.b(eVar, c8.m.P)) {
                            int size2 = ((List) obj).size();
                            Class[] clsArr = new Class[size2];
                            while (i2 < size2) {
                                Object obj3 = arrayList.get(i2);
                                q7.k.c(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                                clsArr[i2] = obj3;
                                i2++;
                            }
                            return clsArr;
                        }
                        e9.b bVarF = l9.d.f(eVar);
                        if (bVarF != null && (clsH = h(classLoader, bVarF, 0)) != null) {
                            Object objNewInstance = Array.newInstance((Class<?>) clsH, ((List) obj).size());
                            q7.k.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                            Object[] objArr = (Object[]) objNewInstance;
                            int size3 = arrayList.size();
                            while (i2 < size3) {
                                objArr[i2] = arrayList.get(i2);
                                i2++;
                            }
                            return objArr;
                        }
                        break;
                    case 0:
                    default:
                        throw new a4.u();
                    case 1:
                        int size4 = ((List) obj).size();
                        boolean[] zArr = new boolean[size4];
                        while (i2 < size4) {
                            Object obj4 = arrayList.get(i2);
                            q7.k.c(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                            zArr[i2] = ((Boolean) obj4).booleanValue();
                            i2++;
                        }
                        return zArr;
                    case 2:
                        int size5 = ((List) obj).size();
                        char[] cArr = new char[size5];
                        while (i2 < size5) {
                            Object obj5 = arrayList.get(i2);
                            q7.k.c(obj5, "null cannot be cast to non-null type kotlin.Char");
                            cArr[i2] = ((Character) obj5).charValue();
                            i2++;
                        }
                        return cArr;
                    case 3:
                        int size6 = ((List) obj).size();
                        byte[] bArr = new byte[size6];
                        while (i2 < size6) {
                            Object obj6 = arrayList.get(i2);
                            q7.k.c(obj6, "null cannot be cast to non-null type kotlin.Byte");
                            bArr[i2] = ((Byte) obj6).byteValue();
                            i2++;
                        }
                        return bArr;
                    case 4:
                        int size7 = ((List) obj).size();
                        short[] sArr = new short[size7];
                        while (i2 < size7) {
                            Object obj7 = arrayList.get(i2);
                            q7.k.c(obj7, "null cannot be cast to non-null type kotlin.Short");
                            sArr[i2] = ((Short) obj7).shortValue();
                            i2++;
                        }
                        return sArr;
                    case 5:
                        int size8 = ((List) obj).size();
                        int[] iArr = new int[size8];
                        while (i2 < size8) {
                            Object obj8 = arrayList.get(i2);
                            q7.k.c(obj8, "null cannot be cast to non-null type kotlin.Int");
                            iArr[i2] = ((Integer) obj8).intValue();
                            i2++;
                        }
                        return iArr;
                    case 6:
                        int size9 = ((List) obj).size();
                        float[] fArr = new float[size9];
                        while (i2 < size9) {
                            Object obj9 = arrayList.get(i2);
                            q7.k.c(obj9, "null cannot be cast to non-null type kotlin.Float");
                            fArr[i2] = ((Float) obj9).floatValue();
                            i2++;
                        }
                        return fArr;
                    case 7:
                        int size10 = ((List) obj).size();
                        long[] jArr = new long[size10];
                        while (i2 < size10) {
                            Object obj10 = arrayList.get(i2);
                            q7.k.c(obj10, "null cannot be cast to non-null type kotlin.Long");
                            jArr[i2] = ((Long) obj10).longValue();
                            i2++;
                        }
                        return jArr;
                    case 8:
                        int size11 = ((List) obj).size();
                        double[] dArr = new double[size11];
                        while (i2 < size11) {
                            Object obj11 = arrayList.get(i2);
                            q7.k.c(obj11, "null cannot be cast to non-null type kotlin.Double");
                            dArr[i2] = ((Double) obj11).doubleValue();
                            i2++;
                        }
                        return dArr;
                }
            }
        } else if (gVar instanceof j9.i) {
            c7.j jVar = (c7.j) ((j9.i) gVar).f5408a;
            e9.b bVar2 = (e9.b) jVar.f1973f;
            e9.f fVar2 = (e9.f) jVar.f1974g;
            Class clsH2 = h(classLoader, bVar2, 0);
            if (clsH2 != null) {
                return Enum.valueOf(clsH2, fVar2.b());
            }
        } else if (gVar instanceof j9.s) {
            j9.r rVar = (j9.r) ((j9.s) gVar).f5408a;
            if (rVar instanceof j9.q) {
                j9.f fVar3 = ((j9.q) rVar).f5416a;
                return h(classLoader, fVar3.f5406a, fVar3.f5407b);
            }
            if (!(rVar instanceof j9.p)) {
                throw new a4.u();
            }
            f8.g gVarC3 = ((j9.p) rVar).f5415a.E0().c();
            f8.e eVar2 = gVarC3 instanceof f8.e ? (f8.e) gVarC3 : null;
            if (eVar2 != null) {
                return j(eVar2);
            }
        } else {
            if (!(gVar instanceof j9.j ? true : gVar instanceof j9.u)) {
                return gVar.b();
            }
        }
        return null;
    }
}
