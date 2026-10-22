package com.bytedance.android.ec.hybrid.list.play;

import android.os.CountDownTimer;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsECHybridAutoPlay f47236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseViewHolder f47237b;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        this.f47236a.p();
        this.f47237b.D();
        this.f47237b.K();
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r100) {
        int r101 = ((int) r100) / 1000;
        this.f47236a.getClass();
    }

    public a(AbsECHybridAutoPlay r100, BaseViewHolder r101, long r102) {
        this.f47236a = r100;
        this.f47237b = r101;
        super(r102, 1000);
    }
}
