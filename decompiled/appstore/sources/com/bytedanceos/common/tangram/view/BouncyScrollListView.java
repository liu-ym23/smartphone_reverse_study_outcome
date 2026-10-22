package com.bytedanceos.common.tangram.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class BouncyScrollListView extends HorizontalScrollView {
    private IReportListener mIReportListener;
    private RecyclerView mListView;

    public interface IReportListener {
        void reportExpose();
    }

    public BouncyScrollListView(Context r10) {
        this(r10, null);
    }

    public RecyclerView getListView() {
        return this.mListView;
    }

    public final void init() {
        this.mListView = new BouncyListView(getContext());
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2);
        addView(this.mListView, r10);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (r10.getAction() != 1) goto L9;
        IReportListener r11 = this.mIReportListener;
        if (r11 == null) goto L9;
        r11.reportExpose();
    L9:
        return super.onTouchEvent(r10);
    }

    public void setIReportListener(IReportListener r10) {
        this.mIReportListener = r10;
    }

    public BouncyScrollListView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public BouncyScrollListView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        init();
    }
}
