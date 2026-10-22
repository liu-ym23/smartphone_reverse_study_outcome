package com.baidu.platform.comapi.basestruct;

import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class Point implements Serializable {
    public double doubleX;
    public double doubleY;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f32737x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f32738y;

    public String toQuery() {
        return String.format("(%d,%d)", new Object[]{Integer.valueOf(getIntX()), Integer.valueOf(getIntY())});
    }

    public String toString() {
        return "Point [x=" + getDoubleX() + ", y=" + getDoubleY() + "]";
    }

    public int hashCode() {
        return ((getIntX() + 31) * 31) + getIntY();
    }

    public Point() {
    }

    public double getDoubleX() {
        return this.doubleX;
    }

    public double getDoubleY() {
        return this.doubleY;
    }

    public int getIntX() {
        return this.f32737x;
    }

    public int getIntY() {
        return this.f32738y;
    }

    public int getmPtx() {
        return this.f32737x;
    }

    public int getmPty() {
        return this.f32738y;
    }

    public Point(Point r100) {
        if (r100 == null) goto L6;
        this.doubleX = r100.getDoubleX();
        this.doubleY = r100.getDoubleY();
        this.f32737x = r100.getIntX();
        this.f32738y = r100.getIntY();
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        Point r101 = (Point) r100;
        if (getDoubleX() == r101.getDoubleX()) goto L14;
    L26:
        return false;
    L14:
        if (getIntX() != r101.getIntX()) goto L26;
        if (getDoubleY() != r101.getDoubleY()) goto L26;
        if (getIntY() != r101.getIntY()) goto L26;
        if (getDoubleY() == r101.getDoubleY()) goto L27;
        return false;
    L27:
        return true;
    }

    public void setDoubleX(double r100) {
        this.doubleX = r100;
    }

    public void setDoubleY(double r100) {
        this.doubleY = r100;
    }

    public void setIntX(int r100) {
        this.f32737x = r100;
    }

    public void setIntY(int r100) {
        this.f32738y = r100;
    }

    public void setTo(Point r100) {
        if (r100 == null) goto L5;
        setDoubleX(r100.getDoubleX());
        setDoubleY(r100.getDoubleY());
        return;
    }

    public void setmPtx(int r100) {
        this.f32737x = r100;
    }

    public void setmPty(int r100) {
        this.f32738y = r100;
    }

    public Point(double r100, double r101) {
        this.f32737x = (int) r100;
        this.f32738y = (int) r101;
        this.doubleX = r100;
        this.doubleY = r101;
    }

    public void setTo(double r100, double r101) {
        setDoubleX(r100);
        setDoubleY(r101);
    }

    public Point(int r100, int r101) {
        this.f32737x = r100;
        this.f32738y = r101;
        this.doubleX = r100;
        this.doubleY = r101;
    }
}
