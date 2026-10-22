package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends ArrayList<FeedItem>> f122752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<FeedExtra> f122753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super Function1<? super ArrayList<FeedItem>, ? extends ArrayList<FeedItem>>, Unit> f122754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<? super Boolean, Unit> f122755d;

    public u(Function0<? extends ArrayList<FeedItem>> r100, Function0<FeedExtra> r101, Function1<? super Function1<? super ArrayList<FeedItem>, ? extends ArrayList<FeedItem>>, Unit> r102, Function1<? super Boolean, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "historyList");
        Intrinsics.checkNotNullParameter(r101, "historyExtraData");
        Intrinsics.checkNotNullParameter(r102, "setHistoryList");
        Intrinsics.checkNotNullParameter(r103, "fetchHistory");
        this.f122752a = r100;
        this.f122753b = r101;
        this.f122754c = r102;
        this.f122755d = r103;
    }
}
