package a7a;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;

/* JADX INFO: loaded from: classes32.dex */
public final class f extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f2078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2079i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2080j;

    public f(ReadableArray r100) {
        this.f2080j = false;
        if (r100 != null) goto L7;
        LLog.e("LinearGradient", "native parse error array is null");
        return;
    L7:
        if (r100.size() >= 3) goto L10;
        LLog.e("LinearGradient", "native parse error, array.size must be 4  ");
        return;
    L10:
        this.f2078h = r100.getDouble(0);
        k(r100.getArray(1), r100.getArray(2));
        if (r100.size() != 4) goto L13;
        int r101 = r100.getInt(3);
    L14:
        this.f2079i = r101;
        return;
    L13:
        r101 = 9;
        goto L14
    }

    @Override // a7a.d
    public final void i(boolean r100) {
        this.f2080j = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect r110) {
        this.f2072c = Math.max(r110.width(), 1);
        this.f2073d = Math.max(r110.height(), 1);
        int r100 = r110.left;
        int r101 = r110.top;
        int[] r102 = this.f2075f;
        if (r102 != null) goto L5;
    L61:
        this.f2071b = null;
    L62:
        super.setBounds(r110);
        return;
    L5:
        if (r102.length < 2) goto L61;
        float[] r103 = this.f2076g;
        if (r103 != null) goto L10;
    L12:
        PointF r104 = new PointF();
        PointF r111 = new PointF();
        int r105 = this.f2072c;     // Catch: Exception -> L59
        int r112 = this.f2073d;     // Catch: Exception -> L59
        float r106 = ((r105 * 2.0f) * r112) / ((r105 * r105) + (r112 * r112));     // Catch: Exception -> L59
        int r113 = this.f2079i;     // Catch: Exception -> L59
        if (r113 != 1) goto L16;
        float r107 = r100;
        r104.x = r107;     // Catch: Exception -> L59
        r104.y = r112 + r101;     // Catch: Exception -> L59
        r111.x = r107;     // Catch: Exception -> L59
        r111.y = r101;     // Catch: Exception -> L59
    L53:
        if (Build.VERSION.SDK_INT < 28) goto L55;
    L57:
        this.f2071b = new LinearGradient(r104.x, r104.y, r111.x, r111.y, this.f2075f, this.f2076g, Shader.TileMode.CLAMP);     // Catch: Exception -> L59
        goto L62
    L55:
        if (this.f2080j == false) goto L57;
        TraceEvent.beginSection("createBitmapShader");     // Catch: Exception -> L59
        l(r104, r111, this.f2075f, this.f2076g, (float) this.f2078h);     // Catch: Exception -> L59
        TraceEvent.endSection("createBitmapShader");     // Catch: Exception -> L59
        goto L62
    L16:
        if (r113 != 2) goto L19;
        float r108 = r100;
        r104.x = r108;     // Catch: Exception -> L59
        r104.y = r101;     // Catch: Exception -> L59
        r111.x = r108;     // Catch: Exception -> L59
        r111.y = r101 + r112;     // Catch: Exception -> L59
        goto L53
    L19:
        if (r113 != 3) goto L22;
        r104.x = r105 + r100;     // Catch: Exception -> L59
        float r109 = r101;
        r104.y = r109;     // Catch: Exception -> L59
        r111.x = r100;     // Catch: Exception -> L59
        r111.y = r109;     // Catch: Exception -> L59
        goto L53
    L22:
        if (r113 != 4) goto L25;
        r104.x = r100;     // Catch: Exception -> L59
        float r114 = r101;
        r104.y = r114;     // Catch: Exception -> L59
        r111.x = r100 + r105;     // Catch: Exception -> L59
        r111.y = r114;     // Catch: Exception -> L59
        goto L53
    L25:
        if (r113 != 5) goto L28;
        r104.x = (r100 + r105) - (r112 * r106);     // Catch: Exception -> L59
        float r115 = r101;
        r104.y = (r105 * r106) + r115;     // Catch: Exception -> L59
        r111.x = r100 + r105;     // Catch: Exception -> L59
        r111.y = r115;     // Catch: Exception -> L59
        goto L53
    L28:
        if (r113 != 6) goto L31;
        float r116 = r100;
        r104.x = (r112 * r106) + r116;     // Catch: Exception -> L59
        float r117 = r101;
        r104.y = (r105 * r106) + r117;     // Catch: Exception -> L59
        r111.x = r116;     // Catch: Exception -> L59
        r111.y = r117;     // Catch: Exception -> L59
        goto L53
    L31:
        if (r113 != 7) goto L34;
        float r118 = r100;
        r104.x = r118;     // Catch: Exception -> L59
        float r119 = r101;
        r104.y = r119;     // Catch: Exception -> L59
        r111.x = r118 + (r112 * r106);     // Catch: Exception -> L59
        r111.y = r119 + (r105 * r106);     // Catch: Exception -> L59
        goto L53
    L34:
        if (r113 != 8) goto L36;
        r104.x = r100 + r105;     // Catch: Exception -> L59
        float r120 = r101;
        r104.y = r120;     // Catch: Exception -> L59
        r111.x = (r100 + r105) - (r112 * r106);     // Catch: Exception -> L59
        r111.y = r120 + (r105 * r106);     // Catch: Exception -> L59
        goto L53
    L36:
        PointF r121 = new PointF(this.f2072c / 2.0f, this.f2073d / 2.0f);     // Catch: Exception -> L59
        double r122 = Math.toRadians(this.f2078h);     // Catch: Exception -> L59
        float r123 = (float) Math.sin(r122);     // Catch: Exception -> L59
        float r124 = (float) Math.cos(r122);     // Catch: Exception -> L59
        float r125 = (float) Math.tan(r122);     // Catch: Exception -> L59
        if (r123 >= 0.0f) goto L39;
    L41:
        if (r123 < 0.0f) goto L46;
        if (r124 >= 0.0f) goto L46;
        PointF r126 = new PointF(this.f2072c, this.f2073d);     // Catch: Exception -> L59
    L51:
        float r127 = r100;
        float r128 = r101;
        r104.offset(r127, r128);     // Catch: Exception -> L59
        r111.offset(r127, r128);     // Catch: Exception -> L59
        r121.offset(r127, r128);     // Catch: Exception -> L59
        r126.offset(r127, r128);     // Catch: Exception -> L59
        float r129 = r121.y;     // Catch: Exception -> L59
        float r130 = r129 - r126.y;     // Catch: Exception -> L59
        float r131 = r121.x;     // Catch: Exception -> L59
        float r132 = (r130 - (r125 * r131)) + (r126.x * r125);     // Catch: Exception -> L59
        float r133 = r131 + ((r123 * r132) / ((r123 * r125) + r124));     // Catch: Exception -> L59
        r111.x = r133;     // Catch: Exception -> L59
        float r134 = r129 - (r132 / ((r125 * r125) + 1.0f));     // Catch: Exception -> L59
        r111.y = r134;     // Catch: Exception -> L59
        r104.x = (r121.x * 2.0f) - r133;     // Catch: Exception -> L59
        r104.y = (r121.y * 2.0f) - r134;     // Catch: Exception -> L59
    L46:
        if (r123 < 0.0f) goto L48;
    L50:
        r126 = new PointF(0.0f, 0.0f);     // Catch: Exception -> L59
        goto L51
    L48:
        if (r124 >= 0.0f) goto L50;
        r126 = new PointF(0.0f, this.f2073d);     // Catch: Exception -> L59
        goto L51
    L39:
        if (r124 < 0.0f) goto L41;
        r126 = new PointF(this.f2072c, 0.0f);     // Catch: Exception -> L59
    L59:
        e = move-exception;
        this.f2071b = null;
        this.f2074e.setColor(this.f2075f[0]);
        e.printStackTrace();
        LLog.w("BackgroundLinearGradientLayer", "exception:\n" + e);
        goto L62
    L10:
        if (r103.length == r102.length) goto L12;
        this.f2071b = null;
        goto L62
    }

    public static void m(int[] r210, float[] r211, int r212, int[] r213) {
        int r100 = 0;
        int r101 = r210[0];
        float r102 = ((r101 >> 24) & 255) / 255.0f;
        float r103 = ((r101 >> 16) & 255) / 255.0f;
        float r104 = ((r101 >> 8) & 255) / 255.0f;
        float r105 = (r101 & 255) / 255.0f;
        int r106 = 1;
        int r107 = r210[1];
        float r108 = ((r107 >> 24) & 255) / 255.0f;
        float r110 = ((r107 >> 16) & 255) / 255.0f;
        float r111 = ((r107 >> 8) & 255) / 255.0f;
        float r109 = (r107 & 255) / 255.0f;
        float r112 = r211[0];
        float r113 = r211[1] - r112;
    L3:
        if (r100 >= r212) goto L8;
        float r114 = r100 / (r212 - 1.0f);
        float r115 = r211[r106];
        if (r114 <= r115) goto L7;
        r106 = r106 + 1;
        int r116 = r210[r106];
        float r117 = ((r116 >> 24) & 255) / 255.0f;
        float r118 = ((r116 >> 16) & 255) / 255.0f;
        float r119 = ((r116 >> 8) & 255) / 255.0f;
        r113 = r211[r106] - r115;
        r112 = r115;
        float r120 = r109;
        r109 = (r116 & 255) / 255.0f;
        r105 = r120;
        float r214 = r108;
        r108 = r117;
        r102 = r214;
        float r215 = r110;
        r110 = r118;
        r103 = r215;
        float r216 = r111;
        r111 = r119;
        r104 = r216;
    L7:
        float r121 = (r114 - r112) / r113;
        float r122 = 1.0f - r121;
        int r123 = ((int) (((r104 * r122) + (r111 * r121)) * 255.0f)) << 8;
        int r124 = r123 | ((((int) (((r122 * r102) + (r121 * r108)) * 255.0f)) << 24) | (((int) (((r103 * r122) + (r110 * r121)) * 255.0f)) << 16));
        r213[r100] = r124 | ((int) (((r105 * r122) + (r109 * r121)) * 255.0f));
        r100 = r100 + 1;
        r105 = r105;
        goto L3
    }

    public final void l(PointF r110, PointF r111, int[] r112, float[] r210, float r211) {
        int r100 = (int) PointF.length(r111.x - r110.x, r111.y - r110.y);
        if (r100 > 0) goto L6;
        this.f2071b = null;
        return;
    L6:
        int[] r101 = new int[r100];
        if (r210 != null) goto L17;
        float[] r102 = new float[r112.length];
        if (r112.length != 2) goto L12;
        r102[0] = 0.0f;
        r102[1] = 1.0f;
    L19:
        if (r102[0] == 0.0f) goto L21;
        int r113 = 1;
    L23:
        if (r102[r102.length - 1] == 1.0f) goto L25;
        int r114 = 1;
    L26:
        int r115 = (r102.length + r113) + r114;
        if (r115 == r102.length) goto L35;
        int[] r116 = new int[r115];
        float[] r117 = new float[r115];
        if (r113 == 0) goto L31;
        r116[0] = r112[0];
        r117[0] = 0.0f;
    L31:
        System.arraycopy(r112, 0, r116, r113, r112.length);
        System.arraycopy(r102, 0, r117, r113, r102.length);
        if (r114 == 0) goto L34;
        int r118 = r115 - 1;
        r116[r118] = r112[r112.length - 1];
        r117[r118] = 1.0f;
    L34:
        m(r116, r117, r100, r101);
    L36:
        this.f2071b = new BitmapShader(Bitmap.createBitmap(r101, r100, 1, Bitmap.Config.ARGB_8888), Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);
        Matrix r103 = new Matrix();
        r103.postRotate(r211 + 270.0f);
        r103.postTranslate(r110.x, r110.y);
        this.f2071b.setLocalMatrix(r103);
        return;
    L35:
        m(r112, r102, r100, r101);
        goto L36
    L25:
        r114 = 0;
        goto L26
    L21:
        r113 = 0;
        goto L23
    L12:
        if (r112.length <= 2) goto L19;
        int r119 = 0;
    L15:
        if (r119 >= r112.length) goto L19;
        r102[r119] = r119 / (r112.length - 1);
        r119 = r119 + 1;
        goto L15
    L17:
        r102 = r210;
        goto L19
    }
}
