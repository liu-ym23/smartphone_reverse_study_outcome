package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;

/* JADX INFO: loaded from: classes45.dex */
public class UnCheckRadioButton extends AppCompatRadioButton {
    @Override // android.widget.RadioButton, android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    public UnCheckRadioButton(Context r100) {
        super(r100);
    }

    public UnCheckRadioButton(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public UnCheckRadioButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
