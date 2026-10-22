package androidx.core.content.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: TypedArrayUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public static boolean a(XmlPullParser r2, String r3) {
        if (((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r2, XmlPullParser.class, "com.obric.aiagent.plugin")).getAttributeValue("http://schemas.android.com/apk/res/android", r3) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static float a(TypedArray r2, XmlPullParser r3, String r4, int r5, float r6) {
        if (a((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin"), r4) == true) goto L6;
        return r6;
    L6:
        return r2.getFloat(r5, r6);
    }

    public static boolean a(TypedArray r2, XmlPullParser r3, String r4, int r5, boolean r6) {
        if (a((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin"), r4) == true) goto L6;
        return r6;
    L6:
        return r2.getBoolean(r5, r6);
    }

    public static int a(TypedArray r2, XmlPullParser r3, String r4, int r5, int r6) {
        if (a((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin"), r4) == true) goto L6;
        return r6;
    L6:
        return r2.getInt(r5, r6);
    }

    public static int b(TypedArray r2, XmlPullParser r3, String r4, int r5, int r6) {
        if (a((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin"), r4) == true) goto L6;
        return r6;
    L6:
        return r2.getColor(r5, r6);
    }

    public static d a(TypedArray r2, XmlPullParser r3, Resources.Theme r4, String r5, int r6, int r7) {
        if (a((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin"), r5) == false) goto L14;
        TypedValue r8 = new TypedValue();
        r2.getValue(r6, r8);
        if (r8.type >= 28) goto L7;
    L10:
        d r9 = d.a(ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin"), r2.getResourceId(r6, 0), r4);
        if (r9 == null) goto L14;
        return r9;
    L7:
        if (r8.type > 31) goto L10;
        return d.a(r8.data);
    L14:
        return d.a(r7);
    }

    public static ColorStateList a(TypedArray r2, XmlPullParser r3, Resources.Theme r4, String r5, int r6) {
        if (a((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin"), r5) == false) goto L16;
        TypedValue r7 = new TypedValue();
        r2.getValue(r6, r7);
        if (r7.type == 2) goto L15;
        if (r7.type < 28) goto L13;
        if (r7.type > 31) goto L13;
        return a(r7);
    L13:
        return c.a(ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin"), r2.getResourceId(r6, 0), r4);
    L15:
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + r6 + ": " + r7);
    L16:
        return null;
    }

    private static ColorStateList a(TypedValue r0) {
        return ColorStateList.valueOf(r0.data);
    }

    public static int c(TypedArray r2, XmlPullParser r3, String r4, int r5, int r6) {
        if (a((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin"), r4) == true) goto L6;
        return r6;
    L6:
        return r2.getResourceId(r5, r6);
    }

    public static String a(TypedArray r2, XmlPullParser r3, String r4, int r5) {
        if (a((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin"), r4) == true) goto L7;
        return null;
    L7:
        return r2.getString(r5);
    }

    public static TypedValue b(TypedArray r2, XmlPullParser r3, String r4, int r5) {
        if (a((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin"), r4) == true) goto L7;
        return null;
    L7:
        return r2.peekValue(r5);
    }

    public static TypedArray a(Resources r2, Resources.Theme r3, AttributeSet r4, int[] r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return r2.obtainAttributes(r6, r5);
    L7:
        return r3.obtainStyledAttributes(r6, r5, 0, 0);
    }
}
