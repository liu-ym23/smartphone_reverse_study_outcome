package P8;

import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class m {
    public static h.a a(O8.h hVar) {
        h.f fVarL = O8.h.l("keyword", O8.h.g(Pattern.compile("\\b(?:abstract|continue|for|new|switch|assert|default|goto|package|synchronized|boolean|do|if|private|this|break|double|implements|protected|throw|byte|else|import|public|throws|case|enum|instanceof|return|transient|catch|extends|int|short|try|char|final|interface|static|void|class|finally|long|strictfp|volatile|const|float|native|super|while)\\b")));
        h.a aVarD = O8.f.d(O8.f.k(hVar, "clike"), "java", fVarL, O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("\\b0b[01]+\\b|\\b0x[\\da-f]*\\.?[\\da-fp-]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[+-]?\\d+)?[df]?", 2))), O8.h.l(Parameters.OPERATOR, O8.h.h(Pattern.compile("(^|[^.])(?:\\+[+=]?|-[-=]?|!=?|<<?=?|>>?>?=?|==?|&[&=]?|\\|[|=]?|\\*=?|\\/=?|%=?|\\^=?|[?:~])", 8), true)));
        O8.f.h(aVarD, "function", O8.h.l("annotation", O8.h.j(Pattern.compile("(^|[^.])@\\w+"), true, false, "punctuation")));
        O8.f.h(aVarD, "class-name", O8.h.l("generics", O8.h.k(Pattern.compile("<\\s*\\w+(?:\\.\\w+)?(?:\\s*,\\s*\\w+(?:\\.\\w+)?)*>", 2), false, false, "function", O8.h.c("inside", fVarL, O8.h.l("punctuation", O8.h.g(Pattern.compile("[<>(),.:]")))))));
        return aVarD;
    }
}
