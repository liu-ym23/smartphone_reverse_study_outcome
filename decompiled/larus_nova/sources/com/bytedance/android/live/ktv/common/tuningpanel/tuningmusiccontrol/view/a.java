package com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes45.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningMusicControlContainer f70560a;

    public a(TuningMusicControlContainer r100) {
        this.f70560a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        TuningMusicControlContainer r102 = this.f70560a;
        int r103 = TuningMusicControlContainer.f70546n;
        r102.S5();
    }
}
