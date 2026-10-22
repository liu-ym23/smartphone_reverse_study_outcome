package com.google.protobuf;

import X8.AbstractC0285p;
import a9.InterfaceC0310b;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import i8.InterfaceC1555a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import q8.C1828a;
import q8.C1845r;
import t8.C2024a;
import y8.C2138a;

/* renamed from: com.google.protobuf.k1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0958k1 implements InterfaceC0938f1 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2927a;
    public final boolean b;
    public final Object c;
    public final Object d;
    public final Object e;

    public C0958k1(InterfaceC1555a interfaceC1555a, boolean z10, K1.a containerContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z11) {
        kotlin.jvm.internal.k.f(containerContext, "containerContext");
        this.c = interfaceC1555a;
        this.f2927a = z10;
        this.d = containerContext;
        this.e = annotationQualifierApplicabilityType;
        this.b = z11;
    }

    public static void i(Object obj, ArrayList arrayList, J4.b bVar) {
        arrayList.add(obj);
        Iterable iterable = (Iterable) bVar.invoke(obj);
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                i(it.next(), arrayList, bVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static y8.C2143f j(h8.InterfaceC1507O r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.k.f(r5, r0)
            boolean r1 = r5 instanceof u8.E
            if (r1 != 0) goto Lb
            goto Le3
        Lb:
            java.util.List r5 = r5.getUpperBounds()
            java.lang.String r1 = "getUpperBounds(...)"
            kotlin.jvm.internal.k.e(r5, r1)
            r1 = r5
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r2 = r1 instanceof java.util.Collection
            if (r2 == 0) goto L26
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L26
            goto Le3
        L26:
            java.util.Iterator r3 = r1.iterator()
        L2a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Le3
            java.lang.Object r4 = r3.next()
            a9.b r4 = (a9.InterfaceC0310b) r4
            boolean r4 = Y8.g.B(r4)
            if (r4 != 0) goto L2a
            if (r2 == 0) goto L48
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L48
            goto L60
        L48:
            java.util.Iterator r3 = r1.iterator()
        L4c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L60
            java.lang.Object r4 = r3.next()
            a9.b r4 = (a9.InterfaceC0310b) r4
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = l(r4)
            if (r4 == 0) goto L4c
            r2 = r5
            goto Lac
        L60:
            if (r2 == 0) goto L6d
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L6d
            goto Le3
        L6d:
            java.util.Iterator r2 = r1.iterator()
        L71:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Le3
            java.lang.Object r3 = r2.next()
            a9.b r3 = (a9.InterfaceC0310b) r3
            kotlin.jvm.internal.k.f(r3, r0)
            X8.w r3 = (X8.w) r3
            X8.w r3 = X8.AbstractC0272c.g(r3)
            if (r3 == 0) goto L71
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L91:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Lac
            java.lang.Object r3 = r1.next()
            a9.b r3 = (a9.InterfaceC0310b) r3
            kotlin.jvm.internal.k.f(r3, r0)
            X8.w r3 = (X8.w) r3
            X8.w r3 = X8.AbstractC0272c.g(r3)
            if (r3 == 0) goto L91
            r2.add(r3)
            goto L91
        Lac:
            r0 = r2
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto Lbd
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto Lbd
            goto Ld6
        Lbd:
            java.util.Iterator r0 = r0.iterator()
        Lc1:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Ld6
            java.lang.Object r1 = r0.next()
            a9.b r1 = (a9.InterfaceC0310b) r1
            boolean r1 = Y8.g.H(r1)
            if (r1 != 0) goto Lc1
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.c
            goto Ld8
        Ld6:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.b
        Ld8:
            y8.f r1 = new y8.f
            if (r2 == r5) goto Lde
            r5 = 1
            goto Ldf
        Lde:
            r5 = 0
        Ldf:
            r1.<init>(r0, r5)
            return r1
        Le3:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0958k1.j(h8.O):y8.f");
    }

    public static G8.e k(X8.A a3) {
        Z8.g gVar = X8.S.f1527a;
        InterfaceC1524g interfaceC1524gD = a3.Q().d();
        InterfaceC1522e interfaceC1522e = interfaceC1524gD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gD : null;
        if (interfaceC1522e != null) {
            return J8.e.g(interfaceC1522e);
        }
        return null;
    }

    public static NullabilityQualifier l(InterfaceC0310b interfaceC0310b) {
        X8.A aH;
        X8.A aH2;
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        AbstractC0285p abstractC0285pG = Y8.g.g(interfaceC0310b);
        if (abstractC0285pG == null || (aH = Y8.g.N(abstractC0285pG)) == null) {
            aH = Y8.g.h(interfaceC0310b);
            kotlin.jvm.internal.k.c(aH);
        }
        if (Y8.g.F(aH)) {
            return NullabilityQualifier.b;
        }
        AbstractC0285p abstractC0285pG2 = Y8.g.g(interfaceC0310b);
        if (abstractC0285pG2 == null || (aH2 = Y8.g.Y(abstractC0285pG2)) == null) {
            aH2 = Y8.g.h(interfaceC0310b);
            kotlin.jvm.internal.k.c(aH2);
        }
        if (Y8.g.F(aH2)) {
            return null;
        }
        return NullabilityQualifier.c;
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public Object a(GeneratedMessageV3 generatedMessageV3) {
        return GeneratedMessageV3.u((Method) ((F1.b) this.e).b, generatedMessageV3, new Object[0]);
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public boolean b(GeneratedMessageV3 generatedMessageV3) {
        D0 d02 = (D0) this.d;
        F1.b bVar = (F1.b) this.e;
        return !this.b ? this.f2927a ? ((InterfaceC0974o1) GeneratedMessageV3.u((Method) bVar.g, generatedMessageV3, new Object[0])).getNumber() == d02.b.e : !a(generatedMessageV3).equals(d02.f()) : ((Boolean) GeneratedMessageV3.u((Method) bVar.e, generatedMessageV3, new Object[0])).booleanValue();
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public Object c(AbstractC0926c1 abstractC0926c1) {
        return GeneratedMessageV3.u((Method) ((F1.b) this.e).c, abstractC0926c1, new Object[0]);
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public boolean d(AbstractC0926c1 abstractC0926c1) {
        D0 d02 = (D0) this.d;
        F1.b bVar = (F1.b) this.e;
        return !this.b ? this.f2927a ? ((InterfaceC0974o1) GeneratedMessageV3.u((Method) bVar.h, abstractC0926c1, new Object[0])).getNumber() == d02.b.e : !c(abstractC0926c1).equals(d02.f()) : ((Boolean) GeneratedMessageV3.u((Method) bVar.f, abstractC0926c1, new Object[0])).booleanValue();
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public void e(AbstractC0926c1 abstractC0926c1, Object obj) {
        GeneratedMessageV3.u((Method) ((F1.b) this.e).d, abstractC0926c1, new Object[]{obj});
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public AbstractC0916a f(AbstractC0926c1 abstractC0926c1) {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public void g(AbstractC0926c1 abstractC0926c1, Object obj) {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public AbstractC0916a h() {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [C7.f, java.lang.Object] */
    public ArrayList m(InterfaceC0310b interfaceC0310b) {
        K1.a aVar = (K1.a) this.d;
        C1845r c1845r = (C1845r) aVar.d.getF4884a();
        C1828a c1828a = ((C2024a) aVar.f903a).f6672q;
        kotlin.jvm.internal.k.f(interfaceC0310b, "<this>");
        C2138a c2138a = new C2138a(interfaceC0310b, c1828a.b(c1845r, ((X8.w) interfaceC0310b).getAnnotations()), null);
        J4.b bVar = new J4.b(this, 27);
        ArrayList arrayList = new ArrayList(1);
        i(c2138a, arrayList, bVar);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0958k1(com.google.protobuf.D0 r12, java.lang.String r13, java.lang.Class r14, java.lang.Class r15, java.lang.String r16) {
        /*
            r11 = this;
            r11.<init>()
            com.google.protobuf.H0 r0 = r12.f2763j
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L14
            com.google.protobuf.D0[] r3 = r0.g
            int r4 = r3.length
            if (r4 != r2) goto L15
            r3 = r3[r1]
            boolean r3 = r3.f
            if (r3 == 0) goto L15
        L14:
            r0 = 0
        L15:
            com.google.protobuf.E0 r3 = r12.d
            if (r0 == 0) goto L1b
            r9 = r2
            goto L1c
        L1b:
            r9 = r1
        L1c:
            r11.f2927a = r9
            com.google.protobuf.Descriptors$FileDescriptor$Syntax r0 = r3.g()
            com.google.protobuf.Descriptors$FileDescriptor$Syntax r4 = com.google.protobuf.Descriptors$FileDescriptor$Syntax.c
            if (r0 != r4) goto L2c
            boolean r0 = r12.j()
            if (r0 != 0) goto L56
        L2c:
            com.google.protobuf.Descriptors$FileDescriptor$Syntax r0 = r3.g()
            com.google.protobuf.Descriptors$FileDescriptor$Syntax r4 = com.google.protobuf.Descriptors$FileDescriptor$Syntax.f2825a
            if (r0 == r4) goto L56
            boolean r0 = r12.f
            if (r0 != 0) goto L56
            com.google.protobuf.Descriptors$FileDescriptor$Syntax r0 = r3.g()
            if (r0 != r4) goto L49
            boolean r0 = r12.l()
            if (r0 == 0) goto L49
            com.google.protobuf.H0 r0 = r12.f2763j
            if (r0 != 0) goto L49
            goto L56
        L49:
            if (r9 != 0) goto L54
            com.google.protobuf.Descriptors$FieldDescriptor$Type r0 = r12.g
            com.google.protobuf.Descriptors$FieldDescriptor$JavaType r0 = r0.f2824a
            com.google.protobuf.Descriptors$FieldDescriptor$JavaType r3 = com.google.protobuf.Descriptors$FieldDescriptor$JavaType.MESSAGE
            if (r0 != r3) goto L54
            goto L56
        L54:
            r10 = r1
            goto L57
        L56:
            r10 = r2
        L57:
            r11.b = r10
            F1.b r4 = new F1.b
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r11.d = r12
            java.lang.Object r12 = r4.b
            java.lang.reflect.Method r12 = (java.lang.reflect.Method) r12
            java.lang.Class r12 = r12.getReturnType()
            r11.c = r12
            r11.e = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0958k1.<init>(com.google.protobuf.D0, java.lang.String, java.lang.Class, java.lang.Class, java.lang.String):void");
    }
}
