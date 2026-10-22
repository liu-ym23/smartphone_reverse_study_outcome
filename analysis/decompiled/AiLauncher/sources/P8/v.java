package P8;

import O8.f;
import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class v {

    public class a implements f.a {
        @Override // O8.f.a
        public boolean a(h.f fVar) {
            String strName = fVar.name();
            return ("class-name".equals(strName) || "function".equals(strName)) ? false : true;
        }
    }

    public static h.a a(O8.h hVar) {
        h.a aVarC = O8.f.c(O8.f.k(hVar, "java"), "scala", new a(), O8.h.l("keyword", O8.h.g(Pattern.compile("<-|=>|\\b(?:abstract|case|catch|class|def|do|else|extends|final|finally|for|forSome|if|implicit|import|lazy|match|new|null|object|override|package|private|protected|return|sealed|self|super|this|throw|trait|try|type|val|var|while|with|yield)\\b"))), O8.h.l("string", O8.h.i(Pattern.compile("\"\"\"[\\s\\S]*?\"\"\""), false, true), O8.h.i(Pattern.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("\\b0x[\\da-f]*\\.?[\\da-f]+|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e\\d+)?[dfl]?", 2))));
        aVarC.a().add(O8.h.l("symbol", O8.h.g(Pattern.compile("'[^\\d\\s\\\\]\\w*"))));
        O8.f.h(aVarC, Const.JSON_KEY_NUMBER, O8.h.l("builtin", O8.h.g(Pattern.compile("\\b(?:String|Int|Long|Short|Byte|Boolean|Double|Float|Char|Any|AnyRef|AnyVal|Unit|Nothing)\\b"))));
        return aVarC;
    }
}
