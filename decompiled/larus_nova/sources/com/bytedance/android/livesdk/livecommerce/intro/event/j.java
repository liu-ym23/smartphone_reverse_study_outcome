package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b f148273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f148274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f148275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveRoomParams f148276d;

    public j(LiveRoomParams r100) {
        Intrinsics.checkNotNullParameter(r100, "liveRoomParams");
        this.f148276d = r100;
        this.f148275c = EComABUtils.enableExplainCardMonitor();
    }
}
