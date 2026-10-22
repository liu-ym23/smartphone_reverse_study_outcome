package com.baidu.mapapi.map;

import android.graphics.Color;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: classes39.dex */
public class Gradient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f30870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f30871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float[] f30872d;

    public static /* synthetic */ class a {
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f30873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f30874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f30875c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Gradient f30876d;

        public static /* synthetic */ float a(b r100) {
            return r100.f30875c;
        }

        public static /* synthetic */ int b(b r100) {
            return r100.f30873a;
        }

        public static /* synthetic */ int c(b r100) {
            return r100.f30874b;
        }

        private b(Gradient r100, int r101, int r102, float r103) {
            this.f30876d = r100;
            this.f30873a = r101;
            this.f30874b = r102;
            this.f30875c = r103;
        }

        public /* synthetic */ b(Gradient r100, int r101, int r102, float r103, a r104) {
            this(r100, r101, r102, r103);
        }
    }

    private HashMap<Integer, b> a() {
        HashMap<Integer, b> r100 = new HashMap();
        if (this.f30871c[0] == 0.0f) goto L5;
        r100.put(0, new b(this, Color.argb(0, Color.red(this.f30870b[0]), Color.green(this.f30870b[0]), Color.blue(this.f30870b[0])), this.f30870b[0], this.f30869a * this.f30871c[0], null));
    L5:
        int r101 = 1;
    L7:
        if (r101 >= this.f30870b.length) goto L9;
        int r102 = r101 - 1;
        Integer r103 = Integer.valueOf((int) (this.f30869a * this.f30871c[r102]));
        int[] r104 = this.f30870b;
        int r105 = r104[r102];
        int r106 = r104[r101];
        float r107 = this.f30869a;
        float[] r108 = this.f30871c;
        r100.put(r103, new b(this, r105, r106, (r108[r101] - r108[r102]) * r107, null));
        r101 = r101 + 1;
        goto L7
    L9:
        float[] r109 = this.f30871c;
        if (r109[r109.length - 1] == 1.0f) goto L12;
        int r110 = r109.length - 1;
        Integer r111 = Integer.valueOf((int) (this.f30869a * r109[r110]));
        int r112 = this.f30870b[r110];
        r100.put(r111, new b(this, r112, r112, this.f30869a * (1.0f - this.f30871c[r110]), null));
    L12:
        return r100;
    }

    public float[] b() {
        float[] r100 = this.f30872d;
        if (r100 != null) goto L11;
        this.f30872d = new float[this.f30869a];
        int r101 = 0;
    L6:
        if (r101 >= this.f30869a) goto L9;
        int r102 = r101 + 1;
        this.f30872d[r101] = r102 * 0.001f;
        r101 = r102;
        goto L6
    L9:
        return this.f30872d;
    L11:
        return r100;
    }

    public int[] getColors() {
        return this.f30870b;
    }

    public float[] getStartPoints() {
        return this.f30871c;
    }

    public int[] a(double r110) {
        HashMap<Integer, b> r100 = a();
        int[] r101 = new int[this.f30869a];
        int r102 = 0;
        b r103 = r100.get(0);
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= this.f30869a) goto L10;
        if (r100.containsKey(Integer.valueOf(r104)) == false) goto L8;
        r103 = r100.get(Integer.valueOf(r104));
        r105 = r104;
    L8:
        r101[r104] = a(b.b(r103), b.c(r103), (r104 - r105) / b.a(r103));
        r104 = r104 + 1;
        goto L4
    L10:
        if (r110 != 1.0d) goto L12;
    L14:
        return r101;
    L12:
        if (r102 >= this.f30869a) goto L14;
        int r106 = r101[r102];
        r101[r102] = Color.argb((int) (((double) Color.alpha(r106)) * r110), Color.red(r106), Color.green(r106), Color.blue(r106));
        r102 = r102 + 1;
        goto L12
    }

    public Gradient(int[] r100, float[] r101) {
        this(r100, r101, 1000);
    }

    private Gradient(int[] r100, float[] r101, int r102) {
        int[] r103 = com.baidu.platform.comapi.util.d.a(r100);
        if (r103 == null) goto L24;
        if (r101 == null) goto L24;
        if (r103.length != r101.length) goto L22;
        if (r103.length == 0) goto L20;
        int r104 = 1;
    L11:
        if (r104 >= r101.length) goto L17;
        if (r101[r104] <= r101[r104 - 1]) goto L16;
        r104 = r104 + 1;
        goto L11
    L16:
        throw new IllegalArgumentException("BDMapSDKException: startPoints should be in increasing order");
    L17:
        this.f30869a = r102;
        int[] r105 = new int[r103.length];
        this.f30870b = r105;
        float[] r106 = new float[r101.length];
        this.f30871c = r106;
        System.arraycopy(r103, 0, r105, 0, r103.length);
        System.arraycopy(r101, 0, r106, 0, r101.length);
        return;
    L20:
        throw new IllegalArgumentException("BDMapSDKException: No colors have been defined");
    L22:
        throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should be same length");
    L24:
        throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should not be null");
    }

    private static int a(int r100, int r101, float r110) {
        int r102 = (int) (((Color.alpha(r101) - Color.alpha(r100)) * r110) + Color.alpha(r100));
        float[] r103 = new float[3];
        ColorProtector.RGBToHSV(Color.red(r100), Color.green(r100), Color.blue(r100), r103);
        float[] r104 = new float[3];
        ColorProtector.RGBToHSV(Color.red(r101), Color.green(r101), Color.blue(r101), r104);
        int r105 = 0;
        float r106 = r103[0];
        float r107 = r104[0];
        if ((r106 - r107) <= 180.0f) goto L6;
        r104[0] = r107 + 360.0f;
    L8:
        float[] r108 = new float[3];
    L9:
        if (r105 >= 3) goto L12;
        float r109 = r104[r105];
        float r111 = r103[r105];
        r108[r105] = ((r109 - r111) * r110) + r111;
        r105 = r105 + 1;
        goto L9
    L12:
        return ColorProtector.HSVToColor(r102, r108);
    L6:
        if ((r107 - r106) <= 180.0f) goto L8;
        r103[0] = r106 + 360.0f;
        goto L8
    }
}
