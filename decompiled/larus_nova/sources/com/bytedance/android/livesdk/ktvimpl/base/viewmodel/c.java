package com.bytedance.android.livesdk.ktvimpl.base.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public interface c {
    void clearData();

    KtvRoomLyricsStateMachineConfig.d getCurState();

    KtvRoomLyricsStateMachineConfig.d getState();

    boolean inOnSing();

    boolean isPaused();

    void observeState(LifecycleOwner r100, Observer<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r101, boolean r102);

    void observerOnLyricsChange(LifecycleOwner r100, Function1<? super ub0.a, Unit> r101);

    void observerOnProgress(LifecycleOwner r100, Function1<? super Long, Unit> r101);

    long obtainCurMusicProgress();

    void registerKtvCoreListener(ArrayList<String> r100, e r101, boolean r102);

    void sendEvent(KtvRoomLyricsStateMachineConfig.a r100, String r101);

    void unregisterKtvCoreListener(e r100);
}
