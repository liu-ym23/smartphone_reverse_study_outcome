package com.android.ttcjpaysdk.thirdparty.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayMaskLayout extends FrameLayout {
    Drawable maskDrawable;
    Paint maskPaint;

    public CJPayMaskLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void draw(Canvas r110) {
        if (this.maskDrawable == null) goto L13;
        int r100 = getMeasuredWidth();
        int r101 = getMeasuredHeight();
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 26) goto L7;
        r110.saveLayer(0.0f, 0.0f, r100, r101, null);
    L8:
        this.maskDrawable.setBounds(getPaddingLeft(), getPaddingTop(), r100 - getPaddingRight(), r101 - getPaddingBottom());
        this.maskDrawable.draw(r110);
        if (r102 < 26) goto L11;
        r110.saveLayer(0.0f, 0.0f, r100, r101, this.maskPaint);
    L12:
        super.draw(r110);
        r110.restore();
        r110.restore();
        return;
    L11:
        r110.saveLayer(0.0f, 0.0f, r100, r101, this.maskPaint, 31);
        goto L12
    L7:
        r110.saveLayer(0.0f, 0.0f, r100, r101, null, 31);
        goto L8
    L13:
        super.draw(r110);
    }

    public CJPayMaskLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayMaskDrawable});
        this.maskDrawable = r102.getDrawable(0);
        r102.recycle();
        Paint r103 = new Paint(1);
        this.maskPaint = r103;
        r103.setFilterBitmap(true);
        this.maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        setWillNotDraw(false);
    }
}
