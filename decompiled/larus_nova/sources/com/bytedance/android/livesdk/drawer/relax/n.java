package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends FeedItem> f122705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0 f122706b;

    public n(Function0<? extends FeedItem> r100, l0 r101) {
        Intrinsics.checkNotNullParameter(r100, "feedItem");
        Intrinsics.checkNotNullParameter(r101, "tabItem");
        this.f122705a = r100;
        this.f122706b = r101;
    }
}
