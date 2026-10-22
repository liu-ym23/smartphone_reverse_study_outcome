package kotlin.reflect.jvm.internal.impl.load.kotlin;

import C9.q;
import E9.W;
import ba.C1464a;
import ba.C1465b;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import ea.C4018b;
import fa.C4071h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.load.kotlin.f;
import kotlin.reflect.jvm.internal.impl.load.kotlin.g;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import ma.AbstractC4927g;
import ma.s;
import ua.AbstractC5604N;
import ua.InterfaceC5618d;
import xa.InterfaceC5863f;
import xa.InterfaceC5869l;
import ya.S;

/* loaded from: classes5.dex */
public abstract class a<A, C> extends AbstractBinaryClassAnnotationLoader<A, c<? extends A, ? extends C>> implements InterfaceC5618d<A, C> {

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5863f<f, c<A, C>> f35157c;

    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.a$a, reason: collision with other inner class name */
    public static final class C0440a implements f.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a<A, C> f35158a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap<g, List<A>> f35159b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f35160c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ HashMap<g, C> f35161d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ HashMap<g, C> f35162e;

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.a$a$a, reason: collision with other inner class name */
        public final class C0441a extends b implements f.e {

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ C0440a f35163d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0441a(C0440a c0440a, g signature) {
                super(c0440a, signature);
                p.i(signature, "signature");
                this.f35163d = c0440a;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.e
            public f.a c(int i10, ga.b classId, W source) {
                p.i(classId, "classId");
                p.i(source, "source");
                g gVarE = g.f35201b.e(d(), i10);
                List<A> arrayList = this.f35163d.f35159b.get(gVarE);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f35163d.f35159b.put(gVarE, arrayList);
                }
                return this.f35163d.f35158a.A(classId, source, arrayList);
            }
        }

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.a$a$b */
        public class b implements f.c {

            /* renamed from: a, reason: collision with root package name */
            public final g f35164a;

            /* renamed from: b, reason: collision with root package name */
            public final ArrayList<A> f35165b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ C0440a f35166c;

            public b(C0440a c0440a, g signature) {
                p.i(signature, "signature");
                this.f35166c = c0440a;
                this.f35164a = signature;
                this.f35165b = new ArrayList<>();
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.c
            public void a() {
                if (this.f35165b.isEmpty()) {
                    return;
                }
                this.f35166c.f35159b.put(this.f35164a, this.f35165b);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.c
            public f.a b(ga.b classId, W source) {
                p.i(classId, "classId");
                p.i(source, "source");
                return this.f35166c.f35158a.A(classId, source, this.f35165b);
            }

            public final g d() {
                return this.f35164a;
            }
        }

        public C0440a(a<A, C> aVar, HashMap<g, List<A>> map, f fVar, HashMap<g, C> map2, HashMap<g, C> map3) {
            this.f35158a = aVar;
            this.f35159b = map;
            this.f35160c = fVar;
            this.f35161d = map2;
            this.f35162e = map3;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.d
        public f.e a(ga.e name, String desc) {
            p.i(name, "name");
            p.i(desc, "desc");
            g.a aVar = g.f35201b;
            String strB = name.b();
            p.h(strB, "asString(...)");
            return new C0441a(this, aVar.d(strB, desc));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.d
        public f.c b(ga.e name, String desc, Object obj) {
            C cL;
            p.i(name, "name");
            p.i(desc, "desc");
            g.a aVar = g.f35201b;
            String strB = name.b();
            p.h(strB, "asString(...)");
            g gVarA = aVar.a(strB, desc);
            if (obj != null && (cL = this.f35158a.L(desc, obj)) != null) {
                this.f35162e.put(gVarA, cL);
            }
            return new b(this, gVarA);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(InterfaceC5869l storageManager, ba.p kotlinClassFinder) {
        super(kotlinClassFinder);
        p.i(storageManager, "storageManager");
        p.i(kotlinClassFinder, "kotlinClassFinder");
        this.f35157c = storageManager.c(new C1464a(this));
    }

    public static final Object J(c loadConstantFromProperty, g it) {
        p.i(loadConstantFromProperty, "$this$loadConstantFromProperty");
        p.i(it, "it");
        return loadConstantFromProperty.b().get(it);
    }

    public static final Object N(c loadConstantFromProperty, g it) {
        p.i(loadConstantFromProperty, "$this$loadConstantFromProperty");
        p.i(it, "it");
        return loadConstantFromProperty.c().get(it);
    }

    public static final c O(a aVar, f kotlinClass) {
        p.i(kotlinClass, "kotlinClass");
        return aVar.K(kotlinClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public c<A, C> r(f binaryClass) {
        p.i(binaryClass, "binaryClass");
        return this.f35157c.invoke(binaryClass);
    }

    public final boolean I(ga.b annotationClassId, Map<ga.e, ? extends AbstractC4927g<?>> arguments) {
        p.i(annotationClassId, "annotationClassId");
        p.i(arguments, "arguments");
        if (!p.d(annotationClassId, B9.a.f1474a.a())) {
            return false;
        }
        AbstractC4927g<?> abstractC4927g = arguments.get(ga.e.j(UxipConstants.f30680s));
        s sVar = abstractC4927g instanceof s ? (s) abstractC4927g : null;
        if (sVar == null) {
            return false;
        }
        s.b bVarB = sVar.b();
        s.b.C0474b c0474b = bVarB instanceof s.b.C0474b ? (s.b.C0474b) bVarB : null;
        if (c0474b == null) {
            return false;
        }
        return y(c0474b.b());
    }

    public final c<A, C> K(f fVar) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        fVar.a(new C0440a(this, map, fVar, map3, map2), s(fVar));
        return new c<>(map, map2, map3);
    }

    public abstract C L(String str, Object obj);

    public final C M(AbstractC5604N abstractC5604N, ProtoBuf$Property protoBuf$Property, AnnotatedCallableKind annotatedCallableKind, S s10, p9.p<? super c<? extends A, ? extends C>, ? super g, ? extends C> pVar) {
        C cInvoke;
        f fVarQ = q(abstractC5604N, AbstractBinaryClassAnnotationLoader.f35152b.a(abstractC5604N, true, true, C4018b.f32358D.d(protoBuf$Property.H0()), C4071h.f(protoBuf$Property), w(), x()));
        if (fVarQ == null) {
            return null;
        }
        g gVarT = t(protoBuf$Property, abstractC5604N.b(), abstractC5604N.d(), annotatedCallableKind, fVarQ.b().d().d(e.f35194b.a()));
        if (gVarT == null || (cInvoke = pVar.invoke(this.f35157c.invoke(fVarQ), gVarT)) == null) {
            return null;
        }
        return q.d(s10) ? P(cInvoke) : cInvoke;
    }

    public abstract C P(C c10);

    @Override // ua.InterfaceC5618d
    public C g(AbstractC5604N container, ProtoBuf$Property proto, S expectedType) {
        p.i(container, "container");
        p.i(proto, "proto");
        p.i(expectedType, "expectedType");
        return M(container, proto, AnnotatedCallableKind.PROPERTY_GETTER, expectedType, C1465b.f15325a);
    }

    @Override // ua.InterfaceC5618d
    public C i(AbstractC5604N container, ProtoBuf$Property proto, S expectedType) {
        p.i(container, "container");
        p.i(proto, "proto");
        p.i(expectedType, "expectedType");
        return M(container, proto, AnnotatedCallableKind.PROPERTY, expectedType, ba.c.f15326a);
    }
}
