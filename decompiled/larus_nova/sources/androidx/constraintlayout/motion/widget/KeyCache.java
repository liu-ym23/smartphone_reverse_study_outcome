package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes17.dex */
public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> map;

    public KeyCache() {
        this.map = new HashMap();
    }

    public float getFloatValue(Object r100, String r101, int r102) {
        if (this.map.containsKey(r100) == true) goto L5;
        return Float.NaN;
    L5:
        HashMap<String, float[]> r103 = this.map.get(r100);
        if (r103.containsKey(r101) == true) goto L8;
        return Float.NaN;
    L8:
        float[] r104 = r103.get(r101);
        if (r104.length > r102) goto L11;
        return Float.NaN;
    L11:
        return r104[r102];
    }

    public void setFloatValue(Object r100, String r101, int r102, float r103) {
        if (this.map.containsKey(r100) == true) goto L5;
        HashMap<String, float[]> r104 = new HashMap();
        float[] r105 = new float[r102 + 1];
        r105[r102] = r103;
        r104.put(r101, r105);
        this.map.put(r100, r104);
        return;
    L5:
        HashMap<String, float[]> r106 = this.map.get(r100);
        if (r106.containsKey(r101) == true) goto L8;
        float[] r107 = new float[r102 + 1];
        r107[r102] = r103;
        r106.put(r101, r107);
        this.map.put(r100, r106);
        return;
    L8:
        float[] r108 = r106.get(r101);
        if (r108.length > r102) goto L11;
        r108 = Arrays.copyOf(r108, r102 + 1);
    L11:
        r108[r102] = r103;
        r106.put(r101, r108);
    }
}
