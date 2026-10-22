package q8;

import D7.A;
import h8.InterfaceC1522e;
import i8.InterfaceC1556b;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;

/* renamed from: q8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1828a {
    public static final LinkedHashMap c;

    /* renamed from: a, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.load.java.a f5597a;
    public final ConcurrentHashMap b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : AnnotationQualifierApplicabilityType.values()) {
            String str = annotationQualifierApplicabilityType.f4987a;
            if (linkedHashMap.get(str) == null) {
                linkedHashMap.put(str, annotationQualifierApplicabilityType);
            }
        }
        c = linkedHashMap;
    }

    public C1828a(kotlin.reflect.jvm.internal.impl.load.java.a javaTypeEnhancementState) {
        kotlin.jvm.internal.k.f(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.f5597a = javaTypeEnhancementState;
        this.b = new ConcurrentHashMap();
    }

    public static ArrayList a(Object obj, boolean z10) {
        InterfaceC1556b interfaceC1556b = (InterfaceC1556b) obj;
        kotlin.jvm.internal.k.f(interfaceC1556b, "<this>");
        Map mapA = interfaceC1556b.a();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : mapA.entrySet()) {
            A.e0((!z10 || kotlin.jvm.internal.k.b((G8.f) entry.getKey(), u.b)) ? j((L8.g) entry.getValue()) : EmptyList.f4893a, arrayList);
        }
        return arrayList;
    }

    public static Object c(Object obj, G8.c cVar) {
        for (Object obj2 : e(obj)) {
            if (kotlin.jvm.internal.k.b(d(obj2), cVar)) {
                return obj2;
            }
        }
        return null;
    }

    public static G8.c d(Object obj) {
        InterfaceC1556b interfaceC1556b = (InterfaceC1556b) obj;
        kotlin.jvm.internal.k.f(interfaceC1556b, "<this>");
        return interfaceC1556b.b();
    }

    public static Iterable e(Object obj) {
        InterfaceC1561g annotations;
        InterfaceC1556b interfaceC1556b = (InterfaceC1556b) obj;
        kotlin.jvm.internal.k.f(interfaceC1556b, "<this>");
        InterfaceC1522e interfaceC1522eD = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(interfaceC1556b);
        return (interfaceC1522eD == null || (annotations = interfaceC1522eD.getAnnotations()) == null) ? EmptyList.f4893a : annotations;
    }

    public static boolean f(Object obj, G8.c cVar) {
        Iterable iterableE = e(obj);
        if ((iterableE instanceof Collection) && ((Collection) iterableE).isEmpty()) {
            return false;
        }
        Iterator it = iterableE.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.k.b(d(it.next()), cVar)) {
                return true;
            }
        }
        return false;
    }

    public static List j(L8.g gVar) {
        if (!(gVar instanceof L8.b)) {
            return gVar instanceof L8.i ? H4.o.M(((L8.i) gVar).c.c()) : EmptyList.f4893a;
        }
        Iterable iterable = (Iterable) ((L8.b) gVar).f939a;
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            A.e0(j((L8.g) it.next()), arrayList);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012c  */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final q8.C1845r b(q8.C1845r r12, i8.InterfaceC1561g r13) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.C1828a.b(q8.r, i8.g):q8.r");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        if (r5.equals("ALWAYS") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
    
        if (r5.equals("NEVER") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
    
        if (r5.equals("MAYBE") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0080, code lost:
    
        r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.b;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final y8.C2143f g(java.lang.Object r5, boolean r6) {
        /*
            r4 = this;
            G8.c r0 = d(r5)
            r1 = 0
            if (r0 != 0) goto L9
            goto L93
        L9:
            kotlin.reflect.jvm.internal.impl.load.java.a r4 = r4.f5597a
            S7.k r4 = r4.b
            java.lang.Object r4 = r4.invoke(r0)
            kotlin.reflect.jvm.internal.impl.load.java.ReportLevel r4 = (kotlin.reflect.jvm.internal.impl.load.java.ReportLevel) r4
            r4.getClass()
            kotlin.reflect.jvm.internal.impl.load.java.ReportLevel r2 = kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.b
            if (r4 != r2) goto L1b
            return r1
        L1b:
            java.util.Set r2 = q8.v.k
            boolean r2 = r2.contains(r0)
            r3 = 0
            if (r2 == 0) goto L27
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.c
            goto L85
        L27:
            java.util.Set r2 = q8.v.l
            boolean r2 = r2.contains(r0)
            if (r2 == 0) goto L32
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.b
            goto L85
        L32:
            java.util.Set r2 = q8.v.m
            boolean r2 = r2.contains(r0)
            if (r2 == 0) goto L3d
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.f5005a
            goto L85
        L3d:
            G8.c r2 = q8.v.g
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L93
            java.util.ArrayList r5 = a(r5, r3)
            java.lang.Object r5 = D7.v.B0(r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L83
            int r0 = r5.hashCode()
            switch(r0) {
                case 73135176: goto L77;
                case 74175084: goto L6e;
                case 433141802: goto L62;
                case 1933739535: goto L59;
                default: goto L58;
            }
        L58:
            goto L93
        L59:
            java.lang.String r0 = "ALWAYS"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L93
            goto L83
        L62:
            java.lang.String r0 = "UNKNOWN"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L6b
            goto L93
        L6b:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.f5005a
            goto L85
        L6e:
            java.lang.String r0 = "NEVER"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L80
            goto L93
        L77:
            java.lang.String r0 = "MAYBE"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L80
            goto L93
        L80:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.b
            goto L85
        L83:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.c
        L85:
            y8.f r0 = new y8.f
            kotlin.reflect.jvm.internal.impl.load.java.ReportLevel r1 = kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.c
            if (r4 != r1) goto L8c
            goto L8e
        L8c:
            if (r6 == 0) goto L8f
        L8e:
            r3 = 1
        L8f:
            r0.<init>(r5, r3)
            return r0
        L93:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.C1828a.g(java.lang.Object, boolean):y8.f");
    }

    public final ReportLevel h(Object obj) {
        String str;
        kotlin.reflect.jvm.internal.impl.load.java.a aVar = this.f5597a;
        ReportLevel reportLevel = (ReportLevel) aVar.f4992a.c.get(d(obj));
        if (reportLevel != null) {
            return reportLevel;
        }
        Object objC = c(obj, v.f5616q);
        if (objC == null || (str = (String) D7.v.B0(a(objC, false))) == null) {
            return null;
        }
        ReportLevel reportLevel2 = aVar.f4992a.b;
        if (reportLevel2 != null) {
            return reportLevel2;
        }
        int iHashCode = str.hashCode();
        if (iHashCode == -2137067054) {
            if (str.equals("IGNORE")) {
                return ReportLevel.b;
            }
            return null;
        }
        if (iHashCode == -1838656823) {
            if (str.equals("STRICT")) {
                return ReportLevel.d;
            }
            return null;
        }
        if (iHashCode == 2656902 && str.equals("WARN")) {
            return ReportLevel.c;
        }
        return null;
    }

    public final Object i(Object annotation) {
        Object objI;
        kotlin.jvm.internal.k.f(annotation, "annotation");
        if (!this.f5597a.f4992a.d) {
            if (D7.v.u0(v.f5615j, d(annotation)) || f(annotation, v.d)) {
                return annotation;
            }
            if (f(annotation, v.e)) {
                InterfaceC1522e interfaceC1522eD = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d((InterfaceC1556b) annotation);
                kotlin.jvm.internal.k.c(interfaceC1522eD);
                ConcurrentHashMap concurrentHashMap = this.b;
                Object obj = concurrentHashMap.get(interfaceC1522eD);
                if (obj != null) {
                    return obj;
                }
                Iterator it = e(annotation).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        objI = null;
                        break;
                    }
                    objI = i(it.next());
                    if (objI != null) {
                        break;
                    }
                }
                if (objI != null) {
                    Object objPutIfAbsent = concurrentHashMap.putIfAbsent(interfaceC1522eD, objI);
                    return objPutIfAbsent == null ? objI : objPutIfAbsent;
                }
            }
        }
        return null;
    }
}
