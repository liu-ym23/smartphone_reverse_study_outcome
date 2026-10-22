package com.bytedance.android.livesdk.push.ui;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;

/* JADX INFO: loaded from: classes11.dex */
public final enum OnSwipeListener$Direction extends Enum<OnSwipeListener$Direction> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnSwipeListener$Direction[] f156868a = null;
    public static final OnSwipeListener$Direction down = null;
    public static final OnSwipeListener$Direction left = null;
    public static final OnSwipeListener$Direction right = null;

    /* JADX INFO: renamed from: up, reason: collision with root package name */
    public static final OnSwipeListener$Direction f156869up = null;

    public static boolean a(double r100, float r101, float r102) {
        if (r100 >= r101) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= r102) goto L7;
        return true;
    }

    static {
        OnSwipeListener$Direction r100 = new OnSwipeListener$Direction("up", 0);
        f156869up = r100;
        OnSwipeListener$Direction r101 = new OnSwipeListener$Direction(ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, 1);
        down = r101;
        OnSwipeListener$Direction r102 = new OnSwipeListener$Direction("left", 2);
        left = r102;
        OnSwipeListener$Direction r103 = new OnSwipeListener$Direction("right", 3);
        right = r103;
        f156868a = new OnSwipeListener$Direction[]{r100, r101, r102, r103};
    }

    public static OnSwipeListener$Direction[] values() {
        return (OnSwipeListener$Direction[]) f156868a.clone();
    }

    public static OnSwipeListener$Direction fromAngle(double r100) {
        if (a(r100, 45.0f, 135.0f) == false) goto L7;
        return f156869up;
    L7:
        if (a(r100, 0.0f, 45.0f) == true) goto L18;
        if (a(r100, 315.0f, 360.0f) == true) goto L18;
        if (a(r100, 225.0f, 315.0f) == false) goto L16;
        return down;
    L16:
        return left;
    L18:
        return right;
    }

    public static OnSwipeListener$Direction valueOf(String r100) {
        return (OnSwipeListener$Direction) r27.a.a(OnSwipeListener$Direction.class, r100);
    }

    public OnSwipeListener$Direction(String r100, int r101) {
        super(r100, r101);
    }
}
