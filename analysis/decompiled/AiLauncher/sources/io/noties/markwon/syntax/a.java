package io.noties.markwon.syntax;

import M8.c;
import com.autonavi.aps.amapapi.config.Const;
import io.noties.markwon.syntax.Prism4jThemeBase;

/* loaded from: classes4.dex */
public final class a extends Prism4jThemeBase {
    public static c g() {
        return new a();
    }

    @Override // M8.c
    public int a() {
        return -14803426;
    }

    @Override // M8.c
    public int c() {
        return -2829100;
    }

    @Override // io.noties.markwon.syntax.Prism4jThemeBase
    public Prism4jThemeBase.ColorHashMap f() {
        return new Prism4jThemeBase.ColorHashMap().i(-9791147, "comment", "prolog", "doctype", "cdata").d(-2829100, "punctuation").h(-11613776, "namespace", "builtin", "class-name").h(-6497026, "property", "attr-name", "variable").h(-11100970, "tag", "boolean", "url").g(-11550209, "constant", "symbol").i(-3239560, "string", "char", "deleted", "attr-value").g(-4862296, Const.JSON_KEY_NUMBER, "inserted").g(-2639235, "selector", Const.LBS_FAIL_BD_ENTITY).h(-3832128, "atrule", "keyword", "important").d(-2302806, "function").d(-3053207, "regex");
    }
}
