package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.view.View;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import kotlin.Pair;

/* JADX INFO: loaded from: classes10.dex */
public interface b extends com.bytedance.android.live.ktv.common.util.c {
    void A1();

    void F9(com.bytedance.android.live.ktv.common.midi.k r100, Long r101, boolean r102);

    void Gk(db0.a r100, com.bytedance.android.live.ktv.common.midi.g r101);

    void R2(long r100);

    View asView();

    void onDetach();

    void qc(com.bytedance.android.live.ktv.common.midi.f r100);

    void reset();

    void setConfig(g0 r100);

    void setContainerVisibility(int r100);

    void setPerformStrategy(com.bytedance.android.live.ktv.common.midi.g r100);

    void xc(Pair<Integer, Integer> r100);

    void y(MidiSkinDressInfo r100);
}
