package androidx.compose.material3.internal;

import j9.C1615i;
import j9.l;
import j9.m;
import j9.t;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DaysInWeek", "", "MillisecondsIn24Hours", "", "datePatternAsInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "localeFormat", "", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CalendarModelKt {
    public static final int DaysInWeek = 7;
    public static final long MillisecondsIn24Hours = 86400000;

    public static final DateInputFormat datePatternAsInputFormat(String str) {
        String strZ0 = m.z0(t.c0(new Regex("y{1,4}").f(new Regex("M{1,2}").f(new Regex("d{1,2}").f(new Regex("[^dMy/\\-.]").f(str, ""), "dd"), "MM"), "yyyy"), "My", "M/y"), ".");
        l lVarB = new Regex("[/\\-.]").b(strZ0);
        k.c(lVarB);
        C1615i c1615iB = lVarB.c.b(0);
        k.c(c1615iB);
        int i = c1615iB.b.f1569a;
        String strSubstring = strZ0.substring(i, i + 1);
        k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return new DateInputFormat(strZ0, strSubstring.charAt(0));
    }
}
