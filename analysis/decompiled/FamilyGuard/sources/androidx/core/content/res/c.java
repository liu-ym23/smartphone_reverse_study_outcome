package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import z.C1329a;
import z.C1334f;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f9600a = new ThreadLocal<>();

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

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedValue c() {
        ThreadLocal<TypedValue> threadLocal = f9600a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList d(Resources resources, int i5, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i5), theme);
        } catch (Exception e6) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e6);
            return null;
        }
    }

    private static ColorStateList e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int color;
        Resources resources2 = resources;
        int i5 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrA = new int[20];
        int i6 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i5 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayH = h(resources2, theme, attributeSet, C1334f.f24005b);
                int i7 = C1334f.f24006c;
                int resourceId = typedArrayH.getResourceId(i7, -1);
                if (resourceId == -1 || f(resources2, resourceId)) {
                    color = typedArrayH.getColor(i7, -65281);
                } else {
                    try {
                        color = a(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = typedArrayH.getColor(C1334f.f24006c, -65281);
                    }
                }
                int i8 = C1334f.f24007d;
                float f5 = 1.0f;
                if (typedArrayH.hasValue(i8)) {
                    f5 = typedArrayH.getFloat(i8, 1.0f);
                } else {
                    int i9 = C1334f.f24009f;
                    if (typedArrayH.hasValue(i9)) {
                        f5 = typedArrayH.getFloat(i9, 1.0f);
                    }
                }
                int i10 = C1334f.f24008e;
                float f6 = typedArrayH.hasValue(i10) ? typedArrayH.getFloat(i10, -1.0f) : typedArrayH.getFloat(C1334f.f24010g, -1.0f);
                typedArrayH.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i11 = 0;
                for (int i12 = 0; i12 < attributeCount; i12++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i12);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != C1329a.f23935a && attributeNameResource != C1329a.f23936b) {
                        int i13 = i11 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i12, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i11] = attributeNameResource;
                        i11 = i13;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i11);
                iArrA = g.a(iArrA, i6, g(color, f5, f6));
                iArr = (int[][]) g.b(iArr, i6, iArrTrimStateSet);
                i6++;
            }
            i5 = 1;
            resources2 = resources;
        }
        int[] iArr3 = new int[i6];
        int[][] iArr4 = new int[i6][];
        System.arraycopy(iArrA, 0, iArr3, 0, i6);
        System.arraycopy(iArr, 0, iArr4, 0, i6);
        return new ColorStateList(iArr4, iArr3);
    }

    private static boolean f(Resources resources, int i5) throws Resources.NotFoundException {
        TypedValue typedValueC = c();
        resources.getValue(i5, typedValueC, true);
        int i6 = typedValueC.type;
        return i6 >= 28 && i6 <= 31;
    }

    private static int g(int i5, float f5, float f6) {
        boolean z5 = f6 >= 0.0f && f6 <= 100.0f;
        if (f5 == 1.0f && !z5) {
            return i5;
        }
        int iB = B.a.b((int) ((Color.alpha(i5) * f5) + 0.5f), 0, 255);
        if (z5) {
            a aVarC = a.c(i5);
            i5 = a.m(aVarC.j(), aVarC.i(), f6);
        }
        return (i5 & 16777215) | (iB << 24);
    }

    private static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
