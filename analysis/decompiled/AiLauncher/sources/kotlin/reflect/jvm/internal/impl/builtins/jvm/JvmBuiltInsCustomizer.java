package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import D9.h;
import D9.i;
import D9.j;
import D9.k;
import D9.l;
import D9.m;
import D9.n;
import D9.o;
import D9.q;
import D9.s;
import E9.C0809n;
import E9.C0810o;
import E9.C0817w;
import E9.D;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.InterfaceC0819y;
import E9.W;
import E9.i0;
import F9.f;
import F9.g;
import H9.C0832k;
import H9.H;
import Ia.b;
import Ia.k;
import W9.C1105n;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import ba.u;
import ba.x;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import ga.d;
import ga.e;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import ra.InterfaceC5238k;
import ua.C5602L;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5858a;
import xa.InterfaceC5863f;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.S;
import ya.Y;

/* loaded from: classes5.dex */
public final class JvmBuiltInsCustomizer implements G9.a, G9.c {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f34985i = {t.i(new PropertyReference1Impl(JvmBuiltInsCustomizer.class, "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;", 0)), t.i(new PropertyReference1Impl(JvmBuiltInsCustomizer.class, "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;", 0)), t.i(new PropertyReference1Impl(JvmBuiltInsCustomizer.class, "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;", 0))};

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0819y f34986a;

    /* renamed from: b, reason: collision with root package name */
    public final D9.b f34987b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5865h f34988c;

    /* renamed from: d, reason: collision with root package name */
    public final S f34989d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5865h f34990e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC5858a<ga.c, InterfaceC0797b> f34991f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC5865h f34992g;

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceC5863f<Pair<String, String>, g> f34993h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class JDKMemberStatus {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ JDKMemberStatus[] $VALUES;
        public static final JDKMemberStatus HIDDEN = new JDKMemberStatus("HIDDEN", 0);
        public static final JDKMemberStatus VISIBLE = new JDKMemberStatus("VISIBLE", 1);
        public static final JDKMemberStatus DEPRECATED_LIST_METHODS = new JDKMemberStatus("DEPRECATED_LIST_METHODS", 2);
        public static final JDKMemberStatus NOT_CONSIDERED = new JDKMemberStatus("NOT_CONSIDERED", 3);
        public static final JDKMemberStatus DROP = new JDKMemberStatus("DROP", 4);

        private static final /* synthetic */ JDKMemberStatus[] $values() {
            return new JDKMemberStatus[]{HIDDEN, VISIBLE, DEPRECATED_LIST_METHODS, NOT_CONSIDERED, DROP};
        }

        static {
            JDKMemberStatus[] jDKMemberStatusArr$values = $values();
            $VALUES = jDKMemberStatusArr$values;
            $ENTRIES = kotlin.enums.a.a(jDKMemberStatusArr$values);
        }

        private JDKMemberStatus(String str, int i10) {
        }

        public static JDKMemberStatus valueOf(String str) {
            return (JDKMemberStatus) Enum.valueOf(JDKMemberStatus.class, str);
        }

        public static JDKMemberStatus[] values() {
            return (JDKMemberStatus[]) $VALUES.clone();
        }
    }

    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34994a;

        static {
            int[] iArr = new int[JDKMemberStatus.values().length];
            try {
                iArr[JDKMemberStatus.HIDDEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JDKMemberStatus.DEPRECATED_LIST_METHODS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[JDKMemberStatus.DROP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[JDKMemberStatus.VISIBLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f34994a = iArr;
        }
    }

    public static final class b extends H {
        public b(InterfaceC0819y interfaceC0819y, ga.c cVar) {
            super(interfaceC0819y, cVar);
        }

        @Override // E9.E
        /* renamed from: A0, reason: merged with bridge method [inline-methods] */
        public InterfaceC5238k.b m() {
            return InterfaceC5238k.b.f38898b;
        }
    }

    public static final class c extends b.AbstractC0058b<InterfaceC0797b, JDKMemberStatus> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f34995a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<JDKMemberStatus> f34996b;

        public c(String str, Ref$ObjectRef<JDKMemberStatus> ref$ObjectRef) {
            this.f34995a = str;
            this.f34996b = ref$ObjectRef;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus] */
        /* JADX WARN: Type inference failed for: r0v5, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus] */
        /* JADX WARN: Type inference failed for: r0v6, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus] */
        /* JADX WARN: Type inference failed for: r0v7, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus] */
        @Override // Ia.b.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(InterfaceC0797b javaClassDescriptor) {
            p.i(javaClassDescriptor, "javaClassDescriptor");
            String strA = ba.t.a(x.f15368a, javaClassDescriptor, this.f34995a);
            s sVar = s.f2313a;
            if (sVar.f().contains(strA)) {
                this.f34996b.f34820a = JDKMemberStatus.HIDDEN;
            } else if (sVar.i().contains(strA)) {
                this.f34996b.f34820a = JDKMemberStatus.VISIBLE;
            } else if (sVar.c().contains(strA)) {
                this.f34996b.f34820a = JDKMemberStatus.DEPRECATED_LIST_METHODS;
            } else if (sVar.d().contains(strA)) {
                this.f34996b.f34820a = JDKMemberStatus.DROP;
            }
            return this.f34996b.f34820a == null;
        }

        @Override // Ia.b.d
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public JDKMemberStatus a() {
            JDKMemberStatus jDKMemberStatus = this.f34996b.f34820a;
            return jDKMemberStatus == null ? JDKMemberStatus.NOT_CONSIDERED : jDKMemberStatus;
        }
    }

    public JvmBuiltInsCustomizer(InterfaceC0819y moduleDescriptor, InterfaceC5869l storageManager, InterfaceC5063a<JvmBuiltIns.a> settingsComputation) {
        p.i(moduleDescriptor, "moduleDescriptor");
        p.i(storageManager, "storageManager");
        p.i(settingsComputation, "settingsComputation");
        this.f34986a = moduleDescriptor;
        this.f34987b = D9.b.f2290a;
        this.f34988c = storageManager.i(settingsComputation);
        this.f34989d = q(storageManager);
        this.f34990e = storageManager.i(new h(this, storageManager));
        this.f34991f = storageManager.a();
        this.f34992g = storageManager.i(new i(this));
        this.f34993h = storageManager.c(new j(this));
    }

    public static final Iterable B(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, InterfaceC0797b interfaceC0797b) {
        Collection<S> collectionE = interfaceC0797b.j().e();
        p.h(collectionE, "getSupertypes(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionE.iterator();
        while (it.hasNext()) {
            InterfaceC0799d interfaceC0799dD = ((S) it.next()).H0().d();
            C1105n c1105nZ = null;
            InterfaceC0799d interfaceC0799dA = interfaceC0799dD != null ? interfaceC0799dD.a() : null;
            InterfaceC0797b interfaceC0797b2 = interfaceC0799dA instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dA : null;
            if (interfaceC0797b2 != null && (c1105nZ = jvmBuiltInsCustomizer.z(interfaceC0797b2)) == null) {
                c1105nZ = interfaceC0797b2;
            }
            if (c1105nZ != null) {
                arrayList.add(c1105nZ);
            }
        }
        return arrayList;
    }

    public static final Iterable F(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.a().d();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Boolean G(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer r2, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r3) {
        /*
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r0 = r3.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r1 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION
            if (r0 != r1) goto L1d
            D9.b r2 = r2.f34987b
            E9.h r3 = r3.b()
            java.lang.String r0 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.p.g(r3, r0)
            E9.b r3 = (E9.InterfaceC0797b) r3
            boolean r2 = r2.c(r3)
            if (r2 == 0) goto L1d
            r2 = 1
            goto L1e
        L1d:
            r2 = 0
        L1e:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.G(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor):java.lang.Boolean");
    }

    public static final g I(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        return g.f2609m0.a(C1172u.e(f.c(jvmBuiltInsCustomizer.f34986a.g(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, true, 6, null)));
    }

    public static final AbstractC5990d0 o(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, InterfaceC5869l interfaceC5869l) {
        return FindClassInModuleKt.d(jvmBuiltInsCustomizer.D().a(), kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f35001d.a(), new D(interfaceC5869l, jvmBuiltInsCustomizer.D().a())).n();
    }

    public static final S r(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        AbstractC5990d0 abstractC5990d0I = jvmBuiltInsCustomizer.f34986a.g().i();
        p.h(abstractC5990d0I, "getAnyType(...)");
        return abstractC5990d0I;
    }

    public static final g s(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, Pair pair) {
        p.i(pair, "<destruct>");
        String str = (String) pair.a();
        String str2 = (String) pair.b();
        return g.f2609m0.a(C1172u.e(f.b(jvmBuiltInsCustomizer.f34986a.g(), '\'' + str + "()' member of List is redundant in Kotlin and might be removed soon. Please use '" + str2 + "()' stdlib extension instead", str2 + "()", "HIDDEN", false)));
    }

    public static final InterfaceC0797b u(C1105n c1105n, InterfaceC0797b interfaceC0797b) {
        T9.j EMPTY = T9.j.f5904a;
        p.h(EMPTY, "EMPTY");
        return c1105n.J0(EMPTY, interfaceC0797b);
    }

    public static final boolean w(kotlin.reflect.jvm.internal.impl.descriptors.c cVar, TypeSubstitutor typeSubstitutor, kotlin.reflect.jvm.internal.impl.descriptors.c cVar2) {
        return OverridingUtil.x(cVar, cVar2.c(typeSubstitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    public static final Collection x(e eVar, InterfaceC5238k it) {
        p.i(it, "it");
        return it.c(eVar, NoLookupLocation.FROM_BUILTINS);
    }

    public final JDKMemberStatus A(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        InterfaceC0803h interfaceC0803hB = eVar.b();
        p.g(interfaceC0803hB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Object objB = Ia.b.b(C1172u.e((InterfaceC0797b) interfaceC0803hB), new D9.p(this), new c(u.c(eVar, false, false, 3, null), new Ref$ObjectRef()));
        p.h(objB, "dfs(...)");
        return (JDKMemberStatus) objB;
    }

    public final g C() {
        return (g) C5868k.a(this.f34992g, this, f34985i[2]);
    }

    public final JvmBuiltIns.a D() {
        return (JvmBuiltIns.a) C5868k.a(this.f34988c, this, f34985i[0]);
    }

    public final boolean E(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, boolean z10) {
        InterfaceC0803h interfaceC0803hB = gVar.b();
        p.g(interfaceC0803hB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String strC = u.c(gVar, false, false, 3, null);
        if (z10 ^ s.f2313a.g().contains(ba.t.a(x.f15368a, (InterfaceC0797b) interfaceC0803hB, strC))) {
            return true;
        }
        Boolean boolE = Ia.b.e(C1172u.e(gVar), n.f2307a, new o(this));
        p.h(boolE, "ifAny(...)");
        return boolE.booleanValue();
    }

    public final boolean H(kotlin.reflect.jvm.internal.impl.descriptors.c cVar, InterfaceC0797b interfaceC0797b) {
        if (cVar.i().size() != 1) {
            return false;
        }
        List<i0> listI = cVar.i();
        p.h(listI, "getValueParameters(...)");
        InterfaceC0799d interfaceC0799dD = ((i0) F.X0(listI)).getType().H0().d();
        return p.d(interfaceC0799dD != null ? DescriptorUtilsKt.p(interfaceC0799dD) : null, DescriptorUtilsKt.p(interfaceC0797b));
    }

    @Override // G9.a
    public Collection<S> a(InterfaceC0797b classDescriptor) {
        p.i(classDescriptor, "classDescriptor");
        d dVarP = DescriptorUtilsKt.p(classDescriptor);
        s sVar = s.f2313a;
        return sVar.j(dVarP) ? C1173v.p(v(), this.f34989d) : sVar.k(dVarP) ? C1172u.e(this.f34989d) : C1173v.m();
    }

    @Override // G9.c
    public boolean b(InterfaceC0797b classDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.g functionDescriptor) {
        p.i(classDescriptor, "classDescriptor");
        p.i(functionDescriptor, "functionDescriptor");
        C1105n c1105nZ = z(classDescriptor);
        if (c1105nZ == null || !functionDescriptor.getAnnotations().E(G9.d.a())) {
            return true;
        }
        if (!D().b()) {
            return false;
        }
        String strC = u.c(functionDescriptor, false, false, 3, null);
        LazyJavaClassMemberScope lazyJavaClassMemberScopeO0 = c1105nZ.R();
        e name = functionDescriptor.getName();
        p.h(name, "getName(...)");
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> collectionC = lazyJavaClassMemberScopeO0.c(name, NoLookupLocation.FROM_BUILTINS);
        if ((collectionC instanceof Collection) && collectionC.isEmpty()) {
            return false;
        }
        Iterator<T> it = collectionC.iterator();
        while (it.hasNext()) {
            if (p.d(u.c((kotlin.reflect.jvm.internal.impl.descriptors.g) it.next(), false, false, 3, null), strC)) {
                return true;
            }
        }
        return false;
    }

    @Override // G9.a
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> c(e name, InterfaceC0797b classDescriptor) {
        g gVarInvoke;
        p.i(name, "name");
        p.i(classDescriptor, "classDescriptor");
        if (p.d(name, kotlin.reflect.jvm.internal.impl.builtins.jvm.a.f34997e.a()) && (classDescriptor instanceof DeserializedClassDescriptor) && C9.j.e0(classDescriptor)) {
            DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) classDescriptor;
            List<ProtoBuf$Function> listK0 = deserializedClassDescriptor.Y0().K0();
            p.h(listK0, "getFunctionList(...)");
            List<ProtoBuf$Function> list = listK0;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (p.d(C5602L.b(deserializedClassDescriptor.X0().g(), ((ProtoBuf$Function) it.next()).w0()), kotlin.reflect.jvm.internal.impl.builtins.jvm.a.f34997e.a())) {
                        return C1173v.m();
                    }
                }
            }
            return C1172u.e(p(deserializedClassDescriptor, (kotlin.reflect.jvm.internal.impl.descriptors.g) F.W0(v().m().c(name, NoLookupLocation.FROM_BUILTINS))));
        }
        if (!D().b()) {
            return C1173v.m();
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> collectionT = t(classDescriptor, new l(name));
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.g gVar : collectionT) {
            InterfaceC0803h interfaceC0803hB = gVar.b();
            p.g(interfaceC0803hB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarC = gVar.c(D9.t.a((InterfaceC0797b) interfaceC0803hB, classDescriptor).c());
            p.g(eVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            e.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> aVarS = ((kotlin.reflect.jvm.internal.impl.descriptors.g) eVarC).s();
            aVarS.s(classDescriptor);
            aVarS.f(classDescriptor.D0());
            aVarS.j();
            int i10 = a.f34994a[A(gVar).ordinal()];
            kotlin.reflect.jvm.internal.impl.descriptors.g gVar2 = null;
            if (i10 != 1) {
                if (i10 == 2) {
                    ga.e name2 = gVar.getName();
                    if (p.d(name2, q.f2310a)) {
                        gVarInvoke = this.f34993h.invoke(Y8.j.a(gVar.getName().b(), AMapLocationStaticsEntity.FIRST_LOCATE));
                    } else {
                        if (!p.d(name2, q.f2311b)) {
                            throw new IllegalStateException(("Unexpected name: " + gVar.getName()).toString());
                        }
                        gVarInvoke = this.f34993h.invoke(Y8.j.a(gVar.getName().b(), "last"));
                    }
                    aVarS.h(gVarInvoke);
                } else if (i10 == 3) {
                    aVarS.h(C());
                } else if (i10 != 4) {
                    if (i10 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Y8.t tVar = Y8.t.f7040a;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarBuild = aVarS.build();
                p.f(eVarBuild);
                gVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.g) eVarBuild;
            } else if (!C0817w.a(classDescriptor)) {
                aVarS.c();
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarBuild2 = aVarS.build();
                p.f(eVarBuild2);
                gVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.g) eVarBuild2;
            }
            if (gVar2 != null) {
                arrayList.add(gVar2);
            }
        }
        return arrayList;
    }

    @Override // G9.a
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> e(InterfaceC0797b classDescriptor) {
        InterfaceC0797b interfaceC0797bF;
        p.i(classDescriptor, "classDescriptor");
        if (classDescriptor.getKind() != ClassKind.CLASS || !D().b()) {
            return C1173v.m();
        }
        C1105n c1105nZ = z(classDescriptor);
        if (c1105nZ != null && (interfaceC0797bF = D9.b.f(this.f34987b, DescriptorUtilsKt.o(c1105nZ), kotlin.reflect.jvm.internal.impl.builtins.jvm.b.f34999h.a(), null, 4, null)) != null) {
            TypeSubstitutor typeSubstitutorC = D9.t.a(interfaceC0797bF, c1105nZ).c();
            List<kotlin.reflect.jvm.internal.impl.descriptors.b> listL0 = c1105nZ.h();
            ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.b> arrayList = new ArrayList();
            for (Object obj : listL0) {
                kotlin.reflect.jvm.internal.impl.descriptors.b bVar = (kotlin.reflect.jvm.internal.impl.descriptors.b) obj;
                if (bVar.getVisibility().d()) {
                    Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collectionH = interfaceC0797bF.h();
                    p.h(collectionH, "getConstructors(...)");
                    Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection = collectionH;
                    if (!(collection instanceof Collection) || !collection.isEmpty()) {
                        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar2 : collection) {
                            p.f(bVar2);
                            if (w(bVar2, typeSubstitutorC, bVar)) {
                                break;
                            }
                        }
                    }
                    if (!H(bVar, classDescriptor) && !C9.j.l0(bVar) && !s.f2313a.e().contains(ba.t.a(x.f15368a, c1105nZ, u.c(bVar, false, false, 3, null)))) {
                        arrayList.add(obj);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
            for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar3 : arrayList) {
                e.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.e> aVarS = bVar3.s();
                aVarS.s(classDescriptor);
                aVarS.o(classDescriptor.n());
                aVarS.j();
                aVarS.d(typeSubstitutorC.k());
                if (!s.f2313a.h().contains(ba.t.a(x.f15368a, c1105nZ, u.c(bVar3, false, false, 3, null)))) {
                    aVarS.h(C());
                }
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarBuild = aVarS.build();
                p.g(eVarBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                arrayList2.add((kotlin.reflect.jvm.internal.impl.descriptors.b) eVarBuild);
            }
            return arrayList2;
        }
        return C1173v.m();
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.g p(DeserializedClassDescriptor deserializedClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.g gVar) {
        e.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> aVarS = gVar.s();
        aVarS.s(deserializedClassDescriptor);
        aVarS.r(C0810o.f2473e);
        aVarS.o(deserializedClassDescriptor.n());
        aVarS.f(deserializedClassDescriptor.D0());
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarBuild = aVarS.build();
        p.f(eVarBuild);
        return (kotlin.reflect.jvm.internal.impl.descriptors.g) eVarBuild;
    }

    public final S q(InterfaceC5869l interfaceC5869l) {
        C0832k c0832k = new C0832k(new b(this.f34986a, new ga.c("java.io")), ga.e.j("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, C1172u.e(new Y(interfaceC5869l, new k(this))), W.f2444a, false, interfaceC5869l);
        c0832k.E0(InterfaceC5238k.b.f38898b, Z8.Y.e(), null);
        AbstractC5990d0 abstractC5990d0N = c0832k.n();
        p.h(abstractC5990d0N, "getDefaultType(...)");
        return abstractC5990d0N;
    }

    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> t(InterfaceC0797b interfaceC0797b, InterfaceC5074l<? super InterfaceC5238k, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> interfaceC5074l) {
        C1105n c1105nZ = z(interfaceC0797b);
        if (c1105nZ == null) {
            return C1173v.m();
        }
        Collection<InterfaceC0797b> collectionG = this.f34987b.g(DescriptorUtilsKt.o(c1105nZ), kotlin.reflect.jvm.internal.impl.builtins.jvm.b.f34999h.a());
        InterfaceC0797b interfaceC0797b2 = (InterfaceC0797b) F.D0(collectionG);
        if (interfaceC0797b2 == null) {
            return C1173v.m();
        }
        k.b bVar = Ia.k.f3419c;
        ArrayList arrayList = new ArrayList(C1174w.x(collectionG, 10));
        Iterator<T> it = collectionG.iterator();
        while (it.hasNext()) {
            arrayList.add(DescriptorUtilsKt.o((InterfaceC0797b) it.next()));
        }
        Ia.k kVarB = bVar.b(arrayList);
        boolean zC = this.f34987b.c(interfaceC0797b);
        InterfaceC5238k interfaceC5238kR = this.f34991f.a(DescriptorUtilsKt.o(c1105nZ), new m(c1105nZ, interfaceC0797b2)).R();
        p.h(interfaceC5238kR, "getUnsubstitutedMemberScope(...)");
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collectionInvoke = interfaceC5074l.invoke(interfaceC5238kR);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionInvoke) {
            kotlin.reflect.jvm.internal.impl.descriptors.g gVar = (kotlin.reflect.jvm.internal.impl.descriptors.g) obj;
            if (gVar.getKind() == CallableMemberDescriptor.Kind.DECLARATION && gVar.getVisibility().d() && !C9.j.l0(gVar)) {
                Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.e> collectionD = gVar.d();
                p.h(collectionD, "getOverriddenDescriptors(...)");
                Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.e> collection = collectionD;
                if (!(collection instanceof Collection) || !collection.isEmpty()) {
                    Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        InterfaceC0803h interfaceC0803hB = ((kotlin.reflect.jvm.internal.impl.descriptors.e) it2.next()).b();
                        p.h(interfaceC0803hB, "getContainingDeclaration(...)");
                        if (kVarB.contains(DescriptorUtilsKt.o(interfaceC0803hB))) {
                            break;
                        }
                    }
                }
                if (!E(gVar, zC)) {
                    arrayList2.add(obj);
                }
            }
        }
        return arrayList2;
    }

    public final AbstractC5990d0 v() {
        return (AbstractC5990d0) C5868k.a(this.f34990e, this, f34985i[1]);
    }

    @Override // G9.a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public Set<ga.e> d(InterfaceC0797b classDescriptor) {
        LazyJavaClassMemberScope lazyJavaClassMemberScopeO0;
        Set<ga.e> setB;
        p.i(classDescriptor, "classDescriptor");
        if (!D().b()) {
            return Z8.Y.e();
        }
        C1105n c1105nZ = z(classDescriptor);
        return (c1105nZ == null || (lazyJavaClassMemberScopeO0 = c1105nZ.R()) == null || (setB = lazyJavaClassMemberScopeO0.b()) == null) ? Z8.Y.e() : setB;
    }

    public final C1105n z(InterfaceC0797b interfaceC0797b) {
        ga.b bVarN;
        ga.c cVarA;
        if (C9.j.b0(interfaceC0797b) || !C9.j.C0(interfaceC0797b)) {
            return null;
        }
        d dVarP = DescriptorUtilsKt.p(interfaceC0797b);
        if (dVarP.f() && (bVarN = D9.a.f2270a.n(dVarP)) != null && (cVarA = bVarN.a()) != null) {
            InterfaceC0797b interfaceC0797bD = C0809n.d(D().a(), cVarA, NoLookupLocation.FROM_BUILTINS);
            if (interfaceC0797bD instanceof C1105n) {
                return (C1105n) interfaceC0797bD;
            }
        }
        return null;
    }
}
