package android.content.res.stepostheme.iconfilter.filters;

import android.content.res.stepostheme.iconfilter.utils.ConstrainUtils;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.display.StepOSDisplayManager;

/* loaded from: classes.dex */
public class EdgeFilter extends BaseFilter {
    private int mEdgeColor = 16777215;

    public void setEdgeColor(int edgeColor) {
        this.mEdgeColor = edgeColor;
        this.mEdgeColor = ConstrainUtils.constrain(this.mEdgeColor, 0, 16777215);
    }

    @Override // android.content.res.stepostheme.iconfilter.filters.BaseFilter
    public Bitmap filter(Bitmap bitmap) {
        int[] grayPixels;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] grayPixels2 = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = bitmap.getPixel(x, y);
                int r = Color.red(pixel);
                int g = Color.green(pixel);
                int b = Color.blue(pixel);
                grayPixels2[(y * width) + x] = (int) ((r * 0.299d) + (g * 0.587d) + (b * 0.114d));
            }
        }
        int y2 = width * height;
        int[] dstPixels = new int[y2];
        int edgeR = Color.red(this.mEdgeColor);
        int edgeG = Color.green(this.mEdgeColor);
        int edgeB = Color.blue(this.mEdgeColor);
        int i = 0;
        int i2 = 1;
        int[][] sobelX = {new int[]{-1, 0, 1}, new int[]{-2, 0, 2}, new int[]{-1, 0, 1}};
        int[][] sobelY = {new int[]{-1, -2, -1}, new int[]{0, 0, 0}, new int[]{1, 2, 1}};
        int y3 = 1;
        while (y3 < height - 1) {
            int x2 = 1;
            while (x2 < width - 1) {
                int gx = 0;
                int gy = 0;
                int i3 = i;
                for (int ky = -1; ky <= i2; ky++) {
                    for (int kx = -1; kx <= i2; kx++) {
                        int gray = grayPixels2[((y3 + ky) * width) + x2 + kx];
                        gx += sobelX[ky + 1][kx + 1] * gray;
                        gy += sobelY[ky + 1][kx + 1] * gray;
                    }
                }
                int[][] sobelX2 = sobelX;
                int magnitude = Math.min(StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX, (int) Math.sqrt((gx * gx) + (gy * gy)));
                if (magnitude > 30) {
                    float factor = magnitude / 255.0f;
                    int r2 = (int) (edgeR * factor);
                    int g2 = (int) (edgeG * factor);
                    int b2 = (int) (edgeB * factor);
                    grayPixels = grayPixels2;
                    dstPixels[(y3 * width) + x2] = Color.argb(StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX, r2, g2, b2);
                } else {
                    grayPixels = grayPixels2;
                    dstPixels[(y3 * width) + x2] = i3;
                }
                x2++;
                i = i3;
                sobelX = sobelX2;
                grayPixels2 = grayPixels;
                i2 = 1;
            }
            y3++;
            i2 = 1;
        }
        return Bitmap.createBitmap(dstPixels, width, height, Bitmap.Config.ARGB_8888);
    }
}
