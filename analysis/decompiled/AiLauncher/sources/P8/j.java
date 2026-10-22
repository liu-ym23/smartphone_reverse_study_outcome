package P8;

import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class j {
    public static h.a a(O8.h hVar) {
        return O8.h.c("git", O8.h.l("comment", O8.h.g(Pattern.compile("^#.*", 8))), O8.h.l("deleted", O8.h.g(Pattern.compile("^[-–].*", 8))), O8.h.l("inserted", O8.h.g(Pattern.compile("^\\+.*", 8))), O8.h.l("string", O8.h.g(Pattern.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1", 8))), O8.h.l("command", O8.h.k(Pattern.compile("^.*\\$ git .*$", 8), false, false, null, O8.h.c("inside", O8.h.l("parameter", O8.h.g(Pattern.compile("\\s--?\\w+", 8)))))), O8.h.l(Const.JSON_KEY_COORD, O8.h.g(Pattern.compile("^@@.*@@$", 8))), O8.h.l("commit_sha1", O8.h.g(Pattern.compile("^commit \\w{40}$", 8))));
    }
}
