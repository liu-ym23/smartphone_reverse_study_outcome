package a7a;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.GradientUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class i extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f2084j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f2085k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f2086l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f2087m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f2088n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f2089o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f2090p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f2091q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PointF f2092r;

    public static float l(int r100, float r101, float r102) {
        if (r100 == 11) goto L11;
        switch(r100) {
            case 32: goto L8;
            case 33: goto L12;
            case 34: goto L12;
            case 35: goto L8;
            case 36: goto L7;
            default: goto L5;
        };
    L5:
        return r101;
    L8:
        return 0.0f;
    L12:
        return r102;
    L7:
        return r102 * 0.5f;
    L11:
        return (r102 * r101) / 100.0f;
    }

    public i(ReadableArray r100) {
        this.f2082h = 0;
        this.f2083i = 0;
        this.f2084j = 36;
        this.f2085k = 36;
        this.f2086l = 0.5f;
        this.f2087m = 0.5f;
        this.f2092r = new PointF(0.5f, 0.5f);
        if (r100 != null) goto L7;
        LLog.e("RadialGradient", "native parser error, array is null");
        return;
    L7:
        if (r100.size() == 3) goto L9;
        LLog.e("RadialGradient", "native parser error, array.size must be 3");
    L9:
        ReadableArray r101 = r100.getArray(0);
        this.f2082h = (int) r101.getLong(0);
        int r102 = (int) r101.getLong(1);
        this.f2083i = r102;
        this.f2084j = (int) r101.getLong(2);
        this.f2086l = (float) r101.getDouble(3);
        this.f2085k = (int) r101.getLong(4);
        this.f2087m = (float) r101.getDouble(5);
        if (r102 != 4) goto L12;
        this.f2088n = (float) r101.getDouble(10);
        this.f2089o = r101.getInt(11);
        this.f2090p = (float) r101.getDouble(12);
        this.f2091q = r101.getInt(13);
    L12:
        k(r100.getArray(1), r100.getArray(2));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect r110) {
        this.f2072c = r110.width();
        this.f2073d = r110.height();
        this.f2092r.x = l(this.f2084j, this.f2086l, this.f2072c);
        this.f2092r.y = l(this.f2085k, this.f2087m, this.f2073d);
        PointF r100 = this.f2092r;
        float r101 = r100.x;
        float r102 = r100.y;
        int r103 = this.f2083i;
        boolean r104 = true;
        if (r103 == 4) goto L5;
        PointF r105 = GradientUtils.b(this.f2082h, r103, r101, r102, this.f2072c, this.f2073d);
    L14:
        int[] r106 = this.f2075f;
        if (r106 != null) goto L17;
    L40:
        this.f2071b = null;
    L41:
        super.setBounds(r110);
        return;
    L17:
        if (r106.length < 2) goto L40;
        float[] r107 = this.f2076g;
        if (r107 != null) goto L22;
    L43:
        float r108 = r105.x;     // Catch: Exception -> L38
        if (r108 == 0.0f) goto L31;
        if (r105.y == 0.0f) goto L31;
        r104 = false;
    L31:
        if (r104 == false) goto L33;
        float r111 = 1.0f;
    L34:
        this.f2071b = new RadialGradient(r101, r102, Math.max(r105.x, 1.0f), this.f2075f, this.f2076g, Shader.TileMode.CLAMP);     // Catch: Exception -> L38
        if (r111 == 1.0f) goto L41;
        Matrix r109 = new Matrix();     // Catch: Exception -> L38
        r109.preScale(1.0f, 1.0f / r111, r101, r102);     // Catch: Exception -> L38
        this.f2071b.setLocalMatrix(r109);     // Catch: Exception -> L38
        goto L41
    L33:
        r111 = r108 / r105.y;     // Catch: Exception -> L38
    L38:
        e = move-exception;
        this.f2071b = null;
        e.printStackTrace();
        LLog.w("BackgroundRadialGradientLayer", "exception:\n" + e.toString());
        goto L41
    L22:
        if (r107.length == r106.length) goto L43;
        this.f2071b = null;
        goto L41
    L5:
        if (this.f2089o != 1) goto L7;
        float r112 = this.f2072c * this.f2088n;
    L9:
        if (this.f2091q != 1) goto L11;
        float r113 = this.f2073d * this.f2090p;
    L12:
        r105 = new PointF(r112, r113);
        goto L14
    L11:
        r113 = this.f2090p;
        goto L12
    L7:
        r112 = this.f2088n;
        goto L9
    }
}
