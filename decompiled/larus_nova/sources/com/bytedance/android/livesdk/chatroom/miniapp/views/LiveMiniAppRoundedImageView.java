package com.bytedance.android.livesdk.chatroom.miniapp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes7.dex */
public class LiveMiniAppRoundedImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f106864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f106865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f106866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f106867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f106868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f106869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f106870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f106871h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Path f106872i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f106873j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f106874k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float[] f106875l;

    public final void init() {
        this.f106870g = new RectF();
        this.f106871h = new RectF();
        new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f106874k = new float[8];
        this.f106875l = new float[8];
    }

    public LiveMiniAppRoundedImageView(Context r100) {
        super(r100);
        this.f106864a = 0;
        this.f106868e = -1;
        this.f106872i = new Path();
        this.f106873j = new Paint();
        init();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        r100.saveLayer(this.f106870g, null, 31);
        int r101 = this.f106865b;
        int r102 = this.f106869f;
        int r103 = this.f106866c;
        r100.scale(((r101 - (r102 * 2)) * 1.0f) / r101, ((r103 - (r102 * 2)) * 1.0f) / r103, r101 / 2.0f, r103 / 2.0f);
        if (this.f106867d == false) goto L5;
        Path r104 = this.f106872i;
        int r105 = this.f106865b;
        int r106 = this.f106866c;
        r104.addCircle(r105 * 0.5f, r106 * 0.5f, Math.min(r105, r106) * 0.5f, Path.Direction.CCW);
    L6:
        r100.clipPath(this.f106872i);
        super.onDraw(r100);
        r100.restore();
        int r107 = this.f106869f;
        if (r107 <= 0) goto L14;
        int r108 = this.f106868e;
        RectF r109 = this.f106871h;
        float[] r110 = this.f106874k;
        this.f106872i.reset();
        this.f106873j.reset();
        this.f106873j.setAntiAlias(true);
        this.f106873j.setStyle(Paint.Style.FILL);
        this.f106873j.setStrokeWidth(r107);
        this.f106873j.setColor(r108);
        this.f106873j.setStyle(Paint.Style.STROKE);
        if (this.f106867d == false) goto L11;
        Path r111 = this.f106872i;
        int r112 = this.f106865b;
        int r113 = this.f106866c;
        r111.addCircle(r112 * 0.5f, r113 * 0.5f, (Math.min(r112, r113) - this.f106869f) * 0.5f, Path.Direction.CCW);
    L12:
        r100.drawPath(this.f106872i, this.f106873j);
        return;
    L11:
        this.f106872i.addRoundRect(r109, r110, Path.Direction.CCW);
        goto L12
    L14:
        return;
    L5:
        this.f106872i.addRoundRect(this.f106870g, this.f106875l, Path.Direction.CCW);
        goto L6
    }

    public void setBorderColor(int r100) {
        this.f106868e = r100;
    }

    public void setBorderWidth(float r100) {
        this.f106869f = (int) r100;
    }

    public void setCornerRadius(int r100) {
        this.f106864a = r100;
        int r101 = 0;
    L3:
        float[] r102 = this.f106874k;
        if (r101 >= r102.length) goto L6;
        float r103 = this.f106864a;
        r102[r101] = r103;
        this.f106875l[r101] = r103 - (this.f106869f / 2.0f);
        r101 = r101 + 1;
        goto L3
    }

    public void setIsOval(boolean r100) {
        this.f106867d = r100;
    }

    public LiveMiniAppRoundedImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f106864a = 0;
        this.f106868e = -1;
        this.f106872i = new Path();
        this.f106873j = new Paint();
        init();
    }

    public LiveMiniAppRoundedImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f106864a = 0;
        this.f106868e = -1;
        this.f106872i = new Path();
        this.f106873j = new Paint();
        init();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f106865b = r100;
        this.f106866c = r101;
        float r104 = r100;
        float r105 = r101;
        this.f106870g.set(0.0f, 0.0f, r104, r105);
        RectF r106 = this.f106871h;
        float r107 = this.f106869f / 2.0f;
        r106.set(r107, r107, r104 - r107, r105 - r107);
        int r108 = 0;
    L3:
        float[] r109 = this.f106874k;
        if (r108 >= r109.length) goto L6;
        float r110 = this.f106864a;
        r109[r108] = r110;
        this.f106875l[r108] = r110 - (this.f106869f / 2.0f);
        r108 = r108 + 1;
        goto L3
    }
}
