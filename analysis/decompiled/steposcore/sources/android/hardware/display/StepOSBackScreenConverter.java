package android.hardware.display;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.android.internal.policy.StepOSSystemBarController;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class StepOSBackScreenConverter {
    private static final int BACKGROUND_COLOR_TOLERANCE = 40;
    private static final int COLOR_QUANT_SHIFT = 3;
    public static final int TARGET_HEIGHT = 23;
    public static final int TARGET_WIDTH = 17;

    private StepOSBackScreenConverter() {
    }

    public static int[] bitmapToFrame(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int srcW = bitmap.getWidth();
        int srcH = bitmap.getHeight();
        if (srcW <= 0 || srcH <= 0) {
            return null;
        }
        Bitmap panel = Bitmap.createBitmap(17, 23, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(panel);
            canvas.drawColor(StepOSSystemBarController.COLO_BLACK);
            float scale = Math.min(17.0f / srcW, 23.0f / srcH);
            int drawW = Math.max(1, Math.round(srcW * scale));
            int drawH = Math.max(1, Math.round(srcH * scale));
            Bitmap scaled = Bitmap.createScaledBitmap(bitmap, drawW, drawH, true);
            try {
                int left = (17 - drawW) / 2;
                int top = (23 - drawH) / 2;
                canvas.drawBitmap(scaled, left, top, new Paint(2));
                if (scaled != bitmap) {
                    scaled.recycle();
                }
                int[] pixels = new int[391];
                panel.getPixels(pixels, 0, 17, 0, 0, 17, 23);
                int backgroundColor = findDominantEdgeColor(pixels, 17, 23);
                int[] frame = new int[391];
                int y = 0;
                for (int i = 23; y < i; i = 23) {
                    for (int x = 0; x < 17; x++) {
                        int index = (y * 17) + x;
                        int pixel = pixels[index];
                        if (isBackgroundColor(pixel, backgroundColor, 40)) {
                            frame[index] = 0;
                        } else {
                            frame[index] = toLuminance(pixel);
                        }
                    }
                    y++;
                }
                return frame;
            } catch (Throwable th) {
                if (scaled != bitmap) {
                    scaled.recycle();
                }
                throw th;
            }
        } finally {
            panel.recycle();
        }
    }

    private static int findDominantEdgeColor(int[] pixels, int width, int height) {
        Map<Integer, int[]> buckets = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        for (int x = 0; x < width; x++) {
            accumulateEdgePixel(pixels[x], buckets, counts);
            accumulateEdgePixel(pixels[((height - 1) * width) + x], buckets, counts);
        }
        for (int y = 1; y < height - 1; y++) {
            accumulateEdgePixel(pixels[y * width], buckets, counts);
            accumulateEdgePixel(pixels[(y * width) + (width - 1)], buckets, counts);
        }
        int bestKey = 0;
        int bestCount = -1;
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            if (e.getValue().intValue() > bestCount) {
                bestCount = e.getValue().intValue();
                bestKey = e.getKey().intValue();
            }
        }
        int[] rgb = buckets.get(Integer.valueOf(bestKey));
        if (rgb == null) {
            return StepOSSystemBarController.COLO_BLACK;
        }
        return Color.rgb(rgb[0], rgb[1], rgb[2]);
    }

    private static void accumulateEdgePixel(int pixel, Map<Integer, int[]> buckets, Map<Integer, Integer> counts) {
        int key = quantizeColorKey(pixel);
        buckets.putIfAbsent(Integer.valueOf(key), sampleRgb(pixel));
        counts.put(Integer.valueOf(key), Integer.valueOf(counts.getOrDefault(Integer.valueOf(key), 0).intValue() + 1));
    }

    private static int quantizeColorKey(int pixel) {
        int r = (pixel >> 16) & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int g = (pixel >> 8) & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int b = pixel & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        return ((r >> 3) << 10) | ((g >> 3) << 5) | (b >> 3);
    }

    private static int[] sampleRgb(int pixel) {
        return new int[]{(pixel >> 16) & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX, (pixel >> 8) & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX, pixel & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX};
    }

    private static boolean isBackgroundColor(int pixel, int backgroundColor, int tolerance) {
        int r = (pixel >> 16) & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int g = (pixel >> 8) & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int b = pixel & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int br = Color.red(backgroundColor);
        int bg = Color.green(backgroundColor);
        int bb = Color.blue(backgroundColor);
        return Math.abs(r - br) <= tolerance && Math.abs(g - bg) <= tolerance && Math.abs(b - bb) <= tolerance;
    }

    private static int toLuminance(int pixel) {
        int r = (pixel >> 16) & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int g = (pixel >> 8) & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int b = pixel & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int y = (((r * 299) + (g * 587)) + (b * 114)) / 1000;
        if (y < 0) {
            return 0;
        }
        return Math.min(y, StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX);
    }
}
