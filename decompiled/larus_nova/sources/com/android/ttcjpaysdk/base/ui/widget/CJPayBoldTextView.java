package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayBoldTextView extends TextView {
    private void init() {
        if (getTypeface() != null) goto L5;
        return;
    L5:
        if (getTypeface().isBold() == false) goto L9;
        setTypeface(Typeface.DEFAULT);
        CJPayFakeBoldUtils.fakeBold(this);
        return;
    }

    public CJPayBoldTextView(Context r100) {
        this(r100, null);
    }

    public CJPayBoldTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CJPayBoldTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init();
    }
}
