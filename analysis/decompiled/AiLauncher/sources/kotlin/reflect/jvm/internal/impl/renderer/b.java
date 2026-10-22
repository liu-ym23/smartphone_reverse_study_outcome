package kotlin.reflect.jvm.internal.impl.renderer;

import E9.InterfaceC0797b;
import E9.InterfaceC0800e;
import E9.InterfaceC0803h;
import E9.a0;
import E9.i0;
import Y8.t;
import Z8.Y;
import ja.C4789a;
import ja.e;
import ja.f;
import ja.g;
import ja.h;
import ja.j;
import ja.k;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.renderer.a;
import p9.InterfaceC5074l;
import ya.B0;
import ya.S;

/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f35910a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f35911b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f35912c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f35913d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f35914e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f35915f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f35916g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f35917h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f35918i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f35919j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f35920k;

    /* renamed from: l, reason: collision with root package name */
    public static final b f35921l;

    public static final class a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.b$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0454a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f35922a;

            static {
                int[] iArr = new int[ClassKind.values().length];
                try {
                    iArr[ClassKind.CLASS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ClassKind.INTERFACE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ClassKind.ENUM_CLASS.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ClassKind.OBJECT.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ClassKind.ENUM_ENTRY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f35922a = iArr;
            }
        }

        public /* synthetic */ a(i iVar) {
            this();
        }

        public final String a(InterfaceC0800e classifier) {
            p.i(classifier, "classifier");
            if (classifier instanceof a0) {
                return "typealias";
            }
            if (!(classifier instanceof InterfaceC0797b)) {
                throw new AssertionError("Unexpected classifier: " + classifier);
            }
            InterfaceC0797b interfaceC0797b = (InterfaceC0797b) classifier;
            if (interfaceC0797b.W()) {
                return "companion object";
            }
            switch (C0454a.f35922a[interfaceC0797b.getKind().ordinal()]) {
                case 1:
                    return "class";
                case 2:
                    return "interface";
                case 3:
                    return "enum class";
                case 4:
                    return "object";
                case 5:
                    return "annotation class";
                case 6:
                    return "enum entry";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final b b(InterfaceC5074l<? super c, t> changeOptions) {
            p.i(changeOptions, "changeOptions");
            d dVar = new d();
            changeOptions.invoke(dVar);
            dVar.q0();
            return new DescriptorRendererImpl(dVar);
        }

        public a() {
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.b$b, reason: collision with other inner class name */
    public interface InterfaceC0455b {

        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.b$b$a */
        public static final class a implements InterfaceC0455b {

            /* renamed from: a, reason: collision with root package name */
            public static final a f35923a = new a();

            @Override // kotlin.reflect.jvm.internal.impl.renderer.b.InterfaceC0455b
            public void a(int i10, StringBuilder builder) {
                p.i(builder, "builder");
                builder.append("(");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.b.InterfaceC0455b
            public void b(i0 parameter, int i10, int i11, StringBuilder builder) {
                p.i(parameter, "parameter");
                p.i(builder, "builder");
                if (i10 != i11 - 1) {
                    builder.append(", ");
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.b.InterfaceC0455b
            public void c(int i10, StringBuilder builder) {
                p.i(builder, "builder");
                builder.append(")");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.b.InterfaceC0455b
            public void d(i0 parameter, int i10, int i11, StringBuilder builder) {
                p.i(parameter, "parameter");
                p.i(builder, "builder");
            }
        }

        void a(int i10, StringBuilder sb2);

        void b(i0 i0Var, int i10, int i11, StringBuilder sb2);

        void c(int i10, StringBuilder sb2);

        void d(i0 i0Var, int i10, int i11, StringBuilder sb2);
    }

    static {
        a aVar = new a(null);
        f35910a = aVar;
        f35911b = aVar.b(C4789a.f34537a);
        f35912c = aVar.b(ja.c.f34539a);
        f35913d = aVar.b(ja.d.f34540a);
        f35914e = aVar.b(e.f34541a);
        f35915f = aVar.b(f.f34542a);
        f35916g = aVar.b(g.f34543a);
        f35917h = aVar.b(h.f34544a);
        f35918i = aVar.b(ja.i.f34545a);
        f35919j = aVar.b(j.f34546a);
        f35920k = aVar.b(k.f34547a);
        f35921l = aVar.b(ja.b.f34538a);
    }

    public static final t A(c withOptions) {
        p.i(withOptions, "$this$withOptions");
        withOptions.l(Y.e());
        return t.f7040a;
    }

    public static /* synthetic */ String O(b bVar, F9.c cVar, AnnotationUseSiteTarget annotationUseSiteTarget, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        }
        if ((i10 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        return bVar.N(cVar, annotationUseSiteTarget);
    }

    public static final t q(c withOptions) {
        p.i(withOptions, "$this$withOptions");
        withOptions.c(false);
        withOptions.l(Y.e());
        return t.f7040a;
    }

    public static final t r(c withOptions) {
        p.i(withOptions, "$this$withOptions");
        withOptions.c(false);
        withOptions.l(Y.e());
        withOptions.e(true);
        return t.f7040a;
    }

    public static final t s(c withOptions) {
        p.i(withOptions, "$this$withOptions");
        withOptions.c(false);
        return t.f7040a;
    }

    public static final t t(c withOptions) {
        p.i(withOptions, "$this$withOptions");
        withOptions.l(Y.e());
        withOptions.m(a.b.f35908a);
        withOptions.b(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return t.f7040a;
    }

    public static final t u(c withOptions) {
        p.i(withOptions, "$this$withOptions");
        withOptions.n(true);
        withOptions.m(a.C0453a.f35907a);
        withOptions.l(DescriptorRendererModifier.ALL);
        return t.f7040a;
    }

    public static final t v(c withOptions) {
        p.i(withOptions, "$this$withOptions");
        withOptions.l(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        return t.f7040a;
    }

    public static final t w(c withOptions) {
        p.i(withOptions, "$this$withOptions");
        withOptions.l(DescriptorRendererModifier.ALL);
        return t.f7040a;
    }

    public static final t x(c withOptions) {
        p.i(withOptions, "$this$withOptions");
        withOptions.g(RenderingFormat.HTML);
        withOptions.l(DescriptorRendererModifier.ALL);
        return t.f7040a;
    }

    public static final t y(c withOptions) {
        p.i(withOptions, "$this$withOptions");
        withOptions.c(false);
        withOptions.l(Y.e());
        withOptions.m(a.b.f35908a);
        withOptions.p(true);
        withOptions.b(ParameterNameRenderingPolicy.NONE);
        withOptions.f(true);
        withOptions.o(true);
        withOptions.e(true);
        withOptions.a(true);
        return t.f7040a;
    }

    public static final t z(c withOptions) {
        p.i(withOptions, "$this$withOptions");
        withOptions.m(a.b.f35908a);
        withOptions.b(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return t.f7040a;
    }

    public abstract String M(InterfaceC0803h interfaceC0803h);

    public abstract String N(F9.c cVar, AnnotationUseSiteTarget annotationUseSiteTarget);

    public abstract String P(String str, String str2, C9.j jVar);

    public abstract String Q(ga.d dVar);

    public abstract String R(ga.e eVar, boolean z10);

    public abstract String S(S s10);

    public abstract String T(B0 b02);

    public final b U(InterfaceC5074l<? super c, t> changeOptions) {
        p.i(changeOptions, "changeOptions");
        p.g(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        d dVarS = ((DescriptorRendererImpl) this).N0().s();
        changeOptions.invoke(dVarS);
        dVarS.q0();
        return new DescriptorRendererImpl(dVarS);
    }
}
