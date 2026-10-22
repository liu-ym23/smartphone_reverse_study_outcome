package K4;

import La.D;
import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.stepos.agentframework.uikit.code.CodeTokenKind;
import com.stepos.agentframework.uikit.code.KeyStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010!R\u0017\u0010\"\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b'\u0010%R\u0017\u0010(\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%R\u0017\u0010*\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b*\u0010#\u001a\u0004\b+\u0010%R\u0017\u0010,\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b,\u0010#\u001a\u0004\b-\u0010%R\u0017\u0010.\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b.\u0010#\u001a\u0004\b/\u0010%R\u0017\u00100\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b0\u0010#\u001a\u0004\b1\u0010%R\u0017\u00102\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b2\u0010#\u001a\u0004\b3\u0010%¨\u00064"}, d2 = {"LK4/b;", "", "<init>", "()V", "", "raw", "LK4/a;", "syntax", "", "limit", "", "LK4/c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;LK4/a;I)Ljava/util/List;", "language", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)LK4/a;", "start", "close", "openLen", "scanEnd", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;ILjava/lang/String;II)I", "f", "(Ljava/lang/String;II)I", "from", "", "ch", "", "e", "(Ljava/lang/String;IC)Z", "c", Const.INTENT_KEY_UMID, "(C)Z", "HTML", "LK4/a;", Const.INTENT_KEY_PKGNAME, "()LK4/a;", "CSS", "getCSS", JsonFactory.FORMAT_NAME_JSON, "getJSON", YAMLFactory.FORMAT_NAME_YAML, "getYAML", "JS", "getJS", "HASH", "getHASH", "DASH", "getDASH", "C_LIKE", "getC_LIKE", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class b {
    private static final a CSS;
    private static final a C_LIKE;
    private static final a DASH;
    private static final a HASH;
    private static final a JS;
    private static final a JSON;
    private static final a YAML;
    public static final b INSTANCE = new b();
    private static final a HTML = new a(null, true, true, null, KeyStyle.ATTR_EQUALS, 9, null);

    static {
        KeyStyle keyStyle = KeyStyle.COLON;
        CSS = new a(null, true, false, null, keyStyle, 13, null);
        JSON = new a(null, false, false, "\"", keyStyle, 7, null);
        YAML = new a(Const.STR_MART_WELL, false, false, null, keyStyle, 14, null);
        JS = new a("//", true, false, "\"'`", null, 20, null);
        HASH = new a(Const.STR_MART_WELL, false, false, null, null, 30, null);
        DASH = new a("--", false, false, null, null, 30, null);
        C_LIKE = new a("//", true, false, null, null, 28, null);
    }

    public final int a(String raw, int start, String close, int openLen, int scanEnd) {
        int iU0;
        int i10 = start + openLen;
        return (i10 < scanEnd && (iU0 = H.u0(raw, close, i10, false, 4, null)) >= 0 && close.length() + iU0 <= scanEnd) ? iU0 + close.length() : scanEnd;
    }

    public final a b() {
        return HTML;
    }

    public final boolean c(char c10) {
        return Character.isLetterOrDigit(c10) || c10 == '_' || c10 == '-' || c10 == '$' || c10 == '.';
    }

    public final boolean d(char c10) {
        return Character.isLetter(c10) || c10 == '_' || c10 == '-' || c10 == '$';
    }

    public final boolean e(String raw, int from, char ch) {
        while (from < raw.length() && (raw.charAt(from) == ' ' || raw.charAt(from) == '\t')) {
            from++;
        }
        return from < raw.length() && raw.charAt(from) == ch;
    }

    public final int f(String raw, int start, int scanEnd) {
        char cCharAt;
        char cCharAt2 = raw.charAt(start);
        do {
            start++;
            while (start < scanEnd) {
                cCharAt = raw.charAt(start);
                if (cCharAt == '\n') {
                    return start;
                }
                if (cCharAt == '\\') {
                    start = C5685n.j(start + 2, scanEnd);
                }
            }
            return scanEnd;
        } while (cCharAt != cCharAt2);
        return start + 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x013e, code lost:
    
        if (r0.equals(com.networknt.schema.keyword.PropertiesValidator.PROPERTY) == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0143, code lost:
    
        return K4.b.HASH;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x014a, code lost:
    
        if (r0.equals("markup") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0151, code lost:
    
        return K4.b.HTML;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        if (r0.equals("yaml") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r0.equals("toml") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        if (r0.equals("scss") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
    
        if (r0.equals("less") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
    
        if (r0.equals("json") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        return K4.b.JSON;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
    
        if (r0.equals("html") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:
    
        if (r0.equals("bash") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
    
        if (r0.equals("yml") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0082, code lost:
    
        return K4.b.YAML;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0089, code lost:
    
        if (r0.equals("xml") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0093, code lost:
    
        if (r0.equals("vue") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009d, code lost:
    
        if (r0.equals("tsx") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a7, code lost:
    
        if (r0.equals("svg") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b1, code lost:
    
        if (r0.equals("sql") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00bb, code lost:
    
        if (r0.equals("mjs") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c5, code lost:
    
        if (r0.equals("lua") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00cb, code lost:
    
        return K4.b.DASH;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d2, code lost:
    
        if (r0.equals("jsx") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00dc, code lost:
    
        if (r0.equals("htm") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e6, code lost:
    
        if (r0.equals("css") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
    
        if (r0.equals("xhtml") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ec, code lost:
    
        return K4.b.CSS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f3, code lost:
    
        if (r0.equals("cjs") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00fc, code lost:
    
        if (r0.equals("ts") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0105, code lost:
    
        if (r0.equals("sh") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x010e, code lost:
    
        if (r0.equals("rb") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0117, code lost:
    
        if (r0.equals("py") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0120, code lost:
    
        if (r0.equals("js") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0125, code lost:
    
        return K4.b.JS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x012c, code lost:
    
        if (r0.equals("r") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0135, code lost:
    
        if (r0.equals("svelte") == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (r0.equals("json5") == false) goto L106;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final K4.a g(java.lang.String r1) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K4.b.g(java.lang.String):K4.a");
    }

    public final List<CodeToken> h(String raw, a syntax, int limit) {
        int i10;
        int iF;
        p.i(raw, "raw");
        p.i(syntax, "syntax");
        ArrayList arrayList = new ArrayList();
        int iN = C5685n.n(limit, 0, raw.length());
        int i11 = 0;
        boolean z10 = false;
        while (i11 < iN) {
            char cCharAt = raw.charAt(i11);
            if (syntax.getHtmlComment() && D.W(raw, "<!--", i11, false, 4, null)) {
                int iA = a(raw, i11, "-->", 4, iN);
                arrayList.add(new CodeToken(i11, iA, CodeTokenKind.COMMENT));
                i11 = iA;
            } else {
                if (syntax.getBlockComment() && D.W(raw, "/*", i11, false, 4, null)) {
                    int i12 = iN;
                    int iA2 = a(raw, i11, "*/", 2, i12);
                    i10 = i12;
                    arrayList.add(new CodeToken(i11, iA2, CodeTokenKind.COMMENT));
                    i11 = iA2;
                } else {
                    i10 = iN;
                    if (syntax.getLineComment() == null || !D.W(raw, syntax.getLineComment(), i11, false, 4, null)) {
                        if (H.f0(syntax.getQuotes(), cCharAt, false, 2, null)) {
                            iF = f(raw, i11, i10);
                            arrayList.add(new CodeToken(i11, iF, syntax.getKeyStyle() == KeyStyle.COLON && e(raw, iF, ':') ? CodeTokenKind.KEY : CodeTokenKind.STRING));
                        } else {
                            KeyStyle keyStyle = syntax.getKeyStyle();
                            KeyStyle keyStyle2 = KeyStyle.ATTR_EQUALS;
                            if (keyStyle == keyStyle2 && cCharAt == '<') {
                                i11++;
                                z10 = true;
                            } else if (syntax.getKeyStyle() == keyStyle2 && cCharAt == '>') {
                                i11++;
                                z10 = false;
                            } else if (d(cCharAt) && syntax.a(z10)) {
                                iF = i11;
                                while (iF < i10 && c(raw.charAt(iF))) {
                                    iF++;
                                }
                                if (e(raw, iF, syntax.getKeyStyle() != KeyStyle.COLON ? '=' : ':')) {
                                    arrayList.add(new CodeToken(i11, iF, CodeTokenKind.KEY));
                                }
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        int iT0 = H.t0(raw, '\n', i11, false, 4, null);
                        if (iT0 < 0) {
                            iT0 = raw.length();
                        }
                        iF = Math.min(iT0, i10);
                        arrayList.add(new CodeToken(i11, iF, CodeTokenKind.COMMENT));
                    }
                    i11 = iF;
                }
                iN = i10;
            }
        }
        return arrayList;
    }
}
