package com.stepos.activeview.json;

/* loaded from: classes.dex */
public class Args {
    private static final int PATH_ARRAY_LENGTH = 4;
    private float frequency;
    private float[] path = new float[4];

    public float getFrequency() {
        return this.frequency;
    }

    public float[] getPath() {
        return this.path;
    }

    public void setFrequency(float f4) {
        this.frequency = f4;
    }

    public void setPath(float[] fArr) {
        if (fArr.length != 4) {
            return;
        }
        this.path = fArr;
    }
}
