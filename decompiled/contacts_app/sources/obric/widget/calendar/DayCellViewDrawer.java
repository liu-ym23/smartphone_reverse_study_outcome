package obric.widget.calendar;

import android.graphics.Canvas;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DayCellViewDrawer {
    public static int VIEW_TYPE_DAY_NO_VALID = 64;
    public static int VIEW_TYPE_DAY_OUT_OF_RANGE = 32;
    public static int VIEW_TYPE_NORMAL = 2;
    public static int VIEW_TYPE_NOT_FOCUS_MONTH = 16;
    public static int VIEW_TYPE_SELECTED = 4;
    public static int VIEW_TYPE_TODAY = 8;

    static {
    }

    public abstract void drawView(int index, String dayNum, String lunar, int eventType, int viewType, Canvas canvas, float percent);

    public abstract void setHasFocus(boolean focus);

    public DayCellViewDrawer() {
    }
}
