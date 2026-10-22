package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import android.view.View;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public interface a {
    void c(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r100);

    boolean d();

    void e(View r100, Function1<? super Boolean, Unit> r101);

    void g(KtvRoomChallengeProgressView r100, View r101, View r102, Function1<? super Boolean, Unit> r103);

    void h(UserAttr r100);

    void onDestroy();
}
