package com.bytedance.android.live.recharge.balance;

import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends BDNetworkTagContextProviderAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f89650a;

    @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public final int triggerType() {
        return !Intrinsics.areEqual("enter_room", this.f89650a.f89658b) ? 1 : 0;
    }

    public a(f r100) {
        this.f89650a = r100;
    }
}
