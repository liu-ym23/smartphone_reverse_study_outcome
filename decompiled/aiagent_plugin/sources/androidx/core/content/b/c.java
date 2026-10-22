package androidx.core.content.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ColorStateListInflaterCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f1160a = null;

    static {
        f1160a = new ThreadLocal();
    }

    public static ColorStateList a(Resources r0, int r1, Resources.Theme r2) {
        return a(r0, r0.getXml(r1), r2);
    L4:
        e = move-exception;
        a("CSLCompat", "Failed to inflate ColorStateList.", e);
        return null;
    }

    public static ColorStateList a(Resources r4, XmlPullParser r5, Resources.Theme r6) {
        XmlPullParser r7 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r5, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r0 = Xml.asAttributeSet(r7);
    L3:
        int r1 = r7.next();
        if (r1 == 2) goto L8;
        if (r1 != 1) goto L3;
    L8:
        if (r1 != 2) goto L12;
        return a(r4, r7, r0, r6);
    L12:
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList a(Resources r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
        XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        String r0 = r6.getName();
        if (r0.equals("selector") == false) goto L7;
        return b(r2, r6, r7, r5);
    L7:
        throw new XmlPullParserException(r6.getPositionDescription() + ": invalid color state list tag " + r0);
    }

    private static ColorStateList b(Resources r18, XmlPullParser r19, AttributeSet r20, Resources.Theme r21) {
        r18 = r18;
        r21 = r21;
        XmlPullParser r2 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r19, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r20, AttributeSet.class, "com.obric.aiagent.plugin");
        int r6 = 1;
        int r5 = r2.getDepth() + 1;
        int[][] r8 = new int[20][];
        int[] r7 = new int[20];
        int r10 = 0;
    L3:
        int r11 = r2.next();
        if (r11 == r6) goto L55;
        int r12 = r2.getDepth();
        if (r12 >= r5) goto L10;
        if (r11 == 3) goto L55;
    L10:
        if (r11 != 2) goto L53;
        if (r12 > r5) goto L53;
        if (r2.getName().equals("item") == false) goto L53;
        TypedArray r13 = a(r18, r21, r4, R.styleable.ColorStateListItem);
        int r14 = r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_android_color, "styleable", "ColorStateListItem_android_color"), -1);
        if (r14 != (-1)) goto L18;
    L22:
        int r9 = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_android_color, "styleable", "ColorStateListItem_android_color"), -65281);
    L23:
        float r15 = 1.0f;
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_android_alpha, "styleable", "ColorStateListItem_android_alpha")) == false) goto L27;
        r15 = r13.getFloat(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_android_alpha, "styleable", "ColorStateListItem_android_alpha"), 1.0f);
    L30:
        if (Build.VERSION.SDK_INT >= 31) goto L32;
    L34:
        float r16 = r13.getFloat(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_lStar, "styleable", "ColorStateListItem_lStar"), -1.0f);
    L35:
        r13.recycle();
        int r17 = r4.getAttributeCount();
        int[] r110 = new int[r17];
        int r111 = 0;
        int r112 = 0;
    L36:
        if (r111 >= r17) goto L52;
        int r0 = r4.getAttributeNameResource(r111);
        if (r0 != 16843173) goto L40;
    L50:
        XmlPullParser r113 = r2;
        int r114 = r5;
    L51:
        r111 = r111 + 1;
        r2 = r113;
        r5 = r114;
        goto L36
    L40:
        if (r0 == 16843551) goto L50;
        r113 = r2;
        r114 = r5;
        if (r0 == ZeusTransformUtils.mapRes(R.attr.alpha, "attr", "alpha")) goto L51;
        if (r0 == ZeusTransformUtils.mapRes(R.attr.lStar, "attr", "lStar")) goto L51;
        int r1 = r112 + 1;
        if (r4.getAttributeBooleanValue(r111, false) == true) goto L49;
        r0 = -r0;
    L49:
        r110[r112] = r0;
        r112 = r1;
        goto L51
    L52:
        int[] r3 = StateSet.trimStateSet(r110, r112);
        r7 = g.a(r7, r10, a(r9, r15, r16));
        r8 = (int[][]) ZeusTransformUtils.preCheckCast(g.a(r8, r10, r3), int[][].class, "com.obric.aiagent.plugin");
        r10 = r10 + 1;
    L54:
        r6 = 1;
        goto L3
    L32:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_android_lStar, "styleable", "ColorStateListItem_android_lStar")) == false) goto L34;
        r16 = r13.getFloat(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_android_lStar, "styleable", "ColorStateListItem_android_lStar"), -1.0f);
        goto L35
    L27:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_alpha, "styleable", "ColorStateListItem_alpha")) == false) goto L30;
        r15 = r13.getFloat(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_alpha, "styleable", "ColorStateListItem_alpha"), 1.0f);
        goto L30
    L18:
        if (a(r18, r14) == true) goto L22;
        r9 = a(r18, r18.getXml(r14), r21).getDefaultColor();     // Catch: Exception -> L21
    L21:
        r9 = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.ColorStateListItem_android_color, "styleable", "ColorStateListItem_android_color"), -65281);
    L53:
        r2 = r2;
        r5 = r5;
    L55:
        int[] r22 = new int[r10];
        int[][] r23 = new int[r10][];
        System.arraycopy(r7, 0, r22, 0, r10);
        System.arraycopy(r8, 0, r23, 0, r10);
        return new ColorStateList(r23, r22);
    }

    private static boolean a(Resources r2, int r3) {
        TypedValue r0 = a();
        r2.getValue(r3, r0, true);
        if (r0.type >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r0.type > 31) goto L7;
        return true;
    }

    private static TypedValue a() {
        ThreadLocal<TypedValue> r0 = f1160a;
        TypedValue r1 = (TypedValue) ZeusTransformUtils.preCheckCast(r0.get(), TypedValue.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        TypedValue r2 = new TypedValue();
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }

    private static TypedArray a(Resources r2, Resources.Theme r3, AttributeSet r4, int[] r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L6;
        return r2.obtainAttributes(r6, r5);
    L6:
        return r3.obtainStyledAttributes(r6, r5, 0, 0);
    }

    private static int a(int r3, float r4, float r5) {
        if (r5 >= 0.0f) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r4 != 1.0f) goto L12;
        if (r0 == true) goto L12;
        return r3;
    L12:
        int r6 = androidx.core.a.a.a((int) ((Color.alpha(r3) * r4) + 0.5f), 0, 255);
        if (r0 == false) goto L16;
        a r7 = a.a(r3);
        r3 = a.a(r7.a(), r7.b(), r5);
    L16:
        return (r3 & 16777215) | (r6 << 24);
    L5:
        if (r5 > 100.0f) goto L7;
        r0 = true;
        goto L9
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
