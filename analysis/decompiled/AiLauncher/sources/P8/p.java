package P8;

import O8.f;
import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class p {

    public class a implements f.a {
        @Override // O8.f.a
        public boolean a(h.f fVar) {
            return !"class-name".equals(fVar.name());
        }
    }

    public static h.a a(O8.h hVar) {
        h.a aVarC = O8.f.c(O8.f.k(hVar, "clike"), "kotlin", new a(), O8.h.l("keyword", O8.h.h(Pattern.compile("(^|[^.])\\b(?:abstract|actual|annotation|as|break|by|catch|class|companion|const|constructor|continue|crossinline|data|do|dynamic|else|enum|expect|external|final|finally|for|fun|get|if|import|in|infix|init|inline|inner|interface|internal|is|lateinit|noinline|null|object|open|operator|out|override|package|private|protected|public|reified|return|sealed|set|super|suspend|tailrec|this|throw|to|try|typealias|val|var|vararg|when|where|while)\\b"), true)), O8.h.l("function", O8.h.g(Pattern.compile("\\w+(?=\\s*\\()")), O8.h.h(Pattern.compile("(\\.)\\w+(?=\\s*\\{)"), true)), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("\\b(?:0[xX][\\da-fA-F]+(?:_[\\da-fA-F]+)*|0[bB][01]+(?:_[01]+)*|\\d+(?:_\\d+)*(?:\\.\\d+(?:_\\d+)*)?(?:[eE][+-]?\\d+(?:_\\d+)*)?[fFL]?)\\b"))), O8.h.l(Parameters.OPERATOR, O8.h.g(Pattern.compile("\\+[+=]?|-[-=>]?|==?=?|!(?:!|==?)?|[\\/*%<>]=?|[?:]:?|\\.\\.|&&|\\|\\||\\b(?:and|inv|or|shl|shr|ushr|xor)\\b"))));
        O8.f.h(aVarC, "string", O8.h.l("raw-string", O8.h.j(Pattern.compile("(\"\"\"|''')[\\s\\S]*?\\1"), false, false, "string")));
        O8.f.h(aVarC, "keyword", O8.h.l("annotation", O8.h.j(Pattern.compile("\\B@(?:\\w+:)?(?:[A-Z]\\w*|\\[[^\\]]+\\])"), false, false, "builtin")));
        O8.f.h(aVarC, "function", O8.h.l("label", O8.h.j(Pattern.compile("\\w+@|@\\w+"), false, false, "symbol")));
        ArrayList arrayList = new ArrayList(aVarC.a().size() + 1);
        arrayList.add(O8.h.l("delimiter", O8.h.j(Pattern.compile("^\\$\\{|\\}$"), false, false, "variable")));
        arrayList.addAll(aVarC.a());
        h.a aVarC2 = O8.h.c("inside", O8.h.l("interpolation", O8.h.k(Pattern.compile("\\$\\{[^}]+\\}"), false, false, null, O8.h.b("inside", arrayList)), O8.h.j(Pattern.compile("\\$\\w+"), false, false, "variable")));
        h.f fVarF = O8.f.f(aVarC, "string");
        h.f fVarF2 = O8.f.f(aVarC, "raw-string");
        if (fVarF == null || fVarF2 == null) {
            throw new RuntimeException("Unexpected state, cannot find `string` and/or `raw-string` tokens inside kotlin grammar");
        }
        h.c cVar = fVarF.a().get(0);
        h.c cVar2 = fVarF2.a().get(0);
        fVarF.a().add(O8.h.k(cVar.e(), cVar.f(), cVar.c(), cVar.a(), aVarC2));
        fVarF2.a().add(O8.h.k(cVar2.e(), cVar2.f(), cVar2.c(), cVar2.a(), aVarC2));
        fVarF.a().remove(0);
        fVarF2.a().remove(0);
        return aVarC;
    }
}
