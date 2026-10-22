package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends FeedItem> f122577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f122578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f122579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Long> f122580d;

    public a0(Function0<? extends FeedItem> r100, Function0<String> r101, Function0<String> r102, Function0<Long> r103) {
        Intrinsics.checkNotNullParameter(r100, "feedItem");
        Intrinsics.checkNotNullParameter(r101, "aggregateEnterFrom");
        Intrinsics.checkNotNullParameter(r102, "aggregateEnterMethod");
        Intrinsics.checkNotNullParameter(r103, "aggregateReplaceTabId");
        this.f122577a = r100;
        this.f122578b = r101;
        this.f122579c = r102;
        this.f122580d = r103;
    }
}
