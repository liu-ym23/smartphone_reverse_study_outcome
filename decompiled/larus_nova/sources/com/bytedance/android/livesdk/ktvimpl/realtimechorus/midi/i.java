package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RealTimeChorusMidiWidget f146826a;

    public i(RealTimeChorusMidiWidget r100) {
        this.f146826a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        g0 r101 = (g0) r100;
        RealTimeChorusMidiWidget r102 = this.f146826a;
        if (r101 != null) goto L5;
        int r103 = RealTimeChorusMidiWidget.f146766p;
        r102.getClass();
        return;
    L5:
        KtvComponentMidiView r104 = r102.f146769c;
        if (r104 == null) goto L10;
        r104.setConfig(r101);
        return;
    }
}
