package android.content.res.stepostheme.iconfilter.utils;

import android.graphics.Color;
import android.hardware.display.StepOSDisplayManager;

/* loaded from: classes.dex */
public class ColorUtils {
    public static void colorToHSL(int color, float[] hsl) {
        float s;
        float h;
        float r = Color.red(color) / 255.0f;
        float g = Color.green(color) / 255.0f;
        float b = Color.blue(color) / 255.0f;
        float max = Math.max(r, Math.max(g, b));
        float min = Math.min(r, Math.min(g, b));
        float delta = max - min;
        float l = (max + min) / 2.0f;
        if (delta == 0.0f) {
            s = 0.0f;
        } else if (l <= 0.5f) {
            s = delta / (max + min);
        } else {
            float s2 = 2.0f - max;
            s = delta / (s2 - min);
        }
        if (delta == 0.0f) {
            h = 0.0f;
        } else if (max == r) {
            h = ((g - b) / delta) % 6.0f;
        } else if (max == g) {
            h = 2.0f + ((b - r) / delta);
        } else {
            float h2 = r - g;
            h = (h2 / delta) + 4.0f;
        }
        float h3 = h * 60.0f;
        if (h3 < 0.0f) {
            h3 += 360.0f;
        }
        hsl[0] = h3;
        hsl[1] = s;
        hsl[2] = l;
    }

    public static int HSLToColor(float[] hsl) {
        float r;
        float g;
        float b;
        float h = hsl[0];
        float s = hsl[1];
        float l = hsl[2];
        float c = (1.0f - Math.abs((l * 2.0f) - 1.0f)) * s;
        float x = (1.0f - Math.abs(((h / 60.0f) % 2.0f) - 1.0f)) * c;
        float m = l - (c / 2.0f);
        if (h < 60.0f) {
            r = c;
            g = x;
            b = 0.0f;
        } else if (h < 120.0f) {
            r = x;
            g = c;
            b = 0.0f;
        } else if (h < 180.0f) {
            r = 0.0f;
            g = c;
            b = x;
        } else if (h < 240.0f) {
            r = 0.0f;
            g = x;
            b = c;
        } else if (h < 300.0f) {
            r = x;
            g = 0.0f;
            b = c;
        } else {
            r = c;
            g = 0.0f;
            b = x;
        }
        int red = Math.round((r + m) * 255.0f);
        int green = Math.round((g + m) * 255.0f);
        int blue = Math.round((b + m) * 255.0f);
        return Color.rgb(ConstrainUtils.constrain(red, 0, StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX), ConstrainUtils.constrain(green, 0, StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX), ConstrainUtils.constrain(blue, 0, StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX));
    }
}
