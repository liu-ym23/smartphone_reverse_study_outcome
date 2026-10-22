package com.baidu.location.e;

import com.stepos.alphame.utils.Property;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c {
    public static int a(ArrayList<ArrayList<Float>> arrayList) {
        int i4 = 0;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ArrayList<Float> arrayList2 = arrayList.get(i5);
            if (arrayList2 != null && arrayList2.size() > 2 && arrayList2.get(2).floatValue() > Property.DEFAULT_FLOAT_VALUE) {
                i4++;
            }
        }
        return i4;
    }

    public static int b(ArrayList<ArrayList<Float>> arrayList) {
        int i4 = 0;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ArrayList<Float> arrayList2 = arrayList.get(i5);
            if (arrayList2 != null && arrayList2.size() > 2 && arrayList2.get(2).floatValue() >= 15.0f) {
                i4++;
            }
        }
        return i4;
    }

    public static int c(ArrayList<ArrayList<Float>> arrayList) {
        int i4 = 0;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ArrayList<Float> arrayList2 = arrayList.get(i5);
            if (arrayList2 != null && arrayList2.size() > 2 && arrayList2.get(2).floatValue() >= 20.0f) {
                i4++;
            }
        }
        return i4;
    }

    public static int d(ArrayList<ArrayList<Float>> arrayList) {
        float fFloatValue = 0.0f;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            ArrayList<Float> arrayList2 = arrayList.get(i4);
            if (arrayList2 != null && arrayList2.size() > 2 && arrayList2.get(2).floatValue() > Property.DEFAULT_FLOAT_VALUE) {
                fFloatValue += arrayList2.get(2).floatValue();
            }
        }
        return Math.round(fFloatValue);
    }

    public static int e(ArrayList<ArrayList<Float>> arrayList) {
        return Math.round(d(arrayList) / a(arrayList));
    }

    public static int f(ArrayList<ArrayList<Float>> arrayList) {
        float fFloatValue = 0.0f;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            ArrayList<Float> arrayList2 = arrayList.get(i4);
            if (arrayList2 != null && arrayList2.size() > 2 && arrayList2.get(2).floatValue() > Property.DEFAULT_FLOAT_VALUE) {
                fFloatValue += arrayList2.get(1).floatValue() * arrayList2.get(2).floatValue();
            }
        }
        return Math.round(fFloatValue);
    }

    public static int g(ArrayList<ArrayList<Float>> arrayList) {
        return Math.round(f(arrayList) / a(arrayList));
    }

    public static int h(ArrayList<ArrayList<Float>> arrayList) {
        int i4;
        int[] iArr = new int[37];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            try {
                if (i6 >= arrayList.size()) {
                    break;
                }
                ArrayList<Float> arrayList2 = arrayList.get(i6);
                if (arrayList2 != null && arrayList2.size() > 0 && arrayList2.get(0).floatValue() < 360.0d) {
                    int iCeil = (int) Math.ceil(arrayList2.get(0).floatValue() / 10.0f);
                    iArr[iCeil] = iArr[iCeil] + 1;
                }
                i6++;
            } catch (Exception unused) {
                return 0;
            }
        }
        for (i4 = 1; i4 <= 36; i4++) {
            if (iArr[i4] > 0) {
                i5++;
            }
        }
        return Math.round((i5 / 36.0f) * 1000.0f);
    }
}
