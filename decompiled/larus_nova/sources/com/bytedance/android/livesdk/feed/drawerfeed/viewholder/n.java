package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;

/* JADX INFO: loaded from: classes8.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrawerFollowViewHolder f123975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FeedItem f123976b;

    public n(DrawerFollowViewHolder r100, FeedItem r101) {
        this.f123975a = r100;
        this.f123976b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DrawerFollowViewHolder r101 = this.f123975a;
        FeedItem r102 = this.f123976b;
        if (r102 == null) goto L5;
        ScheduledLiveItem r103 = r102.scheduledLive;
    L6:
        DrawerFollowViewHolder.T3(r101, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
