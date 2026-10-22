package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class k {
    public static int a(Context context, int i5, int i6) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i5, typedValue, true);
        return typedValue.resourceId != 0 ? i5 : i6;
    }

    public static boolean b(TypedArray typedArray, int i5, int i6, boolean z5) {
        return typedArray.getBoolean(i5, typedArray.getBoolean(i6, z5));
    }

    public static Drawable c(TypedArray typedArray, int i5, int i6) {
        Drawable drawable = typedArray.getDrawable(i5);
        return drawable == null ? typedArray.getDrawable(i6) : drawable;
    }

    public static int d(TypedArray typedArray, int i5, int i6, int i7) {
        return typedArray.getInt(i5, typedArray.getInt(i6, i7));
    }

    public static boolean e(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, boolean z5) {
        return !p(xmlPullParser, str) ? z5 : typedArray.getBoolean(i5, z5);
    }

    public static int f(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, int i6) {
        return !p(xmlPullParser, str) ? i6 : typedArray.getColor(i5, i6);
    }

    public static ColorStateList g(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i5) {
        if (!p(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i5, typedValue);
        int i6 = typedValue.type;
        if (i6 != 2) {
            return (i6 < 28 || i6 > 31) ? c.d(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme) : h(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i5 + ": " + typedValue);
    }

    private static ColorStateList h(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static d i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i5, int i6) {
        if (p(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i5, typedValue);
            int i7 = typedValue.type;
            if (i7 >= 28 && i7 <= 31) {
                return d.b(typedValue.data);
            }
            d dVarG = d.g(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme);
            if (dVarG != null) {
                return dVarG;
            }
        }
        return d.b(i6);
    }

    public static float j(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, float f5) {
        return !p(xmlPullParser, str) ? f5 : typedArray.getFloat(i5, f5);
    }

    public static int k(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, int i6) {
        return !p(xmlPullParser, str) ? i6 : typedArray.getInt(i5, i6);
    }

    public static int l(TypedArray typedArray, int i5, int i6, int i7) {
        return typedArray.getResourceId(i5, typedArray.getResourceId(i6, i7));
    }

    public static String m(TypedArray typedArray, int i5, int i6) {
        String string = typedArray.getString(i5);
        return string == null ? typedArray.getString(i6) : string;
    }

    public static CharSequence n(TypedArray typedArray, int i5, int i6) {
        CharSequence text = typedArray.getText(i5);
        return text == null ? typedArray.getText(i6) : text;
    }

    public static CharSequence[] o(TypedArray typedArray, int i5, int i6) {
        CharSequence[] textArray = typedArray.getTextArray(i5);
        return textArray == null ? typedArray.getTextArray(i6) : textArray;
    }

    public static boolean p(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray q(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
