package c03;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21907a = 0;

    static {
    }

    public static int a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "str");
        Intrinsics.checkNotNullParameter(r101, "pattern");
        MatchResult r102 = Regex.find$default(new Regex(r101), r100, 0, 2, null);
        if (r102 == null) goto L7;
        IntRange r103 = r102.getRange();
        if (r103 == null) goto L7;
        return r103.getStart().intValue();
    L7:
        return -1;
    }
}
