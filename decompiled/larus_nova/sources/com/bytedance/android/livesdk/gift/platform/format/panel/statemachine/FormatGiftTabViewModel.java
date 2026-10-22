package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class FormatGiftTabViewModel extends com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a implements o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateMachine<GiftStateMachineConfig.h, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> f132143e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FormatGiftTabViewModel(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super((LifecycleOwner) r100);
        int r101 = GiftStateMachineConfig.f126971a;
        this.f132143e = GiftStateMachineConfig.c(new FormatGiftTabViewModel$tabStateMachine$1(this));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void d(GiftStateMachineConfig.Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StateMachine<GiftStateMachineConfig.h, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r101 = this.f132143e;
        StateMachine.a r102 = StateMachine.f66079c;
        r101.d(r100, null);
    }
}
