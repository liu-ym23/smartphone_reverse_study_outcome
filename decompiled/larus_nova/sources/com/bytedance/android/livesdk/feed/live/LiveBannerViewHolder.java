package com.bytedance.android.livesdk.feed.live;

import android.view.View;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.banner.BannerViewHolder;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.l;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes8.dex */
public class LiveBannerViewHolder extends BannerViewHolder {
    public LiveBannerViewHolder(View r100, BannerSwipeRefreshLayout.a r101, FeedDataKey r102, PublishSubject<Object> r103, PublishSubject<Object> r104, PublishSubject<Boolean> r105, l r106) {
        super(r100, r101, r102, r103, r104, r105, r106);
    }
}
