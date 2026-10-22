package U;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class Y {
    public static String a(int i10) {
        ArrayList arrayList = new ArrayList();
        if ((i10 & 4) != 0) {
            arrayList.add("IMAGE_CAPTURE");
        }
        if ((i10 & 1) != 0) {
            arrayList.add("PREVIEW");
        }
        if ((i10 & 2) != 0) {
            arrayList.add("VIDEO_CAPTURE");
        }
        return String.join("|", arrayList);
    }

    public static int b(int i10) {
        int i11 = 0;
        while (i10 != 0) {
            i11 += i10 & 1;
            i10 >>= 1;
        }
        return i11;
    }

    public static boolean c(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
