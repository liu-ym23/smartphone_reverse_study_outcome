package com.bytedance.android.live.profit.lottery.model;

import com.bytedance.android.livesdk.revenue.message.k;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class d extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f88145e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k.b f88146d;

    static {
        f88145e = new KProperty[]{Reflection.property1(new PropertyReference1Impl(d.class, "lotteryInfoSyncData", "getLotteryInfoSyncData()Lcom/bytedance/android/livesdk/revenue/message/IRevWrdsSettingItem;", 0))};
    }

    public d() {
        k.b<?> r100 = new k.b(this, LotteryInfoSyncData.class);
        this.f157188b.put("LotteryInfoSyncData", r100);
        this.f88146d = r100;
    }
}
