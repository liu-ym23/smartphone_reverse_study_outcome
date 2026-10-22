package com.bes.sdk.message;

import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class AncSettings implements Serializable {
    public static final int ANC_SPORTS_OFF = 0;
    public static final int ANC_SPORTS_ON = 1;
    public static final int FILTER_AMBIENT_AWARE = 3;
    public static final int FILTER_ANC = 1;
    public static final int FILTER_OFF = 0;
    public static final int FILTER_TALK_THROUGH = 2;
    public static final int INVALID_VALUE = -1;
    private int ancSportsMode;
    private int filter;
    private double gain;

    public String toString() {
        return "AncSettings{filter=" + this.filter + ", gain=" + this.gain + ", ancSportsMode=" + this.ancSportsMode + '}';
    }

    public AncSettings() {
        this.ancSportsMode = 0;
    }

    public int getAncSportsMode() {
        return this.ancSportsMode;
    }

    public int getFilter() {
        return this.filter;
    }

    public double getGain() {
        return this.gain;
    }

    public void setAncSportsMode(int r100) {
        this.ancSportsMode = r100;
    }

    public void setFilter(int r100) {
        this.filter = r100;
    }

    public void setGain(double r100) {
        this.gain = r100;
    }
}
