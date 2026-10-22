package A8;

import C7.r;
import D7.v;
import G8.h;
import I8.j;
import T8.g;
import V8.t;
import X8.w;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import com.stepos.core.deepbinder.IAbilityDeepBinderService;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import e1.C1403b;
import e8.i;
import h8.AbstractC1538u;
import h8.C1531n;
import h8.InterfaceC1494B;
import h8.InterfaceC1497E;
import h8.InterfaceC1501I;
import h8.InterfaceC1503K;
import h8.InterfaceC1506N;
import h8.InterfaceC1527j;
import h8.InterfaceC1529l;
import h8.InterfaceC1536s;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k8.AbstractC1629B;
import k8.AbstractC1637f;
import k8.AbstractC1639h;
import k8.C1640i;
import k8.F;
import k8.H;
import k8.I;
import k8.J;
import k8.Q;
import k8.u;
import k8.y;
import k8.z;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy;
import stepos.support.v7.app.L;
import u8.p;
import z2.l;
import z8.n;
import z8.o;

/* loaded from: classes4.dex */
public final class d implements n, E9.f, InterfaceC1529l, g, ViewPropertyAnimatorUpdateListener, InterfaceC1503K {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f161a;
    public final Object b;

    public /* synthetic */ d(Object obj, int i) {
        this.f161a = i;
        this.b = obj;
    }

    public static void B(Object... args) {
        k.f(args, "args");
        for (d dVar : Ya.a.b) {
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            dVar.getClass();
            B(objArrCopyOf);
        }
    }

    public static void C(Object... args) {
        k.f(args, "args");
        for (d dVar : Ya.a.b) {
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            dVar.getClass();
            C(objArrCopyOf);
        }
    }

    public static void D(Object... args) {
        k.f(args, "args");
        for (d dVar : Ya.a.b) {
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            dVar.getClass();
            D(objArrCopyOf);
        }
    }

    public static void I(Object... args) {
        k.f(args, "args");
        for (d dVar : Ya.a.b) {
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            dVar.getClass();
            I(objArrCopyOf);
        }
    }

    public static void q(Object... args) {
        k.f(args, "args");
        for (d dVar : Ya.a.b) {
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            dVar.getClass();
            q(objArrCopyOf);
        }
    }

    @Override // h8.InterfaceC1529l
    public Object A(u uVar, Object obj) {
        ((StringBuilder) obj).append(uVar.getName());
        return r.f317a;
    }

    public l E(com.stepos.core.transport.bridge.b bVar) {
        String str = bVar.f3828a;
        Log.d("DeepBinderTransportBridge", "send: requestId=" + str);
        try {
            ((IAbilityDeepBinderService) this.b).infer(str, bVar.b, new C1403b(7));
            return new com.stepos.core.transport.bridge.e(str);
        } catch (Exception e) {
            Log.e("DeepBinderTransportBridge", "send failed: " + str, e);
            String message = e.getMessage();
            if (message == null) {
                message = "DeepBinder infer failed";
            }
            return new com.stepos.core.transport.bridge.d(str, new com.stepos.core.transport.bridge.c(message));
        }
    }

    public void F(String tag) {
        k.f(tag, "tag");
        d[] dVarArr = Ya.a.b;
        int length = dVarArr.length;
        int i = 0;
        while (i < length) {
            d dVar = dVarArr[i];
            i++;
            ((ThreadLocal) dVar.b).set(tag);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void G(h8.InterfaceC1536s r11, java.lang.StringBuilder r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A8.d.G(h8.s, java.lang.StringBuilder):void");
    }

    public void H(F f, StringBuilder sb, String str) throws IOException {
        I8.g gVar = (I8.g) this.b;
        j jVar = gVar.f813a;
        int iOrdinal = ((PropertyAccessorRenderingPolicy) jVar.f822H.getValue(jVar, j.f815Y[32])).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                G(f, sb);
                return;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                return;
            }
        }
        gVar.I(f, sb);
        sb.append(str.concat(" for "));
        InterfaceC1501I interfaceC1501IR0 = f.R0();
        k.e(interfaceC1501IR0, "getCorrespondingProperty(...)");
        I8.g.l(gVar, interfaceC1501IR0, sb);
    }

    @Override // E9.f
    public void a(Z7.d kClass, S7.k kVar) {
        k.f(kClass, "kClass");
        ((kotlinx.serialization.modules.a) this.b).g(kClass, new E9.b(kVar), true);
    }

    @Override // E9.f
    public void b(Z7.d dVar, Z7.d dVar2, x9.b bVar) {
        ((kotlinx.serialization.modules.a) this.b).f(dVar, dVar2, bVar, true);
    }

    @Override // h8.InterfaceC1529l
    public Object c(J j5, Object obj) throws IOException {
        H(j5, (StringBuilder) obj, "setter");
        return r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0044  */
    @Override // h8.InterfaceC1529l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(k8.C1640i r11, java.lang.Object r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A8.d.d(k8.i, java.lang.Object):java.lang.Object");
    }

    @Override // T8.g
    public T8.f e(G8.b classId) {
        T8.f fVarE;
        k.f(classId, "classId");
        Iterator it = AbstractC1538u.f((InterfaceC1497E) this.b, classId.f687a).iterator();
        while (it.hasNext()) {
            InterfaceC1494B interfaceC1494B = (InterfaceC1494B) it.next();
            if ((interfaceC1494B instanceof U8.b) && (fVarE = ((U8.b) interfaceC1494B).i.e(classId)) != null) {
                return fVarE;
            }
        }
        return null;
    }

    @Override // h8.InterfaceC1529l
    public Object g(y yVar, Object obj) throws IOException {
        C1640i c1640iU;
        String str;
        StringBuilder sb = (StringBuilder) obj;
        I8.g gVar = (I8.g) this.b;
        j jVar = gVar.f813a;
        boolean z10 = yVar.getKind() == ClassKind.d;
        if (!gVar.p()) {
            List listT = yVar.T();
            k.e(listT, "getContextReceivers(...)");
            gVar.A(sb, listT);
            gVar.w(sb, yVar, null);
            if (!z10) {
                C1531n visibility = yVar.getVisibility();
                k.e(visibility, "getVisibility(...)");
                gVar.f0(visibility, sb);
            }
            if ((yVar.getKind() != ClassKind.b || yVar.i() != Modality.e) && (!yVar.getKind().a() || yVar.i() != Modality.b)) {
                Modality modalityI = yVar.i();
                k.e(modalityI, "getModality(...)");
                gVar.J(modalityI, sb, I8.g.t(yVar));
            }
            gVar.I(yVar, sb);
            gVar.L(sb, gVar.o().contains(DescriptorRendererModifier.h) && yVar.q(), "inner");
            gVar.L(sb, gVar.o().contains(DescriptorRendererModifier.f5106j) && yVar.A0(), SettingsConfig.KEY_DATA);
            gVar.L(sb, gVar.o().contains(DescriptorRendererModifier.k) && yVar.isInline(), "inline");
            gVar.L(sb, gVar.o().contains(DescriptorRendererModifier.f5107q) && yVar.j(), "value");
            gVar.L(sb, gVar.o().contains(DescriptorRendererModifier.p) && yVar.c0(), "fun");
            if (yVar instanceof InterfaceC1506N) {
                str = "typealias";
            } else if (yVar.X()) {
                str = "companion object";
            } else {
                int iOrdinal = yVar.getKind().ordinal();
                if (iOrdinal == 0) {
                    str = "class";
                } else if (iOrdinal == 1) {
                    str = "interface";
                } else if (iOrdinal == 2) {
                    str = "enum class";
                } else if (iOrdinal == 3) {
                    str = "enum entry";
                } else if (iOrdinal == 4) {
                    str = "annotation class";
                } else {
                    if (iOrdinal != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    str = "object";
                }
            }
            sb.append(gVar.G(str));
        }
        if (J8.e.l(yVar)) {
            if (((Boolean) jVar.f821G.getValue(jVar, j.f815Y[31])).booleanValue()) {
                if (gVar.p()) {
                    sb.append("companion object");
                }
                I8.g.V(sb);
                InterfaceC1527j interfaceC1527jD = yVar.d();
                if (interfaceC1527jD != null) {
                    sb.append("of ");
                    G8.f name = interfaceC1527jD.getName();
                    k.e(name, "getName(...)");
                    sb.append(gVar.M(name, false));
                }
            }
            if (gVar.s() || !k.b(yVar.getName(), h.b)) {
                if (!gVar.p()) {
                    I8.g.V(sb);
                }
                G8.f name2 = yVar.getName();
                k.e(name2, "getName(...)");
                sb.append(gVar.M(name2, true));
            }
        } else {
            if (!gVar.p()) {
                I8.g.V(sb);
            }
            gVar.N(yVar, sb, true);
        }
        if (!z10) {
            List listH = yVar.h();
            k.e(listH, "getDeclaredTypeParameters(...)");
            gVar.b0(listH, sb, false);
            gVar.y(yVar, sb);
            if (!yVar.getKind().a() && ((Boolean) jVar.i.getValue(jVar, j.f815Y[7])).booleanValue() && (c1640iU = yVar.u()) != null) {
                sb.append(" ");
                gVar.w(sb, c1640iU, null);
                C1640i c1640i = c1640iU;
                C1531n visibility2 = c1640i.getVisibility();
                k.e(visibility2, "getVisibility(...)");
                gVar.f0(visibility2, sb);
                sb.append(gVar.G("constructor"));
                List listX = c1640i.x();
                k.e(listX, "getValueParameters(...)");
                gVar.e0(listX, c1640iU.e0(), sb);
            }
            if (!((Boolean) jVar.f847x.getValue(jVar, j.f815Y[22])).booleanValue() && !i.E(yVar.g())) {
                Collection collectionE = yVar.m().e();
                k.e(collectionE, "getSupertypes(...)");
                if (!collectionE.isEmpty() && (collectionE.size() != 1 || !i.x((w) collectionE.iterator().next()))) {
                    I8.g.V(sb);
                    sb.append(": ");
                    v.H0(collectionE, sb, ", ", null, null, new I8.f(gVar, 1), 60);
                }
            }
            gVar.g0(sb, listH);
        }
        return r.f317a;
    }

    @Override // E9.f
    public void h(Z7.d dVar, S7.k kVar) {
        ((kotlinx.serialization.modules.a) this.b).e(dVar, kVar, true);
    }

    @Override // E9.f
    public void i(Z7.d dVar, S7.k kVar) {
        ((kotlinx.serialization.modules.a) this.b).d(dVar, kVar, true);
    }

    @Override // h8.InterfaceC1529l
    public Object j(k8.w wVar, Object obj) {
        StringBuilder sb = (StringBuilder) obj;
        I8.g gVar = (I8.g) this.b;
        gVar.getClass();
        gVar.R(wVar.d, "package", sb);
        if (gVar.f813a.l()) {
            sb.append(" in context of ");
            gVar.N(wVar.c, sb, false);
        }
        return r.f317a;
    }

    @Override // z8.n
    public void k() {
    }

    @Override // z8.n
    public n l(G8.b bVar, G8.f fVar) {
        return null;
    }

    @Override // z8.n
    public void m(G8.f fVar, L8.f fVar2) {
    }

    @Override // z8.n
    public o n(G8.f fVar) {
        String strB = fVar.b();
        if ("d1".equals(strB)) {
            return new c(this, 0);
        }
        if ("d2".equals(strB)) {
            return new c(this, 1);
        }
        return null;
    }

    @Override // E9.f
    public void o(Z7.d dVar, x9.b serializer) {
        k.f(serializer, "serializer");
        ((kotlinx.serialization.modules.a) this.b).g(dVar, new E9.a(serializer), true);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
    public void onAnimationUpdate(View view) {
        ((View) ((L) this.b).f.getParent()).invalidate();
    }

    @Override // h8.InterfaceC1529l
    public Object p(H descriptor, Object obj) throws IOException {
        k.f(descriptor, "descriptor");
        I8.g.l((I8.g) this.b, descriptor, (StringBuilder) obj);
        return r.f317a;
    }

    @Override // h8.InterfaceC1529l
    public Object r(I i, Object obj) throws IOException {
        H(i, (StringBuilder) obj, "getter");
        return r.f317a;
    }

    @Override // h8.InterfaceC1529l
    public Object s(Q q5, Object obj) {
        ((I8.g) this.b).d0(q5, true, (StringBuilder) obj, true);
        return r.f317a;
    }

    @Override // z8.n
    public void t(G8.f fVar, Object obj) {
        f fVar2 = (f) this.b;
        String strB = fVar.b();
        if ("k".equals(strB)) {
            if (obj instanceof Integer) {
                KotlinClassHeader$Kind.b.getClass();
                KotlinClassHeader$Kind kotlinClassHeader$Kind = (KotlinClassHeader$Kind) KotlinClassHeader$Kind.c.get((Integer) obj);
                if (kotlinClassHeader$Kind == null) {
                    kotlinClassHeader$Kind = KotlinClassHeader$Kind.d;
                }
                fVar2.g = kotlinClassHeader$Kind;
                return;
            }
            return;
        }
        if ("mv".equals(strB)) {
            if (obj instanceof int[]) {
                fVar2.f163a = (int[]) obj;
                return;
            }
            return;
        }
        if ("xs".equals(strB)) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.isEmpty()) {
                    return;
                }
                fVar2.b = str;
                return;
            }
            return;
        }
        if ("xi".equals(strB)) {
            if (obj instanceof Integer) {
                fVar2.c = ((Integer) obj).intValue();
            }
        } else if ("pn".equals(strB) && (obj instanceof String)) {
            ((String) obj).isEmpty();
        }
    }

    public String toString() {
        switch (this.f161a) {
            case 8:
                StringBuilder sb = new StringBuilder();
                p pVar = (p) this.b;
                sb.append(pVar);
                sb.append(": ");
                sb.append(((Map) S0.b.g1(pVar.i, p.m[0])).keySet());
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // h8.InterfaceC1529l
    public Object u(AbstractC1629B abstractC1629B, Object obj) {
        StringBuilder sb = (StringBuilder) obj;
        I8.g gVar = (I8.g) this.b;
        gVar.getClass();
        gVar.R(abstractC1629B.e, "package-fragment", sb);
        if (gVar.f813a.l()) {
            sb.append(" in ");
            gVar.N(abstractC1629B.d(), sb, false);
        }
        return r.f317a;
    }

    @Override // h8.InterfaceC1529l
    public Object v(Object obj, z zVar) {
        ((I8.g) this.b).N(zVar, (StringBuilder) obj, true);
        return r.f317a;
    }

    @Override // h8.InterfaceC1529l
    public Object w(AbstractC1639h abstractC1639h, Object obj) {
        ((I8.g) this.b).Z(abstractC1639h, (StringBuilder) obj, true);
        return r.f317a;
    }

    @Override // h8.InterfaceC1529l
    public Object x(AbstractC1637f abstractC1637f, Object obj) {
        StringBuilder sb = (StringBuilder) obj;
        I8.g gVar = (I8.g) this.b;
        gVar.getClass();
        gVar.w(sb, abstractC1637f, null);
        C1531n c1531n = abstractC1637f.f;
        k.e(c1531n, "getVisibility(...)");
        gVar.f0(c1531n, sb);
        gVar.I(abstractC1637f, sb);
        sb.append(gVar.G("typealias"));
        sb.append(" ");
        gVar.N(abstractC1637f, sb, true);
        gVar.b0(abstractC1637f.h(), sb, false);
        gVar.y(abstractC1637f, sb);
        sb.append(" = ");
        sb.append(gVar.W(((t) abstractC1637f).T0()));
        return r.f317a;
    }

    @Override // z8.n
    public void y(G8.f fVar, G8.b bVar, G8.f fVar2) {
    }

    @Override // h8.InterfaceC1529l
    public /* bridge */ /* synthetic */ Object z(InterfaceC1536s interfaceC1536s, Object obj) throws IOException {
        G(interfaceC1536s, (StringBuilder) obj);
        return r.f317a;
    }

    public d(IAbilityDeepBinderService abilityService) {
        this.f161a = 5;
        k.f(abilityService, "abilityService");
        this.b = abilityService;
    }

    public d(int i) {
        this.f161a = i;
        switch (i) {
            case 6:
                this.b = L.d.a(H.h.f711a, "monitor_config");
                break;
            default:
                this.b = new ThreadLocal();
                break;
        }
    }
}
