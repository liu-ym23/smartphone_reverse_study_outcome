package cn.jzvd;

/* JADX INFO: loaded from: classes.dex */
public class JzvdMgr {
    public static Jzvd FIRST_FLOOR_JZVD;
    public static Jzvd SECOND_FLOOR_JZVD;

    public JzvdMgr() {
    }

    public static void completeAll() {
        Jzvd r10 = SECOND_FLOOR_JZVD;
        if (r10 == null) goto L5;
        r10.onCompletion();
        SECOND_FLOOR_JZVD = null;
    L5:
        Jzvd r11 = FIRST_FLOOR_JZVD;
        if (r11 == null) goto L9;
        r11.onCompletion();
        FIRST_FLOOR_JZVD = null;
        return;
    }

    public static Jzvd getCurrentJzvd() {
        if (getSecondFloor() == null) goto L7;
        return getSecondFloor();
    L7:
        return getFirstFloor();
    }

    public static Jzvd getFirstFloor() {
        return FIRST_FLOOR_JZVD;
    }

    public static Jzvd getSecondFloor() {
        return SECOND_FLOOR_JZVD;
    }

    public static void setFirstFloor(Jzvd r10) {
        FIRST_FLOOR_JZVD = r10;
    }

    public static void setSecondFloor(Jzvd r10) {
        SECOND_FLOOR_JZVD = r10;
    }
}
