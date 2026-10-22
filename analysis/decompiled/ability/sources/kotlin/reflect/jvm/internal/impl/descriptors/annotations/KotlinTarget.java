package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import D7.v;
import H4.o;
import K7.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Pair;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class KotlinTarget {

    /* renamed from: A, reason: collision with root package name */
    public static final KotlinTarget f4957A;

    /* renamed from: B, reason: collision with root package name */
    public static final KotlinTarget f4958B;

    /* renamed from: C, reason: collision with root package name */
    public static final KotlinTarget f4959C;

    /* renamed from: D, reason: collision with root package name */
    public static final KotlinTarget f4960D;
    public static final KotlinTarget E;

    /* renamed from: F, reason: collision with root package name */
    public static final KotlinTarget f4961F;

    /* renamed from: G, reason: collision with root package name */
    public static final KotlinTarget f4962G;

    /* renamed from: L, reason: collision with root package name */
    public static final KotlinTarget f4963L;

    /* renamed from: M, reason: collision with root package name */
    public static final KotlinTarget f4964M;

    /* renamed from: N, reason: collision with root package name */
    public static final KotlinTarget f4965N;

    /* renamed from: O, reason: collision with root package name */
    public static final KotlinTarget f4966O;

    /* renamed from: P, reason: collision with root package name */
    public static final KotlinTarget f4967P;

    /* renamed from: Q, reason: collision with root package name */
    public static final /* synthetic */ KotlinTarget[] f4968Q;

    /* renamed from: R, reason: collision with root package name */
    public static final /* synthetic */ a f4969R;
    public static final HashMap b;
    public static final Set c;
    public static final Set d;
    public static final List e;
    public static final List f;
    public static final List g;
    public static final List h;
    public static final List i;

    /* renamed from: j, reason: collision with root package name */
    public static final List f4970j;
    public static final List k;
    public static final List l;
    public static final List m;
    public static final List n;
    public static final List o;
    public static final List p;

    /* renamed from: q, reason: collision with root package name */
    public static final Object f4971q;

    /* renamed from: r, reason: collision with root package name */
    public static final KotlinTarget f4972r;

    /* renamed from: s, reason: collision with root package name */
    public static final KotlinTarget f4973s;

    /* renamed from: t, reason: collision with root package name */
    public static final KotlinTarget f4974t;
    public static final KotlinTarget u;

    /* renamed from: v, reason: collision with root package name */
    public static final KotlinTarget f4975v;

    /* renamed from: w, reason: collision with root package name */
    public static final KotlinTarget f4976w;

    /* renamed from: x, reason: collision with root package name */
    public static final KotlinTarget f4977x;
    public static final KotlinTarget y;

    /* renamed from: z, reason: collision with root package name */
    public static final KotlinTarget f4978z;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4979a;

    static {
        KotlinTarget kotlinTarget = new KotlinTarget("CLASS", 0, true);
        f4972r = kotlinTarget;
        KotlinTarget kotlinTarget2 = new KotlinTarget("ANNOTATION_CLASS", 1, true);
        f4973s = kotlinTarget2;
        KotlinTarget kotlinTarget3 = new KotlinTarget("TYPE_PARAMETER", 2, false);
        f4974t = kotlinTarget3;
        KotlinTarget kotlinTarget4 = new KotlinTarget("PROPERTY", 3, true);
        u = kotlinTarget4;
        KotlinTarget kotlinTarget5 = new KotlinTarget("FIELD", 4, true);
        f4975v = kotlinTarget5;
        KotlinTarget kotlinTarget6 = new KotlinTarget("LOCAL_VARIABLE", 5, true);
        f4976w = kotlinTarget6;
        KotlinTarget kotlinTarget7 = new KotlinTarget("VALUE_PARAMETER", 6, true);
        f4977x = kotlinTarget7;
        KotlinTarget kotlinTarget8 = new KotlinTarget("CONSTRUCTOR", 7, true);
        y = kotlinTarget8;
        KotlinTarget kotlinTarget9 = new KotlinTarget("FUNCTION", 8, true);
        f4978z = kotlinTarget9;
        KotlinTarget kotlinTarget10 = new KotlinTarget("PROPERTY_GETTER", 9, true);
        f4957A = kotlinTarget10;
        KotlinTarget kotlinTarget11 = new KotlinTarget("PROPERTY_SETTER", 10, true);
        f4958B = kotlinTarget11;
        KotlinTarget kotlinTarget12 = new KotlinTarget("TYPE", 11, false);
        f4959C = kotlinTarget12;
        KotlinTarget kotlinTarget13 = new KotlinTarget("EXPRESSION", 12, false);
        KotlinTarget kotlinTarget14 = new KotlinTarget("FILE", 13, false);
        f4960D = kotlinTarget14;
        KotlinTarget kotlinTarget15 = new KotlinTarget("TYPEALIAS", 14, false);
        KotlinTarget kotlinTarget16 = new KotlinTarget("TYPE_PROJECTION", 15, false);
        KotlinTarget kotlinTarget17 = new KotlinTarget("STAR_PROJECTION", 16, false);
        KotlinTarget kotlinTarget18 = new KotlinTarget("PROPERTY_PARAMETER", 17, false);
        KotlinTarget kotlinTarget19 = new KotlinTarget("CLASS_ONLY", 18, false);
        E = kotlinTarget19;
        KotlinTarget kotlinTarget20 = new KotlinTarget("OBJECT", 19, false);
        f4961F = kotlinTarget20;
        KotlinTarget kotlinTarget21 = new KotlinTarget("STANDALONE_OBJECT", 20, false);
        f4962G = kotlinTarget21;
        KotlinTarget kotlinTarget22 = new KotlinTarget("COMPANION_OBJECT", 21, false);
        f4963L = kotlinTarget22;
        KotlinTarget kotlinTarget23 = new KotlinTarget("INTERFACE", 22, false);
        f4964M = kotlinTarget23;
        KotlinTarget kotlinTarget24 = new KotlinTarget("ENUM_CLASS", 23, false);
        f4965N = kotlinTarget24;
        KotlinTarget kotlinTarget25 = new KotlinTarget("ENUM_ENTRY", 24, false);
        f4966O = kotlinTarget25;
        KotlinTarget kotlinTarget26 = new KotlinTarget("LOCAL_CLASS", 25, false);
        f4967P = kotlinTarget26;
        KotlinTarget[] kotlinTargetArr = {kotlinTarget, kotlinTarget2, kotlinTarget3, kotlinTarget4, kotlinTarget5, kotlinTarget6, kotlinTarget7, kotlinTarget8, kotlinTarget9, kotlinTarget10, kotlinTarget11, kotlinTarget12, kotlinTarget13, kotlinTarget14, kotlinTarget15, kotlinTarget16, kotlinTarget17, kotlinTarget18, kotlinTarget19, kotlinTarget20, kotlinTarget21, kotlinTarget22, kotlinTarget23, kotlinTarget24, kotlinTarget25, kotlinTarget26, new KotlinTarget("LOCAL_FUNCTION", 26, false), new KotlinTarget("MEMBER_FUNCTION", 27, false), new KotlinTarget("TOP_LEVEL_FUNCTION", 28, false), new KotlinTarget("MEMBER_PROPERTY", 29, false), new KotlinTarget("MEMBER_PROPERTY_WITH_BACKING_FIELD", 30, false), new KotlinTarget("MEMBER_PROPERTY_WITH_DELEGATE", 31, false), new KotlinTarget("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 32, false), new KotlinTarget("TOP_LEVEL_PROPERTY", 33, false), new KotlinTarget("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 34, false), new KotlinTarget("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 35, false), new KotlinTarget("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 36, false), new KotlinTarget("BACKING_FIELD", 37, true), new KotlinTarget("INITIALIZER", 38, false), new KotlinTarget("DESTRUCTURING_DECLARATION", 39, false), new KotlinTarget("LAMBDA_EXPRESSION", 40, false), new KotlinTarget("ANONYMOUS_FUNCTION", 41, false), new KotlinTarget("OBJECT_LITERAL", 42, false)};
        f4968Q = kotlinTargetArr;
        a<KotlinTarget> aVarA = kotlin.enums.a.a(kotlinTargetArr);
        f4969R = aVarA;
        b = new HashMap();
        for (KotlinTarget kotlinTarget27 : aVarA) {
            b.put(kotlinTarget27.name(), kotlinTarget27);
        }
        a aVar = f4969R;
        ArrayList arrayList = new ArrayList();
        for (Object obj : aVar) {
            if (((KotlinTarget) obj).f4979a) {
                arrayList.add(obj);
            }
        }
        c = v.j1(arrayList);
        d = v.j1(f4969R);
        KotlinTarget kotlinTarget28 = f4973s;
        KotlinTarget kotlinTarget29 = f4972r;
        e = o.N(kotlinTarget28, kotlinTarget29);
        f = o.N(f4967P, kotlinTarget29);
        g = o.N(E, kotlinTarget29);
        KotlinTarget kotlinTarget30 = f4963L;
        KotlinTarget kotlinTarget31 = f4961F;
        h = o.N(kotlinTarget30, kotlinTarget31, kotlinTarget29);
        i = o.N(f4962G, kotlinTarget31, kotlinTarget29);
        f4970j = o.N(f4964M, kotlinTarget29);
        k = o.N(f4965N, kotlinTarget29);
        KotlinTarget kotlinTarget32 = f4966O;
        KotlinTarget kotlinTarget33 = u;
        KotlinTarget kotlinTarget34 = f4975v;
        l = o.N(kotlinTarget32, kotlinTarget33, kotlinTarget34);
        KotlinTarget kotlinTarget35 = f4958B;
        m = o.M(kotlinTarget35);
        KotlinTarget kotlinTarget36 = f4957A;
        n = o.M(kotlinTarget36);
        o = o.M(f4978z);
        KotlinTarget kotlinTarget37 = f4960D;
        p = o.M(kotlinTarget37);
        AnnotationUseSiteTarget annotationUseSiteTarget = AnnotationUseSiteTarget.h;
        KotlinTarget kotlinTarget38 = f4977x;
        f4971q = kotlin.collections.a.R(new Pair(annotationUseSiteTarget, kotlinTarget38), new Pair(AnnotationUseSiteTarget.b, kotlinTarget34), new Pair(AnnotationUseSiteTarget.d, kotlinTarget33), new Pair(AnnotationUseSiteTarget.c, kotlinTarget37), new Pair(AnnotationUseSiteTarget.e, kotlinTarget36), new Pair(AnnotationUseSiteTarget.f, kotlinTarget35), new Pair(AnnotationUseSiteTarget.g, kotlinTarget38), new Pair(AnnotationUseSiteTarget.i, kotlinTarget38), new Pair(AnnotationUseSiteTarget.f4954j, kotlinTarget34));
    }

    public KotlinTarget(String str, int i6, boolean z10) {
        this.f4979a = z10;
    }

    public static KotlinTarget valueOf(String str) {
        return (KotlinTarget) Enum.valueOf(KotlinTarget.class, str);
    }

    public static KotlinTarget[] values() {
        return (KotlinTarget[]) f4968Q.clone();
    }
}
