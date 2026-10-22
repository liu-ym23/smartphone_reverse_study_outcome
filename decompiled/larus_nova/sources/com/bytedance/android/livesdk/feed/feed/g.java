package com.bytedance.android.livesdk.feed.feed;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.user.IUser;
import com.larus.nova.R;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements Item {
    public g() {
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final IUser author() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final ImageModel cover() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final List<Object> getDislikeReason() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final long getId() {
        return R.id.ttlive_core_live_rank;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final String getVideoUrl() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final String subtitle() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final String title() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final String getMixId() {
        return String.valueOf(R.id.ttlive_core_live_rank);
    }
}
