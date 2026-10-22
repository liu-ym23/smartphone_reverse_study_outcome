package ua;

import Z8.C1173v;
import Z8.C1174w;
import ea.InterfaceC4020d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import ta.C5527a;
import ua.AbstractC5604N;

/* renamed from: ua.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5615a<A> implements InterfaceC5621g<A> {

    /* renamed from: a, reason: collision with root package name */
    public final C5527a f42585a;

    /* renamed from: ua.a$a, reason: collision with other inner class name */
    public static final /* synthetic */ class C0535a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42586a;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            try {
                iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f42586a = iArr;
        }
    }

    public AbstractC5615a(C5527a protocol) {
        kotlin.jvm.internal.p.i(protocol, "protocol");
        this.f42585a = protocol;
    }

    @Override // ua.InterfaceC5621g
    public List<A> a(AbstractC5604N container, kotlin.reflect.jvm.internal.impl.protobuf.h proto, AnnotatedCallableKind kind) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(kind, "kind");
        List listM = null;
        if (proto instanceof ProtoBuf$Function) {
            GeneratedMessageLite.e<ProtoBuf$Function, List<ProtoBuf$Annotation>> eVarG = this.f42585a.g();
            if (eVarG != null) {
                listM = (List) ((ProtoBuf$Function) proto).s(eVarG);
            }
        } else {
            if (!(proto instanceof ProtoBuf$Property)) {
                throw new IllegalStateException(("Unknown message: " + proto).toString());
            }
            int i10 = C0535a.f42586a[kind.ordinal()];
            if (i10 != 1 && i10 != 2 && i10 != 3) {
                throw new IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + kind).toString());
            }
            GeneratedMessageLite.e<ProtoBuf$Property, List<ProtoBuf$Annotation>> eVarL = this.f42585a.l();
            if (eVarL != null) {
                listM = (List) ((ProtoBuf$Property) proto).s(eVarL);
            }
        }
        if (listM == null) {
            listM = C1173v.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ProtoBuf$Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // ua.InterfaceC5621g
    public List<A> b(AbstractC5604N container, ProtoBuf$Property proto) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(proto, "proto");
        GeneratedMessageLite.e<ProtoBuf$Property, List<ProtoBuf$Annotation>> eVarK = this.f42585a.k();
        List listM = eVarK != null ? (List) proto.s(eVarK) : null;
        if (listM == null) {
            listM = C1173v.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ProtoBuf$Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // ua.InterfaceC5621g
    public List<A> c(ProtoBuf$TypeParameter proto, InterfaceC4020d nameResolver) {
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        List listM = (List) proto.s(this.f42585a.p());
        if (listM == null) {
            listM = C1173v.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ProtoBuf$Annotation) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // ua.InterfaceC5621g
    public List<A> d(AbstractC5604N container, ProtoBuf$Property proto) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(proto, "proto");
        GeneratedMessageLite.e<ProtoBuf$Property, List<ProtoBuf$Annotation>> eVarJ = this.f42585a.j();
        List listM = eVarJ != null ? (List) proto.s(eVarJ) : null;
        if (listM == null) {
            listM = C1173v.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ProtoBuf$Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // ua.InterfaceC5621g
    public List<A> e(AbstractC5604N.a container) {
        kotlin.jvm.internal.p.i(container, "container");
        List listM = (List) container.f().s(this.f42585a.a());
        if (listM == null) {
            listM = C1173v.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ProtoBuf$Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // ua.InterfaceC5621g
    public List<A> h(ProtoBuf$Type proto, InterfaceC4020d nameResolver) {
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        List listM = (List) proto.s(this.f42585a.o());
        if (listM == null) {
            listM = C1173v.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ProtoBuf$Annotation) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // ua.InterfaceC5621g
    public List<A> j(AbstractC5604N container, kotlin.reflect.jvm.internal.impl.protobuf.h callableProto, AnnotatedCallableKind kind, int i10, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(callableProto, "callableProto");
        kotlin.jvm.internal.p.i(kind, "kind");
        List<A> listK = protoBuf$ValueParameter != null ? k(container, callableProto, kind, i10, protoBuf$ValueParameter) : null;
        return listK == null ? C1173v.m() : listK;
    }

    @Override // ua.InterfaceC5621g
    public List<A> k(AbstractC5604N container, kotlin.reflect.jvm.internal.impl.protobuf.h callableProto, AnnotatedCallableKind kind, int i10, ProtoBuf$ValueParameter proto) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(callableProto, "callableProto");
        kotlin.jvm.internal.p.i(kind, "kind");
        kotlin.jvm.internal.p.i(proto, "proto");
        List listM = (List) proto.s(this.f42585a.h());
        if (listM == null) {
            listM = C1173v.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ProtoBuf$Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // ua.InterfaceC5621g
    public List<A> l(AbstractC5604N container, ProtoBuf$EnumEntry proto) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(proto, "proto");
        List listM = (List) proto.s(this.f42585a.d());
        if (listM == null) {
            listM = C1173v.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ProtoBuf$Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // ua.InterfaceC5621g
    public List<A> m(AbstractC5604N container, kotlin.reflect.jvm.internal.impl.protobuf.h proto, AnnotatedCallableKind kind) {
        List listM;
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(kind, "kind");
        if (proto instanceof ProtoBuf$Constructor) {
            listM = (List) ((ProtoBuf$Constructor) proto).s(this.f42585a.c());
        } else if (proto instanceof ProtoBuf$Function) {
            listM = (List) ((ProtoBuf$Function) proto).s(this.f42585a.f());
        } else {
            if (!(proto instanceof ProtoBuf$Property)) {
                throw new IllegalStateException(("Unknown message: " + proto).toString());
            }
            int i10 = C0535a.f42586a[kind.ordinal()];
            if (i10 == 1) {
                listM = (List) ((ProtoBuf$Property) proto).s(this.f42585a.i());
            } else if (i10 == 2) {
                listM = (List) ((ProtoBuf$Property) proto).s(this.f42585a.m());
            } else {
                if (i10 != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto");
                }
                listM = (List) ((ProtoBuf$Property) proto).s(this.f42585a.n());
            }
        }
        if (listM == null) {
            listM = C1173v.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ProtoBuf$Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    public final C5527a n() {
        return this.f42585a;
    }
}
