package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes17.dex */
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    private static ColorStateList getNamedColorStateListFromInt(TypedValue r100) {
        return ColorStateList.valueOf(r100.data);
    }

    public static boolean hasAttribute(XmlPullParser r100, String r101) {
        if (r100.getAttributeValue(NAMESPACE, r101) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getAttr(Context r100, int r101, int r102) {
        TypedValue r103 = new TypedValue();
        r100.getTheme().resolveAttribute(r101, r103, true);
        if (r103.resourceId == 0) goto L5;
        return r101;
    L5:
        return r102;
    }

    public static Drawable getDrawable(TypedArray r100, int r101, int r102) {
        Drawable r103 = r100.getDrawable(r101);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return r100.getDrawable(r102);
    }

    public static String getString(TypedArray r100, int r101, int r102) {
        String r103 = r100.getString(r101);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return r100.getString(r102);
    }

    public static CharSequence getText(TypedArray r100, int r101, int r102) {
        CharSequence r103 = r100.getText(r101);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return r100.getText(r102);
    }

    public static CharSequence[] getTextArray(TypedArray r100, int r101, int r102) {
        CharSequence[] r103 = r100.getTextArray(r101);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return r100.getTextArray(r102);
    }

    public static boolean getBoolean(TypedArray r100, int r101, int r102, boolean r103) {
        return r100.getBoolean(r101, r100.getBoolean(r102, r103));
    }

    public static int getInt(TypedArray r100, int r101, int r102, int r103) {
        return r100.getInt(r101, r100.getInt(r102, r103));
    }

    public static String getNamedString(TypedArray r100, XmlPullParser r101, String r102, int r103) {
        if (hasAttribute(r101, r102) == true) goto L7;
        return null;
    L7:
        return r100.getString(r103);
    }

    public static int getResourceId(TypedArray r100, int r101, int r102, int r103) {
        return r100.getResourceId(r101, r100.getResourceId(r102, r103));
    }

    public static TypedArray obtainAttributes(Resources r100, Resources.Theme r101, AttributeSet r102, int[] r103) {
        if (r101 != null) goto L6;
        return r100.obtainAttributes(r102, r103);
    L6:
        return r101.obtainStyledAttributes(r102, r103, 0, 0);
    }

    public static TypedValue peekNamedValue(TypedArray r100, XmlPullParser r101, String r102, int r103) {
        if (hasAttribute(r101, r102) == true) goto L7;
        return null;
    L7:
        return r100.peekValue(r103);
    }

    public static boolean getNamedBoolean(TypedArray r100, XmlPullParser r101, String r102, int r103, boolean r104) {
        if (hasAttribute(r101, r102) == true) goto L6;
        return r104;
    L6:
        return r100.getBoolean(r103, r104);
    }

    public static int getNamedColor(TypedArray r100, XmlPullParser r101, String r102, int r103, int r104) {
        if (hasAttribute(r101, r102) == true) goto L6;
        return r104;
    L6:
        return r100.getColor(r103, r104);
    }

    public static ColorStateList getNamedColorStateList(TypedArray r100, XmlPullParser r101, Resources.Theme r102, String r103, int r104) {
        if (hasAttribute(r101, r103) == false) goto L16;
        TypedValue r105 = new TypedValue();
        r100.getValue(r104, r105);
        int r106 = r105.type;
        if (r106 == 2) goto L15;
        if (r106 < 28) goto L13;
        if (r106 > 31) goto L13;
        return getNamedColorStateListFromInt(r105);
    L13:
        return ColorStateListInflaterCompat.inflate(r100.getResources(), r100.getResourceId(r104, 0), r102);
    L15:
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + r104 + ": " + r105);
    L16:
        return null;
    }

    public static float getNamedFloat(TypedArray r100, XmlPullParser r101, String r102, int r103, float r104) {
        if (hasAttribute(r101, r102) == true) goto L6;
        return r104;
    L6:
        return r100.getFloat(r103, r104);
    }

    public static int getNamedInt(TypedArray r100, XmlPullParser r101, String r102, int r103, int r104) {
        if (hasAttribute(r101, r102) == true) goto L6;
        return r104;
    L6:
        return r100.getInt(r103, r104);
    }

    public static int getNamedResourceId(TypedArray r100, XmlPullParser r101, String r102, int r103, int r104) {
        if (hasAttribute(r101, r102) == true) goto L6;
        return r104;
    L6:
        return r100.getResourceId(r103, r104);
    }

    public static ComplexColorCompat getNamedComplexColor(TypedArray r100, XmlPullParser r101, Resources.Theme r102, String r103, int r104, int r105) {
        if (hasAttribute(r101, r103) == false) goto L14;
        TypedValue r106 = new TypedValue();
        r100.getValue(r104, r106);
        int r107 = r106.type;
        if (r107 >= 28) goto L7;
    L10:
        ComplexColorCompat r108 = ComplexColorCompat.inflate(r100.getResources(), r100.getResourceId(r104, 0), r102);
        if (r108 == null) goto L14;
        return r108;
    L7:
        if (r107 > 31) goto L10;
        return ComplexColorCompat.from(r106.data);
    L14:
        return ComplexColorCompat.from(r105);
    }
}
