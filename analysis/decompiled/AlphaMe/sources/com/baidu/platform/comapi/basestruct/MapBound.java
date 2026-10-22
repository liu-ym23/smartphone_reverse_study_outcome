package com.baidu.platform.comapi.basestruct;

import java.io.Serializable;

/* loaded from: classes.dex */
public class MapBound implements Serializable {
    public Point leftBottomPt = new Point();
    public Point rightTopPt = new Point();

    public MapBound() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapBound)) {
            return false;
        }
        MapBound mapBound = (MapBound) obj;
        Point point = this.leftBottomPt;
        if (point == null ? mapBound.leftBottomPt != null : !point.equals(mapBound.leftBottomPt)) {
            return false;
        }
        Point point2 = this.rightTopPt;
        if (point2 != null) {
            if (point2.equals(mapBound.rightTopPt)) {
                return true;
            }
        } else if (mapBound.rightTopPt == null) {
            return true;
        }
        return false;
    }

    public Point getCenterPt() {
        return new Point((this.rightTopPt.getIntX() + this.leftBottomPt.getIntX()) / 2, (this.rightTopPt.getIntY() + this.leftBottomPt.getIntY()) / 2);
    }

    public int hashCode() {
        Point point = this.leftBottomPt;
        int iHashCode = (point != null ? point.hashCode() : 0) * 31;
        Point point2 = this.rightTopPt;
        return iHashCode + (point2 != null ? point2.hashCode() : 0);
    }

    public void setLeftBottomPt(int i4, int i5) {
        this.leftBottomPt.setTo(i4, i5);
    }

    public void setRightTopPt(int i4, int i5) {
        this.rightTopPt.setTo(i4, i5);
    }

    public String toQuery() {
        return String.format("(%d,%d;%d,%d)", Integer.valueOf(this.leftBottomPt.getIntX()), Integer.valueOf(this.leftBottomPt.getIntY()), Integer.valueOf(this.rightTopPt.getIntX()), Integer.valueOf(this.rightTopPt.getIntY()));
    }

    public String toString() {
        return "MapBound{leftBottomPt=" + this.leftBottomPt + ", rightTopPt=" + this.rightTopPt + '}';
    }

    public void setLeftBottomPt(Point point) {
        this.leftBottomPt.setTo(point);
    }

    public void setRightTopPt(Point point) {
        this.rightTopPt.setTo(point);
    }

    public MapBound(int i4, int i5, int i6, int i7) {
        setLeftBottomPt(i4, i5);
        setRightTopPt(i6, i7);
    }
}
