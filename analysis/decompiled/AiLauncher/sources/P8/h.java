package P8;

import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class h {
    public static h.a a(O8.h hVar) {
        h.a aVarA = hVar.a("css");
        if (aVarA != null) {
            h.f fVarF = O8.f.f(aVarA, "selector");
            if (fVarF != null) {
                h.c cVarK = O8.h.k(Pattern.compile("[^{}\\s][^{}]*(?=\\s*\\{)"), false, false, null, O8.h.c("inside", O8.h.l("pseudo-element", O8.h.g(Pattern.compile(":(?:after|before|first-letter|first-line|selection)|::[-\\w]+"))), O8.h.l("pseudo-class", O8.h.g(Pattern.compile(":[-\\w]+(?:\\(.*\\))?"))), O8.h.l("class", O8.h.g(Pattern.compile("\\.[-:.\\w]+"))), O8.h.l("id", O8.h.g(Pattern.compile("#[-:.\\w]+"))), O8.h.l("attribute", O8.h.g(Pattern.compile("\\[[^\\]]+\\]")))));
                fVarF.a().clear();
                fVarF.a().add(cVarK);
            }
            O8.f.h(aVarA, "function", O8.h.l("hexcode", O8.h.g(Pattern.compile("#[\\da-f]{3,8}", 2))), O8.h.l(Const.LBS_FAIL_BD_ENTITY, O8.h.g(Pattern.compile("\\\\[\\da-f]{1,8}", 2))), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("[\\d%.]+"))));
        }
        return null;
    }
}
