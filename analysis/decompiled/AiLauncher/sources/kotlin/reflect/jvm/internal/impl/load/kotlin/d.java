package kotlin.reflect.jvm.internal.impl.load.kotlin;

import E9.D;
import E9.InterfaceC0797b;
import E9.InterfaceC0819y;
import E9.W;
import E9.i0;
import La.H;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import ea.C4019c;
import ea.InterfaceC4020d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.f;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import ma.AbstractC4927g;
import ma.C4916A;
import ma.C4917B;
import ma.C4918C;
import ma.C4919D;
import ma.C4921a;
import ma.C4924d;
import ma.C4926f;
import ma.C4929i;
import ma.k;
import ma.l;
import ma.n;
import ma.s;
import ma.t;
import ma.w;
import ua.C5620f;
import xa.InterfaceC5869l;
import ya.S;

/* loaded from: classes5.dex */
public final class d extends kotlin.reflect.jvm.internal.impl.load.kotlin.a<F9.c, AbstractC4927g<?>> {

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0819y f35170d;

    /* renamed from: e, reason: collision with root package name */
    public final D f35171e;

    /* renamed from: f, reason: collision with root package name */
    public final C5620f f35172f;

    /* renamed from: g, reason: collision with root package name */
    public C4019c f35173g;

    public abstract class a implements f.a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.d$a$a, reason: collision with other inner class name */
        public static final class C0442a implements f.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f.a f35175a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f.a f35176b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f35177c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ga.e f35178d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ ArrayList<F9.c> f35179e;

            public C0442a(f.a aVar, a aVar2, ga.e eVar, ArrayList<F9.c> arrayList) {
                this.f35176b = aVar;
                this.f35177c = aVar2;
                this.f35178d = eVar;
                this.f35179e = arrayList;
                this.f35175a = aVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
            public void a() {
                this.f35176b.a();
                this.f35177c.h(this.f35178d, new C4921a((F9.c) F.X0(this.f35179e)));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
            public void b(ga.e eVar, ga.b enumClassId, ga.e enumEntryName) {
                p.i(enumClassId, "enumClassId");
                p.i(enumEntryName, "enumEntryName");
                this.f35175a.b(eVar, enumClassId, enumEntryName);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
            public void c(ga.e eVar, Object obj) {
                this.f35175a.c(eVar, obj);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
            public void d(ga.e eVar, C4926f value) {
                p.i(value, "value");
                this.f35175a.d(eVar, value);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
            public f.b e(ga.e eVar) {
                return this.f35175a.e(eVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
            public f.a f(ga.e eVar, ga.b classId) {
                p.i(classId, "classId");
                return this.f35175a.f(eVar, classId);
            }
        }

        public static final class b implements f.b {

            /* renamed from: a, reason: collision with root package name */
            public final ArrayList<AbstractC4927g<?>> f35180a = new ArrayList<>();

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f35181b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ga.e f35182c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f35183d;

            /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.d$a$b$a, reason: collision with other inner class name */
            public static final class C0443a implements f.a {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ f.a f35184a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ f.a f35185b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ b f35186c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ ArrayList<F9.c> f35187d;

                public C0443a(f.a aVar, b bVar, ArrayList<F9.c> arrayList) {
                    this.f35185b = aVar;
                    this.f35186c = bVar;
                    this.f35187d = arrayList;
                    this.f35184a = aVar;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
                public void a() {
                    this.f35185b.a();
                    this.f35186c.f35180a.add(new C4921a((F9.c) F.X0(this.f35187d)));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
                public void b(ga.e eVar, ga.b enumClassId, ga.e enumEntryName) {
                    p.i(enumClassId, "enumClassId");
                    p.i(enumEntryName, "enumEntryName");
                    this.f35184a.b(eVar, enumClassId, enumEntryName);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
                public void c(ga.e eVar, Object obj) {
                    this.f35184a.c(eVar, obj);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
                public void d(ga.e eVar, C4926f value) {
                    p.i(value, "value");
                    this.f35184a.d(eVar, value);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
                public f.b e(ga.e eVar) {
                    return this.f35184a.e(eVar);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
                public f.a f(ga.e eVar, ga.b classId) {
                    p.i(classId, "classId");
                    return this.f35184a.f(eVar, classId);
                }
            }

            public b(d dVar, ga.e eVar, a aVar) {
                this.f35181b = dVar;
                this.f35182c = eVar;
                this.f35183d = aVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.b
            public void a() {
                this.f35183d.g(this.f35182c, this.f35180a);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.b
            public void b(C4926f value) {
                p.i(value, "value");
                this.f35180a.add(new s(value));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.b
            public void c(ga.b enumClassId, ga.e enumEntryName) {
                p.i(enumClassId, "enumClassId");
                p.i(enumEntryName, "enumEntryName");
                this.f35180a.add(new k(enumClassId, enumEntryName));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.b
            public f.a d(ga.b classId) {
                p.i(classId, "classId");
                ArrayList arrayList = new ArrayList();
                d dVar = this.f35181b;
                W NO_SOURCE = W.f2444a;
                p.h(NO_SOURCE, "NO_SOURCE");
                f.a aVarZ = dVar.z(classId, NO_SOURCE, arrayList);
                p.f(aVarZ);
                return new C0443a(aVarZ, this, arrayList);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.b
            public void e(Object obj) {
                this.f35180a.add(this.f35181b.R(this.f35182c, obj));
            }
        }

        public a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void b(ga.e eVar, ga.b enumClassId, ga.e enumEntryName) {
            p.i(enumClassId, "enumClassId");
            p.i(enumEntryName, "enumEntryName");
            h(eVar, new k(enumClassId, enumEntryName));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void c(ga.e eVar, Object obj) {
            h(eVar, d.this.R(eVar, obj));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void d(ga.e eVar, C4926f value) {
            p.i(value, "value");
            h(eVar, new s(value));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public f.b e(ga.e eVar) {
            return new b(d.this, eVar, this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public f.a f(ga.e eVar, ga.b classId) {
            p.i(classId, "classId");
            ArrayList arrayList = new ArrayList();
            d dVar = d.this;
            W NO_SOURCE = W.f2444a;
            p.h(NO_SOURCE, "NO_SOURCE");
            f.a aVarZ = dVar.z(classId, NO_SOURCE, arrayList);
            p.f(aVarZ);
            return new C0442a(aVarZ, this, eVar, arrayList);
        }

        public abstract void g(ga.e eVar, ArrayList<AbstractC4927g<?>> arrayList);

        public abstract void h(ga.e eVar, AbstractC4927g<?> abstractC4927g);
    }

    public static final class b extends a {

        /* renamed from: b, reason: collision with root package name */
        public final HashMap<ga.e, AbstractC4927g<?>> f35188b;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0797b f35190d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ga.b f35191e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ List<F9.c> f35192f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ W f35193g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC0797b interfaceC0797b, ga.b bVar, List<F9.c> list, W w10) {
            super();
            this.f35190d = interfaceC0797b;
            this.f35191e = bVar;
            this.f35192f = list;
            this.f35193g = w10;
            this.f35188b = new HashMap<>();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void a() {
            if (d.this.I(this.f35191e, this.f35188b) || d.this.y(this.f35191e)) {
                return;
            }
            this.f35192f.add(new F9.d(this.f35190d.n(), this.f35188b, this.f35193g));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.d.a
        public void g(ga.e eVar, ArrayList<AbstractC4927g<?>> elements) {
            p.i(elements, "elements");
            if (eVar == null) {
                return;
            }
            i0 i0VarB = T9.a.b(eVar, this.f35190d);
            if (i0VarB != null) {
                HashMap<ga.e, AbstractC4927g<?>> map = this.f35188b;
                C4929i c4929i = C4929i.f37195a;
                List<? extends AbstractC4927g<?>> listC = Ia.a.c(elements);
                S type = i0VarB.getType();
                p.h(type, "getType(...)");
                map.put(eVar, c4929i.c(listC, type));
                return;
            }
            if (d.this.y(this.f35191e) && p.d(eVar.b(), UxipConstants.f30680s)) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : elements) {
                    if (obj instanceof C4921a) {
                        arrayList.add(obj);
                    }
                }
                List<F9.c> list = this.f35192f;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    list.add(((C4921a) it.next()).b());
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.d.a
        public void h(ga.e eVar, AbstractC4927g<?> value) {
            p.i(value, "value");
            if (eVar != null) {
                this.f35188b.put(eVar, value);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(InterfaceC0819y module, D notFoundClasses, InterfaceC5869l storageManager, ba.p kotlinClassFinder) {
        super(storageManager, kotlinClassFinder);
        p.i(module, "module");
        p.i(notFoundClasses, "notFoundClasses");
        p.i(storageManager, "storageManager");
        p.i(kotlinClassFinder, "kotlinClassFinder");
        this.f35170d = module;
        this.f35171e = notFoundClasses;
        this.f35172f = new C5620f(module, notFoundClasses);
        this.f35173g = C4019c.f32404i;
    }

    public final AbstractC4927g<?> R(ga.e eVar, Object obj) {
        AbstractC4927g<?> abstractC4927gE = C4929i.f37195a.e(obj, this.f35170d);
        if (abstractC4927gE != null) {
            return abstractC4927gE;
        }
        return l.f37198b.a("Unsupported annotation argument: " + eVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader, ua.InterfaceC5621g
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public F9.c f(ProtoBuf$Annotation proto, InterfaceC4020d nameResolver) {
        p.i(proto, "proto");
        p.i(nameResolver, "nameResolver");
        return this.f35172f.a(proto, nameResolver);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public AbstractC4927g<?> L(String desc, Object initializer) {
        p.i(desc, "desc");
        p.i(initializer, "initializer");
        if (H.g0("ZBCS", desc, false, 2, null)) {
            int iIntValue = ((Integer) initializer).intValue();
            int iHashCode = desc.hashCode();
            if (iHashCode == 66) {
                if (desc.equals("B")) {
                    initializer = Byte.valueOf((byte) iIntValue);
                }
                throw new AssertionError(desc);
            }
            if (iHashCode == 67) {
                if (desc.equals("C")) {
                    initializer = Character.valueOf((char) iIntValue);
                }
                throw new AssertionError(desc);
            }
            if (iHashCode == 83) {
                if (desc.equals(ExifInterface.LATITUDE_SOUTH)) {
                    initializer = Short.valueOf((short) iIntValue);
                }
                throw new AssertionError(desc);
            }
            if (iHashCode == 90 && desc.equals("Z")) {
                initializer = Boolean.valueOf(iIntValue != 0);
            }
            throw new AssertionError(desc);
        }
        return C4929i.f37195a.e(initializer, this.f35170d);
    }

    public final InterfaceC0797b U(ga.b bVar) {
        return FindClassInModuleKt.d(this.f35170d, bVar, this.f35171e);
    }

    public void V(C4019c c4019c) {
        p.i(c4019c, "<set-?>");
        this.f35173g = c4019c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public AbstractC4927g<?> P(AbstractC4927g<?> constant) {
        p.i(constant, "constant");
        return constant instanceof C4924d ? new C4916A(((C4924d) constant).b().byteValue()) : constant instanceof w ? new C4919D(((w) constant).b().shortValue()) : constant instanceof n ? new C4917B(((n) constant).b().intValue()) : constant instanceof t ? new C4918C(((t) constant).b().longValue()) : constant;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public C4019c x() {
        return this.f35173g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public f.a z(ga.b annotationClassId, W source, List<F9.c> result) {
        p.i(annotationClassId, "annotationClassId");
        p.i(source, "source");
        p.i(result, "result");
        return new b(U(annotationClassId), annotationClassId, result, source);
    }
}
