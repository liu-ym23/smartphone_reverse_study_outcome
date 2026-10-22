package com.stepos.alphame.notification.model;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes.dex */
public class Word2VecModel implements Serializable {
    private Map model;
    private int vector_size;

    public Map getModel() {
        return this.model;
    }

    public float[] getValue(String str) {
        float[] fArr = new float[this.vector_size];
        short[] sArr = (short[]) this.model.get(str);
        if (sArr == null) {
            return null;
        }
        for (int i4 = 0; i4 < sArr.length; i4++) {
            fArr[i4] = sArr[i4] / 10.0f;
        }
        return fArr;
    }

    public int getVector_size() {
        return this.vector_size;
    }

    public void setModel(Map map) {
        this.model = map;
    }

    public void setVector_size(int i4) {
        this.vector_size = i4;
    }
}
