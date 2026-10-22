package com.bes.sdk.message;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;

/* JADX INFO: loaded from: classes39.dex */
public class EQPayload implements Serializable {
    private float bandCount;
    private float calibration;
    private LinkedList<EQIDParam> iirParams;
    private int index;
    private float leftGain;
    private float rightGain;
    private int sampleRate;

    public static class EQIDParam implements Serializable {
        int bandType;
        float frequency;
        float gainValue;
        float qValue;

        public EQIDParam() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.bandType), Float.valueOf(this.gainValue), Float.valueOf(this.frequency), Float.valueOf(this.qValue)});
        }

        public String toString() {
            return "\ntype=" + this.bandType + ",gain=" + this.gainValue + ",freq=" + this.frequency + ",qValue=" + this.qValue;
        }

        public int getBandType() {
            return this.bandType;
        }

        public float getFrequency() {
            return this.frequency;
        }

        public float getGainValue() {
            return this.gainValue;
        }

        public float getQValue() {
            return this.qValue;
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
            EQIDParam r101 = (EQIDParam) r100;
            if (this.bandType == r101.bandType) goto L13;
        L19:
            return false;
        L13:
            if (Float.compare(r101.gainValue, this.gainValue) != 0) goto L19;
            if (Float.compare(r101.frequency, this.frequency) != 0) goto L19;
            if (Float.compare(r101.qValue, this.qValue) != 0) goto L19;
            return true;
        }

        public void setBandType(int r100) {
            this.bandType = r100;
        }

        public void setFrequency(float r100) {
            this.frequency = r100;
        }

        public void setGainValue(float r100) {
            this.gainValue = r100;
        }

        public void setQValue(float r100) {
            this.qValue = r100;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Float.valueOf(this.calibration), Integer.valueOf(this.sampleRate), Float.valueOf(this.leftGain), Float.valueOf(this.rightGain), this.iirParams});
    }

    public String toString() {
        LinkedList<EQIDParam> r100 = this.iirParams;
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L7:
        return "\nindex=" + this.index + "\ncalibration=" + this.calibration + "\nsampleRate=" + this.sampleRate + "\nleftGain=" + this.leftGain + "\nrightGain=" + this.rightGain + "\nbandCount=" + this.bandCount + "\n" + r101;
    L5:
        r101 = "";
        goto L7
    }

    public EQPayload() {
        this.index = -1;
    }

    public float getBandCount() {
        return this.bandCount;
    }

    public float getCalibration() {
        return this.calibration;
    }

    public LinkedList<EQIDParam> getIirParams() {
        return this.iirParams;
    }

    public int getIndex() {
        return this.index;
    }

    public float getLeftGain() {
        return this.leftGain;
    }

    public float getRightGain() {
        return this.rightGain;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L23:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L23;
        EQPayload r101 = (EQPayload) r100;
        if (Float.compare(r101.calibration, this.calibration) == 0) goto L13;
    L21:
        return false;
    L13:
        if (this.sampleRate != r101.sampleRate) goto L21;
        if (Float.compare(r101.leftGain, this.leftGain) != 0) goto L21;
        if (Float.compare(r101.rightGain, this.rightGain) != 0) goto L21;
        if (Objects.equals(this.iirParams, r101.iirParams) == false) goto L21;
        return true;
    }

    public void setBandCount(float r100) {
        this.bandCount = r100;
    }

    public void setCalibration(float r100) {
        this.calibration = r100;
    }

    public void setIirParams(LinkedList<EQIDParam> r100) {
        this.iirParams = r100;
    }

    public void setIndex(int r100) {
        this.index = r100;
    }

    public void setLeftGain(float r100) {
        this.leftGain = r100;
    }

    public void setRightGain(float r100) {
        this.rightGain = r100;
    }

    public void setSampleRate(int r100) {
        this.sampleRate = r100;
    }
}
