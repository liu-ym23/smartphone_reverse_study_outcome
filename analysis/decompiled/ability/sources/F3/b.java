package F3;

import com.networknt.schema.keyword.KeywordType;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import z3.C2160e;
import z3.t;

/* loaded from: classes3.dex */
public final class b {
    public static final b c;
    public static final b d;
    public static final b e;
    public static final b f;
    public static final b g;
    public static final b h;
    public static final b i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f537j;
    public static final b k;
    public static final b l;
    public static final b m;
    public static final b n;
    public static final b o;
    public static final b p;

    /* renamed from: q, reason: collision with root package name */
    public static final b f538q;

    /* renamed from: a, reason: collision with root package name */
    public final String f539a;
    public final LinkedHashSet b;

    static {
        C2160e c2160e = new C2160e("$id", 1);
        C2160e c2160e2 = new C2160e("$schema", 1);
        C2160e c2160e3 = new C2160e("$anchor", 1);
        KeywordType keywordType = KeywordType.f3036Y;
        c = new b("https://json-schema.org/draft/2019-09/vocab/core", c2160e, c2160e2, c2160e3, keywordType, KeywordType.f3035X, new C2160e("$recursiveAnchor", 1), new C2160e("$vocabulary", 1), new C2160e("$comment", 1), new C2160e("$defs", 1));
        C2160e c2160e4 = new C2160e("additionalItems", 1);
        KeywordType keywordType2 = KeywordType.f3039c0;
        KeywordType keywordType3 = KeywordType.h;
        KeywordType keywordType4 = KeywordType.d;
        KeywordType keywordType5 = KeywordType.f3040d0;
        KeywordType keywordType6 = KeywordType.f3031T;
        KeywordType keywordType7 = KeywordType.f3028Q;
        KeywordType keywordType8 = KeywordType.m;
        KeywordType keywordType9 = KeywordType.f3033V;
        KeywordType keywordType10 = KeywordType.f3050v;
        C2160e c2160e5 = new C2160e("then", 1);
        C2160e c2160e6 = new C2160e("else", 1);
        KeywordType keywordType11 = KeywordType.e;
        KeywordType keywordType12 = KeywordType.f;
        KeywordType keywordType13 = KeywordType.f3027P;
        KeywordType keywordType14 = KeywordType.f3026O;
        d = new b("https://json-schema.org/draft/2019-09/vocab/applicator", c2160e4, keywordType2, KeywordType.f3052x, keywordType3, keywordType4, keywordType5, keywordType6, keywordType7, keywordType8, keywordType9, keywordType10, c2160e5, c2160e6, keywordType11, keywordType12, keywordType13, keywordType14);
        KeywordType keywordType15 = KeywordType.f3024M;
        KeywordType keywordType16 = KeywordType.f3019C;
        KeywordType keywordType17 = KeywordType.f3046q;
        KeywordType keywordType18 = KeywordType.f3023L;
        KeywordType keywordType19 = KeywordType.f3047r;
        KeywordType keywordType20 = KeywordType.f3017A;
        KeywordType keywordType21 = KeywordType.f3021F;
        KeywordType keywordType22 = KeywordType.f3029R;
        KeywordType keywordType23 = KeywordType.f3053z;
        KeywordType keywordType24 = KeywordType.E;
        KeywordType keywordType25 = KeywordType.f3041e0;
        KeywordType keywordType26 = KeywordType.y;
        KeywordType keywordType27 = KeywordType.f3020D;
        KeywordType keywordType28 = KeywordType.f3018B;
        KeywordType keywordType29 = KeywordType.f3022G;
        KeywordType keywordType30 = KeywordType.f3037Z;
        KeywordType keywordType31 = KeywordType.l;
        KeywordType keywordType32 = KeywordType.g;
        KeywordType keywordType33 = KeywordType.p;
        KeywordType keywordType34 = KeywordType.b0;
        e = new b("https://json-schema.org/draft/2019-09/vocab/validation", keywordType15, keywordType16, keywordType17, keywordType18, keywordType19, keywordType20, keywordType21, keywordType22, keywordType23, keywordType24, keywordType25, keywordType26, keywordType27, keywordType28, keywordType29, keywordType30, keywordType31, keywordType32, keywordType33, keywordType34);
        C2160e c2160e7 = new C2160e("title", 0);
        C2160e c2160e8 = new C2160e("description", 0);
        C2160e c2160e9 = new C2160e("default", 0);
        C2160e c2160e10 = new C2160e("deprecated", 0);
        KeywordType keywordType35 = KeywordType.f3034W;
        KeywordType keywordType36 = KeywordType.f3042f0;
        f = new b("https://json-schema.org/draft/2019-09/vocab/meta-data", c2160e7, c2160e8, c2160e9, c2160e10, keywordType35, keywordType36, new C2160e("examples", 0));
        KeywordType keywordType37 = KeywordType.f3049t;
        g = new b("https://json-schema.org/draft/2019-09/vocab/format", keywordType37);
        h = new b("https://json-schema.org/draft/2019-09/vocab/content", new C2160e("contentMediaType", 0), new C2160e("contentEncoding", 0), new C2160e("contentSchema", 0));
        i = new b("https://json-schema.org/draft/2020-12/vocab/core", new C2160e("$id", 1), new C2160e("$schema", 1), keywordType, new C2160e("$anchor", 1), KeywordType.o, new C2160e("$dynamicAnchor", 1), new C2160e("$vocabulary", 1), new C2160e("$comment", 1), new C2160e("$defs", 1));
        f537j = new b("https://json-schema.org/draft/2020-12/vocab/applicator", KeywordType.f3030S, KeywordType.f3051w, keywordType3, keywordType4, keywordType6, keywordType7, keywordType8, keywordType9, keywordType10, new C2160e("then", 1), new C2160e("else", 1), keywordType11, keywordType12, keywordType13, keywordType14);
        k = new b("https://json-schema.org/draft/2020-12/vocab/unevaluated", keywordType2, keywordType5);
        l = new b("https://json-schema.org/draft/2020-12/vocab/validation", keywordType34, keywordType32, keywordType33, keywordType15, keywordType16, keywordType17, keywordType18, keywordType19, keywordType20, keywordType21, keywordType22, keywordType23, keywordType24, keywordType25, keywordType26, keywordType27, keywordType28, keywordType29, keywordType30, keywordType31);
        m = new b("https://json-schema.org/draft/2020-12/vocab/meta-data", new C2160e("title", 0), new C2160e("description", 0), new C2160e("default", 0), new C2160e("deprecated", 0), keywordType35, keywordType36, new C2160e("examples", 0));
        n = new b("https://json-schema.org/draft/2020-12/vocab/format-annotation", keywordType37);
        o = new b("https://json-schema.org/draft/2020-12/vocab/format-assertion", keywordType37);
        p = new b("https://json-schema.org/draft/2020-12/vocab/content", new C2160e("contentEncoding", 0), new C2160e("contentMediaType", 0), new C2160e("contentSchema", 0));
        f538q = new b("https://spec.openapis.org/oas/3.1/vocab/base", new C2160e("example", 0), KeywordType.n, new C2160e("externalDocs", 0), new C2160e("xml", 0));
    }

    public b(String str, t... tVarArr) {
        this.f539a = str;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.b = linkedHashSet;
        linkedHashSet.addAll(Arrays.asList(tVarArr));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f539a.equals(bVar.f539a) && Objects.equals(this.b, bVar.b);
    }

    public final int hashCode() {
        return Objects.hash(this.f539a, this.b);
    }

    public final String toString() {
        return "Vocabulary [id=" + this.f539a + ", keywords=" + this.b + "]";
    }
}
