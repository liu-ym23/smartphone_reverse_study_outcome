package P8;

import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class y {
    public static h.a a(O8.h hVar) {
        return O8.h.c("yaml", O8.h.l("scalar", O8.h.j(Pattern.compile("([\\-:]\\s*(?:![^\\s]+)?[ \\t]*[|>])[ \\t]*(?:((?:\\r?\\n|\\r)[ \\t]+)[^\\r\\n]+(?:\\2[^\\r\\n]+)*)"), true, false, "string")), O8.h.l("comment", O8.h.g(Pattern.compile("#.*"))), O8.h.l("key", O8.h.j(Pattern.compile("(\\s*(?:^|[:\\-,\\[{\\r\\n?])[ \\t]*(?:![^\\s]+)?[ \\t]*)[^\\r\\n{\\[\\]},#\\s]+?(?=\\s*:\\s)"), true, false, "atrule")), O8.h.l("directive", O8.h.j(Pattern.compile("(^[ \\t]*)%.+", 8), true, false, "important")), O8.h.l("datetime", O8.h.j(Pattern.compile("([:\\-,\\[{]\\s*(?:![^\\s]+)?[ \\t]*)(?:\\d{4}-\\d\\d?-\\d\\d?(?:[tT]|[ \\t]+)\\d\\d?:\\d{2}:\\d{2}(?:\\.\\d*)?[ \\t]*(?:Z|[-+]\\d\\d?(?::\\d{2})?)?|\\d{4}-\\d{2}-\\d{2}|\\d\\d?:\\d{2}(?::\\d{2}(?:\\.\\d*)?)?)(?=[ \\t]*(?:$|,|]|\\}))", 8), true, false, Const.JSON_KEY_NUMBER)), O8.h.l("boolean", O8.h.j(Pattern.compile("([:\\-,\\[{]\\s*(?:![^\\s]+)?[ \\t]*)(?:true|false)[ \\t]*(?=$|,|]|\\})", 10), true, false, "important")), O8.h.l("null", O8.h.j(Pattern.compile("([:\\-,\\[{]\\s*(?:![^\\s]+)?[ \\t]*)(?:null|~)[ \\t]*(?=$|,|]|\\})", 10), true, false, "important")), O8.h.l("string", O8.h.i(Pattern.compile("([:\\-,\\[{]\\s*(?:![^\\s]+)?[ \\t]*)(\"|')(?:(?!\\2)[^\\\\\\r\\n]|\\\\.)*\\2(?=[ \\t]*(?:$|,|]|\\}))", 8), true, true)), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.h(Pattern.compile("([:\\-,\\[{]\\s*(?:![^\\s]+)?[ \\t]*)[+-]?(?:0x[\\da-f]+|0o[0-7]+|(?:\\d+\\.?\\d*|\\.?\\d+)(?:e[+-]?\\d+)?|\\.inf|\\.nan)[ \\t]*(?=$|,|]|\\})", 10), true)), O8.h.l("tag", O8.h.g(Pattern.compile("![^\\s]+"))), O8.h.l("important", O8.h.g(Pattern.compile("[&*][\\w]+"))), O8.h.l("punctuation", O8.h.g(Pattern.compile("---|[:\\[\\]{}\\-,|>?]|\\.\\.\\."))));
    }
}
