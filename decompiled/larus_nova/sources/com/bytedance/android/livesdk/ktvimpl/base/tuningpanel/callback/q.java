package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListAdapter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class q<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KSongViceSingerTuningButtonOuterCallback f143511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ bc0.c f143512b;

    public q(KSongViceSingerTuningButtonOuterCallback r100, TuningButtonListAdapter r101) {
        this.f143511a = r100;
        this.f143512b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        final Boolean r101 = (Boolean) r100;
        this.f143512b.m2(new KSongViceSingerTuningButtonOuterCallback$addSwitchObserver$3$1(this, r101), TuningButtonType.ECHO_ITEM, false);
    }
}
