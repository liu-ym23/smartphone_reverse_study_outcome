package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends FeedItem> f122763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f122764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f122765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Long> f122766d;

    public z(Function0<? extends FeedItem> r100, Function0<String> r101, Function0<String> r102, Function0<Long> r103) {
        Intrinsics.checkNotNullParameter(r100, "feedItem");
        Intrinsics.checkNotNullParameter(r101, "aggregateEnterFrom");
        Intrinsics.checkNotNullParameter(r102, "aggregateEnterMethod");
        Intrinsics.checkNotNullParameter(r103, "aggregateReplaceTabId");
        this.f122763a = r100;
        this.f122764b = r101;
        this.f122765c = r102;
        this.f122766d = r103;
    }
}
