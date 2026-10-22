package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0087\u0002\u001a\r\u0010\u0000\u001a\u00020\t*\u00020\tH\u0086\n\u001a\r\u0010\u0003\u001a\u00020\t*\u00020\tH\u0086\n\u001a\r\u0010\u0004\u001a\u00020\t*\u00020\tH\u0086\n\u001a\r\u0010\u0005\u001a\u00020\t*\u00020\tH\u0086\n\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\tH\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\tH\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0017H\u0087\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0017H\u0087\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0017H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0017H\u0087\n\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0017H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\t*\u00020\u0017H\u0087\b\u001a\u0015\u0010\"\u001a\u00020\u0017*\u00020\t2\u0006\u0010\u001e\u001a\u00020#H\u0087\f\u001a\u0015\u0010\"\u001a\u00020\u0017*\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0087\f\u001a\u0015\u0010\"\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u001e\u001a\u00020#H\u0087\f\u001a\u0015\u0010\"\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0087\f\u001a\u0015\u0010\"\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001e\u001a\u00020#H\u0087\f\u001a\u0015\u0010\"\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0087\f\u001a\r\u0010\u0019\u001a\u00020\t*\u00020$H\u0087\b\"\u0016\u0010\b\u001a\u00020\t*\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\t*\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0016\u0010\u000e\u001a\u00020\t*\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0016\u0010\u0010\u001a\u00020\t*\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b\"\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\t8Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0016\u0010\b\u001a\u00020\u0001*\u00020\u00178Ç\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u0018\"\u0016\u0010\f\u001a\u00020\u0001*\u00020\u00178Ç\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u0018\"\u0016\u0010\u000e\u001a\u00020\u0001*\u00020\u00178Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0018\"\u0016\u0010\u0010\u001a\u00020\u0001*\u00020\u00178Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0018\"\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00178Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0018\"\u0016\u0010\u001a\u001a\u00020\u001b*\u00020\u00178Ç\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c\"\u0016\u0010\u001d\u001a\u00020\u001b*\u00020\u00178Ç\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001c\"\u0016\u0010\u001e\u001a\u00020\u001f*\u00020\u00178Ç\u0002¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"component1", "", "Landroid/graphics/Color;", "component2", "component3", "component4", "plus", "c", "alpha", "", "getAlpha", "(I)I", "red", "getRed", "green", "getGreen", "blue", "getBlue", "luminance", "getLuminance", "(I)F", "toColor", "toColorLong", "", "(J)F", "toColorInt", "isSrgb", "", "(J)Z", "isWideGamut", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "convertTo", "Landroid/graphics/ColorSpace$Named;", "", "core-ktx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ColorKt {
    public static final int component1(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    public static final int component2(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    public static final int component3(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    public static final int component4(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, ColorSpace.Named named) {
        return Color.convert(i, ColorSpace.get(named));
    }

    public static final int getAlpha(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    public static final int getBlue(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    public static final ColorSpace getColorSpace(long j5) {
        return Color.colorSpace(j5);
    }

    public static final int getGreen(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i) {
        return Color.luminance(i);
    }

    public static final int getRed(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j5) {
        return Color.isSrgb(j5);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j5) {
        return Color.isWideGamut(j5);
    }

    @RequiresApi(26)
    public static final Color plus(Color color, Color color2) {
        return ColorUtils.compositeColors(color2, color);
    }

    @RequiresApi(26)
    public static final Color toColor(@ColorInt int i) {
        return Color.valueOf(i);
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j5) {
        return Color.toArgb(j5);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i) {
        return Color.pack(i);
    }

    @RequiresApi(26)
    public static final float component1(Color color) {
        return color.getComponent(0);
    }

    @RequiresApi(26)
    public static final float component2(Color color) {
        return color.getComponent(1);
    }

    @RequiresApi(26)
    public static final float component3(Color color) {
        return color.getComponent(2);
    }

    @RequiresApi(26)
    public static final float component4(Color color) {
        return color.getComponent(3);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, ColorSpace colorSpace) {
        return Color.convert(i, colorSpace);
    }

    @RequiresApi(26)
    public static final float getAlpha(long j5) {
        return Color.alpha(j5);
    }

    @RequiresApi(26)
    public static final float getBlue(long j5) {
        return Color.blue(j5);
    }

    @RequiresApi(26)
    public static final float getGreen(long j5) {
        return Color.green(j5);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j5) {
        return Color.luminance(j5);
    }

    @RequiresApi(26)
    public static final float getRed(long j5) {
        return Color.red(j5);
    }

    @RequiresApi(26)
    public static final Color toColor(long j5) {
        return Color.valueOf(j5);
    }

    @ColorInt
    public static final int toColorInt(String str) {
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    public static final float component1(long j5) {
        return Color.red(j5);
    }

    @RequiresApi(26)
    public static final float component2(long j5) {
        return Color.green(j5);
    }

    @RequiresApi(26)
    public static final float component3(long j5) {
        return Color.blue(j5);
    }

    @RequiresApi(26)
    public static final float component4(long j5) {
        return Color.alpha(j5);
    }

    @RequiresApi(26)
    public static final long convertTo(long j5, ColorSpace.Named named) {
        return Color.convert(j5, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final long convertTo(long j5, ColorSpace colorSpace) {
        return Color.convert(j5, colorSpace);
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace.Named named) {
        return color.convert(ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace colorSpace) {
        return color.convert(colorSpace);
    }
}
