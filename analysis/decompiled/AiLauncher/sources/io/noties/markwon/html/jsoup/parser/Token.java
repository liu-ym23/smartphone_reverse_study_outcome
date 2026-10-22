package io.noties.markwon.html.jsoup.parser;

/* loaded from: classes4.dex */
public abstract class Token {

    /* renamed from: a, reason: collision with root package name */
    public final TokenType f34220a;

    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    public static final class a extends b {
        public a(String str) {
            c(str);
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token.b
        public String toString() {
            return "<![CDATA[" + d() + "]]>";
        }
    }

    public static class b extends Token {

        /* renamed from: b, reason: collision with root package name */
        public String f34221b;

        public b() {
            super(TokenType.Character);
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token a() {
            this.f34221b = null;
            return this;
        }

        public b c(String str) {
            this.f34221b = str;
            return this;
        }

        public String d() {
            return this.f34221b;
        }

        public String toString() {
            return d();
        }
    }

    public static final class c extends Token {

        /* renamed from: b, reason: collision with root package name */
        public final StringBuilder f34222b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f34223c;

        public c() {
            super(TokenType.Comment);
            this.f34222b = new StringBuilder();
            this.f34223c = false;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token a() {
            Token.b(this.f34222b);
            this.f34223c = false;
            return this;
        }

        public String c() {
            return this.f34222b.toString();
        }

        public String toString() {
            return "<!--" + c() + "-->";
        }
    }

    public static final class d extends Token {

        /* renamed from: b, reason: collision with root package name */
        public final StringBuilder f34224b;

        /* renamed from: c, reason: collision with root package name */
        public String f34225c;

        /* renamed from: d, reason: collision with root package name */
        public final StringBuilder f34226d;

        /* renamed from: e, reason: collision with root package name */
        public final StringBuilder f34227e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f34228f;

        public d() {
            super(TokenType.Doctype);
            this.f34224b = new StringBuilder();
            this.f34225c = null;
            this.f34226d = new StringBuilder();
            this.f34227e = new StringBuilder();
            this.f34228f = false;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token a() {
            Token.b(this.f34224b);
            this.f34225c = null;
            Token.b(this.f34226d);
            Token.b(this.f34227e);
            this.f34228f = false;
            return this;
        }
    }

    public static final class e extends Token {
        public e() {
            super(TokenType.EOF);
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token a() {
            return this;
        }
    }

    public static final class f extends h {
        public f() {
            super(TokenType.EndTag);
        }

        public String toString() {
            return "</" + m() + ">";
        }
    }

    public static final class g extends h {
        public g() {
            super(TokenType.StartTag);
            this.f34237j = new E8.b();
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token.h, io.noties.markwon.html.jsoup.parser.Token
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public h a() {
            super.a();
            this.f34237j = new E8.b();
            return this;
        }

        public String toString() {
            E8.b bVar = this.f34237j;
            if (bVar == null || bVar.size() <= 0) {
                return "<" + m() + ">";
            }
            return "<" + m() + " " + this.f34237j.toString() + ">";
        }
    }

    public static abstract class h extends Token {

        /* renamed from: b, reason: collision with root package name */
        public String f34229b;

        /* renamed from: c, reason: collision with root package name */
        public String f34230c;

        /* renamed from: d, reason: collision with root package name */
        public String f34231d;

        /* renamed from: e, reason: collision with root package name */
        public StringBuilder f34232e;

        /* renamed from: f, reason: collision with root package name */
        public String f34233f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f34234g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f34235h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f34236i;

        /* renamed from: j, reason: collision with root package name */
        public E8.b f34237j;

        public h(TokenType tokenType) {
            super(tokenType);
            this.f34232e = new StringBuilder();
            this.f34234g = false;
            this.f34235h = false;
            this.f34236i = false;
        }

        public final void c(char c10) {
            d(String.valueOf(c10));
        }

        public final void d(String str) {
            String str2 = this.f34231d;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f34231d = str;
        }

        public final void e(char c10) {
            j();
            this.f34232e.append(c10);
        }

        public final void f(String str) {
            j();
            if (this.f34232e.length() == 0) {
                this.f34233f = str;
            } else {
                this.f34232e.append(str);
            }
        }

        public final void g(int[] iArr) {
            j();
            for (int i10 : iArr) {
                this.f34232e.appendCodePoint(i10);
            }
        }

        public final void h(char c10) {
            i(String.valueOf(c10));
        }

        public final void i(String str) {
            String str2 = this.f34229b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f34229b = str;
            this.f34230c = D8.a.a(str);
        }

        public final void j() {
            this.f34235h = true;
            String str = this.f34233f;
            if (str != null) {
                this.f34232e.append(str);
                this.f34233f = null;
            }
        }

        public final void k() {
            if (this.f34231d != null) {
                n();
            }
        }

        public final h l(String str) {
            this.f34229b = str;
            this.f34230c = D8.a.a(str);
            return this;
        }

        public final String m() {
            String str = this.f34229b;
            D8.b.b(str == null || str.length() == 0);
            return this.f34229b;
        }

        public final void n() {
            if (this.f34237j == null) {
                this.f34237j = new E8.b();
            }
            String str = this.f34231d;
            if (str != null) {
                String strTrim = str.trim();
                this.f34231d = strTrim;
                if (strTrim.length() > 0) {
                    this.f34237j.u(this.f34231d, this.f34235h ? this.f34232e.length() > 0 ? this.f34232e.toString() : this.f34233f : this.f34234g ? "" : null);
                }
            }
            this.f34231d = null;
            this.f34234g = false;
            this.f34235h = false;
            Token.b(this.f34232e);
            this.f34233f = null;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        /* renamed from: o */
        public h a() {
            this.f34229b = null;
            this.f34230c = null;
            this.f34231d = null;
            Token.b(this.f34232e);
            this.f34233f = null;
            this.f34234g = false;
            this.f34235h = false;
            this.f34236i = false;
            this.f34237j = null;
            return this;
        }

        public final void p() {
            this.f34234g = true;
        }
    }

    public Token(TokenType tokenType) {
        this.f34220a = tokenType;
    }

    public static void b(StringBuilder sb2) {
        if (sb2 != null) {
            sb2.delete(0, sb2.length());
        }
    }

    public abstract Token a();
}
