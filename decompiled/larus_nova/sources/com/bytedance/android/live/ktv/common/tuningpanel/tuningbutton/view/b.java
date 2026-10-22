package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningButtonListView f70501a;

    public b(TuningButtonListView r100) {
        this.f70501a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ((Boolean) r100).booleanValue();
        TuningButtonListView r101 = this.f70501a;
        int r102 = TuningButtonListView.f70484h;
        r101.u();
    }
}
