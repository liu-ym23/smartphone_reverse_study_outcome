package com.obric.oui.time;

import com.android.common.speech.LoggingEvents;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeFormat.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/time/TimeFormat;", "", "()V", "localizationCN", "Lcom/obric/oui/time/RelativeTimeLocalization;", "localizationHK", "localizationTW", "localizationUK", "localizationUS", "preDefinePatterns", "", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "Lcom/obric/oui/time/TimePattern;", "timePatternCN", "timePatternTW", "timePatternUK", "timePatternUS", "getBasePattern", LoggingEvents.VoiceIme.EXTRA_START_LOCALE, "getBasePattern$OUI_standardRelease", "getLocalization", "getLocalization$OUI_standardRelease", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TimeFormat {
    public static final TimeFormat INSTANCE = null;
    private static final RelativeTimeLocalization localizationCN = null;
    private static final RelativeTimeLocalization localizationHK = null;
    private static final RelativeTimeLocalization localizationTW = null;
    private static final RelativeTimeLocalization localizationUK = null;
    private static final RelativeTimeLocalization localizationUS = null;
    private static final Map<Locale, TimePattern> preDefinePatterns = null;
    private static final TimePattern timePatternCN = null;
    private static final TimePattern timePatternTW = null;
    private static final TimePattern timePatternUK = null;
    private static final TimePattern timePatternUS = null;

    private TimeFormat() {
    }

    static {
        INSTANCE = new TimeFormat();
        Locale r2 = Locale.CHINA;
        Intrinsics.checkNotNullExpressionValue(r2, "CHINA");
        TimePattern r0 = new TimePattern(r2, new Pair("yyyy年M月d日 H:mm:ss.SSS", "yyyy年M月d日 a h:mm:ss.SSS"), new Pair("yyyy年", "yyyy年"), new Pair("yyyy年M月", "yyyy年M月"), new Pair("yyyy年M月d日", "yyyy年M月d日"), new Pair("M月d日", "M月d日"), new Pair("yyyy年M月d日 H:mm", "yyyy年M月d日 a h:mm"), new Pair("yyyy年M月d日 EEEE H:mm", "yyyy年M月d日 EEEE a h:mm"), new Pair("H:mm", "a h:mm"), new Pair("M/d", "M/d"), new Pair("yyyy/M/d H:mm", "yyyy/M/d a h:mm"));
        timePatternCN = r0;
        Locale r3 = Locale.UK;
        Intrinsics.checkNotNullExpressionValue(r3, "UK");
        TimePattern r1 = new TimePattern(r3, new Pair("d MMMM yyyy H:mm:ss.SSS", "d MMMM yyyy h:mm:ss.SSS a"), new Pair("yyyy", "yyyy"), new Pair("MMMM yyyy", "MMMM yyyy"), new Pair("d MMMM yyyy", "d MMMM yyyy"), new Pair("d MMMM", "d MMMM"), new Pair("d MMMM yyyy H:mm", "d MMMM yyyy h:mm a"), new Pair("d MMMM yyyy EEEE H:mm", "d MMMM yyyy EEEE h:mm a"), new Pair("H:mm", "h:mm a"), new Pair("d/M", "d/M"), new Pair("d/M/yyyy H:mm", "d/M/yyyy h:mm a"));
        timePatternUK = r1;
        Locale r4 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r4, "US");
        TimePattern r5 = new TimePattern(r4, new Pair("MMMM d, yyyy H:mm:ss.SSS", "MMMM d, yyyy h:mm:ss.SSS a"), new Pair("yyyy", "yyyy"), new Pair("MMMM yyyy", "MMMM yyyy"), new Pair("MMMM d, yyyy", "MMMM d, yyyy"), new Pair("MMMM d", "MMMM d"), new Pair("MMMM d, yyyy H:mm", "MMMM d, yyyy h:mm a"), new Pair("MMMM d, yyyy EEEE H:mm", "MMMM d, yyyy EEEE h:mm a"), new Pair("H:mm", "h:mm a"), new Pair("M/d", "M/d"), new Pair("M/d/yyyy H:mm", "M/d/yyyy h:mm a"));
        timePatternUS = r5;
        Locale r6 = Locale.TRADITIONAL_CHINESE;
        Intrinsics.checkNotNullExpressionValue(r6, "TRADITIONAL_CHINESE");
        TimePattern r7 = new TimePattern(r6, new Pair("yyyy年M月d日 H:mm:ss.SSS", "yyyy年M月d日 a h:mm:ss.SSS"), new Pair("yyyy年", "yyyy年"), new Pair("yyyy年M月", "yyyy年M月"), new Pair("yyyy年M月d日", "yyyy年M月d日"), new Pair("M月d日", "M月d日"), new Pair("yyyy年M月d日 H:mm", "yyyy年M月d日 a h:mm"), new Pair("yyyy年M月d日 EEEE H:mm", "yyyy年M月d日 EEEE a h:mm"), new Pair("H:mm", "a h:mm"), new Pair("M/d", "M/d"), new Pair("yyyy/M/d H:mm", "yyyy/M/d a h:mm"));
        timePatternTW = r7;
        preDefinePatterns = MapsKt.mapOf(new Pair[]{TuplesKt.to(Locale.CHINA, r0), TuplesKt.to(Locale.TRADITIONAL_CHINESE, r7), TuplesKt.to(Locale.UK, r1), TuplesKt.to(Locale.US, r5)});
        localizationCN = new RelativeTimeLocalization("刚刚", new Pair("H:mm", "a h:mm"), "今天", "昨天", "明天", "前天", "后天", "EEEE", "M月d日", "yyyy年M月d日", "yyyy/M/d", "%d 秒前", "%d 秒后", "%d 分钟前", "%d 分钟后", "%d 小时前", "%d 小时后", "%d 天前", "%d 天后", "%d 个月前", "%d 个月后", "%d 年前", "%d 年后");
        localizationUS = new RelativeTimeLocalization("Just now", new Pair("H:mm", "h:mm a"), "today", "Yesterday", "Tomorrow", "Before yesterday", "After tomorrow", "EEEE", "MMMM d", "MMMM d, yyyy", "M/d/yyyy", "%d seconds ago", "%d seconds from now", "%d minutes ago", "%d minutes from now", "%d hours ago", "%d hours from now", "%d days ago", "%d days from now", "%d months ago", "%d months from now", "%d years ago", "%d years from now");
        localizationUK = new RelativeTimeLocalization("Just now", new Pair("H:mm", "h:mm a"), "today", "Yesterday", "Tomorrow", "Before yesterday", "After tomorrow", "EEEE", "d MMMM", "d MMMM, yyyy", "d/M/yyyy", "%d seconds ago", "%d seconds from now", "%d minutes ago", "%d minutes from now", "%d hours ago", "%d hours from now", "%d days ago", "%d days from now", "%d months ago", "%d months from now", "%d years ago", "%d years from now");
        localizationTW = new RelativeTimeLocalization("剛剛", new Pair("H:mm", "a h:mm"), "今天", "昨天", "明天", "前天", "後天", "EEEE", "M月d日", "yyyy年M月d日", "yyyy/M/d", "%d 秒前", "%d 秒後", "%d 分鐘前", "%d 分鐘後", "%d 小時前", "%d 小時後", "%d 天前", "%d 天後", "%d 個月前", "%d 個月後", "%d 年前", "%d 年後");
        localizationHK = new RelativeTimeLocalization("剛剛", new Pair("H:mm", "a h:mm"), "今日", "昨日", "明日", "前日", "後日", "EEEE", "M月d日", "yyyy年M月d日", "yyyy/M/d", "%d 秒前", "%d 秒後", "%d 分鐘前", "%d 分鐘後", "%d 小時前", "%d 小時後", "%d 日前", "%d 日後", "%d 個月前", "%d 個月後", "%d 年前", "%d 年後");
    }

    public final TimePattern getBasePattern$OUI_standardRelease(Locale r1) {
        Intrinsics.checkNotNullParameter(r1, LoggingEvents.VoiceIme.EXTRA_START_LOCALE);
        if (Intrinsics.areEqual(r1, Locale.CHINA) == false) goto L6;
        return timePatternCN;
    L6:
        if (Intrinsics.areEqual(r1, Locale.TAIWAN) == false) goto L9;
        return timePatternTW;
    L9:
        if (Intrinsics.areEqual(r1, Locale.UK) == false) goto L12;
        return timePatternUK;
    L12:
        if (Intrinsics.areEqual(r1, Locale.US) == false) goto L15;
        return timePatternUS;
    L15:
        if (Intrinsics.areEqual(r1.getCountry(), "HK") == false) goto L18;
        return timePatternTW;
    L18:
        return timePatternUS;
    }

    public final RelativeTimeLocalization getLocalization$OUI_standardRelease(Locale r1) {
        Intrinsics.checkNotNullParameter(r1, LoggingEvents.VoiceIme.EXTRA_START_LOCALE);
        if (Intrinsics.areEqual(r1, Locale.CHINA) == false) goto L6;
        return localizationCN;
    L6:
        if (Intrinsics.areEqual(r1, Locale.TAIWAN) == false) goto L9;
        return localizationTW;
    L9:
        if (Intrinsics.areEqual(r1, Locale.UK) == false) goto L12;
        return localizationUK;
    L12:
        if (Intrinsics.areEqual(r1, Locale.US) == false) goto L15;
        return localizationUS;
    L15:
        if (Intrinsics.areEqual(r1.getCountry(), "HK") == false) goto L18;
        return localizationHK;
    L18:
        return localizationUS;
    }
}
