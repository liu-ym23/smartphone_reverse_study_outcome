package com.bytedance.android.live.profit.vote;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f89213a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f89214b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f89215c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_VOTE_CONFIG", "getLIVE_VOTE_CONFIG()Lcom/bytedance/android/live/profit/vote/LiveVoteConfig;", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_GIFT_CLOSE_ANCHOR_BLOCK_SWITCH", "getLIVE_GIFT_CLOSE_ANCHOR_BLOCK_SWITCH()Z", 1))};
        f89213a = r100;
        LiveVoteConfig.f89189a.getClass();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_vote_config", (LiveVoteConfig) LiveVoteConfig.Companion.f89190a.getValue(), LiveVoteConfig.class, false);
        f89214b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_close_anchor_block_switch", Boolean.TRUE, Boolean.TYPE, false);
        f89215c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
    }

    public static final LiveVoteConfig a() {
        return (LiveVoteConfig) f89214b.getValue(null, f89213a[0]);
    }
}
