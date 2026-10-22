package s0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$attr;
import androidx.core.R$styleable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import w0.C5715a;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f40013a = new ThreadLocal<>();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    public static TypedValue c() {
        ThreadLocal<TypedValue> threadLocal = f40013a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList d(Resources resources, int i10, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e10);
            return null;
        }
    }

    public static ColorStateList e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int color;
        Resources resources2 = resources;
        int i10 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrA = new int[20];
        int i11 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i10 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayH = h(resources2, theme, attributeSet, R$styleable.ColorStateListItem);
                int i12 = R$styleable.ColorStateListItem_android_color;
                int resourceId = typedArrayH.getResourceId(i12, -1);
                if (resourceId == -1 || f(resources2, resourceId)) {
                    color = typedArrayH.getColor(i12, -65281);
                } else {
                    try {
                        color = a(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = typedArrayH.getColor(R$styleable.ColorStateListItem_android_color, -65281);
                    }
                }
                int i13 = R$styleable.ColorStateListItem_android_alpha;
                float f10 = 1.0f;
                if (typedArrayH.hasValue(i13)) {
                    f10 = typedArrayH.getFloat(i13, 1.0f);
                } else {
                    int i14 = R$styleable.ColorStateListItem_alpha;
                    if (typedArrayH.hasValue(i14)) {
                        f10 = typedArrayH.getFloat(i14, 1.0f);
                    }
                }
                int i15 = R$styleable.ColorStateListItem_android_lStar;
                float f11 = typedArrayH.hasValue(i15) ? typedArrayH.getFloat(i15, -1.0f) : typedArrayH.getFloat(R$styleable.ColorStateListItem_lStar, -1.0f);
                typedArrayH.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i16 = 0;
                for (int i17 = 0; i17 < attributeCount; i17++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i17);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R$attr.alpha && attributeNameResource != R$attr.lStar) {
                        int i18 = i16 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i17, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i16] = attributeNameResource;
                        i16 = i18;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i16);
                iArrA = g.a(iArrA, i11, g(color, f10, f11));
                iArr = (int[][]) g.b(iArr, i11, iArrTrimStateSet);
                i11++;
            }
            i10 = 1;
            resources2 = resources;
        }
        int[] iArr3 = new int[i11];
        int[][] iArr4 = new int[i11][];
        System.arraycopy(iArrA, 0, iArr3, 0, i11);
        System.arraycopy(iArr, 0, iArr4, 0, i11);
        return new ColorStateList(iArr4, iArr3);
    }

    public static boolean f(Resources resources, int i10) throws Resources.NotFoundException {
        TypedValue typedValueC = c();
        resources.getValue(i10, typedValueC, true);
        int i11 = typedValueC.type;
        return i11 >= 28 && i11 <= 31;
    }

    public static int g(int i10, float f10, float f11) {
        boolean z10 = f11 >= 0.0f && f11 <= 100.0f;
        if (f10 == 1.0f && !z10) {
            return i10;
        }
        int iB = C5715a.b((int) ((Color.alpha(i10) * f10) + 0.5f), 0, 255);
        if (z10) {
            C5436a c5436aC = C5436a.c(i10);
            i10 = C5436a.m(c5436aC.j(), c5436aC.i(), f11);
        }
        return (i10 & 16777215) | (iB << 24);
    }

    public static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
