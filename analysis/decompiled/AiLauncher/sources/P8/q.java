package P8;

import O8.h;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class q {
    public static h.a a(O8.h hVar) {
        Pattern patternCompile = Pattern.compile("\\\\(?:[^a-z()\\[\\]]|[a-z*]+)", 2);
        h.a aVarC = O8.h.c("inside", O8.h.l("equation-command", O8.h.j(patternCompile, false, false, "regex")));
        return O8.h.c("latex", O8.h.l("comment", O8.h.g(Pattern.compile("%.*", 8))), O8.h.l("cdata", O8.h.h(Pattern.compile("(\\\\begin\\{((?:verbatim|lstlisting)\\*?)\\})[\\s\\S]*?(?=\\\\end\\{\\2\\})"), true)), O8.h.l("equation", O8.h.k(Pattern.compile("\\$(?:\\\\[\\s\\S]|[^\\\\$])*\\$|\\\\\\([\\s\\S]*?\\\\\\)|\\\\\\[[\\s\\S]*?\\\\\\]"), false, false, "string", aVarC), O8.h.k(Pattern.compile("(\\\\begin\\{((?:equation|math|eqnarray|align|multline|gather)\\*?)\\})[\\s\\S]*?(?=\\\\end\\{\\2\\})"), true, false, "string", aVarC)), O8.h.l("keyword", O8.h.h(Pattern.compile("(\\\\(?:begin|end|ref|cite|label|usepackage|documentclass)(?:\\[[^\\]]+\\])?\\{)[^}]+(?=\\})"), true)), O8.h.l("url", O8.h.h(Pattern.compile("(\\\\url\\{)[^}]+(?=\\})"), true)), O8.h.l("headline", O8.h.j(Pattern.compile("(\\\\(?:part|chapter|section|subsection|frametitle|subsubsection|paragraph|subparagraph|subsubparagraph|subsubsubparagraph)\\*?(?:\\[[^\\]]+\\])?\\{)[^}]+(?=\\}(?:\\[[^\\]]+\\])?)"), true, false, "class-name")), O8.h.l("function", O8.h.j(patternCompile, false, false, "selector")), O8.h.l("punctuation", O8.h.g(Pattern.compile("[\\[\\]{}&]"))));
    }
}
