package com.bytedance.android.live.soloktv.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListAdapter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvTuningButtonOuterCallback f101572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ bc0.c f101573b;

    public c(SoloKtvTuningButtonOuterCallback r100, TuningButtonListAdapter r101) {
        this.f101572a = r100;
        this.f101573b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        final Boolean r101 = (Boolean) r100;
        this.f101573b.m2(new SoloKtvTuningButtonOuterCallback$addSwitchObserver$3$1(this, r101), TuningButtonType.ECHO_ITEM, false);
    }
}
