package cma;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f24227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f24228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f24230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f24231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f24232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f24233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f24234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Path f24235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f24236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Matrix f24237k;

    /* JADX INFO: renamed from: cma.a$a, reason: collision with other inner class name */
    public static final class C0460a {
    }

    static {
    }

    public final void b() {
        this.f24235i.reset();
        this.f24236j.reset();
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        Path r100 = new AdaptiveIconDrawable(null, null, null).getIconMask();
        if (r100.isEmpty() == false) goto L8;
        return;
    L8:
        float r101 = getBounds().width();
        float r102 = getBounds().height();
        float r103 = Math.min(r101, r102);
        float r104 = 0.0f;
        if (r101 <= r102) goto L11;
        float r105 = (r101 - r102) / 2.0f;
    L13:
        if (r102 <= r101) goto L15;
        r104 = (r102 - r101) / 2.0f;
    L15:
        this.f24237k.reset();
        float r106 = r103 / 100.0f;
        this.f24237k.setScale(r106, r106);
        this.f24235i.set(r100);
        this.f24235i.transform(this.f24237k);
        this.f24235i.offset(getBounds().left + r105, getBounds().top + r104);
        float r107 = this.f24230d + 1;
        this.f24237k.reset();
        float r108 = (r103 - (2.0f * r107)) / 100.0f;
        this.f24237k.setScale(r108, r108);
        this.f24236j.set(r100);
        this.f24236j.transform(this.f24237k);
        this.f24236j.offset((getBounds().left + r105) + r107, (getBounds().top + r104) + r107);
        return;
    L11:
        r105 = 0.0f;
        goto L13
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f24227a.getOpacity();
    }

    public final void a(Canvas r100) {
        if (this.f24228b != null) goto L6;
        return;
    L6:
        if (this.f24235i.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.f24234h == false) goto L11;
        Path r101 = this.f24236j;
    L12:
        r100.drawPath(r101, this.f24233g);
        return;
    L11:
        r101 = this.f24235i;
        goto L12
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f24231e == true) goto L13;
        a(r100);
        this.f24227a.draw(r100);
        if (this.f24235i.isEmpty() == true) goto L21;
        float r101 = this.f24230d;
        if (r101 > 0.0f) goto L10;
        Intrinsics.stringPlus("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r101));
        return;
    L10:
        int r102 = r100.save();
        r100.clipPath(this.f24235i);
        this.f24232f.setStrokeWidth(this.f24230d * 2);
        this.f24232f.setStrokeJoin(Paint.Join.ROUND);
        this.f24232f.setStrokeCap(Paint.Cap.ROUND);
        r100.drawPath(this.f24235i, this.f24232f);
        r100.restoreToCount(r102);
        return;
    L21:
        return;
    L13:
        if (this.f24235i.isEmpty() == false) goto L15;
        this.f24227a.draw(r100);
        return;
    L15:
        int r103 = r100.save();
        r100.clipPath(this.f24235i);
        a(r100);
        this.f24227a.draw(r100);
        float r104 = this.f24230d;
        if (r104 > 0.0f) goto L18;
        Intrinsics.stringPlus("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r104));
        r100.restoreToCount(r103);
        return;
    L18:
        this.f24232f.setStrokeWidth(r104 * 2);
        this.f24232f.setStrokeJoin(Paint.Join.ROUND);
        this.f24232f.setStrokeCap(Paint.Cap.ROUND);
        r100.drawPath(this.f24235i, this.f24232f);
        r100.restoreToCount(r103);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        this.f24227a.setBounds(r100);
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f24227a.setAlpha(r100);
        this.f24233g.setAlpha(r100);
        this.f24232f.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f24227a.setColorFilter(r100);
        this.f24233g.setColorFilter(r100);
        this.f24232f.setColorFilter(r100);
        invalidateSelf();
    }

    public a(Context r100, Drawable r101, Integer r102, int r103, boolean r104) {
        float r105 = r100.getResources().getDimension(R.dimen.oui_image_stroke_width);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "icon");
        this.f24227a = r101;
        this.f24228b = r102;
        this.f24229c = r103;
        this.f24230d = r105;
        this.f24231e = r104;
        Paint r106 = new Paint(1);
        r106.setStyle(Paint.Style.STROKE);
        r106.setColor(this.f24229c);
        this.f24232f = r106;
        Paint r107 = new Paint(1);
        r107.setStyle(Paint.Style.FILL);
        this.f24233g = r107;
        this.f24235i = new Path();
        this.f24236j = new Path();
        this.f24237k = new Matrix();
        Integer r108 = this.f24228b;
        if (r108 == null) goto L6;
        r107.setColor(r108.intValue());
    L6:
        b();
    }
}
