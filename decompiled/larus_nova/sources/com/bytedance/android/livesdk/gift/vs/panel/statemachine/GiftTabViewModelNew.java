package com.bytedance.android.livesdk.gift.vs.panel.statemachine;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftTabViewModelNew extends com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateMachine<GiftStateMachineConfig.h, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> f132394e;

    public static final class a {
    }

    static {
    }

    public GiftTabViewModelNew(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        super(r100);
        int r101 = GiftStateMachineConfig.f126971a;
        this.f132394e = GiftStateMachineConfig.c(new GiftTabViewModelNew$tabStateMachine$1(this));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void d(GiftStateMachineConfig.Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StateMachine<GiftStateMachineConfig.h, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r101 = this.f132394e;
        StateMachine.a r102 = StateMachine.f66079c;
        r101.d(r100, null);
    }
}
