package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001f\u001a\u00020\u0019*\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0087\u0002\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0001H\u0087\b\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020#H\u0087\b\u001a\r\u0010$\u001a\u00020\u0005*\u00020\u0001H\u0087\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0000\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\"\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00018Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006\"\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006¨\u0006%"}, d2 = {"alpha", "", "getAlpha", "(I)I", "", "", "(J)F", "blue", "getBlue", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "green", "getGreen", "isSrgb", "", "(J)Z", "isWideGamut", "luminance", "getLuminance", "(I)F", "red", "getRed", "component1", "Landroid/graphics/Color;", "component2", "component3", "component4", "convertTo", "Landroid/graphics/ColorSpace$Named;", "plus", "c", "toColor", "toColorInt", "", "toColorLong", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorKt {
    public static final int component1(int r100) {
        return (r100 >> 24) & 255;
    }

    public static final int component2(int r100) {
        return (r100 >> 16) & 255;
    }

    public static final int component3(int r100) {
        return (r100 >> 8) & 255;
    }

    public static final int component4(int r100) {
        return r100 & 255;
    }

    public static final int getAlpha(int r100) {
        return (r100 >> 24) & 255;
    }

    public static final int getBlue(int r100) {
        return r100 & 255;
    }

    public static final int getGreen(int r100) {
        return (r100 >> 8) & 255;
    }

    public static final int getRed(int r100) {
        return (r100 >> 16) & 255;
    }

    public static final float component1(Color r100) {
        return r100.getComponent(0);
    }

    public static final float component2(Color r100) {
        return r100.getComponent(1);
    }

    public static final float component3(Color r100) {
        return r100.getComponent(2);
    }

    public static final float component4(Color r100) {
        return r100.getComponent(3);
    }

    public static final float getAlpha(long r100) {
        return Color.alpha(r100);
    }

    public static final float getBlue(long r100) {
        return Color.blue(r100);
    }

    public static final ColorSpace getColorSpace(long r100) {
        return Color.colorSpace(r100);
    }

    public static final float getGreen(long r100) {
        return Color.green(r100);
    }

    public static final float getLuminance(int r100) {
        return Color.luminance(r100);
    }

    public static final float getRed(long r100) {
        return Color.red(r100);
    }

    public static final boolean isSrgb(long r100) {
        return Color.isSrgb(r100);
    }

    public static final boolean isWideGamut(long r100) {
        return Color.isWideGamut(r100);
    }

    public static final Color toColor(int r100) {
        return Color.valueOf(r100);
    }

    public static final int toColorInt(long r100) {
        return Color.toArgb(r100);
    }

    public static final long toColorLong(int r100) {
        return Color.pack(r100);
    }

    public static final float component1(long r100) {
        return Color.red(r100);
    }

    public static final float component2(long r100) {
        return Color.green(r100);
    }

    public static final float component3(long r100) {
        return Color.blue(r100);
    }

    public static final float component4(long r100) {
        return Color.alpha(r100);
    }

    public static final float getLuminance(long r100) {
        return Color.luminance(r100);
    }

    public static final Color toColor(long r100) {
        return Color.valueOf(r100);
    }

    public static final int toColorInt(String r100) {
        return ColorProtector.parseColor(r100);
    }

    public static final long convertTo(int r100, ColorSpace.Named r101) {
        return Color.convert(r100, ColorSpace.get(r101));
    }

    public static final Color plus(Color r100, Color r101) {
        return ColorUtils.compositeColors(r101, r100);
    }

    public static final long convertTo(long r100, ColorSpace.Named r101) {
        return Color.convert(r100, ColorSpace.get(r101));
    }

    public static final Color convertTo(Color r100, ColorSpace.Named r101) {
        return r100.convert(ColorSpace.get(r101));
    }

    public static final long convertTo(int r100, ColorSpace r101) {
        return Color.convert(r100, r101);
    }

    public static final long convertTo(long r100, ColorSpace r101) {
        return Color.convert(r100, r101);
    }

    public static final Color convertTo(Color r100, ColorSpace r101) {
        return r100.convert(r101);
    }
}
