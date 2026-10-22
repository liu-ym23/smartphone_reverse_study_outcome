package S9;

import C9.o;
import Z8.Z;
import aa.C1263k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import p9.InterfaceC5074l;

/* renamed from: S9.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC1003b<TAnnotation> {

    /* renamed from: c, reason: collision with root package name */
    public static final a f5742c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, AnnotationQualifierApplicabilityType> f5743d;

    /* renamed from: a, reason: collision with root package name */
    public final A f5744a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Object, TAnnotation> f5745b;

    /* renamed from: S9.b$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : AnnotationQualifierApplicabilityType.values()) {
            String javaTarget = annotationQualifierApplicabilityType.getJavaTarget();
            if (linkedHashMap.get(javaTarget) == null) {
                linkedHashMap.put(javaTarget, annotationQualifierApplicabilityType);
            }
        }
        f5743d = linkedHashMap;
    }

    public AbstractC1003b(A javaTypeEnhancementState) {
        kotlin.jvm.internal.p.i(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.f5744a = javaTypeEnhancementState;
        this.f5745b = new ConcurrentHashMap<>();
    }

    public static final boolean f(Object extractNullability) {
        kotlin.jvm.internal.p.i(extractNullability, "$this$extractNullability");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Set<AnnotationQualifierApplicabilityType> b(Set<? extends AnnotationQualifierApplicabilityType> set) {
        return set.contains(AnnotationQualifierApplicabilityType.TYPE_USE) ? Z.o(Z.n(Z8.r.i1(AnnotationQualifierApplicabilityType.values()), AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS), set) : set;
    }

    public abstract Iterable<String> c(TAnnotation tannotation, boolean z10);

    public final B d(B b10, Iterable<? extends TAnnotation> annotations) {
        EnumMap<AnnotationQualifierApplicabilityType, t> enumMapB;
        kotlin.jvm.internal.p.i(annotations, "annotations");
        if (!this.f5744a.a()) {
            ArrayList<t> arrayList = new ArrayList();
            Iterator<? extends TAnnotation> it = annotations.iterator();
            while (it.hasNext()) {
                t tVarE = e(it.next());
                if (tVarE != null) {
                    arrayList.add(tVarE);
                }
            }
            if (!arrayList.isEmpty()) {
                EnumMap enumMap = new EnumMap(AnnotationQualifierApplicabilityType.class);
                for (t tVar : arrayList) {
                    for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : tVar.e()) {
                        if (enumMap.containsKey(annotationQualifierApplicabilityType) && o()) {
                            t tVar2 = (t) enumMap.get(annotationQualifierApplicabilityType);
                            if (tVar2 != null) {
                                C1263k c1263kD = tVar2.d();
                                C1263k c1263kD2 = tVar.d();
                                if (!kotlin.jvm.internal.p.d(c1263kD2, c1263kD) && (!c1263kD2.d() || c1263kD.d())) {
                                    tVar2 = (c1263kD2.d() || !c1263kD.d()) ? null : tVar;
                                }
                                enumMap.put((EnumMap) annotationQualifierApplicabilityType, (AnnotationQualifierApplicabilityType) tVar2);
                            }
                        } else {
                            enumMap.put((EnumMap) annotationQualifierApplicabilityType, (AnnotationQualifierApplicabilityType) tVar);
                        }
                    }
                }
                EnumMap enumMap2 = (b10 == null || (enumMapB = b10.b()) == null) ? new EnumMap(AnnotationQualifierApplicabilityType.class) : new EnumMap((EnumMap) enumMapB);
                boolean z10 = false;
                for (Map.Entry entry : enumMap.entrySet()) {
                    AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = (AnnotationQualifierApplicabilityType) entry.getKey();
                    t tVar3 = (t) entry.getValue();
                    if (tVar3 != null) {
                        enumMap2.put((EnumMap) annotationQualifierApplicabilityType2, (AnnotationQualifierApplicabilityType) tVar3);
                        z10 = true;
                    }
                }
                if (z10) {
                    return new B(enumMap2);
                }
            }
        }
        return b10;
    }

    public final t e(TAnnotation tannotation) {
        C1263k c1263kI;
        t tVarU = u(tannotation);
        if (tVarU != null) {
            return tVarU;
        }
        Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> pairW = w(tannotation);
        if (pairW == null) {
            return null;
        }
        TAnnotation tannotationA = pairW.a();
        Set<AnnotationQualifierApplicabilityType> setB = pairW.b();
        ReportLevel reportLevelT = t(tannotation);
        if (reportLevelT == null) {
            reportLevelT = s(tannotationA);
        }
        if (reportLevelT.isIgnore() || (c1263kI = i(tannotationA, C1002a.f5741a)) == null) {
            return null;
        }
        return new t(C1263k.b(c1263kI, null, reportLevelT.isWarning(), 1, null), setB, false, false, 12, null);
    }

    public final MutabilityQualifier g(Iterable<? extends TAnnotation> annotations) {
        MutabilityQualifier mutabilityQualifier;
        kotlin.jvm.internal.p.i(annotations, "annotations");
        Iterator<? extends TAnnotation> it = annotations.iterator();
        MutabilityQualifier mutabilityQualifier2 = null;
        while (it.hasNext()) {
            ga.c cVarK = k(it.next());
            if (Z8.F.f0(G.o(), cVarK)) {
                mutabilityQualifier = MutabilityQualifier.READ_ONLY;
            } else if (Z8.F.f0(G.l(), cVarK)) {
                mutabilityQualifier = MutabilityQualifier.MUTABLE;
            } else {
                continue;
            }
            if (mutabilityQualifier2 != null && mutabilityQualifier2 != mutabilityQualifier) {
                return null;
            }
            mutabilityQualifier2 = mutabilityQualifier;
        }
        return mutabilityQualifier2;
    }

    public final C1263k h(Iterable<? extends TAnnotation> annotations, InterfaceC5074l<? super TAnnotation, Boolean> forceWarning) {
        kotlin.jvm.internal.p.i(annotations, "annotations");
        kotlin.jvm.internal.p.i(forceWarning, "forceWarning");
        Iterator<? extends TAnnotation> it = annotations.iterator();
        C1263k c1263k = null;
        while (it.hasNext()) {
            C1263k c1263kI = i(it.next(), forceWarning);
            if (c1263k != null) {
                if (c1263kI != null && !kotlin.jvm.internal.p.d(c1263kI, c1263k) && (!c1263kI.d() || c1263k.d())) {
                    if (c1263kI.d() || !c1263k.d()) {
                        return null;
                    }
                }
            }
            c1263k = c1263kI;
        }
        return c1263k;
    }

    public final C1263k i(TAnnotation tannotation, InterfaceC5074l<? super TAnnotation, Boolean> interfaceC5074l) {
        C1263k c1263kQ;
        C1263k c1263kQ2 = q(tannotation, interfaceC5074l.invoke(tannotation).booleanValue());
        if (c1263kQ2 != null) {
            return c1263kQ2;
        }
        TAnnotation tannotationV = v(tannotation);
        if (tannotationV == null) {
            return null;
        }
        ReportLevel reportLevelS = s(tannotation);
        if (reportLevelS.isIgnore() || (c1263kQ = q(tannotationV, interfaceC5074l.invoke(tannotationV).booleanValue())) == null) {
            return null;
        }
        return C1263k.b(c1263kQ, null, reportLevelS.isWarning(), 1, null);
    }

    public final TAnnotation j(TAnnotation tannotation, ga.c cVar) {
        for (TAnnotation tannotation2 : m(tannotation)) {
            if (kotlin.jvm.internal.p.d(k(tannotation2), cVar)) {
                return tannotation2;
            }
        }
        return null;
    }

    public abstract ga.c k(TAnnotation tannotation);

    public abstract Object l(TAnnotation tannotation);

    public abstract Iterable<TAnnotation> m(TAnnotation tannotation);

    public final boolean n(TAnnotation tannotation, ga.c cVar) {
        Iterable<TAnnotation> iterableM = m(tannotation);
        if ((iterableM instanceof Collection) && ((Collection) iterableM).isEmpty()) {
            return false;
        }
        Iterator<TAnnotation> it = iterableM.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.p.d(k(it.next()), cVar)) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean o();

    public final boolean p(TAnnotation annotation) {
        kotlin.jvm.internal.p.i(annotation, "annotation");
        TAnnotation tannotationJ = j(annotation, o.a.f1860H);
        if (tannotationJ == null) {
            return false;
        }
        Iterable<String> iterableC = c(tannotationJ, false);
        if ((iterableC instanceof Collection) && ((Collection) iterableC).isEmpty()) {
            return false;
        }
        Iterator<String> it = iterableC.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.p.d(it.next(), "TYPE")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (r5.equals("ALWAYS") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r5.equals("NEVER") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
    
        if (r5.equals("MAYBE") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
    
        r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
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
    public final aa.C1263k q(TAnnotation r6, boolean r7) {
        /*
            r5 = this;
            ga.c r0 = r5.k(r6)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            S9.A r2 = r5.f5744a
            p9.l r2 = r2.b()
            java.lang.Object r2 = r2.invoke(r0)
            kotlin.reflect.jvm.internal.impl.load.java.ReportLevel r2 = (kotlin.reflect.jvm.internal.impl.load.java.ReportLevel) r2
            boolean r3 = r2.isIgnore()
            if (r3 == 0) goto L1b
            return r1
        L1b:
            java.util.Set r3 = S9.G.m()
            boolean r3 = r3.contains(r0)
            r4 = 0
            if (r3 == 0) goto L29
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            goto L8d
        L29:
            java.util.Set r3 = S9.G.n()
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L36
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            goto L8d
        L36:
            java.util.Set r3 = S9.G.b()
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L43
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            goto L8d
        L43:
            ga.c r3 = S9.G.c()
            boolean r0 = kotlin.jvm.internal.p.d(r0, r3)
            if (r0 == 0) goto L9c
            java.lang.Iterable r5 = r5.c(r6, r4)
            java.lang.Object r5 = Z8.F.r0(r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L8b
            int r6 = r5.hashCode()
            switch(r6) {
                case 73135176: goto L7f;
                case 74175084: goto L76;
                case 433141802: goto L6a;
                case 1933739535: goto L61;
                default: goto L60;
            }
        L60:
            goto L87
        L61:
            java.lang.String r6 = "ALWAYS"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L87
            goto L8b
        L6a:
            java.lang.String r6 = "UNKNOWN"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L73
            goto L87
        L73:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            goto L8d
        L76:
            java.lang.String r6 = "NEVER"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L88
            goto L87
        L7f:
            java.lang.String r6 = "MAYBE"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L88
        L87:
            return r1
        L88:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            goto L8d
        L8b:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
        L8d:
            aa.k r6 = new aa.k
            boolean r0 = r2.isWarning()
            if (r0 != 0) goto L97
            if (r7 == 0) goto L98
        L97:
            r4 = 1
        L98:
            r6.<init>(r5, r4)
            return r6
        L9c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: S9.AbstractC1003b.q(java.lang.Object, boolean):aa.k");
    }

    public final ReportLevel r(TAnnotation tannotation) {
        ga.c cVarK = k(tannotation);
        return (cVarK == null || !u.b().containsKey(cVarK)) ? s(tannotation) : this.f5744a.b().invoke(cVarK);
    }

    public final ReportLevel s(TAnnotation tannotation) {
        ReportLevel reportLevelT = t(tannotation);
        return reportLevelT != null ? reportLevelT : this.f5744a.c().c();
    }

    public final ReportLevel t(TAnnotation tannotation) {
        Iterable<String> iterableC;
        String str;
        ReportLevel reportLevel = this.f5744a.c().e().get(k(tannotation));
        if (reportLevel != null) {
            return reportLevel;
        }
        TAnnotation tannotationJ = j(tannotation, G.p());
        if (tannotationJ == null || (iterableC = c(tannotationJ, false)) == null || (str = (String) Z8.F.r0(iterableC)) == null) {
            return null;
        }
        ReportLevel reportLevelD = this.f5744a.c().d();
        if (reportLevelD != null) {
            return reportLevelD;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -2137067054) {
            if (iHashCode != -1838656823) {
                if (iHashCode == 2656902 && str.equals("WARN")) {
                    return ReportLevel.WARN;
                }
            } else if (str.equals("STRICT")) {
                return ReportLevel.STRICT;
            }
        } else if (str.equals("IGNORE")) {
            return ReportLevel.IGNORE;
        }
        return null;
    }

    public final t u(TAnnotation tannotation) {
        t tVar;
        if (this.f5744a.a() || (tVar = u.a().get(k(tannotation))) == null) {
            return null;
        }
        ReportLevel reportLevelR = r(tannotation);
        if (reportLevelR == ReportLevel.IGNORE) {
            reportLevelR = null;
        }
        if (reportLevelR == null) {
            return null;
        }
        return t.b(tVar, C1263k.b(tVar.d(), null, reportLevelR.isWarning(), 1, null), null, false, false, 14, null);
    }

    public final TAnnotation v(TAnnotation annotation) {
        TAnnotation tannotationV;
        kotlin.jvm.internal.p.i(annotation, "annotation");
        if (this.f5744a.c().f()) {
            return null;
        }
        if (Z8.F.f0(G.a(), k(annotation)) || n(annotation, G.f())) {
            return annotation;
        }
        if (!n(annotation, G.h())) {
            return null;
        }
        ConcurrentHashMap<Object, TAnnotation> concurrentHashMap = this.f5745b;
        Object objL = l(annotation);
        TAnnotation tannotation = concurrentHashMap.get(objL);
        if (tannotation != null) {
            return tannotation;
        }
        Iterator<TAnnotation> it = m(annotation).iterator();
        while (true) {
            if (!it.hasNext()) {
                tannotationV = null;
                break;
            }
            tannotationV = v(it.next());
            if (tannotationV != null) {
                break;
            }
        }
        if (tannotationV == null) {
            return null;
        }
        TAnnotation tannotationPutIfAbsent = concurrentHashMap.putIfAbsent(objL, tannotationV);
        return tannotationPutIfAbsent == null ? tannotationV : tannotationPutIfAbsent;
    }

    public final Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> w(TAnnotation tannotation) {
        TAnnotation tannotationJ;
        TAnnotation next;
        if (this.f5744a.c().f() || (tannotationJ = j(tannotation, G.g())) == null) {
            return null;
        }
        Iterator<TAnnotation> it = m(tannotation).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (v(next) != null) {
                break;
            }
        }
        if (next == null) {
            return null;
        }
        Iterable<String> iterableC = c(tannotationJ, true);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it2 = iterableC.iterator();
        while (it2.hasNext()) {
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = f5743d.get(it2.next());
            if (annotationQualifierApplicabilityType != null) {
                linkedHashSet.add(annotationQualifierApplicabilityType);
            }
        }
        return new Pair<>(next, b(linkedHashSet));
    }
}
