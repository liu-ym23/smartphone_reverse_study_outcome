package P8;

import O8.f;
import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class b {

    public class a implements f.a {
        @Override // O8.f.a
        public boolean a(h.f fVar) {
            String strName = fVar.name();
            return ("class-name".equals(strName) || "boolean".equals(strName)) ? false : true;
        }
    }

    public static h.a a(O8.h hVar) {
        h.a aVarC = O8.f.c(O8.f.k(hVar, "clike"), "c", new a(), O8.h.l("keyword", O8.h.g(Pattern.compile("\\b(?:_Alignas|_Alignof|_Atomic|_Bool|_Complex|_Generic|_Imaginary|_Noreturn|_Static_assert|_Thread_local|asm|typeof|inline|auto|break|case|char|const|continue|default|do|double|else|enum|extern|float|for|goto|if|int|long|register|return|short|signed|sizeof|static|struct|switch|typedef|union|unsigned|void|volatile|while)\\b"))), O8.h.l(Parameters.OPERATOR, O8.h.g(Pattern.compile("-[>-]?|\\+\\+?|!=?|<<?=?|>>?=?|==?|&&?|\\|\\|?|[~^%?*\\/]"))), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("(?:\\b0x[\\da-f]+|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[+-]?\\d+)?)[ful]*", 2))));
        O8.f.h(aVarC, "string", O8.h.l("macro", O8.h.k(Pattern.compile("(^\\s*)#\\s*[a-z]+(?:[^\\r\\n\\\\]|\\\\(?:\\r\\n|[\\s\\S]))*", 10), true, false, "property", O8.h.c("inside", O8.h.l("string", O8.h.h(Pattern.compile("(#\\s*include\\s*)(?:<.+?>|(\"|')(?:\\\\?.)+?\\2)"), true)), O8.h.l("directive", O8.h.j(Pattern.compile("(#\\s*)\\b(?:define|defined|elif|else|endif|error|ifdef|ifndef|if|import|include|line|pragma|undef|using)\\b"), true, false, "keyword"))))), O8.h.l("constant", O8.h.g(Pattern.compile("\\b(?:__FILE__|__LINE__|__DATE__|__TIME__|__TIMESTAMP__|__func__|EOF|NULL|SEEK_CUR|SEEK_END|SEEK_SET|stdin|stdout|stderr)\\b"))));
        return aVarC;
    }
}
