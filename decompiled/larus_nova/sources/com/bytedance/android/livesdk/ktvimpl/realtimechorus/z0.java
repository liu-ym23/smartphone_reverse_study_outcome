package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class z0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RealTimeChorusOperateView f146981a;

    public z0(RealTimeChorusOperateView r100) {
        this.f146981a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        RealTimeChorusOperateView r102 = this.f146981a;
        int r103 = RealTimeChorusOperateView.f146392r;
        r102.b6();
    }
}
