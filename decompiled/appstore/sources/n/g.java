package n;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static boolean a(TypedArray r10, XmlPullParser r11, String r12, int r13, boolean r14) {
        if (f(r11, r12) == true) goto L6;
        return r14;
    L6:
        return r10.getBoolean(r13, r14);
    }

    public static float b(TypedArray r10, XmlPullParser r11, String r12, int r13, float r14) {
        if (f(r11, r12) == true) goto L6;
        return r14;
    L6:
        return r10.getFloat(r13, r14);
    }

    public static int c(TypedArray r10, XmlPullParser r11, String r12, int r13, int r14) {
        if (f(r11, r12) == true) goto L6;
        return r14;
    L6:
        return r10.getInt(r13, r14);
    }

    public static int d(TypedArray r10, XmlPullParser r11, String r12, int r13, int r14) {
        if (f(r11, r12) == true) goto L6;
        return r14;
    L6:
        return r10.getResourceId(r13, r14);
    }

    public static String e(TypedArray r10, XmlPullParser r11, String r12, int r13) {
        if (f(r11, r12) == true) goto L7;
        return null;
    L7:
        return r10.getString(r13);
    }

    public static boolean f(XmlPullParser r10, String r11) {
        if (r10.getAttributeValue("http://schemas.android.com/apk/res/android", r11) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
