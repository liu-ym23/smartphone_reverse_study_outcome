package w;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final float[][] f6044a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: b, reason: collision with root package name */
    public static final float[][] f6045b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f6046c = {95.047f, 100.0f, 108.883f};
    public static final float[][] d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    public static int b(float f3) {
        if (f3 < 1.0f) {
            return -16777216;
        }
        if (f3 > 99.0f) {
            return -1;
        }
        float f7 = (f3 + 16.0f) / 116.0f;
        float f9 = f3 > 8.0f ? f7 * f7 * f7 : f3 / 903.2963f;
        float f10 = f7 * f7 * f7;
        boolean z = f10 > 0.008856452f;
        float f11 = z ? f10 : ((f7 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f10 = ((f7 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f6046c;
        return x.a.a(f11 * fArr[0], f9 * fArr[1], f10 * fArr[2]);
    }

    public static float c(int i8) {
        float f3 = i8 / 255.0f;
        return (f3 <= 0.04045f ? f3 / 12.92f : (float) Math.pow((f3 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static d f(XmlResourceParser xmlResourceParser, Resources resources) throws Throwable {
        int next;
        int i8;
        int i9;
        int i10;
        TypedArray typedArray;
        Throwable th;
        do {
            next = xmlResourceParser.next();
            i8 = 2;
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlResourceParser.require(2, null, "font-family");
        if (!xmlResourceParser.getName().equals("font-family")) {
            h(xmlResourceParser);
            return null;
        }
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), u.a.f5613b);
        int i11 = 0;
        String string = typedArrayObtainAttributes.getString(0);
        String string2 = typedArrayObtainAttributes.getString(5);
        String string3 = typedArrayObtainAttributes.getString(6);
        String string4 = typedArrayObtainAttributes.getString(2);
        int resourceId = typedArrayObtainAttributes.getResourceId(1, 0);
        int i12 = 3;
        int integer = typedArrayObtainAttributes.getInteger(3, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(4, 500);
        String string5 = typedArrayObtainAttributes.getString(7);
        typedArrayObtainAttributes.recycle();
        if (string == null || string2 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlResourceParser.next() != 3) {
                if (xmlResourceParser.getEventType() == 2) {
                    if (xmlResourceParser.getName().equals("font")) {
                        TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), u.a.f5614c);
                        int i13 = typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(8) ? 8 : 1, 400);
                        boolean z = 1 == typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(6) ? 6 : 2, 0);
                        int i14 = typedArrayObtainAttributes2.hasValue(9) ? 9 : 3;
                        String string6 = typedArrayObtainAttributes2.getString(typedArrayObtainAttributes2.hasValue(7) ? 7 : 4);
                        int i15 = typedArrayObtainAttributes2.getInt(i14, 0);
                        int i16 = typedArrayObtainAttributes2.hasValue(5) ? 5 : 0;
                        int resourceId2 = typedArrayObtainAttributes2.getResourceId(i16, 0);
                        String string7 = typedArrayObtainAttributes2.getString(i16);
                        typedArrayObtainAttributes2.recycle();
                        while (xmlResourceParser.next() != 3) {
                            h(xmlResourceParser);
                        }
                        arrayList.add(new f(i13, i15, resourceId2, string7, string6, z));
                    } else {
                        h(xmlResourceParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new e((f[]) arrayList.toArray(new f[0]));
        }
        List listG = g(resources, resourceId);
        ArrayList arrayList2 = new ArrayList();
        while (xmlResourceParser.next() != i12) {
            if (xmlResourceParser.getEventType() == i8) {
                if (xmlResourceParser.getName().equals("fallback")) {
                    TypedArray typedArrayObtainAttributes3 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), u.a.d);
                    try {
                        String string8 = typedArrayObtainAttributes3.getString(i11);
                        String string9 = typedArrayObtainAttributes3.getString(1);
                        i10 = integer;
                        String string10 = typedArrayObtainAttributes3.getString(i8);
                        if (string8 == null) {
                            typedArray = typedArrayObtainAttributes3;
                            throw new XmlPullParserException("query attribute must be set in fallback element");
                        }
                        while (xmlResourceParser.next() != i12) {
                            try {
                                h(xmlResourceParser);
                            } catch (Throwable th2) {
                                th = th2;
                                typedArray = typedArrayObtainAttributes3;
                            }
                        }
                        try {
                            typedArray = typedArrayObtainAttributes3;
                            i9 = i12;
                            try {
                                b0.e eVar = new b0.e(string, string2, string8, listG, string9, string10);
                                typedArray.close();
                                arrayList2.add(eVar);
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            typedArray = typedArrayObtainAttributes3;
                        }
                        th = th3;
                    } catch (Throwable th5) {
                        th = th5;
                        typedArray = typedArrayObtainAttributes3;
                    }
                    th = th;
                    if (typedArray == null) {
                        throw th;
                    }
                    try {
                        typedArray.close();
                        throw th;
                    } catch (Throwable th6) {
                        th.addSuppressed(th6);
                        throw th;
                    }
                }
                i9 = i12;
                i10 = integer;
                h(xmlResourceParser);
                i12 = i9;
                integer = i10;
                i8 = 2;
                i11 = 0;
            }
        }
        int i17 = integer;
        if (!arrayList2.isEmpty()) {
            return new g(arrayList2, i17, integer2, string5);
        }
        if (string3 == null) {
            throw new IllegalArgumentException("The provider font XML requires query attribute or fallback children.");
        }
        arrayList2.add(new b0.e(string, string2, string3, listG, null, null));
        if (string4 != null) {
            arrayList2.add(new b0.e(string, string2, string4, listG, null, null));
        }
        return new g(arrayList2, i17, integer2, string5);
    }

    public static List g(Resources resources, int i8) throws Resources.NotFoundException {
        if (i8 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i8);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i9 = 0; i9 < typedArrayObtainTypedArray.length(); i9++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i9, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i8);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static void h(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i8 = 1;
        while (i8 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i8++;
            } else if (next == 3) {
                i8--;
            }
        }
    }

    public static float i() {
        return ((float) Math.pow((50.0f + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public void a(int i8) {
        new Handler(Looper.getMainLooper()).post(new u1.c(this, i8, 1));
    }

    public abstract void d(int i8);

    public abstract void e(Typeface typeface);
}
