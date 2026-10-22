package com.bytedance.android.live.uikit.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes7.dex */
public class AlwaysMarqueeTextView extends TextView {
    @Override // android.view.View
    public final boolean isFocused() {
        return true;
    }

    public AlwaysMarqueeTextView(Context r100) {
        super(r100);
    }

    public AlwaysMarqueeTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public AlwaysMarqueeTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
