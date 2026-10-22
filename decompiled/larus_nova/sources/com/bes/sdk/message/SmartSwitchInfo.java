package com.bes.sdk.message;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes39.dex */
public class SmartSwitchInfo implements Serializable {
    public static final int INVALID = -1;

    /* JADX INFO: renamed from: aac, reason: collision with root package name */
    private int f33665aac;
    private int latency;
    private int latency2;

    /* JADX INFO: renamed from: sbc, reason: collision with root package name */
    private int f33666sbc;

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f33665aac), Integer.valueOf(this.f33666sbc), Integer.valueOf(this.latency), Integer.valueOf(this.latency2)});
    }

    public String toString() {
        return "SmartSwitchInfo{aac=" + this.f33665aac + ", sbc=" + this.f33666sbc + ", latency=" + this.latency + ", latency2=" + this.latency2 + '}';
    }

    public SmartSwitchInfo() {
        this.latency = -1;
        this.latency2 = -1;
    }

    public int getAac() {
        return this.f33665aac;
    }

    public int getLatency() {
        return this.latency;
    }

    public int getLatency2() {
        return this.latency2;
    }

    public int getSbc() {
        return this.f33666sbc;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L21;
        SmartSwitchInfo r101 = (SmartSwitchInfo) r100;
        if (this.f33665aac == r101.f33665aac) goto L13;
    L19:
        return false;
    L13:
        if (this.f33666sbc != r101.f33666sbc) goto L19;
        if (this.latency != r101.latency) goto L19;
        if (this.latency2 != r101.latency2) goto L19;
        return true;
    }

    public void setAac(int r100) {
        this.f33665aac = r100;
    }

    public void setLatency(int r100) {
        this.latency = r100;
    }

    public void setLatency2(int r100) {
        this.latency2 = r100;
    }

    public void setSbc(int r100) {
        this.f33666sbc = r100;
    }

    public SmartSwitchInfo(int r100, int r101, int r102, int r103) {
        this.f33665aac = r100;
        this.f33666sbc = r101;
        this.latency = r102;
        this.latency2 = r103;
    }
}
