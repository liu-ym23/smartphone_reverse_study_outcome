package C9;

import C9.o;
import E9.D;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0819y;
import E9.b0;
import Z8.C1172u;
import Z8.F;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.t;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import ra.InterfaceC5238k;
import w9.InterfaceC5752k;
import ya.C6004k0;
import ya.S;
import ya.V;
import ya.s0;

/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final D f1798a;

    /* renamed from: b, reason: collision with root package name */
    public final Y8.h f1799b;

    /* renamed from: c, reason: collision with root package name */
    public final a f1800c;

    /* renamed from: d, reason: collision with root package name */
    public final a f1801d;

    /* renamed from: e, reason: collision with root package name */
    public final a f1802e;

    /* renamed from: f, reason: collision with root package name */
    public final a f1803f;

    /* renamed from: g, reason: collision with root package name */
    public final a f1804g;

    /* renamed from: h, reason: collision with root package name */
    public final a f1805h;

    /* renamed from: i, reason: collision with root package name */
    public final a f1806i;

    /* renamed from: j, reason: collision with root package name */
    public final a f1807j;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f1797l = {t.i(new PropertyReference1Impl(n.class, "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), t.i(new PropertyReference1Impl(n.class, "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), t.i(new PropertyReference1Impl(n.class, "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), t.i(new PropertyReference1Impl(n.class, "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), t.i(new PropertyReference1Impl(n.class, "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), t.i(new PropertyReference1Impl(n.class, "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), t.i(new PropertyReference1Impl(n.class, "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), t.i(new PropertyReference1Impl(n.class, "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0))};

    /* renamed from: k, reason: collision with root package name */
    public static final b f1796k = new b(null);

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f1808a;

        public a(int i10) {
            this.f1808a = i10;
        }

        public final InterfaceC0797b a(n types, InterfaceC5752k<?> property) {
            kotlin.jvm.internal.p.i(types, "types");
            kotlin.jvm.internal.p.i(property, "property");
            return types.c(Ga.a.a(property.getName()), this.f1808a);
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final S a(InterfaceC0819y module) {
            kotlin.jvm.internal.p.i(module, "module");
            InterfaceC0797b interfaceC0797bB = FindClassInModuleKt.b(module, o.a.f1939w0);
            if (interfaceC0797bB == null) {
                return null;
            }
            s0 s0VarK = s0.f44124b.k();
            List<b0> parameters = interfaceC0797bB.j().getParameters();
            kotlin.jvm.internal.p.h(parameters, "getParameters(...)");
            Object objX0 = F.X0(parameters);
            kotlin.jvm.internal.p.h(objX0, "single(...)");
            return V.h(s0VarK, interfaceC0797bB, C1172u.e(new C6004k0((b0) objX0)));
        }

        public b() {
        }
    }

    public n(InterfaceC0819y module, D notFoundClasses) {
        kotlin.jvm.internal.p.i(module, "module");
        kotlin.jvm.internal.p.i(notFoundClasses, "notFoundClasses");
        this.f1798a = notFoundClasses;
        this.f1799b = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new m(module));
        this.f1800c = new a(1);
        this.f1801d = new a(1);
        this.f1802e = new a(1);
        this.f1803f = new a(2);
        this.f1804g = new a(3);
        this.f1805h = new a(1);
        this.f1806i = new a(2);
        this.f1807j = new a(3);
    }

    public static final InterfaceC5238k f(InterfaceC0819y interfaceC0819y) {
        return interfaceC0819y.f0(o.f1844y).m();
    }

    public final InterfaceC0797b c(String str, int i10) {
        ga.e eVarJ = ga.e.j(str);
        kotlin.jvm.internal.p.h(eVarJ, "identifier(...)");
        InterfaceC0799d interfaceC0799dD = e().d(eVarJ, NoLookupLocation.FROM_REFLECTION);
        InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
        return interfaceC0797b == null ? this.f1798a.d(new ga.b(o.f1844y, eVarJ), C1172u.e(Integer.valueOf(i10))) : interfaceC0797b;
    }

    public final InterfaceC0797b d() {
        return this.f1800c.a(this, f1797l[0]);
    }

    public final InterfaceC5238k e() {
        return (InterfaceC5238k) this.f1799b.getValue();
    }
}
