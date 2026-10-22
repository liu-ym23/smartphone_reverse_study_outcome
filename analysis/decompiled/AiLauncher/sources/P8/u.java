package P8;

import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class u {
    public static h.a a(O8.h hVar) {
        return O8.h.c("python", O8.h.l("comment", O8.h.h(Pattern.compile("(^|[^\\\\])#.*"), true)), O8.h.l("triple-quoted-string", O8.h.j(Pattern.compile("(\"\"\"|''')[\\s\\S]+?\\1"), false, true, "string")), O8.h.l("string", O8.h.i(Pattern.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), O8.h.l("function", O8.h.h(Pattern.compile("((?:^|\\s)def[ \\t]+)[a-zA-Z_]\\w*(?=\\s*\\()"), true)), O8.h.l("class-name", O8.h.h(Pattern.compile("(\\bclass\\s+)\\w+", 2), true)), O8.h.l("keyword", O8.h.g(Pattern.compile("\\b(?:as|assert|async|await|break|class|continue|def|del|elif|else|except|exec|finally|for|from|global|if|import|in|is|lambda|nonlocal|pass|print|raise|return|try|while|with|yield)\\b"))), O8.h.l("builtin", O8.h.g(Pattern.compile("\\b(?:__import__|abs|all|any|apply|ascii|basestring|bin|bool|buffer|bytearray|bytes|callable|chr|classmethod|cmp|coerce|compile|complex|delattr|dict|dir|divmod|enumerate|eval|execfile|file|filter|float|format|frozenset|getattr|globals|hasattr|hash|help|hex|id|input|int|intern|isinstance|issubclass|iter|len|list|locals|long|map|max|memoryview|min|next|object|oct|open|ord|pow|property|range|raw_input|reduce|reload|repr|reversed|round|set|setattr|slice|sorted|staticmethod|str|sum|super|tuple|type|unichr|unicode|vars|xrange|zip)\\b"))), O8.h.l("boolean", O8.h.g(Pattern.compile("\\b(?:True|False|None)\\b"))), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("(?:\\b(?=\\d)|\\B(?=\\.))(?:0[bo])?(?:(?:\\d|0x[\\da-f])[\\da-f]*\\.?\\d*|\\.\\d+)(?:e[+-]?\\d+)?j?\\b", 2))), O8.h.l(Parameters.OPERATOR, O8.h.g(Pattern.compile("[-+%=]=?|!=|\\*\\*?=?|\\/\\/?=?|<[<=>]?|>[=>]?|[&|^~]|\\b(?:or|and|not)\\b"))), O8.h.l("punctuation", O8.h.g(Pattern.compile("[{}\\[\\];(),.:]"))));
    }
}
