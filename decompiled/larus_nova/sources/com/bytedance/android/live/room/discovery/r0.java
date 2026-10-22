package com.bytedance.android.live.room.discovery;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class r0 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TopLeftActivityBannerWidget f99584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f99585b;

    public r0(TopLeftActivityBannerWidget r100, String r101) {
        this.f99584a = r100;
        this.f99585b = r101;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        TopLeftActivityBannerWidget r102 = this.f99584a;
        String r103 = this.f99585b;
        int r104 = TopLeftActivityBannerWidget.f99357f;
        r102.wq(r103, "live_banner_click");
        if (r101.getAction() != 0) goto L7;
        UIUtils.setViewVisibility(this.f99584a.contentView.findViewById(R.id.common_banner_hint_view), 8);
        return false;
    L7:
        return false;
    }
}
