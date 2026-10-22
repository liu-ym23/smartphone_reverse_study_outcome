package P8;

import O8.h;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class e {
    public static h.a a(O8.h hVar) {
        h.a aVarD = O8.f.d(O8.f.k(hVar, "c"), "cpp", O8.h.l("keyword", O8.h.g(Pattern.compile("\\b(?:alignas|alignof|asm|auto|bool|break|case|catch|char|char16_t|char32_t|class|compl|const|constexpr|const_cast|continue|decltype|default|delete|do|double|dynamic_cast|else|enum|explicit|export|extern|float|for|friend|goto|if|inline|int|int8_t|int16_t|int32_t|int64_t|uint8_t|uint16_t|uint32_t|uint64_t|long|mutable|namespace|new|noexcept|nullptr|operator|private|protected|public|register|reinterpret_cast|return|short|signed|sizeof|static|static_assert|static_cast|struct|switch|template|this|thread_local|throw|try|typedef|typeid|typename|union|unsigned|using|virtual|void|volatile|wchar_t|while)\\b"))), O8.h.l(Parameters.OPERATOR, O8.h.g(Pattern.compile("--?|\\+\\+?|!=?|<{1,2}=?|>{1,2}=?|->|:{1,2}|={1,2}|\\^|~|%|&{1,2}|\\|\\|?|\\?|\\*|\\/|\\b(?:and|and_eq|bitand|bitor|not|not_eq|or|or_eq|xor|xor_eq)\\b"))));
        O8.f.h(aVarD, "function", O8.h.l("boolean", O8.h.g(Pattern.compile("\\b(?:true|false)\\b"))));
        O8.f.h(aVarD, "keyword", O8.h.l("class-name", O8.h.h(Pattern.compile("(class\\s+)\\w+", 2), true)));
        O8.f.h(aVarD, "string", O8.h.l("raw-string", O8.h.j(Pattern.compile("R\"([^()\\\\ ]{0,16})\\([\\s\\S]*?\\)\\1\""), false, true, "string")));
        return aVarD;
    }
}
