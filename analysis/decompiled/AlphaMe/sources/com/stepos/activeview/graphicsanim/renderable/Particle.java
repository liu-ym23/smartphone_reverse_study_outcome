package com.stepos.activeview.graphicsanim.renderable;

/* loaded from: classes.dex */
public class Particle {
    public float height;
    public long lastRandomSizeChange = System.currentTimeMillis();
    public float moveDistance;
    public float randomSpeedX;
    public float randomSpeedY;
    public float startX;
    public float startY;
    public float width;

    /* renamed from: x, reason: collision with root package name */
    public float f11173x;

    /* renamed from: y, reason: collision with root package name */
    public float f11174y;

    public Particle(float f4, float f5, float f6, float f7) {
        this.f11173x = f4;
        this.f11174y = f5;
        this.startX = f4;
        this.startY = f5;
        this.randomSpeedX = f6;
        this.randomSpeedY = f7;
    }

    public void setRandomSpeed(float f4, float f5) {
        this.randomSpeedX = f4;
        this.randomSpeedY = f5;
    }

    public String toString() {
        return "Particle(" + hashCode() + "): startX = " + this.startX + ", startY = " + this.startY + ", x =" + this.f11173x + ", y = " + this.f11174y + ", randomSpeedX = " + this.randomSpeedX + ", randomSpeedY = " + this.randomSpeedY + ", width = " + this.width + ", height = " + this.height + ";";
    }
}
