package P8;

import O8.h;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class i {
    public static h.a a(O8.h hVar) {
        h.a aVarD = O8.f.d(O8.f.k(hVar, "clike"), "dart", O8.h.l("string", O8.h.i(Pattern.compile("r?(\"\"\"|''')[\\s\\S]*?\\1"), false, true), O8.h.i(Pattern.compile("r?(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), O8.h.l("keyword", O8.h.g(Pattern.compile("\\b(?:async|sync|yield)\\*")), O8.h.g(Pattern.compile("\\b(?:abstract|assert|async|await|break|case|catch|class|const|continue|default|deferred|do|dynamic|else|enum|export|external|extends|factory|final|finally|for|get|if|implements|import|in|library|new|null|operator|part|rethrow|return|set|static|super|switch|this|throw|try|typedef|var|void|while|with|yield)\\b"))), O8.h.l(Parameters.OPERATOR, O8.h.g(Pattern.compile("\\bis!|\\b(?:as|is)\\b|\\+\\+|--|&&|\\|\\||<<=?|>>=?|~(?:\\/=?)?|[+\\-*\\/%&^|=!<>]=?|\\?"))));
        O8.f.h(aVarD, "function", O8.h.l("metadata", O8.h.j(Pattern.compile("@\\w+"), false, false, "symbol")));
        return aVarD;
    }
}
