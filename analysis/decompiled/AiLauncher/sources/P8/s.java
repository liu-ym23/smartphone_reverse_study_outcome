package P8;

import O8.h;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class s {
    public static void a(h.a aVar, h.f fVar, h.f fVar2) {
        if (aVar != null) {
            aVar.a().add(fVar);
            aVar.a().add(fVar2);
        }
    }

    public static h.a b(O8.h hVar) {
        h.a aVarD = O8.f.d(O8.f.k(hVar, "markup"), "markdown", new h.f[0]);
        h.f fVarL = O8.h.l("bold", O8.h.k(Pattern.compile("(^|[^\\\\])(\\*\\*|__)(?:(?:\\r?\\n|\\r)(?!\\r?\\n|\\r)|.)+?\\2"), true, false, null, O8.h.c("inside", O8.h.l("punctuation", O8.h.g(Pattern.compile("^\\*\\*|^__|\\*\\*$|__$"))))));
        h.f fVarL2 = O8.h.l("italic", O8.h.k(Pattern.compile("(^|[^\\\\])([*_])(?:(?:\\r?\\n|\\r)(?!\\r?\\n|\\r)|.)+?\\2"), true, false, null, O8.h.c("inside", O8.h.l("punctuation", O8.h.g(Pattern.compile("^[*_]|[*_]$"))))));
        h.f fVarL3 = O8.h.l("url", O8.h.k(Pattern.compile("!?\\[[^\\]]+\\](?:\\([^\\s)]+(?:[\\t ]+\"(?:\\\\.|[^\"\\\\])*\")?\\)| ?\\[[^\\]\\n]*\\])"), false, false, null, O8.h.c("inside", O8.h.l("variable", O8.h.h(Pattern.compile("(!?\\[)[^\\]]+(?=\\]$)"), true)), O8.h.l("string", O8.h.g(Pattern.compile("\"(?:\\\\.|[^\"\\\\])*\"(?=\\)$)"))))));
        O8.f.h(aVarD, "prolog", O8.h.l("blockquote", O8.h.g(Pattern.compile("^>(?:[\\t ]*>)*", 8))), O8.h.l("code", O8.h.j(Pattern.compile("^(?: {4}|\\t).+", 8), false, false, "keyword"), O8.h.j(Pattern.compile("``.+?``|`[^`\\n]+`"), false, false, "keyword")), O8.h.l("title", O8.h.k(Pattern.compile("\\w+.*(?:\\r?\\n|\\r)(?:==+|--+)"), false, false, "important", O8.h.c("inside", O8.h.l("punctuation", O8.h.g(Pattern.compile("==+$|--+$"))))), O8.h.k(Pattern.compile("(^\\s*)#+.+", 8), true, false, "important", O8.h.c("inside", O8.h.l("punctuation", O8.h.g(Pattern.compile("^#+|#+$")))))), O8.h.l("hr", O8.h.j(Pattern.compile("(^\\s*)([*-])(?:[\\t ]*\\2){2,}(?=\\s*$)", 8), true, false, "punctuation")), O8.h.l("list", O8.h.j(Pattern.compile("(^\\s*)(?:[*+-]|\\d+\\.)(?=[\\t ].)", 8), true, false, "punctuation")), O8.h.l("url-reference", O8.h.k(Pattern.compile("!?\\[[^\\]]+\\]:[\\t ]+(?:\\S+|<(?:\\\\.|[^>\\\\])+>)(?:[\\t ]+(?:\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'|\\((?:\\\\.|[^)\\\\])*\\)))?"), false, false, "url", O8.h.c("inside", O8.h.l("variable", O8.h.h(Pattern.compile("^(!?\\[)[^\\]]+"), true)), O8.h.l("string", O8.h.g(Pattern.compile("(?:\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'|\\((?:\\\\.|[^)\\\\])*\\))$"))), O8.h.l("punctuation", O8.h.g(Pattern.compile("^[\\[\\]!:]|[<>]")))))), fVarL, fVarL2, fVarL3);
        a(O8.f.e(fVarL), fVarL3, fVarL2);
        a(O8.f.e(fVarL2), fVarL3, fVarL);
        return aVarD;
    }
}
