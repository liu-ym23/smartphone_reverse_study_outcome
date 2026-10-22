package H9;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.b0;
import E9.g0;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import ka.AbstractC4831k;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import ra.AbstractC5239l;
import ra.C5231d;
import ra.InterfaceC5238k;
import xa.InterfaceC5863f;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.C6013t;
import ya.v0;

/* renamed from: H9.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0838q extends AbstractC0831j {

    /* renamed from: i, reason: collision with root package name */
    public final v0 f3144i;

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC5238k f3145j;

    /* renamed from: k, reason: collision with root package name */
    public final InterfaceC5865h<Set<ga.e>> f3146k;

    /* renamed from: l, reason: collision with root package name */
    public final F9.g f3147l;

    /* renamed from: H9.q$a */
    public class a extends AbstractC5239l {

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC5863f<ga.e, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> f3148b;

        /* renamed from: c, reason: collision with root package name */
        public final InterfaceC5863f<ga.e, Collection<? extends E9.O>> f3149c;

        /* renamed from: d, reason: collision with root package name */
        public final InterfaceC5865h<Collection<InterfaceC0803h>> f3150d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ C0838q f3151e;

        /* renamed from: H9.q$a$a, reason: collision with other inner class name */
        public class C0050a implements InterfaceC5074l<ga.e, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0838q f3152a;

            public C0050a(C0838q c0838q) {
                this.f3152a = c0838q;
            }

            @Override // p9.InterfaceC5074l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> invoke(ga.e eVar) {
                return a.this.l(eVar);
            }
        }

        /* renamed from: H9.q$a$b */
        public class b implements InterfaceC5074l<ga.e, Collection<? extends E9.O>> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0838q f3154a;

            public b(C0838q c0838q) {
                this.f3154a = c0838q;
            }

            @Override // p9.InterfaceC5074l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<? extends E9.O> invoke(ga.e eVar) {
                return a.this.m(eVar);
            }
        }

        /* renamed from: H9.q$a$c */
        public class c implements InterfaceC5063a<Collection<InterfaceC0803h>> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0838q f3156a;

            public c(C0838q c0838q) {
                this.f3156a = c0838q;
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<InterfaceC0803h> invoke() {
                return a.this.k();
            }
        }

        /* renamed from: H9.q$a$d */
        public class d extends AbstractC4831k {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Set f3158a;

            public d(Set set) {
                this.f3158a = set;
            }

            public static /* synthetic */ void f(int i10) {
                Object[] objArr = new Object[3];
                if (i10 == 1) {
                    objArr[0] = "fromSuper";
                } else if (i10 != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i10 == 1 || i10 == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // ka.AbstractC4832l
            public void a(CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    f(0);
                }
                OverridingUtil.K(callableMemberDescriptor, null);
                this.f3158a.add(callableMemberDescriptor);
            }

            @Override // ka.AbstractC4831k
            public void e(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                if (callableMemberDescriptor == null) {
                    f(1);
                }
                if (callableMemberDescriptor2 == null) {
                    f(2);
                }
            }
        }

        public a(C0838q c0838q, InterfaceC5869l interfaceC5869l) {
            if (interfaceC5869l == null) {
                g(0);
            }
            this.f3151e = c0838q;
            this.f3148b = interfaceC5869l.c(new C0050a(c0838q));
            this.f3149c = interfaceC5869l.c(new b(c0838q));
            this.f3150d = interfaceC5869l.i(new c(c0838q));
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static /* synthetic */ void g(int r13) {
            /*
                Method dump skipped, instructions count: 346
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: H9.C0838q.a.g(int):void");
        }

        @Override // ra.AbstractC5239l, ra.InterfaceC5238k
        public Collection<? extends E9.O> a(ga.e eVar, M9.b bVar) {
            if (eVar == null) {
                g(1);
            }
            if (bVar == null) {
                g(2);
            }
            Collection<? extends E9.O> collectionInvoke = this.f3149c.invoke(eVar);
            if (collectionInvoke == null) {
                g(3);
            }
            return collectionInvoke;
        }

        @Override // ra.AbstractC5239l, ra.InterfaceC5238k
        public Set<ga.e> b() {
            Set<ga.e> set = (Set) this.f3151e.f3146k.invoke();
            if (set == null) {
                g(17);
            }
            return set;
        }

        @Override // ra.AbstractC5239l, ra.InterfaceC5238k
        public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e eVar, M9.b bVar) {
            if (eVar == null) {
                g(5);
            }
            if (bVar == null) {
                g(6);
            }
            Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collectionInvoke = this.f3148b.invoke(eVar);
            if (collectionInvoke == null) {
                g(7);
            }
            return collectionInvoke;
        }

        @Override // ra.AbstractC5239l, ra.InterfaceC5241n
        public Collection<InterfaceC0803h> e(C5231d c5231d, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l) {
            if (c5231d == null) {
                g(13);
            }
            if (interfaceC5074l == null) {
                g(14);
            }
            Collection<InterfaceC0803h> collectionInvoke = this.f3150d.invoke();
            if (collectionInvoke == null) {
                g(15);
            }
            return collectionInvoke;
        }

        @Override // ra.AbstractC5239l, ra.InterfaceC5238k
        public Set<ga.e> f() {
            Set<ga.e> set = Collections.EMPTY_SET;
            if (set == null) {
                g(18);
            }
            return set;
        }

        @Override // ra.AbstractC5239l, ra.InterfaceC5238k
        public Set<ga.e> getVariableNames() {
            Set<ga.e> set = (Set) this.f3151e.f3146k.invoke();
            if (set == null) {
                g(19);
            }
            return set;
        }

        public final Collection<InterfaceC0803h> k() {
            HashSet hashSet = new HashSet();
            for (ga.e eVar : (Set) this.f3151e.f3146k.invoke()) {
                NoLookupLocation noLookupLocation = NoLookupLocation.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(c(eVar, noLookupLocation));
                hashSet.addAll(a(eVar, noLookupLocation));
            }
            return hashSet;
        }

        public final Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> l(ga.e eVar) {
            if (eVar == null) {
                g(8);
            }
            return o(eVar, n().c(eVar, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        public final Collection<? extends E9.O> m(ga.e eVar) {
            if (eVar == null) {
                g(4);
            }
            return o(eVar, n().a(eVar, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        public final InterfaceC5238k n() {
            InterfaceC5238k interfaceC5238kM = this.f3151e.j().e().iterator().next().m();
            if (interfaceC5238kM == null) {
                g(9);
            }
            return interfaceC5238kM;
        }

        public final <D extends CallableMemberDescriptor> Collection<? extends D> o(ga.e eVar, Collection<? extends D> collection) {
            if (eVar == null) {
                g(10);
            }
            if (collection == null) {
                g(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            OverridingUtil.f35978f.v(eVar, collection, Collections.EMPTY_SET, this.f3151e, new d(linkedHashSet));
            return linkedHashSet;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0838q(InterfaceC5869l interfaceC5869l, InterfaceC0797b interfaceC0797b, ya.S s10, ga.e eVar, InterfaceC5865h<Set<ga.e>> interfaceC5865h, F9.g gVar, E9.W w10) {
        super(interfaceC5869l, interfaceC0797b, eVar, w10, false);
        if (interfaceC5869l == null) {
            y0(6);
        }
        if (interfaceC0797b == null) {
            y0(7);
        }
        if (s10 == null) {
            y0(8);
        }
        if (eVar == null) {
            y0(9);
        }
        if (interfaceC5865h == null) {
            y0(10);
        }
        if (gVar == null) {
            y0(11);
        }
        if (w10 == null) {
            y0(12);
        }
        this.f3147l = gVar;
        this.f3144i = new C6013t(this, Collections.EMPTY_LIST, Collections.singleton(s10), interfaceC5869l);
        this.f3145j = new a(this, interfaceC5869l);
        this.f3146k = interfaceC5865h;
    }

    public static C0838q F0(InterfaceC5869l interfaceC5869l, InterfaceC0797b interfaceC0797b, ga.e eVar, InterfaceC5865h<Set<ga.e>> interfaceC5865h, F9.g gVar, E9.W w10) {
        if (interfaceC5869l == null) {
            y0(0);
        }
        if (interfaceC0797b == null) {
            y0(1);
        }
        if (eVar == null) {
            y0(2);
        }
        if (interfaceC5865h == null) {
            y0(3);
        }
        if (gVar == null) {
            y0(4);
        }
        if (w10 == null) {
            y0(5);
        }
        return new C0838q(interfaceC5869l, interfaceC0797b, interfaceC0797b.n(), eVar, interfaceC5865h, gVar, w10);
    }

    private static /* synthetic */ void y0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i10) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i10) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // E9.InterfaceC0797b
    public kotlin.reflect.jvm.internal.impl.descriptors.b B() {
        return null;
    }

    @Override // E9.InterfaceC0797b
    public boolean C0() {
        return false;
    }

    @Override // E9.InterfaceC0797b
    public g0<AbstractC5990d0> P() {
        return null;
    }

    @Override // E9.InterfaceC0816v
    public boolean S() {
        return false;
    }

    @Override // E9.InterfaceC0797b
    public boolean W() {
        return false;
    }

    @Override // E9.InterfaceC0797b
    public boolean Z() {
        return false;
    }

    @Override // H9.z
    public InterfaceC5238k c0(kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        if (cVar == null) {
            y0(13);
        }
        InterfaceC5238k interfaceC5238k = this.f3145j;
        if (interfaceC5238k == null) {
            y0(14);
        }
        return interfaceC5238k;
    }

    @Override // E9.InterfaceC0816v
    public boolean e0() {
        return false;
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC5238k g0() {
        InterfaceC5238k.b bVar = InterfaceC5238k.b.f38898b;
        if (bVar == null) {
            y0(15);
        }
        return bVar;
    }

    @Override // F9.a
    public F9.g getAnnotations() {
        F9.g gVar = this.f3147l;
        if (gVar == null) {
            y0(21);
        }
        return gVar;
    }

    @Override // E9.InterfaceC0797b
    public ClassKind getKind() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind == null) {
            y0(18);
        }
        return classKind;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        AbstractC0811p abstractC0811p = C0810o.f2473e;
        if (abstractC0811p == null) {
            y0(20);
        }
        return abstractC0811p;
    }

    @Override // E9.InterfaceC0797b
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> h() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            y0(16);
        }
        return list;
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC0797b h0() {
        return null;
    }

    @Override // E9.InterfaceC0797b
    public boolean isInline() {
        return false;
    }

    @Override // E9.InterfaceC0799d
    public v0 j() {
        v0 v0Var = this.f3144i;
        if (v0Var == null) {
            y0(17);
        }
        return v0Var;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0800e
    public List<b0> o() {
        List<b0> list = Collections.EMPTY_LIST;
        if (list == null) {
            y0(22);
        }
        return list;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public Modality p() {
        Modality modality = Modality.FINAL;
        if (modality == null) {
            y0(19);
        }
        return modality;
    }

    @Override // E9.InterfaceC0797b
    public boolean q() {
        return false;
    }

    public String toString() {
        return "enum entry " + getName();
    }

    @Override // E9.InterfaceC0800e
    public boolean x() {
        return false;
    }
}
