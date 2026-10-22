package com.bytedance.android.gamecp.base.gamedetail;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/gamecp/base/gamedetail/ConvertButtonViewStyle;", "", "RED_CORNER_8", "WHITE", "LIGHT_RED", "DARK_BG_CORNER_8", "BG_TRANSPARENT_CORNER_8_BORDER", "BG_TRANSPARENT_CORNER_4_BORDER", "GRAY_CORNER_8", "GRAY_CORNER_8_BORDER", "GRAY_CORNER_4_TEXT_COLOR_GRAY", "DARK_BG_CORNER_4", "RED_CORNER_4", "DARK_BG_CORNER_4_TEXT_COLOR_GRAY", "BG_TRANSPARENT_CORNER_4_BORDER_GRAY", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ConvertButtonViewStyle extends Enum<ConvertButtonViewStyle> {
    public static final ConvertButtonViewStyle BG_TRANSPARENT_CORNER_4_BORDER = null;
    public static final ConvertButtonViewStyle BG_TRANSPARENT_CORNER_4_BORDER_GRAY = null;
    public static final ConvertButtonViewStyle BG_TRANSPARENT_CORNER_8_BORDER = null;
    public static final ConvertButtonViewStyle DARK_BG_CORNER_4 = null;
    public static final ConvertButtonViewStyle DARK_BG_CORNER_4_TEXT_COLOR_GRAY = null;
    public static final ConvertButtonViewStyle DARK_BG_CORNER_8 = null;
    public static final ConvertButtonViewStyle GRAY_CORNER_4_TEXT_COLOR_GRAY = null;
    public static final ConvertButtonViewStyle GRAY_CORNER_8 = null;
    public static final ConvertButtonViewStyle GRAY_CORNER_8_BORDER = null;
    public static final ConvertButtonViewStyle LIGHT_RED = null;
    public static final ConvertButtonViewStyle RED_CORNER_4 = null;
    public static final ConvertButtonViewStyle RED_CORNER_8 = null;
    public static final ConvertButtonViewStyle WHITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConvertButtonViewStyle[] f51520a = null;

    static {
        ConvertButtonViewStyle r100 = new ConvertButtonViewStyle("RED_CORNER_8", 0);
        RED_CORNER_8 = r100;
        ConvertButtonViewStyle r101 = new ConvertButtonViewStyle("WHITE", 1);
        WHITE = r101;
        ConvertButtonViewStyle r102 = new ConvertButtonViewStyle("LIGHT_RED", 2);
        LIGHT_RED = r102;
        ConvertButtonViewStyle r103 = new ConvertButtonViewStyle("DARK_BG_CORNER_8", 3);
        DARK_BG_CORNER_8 = r103;
        ConvertButtonViewStyle r104 = new ConvertButtonViewStyle("BG_TRANSPARENT_CORNER_8_BORDER", 4);
        BG_TRANSPARENT_CORNER_8_BORDER = r104;
        ConvertButtonViewStyle r105 = new ConvertButtonViewStyle("BG_TRANSPARENT_CORNER_4_BORDER", 5);
        BG_TRANSPARENT_CORNER_4_BORDER = r105;
        ConvertButtonViewStyle r106 = new ConvertButtonViewStyle("GRAY_CORNER_8", 6);
        GRAY_CORNER_8 = r106;
        ConvertButtonViewStyle r107 = new ConvertButtonViewStyle("GRAY_CORNER_8_BORDER", 7);
        GRAY_CORNER_8_BORDER = r107;
        ConvertButtonViewStyle r108 = new ConvertButtonViewStyle("GRAY_CORNER_4_TEXT_COLOR_GRAY", 8);
        GRAY_CORNER_4_TEXT_COLOR_GRAY = r108;
        ConvertButtonViewStyle r109 = new ConvertButtonViewStyle("DARK_BG_CORNER_4", 9);
        DARK_BG_CORNER_4 = r109;
        ConvertButtonViewStyle r110 = new ConvertButtonViewStyle("RED_CORNER_4", 10);
        RED_CORNER_4 = r110;
        ConvertButtonViewStyle r111 = new ConvertButtonViewStyle("DARK_BG_CORNER_4_TEXT_COLOR_GRAY", 11);
        DARK_BG_CORNER_4_TEXT_COLOR_GRAY = r111;
        ConvertButtonViewStyle r112 = new ConvertButtonViewStyle("BG_TRANSPARENT_CORNER_4_BORDER_GRAY", 12);
        BG_TRANSPARENT_CORNER_4_BORDER_GRAY = r112;
        f51520a = new ConvertButtonViewStyle[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public static ConvertButtonViewStyle valueOf(String r100) {
        return (ConvertButtonViewStyle) r27.a.a(ConvertButtonViewStyle.class, r100);
    }

    public static ConvertButtonViewStyle[] values() {
        return (ConvertButtonViewStyle[]) f51520a.clone();
    }

    public ConvertButtonViewStyle(String r100, int r101) {
        super(r100, r101);
    }
}
