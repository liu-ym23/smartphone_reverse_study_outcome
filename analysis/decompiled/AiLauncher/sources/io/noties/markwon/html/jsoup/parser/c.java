package io.noties.markwon.html.jsoup.parser;

import com.autonavi.aps.amapapi.config.Const;
import io.noties.markwon.html.jsoup.parser.Token;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: r, reason: collision with root package name */
    public static final char[] f34248r;

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f34249s = {8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};

    /* renamed from: a, reason: collision with root package name */
    public final a f34250a;

    /* renamed from: b, reason: collision with root package name */
    public final ParseErrorList f34251b;

    /* renamed from: d, reason: collision with root package name */
    public Token f34253d;

    /* renamed from: i, reason: collision with root package name */
    public Token.h f34258i;

    /* renamed from: o, reason: collision with root package name */
    public String f34264o;

    /* renamed from: c, reason: collision with root package name */
    public TokeniserState f34252c = TokeniserState.Data;

    /* renamed from: e, reason: collision with root package name */
    public boolean f34254e = false;

    /* renamed from: f, reason: collision with root package name */
    public String f34255f = null;

    /* renamed from: g, reason: collision with root package name */
    public StringBuilder f34256g = new StringBuilder(1024);

    /* renamed from: h, reason: collision with root package name */
    public StringBuilder f34257h = new StringBuilder(1024);

    /* renamed from: j, reason: collision with root package name */
    public Token.g f34259j = new Token.g();

    /* renamed from: k, reason: collision with root package name */
    public Token.f f34260k = new Token.f();

    /* renamed from: l, reason: collision with root package name */
    public Token.b f34261l = new Token.b();

    /* renamed from: m, reason: collision with root package name */
    public Token.d f34262m = new Token.d();

    /* renamed from: n, reason: collision with root package name */
    public Token.c f34263n = new Token.c();

    /* renamed from: p, reason: collision with root package name */
    public final int[] f34265p = new int[1];

    /* renamed from: q, reason: collision with root package name */
    public final int[] f34266q = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', '<', '&'};
        f34248r = cArr;
        Arrays.sort(cArr);
    }

    public c(a aVar, ParseErrorList parseErrorList) {
        this.f34250a = aVar;
        this.f34251b = parseErrorList;
    }

    public void a(TokeniserState tokeniserState) {
        this.f34250a.a();
        this.f34252c = tokeniserState;
    }

    public String b() {
        return this.f34264o;
    }

    public final void c(String str) {
        if (this.f34251b.f()) {
            this.f34251b.add(new b(this.f34250a.F(), "Invalid character reference: %s", str));
        }
    }

    public int[] d(Character ch, boolean z10) {
        int iIntValue;
        if (this.f34250a.r()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.f34250a.q()) || this.f34250a.z(f34248r)) {
            return null;
        }
        int[] iArr = this.f34265p;
        this.f34250a.t();
        if (this.f34250a.u(Const.STR_MART_WELL)) {
            boolean zV = this.f34250a.v("X");
            a aVar = this.f34250a;
            String strG = zV ? aVar.g() : aVar.f();
            if (strG.length() == 0) {
                c("numeric reference with no numerals");
                this.f34250a.H();
                return null;
            }
            if (!this.f34250a.u(Const.STR_MART_SEMICOLON)) {
                c("missing semicolon");
            }
            try {
                iIntValue = Integer.valueOf(strG, zV ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                iIntValue = -1;
            }
            if (iIntValue == -1 || ((iIntValue >= 55296 && iIntValue <= 57343) || iIntValue > 1114111)) {
                c("character outside of valid range");
                iArr[0] = 65533;
                return iArr;
            }
            if (iIntValue >= 128) {
                int[] iArr2 = f34249s;
                if (iIntValue < iArr2.length + 128) {
                    c("character is not a valid unicode code point");
                    iIntValue = iArr2[iIntValue - 128];
                }
            }
            iArr[0] = iIntValue;
            return iArr;
        }
        String strI = this.f34250a.i();
        boolean zW = this.f34250a.w(';');
        if (!E8.c.b(strI) || !zW) {
            this.f34250a.H();
            if (zW) {
                c(String.format("invalid named referenece '%s'", strI));
            }
            return null;
        }
        if (z10 && (this.f34250a.C() || this.f34250a.A() || this.f34250a.y('=', '-', '_'))) {
            this.f34250a.H();
            return null;
        }
        if (!this.f34250a.u(Const.STR_MART_SEMICOLON)) {
            c("missing semicolon");
        }
        int iA = E8.c.a(strI, this.f34266q);
        if (iA == 1) {
            iArr[0] = this.f34266q[0];
            return iArr;
        }
        if (iA == 2) {
            return this.f34266q;
        }
        D8.b.a("Unexpected characters returned for " + strI);
        return this.f34266q;
    }

    public void e() {
        this.f34263n.a();
    }

    public void f() {
        this.f34262m.a();
    }

    public Token.h g(boolean z10) {
        Token.h hVarA = z10 ? this.f34259j.a() : this.f34260k.a();
        this.f34258i = hVarA;
        return hVarA;
    }

    public void h() {
        Token.b(this.f34257h);
    }

    public void i(char c10) {
        k(String.valueOf(c10));
    }

    public void j(Token token) {
        D8.b.c(this.f34254e, "There is an unread token pending!");
        this.f34253d = token;
        this.f34254e = true;
        Token.TokenType tokenType = token.f34220a;
        if (tokenType == Token.TokenType.StartTag) {
            this.f34264o = ((Token.g) token).f34229b;
        } else {
            if (tokenType != Token.TokenType.EndTag || ((Token.f) token).f34237j == null) {
                return;
            }
            r("Attributes incorrectly present on end tag");
        }
    }

    public void k(String str) {
        if (this.f34255f == null) {
            this.f34255f = str;
            return;
        }
        if (this.f34256g.length() == 0) {
            this.f34256g.append(this.f34255f);
        }
        this.f34256g.append(str);
    }

    public void l(int[] iArr) {
        k(new String(iArr, 0, iArr.length));
    }

    public void m() {
        j(this.f34263n);
    }

    public void n() {
        j(this.f34262m);
    }

    public void o() {
        this.f34258i.k();
        j(this.f34258i);
    }

    public void p(TokeniserState tokeniserState) {
        if (this.f34251b.f()) {
            this.f34251b.add(new b(this.f34250a.F(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    public void q(TokeniserState tokeniserState) {
        if (this.f34251b.f()) {
            this.f34251b.add(new b(this.f34250a.F(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f34250a.q()), tokeniserState));
        }
    }

    public void r(String str) {
        if (this.f34251b.f()) {
            this.f34251b.add(new b(this.f34250a.F(), str));
        }
    }

    public boolean s() {
        return this.f34264o != null && this.f34258i.m().equalsIgnoreCase(this.f34264o);
    }

    public Token t() {
        while (!this.f34254e) {
            this.f34252c.read(this, this.f34250a);
        }
        if (this.f34256g.length() > 0) {
            String string = this.f34256g.toString();
            StringBuilder sb2 = this.f34256g;
            sb2.delete(0, sb2.length());
            this.f34255f = null;
            return this.f34261l.c(string);
        }
        String str = this.f34255f;
        if (str == null) {
            this.f34254e = false;
            return this.f34253d;
        }
        Token.b bVarC = this.f34261l.c(str);
        this.f34255f = null;
        return bVarC;
    }

    public void u(TokeniserState tokeniserState) {
        this.f34252c = tokeniserState;
    }
}
