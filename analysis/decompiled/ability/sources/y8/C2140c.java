package y8;

import X8.A;
import X8.AbstractC0272c;
import X8.AbstractC0285p;
import X8.U;
import X8.w;
import com.google.protobuf.C0958k1;
import h8.InterfaceC1519b;
import h8.InterfaceC1520c;
import i8.InterfaceC1555a;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import stepos.support.v7.widget.C1977a;
import v8.C2071g;

/* renamed from: y8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2140c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d2  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static stepos.support.v7.widget.C1977a c(X8.A r17, J4.f r18, int r19, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 675
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.C2140c.c(X8.A, J4.f, int, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition, boolean, boolean):stepos.support.v7.widget.a");
    }

    public static B1.b d(U u, J4.f fVar, int i, boolean z10) {
        w wVarF;
        Object objG = null;
        if (AbstractC0272c.k(u)) {
            return new B1.b(null, 1, 10);
        }
        if (!(u instanceof AbstractC0285p)) {
            if (!(u instanceof A)) {
                throw new NoWhenBranchMatchedException();
            }
            C1977a c1977aC = c((A) u, fVar, i, TypeComponentPosition.c, false, z10);
            w wVarG = (A) c1977aC.d;
            if (c1977aC.b) {
                wVarG = AbstractC0272c.G(u, wVarG);
            }
            return new B1.b(wVarG, c1977aC.c, 10);
        }
        boolean z11 = u instanceof C2071g;
        AbstractC0285p abstractC0285p = (AbstractC0285p) u;
        A a3 = abstractC0285p.c;
        A a4 = abstractC0285p.b;
        C1977a c1977aC2 = c(abstractC0285p.b, fVar, i, TypeComponentPosition.f5006a, z11, z10);
        C1977a c1977aC3 = c(abstractC0285p.c, fVar, i, TypeComponentPosition.b, z11, z10);
        A a8 = (A) c1977aC3.d;
        A a10 = (A) c1977aC2.d;
        if (a10 != null || a8 != null) {
            if (c1977aC2.b || c1977aC3.b) {
                if (a8 != null) {
                    if (a10 == null) {
                        a10 = a8;
                    }
                    wVarF = AbstractC0272c.f(a10, a8);
                } else {
                    kotlin.jvm.internal.k.c(a10);
                    wVarF = a10;
                }
                objG = AbstractC0272c.G(u, wVarF);
            } else if (z11) {
                if (a10 != null) {
                    a4 = a10;
                }
                if (a8 != null) {
                    a3 = a8;
                }
                objG = new C2071g(a4, a3);
            } else {
                if (a10 != null) {
                    a4 = a10;
                }
                if (a8 != null) {
                    a3 = a8;
                }
                objG = AbstractC0272c.f(a4, a3);
            }
        }
        return new B1.b(objG, c1977aC2.c, 10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20, types: [kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier] */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25, types: [kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24, types: [kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier] */
    /* JADX WARN: Type inference failed for: r13v25, types: [kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier] */
    /* JADX WARN: Type inference failed for: r13v26, types: [kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier] */
    /* JADX WARN: Type inference failed for: r3v18, types: [q8.l] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [q8.l] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier] */
    /* JADX WARN: Type inference failed for: r5v7, types: [kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier] */
    /* JADX WARN: Type inference failed for: r7v16, types: [kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public X8.w a(com.google.protobuf.C0958k1 r26, X8.w r27, java.util.List r28, y8.C2150m r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 1118
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.C2140c.a(com.google.protobuf.k1, X8.w, java.util.List, y8.m, boolean):X8.w");
    }

    public w b(InterfaceC1520c interfaceC1520c, InterfaceC1519b interfaceC1519b, boolean z10, K1.a aVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, C2150m c2150m, boolean z11, S7.k kVar) {
        C0958k1 c0958k1 = new C0958k1((InterfaceC1555a) interfaceC1519b, z10, aVar, annotationQualifierApplicabilityType, false);
        w wVar = (w) kVar.invoke(interfaceC1520c);
        Collection collectionE = interfaceC1520c.e();
        kotlin.jvm.internal.k.e(collectionE, "getOverriddenDescriptors(...)");
        Collection<InterfaceC1520c> collection = collectionE;
        ArrayList arrayList = new ArrayList(D7.w.c0(collection, 10));
        for (InterfaceC1520c interfaceC1520c2 : collection) {
            kotlin.jvm.internal.k.c(interfaceC1520c2);
            arrayList.add((w) kVar.invoke(interfaceC1520c2));
        }
        return a(c0958k1, wVar, arrayList, c2150m, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02bd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01cd  */
    /* JADX WARN: Type inference failed for: r26v0, types: [y8.c] */
    /* JADX WARN: Type inference failed for: r7v1, types: [h8.b, h8.c, h8.j] */
    /* JADX WARN: Type inference failed for: r7v2, types: [s8.a] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList e(K1.a r27, java.util.Collection r28) {
        /*
            Method dump skipped, instructions count: 848
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.C2140c.e(K1.a, java.util.Collection):java.util.ArrayList");
    }
}
