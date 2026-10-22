package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.live.LiveGapViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a0 implements b90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f123575a = null;

    static {
        f123575a = new a0();
    }

    public a0() {
    }

    @Override // b90.a
    public final BaseViewHolder<Object> a(ViewGroup r100, Object[] r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new LiveGapViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_feed_live_gap, r100, false));
    }
}
