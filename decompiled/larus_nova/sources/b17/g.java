package b17;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import com.lynx.tasm.utils.i;

/* JADX INFO: loaded from: classes21.dex */
public class g extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f16937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Matrix f16938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BorderRadius f16939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f16940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RectF f16941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f16942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f16943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f16944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f16945j;

    public final void a() {
        Drawable r100 = this.f16937b;
        if (r100 != null) goto L7;
        invalidate();
        return;
    L7:
        if (r100.getIntrinsicHeight() > 0) goto L9;
    L17:
        invalidate();
        return;
    L9:
        if (this.f16937b.getIntrinsicWidth() <= 0) goto L17;
        if (getWidth() <= 0) goto L17;
        if (getHeight() <= 0) goto L17;
        RectF r101 = new RectF(this.f16942g, this.f16943h, this.f16944i, this.f16945j);
        RectF r102 = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        this.f16938c = e(this.f16937b, getWidth(), getHeight(), r101, r102, this.f16936a);
        this.f16940e = c(this.f16939d, r101, getWidth(), getHeight());
        this.f16941f = d(getWidth(), getHeight(), r101, r102);
        invalidate();
    }

    public Drawable getDrawable() {
        return this.f16937b;
    }

    public g(Context r100) {
        super(r100);
        this.f16936a = "scaleToFill";
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        super.invalidateDrawable(r100);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        if (this.f16941f != null) goto L5;
        return;
    L5:
        TraceEvent.beginSection("UIImageView.onDraw");
        b(r100, this.f16941f, this.f16940e, this.f16937b, this.f16938c, null);
        TraceEvent.endSection("UIImageView.onDraw");
    }

    public void setBitmap(Bitmap r100) {
        if (r100 != null) goto L5;
        setDrawable(null);
        return;
    L5:
        BitmapDrawable r101 = new BitmapDrawable(r100);
        r101.setBounds(0, 0, r101.getIntrinsicWidth(), r101.getIntrinsicHeight());
        setDrawable(r101);
    }

    public void setBorderRadius(BorderRadius r100) {
        this.f16939d = r100;
        a();
    }

    public void setDrawable(Drawable r100) {
        this.f16937b = r100;
        if (r100 == null) goto L5;
        r100.setCallback(this);
    L5:
        a();
    }

    public void setScaleType(String r100) {
        this.f16936a = r100;
        a();
    }

    public static Path c(BorderRadius r110, RectF r111, int r210, int r211) {
        if (r110 == null) goto L5;
        Path r100 = new Path();
        float r101 = r210;
        float r102 = r211;
        r110.d(r101, r102);
        float[] r103 = r110.a();
        r100.addRoundRect(new RectF(r111.left, r111.top, r101 - r111.right, r102 - r111.bottom), new float[]{Math.max(r103[0] - r111.left, 0.0f), Math.max(r103[1] - r111.top, 0.0f), Math.max(r103[2] - r111.right, 0.0f), Math.max(r103[3] - r111.top, 0.0f), Math.max(r103[4] - r111.right, 0.0f), Math.max(r103[5] - r111.bottom, 0.0f), Math.max(r103[6] - r111.left, 0.0f), Math.max(r103[7] - r111.bottom, 0.0f)}, Path.Direction.CW);
        return r100;
    L5:
        return null;
    }

    public static RectF d(int r100, int r101, RectF r102, RectF r103) {
        return new RectF(r102.left + r103.left, r102.top + r103.top, (r100 - r103.right) - r102.right, (r101 - r103.bottom) - r102.bottom);
    }

    @Override // android.view.View
    public final void layout(int r100, int r101, int r102, int r103) {
        super.layout(r100, r101, r102, r103);
        a();
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        super.setPadding(r100, r101, r102, r103);
        a();
    }

    public static void b(Canvas r100, RectF r101, Path r102, Drawable r103, Matrix r104, Paint r105) {
        int r106 = r100.save();
        r100.clipRect(r101);
        if (r102 == null) goto L5;
        r100.clipPath(r102);
    L5:
        if (r103 == null) goto L10;
        r100.concat(r104);
        if (r105 == null) goto L9;
        r100.drawPaint(r105);
    L9:
        r103.draw(r100);
    L10:
        r100.restoreToCount(r106);
    }

    public static Matrix e(Drawable r100, int r101, int r102, RectF r103, RectF r110, String r111) {
        Matrix r104 = new Matrix();
        if (r100 != null) goto L5;
    L21:
        return r104;
    L5:
        if (r100.getIntrinsicHeight() <= 0) goto L21;
        if (r100.getIntrinsicWidth() <= 0) goto L21;
        if (r101 <= 0) goto L21;
        if (r102 <= 0) goto L21;
        float r105 = r100.getIntrinsicWidth();
        float r106 = r100.getIntrinsicHeight();
        float r107 = r103.left;
        float r108 = r110.left;
        float r109 = (((r101 - r107) - r108) - r103.right) - r110.right;
        float r112 = r103.top;
        float r113 = r110.top;
        float r114 = (((r102 - r112) - r113) - r103.bottom) - r110.bottom;
        float r115 = r107 + r108;
        float r116 = r112 + r113;
        if ("center".equals(r111) == false) goto L15;
        float r117 = i.b(1.0f, 0.0f);
        r104.preTranslate(r115 - (((r105 * r117) - r109) / 2.0f), r116 - (((r106 * r117) - r114) / 2.0f));
        r104.preScale(r117, r117);
        goto L21
    L15:
        if ("aspectFill".equals(r111) == false) goto L18;
        float r118 = Math.max(r109 / r105, r114 / r106);
        r104.preTranslate(r115 + ((r109 - (r105 * r118)) / 2.0f), r116 + ((r114 - (r106 * r118)) / 2.0f));
        r104.preScale(r118, r118);
        goto L21
    L18:
        if ("aspectFit".equals(r111) == false) goto L20;
        float r119 = Math.min(r109 / r105, r114 / r106);
        r104.preTranslate(r115 + ((r109 - (r105 * r119)) / 2.0f), r116 + ((r114 - (r106 * r119)) / 2.0f));
        r104.preScale(r119, r119);
        goto L21
    L20:
        r104.preTranslate(r115, r116);
        r104.preScale(r109 / r105, r114 / r106);
        goto L21
    }
}
