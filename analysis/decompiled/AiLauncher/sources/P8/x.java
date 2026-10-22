package P8;

import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class x {
    public static h.a a(O8.h hVar) {
        h.a aVarD = O8.f.d(O8.f.k(hVar, "clike"), "swift", O8.h.l("string", O8.h.k(Pattern.compile("(\"|')(\\\\(?:\\((?:[^()]|\\([^)]+\\))+\\)|\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true, null, O8.h.c("inside", O8.h.l("interpolation", O8.h.k(Pattern.compile("\\\\\\((?:[^()]|\\([^)]+\\))+\\)"), false, false, null, O8.h.c("inside", O8.h.l("delimiter", O8.h.j(Pattern.compile("^\\\\\\(|\\)$"), false, false, "variable")))))))), O8.h.l("keyword", O8.h.g(Pattern.compile("\\b(?:as|associativity|break|case|catch|class|continue|convenience|default|defer|deinit|didSet|do|dynamic(?:Type)?|else|enum|extension|fallthrough|final|for|func|get|guard|if|import|in|infix|init|inout|internal|is|lazy|left|let|mutating|new|none|nonmutating|operator|optional|override|postfix|precedence|prefix|private|protocol|public|repeat|required|rethrows|return|right|safe|self|Self|set|static|struct|subscript|super|switch|throws?|try|Type|typealias|unowned|unsafe|var|weak|where|while|willSet|__(?:COLUMN__|FILE__|FUNCTION__|LINE__))\\b"))), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("\\b(?:[\\d_]+(?:\\.[\\de_]+)?|0x[a-f0-9_]+(?:\\.[a-f0-9p_]+)?|0b[01_]+|0o[0-7_]+)\\b", 2))));
        List<h.f> listA = aVarD.a();
        listA.add(O8.h.l("constant", O8.h.g(Pattern.compile("\\b(?:nil|[A-Z_]{2,}|k[A-Z][A-Za-z_]+)\\b"))));
        listA.add(O8.h.l("atrule", O8.h.g(Pattern.compile("@\\b(?:IB(?:Outlet|Designable|Action|Inspectable)|class_protocol|exported|noreturn|NS(?:Copying|Managed)|objc|UIApplicationMain|auto_closure)\\b"))));
        listA.add(O8.h.l("builtin", O8.h.g(Pattern.compile("\\b(?:[A-Z]\\S+|abs|advance|alignof(?:Value)?|assert|contains|count(?:Elements)?|debugPrint(?:ln)?|distance|drop(?:First|Last)|dump|enumerate|equal|filter|find|first|getVaList|indices|isEmpty|join|last|lexicographicalCompare|map|max(?:Element)?|min(?:Element)?|numericCast|overlaps|partition|print(?:ln)?|reduce|reflect|reverse|sizeof(?:Value)?|sort(?:ed)?|split|startsWith|stride(?:of(?:Value)?)?|suffix|swap|toDebugString|toString|transcode|underestimateCount|unsafeBitCast|with(?:ExtendedLifetime|Unsafe(?:MutablePointers?|Pointers?)|VaList))\\b"))));
        h.f fVarF = O8.f.f(aVarD, "string/interpolation");
        h.a aVarE = fVarF != null ? O8.f.e(fVarF) : null;
        if (aVarE != null) {
            aVarE.a().addAll(aVarD.a());
        }
        return aVarD;
    }
}
