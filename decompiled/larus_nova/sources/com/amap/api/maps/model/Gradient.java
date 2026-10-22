package com.amap.api.maps.model;

import android.graphics.Color;
import com.amap.api.maps.AMapException;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: classes28.dex */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    private boolean isAvailable;
    private int mColorMapSize;
    private int[] mColors;
    private float[] mStartPoints;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f28650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f28651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f28652c;

        public static /* synthetic */ float a(b r100) {
            return r100.f28652c;
        }

        public static /* synthetic */ int b(b r100) {
            return r100.f28650a;
        }

        public static /* synthetic */ int c(b r100) {
            return r100.f28651b;
        }

        private b(int r100, int r101, float r102) {
            this.f28650a = r100;
            this.f28651b = r101;
            this.f28652c = r102;
        }

        public /* synthetic */ b(int r100, int r101, float r102, a r103) {
            this(r100, r101, r102);
        }
    }

    public int[] getColors() {
        return this.mColors;
    }

    public float[] getStartPoints() {
        return this.mStartPoints;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public int[] generateColorMap(double r110) {
        HashMap r100 = new HashMap(32);
        int r101 = 0;
        a r102 = null;
        if (this.mStartPoints[0] == 0.0f) goto L5;
        r100.put(0, new b(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0], r102));
    L5:
        int r103 = 1;
    L7:
        if (r103 >= this.mColors.length) goto L9;
        int r104 = r103 - 1;
        Integer r105 = Integer.valueOf((int) (this.mColorMapSize * this.mStartPoints[r104]));
        int[] r111 = this.mColors;
        int r112 = r111[r104];
        int r113 = r111[r103];
        float r114 = this.mColorMapSize;
        float[] r115 = this.mStartPoints;
        r100.put(r105, new b(r112, r113, r114 * (r115[r103] - r115[r104]), r102));
        r103 = r103 + 1;
        goto L7
    L9:
        float[] r106 = this.mStartPoints;
        if (r106[r106.length - 1] == 1.0f) goto L12;
        int r107 = r106.length - 1;
        Integer r108 = Integer.valueOf((int) (this.mColorMapSize * r106[r107]));
        int r109 = this.mColors[r107];
        r100.put(r108, new b(r109, r109, this.mColorMapSize * (1.0f - this.mStartPoints[r107]), r102));
    L12:
        int[] r116 = new int[this.mColorMapSize];
        b r117 = (b) r100.get(0);
        int r118 = 0;
        int r119 = 0;
    L14:
        if (r118 >= this.mColorMapSize) goto L29;
        if (r100.containsKey(Integer.valueOf(r118)) == false) goto L18;
        r117 = (b) r100.get(Integer.valueOf(r118));
        r119 = r118;
    L18:
        float r120 = (r118 - r119) / b.a(r117);
        int r121 = b.b(r117);
        int r122 = b.c(r117);
        int r123 = (int) (((Color.alpha(r122) - Color.alpha(r121)) * r120) + Color.alpha(r121));
        float[] r124 = new float[3];
        ColorProtector.RGBToHSV(Color.red(r121), Color.green(r121), Color.blue(r121), r124);
        float[] r125 = new float[3];
        ColorProtector.RGBToHSV(Color.red(r122), Color.green(r122), Color.blue(r122), r125);
        float r126 = r124[0];
        float r127 = r125[0];
        float r128 = 180;
        if ((r126 - r127) <= r128) goto L22;
        r125[0] = r127 + 360;
    L24:
        float[] r129 = new float[3];
        int r130 = 0;
    L25:
        if (r130 >= 3) goto L27;
        float r131 = r125[r130];
        float r132 = r124[r130];
        r129[r130] = ((r131 - r132) * r120) + r132;
        r130 = r130 + 1;
        goto L25
    L27:
        r116[r118] = ColorProtector.HSVToColor(r123, r129);
        r118 = r118 + 1;
        goto L14
    L22:
        if ((r127 - r126) <= r128) goto L24;
        r124[0] = r126 + 360;
        goto L24
    L29:
        if (r110 != 1.0d) goto L31;
    L33:
        return r116;
    L31:
        if (r101 >= this.mColorMapSize) goto L33;
        int r133 = r116[r101];
        r116[r101] = Color.argb((int) (((double) Color.alpha(r133)) * r110), Color.red(r133), Color.green(r133), Color.blue(r133));
        r101 = r101 + 1;
        goto L31
    }

    public Gradient(int[] r100, float[] r101) {
        this(r100, r101, 1000);
    }

    private Gradient(int[] r100, float[] r101, int r102) {
        this.isAvailable = true;
        if (r100 == null) goto L23;
        if (r101 == null) goto L23;
        if (r100.length != r101.length) goto L21;
        if (r100.length == 0) goto L19;
        int r103 = 1;
    L11:
        if (r103 >= r101.length) goto L17;
        if (r101[r103] < r101[r103 - 1]) goto L16;
        r103 = r103 + 1;     // Catch: AMapException -> L24
        goto L11
    L16:
        throw new AMapException("startPoints should be in increasing order");     // Catch: AMapException -> L24
    L17:
        this.mColorMapSize = r102;     // Catch: AMapException -> L24
        int[] r104 = new int[r100.length];     // Catch: AMapException -> L24
        this.mColors = r104;     // Catch: AMapException -> L24
        this.mStartPoints = new float[r101.length];     // Catch: AMapException -> L24
        System.arraycopy(r100, 0, r104, 0, r100.length);     // Catch: AMapException -> L24
        System.arraycopy(r101, 0, this.mStartPoints, 0, r101.length);     // Catch: AMapException -> L24
        this.isAvailable = true;     // Catch: AMapException -> L24
        return;
    L19:
        throw new AMapException("No colors have been defined");     // Catch: AMapException -> L24
    L21:
        throw new AMapException("colors and startPoints should be same length");     // Catch: AMapException -> L24
    L23:
        throw new AMapException("colors and startPoints should not be null");     // Catch: AMapException -> L24
    L24:
        e = move-exception;
        this.isAvailable = false;
        e.getErrorMessage();
        e.printStackTrace();
    }
}
