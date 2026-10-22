package com.bytedance.applog.event;

/* loaded from: classes.dex */
public class AutoTrackEventType {
    public static final int ALL = Integer.MAX_VALUE;
    public static final int CLICK = 4;
    public static final int PAGE = 2;
    public static final int PAGE_LEAVE = 8;

    public static boolean a(int i, int i2) {
        return (i & i2) != 0;
    }
}
