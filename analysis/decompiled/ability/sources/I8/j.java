package I8;

import Z7.t;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat;

/* loaded from: classes4.dex */
public final class j implements h {

    /* renamed from: Y, reason: collision with root package name */
    public static final /* synthetic */ t[] f815Y;

    /* renamed from: A, reason: collision with root package name */
    public final i f816A;

    /* renamed from: B, reason: collision with root package name */
    public final i f817B;

    /* renamed from: C, reason: collision with root package name */
    public final i f818C;

    /* renamed from: D, reason: collision with root package name */
    public final i f819D;
    public final i E;

    /* renamed from: F, reason: collision with root package name */
    public final i f820F;

    /* renamed from: G, reason: collision with root package name */
    public final i f821G;

    /* renamed from: H, reason: collision with root package name */
    public final i f822H;

    /* renamed from: I, reason: collision with root package name */
    public final i f823I;

    /* renamed from: J, reason: collision with root package name */
    public final i f824J;

    /* renamed from: K, reason: collision with root package name */
    public final i f825K;

    /* renamed from: L, reason: collision with root package name */
    public final i f826L;

    /* renamed from: M, reason: collision with root package name */
    public final i f827M;

    /* renamed from: N, reason: collision with root package name */
    public final i f828N;

    /* renamed from: O, reason: collision with root package name */
    public final i f829O;

    /* renamed from: P, reason: collision with root package name */
    public final i f830P;

    /* renamed from: Q, reason: collision with root package name */
    public final i f831Q;

    /* renamed from: R, reason: collision with root package name */
    public final i f832R;

    /* renamed from: S, reason: collision with root package name */
    public final i f833S;

    /* renamed from: T, reason: collision with root package name */
    public final i f834T;

    /* renamed from: U, reason: collision with root package name */
    public final i f835U;

    /* renamed from: V, reason: collision with root package name */
    public final i f836V;

    /* renamed from: W, reason: collision with root package name */
    public final i f837W;

    /* renamed from: X, reason: collision with root package name */
    public final i f838X;

    /* renamed from: a, reason: collision with root package name */
    public boolean f839a;
    public final i b = new i(a.d, this);
    public final i c;
    public final i d;
    public final i e;
    public final i f;
    public final i g;
    public final i h;
    public final i i;

    /* renamed from: j, reason: collision with root package name */
    public final i f840j;
    public final i k;
    public final i l;
    public final i m;
    public final i n;
    public final i o;
    public final i p;

    /* renamed from: q, reason: collision with root package name */
    public final i f841q;

    /* renamed from: r, reason: collision with root package name */
    public final i f842r;

    /* renamed from: s, reason: collision with root package name */
    public final i f843s;

    /* renamed from: t, reason: collision with root package name */
    public final i f844t;
    public final i u;

    /* renamed from: v, reason: collision with root package name */
    public final i f845v;

    /* renamed from: w, reason: collision with root package name */
    public final i f846w;

    /* renamed from: x, reason: collision with root package name */
    public final i f847x;
    public final i y;

    /* renamed from: z, reason: collision with root package name */
    public final i f848z;

    static {
        n nVar = m.f4928a;
        f815Y = new t[]{nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "withDefinedIn", "getWithDefinedIn()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "modifiers", "getModifiers()Ljava/util/Set;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "startFromName", "getStartFromName()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "debugMode", "getDebugMode()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "verbose", "getVerbose()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "unitReturnType", "getUnitReturnType()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "withoutReturnType", "getWithoutReturnType()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "enhancedTypes", "getEnhancedTypes()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "renderDefaultModality", "getRenderDefaultModality()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "propertyConstantRenderer", "getPropertyConstantRenderer()Lkotlin/jvm/functions/Function1;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "receiverAfterName", "getReceiverAfterName()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "renderAbbreviatedTypeComments", "getRenderAbbreviatedTypeComments()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), nVar.e(new MutablePropertyReference1Impl(nVar.b(j.class), "informativeErrorType", "getInformativeErrorType()Z"))};
    }

    public j() {
        Boolean bool = Boolean.TRUE;
        this.c = new i(bool, this);
        this.d = new i(bool, this);
        this.e = new i(DescriptorRendererModifier.b, this);
        Boolean bool2 = Boolean.FALSE;
        this.f = new i(bool2, this);
        this.g = new i(bool2, this);
        this.h = new i(bool2, this);
        this.i = new i(bool2, this);
        this.f840j = new i(bool2, this);
        this.k = new i(bool, this);
        this.l = new i(bool2, this);
        this.m = new i(bool2, this);
        this.n = new i(bool2, this);
        this.o = new i(bool, this);
        this.p = new i(bool, this);
        this.f841q = new i(bool2, this);
        this.f842r = new i(bool2, this);
        this.f843s = new i(bool2, this);
        this.f844t = new i(bool2, this);
        this.u = new i(bool2, this);
        this.f845v = new i(null, this);
        this.f846w = new i(bool2, this);
        this.f847x = new i(bool2, this);
        this.y = new i(c.o, this);
        this.f848z = new i(c.p, this);
        this.f816A = new i(bool, this);
        this.f817B = new i(OverrideRenderingPolicy.b, this);
        this.f818C = new i(d.f810a, this);
        this.f819D = new i(RenderingFormat.f5113a, this);
        this.E = new i(ParameterNameRenderingPolicy.f5111a, this);
        this.f820F = new i(bool2, this);
        this.f821G = new i(bool2, this);
        this.f822H = new i(PropertyAccessorRenderingPolicy.f5112a, this);
        this.f823I = new i(bool2, this);
        this.f824J = new i(bool2, this);
        this.f825K = new i(EmptySet.f4895a, this);
        this.f826L = new i(k.f849a, this);
        this.f827M = new i(null, this);
        this.f828N = new i(AnnotationArgumentsRenderingPolicy.c, this);
        this.f829O = new i(bool2, this);
        this.f830P = new i(bool, this);
        this.f831Q = new i(bool, this);
        this.f832R = new i(bool2, this);
        this.f833S = new i(bool2, this);
        this.f834T = new i(bool, this);
        this.f835U = new i(bool, this);
        this.f836V = new i(bool2, this);
        this.f837W = new i(bool2, this);
        this.f838X = new i(bool, this);
    }

    @Override // I8.h
    public final void a() {
        this.f820F.a(this, f815Y[30], Boolean.TRUE);
    }

    @Override // I8.h
    public final void b() {
        this.f821G.a(this, f815Y[31], Boolean.TRUE);
    }

    @Override // I8.h
    public final void c(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        this.E.a(this, f815Y[29], parameterNameRenderingPolicy);
    }

    @Override // I8.h
    public final void d() {
        this.f846w.a(this, f815Y[21], Boolean.TRUE);
    }

    @Override // I8.h
    public final void e() {
        this.f.a(this, f815Y[4], Boolean.TRUE);
    }

    @Override // I8.h
    public final void f() {
        this.f847x.a(this, f815Y[22], Boolean.TRUE);
    }

    @Override // I8.h
    public final void g() {
        this.h.a(this, f815Y[6], Boolean.TRUE);
    }

    @Override // I8.h
    public final void h(b bVar) {
        this.b.a(this, f815Y[0], bVar);
    }

    @Override // I8.h
    public final void i(Set set) {
        kotlin.jvm.internal.k.f(set, "<set-?>");
        this.e.a(this, f815Y[3], set);
    }

    @Override // I8.h
    public final void j() {
        this.c.a(this, f815Y[1], Boolean.FALSE);
    }

    @Override // I8.h
    public final void k() {
        RenderingFormat renderingFormat = RenderingFormat.b;
        this.f819D.a(this, f815Y[28], renderingFormat);
    }

    public final boolean l() {
        return ((Boolean) this.h.getValue(this, f815Y[6])).booleanValue();
    }

    public final Set m() {
        return (Set) this.f826L.getValue(this, f815Y[36]);
    }
}
