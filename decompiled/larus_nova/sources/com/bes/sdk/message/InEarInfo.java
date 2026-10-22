package com.bes.sdk.message;

import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class InEarInfo implements Serializable {
    public static final int INVALID = -1;
    public static final int NOT_READY = 0;
    public static final int READY = 1;
    private int leftInEar;
    private int rightInEar;

    public InEarInfo() {
    }

    public String toString() {
        return "InEarInfo{leftInEar=" + this.leftInEar + ", rightInEar=" + this.rightInEar + '}';
    }

    public int getLeftInEar() {
        return this.leftInEar;
    }

    public int getRightInEar() {
        return this.rightInEar;
    }

    public void setLeftInEar(int r100) {
        this.leftInEar = r100;
    }

    public void setRightInEar(int r100) {
        this.rightInEar = r100;
    }
}
