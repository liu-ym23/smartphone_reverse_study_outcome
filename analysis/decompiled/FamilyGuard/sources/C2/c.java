package C2;

import android.text.TextUtils;
import java.util.List;

/* loaded from: classes.dex */
public class c {
    public static boolean a(String[] strArr, String str) {
        if (strArr != null) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static float b(float[] fArr) {
        float f5 = 0.0f;
        for (float f6 : fArr) {
            if (f5 < f6) {
                f5 = f6;
            }
        }
        return f5;
    }

    public static int[] c(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int[] iArr = new int[list.size()];
        for (int i5 = 0; i5 < list.size(); i5++) {
            iArr[i5] = list.get(i5).intValue();
        }
        return iArr;
    }
}
