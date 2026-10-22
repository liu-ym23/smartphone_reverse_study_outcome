package com.autonavi.base.amap.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.mapcore.IPoint;

/* JADX INFO: loaded from: classes39.dex */
public class Rectangle {
    private int beyond180Mode;
    public float bottom;
    public FPoint[] clipMapRect;
    public IPoint[] clipRect;
    private int[] jniClipRect;
    public float left;
    public Rect rect;
    public float right;
    public float top;

    private void updateClipRect() {
        if (this.clipRect != null) goto L5;
        IPoint[] r100 = new IPoint[4];
        this.clipRect = r100;
        r100[0] = IPoint.obtain(0, 0);
        this.clipRect[1] = IPoint.obtain(0, 0);
        this.clipRect[2] = IPoint.obtain(0, 0);
        this.clipRect[3] = IPoint.obtain(0, 0);
    L5:
        Rect r101 = this.rect;
        if (r101 == null) goto L9;
        IPoint[] r102 = this.clipRect;
        IPoint r103 = r102[0];
        int r104 = r101.left;
        ((Point) r103).x = r104;
        int r105 = r101.top;
        ((Point) r103).y = r105;
        IPoint r106 = r102[1];
        int r107 = r101.right;
        ((Point) r106).x = r107;
        ((Point) r106).y = r105;
        IPoint r108 = r102[2];
        ((Point) r108).x = r107;
        int r109 = r101.bottom;
        ((Point) r108).y = r109;
        IPoint r110 = r102[3];
        ((Point) r110).x = r104;
        ((Point) r110).y = r109;
        return;
    }

    public Rectangle() {
        this.rect = new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
    }

    public int getBeyond180Mode() {
        return this.beyond180Mode;
    }

    public FPoint[] getClipMapRect() {
        return this.clipMapRect;
    }

    public IPoint[] getClipRect() {
        return this.clipRect;
    }

    public Rect getRect() {
        return this.rect;
    }

    public boolean contains(IPoint r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return contains(((Point) r100).x, ((Point) r100).y);
    }

    public boolean isOverlap(Rect r100) {
        Rect r101 = this.rect;
        if (r101 == null) goto L16;
        if (r100 == null) goto L16;
        int r102 = r101.left + r101.width();
        int r103 = r100.left;
        if (r102 <= r103) goto L16;
        int r104 = r103 + r100.width();
        Rect r105 = this.rect;
        if (r104 <= r105.left) goto L16;
        int r106 = r105.top + r105.height();
        int r107 = r100.top;
        if (r106 <= r107) goto L16;
        if ((r107 + r100.height()) <= this.rect.top) goto L16;
        return true;
    L16:
        return false;
    }

    public boolean contains(Rect r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return this.rect.contains(r100);
    }

    private void updateClipMapRect(int r110, int r111) {
        int r100 = 0;
        if (this.clipMapRect != null) goto L5;
        FPoint[] r101 = new FPoint[4];
        this.clipMapRect = r101;
        r101[0] = FPoint.obtain(0.0f, 0.0f);
        this.clipMapRect[1] = FPoint.obtain(0.0f, 0.0f);
        this.clipMapRect[2] = FPoint.obtain(0.0f, 0.0f);
        this.clipMapRect[3] = FPoint.obtain(0.0f, 0.0f);
    L5:
        Rect r102 = this.rect;
        if (r102 == null) goto L9;
        FPoint[] r103 = this.clipMapRect;
        FPoint r104 = r103[0];
        float r105 = r102.left - r110;
        ((PointF) r104).x = r105;
        float r106 = r102.top - r111;
        ((PointF) r104).y = r106;
        FPoint r107 = r103[1];
        float r112 = r102.right - r110;
        ((PointF) r107).x = r112;
        ((PointF) r107).y = r106;
        FPoint r108 = r103[2];
        ((PointF) r108).x = r112;
        float r113 = r102.bottom - r111;
        ((PointF) r108).y = r113;
        FPoint r114 = r103[3];
        ((PointF) r114).x = r105;
        ((PointF) r114).y = r113;
    L9:
        if (this.jniClipRect != null) goto L11;
        this.jniClipRect = new int[this.clipMapRect.length * 2];
    L11:
        FPoint[] r115 = this.clipMapRect;
        if (r100 >= r115.length) goto L14;
        int[] r116 = this.jniClipRect;
        int r109 = r100 * 2;
        FPoint r117 = r115[r100];
        r116[r109] = (int) ((PointF) r117).x;
        r116[r109 + 1] = (int) ((PointF) r117).y;
        r100 = r100 + 1;
        goto L11
    }

    public boolean contains(int r100, int r101) {
        Rect r102 = this.rect;
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r102.contains(r100, r101) == false) goto L8;
        return true;
    L8:
        if (this.beyond180Mode != 0) goto L10;
        return false;
    L10:
        if (this.rect.contains(r100 - 268435456, r101) == false) goto L13;
        return true;
    L13:
        if (this.rect.contains(r100 + 268435456, r101) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public Rectangle(Rect r100, int r101, int r102) {
        new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        this.rect = r100;
        if (r100 == null) goto L6;
        updateRect(r100, r101, r102);
        updateClipRect();
        updateClipMapRect(r100.centerX(), r100.centerY());
        return;
    }

    public void updateRect(Rect r100, int r101, int r102) {
        if (r100 == null) goto L12;
        this.rect = r100;
        r100.inset((-r100.width()) / 8, (-r100.height()) / 8);
        Rect r103 = this.rect;
        float r104 = r103.left / 100000.0f;
        int r105 = r103.right;
        if ((r104 * (r105 / 100000.0f)) >= 0.0f) goto L7;
        this.beyond180Mode = -1;
    L10:
        updateClipRect();
        updateClipMapRect(r101, r102);
        return;
    L7:
        if (r105 <= 268435456) goto L9;
        this.beyond180Mode = 1;
        goto L10
    L9:
        this.beyond180Mode = 0;
        goto L10
    }

    public Rectangle(float r100, float r101, float r102, float r103) {
        this.rect = new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        if (r100 < r101) goto L5;
        return;
    L5:
        if (r103 <= r102) goto L10;
        this.left = r100;
        this.right = r101;
        this.top = r103;
        this.bottom = r102;
        return;
    }

    public boolean isOverlap(int r100, int r101, int r102, int r103) {
        Rect r104 = this.rect;
        if (r104 != null) goto L6;
        return false;
    L6:
        if ((r104.left + r104.width()) <= r100) goto L15;
        int r105 = r100 + r102;
        Rect r106 = this.rect;
        if (r105 <= r106.left) goto L15;
        if ((r106.top + r106.height()) <= r101) goto L15;
        if ((r101 + r103) <= this.rect.top) goto L15;
        return true;
    L15:
        return false;
    }
}
