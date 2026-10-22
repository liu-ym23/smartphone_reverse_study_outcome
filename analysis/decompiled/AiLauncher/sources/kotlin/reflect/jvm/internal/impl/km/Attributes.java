package kotlin.reflect.jvm.internal.impl.km;

import N9.d;
import N9.g;
import N9.k;
import N9.n;
import N9.o;
import N9.r;
import N9.s;
import O9.a;
import O9.b;
import O9.c;
import Z8.C1174w;
import ea.C4018b;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import w9.InterfaceC5752k;

/* loaded from: classes5.dex */
public final class Attributes {

    /* renamed from: A, reason: collision with root package name */
    public static final a f35017A;

    /* renamed from: B, reason: collision with root package name */
    public static final a f35018B;

    /* renamed from: C, reason: collision with root package name */
    public static final a f35019C;

    /* renamed from: D, reason: collision with root package name */
    public static final a f35020D;

    /* renamed from: E, reason: collision with root package name */
    public static final a f35021E;

    /* renamed from: F, reason: collision with root package name */
    public static final a f35022F;

    /* renamed from: G, reason: collision with root package name */
    public static final b f35023G;

    /* renamed from: H, reason: collision with root package name */
    public static final b f35024H;

    /* renamed from: I, reason: collision with root package name */
    public static final b f35025I;

    /* renamed from: J, reason: collision with root package name */
    public static final a f35026J;

    /* renamed from: K, reason: collision with root package name */
    public static final a f35027K;

    /* renamed from: L, reason: collision with root package name */
    public static final a f35028L;

    /* renamed from: M, reason: collision with root package name */
    public static final a f35029M;

    /* renamed from: N, reason: collision with root package name */
    public static final a f35030N;

    /* renamed from: O, reason: collision with root package name */
    public static final a f35031O;

    /* renamed from: P, reason: collision with root package name */
    public static final a f35032P;

    /* renamed from: Q, reason: collision with root package name */
    public static final b f35033Q;

    /* renamed from: R, reason: collision with root package name */
    public static final b f35034R;

    /* renamed from: S, reason: collision with root package name */
    public static final a f35035S;

    /* renamed from: T, reason: collision with root package name */
    public static final a f35036T;

    /* renamed from: U, reason: collision with root package name */
    public static final a f35037U;

    /* renamed from: V, reason: collision with root package name */
    public static final a f35038V;

    /* renamed from: W, reason: collision with root package name */
    public static final a f35039W;

    /* renamed from: X, reason: collision with root package name */
    public static final a f35040X;

    /* renamed from: Y, reason: collision with root package name */
    public static final a f35041Y;

    /* renamed from: Z, reason: collision with root package name */
    public static final b f35042Z;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f35043a = {t.f(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmClass;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmConstructor;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmFunction;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmProperty;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmValueParameter;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmTypeAlias;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Modality;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Visibility;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "kind", "getKind(Lkotlin/metadata/KmClass;)Lkotlin/metadata/ClassKind;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isInner", "isInner(Lkotlin/metadata/KmClass;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isData", "isData(Lkotlin/metadata/KmClass;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmClass;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmClass;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isValue", "isValue(Lkotlin/metadata/KmClass;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isFunInterface", "isFunInterface(Lkotlin/metadata/KmClass;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "hasEnumEntries", "getHasEnumEntries(Lkotlin/metadata/KmClass;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmConstructor;)Lkotlin/metadata/Visibility;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isSecondary", "isSecondary(Lkotlin/metadata/KmConstructor;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmConstructor;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "kind", "getKind(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/MemberKind;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Visibility;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Modality;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isOperator", "isOperator(Lkotlin/metadata/KmFunction;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isInfix", "isInfix(Lkotlin/metadata/KmFunction;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isInline", "isInline(Lkotlin/metadata/KmFunction;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isTailrec", "isTailrec(Lkotlin/metadata/KmFunction;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmFunction;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isSuspend", "isSuspend(Lkotlin/metadata/KmFunction;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmFunction;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmFunction;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Visibility;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Modality;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "kind", "getKind(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/MemberKind;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isVar", "isVar(Lkotlin/metadata/KmProperty;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isConst", "isConst(Lkotlin/metadata/KmProperty;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isLateinit", "isLateinit(Lkotlin/metadata/KmProperty;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "hasConstant", "getHasConstant(Lkotlin/metadata/KmProperty;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmProperty;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isDelegated", "isDelegated(Lkotlin/metadata/KmProperty;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmProperty;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Visibility;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Modality;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isNotDefault", "isNotDefault(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isInline", "isInline(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isNullable", "isNullable(Lkotlin/metadata/KmType;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isSuspend", "isSuspend(Lkotlin/metadata/KmType;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isDefinitelyNonNull", "isDefinitelyNonNull(Lkotlin/metadata/KmType;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isReified", "isReified(Lkotlin/metadata/KmTypeParameter;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "visibility", "getVisibility(Lkotlin/metadata/KmTypeAlias;)Lkotlin/metadata/Visibility;", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "declaresDefaultValue", "getDeclaresDefaultValue(Lkotlin/metadata/KmValueParameter;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isCrossinline", "isCrossinline(Lkotlin/metadata/KmValueParameter;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isNoinline", "isNoinline(Lkotlin/metadata/KmValueParameter;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isNegated", "isNegated(Lkotlin/metadata/KmEffectExpression;)Z", 1)), t.f(new MutablePropertyReference1Impl(Attributes.class, "isNullCheckPredicate", "isNullCheckPredicate(Lkotlin/metadata/KmEffectExpression;)Z", 1))};

    /* renamed from: a0, reason: collision with root package name */
    public static final a f35044a0;

    /* renamed from: b, reason: collision with root package name */
    public static final a f35045b;

    /* renamed from: b0, reason: collision with root package name */
    public static final a f35046b0;

    /* renamed from: c, reason: collision with root package name */
    public static final a f35047c;

    /* renamed from: c0, reason: collision with root package name */
    public static final a f35048c0;

    /* renamed from: d, reason: collision with root package name */
    public static final a f35049d;

    /* renamed from: d0, reason: collision with root package name */
    public static final a f35050d0;

    /* renamed from: e, reason: collision with root package name */
    public static final a f35051e;

    /* renamed from: e0, reason: collision with root package name */
    public static final a f35052e0;

    /* renamed from: f, reason: collision with root package name */
    public static final a f35053f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f35054g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f35055h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f35056i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f35057j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f35058k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f35059l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f35060m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f35061n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f35062o;

    /* renamed from: p, reason: collision with root package name */
    public static final a f35063p;

    /* renamed from: q, reason: collision with root package name */
    public static final a f35064q;

    /* renamed from: r, reason: collision with root package name */
    public static final a f35065r;

    /* renamed from: s, reason: collision with root package name */
    public static final b f35066s;

    /* renamed from: t, reason: collision with root package name */
    public static final a f35067t;

    /* renamed from: u, reason: collision with root package name */
    public static final a f35068u;

    /* renamed from: v, reason: collision with root package name */
    public static final b f35069v;

    /* renamed from: w, reason: collision with root package name */
    public static final b f35070w;

    /* renamed from: x, reason: collision with root package name */
    public static final b f35071x;

    /* renamed from: y, reason: collision with root package name */
    public static final a f35072y;

    /* renamed from: z, reason: collision with root package name */
    public static final a f35073z;

    static {
        C4018b.C0396b HAS_ANNOTATIONS = C4018b.f32376c;
        p.h(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f35045b = FlagDelegatesImplKt.a(new c(HAS_ANNOTATIONS));
        p.h(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f35047c = FlagDelegatesImplKt.b(new c(HAS_ANNOTATIONS));
        p.h(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f35049d = FlagDelegatesImplKt.c(new c(HAS_ANNOTATIONS));
        p.h(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f35051e = FlagDelegatesImplKt.g(new c(HAS_ANNOTATIONS));
        p.h(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f35053f = FlagDelegatesImplKt.f(new c(HAS_ANNOTATIONS));
        p.h(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f35054g = FlagDelegatesImplKt.j(new c(HAS_ANNOTATIONS));
        p.h(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f35055h = FlagDelegatesImplKt.h(new c(HAS_ANNOTATIONS));
        f35056i = FlagDelegatesImplKt.e(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((d) obj).i());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((d) obj).s(((Number) obj2).intValue());
            }
        });
        f35057j = FlagDelegatesImplKt.k(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((d) obj).i());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((d) obj).s(((Number) obj2).intValue());
            }
        });
        Attributes$kind$2 attributes$kind$2 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$kind$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((d) obj).i());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((d) obj).s(((Number) obj2).intValue());
            }
        };
        C4018b.d<ProtoBuf$Class.Kind> CLASS_KIND = C4018b.f32379f;
        p.h(CLASS_KIND, "CLASS_KIND");
        InterfaceC4149a<ClassKind> entries = ClassKind.getEntries();
        InterfaceC4149a<ClassKind> entries2 = ClassKind.getEntries();
        ArrayList arrayList = new ArrayList(C1174w.x(entries2, 10));
        Iterator<ClassKind> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFlag$kotlin_metadata());
        }
        f35058k = new b(attributes$kind$2, CLASS_KIND, entries, arrayList);
        C4018b.C0396b IS_INNER = C4018b.f32380g;
        p.h(IS_INNER, "IS_INNER");
        f35059l = FlagDelegatesImplKt.a(new c(IS_INNER));
        C4018b.C0396b IS_DATA = C4018b.f32381h;
        p.h(IS_DATA, "IS_DATA");
        f35060m = FlagDelegatesImplKt.a(new c(IS_DATA));
        C4018b.C0396b IS_EXTERNAL_CLASS = C4018b.f32382i;
        p.h(IS_EXTERNAL_CLASS, "IS_EXTERNAL_CLASS");
        f35061n = FlagDelegatesImplKt.a(new c(IS_EXTERNAL_CLASS));
        C4018b.C0396b IS_EXPECT_CLASS = C4018b.f32383j;
        p.h(IS_EXPECT_CLASS, "IS_EXPECT_CLASS");
        f35062o = FlagDelegatesImplKt.a(new c(IS_EXPECT_CLASS));
        C4018b.C0396b IS_VALUE_CLASS = C4018b.f32384k;
        p.h(IS_VALUE_CLASS, "IS_VALUE_CLASS");
        f35063p = FlagDelegatesImplKt.a(new c(IS_VALUE_CLASS));
        C4018b.C0396b IS_FUN_INTERFACE = C4018b.f32385l;
        p.h(IS_FUN_INTERFACE, "IS_FUN_INTERFACE");
        f35064q = FlagDelegatesImplKt.a(new c(IS_FUN_INTERFACE));
        C4018b.C0396b HAS_ENUM_ENTRIES = C4018b.f32386m;
        p.h(HAS_ENUM_ENTRIES, "HAS_ENUM_ENTRIES");
        f35065r = FlagDelegatesImplKt.a(new c(HAS_ENUM_ENTRIES));
        f35066s = FlagDelegatesImplKt.k(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$6
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((g) obj).c());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((g) obj).f(((Number) obj2).intValue());
            }
        });
        C4018b.C0396b IS_SECONDARY = C4018b.f32387n;
        p.h(IS_SECONDARY, "IS_SECONDARY");
        f35067t = FlagDelegatesImplKt.b(new c(IS_SECONDARY));
        C4018b.C0396b IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = C4018b.f32388o;
        p.h(IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES, "IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES");
        f35068u = FlagDelegatesImplKt.b(new c(IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES));
        f35069v = FlagDelegatesImplKt.d(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$kind$7
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((n) obj).e());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((n) obj).j(((Number) obj2).intValue());
            }
        });
        f35070w = FlagDelegatesImplKt.k(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$10
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((n) obj).e());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((n) obj).j(((Number) obj2).intValue());
            }
        });
        f35071x = FlagDelegatesImplKt.e(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$6
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((n) obj).e());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((n) obj).j(((Number) obj2).intValue());
            }
        });
        C4018b.C0396b IS_OPERATOR = C4018b.f32391r;
        p.h(IS_OPERATOR, "IS_OPERATOR");
        f35072y = FlagDelegatesImplKt.c(new c(IS_OPERATOR));
        C4018b.C0396b IS_INFIX = C4018b.f32392s;
        p.h(IS_INFIX, "IS_INFIX");
        f35073z = FlagDelegatesImplKt.c(new c(IS_INFIX));
        C4018b.C0396b IS_INLINE = C4018b.f32393t;
        p.h(IS_INLINE, "IS_INLINE");
        f35017A = FlagDelegatesImplKt.c(new c(IS_INLINE));
        C4018b.C0396b IS_TAILREC = C4018b.f32394u;
        p.h(IS_TAILREC, "IS_TAILREC");
        f35018B = FlagDelegatesImplKt.c(new c(IS_TAILREC));
        C4018b.C0396b IS_EXTERNAL_FUNCTION = C4018b.f32395v;
        p.h(IS_EXTERNAL_FUNCTION, "IS_EXTERNAL_FUNCTION");
        f35019C = FlagDelegatesImplKt.c(new c(IS_EXTERNAL_FUNCTION));
        C4018b.C0396b IS_SUSPEND = C4018b.f32396w;
        p.h(IS_SUSPEND, "IS_SUSPEND");
        f35020D = FlagDelegatesImplKt.c(new c(IS_SUSPEND));
        C4018b.C0396b IS_EXPECT_FUNCTION = C4018b.f32397x;
        p.h(IS_EXPECT_FUNCTION, "IS_EXPECT_FUNCTION");
        f35021E = FlagDelegatesImplKt.c(new c(IS_EXPECT_FUNCTION));
        C4018b.C0396b IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = C4018b.f32398y;
        p.h(IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES, "IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES");
        f35022F = FlagDelegatesImplKt.c(new c(IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES));
        f35023G = FlagDelegatesImplKt.k(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$14
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((o) obj).g());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((o) obj).m(((Number) obj2).intValue());
            }
        });
        f35024H = FlagDelegatesImplKt.e(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$10
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((o) obj).g());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((o) obj).m(((Number) obj2).intValue());
            }
        });
        f35025I = FlagDelegatesImplKt.d(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$kind$11
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((o) obj).g());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((o) obj).m(((Number) obj2).intValue());
            }
        });
        C4018b.C0396b IS_VAR = C4018b.f32355A;
        p.h(IS_VAR, "IS_VAR");
        f35026J = FlagDelegatesImplKt.g(new c(IS_VAR));
        C4018b.C0396b IS_CONST = C4018b.f32358D;
        p.h(IS_CONST, "IS_CONST");
        f35027K = FlagDelegatesImplKt.g(new c(IS_CONST));
        C4018b.C0396b IS_LATEINIT = C4018b.f32359E;
        p.h(IS_LATEINIT, "IS_LATEINIT");
        f35028L = FlagDelegatesImplKt.g(new c(IS_LATEINIT));
        C4018b.C0396b HAS_CONSTANT = C4018b.f32360F;
        p.h(HAS_CONSTANT, "HAS_CONSTANT");
        f35029M = FlagDelegatesImplKt.g(new c(HAS_CONSTANT));
        C4018b.C0396b IS_EXTERNAL_PROPERTY = C4018b.f32361G;
        p.h(IS_EXTERNAL_PROPERTY, "IS_EXTERNAL_PROPERTY");
        f35030N = FlagDelegatesImplKt.g(new c(IS_EXTERNAL_PROPERTY));
        C4018b.C0396b IS_DELEGATED = C4018b.f32362H;
        p.h(IS_DELEGATED, "IS_DELEGATED");
        f35031O = FlagDelegatesImplKt.g(new c(IS_DELEGATED));
        C4018b.C0396b IS_EXPECT_PROPERTY = C4018b.f32363I;
        p.h(IS_EXPECT_PROPERTY, "IS_EXPECT_PROPERTY");
        f35032P = FlagDelegatesImplKt.g(new c(IS_EXPECT_PROPERTY));
        f35033Q = FlagDelegatesImplKt.k(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$18
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((N9.p) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((N9.p) obj).c(((Number) obj2).intValue());
            }
        });
        f35034R = FlagDelegatesImplKt.e(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$14
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((N9.p) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((N9.p) obj).c(((Number) obj2).intValue());
            }
        });
        C4018b.C0396b IS_NOT_DEFAULT = C4018b.f32368N;
        p.h(IS_NOT_DEFAULT, "IS_NOT_DEFAULT");
        f35035S = FlagDelegatesImplKt.f(new c(IS_NOT_DEFAULT));
        C4018b.C0396b IS_EXTERNAL_ACCESSOR = C4018b.f32369O;
        p.h(IS_EXTERNAL_ACCESSOR, "IS_EXTERNAL_ACCESSOR");
        f35036T = FlagDelegatesImplKt.f(new c(IS_EXTERNAL_ACCESSOR));
        C4018b.C0396b IS_INLINE_ACCESSOR = C4018b.f32370P;
        p.h(IS_INLINE_ACCESSOR, "IS_INLINE_ACCESSOR");
        f35037U = FlagDelegatesImplKt.f(new c(IS_INLINE_ACCESSOR));
        f35038V = FlagDelegatesImplKt.i(new c(0, 1, 1));
        C4018b.C0396b c0396b = C4018b.f32374a;
        f35039W = FlagDelegatesImplKt.i(new c(c0396b.f32401a + 1, c0396b.f32402b, 1));
        C4018b.C0396b c0396b2 = C4018b.f32375b;
        f35040X = FlagDelegatesImplKt.i(new c(c0396b2.f32401a + 1, c0396b2.f32402b, 1));
        f35041Y = new a(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$isReified$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((s) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((s) obj).d(((Number) obj2).intValue());
            }
        }, new c(0, 1, 1));
        f35042Z = FlagDelegatesImplKt.k(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$22
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((r) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((r) obj).f(((Number) obj2).intValue());
            }
        });
        C4018b.C0396b DECLARES_DEFAULT_VALUE = C4018b.f32365K;
        p.h(DECLARES_DEFAULT_VALUE, "DECLARES_DEFAULT_VALUE");
        f35044a0 = FlagDelegatesImplKt.j(new c(DECLARES_DEFAULT_VALUE));
        C4018b.C0396b IS_CROSSINLINE = C4018b.f32366L;
        p.h(IS_CROSSINLINE, "IS_CROSSINLINE");
        f35046b0 = FlagDelegatesImplKt.j(new c(IS_CROSSINLINE));
        C4018b.C0396b IS_NOINLINE = C4018b.f32367M;
        p.h(IS_NOINLINE, "IS_NOINLINE");
        f35048c0 = FlagDelegatesImplKt.j(new c(IS_NOINLINE));
        Attributes$isNegated$2 attributes$isNegated$2 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$isNegated$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((k) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((k) obj).e(((Number) obj2).intValue());
            }
        };
        C4018b.C0396b IS_NEGATED = C4018b.f32371Q;
        p.h(IS_NEGATED, "IS_NEGATED");
        f35050d0 = new a(attributes$isNegated$2, new c(IS_NEGATED));
        Attributes$isNullCheckPredicate$2 attributes$isNullCheckPredicate$2 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$isNullCheckPredicate$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return Integer.valueOf(((k) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, w9.InterfaceC5751j
            public void set(Object obj, Object obj2) {
                ((k) obj).e(((Number) obj2).intValue());
            }
        };
        C4018b.C0396b IS_NULL_CHECK_PREDICATE = C4018b.f32372R;
        p.h(IS_NULL_CHECK_PREDICATE, "IS_NULL_CHECK_PREDICATE");
        f35052e0 = new a(attributes$isNullCheckPredicate$2, new c(IS_NULL_CHECK_PREDICATE));
    }

    public static final ClassKind a(d dVar) {
        p.i(dVar, "<this>");
        return (ClassKind) f35058k.a(dVar, f35043a[9]);
    }

    public static final boolean b(d dVar) {
        p.i(dVar, "<this>");
        return f35063p.a(dVar, f35043a[14]);
    }
}
