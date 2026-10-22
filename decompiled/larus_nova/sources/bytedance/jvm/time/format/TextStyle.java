package bytedance.jvm.time.format;

import com.bytedance.android.livesdkapi.model.StreamSrConfig;

/* JADX INFO: loaded from: classes28.dex */
public final enum TextStyle extends Enum<TextStyle> {
    public static final TextStyle FULL = null;
    public static final TextStyle FULL_STANDALONE = null;
    public static final TextStyle NARROW = null;
    public static final TextStyle NARROW_STANDALONE = null;
    public static final TextStyle SHORT = null;
    public static final TextStyle SHORT_STANDALONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextStyle[] f21640a = null;
    private final int calendarStyle;
    private final int zoneNameStyleIndex;

    static {
        TextStyle r100 = new TextStyle("FULL", 0, 2, 0);
        FULL = r100;
        TextStyle r101 = new TextStyle("FULL_STANDALONE", 1, 32770, 0);
        FULL_STANDALONE = r101;
        TextStyle r102 = new TextStyle("SHORT", 2, 1, 1);
        SHORT = r102;
        TextStyle r103 = new TextStyle("SHORT_STANDALONE", 3, StreamSrConfig.SrScale.SR_SCALE_DISABLE, 1);
        SHORT_STANDALONE = r103;
        TextStyle r104 = new TextStyle("NARROW", 4, 4, 1);
        NARROW = r104;
        TextStyle r105 = new TextStyle("NARROW_STANDALONE", 5, 32772, 1);
        NARROW_STANDALONE = r105;
        f21640a = new TextStyle[]{r100, r101, r102, r103, r104, r105};
    }

    public static TextStyle[] values() {
        return (TextStyle[]) f21640a.clone();
    }

    public TextStyle asNormal() {
        return values()[ordinal() & (-2)];
    }

    public TextStyle asStandalone() {
        return values()[ordinal() | 1];
    }

    public boolean isStandalone() {
        if ((ordinal() & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int toCalendarStyle() {
        return this.calendarStyle;
    }

    public int zoneNameStyleIndex() {
        return this.zoneNameStyleIndex;
    }

    public static TextStyle valueOf(String r100) {
        return (TextStyle) r27.a.a(TextStyle.class, r100);
    }

    public TextStyle(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.calendarStyle = r102;
        this.zoneNameStyleIndex = r103;
    }
}
