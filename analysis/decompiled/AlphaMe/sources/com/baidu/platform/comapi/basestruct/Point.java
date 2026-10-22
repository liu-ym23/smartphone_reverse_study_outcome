package com.baidu.platform.comapi.basestruct;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Point implements Serializable {
    public double doubleX;
    public double doubleY;

    /* renamed from: x, reason: collision with root package name */
    public int f8600x;

    /* renamed from: y, reason: collision with root package name */
    public int f8601y;

    public Point() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return getDoubleX() == point.getDoubleX() && getIntX() == point.getIntX() && getDoubleY() == point.getDoubleY() && getIntY() == point.getIntY() && getDoubleY() == point.getDoubleY();
    }

    public double getDoubleX() {
        return this.doubleX;
    }

    public double getDoubleY() {
        return this.doubleY;
    }

    public int getIntX() {
        return this.f8600x;
    }

    public int getIntY() {
        return this.f8601y;
    }

    public int getmPtx() {
        return this.f8600x;
    }

    public int getmPty() {
        return this.f8601y;
    }

    public int hashCode() {
        return getIntY() + ((getIntX() + 31) * 31);
    }

    public void setDoubleX(double d4) {
        this.doubleX = d4;
    }

    public void setDoubleY(double d4) {
        this.doubleY = d4;
    }

    public void setIntX(int i4) {
        this.f8600x = i4;
    }

    public void setIntY(int i4) {
        this.f8601y = i4;
    }

    public void setTo(double d4, double d5) {
        setDoubleX(d4);
        setDoubleY(d5);
    }

    public void setmPtx(int i4) {
        this.f8600x = i4;
    }

    public void setmPty(int i4) {
        this.f8601y = i4;
    }

    public String toQuery() {
        return String.format("(%d,%d)", Integer.valueOf(getIntX()), Integer.valueOf(getIntY()));
    }

    public String toString() {
        return "Point [x=" + getDoubleX() + ", y=" + getDoubleY() + "]";
    }

    public Point(int i4, int i5) {
        this.f8600x = i4;
        this.f8601y = i5;
        this.doubleX = i4;
        this.doubleY = i5;
    }

    public void setTo(Point point) {
        if (point != null) {
            setDoubleX(point.getDoubleX());
            setDoubleY(point.getDoubleY());
        }
    }

    public Point(double d4, double d5) {
        this.f8600x = (int) d4;
        this.f8601y = (int) d5;
        this.doubleX = d4;
        this.doubleY = d5;
    }

    public Point(Point point) {
        if (point != null) {
            this.doubleX = point.getDoubleX();
            this.doubleY = point.getDoubleY();
            this.f8600x = point.getIntX();
            this.f8601y = point.getIntY();
        }
    }
}
