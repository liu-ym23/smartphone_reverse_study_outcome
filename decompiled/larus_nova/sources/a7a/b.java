package a7a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import com.facebook.keyframes.model.KFFeatureEffect;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public abstract class b extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Shader f2071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f2074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f2075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f2076g;

    @Override // a7a.d
    public final boolean c() {
        return true;
    }

    @Override // a7a.d
    public final void d() {
    }

    @Override // a7a.d
    public final void e() {
    }

    @Override // a7a.d
    public final void g(int r100, int r101) {
    }

    public b() {
        this.f2072c = 0;
        this.f2073d = 0;
        this.f2074e = new Paint(1);
        this.f2075f = null;
        this.f2076g = null;
    }

    @Override // a7a.d
    public final int a() {
        return this.f2073d;
    }

    @Override // a7a.d
    public final int b() {
        return this.f2072c;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        if (this.f2071b != null) goto L5;
        LLog.e(KFFeatureEffect.GRADIENT_JSON_FIELD, "BackgroundGradientLayer.draw() must be called after setBounds()");
    L5:
        this.f2074e.setShader(this.f2071b);
        Path r101 = this.f2077a;
        if (r101 == null) goto L8;
        r100.drawPath(r101, this.f2074e);
        return;
    L8:
        r100.drawRect(getBounds(), this.f2074e);
    }

    public final void k(ReadableArray r100, ReadableArray r101) {
        if (r101.size() != 0) goto L5;
    L8:
        this.f2075f = new int[r100.size()];
        if (r101.size() != r100.size()) goto L11;
        this.f2076g = new float[r101.size()];
    L11:
        int r102 = 0;
    L12:
        int[] r103 = this.f2075f;
        if (r102 >= r103.length) goto L18;
        r103[r102] = (int) r100.getLong(r102);
        float[] r104 = this.f2076g;
        if (r104 == null) goto L17;
        r104[r102] = ((float) r101.getDouble(r102)) / 100.0f;
    L17:
        r102 = r102 + 1;
        goto L12
    L18:
        return;
    L5:
        if (r100.size() == r101.size()) goto L8;
        LLog.e("Gradient", "native parser error, color and stop must have same size");
    }
}
