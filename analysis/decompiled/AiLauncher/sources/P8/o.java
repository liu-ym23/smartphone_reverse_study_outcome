package P8;

import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.sse.ServerSentEventKt;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class o {
    public static h.a a(O8.h hVar) {
        return O8.h.c("json", O8.h.l("property", O8.h.g(Pattern.compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\"(?=\\s*:)", 2))), O8.h.l("string", O8.h.i(Pattern.compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\"(?!\\s*:)"), false, true)), O8.h.l(Const.JSON_KEY_NUMBER, O8.h.g(Pattern.compile("\\b0x[\\dA-Fa-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?"))), O8.h.l("punctuation", O8.h.g(Pattern.compile("[{}\\[\\]);,]"))), O8.h.l(Parameters.OPERATOR, O8.h.g(Pattern.compile(ServerSentEventKt.COLON))), O8.h.l("boolean", O8.h.g(Pattern.compile("\\b(?:true|false)\\b", 2))), O8.h.l("null", O8.h.g(Pattern.compile("\\bnull\\b", 2))));
    }
}
