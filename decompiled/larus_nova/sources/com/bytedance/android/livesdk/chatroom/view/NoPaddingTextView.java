package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes8.dex */
public class NoPaddingTextView extends AppCompatTextView {
    public NoPaddingTextView(Context r100) {
        this(r100, null, 0);
    }

    public NoPaddingTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public NoPaddingTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        Paint r103 = new Paint();
        r103.setTextSize(getTextSize());
        Paint.FontMetricsInt r104 = r103.getFontMetricsInt();
        setPadding(0, -Math.abs(r104.top - r104.ascent), 0, r104.top - r104.ascent);
    }
}
