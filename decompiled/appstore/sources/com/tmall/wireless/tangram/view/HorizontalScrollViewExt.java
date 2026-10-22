package com.tmall.wireless.tangram.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* JADX INFO: loaded from: classes4.dex */
public class HorizontalScrollViewExt extends HorizontalScrollView {
    private OnScrollChangedListenerExt listener;

    public interface OnScrollChangedListenerExt {
        void onScrollChangedExt(int r10, int r11, int r12, int r13);
    }

    public HorizontalScrollViewExt(Context r10) {
        super(r10);
    }

    @Override // android.view.View
    public void onScrollChanged(int r10, int r11, int r12, int r13) {
        super.onScrollChanged(r10, r11, r12, r13);
        OnScrollChangedListenerExt r14 = this.listener;
        if (r14 == null) goto L6;
        r14.onScrollChangedExt(r10, r11, r12, r13);
        return;
    }

    public void setOnScrollChangedListenerExt(OnScrollChangedListenerExt r10) {
        this.listener = r10;
    }

    public HorizontalScrollViewExt(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public HorizontalScrollViewExt(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
