package C8;

import C8.f;
import C8.g;
import C8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import io.noties.markwon.html.jsoup.parser.ParseErrorList;
import io.noties.markwon.html.jsoup.parser.Token;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class i extends h {

    /* renamed from: g, reason: collision with root package name */
    public static final Set<String> f1749g = Collections.unmodifiableSet(new HashSet(Arrays.asList(Const.INTENT_KEY_APIKEY, "abbr", "acronym", Const.INTENT_KEY_PKGNAME, "bdo", "big", "br", "button", "cite", "code", "dfn", "em", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "img", "input", "kbd", "label", C3081a.FOCUS_MAP_NAME, "object", "q", "samp", "script", M5.c.ACTION_SELECT, "small", "span", "strong", "sub", "sup", "textarea", "time", "tt", "var")));

    /* renamed from: h, reason: collision with root package name */
    public static final Set<String> f1750h = Collections.unmodifiableSet(new HashSet(Arrays.asList("area", "base", "br", "col", "embed", "hr", "img", "input", "keygen", "link", "meta", "param", "source", "track", "wbr")));

    /* renamed from: i, reason: collision with root package name */
    public static final Set<String> f1751i = Collections.unmodifiableSet(new HashSet(Arrays.asList(Const.JSON_KEY_ADDRESS, "article", "aside", "blockquote", "canvas", "dd", "div", "dl", "dt", "fieldset", "figcaption", "figure", "footer", "form", "h1", "h2", "h3", "h4", "h5", "h6", "header", "hgroup", "hr", "li", "main", "nav", "noscript", Const.SP_KEY_ONCE_LOCATION, "output", "p", "pre", "section", "table", "tfoot", "ul", "video")));

    /* renamed from: a, reason: collision with root package name */
    public final d f1752a;

    /* renamed from: b, reason: collision with root package name */
    public final n f1753b;

    /* renamed from: c, reason: collision with root package name */
    public final List<g.b> f1754c = new ArrayList(0);

    /* renamed from: d, reason: collision with root package name */
    public g.a f1755d = g.a.h();

    /* renamed from: e, reason: collision with root package name */
    public boolean f1756e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1757f;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1758a;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            f1758a = iArr;
            try {
                iArr[Token.TokenType.StartTag.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1758a[Token.TokenType.EndTag.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1758a[Token.TokenType.Character.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public i(d dVar, n nVar) {
        this.f1752a = dVar;
        this.f1753b = nVar;
    }

    public static i g() {
        return h(d.a());
    }

    public static i h(d dVar) {
        return new i(dVar, n.b());
    }

    public static <T extends Appendable & CharSequence> void i(T t10) throws IOException {
        T t11 = t10;
        int length = t11.length();
        if (length <= 0 || '\n' == t11.charAt(length - 1)) {
            return;
        }
        C8.a.a(t10, '\n');
    }

    public static Map<String, String> k(Token.g gVar) {
        E8.b bVar = gVar.f34237j;
        int size = bVar.size();
        if (size <= 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap(size);
        Iterator<E8.a> it = bVar.iterator();
        while (it.hasNext()) {
            E8.a next = it.next();
            map.put(next.getKey().toLowerCase(Locale.US), next.getValue());
        }
        return Collections.unmodifiableMap(map);
    }

    public static boolean n(String str) {
        return f1751i.contains(str);
    }

    public static <T extends Appendable & CharSequence> boolean o(T t10, g gVar) {
        return gVar.f1744b == t10.length();
    }

    public static boolean p(String str) {
        return f1749g.contains(str);
    }

    public static boolean q(String str) {
        return f1750h.contains(str);
    }

    @Override // C8.h
    public void a(int i10, h.a<f.a> aVar) {
        g.a aVar2 = this.f1755d;
        while (true) {
            g.a aVar3 = aVar2.f1747e;
            if (aVar3 == null) {
                break;
            } else {
                aVar2 = aVar3;
            }
        }
        if (i10 > -1) {
            aVar2.f(i10);
        }
        List<f.a> listB = aVar2.b();
        if (listB.size() > 0) {
            aVar.a(listB);
        } else {
            aVar.a(Collections.EMPTY_LIST);
        }
        this.f1755d = g.a.h();
    }

    @Override // C8.h
    public void b(int i10, h.a<f.b> aVar) {
        if (this.f1754c.size() <= 0) {
            aVar.a(Collections.EMPTY_LIST);
            return;
        }
        if (i10 > -1) {
            Iterator<g.b> it = this.f1754c.iterator();
            while (it.hasNext()) {
                it.next().f(i10);
            }
        }
        aVar.a(Collections.unmodifiableList(this.f1754c));
        this.f1754c.clear();
    }

    @Override // C8.h
    public <T extends Appendable & CharSequence> void c(T t10, String str) throws IOException {
        io.noties.markwon.html.jsoup.parser.c cVar = new io.noties.markwon.html.jsoup.parser.c(new io.noties.markwon.html.jsoup.parser.a(str), ParseErrorList.i());
        while (true) {
            Token tokenT = cVar.t();
            Token.TokenType tokenType = tokenT.f34220a;
            if (Token.TokenType.EOF == tokenType) {
                return;
            }
            int i10 = a.f1758a[tokenType.ordinal()];
            if (i10 == 1) {
                Token.g gVar = (Token.g) tokenT;
                if (p(gVar.f34230c)) {
                    v(t10, gVar);
                } else {
                    s(t10, gVar);
                }
            } else if (i10 == 2) {
                Token.f fVar = (Token.f) tokenT;
                if (p(fVar.f34230c)) {
                    u(t10, fVar);
                } else {
                    r(t10, fVar);
                }
            } else if (i10 == 3) {
                t(t10, (Token.b) tokenT);
            }
            tokenT.a();
        }
    }

    @Override // C8.h
    public void d() {
        this.f1754c.clear();
        this.f1755d = g.a.h();
    }

    public void e(g.a aVar, g.a aVar2) {
        List arrayList = aVar.f1748f;
        if (arrayList == null) {
            arrayList = new ArrayList(2);
            aVar.f1748f = arrayList;
        }
        arrayList.add(aVar2);
    }

    public <T extends Appendable & CharSequence> void f(T t10, g gVar) throws IOException {
        String strB = this.f1752a.b(gVar);
        if (strB != null) {
            C8.a.b(t10, strB);
        }
    }

    public <T extends Appendable & CharSequence> void j(T t10) throws IOException {
        if (this.f1757f) {
            i(t10);
            this.f1757f = false;
        }
    }

    public g.a l(String str) {
        g.a aVar = this.f1755d;
        while (aVar != null && !str.equals(aVar.f1743a) && !aVar.isClosed()) {
            aVar = aVar.f1747e;
        }
        return aVar;
    }

    public g.b m(String str) {
        int size = this.f1754c.size();
        while (true) {
            size--;
            if (size <= -1) {
                return null;
            }
            g.b bVar = this.f1754c.get(size);
            if (str.equals(bVar.f1743a) && bVar.f1746d < 0) {
                return bVar;
            }
        }
    }

    public <T extends Appendable & CharSequence> void r(T t10, Token.f fVar) throws IOException {
        String str = fVar.f34230c;
        g.a aVarL = l(str);
        if (aVarL != null) {
            if ("pre".equals(str)) {
                this.f1756e = false;
            }
            if (o(t10, aVarL)) {
                f(t10, aVarL);
            }
            aVarL.f(t10.length());
            if (!aVarL.isEmpty()) {
                this.f1757f = n(aVarL.f1743a);
            }
            if ("p".equals(str)) {
                C8.a.a(t10, '\n');
            }
            this.f1755d = aVarL.f1747e;
        }
    }

    public <T extends Appendable & CharSequence> void s(T t10, Token.g gVar) throws IOException {
        String str = gVar.f34230c;
        if ("p".equals(this.f1755d.f1743a)) {
            this.f1755d.f(t10.length());
            C8.a.a(t10, '\n');
            this.f1755d = this.f1755d.f1747e;
        } else if ("li".equals(str) && "li".equals(this.f1755d.f1743a)) {
            this.f1755d.f(t10.length());
            this.f1755d = this.f1755d.f1747e;
        }
        if (n(str)) {
            this.f1756e = "pre".equals(str);
            i(t10);
        } else {
            j(t10);
        }
        T t11 = t10;
        g.a aVarG = g.a.g(str, t11.length(), k(gVar), this.f1755d);
        boolean z10 = q(str) || gVar.f34236i;
        if (z10) {
            String strB = this.f1752a.b(aVarG);
            if (strB != null && strB.length() > 0) {
                C8.a.b(t10, strB);
            }
            aVarG.f(t11.length());
        }
        e(aVarG.f1747e, aVarG);
        if (z10) {
            return;
        }
        this.f1755d = aVarG;
    }

    public <T extends Appendable & CharSequence> void t(T t10, Token.b bVar) throws IOException {
        if (this.f1756e) {
            C8.a.b(t10, bVar.d());
        } else {
            j(t10);
            this.f1753b.a(t10, bVar.d());
        }
    }

    public <T extends Appendable & CharSequence> void u(T t10, Token.f fVar) throws IOException {
        g.b bVarM = m(fVar.f34230c);
        if (bVarM != null) {
            if (o(t10, bVarM)) {
                f(t10, bVarM);
            }
            bVarM.f(t10.length());
        }
    }

    public <T extends Appendable & CharSequence> void v(T t10, Token.g gVar) throws IOException {
        String str = gVar.f34230c;
        T t11 = t10;
        g.b bVar = new g.b(str, t11.length(), k(gVar));
        j(t10);
        if (q(str) || gVar.f34236i) {
            String strB = this.f1752a.b(bVar);
            if (strB != null && strB.length() > 0) {
                C8.a.b(t10, strB);
            }
            bVar.f(t11.length());
        }
        this.f1754c.add(bVar);
    }
}
