package com.bes.sdk.message;

import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class BatteryInfo implements Serializable {
    public static final int INVALID_LEVEL = -1;
    private boolean boxCharging;
    private int boxLevel;
    private boolean masterCharging;
    private int masterLevel;
    private int masterVoltage;
    private boolean slaveCharging;
    private int slaveLevel;
    private int slaveVoltage;

    public BatteryInfo() {
    }

    public String toString() {
        return "BatteryInfo{\nmasterCharging=" + this.masterCharging + "\nmasterLevel=" + this.masterLevel + "\nslaveCharging=" + this.slaveCharging + "\nslaveLevel=" + this.slaveLevel + "\nboxCharging=" + this.boxCharging + "\nboxLevel=" + this.boxLevel + "\nmasterVoltage=" + this.masterVoltage + "\nslaveVoltage=" + this.slaveVoltage + '}';
    }

    public int getBoxLevel() {
        return this.boxLevel;
    }

    public int getMasterLevel() {
        return this.masterLevel;
    }

    public int getMasterVoltage() {
        return this.masterVoltage;
    }

    public int getSlaveLevel() {
        return this.slaveLevel;
    }

    public int getSlaveVoltage() {
        return this.slaveVoltage;
    }

    public boolean isBoxCharging() {
        return this.boxCharging;
    }

    public boolean isMasterCharging() {
        return this.masterCharging;
    }

    public boolean isSlaveCharging() {
        return this.slaveCharging;
    }

    public void setBoxCharging(boolean r100) {
        this.boxCharging = r100;
    }

    public void setBoxLevel(int r100) {
        this.boxLevel = r100;
    }

    public void setMasterCharging(boolean r100) {
        this.masterCharging = r100;
    }

    public void setMasterLevel(int r100) {
        this.masterLevel = r100;
    }

    public void setMasterVoltage(int r100) {
        this.masterVoltage = r100;
    }

    public void setSlaveCharging(boolean r100) {
        this.slaveCharging = r100;
    }

    public void setSlaveLevel(int r100) {
        this.slaveLevel = r100;
    }

    public void setSlaveVoltage(int r100) {
        this.slaveVoltage = r100;
    }
}
