package com.typesafe.config.impl;

import com.autonavi.aps.amapapi.config.Const;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.ConfigString;
import io.ktor.sse.ServerSentEventKt;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class S {

    /* renamed from: a, reason: collision with root package name */
    public static final Q f31787a = Q.c(TokenType.START, "start of file", "");

    /* renamed from: b, reason: collision with root package name */
    public static final Q f31788b = Q.c(TokenType.END, "end of file", "");

    /* renamed from: c, reason: collision with root package name */
    public static final Q f31789c = Q.c(TokenType.COMMA, "','", Const.STR_MART_COMMA);

    /* renamed from: d, reason: collision with root package name */
    public static final Q f31790d = Q.c(TokenType.EQUALS, "'='", "=");

    /* renamed from: e, reason: collision with root package name */
    public static final Q f31791e = Q.c(TokenType.COLON, "':'", ServerSentEventKt.COLON);

    /* renamed from: f, reason: collision with root package name */
    public static final Q f31792f = Q.c(TokenType.OPEN_CURLY, "'{'", Const.STR_MART_JSON_BEGIN);

    /* renamed from: g, reason: collision with root package name */
    public static final Q f31793g = Q.c(TokenType.CLOSE_CURLY, "'}'", "}");

    /* renamed from: h, reason: collision with root package name */
    public static final Q f31794h = Q.c(TokenType.OPEN_SQUARE, "'['", "[");

    /* renamed from: i, reason: collision with root package name */
    public static final Q f31795i = Q.c(TokenType.CLOSE_SQUARE, "']'", "]");

    /* renamed from: j, reason: collision with root package name */
    public static final Q f31796j = Q.c(TokenType.PLUS_EQUALS, "'+='", "+=");

    public static abstract class a extends Q {

        /* renamed from: e, reason: collision with root package name */
        public final String f31797e;

        /* renamed from: com.typesafe.config.impl.S$a$a, reason: collision with other inner class name */
        public static final class C0380a extends a {
            public C0380a(b8.k kVar, String str) {
                super(kVar, str);
            }

            @Override // com.typesafe.config.impl.Q
            public String e() {
                return "//" + this.f31797e;
            }
        }

        public static final class b extends a {
            public b(b8.k kVar, String str) {
                super(kVar, str);
            }

            @Override // com.typesafe.config.impl.Q
            public String e() {
                return Const.STR_MART_WELL + this.f31797e;
            }
        }

        public a(b8.k kVar, String str) {
            super(TokenType.COMMENT, kVar);
            this.f31797e = str;
        }

        @Override // com.typesafe.config.impl.Q
        public boolean a(Object obj) {
            return obj instanceof a;
        }

        @Override // com.typesafe.config.impl.Q
        public boolean equals(Object obj) {
            return super.equals(obj) && ((a) obj).f31797e.equals(this.f31797e);
        }

        public String g() {
            return this.f31797e;
        }

        @Override // com.typesafe.config.impl.Q
        public int hashCode() {
            return (((super.hashCode() + 41) * 41) + this.f31797e.hashCode()) * 41;
        }

        @Override // com.typesafe.config.impl.Q
        public String toString() {
            return "'#" + this.f31797e + "' (COMMENT)";
        }
    }

    public static class b extends Q {

        /* renamed from: e, reason: collision with root package name */
        public final String f31798e;

        public b(b8.k kVar, String str) {
            super(TokenType.IGNORED_WHITESPACE, kVar);
            this.f31798e = str;
        }

        @Override // com.typesafe.config.impl.Q
        public boolean a(Object obj) {
            return obj instanceof b;
        }

        @Override // com.typesafe.config.impl.Q
        public String e() {
            return this.f31798e;
        }

        @Override // com.typesafe.config.impl.Q
        public boolean equals(Object obj) {
            return super.equals(obj) && ((b) obj).f31798e.equals(this.f31798e);
        }

        @Override // com.typesafe.config.impl.Q
        public int hashCode() {
            return ((super.hashCode() + 41) * 41) + this.f31798e.hashCode();
        }

        @Override // com.typesafe.config.impl.Q
        public String toString() {
            return "'" + this.f31798e + "' (WHITESPACE)";
        }
    }

    public static class c extends Q {
        public c(b8.k kVar) {
            super(TokenType.NEWLINE, kVar);
        }

        @Override // com.typesafe.config.impl.Q
        public boolean a(Object obj) {
            return obj instanceof c;
        }

        @Override // com.typesafe.config.impl.Q
        public String e() {
            return "\n";
        }

        @Override // com.typesafe.config.impl.Q
        public boolean equals(Object obj) {
            return super.equals(obj) && ((c) obj).b() == b();
        }

        @Override // com.typesafe.config.impl.Q
        public int hashCode() {
            return ((super.hashCode() + 41) * 41) + b();
        }

        @Override // com.typesafe.config.impl.Q
        public String toString() {
            return "'\\n'@" + b();
        }
    }

    public static class d extends Q {

        /* renamed from: e, reason: collision with root package name */
        public final String f31799e;

        /* renamed from: f, reason: collision with root package name */
        public final String f31800f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f31801g;

        /* renamed from: h, reason: collision with root package name */
        public final Throwable f31802h;

        public d(b8.k kVar, String str, String str2, boolean z10, Throwable th) {
            super(TokenType.PROBLEM, kVar);
            this.f31799e = str;
            this.f31800f = str2;
            this.f31801g = z10;
            this.f31802h = th;
        }

        @Override // com.typesafe.config.impl.Q
        public boolean a(Object obj) {
            return obj instanceof d;
        }

        @Override // com.typesafe.config.impl.Q
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            d dVar = (d) obj;
            return dVar.f31799e.equals(this.f31799e) && dVar.f31800f.equals(this.f31800f) && dVar.f31801g == this.f31801g && C3904j.b(dVar.f31802h, this.f31802h);
        }

        @Override // com.typesafe.config.impl.Q
        public int hashCode() {
            int iHashCode = (((((((super.hashCode() + 41) * 41) + this.f31799e.hashCode()) * 41) + this.f31800f.hashCode()) * 41) + Boolean.valueOf(this.f31801g).hashCode()) * 41;
            Throwable th = this.f31802h;
            return th != null ? (iHashCode + th.hashCode()) * 41 : iHashCode;
        }

        @Override // com.typesafe.config.impl.Q
        public String toString() {
            return '\'' + this.f31799e + "' (" + this.f31800f + ")";
        }
    }

    public static class e extends Q {

        /* renamed from: e, reason: collision with root package name */
        public final boolean f31803e;

        /* renamed from: f, reason: collision with root package name */
        public final List<Q> f31804f;

        public e(b8.k kVar, boolean z10, List<Q> list) {
            super(TokenType.SUBSTITUTION, kVar);
            this.f31803e = z10;
            this.f31804f = list;
        }

        @Override // com.typesafe.config.impl.Q
        public boolean a(Object obj) {
            return obj instanceof e;
        }

        @Override // com.typesafe.config.impl.Q
        public String e() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("${");
            sb2.append(this.f31803e ? "?" : "");
            sb2.append(Tokenizer.c(this.f31804f.iterator()));
            sb2.append("}");
            return sb2.toString();
        }

        @Override // com.typesafe.config.impl.Q
        public boolean equals(Object obj) {
            return super.equals(obj) && ((e) obj).f31804f.equals(this.f31804f);
        }

        public boolean f() {
            return this.f31803e;
        }

        public List<Q> g() {
            return this.f31804f;
        }

        @Override // com.typesafe.config.impl.Q
        public int hashCode() {
            return ((super.hashCode() + 41) * 41) + this.f31804f.hashCode();
        }

        @Override // com.typesafe.config.impl.Q
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            Iterator<Q> it = this.f31804f.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().toString());
            }
            return "'${" + sb2.toString() + "}'";
        }
    }

    public static class f extends Q {

        /* renamed from: e, reason: collision with root package name */
        public final String f31805e;

        public f(b8.k kVar, String str) {
            super(TokenType.UNQUOTED_TEXT, kVar);
            this.f31805e = str;
        }

        @Override // com.typesafe.config.impl.Q
        public boolean a(Object obj) {
            return obj instanceof f;
        }

        @Override // com.typesafe.config.impl.Q
        public String e() {
            return this.f31805e;
        }

        @Override // com.typesafe.config.impl.Q
        public boolean equals(Object obj) {
            return super.equals(obj) && ((f) obj).f31805e.equals(this.f31805e);
        }

        public String f() {
            return this.f31805e;
        }

        @Override // com.typesafe.config.impl.Q
        public int hashCode() {
            return ((super.hashCode() + 41) * 41) + this.f31805e.hashCode();
        }

        @Override // com.typesafe.config.impl.Q
        public String toString() {
            return "'" + this.f31805e + "'";
        }
    }

    public static class g extends Q {

        /* renamed from: e, reason: collision with root package name */
        public final AbstractConfigValue f31806e;

        public g(AbstractConfigValue abstractConfigValue, String str) {
            super(TokenType.VALUE, abstractConfigValue.e(), str);
            this.f31806e = abstractConfigValue;
        }

        @Override // com.typesafe.config.impl.Q
        public boolean a(Object obj) {
            return obj instanceof g;
        }

        @Override // com.typesafe.config.impl.Q
        public boolean equals(Object obj) {
            return super.equals(obj) && ((g) obj).f31806e.equals(this.f31806e);
        }

        public AbstractConfigValue f() {
            return this.f31806e;
        }

        @Override // com.typesafe.config.impl.Q
        public int hashCode() {
            return ((super.hashCode() + 41) * 41) + this.f31806e.hashCode();
        }

        @Override // com.typesafe.config.impl.Q
        public String toString() {
            if (f().j0() != ResolveStatus.RESOLVED) {
                return "'<unresolved value>' (" + this.f31806e.c().name() + ")";
            }
            return "'" + f().a() + "' (" + this.f31806e.c().name() + ")";
        }
    }

    public static String a(Q q10) {
        if (q10 instanceof a) {
            return ((a) q10).g();
        }
        throw new ConfigException.BugOrBroken("tried to get comment text from " + q10);
    }

    public static boolean b(Q q10) {
        if (q10 instanceof e) {
            return ((e) q10).f();
        }
        throw new ConfigException.BugOrBroken("tried to get substitution optionality from " + q10);
    }

    public static List<Q> c(Q q10) {
        if (q10 instanceof e) {
            return ((e) q10).g();
        }
        throw new ConfigException.BugOrBroken("tried to get substitution from " + q10);
    }

    public static String d(Q q10) {
        if (q10 instanceof f) {
            return ((f) q10).f();
        }
        throw new ConfigException.BugOrBroken("tried to get unquoted text from " + q10);
    }

    public static AbstractConfigValue e(Q q10) {
        if (q10 instanceof g) {
            return ((g) q10).f();
        }
        throw new ConfigException.BugOrBroken("tried to get value of non-value token " + q10);
    }

    public static boolean f(Q q10) {
        return q10 instanceof a;
    }

    public static boolean g(Q q10) {
        return q10 instanceof b;
    }

    public static boolean h(Q q10) {
        return q10 instanceof c;
    }

    public static boolean i(Q q10) {
        return q10 instanceof e;
    }

    public static boolean j(Q q10) {
        return q10 instanceof f;
    }

    public static boolean k(Q q10) {
        return q10 instanceof g;
    }

    public static boolean l(Q q10, ConfigValueType configValueType) {
        return k(q10) && e(q10).c() == configValueType;
    }

    public static Q m(b8.k kVar, boolean z10) {
        return y(new ConfigBoolean(kVar, z10), "" + z10);
    }

    public static Q n(b8.k kVar, String str) {
        return new a.C0380a(kVar, str);
    }

    public static Q o(b8.k kVar, String str) {
        return new a.b(kVar, str);
    }

    public static Q p(b8.k kVar, double d10, String str) {
        return y(ConfigNumber.u0(kVar, d10, str), str);
    }

    public static Q q(b8.k kVar, String str) {
        return new b(kVar, str);
    }

    public static Q r(b8.k kVar) {
        return new c(kVar);
    }

    public static Q s(b8.k kVar, long j10, String str) {
        return y(ConfigNumber.v0(kVar, j10, str), str);
    }

    public static Q t(b8.k kVar) {
        return y(new ConfigNull(kVar), "null");
    }

    public static Q u(b8.k kVar, String str, String str2, boolean z10, Throwable th) {
        return new d(kVar, str, str2, z10, th);
    }

    public static Q v(b8.k kVar, String str, String str2) {
        return y(new ConfigString.Quoted(kVar, str), str2);
    }

    public static Q w(b8.k kVar, boolean z10, List<Q> list) {
        return new e(kVar, z10, list);
    }

    public static Q x(b8.k kVar, String str) {
        return new f(kVar, str);
    }

    public static Q y(AbstractConfigValue abstractConfigValue, String str) {
        return new g(abstractConfigValue, str);
    }
}
