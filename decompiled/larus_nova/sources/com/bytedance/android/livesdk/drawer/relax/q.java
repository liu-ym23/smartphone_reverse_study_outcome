package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f122731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<? extends ArrayList<FeedItem>> f122732b;

    public q(Function0<Boolean> r100, Function0<? extends ArrayList<FeedItem>> r101) {
        Intrinsics.checkNotNullParameter(r100, "enableLiveHistory");
        Intrinsics.checkNotNullParameter(r101, "historyList");
        this.f122731a = r100;
        this.f122732b = r101;
    }
}
