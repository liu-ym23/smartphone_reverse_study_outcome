package P8;

import O8.h;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class r {
    public static h.a a(O8.h hVar) {
        return O8.h.c("makefile", O8.h.l("comment", O8.h.h(Pattern.compile("(^|[^\\\\])#(?:\\\\(?:\\r\\n|[\\s\\S])|[^\\\\\\r\\n])*"), true)), O8.h.l("string", O8.h.i(Pattern.compile("([\"'])(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), O8.h.l("builtin", O8.h.g(Pattern.compile("\\.[A-Z][^:#=\\s]+(?=\\s*:(?!=))"))), O8.h.l("symbol", O8.h.k(Pattern.compile("^[^:=\\r\\n]+(?=\\s*:(?!=))", 8), false, false, null, O8.h.c("inside", O8.h.l("variable", O8.h.g(Pattern.compile("\\$+(?:[^(){}:#=\\s]+|(?=[({]))")))))), O8.h.l("variable", O8.h.g(Pattern.compile("\\$+(?:[^(){}:#=\\s]+|\\([@*%<^+?][DF]\\)|(?=[({]))"))), O8.h.l("keyword", O8.h.g(Pattern.compile("-include\\b|\\b(?:define|else|endef|endif|export|ifn?def|ifn?eq|include|override|private|sinclude|undefine|unexport|vpath)\\b")), O8.h.h(Pattern.compile("(\\()(?:addsuffix|abspath|and|basename|call|dir|error|eval|file|filter(?:-out)?|findstring|firstword|flavor|foreach|guile|if|info|join|lastword|load|notdir|or|origin|patsubst|realpath|shell|sort|strip|subst|suffix|value|warning|wildcard|word(?:s|list)?)(?=[ \\t])"), true)), O8.h.l(Parameters.OPERATOR, O8.h.g(Pattern.compile("(?:::|[?:+!])?=|[|@]"))), O8.h.l("punctuation", O8.h.g(Pattern.compile("[:;(){}]"))));
    }
}
