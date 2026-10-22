package com.stepos.common.widget;

import O6.s;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.stepos.common.R$attr;
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;

/* loaded from: classes3.dex */
public class h {
    private static final int MAX_COUNT = 999;
    public static final int SHOW_DOT = 0;
    public static final int SHOW_NUMBER = 1;
    private Paint mBgPaint;
    private int mBorderColor;
    private int mBorderWidth;
    private Rect mBounds;
    private Context mContext;
    private int mDrawableHeight;
    private int mDrawableWidth;
    private int mHeight;
    private int mHideNumRadius;
    private int mNewMessageColor;
    private RectF mRectF;
    private int mSpace;
    private int mTextColor;
    private String mTextContent;
    private TextPaint mTextPaint;
    private float mTextSize;
    private int mViewMaxHeight;
    private int mViewMaxWidth;
    private int mWidth;
    private boolean mShowBorder = false;
    private int mCurrentStage = 0;

    public h(Context context) {
        this.mContext = context;
        j(context);
    }

    public void a(Canvas canvas) {
        if (this.mShowBorder && this.mBorderWidth > 0) {
            this.mBgPaint.setColor(this.mBorderColor);
            if (this.mCurrentStage == 1) {
                float f10 = this.mWidth;
                int i10 = this.mHeight;
                float f11 = i10;
                float f12 = i10 >> 1;
                w(0.0f, 0.0f, f10, f11);
                canvas.drawRoundRect(this.mRectF, f12, f12, this.mBgPaint);
            } else {
                canvas.drawCircle(this.mWidth / 2, this.mHeight / 2, this.mHideNumRadius + this.mBorderWidth, this.mBgPaint);
            }
        }
        this.mBgPaint.setColor(this.mNewMessageColor);
        if (this.mCurrentStage != 1) {
            canvas.drawCircle(this.mWidth / 2, this.mHeight / 2, this.mHideNumRadius, this.mBgPaint);
            return;
        }
        int i11 = this.mBorderWidth;
        w(i11, i11, this.mWidth - i11, this.mHeight - i11);
        float f13 = this.mDrawableHeight >> 1;
        canvas.drawRoundRect(this.mRectF, f13, f13, this.mBgPaint);
        String str = this.mTextContent;
        if (str != null) {
            if (this.mShowBorder) {
                canvas.drawText(str, this.mWidth / 2, ((this.mHeight - this.mBorderWidth) - ((this.mDrawableHeight - this.mBounds.height()) / 2)) - 1, this.mTextPaint);
            } else {
                canvas.drawText(str, this.mWidth / 2, (this.mHeight - ((this.mDrawableHeight - this.mBounds.height()) / 2)) - 1, this.mTextPaint);
            }
        }
    }

    public int b() {
        return this.mBorderWidth;
    }

    public int c() {
        return this.mHeight;
    }

    public Integer d() {
        String str = this.mTextContent;
        if (str == null) {
            return 0;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public int e() {
        return this.mCurrentStage;
    }

    public String f() {
        return this.mTextContent;
    }

    public int g() {
        return this.mViewMaxHeight;
    }

    public int h() {
        return this.mViewMaxWidth;
    }

    public int i() {
        return this.mWidth;
    }

    public final void j(Context context) {
        this.mViewMaxWidth = (int) context.getResources().getDimension(R$dimen.mc_new_message_view_layout_max_width);
        this.mViewMaxHeight = (int) context.getResources().getDimension(R$dimen.mc_new_message_view_layout_max_height);
        k(context);
        n();
        m();
        l();
    }

    public final void k(Context context) {
        Resources resources = context.getResources();
        Resources resources2 = context.getResources();
        int i10 = R$color.fd_sys_color_on_error_default;
        this.mTextColor = resources2.getColor(i10);
        this.mTextSize = 10.0f;
        this.mHideNumRadius = resources.getDimensionPixelSize(R$dimen.fd_sys_radius_corner_smooth_extra_mini);
        int iC = s.c(R$attr.colorError, context);
        if (iC == 0) {
            iC = R$color.fd_sys_color_error_default;
        }
        this.mNewMessageColor = context.getResources().getColor(iC);
        this.mBorderColor = context.getResources().getColor(i10);
        this.mBorderWidth = resources.getDimensionPixelSize(R$dimen.mc_new_message_view_border_width);
        this.mSpace = resources.getDimensionPixelSize(R$dimen.mc_new_message_view_space_large);
    }

    public final void l() {
        this.mRectF = new RectF();
    }

    public final void m() {
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTypeface(Typeface.create("SFPRO-bold", 0));
        this.mBounds = new Rect();
    }

    public final void n() {
        Paint paint = new Paint();
        this.mBgPaint = paint;
        paint.setAntiAlias(true);
        this.mBgPaint.setColor(this.mNewMessageColor);
        this.mBgPaint.setStyle(Paint.Style.FILL);
    }

    public void o() {
        int iA;
        int i10;
        if (this.mCurrentStage != 1 || this.mTextContent == null) {
            iA = (this.mShowBorder ? this.mHideNumRadius + this.mBorderWidth : this.mHideNumRadius) * 2;
            i10 = iA;
        } else {
            this.mTextPaint.setTextSize(s.i(this.mTextSize, this.mContext));
            this.mTextPaint.setColor(this.mTextColor);
            TextPaint textPaint = this.mTextPaint;
            String str = this.mTextContent;
            textPaint.getTextBounds(str, 0, str.length(), this.mBounds);
            this.mDrawableWidth = this.mBounds.width() + (this.mSpace * 2);
            iA = (int) s.a(18.0f, this.mContext);
            this.mDrawableHeight = iA;
            if (this.mDrawableWidth < iA) {
                this.mDrawableWidth = iA;
            }
            if (this.mShowBorder) {
                int i11 = this.mDrawableWidth;
                int i12 = this.mBorderWidth;
                i10 = i11 + (i12 * 2);
                iA += i12 * 2;
            } else {
                i10 = this.mDrawableWidth;
            }
        }
        this.mWidth = i10;
        this.mHeight = iA;
    }

    public void p(int i10) {
        this.mBgPaint.setAlpha(i10);
        this.mTextPaint.setAlpha(i10);
    }

    public void q(int i10) {
        this.mBgPaint.setColor(i10);
    }

    public void r(int i10) {
        this.mBorderColor = i10;
    }

    public void s(int i10) {
        this.mBorderWidth = i10;
    }

    public void t(int i10) {
        this.mCurrentStage = i10;
    }

    public void u(int i10) {
        this.mCurrentStage = 1;
        if (i10 >= 999) {
            i10 = 999;
        } else if (i10 <= 0) {
            i10 = 0;
        }
        y(String.valueOf(i10));
    }

    public void v(int i10) {
        this.mSpace = i10;
    }

    public final void w(float f10, float f11, float f12, float f13) {
        RectF rectF = this.mRectF;
        rectF.left = f10;
        rectF.top = f11;
        rectF.right = f12;
        rectF.bottom = f13;
    }

    public void x(boolean z10) {
        this.mShowBorder = z10;
    }

    public void y(String str) {
        this.mTextContent = str;
    }

    public void z(float f10) {
        this.mTextSize = f10;
    }
}
