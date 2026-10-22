package com.bytedance.android.live.room.discovery;

import android.view.View;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdkapi.banner.IBannerManager;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class t0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f99594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TopLeftActivityBannerWidget f99595b;

    public t0(b1 r100, TopLeftActivityBannerWidget r101) {
        this.f99594a = r100;
        this.f99595b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        IBannerManager r101 = (IBannerManager) this.f99595b.dataCenter.get("data_in_room_banner_manager", null);
        if (r101 == null) goto L5;
        r101.bannerClick(this.f99595b.context, this.f99594a);
    L5:
        TopLeftActivityBannerWidget r102 = this.f99595b;
        String r103 = String.valueOf(this.f99594a.getId());
        int r104 = TopLeftActivityBannerWidget.f99357f;
        r102.wq(r103, "live_banner_click");
        UIUtils.setViewVisibility(this.f99595b.contentView.findViewById(R.id.common_banner_hint_view), 8);
    }
}
