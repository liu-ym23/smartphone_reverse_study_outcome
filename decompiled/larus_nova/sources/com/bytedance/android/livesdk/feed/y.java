package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.live.HorFollowLiveFeedViewHolder;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y implements b90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f124601a = null;

    static {
        f124601a = new y();
    }

    public y() {
    }

    @Override // b90.a
    public final BaseViewHolder<Object> a(ViewGroup r100, Object[] r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "payloads");
        if (r101.length != 0) goto L5;
        boolean r102 = true;
    L7:
        if ((!r102) == false) goto L14;
        Object r103 = r101[0];
        if ((r103 instanceof mv1.l) == false) goto L14;
        if (r103 == null) goto L13;
        BannerSwipeRefreshLayout.a r104 = ((mv1.l) r103).b();
    L15:
        View r105 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_follow_feed, r100, false);
        Integer r106 = LiveFeedSettings.DOUYIN_LIVE_FEED_TOP_HINT.getValue();
        if (r106 == null) goto L22;
        if (r106.intValue() != 0) goto L22;
        r105.findViewById(R.id.ttlive_tv_story_hint).setVisibility(8);
    L22:
        return new HorFollowLiveFeedViewHolder(r105, r104);
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.adapter.IPayloadProvider");
    L14:
        r104 = null;
        goto L15
    L5:
        r102 = false;
        goto L7
    }
}
