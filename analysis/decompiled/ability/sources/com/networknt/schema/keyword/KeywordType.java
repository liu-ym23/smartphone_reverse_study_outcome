package com.networknt.schema.keyword;

import G6.c;
import com.bumptech.glide.load.resource.bitmap.b;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.SpecificationVersionRange;
import com.networknt.schema.keyword.KeywordType;
import java.util.ArrayList;
import java.util.HashMap;
import u3.i;
import u3.j;
import z3.AbstractC2156a;
import z3.L;
import z3.t;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'd' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public class KeywordType implements t {

    /* renamed from: A, reason: collision with root package name */
    public static final KeywordType f3017A;

    /* renamed from: B, reason: collision with root package name */
    public static final KeywordType f3018B;

    /* renamed from: C, reason: collision with root package name */
    public static final KeywordType f3019C;

    /* renamed from: D, reason: collision with root package name */
    public static final KeywordType f3020D;
    public static final KeywordType E;

    /* renamed from: F, reason: collision with root package name */
    public static final KeywordType f3021F;

    /* renamed from: G, reason: collision with root package name */
    public static final KeywordType f3022G;

    /* renamed from: L, reason: collision with root package name */
    public static final KeywordType f3023L;

    /* renamed from: M, reason: collision with root package name */
    public static final KeywordType f3024M;

    /* renamed from: N, reason: collision with root package name */
    public static final KeywordType f3025N;

    /* renamed from: O, reason: collision with root package name */
    public static final KeywordType f3026O;

    /* renamed from: P, reason: collision with root package name */
    public static final KeywordType f3027P;

    /* renamed from: Q, reason: collision with root package name */
    public static final KeywordType f3028Q;

    /* renamed from: R, reason: collision with root package name */
    public static final KeywordType f3029R;

    /* renamed from: S, reason: collision with root package name */
    public static final KeywordType f3030S;

    /* renamed from: T, reason: collision with root package name */
    public static final KeywordType f3031T;

    /* renamed from: U, reason: collision with root package name */
    public static final KeywordType f3032U;

    /* renamed from: V, reason: collision with root package name */
    public static final KeywordType f3033V;

    /* renamed from: W, reason: collision with root package name */
    public static final KeywordType f3034W;

    /* renamed from: X, reason: collision with root package name */
    public static final KeywordType f3035X;

    /* renamed from: Y, reason: collision with root package name */
    public static final KeywordType f3036Y;

    /* renamed from: Z, reason: collision with root package name */
    public static final KeywordType f3037Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final KeywordType f3038a0;
    public static final KeywordType b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final KeywordType f3039c0;
    public static final KeywordType d;

    /* renamed from: d0, reason: collision with root package name */
    public static final KeywordType f3040d0;
    public static final KeywordType e;

    /* renamed from: e0, reason: collision with root package name */
    public static final KeywordType f3041e0;
    public static final KeywordType f;

    /* renamed from: f0, reason: collision with root package name */
    public static final KeywordType f3042f0;
    public static final KeywordType g;

    /* renamed from: g0, reason: collision with root package name */
    public static final HashMap f3043g0;
    public static final KeywordType h;

    /* renamed from: h0, reason: collision with root package name */
    public static final /* synthetic */ KeywordType[] f3044h0;
    public static final KeywordType i;

    /* renamed from: j, reason: collision with root package name */
    public static final KeywordType f3045j;
    public static final KeywordType k;
    public static final KeywordType l;
    public static final KeywordType m;
    public static final KeywordType n;
    public static final KeywordType o;
    public static final KeywordType p;

    /* renamed from: q, reason: collision with root package name */
    public static final KeywordType f3046q;

    /* renamed from: r, reason: collision with root package name */
    public static final KeywordType f3047r;

    /* renamed from: s, reason: collision with root package name */
    public static final KeywordType f3048s;

    /* renamed from: t, reason: collision with root package name */
    public static final KeywordType f3049t;
    public static final KeywordType u;

    /* renamed from: v, reason: collision with root package name */
    public static final KeywordType f3050v;

    /* renamed from: w, reason: collision with root package name */
    public static final KeywordType f3051w;

    /* renamed from: x, reason: collision with root package name */
    public static final KeywordType f3052x;
    public static final KeywordType y;

    /* renamed from: z, reason: collision with root package name */
    public static final KeywordType f3053z;

    /* renamed from: a, reason: collision with root package name */
    public final String f3054a;
    public final L b;
    public final SpecificationVersionRange c;

    /* renamed from: com.networknt.schema.keyword.KeywordType$1, reason: invalid class name */
    public enum AnonymousClass1 extends KeywordType {
        @Override // com.networknt.schema.keyword.KeywordType, z3.t
        public final AbstractC2156a a(j jVar, JsonNode jsonNode, i iVar, c cVar) {
            throw new UnsupportedOperationException("Use FormatKeyword instead");
        }
    }

    static {
        b bVar = new b(13);
        SpecificationVersionRange specificationVersionRange = SpecificationVersionRange.f;
        KeywordType keywordType = new KeywordType("ADDITIONAL_PROPERTIES", 0, "additionalProperties", bVar, specificationVersionRange);
        d = keywordType;
        KeywordType keywordType2 = new KeywordType("ALL_OF", 1, "allOf", new b(15), specificationVersionRange);
        e = keywordType2;
        final int i6 = 26;
        KeywordType keywordType3 = new KeywordType("ANY_OF", 2, "anyOf", new b(i6), specificationVersionRange);
        f = keywordType3;
        final int i10 = 8;
        L l5 = new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i10) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType4 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType4, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType4.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        };
        SpecificationVersionRange specificationVersionRange2 = SpecificationVersionRange.e;
        KeywordType keywordType4 = new KeywordType("CONST", 3, "const", l5, specificationVersionRange2);
        g = keywordType4;
        final int i11 = 20;
        KeywordType keywordType5 = new KeywordType("CONTAINS", 4, "contains", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i11) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange2);
        h = keywordType5;
        final int i12 = 21;
        L l9 = new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i12) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        };
        SpecificationVersionRange specificationVersionRange3 = SpecificationVersionRange.i;
        KeywordType keywordType6 = new KeywordType("CONTENT_ENCODING", 5, "contentEncoding", l9, specificationVersionRange3);
        i = keywordType6;
        final int i13 = 22;
        KeywordType keywordType7 = new KeywordType("CONTENT_MEDIA_TYPE", 6, "contentMediaType", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i13) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange3);
        f3045j = keywordType7;
        final int i14 = 23;
        L l10 = new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i14) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        };
        SpecificationVersionRange specificationVersionRange4 = SpecificationVersionRange.c;
        KeywordType keywordType8 = new KeywordType("DEPENDENCIES", 7, "dependencies", l10, specificationVersionRange4);
        k = keywordType8;
        final int i15 = 24;
        L l11 = new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i15) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        };
        SpecificationVersionRange specificationVersionRange5 = SpecificationVersionRange.b;
        KeywordType keywordType9 = new KeywordType("DEPENDENT_REQUIRED", 8, "dependentRequired", l11, specificationVersionRange5);
        l = keywordType9;
        final int i16 = 25;
        KeywordType keywordType10 = new KeywordType("DEPENDENT_SCHEMAS", 9, "dependentSchemas", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i16) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange5);
        m = keywordType10;
        KeywordType keywordType11 = new KeywordType("DISCRIMINATOR", 10, "discriminator", new b(i15), specificationVersionRange5);
        n = keywordType11;
        final int i17 = 5;
        KeywordType keywordType12 = new KeywordType("DYNAMIC_REF", 11, "$dynamicRef", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i17) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange5);
        o = keywordType12;
        final int i18 = 16;
        KeywordType keywordType13 = new KeywordType("ENUM", 12, "enum", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i18) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange);
        p = keywordType13;
        KeywordType keywordType14 = new KeywordType("EXCLUSIVE_MAXIMUM", 13, "exclusiveMaximum", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i6) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange2);
        f3046q = keywordType14;
        final int i19 = 27;
        KeywordType keywordType15 = new KeywordType("EXCLUSIVE_MINIMUM", 14, "exclusiveMinimum", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i19) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange2);
        f3047r = keywordType15;
        final int i20 = 28;
        L l12 = new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i20) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        };
        SpecificationVersionRange specificationVersionRange6 = SpecificationVersionRange.d;
        KeywordType keywordType16 = new KeywordType("FALSE", 15, "false", l12, specificationVersionRange6);
        f3048s = keywordType16;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1("FORMAT", 16, "format", null, specificationVersionRange);
        f3049t = anonymousClass1;
        KeywordType keywordType17 = new KeywordType("ID", 17, "id", null, specificationVersionRange4);
        u = keywordType17;
        final int i21 = 29;
        KeywordType keywordType18 = new KeywordType("IF_THEN_ELSE", 18, "if", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i21) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange3);
        f3050v = keywordType18;
        final int i22 = 0;
        KeywordType keywordType19 = new KeywordType("ITEMS", 19, "items", new L() { // from class: z3.v
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i22) {
                    case 0:
                        return new s(jVar, jsonNode, iVar, cVar);
                    default:
                        return new r(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange5);
        f3051w = keywordType19;
        final int i23 = 1;
        KeywordType keywordType20 = new KeywordType("ITEMS_LEGACY", 20, "items", new L() { // from class: z3.v
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i23) {
                    case 0:
                        return new s(jVar, jsonNode, iVar, cVar);
                    default:
                        return new r(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange);
        f3052x = keywordType20;
        final int i24 = 14;
        KeywordType keywordType21 = new KeywordType("MAX_CONTAINS", 21, "maxContains", new b(i24), specificationVersionRange5);
        y = keywordType21;
        KeywordType keywordType22 = new KeywordType("MAX_ITEMS", 22, "maxItems", new b(i18), specificationVersionRange);
        f3053z = keywordType22;
        KeywordType keywordType23 = new KeywordType("MAX_LENGTH", 23, "maxLength", new b(17), specificationVersionRange);
        f3017A = keywordType23;
        KeywordType keywordType24 = new KeywordType("MAX_PROPERTIES", 24, "maxProperties", new b(18), specificationVersionRange);
        f3018B = keywordType24;
        KeywordType keywordType25 = new KeywordType("MAXIMUM", 25, "maximum", new b(19), specificationVersionRange);
        f3019C = keywordType25;
        KeywordType keywordType26 = new KeywordType("MIN_CONTAINS", 26, "minContains", new b(i24), specificationVersionRange5);
        f3020D = keywordType26;
        KeywordType keywordType27 = new KeywordType("MIN_ITEMS", 27, "minItems", new b(i11), specificationVersionRange);
        E = keywordType27;
        KeywordType keywordType28 = new KeywordType("MIN_LENGTH", 28, "minLength", new b(i12), specificationVersionRange);
        f3021F = keywordType28;
        KeywordType keywordType29 = new KeywordType("MIN_PROPERTIES", 29, "minProperties", new b(i13), specificationVersionRange);
        f3022G = keywordType29;
        KeywordType keywordType30 = new KeywordType("MINIMUM", 30, "minimum", new b(23), specificationVersionRange);
        f3023L = keywordType30;
        KeywordType keywordType31 = new KeywordType("MULTIPLE_OF", 31, "multipleOf", new b(25), specificationVersionRange);
        f3024M = keywordType31;
        KeywordType keywordType32 = new KeywordType("NOT_ALLOWED", 32, "notAllowed", new b(i19), specificationVersionRange4);
        f3025N = keywordType32;
        KeywordType keywordType33 = new KeywordType("NOT", 33, "not", new b(28), specificationVersionRange);
        f3026O = keywordType33;
        KeywordType keywordType34 = new KeywordType("ONE_OF", 34, "oneOf", new b(29), specificationVersionRange);
        f3027P = keywordType34;
        final int i25 = 0;
        KeywordType keywordType35 = new KeywordType("PATTERN_PROPERTIES", 35, "patternProperties", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i25) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange);
        f3028Q = keywordType35;
        final int i26 = 1;
        KeywordType keywordType36 = new KeywordType("PATTERN", 36, "pattern", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i26) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange);
        f3029R = keywordType36;
        final int i27 = 2;
        KeywordType keywordType37 = new KeywordType("PREFIX_ITEMS", 37, "prefixItems", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i27) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange5);
        f3030S = keywordType37;
        final int i28 = 3;
        KeywordType keywordType38 = new KeywordType("PROPERTIES", 38, "properties", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i28) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange);
        f3031T = keywordType38;
        final int i29 = 4;
        KeywordType keywordType39 = new KeywordType("PROPERTY_DEPENDENCIES", 39, "propertyDependencies", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i29) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange5);
        f3032U = keywordType39;
        final int i30 = 6;
        KeywordType keywordType40 = new KeywordType("PROPERTY_NAMES", 40, "propertyNames", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i30) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange2);
        f3033V = keywordType40;
        final int i31 = 7;
        KeywordType keywordType41 = new KeywordType("READ_ONLY", 41, "readOnly", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i31) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType42 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType42, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType42.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange3);
        f3034W = keywordType41;
        final int i32 = 9;
        KeywordType keywordType42 = new KeywordType("RECURSIVE_REF", 42, "$recursiveRef", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i32) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType422 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType422, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType422.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange5);
        f3035X = keywordType42;
        final int i33 = 10;
        KeywordType keywordType43 = new KeywordType("REF", 43, "$ref", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i33) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType422 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType422, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType422.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange);
        f3036Y = keywordType43;
        final int i34 = 11;
        KeywordType keywordType44 = new KeywordType("REQUIRED", 44, "required", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i34) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType422 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType422, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType422.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange);
        f3037Z = keywordType44;
        final int i35 = 12;
        KeywordType keywordType45 = new KeywordType("TRUE", 45, "true", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i35) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType422 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType422, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType422.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange6);
        f3038a0 = keywordType45;
        final int i36 = 13;
        KeywordType keywordType46 = new KeywordType("TYPE", 46, "type", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i36) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType422 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType422, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType422.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange);
        b0 = keywordType46;
        KeywordType keywordType47 = new KeywordType("UNEVALUATED_ITEMS", 47, "unevaluatedItems", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i24) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType422 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType422, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType422.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange5);
        f3039c0 = keywordType47;
        final int i37 = 15;
        KeywordType keywordType48 = new KeywordType("UNEVALUATED_PROPERTIES", 48, "unevaluatedProperties", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i37) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType422 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType422, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType422.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange5);
        f3040d0 = keywordType48;
        final int i38 = 17;
        KeywordType keywordType49 = new KeywordType("UNION_TYPE", 49, "unionType", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i38) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType422 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType422, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType422.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange5);
        final int i39 = 18;
        KeywordType keywordType50 = new KeywordType("UNIQUE_ITEMS", 50, "uniqueItems", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i39) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType422 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType422, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType422.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange);
        f3041e0 = keywordType50;
        final int i40 = 19;
        KeywordType keywordType51 = new KeywordType("WRITE_ONLY", 51, "writeOnly", new L() { // from class: z3.u
            @Override // z3.L
            public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
                switch (i40) {
                    case 0:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 3);
                    case 1:
                        return new B(jVar, jsonNode, iVar, cVar);
                    case 2:
                        return new C2158c(jVar, jsonNode, iVar, cVar, 3);
                    case 3:
                        return new C(jVar, jsonNode, iVar, cVar, 0);
                    case 4:
                        return new C(jVar, jsonNode, iVar, cVar, 1);
                    case 5:
                        return new C2162g(KeywordType.o, jsonNode, jVar, iVar, cVar, 1);
                    case 6:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 1);
                    case 7:
                        D d6 = new D(KeywordType.f3034W, jsonNode, jVar, iVar, cVar);
                        D.f.a("Loaded ReadOnlyValidator for property {} as {}", iVar, "read mode");
                        return d6;
                    case 8:
                        return new C2162g(KeywordType.g, jsonNode, jVar, iVar, cVar, 0);
                    case 9:
                        KeywordType keywordType422 = KeywordType.f3035X;
                        C2162g c2162g = new C2162g(keywordType422, jsonNode, jVar, iVar, cVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return c2162g;
                        }
                        u3.g gVarJ = c2162g.j();
                        gVarJ.f6696a = keywordType422.f3054a;
                        gVarJ.i = "internal.invalidRecursiveRef";
                        gVarJ.g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        gVarJ.d = jVar.b;
                        gVarJ.e = new Object[]{strAsText};
                        throw new SchemaException(gVarJ.a());
                    case 10:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 4);
                    case 11:
                        return new z(jVar, jsonNode, iVar, cVar, 1);
                    case 12:
                        return new C2162g(KeywordType.f3038a0, jsonNode, jVar, iVar, cVar, 4);
                    case 13:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 2);
                    case 14:
                        return new x(jVar, jsonNode, iVar, cVar, 2);
                    case 15:
                        return new C2155A(jVar, jsonNode, iVar, cVar, 2);
                    case 16:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 1);
                    case 17:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 3);
                    case 18:
                        return new I(jVar, jsonNode, iVar, cVar);
                    case 19:
                        M m2 = new M(KeywordType.f3042f0, jsonNode, jVar, iVar, cVar);
                        M.f.a("Loaded WriteOnlyValidator for property {} as {}", iVar, "write mode");
                        return m2;
                    case 20:
                        return new C2157b(jVar, jsonNode, iVar, cVar, 1);
                    case 21:
                        return new C2163h(jVar, jsonNode, iVar, cVar, 0);
                    case 22:
                        return new C2164i(jVar, jsonNode, iVar, cVar);
                    case 23:
                        return new C2165j(jVar, jsonNode, iVar, cVar, 0);
                    case 24:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 0);
                    case 25:
                        return new C2166k(jVar, jsonNode, iVar, cVar, 1);
                    case 26:
                        return new n(jVar, jsonNode, iVar, cVar, 0);
                    case 27:
                        return new n(jVar, jsonNode, iVar, cVar, 1);
                    case 28:
                        return new C2162g(KeywordType.f3048s, jsonNode, jVar, iVar, cVar, 2);
                    default:
                        return new q(jVar, jsonNode, iVar, cVar);
                }
            }
        }, specificationVersionRange3);
        f3042f0 = keywordType51;
        f3044h0 = new KeywordType[]{keywordType, keywordType2, keywordType3, keywordType4, keywordType5, keywordType6, keywordType7, keywordType8, keywordType9, keywordType10, keywordType11, keywordType12, keywordType13, keywordType14, keywordType15, keywordType16, anonymousClass1, keywordType17, keywordType18, keywordType19, keywordType20, keywordType21, keywordType22, keywordType23, keywordType24, keywordType25, keywordType26, keywordType27, keywordType28, keywordType29, keywordType30, keywordType31, keywordType32, keywordType33, keywordType34, keywordType35, keywordType36, keywordType37, keywordType38, keywordType39, keywordType40, keywordType41, keywordType42, keywordType43, keywordType44, keywordType45, keywordType46, keywordType47, keywordType48, keywordType49, keywordType50, keywordType51};
        f3043g0 = new HashMap();
        for (KeywordType keywordType52 : values()) {
            f3043g0.put(keywordType52.f3054a, keywordType52);
        }
    }

    public KeywordType(String str, int i6, String str2, L l5, SpecificationVersionRange specificationVersionRange) {
        this.f3054a = str2;
        this.b = l5;
        this.c = specificationVersionRange;
    }

    public static ArrayList b(SpecificationVersion specificationVersion) {
        ArrayList arrayList = new ArrayList();
        for (KeywordType keywordType : values()) {
            if (keywordType.c.f3015a.contains(specificationVersion)) {
                arrayList.add(keywordType);
            }
        }
        return arrayList;
    }

    public static KeywordType valueOf(String str) {
        return (KeywordType) Enum.valueOf(KeywordType.class, str);
    }

    public static KeywordType[] values() {
        return (KeywordType[]) f3044h0.clone();
    }

    @Override // z3.t
    public AbstractC2156a a(j jVar, JsonNode jsonNode, i iVar, c cVar) {
        L l5 = this.b;
        if (l5 != null) {
            return l5.a(jVar, jsonNode, iVar, cVar);
        }
        throw new UnsupportedOperationException("No suitable validator for ".concat(this.f3054a));
    }

    @Override // z3.t
    public final String getValue() {
        return this.f3054a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f3054a;
    }
}
