package com.bytedance.android.livesdk.drawer.relax;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FeedItem f122738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<FeedExtra> f122739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<? super String, ? super Boolean, ? super String, Unit> f122740c;

    public s(FeedItem r100, Function0<FeedExtra> r101, Function3<? super String, ? super Boolean, ? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "historyExtraData");
        Intrinsics.checkNotNullParameter(r102, "deleteHistory");
        this.f122738a = r100;
        this.f122739b = r101;
        this.f122740c = r102;
    }
}
