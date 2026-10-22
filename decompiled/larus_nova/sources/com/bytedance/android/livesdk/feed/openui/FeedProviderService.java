package com.bytedance.android.livesdk.feed.openui;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.feed.openui.view.LiveOuterFollowListView;
import jc1.k;
import ry.b;
import ry.d;
import ry.f;

/* JADX INFO: loaded from: classes8.dex */
public class FeedProviderService implements d {
    public FeedProviderService() {
        k.l(d.class, this);
    }

    @Override // ry.d
    public b getFollowListView(Context r100, Bundle r101, f r102) {
        return new LiveOuterFollowListView(r100, r101, r102);
    }
}
