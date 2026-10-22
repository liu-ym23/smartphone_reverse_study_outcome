package com.bytedance.android.livesdk.widget.crop;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import jv2.f;

/* JADX INFO: loaded from: classes11.dex */
public class PreviewBoxViewV2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f161662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f161663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f161664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f161665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f161666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f161667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f161668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f161669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f161670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f161671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RectF f161672k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RectF f161673l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout f161674m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f161675n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f161676o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f161677p;

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return false;
    }

    public Rect getPreviewRect() {
        Rect r100 = new Rect();
        RectF r101 = this.f161671j;
        r100.set((int) r101.left, (int) r101.top, (int) r101.right, (int) r101.bottom);
        return r100;
    }

    public Rect getVisibleRect() {
        Rect r100 = new Rect();
        RectF r101 = this.f161670i;
        r100.set((int) r101.left, (int) r101.top, (int) r101.right, (int) r101.bottom);
        return r100;
    }

    public PreviewBoxViewV2(Context r100) {
        super(r100);
        this.f161666e = false;
        this.f161669h = 0.5625f;
        this.f161676o = 0.85f;
        this.f161677p = -1;
        a(r100);
    }

    public final void a(Context r100) {
        this.f161674m = (ConstraintLayout) LayoutInflater.from(getContext()).inflate(R.layout.ttlive_audio_custom_theme_preview_mask, this, true).findViewById(R.id.custom_theme_preview_mask);
        Paint r101 = new Paint();
        this.f161662a = r101;
        r101.setAntiAlias(true);
        this.f161668g = (int) UIUtils.dip2Px(r100, 20.0f);
        this.f161677p = (int) UIUtils.dip2Px(r100, 50.0f);
        this.f161675n = 0.5f;
        Paint r102 = new Paint();
        this.f161663b = r102;
        r102.setStyle(Paint.Style.STROKE);
        this.f161663b.setAntiAlias(true);
        this.f161663b.setColor(getContext().getResources().getColor(R.color.white));
        this.f161663b.setStrokeWidth(UIUtils.dip2Px(r100, 2.0f));
        Paint r103 = new Paint();
        this.f161665d = r103;
        r103.setAntiAlias(true);
        this.f161665d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint r104 = new Paint();
        this.f161664c = r104;
        r104.setAntiAlias(true);
        this.f161664c.setColor(ColorProtector.parseColor("#0f0f0f") + 2130706432);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        if (this.f161670i != null) goto L5;
        return;
    L5:
        this.f161662a.setColor(ColorProtector.parseColor("#0f0f0f") + (((int) (this.f161675n * 255.0f)) << 24));
        r110.drawRect(0.0f, 0.0f, getWidth(), this.f161670i.top, this.f161662a);
        RectF r100 = this.f161670i;
        r110.drawRect(0.0f, r100.top, r100.left, r100.bottom, this.f161662a);
        RectF r101 = this.f161670i;
        r110.drawRect(r101.right, r101.top, getWidth(), this.f161670i.bottom, this.f161662a);
        r110.drawRect(0.0f, this.f161670i.bottom, getWidth(), getHeight(), this.f161662a);
        r110.drawRect(this.f161670i, this.f161663b);
        r110.drawRect(this.f161672k, this.f161664c);
        r110.drawRect(this.f161673l, this.f161664c);
    }

    public void setTopOffset(int r100) {
        this.f161677p = r100;
    }

    public PreviewBoxViewV2(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f161666e = false;
        this.f161669h = 0.5625f;
        this.f161676o = 0.85f;
        this.f161677p = -1;
        a(r100);
    }

    public PreviewBoxViewV2(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f161666e = false;
        this.f161669h = 0.5625f;
        this.f161676o = 0.85f;
        this.f161677p = -1;
        a(r100);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = getWidth() - (this.f161668g * 2);
        int r105 = (int) (r104 / this.f161669h);
        int r106 = this.f161677p;
        if (r106 >= 0) goto L5;
        r106 = Math.max(0, (getHeight() - r105) / 2);
    L5:
        int r107 = this.f161668g;
        this.f161670i = new RectF(r107, r106, r107 + r104, r106 + r105);
        Display r108 = ((WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        Point r109 = new Point();
        r108.getSize(r109);
        if (this.f161671j != null) goto L8;
        this.f161671j = new RectF();
    L8:
        float r110 = r109.x;
        float r111 = r109.y;
        RectF r112 = this.f161670i;
        float r113 = r112.bottom;
        float r114 = r112.top;
        RectF r115 = this.f161671j;
        r115.bottom = r113;
        r115.top = r114;
        float r116 = ((r113 - r114) / r111) * r110;
        float r117 = (r110 - r116) / 2.0f;
        r115.left = r117;
        r115.right = r117 + r116;
        RectF r118 = this.f161670i;
        this.f161672k = new RectF(r118.left, r118.top, this.f161671j.left, r118.bottom);
        float r119 = this.f161671j.right;
        RectF r120 = this.f161670i;
        this.f161673l = new RectF(r119, r120.top, r120.right, r120.bottom);
        this.f161674m.post(new f(this));
    }
}
