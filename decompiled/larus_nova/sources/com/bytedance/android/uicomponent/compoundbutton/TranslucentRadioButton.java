package com.bytedance.android.uicomponent.compoundbutton;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;

/* JADX INFO: loaded from: classes14.dex */
public class TranslucentRadioButton extends AppCompatRadioButton {
    public TranslucentRadioButton(Context r100) {
        super(r100);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        float r101 = getWidth();
        float r102 = getHeight();
        if (isEnabled() == false) goto L5;
        int r103 = 255;
    L6:
        r100.saveLayerAlpha(0.0f, 0.0f, r101, r102, r103, 31);
        super.onDraw(r100);
        r100.restore();
        return;
    L5:
        r103 = 127;
        goto L6
    }

    public TranslucentRadioButton(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public TranslucentRadioButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
