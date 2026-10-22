package android.content.res.stepostheme;

import android.app.ActivityThread;
import android.app.Application;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.provider.Settings;
import android.util.Log;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class StepOSDarkModeExtImpl implements IStepOSDarkModeExt {
    private static final Set<String> ACTIVITY_BLACKLIST;
    private static final Set<String> APP_BLACKLIST;
    private static final int BLACK_THRESHOLD = 50;
    private static final ColorMatrixColorFilter DARKEN_COLOR_FILTER;
    private static final float DARKEN_SCALE = 0.8f;
    private static final String DEFAULT_DARK_MODE_HUE = "#000000";
    private static final String KEY_DARK_MODE_HUE = "stepos_dark_mode_hue_color";
    private static final int MAX_ICON_SIZE = 500;
    private static final ColorMatrixColorFilter REVERSAL_COLOR_FILTER;
    private static final ColorMatrixColorFilter REVERSAL_DARKEN_COLOR_FILTER;
    private static final String TAG = "StepOSDarkMode";
    private static final int WHITE_THRESHOLD = 200;
    public static final ColorMatrix REVERSAL_MATRIX = new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    public static final ColorMatrix DARKEN_MATRIX = new ColorMatrix(new float[]{0.8f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.8f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.8f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    public static final ColorMatrix DEEP_DARKEN_MATRIX = new ColorMatrix(new float[]{0.4f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.4f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.4f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    private static final ColorMatrix REVERSAL_DARKEN_MATRIX = new ColorMatrix(REVERSAL_MATRIX);

    static {
        REVERSAL_DARKEN_MATRIX.postConcat(DARKEN_MATRIX);
        REVERSAL_COLOR_FILTER = new ColorMatrixColorFilter(REVERSAL_MATRIX);
        DARKEN_COLOR_FILTER = new ColorMatrixColorFilter(DARKEN_MATRIX);
        REVERSAL_DARKEN_COLOR_FILTER = new ColorMatrixColorFilter(REVERSAL_DARKEN_MATRIX);
        APP_BLACKLIST = new HashSet(Arrays.asList("com.android.camera", "com.android.gallery3d", "com.google.android.apps.photos"));
        ACTIVITY_BLACKLIST = new HashSet(Arrays.asList("com.android.settings.DisplaySettings", "com.android.settings.DarkModeSettings"));
    }

    public boolean inNightMode(int uiMode) {
        return (uiMode & 48) == 32;
    }

    public boolean shouldApplyDarkMode(String packageName) {
        if (packageName == null) {
            return true;
        }
        return true ^ APP_BLACKLIST.contains(packageName);
    }

    public boolean isActivityInBlackList(String activityName) {
        if (activityName == null) {
            return false;
        }
        return ACTIVITY_BLACKLIST.contains(activityName);
    }

    public ColorMatrix getReversalMatrix() {
        return new ColorMatrix(REVERSAL_MATRIX);
    }

    public ColorMatrix getDarkenMatrix() {
        return new ColorMatrix(DARKEN_MATRIX);
    }

    public ColorMatrixColorFilter getDarkModeColorFilter() {
        return REVERSAL_DARKEN_COLOR_FILTER;
    }

    public boolean beforeDrawBitmap(Bitmap bitmap, Paint paint) {
        if (bitmap == null || paint == null || shouldSkipBitmap(bitmap)) {
            return false;
        }
        paint.setColorFilter(REVERSAL_DARKEN_COLOR_FILTER);
        return true;
    }

    public boolean shouldSkipBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getConfig() == Bitmap.Config.HARDWARE) {
            return true;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > MAX_ICON_SIZE && height > MAX_ICON_SIZE) {
            return true;
        }
        int type = analyzeBitmapType(bitmap);
        return type == 3;
    }

    public int analyzeBitmapType(Bitmap bitmap) {
        int i;
        int i2;
        int i3 = 3;
        if (bitmap == null || bitmap.isRecycled() || bitmap.getConfig() == Bitmap.Config.HARDWARE) {
            return 3;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int whiteCount = 0;
        int blackCount = 0;
        int colorCount = 0;
        int sampleSize = Math.min(100, width * height);
        int i4 = 1;
        int step = Math.max(1, (width * height) / sampleSize);
        int i5 = 0;
        while (i5 < width * height) {
            int x = i5 % width;
            int y = i5 / width;
            int pixel = bitmap.getPixel(x, y);
            if (Color.alpha(pixel) < 10) {
                i = i3;
                i2 = i4;
            } else {
                int r = Color.red(pixel);
                int g = Color.green(pixel);
                i = i3;
                int b = Color.blue(pixel);
                i2 = i4;
                if (r > 200 && g > 200 && b > 200) {
                    whiteCount++;
                } else if (r < BLACK_THRESHOLD && g < BLACK_THRESHOLD && b < BLACK_THRESHOLD) {
                    blackCount++;
                } else {
                    colorCount++;
                }
            }
            i5 += step;
            i3 = i;
            i4 = i2;
        }
        int i6 = i3;
        int i7 = i4;
        if (whiteCount > blackCount && whiteCount > colorCount) {
            return 0;
        }
        if (blackCount > whiteCount && blackCount > colorCount) {
            return i7;
        }
        if (colorCount > 10) {
            return 2;
        }
        return i6;
    }

    public int transformColor(int color) {
        int a = Color.alpha(color);
        int r = 255 - Color.red(color);
        int g = 255 - Color.green(color);
        int b = 255 - Color.blue(color);
        return Color.argb(a, (int) (r * 0.8f), (int) (g * 0.8f), (int) (b * 0.8f));
    }

    public int transformTextColor(int color) {
        int a = Color.alpha(color);
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        if (r < 128 && g < 128 && b < 128) {
            r = 255 - r;
            g = 255 - g;
            b = 255 - b;
        }
        return Color.argb(a, r, g, b);
    }

    public boolean isWhiteColor(int color) {
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        return r > 200 && g > 200 && b > 200;
    }

    public boolean isBlackColor(int color) {
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        return r < BLACK_THRESHOLD && g < BLACK_THRESHOLD && b < BLACK_THRESHOLD;
    }

    public void initWebViewDarkMode(boolean inNightMode) {
        StepOSLogUtil.d("initWebViewDarkMode: " + inNightMode);
    }

    public String getDarkModeHueColor() {
        try {
            Application app = ActivityThread.currentApplication();
            if (app != null) {
                ContentResolver cr = app.getContentResolver();
                String hue = Settings.System.getString(cr, KEY_DARK_MODE_HUE);
                if (hue != null) {
                    return hue;
                }
                return DEFAULT_DARK_MODE_HUE;
            }
            return DEFAULT_DARK_MODE_HUE;
        } catch (Exception e) {
            Log.w(TAG, "Failed to get dark mode hue: " + e.getMessage());
            return DEFAULT_DARK_MODE_HUE;
        }
    }

    public void setDarkModeHueColor(String hueColor) {
        try {
            Application app = ActivityThread.currentApplication();
            if (app != null) {
                ContentResolver cr = app.getContentResolver();
                Settings.System.putString(cr, KEY_DARK_MODE_HUE, hueColor);
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to set dark mode hue: " + e.getMessage());
        }
    }
}
