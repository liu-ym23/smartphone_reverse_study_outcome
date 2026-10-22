package androidx.core.content.res;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.math.MathUtils;
import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
public final class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> sTempTypedValue = null;

    static {
        sTempTypedValue = new ThreadLocal();
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r100 = sTempTypedValue;
        TypedValue r101 = r100.get();
        if (r101 != null) goto L6;
        TypedValue r102 = new TypedValue();
        r100.set(r102);
        return r102;
    L6:
        return r101;
    }

    private ColorStateListInflaterCompat() {
    }

    private static boolean isColorInt(Resources r100, int r101) {
        TypedValue r102 = getTypedValue();
        r100.getValue(r101, r102, true);
        int r103 = r102.type;
        if (r103 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r103 > 31) goto L7;
        return true;
    }

    public static ColorStateList createFromXml(Resources r100, XmlPullParser r101, Resources.Theme r102) throws XmlPullParserException, IOException {
        AttributeSet r103 = Xml.asAttributeSet(r101);
    L3:
        int r104 = r101.next();
        if (r104 == 2) goto L8;
        if (r104 != 1) goto L3;
    L8:
        if (r104 != 2) goto L12;
        return createFromXmlInner(r100, r101, r103, r102);
    L12:
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList inflate(Resources r100, int r101, Resources.Theme r102) {
        return createFromXml(r100, r100.getXml(r101), r102);
    L4:
        return null;
    }

    private static int modulateColorAlpha(int r100, float r101, float r102) {
        if (r102 >= 0.0f) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r101 != 1.0f) goto L12;
        if (r103 == true) goto L12;
        return r100;
    L12:
        int r104 = MathUtils.clamp((int) ((Color.alpha(r100) * r101) + 0.5f), 0, 255);
        if (r103 == false) goto L16;
        CamColor r105 = CamColor.fromColor(r100);
        r100 = CamColor.toColor(r105.getHue(), r105.getChroma(), r102);
    L16:
        return (r100 & 16777215) | (r104 << 24);
    L5:
        if (r102 > 100.0f) goto L7;
        r103 = true;
        goto L9
    }

    public static ColorStateList createFromXmlInner(Resources r100, XmlPullParser r101, AttributeSet r102, Resources.Theme r103) throws XmlPullParserException, IOException {
        String r104 = r101.getName();
        if (r104.equals("selector") == false) goto L7;
        return inflate(r100, r101, r102, r103);
    L7:
        throw new XmlPullParserException(r101.getPositionDescription() + ": invalid color state list tag " + r104);
    }

    private static ColorStateList inflate(Resources r110, XmlPullParser r111, AttributeSet r112, Resources.Theme r210) throws XmlPullParserException, IOException {
        int r100 = 1;
        int r101 = r111.getDepth() + 1;
        int[][] r102 = new int[20][];
        int[] r103 = new int[20];
        int r104 = 0;
        int r105 = 0;
    L3:
        int r106 = r111.next();
        if (r106 == r100) goto L52;
        int r113 = r111.getDepth();
        if (r113 >= r101) goto L9;
        if (r106 == 3) goto L52;
    L9:
        if (r106 != 2) goto L51;
        if (r113 > r101) goto L51;
        if (r111.getName().equals(MapController.ITEM_LAYER_TAG) == false) goto L51;
        TypedArray r107 = obtainAttributes(r110, r210, r112, new int[]{R.attr.color, R.attr.alpha, R.attr.lStar, com.larus.nova.R.attr.alpha, com.larus.nova.R.attr.lStar});
        int r114 = r107.getResourceId(r104, -1);
        if (r114 != (-1)) goto L17;
    L21:
        int r115 = r107.getColor(r104, FakePickerAvatarCreator.MAGENTA);
    L22:
        float r116 = 1.0f;
        if (r107.hasValue(r100) == false) goto L26;
        r116 = r107.getFloat(r100, 1.0f);
    L29:
        if (Build.VERSION.SDK_INT >= 31) goto L31;
    L33:
        float r117 = r107.getFloat(4, -1.0f);
    L34:
        r107.recycle();
        int r108 = r112.getAttributeCount();
        int[] r118 = new int[r108];
        int r119 = 0;
        int r120 = 0;
    L35:
        if (r119 >= r108) goto L50;
        int r109 = r112.getAttributeNameResource(r119);
        if (r109 == 16843173) goto L49;
        if (r109 == 16843551) goto L49;
        if (r109 == com.larus.nova.R.attr.alpha) goto L49;
        if (r109 == com.larus.nova.R.attr.lStar) goto L49;
        int r121 = r120 + 1;
        if (r112.getAttributeBooleanValue(r119, false) == true) goto L48;
        r109 = -r109;
    L48:
        r118[r120] = r109;
        r120 = r121;
    L49:
        r119 = r119 + 1;
        goto L35
    L50:
        int[] r122 = StateSet.trimStateSet(r118, r120);
        r103 = GrowingArrayUtils.append(r103, r105, modulateColorAlpha(r115, r116, r117));
        r102 = (int[][]) GrowingArrayUtils.append(r102, r105, r122);
        r105 = r105 + 1;
        goto L51
    L31:
        if (r107.hasValue(2) == false) goto L33;
        r117 = r107.getFloat(2, -1.0f);
        goto L34
    L26:
        if (r107.hasValue(3) == false) goto L29;
        r116 = r107.getFloat(3, 1.0f);
        goto L29
    L17:
        if (isColorInt(r110, r114) == true) goto L21;
        r115 = createFromXml(r110, r110.getXml(r114), r210).getDefaultColor();     // Catch: Exception -> L20
    L20:
        r115 = r107.getColor(r104, FakePickerAvatarCreator.MAGENTA);
    L51:
        r100 = 1;
        r104 = 0;
    L52:
        int[] r123 = new int[r105];
        int[][] r124 = new int[r105][];
        System.arraycopy(r103, 0, r123, 0, r105);
        System.arraycopy(r102, 0, r124, 0, r105);
        return new ColorStateList(r124, r123);
    }

    private static TypedArray obtainAttributes(Resources r100, Resources.Theme r101, AttributeSet r102, int[] r103) {
        if (r101 != null) goto L5;
        return r100.obtainAttributes(r102, r103);
    L5:
        return r101.obtainStyledAttributes(r102, r103, 0, 0);
    }
}
