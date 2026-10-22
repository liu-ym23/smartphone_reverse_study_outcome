package com.bes.sdk.message;

import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class MyBudsInfo implements Serializable {
    public static final int INVALID_STATUS = -1;
    public static final int OFF = 0;
    private int leftBeeping;
    private int leftLighting;
    private int rightBeeping;
    private int rightLighting;

    public String toString() {
        return "MyBudsInfo{leftBeeping=" + this.leftBeeping + ", rightBeeping=" + this.rightBeeping + ", leftLighting=" + this.leftLighting + ", rightLighting=" + this.rightLighting + '}';
    }

    public MyBudsInfo() {
        this.leftBeeping = -1;
        this.rightBeeping = -1;
        this.leftLighting = -1;
        this.rightLighting = -1;
    }

    public int getLeftBeeping() {
        return this.leftBeeping;
    }

    public int getLeftLighting() {
        return this.leftLighting;
    }

    public int getRightBeeping() {
        return this.rightBeeping;
    }

    public int getRightLighting() {
        return this.rightLighting;
    }

    public void setLeftBeeping(int r100) {
        this.leftBeeping = r100;
    }

    public void setLeftLighting(int r100) {
        this.leftLighting = r100;
    }

    public void setRightBeeping(int r100) {
        this.rightBeeping = r100;
    }

    public void setRightLighting(int r100) {
        this.rightLighting = r100;
    }
}
