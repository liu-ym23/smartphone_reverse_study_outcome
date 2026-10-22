package P8;

import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class n {
    public static h.a a(O8.h hVar) {
        h.a aVarD = O8.f.d(O8.f.k(hVar, "clike"), "javascript", O8.h.l("keyword", O8.h.g(Pattern.compile("\\b(?:as|async|await|break|case|catch|class|const|continue|debugger|default|delete|do|else|enum|export|extends|finally|for|from|function|get|if|implements|import|in|instanceof|interface|let|new|null|of|package|private|protected|public|return|set|static|super|switch|this|throw|try|typeof|var|void|while|with|yield)\\b"))), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("\\b(?:0[xX][\\dA-Fa-f]+|0[bB][01]+|0[oO][0-7]+|NaN|Infinity)\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?"))), O8.h.l("function", O8.h.g(Pattern.compile("[_$a-z\\xA0-\\uFFFF][$\\w\\xA0-\\uFFFF]*(?=\\s*\\()", 2))), O8.h.l(Parameters.OPERATOR, O8.h.g(Pattern.compile("-[-=]?|\\+[+=]?|!=?=?|<<?=?|>>?>?=?|=(?:==?|>)?|&[&=]?|\\|[|=]?|\\*\\*?=?|\\/=?|~|\\^=?|%=?|\\?|\\.{3}"))));
        O8.f.h(aVarD, "keyword", O8.h.l("regex", O8.h.i(Pattern.compile("((?:^|[^$\\w\\xA0-\\uFFFF.\"'\\])\\s])\\s*)\\/(\\[[^\\]\\r\\n]+]|\\\\.|[^/\\\\\\[\\r\\n])+\\/[gimyu]{0,5}(?=\\s*($|[\\r\\n,.;})\\]]))"), true, true)), O8.h.l("function-variable", O8.h.j(Pattern.compile("[_$a-z\\xA0-\\uFFFF][$\\w\\xA0-\\uFFFF]*(?=\\s*=\\s*(?:function\\b|(?:\\([^()]*\\)|[_$a-z\\xA0-\\uFFFF][$\\w\\xA0-\\uFFFF]*)\\s*=>))", 2), false, false, "function")), O8.h.l("constant", O8.h.g(Pattern.compile("\\b[A-Z][A-Z\\d_]*\\b"))));
        h.f fVarL = O8.h.l("interpolation", new h.c[0]);
        O8.f.h(aVarD, "string", O8.h.l("template-string", O8.h.k(Pattern.compile("`(?:\\\\[\\s\\S]|\\$\\{[^}]+\\}|[^\\\\`])*`"), false, true, null, O8.h.c("inside", fVarL, O8.h.l("string", O8.h.g(Pattern.compile("[\\s\\S]+")))))));
        ArrayList arrayList = new ArrayList(aVarD.a().size() + 1);
        arrayList.add(O8.h.l("interpolation-punctuation", O8.h.j(Pattern.compile("^\\$\\{|\\}$"), false, false, "punctuation")));
        arrayList.addAll(aVarD.a());
        fVarL.a().add(O8.h.k(Pattern.compile("\\$\\{[^}]+\\}"), false, false, null, O8.h.b("inside", arrayList)));
        h.a aVarA = hVar.a("markup");
        if (aVarA != null) {
            O8.f.h(aVarA, "tag", O8.h.l("script", O8.h.k(Pattern.compile("(<script[\\s\\S]*?>)[\\s\\S]*?(?=<\\/script>)", 2), true, true, "language-javascript", aVarD)));
        }
        return aVarD;
    }
}
