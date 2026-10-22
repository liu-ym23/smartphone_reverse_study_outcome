package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public class DouyinLoadingLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f153130a;

    public DouyinLoadingLayout(Context r100) {
        super(r100);
        if (r100 == null) goto L7;
        this.f153130a = LayoutInflater.from(r100).inflate(R.layout.ec_layout_douyin_loading_view, this, true).findViewById(R.id.double_loading_view);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        View r101 = this.f153130a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisibility(r100);
    }

    public DouyinLoadingLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        if (r100 == null) goto L7;
        this.f153130a = LayoutInflater.from(r100).inflate(R.layout.ec_layout_douyin_loading_view, this, true).findViewById(R.id.double_loading_view);
        return;
    }
}
