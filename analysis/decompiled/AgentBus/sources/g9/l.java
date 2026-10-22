package g9;

import d7.b0;
import java.util.LinkedHashSet;
import java.util.Set;
import q7.w;
import q7.x;

/* loaded from: classes.dex */
public final class l implements j {
    public static final /* synthetic */ w7.t[] W;
    public final k A;
    public final k B;
    public final k C;
    public final k D;
    public final k E;
    public final k F;
    public final k G;
    public final k H;
    public final k I;
    public final k J;
    public final k K;
    public final k L;
    public final k M;
    public final k N;
    public final k O;
    public final k P;
    public final k Q;
    public final k R;
    public final k S;
    public final k T;
    public final k U;
    public final k V;

    /* renamed from: a, reason: collision with root package name */
    public boolean f3964a;

    /* renamed from: b, reason: collision with root package name */
    public final k f3965b = new k(b.f3929d, this);

    /* renamed from: c, reason: collision with root package name */
    public final k f3966c;

    /* renamed from: d, reason: collision with root package name */
    public final k f3967d;

    /* renamed from: e, reason: collision with root package name */
    public final k f3968e;

    /* renamed from: f, reason: collision with root package name */
    public final k f3969f;

    /* renamed from: g, reason: collision with root package name */
    public final k f3970g;

    /* renamed from: h, reason: collision with root package name */
    public final k f3971h;

    /* renamed from: i, reason: collision with root package name */
    public final k f3972i;

    /* renamed from: j, reason: collision with root package name */
    public final k f3973j;

    /* renamed from: k, reason: collision with root package name */
    public final k f3974k;

    /* renamed from: l, reason: collision with root package name */
    public final k f3975l;

    /* renamed from: m, reason: collision with root package name */
    public final k f3976m;

    /* renamed from: n, reason: collision with root package name */
    public final k f3977n;

    /* renamed from: o, reason: collision with root package name */
    public final k f3978o;

    /* renamed from: p, reason: collision with root package name */
    public final k f3979p;

    /* renamed from: q, reason: collision with root package name */
    public final k f3980q;

    /* renamed from: r, reason: collision with root package name */
    public final k f3981r;

    /* renamed from: s, reason: collision with root package name */
    public final k f3982s;

    /* renamed from: t, reason: collision with root package name */
    public final k f3983t;

    /* renamed from: u, reason: collision with root package name */
    public final k f3984u;

    /* renamed from: v, reason: collision with root package name */
    public final k f3985v;

    /* renamed from: w, reason: collision with root package name */
    public final k f3986w;

    /* renamed from: x, reason: collision with root package name */
    public final k f3987x;

    /* renamed from: y, reason: collision with root package name */
    public final k f3988y;

    /* renamed from: z, reason: collision with root package name */
    public final k f3989z;

    static {
        x xVar = w.f8821a;
        W = new w7.t[]{xVar.d(new q7.n(xVar.b(l.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), xVar.d(new q7.n(xVar.b(l.class), "withDefinedIn", "getWithDefinedIn()Z")), xVar.d(new q7.n(xVar.b(l.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), xVar.d(new q7.n(xVar.b(l.class), "modifiers", "getModifiers()Ljava/util/Set;")), xVar.d(new q7.n(xVar.b(l.class), "startFromName", "getStartFromName()Z")), xVar.d(new q7.n(xVar.b(l.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), xVar.d(new q7.n(xVar.b(l.class), "debugMode", "getDebugMode()Z")), xVar.d(new q7.n(xVar.b(l.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), xVar.d(new q7.n(xVar.b(l.class), "verbose", "getVerbose()Z")), xVar.d(new q7.n(xVar.b(l.class), "unitReturnType", "getUnitReturnType()Z")), xVar.d(new q7.n(xVar.b(l.class), "withoutReturnType", "getWithoutReturnType()Z")), xVar.d(new q7.n(xVar.b(l.class), "enhancedTypes", "getEnhancedTypes()Z")), xVar.d(new q7.n(xVar.b(l.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), xVar.d(new q7.n(xVar.b(l.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), xVar.d(new q7.n(xVar.b(l.class), "renderDefaultModality", "getRenderDefaultModality()Z")), xVar.d(new q7.n(xVar.b(l.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), xVar.d(new q7.n(xVar.b(l.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), xVar.d(new q7.n(xVar.b(l.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), xVar.d(new q7.n(xVar.b(l.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), xVar.d(new q7.n(xVar.b(l.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), xVar.d(new q7.n(xVar.b(l.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), xVar.d(new q7.n(xVar.b(l.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), xVar.d(new q7.n(xVar.b(l.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), xVar.d(new q7.n(xVar.b(l.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), xVar.d(new q7.n(xVar.b(l.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), xVar.d(new q7.n(xVar.b(l.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), xVar.d(new q7.n(xVar.b(l.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), xVar.d(new q7.n(xVar.b(l.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), xVar.d(new q7.n(xVar.b(l.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), xVar.d(new q7.n(xVar.b(l.class), "receiverAfterName", "getReceiverAfterName()Z")), xVar.d(new q7.n(xVar.b(l.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), xVar.d(new q7.n(xVar.b(l.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), xVar.d(new q7.n(xVar.b(l.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), xVar.d(new q7.n(xVar.b(l.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), xVar.d(new q7.n(xVar.b(l.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), xVar.d(new q7.n(xVar.b(l.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), xVar.d(new q7.n(xVar.b(l.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), xVar.d(new q7.n(xVar.b(l.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), xVar.d(new q7.n(xVar.b(l.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), xVar.d(new q7.n(xVar.b(l.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), xVar.d(new q7.n(xVar.b(l.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), xVar.d(new q7.n(xVar.b(l.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), xVar.d(new q7.n(xVar.b(l.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), xVar.d(new q7.n(xVar.b(l.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), xVar.d(new q7.n(xVar.b(l.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), xVar.d(new q7.n(xVar.b(l.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), xVar.d(new q7.n(xVar.b(l.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), xVar.d(new q7.n(xVar.b(l.class), "informativeErrorType", "getInformativeErrorType()Z"))};
    }

    public l() {
        Boolean bool = Boolean.TRUE;
        this.f3966c = new k(bool, this);
        this.f3967d = new k(bool, this);
        this.f3968e = new k(h.f3944g, this);
        Boolean bool2 = Boolean.FALSE;
        this.f3969f = new k(bool2, this);
        this.f3970g = new k(bool2, this);
        this.f3971h = new k(bool2, this);
        this.f3972i = new k(bool2, this);
        this.f3973j = new k(bool2, this);
        this.f3974k = new k(bool, this);
        this.f3975l = new k(bool2, this);
        this.f3976m = new k(bool2, this);
        this.f3977n = new k(bool2, this);
        this.f3978o = new k(bool, this);
        this.f3979p = new k(bool, this);
        this.f3980q = new k(bool2, this);
        this.f3981r = new k(bool2, this);
        this.f3982s = new k(bool2, this);
        this.f3983t = new k(bool2, this);
        this.f3984u = new k(bool2, this);
        this.f3985v = new k(bool2, this);
        this.f3986w = new k(bool2, this);
        this.f3987x = new k(f.f3937k, this);
        this.f3988y = new k(f.f3936j, this);
        this.f3989z = new k(bool, this);
        this.A = new k(o.f3993g, this);
        this.B = new k(d.f3931a, this);
        this.C = new k(t.f4002f, this);
        this.D = new k(p.f3995f, this);
        this.E = new k(bool2, this);
        this.F = new k(bool2, this);
        this.G = new k(q.f3999f, this);
        this.H = new k(bool2, this);
        this.I = new k(bool2, this);
        this.J = new k(b0.f2947f, this);
        this.K = new k(m.f3990a, this);
        this.L = new k(null, this);
        this.M = new k(a.NO_ARGUMENTS, this);
        this.N = new k(bool2, this);
        this.O = new k(bool, this);
        this.P = new k(bool, this);
        this.Q = new k(bool2, this);
        this.R = new k(bool, this);
        this.S = new k(bool, this);
        this.T = new k(bool2, this);
        this.U = new k(bool2, this);
        this.V = new k(bool, this);
    }

    @Override // g9.j
    public final void a() {
        w7.t tVar = W[29];
        this.E.b(Boolean.TRUE, tVar);
    }

    @Override // g9.j
    public final void b() {
        w7.t tVar = W[6];
        this.f3971h.b(Boolean.TRUE, tVar);
    }

    @Override // g9.j
    public final void c() {
        w7.t tVar = W[30];
        this.F.b(Boolean.TRUE, tVar);
    }

    @Override // g9.j
    public final void d(p pVar) {
        this.D.b(pVar, W[28]);
    }

    @Override // g9.j
    public final void e(c cVar) {
        this.f3965b.b(cVar, W[0]);
    }

    @Override // g9.j
    public final void f(Set set) {
        q7.k.e(set, "<set-?>");
        this.f3968e.b(set, W[3]);
    }

    @Override // g9.j
    public final void g() {
        w7.t tVar = W[4];
        this.f3969f.b(Boolean.TRUE, tVar);
    }

    @Override // g9.j
    public final void h() {
        w7.t tVar = W[1];
        this.f3966c.b(Boolean.FALSE, tVar);
    }

    @Override // g9.j
    public final Set i() {
        return (Set) this.K.a(this, W[35]);
    }

    @Override // g9.j
    public final a j() {
        return (a) this.M.a(this, W[37]);
    }

    @Override // g9.j
    public final void k(LinkedHashSet linkedHashSet) {
        this.K.b(linkedHashSet, W[35]);
    }

    @Override // g9.j
    public final void l() {
        w7.t tVar = W[20];
        this.f3985v.b(Boolean.TRUE, tVar);
    }

    @Override // g9.j
    public final void m() {
        this.C.b(t.f4003g, W[27]);
    }

    @Override // g9.j
    public final void n() {
        w7.t tVar = W[21];
        this.f3986w.b(Boolean.TRUE, tVar);
    }

    public final boolean o() {
        return ((Boolean) this.f3971h.a(this, W[6])).booleanValue();
    }
}
