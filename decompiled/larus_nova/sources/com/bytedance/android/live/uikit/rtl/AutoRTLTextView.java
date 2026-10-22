package com.bytedance.android.live.uikit.rtl;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes7.dex */
public class AutoRTLTextView extends AppCompatTextView {
    public AutoRTLTextView(Context r100) {
        this(r100, null);
    }

    private void init(Context r100) {
        Drawable r101 = getBackground();
        Drawable[] r102 = getCompoundDrawables();
        Drawable[] r103 = getCompoundDrawablesRelative();
        if (r101 == null) goto L5;
        r101.setAutoMirrored(true);
    L5:
        int r104 = r102.length;
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r106 >= r104) goto L12;
        Drawable r107 = r102[r106];
        if (r107 == null) goto L11;
        r107.setAutoMirrored(true);
    L11:
        r106 = r106 + 1;
        goto L6
    L12:
        int r108 = r103.length;
    L13:
        if (r105 >= r108) goto L19;
        Drawable r109 = r103[r105];
        if (r109 == null) goto L18;
        r109.setAutoMirrored(true);
    L18:
        r105 = r105 + 1;
        goto L13
    }

    public AutoRTLTextView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.textViewStyle);
    }

    public AutoRTLTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init(r100);
    }
}
