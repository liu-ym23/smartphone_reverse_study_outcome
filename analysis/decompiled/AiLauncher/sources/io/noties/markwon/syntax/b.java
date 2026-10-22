package io.noties.markwon.syntax;

import M8.c;
import com.autonavi.aps.amapapi.config.Const;
import io.noties.markwon.syntax.Prism4jThemeBase;

/* loaded from: classes4.dex */
public final class b extends Prism4jThemeBase {
    public static c g() {
        return new b();
    }

    @Override // M8.c
    public int a() {
        return -591622;
    }

    @Override // M8.c
    public int c() {
        return -16777216;
    }

    @Override // io.noties.markwon.syntax.Prism4jThemeBase
    public Prism4jThemeBase.ColorHashMap f() {
        return new Prism4jThemeBase.ColorHashMap().i(-16744448, "comment", "prolog", "doctype", "cdata").d(-16777216, "punctuation").i(-15770765, "namespace", "builtin", "class-name", "tag").h(-1938678, "property", "attr-name", "variable").i(-16748351, "constant", "symbol", "boolean", "url", "string", "char", "deleted", "attr-value").g(-16153000, Const.JSON_KEY_NUMBER, "inserted").g(-8236833, "selector", Const.LBS_FAIL_BD_ENTITY).h(-16776961, "atrule", "keyword", "important").d(-8823258, "function").d(-8315073, "regex");
    }
}
