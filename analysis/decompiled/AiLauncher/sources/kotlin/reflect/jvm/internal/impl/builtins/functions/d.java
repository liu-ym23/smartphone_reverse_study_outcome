package kotlin.reflect.jvm.internal.impl.builtins.functions;

import E9.C0810o;
import E9.InterfaceC0803h;
import E9.S;
import E9.W;
import E9.b0;
import E9.i0;
import F9.g;
import Fa.t;
import H9.AbstractC0839s;
import H9.O;
import H9.V;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.IndexedValue;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import ya.AbstractC5990d0;

/* loaded from: classes5.dex */
public final class d extends O {

    /* renamed from: E, reason: collision with root package name */
    public static final a f34962E = new a(null);

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public final d a(b functionClass, boolean z10) {
            p.i(functionClass, "functionClass");
            List<b0> listO = functionClass.o();
            d dVar = new d(functionClass, null, CallableMemberDescriptor.Kind.DECLARATION, z10, null);
            S sD0 = functionClass.D0();
            List<S> listM = C1173v.m();
            List<? extends b0> listM2 = C1173v.m();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listO) {
                if (((b0) obj).l() != Variance.IN_VARIANCE) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<IndexedValue> iterableU1 = F.u1(arrayList);
            ArrayList arrayList2 = new ArrayList(C1174w.x(iterableU1, 10));
            for (IndexedValue indexedValue : iterableU1) {
                arrayList2.add(d.f34962E.b(dVar, indexedValue.c(), (b0) indexedValue.d()));
            }
            dVar.L0(null, sD0, listM, listM2, arrayList2, ((b0) F.C0(listO)).n(), Modality.ABSTRACT, C0810o.f2473e);
            dVar.T0(true);
            return dVar;
        }

        public final i0 b(d dVar, int i10, b0 b0Var) {
            String lowerCase;
            String strB = b0Var.getName().b();
            p.h(strB, "asString(...)");
            if (p.d(strB, ExifInterface.GPS_DIRECTION_TRUE)) {
                lowerCase = "instance";
            } else if (p.d(strB, ExifInterface.LONGITUDE_EAST)) {
                lowerCase = "receiver";
            } else {
                lowerCase = strB.toLowerCase(Locale.ROOT);
                p.h(lowerCase, "toLowerCase(...)");
            }
            g gVarB = g.f2609m0.b();
            ga.e eVarJ = ga.e.j(lowerCase);
            p.h(eVarJ, "identifier(...)");
            AbstractC5990d0 abstractC5990d0N = b0Var.n();
            p.h(abstractC5990d0N, "getDefaultType(...)");
            W NO_SOURCE = W.f2444a;
            p.h(NO_SOURCE, "NO_SOURCE");
            return new V(dVar, null, i10, gVarB, eVarJ, abstractC5990d0N, false, false, false, null, NO_SOURCE);
        }

        public a() {
        }
    }

    public /* synthetic */ d(InterfaceC0803h interfaceC0803h, d dVar, CallableMemberDescriptor.Kind kind, boolean z10, i iVar) {
        this(interfaceC0803h, dVar, kind, z10);
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean A() {
        return false;
    }

    @Override // H9.O, H9.AbstractC0839s
    public AbstractC0839s F0(InterfaceC0803h newOwner, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, CallableMemberDescriptor.Kind kind, ga.e eVar2, g annotations, W source) {
        p.i(newOwner, "newOwner");
        p.i(kind, "kind");
        p.i(annotations, "annotations");
        p.i(source, "source");
        return new d(newOwner, (d) eVar, kind, isSuspend());
    }

    @Override // H9.AbstractC0839s
    public kotlin.reflect.jvm.internal.impl.descriptors.e G0(AbstractC0839s.c configuration) {
        p.i(configuration, "configuration");
        d dVar = (d) super.G0(configuration);
        if (dVar == null) {
            return null;
        }
        List<i0> listI = dVar.i();
        p.h(listI, "getValueParameters(...)");
        List<i0> list = listI;
        if ((list instanceof Collection) && list.isEmpty()) {
            return dVar;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ya.S type = ((i0) it.next()).getType();
            p.h(type, "getType(...)");
            if (C9.i.d(type) != null) {
                List<i0> listI2 = dVar.i();
                p.h(listI2, "getValueParameters(...)");
                List<i0> list2 = listI2;
                ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    ya.S type2 = ((i0) it2.next()).getType();
                    p.h(type2, "getType(...)");
                    arrayList.add(C9.i.d(type2));
                }
                return dVar.j1(arrayList);
            }
        }
        return dVar;
    }

    @Override // H9.AbstractC0839s, E9.InterfaceC0816v
    public boolean isExternal() {
        return false;
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e j1(List<ga.e> list) {
        ga.e eVar;
        int size = i().size() - list.size();
        boolean z10 = true;
        if (size == 0) {
            List<i0> listI = i();
            p.h(listI, "getValueParameters(...)");
            List<Pair> listW1 = F.w1(list, listI);
            if ((listW1 instanceof Collection) && listW1.isEmpty()) {
                return this;
            }
            for (Pair pair : listW1) {
                if (!p.d((ga.e) pair.a(), ((i0) pair.b()).getName())) {
                }
            }
            return this;
        }
        List<i0> listI2 = i();
        p.h(listI2, "getValueParameters(...)");
        List<i0> list2 = listI2;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        for (i0 i0Var : list2) {
            ga.e name = i0Var.getName();
            p.h(name, "getName(...)");
            int index = i0Var.getIndex();
            int i10 = index - size;
            if (i10 >= 0 && (eVar = list.get(i10)) != null) {
                name = eVar;
            }
            arrayList.add(i0Var.U(this, name, index));
        }
        AbstractC0839s.c cVarM0 = M0(TypeSubstitutor.f36088b);
        List<ga.e> list3 = list;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            z10 = false;
        } else {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (((ga.e) it.next()) == null) {
                    break;
                }
            }
            z10 = false;
        }
        AbstractC0839s.c cVarL = cVarM0.G(z10).b(arrayList).l(a());
        p.h(cVarL, "setOriginal(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarG0 = super.G0(cVarL);
        p.f(eVarG0);
        return eVarG0;
    }

    public d(InterfaceC0803h interfaceC0803h, d dVar, CallableMemberDescriptor.Kind kind, boolean z10) {
        super(interfaceC0803h, dVar, g.f2609m0.b(), t.f2708i, kind, W.f2444a);
        Z0(true);
        b1(z10);
        S0(false);
    }
}
