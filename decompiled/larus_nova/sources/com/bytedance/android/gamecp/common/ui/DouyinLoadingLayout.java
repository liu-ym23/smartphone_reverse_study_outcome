package com.bytedance.android.gamecp.common.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public class DouyinLoadingLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DouyinBallLoadingAnimationView f56900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f56901b;

    public DouyinLoadingLayout(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        View r101 = LayoutInflater.from(r100).inflate(R.layout.gamecp_layout_douyin_loading_view, this, true);
        this.f56900a = (DouyinBallLoadingAnimationView) r101.findViewById(R.id.double_loading_view);
        this.f56901b = (TextView) r101.findViewById(R.id.double_loading_text);
    }

    public void setLoadingText(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.f56901b.setVisibility(8);
        return;
    L5:
        this.f56901b.setVisibility(0);
        this.f56901b.setText(r100);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        DouyinBallLoadingAnimationView r101 = this.f56900a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisibility(r100);
    }

    public void setLoadingText(int r100) {
        setLoadingText(y0.i(r100));
    }

    public DouyinLoadingLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }
}
