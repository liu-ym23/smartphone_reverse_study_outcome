package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"datePatternAsInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "localeFormat", "", "DaysInWeek", "", "MillisecondsIn24Hours", "", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CalendarModelKt {
    public static final int DaysInWeek = 7;
    public static final long MillisecondsIn24Hours = 86400000;

    public static final DateInputFormat datePatternAsInputFormat(String r100) {
        String r101 = new Regex("[^dMy/\\-.]").replace(r100, "");
        String r102 = new Regex("d{1,2}").replace(r101, "dd");
        String r103 = new Regex("M{1,2}").replace(r102, "MM");
        String r104 = StringsKt.removeSuffix(StringsKt.replace$default(new Regex("y{1,4}").replace(r103, "yyyy"), "My", "M/y", false, 4, null), ".");
        MatchResult r105 = Regex.find$default(new Regex("[/\\-.]"), r104, 0, 2, null);
        Intrinsics.checkNotNull(r105);
        MatchGroup r106 = r105.getGroups().get(0);
        Intrinsics.checkNotNull(r106);
        return new DateInputFormat(r104, r106.getValue().charAt(0));
    }
}
