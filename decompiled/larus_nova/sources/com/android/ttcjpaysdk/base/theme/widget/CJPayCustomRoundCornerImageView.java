package com.android.ttcjpaysdk.base.theme.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.ttcjpaysdk.base.ktextension.CJPayColorHelper;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.theme.utils.BitmapUtil;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayCustomRoundCornerImageView extends AppCompatImageView {
    private int mBackgroundColor;
    private BitmapShader mBitmapShader;
    private int mBorderRadius;
    private Matrix mMatrix;
    private Paint mPaint;

    public CJPayCustomRoundCornerImageView(Context r100) {
        super(r100);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mBorderRadius = CJPayBasicUtils.dipToPX(getContext(), 4.0f);
        initView(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        if (getDrawable() != null) goto L5;
        return;
    L5:
        if (getWidth() != 0) goto L7;
        return;
    L7:
        if (getHeight() == 0) goto L18;
        Bitmap r101 = BitmapUtil.drawableToBitmap(getDrawable(), getWidth(), getHeight());
        Shader.TileMode r102 = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(r101, r102, r102);
        float r103 = 1.0f;
        if (r101.getWidth() == getWidth()) goto L12;
    L13:
        r103 = Math.max((getWidth() * 1.0f) / r101.getWidth(), (getHeight() * 1.0f) / r101.getHeight());
    L14:
        this.mMatrix.setScale(r103, r103);
        this.mBitmapShader.setLocalMatrix(this.mMatrix);
        this.mPaint.setShader(this.mBitmapShader);
        RectF r104 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        int r105 = this.mBorderRadius;
        r100.drawRoundRect(r104, r105, r105, this.mPaint);
        return;
    L12:
        if (r101.getHeight() == getHeight()) goto L14;
    }

    public CJPayCustomRoundCornerImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mBorderRadius = CJPayBasicUtils.dipToPX(getContext(), 4.0f);
        initView(r100, r101);
    }

    private void initView(Context r100, AttributeSet r101) {
        if (r101 == null) goto L13;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayCornerRadius});
        if (r102 == null) goto L6;
        this.mBorderRadius = (int) r102.getDimension(0, CJPayBasicUtils.dipToPX(getContext(), 4.0f));
        r102.recycle();
    L6:
        this.mMatrix = new Matrix();
        Paint r103 = new Paint();
        this.mPaint = r103;
        r103.setAntiAlias(true);
    L13:
        this.mBackgroundColor = Color.parseColor(CJPayThemeManager.getInstance().getThemeInfo().checkBoxInfo.bgColor);     // Catch: Exception -> L9
    L11:
        setImageDrawable(new ColorDrawable(this.mBackgroundColor));
        return;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCustomRoundCornerImageView#initView", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCustomRoundCornerImageView#initView", e);
        goto L11
    }

    public CJPayCustomRoundCornerImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mBorderRadius = CJPayBasicUtils.dipToPX(getContext(), 4.0f);
        initView(r100, r101);
    }
}
