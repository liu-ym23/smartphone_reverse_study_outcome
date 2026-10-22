package P8;

import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class f {
    public static h.a a(O8.h hVar) {
        h.a aVarC = O8.h.c("inside", O8.h.l("punctuation", O8.h.g(Pattern.compile("\\."))));
        h.a aVarD = O8.f.d(O8.f.k(hVar, "clike"), "csharp", O8.h.l("keyword", O8.h.g(Pattern.compile("\\b(?:abstract|add|alias|as|ascending|async|await|base|bool|break|byte|case|catch|char|checked|class|const|continue|decimal|default|delegate|descending|do|double|dynamic|else|enum|event|explicit|extern|false|finally|fixed|float|for|foreach|from|get|global|goto|group|if|implicit|in|int|interface|internal|into|is|join|let|lock|long|namespace|new|null|object|operator|orderby|out|override|params|partial|private|protected|public|readonly|ref|remove|return|sbyte|sealed|select|set|short|sizeof|stackalloc|static|string|struct|switch|this|throw|true|try|typeof|uint|ulong|unchecked|unsafe|ushort|using|value|var|virtual|void|volatile|where|while|yield)\\b"))), O8.h.l("string", O8.h.i(Pattern.compile("@(\"|')(?:\\1\\1|\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1"), false, true), O8.h.i(Pattern.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*?\\1"), false, true)), O8.h.l("class-name", O8.h.k(Pattern.compile("\\b[A-Z]\\w*(?:\\.\\w+)*\\b(?=\\s+\\w+)"), false, false, null, aVarC), O8.h.k(Pattern.compile("(\\[)[A-Z]\\w*(?:\\.\\w+)*\\b"), true, false, null, aVarC), O8.h.k(Pattern.compile("(\\b(?:class|interface)\\s+[A-Z]\\w*(?:\\.\\w+)*\\s*:\\s*)[A-Z]\\w*(?:\\.\\w+)*\\b"), true, false, null, aVarC), O8.h.k(Pattern.compile("((?:\\b(?:class|interface|new)\\s+)|(?:catch\\s+\\())[A-Z]\\w*(?:\\.\\w+)*\\b"), true, false, null, aVarC)), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("\\b0x[\\da-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)f?", 2))));
        O8.f.h(aVarD, "class-name", O8.h.l("generic-method", O8.h.k(Pattern.compile("\\w+\\s*<[^>\\r\\n]+?>\\s*(?=\\()"), false, false, null, O8.h.c("inside", O8.h.l("function", O8.h.g(Pattern.compile("^\\w+"))), O8.h.l("class-name", O8.h.k(Pattern.compile("\\b[A-Z]\\w*(?:\\.\\w+)*\\b"), false, false, null, aVarC)), O8.f.f(aVarD, "keyword"), O8.h.l("punctuation", O8.h.g(Pattern.compile("[<>(),.:]")))))), O8.h.l("preprocessor", O8.h.k(Pattern.compile("(^\\s*)#.*", 8), true, false, "property", O8.h.c("inside", O8.h.l("directive", O8.h.j(Pattern.compile("(\\s*#)\\b(?:define|elif|else|endif|endregion|error|if|line|pragma|region|undef|warning)\\b"), true, false, "keyword"))))));
        return aVarD;
    }
}
