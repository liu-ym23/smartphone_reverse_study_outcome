package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerOperationCardViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class d0 implements b90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f123671a = null;

    static {
        f123671a = new d0();
    }

    public d0() {
    }

    @Override // b90.a
    public final BaseViewHolder<Object> a(ViewGroup r100, Object[] r101) {
        return new DrawerOperationCardViewHolder(r100, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_feed_drawer_operation_card_holder, r100, false));
    }
}
