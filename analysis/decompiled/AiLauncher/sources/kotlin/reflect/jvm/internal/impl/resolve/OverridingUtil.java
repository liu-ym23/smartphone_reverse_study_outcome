package kotlin.reflect.jvm.internal.impl.resolve;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.InterfaceC0807l;
import E9.InterfaceC0816v;
import E9.O;
import E9.b0;
import E9.i0;
import H9.AbstractC0839s;
import H9.J;
import H9.K;
import Ia.k;
import Y8.t;
import Z8.F;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import ka.AbstractC4832l;
import ka.C4828h;
import ka.C4833m;
import ka.C4841u;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.b;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;
import ya.C5977L;
import ya.S;
import ya.W;
import ya.v0;

/* loaded from: classes5.dex */
public class OverridingUtil {

    /* renamed from: e, reason: collision with root package name */
    public static final List<ExternalOverridabilityCondition> f35977e = F.m1(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));

    /* renamed from: f, reason: collision with root package name */
    public static final OverridingUtil f35978f;

    /* renamed from: g, reason: collision with root package name */
    public static final b.a f35979g;

    /* renamed from: a, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.types.checker.c f35980a;

    /* renamed from: b, reason: collision with root package name */
    public final KotlinTypePreparator f35981b;

    /* renamed from: c, reason: collision with root package name */
    public final b.a f35982c;

    /* renamed from: d, reason: collision with root package name */
    public final p<S, S, Boolean> f35983d;

    public static class OverrideCompatibilityInfo {

        /* renamed from: c, reason: collision with root package name */
        public static final OverrideCompatibilityInfo f35984c = new OverrideCompatibilityInfo(Result.OVERRIDABLE, AMapLocationStaticsEntity.SUCCESS_STATUS);

        /* renamed from: a, reason: collision with root package name */
        public final Result f35985a;

        /* renamed from: b, reason: collision with root package name */
        public final String f35986b;

        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public OverrideCompatibilityInfo(Result result, String str) {
            if (result == null) {
                a(3);
            }
            if (str == null) {
                a(4);
            }
            this.f35985a = result;
            this.f35986b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static /* synthetic */ void a(int r10) {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                if (r10 == r3) goto Lf
                if (r10 == r2) goto Lf
                if (r10 == r1) goto Lf
                if (r10 == r0) goto Lf
                java.lang.String r4 = "@NotNull method %s.%s must not return null"
                goto L11
            Lf:
                java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            L11:
                if (r10 == r3) goto L1b
                if (r10 == r2) goto L1b
                if (r10 == r1) goto L1b
                if (r10 == r0) goto L1b
                r5 = r2
                goto L1c
            L1b:
                r5 = r1
            L1c:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "success"
                java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo"
                r8 = 0
                if (r10 == r3) goto L31
                if (r10 == r2) goto L31
                if (r10 == r1) goto L2e
                if (r10 == r0) goto L31
                r5[r8] = r7
                goto L35
            L2e:
                r5[r8] = r6
                goto L35
            L31:
                java.lang.String r9 = "debugMessage"
                r5[r8] = r9
            L35:
                switch(r10) {
                    case 1: goto L45;
                    case 2: goto L45;
                    case 3: goto L45;
                    case 4: goto L45;
                    case 5: goto L40;
                    case 6: goto L3b;
                    default: goto L38;
                }
            L38:
                r5[r3] = r6
                goto L47
            L3b:
                java.lang.String r6 = "getDebugMessage"
                r5[r3] = r6
                goto L47
            L40:
                java.lang.String r6 = "getResult"
                r5[r3] = r6
                goto L47
            L45:
                r5[r3] = r7
            L47:
                if (r10 == r3) goto L5a
                if (r10 == r2) goto L55
                if (r10 == r1) goto L50
                if (r10 == r0) goto L50
                goto L5e
            L50:
                java.lang.String r6 = "<init>"
                r5[r2] = r6
                goto L5e
            L55:
                java.lang.String r6 = "conflict"
                r5[r2] = r6
                goto L5e
            L5a:
                java.lang.String r6 = "incompatible"
                r5[r2] = r6
            L5e:
                java.lang.String r4 = java.lang.String.format(r4, r5)
                if (r10 == r3) goto L70
                if (r10 == r2) goto L70
                if (r10 == r1) goto L70
                if (r10 == r0) goto L70
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r4)
                goto L75
            L70:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r4)
            L75:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.a(int):void");
        }

        public static OverrideCompatibilityInfo b(String str) {
            if (str == null) {
                a(2);
            }
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        public static OverrideCompatibilityInfo d(String str) {
            if (str == null) {
                a(1);
            }
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }

        public static OverrideCompatibilityInfo e() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = f35984c;
            if (overrideCompatibilityInfo == null) {
                a(0);
            }
            return overrideCompatibilityInfo;
        }

        public Result c() {
            Result result = this.f35985a;
            if (result == null) {
                a(5);
            }
            return result;
        }

        public String toString() {
            return this.f35985a + ": " + this.f35986b;
        }
    }

    public static class a implements b.a {
        public static /* synthetic */ void b(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = Const.INTENT_KEY_APIKEY;
            } else {
                objArr[0] = Const.INTENT_KEY_PKGNAME;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.b.a
        public boolean a(v0 v0Var, v0 v0Var2) {
            if (v0Var == null) {
                b(0);
            }
            if (v0Var2 == null) {
                b(1);
            }
            return v0Var.equals(v0Var2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    public static class b<D> implements p<D, D, Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a>> {
        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Lkotlin/reflect/jvm/internal/impl/descriptors/a;Lkotlin/reflect/jvm/internal/impl/descriptors/a;>; */
        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Pair invoke(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
            return new Pair(aVar, aVar2);
        }
    }

    public static class c implements InterfaceC5074l<CallableMemberDescriptor, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0803h f35987a;

        public c(InterfaceC0803h interfaceC0803h) {
            this.f35987a = interfaceC0803h;
        }

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(callableMemberDescriptor.b() == this.f35987a);
        }
    }

    public static class d implements InterfaceC5074l<CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a> {
        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CallableMemberDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    public static class e implements InterfaceC5074l<CallableMemberDescriptor, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0797b f35988a;

        public e(InterfaceC0797b interfaceC0797b) {
            this.f35988a = interfaceC0797b;
        }

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            boolean z10 = false;
            if (!C0810o.g(callableMemberDescriptor.getVisibility()) && C0810o.h(callableMemberDescriptor, this.f35988a, false)) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static class f implements InterfaceC5074l<CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a> {
        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.a invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    public static class g implements InterfaceC5074l<CallableMemberDescriptor, t> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC4832l f35989a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CallableMemberDescriptor f35990b;

        public g(AbstractC4832l abstractC4832l, CallableMemberDescriptor callableMemberDescriptor) {
            this.f35989a = abstractC4832l;
            this.f35990b = callableMemberDescriptor;
        }

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public t invoke(CallableMemberDescriptor callableMemberDescriptor) {
            this.f35989a.b(this.f35990b, callableMemberDescriptor);
            return t.f7040a;
        }
    }

    public static /* synthetic */ class h {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35991a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f35992b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f35993c;

        static {
            int[] iArr = new int[Modality.values().length];
            f35993c = iArr;
            try {
                iArr[Modality.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35993c[Modality.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35993c[Modality.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35993c[Modality.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[OverrideCompatibilityInfo.Result.values().length];
            f35992b = iArr2;
            try {
                iArr2[OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35992b[OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35992b[OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[ExternalOverridabilityCondition.Result.values().length];
            f35991a = iArr3;
            try {
                iArr3[ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35991a[ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35991a[ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        a aVar = new a();
        f35979g = aVar;
        f35978f = new OverridingUtil(aVar, c.a.f36099a, KotlinTypePreparator.a.f36096a, null);
    }

    public OverridingUtil(b.a aVar, kotlin.reflect.jvm.internal.impl.types.checker.c cVar, KotlinTypePreparator kotlinTypePreparator, p<S, S, Boolean> pVar) {
        if (aVar == null) {
            a(5);
        }
        if (cVar == null) {
            a(6);
        }
        if (kotlinTypePreparator == null) {
            a(7);
        }
        this.f35982c = aVar;
        this.f35980a = cVar;
        this.f35981b = kotlinTypePreparator;
        this.f35983d = pVar;
    }

    public static boolean A(kotlin.reflect.jvm.internal.impl.descriptors.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.f fVar2) {
        if (fVar == null || fVar2 == null) {
            return true;
        }
        return H(fVar, fVar2);
    }

    public static boolean B(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        if (aVar == null) {
            a(65);
        }
        if (aVar2 == null) {
            a(66);
        }
        S returnType = aVar.getReturnType();
        S returnType2 = aVar2.getReturnType();
        if (!H(aVar, aVar2)) {
            return false;
        }
        TypeCheckerState typeCheckerStateL = f35978f.l(aVar.getTypeParameters(), aVar2.getTypeParameters());
        if (aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            return G(aVar, returnType, aVar2, returnType2, typeCheckerStateL);
        }
        if (!(aVar instanceof O)) {
            throw new IllegalArgumentException("Unexpected callable: " + aVar.getClass());
        }
        O o10 = (O) aVar;
        O o11 = (O) aVar2;
        if (A(o10.getSetter(), o11.getSetter())) {
            return (o10.J() && o11.J()) ? kotlin.reflect.jvm.internal.impl.types.b.f36092a.m(typeCheckerStateL, returnType.K0(), returnType2.K0()) : (o10.J() || !o11.J()) && G(aVar, returnType, aVar2, returnType2, typeCheckerStateL);
        }
        return false;
    }

    public static boolean C(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, Collection<kotlin.reflect.jvm.internal.impl.descriptors.a> collection) {
        if (aVar == null) {
            a(69);
        }
        if (collection == null) {
            a(70);
        }
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.a> it = collection.iterator();
        while (it.hasNext()) {
            if (!B(aVar, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean G(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, S s10, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, S s11, TypeCheckerState typeCheckerState) {
        if (aVar == null) {
            a(71);
        }
        if (s10 == null) {
            a(72);
        }
        if (aVar2 == null) {
            a(73);
        }
        if (s11 == null) {
            a(74);
        }
        if (typeCheckerState == null) {
            a(75);
        }
        return kotlin.reflect.jvm.internal.impl.types.b.f36092a.u(typeCheckerState, s10.K0(), s11.K0());
    }

    public static boolean H(InterfaceC0807l interfaceC0807l, InterfaceC0807l interfaceC0807l2) {
        if (interfaceC0807l == null) {
            a(67);
        }
        if (interfaceC0807l2 == null) {
            a(68);
        }
        Integer numD = C0810o.d(interfaceC0807l.getVisibility(), interfaceC0807l2.getVisibility());
        return numD == null || numD.intValue() >= 0;
    }

    public static boolean I(InterfaceC0816v interfaceC0816v, InterfaceC0816v interfaceC0816v2, boolean z10) {
        if (interfaceC0816v == null) {
            a(55);
        }
        if (interfaceC0816v2 == null) {
            a(56);
        }
        return !C0810o.g(interfaceC0816v2.getVisibility()) && C0810o.h(interfaceC0816v2, interfaceC0816v, z10);
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> boolean J(D d10, D d11, boolean z10, boolean z11) {
        if (d10 == null) {
            a(13);
        }
        if (d11 == null) {
            a(14);
        }
        if (!d10.equals(d11) && kotlin.reflect.jvm.internal.impl.resolve.a.f35994a.k(d10.a(), d11.a(), z10, z11)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.a aVarA = d11.a();
        Iterator it = C4828h.d(d10).iterator();
        while (it.hasNext()) {
            if (kotlin.reflect.jvm.internal.impl.resolve.a.f35994a.k(aVarA, (kotlin.reflect.jvm.internal.impl.descriptors.a) it.next(), z10, z11)) {
                return true;
            }
        }
        return false;
    }

    public static void K(CallableMemberDescriptor callableMemberDescriptor, InterfaceC5074l<CallableMemberDescriptor, t> interfaceC5074l) {
        AbstractC0811p abstractC0811p;
        if (callableMemberDescriptor == null) {
            a(105);
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.d()) {
            if (callableMemberDescriptor2.getVisibility() == C0810o.f2475g) {
                K(callableMemberDescriptor2, interfaceC5074l);
            }
        }
        if (callableMemberDescriptor.getVisibility() != C0810o.f2475g) {
            return;
        }
        AbstractC0811p abstractC0811pH = h(callableMemberDescriptor);
        if (abstractC0811pH == null) {
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(callableMemberDescriptor);
            }
            abstractC0811p = C0810o.f2473e;
        } else {
            abstractC0811p = abstractC0811pH;
        }
        if (callableMemberDescriptor instanceof K) {
            ((K) callableMemberDescriptor).W0(abstractC0811p);
            Iterator<kotlin.reflect.jvm.internal.impl.descriptors.f> it = ((O) callableMemberDescriptor).t().iterator();
            while (it.hasNext()) {
                K(it.next(), abstractC0811pH == null ? null : interfaceC5074l);
            }
            return;
        }
        if (callableMemberDescriptor instanceof AbstractC0839s) {
            ((AbstractC0839s) callableMemberDescriptor).d1(abstractC0811p);
            return;
        }
        J j10 = (J) callableMemberDescriptor;
        j10.I0(abstractC0811p);
        if (abstractC0811p != j10.Q().getVisibility()) {
            j10.G0(false);
        }
    }

    public static <H> H L(Collection<H> collection, InterfaceC5074l<H, kotlin.reflect.jvm.internal.impl.descriptors.a> interfaceC5074l) {
        H h10;
        if (collection == null) {
            a(76);
        }
        if (interfaceC5074l == null) {
            a(77);
        }
        if (collection.size() == 1) {
            H h11 = (H) F.p0(collection);
            if (h11 == null) {
                a(78);
            }
            return h11;
        }
        ArrayList arrayList = new ArrayList(2);
        List listF0 = F.F0(collection, interfaceC5074l);
        H h12 = (H) F.p0(collection);
        kotlin.reflect.jvm.internal.impl.descriptors.a aVarInvoke = interfaceC5074l.invoke(h12);
        for (H h13 : collection) {
            kotlin.reflect.jvm.internal.impl.descriptors.a aVarInvoke2 = interfaceC5074l.invoke(h13);
            if (C(aVarInvoke2, listF0)) {
                arrayList.add(h13);
            }
            if (B(aVarInvoke2, aVarInvoke) && !B(aVarInvoke, aVarInvoke2)) {
                h12 = h13;
            }
        }
        if (arrayList.isEmpty()) {
            if (h12 == null) {
                a(79);
            }
            return h12;
        }
        if (arrayList.size() == 1) {
            H h14 = (H) F.p0(arrayList);
            if (h14 == null) {
                a(80);
            }
            return h14;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                h10 = null;
                break;
            }
            h10 = (H) it.next();
            if (!C5977L.b(interfaceC5074l.invoke(h10).getReturnType())) {
                break;
            }
        }
        if (h10 != null) {
            return h10;
        }
        H h15 = (H) F.p0(arrayList);
        if (h15 == null) {
            a(82);
        }
        return h15;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instructions count: 1298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.a(int):void");
    }

    public static boolean b(Collection<CallableMemberDescriptor> collection) {
        if (collection == null) {
            a(61);
        }
        if (collection.size() < 2) {
            return true;
        }
        return F.c0(collection, new c(collection.iterator().next().b()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
    
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(E9.b0 r4, E9.b0 r5, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState r6) {
        /*
            if (r4 != 0) goto L7
            r0 = 47
            a(r0)
        L7:
            if (r5 != 0) goto Le
            r0 = 48
            a(r0)
        Le:
            if (r6 != 0) goto L15
            r0 = 49
            a(r0)
        L15:
            java.util.List r4 = r4.getUpperBounds()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List r5 = r5.getUpperBounds()
            r0.<init>(r5)
            int r5 = r4.size()
            int r1 = r0.size()
            r2 = 0
            if (r5 == r1) goto L2e
            return r2
        L2e:
            java.util.Iterator r4 = r4.iterator()
        L32:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L59
            java.lang.Object r5 = r4.next()
            ya.S r5 = (ya.S) r5
            java.util.ListIterator r1 = r0.listIterator()
        L42:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r1.next()
            ya.S r3 = (ya.S) r3
            boolean r3 = d(r5, r3, r6)
            if (r3 == 0) goto L42
            r1.remove()
            goto L32
        L58:
            return r2
        L59:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.c(E9.b0, E9.b0, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState):boolean");
    }

    public static boolean d(S s10, S s11, TypeCheckerState typeCheckerState) {
        if (s10 == null) {
            a(44);
        }
        if (s11 == null) {
            a(45);
        }
        if (typeCheckerState == null) {
            a(46);
        }
        if (W.a(s10) && W.a(s11)) {
            return true;
        }
        return kotlin.reflect.jvm.internal.impl.types.b.f36092a.m(typeCheckerState, s10.K0(), s11.K0());
    }

    public static OverrideCompatibilityInfo e(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        if ((aVar.K() == null) != (aVar2.K() == null)) {
            return OverrideCompatibilityInfo.d("Receiver presence mismatch");
        }
        if (aVar.i().size() != aVar2.i().size()) {
            return OverrideCompatibilityInfo.d("Value parameter number mismatch");
        }
        return null;
    }

    public static void f(CallableMemberDescriptor callableMemberDescriptor, Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            a(17);
        }
        if (set == null) {
            a(18);
        }
        if (callableMemberDescriptor.getKind().isReal()) {
            set.add(callableMemberDescriptor);
            return;
        }
        if (callableMemberDescriptor.d().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
        Iterator<? extends CallableMemberDescriptor> it = callableMemberDescriptor.d().iterator();
        while (it.hasNext()) {
            f(it.next(), set);
        }
    }

    public static List<S> g(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        E9.S sK = aVar.K();
        ArrayList arrayList = new ArrayList();
        if (sK != null) {
            arrayList.add(sK.getType());
        }
        Iterator<i0> it = aVar.i().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }

    public static AbstractC0811p h(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(106);
        }
        Collection<? extends CallableMemberDescriptor> collectionD = callableMemberDescriptor.d();
        AbstractC0811p abstractC0811pU = u(collectionD);
        if (abstractC0811pU == null) {
            return null;
        }
        if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return abstractC0811pU.f();
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : collectionD) {
            if (callableMemberDescriptor2.p() != Modality.ABSTRACT && !callableMemberDescriptor2.getVisibility().equals(abstractC0811pU)) {
                return null;
            }
        }
        return abstractC0811pU;
    }

    public static OverridingUtil i(kotlin.reflect.jvm.internal.impl.types.checker.c cVar, b.a aVar) {
        if (cVar == null) {
            a(3);
        }
        if (aVar == null) {
            a(4);
        }
        return new OverridingUtil(aVar, cVar, KotlinTypePreparator.a.f36096a, null);
    }

    public static void j(Collection<CallableMemberDescriptor> collection, InterfaceC0797b interfaceC0797b, AbstractC4832l abstractC4832l) {
        if (collection == null) {
            a(83);
        }
        if (interfaceC0797b == null) {
            a(84);
        }
        if (abstractC4832l == null) {
            a(85);
        }
        Collection<CallableMemberDescriptor> collectionT = t(interfaceC0797b, collection);
        boolean zIsEmpty = collectionT.isEmpty();
        if (!zIsEmpty) {
            collection = collectionT;
        }
        CallableMemberDescriptor callableMemberDescriptorY = ((CallableMemberDescriptor) L(collection, new d())).y(interfaceC0797b, n(collection, interfaceC0797b), zIsEmpty ? C0810o.f2476h : C0810o.f2475g, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        abstractC4832l.d(callableMemberDescriptorY, collection);
        abstractC4832l.a(callableMemberDescriptorY);
    }

    public static void k(InterfaceC0797b interfaceC0797b, Collection<CallableMemberDescriptor> collection, AbstractC4832l abstractC4832l) {
        if (interfaceC0797b == null) {
            a(62);
        }
        if (collection == null) {
            a(63);
        }
        if (abstractC4832l == null) {
            a(64);
        }
        if (b(collection)) {
            Iterator<CallableMemberDescriptor> it = collection.iterator();
            while (it.hasNext()) {
                j(Collections.singleton(it.next()), interfaceC0797b, abstractC4832l);
            }
        } else {
            LinkedList linkedList = new LinkedList(collection);
            while (!linkedList.isEmpty()) {
                j(q(C4841u.a(linkedList), linkedList, abstractC4832l), interfaceC0797b, abstractC4832l);
            }
        }
    }

    public static OverridingUtil m(kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        if (cVar == null) {
            a(0);
        }
        return new OverridingUtil(f35979g, cVar, KotlinTypePreparator.a.f36096a, null);
    }

    public static Modality n(Collection<CallableMemberDescriptor> collection, InterfaceC0797b interfaceC0797b) {
        if (collection == null) {
            a(86);
        }
        if (interfaceC0797b == null) {
            a(87);
        }
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            int i10 = h.f35993c[callableMemberDescriptor.p().ordinal()];
            if (i10 == 1) {
                Modality modality = Modality.FINAL;
                if (modality == null) {
                    a(88);
                }
                return modality;
            }
            if (i10 == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + callableMemberDescriptor);
            }
            if (i10 == 3) {
                z11 = true;
            } else if (i10 == 4) {
                z12 = true;
            }
        }
        if (interfaceC0797b.e0() && interfaceC0797b.p() != Modality.ABSTRACT && interfaceC0797b.p() != Modality.SEALED) {
            z10 = true;
        }
        if (z11 && !z12) {
            Modality modality2 = Modality.OPEN;
            if (modality2 == null) {
                a(89);
            }
            return modality2;
        }
        if (!z11 && z12) {
            Modality modalityP = z10 ? interfaceC0797b.p() : Modality.ABSTRACT;
            if (modalityP == null) {
                a(90);
            }
            return modalityP;
        }
        HashSet hashSet = new HashSet();
        Iterator<CallableMemberDescriptor> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.addAll(z(it.next()));
        }
        return y(r(hashSet), z10, interfaceC0797b.p());
    }

    public static <H> Collection<H> p(H h10, Collection<H> collection, InterfaceC5074l<H, kotlin.reflect.jvm.internal.impl.descriptors.a> interfaceC5074l, InterfaceC5074l<H, t> interfaceC5074l2) {
        if (h10 == null) {
            a(97);
        }
        if (collection == null) {
            a(98);
        }
        if (interfaceC5074l == null) {
            a(99);
        }
        if (interfaceC5074l2 == null) {
            a(100);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h10);
        kotlin.reflect.jvm.internal.impl.descriptors.a aVarInvoke = interfaceC5074l.invoke(h10);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.a aVarInvoke2 = interfaceC5074l.invoke(next);
            if (h10 == next) {
                it.remove();
            } else {
                OverrideCompatibilityInfo.Result resultX = x(aVarInvoke, aVarInvoke2);
                if (resultX == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (resultX == OverrideCompatibilityInfo.Result.CONFLICT) {
                    interfaceC5074l2.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static Collection<CallableMemberDescriptor> q(CallableMemberDescriptor callableMemberDescriptor, Queue<CallableMemberDescriptor> queue, AbstractC4832l abstractC4832l) {
        if (callableMemberDescriptor == null) {
            a(102);
        }
        if (queue == null) {
            a(103);
        }
        if (abstractC4832l == null) {
            a(104);
        }
        return p(callableMemberDescriptor, queue, new f(), new g(abstractC4832l, callableMemberDescriptor));
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> Set<D> r(Set<D> set) {
        if (set == null) {
            a(8);
        }
        return s(set, !set.isEmpty() && DescriptorUtilsKt.y(DescriptorUtilsKt.s(set.iterator().next())), null, new b());
    }

    public static <D> Set<D> s(Set<D> set, boolean z10, InterfaceC5063a<?> interfaceC5063a, p<? super D, ? super D, Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a>> pVar) {
        if (set == null) {
            a(9);
        }
        if (pVar == null) {
            a(10);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(obj);
                    break;
                }
                Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a> pairInvoke = pVar.invoke(obj, (Object) it.next());
                kotlin.reflect.jvm.internal.impl.descriptors.a aVarA = pairInvoke.a();
                kotlin.reflect.jvm.internal.impl.descriptors.a aVarB = pairInvoke.b();
                if (!J(aVarA, aVarB, z10, true)) {
                    if (J(aVarB, aVarA, z10, true)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return linkedHashSet;
    }

    public static Collection<CallableMemberDescriptor> t(InterfaceC0797b interfaceC0797b, Collection<CallableMemberDescriptor> collection) {
        if (interfaceC0797b == null) {
            a(94);
        }
        if (collection == null) {
            a(95);
        }
        List listM0 = F.m0(collection, new e(interfaceC0797b));
        if (listM0 == null) {
            a(96);
        }
        return listM0;
    }

    public static AbstractC0811p u(Collection<? extends CallableMemberDescriptor> collection) {
        AbstractC0811p abstractC0811p;
        if (collection == null) {
            a(107);
        }
        if (collection.isEmpty()) {
            return C0810o.f2480l;
        }
        Iterator<? extends CallableMemberDescriptor> it = collection.iterator();
        loop0: while (true) {
            abstractC0811p = null;
            while (it.hasNext()) {
                AbstractC0811p visibility = it.next().getVisibility();
                if (abstractC0811p != null) {
                    Integer numD = C0810o.d(visibility, abstractC0811p);
                    if (numD == null) {
                        break;
                    }
                    if (numD.intValue() > 0) {
                    }
                }
                abstractC0811p = visibility;
            }
        }
        if (abstractC0811p == null) {
            return null;
        }
        Iterator<? extends CallableMemberDescriptor> it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer numD2 = C0810o.d(abstractC0811p, it2.next().getVisibility());
            if (numD2 == null || numD2.intValue() < 0) {
                return null;
            }
        }
        return abstractC0811p;
    }

    public static OverrideCompatibilityInfo w(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        boolean z10;
        if (aVar == null) {
            a(38);
        }
        if (aVar2 == null) {
            a(39);
        }
        boolean z11 = aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e;
        if ((z11 && !(aVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e)) || (((z10 = aVar instanceof O)) && !(aVar2 instanceof O))) {
            return OverrideCompatibilityInfo.d("Member kind mismatch");
        }
        if (!z11 && !z10) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + aVar);
        }
        if (!aVar.getName().equals(aVar2.getName())) {
            return OverrideCompatibilityInfo.d("Name mismatch");
        }
        OverrideCompatibilityInfo overrideCompatibilityInfoE = e(aVar, aVar2);
        if (overrideCompatibilityInfoE != null) {
            return overrideCompatibilityInfoE;
        }
        return null;
    }

    public static OverrideCompatibilityInfo.Result x(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        OverridingUtil overridingUtil = f35978f;
        OverrideCompatibilityInfo.Result resultC = overridingUtil.D(aVar2, aVar, null).c();
        OverrideCompatibilityInfo.Result resultC2 = overridingUtil.D(aVar, aVar2, null).c();
        OverrideCompatibilityInfo.Result result = OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (resultC == result && resultC2 == result) {
            return result;
        }
        OverrideCompatibilityInfo.Result result2 = OverrideCompatibilityInfo.Result.CONFLICT;
        return (resultC == result2 || resultC2 == result2) ? result2 : OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    }

    public static Modality y(Collection<CallableMemberDescriptor> collection, boolean z10, Modality modality) {
        if (collection == null) {
            a(91);
        }
        if (modality == null) {
            a(92);
        }
        Modality modality2 = Modality.ABSTRACT;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            Modality modalityP = (z10 && callableMemberDescriptor.p() == Modality.ABSTRACT) ? modality : callableMemberDescriptor.p();
            if (modalityP.compareTo(modality2) < 0) {
                modality2 = modalityP;
            }
        }
        if (modality2 == null) {
            a(93);
        }
        return modality2;
    }

    public static Set<CallableMemberDescriptor> z(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(15);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    public OverrideCompatibilityInfo D(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, InterfaceC0797b interfaceC0797b) {
        if (aVar == null) {
            a(19);
        }
        if (aVar2 == null) {
            a(20);
        }
        OverrideCompatibilityInfo overrideCompatibilityInfoE = E(aVar, aVar2, interfaceC0797b, false);
        if (overrideCompatibilityInfoE == null) {
            a(21);
        }
        return overrideCompatibilityInfoE;
    }

    public OverrideCompatibilityInfo E(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, InterfaceC0797b interfaceC0797b, boolean z10) {
        if (aVar == null) {
            a(22);
        }
        if (aVar2 == null) {
            a(23);
        }
        OverrideCompatibilityInfo overrideCompatibilityInfoF = F(aVar, aVar2, z10);
        boolean z11 = overrideCompatibilityInfoF.c() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (ExternalOverridabilityCondition externalOverridabilityCondition : f35977e) {
            if (externalOverridabilityCondition.a() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!z11 || externalOverridabilityCondition.a() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                int i10 = h.f35991a[externalOverridabilityCondition.b(aVar, aVar2, interfaceC0797b).ordinal()];
                if (i10 == 1) {
                    z11 = true;
                } else if (i10 == 2) {
                    OverrideCompatibilityInfo overrideCompatibilityInfoD = OverrideCompatibilityInfo.d("External condition");
                    if (overrideCompatibilityInfoD == null) {
                        a(24);
                    }
                    return overrideCompatibilityInfoD;
                }
            }
        }
        if (!z11) {
            return overrideCompatibilityInfoF;
        }
        for (ExternalOverridabilityCondition externalOverridabilityCondition2 : f35977e) {
            if (externalOverridabilityCondition2.a() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                int i11 = h.f35991a[externalOverridabilityCondition2.b(aVar, aVar2, interfaceC0797b).ordinal()];
                if (i11 == 1) {
                    throw new IllegalStateException("Contract violation in " + externalOverridabilityCondition2.getClass().getName() + " condition. It's not supposed to end with success");
                }
                if (i11 == 2) {
                    OverrideCompatibilityInfo overrideCompatibilityInfoD2 = OverrideCompatibilityInfo.d("External condition");
                    if (overrideCompatibilityInfoD2 == null) {
                        a(26);
                    }
                    return overrideCompatibilityInfoD2;
                }
            }
        }
        OverrideCompatibilityInfo overrideCompatibilityInfoE = OverrideCompatibilityInfo.e();
        if (overrideCompatibilityInfoE == null) {
            a(27);
        }
        return overrideCompatibilityInfoE;
    }

    public OverrideCompatibilityInfo F(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, boolean z10) {
        if (aVar == null) {
            a(28);
        }
        if (aVar2 == null) {
            a(29);
        }
        OverrideCompatibilityInfo overrideCompatibilityInfoW = w(aVar, aVar2);
        if (overrideCompatibilityInfoW != null) {
            return overrideCompatibilityInfoW;
        }
        List<S> listG = g(aVar);
        List<S> listG2 = g(aVar2);
        List<b0> typeParameters = aVar.getTypeParameters();
        List<b0> typeParameters2 = aVar2.getTypeParameters();
        int i10 = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i10 < listG.size()) {
                if (!kotlin.reflect.jvm.internal.impl.types.checker.b.f36098a.c(listG.get(i10), listG2.get(i10))) {
                    OverrideCompatibilityInfo overrideCompatibilityInfoD = OverrideCompatibilityInfo.d("Type parameter number mismatch");
                    if (overrideCompatibilityInfoD == null) {
                        a(31);
                    }
                    return overrideCompatibilityInfoD;
                }
                i10++;
            }
            OverrideCompatibilityInfo overrideCompatibilityInfoB = OverrideCompatibilityInfo.b("Type parameter number mismatch");
            if (overrideCompatibilityInfoB == null) {
                a(32);
            }
            return overrideCompatibilityInfoB;
        }
        TypeCheckerState typeCheckerStateL = l(typeParameters, typeParameters2);
        for (int i11 = 0; i11 < typeParameters.size(); i11++) {
            if (!c(typeParameters.get(i11), typeParameters2.get(i11), typeCheckerStateL)) {
                OverrideCompatibilityInfo overrideCompatibilityInfoD2 = OverrideCompatibilityInfo.d("Type parameter bounds mismatch");
                if (overrideCompatibilityInfoD2 == null) {
                    a(33);
                }
                return overrideCompatibilityInfoD2;
            }
        }
        while (i10 < listG.size()) {
            if (!d(listG.get(i10), listG2.get(i10), typeCheckerStateL)) {
                OverrideCompatibilityInfo overrideCompatibilityInfoD3 = OverrideCompatibilityInfo.d("Value parameter type mismatch");
                if (overrideCompatibilityInfoD3 == null) {
                    a(34);
                }
                return overrideCompatibilityInfoD3;
            }
            i10++;
        }
        if ((aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && (aVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && ((kotlin.reflect.jvm.internal.impl.descriptors.e) aVar).isSuspend() != ((kotlin.reflect.jvm.internal.impl.descriptors.e) aVar2).isSuspend()) {
            OverrideCompatibilityInfo overrideCompatibilityInfoB2 = OverrideCompatibilityInfo.b("Incompatible suspendability");
            if (overrideCompatibilityInfoB2 == null) {
                a(35);
            }
            return overrideCompatibilityInfoB2;
        }
        if (z10) {
            S returnType = aVar.getReturnType();
            S returnType2 = aVar2.getReturnType();
            if (returnType != null && returnType2 != null && ((!W.a(returnType2) || !W.a(returnType)) && !kotlin.reflect.jvm.internal.impl.types.b.f36092a.u(typeCheckerStateL, returnType2.K0(), returnType.K0()))) {
                OverrideCompatibilityInfo overrideCompatibilityInfoB3 = OverrideCompatibilityInfo.b("Return type mismatch");
                if (overrideCompatibilityInfoB3 == null) {
                    a(36);
                }
                return overrideCompatibilityInfoB3;
            }
        }
        OverrideCompatibilityInfo overrideCompatibilityInfoE = OverrideCompatibilityInfo.e();
        if (overrideCompatibilityInfoE == null) {
            a(37);
        }
        return overrideCompatibilityInfoE;
    }

    public final TypeCheckerState l(List<b0> list, List<b0> list2) {
        if (list == null) {
            a(40);
        }
        if (list2 == null) {
            a(41);
        }
        if (list.isEmpty()) {
            TypeCheckerState typeCheckerStateM0 = new C4833m(null, this.f35982c, this.f35980a, this.f35981b, this.f35983d).M0(true, true, false);
            if (typeCheckerStateM0 == null) {
                a(42);
            }
            return typeCheckerStateM0;
        }
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < list.size(); i10++) {
            map.put(list.get(i10).j(), list2.get(i10).j());
        }
        TypeCheckerState typeCheckerStateM02 = new C4833m(map, this.f35982c, this.f35980a, this.f35981b, this.f35983d).M0(true, true, false);
        if (typeCheckerStateM02 == null) {
            a(43);
        }
        return typeCheckerStateM02;
    }

    public final Collection<CallableMemberDescriptor> o(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection, InterfaceC0797b interfaceC0797b, AbstractC4832l abstractC4832l) {
        if (callableMemberDescriptor == null) {
            a(57);
        }
        if (collection == null) {
            a(58);
        }
        if (interfaceC0797b == null) {
            a(59);
        }
        if (abstractC4832l == null) {
            a(60);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        k kVarC = k.c();
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            OverrideCompatibilityInfo.Result resultC = D(callableMemberDescriptor2, callableMemberDescriptor, interfaceC0797b).c();
            boolean zI = I(callableMemberDescriptor, callableMemberDescriptor2, false);
            int i10 = h.f35992b[resultC.ordinal()];
            if (i10 == 1) {
                if (zI) {
                    kVarC.add(callableMemberDescriptor2);
                }
                arrayList.add(callableMemberDescriptor2);
            } else if (i10 == 2) {
                if (zI) {
                    abstractC4832l.c(callableMemberDescriptor2, callableMemberDescriptor);
                }
                arrayList.add(callableMemberDescriptor2);
            }
        }
        abstractC4832l.d(callableMemberDescriptor, kVarC);
        return arrayList;
    }

    public void v(ga.e eVar, Collection<? extends CallableMemberDescriptor> collection, Collection<? extends CallableMemberDescriptor> collection2, InterfaceC0797b interfaceC0797b, AbstractC4832l abstractC4832l) {
        if (eVar == null) {
            a(50);
        }
        if (collection == null) {
            a(51);
        }
        if (collection2 == null) {
            a(52);
        }
        if (interfaceC0797b == null) {
            a(53);
        }
        if (abstractC4832l == null) {
            a(54);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator<? extends CallableMemberDescriptor> it = collection2.iterator();
        while (it.hasNext()) {
            linkedHashSet.removeAll(o(it.next(), collection, interfaceC0797b, abstractC4832l));
        }
        k(interfaceC0797b, linkedHashSet, abstractC4832l);
    }
}
