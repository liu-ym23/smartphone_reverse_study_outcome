package La;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u00000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0013\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"", "LLa/e;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Iterable;)I", "Ljava/util/regex/Matcher;", "from", "", "input", "LLa/m;", "f", "(Ljava/util/regex/Matcher;ILjava/lang/CharSequence;)LLa/m;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)LLa/m;", "Ljava/util/regex/MatchResult;", "Lv9/i;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/regex/MatchResult;)Lv9/i;", "groupIndex", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/regex/MatchResult;I)Lv9/i;", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class q {
    public static final m f(Matcher matcher, int i10, CharSequence charSequence) {
        if (matcher.find(i10)) {
            return new n(matcher, charSequence);
        }
        return null;
    }

    public static final m g(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new n(matcher, charSequence);
        }
        return null;
    }

    public static final C5680i h(MatchResult matchResult) {
        return C5685n.s(matchResult.start(), matchResult.end());
    }

    public static final C5680i i(MatchResult matchResult, int i10) {
        return C5685n.s(matchResult.start(i10), matchResult.end(i10));
    }

    public static final int j(Iterable<? extends InterfaceC0955e> iterable) {
        Iterator<? extends InterfaceC0955e> it = iterable.iterator();
        int value = 0;
        while (it.hasNext()) {
            value |= it.next().getValue();
        }
        return value;
    }
}
