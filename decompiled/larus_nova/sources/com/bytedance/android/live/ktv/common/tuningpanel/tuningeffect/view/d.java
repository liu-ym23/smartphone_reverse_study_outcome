package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningEffectListView f70544a;

    public d(TuningEffectListView r100) {
        this.f70544a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f70544a.f70532b.b0();
    }
}
