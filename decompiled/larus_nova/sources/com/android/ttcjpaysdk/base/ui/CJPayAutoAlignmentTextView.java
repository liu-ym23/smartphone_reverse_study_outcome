package com.android.ttcjpaysdk.base.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import tb2.c;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayAutoAlignmentTextView extends AppCompatTextView {
    private int mLineY;
    private int mViewWidth;

    public CJPayAutoAlignmentTextView(Context r100) {
        super(r100);
    }

    private boolean needScale(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() != 0) goto L8;
        return false;
    L8:
        if (r100.charAt(r100.length() - 1) == '\n') goto L12;
        return true;
    L12:
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r110) {
        TextPaint r100 = getPaint();
        r100.setColor(getCurrentTextColor());
        r100.drawableState = getDrawableState();
        this.mViewWidth = getMeasuredWidth();
        String r101 = getText().toString();
        int r102 = 0;
        this.mLineY = 0;
        this.mLineY = (int) (0 + (getTextSize() - 2.0f));
        Layout r103 = getLayout();
        if (r103 != null) goto L5;
        return;
    L5:
        Paint.FontMetrics r104 = r100.getFontMetrics();
        int r105 = (int) ((((int) Math.ceil(r104.descent - r104.ascent)) * r103.getSpacingMultiplier()) + r103.getSpacingAdd());
    L7:
        if (r102 >= r103.getLineCount()) goto L16;
        int r106 = r103.getLineStart(r102);
        int r107 = r103.getLineEnd(r102);
        float r108 = StaticLayout.getDesiredWidth(r101, r106, r107, getPaint());
        String r109 = r101.substring(r106, r107);
        if (r102 < (r103.getLineCount() - 1)) goto L11;
        r110.drawText(r109, 0.0f, this.mLineY, r100);
    L15:
        this.mLineY += r105;
        r102 = r102 + 1;
        goto L7
    L11:
        if (needScale(r109) == false) goto L13;
        drawScaledText(r110, r106, r109, r108);
        goto L15
    L13:
        r110.drawText(r109, 0.0f, this.mLineY, r100);
        goto L15
    }

    public CJPayAutoAlignmentTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    private boolean isFirstLineOfParagraph(int r100, String r101) {
        if (r101.length() > 3) goto L5;
        return false;
    L5:
        if (r101.charAt(0) == ' ') goto L7;
        return false;
    L7:
        if (r101.charAt(1) != ' ') goto L12;
        return true;
    L12:
        return false;
    }

    public CJPayAutoAlignmentTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    private void drawScaledText(Canvas r100, int r101, String r102, float r110) {
        float r103 = 0.0f;
        if (isFirstLineOfParagraph(r101, r102) == false) goto L5;
        r100.drawText(c.DEFAULT_TEXT, 0.0f, this.mLineY, getPaint());
        r103 = 0.0f + StaticLayout.getDesiredWidth(c.DEFAULT_TEXT, getPaint());
        r102 = r102.substring(3);
    L5:
        int r104 = r102.length() - 1;
        int r105 = 2;
        if (r102.length() > 2) goto L8;
    L12:
        r105 = 0;
    L13:
        float r106 = (this.mViewWidth - r110) / r104;
    L15:
        if (r105 >= r102.length()) goto L17;
        String r107 = String.valueOf(r102.charAt(r105));
        float r111 = StaticLayout.getDesiredWidth(r107, getPaint());
        r100.drawText(r107, r103, this.mLineY, getPaint());
        r103 = r103 + (r111 + r106);
        r105 = r105 + 1;
        goto L15
    L17:
        return;
    L8:
        if (r102.charAt(0) != 12288) goto L12;
        if (r102.charAt(1) != 12288) goto L12;
        String r108 = r102.substring(0, 2);
        float r109 = StaticLayout.getDesiredWidth(r108, getPaint());
        r100.drawText(r108, r103, this.mLineY, getPaint());
        r103 = r103 + r109;
        goto L13
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
