package aa;

import E9.C0809n;
import E9.InterfaceC0799d;
import W9.C1101j;
import W9.C1105n;
import Z8.C1173v;
import Z8.C1174w;
import Z9.InterfaceC1178a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import p9.InterfaceC5074l;
import ya.H0;
import ya.InterfaceC5988c0;
import ya.K0;

/* loaded from: classes5.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final C1260h f8155a;

    public l0(C1260h typeEnhancement) {
        kotlin.jvm.internal.p.i(typeEnhancement, "typeEnhancement");
        this.f8155a = typeEnhancement;
    }

    public static final Boolean g(K0 k02) {
        InterfaceC0799d interfaceC0799dD = k02.H0().d();
        if (interfaceC0799dD == null) {
            return Boolean.FALSE;
        }
        ga.e name = interfaceC0799dD.getName();
        D9.a aVar = D9.a.f2270a;
        return Boolean.valueOf(kotlin.jvm.internal.p.d(name, aVar.h().f()) && kotlin.jvm.internal.p.d(DescriptorUtilsKt.k(interfaceC0799dD), aVar.h()));
    }

    public static /* synthetic */ ya.S j(l0 l0Var, n0 n0Var, ya.S s10, List list, p0 p0Var, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            p0Var = null;
        }
        p0 p0Var2 = p0Var;
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return l0Var.h(n0Var, s10, list, p0Var2, z10);
    }

    public static /* synthetic */ ya.S k(l0 l0Var, CallableMemberDescriptor callableMemberDescriptor, F9.a aVar, boolean z10, V9.k kVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, p0 p0Var, boolean z11, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        return l0Var.i(callableMemberDescriptor, aVar, z10, kVar, annotationQualifierApplicabilityType, p0Var, (i10 & 32) != 0 ? false : z11, interfaceC5074l);
    }

    public static final ya.S m(CallableMemberDescriptor it) {
        kotlin.jvm.internal.p.i(it, "it");
        E9.S sK = it.K();
        kotlin.jvm.internal.p.f(sK);
        ya.S type = sK.getType();
        kotlin.jvm.internal.p.h(type, "getType(...)");
        return type;
    }

    public static final ya.S n(E9.i0 i0Var, CallableMemberDescriptor it) {
        kotlin.jvm.internal.p.i(it, "it");
        ya.S type = it.i().get(i0Var.getIndex()).getType();
        kotlin.jvm.internal.p.h(type, "getType(...)");
        return type;
    }

    public static final ya.S o(CallableMemberDescriptor it) {
        kotlin.jvm.internal.p.i(it, "it");
        ya.S returnType = it.getReturnType();
        kotlin.jvm.internal.p.f(returnType);
        return returnType;
    }

    public static final boolean s(K0 it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it instanceof InterfaceC5988c0;
    }

    public final boolean f(ya.S s10) {
        return H0.c(s10, k0.f8153a);
    }

    public final ya.S h(n0 n0Var, ya.S s10, List<? extends ya.S> list, p0 p0Var, boolean z10) {
        return this.f8155a.a(s10, n0Var.g(s10, list, p0Var, z10), n0Var.D());
    }

    public final ya.S i(CallableMemberDescriptor callableMemberDescriptor, F9.a aVar, boolean z10, V9.k kVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, p0 p0Var, boolean z11, InterfaceC5074l<? super CallableMemberDescriptor, ? extends ya.S> interfaceC5074l) {
        n0 n0Var = new n0(aVar, z10, kVar, annotationQualifierApplicabilityType, false, 16, null);
        ya.S sInvoke = interfaceC5074l.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> collectionD = callableMemberDescriptor.d();
        kotlin.jvm.internal.p.h(collectionD, "getOverriddenDescriptors(...)");
        Collection<? extends CallableMemberDescriptor> collection = collectionD;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            kotlin.jvm.internal.p.f(callableMemberDescriptor2);
            arrayList.add(interfaceC5074l.invoke(callableMemberDescriptor2));
        }
        return h(n0Var, sInvoke, arrayList, p0Var, z11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x0221, code lost:
    
        if (r0 == null) goto L133;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01fb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> D l(D r18, V9.k r19) {
        /*
            Method dump skipped, instructions count: 643
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: aa.l0.l(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, V9.k):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends CallableMemberDescriptor> Collection<D> p(V9.k c10, Collection<? extends D> platformSignatures) {
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(platformSignatures, "platformSignatures");
        Collection<? extends D> collection = platformSignatures;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(l((CallableMemberDescriptor) it.next(), c10));
        }
        return arrayList;
    }

    public final ya.S q(ya.S type, V9.k context) {
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(context, "context");
        ya.S sJ = j(this, new n0(null, false, context, AnnotationQualifierApplicabilityType.TYPE_USE, true), type, C1173v.m(), null, false, 12, null);
        return sJ == null ? type : sJ;
    }

    public final List<ya.S> r(E9.b0 typeParameter, List<? extends ya.S> bounds, V9.k context) {
        ya.S s10;
        ya.S sJ;
        kotlin.jvm.internal.p.i(typeParameter, "typeParameter");
        kotlin.jvm.internal.p.i(bounds, "bounds");
        kotlin.jvm.internal.p.i(context, "context");
        List<? extends ya.S> list = bounds;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (ya.S s11 : list) {
            if (Da.d.e(s11, j0.f8150a)) {
                s10 = s11;
            } else {
                s10 = s11;
                sJ = j(this, new n0(typeParameter, false, context, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null), s10, C1173v.m(), null, false, 12, null);
                if (sJ == null) {
                }
                arrayList.add(sJ);
            }
            sJ = s10;
            arrayList.add(sJ);
        }
        return arrayList;
    }

    public final ya.S t(CallableMemberDescriptor callableMemberDescriptor, E9.i0 i0Var, V9.k kVar, p0 p0Var, boolean z10, InterfaceC5074l<? super CallableMemberDescriptor, ? extends ya.S> interfaceC5074l) {
        V9.k kVarK;
        return i(callableMemberDescriptor, i0Var, false, (i0Var == null || (kVarK = V9.c.k(kVar, i0Var.getAnnotations())) == null) ? kVar : kVarK, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, p0Var, z10, interfaceC5074l);
    }

    public final <D extends CallableMemberDescriptor> F9.g u(D d10, V9.k kVar) {
        InterfaceC0799d interfaceC0799dA = C0809n.a(d10);
        if (interfaceC0799dA == null) {
            return d10.getAnnotations();
        }
        C1105n c1105n = interfaceC0799dA instanceof C1105n ? (C1105n) interfaceC0799dA : null;
        List<InterfaceC1178a> listN0 = c1105n != null ? c1105n.N0() : null;
        List<InterfaceC1178a> list = listN0;
        if (list == null || list.isEmpty()) {
            return d10.getAnnotations();
        }
        List<InterfaceC1178a> list2 = listN0;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new C1101j(kVar, (InterfaceC1178a) it.next(), true));
        }
        return F9.g.f2609m0.a(Z8.F.P0(d10.getAnnotations(), arrayList));
    }
}
