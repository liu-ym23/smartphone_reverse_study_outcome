package com.obric.oui.time;

import kotlin.Metadata;

/* JADX INFO: compiled from: TimeFormat.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/time/TimeStyle;", "", "(Ljava/lang/String;I)V", "FULL", "FULL_Y", "FULL_YM", "FULL_YMD", "FULL_MD", "FULL_YMDHM", "FULL_YMDEHM", "BRIEF_HM", "BRIEF_MD", "BRIEF_YMDHM", "RELATIVE_DETAILED", "RELATIVE_FUZZY", "RELATIVE_MIXED", "RELATIVE_MIXED_BRIEF", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum TimeStyle extends Enum<TimeStyle> {
    private static final /* synthetic */ TimeStyle[] $VALUES = null;
    public static final TimeStyle BRIEF_HM = null;
    public static final TimeStyle BRIEF_MD = null;
    public static final TimeStyle BRIEF_YMDHM = null;
    public static final TimeStyle FULL = null;
    public static final TimeStyle FULL_MD = null;
    public static final TimeStyle FULL_Y = null;
    public static final TimeStyle FULL_YM = null;
    public static final TimeStyle FULL_YMD = null;
    public static final TimeStyle FULL_YMDEHM = null;
    public static final TimeStyle FULL_YMDHM = null;
    public static final TimeStyle RELATIVE_DETAILED = null;
    public static final TimeStyle RELATIVE_FUZZY = null;
    public static final TimeStyle RELATIVE_MIXED = null;
    public static final TimeStyle RELATIVE_MIXED_BRIEF = null;

    private static final /* synthetic */ TimeStyle[] $values() {
        return new TimeStyle[]{FULL, FULL_Y, FULL_YM, FULL_YMD, FULL_MD, FULL_YMDHM, FULL_YMDEHM, BRIEF_HM, BRIEF_MD, BRIEF_YMDHM, RELATIVE_DETAILED, RELATIVE_FUZZY, RELATIVE_MIXED, RELATIVE_MIXED_BRIEF};
    }

    public static TimeStyle valueOf(String r1) {
        return (TimeStyle) Enum.valueOf(TimeStyle.class, r1);
    }

    public static TimeStyle[] values() {
        return (TimeStyle[]) $VALUES.clone();
    }

    private TimeStyle(String r1, int r2) {
        super(r1, r2);
    }

    static {
        FULL = new TimeStyle("FULL", 0);
        FULL_Y = new TimeStyle("FULL_Y", 1);
        FULL_YM = new TimeStyle("FULL_YM", 2);
        FULL_YMD = new TimeStyle("FULL_YMD", 3);
        FULL_MD = new TimeStyle("FULL_MD", 4);
        FULL_YMDHM = new TimeStyle("FULL_YMDHM", 5);
        FULL_YMDEHM = new TimeStyle("FULL_YMDEHM", 6);
        BRIEF_HM = new TimeStyle("BRIEF_HM", 7);
        BRIEF_MD = new TimeStyle("BRIEF_MD", 8);
        BRIEF_YMDHM = new TimeStyle("BRIEF_YMDHM", 9);
        RELATIVE_DETAILED = new TimeStyle("RELATIVE_DETAILED", 10);
        RELATIVE_FUZZY = new TimeStyle("RELATIVE_FUZZY", 11);
        RELATIVE_MIXED = new TimeStyle("RELATIVE_MIXED", 12);
        RELATIVE_MIXED_BRIEF = new TimeStyle("RELATIVE_MIXED_BRIEF", 13);
        $VALUES = $values();
    }
}
