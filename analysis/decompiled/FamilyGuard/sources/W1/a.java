package W1;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class a {
    public static int a(String str) {
        for (int i5 = 0; i5 < c().length; i5++) {
            if (TextUtils.equals(c()[i5], str)) {
                return i5;
            }
        }
        return 10;
    }

    public static String b(int i5) {
        return c()[i5];
    }

    public static String[] c() {
        return new String[]{"UTILS", "NEWS", "LIFE", "FINANCING", "SOCIAL", "GAME_AND_VIDEO", "STUDY", "OFFICE", "SPORT", "SHOPPING", "OTHER", "SYSTEM"};
    }

    public static int[] d() {
        return new int[]{11, 10, 5, 0, 1, 2, 3, 4, 6, 7, 8, 9};
    }
}
