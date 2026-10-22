package com.android.contacts.common.interactions;

import android.graphics.Point;

/* JADX INFO: loaded from: classes.dex */
public class TouchPointManager {
    public static final String TOUCH_POINT = "touchPoint";
    private static TouchPointManager sInstance;
    private Point mPoint;

    static {
        sInstance = new TouchPointManager();
    }

    private TouchPointManager() {
        this.mPoint = new Point();
    }

    public static TouchPointManager getInstance() {
        return sInstance;
    }

    public Point getPoint() {
        return this.mPoint;
    }

    public void setPoint(int r1, int r2) {
        this.mPoint.set(r1, r2);
    }

    public boolean hasValidPoint() {
        if (this.mPoint.x == 0) goto L5;
    L8:
        return true;
    L5:
        if (this.mPoint.y != 0) goto L8;
        return false;
    }
}
