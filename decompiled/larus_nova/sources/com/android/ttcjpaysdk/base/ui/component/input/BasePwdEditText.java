package com.android.ttcjpaysdk.base.ui.component.input;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes28.dex */
public class BasePwdEditText extends AppCompatTextView {
    protected OnTextInputListener onTextInputListener;

    public interface OnTextInputListener {
        void onComplete(String r100);
    }

    public BasePwdEditText(Context r100) {
        this(r100, null);
    }

    public void setOnTextInputListener(OnTextInputListener r100) {
        this.onTextInputListener = r100;
    }

    public BasePwdEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public BasePwdEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
