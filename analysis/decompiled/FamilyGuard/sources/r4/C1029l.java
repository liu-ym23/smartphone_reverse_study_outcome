package r4;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* renamed from: r4.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1029l {
    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC1025h d(Matcher matcher, int i5, CharSequence charSequence) {
        if (matcher.find(i5)) {
            return new C1026i(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.ranges.h e(MatchResult matchResult) {
        return kotlin.ranges.l.j(matchResult.start(), matchResult.end());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.ranges.h f(MatchResult matchResult, int i5) {
        return kotlin.ranges.l.j(matchResult.start(i5), matchResult.end(i5));
    }
}
