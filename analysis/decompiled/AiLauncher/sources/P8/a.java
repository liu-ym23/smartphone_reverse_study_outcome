package P8;

import O8.h;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class a {
    public static h.a a(O8.h hVar) {
        return O8.h.c("brainfuck", O8.h.l(SystemDeleteBroadcastReceiver.PAYLOAD_MODE_POINTER, O8.h.j(Pattern.compile("<|>"), false, false, "keyword")), O8.h.l("increment", O8.h.j(Pattern.compile("\\+"), false, false, "inserted")), O8.h.l("decrement", O8.h.j(Pattern.compile(O6.l.DATE_SEPARATOR), false, false, "deleted")), O8.h.l("branching", O8.h.j(Pattern.compile("\\[|\\]"), false, false, "important")), O8.h.l(Parameters.OPERATOR, O8.h.g(Pattern.compile("[.,]"))), O8.h.l("comment", O8.h.g(Pattern.compile("\\S+"))));
    }
}
