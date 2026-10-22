package n;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$attr;
import androidx.core.R$styleable;
import com.ttnet.org.chromium.net.PrivateKeyType;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f22324a = null;

    static {
        f22324a = new ThreadLocal();
    }

    public static ColorStateList a(Resources r10, XmlPullParser r11, Resources.Theme r12) {
        AttributeSet r13 = Xml.asAttributeSet(r11);
    L3:
        int r14 = r11.next();
        if (r14 == 2) goto L8;
        if (r14 != 1) goto L3;
    L8:
        if (r14 != 2) goto L12;
        return b(r10, r11, r13, r12);
    L12:
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        String r14 = r11.getName();
        if (r14.equals("selector") == false) goto L7;
        return d(r10, r11, r12, r13);
    L7:
        throw new XmlPullParserException(r11.getPositionDescription() + ": invalid color state list tag " + r14);
    }

    public static TypedValue c() {
        ThreadLocal r10 = f22324a;
        TypedValue r11 = (TypedValue) r10.get();
        if (r11 != null) goto L6;
        TypedValue r12 = new TypedValue();
        r10.set(r12);
        return r12;
    L6:
        return r11;
    }

    public static ColorStateList d(Resources r17, XmlPullParser r18, AttributeSet r19, Resources.Theme r20) {
        int r10 = 1;
        int r11 = r18.getDepth() + 1;
        int[][] r12 = new int[20][];
        int[] r13 = new int[20];
        int r14 = 0;
    L3:
        int r15 = r18.next();
        if (r15 == r10) goto L53;
        int r16 = r18.getDepth();
        if (r16 >= r11) goto L10;
        if (r15 == 3) goto L53;
    L10:
        if (r15 != 2) goto L52;
        if (r16 > r11) goto L52;
        if (r18.getName().equals("item") == false) goto L52;
        TypedArray r21 = g(r17, r20, r19, R$styleable.ColorStateListItem);
        int r110 = R$styleable.ColorStateListItem_android_color;
        int r111 = r21.getResourceId(r110, -1);
        if (r111 != (-1)) goto L18;
    L22:
        int r112 = r21.getColor(r110, -65281);
    L23:
        int r113 = R$styleable.ColorStateListItem_android_alpha;
        float r114 = 1.0f;
        if (r21.hasValue(r113) == false) goto L26;
        r114 = r21.getFloat(r113, 1.0f);
    L30:
        if (Build.VERSION.SDK_INT < 31) goto L34;
        int r115 = R$styleable.ColorStateListItem_android_lStar;
        if (r21.hasValue(r115) == false) goto L34;
        float r116 = r21.getFloat(r115, -1.0f);
    L35:
        r21.recycle();
        int r22 = r19.getAttributeCount();
        int[] r117 = new int[r22];
        int r118 = 0;
        int r119 = 0;
    L36:
        if (r118 >= r22) goto L51;
        int r23 = r19.getAttributeNameResource(r118);
        if (r23 == 16843173) goto L50;
        if (r23 == 16843551) goto L50;
        if (r23 == R$attr.alpha) goto L50;
        if (r23 == R$attr.lStar) goto L50;
        int r24 = r119 + 1;
        if (r19.getAttributeBooleanValue(r118, false) == true) goto L49;
        r23 = -r23;
    L49:
        r117[r119] = r23;
        r119 = r24;
    L50:
        r118 = r118 + 1;
        goto L36
    L51:
        int[] r25 = StateSet.trimStateSet(r117, r119);
        r13 = d.a(r13, r14, f(r112, r114, r116));
        r12 = (int[][]) d.b(r12, r14, r25);
        r14 = r14 + 1;
    L34:
        r116 = r21.getFloat(R$styleable.ColorStateListItem_lStar, -1.0f);
        goto L35
    L26:
        int r120 = R$styleable.ColorStateListItem_alpha;
        if (r21.hasValue(r120) == false) goto L30;
        r114 = r21.getFloat(r120, 1.0f);
        goto L30
    L18:
        if (e(r17, r111) == true) goto L22;
        r112 = a(r17, r17.getXml(r111), r20).getDefaultColor();     // Catch: Exception -> L21
    L21:
        r112 = r21.getColor(R$styleable.ColorStateListItem_android_color, -65281);
    L52:
        r10 = 1;
    L53:
        int[] r26 = new int[r14];
        int[][] r27 = new int[r14][];
        System.arraycopy(r13, 0, r26, 0, r14);
        System.arraycopy(r12, 0, r27, 0, r14);
        return new ColorStateList(r27, r26);
    }

    public static boolean e(Resources r10, int r11) {
        TypedValue r12 = c();
        r10.getValue(r11, r12, true);
        int r13 = r12.type;
        if (r13 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r13 > 31) goto L7;
        return true;
    }

    public static int f(int r10, float r11, float r12) {
        if (r12 >= 0.0f) goto L5;
    L7:
        boolean r13 = false;
    L9:
        if (r11 != 1.0f) goto L12;
        if (r13 == true) goto L12;
        return r10;
    L12:
        int r14 = p.a.b((int) ((Color.alpha(r10) * r11) + 0.5f), 0, PrivateKeyType.INVALID);
        if (r13 == false) goto L16;
        a r15 = a.c(r10);
        r10 = a.m(r15.j(), r15.i(), r12);
    L16:
        return (r10 & 16777215) | (r14 << 24);
    L5:
        if (r12 > 100.0f) goto L7;
        r13 = true;
        goto L9
    }

    public static TypedArray g(Resources r10, Resources.Theme r11, AttributeSet r12, int[] r13) {
        if (r11 != null) goto L5;
        return r10.obtainAttributes(r12, r13);
    L5:
        return r11.obtainStyledAttributes(r12, r13, 0, 0);
    }
}
