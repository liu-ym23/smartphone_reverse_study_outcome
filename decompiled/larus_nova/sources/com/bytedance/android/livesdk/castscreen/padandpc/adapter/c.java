package com.bytedance.android.livesdk.castscreen.padandpc.adapter;

import com.airbnb.lottie.LottieAnimationView;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadAndPcDeviceListAdapter.PcDeviceHolder f104672a;

    public c(PadAndPcDeviceListAdapter.PcDeviceHolder r100) {
        this.f104672a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        LottieAnimationView r100 = this.f104672a.f104663c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isAnimating() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        r100.cancelAnimation();
        return;
    }
}
