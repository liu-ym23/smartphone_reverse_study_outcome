package kotlin.text;

import java.util.Iterator;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f {
    public static final /* synthetic */ MatchResult a(Matcher r10, int r11, CharSequence r12) {
        return f(r10, r11, r12);
    }

    public static final /* synthetic */ MatchResult b(Matcher r10, CharSequence r11) {
        return g(r10, r11);
    }

    public static final /* synthetic */ bg.c c(java.util.regex.MatchResult r10) {
        return h(r10);
    }

    public static final /* synthetic */ bg.c d(java.util.regex.MatchResult r10, int r11) {
        return i(r10, r11);
    }

    public static final /* synthetic */ int e(Iterable r10) {
        return j(r10);
    }

    public static final MatchResult f(Matcher r10, int r11, CharSequence r12) {
        if (r10.find(r11) == true) goto L6;
        return null;
    L6:
        return new MatcherMatchResult(r10, r12);
    }

    public static final MatchResult g(Matcher r10, CharSequence r11) {
        if (r10.matches() == true) goto L6;
        return null;
    L6:
        return new MatcherMatchResult(r10, r11);
    }

    public static final bg.c h(java.util.regex.MatchResult r10) {
        return bg.h.p(r10.start(), r10.end());
    }

    public static final bg.c i(java.util.regex.MatchResult r10, int r11) {
        return bg.h.p(r10.start(r11), r10.end(r11));
    }

    public static final int j(Iterable r10) {
        Iterator r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 | ((FlagEnum) r11.next()).getValue();
        goto L4
    L6:
        return r12;
    }
}
