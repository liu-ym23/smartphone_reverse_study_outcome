package kotlin.reflect.jvm.internal.impl.renderer;

import Aa.i;
import C9.j;
import C9.o;
import E9.AbstractC0811p;
import E9.C0810o;
import E9.D;
import E9.E;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0800e;
import E9.InterfaceC0803h;
import E9.InterfaceC0805j;
import E9.InterfaceC0806k;
import E9.InterfaceC0812q;
import E9.InterfaceC0816v;
import E9.InterfaceC0819y;
import E9.L;
import E9.N;
import E9.O;
import E9.P;
import E9.Q;
import E9.S;
import E9.a0;
import E9.b0;
import E9.f0;
import E9.i0;
import E9.j0;
import La.C0951a;
import La.H;
import La.K;
import Y8.h;
import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Z;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import ga.g;
import ja.l;
import ja.m;
import ja.n;
import ja.r;
import ja.s;
import ja.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ka.C4828h;
import kotlin.C4848b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.renderer.b;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import ma.AbstractC4927g;
import ma.C4921a;
import ma.C4922b;
import ma.s;
import p9.InterfaceC5074l;
import ya.AbstractC5974I;
import ya.AbstractC5990d0;
import ya.B0;
import ya.C5982Q;
import ya.C5983a;
import ya.C5998h0;
import ya.C6017x;
import ya.H0;
import ya.K0;
import ya.L0;
import ya.W;
import ya.m0;
import ya.v0;

/* loaded from: classes5.dex */
public final class DescriptorRendererImpl extends kotlin.reflect.jvm.internal.impl.renderer.b implements c {

    /* renamed from: m, reason: collision with root package name */
    public final d f35901m;

    /* renamed from: n, reason: collision with root package name */
    public final h f35902n;

    public final class a implements InterfaceC0805j<t, StringBuilder> {

        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0452a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f35904a;

            static {
                int[] iArr = new int[PropertyAccessorRenderingPolicy.values().length];
                try {
                    iArr[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f35904a = iArr;
            }
        }

        public a() {
        }

        public void A(i0 descriptor, StringBuilder builder) {
            p.i(descriptor, "descriptor");
            p.i(builder, "builder");
            DescriptorRendererImpl.this.G2(descriptor, true, builder, true);
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t a(InterfaceC0797b interfaceC0797b, StringBuilder sb2) throws IOException {
            n(interfaceC0797b, sb2);
            return t.f7040a;
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t b(InterfaceC0819y interfaceC0819y, StringBuilder sb2) {
            q(interfaceC0819y, sb2);
            return t.f7040a;
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t c(a0 a0Var, StringBuilder sb2) {
            y(a0Var, sb2);
            return t.f7040a;
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t d(S s10, StringBuilder sb2) {
            x(s10, sb2);
            return t.f7040a;
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t e(b0 b0Var, StringBuilder sb2) {
            z(b0Var, sb2);
            return t.f7040a;
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t f(L l10, StringBuilder sb2) {
            s(l10, sb2);
            return t.f7040a;
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t g(E e10, StringBuilder sb2) {
            r(e10, sb2);
            return t.f7040a;
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t h(O o10, StringBuilder sb2) throws IOException {
            u(o10, sb2);
            return t.f7040a;
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t i(e eVar, StringBuilder sb2) throws IOException {
            p(eVar, sb2);
            return t.f7040a;
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t j(Q q10, StringBuilder sb2) throws IOException {
            w(q10, sb2);
            return t.f7040a;
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t k(kotlin.reflect.jvm.internal.impl.descriptors.c cVar, StringBuilder sb2) throws IOException {
            o(cVar, sb2);
            return t.f7040a;
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t l(i0 i0Var, StringBuilder sb2) {
            A(i0Var, sb2);
            return t.f7040a;
        }

        @Override // E9.InterfaceC0805j
        public /* bridge */ /* synthetic */ t m(P p10, StringBuilder sb2) throws IOException {
            v(p10, sb2);
            return t.f7040a;
        }

        public void n(InterfaceC0797b descriptor, StringBuilder builder) throws IOException {
            p.i(descriptor, "descriptor");
            p.i(builder, "builder");
            DescriptorRendererImpl.this.F1(descriptor, builder);
        }

        public void o(kotlin.reflect.jvm.internal.impl.descriptors.c constructorDescriptor, StringBuilder builder) throws IOException {
            p.i(constructorDescriptor, "constructorDescriptor");
            p.i(builder, "builder");
            DescriptorRendererImpl.this.K1(constructorDescriptor, builder);
        }

        public void p(e descriptor, StringBuilder builder) throws IOException {
            p.i(descriptor, "descriptor");
            p.i(builder, "builder");
            DescriptorRendererImpl.this.U1(descriptor, builder);
        }

        public void q(InterfaceC0819y descriptor, StringBuilder builder) {
            p.i(descriptor, "descriptor");
            p.i(builder, "builder");
            DescriptorRendererImpl.this.e2(descriptor, builder, true);
        }

        public void r(E descriptor, StringBuilder builder) {
            p.i(descriptor, "descriptor");
            p.i(builder, "builder");
            DescriptorRendererImpl.this.i2(descriptor, builder);
        }

        public void s(L descriptor, StringBuilder builder) {
            p.i(descriptor, "descriptor");
            p.i(builder, "builder");
            DescriptorRendererImpl.this.k2(descriptor, builder);
        }

        public final void t(f fVar, StringBuilder sb2, String str) throws IOException {
            int i10 = C0452a.f35904a[DescriptorRendererImpl.this.S0().ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    p(fVar, sb2);
                    return;
                } else {
                    if (i10 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return;
                }
            }
            DescriptorRendererImpl.this.z1(fVar, sb2);
            sb2.append(str + " for ");
            DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
            O oQ = fVar.Q();
            p.h(oQ, "getCorrespondingProperty(...)");
            descriptorRendererImpl.m2(oQ, sb2);
        }

        public void u(O descriptor, StringBuilder builder) throws IOException {
            p.i(descriptor, "descriptor");
            p.i(builder, "builder");
            DescriptorRendererImpl.this.m2(descriptor, builder);
        }

        public void v(P descriptor, StringBuilder builder) throws IOException {
            p.i(descriptor, "descriptor");
            p.i(builder, "builder");
            t(descriptor, builder, "getter");
        }

        public void w(Q descriptor, StringBuilder builder) throws IOException {
            p.i(descriptor, "descriptor");
            p.i(builder, "builder");
            t(descriptor, builder, "setter");
        }

        public void x(S descriptor, StringBuilder builder) {
            p.i(descriptor, "descriptor");
            p.i(builder, "builder");
            builder.append(descriptor.getName());
        }

        public void y(a0 descriptor, StringBuilder builder) {
            p.i(descriptor, "descriptor");
            p.i(builder, "builder");
            DescriptorRendererImpl.this.v2(descriptor, builder);
        }

        public void z(b0 descriptor, StringBuilder builder) {
            p.i(descriptor, "descriptor");
            p.i(builder, "builder");
            DescriptorRendererImpl.this.B2(descriptor, builder, true);
        }
    }

    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35905a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f35906b;

        static {
            int[] iArr = new int[RenderingFormat.values().length];
            try {
                iArr[RenderingFormat.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenderingFormat.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f35905a = iArr;
            int[] iArr2 = new int[ParameterNameRenderingPolicy.values().length];
            try {
                iArr2[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f35906b = iArr2;
        }
    }

    public DescriptorRendererImpl(d options) {
        p.i(options, "options");
        this.f35901m = options;
        options.p0();
        this.f35902n = C4848b.b(new l(this));
    }

    public static /* synthetic */ void A2(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb2, ya.S s10, v0 v0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            v0Var = s10.H0();
        }
        descriptorRendererImpl.z2(sb2, s10, v0Var);
    }

    public static /* synthetic */ void D1(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb2, F9.a aVar, AnnotationUseSiteTarget annotationUseSiteTarget, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        descriptorRendererImpl.C1(sb2, aVar, annotationUseSiteTarget);
    }

    public static /* synthetic */ void F2(DescriptorRendererImpl descriptorRendererImpl, j0 j0Var, StringBuilder sb2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        descriptorRendererImpl.E2(j0Var, sb2, z10);
    }

    public static final CharSequence L1(i0 i0Var) {
        return "";
    }

    public static final String Q1(DescriptorRendererImpl descriptorRendererImpl, j jVar) {
        kotlin.reflect.jvm.internal.impl.renderer.a aVarB0 = descriptorRendererImpl.B0();
        InterfaceC0797b interfaceC0797bX = jVar.x();
        p.h(interfaceC0797bX, "getCollection(...)");
        return H.x1(aVarB0.a(interfaceC0797bX, descriptorRendererImpl), CoreUtil.STR_DEX_COLLECTION_NAME, null, 2, null);
    }

    public static final String R1(DescriptorRendererImpl descriptorRendererImpl, j jVar) {
        kotlin.reflect.jvm.internal.impl.renderer.a aVarB0 = descriptorRendererImpl.B0();
        InterfaceC0797b interfaceC0797bJ = jVar.j();
        p.h(interfaceC0797bJ, "getArray(...)");
        return H.x1(aVarB0.a(interfaceC0797bJ, descriptorRendererImpl), "Array", null, 2, null);
    }

    public static final CharSequence r0(DescriptorRendererImpl descriptorRendererImpl, B0 it) {
        p.i(it, "it");
        if (it.b()) {
            return "*";
        }
        ya.S type = it.getType();
        p.h(type, "getType(...)");
        String strS = descriptorRendererImpl.S(type);
        if (it.c() == Variance.INVARIANT) {
            return strS;
        }
        return it.c() + ' ' + strS;
    }

    public static final CharSequence t2(DescriptorRendererImpl descriptorRendererImpl, ya.S s10) {
        p.f(s10);
        return descriptorRendererImpl.S(s10);
    }

    public static final DescriptorRendererImpl u0(DescriptorRendererImpl descriptorRendererImpl) {
        kotlin.reflect.jvm.internal.impl.renderer.b bVarU = descriptorRendererImpl.U(s.f34557a);
        p.g(bVarU, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        return (DescriptorRendererImpl) bVarU;
    }

    public static final t v0(c withOptions) {
        p.i(withOptions, "$this$withOptions");
        withOptions.k(Z.o(withOptions.h(), C1173v.p(o.a.f1850C, o.a.f1852D)));
        return t.f7040a;
    }

    public static final Object y2(ya.S it) {
        p.i(it, "it");
        return it instanceof m0 ? ((m0) it).Q0() : it;
    }

    public boolean A0() {
        return this.f35901m.y();
    }

    public final void A1(e eVar, StringBuilder sb2) {
        boolean z10;
        boolean z11 = false;
        if (eVar.isOperator()) {
            Collection<? extends e> collectionD = eVar.d();
            p.h(collectionD, "getOverriddenDescriptors(...)");
            Collection<? extends e> collection = collectionD;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((e) it.next()).isOperator()) {
                        if (x0()) {
                            break;
                        }
                    }
                }
                z10 = false;
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (eVar.isInfix()) {
            Collection<? extends e> collectionD2 = eVar.d();
            p.h(collectionD2, "getOverriddenDescriptors(...)");
            Collection<? extends e> collection2 = collectionD2;
            if (collection2.isEmpty()) {
                z11 = true;
            } else {
                Iterator<T> it2 = collection2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (((e) it2.next()).isInfix()) {
                        if (x0()) {
                            break;
                        }
                    }
                }
            }
        }
        d2(sb2, eVar.A(), "tailrec");
        u2(eVar, sb2);
        d2(sb2, eVar.isInline(), "inline");
        d2(sb2, z11, "infix");
        d2(sb2, z10, Parameters.OPERATOR);
    }

    public kotlin.reflect.jvm.internal.impl.renderer.a B0() {
        return this.f35901m.z();
    }

    public final List<String> B1(F9.c cVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.b bVarB;
        List<i0> listI;
        Map<ga.e, AbstractC4927g<?>> mapA = cVar.a();
        List listM = null;
        InterfaceC0797b interfaceC0797bL = Y0() ? DescriptorUtilsKt.l(cVar) : null;
        if (interfaceC0797bL != null && (bVarB = interfaceC0797bL.B()) != null && (listI = bVarB.i()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listI) {
                if (((i0) obj).v0()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((i0) it.next()).getName());
            }
            listM = arrayList2;
        }
        if (listM == null) {
            listM = C1173v.m();
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listM) {
            if (!mapA.containsKey((ga.e) obj2)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(C1174w.x(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((ga.e) it2.next()).b() + " = ...");
        }
        Set<Map.Entry<ga.e, AbstractC4927g<?>>> setEntrySet = mapA.entrySet();
        ArrayList arrayList5 = new ArrayList(C1174w.x(setEntrySet, 10));
        Iterator<T> it3 = setEntrySet.iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            ga.e eVar = (ga.e) entry.getKey();
            AbstractC4927g<?> abstractC4927g = (AbstractC4927g) entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(eVar.b());
            sb2.append(" = ");
            sb2.append(!listM.contains(eVar) ? J1(abstractC4927g) : "...");
            arrayList5.add(sb2.toString());
        }
        return F.b1(F.S0(arrayList4, arrayList5));
    }

    public final void B2(b0 b0Var, StringBuilder sb2, boolean z10) {
        if (z10) {
            sb2.append(w1());
        }
        if (m1()) {
            sb2.append("/*");
            sb2.append(b0Var.getIndex());
            sb2.append("*/ ");
        }
        d2(sb2, b0Var.w(), "reified");
        String label = b0Var.l().getLabel();
        boolean z11 = true;
        d2(sb2, label.length() > 0, label);
        D1(this, sb2, b0Var, null, 2, null);
        e2(b0Var, sb2, z10);
        int size = b0Var.getUpperBounds().size();
        if ((size > 1 && !z10) || size == 1) {
            ya.S next = b0Var.getUpperBounds().iterator().next();
            if (!j.k0(next)) {
                sb2.append(" : ");
                p.f(next);
                sb2.append(S(next));
            }
        } else if (z10) {
            for (ya.S s10 : b0Var.getUpperBounds()) {
                if (!j.k0(s10)) {
                    if (z11) {
                        sb2.append(" : ");
                    } else {
                        sb2.append(" & ");
                    }
                    p.f(s10);
                    sb2.append(S(s10));
                    z11 = false;
                }
            }
        }
        if (z10) {
            sb2.append(s1());
        }
    }

    public InterfaceC5074l<i0, String> C0() {
        return this.f35901m.A();
    }

    public final void C1(StringBuilder sb2, F9.a aVar, AnnotationUseSiteTarget annotationUseSiteTarget) {
        if (L0().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            Set<ga.c> setH = aVar instanceof ya.S ? h() : E0();
            InterfaceC5074l<F9.c, Boolean> interfaceC5074lY0 = y0();
            for (F9.c cVar : aVar.getAnnotations()) {
                if (!F.f0(setH, cVar.f()) && !v1(cVar) && (interfaceC5074lY0 == null || interfaceC5074lY0.invoke(cVar).booleanValue())) {
                    sb2.append(N(cVar, annotationUseSiteTarget));
                    if (D0()) {
                        sb2.append('\n');
                    } else {
                        sb2.append(" ");
                    }
                }
            }
        }
    }

    public final void C2(StringBuilder sb2, List<? extends b0> list) {
        Iterator<? extends b0> it = list.iterator();
        while (it.hasNext()) {
            B2(it.next(), sb2, false);
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
    }

    public boolean D0() {
        return this.f35901m.B();
    }

    public final void D2(List<? extends b0> list, StringBuilder sb2, boolean z10) {
        if (r1() || list.isEmpty()) {
            return;
        }
        sb2.append(w1());
        C2(sb2, list);
        sb2.append(s1());
        if (z10) {
            sb2.append(" ");
        }
    }

    public Set<ga.c> E0() {
        return this.f35901m.C();
    }

    public final void E1(InterfaceC0800e interfaceC0800e, StringBuilder sb2) {
        List<b0> listO = interfaceC0800e.o();
        p.h(listO, "getDeclaredTypeParameters(...)");
        List<b0> parameters = interfaceC0800e.j().getParameters();
        p.h(parameters, "getParameters(...)");
        if (m1() && interfaceC0800e.x() && parameters.size() > listO.size()) {
            sb2.append(" /*captured type parameters: ");
            C2(sb2, parameters.subList(listO.size(), parameters.size()));
            sb2.append("*/");
        }
    }

    public final void E2(j0 j0Var, StringBuilder sb2, boolean z10) {
        if (z10 || !(j0Var instanceof i0)) {
            sb2.append(X1(j0Var.J() ? "var" : "val"));
            sb2.append(" ");
        }
    }

    public final DescriptorRendererImpl F0() {
        return (DescriptorRendererImpl) this.f35902n.getValue();
    }

    public final void F1(InterfaceC0797b interfaceC0797b, StringBuilder sb2) throws IOException {
        kotlin.reflect.jvm.internal.impl.descriptors.b bVarB;
        boolean z10 = interfaceC0797b.getKind() == ClassKind.ENUM_ENTRY;
        if (!g1()) {
            List<S> listV = interfaceC0797b.V();
            p.h(listV, "getContextReceivers(...)");
            M1(listV, sb2);
            D1(this, sb2, interfaceC0797b, null, 2, null);
            if (!z10) {
                AbstractC0811p visibility = interfaceC0797b.getVisibility();
                p.h(visibility, "getVisibility(...)");
                J2(visibility, sb2);
            }
            if ((interfaceC0797b.getKind() != ClassKind.INTERFACE || interfaceC0797b.p() != Modality.ABSTRACT) && (!interfaceC0797b.getKind().isSingleton() || interfaceC0797b.p() != Modality.FINAL)) {
                Modality modalityP = interfaceC0797b.p();
                p.h(modalityP, "getModality(...)");
                b2(modalityP, sb2, u1(interfaceC0797b));
            }
            Z1(interfaceC0797b, sb2);
            d2(sb2, L0().contains(DescriptorRendererModifier.INNER) && interfaceC0797b.x(), "inner");
            d2(sb2, L0().contains(DescriptorRendererModifier.DATA) && interfaceC0797b.C0(), "data");
            d2(sb2, L0().contains(DescriptorRendererModifier.INLINE) && interfaceC0797b.isInline(), "inline");
            d2(sb2, L0().contains(DescriptorRendererModifier.VALUE) && interfaceC0797b.q(), UxipConstants.f30680s);
            d2(sb2, L0().contains(DescriptorRendererModifier.FUN) && interfaceC0797b.Z(), "fun");
            G1(interfaceC0797b, sb2);
        }
        if (C4828h.x(interfaceC0797b)) {
            I1(interfaceC0797b, sb2);
        } else {
            if (!g1()) {
                r2(sb2);
            }
            e2(interfaceC0797b, sb2, true);
        }
        if (z10) {
            return;
        }
        List<b0> listO = interfaceC0797b.o();
        p.h(listO, "getDeclaredTypeParameters(...)");
        D2(listO, sb2, false);
        E1(interfaceC0797b, sb2);
        if (!interfaceC0797b.getKind().isSingleton() && A0() && (bVarB = interfaceC0797b.B()) != null) {
            sb2.append(" ");
            D1(this, sb2, bVarB, null, 2, null);
            AbstractC0811p visibility2 = bVarB.getVisibility();
            p.h(visibility2, "getVisibility(...)");
            J2(visibility2, sb2);
            sb2.append(X1("constructor"));
            List<i0> listI = bVarB.i();
            p.h(listI, "getValueParameters(...)");
            H2(listI, bVarB.b0(), sb2);
        }
        s2(interfaceC0797b, sb2);
        K2(listO, sb2);
    }

    public boolean G0() {
        return this.f35901m.D();
    }

    public final void G1(InterfaceC0797b interfaceC0797b, StringBuilder sb2) {
        sb2.append(X1(kotlin.reflect.jvm.internal.impl.renderer.b.f35910a.a(interfaceC0797b)));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G2(E9.i0 r9, boolean r10, java.lang.StringBuilder r11, boolean r12) {
        /*
            r8 = this;
            if (r12 == 0) goto L10
            java.lang.String r2 = "value-parameter"
            java.lang.String r2 = r8.X1(r2)
            r11.append(r2)
            java.lang.String r2 = " "
            r11.append(r2)
        L10:
            boolean r2 = r8.m1()
            if (r2 == 0) goto L27
            java.lang.String r2 = "/*"
            r11.append(r2)
            int r2 = r9.getIndex()
            r11.append(r2)
        */
        //  java.lang.String r2 = "*/ "
        /*
            r11.append(r2)
        L27:
            r4 = 2
            r5 = 0
            r3 = 0
            r0 = r8
            r2 = r9
            r1 = r11
            D1(r0, r1, r2, r3, r4, r5)
            boolean r2 = r9.l0()
            java.lang.String r3 = "crossinline"
            r8.d2(r11, r2, r3)
            boolean r2 = r9.j0()
            java.lang.String r3 = "noinline"
            r8.d2(r11, r2, r3)
            boolean r2 = r8.b1()
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L60
            kotlin.reflect.jvm.internal.impl.descriptors.a r2 = r9.b()
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.b
            if (r3 == 0) goto L55
            kotlin.reflect.jvm.internal.impl.descriptors.b r2 = (kotlin.reflect.jvm.internal.impl.descriptors.b) r2
            goto L56
        L55:
            r2 = 0
        L56:
            if (r2 == 0) goto L60
            boolean r2 = r2.X()
            if (r2 != r7) goto L60
            r5 = r7
            goto L61
        L60:
            r5 = r6
        L61:
            if (r5 == 0) goto L6c
            boolean r2 = r8.w0()
            java.lang.String r3 = "actual"
            r8.d2(r11, r2, r3)
        L6c:
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r0.I2(r1, r2, r3, r4, r5)
            p9.l r0 = r8.C0()
            if (r0 == 0) goto L8c
            boolean r0 = r8.i()
            if (r0 == 0) goto L85
            boolean r0 = r9.v0()
            goto L89
        L85:
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.f(r9)
        L89:
            if (r0 == 0) goto L8c
            r6 = r7
        L8c:
            if (r6 == 0) goto Laf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = " = "
            r0.append(r2)
            p9.l r2 = r8.C0()
            kotlin.jvm.internal.p.f(r2)
            java.lang.Object r2 = r2.invoke(r9)
            java.lang.String r2 = (java.lang.String) r2
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r11.append(r0)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.G2(E9.i0, boolean, java.lang.StringBuilder, boolean):void");
    }

    public boolean H0() {
        return this.f35901m.E();
    }

    public String H1(InterfaceC0799d klass) {
        p.i(klass, "klass");
        return i.m(klass) ? klass.j().toString() : B0().a(klass, this);
    }

    public final void H2(Collection<? extends i0> collection, boolean z10, StringBuilder sb2) {
        boolean zM2 = M2(z10);
        int size = collection.size();
        l1().a(size, sb2);
        int i10 = 0;
        for (i0 i0Var : collection) {
            l1().d(i0Var, i10, size, sb2);
            G2(i0Var, zM2, sb2, false);
            l1().b(i0Var, i10, size, sb2);
            i10++;
        }
        l1().c(size, sb2);
    }

    public boolean I0() {
        return this.f35901m.F();
    }

    public final void I1(InterfaceC0803h interfaceC0803h, StringBuilder sb2) {
        if (V0()) {
            if (g1()) {
                sb2.append("companion object");
            }
            r2(sb2);
            InterfaceC0803h interfaceC0803hB = interfaceC0803h.b();
            if (interfaceC0803hB != null) {
                sb2.append("of ");
                ga.e name = interfaceC0803hB.getName();
                p.h(name, "getName(...)");
                sb2.append(R(name, false));
            }
        }
        if (m1() || !p.d(interfaceC0803h.getName(), g.f32744d)) {
            if (!g1()) {
                r2(sb2);
            }
            ga.e name2 = interfaceC0803h.getName();
            p.h(name2, "getName(...)");
            sb2.append(R(name2, true));
        }
    }

    public final void I2(j0 j0Var, boolean z10, StringBuilder sb2, boolean z11, boolean z12) {
        ya.S type = j0Var.getType();
        p.h(type, "getType(...)");
        i0 i0Var = j0Var instanceof i0 ? (i0) j0Var : null;
        ya.S sP0 = i0Var != null ? i0Var.p0() : null;
        ya.S s10 = sP0 == null ? type : sP0;
        d2(sb2, sP0 != null, "vararg");
        if (z12 || (z11 && !g1())) {
            E2(j0Var, sb2, z12);
        }
        if (z10) {
            e2(j0Var, sb2, z11);
            sb2.append(": ");
        }
        sb2.append(S(s10));
        W1(j0Var, sb2);
        if (!m1() || sP0 == null) {
            return;
        }
        sb2.append(" /*");
        sb2.append(S(type));
        sb2.append("*/");
    }

    public boolean J0() {
        return this.f35901m.G();
    }

    public final String J1(AbstractC4927g<?> abstractC4927g) {
        InterfaceC5074l<AbstractC4927g<?>, String> interfaceC5074lP = this.f35901m.P();
        if (interfaceC5074lP != null) {
            return interfaceC5074lP.invoke(abstractC4927g);
        }
        if (abstractC4927g instanceof C4922b) {
            List<? extends AbstractC4927g<?>> listB = ((C4922b) abstractC4927g).b();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                String strJ1 = J1((AbstractC4927g) it.next());
                if (strJ1 != null) {
                    arrayList.add(strJ1);
                }
            }
            return F.A0(arrayList, ", ", Const.STR_MART_JSON_BEGIN, "}", 0, null, null, 56, null);
        }
        if (abstractC4927g instanceof C4921a) {
            return H.R0(kotlin.reflect.jvm.internal.impl.renderer.b.O(this, ((C4921a) abstractC4927g).b(), null, 2, null), "@");
        }
        if (!(abstractC4927g instanceof ma.s)) {
            return abstractC4927g.toString();
        }
        s.b bVarB = ((ma.s) abstractC4927g).b();
        if (bVarB instanceof s.b.a) {
            return ((s.b.a) bVarB).a() + "::class";
        }
        if (!(bVarB instanceof s.b.C0474b)) {
            throw new NoWhenBranchMatchedException();
        }
        s.b.C0474b c0474b = (s.b.C0474b) bVarB;
        String strA = c0474b.b().a().a();
        for (int i10 = 0; i10 < c0474b.a(); i10++) {
            strA = "kotlin.Array<" + strA + '>';
        }
        return strA + "::class";
    }

    public final boolean J2(AbstractC0811p abstractC0811p, StringBuilder sb2) {
        if (!L0().contains(DescriptorRendererModifier.VISIBILITY)) {
            return false;
        }
        if (M0()) {
            abstractC0811p = abstractC0811p.f();
        }
        if (!a1() && p.d(abstractC0811p, C0810o.f2480l)) {
            return false;
        }
        sb2.append(X1(abstractC0811p.c()));
        sb2.append(" ");
        return true;
    }

    public boolean K0() {
        return this.f35901m.H();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K1(kotlin.reflect.jvm.internal.impl.descriptors.c r18, java.lang.StringBuilder r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.K1(kotlin.reflect.jvm.internal.impl.descriptors.c, java.lang.StringBuilder):void");
    }

    public final void K2(List<? extends b0> list, StringBuilder sb2) throws IOException {
        if (r1()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (b0 b0Var : list) {
            List<ya.S> upperBounds = b0Var.getUpperBounds();
            p.h(upperBounds, "getUpperBounds(...)");
            for (ya.S s10 : F.h0(upperBounds, 1)) {
                StringBuilder sb3 = new StringBuilder();
                ga.e name = b0Var.getName();
                p.h(name, "getName(...)");
                sb3.append(R(name, false));
                sb3.append(" : ");
                p.f(s10);
                sb3.append(S(s10));
                arrayList.add(sb3.toString());
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        sb2.append(" ");
        sb2.append(X1("where"));
        sb2.append(" ");
        F.x0(arrayList, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
    }

    public Set<DescriptorRendererModifier> L0() {
        return this.f35901m.I();
    }

    public final boolean L2(ya.S s10) {
        if (!C9.i.p(s10)) {
            return false;
        }
        List<B0> listF0 = s10.F0();
        if ((listF0 instanceof Collection) && listF0.isEmpty()) {
            return true;
        }
        Iterator<T> it = listF0.iterator();
        while (it.hasNext()) {
            if (((B0) it.next()).b()) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    public String M(InterfaceC0803h declarationDescriptor) {
        p.i(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb2 = new StringBuilder();
        declarationDescriptor.v(new a(), sb2);
        if (n1()) {
            p0(sb2, declarationDescriptor);
        }
        return sb2.toString();
    }

    public boolean M0() {
        return this.f35901m.J();
    }

    public final void M1(List<? extends S> list, StringBuilder sb2) {
        if (list.isEmpty()) {
            return;
        }
        sb2.append("context(");
        int i10 = 0;
        for (S s10 : list) {
            int i11 = i10 + 1;
            C1(sb2, s10, AnnotationUseSiteTarget.RECEIVER);
            ya.S type = s10.getType();
            p.h(type, "getType(...)");
            sb2.append(S1(type));
            if (i10 == C1173v.o(list)) {
                sb2.append(") ");
            } else {
                sb2.append(", ");
            }
            i10 = i11;
        }
    }

    public final boolean M2(boolean z10) {
        int i10 = b.f35906b[P0().ordinal()];
        if (i10 == 1) {
            return true;
        }
        if (i10 == 2) {
            return !z10;
        }
        if (i10 == 3) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    public String N(F9.c annotation, AnnotationUseSiteTarget annotationUseSiteTarget) throws IOException {
        p.i(annotation, "annotation");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('@');
        if (annotationUseSiteTarget != null) {
            sb2.append(annotationUseSiteTarget.getRenderName() + ':');
        }
        ya.S type = annotation.getType();
        sb2.append(S(type));
        if (H0()) {
            List<String> listB1 = B1(annotation);
            if (I0() || !listB1.isEmpty()) {
                F.x0(listB1, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
            }
        }
        if (m1() && (W.a(type) || (type.H0().d() instanceof D.b))) {
            sb2.append(" /* annotation class not found */");
        }
        return sb2.toString();
    }

    public final d N0() {
        return this.f35901m;
    }

    public final void N1(StringBuilder sb2, ya.S s10) {
        D1(this, sb2, s10, null, 2, null);
        C6017x c6017x = s10 instanceof C6017x ? (C6017x) s10 : null;
        AbstractC5990d0 abstractC5990d0T0 = c6017x != null ? c6017x.T0() : null;
        if (W.a(s10)) {
            if (Da.d.z(s10) && R0()) {
                sb2.append(O1(i.f1351a.p(s10)));
            } else {
                if (!(s10 instanceof Aa.g) || K0()) {
                    sb2.append(s10.H0().toString());
                } else {
                    sb2.append(((Aa.g) s10).Q0());
                }
                sb2.append(w2(s10.F0()));
            }
        } else if (s10 instanceof m0) {
            sb2.append(((m0) s10).Q0().toString());
        } else if (abstractC5990d0T0 instanceof m0) {
            sb2.append(((m0) abstractC5990d0T0).Q0().toString());
        } else {
            A2(this, sb2, s10, null, 2, null);
            t tVar = t.f7040a;
        }
        if (s10.I0()) {
            sb2.append("?");
        }
        if (C5998h0.c(s10)) {
            sb2.append(" & Any");
        }
    }

    public OverrideRenderingPolicy O0() {
        return this.f35901m.K();
    }

    public final String O1(String str) {
        int i10 = b.f35905a[h1().ordinal()];
        if (i10 == 1) {
            return str;
        }
        if (i10 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return "<font color=red><b>" + str + "</b></font>";
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    public String P(String lowerRendered, String upperRendered, j builtIns) {
        p.i(lowerRendered, "lowerRendered");
        p.i(upperRendered, "upperRendered");
        p.i(builtIns, "builtIns");
        if (y.j(lowerRendered, upperRendered)) {
            if (!La.D.X(upperRendered, "(", false, 2, null)) {
                return lowerRendered + '!';
            }
            return '(' + lowerRendered + ")!";
        }
        String strD = y.d(lowerRendered, upperRendered, new m(this, builtIns), new n(this, builtIns), new DescriptorRendererImpl$renderFlexibleType$3(this));
        if (strD != null) {
            return strD;
        }
        return '(' + lowerRendered + ".." + upperRendered + ')';
    }

    public ParameterNameRenderingPolicy P0() {
        return this.f35901m.L();
    }

    public final void P1(StringBuilder sb2, C5983a c5983a) {
        RenderingFormat renderingFormatH1 = h1();
        RenderingFormat renderingFormat = RenderingFormat.HTML;
        if (renderingFormatH1 == renderingFormat) {
            sb2.append("<font color=\"808080\"><i>");
        }
        sb2.append(" /* ");
        sb2.append("= ");
        g2(sb2, c5983a.E());
        sb2.append(" */");
        if (h1() == renderingFormat) {
            sb2.append("</i></font>");
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    public String Q(ga.d fqName) {
        p.i(fqName, "fqName");
        return T1(fqName.h());
    }

    public boolean Q0() {
        return this.f35901m.M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    public String R(ga.e name, boolean z10) {
        p.i(name, "name");
        String strT0 = t0(y.c(name));
        if (!z0() || h1() != RenderingFormat.HTML || !z10) {
            return strT0;
        }
        return "<b>" + strT0 + "</b>";
    }

    public boolean R0() {
        return this.f35901m.N();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    public String S(ya.S type) {
        p.i(type, "type");
        StringBuilder sb2 = new StringBuilder();
        f2(sb2, i1().invoke(type));
        return sb2.toString();
    }

    public PropertyAccessorRenderingPolicy S0() {
        return this.f35901m.O();
    }

    public final String S1(ya.S s10) {
        String strS = S(s10);
        if ((!L2(s10) || H0.l(s10)) && !(s10 instanceof C6017x)) {
            return strS;
        }
        return '(' + strS + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    public String T(B0 typeProjection) throws IOException {
        p.i(typeProjection, "typeProjection");
        StringBuilder sb2 = new StringBuilder();
        q0(sb2, C1172u.e(typeProjection));
        return sb2.toString();
    }

    public boolean T0() {
        return this.f35901m.Q();
    }

    public final String T1(List<ga.e> list) {
        return t0(y.g(list));
    }

    public boolean U0() {
        return this.f35901m.R();
    }

    public final void U1(e eVar, StringBuilder sb2) throws IOException {
        DescriptorRendererImpl descriptorRendererImpl;
        e eVar2;
        StringBuilder sb3;
        if (g1()) {
            descriptorRendererImpl = this;
            eVar2 = eVar;
            sb3 = sb2;
        } else {
            if (f1()) {
                descriptorRendererImpl = this;
                eVar2 = eVar;
                sb3 = sb2;
            } else {
                List<S> listS0 = eVar.s0();
                p.h(listS0, "getContextReceiverParameters(...)");
                M1(listS0, sb2);
                descriptorRendererImpl = this;
                eVar2 = eVar;
                sb3 = sb2;
                D1(descriptorRendererImpl, sb3, eVar2, null, 2, null);
                AbstractC0811p visibility = eVar2.getVisibility();
                p.h(visibility, "getVisibility(...)");
                descriptorRendererImpl.J2(visibility, sb3);
                descriptorRendererImpl.c2(eVar2, sb3);
                if (descriptorRendererImpl.G0()) {
                    descriptorRendererImpl.Z1(eVar2, sb3);
                }
                descriptorRendererImpl.h2(eVar2, sb3);
                if (descriptorRendererImpl.G0()) {
                    descriptorRendererImpl.A1(eVar2, sb3);
                } else {
                    descriptorRendererImpl.u2(eVar2, sb3);
                }
                descriptorRendererImpl.Y1(eVar2, sb3);
                if (descriptorRendererImpl.m1()) {
                    if (eVar2.w0()) {
                        sb3.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (eVar2.z0()) {
                        sb3.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb3.append(descriptorRendererImpl.X1("fun"));
            sb3.append(" ");
            List<b0> typeParameters = eVar2.getTypeParameters();
            p.h(typeParameters, "getTypeParameters(...)");
            descriptorRendererImpl.D2(typeParameters, sb3, true);
            descriptorRendererImpl.o2(eVar2, sb3);
        }
        descriptorRendererImpl.e2(eVar2, sb3, true);
        List<i0> listI = eVar2.i();
        p.h(listI, "getValueParameters(...)");
        descriptorRendererImpl.H2(listI, eVar2.b0(), sb3);
        descriptorRendererImpl.p2(eVar2, sb3);
        ya.S returnType = eVar2.getReturnType();
        if (!descriptorRendererImpl.p1() && (descriptorRendererImpl.k1() || returnType == null || !j.D0(returnType))) {
            sb3.append(": ");
            sb3.append(returnType == null ? "[NULL]" : descriptorRendererImpl.S(returnType));
        }
        List<b0> typeParameters2 = eVar2.getTypeParameters();
        p.h(typeParameters2, "getTypeParameters(...)");
        descriptorRendererImpl.K2(typeParameters2, sb3);
    }

    public boolean V0() {
        return this.f35901m.S();
    }

    public final void V1(StringBuilder sb2, ya.S s10) {
        ga.e eVarD;
        int length = sb2.length();
        D1(F0(), sb2, s10, null, 2, null);
        boolean z10 = sb2.length() != length;
        ya.S sK = C9.i.k(s10);
        List<ya.S> listE = C9.i.e(s10);
        boolean zS = C9.i.s(s10);
        boolean zI0 = s10.I0();
        boolean z11 = zI0 || (z10 && sK != null);
        if (z11) {
            if (zS) {
                sb2.insert(length, '(');
            } else {
                if (z10) {
                    C0951a.c(K.P1(sb2));
                    if (sb2.charAt(H.n0(sb2) - 1) != ')') {
                        sb2.insert(H.n0(sb2), "()");
                    }
                }
                sb2.append("(");
            }
        }
        d2(sb2, zS, "suspend");
        if (!listE.isEmpty()) {
            sb2.append("context(");
            Iterator<ya.S> it = listE.subList(0, C1173v.o(listE)).iterator();
            while (it.hasNext()) {
                f2(sb2, it.next());
                sb2.append(", ");
            }
            f2(sb2, (ya.S) F.C0(listE));
            sb2.append(") ");
        }
        if (sK != null) {
            boolean z12 = (L2(sK) && !sK.I0()) || t1(sK) || (sK instanceof C6017x);
            if (z12) {
                sb2.append("(");
            }
            f2(sb2, sK);
            if (z12) {
                sb2.append(")");
            }
            sb2.append(".");
        }
        sb2.append("(");
        if (!C9.i.n(s10) || s10.F0().size() > 1) {
            int i10 = 0;
            for (B0 b02 : C9.i.m(s10)) {
                int i11 = i10 + 1;
                if (i10 > 0) {
                    sb2.append(", ");
                }
                if (Q0()) {
                    ya.S type = b02.getType();
                    p.h(type, "getType(...)");
                    eVarD = C9.i.d(type);
                } else {
                    eVarD = null;
                }
                if (eVarD != null) {
                    sb2.append(R(eVarD, false));
                    sb2.append(": ");
                }
                sb2.append(T(b02));
                i10 = i11;
            }
        } else {
            sb2.append("???");
        }
        sb2.append(") ");
        sb2.append(s0());
        sb2.append(" ");
        f2(sb2, C9.i.l(s10));
        if (z11) {
            sb2.append(")");
        }
        if (zI0) {
            sb2.append("?");
        }
    }

    public boolean W0() {
        return this.f35901m.T();
    }

    public final void W1(j0 j0Var, StringBuilder sb2) {
        AbstractC4927g<?> abstractC4927gI0;
        String strJ1;
        if (!J0() || (abstractC4927gI0 = j0Var.i0()) == null || (strJ1 = J1(abstractC4927gI0)) == null) {
            return;
        }
        sb2.append(" = ");
        sb2.append(t0(strJ1));
    }

    public boolean X0() {
        return this.f35901m.U();
    }

    public final String X1(String str) {
        int i10 = b.f35905a[h1().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (!z0()) {
                return "<b>" + str + "</b>";
            }
        }
        return str;
    }

    public boolean Y0() {
        return this.f35901m.V();
    }

    public final void Y1(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb2) {
        if (L0().contains(DescriptorRendererModifier.MEMBER_KIND) && m1() && callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.DECLARATION) {
            sb2.append("/*");
            sb2.append(Ga.a.f(callableMemberDescriptor.getKind().name()));
            sb2.append("*/ ");
        }
    }

    public boolean Z0() {
        return this.f35901m.W();
    }

    public final void Z1(InterfaceC0816v interfaceC0816v, StringBuilder sb2) {
        d2(sb2, interfaceC0816v.isExternal(), "external");
        boolean z10 = false;
        d2(sb2, L0().contains(DescriptorRendererModifier.EXPECT) && interfaceC0816v.e0(), "expect");
        if (L0().contains(DescriptorRendererModifier.ACTUAL) && interfaceC0816v.S()) {
            z10 = true;
        }
        d2(sb2, z10, "actual");
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void a(boolean z10) {
        this.f35901m.a(z10);
    }

    public boolean a1() {
        return this.f35901m.X();
    }

    public String a2(String message) {
        p.i(message, "message");
        int i10 = b.f35905a[h1().ordinal()];
        if (i10 == 1) {
            return message;
        }
        if (i10 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return "<i>" + message + "</i>";
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void b(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        p.i(parameterNameRenderingPolicy, "<set-?>");
        this.f35901m.b(parameterNameRenderingPolicy);
    }

    public boolean b1() {
        return this.f35901m.Y();
    }

    public final void b2(Modality modality, StringBuilder sb2, Modality modality2) {
        if (Z0() || modality != modality2) {
            d2(sb2, L0().contains(DescriptorRendererModifier.MODALITY), Ga.a.f(modality.name()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void c(boolean z10) {
        this.f35901m.c(z10);
    }

    public boolean c1() {
        return this.f35901m.Z();
    }

    public final void c2(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb2) {
        if (C4828h.J(callableMemberDescriptor) && callableMemberDescriptor.p() == Modality.FINAL) {
            return;
        }
        if (O0() == OverrideRenderingPolicy.RENDER_OVERRIDE && callableMemberDescriptor.p() == Modality.OPEN && x1(callableMemberDescriptor)) {
            return;
        }
        Modality modalityP = callableMemberDescriptor.p();
        p.h(modalityP, "getModality(...)");
        b2(modalityP, sb2, u1(callableMemberDescriptor));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public boolean d() {
        return this.f35901m.d();
    }

    public boolean d1() {
        return this.f35901m.a0();
    }

    public final void d2(StringBuilder sb2, boolean z10, String str) {
        if (z10) {
            sb2.append(X1(str));
            sb2.append(" ");
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void e(boolean z10) {
        this.f35901m.e(z10);
    }

    public boolean e1() {
        return this.f35901m.b0();
    }

    public final void e2(InterfaceC0803h interfaceC0803h, StringBuilder sb2, boolean z10) {
        ga.e name = interfaceC0803h.getName();
        p.h(name, "getName(...)");
        sb2.append(R(name, z10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void f(boolean z10) {
        this.f35901m.f(z10);
    }

    public boolean f1() {
        return this.f35901m.c0();
    }

    public final void f2(StringBuilder sb2, ya.S s10) {
        K0 K02 = s10.K0();
        C5983a c5983a = K02 instanceof C5983a ? (C5983a) K02 : null;
        if (c5983a == null) {
            g2(sb2, s10);
            return;
        }
        if (c1()) {
            g2(sb2, c5983a.E());
            if (U0()) {
                y1(sb2, c5983a);
                return;
            }
            return;
        }
        g2(sb2, c5983a.T0());
        if (d1()) {
            P1(sb2, c5983a);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void g(RenderingFormat renderingFormat) {
        p.i(renderingFormat, "<set-?>");
        this.f35901m.g(renderingFormat);
    }

    public boolean g1() {
        return this.f35901m.d0();
    }

    public final void g2(StringBuilder sb2, ya.S s10) {
        if ((s10 instanceof L0) && i() && !((L0) s10).M0()) {
            sb2.append("<Not computed yet>");
            return;
        }
        K0 K02 = s10.K0();
        if (K02 instanceof AbstractC5974I) {
            sb2.append(((AbstractC5974I) K02).R0(this, this));
        } else {
            if (!(K02 instanceof AbstractC5990d0)) {
                throw new NoWhenBranchMatchedException();
            }
            q2(sb2, (AbstractC5990d0) K02);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public Set<ga.c> h() {
        return this.f35901m.h();
    }

    public RenderingFormat h1() {
        return this.f35901m.e0();
    }

    public final void h2(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb2) {
        if (L0().contains(DescriptorRendererModifier.OVERRIDE) && x1(callableMemberDescriptor) && O0() != OverrideRenderingPolicy.RENDER_OPEN) {
            d2(sb2, true, "override");
            if (m1()) {
                sb2.append("/*");
                sb2.append(callableMemberDescriptor.d().size());
                sb2.append("*/ ");
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public boolean i() {
        return this.f35901m.i();
    }

    public InterfaceC5074l<ya.S, ya.S> i1() {
        return this.f35901m.f0();
    }

    public final void i2(E e10, StringBuilder sb2) {
        j2(e10.f(), "package-fragment", sb2);
        if (i()) {
            sb2.append(" in ");
            e2(e10.b(), sb2, false);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public AnnotationArgumentsRenderingPolicy j() {
        return this.f35901m.j();
    }

    public boolean j1() {
        return this.f35901m.g0();
    }

    public final void j2(ga.c cVar, String str, StringBuilder sb2) {
        sb2.append(X1(str));
        String strQ = Q(cVar.i());
        if (strQ.length() > 0) {
            sb2.append(" ");
            sb2.append(strQ);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void k(Set<ga.c> set) {
        p.i(set, "<set-?>");
        this.f35901m.k(set);
    }

    public boolean k1() {
        return this.f35901m.h0();
    }

    public final void k2(L l10, StringBuilder sb2) {
        j2(l10.f(), "package", sb2);
        if (i()) {
            sb2.append(" in context of ");
            e2(l10.getModule(), sb2, false);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void l(Set<? extends DescriptorRendererModifier> set) {
        p.i(set, "<set-?>");
        this.f35901m.l(set);
    }

    public b.InterfaceC0455b l1() {
        return this.f35901m.i0();
    }

    public final void l2(StringBuilder sb2, N n10) {
        N nC = n10.c();
        if (nC != null) {
            l2(sb2, nC);
            sb2.append('.');
            ga.e name = n10.b().getName();
            p.h(name, "getName(...)");
            sb2.append(R(name, false));
        } else {
            v0 v0VarJ = n10.b().j();
            p.h(v0VarJ, "getTypeConstructor(...)");
            sb2.append(x2(v0VarJ));
        }
        sb2.append(w2(n10.a()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void m(kotlin.reflect.jvm.internal.impl.renderer.a aVar) {
        p.i(aVar, "<set-?>");
        this.f35901m.m(aVar);
    }

    public boolean m1() {
        return this.f35901m.j0();
    }

    public final void m2(O o10, StringBuilder sb2) throws IOException {
        DescriptorRendererImpl descriptorRendererImpl;
        O o11;
        StringBuilder sb3;
        if (g1()) {
            descriptorRendererImpl = this;
            o11 = o10;
            sb3 = sb2;
        } else {
            if (!f1()) {
                List<S> listS0 = o10.s0();
                p.h(listS0, "getContextReceiverParameters(...)");
                M1(listS0, sb2);
                n2(o10, sb2);
                AbstractC0811p visibility = o10.getVisibility();
                p.h(visibility, "getVisibility(...)");
                J2(visibility, sb2);
                boolean z10 = false;
                d2(sb2, L0().contains(DescriptorRendererModifier.CONST) && o10.isConst(), "const");
                Z1(o10, sb2);
                c2(o10, sb2);
                h2(o10, sb2);
                if (L0().contains(DescriptorRendererModifier.LATEINIT) && o10.t0()) {
                    z10 = true;
                }
                d2(sb2, z10, "lateinit");
                Y1(o10, sb2);
            }
            descriptorRendererImpl = this;
            o11 = o10;
            sb3 = sb2;
            F2(descriptorRendererImpl, o11, sb3, false, 4, null);
            List<b0> typeParameters = o11.getTypeParameters();
            p.h(typeParameters, "getTypeParameters(...)");
            descriptorRendererImpl.D2(typeParameters, sb3, true);
            descriptorRendererImpl.o2(o11, sb3);
        }
        descriptorRendererImpl.e2(o11, sb3, true);
        sb3.append(": ");
        ya.S type = o11.getType();
        p.h(type, "getType(...)");
        sb3.append(descriptorRendererImpl.S(type));
        descriptorRendererImpl.p2(o11, sb3);
        descriptorRendererImpl.W1(o11, sb3);
        List<b0> typeParameters2 = o11.getTypeParameters();
        p.h(typeParameters2, "getTypeParameters(...)");
        descriptorRendererImpl.K2(typeParameters2, sb3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void n(boolean z10) {
        this.f35901m.n(z10);
    }

    public boolean n1() {
        return this.f35901m.k0();
    }

    public final void n2(O o10, StringBuilder sb2) {
        if (L0().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            D1(this, sb2, o10, null, 2, null);
            InterfaceC0812q interfaceC0812qR0 = o10.r0();
            if (interfaceC0812qR0 != null) {
                C1(sb2, interfaceC0812qR0, AnnotationUseSiteTarget.FIELD);
            }
            InterfaceC0812q interfaceC0812qL = o10.L();
            if (interfaceC0812qL != null) {
                C1(sb2, interfaceC0812qL, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
            }
            if (S0() == PropertyAccessorRenderingPolicy.NONE) {
                P getter = o10.getGetter();
                if (getter != null) {
                    C1(sb2, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                }
                Q setter = o10.getSetter();
                if (setter != null) {
                    C1(sb2, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                    List<i0> listI = setter.i();
                    p.h(listI, "getValueParameters(...)");
                    i0 i0Var = (i0) F.X0(listI);
                    p.f(i0Var);
                    C1(sb2, i0Var, AnnotationUseSiteTarget.SETTER_PARAMETER);
                }
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void o(boolean z10) {
        this.f35901m.o(z10);
    }

    public boolean o1() {
        return this.f35901m.l0();
    }

    public final void o2(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, StringBuilder sb2) {
        S sK = aVar.K();
        if (sK != null) {
            C1(sb2, sK, AnnotationUseSiteTarget.RECEIVER);
            ya.S type = sK.getType();
            p.h(type, "getType(...)");
            sb2.append(S1(type));
            sb2.append(".");
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void p(boolean z10) {
        this.f35901m.p(z10);
    }

    public final void p0(StringBuilder sb2, InterfaceC0803h interfaceC0803h) {
        InterfaceC0803h interfaceC0803hB;
        String name;
        if ((interfaceC0803h instanceof E) || (interfaceC0803h instanceof L) || (interfaceC0803hB = interfaceC0803h.b()) == null || (interfaceC0803hB instanceof InterfaceC0819y)) {
            return;
        }
        sb2.append(" ");
        sb2.append(a2("defined in"));
        sb2.append(" ");
        ga.d dVarM = C4828h.m(interfaceC0803hB);
        p.h(dVarM, "getFqName(...)");
        sb2.append(dVarM.e() ? "root package" : Q(dVarM));
        if (o1() && (interfaceC0803hB instanceof E) && (interfaceC0803h instanceof InterfaceC0806k) && (name = ((InterfaceC0806k) interfaceC0803h).e().b().getName()) != null) {
            sb2.append(" ");
            sb2.append(a2("in file"));
            sb2.append(" ");
            sb2.append(name);
        }
    }

    public boolean p1() {
        return this.f35901m.m0();
    }

    public final void p2(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, StringBuilder sb2) {
        S sK;
        if (T0() && (sK = aVar.K()) != null) {
            sb2.append(" on ");
            ya.S type = sK.getType();
            p.h(type, "getType(...)");
            sb2.append(S(type));
        }
    }

    public final void q0(StringBuilder sb2, List<? extends B0> list) throws IOException {
        F.x0(list, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new ja.p(this));
    }

    public boolean q1() {
        return this.f35901m.n0();
    }

    public final void q2(StringBuilder sb2, AbstractC5990d0 abstractC5990d0) {
        if (p.d(abstractC5990d0, H0.f44024b) || H0.k(abstractC5990d0)) {
            sb2.append("???");
            return;
        }
        if (i.o(abstractC5990d0)) {
            if (!j1()) {
                sb2.append("???");
                return;
            }
            v0 v0VarH0 = abstractC5990d0.H0();
            p.g(v0VarH0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
            sb2.append(O1(((Aa.h) v0VarH0).i(0)));
            return;
        }
        if (W.a(abstractC5990d0)) {
            N1(sb2, abstractC5990d0);
        } else if (L2(abstractC5990d0)) {
            V1(sb2, abstractC5990d0);
        } else {
            N1(sb2, abstractC5990d0);
        }
    }

    public boolean r1() {
        return this.f35901m.o0();
    }

    public final void r2(StringBuilder sb2) {
        int length = sb2.length();
        if (length == 0 || sb2.charAt(length - 1) != ' ') {
            sb2.append(' ');
        }
    }

    public final String s0() {
        int i10 = b.f35905a[h1().ordinal()];
        if (i10 == 1) {
            return t0("->");
        }
        if (i10 == 2) {
            return "&rarr;";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String s1() {
        return t0(">");
    }

    public final void s2(InterfaceC0797b interfaceC0797b, StringBuilder sb2) throws IOException {
        if (q1() || j.o0(interfaceC0797b.n())) {
            return;
        }
        Collection<ya.S> collectionE = interfaceC0797b.j().e();
        p.h(collectionE, "getSupertypes(...)");
        if (collectionE.isEmpty()) {
            return;
        }
        if (collectionE.size() == 1 && j.c0(collectionE.iterator().next())) {
            return;
        }
        r2(sb2);
        sb2.append(": ");
        F.x0(collectionE, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new r(this));
    }

    public final String t0(String str) {
        return h1().escape(str);
    }

    public final boolean t1(ya.S s10) {
        return C9.i.s(s10) || !s10.getAnnotations().isEmpty();
    }

    public final Modality u1(InterfaceC0816v interfaceC0816v) {
        if (interfaceC0816v instanceof InterfaceC0797b) {
            return ((InterfaceC0797b) interfaceC0816v).getKind() == ClassKind.INTERFACE ? Modality.ABSTRACT : Modality.FINAL;
        }
        InterfaceC0803h interfaceC0803hB = interfaceC0816v.b();
        InterfaceC0797b interfaceC0797b = interfaceC0803hB instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0803hB : null;
        if (interfaceC0797b != null && (interfaceC0816v instanceof CallableMemberDescriptor)) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) interfaceC0816v;
            Collection<? extends CallableMemberDescriptor> collectionD = callableMemberDescriptor.d();
            p.h(collectionD, "getOverriddenDescriptors(...)");
            if (!collectionD.isEmpty() && interfaceC0797b.p() != Modality.FINAL) {
                return Modality.OPEN;
            }
            if (interfaceC0797b.getKind() != ClassKind.INTERFACE || p.d(callableMemberDescriptor.getVisibility(), C0810o.f2469a)) {
                return Modality.FINAL;
            }
            Modality modalityP = callableMemberDescriptor.p();
            Modality modality = Modality.ABSTRACT;
            return modalityP == modality ? modality : Modality.OPEN;
        }
        return Modality.FINAL;
    }

    public final void u2(e eVar, StringBuilder sb2) {
        d2(sb2, eVar.isSuspend(), "suspend");
    }

    public final boolean v1(F9.c cVar) {
        return p.d(cVar.f(), o.a.f1854E);
    }

    public final void v2(a0 a0Var, StringBuilder sb2) {
        D1(this, sb2, a0Var, null, 2, null);
        AbstractC0811p visibility = a0Var.getVisibility();
        p.h(visibility, "getVisibility(...)");
        J2(visibility, sb2);
        Z1(a0Var, sb2);
        sb2.append(X1("typealias"));
        sb2.append(" ");
        e2(a0Var, sb2, true);
        List<b0> listO = a0Var.o();
        p.h(listO, "getDeclaredTypeParameters(...)");
        D2(listO, sb2, false);
        E1(a0Var, sb2);
        sb2.append(" = ");
        sb2.append(S(a0Var.n0()));
    }

    public boolean w0() {
        return this.f35901m.u();
    }

    public final String w1() {
        return t0("<");
    }

    public String w2(List<? extends B0> typeArguments) throws IOException {
        p.i(typeArguments, "typeArguments");
        if (typeArguments.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(w1());
        q0(sb2, typeArguments);
        sb2.append(s1());
        return sb2.toString();
    }

    public boolean x0() {
        return this.f35901m.v();
    }

    public final boolean x1(CallableMemberDescriptor callableMemberDescriptor) {
        return !callableMemberDescriptor.d().isEmpty();
    }

    public String x2(v0 typeConstructor) {
        p.i(typeConstructor, "typeConstructor");
        InterfaceC0799d interfaceC0799dD = typeConstructor.d();
        if ((interfaceC0799dD instanceof b0) || (interfaceC0799dD instanceof InterfaceC0797b) || (interfaceC0799dD instanceof a0)) {
            return H1(interfaceC0799dD);
        }
        if (interfaceC0799dD == null) {
            return typeConstructor instanceof C5982Q ? ((C5982Q) typeConstructor).o(ja.o.f34553a) : typeConstructor.toString();
        }
        throw new IllegalStateException(("Unexpected classifier: " + interfaceC0799dD.getClass()).toString());
    }

    public InterfaceC5074l<F9.c, Boolean> y0() {
        return this.f35901m.w();
    }

    public final void y1(StringBuilder sb2, C5983a c5983a) {
        RenderingFormat renderingFormatH1 = h1();
        RenderingFormat renderingFormat = RenderingFormat.HTML;
        if (renderingFormatH1 == renderingFormat) {
            sb2.append("<font color=\"808080\"><i>");
        }
        sb2.append(" /* ");
        sb2.append("from: ");
        g2(sb2, c5983a.T0());
        sb2.append(" */");
        if (h1() == renderingFormat) {
            sb2.append("</i></font>");
        }
    }

    public boolean z0() {
        return this.f35901m.x();
    }

    public final void z1(f fVar, StringBuilder sb2) {
        Z1(fVar, sb2);
    }

    public final void z2(StringBuilder sb2, ya.S s10, v0 v0Var) {
        N nD = f0.d(s10);
        if (nD != null) {
            l2(sb2, nD);
        } else {
            sb2.append(x2(v0Var));
            sb2.append(w2(s10.F0()));
        }
    }
}
