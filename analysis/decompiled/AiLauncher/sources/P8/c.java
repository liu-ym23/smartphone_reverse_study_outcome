package P8;

import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public abstract class c {
    public static h.a a(O8.h hVar) {
        return O8.h.c("clike", O8.h.l("comment", O8.h.h(Pattern.compile("(^|[^\\\\])\\/\\*[\\s\\S]*?(?:\\*\\/|$)"), true), O8.h.i(Pattern.compile("(^|[^\\\\:])\\/\\/.*"), true, true)), O8.h.l("string", O8.h.i(Pattern.compile("([\"'])(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), O8.h.l("class-name", O8.h.k(Pattern.compile("((?:\\b(?:class|interface|extends|implements|trait|instanceof|new)\\s+)|(?:catch\\s+\\())[\\w.\\\\]+"), true, false, null, O8.h.c("inside", O8.h.l("punctuation", O8.h.g(Pattern.compile("[.\\\\]")))))), O8.h.l("keyword", O8.h.g(Pattern.compile("\\b(?:if|else|while|do|for|return|in|instanceof|function|new|try|throw|catch|finally|null|break|continue)\\b"))), O8.h.l("boolean", O8.h.g(Pattern.compile("\\b(?:true|false)\\b"))), O8.h.l("function", O8.h.g(Pattern.compile("[a-z0-9_]+(?=\\()", 2))), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("\\b0x[\\da-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[+-]?\\d+)?", 2))), O8.h.l(Parameters.OPERATOR, O8.h.g(Pattern.compile("--?|\\+\\+?|!=?=?|<=?|>=?|==?=?|&&?|\\|\\|?|\\?|\\*|\\/|~|\\^|%"))), O8.h.l("punctuation", O8.h.g(Pattern.compile("[{}\\[\\];(),.:]"))));
    }
}
