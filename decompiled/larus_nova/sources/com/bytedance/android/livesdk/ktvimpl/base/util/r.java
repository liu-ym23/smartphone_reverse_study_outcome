package com.bytedance.android.livesdk.ktvimpl.base.util;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f143576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f143577b;

    public r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "currentUid");
        this.f143577b = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(StateMachine.c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
        KtvRoomLyricsStateMachineConfig.d r101 = (KtvRoomLyricsStateMachineConfig.d) r100.f66101c;
        if ((r101 instanceof KtvRoomLyricsStateMachineConfig.d.c) == true) goto L6;
        return;
    L6:
        if ((r101 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L14;
        KtvRoomLyricsStateMachineConfig.d r102 = (KtvRoomLyricsStateMachineConfig.d) r100.f66099a;
        if ((r100.f66100b instanceof KtvRoomLyricsStateMachineConfig.a.i) == true) goto L10;
    L12:
        pd2.d.M(pd2.d.f528658n, ((KtvRoomLyricsStateMachineConfig.d.c) r101).f145409b, "prepare");
        return;
    L10:
        if ((r102 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L12;
        pd2.d.M(pd2.d.f528658n, ((KtvRoomLyricsStateMachineConfig.d.e) r102).f145409b, "sing_cut");
        goto L12
    L14:
        if ((r101 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L18;
        pd2.d.M(pd2.d.f528658n, ((KtvRoomLyricsStateMachineConfig.d.c) r101).f145409b, "start_sing");
        return;
    }
}
