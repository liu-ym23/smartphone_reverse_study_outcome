package com.android.server.display.color;

import android.pico.utils.IExtBase;
import android.util.SparseArray;
import java.io.PrintWriter;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtDisplayTransformManager extends IExtBase {
    public static final HashMap<Class, IExtDisplayTransformManager> sCacheInstances = null;

    void applyColorMatrix(float[] r1);

    void applyDaltonizerMode(int r1, int r2);

    void applySaturation(float r1);

    void dumpInternal(PrintWriter r1, String[] r2);

    void setColorMatrix(int r1, float[] r2, float[] r3, SparseArray<float[]> r4);

    void setDisplayColor(int r1, int r2);

    static {
        sCacheInstances = new HashMap();
    }
}
