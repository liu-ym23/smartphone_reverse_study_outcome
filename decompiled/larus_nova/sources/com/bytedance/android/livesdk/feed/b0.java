package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.live.LiveRankViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b0 implements b90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f123619a = null;

    static {
        f123619a = new b0();
    }

    public b0() {
    }

    @Override // b90.a
    public final BaseViewHolder<Object> a(ViewGroup r100, Object[] r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new LiveRankViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_feed_live_rank, r100, false));
    }
}
