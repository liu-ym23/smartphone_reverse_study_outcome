package com.bytedance.android.livesdk.interactivity.medialink.widget.mixer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/mixer/WindowsPosition;", "", "SINGLE", "TWO_LEFT", "TWO_RIGHT", "THREE_LEFT", "THREE_RIGHT_TOP", "THREE_RIGHT_BOTTOM", "FOUR_LEFT_TOP", "FOUR_LEFT_BOTTOM", "FOUR_RIGHT_TOP", "FOUR_RIGHT_BOTTOM", "IGNORE", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowsPosition extends Enum<WindowsPosition> {
    public static final WindowsPosition FOUR_LEFT_BOTTOM = null;
    public static final WindowsPosition FOUR_LEFT_TOP = null;
    public static final WindowsPosition FOUR_RIGHT_BOTTOM = null;
    public static final WindowsPosition FOUR_RIGHT_TOP = null;
    public static final WindowsPosition IGNORE = null;
    public static final WindowsPosition SINGLE = null;
    public static final WindowsPosition THREE_LEFT = null;
    public static final WindowsPosition THREE_RIGHT_BOTTOM = null;
    public static final WindowsPosition THREE_RIGHT_TOP = null;
    public static final WindowsPosition TWO_LEFT = null;
    public static final WindowsPosition TWO_RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowsPosition[] f138544a = null;

    static {
        WindowsPosition r100 = new WindowsPosition("SINGLE", 0);
        SINGLE = r100;
        WindowsPosition r101 = new WindowsPosition("TWO_LEFT", 1);
        TWO_LEFT = r101;
        WindowsPosition r102 = new WindowsPosition("TWO_RIGHT", 2);
        TWO_RIGHT = r102;
        WindowsPosition r103 = new WindowsPosition("THREE_LEFT", 3);
        THREE_LEFT = r103;
        WindowsPosition r104 = new WindowsPosition("THREE_RIGHT_TOP", 4);
        THREE_RIGHT_TOP = r104;
        WindowsPosition r105 = new WindowsPosition("THREE_RIGHT_BOTTOM", 5);
        THREE_RIGHT_BOTTOM = r105;
        WindowsPosition r106 = new WindowsPosition("FOUR_LEFT_TOP", 6);
        FOUR_LEFT_TOP = r106;
        WindowsPosition r107 = new WindowsPosition("FOUR_LEFT_BOTTOM", 7);
        FOUR_LEFT_BOTTOM = r107;
        WindowsPosition r108 = new WindowsPosition("FOUR_RIGHT_TOP", 8);
        FOUR_RIGHT_TOP = r108;
        WindowsPosition r109 = new WindowsPosition("FOUR_RIGHT_BOTTOM", 9);
        FOUR_RIGHT_BOTTOM = r109;
        WindowsPosition r110 = new WindowsPosition("IGNORE", 10);
        IGNORE = r110;
        f138544a = new WindowsPosition[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public static WindowsPosition valueOf(String r100) {
        return (WindowsPosition) a.a(WindowsPosition.class, r100);
    }

    public static WindowsPosition[] values() {
        return (WindowsPosition[]) f138544a.clone();
    }

    public WindowsPosition(String r100, int r101) {
        super(r100, r101);
    }
}
