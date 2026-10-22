package com.bytedance.android.gamecp.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public class RoundRectLayoutV2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f56951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f56952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56953c;

    public RoundRectLayoutV2(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        int r100 = r110.saveLayer(this.f56951a, null, 31);
        super.dispatchDraw(r110);
        Path r101 = new Path();
        r101.reset();
        r101.addRoundRect(this.f56951a, this.f56952b, Path.Direction.CW);
        Paint r102 = new Paint();
        r102.setAntiAlias(true);
        if (Build.VERSION.SDK_INT >= 27) goto L5;
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r102.setStyle(Paint.Style.FILL);
        r110.drawPath(r101, r102);
    L6:
        r110.restoreToCount(r100);
        return;
    L5:
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Path r103 = new Path();
        RectF r104 = this.f56951a;
        r103.addRect(r104.left, r104.top, r104.width(), this.f56951a.height(), Path.Direction.CW);
        r103.op(r101, Path.Op.DIFFERENCE);
        r110.drawPath(r103, r102);
        goto L6
    }

    public RoundRectLayoutV2(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public RoundRectLayoutV2(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        float[] r100 = new float[8];
        this.f56952b = r100;
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.cornerRadius, R.attr.fillColor, R.attr.leftBottomRound, R.attr.leftTopRound, R.attr.rightBottomRound, R.attr.rightTopRound, R.attr.round, R.attr.roundCorner});
        this.f56953c = r113.getDimensionPixelSize(7, 0);
        int r101 = r113.getDimensionPixelSize(3, -1);
        int r102 = r113.getDimensionPixelSize(5, -1);
        int r103 = r113.getDimensionPixelSize(2, -1);
        int r104 = r113.getDimensionPixelSize(4, -1);
        if (r101 != (-1)) goto L5;
        float r114 = this.f56953c;
    L6:
        r100[0] = r114;
        if (r101 != (-1)) goto L9;
        float r115 = this.f56953c;
    L10:
        r100[1] = r115;
        if (r102 != (-1)) goto L13;
        float r116 = this.f56953c;
    L14:
        r100[2] = r116;
        if (r102 != (-1)) goto L17;
        float r117 = this.f56953c;
    L18:
        r100[3] = r117;
        if (r103 != (-1)) goto L21;
        float r118 = this.f56953c;
    L22:
        r100[4] = r118;
        if (r103 != (-1)) goto L25;
        float r119 = this.f56953c;
    L26:
        r100[5] = r119;
        if (r104 != (-1)) goto L29;
        float r120 = this.f56953c;
    L30:
        r100[6] = r120;
        if (r104 != (-1)) goto L33;
        float r121 = this.f56953c;
    L34:
        r100[7] = r121;
        r113.recycle();
        this.f56951a = new RectF();
        return;
    L33:
        r121 = r104;
        goto L34
    L29:
        r120 = r104;
        goto L30
    L25:
        r119 = r103;
        goto L26
    L21:
        r118 = r103;
        goto L22
    L17:
        r117 = r102;
        goto L18
    L13:
        r116 = r102;
        goto L14
    L9:
        r115 = r101;
        goto L10
    L5:
        r114 = r101;
        goto L6
    }

    public final void a(float r100, float r101, float r102, float r103) {
        float[] r104 = this.f56952b;
        if (r104 == null) goto L6;
        r104[0] = r100;
        r104[1] = r100;
        r104[2] = r101;
        r104[3] = r101;
        r104[4] = r102;
        r104[5] = r102;
        r104[6] = r103;
        r104[7] = r103;
        invalidate();
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f56951a.left = getPaddingLeft();
        this.f56951a.top = getPaddingTop();
        this.f56951a.right = r100 - getPaddingRight();
        this.f56951a.bottom = r101 - getPaddingBottom();
    }
}
