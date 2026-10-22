package kotlin.reflect.jvm.internal.impl.load.kotlin;

import E9.W;
import La.D;
import La.H;
import Z8.C1173v;
import Z8.C1174w;
import ba.l;
import ba.p;
import ba.q;
import ba.s;
import com.fasterxml.jackson.core.JsonPointer;
import ea.C4018b;
import ea.C4019c;
import ea.InterfaceC4020d;
import fa.AbstractC4067d;
import fa.C4065b;
import fa.C4071h;
import ga.b;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.i;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.a;
import kotlin.reflect.jvm.internal.impl.load.kotlin.f;
import kotlin.reflect.jvm.internal.impl.load.kotlin.g;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import pa.C5080d;
import ua.AbstractC5604N;
import ua.InterfaceC5621g;

/* loaded from: classes5.dex */
public abstract class AbstractBinaryClassAnnotationLoader<A, S extends a<? extends A>> implements InterfaceC5621g<A> {

    /* renamed from: b, reason: collision with root package name */
    public static final b f35152b = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final p f35153a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class PropertyRelatedElement {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ PropertyRelatedElement[] $VALUES;
        public static final PropertyRelatedElement PROPERTY = new PropertyRelatedElement("PROPERTY", 0);
        public static final PropertyRelatedElement BACKING_FIELD = new PropertyRelatedElement("BACKING_FIELD", 1);
        public static final PropertyRelatedElement DELEGATE_FIELD = new PropertyRelatedElement("DELEGATE_FIELD", 2);

        private static final /* synthetic */ PropertyRelatedElement[] $values() {
            return new PropertyRelatedElement[]{PROPERTY, BACKING_FIELD, DELEGATE_FIELD};
        }

        static {
            PropertyRelatedElement[] propertyRelatedElementArr$values = $values();
            $VALUES = propertyRelatedElementArr$values;
            $ENTRIES = kotlin.enums.a.a(propertyRelatedElementArr$values);
        }

        private PropertyRelatedElement(String str, int i10) {
        }

        public static PropertyRelatedElement valueOf(String str) {
            return (PropertyRelatedElement) Enum.valueOf(PropertyRelatedElement.class, str);
        }

        public static PropertyRelatedElement[] values() {
            return (PropertyRelatedElement[]) $VALUES.clone();
        }
    }

    public static abstract class a<A> {
        public abstract Map<g, List<A>> a();
    }

    public static final class b {
        public /* synthetic */ b(i iVar) {
            this();
        }

        public final f a(AbstractC5604N container, boolean z10, boolean z11, Boolean bool, boolean z12, p kotlinClassFinder, C4019c metadataVersion) {
            AbstractC5604N.a aVarH;
            kotlin.jvm.internal.p.i(container, "container");
            kotlin.jvm.internal.p.i(kotlinClassFinder, "kotlinClassFinder");
            kotlin.jvm.internal.p.i(metadataVersion, "metadataVersion");
            if (z10) {
                if (bool == null) {
                    throw new IllegalStateException(("isConst should not be null for property (container=" + container + ')').toString());
                }
                if (container instanceof AbstractC5604N.a) {
                    AbstractC5604N.a aVar = (AbstractC5604N.a) container;
                    if (aVar.g() == ProtoBuf$Class.Kind.INTERFACE) {
                        ga.b bVarE = aVar.e();
                        ga.e eVarJ = ga.e.j("DefaultImpls");
                        kotlin.jvm.internal.p.h(eVarJ, "identifier(...)");
                        return q.b(kotlinClassFinder, bVarE.d(eVarJ), metadataVersion);
                    }
                }
                if (bool.booleanValue() && (container instanceof AbstractC5604N.b)) {
                    W wC = container.c();
                    l lVar = wC instanceof l ? (l) wC : null;
                    C5080d c5080dF = lVar != null ? lVar.f() : null;
                    if (c5080dF != null) {
                        b.a aVar2 = ga.b.f32721d;
                        String strF = c5080dF.f();
                        kotlin.jvm.internal.p.h(strF, "getInternalName(...)");
                        return q.b(kotlinClassFinder, aVar2.c(new ga.c(D.S(strF, JsonPointer.SEPARATOR, '.', false, 4, null))), metadataVersion);
                    }
                }
            }
            if (z11 && (container instanceof AbstractC5604N.a)) {
                AbstractC5604N.a aVar3 = (AbstractC5604N.a) container;
                if (aVar3.g() == ProtoBuf$Class.Kind.COMPANION_OBJECT && (aVarH = aVar3.h()) != null && (aVarH.g() == ProtoBuf$Class.Kind.CLASS || aVarH.g() == ProtoBuf$Class.Kind.ENUM_CLASS || (z12 && (aVarH.g() == ProtoBuf$Class.Kind.INTERFACE || aVarH.g() == ProtoBuf$Class.Kind.ANNOTATION_CLASS)))) {
                    W wC2 = aVarH.c();
                    s sVar = wC2 instanceof s ? (s) wC2 : null;
                    if (sVar != null) {
                        return sVar.d();
                    }
                    return null;
                }
            }
            if (!(container instanceof AbstractC5604N.b) || !(container.c() instanceof l)) {
                return null;
            }
            W wC3 = container.c();
            kotlin.jvm.internal.p.g(wC3, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            l lVar2 = (l) wC3;
            f fVarG = lVar2.g();
            return fVarG == null ? q.b(kotlinClassFinder, lVar2.d(), metadataVersion) : fVarG;
        }

        public b() {
        }
    }

    public static final /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35154a;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            try {
                iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f35154a = iArr;
        }
    }

    public static final class d implements f.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractBinaryClassAnnotationLoader<A, S> f35155a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList<A> f35156b;

        public d(AbstractBinaryClassAnnotationLoader<A, S> abstractBinaryClassAnnotationLoader, ArrayList<A> arrayList) {
            this.f35155a = abstractBinaryClassAnnotationLoader;
            this.f35156b = arrayList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.c
        public void a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.c
        public f.a b(ga.b classId, W source) {
            kotlin.jvm.internal.p.i(classId, "classId");
            kotlin.jvm.internal.p.i(source, "source");
            return this.f35155a.A(classId, source, this.f35156b);
        }
    }

    public AbstractBinaryClassAnnotationLoader(p kotlinClassFinder) {
        kotlin.jvm.internal.p.i(kotlinClassFinder, "kotlinClassFinder");
        this.f35153a = kotlinClassFinder;
    }

    public static /* synthetic */ List p(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, AbstractC5604N abstractC5604N, g gVar, boolean z10, boolean z11, Boolean bool, boolean z12, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        if ((i10 & 16) != 0) {
            bool = null;
        }
        if ((i10 & 32) != 0) {
            z12 = false;
        }
        return abstractBinaryClassAnnotationLoader.o(abstractC5604N, gVar, z10, z11, bool, z12);
    }

    public static /* synthetic */ g u(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, h hVar, InterfaceC4020d interfaceC4020d, ea.h hVar2, AnnotatedCallableKind annotatedCallableKind, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
        }
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        return abstractBinaryClassAnnotationLoader.t(hVar, interfaceC4020d, hVar2, annotatedCallableKind, z10);
    }

    public final f.a A(ga.b annotationClassId, W source, List<A> result) {
        kotlin.jvm.internal.p.i(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(result, "result");
        if (B9.a.f1474a.b().contains(annotationClassId)) {
            return null;
        }
        return z(annotationClassId, source, result);
    }

    public final List<A> B(AbstractC5604N abstractC5604N, h hVar, AnnotatedCallableKind annotatedCallableKind, int i10) {
        g gVarU = u(this, hVar, abstractC5604N.b(), abstractC5604N.d(), annotatedCallableKind, false, 16, null);
        return gVarU == null ? C1173v.m() : p(this, abstractC5604N, g.f35201b.e(gVarU, i10), false, false, null, false, 60, null);
    }

    public final List<A> C(AbstractC5604N abstractC5604N, ProtoBuf$Property protoBuf$Property, PropertyRelatedElement propertyRelatedElement) {
        Boolean boolD = C4018b.f32358D.d(protoBuf$Property.H0());
        kotlin.jvm.internal.p.h(boolD, "get(...)");
        boolD.booleanValue();
        boolean zF = C4071h.f(protoBuf$Property);
        if (propertyRelatedElement == PropertyRelatedElement.PROPERTY) {
            g gVarB = kotlin.reflect.jvm.internal.impl.load.kotlin.b.b(protoBuf$Property, abstractC5604N.b(), abstractC5604N.d(), false, true, false, 40, null);
            return gVarB == null ? C1173v.m() : p(this, abstractC5604N, gVarB, true, false, boolD, zF, 8, null);
        }
        g gVarB2 = kotlin.reflect.jvm.internal.impl.load.kotlin.b.b(protoBuf$Property, abstractC5604N.b(), abstractC5604N.d(), true, false, false, 48, null);
        if (gVarB2 == null) {
            return C1173v.m();
        }
        return H.g0(gVarB2.a(), "$delegate", false, 2, null) != (propertyRelatedElement == PropertyRelatedElement.DELEGATE_FIELD) ? C1173v.m() : o(abstractC5604N, gVarB2, true, true, boolD, zF);
    }

    public final f D(AbstractC5604N.a aVar) {
        W wC = aVar.c();
        s sVar = wC instanceof s ? (s) wC : null;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    @Override // ua.InterfaceC5621g
    public List<A> a(AbstractC5604N container, h proto, AnnotatedCallableKind kind) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(kind, "kind");
        return B(container, proto, kind, v(proto));
    }

    @Override // ua.InterfaceC5621g
    public List<A> b(AbstractC5604N container, ProtoBuf$Property proto) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(proto, "proto");
        return C(container, proto, PropertyRelatedElement.DELEGATE_FIELD);
    }

    @Override // ua.InterfaceC5621g
    public List<A> c(ProtoBuf$TypeParameter proto, InterfaceC4020d nameResolver) {
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        Object objS = proto.s(JvmProtoBuf.f35745h);
        kotlin.jvm.internal.p.h(objS, "getExtension(...)");
        Iterable<ProtoBuf$Annotation> iterable = (Iterable) objS;
        ArrayList arrayList = new ArrayList(C1174w.x(iterable, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : iterable) {
            kotlin.jvm.internal.p.f(protoBuf$Annotation);
            arrayList.add(f(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // ua.InterfaceC5621g
    public List<A> d(AbstractC5604N container, ProtoBuf$Property proto) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(proto, "proto");
        return C(container, proto, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // ua.InterfaceC5621g
    public List<A> e(AbstractC5604N.a container) {
        kotlin.jvm.internal.p.i(container, "container");
        f fVarD = D(container);
        if (fVarD != null) {
            ArrayList arrayList = new ArrayList(1);
            fVarD.c(new d(this, arrayList), s(fVarD));
            return arrayList;
        }
        throw new IllegalStateException(("Class for loading annotations is not found: " + container.a()).toString());
    }

    @Override // ua.InterfaceC5621g
    public abstract A f(ProtoBuf$Annotation protoBuf$Annotation, InterfaceC4020d interfaceC4020d);

    @Override // ua.InterfaceC5621g
    public List<A> h(ProtoBuf$Type proto, InterfaceC4020d nameResolver) {
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        Object objS = proto.s(JvmProtoBuf.f35743f);
        kotlin.jvm.internal.p.h(objS, "getExtension(...)");
        Iterable<ProtoBuf$Annotation> iterable = (Iterable) objS;
        ArrayList arrayList = new ArrayList(C1174w.x(iterable, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : iterable) {
            kotlin.jvm.internal.p.f(protoBuf$Annotation);
            arrayList.add(f(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // ua.InterfaceC5621g
    public List<A> j(AbstractC5604N container, h callableProto, AnnotatedCallableKind kind, int i10, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(callableProto, "callableProto");
        kotlin.jvm.internal.p.i(kind, "kind");
        return B(container, callableProto, kind, i10);
    }

    @Override // ua.InterfaceC5621g
    public List<A> k(AbstractC5604N container, h callableProto, AnnotatedCallableKind kind, int i10, ProtoBuf$ValueParameter proto) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(callableProto, "callableProto");
        kotlin.jvm.internal.p.i(kind, "kind");
        kotlin.jvm.internal.p.i(proto, "proto");
        return B(container, callableProto, kind, i10 + n(container, callableProto));
    }

    @Override // ua.InterfaceC5621g
    public List<A> l(AbstractC5604N container, ProtoBuf$EnumEntry proto) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(proto, "proto");
        return p(this, container, g.f35201b.a(container.b().getString(proto.K()), C4065b.b(((AbstractC5604N.a) container).e().b())), false, false, null, false, 60, null);
    }

    @Override // ua.InterfaceC5621g
    public List<A> m(AbstractC5604N container, h proto, AnnotatedCallableKind kind) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(kind, "kind");
        if (kind == AnnotatedCallableKind.PROPERTY) {
            return C(container, (ProtoBuf$Property) proto, PropertyRelatedElement.PROPERTY);
        }
        g gVarU = u(this, proto, container.b(), container.d(), kind, false, 16, null);
        return gVarU == null ? C1173v.m() : p(this, container, gVarU, false, false, null, false, 60, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int n(ua.AbstractC5604N r4, kotlin.reflect.jvm.internal.impl.protobuf.h r5) {
        /*
            r3 = this;
            int r3 = r3.v(r5)
            boolean r0 = r5 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L14
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r5 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function) r5
            boolean r4 = ea.g.g(r5)
            if (r4 == 0) goto L3d
        L12:
            r1 = r2
            goto L3d
        L14:
            boolean r0 = r5 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property
            if (r0 == 0) goto L21
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r5 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property) r5
            boolean r4 = ea.g.h(r5)
            if (r4 == 0) goto L3d
            goto L12
        L21:
            boolean r0 = r5 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor
            if (r0 == 0) goto L3f
            java.lang.String r5 = "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class"
            kotlin.jvm.internal.p.g(r4, r5)
            ua.N$a r4 = (ua.AbstractC5604N.a) r4
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r5 = r4.g()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r0 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.Kind.ENUM_CLASS
            if (r5 != r0) goto L36
            r1 = 2
            goto L3d
        L36:
            boolean r4 = r4.i()
            if (r4 == 0) goto L3d
            goto L12
        L3d:
            int r3 = r3 + r1
            return r3
        L3f:
            java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Unsupported message: "
            r4.append(r0)
            java.lang.Class r5 = r5.getClass()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.n(ua.N, kotlin.reflect.jvm.internal.impl.protobuf.h):int");
    }

    public final List<A> o(AbstractC5604N abstractC5604N, g gVar, boolean z10, boolean z11, Boolean bool, boolean z12) {
        List<A> list;
        f fVarQ = q(abstractC5604N, f35152b.a(abstractC5604N, z10, z11, bool, z12, this.f35153a, x()));
        return (fVarQ == null || (list = r(fVarQ).a().get(gVar)) == null) ? C1173v.m() : list;
    }

    public final f q(AbstractC5604N container, f fVar) {
        kotlin.jvm.internal.p.i(container, "container");
        if (fVar != null) {
            return fVar;
        }
        if (container instanceof AbstractC5604N.a) {
            return D((AbstractC5604N.a) container);
        }
        return null;
    }

    public abstract S r(f fVar);

    public byte[] s(f kotlinClass) {
        kotlin.jvm.internal.p.i(kotlinClass, "kotlinClass");
        return null;
    }

    public final g t(h proto, InterfaceC4020d nameResolver, ea.h typeTable, AnnotatedCallableKind kind, boolean z10) {
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(typeTable, "typeTable");
        kotlin.jvm.internal.p.i(kind, "kind");
        if (proto instanceof ProtoBuf$Constructor) {
            g.a aVar = g.f35201b;
            AbstractC4067d.b bVarB = C4071h.f32594a.b((ProtoBuf$Constructor) proto, nameResolver, typeTable);
            if (bVarB == null) {
                return null;
            }
            return aVar.b(bVarB);
        }
        if (proto instanceof ProtoBuf$Function) {
            g.a aVar2 = g.f35201b;
            AbstractC4067d.b bVarE = C4071h.f32594a.e((ProtoBuf$Function) proto, nameResolver, typeTable);
            if (bVarE == null) {
                return null;
            }
            return aVar2.b(bVarE);
        }
        if (proto instanceof ProtoBuf$Property) {
            GeneratedMessageLite.e<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f35741d;
            kotlin.jvm.internal.p.h(propertySignature, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ea.f.a((GeneratedMessageLite.ExtendableMessage) proto, propertySignature);
            if (jvmPropertySignature == null) {
                return null;
            }
            int i10 = c.f35154a[kind.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    return kotlin.reflect.jvm.internal.impl.load.kotlin.b.a((ProtoBuf$Property) proto, nameResolver, typeTable, true, true, z10);
                }
                if (!jvmPropertySignature.G()) {
                    return null;
                }
                g.a aVar3 = g.f35201b;
                JvmProtoBuf.JvmMethodSignature jvmMethodSignatureA = jvmPropertySignature.A();
                kotlin.jvm.internal.p.h(jvmMethodSignatureA, "getSetter(...)");
                return aVar3.c(nameResolver, jvmMethodSignatureA);
            }
            if (jvmPropertySignature.F()) {
                g.a aVar4 = g.f35201b;
                JvmProtoBuf.JvmMethodSignature jvmMethodSignatureZ = jvmPropertySignature.z();
                kotlin.jvm.internal.p.h(jvmMethodSignatureZ, "getGetter(...)");
                return aVar4.c(nameResolver, jvmMethodSignatureZ);
            }
        }
        return null;
    }

    public final int v(h hVar) {
        if (hVar instanceof ProtoBuf$Function) {
            return ((ProtoBuf$Function) hVar).j0();
        }
        if (hVar instanceof ProtoBuf$Property) {
            return ((ProtoBuf$Property) hVar).t0();
        }
        return 0;
    }

    public final p w() {
        return this.f35153a;
    }

    public abstract C4019c x();

    public final boolean y(ga.b classId) {
        f fVarB;
        kotlin.jvm.internal.p.i(classId, "classId");
        return classId.e() != null && kotlin.jvm.internal.p.d(classId.h().b(), "Container") && (fVarB = q.b(this.f35153a, classId, x())) != null && B9.a.f1474a.c(fVarB);
    }

    public abstract f.a z(ga.b bVar, W w10, List<A> list);
}
