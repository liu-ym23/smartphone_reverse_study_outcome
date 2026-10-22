package P8;

import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class l {
    public static h.a a(O8.h hVar) {
        h.a aVarD = O8.f.d(O8.f.k(hVar, "clike"), "groovy", O8.h.l("keyword", O8.h.g(Pattern.compile("\\b(?:as|def|in|abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|trait|transient|try|void|volatile|while)\\b"))), O8.h.l("string", O8.h.i(Pattern.compile("(\"\"\"|''')[\\s\\S]*?\\1|(?:\\$\\/)(?:\\$\\/\\$|[\\s\\S])*?\\/\\$"), false, true), O8.h.i(Pattern.compile("([\"'\\/])(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("\\b(?:0b[01_]+|0x[\\da-f_]+(?:\\.[\\da-f_p\\-]+)?|[\\d_]+(?:\\.[\\d_]+)?(?:e[+-]?[\\d]+)?)[glidf]?\\b", 2))), O8.h.l(Parameters.OPERATOR, O8.h.h(Pattern.compile("(^|[^.])(?:~|==?~?|\\?[.:]?|\\*(?:[.=]|\\*=?)?|\\.[@&]|\\.\\.<|\\.{1,2}(?!\\.)|-[-=>]?|\\+[+=]?|!=?|<(?:<=?|=>?)?|>(?:>>?=?|=)?|&[&=]?|\\|[|=]?|\\/=?|\\^=?|%=?)"), true)), O8.h.l("punctuation", O8.h.g(Pattern.compile("\\.+|[{}\\[\\];(),:$]"))));
        O8.f.h(aVarD, "string", O8.h.l("shebang", O8.h.j(Pattern.compile("#!.+"), false, false, "comment")));
        O8.f.h(aVarD, "punctuation", O8.h.l("spock-block", O8.h.g(Pattern.compile("\\b(?:setup|given|when|then|and|cleanup|expect|where):"))));
        O8.f.h(aVarD, "function", O8.h.l("annotation", O8.h.j(Pattern.compile("(^|[^.])@\\w+"), true, false, "punctuation")));
        return aVarD;
    }
}
