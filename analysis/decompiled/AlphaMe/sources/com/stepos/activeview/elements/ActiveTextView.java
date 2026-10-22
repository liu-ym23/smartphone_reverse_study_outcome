package com.stepos.activeview.elements;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ActiveTextView extends TextView {
    private boolean mEnabled;

    public ActiveTextView(Context context) {
        super(context);
        this.mEnabled = true;
    }

    private String autoSplitText(TextView textView) {
        String string = textView.getText().toString();
        TextPaint paint = textView.getPaint();
        float measuredWidth = (textView.getMeasuredWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
        String[] strArrSplit = string.replaceAll("\r", "").split("\n");
        StringBuilder sb = new StringBuilder();
        for (String str : strArrSplit) {
            if (paint.measureText(str) <= measuredWidth || textView.getMaxLines() == 1) {
                sb.append(str);
            } else {
                int i4 = 0;
                float f4 = 0.0f;
                while (i4 != str.length()) {
                    char cCharAt = str.charAt(i4);
                    float fMeasureText = paint.measureText(String.valueOf(cCharAt)) + f4;
                    if (fMeasureText <= measuredWidth) {
                        sb.append(cCharAt);
                        f4 = fMeasureText;
                    } else {
                        sb.append("\n");
                        i4--;
                        f4 = 0.0f;
                    }
                    i4++;
                }
            }
            sb.append("\n");
        }
        if (!string.endsWith("\n")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (getMeasuredWidth() <= 0 || !this.mEnabled) {
            return;
        }
        String strAutoSplitText = autoSplitText(this);
        if (TextUtils.isEmpty(strAutoSplitText)) {
            return;
        }
        setText(strAutoSplitText);
    }

    public void setAutoSplitEnabled(boolean z4) {
        this.mEnabled = z4;
    }

    public ActiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEnabled = true;
    }

    public ActiveTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mEnabled = true;
    }
}
