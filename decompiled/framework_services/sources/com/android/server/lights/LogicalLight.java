package com.android.server.lights;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LogicalLight {
    public static final int BRIGHTNESS_MODE_LOW_PERSISTENCE = 2;
    public static final int BRIGHTNESS_MODE_SENSOR = 1;
    public static final int BRIGHTNESS_MODE_USER = 0;
    public static final int LIGHT_FLASH_HARDWARE = 2;
    public static final int LIGHT_FLASH_NONE = 0;
    public static final int LIGHT_FLASH_TIMED = 1;

    public abstract void pulse();

    public abstract void pulse(int r1, int r2);

    public abstract void setBrightness(float r1);

    public abstract void setBrightness(float r1, int r2);

    public abstract void setColor(int r1);

    public abstract void setFlashing(int r1, int r2, int r3, int r4);

    public abstract void setVrMode(boolean r1);

    public abstract void turnOff();

    public LogicalLight() {
    }
}
