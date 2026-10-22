package kotlin.reflect.jvm.internal.impl.load.kotlin;

import D8.f;
import D8.j;
import E8.c;
import F8.e;
import F8.i;
import H8.AbstractC0241b;
import H8.h;
import H8.l;
import J5.b;
import T8.InterfaceC0253e;
import T8.w;
import a.AbstractC0291a;
import androidx.compose.material3.internal.TextFieldImplKt;
import d8.AbstractC1379a;
import h8.InterfaceC1503K;
import j9.m;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import m8.C1681a;
import m8.C1682b;
import n8.AbstractC1744c;
import q8.AbstractC1847t;
import u1.C2031a;
import z8.AbstractC2191c;
import z8.C2193e;
import z8.q;
import z8.r;

/* loaded from: classes4.dex */
public abstract class a implements InterfaceC0253e {

    /* renamed from: a, reason: collision with root package name */
    public final C2031a f5008a;

    public a(C2031a c2031a) {
        this.f5008a = c2031a;
    }

    public static /* synthetic */ List b(a aVar, b bVar, r rVar, Boolean bool, boolean z10, int i) {
        boolean z11 = (i & 4) == 0;
        if ((i & 16) != 0) {
            bool = null;
        }
        return aVar.a(bVar, rVar, z11, false, bool, (i & 32) != 0 ? false : z10);
    }

    public static r c(AbstractC0241b proto, f nameResolver, j jVar, AnnotatedCallableKind annotatedCallableKind, boolean z10) {
        k.f(proto, "proto");
        k.f(nameResolver, "nameResolver");
        if (proto instanceof ProtoBuf$Constructor) {
            h hVar = i.f596a;
            e eVarA = i.a((ProtoBuf$Constructor) proto, nameResolver, jVar);
            if (eVarA != null) {
                return AbstractC0291a.t(eVarA);
            }
        } else if (proto instanceof ProtoBuf$Function) {
            h hVar2 = i.f596a;
            e eVarC = i.c((ProtoBuf$Function) proto, nameResolver, jVar);
            if (eVarC != null) {
                return AbstractC0291a.t(eVarC);
            }
        } else if (proto instanceof ProtoBuf$Property) {
            l propertySignature = c.d;
            k.e(propertySignature, "propertySignature");
            JvmProtoBuf$JvmPropertySignature jvmProtoBuf$JvmPropertySignature = (JvmProtoBuf$JvmPropertySignature) D8.h.a((GeneratedMessageLite.ExtendableMessage) proto, propertySignature);
            if (jvmProtoBuf$JvmPropertySignature != null) {
                int iOrdinal = annotatedCallableKind.ordinal();
                if (iOrdinal == 1) {
                    return AbstractC2191c.a((ProtoBuf$Property) proto, nameResolver, jVar, true, true, z10);
                }
                if (iOrdinal == 2) {
                    if ((jvmProtoBuf$JvmPropertySignature.b & 4) != 4) {
                        return null;
                    }
                    JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature = jvmProtoBuf$JvmPropertySignature.e;
                    k.e(jvmProtoBuf$JvmMethodSignature, "getGetter(...)");
                    return new r(nameResolver.getString(jvmProtoBuf$JvmMethodSignature.c).concat(nameResolver.getString(jvmProtoBuf$JvmMethodSignature.d)));
                }
                if (iOrdinal != 3 || (jvmProtoBuf$JvmPropertySignature.b & 8) != 8) {
                    return null;
                }
                JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature2 = jvmProtoBuf$JvmPropertySignature.f;
                k.e(jvmProtoBuf$JvmMethodSignature2, "getSetter(...)");
                return new r(nameResolver.getString(jvmProtoBuf$JvmMethodSignature2.c).concat(nameResolver.getString(jvmProtoBuf$JvmMethodSignature2.d)));
            }
        }
        return null;
    }

    @Override // T8.InterfaceC0253e
    public final ArrayList A(w container) {
        k.f(container, "container");
        InterfaceC1503K interfaceC1503K = (InterfaceC1503K) container.d;
        q qVar = interfaceC1503K instanceof q ? (q) interfaceC1503K : null;
        C1682b c1682b = qVar != null ? qVar.f6987a : null;
        if (c1682b == null) {
            throw new IllegalStateException(("Class for loading annotations is not found: " + container.g.a()).toString());
        }
        ArrayList arrayList = new ArrayList(1);
        Class klass = c1682b.f5307a;
        k.f(klass, "klass");
        C7.i iVarJ = k.j(klass.getDeclaredAnnotations());
        while (iVarJ.hasNext()) {
            Annotation annotation = (Annotation) iVarJ.next();
            k.c(annotation);
            Class clsZ = M.a.Z(M.a.V(annotation));
            F1.b bVarF = f(AbstractC1744c.a(clsZ), new C1681a(annotation), arrayList);
            if (bVarF != null) {
                S0.b.n1(bVarF, annotation, clsZ);
            }
        }
        return arrayList;
    }

    @Override // T8.InterfaceC0253e
    public final List G(b bVar, AbstractC0241b proto, AnnotatedCallableKind annotatedCallableKind) {
        k.f(proto, "proto");
        r rVarC = c(proto, (f) bVar.b, (j) bVar.c, annotatedCallableKind, false);
        return rVarC != null ? b(this, bVar, new r(B7.a.q(new StringBuilder(), rVarC.f6988a, "@0")), null, false, 60) : EmptyList.f4893a;
    }

    @Override // T8.InterfaceC0253e
    public final List M(b container, ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        k.f(container, "container");
        String string = ((f) container.b).getString(protoBuf$EnumEntry.d);
        String desc = F8.b.b(((w) container).g.b());
        k.f(desc, "desc");
        return b(this, container, new r(string + '#' + desc), null, false, 60);
    }

    @Override // T8.InterfaceC0253e
    public final List Q(b bVar, ProtoBuf$Property proto) {
        k.f(proto, "proto");
        return g(bVar, proto, AbstractBinaryClassAnnotationLoader$PropertyRelatedElement.c);
    }

    @Override // T8.InterfaceC0253e
    public final ArrayList Y(ProtoBuf$TypeParameter proto, f nameResolver) {
        k.f(proto, "proto");
        k.f(nameResolver, "nameResolver");
        Object objI = proto.i(c.h);
        k.e(objI, "getExtension(...)");
        Iterable<ProtoBuf$Annotation> iterable = (Iterable) objI;
        ArrayList arrayList = new ArrayList(D7.w.c0(iterable, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : iterable) {
            k.c(protoBuf$Annotation);
            arrayList.add(((C2193e) this).e.a(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    @Override // T8.InterfaceC0253e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List Z(J5.b r10, H8.AbstractC0241b r11, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r12, int r13, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r14) {
        /*
            r9 = this;
            java.lang.String r14 = "callableProto"
            kotlin.jvm.internal.k.f(r11, r14)
            java.lang.Object r14 = r10.b
            D8.f r14 = (D8.f) r14
            java.lang.Object r0 = r10.c
            D8.j r0 = (D8.j) r0
            r1 = 0
            z8.r r12 = c(r11, r14, r0, r12, r1)
            if (r12 == 0) goto L8d
            boolean r14 = r11 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function
            r0 = 32
            r2 = 64
            r3 = 1
            if (r14 == 0) goto L2b
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r11 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function) r11
            int r11 = r11.c
            r14 = r11 & 32
            if (r14 != r0) goto L26
            goto L29
        L26:
            r11 = r11 & r2
            if (r11 != r2) goto L50
        L29:
            r1 = r3
            goto L50
        L2b:
            boolean r14 = r11 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property
            if (r14 == 0) goto L3c
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r11 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property) r11
            int r11 = r11.c
            r14 = r11 & 32
            if (r14 != r0) goto L38
            goto L3b
        L38:
            r11 = r11 & r2
            if (r11 != r2) goto L50
        L3b:
            goto L29
        L3c:
            boolean r14 = r11 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor
            if (r14 == 0) goto L75
            r11 = r10
            T8.w r11 = (T8.w) r11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r14 = r11.h
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r0 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.Kind.ENUM_CLASS
            if (r14 != r0) goto L4b
            r1 = 2
            goto L50
        L4b:
            boolean r11 = r11.i
            if (r11 == 0) goto L50
            goto L29
        L50:
            int r13 = r13 + r1
            z8.r r5 = new z8.r
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r12.f6988a
            r11.append(r12)
            r11.append(r2)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            r5.<init>(r11)
            r7 = 0
            r8 = 60
            r6 = 0
            r3 = r9
            r4 = r10
            java.util.List r9 = b(r3, r4, r5, r6, r7, r8)
            return r9
        L75:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r12 = "Unsupported message: "
            r10.<init>(r12)
            java.lang.Class r11 = r11.getClass()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L8d:
            kotlin.collections.EmptyList r9 = kotlin.collections.EmptyList.f4893a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.a.Z(J5.b, H8.b, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind, int, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List a(J5.b r9, z8.r r10, boolean r11, boolean r12, java.lang.Boolean r13, boolean r14) {
        /*
            r8 = this;
            r0 = r8
            z8.e r0 = (z8.C2193e) r0
            F8.f r7 = r0.f
            u1.a r6 = r8.f5008a
            r1 = r9
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            m8.b r8 = z8.AbstractC2190b.a(r1, r2, r3, r4, r5, r6, r7)
            if (r8 != 0) goto L2c
            boolean r8 = r1 instanceof T8.w
            r9 = 0
            if (r8 == 0) goto L2b
            r8 = r1
            T8.w r8 = (T8.w) r8
            java.lang.Object r8 = r8.d
            h8.K r8 = (h8.InterfaceC1503K) r8
            boolean r11 = r8 instanceof z8.q
            if (r11 == 0) goto L25
            z8.q r8 = (z8.q) r8
            goto L26
        L25:
            r8 = r9
        L26:
            if (r8 == 0) goto L2b
            m8.b r8 = r8.f6987a
            goto L2c
        L2b:
            r8 = r9
        L2c:
            if (r8 != 0) goto L31
            kotlin.collections.EmptyList r8 = kotlin.collections.EmptyList.f4893a
            return r8
        L31:
            W8.e r9 = r0.b
            java.lang.Object r8 = r9.invoke(r8)
            z8.d r8 = (z8.C2192d) r8
            java.util.HashMap r8 = r8.f6982a
            java.lang.Object r8 = r8.get(r10)
            java.util.List r8 = (java.util.List) r8
            if (r8 != 0) goto L45
            kotlin.collections.EmptyList r8 = kotlin.collections.EmptyList.f4893a
        L45:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.a.a(J5.b, z8.r, boolean, boolean, java.lang.Boolean, boolean):java.util.List");
    }

    public final boolean d(G8.b bVar) {
        if (bVar.e() == null || !k.b(bVar.f().b(), TextFieldImplKt.ContainerId)) {
            return false;
        }
        C1682b c1682bV = Z6.k.v(this.f5008a, bVar, ((C2193e) this).f);
        if (c1682bV == null) {
            return false;
        }
        LinkedHashSet linkedHashSet = AbstractC1379a.f4303a;
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        Class klass = c1682bV.f5307a;
        k.f(klass, "klass");
        C7.i iVarJ = k.j(klass.getDeclaredAnnotations());
        while (iVarJ.hasNext()) {
            Annotation annotation = (Annotation) iVarJ.next();
            k.c(annotation);
            if (AbstractC1744c.a(M.a.Z(M.a.V(annotation))).equals(AbstractC1847t.b)) {
                ref$BooleanRef.f4916a = true;
            }
        }
        return ref$BooleanRef.f4916a;
    }

    public abstract F1.b e(G8.b bVar, InterfaceC1503K interfaceC1503K, List list);

    public final F1.b f(G8.b bVar, C1681a c1681a, List result) {
        k.f(result, "result");
        if (AbstractC1379a.f4303a.contains(bVar)) {
            return null;
        }
        return e(bVar, c1681a, result);
    }

    public final List g(b bVar, ProtoBuf$Property protoBuf$Property, AbstractBinaryClassAnnotationLoader$PropertyRelatedElement abstractBinaryClassAnnotationLoader$PropertyRelatedElement) {
        j jVar = (j) bVar.c;
        f fVar = (f) bVar.b;
        Boolean boolC = D8.e.f410B.c(protoBuf$Property.d);
        boolean zD = i.d(protoBuf$Property);
        if (abstractBinaryClassAnnotationLoader$PropertyRelatedElement == AbstractBinaryClassAnnotationLoader$PropertyRelatedElement.f5007a) {
            r rVarA = AbstractC2191c.a(protoBuf$Property, fVar, jVar, (40 & 8) == 0, (40 & 16) == 0, true);
            return rVarA == null ? EmptyList.f4893a : b(this, bVar, rVarA, boolC, zD, 8);
        }
        r rVarA2 = AbstractC2191c.a(protoBuf$Property, fVar, jVar, (40 & 8) == 0, (40 & 16) == 0, true);
        if (rVarA2 == null) {
            return EmptyList.f4893a;
        }
        return m.h0(rVarA2.f6988a, "$delegate", false) != (abstractBinaryClassAnnotationLoader$PropertyRelatedElement == AbstractBinaryClassAnnotationLoader$PropertyRelatedElement.c) ? EmptyList.f4893a : a(bVar, rVarA2, true, true, boolC, zD);
    }

    @Override // T8.InterfaceC0253e
    public final List m0(b bVar, ProtoBuf$Property proto) {
        k.f(proto, "proto");
        return g(bVar, proto, AbstractBinaryClassAnnotationLoader$PropertyRelatedElement.b);
    }

    @Override // T8.InterfaceC0253e
    public final List s0(b bVar, AbstractC0241b proto, AnnotatedCallableKind annotatedCallableKind) {
        k.f(proto, "proto");
        if (annotatedCallableKind == AnnotatedCallableKind.b) {
            return g(bVar, (ProtoBuf$Property) proto, AbstractBinaryClassAnnotationLoader$PropertyRelatedElement.f5007a);
        }
        r rVarC = c(proto, (f) bVar.b, (j) bVar.c, annotatedCallableKind, false);
        return rVarC == null ? EmptyList.f4893a : b(this, bVar, rVarC, null, false, 60);
    }

    @Override // T8.InterfaceC0253e
    public final ArrayList y0(ProtoBuf$Type proto, f nameResolver) {
        k.f(proto, "proto");
        k.f(nameResolver, "nameResolver");
        Object objI = proto.i(c.f);
        k.e(objI, "getExtension(...)");
        Iterable<ProtoBuf$Annotation> iterable = (Iterable) objI;
        ArrayList arrayList = new ArrayList(D7.w.c0(iterable, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : iterable) {
            k.c(protoBuf$Annotation);
            arrayList.add(((C2193e) this).e.a(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }
}
