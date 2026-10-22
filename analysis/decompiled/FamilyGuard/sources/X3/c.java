package X3;

import j4.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends b {
    public static float b(float f5, float... fArr) {
        k.g(fArr, "other");
        for (float f6 : fArr) {
            f5 = Math.max(f5, f6);
        }
        return f5;
    }
}
