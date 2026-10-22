package P8;

import O8.h;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public abstract class g {
    public static h.a a(O8.h hVar) {
        h.a aVarE;
        h.a aVarC = O8.h.c("css", O8.h.l("comment", O8.h.g(Pattern.compile("\\/\\*[\\s\\S]*?\\*\\/"))), O8.h.l("atrule", O8.h.k(Pattern.compile("@[\\w-]+?.*?(?:;|(?=\\s*\\{))", 2), false, false, null, O8.h.c("inside", O8.h.l("rule", O8.h.g(Pattern.compile("@[\\w-]+")))))), O8.h.l("url", O8.h.g(Pattern.compile("url\\((?:([\"'])(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1|.*?)\\)", 2))), O8.h.l("selector", O8.h.g(Pattern.compile("[^{}\\s][^{};]*?(?=\\s*\\{)"))), O8.h.l("string", O8.h.i(Pattern.compile("(\"|')(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), O8.h.l("property", O8.h.g(Pattern.compile("[-_a-z\\xA0-\\uFFFF][-\\w\\xA0-\\uFFFF]*(?=\\s*:)", 2))), O8.h.l("important", O8.h.g(Pattern.compile("\\B!important\\b", 2))), O8.h.l("function", O8.h.g(Pattern.compile("[-a-z0-9]+(?=\\()", 2))), O8.h.l("punctuation", O8.h.g(Pattern.compile("[(){};:]"))));
        h.a aVarE2 = O8.f.e(aVarC.a().get(1));
        if (aVarE2 != null) {
            for (h.f fVar : aVarC.a()) {
                if (!"atrule".equals(fVar.name())) {
                    aVarE2.a().add(fVar);
                }
            }
        }
        h.a aVarA = hVar.a("markup");
        if (aVarA != null) {
            O8.f.h(aVarA, "tag", O8.h.l("style", O8.h.k(Pattern.compile("(<style[\\s\\S]*?>)[\\s\\S]*?(?=<\\/style>)", 2), true, true, "language-css", aVarC)));
            h.f fVarF = O8.f.f(aVarA, "tag");
            if (fVarF != null) {
                aVarE = O8.f.e(fVarF);
                if (aVarE != null) {
                    aVarE = O8.f.a(aVarE);
                }
            } else {
                aVarE = null;
            }
            O8.f.h(aVarA, "tag/attr-value", O8.h.l("style-attr", O8.h.k(Pattern.compile("\\s*style=(\"|')(?:\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1", 2), false, false, "language-css", O8.h.c("inside", O8.h.l("attr-name", O8.h.k(Pattern.compile("^\\s*style", 2), false, false, null, aVarE)), O8.h.l("punctuation", O8.h.g(Pattern.compile("^\\s*=\\s*['\"]|['\"]\\s*$"))), O8.h.l("attr-value", O8.h.k(Pattern.compile(".+", 2), false, false, null, aVarC))))));
        }
        return aVarC;
    }
}
