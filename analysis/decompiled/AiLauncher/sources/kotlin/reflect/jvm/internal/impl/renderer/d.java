package kotlin.reflect.jvm.internal.impl.renderer;

import E9.i0;
import La.D;
import Z8.Y;
import ja.u;
import ja.v;
import java.lang.reflect.Field;
import java.util.Set;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import kotlin.reflect.jvm.internal.impl.renderer.a;
import kotlin.reflect.jvm.internal.impl.renderer.b;
import kotlin.reflect.jvm.internal.impl.renderer.c;
import ma.AbstractC4927g;
import p9.InterfaceC5074l;
import s9.C5449a;
import s9.InterfaceC5453e;
import s9.ObservableProperty;
import w9.InterfaceC5745d;
import w9.InterfaceC5752k;
import ya.S;

/* loaded from: classes5.dex */
public final class d implements c {

    /* renamed from: Z, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f35924Z = {t.f(new MutablePropertyReference1Impl(d.class, "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "withDefinedIn", "getWithDefinedIn()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "modifiers", "getModifiers()Ljava/util/Set;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "startFromName", "getStartFromName()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "debugMode", "getDebugMode()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "verbose", "getVerbose()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "unitReturnType", "getUnitReturnType()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "withoutReturnType", "getWithoutReturnType()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "enhancedTypes", "getEnhancedTypes()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "normalizedVisibilities", "getNormalizedVisibilities()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "renderDefaultVisibility", "getRenderDefaultVisibility()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "renderDefaultModality", "getRenderDefaultModality()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "renderConstructorDelegation", "getRenderConstructorDelegation()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "includePropertyConstant", "getIncludePropertyConstant()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "propertyConstantRenderer", "getPropertyConstantRenderer()Lkotlin/jvm/functions/Function1;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "withoutTypeParameters", "getWithoutTypeParameters()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "withoutSuperTypes", "getWithoutSuperTypes()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "receiverAfterName", "getReceiverAfterName()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "renderCompanionObjectName", "getRenderCompanionObjectName()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;", 0)), t.f(new MutablePropertyReference1Impl(d.class, "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "renderConstructorKeyword", "getRenderConstructorKeyword()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "renderTypeExpansions", "getRenderTypeExpansions()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "renderAbbreviatedTypeComments", "getRenderAbbreviatedTypeComments()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "renderFunctionContracts", "getRenderFunctionContracts()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z", 0)), t.f(new MutablePropertyReference1Impl(d.class, "informativeErrorType", "getInformativeErrorType()Z", 0))};

    /* renamed from: A, reason: collision with root package name */
    public final InterfaceC5453e f35925A;

    /* renamed from: B, reason: collision with root package name */
    public final InterfaceC5453e f35926B;

    /* renamed from: C, reason: collision with root package name */
    public final InterfaceC5453e f35927C;

    /* renamed from: D, reason: collision with root package name */
    public final InterfaceC5453e f35928D;

    /* renamed from: E, reason: collision with root package name */
    public final InterfaceC5453e f35929E;

    /* renamed from: F, reason: collision with root package name */
    public final InterfaceC5453e f35930F;

    /* renamed from: G, reason: collision with root package name */
    public final InterfaceC5453e f35931G;

    /* renamed from: H, reason: collision with root package name */
    public final InterfaceC5453e f35932H;

    /* renamed from: I, reason: collision with root package name */
    public final InterfaceC5453e f35933I;

    /* renamed from: J, reason: collision with root package name */
    public final InterfaceC5453e f35934J;

    /* renamed from: K, reason: collision with root package name */
    public final InterfaceC5453e f35935K;

    /* renamed from: L, reason: collision with root package name */
    public final InterfaceC5453e f35936L;

    /* renamed from: M, reason: collision with root package name */
    public final InterfaceC5453e f35937M;

    /* renamed from: N, reason: collision with root package name */
    public final InterfaceC5453e f35938N;

    /* renamed from: O, reason: collision with root package name */
    public final InterfaceC5453e f35939O;

    /* renamed from: P, reason: collision with root package name */
    public final InterfaceC5453e f35940P;

    /* renamed from: Q, reason: collision with root package name */
    public final InterfaceC5453e f35941Q;

    /* renamed from: R, reason: collision with root package name */
    public final InterfaceC5453e f35942R;

    /* renamed from: S, reason: collision with root package name */
    public final InterfaceC5453e f35943S;

    /* renamed from: T, reason: collision with root package name */
    public final InterfaceC5453e f35944T;

    /* renamed from: U, reason: collision with root package name */
    public final InterfaceC5453e f35945U;

    /* renamed from: V, reason: collision with root package name */
    public final InterfaceC5453e f35946V;

    /* renamed from: W, reason: collision with root package name */
    public final InterfaceC5453e f35947W;

    /* renamed from: X, reason: collision with root package name */
    public final InterfaceC5453e f35948X;

    /* renamed from: Y, reason: collision with root package name */
    public final InterfaceC5453e f35949Y;

    /* renamed from: a, reason: collision with root package name */
    public boolean f35950a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5453e f35951b = r0(a.c.f35909a);

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5453e f35952c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5453e f35953d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5453e f35954e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC5453e f35955f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC5453e f35956g;

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceC5453e f35957h;

    /* renamed from: i, reason: collision with root package name */
    public final InterfaceC5453e f35958i;

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC5453e f35959j;

    /* renamed from: k, reason: collision with root package name */
    public final InterfaceC5453e f35960k;

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC5453e f35961l;

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceC5453e f35962m;

    /* renamed from: n, reason: collision with root package name */
    public final InterfaceC5453e f35963n;

    /* renamed from: o, reason: collision with root package name */
    public final InterfaceC5453e f35964o;

    /* renamed from: p, reason: collision with root package name */
    public final InterfaceC5453e f35965p;

    /* renamed from: q, reason: collision with root package name */
    public final InterfaceC5453e f35966q;

    /* renamed from: r, reason: collision with root package name */
    public final InterfaceC5453e f35967r;

    /* renamed from: s, reason: collision with root package name */
    public final InterfaceC5453e f35968s;

    /* renamed from: t, reason: collision with root package name */
    public final InterfaceC5453e f35969t;

    /* renamed from: u, reason: collision with root package name */
    public final InterfaceC5453e f35970u;

    /* renamed from: v, reason: collision with root package name */
    public final InterfaceC5453e f35971v;

    /* renamed from: w, reason: collision with root package name */
    public final InterfaceC5453e f35972w;

    /* renamed from: x, reason: collision with root package name */
    public final InterfaceC5453e f35973x;

    /* renamed from: y, reason: collision with root package name */
    public final InterfaceC5453e f35974y;

    /* renamed from: z, reason: collision with root package name */
    public final InterfaceC5453e f35975z;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> extends ObservableProperty<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f35976a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, d dVar) {
            super(obj);
            this.f35976a = dVar;
        }

        @Override // s9.ObservableProperty
        public boolean beforeChange(InterfaceC5752k<?> property, T t10, T t11) {
            p.i(property, "property");
            if (this.f35976a.p0()) {
                throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
            }
            return true;
        }
    }

    public d() {
        Boolean bool = Boolean.TRUE;
        this.f35952c = r0(bool);
        this.f35953d = r0(bool);
        this.f35954e = r0(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        Boolean bool2 = Boolean.FALSE;
        this.f35955f = r0(bool2);
        this.f35956g = r0(bool2);
        this.f35957h = r0(bool2);
        this.f35958i = r0(bool2);
        this.f35959j = r0(bool2);
        this.f35960k = r0(bool);
        this.f35961l = r0(bool2);
        this.f35962m = r0(bool2);
        this.f35963n = r0(bool2);
        this.f35964o = r0(bool);
        this.f35965p = r0(bool);
        this.f35966q = r0(bool2);
        this.f35967r = r0(bool2);
        this.f35968s = r0(bool2);
        this.f35969t = r0(bool2);
        this.f35970u = r0(bool2);
        this.f35971v = r0(null);
        this.f35972w = r0(bool2);
        this.f35973x = r0(bool2);
        this.f35974y = r0(ja.t.f34558a);
        this.f35975z = r0(u.f34559a);
        this.f35925A = r0(bool);
        this.f35926B = r0(OverrideRenderingPolicy.RENDER_OPEN);
        this.f35927C = r0(b.InterfaceC0455b.a.f35923a);
        this.f35928D = r0(RenderingFormat.PLAIN);
        this.f35929E = r0(ParameterNameRenderingPolicy.ALL);
        this.f35930F = r0(bool2);
        this.f35931G = r0(bool2);
        this.f35932H = r0(PropertyAccessorRenderingPolicy.DEBUG);
        this.f35933I = r0(bool2);
        this.f35934J = r0(bool2);
        this.f35935K = r0(Y.e());
        this.f35936L = r0(v.f34560a.a());
        this.f35937M = r0(null);
        this.f35938N = r0(AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS);
        this.f35939O = r0(bool2);
        this.f35940P = r0(bool);
        this.f35941Q = r0(bool);
        this.f35942R = r0(bool2);
        this.f35943S = r0(bool2);
        this.f35944T = r0(bool);
        this.f35945U = r0(bool);
        this.f35946V = r0(bool2);
        this.f35947W = r0(bool2);
        this.f35948X = r0(bool2);
        this.f35949Y = r0(bool);
    }

    public static final S s0(S it) {
        p.i(it, "it");
        return it;
    }

    public static final String t(i0 it) {
        p.i(it, "it");
        return "...";
    }

    public InterfaceC5074l<i0, String> A() {
        return (InterfaceC5074l) this.f35975z.getValue(this, f35924Z[24]);
    }

    public boolean B() {
        return ((Boolean) this.f35934J.getValue(this, f35924Z[34])).booleanValue();
    }

    public Set<ga.c> C() {
        return (Set) this.f35935K.getValue(this, f35924Z[35]);
    }

    public boolean D() {
        return ((Boolean) this.f35944T.getValue(this, f35924Z[44])).booleanValue();
    }

    public /* bridge */ boolean E() {
        return c.a.a(this);
    }

    public /* bridge */ boolean F() {
        return c.a.b(this);
    }

    public boolean G() {
        return ((Boolean) this.f35970u.getValue(this, f35924Z[19])).booleanValue();
    }

    public boolean H() {
        return ((Boolean) this.f35949Y.getValue(this, f35924Z[49])).booleanValue();
    }

    public Set<DescriptorRendererModifier> I() {
        return (Set) this.f35954e.getValue(this, f35924Z[3]);
    }

    public boolean J() {
        return ((Boolean) this.f35963n.getValue(this, f35924Z[12])).booleanValue();
    }

    public OverrideRenderingPolicy K() {
        return (OverrideRenderingPolicy) this.f35926B.getValue(this, f35924Z[26]);
    }

    public ParameterNameRenderingPolicy L() {
        return (ParameterNameRenderingPolicy) this.f35929E.getValue(this, f35924Z[29]);
    }

    public boolean M() {
        return ((Boolean) this.f35945U.getValue(this, f35924Z[45])).booleanValue();
    }

    public boolean N() {
        return ((Boolean) this.f35947W.getValue(this, f35924Z[47])).booleanValue();
    }

    public PropertyAccessorRenderingPolicy O() {
        return (PropertyAccessorRenderingPolicy) this.f35932H.getValue(this, f35924Z[32]);
    }

    public InterfaceC5074l<AbstractC4927g<?>, String> P() {
        return (InterfaceC5074l) this.f35971v.getValue(this, f35924Z[20]);
    }

    public boolean Q() {
        return ((Boolean) this.f35930F.getValue(this, f35924Z[30])).booleanValue();
    }

    public boolean R() {
        return ((Boolean) this.f35943S.getValue(this, f35924Z[43])).booleanValue();
    }

    public boolean S() {
        return ((Boolean) this.f35931G.getValue(this, f35924Z[31])).booleanValue();
    }

    public boolean T() {
        return ((Boolean) this.f35966q.getValue(this, f35924Z[15])).booleanValue();
    }

    public boolean U() {
        return ((Boolean) this.f35940P.getValue(this, f35924Z[40])).booleanValue();
    }

    public boolean V() {
        return ((Boolean) this.f35933I.getValue(this, f35924Z[33])).booleanValue();
    }

    public boolean W() {
        return ((Boolean) this.f35965p.getValue(this, f35924Z[14])).booleanValue();
    }

    public boolean X() {
        return ((Boolean) this.f35964o.getValue(this, f35924Z[13])).booleanValue();
    }

    public boolean Y() {
        return ((Boolean) this.f35967r.getValue(this, f35924Z[16])).booleanValue();
    }

    public boolean Z() {
        return ((Boolean) this.f35942R.getValue(this, f35924Z[42])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void a(boolean z10) {
        this.f35955f.setValue(this, f35924Z[4], Boolean.valueOf(z10));
    }

    public boolean a0() {
        return ((Boolean) this.f35941Q.getValue(this, f35924Z[41])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void b(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        p.i(parameterNameRenderingPolicy, "<set-?>");
        this.f35929E.setValue(this, f35924Z[29], parameterNameRenderingPolicy);
    }

    public boolean b0() {
        return ((Boolean) this.f35925A.getValue(this, f35924Z[25])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void c(boolean z10) {
        this.f35952c.setValue(this, f35924Z[1], Boolean.valueOf(z10));
    }

    public boolean c0() {
        return ((Boolean) this.f35956g.getValue(this, f35924Z[5])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public boolean d() {
        return ((Boolean) this.f35962m.getValue(this, f35924Z[11])).booleanValue();
    }

    public boolean d0() {
        return ((Boolean) this.f35955f.getValue(this, f35924Z[4])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void e(boolean z10) {
        this.f35973x.setValue(this, f35924Z[22], Boolean.valueOf(z10));
    }

    public RenderingFormat e0() {
        return (RenderingFormat) this.f35928D.getValue(this, f35924Z[28]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void f(boolean z10) {
        this.f35930F.setValue(this, f35924Z[30], Boolean.valueOf(z10));
    }

    public InterfaceC5074l<S, S> f0() {
        return (InterfaceC5074l) this.f35974y.getValue(this, f35924Z[23]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void g(RenderingFormat renderingFormat) {
        p.i(renderingFormat, "<set-?>");
        this.f35928D.setValue(this, f35924Z[28], renderingFormat);
    }

    public boolean g0() {
        return ((Boolean) this.f35969t.getValue(this, f35924Z[18])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public Set<ga.c> h() {
        return (Set) this.f35936L.getValue(this, f35924Z[36]);
    }

    public boolean h0() {
        return ((Boolean) this.f35960k.getValue(this, f35924Z[9])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public boolean i() {
        return ((Boolean) this.f35957h.getValue(this, f35924Z[6])).booleanValue();
    }

    public b.InterfaceC0455b i0() {
        return (b.InterfaceC0455b) this.f35927C.getValue(this, f35924Z[27]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public AnnotationArgumentsRenderingPolicy j() {
        return (AnnotationArgumentsRenderingPolicy) this.f35938N.getValue(this, f35924Z[38]);
    }

    public boolean j0() {
        return ((Boolean) this.f35959j.getValue(this, f35924Z[8])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void k(Set<ga.c> set) {
        p.i(set, "<set-?>");
        this.f35936L.setValue(this, f35924Z[36], set);
    }

    public boolean k0() {
        return ((Boolean) this.f35952c.getValue(this, f35924Z[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void l(Set<? extends DescriptorRendererModifier> set) {
        p.i(set, "<set-?>");
        this.f35954e.setValue(this, f35924Z[3], set);
    }

    public boolean l0() {
        return ((Boolean) this.f35953d.getValue(this, f35924Z[2])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void m(kotlin.reflect.jvm.internal.impl.renderer.a aVar) {
        p.i(aVar, "<set-?>");
        this.f35951b.setValue(this, f35924Z[0], aVar);
    }

    public boolean m0() {
        return ((Boolean) this.f35961l.getValue(this, f35924Z[10])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void n(boolean z10) {
        this.f35957h.setValue(this, f35924Z[6], Boolean.valueOf(z10));
    }

    public boolean n0() {
        return ((Boolean) this.f35973x.getValue(this, f35924Z[22])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void o(boolean z10) {
        this.f35931G.setValue(this, f35924Z[31], Boolean.valueOf(z10));
    }

    public boolean o0() {
        return ((Boolean) this.f35972w.getValue(this, f35924Z[21])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public void p(boolean z10) {
        this.f35972w.setValue(this, f35924Z[21], Boolean.valueOf(z10));
    }

    public final boolean p0() {
        return this.f35950a;
    }

    public final void q0() {
        this.f35950a = true;
    }

    public final <T> InterfaceC5453e<d, T> r0(T t10) {
        C5449a c5449a = C5449a.f40169a;
        return new a(t10, this);
    }

    public final d s() {
        d dVar = new d();
        Field[] declaredFields = d.class.getDeclaredFields();
        p.h(declaredFields, "getDeclaredFields(...)");
        for (Field field : declaredFields) {
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                ObservableProperty observableProperty = obj instanceof ObservableProperty ? (ObservableProperty) obj : null;
                if (observableProperty != null) {
                    String name = field.getName();
                    p.h(name, "getName(...)");
                    D.X(name, "is", false, 2, null);
                    InterfaceC5745d interfaceC5745dB = t.b(d.class);
                    String name2 = field.getName();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("get");
                    String name3 = field.getName();
                    p.h(name3, "getName(...)");
                    if (name3.length() > 0) {
                        char upperCase = Character.toUpperCase(name3.charAt(0));
                        String strSubstring = name3.substring(1);
                        p.h(strSubstring, "substring(...)");
                        name3 = upperCase + strSubstring;
                    }
                    sb2.append(name3);
                    field.set(dVar, dVar.r0(observableProperty.getValue(this, new PropertyReference1Impl(interfaceC5745dB, name2, sb2.toString()))));
                }
            }
        }
        return dVar;
    }

    public boolean u() {
        return ((Boolean) this.f35968s.getValue(this, f35924Z[17])).booleanValue();
    }

    public boolean v() {
        return ((Boolean) this.f35939O.getValue(this, f35924Z[39])).booleanValue();
    }

    public InterfaceC5074l<F9.c, Boolean> w() {
        return (InterfaceC5074l) this.f35937M.getValue(this, f35924Z[37]);
    }

    public boolean x() {
        return ((Boolean) this.f35948X.getValue(this, f35924Z[48])).booleanValue();
    }

    public boolean y() {
        return ((Boolean) this.f35958i.getValue(this, f35924Z[7])).booleanValue();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.a z() {
        return (kotlin.reflect.jvm.internal.impl.renderer.a) this.f35951b.getValue(this, f35924Z[0]);
    }
}
