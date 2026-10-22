package A8;

import H8.AbstractC0241b;
import T8.C0250b;
import T8.InterfaceC0253e;
import T8.w;
import android.os.Handler;
import b1.C0821b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import i8.InterfaceC1555a;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import v.C2053a;
import z8.n;
import z8.o;

/* loaded from: classes4.dex */
public abstract class b implements o, R8.d, InterfaceC0253e, InterfaceC1555a {

    /* renamed from: a, reason: collision with root package name */
    public Object f160a;

    public b(c1.b bVar) {
        this.f160a = bVar;
    }

    public static /* synthetic */ void C0(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i == 1) {
            objArr[1] = "getType";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 1 && i != 2) {
            objArr[2] = AppAgent.CONSTRUCT;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static /* synthetic */ void D0(int i) {
        String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 1 ? 3 : 2];
        if (i != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i != 1) {
            objArr[2] = AppAgent.CONSTRUCT;
        }
        String str2 = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // T8.InterfaceC0253e
    public ArrayList A(w container) {
        k.f(container, "container");
        Iterable iterable = (List) container.e.i(((S8.a) this.f160a).c);
        if (iterable == null) {
            iterable = EmptyList.f4893a;
        }
        Iterable iterable2 = iterable;
        ArrayList arrayList = new ArrayList(D7.w.c0(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0250b) this).P0((ProtoBuf$Annotation) it.next(), (D8.f) container.b));
        }
        return arrayList;
    }

    @Override // z8.o
    public void C(L8.f fVar) {
    }

    public Object E0(String str, String str2, v.c cVar) {
        boolean z10;
        C2053a c2053a = (C2053a) this.f160a;
        String strA = cVar.a();
        boolean zB = cVar.b(str);
        boolean zB2 = cVar.b(strA);
        if (!zB && zB2) {
            str = strA;
        }
        if (c2053a != null) {
            String strF = cVar.f(str, str2, c2053a);
            if (!cVar.o(strF, strA)) {
                cVar.q(strF);
            }
            return strF;
        }
        if (zB || zB2) {
            z10 = false;
            str2 = str;
        } else {
            z10 = true;
        }
        if ((z10 && cVar.b(str2)) || (zB && !cVar.o(str2, strA))) {
            cVar.q(str2);
        }
        return str2;
    }

    public void F0() {
        if (AbstractC1451a.f4467a) {
            H4.o.r("APM-CPU", "stop detect when state is : " + L0());
        }
    }

    @Override // T8.InterfaceC0253e
    public List G(J5.b bVar, AbstractC0241b proto, AnnotatedCallableKind annotatedCallableKind) {
        S8.a aVar = (S8.a) this.f160a;
        k.f(proto, "proto");
        if (proto instanceof ProtoBuf$Function) {
            aVar.getClass();
        } else {
            if (!(proto instanceof ProtoBuf$Property)) {
                throw new IllegalStateException(("Unknown message: " + proto).toString());
            }
            int iOrdinal = annotatedCallableKind.ordinal();
            if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3) {
                throw new IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + annotatedCallableKind).toString());
            }
            aVar.getClass();
        }
        EmptyList emptyList = EmptyList.f4893a;
        ArrayList arrayList = new ArrayList(D7.w.c0(emptyList, 10));
        Iterator<E> it = emptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0250b) this).P0((ProtoBuf$Annotation) it.next(), (D8.f) bVar.b));
        }
        return arrayList;
    }

    public void G0(Handler handler) {
        C2053a c2053a = (C2053a) this.f160a;
        if (c2053a != null) {
            c2053a.G0(handler);
        }
    }

    public void H0(C0821b c0821b, boolean z10) {
        if (AbstractC1451a.f4467a) {
            H4.o.r("APM-CPU", "enter : " + L0());
        }
    }

    public void I0(String str) {
        if (AbstractC1451a.f4467a) {
            H4.o.r("APM-CPU", "[" + L0() + "]: " + str);
        }
    }

    public abstract void J0(String str, String str2);

    public void K0(boolean z10) {
        if (AbstractC1451a.f4467a) {
            H4.o.r("APM-CPU", "onLifeCycleChange when state is : " + L0());
        }
    }

    @Override // z8.o
    public n L(G8.b bVar) {
        return null;
    }

    public abstract cc.dd.ee.ee.ee.d L0();

    @Override // T8.InterfaceC0253e
    public List M(J5.b container, ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        k.f(container, "container");
        Iterable iterable = (List) protoBuf$EnumEntry.i(((S8.a) this.f160a).h);
        if (iterable == null) {
            iterable = EmptyList.f4893a;
        }
        Iterable iterable2 = iterable;
        ArrayList arrayList = new ArrayList(D7.w.c0(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0250b) this).P0((ProtoBuf$Annotation) it.next(), (D8.f) container.b));
        }
        return arrayList;
    }

    public abstract String M0(String str);

    public String N0(String str, String str2) {
        return (String) E0(str, str2, new a5.d(this, 8));
    }

    public abstract void O0(String[] strArr);

    @Override // T8.InterfaceC0253e
    public List Q(J5.b bVar, ProtoBuf$Property proto) {
        k.f(proto, "proto");
        ((S8.a) this.f160a).getClass();
        EmptyList emptyList = EmptyList.f4893a;
        ArrayList arrayList = new ArrayList(D7.w.c0(emptyList, 10));
        Iterator<E> it = emptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0250b) this).P0((ProtoBuf$Annotation) it.next(), (D8.f) bVar.b));
        }
        return arrayList;
    }

    @Override // T8.InterfaceC0253e
    public ArrayList Y(ProtoBuf$TypeParameter proto, D8.f nameResolver) {
        k.f(proto, "proto");
        k.f(nameResolver, "nameResolver");
        Iterable iterable = (List) proto.i(((S8.a) this.f160a).l);
        if (iterable == null) {
            iterable = EmptyList.f4893a;
        }
        Iterable iterable2 = iterable;
        ArrayList arrayList = new ArrayList(D7.w.c0(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0250b) this).P0((ProtoBuf$Annotation) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // T8.InterfaceC0253e
    public List Z(J5.b bVar, AbstractC0241b callableProto, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        k.f(callableProto, "callableProto");
        Iterable iterable = (List) protoBuf$ValueParameter.i(((S8.a) this.f160a).f1180j);
        if (iterable == null) {
            iterable = EmptyList.f4893a;
        }
        Iterable iterable2 = iterable;
        ArrayList arrayList = new ArrayList(D7.w.c0(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0250b) this).P0((ProtoBuf$Annotation) it.next(), (D8.f) bVar.b));
        }
        return arrayList;
    }

    @Override // z8.o
    public void f0(G8.b bVar, G8.f fVar) {
    }

    @Override // i8.InterfaceC1555a
    public InterfaceC1561g getAnnotations() {
        InterfaceC1561g interfaceC1561g = (InterfaceC1561g) this.f160a;
        if (interfaceC1561g != null) {
            return interfaceC1561g;
        }
        D0(1);
        throw null;
    }

    @Override // R8.d
    public X8.w getType() {
        X8.w wVar = (X8.w) this.f160a;
        if (wVar != null) {
            return wVar;
        }
        C0(1);
        throw null;
    }

    @Override // z8.o
    public void j0(Object obj) {
        if (obj instanceof String) {
            ((ArrayList) this.f160a).add((String) obj);
        }
    }

    @Override // z8.o
    public void k() {
        O0((String[]) ((ArrayList) this.f160a).toArray(new String[0]));
    }

    @Override // T8.InterfaceC0253e
    public List m0(J5.b bVar, ProtoBuf$Property proto) {
        k.f(proto, "proto");
        ((S8.a) this.f160a).getClass();
        EmptyList emptyList = EmptyList.f4893a;
        ArrayList arrayList = new ArrayList(D7.w.c0(emptyList, 10));
        Iterator<E> it = emptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0250b) this).P0((ProtoBuf$Annotation) it.next(), (D8.f) bVar.b));
        }
        return arrayList;
    }

    @Override // T8.InterfaceC0253e
    public List s0(J5.b bVar, AbstractC0241b proto, AnnotatedCallableKind annotatedCallableKind) {
        List list;
        S8.a aVar = (S8.a) this.f160a;
        k.f(proto, "proto");
        if (proto instanceof ProtoBuf$Constructor) {
            list = (List) ((ProtoBuf$Constructor) proto).i(aVar.b);
        } else if (proto instanceof ProtoBuf$Function) {
            list = (List) ((ProtoBuf$Function) proto).i(aVar.d);
        } else {
            if (!(proto instanceof ProtoBuf$Property)) {
                throw new IllegalStateException(("Unknown message: " + proto).toString());
            }
            int iOrdinal = annotatedCallableKind.ordinal();
            if (iOrdinal == 1) {
                list = (List) ((ProtoBuf$Property) proto).i(aVar.e);
            } else if (iOrdinal == 2) {
                list = (List) ((ProtoBuf$Property) proto).i(aVar.f);
            } else {
                if (iOrdinal != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto");
                }
                list = (List) ((ProtoBuf$Property) proto).i(aVar.g);
            }
        }
        if (list == null) {
            list = EmptyList.f4893a;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(D7.w.c0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0250b) this).P0((ProtoBuf$Annotation) it.next(), (D8.f) bVar.b));
        }
        return arrayList;
    }

    @Override // T8.InterfaceC0253e
    public ArrayList y0(ProtoBuf$Type proto, D8.f nameResolver) {
        k.f(proto, "proto");
        k.f(nameResolver, "nameResolver");
        Iterable iterable = (List) proto.i(((S8.a) this.f160a).k);
        if (iterable == null) {
            iterable = EmptyList.f4893a;
        }
        Iterable iterable2 = iterable;
        ArrayList arrayList = new ArrayList(D7.w.c0(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0250b) this).P0((ProtoBuf$Annotation) it.next(), nameResolver));
        }
        return arrayList;
    }

    public b(Object obj) {
        if (obj != null) {
            this.f160a = obj;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public b(InterfaceC1561g interfaceC1561g) {
        if (interfaceC1561g != null) {
            this.f160a = interfaceC1561g;
        } else {
            D0(0);
            throw null;
        }
    }

    public b(X8.w wVar) {
        if (wVar != null) {
            this.f160a = wVar;
        } else {
            C0(0);
            throw null;
        }
    }

    public b() {
        this.f160a = new ArrayList();
    }
}
