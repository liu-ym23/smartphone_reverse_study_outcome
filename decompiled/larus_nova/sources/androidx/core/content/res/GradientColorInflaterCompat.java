package androidx.core.content.res;

import android.R;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFFeatureEffect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
final class GradientColorInflaterCompat {
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;

    public static final class ColorStops {
        final int[] mColors;
        final float[] mOffsets;

        public ColorStops(List<Integer> r100, List<Float> r101) {
            int r102 = r100.size();
            this.mColors = new int[r102];
            this.mOffsets = new float[r102];
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            this.mColors[r103] = ((Integer) ListProtector.get(r100, r103)).intValue();
            this.mOffsets[r103] = ((Float) ListProtector.get(r101, r103)).floatValue();
            r103 = r103 + 1;
            goto L3
        }

        public ColorStops(int r100, int r101) {
            this.mColors = new int[]{r100, r101};
            this.mOffsets = new float[]{0.0f, 1.0f};
        }

        public ColorStops(int r100, int r101, int r102) {
            this.mColors = new int[]{r100, r101, r102};
            this.mOffsets = new float[]{0.0f, 0.5f, 1.0f};
        }
    }

    private GradientColorInflaterCompat() {
    }

    private static Shader.TileMode parseTileMode(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return Shader.TileMode.CLAMP;
    L9:
        return Shader.TileMode.MIRROR;
    L11:
        return Shader.TileMode.REPEAT;
    }

    public static Shader createFromXml(Resources r100, XmlPullParser r101, Resources.Theme r102) throws XmlPullParserException, IOException {
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

    public static Shader createFromXmlInner(Resources r210, XmlPullParser r211, AttributeSet r212, Resources.Theme r213) throws IOException, XmlPullParserException {
        String r100 = r211.getName();
        if (r100.equals(KFFeatureEffect.GRADIENT_JSON_FIELD) == false) goto L19;
        TypedArray r101 = TypedArrayUtils.obtainAttributes(r210, r213, r212, new int[]{R.attr.startColor, R.attr.endColor, R.attr.type, R.attr.centerX, R.attr.centerY, R.attr.gradientRadius, R.attr.tileMode, R.attr.centerColor, R.attr.startX, R.attr.startY, R.attr.endX, R.attr.endY});
        float r102 = TypedArrayUtils.getNamedFloat(r101, r211, "startX", 8, 0.0f);
        float r110 = TypedArrayUtils.getNamedFloat(r101, r211, "startY", 9, 0.0f);
        float r111 = TypedArrayUtils.getNamedFloat(r101, r211, "endX", 10, 0.0f);
        float r112 = TypedArrayUtils.getNamedFloat(r101, r211, "endY", 11, 0.0f);
        float r113 = TypedArrayUtils.getNamedFloat(r101, r211, "centerX", 3, 0.0f);
        float r114 = TypedArrayUtils.getNamedFloat(r101, r211, "centerY", 4, 0.0f);
        int r103 = TypedArrayUtils.getNamedInt(r101, r211, "type", 2, 0);
        int r115 = TypedArrayUtils.getNamedColor(r101, r211, "startColor", 0, 0);
        boolean r104 = TypedArrayUtils.hasAttribute(r211, "centerColor");
        int r105 = TypedArrayUtils.getNamedColor(r101, r211, "centerColor", 7, 0);
        int r106 = TypedArrayUtils.getNamedColor(r101, r211, "endColor", 1, 0);
        int r107 = TypedArrayUtils.getNamedInt(r101, r211, "tileMode", 6, 0);
        float r108 = TypedArrayUtils.getNamedFloat(r101, r211, "gradientRadius", 5, 0.0f);
        r101.recycle();
        ColorStops r109 = checkColors(inflateChildElements(r210, r211, r212, r213), r115, r106, r104, r105);
        if (r103 == 1) goto L13;
        if (r103 == 2) goto L11;
        return new LinearGradient(r102, r110, r111, r112, r109.mColors, r109.mOffsets, parseTileMode(r107));
    L11:
        return new SweepGradient(r113, r114, r109.mColors, r109.mOffsets);
    L13:
        if (r108 <= 0.0f) goto L17;
        return new RadialGradient(r113, r114, r108, r109.mColors, r109.mOffsets, parseTileMode(r107));
    L17:
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    L19:
        throw new XmlPullParserException(r211.getPositionDescription() + ": invalid gradient color tag " + r100);
    }

    private static ColorStops inflateChildElements(Resources r100, XmlPullParser r101, AttributeSet r110, Resources.Theme r111) throws XmlPullParserException, IOException {
        int r102 = r101.getDepth() + 1;
        ArrayList r103 = new ArrayList(20);
        ArrayList r104 = new ArrayList(20);
    L3:
        int r105 = r101.next();
        if (r105 == 1) goto L23;
        int r106 = r101.getDepth();
        if (r106 >= r102) goto L10;
        if (r105 == 3) goto L23;
    L10:
        if (r105 != 2) goto L3;
        if (r106 > r102) goto L3;
        if (r101.getName().equals(MapController.ITEM_LAYER_TAG) == false) goto L3;
        TypedArray r107 = TypedArrayUtils.obtainAttributes(r100, r111, r110, new int[]{R.attr.color, R.attr.offset});
        boolean r108 = r107.hasValue(0);
        boolean r109 = r107.hasValue(1);
        if (r108 == false) goto L21;
        if (r109 == false) goto L21;
        int r112 = r107.getColor(0, 0);
        float r113 = r107.getFloat(1, 0.0f);
        r107.recycle();
        r104.add(Integer.valueOf(r112));
        r103.add(Float.valueOf(r113));
    L21:
        throw new XmlPullParserException(r101.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
    L23:
        if (r104.size() > 0) goto L25;
        return null;
    L25:
        return new ColorStops(r104, r103);
    }

    private static ColorStops checkColors(ColorStops r100, int r101, int r102, boolean r103, int r104) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        if (r103 == false) goto L8;
        return new ColorStops(r101, r104, r102);
    L8:
        return new ColorStops(r101, r102);
    }
}
