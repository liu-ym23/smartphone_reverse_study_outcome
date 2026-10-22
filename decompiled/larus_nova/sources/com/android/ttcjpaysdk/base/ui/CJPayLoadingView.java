package com.android.ttcjpaysdk.base.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayLoadingView extends FrameLayout {
    private boolean isShow;
    private View mLoadingOuterLayout;

    public void hide() {
        this.isShow = false;
        View r100 = this.mLoadingOuterLayout;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    public void show() {
        this.isShow = true;
        View r100 = this.mLoadingOuterLayout;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
        return;
    }

    public CJPayLoadingView(Context r100) {
        this(r100, null);
    }

    private void init(Context r100) {
        View r101 = LayoutInflater.from(r100).inflate(R.layout.cj_pay_view_loading_layout, this).findViewById(R.id.cj_pay_loading_root_layout);
        this.mLoadingOuterLayout = r101;
        r101.setVisibility(8);
        this.mLoadingOuterLayout.setOnClickListener(new AnonymousClass1(this));
    }

    public CJPayLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CJPayLoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init(r100);
    }
}
