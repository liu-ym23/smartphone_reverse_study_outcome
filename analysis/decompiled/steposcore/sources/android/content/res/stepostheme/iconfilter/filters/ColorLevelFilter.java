package android.content.res.stepostheme.iconfilter.filters;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.display.StepOSDisplayManager;

/* loaded from: classes.dex */
public class ColorLevelFilter extends BaseFilter {
    public static final int FLAG_B = 4;
    public static final int FLAG_G = 2;
    public static final int FLAG_R = 1;
    public static final int FLAG_RGB = 7;
    private int mFlag = 7;
    private int[] mLevelTable = new int[256];

    public void setFlag(int flag) {
        this.mFlag = flag;
    }

    public void setParams(int inputMin, float inputMiddle, int inputMax, int outputMin, int outputMax) {
        int value;
        if (inputMin > 253) {
            inputMin = 253;
        }
        if (inputMin < 0) {
            inputMin = 0;
        }
        if (inputMax > 255) {
            inputMax = StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        }
        if (inputMax < 2) {
            inputMax = 2;
        }
        if (inputMiddle > 9.99f) {
            inputMiddle = 9.99f;
        }
        if (inputMiddle <= 0.0f) {
            inputMiddle = 0.01f;
        }
        if (outputMin < 0) {
            outputMin = 0;
        }
        if (outputMin > 255) {
            outputMin = StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        }
        if (outputMax < 0) {
            outputMax = 0;
        }
        if (outputMax > 255) {
            outputMax = StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        }
        float gamma = 1.0f / inputMiddle;
        for (int i = 0; i < 256; i++) {
            if (i <= inputMin) {
                value = outputMin;
            } else if (i >= inputMax) {
                value = outputMax;
            } else {
                int value2 = i - inputMin;
                float normalized = value2 / (inputMax - inputMin);
                float corrected = (float) Math.pow(normalized, gamma);
                value = (int) (outputMin + ((outputMax - outputMin) * corrected));
            }
            this.mLevelTable[i] = Math.max(0, Math.min(StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX, value));
        }
    }

    @Override // android.content.res.stepostheme.iconfilter.filters.BaseFilter
    public Bitmap filter(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        for (int i = 0; i < pixels.length; i++) {
            int pixel = pixels[i];
            int a = Color.alpha(pixel);
            int r = Color.red(pixel);
            int g = Color.green(pixel);
            int b = Color.blue(pixel);
            if ((this.mFlag & 1) != 0) {
                r = this.mLevelTable[r];
            }
            if ((this.mFlag & 2) != 0) {
                g = this.mLevelTable[g];
            }
            if ((this.mFlag & 4) != 0) {
                b = this.mLevelTable[b];
            }
            pixels[i] = Color.argb(a, r, g, b);
        }
        return Bitmap.createBitmap(pixels, width, height, Bitmap.Config.ARGB_8888);
    }
}
