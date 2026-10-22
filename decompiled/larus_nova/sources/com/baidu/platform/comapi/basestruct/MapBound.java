package com.baidu.platform.comapi.basestruct;

import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class MapBound implements Serializable {
    public Point leftBottomPt;
    public Point rightTopPt;

    public String toQuery() {
        return String.format("(%d,%d;%d,%d)", new Object[]{Integer.valueOf(this.leftBottomPt.getIntX()), Integer.valueOf(this.leftBottomPt.getIntY()), Integer.valueOf(this.rightTopPt.getIntX()), Integer.valueOf(this.rightTopPt.getIntY())});
    }

    public Point getCenterPt() {
        return new Point((this.leftBottomPt.getIntX() + this.rightTopPt.getIntX()) / 2, (this.leftBottomPt.getIntY() + this.rightTopPt.getIntY()) / 2);
    }

    public int hashCode() {
        Point r100 = this.leftBottomPt;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Point r104 = this.rightTopPt;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "MapBound{leftBottomPt=" + this.leftBottomPt + ", rightTopPt=" + this.rightTopPt + '}';
    }

    public MapBound() {
        this.leftBottomPt = new Point();
        this.rightTopPt = new Point();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MapBound) == true) goto L8;
        return false;
    L8:
        MapBound r101 = (MapBound) r100;
        Point r102 = this.leftBottomPt;
        if (r102 == null) goto L14;
        if (r102.equals(r101.leftBottomPt) == false) goto L15;
    L16:
        Point r103 = this.rightTopPt;
        Point r104 = r101.rightTopPt;
        if (r103 != null) goto L19;
        if (r104 == null) goto L26;
    L23:
        return false;
    L26:
        return true;
    L19:
        if (r103.equals(r104) == false) goto L23;
        return true;
    L15:
        return false;
    L14:
        if (r101.leftBottomPt == null) goto L16;
        goto L15
    }

    public void setLeftBottomPt(Point r100) {
        this.leftBottomPt.setTo(r100);
    }

    public void setRightTopPt(Point r100) {
        this.rightTopPt.setTo(r100);
    }

    public void setLeftBottomPt(int r100, int r101) {
        this.leftBottomPt.setTo(r100, r101);
    }

    public void setRightTopPt(int r100, int r101) {
        this.rightTopPt.setTo(r100, r101);
    }

    public MapBound(int r100, int r101, int r102, int r103) {
        this.leftBottomPt = new Point();
        this.rightTopPt = new Point();
        setLeftBottomPt(r100, r101);
        setRightTopPt(r102, r103);
    }
}
