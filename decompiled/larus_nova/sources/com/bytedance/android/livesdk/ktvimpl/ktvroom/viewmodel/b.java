package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class b implements e {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public void b(KtvRoomLyricsStateMachineConfig.b r100) {
        Intrinsics.checkNotNullParameter(r100, "sideEffect");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public boolean c() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public void d(KtvRoomLyricsStateMachineConfig.d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "curstate");
        Intrinsics.checkNotNullParameter(r101, "ktvCoreDataModel");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public void e(long r100) {
    }
}
