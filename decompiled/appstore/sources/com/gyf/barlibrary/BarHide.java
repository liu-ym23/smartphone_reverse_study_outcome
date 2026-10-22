package com.gyf.barlibrary;

/* JADX INFO: loaded from: classes3.dex */
public final enum BarHide extends Enum<BarHide> {
    private static final /* synthetic */ BarHide[] $VALUES = null;
    public static final BarHide FLAG_HIDE_BAR = null;
    public static final BarHide FLAG_HIDE_NAVIGATION_BAR = null;
    public static final BarHide FLAG_HIDE_STATUS_BAR = null;
    public static final BarHide FLAG_SHOW_BAR = null;

    static {
        BarHide r10 = new BarHide("FLAG_HIDE_STATUS_BAR", 0);
        FLAG_HIDE_STATUS_BAR = r10;
        BarHide r11 = new BarHide("FLAG_HIDE_NAVIGATION_BAR", 1);
        FLAG_HIDE_NAVIGATION_BAR = r11;
        BarHide r12 = new BarHide("FLAG_HIDE_BAR", 2);
        FLAG_HIDE_BAR = r12;
        BarHide r13 = new BarHide("FLAG_SHOW_BAR", 3);
        FLAG_SHOW_BAR = r13;
        $VALUES = new BarHide[]{r10, r11, r12, r13};
    }

    private BarHide(String r10, int r11) {
        super(r10, r11);
    }

    public static BarHide valueOf(String r10) {
        return (BarHide) Enum.valueOf(BarHide.class, r10);
    }

    public static BarHide[] values() {
        return (BarHide[]) $VALUES.clone();
    }
}
