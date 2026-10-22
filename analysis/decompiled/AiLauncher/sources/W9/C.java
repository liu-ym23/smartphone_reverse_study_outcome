package W9;

import E9.InterfaceC0797b;
import Z8.C1173v;
import Z8.C1174w;
import ea.C4019c;
import ga.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import pa.C5080d;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;

/* loaded from: classes5.dex */
public final class C extends H9.H {

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f6668o = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(C.class, "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(C.class, "partToFacade", "getPartToFacade()Ljava/util/HashMap;", 0))};

    /* renamed from: g, reason: collision with root package name */
    public final Z9.u f6669g;

    /* renamed from: h, reason: collision with root package name */
    public final V9.k f6670h;

    /* renamed from: i, reason: collision with root package name */
    public final C4019c f6671i;

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC5865h f6672j;

    /* renamed from: k, reason: collision with root package name */
    public final C1097f f6673k;

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC5865h<List<ga.c>> f6674l;

    /* renamed from: m, reason: collision with root package name */
    public final F9.g f6675m;

    /* renamed from: n, reason: collision with root package name */
    public final InterfaceC5865h f6676n;

    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6677a;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f6677a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(V9.k outerContext, Z9.u jPackage) {
        super(outerContext.d(), jPackage.f());
        kotlin.jvm.internal.p.i(outerContext, "outerContext");
        kotlin.jvm.internal.p.i(jPackage, "jPackage");
        this.f6669g = jPackage;
        V9.k kVarF = V9.c.f(outerContext, this, null, 0, 6, null);
        this.f6670h = kVarF;
        this.f6671i = outerContext.a().b().f().g().d();
        this.f6672j = kVarF.e().i(new C1116z(this));
        this.f6673k = new C1097f(kVarF, jPackage, this);
        this.f6674l = kVarF.e().d(new A(this), C1173v.m());
        this.f6675m = kVarF.a().i().a() ? F9.g.f2609m0.b() : V9.h.a(kVarF, jPackage);
        this.f6676n = kVarF.e().i(new B(this));
    }

    public static final Map G0(C c10) {
        List<String> listA = c10.f6670h.a().o().a(c10.f().a());
        ArrayList arrayList = new ArrayList();
        for (String str : listA) {
            b.a aVar = ga.b.f32721d;
            ga.c cVarE = C5080d.d(str).e();
            kotlin.jvm.internal.p.h(cVarE, "getFqNameForTopLevelClassMaybeWithDollars(...)");
            kotlin.reflect.jvm.internal.impl.load.kotlin.f fVarB = ba.q.b(c10.f6670h.a().j(), aVar.c(cVarE), c10.f6671i);
            Pair pairA = fVarB != null ? Y8.j.a(str, fVarB) : null;
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        return kotlin.collections.a.y(arrayList);
    }

    public static final HashMap L0(C c10) {
        HashMap map = new HashMap();
        for (Map.Entry<String, kotlin.reflect.jvm.internal.impl.load.kotlin.f> entry : c10.I0().entrySet()) {
            String key = entry.getKey();
            kotlin.reflect.jvm.internal.impl.load.kotlin.f value = entry.getValue();
            C5080d c5080dD = C5080d.d(key);
            kotlin.jvm.internal.p.h(c5080dD, "byInternalName(...)");
            KotlinClassHeader kotlinClassHeaderB = value.b();
            int i10 = a.f6677a[kotlinClassHeaderB.c().ordinal()];
            if (i10 == 1) {
                String strE = kotlinClassHeaderB.e();
                if (strE != null) {
                    map.put(c5080dD, C5080d.d(strE));
                }
            } else if (i10 == 2) {
                map.put(c5080dD, c5080dD);
            }
        }
        return map;
    }

    public static final List M0(C c10) {
        Collection<Z9.u> collectionU = c10.f6669g.u();
        ArrayList arrayList = new ArrayList(C1174w.x(collectionU, 10));
        Iterator<T> it = collectionU.iterator();
        while (it.hasNext()) {
            arrayList.add(((Z9.u) it.next()).f());
        }
        return arrayList;
    }

    public final InterfaceC0797b H0(Z9.g jClass) {
        kotlin.jvm.internal.p.i(jClass, "jClass");
        return this.f6673k.h().j0(jClass);
    }

    public final Map<String, kotlin.reflect.jvm.internal.impl.load.kotlin.f> I0() {
        return (Map) C5868k.a(this.f6672j, this, f6668o[0]);
    }

    @Override // E9.E
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public C1097f m() {
        return this.f6673k;
    }

    public final List<ga.c> K0() {
        return this.f6674l.invoke();
    }

    @Override // H9.H, H9.AbstractC0835n, E9.InterfaceC0806k
    public E9.W e() {
        return new ba.r(this);
    }

    @Override // F9.b, F9.a
    public F9.g getAnnotations() {
        return this.f6675m;
    }

    @Override // H9.H, H9.AbstractC0834m
    public String toString() {
        return "Lazy Java package fragment: " + f() + " of module " + this.f6670h.a().m();
    }
}
