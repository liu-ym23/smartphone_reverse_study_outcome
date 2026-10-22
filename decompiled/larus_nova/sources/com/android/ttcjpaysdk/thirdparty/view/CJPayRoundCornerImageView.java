package com.android.ttcjpaysdk.thirdparty.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.ttcjpaysdk.base.theme.utils.BitmapUtil;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayRoundCornerImageView extends AppCompatImageView {
    private BitmapShader mBitmapShader;
    private int mBorderRadius;
    private Matrix mMatrix;
    private Paint mPaint;

    public CJPayRoundCornerImageView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        if (getDrawable() != null) goto L5;
        return;
    L5:
        if (getWidth() != 0) goto L7;
        return;
    L7:
        if (getHeight() == 0) goto L21;
        Bitmap r101 = BitmapUtil.drawableToBitmap(getDrawable(), getWidth(), getHeight());
        if (r101 != null) goto L12;
        return;
    L12:
        Shader.TileMode r102 = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(r101, r102, r102);
        float r103 = 1.0f;
        if (r101.getWidth() == getWidth()) goto L15;
    L16:
        r103 = Math.max((getWidth() * 1.0f) / r101.getWidth(), (getHeight() * 1.0f) / r101.getHeight());
    L17:
        this.mMatrix.setScale(r103, r103);
        this.mBitmapShader.setLocalMatrix(this.mMatrix);
        this.mPaint.setShader(this.mBitmapShader);
        RectF r104 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        int r105 = this.mBorderRadius;
        r100.drawRoundRect(r104, r105, r105, this.mPaint);
        return;
    L15:
        if (r101.getHeight() == getHeight()) goto L17;
    }

    public CJPayRoundCornerImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CJPayRoundCornerImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mBorderRadius = CJPayBasicUtils.dipToPX(getContext(), 4.0f);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayRoundCornerImageCornerRadius});
        if (r103 == null) goto L5;
        this.mBorderRadius = (int) r103.getDimension(0, CJPayBasicUtils.dipToPX(getContext(), 4.0f));
        r103.recycle();
    L5:
        this.mMatrix = new Matrix();
        Paint r104 = new Paint();
        this.mPaint = r104;
        r104.setAntiAlias(true);
    }
}
