package com.bes.sdk.message;

import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class SealingInfo implements Serializable {
    public static final int INVALID = -1;
    public static final int NOT_READY = 0;
    public static final int READY = 1;
    private int leftSealing;
    private int rightSealing;

    public SealingInfo() {
    }

    public String toString() {
        return "SealingInfo{leftSealing=" + this.leftSealing + ", rightSealing=" + this.rightSealing + '}';
    }

    public int getLeftSealing() {
        return this.leftSealing;
    }

    public int getRightSealing() {
        return this.rightSealing;
    }

    public void setLeftSealing(int r100) {
        this.leftSealing = r100;
    }

    public void setRightSealing(int r100) {
        this.rightSealing = r100;
    }
}
