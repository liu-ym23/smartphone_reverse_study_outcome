package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f {
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isTransition");
        if (Intrinsics.areEqual(((KtvRoomLyricsStateMachineConfig.d) r100.f66099a).getClass(), ((KtvRoomLyricsStateMachineConfig.d) r100.f66101c).getClass()) == true) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(((KtvRoomLyricsStateMachineConfig.d) r100.f66099a).getClass().getClassLoader(), ((KtvRoomLyricsStateMachineConfig.d) r100.f66101c).getClass().getClassLoader()) == false) goto L8;
        return false;
    }
}
