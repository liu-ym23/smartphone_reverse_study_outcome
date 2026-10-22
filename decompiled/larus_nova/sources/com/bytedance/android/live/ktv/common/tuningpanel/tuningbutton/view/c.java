package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningButtonListView f70502a;

    public c(TuningButtonListView r100) {
        this.f70502a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        TuningButtonListView r102 = this.f70502a;
        int r103 = TuningButtonListView.f70484h;
        r102.v();
    }
}
