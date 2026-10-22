package android.content.res.stepostheme.iconfilter.filters;

import android.content.res.stepostheme.iconfilter.utils.ColorUtils;
import android.content.res.stepostheme.iconfilter.utils.ConstrainUtils;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.display.StepOSDisplayManager;

/* loaded from: classes.dex */
public class HueSaturationBrightnessFilter extends BaseFilter {
    private static final int FLAG_HUE_ADJUST = 1;
    private static final int FLAG_HUE_MODIFY = 8;
    private static final int FLAG_LUM_ADJUST = 4;
    private static final int FLAG_LUM_MODIFY = 32;
    private static final int FLAG_SATURATION_ADJUST = 2;
    private static final int FLAG_SATURATION_MODIFY = 16;
    private int mFlag = 0;
    private float mHueAdjust;
    private float mHueModify;
    private float mLumAdjust;
    private float mLumModify;
    private float mSaturationAdjust;
    private float mSaturationModify;

    public void setHueAdjust(int hueAdjust) {
        this.mFlag |= 1;
        this.mHueAdjust = ConstrainUtils.constrain(hueAdjust, -180, 180);
    }

    public void setSaturationAdjust(int saturationAdjust) {
        this.mFlag |= 2;
        this.mSaturationAdjust = (ConstrainUtils.constrain(saturationAdjust, -100, 100) * 1.0f) / 100.0f;
    }

    public void setLumAdjust(int lumAdjust) {
        this.mFlag |= 4;
        this.mLumAdjust = (ConstrainUtils.constrain(lumAdjust, -100, 100) * 1.0f) / 100.0f;
    }

    public void setHueModify(int hueModify) {
        this.mFlag |= 8;
        this.mHueModify = ConstrainUtils.constrain(hueModify, 0, 360);
    }

    public void setSaturationModify(int saturationModify) {
        this.mFlag |= 16;
        this.mSaturationModify = (ConstrainUtils.constrain(saturationModify, 0, 100) * 1.0f) / 100.0f;
    }

    public void setLumModify(int lumModify) {
        this.mFlag |= 32;
        this.mLumModify = (ConstrainUtils.constrain(lumModify, -100, 100) * 1.0f) / 100.0f;
    }

    @Override // android.content.res.stepostheme.iconfilter.filters.BaseFilter
    public Bitmap filter(Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        if (this.mFlag == 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int position = (y * width) + x;
                float[] hsl = new float[3];
                int alpha = Color.alpha(pixels[position]);
                ColorUtils.colorToHSL(pixels[position], hsl);
                adjustOrModify(hsl);
                pixels[position] = ColorUtils.HSLToColor(hsl);
                pixels[position] = (adjustLum(pixels[position]) & 16777215) | (alpha << 24);
            }
        }
        return Bitmap.createBitmap(pixels, width, height, Bitmap.Config.ARGB_8888);
    }

    private void adjustOrModify(float[] hsl) {
        adjustHsl(hsl);
        modifyHsl(hsl);
    }

    private void adjustHsl(float[] hsl) {
        if ((this.mFlag & 1) == 1) {
            hsl[0] = hsl[0] + this.mHueAdjust;
            hsl[0] = ConstrainUtils.constrainLoop(hsl[0], 0.0f, 360.0f);
        }
        if ((this.mFlag & 2) == 2) {
            hsl[1] = hsl[1] + this.mSaturationAdjust;
            hsl[1] = ConstrainUtils.constrain(hsl[1], 0.0f, 1.0f);
        }
    }

    private void modifyHsl(float[] hsl) {
        if ((this.mFlag & 8) == 8) {
            hsl[0] = this.mHueModify;
            hsl[0] = ConstrainUtils.constrainLoop(hsl[0], 0.0f, 360.0f);
        }
        if ((this.mFlag & 16) == 16) {
            hsl[1] = this.mSaturationModify;
            hsl[1] = ConstrainUtils.constrain(hsl[1], 0.0f, 1.0f);
        }
        if ((this.mFlag & 32) == 32) {
            hsl[2] = this.mLumModify;
            hsl[2] = ConstrainUtils.constrain(hsl[2], 0.0f, 1.0f);
        }
    }

    private int adjustLum(int color) {
        if ((this.mFlag & 4) == 4 && (this.mFlag & 32) != 32) {
            int r = Color.red(color);
            int g = Color.green(color);
            int b = Color.blue(color);
            return Color.rgb(adjustColorChannelLum(r), adjustColorChannelLum(g), adjustColorChannelLum(b));
        }
        return color;
    }

    private int adjustColorChannelLum(int c) {
        if (this.mLumAdjust > 0.0f) {
            c += (int) (((255 - c) * this.mLumAdjust) + 0.5f);
        } else if (this.mLumAdjust < 0.0f) {
            c += (int) ((c * this.mLumAdjust) + 0.5f);
        }
        return ConstrainUtils.constrain(c, 0, StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX);
    }
}
