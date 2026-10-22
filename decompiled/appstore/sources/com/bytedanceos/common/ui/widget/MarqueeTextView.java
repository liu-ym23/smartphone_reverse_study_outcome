package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class MarqueeTextView extends TextView {
    public MarqueeTextView(Context r10) {
        super(r10);
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    public MarqueeTextView(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public MarqueeTextView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
