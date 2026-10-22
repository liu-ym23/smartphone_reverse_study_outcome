package com.bytedance.android.live.revlink.impl.mergepk.pkbase;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.f1;
import com.bytedance.android.livesdk.link.model.y4;

/* JADX INFO: loaded from: classes47.dex */
public interface d {
    void onBizFinishCallback(PkBaseStateMachine.Source r100, f1 r101, Throwable r102);

    void onBizFinished(boolean r100, PkBaseStateMachine.c r101, PkBaseStateMachine.c r102, boolean r103);

    void onBizPK(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r100, PkBaseStateMachine.c r101, PkBaseStateMachine.c r102, PkBaseStateMachine.Source r103, boolean r104, PlayMode r105);

    void onBizPenal(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r100, PkBaseStateMachine.Source r101, PkBaseStateMachine.c r102);

    void onBizReceiveBattleEndPunishMsg(y4 r100);

    void onBizReceiveBattleFinishMsg(a5 r100);

    void onBizReceiveBattleMsg(c5 r100);
}
