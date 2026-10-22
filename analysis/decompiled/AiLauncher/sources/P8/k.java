package P8;

import O8.f;
import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class k {

    public class a implements f.a {
        @Override // O8.f.a
        public boolean a(h.f fVar) {
            return !"class-name".equals(fVar.name());
        }
    }

    public static h.a a(O8.h hVar) {
        h.a aVarC = O8.f.c(O8.f.k(hVar, "clike"), "go", new a(), O8.h.l("keyword", O8.h.g(Pattern.compile("\\b(?:break|case|chan|const|continue|default|defer|else|fallthrough|for|func|go(?:to)?|if|import|interface|map|package|range|return|select|struct|switch|type|var)\\b"))), O8.h.l("boolean", O8.h.g(Pattern.compile("\\b(?:_|iota|nil|true|false)\\b"))), O8.h.l(Parameters.OPERATOR, O8.h.g(Pattern.compile("[*\\/%^!=]=?|\\+[=+]?|-[=-]?|\\|[=|]?|&(?:=|&|\\^=?)?|>(?:>=?|=)?|<(?:<=?|=|-)?|:=|\\.\\.\\."))), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("(?:\\b0x[a-f\\d]+|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[-+]?\\d+)?)i?", 2))), O8.h.l("string", O8.h.i(Pattern.compile("([\"'`])(\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1"), false, true)));
        O8.f.h(aVarC, "boolean", O8.h.l("builtin", O8.h.g(Pattern.compile("\\b(?:bool|byte|complex(?:64|128)|error|float(?:32|64)|rune|string|u?int(?:8|16|32|64)?|uintptr|append|cap|close|complex|copy|delete|imag|len|make|new|panic|print(?:ln)?|real|recover)\\b"))));
        return aVarC;
    }
}
